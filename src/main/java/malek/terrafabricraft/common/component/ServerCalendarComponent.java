package malek.terrafabricraft.common.component;

import dev.onyxstudios.cca.api.v3.component.ComponentKey;
import dev.onyxstudios.cca.api.v3.component.ComponentRegistryV3;
import dev.onyxstudios.cca.api.v3.component.sync.AutoSyncedComponent;
import dev.onyxstudios.cca.api.v3.component.tick.ServerTickingComponent;
import dev.onyxstudios.cca.api.v3.world.WorldComponentFactoryRegistry;
import dev.onyxstudios.cca.api.v3.world.WorldComponentInitializer;
import malek.terrafabricraft.TerraFabriCraft;
import malek.terrafabricraft.common.calendar.Calendar;
import malek.terrafabricraft.common.calendar.CalendarWorldData;
import malek.terrafabricraft.common.calendar.Calendars;
import malek.terrafabricraft.common.calendar.ICalendar;
import malek.terrafabricraft.common.event.TFCEvents;
import malek.terrafabricraft.common.network.CalendarUpdatePacket;
import malek.terrafabricraft.common.util.ReentrantRunnable;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import net.minecraft.world.GameRules;

public class ServerCalendarComponent extends Calendar implements AutoSyncedComponent, ServerTickingComponent, WorldComponentInitializer {
    public static final ComponentKey<ServerCalendarComponent> CALENDAR_COMPONENT = ComponentRegistryV3.INSTANCE.getOrCreate(new Identifier(TerraFabriCraft.MODID, "calendar"), ServerCalendarComponent.class);

    public static final int SYNC_INTERVAL = 20; // Number of ticks between sync attempts. This mimics vanilla's time sync
    public static final int TIME_DESYNC_THRESHOLD = 5;

    private static final ReentrantRunnable DO_DAYLIGHT_CYCLE = new ReentrantRunnable(Calendars.SERVER::setDoDaylightCycle);

   /* public static void overrideDoDaylightCycleCallback()
    {
        final GameRulesAccessor type = (GameRulesAccessor) GameRulesAccessor.getTypes().get(GameRules.DO_DAYLIGHT_CYCLE);
        GameRulesAccessor.callRegister(GameRulesAccessor..andThen((server, t) -> DO_DAYLIGHT_CYCLE.run()));
    } */

    private int syncCounter;
    public ServerPlayerEntity packetPlayer;
    public CalendarUpdatePacket calendarPacket = new CalendarUpdatePacket(this);

    /**
     * This runs a sequence of code, but first will set the calendar and player time by an offset
     * Useful if we need to run code that technically needs to happen at a different calendar time
     * The offsets are removed once the transaction is complete
     *
     * @param transactionPlayerTimeOffset   the offset to be added to the player time
     * @param transactionCalendarTimeOffset the offset to be added to the calendar time
     */
    public void runTransaction(long transactionPlayerTimeOffset, long transactionCalendarTimeOffset, Runnable transaction)
    {
        try
        {
            playerTicks += transactionPlayerTimeOffset;
            calendarTicks += transactionCalendarTimeOffset;
            transaction.run();
        }
        finally
        {
            // Always reset after transaction complete
            playerTicks -= transactionPlayerTimeOffset;
            calendarTicks -= transactionCalendarTimeOffset;
        }
    }

    /**
     * Sets the current player time and calendar time from a calendar timestamp
     *
     * @param calendarTimeToSetTo a calendar ticks time stamp
     */
    public void setTimeFromCalendarTime(long calendarTimeToSetTo)
    {
        // Calculate the time jump
        long timeJump = calendarTimeToSetTo - calendarTicks;

        calendarTicks = calendarTimeToSetTo;
        playerTicks += timeJump;

        // Update the actual world times
        for (ServerWorld world : getServer().getWorlds())
        {
            long currentDayTime = world.getTimeOfDay();
            world.setTimeOfDay(currentDayTime + timeJump);
        }

        CALENDAR_COMPONENT.sync(packetPlayer);
    }

    /**
     * Sets the current player time and calendar time from an overworld day time timestamp, e.g. sleeping will set the time to morning.
     *
     * @param worldTimeToSetTo a world time, obtained from {}. Must be in [0, ICalendar.TICKS_IN_DAY]
     * @return the number of ticks skipped (in world time)
     */
    public long setTimeFromDayTime(long worldTimeToSetTo)
    {
        // Calculate the offset to jump to
        long worldTimeJump = (worldTimeToSetTo % ICalendar.TICKS_IN_DAY) - getCalendarDayTime();
        if (worldTimeJump < 0)
        {
            worldTimeJump += ICalendar.TICKS_IN_DAY;
        }

        calendarTicks += worldTimeJump;
        playerTicks += worldTimeJump;

        return worldTimeJump;
    }

    public void setMonthLength(int newMonthLength)
    {
        // Recalculate the new calendar time
        // Preserve the current month, time of day, and position within the month
        long baseMonths = getTotalCalendarMonths();
        long baseDayTime = calendarTicks - (getTotalCalendarDays() * ICalendar.TICKS_IN_DAY);
        // Minus one here because `getDayOfMonth` returns the player visible one (which adds one)
        float monthPercent = (float) (getCalendarDayOfMonth() - 1) / daysInMonth;
        int newDayOfMonth = (int) (monthPercent * newMonthLength);

        this.daysInMonth = newMonthLength;
        this.calendarTicks = (baseMonths * daysInMonth + newDayOfMonth) * ICalendar.TICKS_IN_DAY + baseDayTime;

        CALENDAR_COMPONENT.sync(packetPlayer);
    }

    public void setPlayersLoggedOn(boolean arePlayersLoggedOn)
    {
        GameRules rules = getServer().getOverworld().getGameRules();
        this.arePlayersLoggedOn = arePlayersLoggedOn;
        if (arePlayersLoggedOn)
        {
            DO_DAYLIGHT_CYCLE.runBlocking(() -> rules.get(GameRules.DO_DAYLIGHT_CYCLE).set(doDaylightCycle, getServer()));
        }
        else
        {
            DO_DAYLIGHT_CYCLE.runBlocking(() -> rules.get(GameRules.DO_DAYLIGHT_CYCLE).set(false, getServer()));
        }

        CALENDAR_COMPONENT.sync(packetPlayer);
    }

    public void setDoDaylightCycle()
    {
        GameRules rules = getServer().getGameRules();
        doDaylightCycle = rules.getBoolean(GameRules.DO_DAYLIGHT_CYCLE);
        if (!arePlayersLoggedOn)
        {
            DO_DAYLIGHT_CYCLE.runBlocking(() -> rules.get(GameRules.DO_DAYLIGHT_CYCLE).set(false, getServer()));
        }

        CALENDAR_COMPONENT.sync(packetPlayer);
    }

    /**
     * Initializes the calendar with the current minecraft server instance, reloading all values from world saved data
     */
    void onServerStart(MinecraftServer server)
    {
        GameRules rules = server.getOverworld().getGameRules();
        DO_DAYLIGHT_CYCLE.runBlocking(() -> rules.get(GameRules.DO_DAYLIGHT_CYCLE).set(false, server));

        reset(CalendarWorldData.get(server.getOverworld()).getCalendar());
        CALENDAR_COMPONENT.sync(packetPlayer);
    }

    /**
     * Called on server ticks, syncs to client
     */
    @Override
    public void serverTick()
    {
        if (arePlayersLoggedOn)
        {
            playerTicks++;
        }
        syncCounter++;
        if (syncCounter % SYNC_INTERVAL == 0)
        {
            CALENDAR_COMPONENT.sync(packetPlayer);
            syncCounter = 0;
        }
    }

    /**
     * Called on each overworld tick, increments and syncs calendar time
     */
    void onOverworldTick(ServerWorld world)
    {
        if (doDaylightCycle && arePlayersLoggedOn)
        {
            calendarTicks++;
        }
        long deltaWorldTime = (world.getTimeOfDay() % ICalendar.TICKS_IN_DAY) - getCalendarDayTime();
        if (deltaWorldTime > TIME_DESYNC_THRESHOLD || deltaWorldTime < -TIME_DESYNC_THRESHOLD)
        {
            // Check if tracking values are wrong
            boolean checkArePlayersLoggedOn = getServer().getCurrentPlayerCount() > 0;
            if (arePlayersLoggedOn != checkArePlayersLoggedOn)
            {
                // Whoops, somehow we missed this.
                setPlayersLoggedOn(checkArePlayersLoggedOn);
            }
            if (arePlayersLoggedOn && doDaylightCycle != getServer().getGameRules().getBoolean(GameRules.DO_DAYLIGHT_CYCLE))
            {
                // Do daylight cycle should match
                setDoDaylightCycle();
            }
            if (deltaWorldTime < 0)
            {
                // Calendar is ahead, so jump world time
                world.setTimeOfDay(world.getTimeOfDay() - deltaWorldTime);
            }
            else
            {
                // World time is ahead, so jump calendar
                calendarTicks += deltaWorldTime;
            }
            CALENDAR_COMPONENT.sync(packetPlayer);
        }
    }

    private MinecraftServer getServer()
    {
        return TFCEvents.getCurrentserver();
    }

    @Override
    public void readFromNbt(NbtCompound tag) {

    }

    @Override
    public void writeToNbt(NbtCompound tag) {

    }

    @Override
    public void registerWorldComponentFactories(WorldComponentFactoryRegistry registry) {
        registry.register(CALENDAR_COMPONENT, world -> new ServerCalendarComponent());
    }

    @Override
    public boolean shouldSyncWith(ServerPlayerEntity player) {
        packetPlayer = player;
        return true;
    }

    @Override
    public void writeSyncPacket(PacketByteBuf buf, ServerPlayerEntity recipient) {
        calendarPacket.encode(buf);
        AutoSyncedComponent.super.writeSyncPacket(buf, recipient);
    }

    @Override
    public void applySyncPacket(PacketByteBuf buf) {
        AutoSyncedComponent.super.applySyncPacket(buf);
    }

    public long getCalendarTicks(){
        return calendarTicks;
    }
}

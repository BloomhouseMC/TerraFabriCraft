package malek.terrafabricraft.common.calendar;

import malek.terrafabricraft.TerraFabriCraft;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import net.minecraft.world.PersistentState;

import java.util.List;

/**
 * The calendar is meant to count and calculate the real in-game time passed
 * since the moment the world is created taking into account the time spent sleeping.
 */
public class Calendar extends PersistentState {

    private final NbtCompound calendarData = new NbtCompound();
    private int iterator;
    private int secondsHand;
    private int minuteHand;
    private int dayCounter;
    private int weekCounter;
    private int monthCounter;
    private int yearCounter;
    private final List<ServerPlayerEntity> playerList;
    private ServerWorld serverLevel;

    public static final Identifier CALENDAR_ID = new Identifier(TerraFabriCraft.MOD_ID, "calendar");



    public Calendar(ServerWorld serverLevel) {
        this.markDirty();
        minuteHand = 1;
        playerList = serverLevel.getServer().getPlayerManager().getPlayerList();;
    }

    /**
     * Saves a compoundTag to ~/data/terrafabricraft.dat
     * @param compoundTag
     * @return
     */
    @Override
    public NbtCompound writeNbt(NbtCompound compoundTag) {
        compoundTag.putInt("minuteHand", minuteHand);
        return compoundTag;
    }

    /**
     * Sends a packet to all clients with the value of minuteHand. See {@code CalendarClient}.
     * Gets called by tick() every second
     */
    public void send() {
        calendarData.putInt("minuteHand", minuteHand);
        var buf = PacketByteBufs.create();
        buf.writeNbt(calendarData);
        for (ServerPlayerEntity serverPlayerEntity : playerList) {
            TerraFabriCraft.LOGGER.debug("Sending packet to all clients");
            ServerPlayNetworking.send(serverPlayerEntity, CALENDAR_ID, buf);
        }
    }

    /**
     * Loads a saved CompoundTag from ~/data/terrafabricraft.dat into a new calendar when you open a world.
     * @param serverLevel Used to get a PlayerList instance.
     * @param compoundTag Tag holding the calendar information saved by {@code writeNbt}.
     * @return
     */
    public static Calendar load(ServerWorld serverLevel, NbtCompound compoundTag) {
        System.out.println("Loading existing nbt");
        var calendar = new Calendar(serverLevel);
        calendar.minuteHand = compoundTag.getInt("minuteHand");
        return calendar;
    }

    /**
     * Gets called by ServerLevel every second. See {@code CalendarMixin}.
     */
    public void tick() {
        iterator++;
        if (iterator >= 2) {
            secondsHand++;
            iterator = 0;
            if (secondsHand >= 1200) {
                minuteHand++;
                secondsHand = 0;
                send();
                if (minuteHand % 20 == 0) {
                    dayCounter++;
                    if (dayCounter % 7 == 0) {
                        weekCounter++;
                    }
                }
            }
        }
    }

    public void setMinuteHand(int minuteHand) {
        this.minuteHand = minuteHand;
    }

    public int getMinuteHand() {
        return minuteHand;
    }

    public int getSecondsHand() {
        return secondsHand;
    }
}

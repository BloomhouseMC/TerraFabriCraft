package io.github.bloomhousemc.terrafabricraft.common.calendar;

import io.github.bloomhousemc.terrafabricraft.TerraFabriCraft;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import net.minecraft.world.PersistentState;
import net.minecraft.world.World;

import java.util.List;

/**
 * The calendar is meant to count and calculate the real in-game time passed
 * since the moment the world is created taking into account the time spent sleeping.
 */
public class Calendar extends PersistentState {

    private final NbtCompound calendarData = new NbtCompound();
    private int iterator;
    private int minuteHand;
    private int dayCounter;
    private Month month;
    private Season season;
    private int year;
    private final List<ServerPlayerEntity> playerList;
    private final ServerWorld world;
    public static final Identifier CALENDAR_ID = new Identifier(TerraFabriCraft.MODID, "calendar");


    public Calendar(MinecraftServer server) {
        world = server.getWorld(World.OVERWORLD);
        playerList = server.getPlayerManager().getPlayerList();
        this.markDirty();
        minuteHand = 0;
        dayCounter = 0;
        month = Month.values()[5];
        season = Season.values()[2];
        year = 1000;

    }

    /**
     * Saves a compoundTag to ~/data/terrafabricraft.dat
     *
     * @param compoundTag
     * @return
     */
    @Override
    public NbtCompound writeNbt(NbtCompound compoundTag) {
        compoundTag.putInt("minuteHand", minuteHand);
        compoundTag.putInt("month", month.ordinal());
        compoundTag.putInt("season", season.ordinal());
        compoundTag.putInt("year", year);
        return compoundTag;
    }

    /**
     * Sends a packet to all clients with the value of minuteHand. See {@code CalendarClient}.
     * Gets called by tick() every second
     */
    public void send() {
        if (!world.isClient) {
            calendarData.putInt("minuteHand", minuteHand);
            calendarData.putInt("dayCounter", dayCounter);
            calendarData.putInt("month", month.ordinal());
            TerraFabriCraft.LOGGER.debug("Month value is: " + month.ordinal() + ".");
            calendarData.putInt("season", season.ordinal());
            var buf = PacketByteBufs.create();
            buf.writeNbt(calendarData);
            for (ServerPlayerEntity serverPlayerEntity : playerList) {
                TerraFabriCraft.LOGGER.debug("Sending packet to all clients");
                ServerPlayNetworking.send(serverPlayerEntity, CALENDAR_ID, buf);
            }
        }
    }

    /**
     * Loads a saved CompoundTag from ~/data/terrafabricraft.dat into a new calendar when you open a world.
     *
     * @param server      Used to get a PlayerList instance.
     * @param compoundTag Tag holding the calendar information saved by {@code writeNbt}.
     * @return
     */
    public static Calendar load(MinecraftServer server, NbtCompound compoundTag) {
        System.out.println("Loading existing nbt");
        var calendar = new Calendar(server);
        calendar.minuteHand = compoundTag.getInt("minuteHand");
        TerraFabriCraft.LOGGER.debug("Retrieving value minute value " + compoundTag.getInt("minuteHand") + " from world.");
        calendar.dayCounter = calendar.minuteHand / 20;
        calendar.month = Month.values()[compoundTag.getInt("month")];
        calendar.season = Season.values()[compoundTag.getInt("season")];
        calendar.year = compoundTag.getInt("year");
        calendar.send();
        return calendar;
    }

    /**
     * Gets called by ServerLevel every second. See {@code CalendarMixin}.
     *
     * @return
     */
    public void tick() {
        iterator++;
        if (iterator >= 2400) {
            minuteHand++;
            iterator = 0;
            if (minuteHand % 20 == 0) {
                dayCounter++;
                if (dayCounter % 8 == 0) {
                    if (month.ordinal() == 11) {
                        month = Month.values()[0];
                    }
                    else {
                        month = Month.values()[month.ordinal() + 1];
                    }
                    if (month.ordinal() % 3 == 0) {
                        if (season.ordinal() == 3) {
                            season = Season.values()[0];
                        }
                        else {
                            season = Season.values()[season.ordinal() + 1];
                        }
                    }

                    if (month.ordinal() % 12 == 0)
                        year++;
                }
            }
            send();
        }
    }

    public void setMinuteHand(int minuteHand) {
        this.minuteHand = minuteHand;
    }

    public int getMinuteHand() {
        return minuteHand;
    }

    public int getDayCounter() {
        return dayCounter;
    }

    public Month getMonth() {
        return month;
    }

//    enum Day {
//        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
//
//        Day(int number) {
//
//        }
//    }

    public enum Month {
        JANUARY ("January"), FEBRUARY ("February"), MARCH ("March"), APRIL ("April"), MAY ("May"), JUNE ("June"), JULY ("July"), AUGUST ("August"), SEPTEMBER ("September"), OCTOBER ("October"), NOVEMBER ("November"), DECEMBER ("December");

        public final String readable;

        Month(String readable) {
            this.readable = readable;
        }
    }

    public enum Season {
        SUMMER ("Summer"), AUTUMN ("Autumn"), WINTER ("Winter"), SPRING ("Spring");

        public final String readable;

        Season(String readable) {
            this.readable = readable;
        }
    }
}

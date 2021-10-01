package malek.terrafabricraft.common.calendar;

import malek.terrafabricraft.TerraFabriCraft;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import net.minecraft.world.PersistentState;

/**
 * The calendar is meant to count and calculate the real in-game time passed
 * since the moment the world is created taking into account the time spent sleeping,
 * changes to
 */
public class Calendar extends PersistentState {

    private NbtCompound calendarData;
    private int iterator;
    private int minuteHand;
    private int dayCounter;
    private int weekCounter;
    private int monthCounter;
    private int yearCounter;
    private ServerWorld serverLevel;
    public static final Identifier CALENDAR_ID = new Identifier(TerraFabriCraft.MOD_ID, "minutehand");

    public Calendar(ServerWorld serverLevel) {
        this.markDirty();
        minuteHand = 1;
        this.serverLevel = serverLevel;
    }

    @Override
    public NbtCompound writeNbt(NbtCompound compoundTag) {
        compoundTag.putInt("minuteHand", minuteHand);
        return compoundTag;
    }

    public void send() {
        calendarData.putInt("minuteHand", minuteHand);
        var buf = PacketByteBufs.create();
        buf.writeNbt(calendarData);
        var playerList = serverLevel.getServer().getPlayerManager().getPlayerList();
        for (ServerPlayerEntity serverPlayerEntity : playerList) {
            ServerPlayNetworking.send(serverPlayerEntity, CALENDAR_ID, buf);
            TerraFabriCraft.LOGGER.debug("If the server doesn't reach this code it's not sending the packets");
        }
    }

    public static Calendar load(ServerWorld serverLevel, NbtCompound compoundTag) {
        var calendar = new Calendar(serverLevel);
        calendar.calendarData = compoundTag;
        calendar.minuteHand = compoundTag.getInt("minuteHand");
        return calendar;
    }

    public void tick() {
        iterator++;
        if (iterator >= 2400) {
            minuteHand++;
            iterator = 0;
            send();
            System.out.println(minuteHand);
            if (minuteHand % 20 == 0) {
                dayCounter++;
                if (dayCounter % 7 == 0) {
                    weekCounter++;
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
}

package malek.terrafabricraft.common.calendar;

import io.netty.buffer.Unpooled;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.PersistentState;

public class Calendar extends PersistentState {

    private NbtCompound calendarData;
    private int iterator;
    private int minuteHand;
    private int dayCounter;
    private int weekCounter;
    private int monthCounter;
    private int yearCounter;
    private ServerWorld serverLevel;
    public static final Identifier CALENDAR_ID = new Identifier("terrafabricraft", "minuteHand");

    public Calendar(ServerWorld serverLevel) {
        this.markDirty();
        minuteHand = 1;
        this.serverLevel = serverLevel;
    }

    @Override
    public NbtCompound writeNbt(NbtCompound compoundTag) {
        compoundTag.putInt("minuteHand", minuteHand);
        var buf = PacketByteBufs.create();
        buf.writeNbt(compoundTag);
//        serverLevel.getServer().getPlayerManager().sendToAll(new CalendarS2CPacket("minuteHand", compoundTag));
        var playerList = serverLevel.getServer().getPlayerManager().getPlayerList();

        for (ServerPlayerEntity serverPlayerEntity : playerList) {
            ServerPlayNetworking.send(serverPlayerEntity, new Identifier("minuteHand"), buf);
            System.out.println(serverPlayerEntity);
            System.out.println(buf);
        }
        return compoundTag;
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

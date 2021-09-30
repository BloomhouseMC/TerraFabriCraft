package malek.terrafabricraft.common.calendar;

import io.netty.buffer.Unpooled;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.PersistentState;

public class Calendar extends PersistentState {

    private NbtCompound calendarData;
    private int iterator;
    private int minuteHand;
    private int dayCounter;
    private int weekCounter;
    private int monthCounter;
    private int yearCounter;

    public Calendar(ServerWorld serverLevel) {
        this.markDirty();
        minuteHand = 1;
    }

    @Override
    public NbtCompound writeNbt(NbtCompound compoundTag) {
        compoundTag.putInt("minuteHand", minuteHand);
        var test = new PacketByteBuf(Unpooled.buffer()).writeNbt(compoundTag);
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
        if (iterator >= 1200) {
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

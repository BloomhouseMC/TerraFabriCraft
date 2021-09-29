package malek.terrafabricraft.common.calendar;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.saveddata.SavedData;

public class Calendar extends SavedData {

    private CompoundTag calendarData;
    private int iterator;
    private int minuteHand;
    private int dayCounter;
    private int weekCounter;
    private int monthCounter;
    private int yearCounter;

    public Calendar(ServerLevel serverLevel) {
        this.setDirty();
        minuteHand = 1;
    }

    @Override
    public CompoundTag save(CompoundTag compoundTag) {
        compoundTag.putInt("minuteHand", minuteHand);
        return compoundTag;
    }

    public static Calendar load(ServerLevel serverLevel, CompoundTag compoundTag) {
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
            System.out.println("yep");
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
}

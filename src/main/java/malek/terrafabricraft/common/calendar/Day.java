package malek.terrafabricraft.common.calendar;

import malek.terrafabricraft.common.util.HelperUtil;
import net.minecraft.text.MutableText;
import net.minecraft.text.TranslatableText;

import java.util.HashMap;
import java.util.Map;

public enum Day
{
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY;

    private static final Map<String, String> BIRTHDAYS = new HashMap<>();
    private static final Map<String, String> IMPORTANT_DATES = new HashMap<>();
    private static final Day[] VALUES = values();

    static
    {
        BIRTHDAYS.put("APRIL28", "MrSterner");

        IMPORTANT_DATES.put("OCTOBER31", "Halloween");
    }

    public static Day valueOf(int i)
    {
        return i < 0 ? MONDAY : i >= VALUES.length ? SUNDAY : VALUES[i];
    }

    public static MutableText getDayName(long totalDays, Month month, int dayOfMonth)
    {
        String birthday = BIRTHDAYS.get(month.name() + dayOfMonth);
        String date = IMPORTANT_DATES.get(month.name() + dayOfMonth);
        if (birthday != null)
        {
            return new TranslatableText("terrafabricraft.tooltip.calendar_birthday", birthday);
        }
        if (date != null)
        {
            return new TranslatableText("terrafabricraft.tooltip.important_date", date);
        }
        Day day = Day.valueOf((int) totalDays % 7);
        return HelperUtil.translateEnum(day);
    }
}

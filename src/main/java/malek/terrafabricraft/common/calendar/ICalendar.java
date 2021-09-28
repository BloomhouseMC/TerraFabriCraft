package malek.terrafabricraft.common.calendar;

import malek.terrafabricraft.common.util.HelperUtil;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;

public interface ICalendar {
    /* Constants */
    int TICKS_IN_HOUR = 1000;
    int HOURS_IN_DAY = 24;
    int TICKS_IN_DAY = TICKS_IN_HOUR * HOURS_IN_DAY;
    int MONTHS_IN_YEAR = 12;

    /* This needs to be a float, otherwise there are ~62 minutes per hour */
    float TICKS_IN_MINUTE = TICKS_IN_HOUR / 60f;

    /* Total Calculation Methods */

    static float getTotalMinutes(long time)
    {
        return time / TICKS_IN_MINUTE;
    }

    static long getTotalHours(long time)
    {
        return time / TICKS_IN_HOUR;
    }

    static long getTotalDays(long time)
    {
        return time / TICKS_IN_DAY;
    }

    static long getTotalMonths(long time, long daysInMonth)
    {
        return time / (daysInMonth * TICKS_IN_DAY);
    }

    static long getTotalYears(long time, long daysInMonth)
    {
        return 1000 + (time / (MONTHS_IN_YEAR * daysInMonth * TICKS_IN_DAY));
    }

    /* Fraction Calculation Methods */

    static int getMinuteOfHour(long time)
    {
        return (int) ((time % TICKS_IN_HOUR) / TICKS_IN_MINUTE);
    }

    static int getHourOfDay(long time)
    {
        return (int) ((time / TICKS_IN_HOUR) % HOURS_IN_DAY);
    }

    static int getDayOfMonth(long time, long daysInMonth)
    {
        return 1 + (int) ((time / TICKS_IN_DAY) % daysInMonth);
    }

    static float getFractionOfMonth(long time, long daysInMonth)
    {
        long ticksInMonth = daysInMonth * TICKS_IN_DAY;
        return (float) (time % ticksInMonth) / ticksInMonth;
    }

    static float getFractionOfYear(long time, long daysInMonth)
    {
        long ticksInYear = MONTHS_IN_YEAR * daysInMonth * TICKS_IN_DAY;
        return (float) (time % ticksInYear) / ticksInYear;
    }

    static Month getMonthOfYear(long time, long daysInMonth)
    {
        return Month.valueOf((int) ((time / (TICKS_IN_DAY * daysInMonth)) % MONTHS_IN_YEAR));
    }

    /* Format Methods */

    static MutableComponent getTimeAndDate(long time, long daysInMonth)
    {
        return ICalendar.getTimeAndDate(ICalendar.getHourOfDay(time), ICalendar.getMinuteOfHour(time), ICalendar.getMonthOfYear(time, daysInMonth), ICalendar.getDayOfMonth(time, daysInMonth), ICalendar.getTotalYears(time, daysInMonth));
    }

    static MutableComponent getTimeAndDate(int hour, int minute, Month month, int day, long years)
    {
        return new TextComponent(String.format("%d:%02d ", hour, minute))
                .append(HelperUtil.translateEnum(month))
                .append(" ")
                .append(new TranslatableComponent("terrafabricraft.tooltip.calendar_days_years", day, years));
    }

    static MutableComponent getTimeDelta(long ticks, int daysInMonth)
    {
        final long hours = getTotalHours(ticks);
        if (hours < 1)
        {
            return new TranslatableComponent("tfc.tooltip.time_delta_hours_minutes", "00", String.format("%02d", getMinuteOfHour(ticks)));
        }
        final long days = getTotalDays(ticks);
        if (days < 1)
        {
            return new TranslatableComponent("tfc.tooltip.time_delta_hours_minutes", hours, String.format("%02d", getMinuteOfHour(ticks)));
        }
        final long months = getTotalMonths(ticks, daysInMonth);
        if (months < 1)
        {
            return new TranslatableComponent("tfc.tooltip.time_delta_days", days);
        }
        final long years = getTotalYears(ticks, daysInMonth) - 1000; // Since years starts at 1k
        if (years < 1)
        {
            return new TranslatableComponent("tfc.tooltip.time_delta_months_days", months, days % daysInMonth);
        }
        return new TranslatableComponent("tfc.tooltip.time_delta_years_months_days", years, months % MONTHS_IN_YEAR, days % daysInMonth);
    }

    /**
     * Gets the absolute amount of ticks passed since the world was created. This stops when no players are logged on.
     * This is safe to store timestamps.
     *
     * @return the amount of ticks since the world was created
     */
    long getTicks();

    /**
     * Gets the amount of ticks since the current date.
     * DO NOT store this in a timestamp, EVER.
     *
     * @return the amount of ticks since Jan 1, 1000
     */
    long getCalendarTicks();

    /**
     * @return the number of days in a month
     */
    int getCalendarDaysInMonth();

    /**
     * Gets the total amount of hours passed
     */
    default long getTotalHours()
    {
        return ICalendar.getTotalHours(getTicks());
    }

    /**
     * Gets the total amount of hours passed since Jan 1, 1000
     */
    default long getTotalCalendarHours()
    {
        return ICalendar.getTotalHours(getCalendarTicks());
    }

    /**
     * Gets the total amount of days passed
     */
    default long getTotalDays()
    {
        return ICalendar.getTotalDays(getTicks());
    }

    /**
     * Gets the total amount of days passed since Jan 1, 1000
     */
    default long getTotalCalendarDays()
    {
        return ICalendar.getTotalDays(getCalendarTicks());
    }

    /**
     * Gets the total amount of months passed
     */
    default long getTotalMonths()
    {
        return ICalendar.getTotalMonths(getTicks(), getCalendarDaysInMonth());
    }

    /**
     * Gets the total amount of months passed since Jan 1, 1000
     */
    default long getTotalCalendarMonths()
    {
        return ICalendar.getTotalMonths(getCalendarTicks(), getCalendarDaysInMonth());
    }

    /**
     * Gets the total amount of years passed
     */
    default long getTotalYears()
    {
        return ICalendar.getTotalYears(getTicks(), getCalendarDaysInMonth());
    }

    /**
     * Gets the total amount of years passed since Jan 1, 1000
     */
    default long getTotalCalendarYears()
    {
        return ICalendar.getTotalYears(getCalendarTicks(), getCalendarDaysInMonth());
    }

    /**
     * Get the equivalent total world time
     * World time 0 = 6:00 AM, which is calendar time 6000
     *
     * @return a value in [0, 24000) which should match the result of {link}
     */
    default long getCalendarDayTime()
    {
        return (getCalendarTicks() - (6 * ICalendar.TICKS_IN_HOUR)) % ICalendar.TICKS_IN_DAY;
    }

    /**
     * Calculates the day of a month from the calendar time (i.e. 01 - ??)
     */
    default int getCalendarDayOfMonth()
    {
        return ICalendar.getDayOfMonth(getCalendarTicks(), getCalendarDaysInMonth());
    }

    /**
     * Returns the progress through the month from a calendar time (i.e. 0 - 1)
     */
    default float getCalendarFractionOfMonth()
    {
        return ICalendar.getFractionOfMonth(getCalendarTicks(), getCalendarDaysInMonth());
    }

    /**
     * Returns the progress through the year from a calendar time (i.e. 0 - 1, where Jan 1 = 0)
     */
    default float getCalendarFractionOfYear()
    {
        return ICalendar.getFractionOfYear(getCalendarTicks(), getCalendarDaysInMonth());
    }

    /**
     * Calculates the current day from a calendar time.
     */
    default MutableComponent getCalendarDayOfYear()
    {
        return Day.getDayName(getTotalCalendarDays(), getCalendarMonthOfYear(), getCalendarDayOfMonth());
    }

    /**
     * Gets the current month of the year in calendar time
     */
    default Month getCalendarMonthOfYear()
    {
        return ICalendar.getMonthOfYear(getCalendarTicks(), getCalendarDaysInMonth());
    }

    /**
     * Gets the total number of ticks in a month.
     */
    default long getCalendarTicksInMonth()
    {
        return (long) getCalendarDaysInMonth() * TICKS_IN_DAY;
    }

    /**
     * Gets the total number of ticks in a year.
     */
    default long getCalendarTicksInYear()
    {
        return (long) getCalendarDaysInMonth() * MONTHS_IN_YEAR * TICKS_IN_DAY;
    }

    default MutableComponent getCalendarTimeAndDate()
    {
        return ICalendar.getTimeAndDate(getCalendarTicks(), getCalendarDaysInMonth());
    }

    default MutableComponent getTimeDelta(long ticks)
    {
        return ICalendar.getTimeDelta(ticks, getCalendarDaysInMonth());
    }
}

package malek.terrafabricraft.common.calendar;

import malek.terrafabricraft.client.ClientCalendar;
import malek.terrafabricraft.common.component.ServerCalendarComponent;
import malek.terrafabricraft.common.util.HelperUtil;
import net.minecraft.world.level.LevelReader;

public final class Calendars
{
    /**
     * These are separated into LOGICAL sides.
     * References must make sure they are choosing the correct side for their application
     */
    public static final ServerCalendarComponent SERVER = new ServerCalendarComponent();
    public static final ClientCalendar CLIENT = new ClientCalendar();

    /**
     * Gets the correct calendar for the current world context
     */
    public static ICalendar get(LevelReader world)
    {
        return HelperUtil.isClientSide(world) ? CLIENT : SERVER;
    }

    public static ICalendar get(boolean isClientSide)
    {
        return isClientSide ? CLIENT : SERVER;
    }

    private Calendars() {}
}

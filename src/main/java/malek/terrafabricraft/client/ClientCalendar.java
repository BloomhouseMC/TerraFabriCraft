package malek.terrafabricraft.client;

import malek.terrafabricraft.common.calendar.Calendar;

public class ClientCalendar extends Calendar {

    void onClientTick()
    {
        if (arePlayersLoggedOn)
        {
            playerTicks++;
            if (doDaylightCycle)
            {
                calendarTicks++;
            }
        }
    }
}

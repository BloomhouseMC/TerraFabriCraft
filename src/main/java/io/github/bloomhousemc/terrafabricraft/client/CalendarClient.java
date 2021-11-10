package io.github.bloomhousemc.terrafabricraft.client;

import io.github.bloomhousemc.terrafabricraft.TerraFabriCraft;
import io.github.bloomhousemc.terrafabricraft.common.calendar.Calendar;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;

import static io.github.bloomhousemc.terrafabricraft.common.calendar.Calendar.CALENDAR_ID;

/**
 * Updates the item tooltip for all decaying items
 * and displays the day, month and year on the debug hud.
 */
public class CalendarClient {
    private static int minuteHand = 0;
    private static int dayCounter = 1;
    private static Calendar.Month month = Calendar.Month.values()[5];
    private static Calendar.Season season = Calendar.Season.values()[2];

    /**
     * Gets a packet from the server every second. See {@code Calendar}
     */
    public static void initClient() {
        ClientPlayNetworking.registerGlobalReceiver(CALENDAR_ID, (client, handler, buf, responseSender) -> {
            var calendarData = buf.readNbt();
            client.execute(() -> {
                TerraFabriCraft.LOGGER.debug("Client got packet: " + calendarData.getInt("minuteHand") + ".");
                minuteHand = calendarData.getInt("minuteHand");
                dayCounter = calendarData.getInt("dayCounter");
                month = Calendar.Month.values()[calendarData.getInt("month")];
                season = Calendar.Season.values()[calendarData.getInt("season")];
            });
        });
    }

    public static int getMinuteHand() {
        return minuteHand;
    }

    public static int getDayCounter() {
        return dayCounter;
    }

    public static String getReadableMonth() {
        return month.readable;
    }

    public static String getReadableSeason() {
        return season.readable;
    }
}

package malek.terrafabricraft.client;

import malek.terrafabricraft.TerraFabriCraft;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;

import static malek.terrafabricraft.common.calendar.Calendar.CALENDAR_ID;

/**
 * Updates the item tooltip for all decaying items
 * and displays the day, month and year on the debug hud.
 */
public class CalendarClient {
    public static int minuteHand;

    /**
     * Gets a packet from the server every second. See {@code Calendar}
     */
    public static void initClient() {
        ClientPlayNetworking.registerGlobalReceiver(CALENDAR_ID, (client, handler, buf, responseSender) -> {
            var minuteHand = buf.readNbt();
            client.execute(() -> {
                TerraFabriCraft.LOGGER.debug("Client got packet: " + minuteHand.getInt("minuteHand") + ".");
                CalendarClient.minuteHand = minuteHand.getInt("minuteHand");
            });
        });
    }

    public static int getMinuteHand() {
        return minuteHand;
    }
}

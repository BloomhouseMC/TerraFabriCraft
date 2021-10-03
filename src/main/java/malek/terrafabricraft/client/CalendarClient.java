package malek.terrafabricraft.client;

import malek.terrafabricraft.TerraFabriCraft;
import malek.terrafabricraft.common.item.TFCFood;
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
        System.out.println("Does the code ever get here?");
        TerraFabriCraft.LOGGER.debug("If the code doesn't get here everything's lost");
        ClientPlayNetworking.registerGlobalReceiver(CALENDAR_ID, (client, handler, buf, responseSender) -> {
            var minuteHand = buf.readNbt();
            client.execute(() -> {
                System.out.println("So code does sometimes get here");
                TerraFabriCraft.LOGGER.debug("Client got the packet");
                System.out.println(minuteHand);
            });
        });
    }

    public static int getMinuteHand() {
        return minuteHand;
    }
}

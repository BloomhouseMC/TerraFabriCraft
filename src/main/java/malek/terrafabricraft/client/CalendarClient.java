package malek.terrafabricraft.client;

import io.netty.buffer.Unpooled;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.util.Identifier;

import static malek.terrafabricraft.common.calendar.Calendar.CALENDAR_ID;

public class CalendarClient {
    public static int minuteHand;
    public static void initClient() {
        System.out.println("Start of initClient()");
        ClientPlayNetworking.registerGlobalReceiver(CALENDAR_ID, (client, handler, buf, responseSender) -> {
            minuteHand = buf.readInt();
            System.out.println(minuteHand + " packet received by client");
        });
    }
}

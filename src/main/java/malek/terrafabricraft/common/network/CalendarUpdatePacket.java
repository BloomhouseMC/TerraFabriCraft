package malek.terrafabricraft.common.network;

import malek.terrafabricraft.common.calendar.Calendar;
import malek.terrafabricraft.common.calendar.Calendars;
import net.minecraft.network.FriendlyByteBuf;

public class CalendarUpdatePacket {
    private final Calendar instance;

    public CalendarUpdatePacket(Calendar instance)
    {
        this.instance = instance;
    }

    public CalendarUpdatePacket(FriendlyByteBuf buffer)
    {
        instance = new Calendar();
        instance.read(buffer);
    }

    public void encode(FriendlyByteBuf buffer)
    {
        instance.write(buffer);
    }

    void handle()
    {
        Calendars.CLIENT.reset(instance);
    }
}

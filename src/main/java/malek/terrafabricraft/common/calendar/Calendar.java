package malek.terrafabricraft.common.calendar;

import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import org.jetbrains.annotations.Nullable;

public class Calendar implements ICalendar {

    protected long playerTicks, calendarTicks;
    protected int daysInMonth;
    protected boolean doDaylightCycle, arePlayersLoggedOn;

    public Calendar()
    {
        daysInMonth = 8;
        playerTicks = 0;
        calendarTicks = (5L * daysInMonth * ICalendar.TICKS_IN_DAY) + (6 * ICalendar.TICKS_IN_HOUR);
        doDaylightCycle = true;
        arePlayersLoggedOn = false;
    }

    @Override
    public long getTicks()
    {
        return playerTicks;
    }

    @Override
    public long getCalendarTicks()
    {
        return calendarTicks;
    }

    @Override
    public int getCalendarDaysInMonth()
    {
        return daysInMonth;
    }

    public NbtCompound write()
    {
        NbtCompound nbt = new NbtCompound();

        nbt.putInt("daysInMonth", daysInMonth);

        nbt.putLong("playerTime", playerTicks);
        nbt.putLong("calendarTime", calendarTicks);

        nbt.putBoolean("doDaylightCycle", doDaylightCycle);
        nbt.putBoolean("arePlayersLoggedOn", arePlayersLoggedOn);

        return nbt;
    }

    public void read(@Nullable NbtCompound nbt)
    {
        if (nbt != null)
        {
            daysInMonth = nbt.getInt("daysInMonth");

            playerTicks = nbt.getLong("playerTime");
            calendarTicks = nbt.getLong("calendarTime");

            doDaylightCycle = nbt.getBoolean("doDaylightCycle");
            arePlayersLoggedOn = nbt.getBoolean("arePlayersLoggedOn");
        }
    }

    public void write(PacketByteBuf buffer)
    {
        buffer.writeVarInt(daysInMonth);

        buffer.writeVarLong(playerTicks);
        buffer.writeVarLong(calendarTicks);

        buffer.writeBoolean(doDaylightCycle);
        buffer.writeBoolean(arePlayersLoggedOn);
    }

    public void read(PacketByteBuf buffer)
    {
        daysInMonth = buffer.readVarInt();

        playerTicks = buffer.readVarLong();
        calendarTicks = buffer.readVarLong();

        doDaylightCycle = buffer.readBoolean();
        arePlayersLoggedOn = buffer.readBoolean();
    }

    public void reset(Calendar resetTo)
    {
        this.daysInMonth = resetTo.daysInMonth;

        this.playerTicks = resetTo.playerTicks;
        this.calendarTicks = resetTo.calendarTicks;

        this.doDaylightCycle = resetTo.doDaylightCycle;
        this.arePlayersLoggedOn = resetTo.arePlayersLoggedOn;
    }
}

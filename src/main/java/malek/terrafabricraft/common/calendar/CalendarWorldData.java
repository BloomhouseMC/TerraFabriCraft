package malek.terrafabricraft.common.calendar;

import malek.terrafabricraft.TerraFabriCraft;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.saveddata.SavedData;

public class CalendarWorldData extends SavedData {
    private static final String NAME = TerraFabriCraft.MODID + "_calendar";

    public static CalendarWorldData get(ServerLevel world)
    {
        return world.getDataStorage().computeIfAbsent(CalendarWorldData::load, CalendarWorldData::new, NAME);
    }

    private static CalendarWorldData load(CompoundTag nbt)
    {
        final CalendarWorldData data = new CalendarWorldData();
        data.calendar.read(nbt.getCompound("calendar"));
        return data;
    }

    private final Calendar calendar;

    public CalendarWorldData()
    {
        this.calendar = new Calendar();
    }

    @Override
    public CompoundTag save(CompoundTag nbt)
    {
        nbt.put("calendar", Calendars.SERVER.write());
        return nbt;
    }

    /**
     * Since this updates every tick, and doesn't store a local copy always assume it needs saving to disk
     */
    @Override
    public boolean isDirty()
    {
        return true;
    }

    public Calendar getCalendar()
    {
        return calendar;
    }
}

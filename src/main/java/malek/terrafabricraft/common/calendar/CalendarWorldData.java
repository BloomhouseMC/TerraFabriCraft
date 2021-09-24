package malek.terrafabricraft.common.calendar;

import malek.terrafabricraft.TerraFabriCraft;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.PersistentState;

public class CalendarWorldData extends PersistentState {
    private static final String NAME = TerraFabriCraft.MODID + "_calendar";

    public static CalendarWorldData get(ServerWorld world)
    {
        return world.getPersistentStateManager().getOrCreate(CalendarWorldData::load, CalendarWorldData::new, NAME);
    }

    private static CalendarWorldData load(NbtCompound nbt)
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
    public NbtCompound writeNbt(NbtCompound nbt)
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

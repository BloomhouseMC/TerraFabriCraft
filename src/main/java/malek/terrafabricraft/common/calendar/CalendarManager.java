package malek.terrafabricraft.common.calendar;

import malek.terrafabricraft.TerraFabriCraft;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;

public class CalendarManager {
    public static CalendarManager singleton;
    public Calendar calendar;

    public CalendarManager(MinecraftServer server) {
        ServerWorld level = server.getWorld(World.OVERWORLD);
        calendar = (Calendar) level.getPersistentStateManager().getOrCreate((compoundTag) -> Calendar.load(level, compoundTag),
                () -> new Calendar(level),
                TerraFabriCraft.MOD_ID);
    }

    public static void init() {
        ServerLifecycleEvents.SERVER_STARTED.register((server -> {
            singleton = new CalendarManager(server);
        }));
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public static CalendarManager getSingleton() {
        return singleton;
    }
}

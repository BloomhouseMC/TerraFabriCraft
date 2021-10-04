package malek.terrafabricraft.common.calendar;

import malek.terrafabricraft.TerraFabriCraft;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;

public class CalendarManager {
    private static CalendarManager singleton;
    private final Calendar calendar ;

    public CalendarManager(MinecraftServer server) {
        var level = server.getWorld(World.OVERWORLD);
        calendar = (Calendar) level.getPersistentStateManager().getOrCreate((compoundTag) -> Calendar.load(server, compoundTag),
                () -> new Calendar(server),
                TerraFabriCraft.MODID);
    }

    public static void init() {
        ServerLifecycleEvents.SERVER_STARTED.register((server -> {
            singleton = new CalendarManager(server);
            ServerTickEvents.START_WORLD_TICK.register(serverWorld -> singleton.getCalendar().tick());
            TerraFabriCraft.LOGGER.debug("Starting the clock");
        }));
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public static CalendarManager getSingleton() {
        return singleton;
    }
}

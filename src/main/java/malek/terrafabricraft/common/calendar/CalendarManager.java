package malek.terrafabricraft.common.calendar;

import malek.terrafabricraft.TerraFabriCraft;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;

public class CalendarManager {
    public Calendar calendar;
    public CalendarManager(MinecraftServer server) {
        ServerWorld level = server.getWorld(World.OVERWORLD);
        calendar = (Calendar) level.getPersistentStateManager().getOrCreate((compoundTag) -> {
            System.out.println(compoundTag);
            return Calendar.load(level, compoundTag);
        }, () -> {
            return new Calendar(level);
        }, TerraFabriCraft.MODID);
    }

    public static void init() {
        ServerLifecycleEvents.SERVER_STARTED.register((server -> {
             var calManager = new CalendarManager(server);
        }));
    }
}

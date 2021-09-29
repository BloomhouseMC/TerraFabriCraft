package malek.terrafabricraft.common.calendar;

import malek.terrafabricraft.TerraFabriCraft;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;

public class CalendarManager {
    public Calendar calendar;
    public CalendarManager(MinecraftServer server) {
        ServerLevel level = server.getLevel(Level.OVERWORLD);
        calendar = (Calendar) level.getDataStorage().computeIfAbsent((compoundTag) -> {
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

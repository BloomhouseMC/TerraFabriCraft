package malek.terrafabricraft.common.event;

import malek.terrafabricraft.TerraFabriCraft;
import malek.terrafabricraft.common.calendar.Calendar;
import malek.terrafabricraft.common.calendar.CalendarManager;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.function.BooleanSupplier;

public class TFCEvents {
    private static MinecraftServer currentserver;
    public static CalendarManager calendarInstantiator;


    public static void init() {
        ServerLifecycleEvents.SERVER_STARTED.register((server -> currentserver = server));

        ServerLifecycleEvents.SERVER_STOPPED.register((server -> currentserver = null));
    }

    public static MinecraftServer getCurrentserver() {
        return currentserver;
    }
}

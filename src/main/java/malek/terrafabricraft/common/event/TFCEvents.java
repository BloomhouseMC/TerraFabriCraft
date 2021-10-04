package malek.terrafabricraft.common.event;

import malek.terrafabricraft.TerraFabriCraft;
import malek.terrafabricraft.common.calendar.Calendar;
import malek.terrafabricraft.common.calendar.CalendarManager;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.minecraft.server.MinecraftServer;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.function.BooleanSupplier;

public class TFCEvents {
    private static MinecraftServer currentServer;

    public static void init() {
        ServerLifecycleEvents.SERVER_STARTED.register((server -> currentServer = server));

        ServerLifecycleEvents.SERVER_STOPPED.register((server -> currentServer = null));
    }

    public static MinecraftServer getCurrentServer() {
        return currentServer;
    }
}

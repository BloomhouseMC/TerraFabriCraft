package malek.terrafabricraft.common.event;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.minecraft.server.MinecraftServer;

public class TFCEvents {
    private static MinecraftServer currentserver;

    public static void init() {
        ServerLifecycleEvents.SERVER_STARTED.register((server -> {
            currentserver = server;
        }));

        ServerLifecycleEvents.SERVER_STOPPED.register((server -> {
            currentserver = null;
        }));
    }

    public static MinecraftServer getCurrentserver() {
        return currentserver;
    }
}

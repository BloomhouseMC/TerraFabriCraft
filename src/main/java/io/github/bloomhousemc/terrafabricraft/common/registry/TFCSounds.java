package io.github.bloomhousemc.terrafabricraft.common.registry;

import io.github.bloomhousemc.terrafabricraft.TerraFabriCraft;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class TFCSounds {

    public static SoundEvent ROOSTER_CRY = register("rooster_cry");
    public static SoundEvent FIRESTARTER1 = register("firestarter1");
    public static SoundEvent FIRESTARTER2 = register("firestarter2");
    public static SoundEvent FIRESTARTER3 = register("firestarter3");

    private static SoundEvent register(String id) {
        SoundEvent sound = new SoundEvent(new Identifier(TerraFabriCraft.MODID, id));
        Registry.register(Registry.SOUND_EVENT, new Identifier(TerraFabriCraft.MODID, id), sound);
        return sound;
    }

    public static void init() {
        // don't delete this
        // I'm serious
        // You: But it's a useless method? Whyyy?
        // No
        // No
        // No
    }
}
package malek.terrafabricraft.common.registry;

import malek.terrafabricraft.TerraFabriCraft;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class TFCSounds {

    public static SoundEvent ROOSTER_CRY = register("rooster_cry");

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
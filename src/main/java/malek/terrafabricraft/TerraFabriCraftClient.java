package malek.terrafabricraft;

import malek.terrafabricraft.client.UserHud;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;

public class TerraFabriCraftClient implements ClientModInitializer {


    @Override
    public void onInitializeClient() {
        HudRenderCallback.EVENT.register(new UserHud());
    }
}

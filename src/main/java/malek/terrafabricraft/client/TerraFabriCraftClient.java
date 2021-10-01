package malek.terrafabricraft.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class TerraFabriCraftClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        CalendarClient.initClient();
    }
}

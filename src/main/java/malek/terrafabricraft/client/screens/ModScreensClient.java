package malek.terrafabricraft.client.screens;

import malek.terrafabricraft.common.block.forge.ForgeGuiDescription;
import malek.terrafabricraft.common.block.forge.ForgeScreen;
import malek.terrafabricraft.common.block.logpile.LogPileGuiDescription;
import malek.terrafabricraft.common.block.logpile.LogPileScreen;
import malek.terrafabricraft.common.item.ceramic.CeramicVesselScreen;
import malek.terrafabricraft.common.item.ceramic.CeramicVesselScreenHandler;
import malek.terrafabricraft.common.knapping.KnappingScreen;
import malek.terrafabricraft.common.knapping.KnappingScreenHandler;
import malek.terrafabricraft.common.registry.TFCScreens;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;

public class ModScreensClient {
    public static void init() {
        ScreenRegistry.<LogPileGuiDescription, LogPileScreen>register(TFCScreens.LOG_PILE_SCREEN_HANDLER, (gui, inventory, title) -> new LogPileScreen(gui, inventory.player, title));
        ScreenRegistry.<ForgeGuiDescription, ForgeScreen>register(TFCScreens.FORGE_GUI_DESCRIPTION, (gui, inventory, title) -> new ForgeScreen(gui, inventory.player, title));
        ScreenRegistry.<CeramicVesselScreenHandler, CeramicVesselScreen>register(TFCScreens.CERAMIC_VESSEL_SCREEN_HANDLER, CeramicVesselScreen::new);
        ScreenRegistry.<KnappingScreenHandler, KnappingScreen>register(TFCScreens.KNAPPING_SCREEN_HANDLER, KnappingScreen::new);
    }
}

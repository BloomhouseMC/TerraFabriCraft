package io.github.bloomhousemc.terrafabricraft.client.screens;

import io.github.bloomhousemc.terrafabricraft.common.block.forge.ForgeGuiDescription;
import io.github.bloomhousemc.terrafabricraft.common.block.forge.ForgeScreen;
import io.github.bloomhousemc.terrafabricraft.common.block.logpile.LogPileGuiDescription;
import io.github.bloomhousemc.terrafabricraft.common.block.logpile.LogPileScreen;
import io.github.bloomhousemc.terrafabricraft.common.item.ceramic.CeramicVesselScreen;
import io.github.bloomhousemc.terrafabricraft.common.item.ceramic.CeramicVesselScreenHandler;
import io.github.bloomhousemc.terrafabricraft.common.gui.knapping.KnappingScreen;
import io.github.bloomhousemc.terrafabricraft.common.gui.knapping.KnappingScreenHandler;
import io.github.bloomhousemc.terrafabricraft.common.registry.TFCScreens;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;

public class ModScreensClient {
    public static void init() {
        ScreenRegistry.<LogPileGuiDescription, LogPileScreen>register(TFCScreens.LOG_PILE_SCREEN_HANDLER, (gui, inventory, title) -> new LogPileScreen(gui, inventory.player, title));
        ScreenRegistry.<ForgeGuiDescription, ForgeScreen>register(TFCScreens.FORGE_GUI_DESCRIPTION, (gui, inventory, title) -> new ForgeScreen(gui, inventory.player, title));
        ScreenRegistry.<CeramicVesselScreenHandler, CeramicVesselScreen>register(TFCScreens.CERAMIC_VESSEL_SCREEN_HANDLER, CeramicVesselScreen::new);
        ScreenRegistry.<KnappingScreenHandler, KnappingScreen>register(TFCScreens.KNAPPING_SCREEN_HANDLER, KnappingScreen::new);
        ScreenRegistry.<AnvilGuiDescription, AnvilScreen>register(TFCScreens.ANVIL_GUI_DESCRIPTION, (gui, inventory, title) -> new AnvilScreen(gui, inventory.player, title));
    }
}

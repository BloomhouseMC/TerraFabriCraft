package com.bloomhousemc.terrafabricraft.client.screens;

import com.bloomhousemc.terrafabricraft.common.block.forge.ForgeGuiDescription;
import com.bloomhousemc.terrafabricraft.common.block.forge.ForgeScreen;
import com.bloomhousemc.terrafabricraft.common.block.logpile.LogPileGuiDescription;
import com.bloomhousemc.terrafabricraft.common.block.logpile.LogPileScreen;
import com.bloomhousemc.terrafabricraft.common.gui.ceramic.CeramicVesselScreen;
import com.bloomhousemc.terrafabricraft.common.gui.ceramic.CeramicVesselScreenHandler;
import com.bloomhousemc.terrafabricraft.common.gui.knapping.KnappingScreen;
import com.bloomhousemc.terrafabricraft.common.registry.TfcScreens;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;

public class ModScreensClient {
    public static void init() {
        ScreenRegistry.<LogPileGuiDescription, LogPileScreen>register(TfcScreens.LOG_PILE_SCREEN_HANDLER, (gui, inventory, title) -> new LogPileScreen(gui, inventory.player, title));
        ScreenRegistry.<ForgeGuiDescription, ForgeScreen>register(TfcScreens.FORGE_GUI_DESCRIPTION, (gui, inventory, title) -> new ForgeScreen(gui, inventory.player, title));
        ScreenRegistry.<CeramicVesselScreenHandler, CeramicVesselScreen>register(TfcScreens.CERAMIC_VESSEL_SCREEN_HANDLER, CeramicVesselScreen::new);
        ScreenRegistry.<KnappingScreenHandler, KnappingScreen>register(TfcScreens.KNAPPING_SCREEN_HANDLER, KnappingScreen::new);
        ScreenRegistry.<AnvilGuiDescription, AnvilScreen>register(TfcScreens.ANVIL_GUI_DESCRIPTION, (gui, inventory, title) -> new AnvilScreen(gui, inventory.player, title));
    }
}

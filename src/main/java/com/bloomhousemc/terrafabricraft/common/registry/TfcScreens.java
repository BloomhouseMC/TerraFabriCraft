package com.bloomhousemc.terrafabricraft.common.registry;

import com.bloomhousemc.terrafabricraft.client.screens.AnvilGuiDescription;
import com.bloomhousemc.terrafabricraft.common.block.forge.ForgeGuiDescription;
import com.bloomhousemc.terrafabricraft.common.block.logpile.LogPileGuiDescription;
import com.bloomhousemc.terrafabricraft.common.gui.ceramic.CeramicVesselScreenHandler;
import com.bloomhousemc.terrafabricraft.client.screens.KnappingScreenHandler;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

import static com.bloomhousemc.terrafabricraft.TerraFabriCraft.MODID;

public class TfcScreens {
    public static ScreenHandlerType<LogPileGuiDescription> LOG_PILE_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(new Identifier(MODID, "log_pile"), (syncId, inventory) -> new LogPileGuiDescription(syncId, inventory, ScreenHandlerContext.EMPTY));
    public static ScreenHandlerType<CeramicVesselScreenHandler> CERAMIC_VESSEL_SCREEN_HANDLER = ScreenHandlerRegistry.registerExtended(new Identifier(MODID, "vessel"), CeramicVesselScreenHandler::new);
    public static ScreenHandlerType<KnappingScreenHandler> KNAPPING_SCREEN_HANDLER = ScreenHandlerRegistry.registerExtended(new Identifier(MODID, "knapping"), KnappingScreenHandler::new);
    public static ScreenHandlerType<ForgeGuiDescription> FORGE_GUI_DESCRIPTION = ScreenHandlerRegistry.registerSimple(new Identifier(MODID, "keg"), (syncId, inventory) -> new ForgeGuiDescription(syncId, inventory, ScreenHandlerContext.EMPTY));
    public static ScreenHandlerType<AnvilGuiDescription> ANVIL_GUI_DESCRIPTION = ScreenHandlerRegistry.registerSimple(new Identifier(MODID, "anvil"), (syncId, inventory) -> new AnvilGuiDescription(syncId, inventory, ScreenHandlerContext.EMPTY));

    private TfcScreens() {
    }

    public static void init() {
    }
}

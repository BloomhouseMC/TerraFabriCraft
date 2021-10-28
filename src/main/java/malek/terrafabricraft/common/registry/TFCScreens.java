package malek.terrafabricraft.common.registry;

import malek.terrafabricraft.client.screens.AnvilGuiDescription;
import malek.terrafabricraft.common.block.forge.ForgeGuiDescription;
import malek.terrafabricraft.common.block.logpile.LogPileGuiDescription;
import malek.terrafabricraft.common.item.ceramic.CeramicVesselScreenHandler;
import malek.terrafabricraft.common.gui.knapping.KnappingScreenHandler;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

import static malek.terrafabricraft.TerraFabriCraft.MODID;

public class TFCScreens {
    public static ScreenHandlerType<LogPileGuiDescription> LOG_PILE_SCREEN_HANDLER;
    public static ScreenHandlerType<CeramicVesselScreenHandler> CERAMIC_VESSEL_SCREEN_HANDLER;
    public static ScreenHandlerType<KnappingScreenHandler> KNAPPING_SCREEN_HANDLER;
    public static ScreenHandlerType<ForgeGuiDescription> FORGE_GUI_DESCRIPTION;
    public static ScreenHandlerType<AnvilGuiDescription> ANVIL_GUI_DESCRIPTION;

    public static void init() {
        LOG_PILE_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(new Identifier(MODID, "log_pile"), (syncId, inventory) -> new LogPileGuiDescription(syncId, inventory, ScreenHandlerContext.EMPTY));
        FORGE_GUI_DESCRIPTION = ScreenHandlerRegistry.registerSimple(new Identifier(MODID, "keg"), (syncId, inventory) -> new ForgeGuiDescription(syncId, inventory, ScreenHandlerContext.EMPTY));
        CERAMIC_VESSEL_SCREEN_HANDLER = ScreenHandlerRegistry.registerExtended(new Identifier(MODID, "vessel"), CeramicVesselScreenHandler::new);
        KNAPPING_SCREEN_HANDLER = ScreenHandlerRegistry.registerExtended(new Identifier(MODID, "knapping"), KnappingScreenHandler::new);
        ANVIL_GUI_DESCRIPTION = ScreenHandlerRegistry.registerSimple(new Identifier(MODID, "anvil"), (syncId, inventory) -> new AnvilGuiDescription(syncId, inventory, ScreenHandlerContext.EMPTY));

    }

}

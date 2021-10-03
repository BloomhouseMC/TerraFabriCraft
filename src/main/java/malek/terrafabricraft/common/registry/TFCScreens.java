package malek.terrafabricraft.common.registry;

import malek.terrafabricraft.common.block.forge.ForgeGuiDescription;
import malek.terrafabricraft.common.block.logpile.LogPileGuiDescription;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

import static malek.terrafabricraft.TerraFabriCraft.MOD_ID;

public class TFCScreens {
    public static ScreenHandlerType<LogPileGuiDescription> LOG_PILE_SCREEN_HANDLER;

    public static ScreenHandlerType<ForgeGuiDescription> FORGE_GUI_DESCRIPTION;
    public static void init() {
        LOG_PILE_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(new Identifier(MOD_ID, "log_pile"), (syncId, inventory) -> new LogPileGuiDescription(syncId, inventory, ScreenHandlerContext.EMPTY));
        FORGE_GUI_DESCRIPTION = ScreenHandlerRegistry.registerSimple(new Identifier(MOD_ID, "keg"), (syncId, inventory) -> new ForgeGuiDescription(syncId, inventory, ScreenHandlerContext.EMPTY));
    }

}

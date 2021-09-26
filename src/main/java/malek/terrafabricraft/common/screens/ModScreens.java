package malek.terrafabricraft.common.screens;

import malek.terrafabricraft.common.block.logpile.LogPileGuiDescription;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

import static malek.terrafabricraft.TerraFabriCraft.MODID;

public class ModScreens {
    public static ScreenHandlerType<LogPileGuiDescription> LOG_PILE_SCREEN_HANDLER;
    public static void init() {
        LOG_PILE_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(new Identifier(MODID, "log_pile"), (syncId, inventory) -> new LogPileGuiDescription(syncId, inventory, ScreenHandlerContext.EMPTY));

    }

}

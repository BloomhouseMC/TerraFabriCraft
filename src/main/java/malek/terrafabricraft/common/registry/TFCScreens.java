package malek.terrafabricraft.common.registry;

import malek.terrafabricraft.common.block.keg.KegGuiDescription;
import malek.terrafabricraft.common.block.logpile.LogPileGuiDescription;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

import static malek.terrafabricraft.TerraFabriCraft.MODID;

public class TFCScreens {
    public static ScreenHandlerType<LogPileGuiDescription> LOG_PILE_SCREEN_HANDLER;
    public static ScreenHandlerType<KegGuiDescription> KEG_SCREEN_HANDLER;

    public static void init() {
        LOG_PILE_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(new Identifier(MODID, "log_pile"), (syncId, inventory) -> new LogPileGuiDescription(syncId, inventory, ScreenHandlerContext.EMPTY));
        KEG_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(new Identifier(MODID, "keg"), (syncId, inventory) -> new KegGuiDescription(syncId, inventory, ScreenHandlerContext.EMPTY));

    }

}

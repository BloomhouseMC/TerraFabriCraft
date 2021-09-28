package malek.terrafabricraft.common.registry;

import malek.terrafabricraft.common.block.keg.KegGuiDescription;
import malek.terrafabricraft.common.block.logpile.LogPileGuiDescription;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.MenuType;

import static malek.terrafabricraft.TerraFabriCraft.MODID;

public class TFCScreens {
    public static MenuType<LogPileGuiDescription> LOG_PILE_SCREEN_HANDLER;
    public static MenuType<KegGuiDescription> KEG_SCREEN_HANDLER;

    public static void init() {
        LOG_PILE_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(new ResourceLocation(MODID, "log_pile"), (syncId, inventory) -> new LogPileGuiDescription(syncId, inventory, ContainerLevelAccess.NULL));
        KEG_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(new ResourceLocation(MODID, "keg"), (syncId, inventory) -> new KegGuiDescription(syncId, inventory, ContainerLevelAccess.NULL));

    }

}

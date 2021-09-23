package malek.terrafabricraft;

import malek.terrafabricraft.client.UserHud;
import malek.terrafabricraft.common.block.GroundCoverBlock;
import malek.terrafabricraft.common.registry.TFCObjects;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.block.Block;
import net.minecraft.client.render.RenderLayer;

public class TerraFabriCraftClient implements ClientModInitializer {


    @Override
    public void onInitializeClient() {
        HudRenderCallback.EVENT.register(new UserHud());
        for(Block block : TFCObjects.BLOCKS.keySet()) {
            if(block instanceof GroundCoverBlock groundCoverBlock) {
                BlockRenderLayerMap.INSTANCE.putBlock(groundCoverBlock, RenderLayer.getCutout());
            }
        }
    }
}

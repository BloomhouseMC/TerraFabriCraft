package malek.terrafabricraft;

import malek.terrafabricraft.client.UserHud;
import malek.terrafabricraft.client.screens.ModScreensClient;
import malek.terrafabricraft.common.block.GroundCoverBlock;
import malek.terrafabricraft.common.block.TFCCrops;
import malek.terrafabricraft.common.block.TFCCropsTall;
import malek.terrafabricraft.common.block.TFCOreBlock;
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
        ModScreensClient.init();
        for(Block block : TFCObjects.BLOCKS.keySet()) {
            if(block instanceof GroundCoverBlock groundCoverBlock) {
                BlockRenderLayerMap.INSTANCE.putBlock(groundCoverBlock, RenderLayer.getCutout());
            }
            if(block instanceof TFCOreBlock tfcOreBlock) {
                BlockRenderLayerMap.INSTANCE.putBlock(tfcOreBlock, RenderLayer.getCutout());
            }
            if(block instanceof TFCCrops tfcCrops){
                BlockRenderLayerMap.INSTANCE.putBlock(tfcCrops, RenderLayer.getCutout());
            }
            if(block instanceof TFCCropsTall tfcCropsTall){
                BlockRenderLayerMap.INSTANCE.putBlock(tfcCropsTall, RenderLayer.getCutout());
            }
        }
    }
}

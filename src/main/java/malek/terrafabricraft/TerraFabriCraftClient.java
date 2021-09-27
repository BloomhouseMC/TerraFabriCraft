package malek.terrafabricraft;

import malek.terrafabricraft.client.UserHud;
import malek.terrafabricraft.client.renderer.block.KegRenderer;
import malek.terrafabricraft.client.screens.ModScreensClient;
import malek.terrafabricraft.common.block.*;
import malek.terrafabricraft.common.block.keg.TFCKeg;
import malek.terrafabricraft.common.registry.TFCObjects;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendereregistry.v1.BlockEntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.block.Block;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;

public class TerraFabriCraftClient implements ClientModInitializer {


    @Override
    public void onInitializeClient() {
        HudRenderCallback.EVENT.register(new UserHud());
        ModScreensClient.init();
        //GeoItemRenderer.registerItemRenderer(TFCObjects.WOOD_ACACIA.keg.asItem(), new KegItemRenderer());
        BlockEntityRendererRegistry.INSTANCE.register(TFCObjects.KEG_BLOCK_ENTITY, (BlockEntityRendererFactory.Context rendererDispatcherIn) -> new KegRenderer());

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
            if(block instanceof TFCLooseRock tfcLooseRock) {
                BlockRenderLayerMap.INSTANCE.putBlock(tfcLooseRock, RenderLayer.getCutout());
            }

            if(block instanceof TFCKeg tfcKeg) {

                BlockRenderLayerMap.INSTANCE.putBlock(tfcKeg, RenderLayer.getCutout());

            }



        }

    }
}

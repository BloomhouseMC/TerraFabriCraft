package malek.terrafabricraft;

import malek.terrafabricraft.client.CalendarClient;
import malek.terrafabricraft.client.CustomLightmapTextureManager;
import malek.terrafabricraft.client.UserHud;
import malek.terrafabricraft.client.particle.KegBubbleParticle;
import malek.terrafabricraft.client.renderer.block.KegRenderer;
import malek.terrafabricraft.client.renderer.entity.NautilusRenderer;
import malek.terrafabricraft.client.screens.ModScreensClient;
import malek.terrafabricraft.common.block.*;
import malek.terrafabricraft.common.block.keg.Keg;
import malek.terrafabricraft.common.block.placeable.PlaceableBlockEntityRenderer;
import malek.terrafabricraft.common.block.toolrack.ToolRackBlock;
import malek.terrafabricraft.common.block.toolrack.ToolRackEntityRenderer;
import malek.terrafabricraft.common.registry.TFCEntityTypes;
import malek.terrafabricraft.common.registry.TFCObjects;
import malek.terrafabricraft.common.registry.TFCParticleTypes;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendereregistry.v1.BlockEntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.block.Block;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;

public class TerraFabriCraftClient implements ClientModInitializer {

    public static CustomLightmapTextureManager customLightmapTextureManager;
    @Override
    public void onInitializeClient() {
        HudRenderCallback.EVENT.register(new UserHud());
        ModScreensClient.init();
        CalendarClient.initClient();
        BlockEntityRendererRegistry.INSTANCE.register(TFCObjects.KEG_BLOCK_ENTITY, (BlockEntityRendererFactory.Context rendererDispatcherIn) -> new KegRenderer());
        ParticleFactoryRegistry.getInstance().register(TFCParticleTypes.KEG_BUBBLE, KegBubbleParticle.Factory::new);
        BlockEntityRendererRegistry.INSTANCE.register(TFCObjects.TOOL_RACK_BLOCK_ENTITY, ctx -> new ToolRackEntityRenderer());
        BlockEntityRendererRegistry.INSTANCE.register(TFCObjects.PLACEABLE_BLOCK_ENTITY, ctx -> new PlaceableBlockEntityRenderer());
        EntityRendererRegistry.INSTANCE.register(TFCEntityTypes.NAUTILUS, NautilusRenderer::new);


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

            if(block instanceof Keg tfcKeg) {
                BlockRenderLayerMap.INSTANCE.putBlock(tfcKeg, RenderLayer.getCutout());
            }
            if(block instanceof ToolRackBlock toolRackBlock) {
                BlockRenderLayerMap.INSTANCE.putBlock(toolRackBlock, RenderLayer.getCutout());
            }
            if(block instanceof TFCSupport tfcSupport) {
                BlockRenderLayerMap.INSTANCE.putBlock(tfcSupport, RenderLayer.getCutout());
            }



        }

    }
}

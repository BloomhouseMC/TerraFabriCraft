package malek.terrafabricraft;

import malek.terrafabricraft.client.CalendarClient;
import malek.terrafabricraft.client.CustomLightmapTextureManager;
import malek.terrafabricraft.client.UserHud;
import malek.terrafabricraft.client.particle.KegBubbleParticle;
import malek.terrafabricraft.client.renderer.block.BellowsRenderer;
import malek.terrafabricraft.client.renderer.block.KegRenderer;
import malek.terrafabricraft.client.screens.ModScreensClient;
import malek.terrafabricraft.common.block.*;
import malek.terrafabricraft.common.block.keg.Keg;
import malek.terrafabricraft.common.block.placeable.PlaceableBlockEntityRenderer;
import malek.terrafabricraft.common.block.toolrack.ToolRackBlock;
import malek.terrafabricraft.common.block.toolrack.ToolRackEntityRenderer;
import malek.terrafabricraft.common.item.MeltableItem;
import malek.terrafabricraft.common.registry.TFCClientRegistry;
import malek.terrafabricraft.common.registry.TFCObjects;
import malek.terrafabricraft.common.registry.TFCParticleTypes;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendereregistry.v1.BlockEntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.block.Block;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.Shader;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.util.Identifier;
import tfc.shaderutil.client.api.CoreShaderRegistry;
import tfc.shaderutil.client.api.ItemShaderTools;
import tfc.shaderutil.client.api.RenderLayerCreator;

import static malek.terrafabricraft.common.temperature.ItemTemperature.getTemperature;

@Environment(EnvType.CLIENT)
public class TerraFabriCraftClient implements ClientModInitializer {
    private static Shader testShader;
    public static CustomLightmapTextureManager customLightmapTextureManager;
    static float brighterLightChange = 0.9f;
    @Override
    public void onInitializeClient() {
        CoreShaderRegistry.register(new Identifier("terrafabricraft:custom_item_shader"),
                (factory, name) -> testShader = new Shader(factory, name, VertexFormats.POSITION_COLOR_TEXTURE_LIGHT_NORMAL)
        );
        RenderLayer testLayer = RenderLayerCreator.makeItem("terrafabricraft:custom_item_shader", () -> testShader, true, true);
        ItemShaderTools.registerLayerFunction((stack, direct) -> {
            float temp = 0;
            if(stack.hasNbt()) {
                if(stack.getOrCreateNbt().contains("temperature")) {
                    int temperature = stack.getOrCreateNbt().getInt("temperature");

                        float meltingPoint = 500;
                        if (stack.getItem() instanceof MeltableItem meltableItem) {
                            meltingPoint = meltableItem.getMeltingPoint();
                        }
                        float currentTemp = getTemperature(stack);
                    if (currentTemp / meltingPoint >brighterLightChange) {
                        temp = currentTemp/meltingPoint;
                        temp = (float) (((temp/brighterLightChange) - 1) * brighterLightChange);
                    }

                }
            }
            testShader.getUniformOrDefault("Count").set(temp);
            return testLayer;
        });

        HudRenderCallback.EVENT.register(new UserHud());
        ModScreensClient.init();
        CalendarClient.initClient();
        BlockEntityRendererRegistry.INSTANCE.register(TFCObjects.KEG_BLOCK_ENTITY, (BlockEntityRendererFactory.Context rendererDispatcherIn) -> new KegRenderer());
        ParticleFactoryRegistry.getInstance().register(TFCParticleTypes.KEG_BUBBLE, KegBubbleParticle.Factory::new);
        BlockEntityRendererRegistry.INSTANCE.register(TFCObjects.TOOL_RACK_BLOCK_ENTITY, ctx -> new ToolRackEntityRenderer());
        BlockEntityRendererRegistry.INSTANCE.register(TFCObjects.PLACEABLE_BLOCK_ENTITY, ctx -> new PlaceableBlockEntityRenderer());
        BlockEntityRendererRegistry.INSTANCE.register(TFCObjects.BELLOWS_BLOCK_ENTITY, (BlockEntityRendererFactory.Context rendererDispatcherIn) -> new BellowsRenderer());
        TFCClientRegistry.init();


        for(Block block : TFCObjects.BLOCKS.keySet()) {
            if(block instanceof GroundCoverBlock groundCoverBlock) {
                BlockRenderLayerMap.INSTANCE.putBlock(groundCoverBlock, RenderLayer.getCutout());
            }
            if(block instanceof TFCOreBlock tfcOreBlock) {
                BlockRenderLayerMap.INSTANCE.putBlock(tfcOreBlock, RenderLayer.getCutout());
            }
            if(block instanceof TFCGrassPlantBlock tfcGrassPlantBlock){
                BlockRenderLayerMap.INSTANCE.putBlock(tfcGrassPlantBlock, RenderLayer.getCutout());
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

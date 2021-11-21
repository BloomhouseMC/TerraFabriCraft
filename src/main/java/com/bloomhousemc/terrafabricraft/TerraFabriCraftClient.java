package com.bloomhousemc.terrafabricraft;

import com.bloomhousemc.terrafabricraft.client.CalendarClient;
import com.bloomhousemc.terrafabricraft.client.CustomLightmapTextureManager;
import com.bloomhousemc.terrafabricraft.client.UserHud;
import com.bloomhousemc.terrafabricraft.client.particle.KegBubbleParticle;
import com.bloomhousemc.terrafabricraft.client.renderer.block.BellowsRenderer;
import com.bloomhousemc.terrafabricraft.client.renderer.block.KegRenderer;
import com.bloomhousemc.terrafabricraft.client.screens.ModScreensClient;
import com.bloomhousemc.terrafabricraft.common.block.placeable.PlaceableBlockEntityRenderer;
import com.bloomhousemc.terrafabricraft.common.block.toolrack.ToolRackEntityRenderer;
import com.bloomhousemc.terrafabricraft.common.item.MeltableItem;
import com.bloomhousemc.terrafabricraft.common.item.TfcMetalItem;
import com.bloomhousemc.terrafabricraft.common.registry.TfcBlockEntities;
import com.bloomhousemc.terrafabricraft.common.registry.TfcBlocks;
import com.bloomhousemc.terrafabricraft.client.registry.TfcClientRegistry;
import com.bloomhousemc.terrafabricraft.common.registry.TfcParticleTypes;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.Shader;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.util.Identifier;
import tfc.shaderutil.client.api.CoreShaderRegistry;
import tfc.shaderutil.client.api.ItemShaderTools;
import tfc.shaderutil.client.api.RenderLayerCreator;

import static com.bloomhousemc.terrafabricraft.common.temperature.ItemTemperature.getTemperature;

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
            if(stack.hasNbt() && stack.getItem() instanceof TfcMetalItem) {
                if(stack.getOrCreateNbt().contains("temperature")) {
                    int temperature = stack.getOrCreateNbt().getInt("temperature");

                        float meltingPoint = 500;
                        if (stack.getItem() instanceof MeltableItem meltableItem) {
                            meltingPoint = meltableItem.getMeltingPoint();
                        }
                        float currentTemp = getTemperature(stack);
                    if (currentTemp / meltingPoint >brighterLightChange) {
                        temp = currentTemp/meltingPoint;
                        temp = (((temp/brighterLightChange) - 1) * brighterLightChange);
                    }

                }
            }
            testShader.getUniformOrDefault("Count").set(temp);
            return testLayer;
        });

        HudRenderCallback.EVENT.register(new UserHud());
        ModScreensClient.init();
        CalendarClient.initClient();
        BlockEntityRendererRegistry.register(TfcBlockEntities.KEG_BLOCK_ENTITY, (BlockEntityRendererFactory.Context rendererDispatcherIn) -> new KegRenderer());
        ParticleFactoryRegistry.getInstance().register(TfcParticleTypes.KEG_BUBBLE, KegBubbleParticle.Factory::new);
        BlockEntityRendererRegistry.register(TfcBlockEntities.TOOL_RACK_BLOCK_ENTITY, ctx -> new ToolRackEntityRenderer());
        BlockEntityRendererRegistry.register(TfcBlockEntities.PLACEABLE_BLOCK_ENTITY, ctx -> new PlaceableBlockEntityRenderer());
        BlockEntityRendererRegistry.register(TfcBlockEntities.BELLOWS_BLOCK_ENTITY, (BlockEntityRendererFactory.Context rendererDispatcherIn) -> new BellowsRenderer());
        TfcClientRegistry.init();

        BlockRenderLayerMap.INSTANCE.putBlock(TfcBlocks.GRASS.loam, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(TfcBlocks.GRASS.sandy_loam, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(TfcBlocks.GRASS.silt, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(TfcBlocks.GRASS.silty_loam, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(TfcBlocks.PEAT_GRASS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(TfcBlocks.CLAY_GRASS.silty_loam, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(TfcBlocks.CLAY_GRASS.silt, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(TfcBlocks.CLAY_GRASS.loam, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(TfcBlocks.CLAY_GRASS.sandy_loam, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(TfcBlocks.GRASS_PATH.sandy_loam, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(TfcBlocks.GRASS_PATH.loam, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(TfcBlocks.GRASS_PATH.silty_loam, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(TfcBlocks.GRASS_PATH.silt, RenderLayer.getCutout());
    }
}

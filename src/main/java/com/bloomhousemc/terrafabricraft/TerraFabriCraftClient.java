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

import static com.bloomhousemc.terrafabricraft.common.temperature.ItemTemperature.getTemperature;

@Environment(EnvType.CLIENT)
public class TerraFabriCraftClient implements ClientModInitializer {
    private static Shader testShader;
    public static CustomLightmapTextureManager customLightmapTextureManager;
    static float brighterLightChange = 0.9f;
    @Override
    public void onInitializeClient() {
    /*    CoreShaderRegistry.register(new Identifier("terrafabricraft:custom_item_shader"),
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
        }); */

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
        BlockRenderLayerMap.INSTANCE.putBlock(TfcBlocks.CORAL_BRAIN.coral, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(TfcBlocks.CORAL_BRAIN.dead_coral, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(TfcBlocks.CORAL_BRAIN.fan, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(TfcBlocks.CORAL_BRAIN.dead_fan, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(TfcBlocks.CORAL_BUBBLE.fan, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(TfcBlocks.CORAL_BUBBLE.dead_fan, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(TfcBlocks.CORAL_BUBBLE.coral, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(TfcBlocks.CORAL_BUBBLE.dead_coral, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(TfcBlocks.CORAL_FIRE.coral, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(TfcBlocks.CORAL_FIRE.dead_coral, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(TfcBlocks.CORAL_FIRE.fan, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(TfcBlocks.CORAL_FIRE.dead_fan, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(TfcBlocks.CORAL_HORN.fan, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(TfcBlocks.CORAL_HORN.dead_fan, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(TfcBlocks.CORAL_HORN.coral, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(TfcBlocks.CORAL_HORN.dead_coral, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(TfcBlocks.CORAL_TUBE.coral, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(TfcBlocks.CORAL_TUBE.dead_coral, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(TfcBlocks.CORAL_TUBE.fan, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(TfcBlocks.CORAL_TUBE.dead_fan, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(TfcBlocks.WOOD_ACACIA.FALLEN_LEAVES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(TfcBlocks.WOOD_ASH.FALLEN_LEAVES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(TfcBlocks.WOOD_ASPEN.FALLEN_LEAVES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(TfcBlocks.WOOD_BIRCH.FALLEN_LEAVES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(TfcBlocks.WOOD_BLACKWOOD.FALLEN_LEAVES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(TfcBlocks.WOOD_CHESTNUT.FALLEN_LEAVES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(TfcBlocks.WOOD_DOUGLAS_FIR.FALLEN_LEAVES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(TfcBlocks.WOOD_HICKORY.FALLEN_LEAVES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(TfcBlocks.WOOD_KAPOK.FALLEN_LEAVES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(TfcBlocks.WOOD_MAPLE.FALLEN_LEAVES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(TfcBlocks.WOOD_OAK.FALLEN_LEAVES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(TfcBlocks.WOOD_PALM.FALLEN_LEAVES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(TfcBlocks.WOOD_PINE.FALLEN_LEAVES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(TfcBlocks.WOOD_ROSEWOOD.FALLEN_LEAVES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(TfcBlocks.WOOD_SEQUOIA.FALLEN_LEAVES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(TfcBlocks.WOOD_SPRUCE.FALLEN_LEAVES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(TfcBlocks.WOOD_SYCAMORE.FALLEN_LEAVES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(TfcBlocks.WOOD_WHITE_CEDAR.FALLEN_LEAVES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(TfcBlocks.WOOD_WILLOW.FALLEN_LEAVES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(TfcBlocks.WOOD_ACACIA.SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(TfcBlocks.WOOD_ASH.SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(TfcBlocks.WOOD_ASPEN.SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(TfcBlocks.WOOD_BIRCH.SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(TfcBlocks.WOOD_BLACKWOOD.SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(TfcBlocks.WOOD_CHESTNUT.SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(TfcBlocks.WOOD_DOUGLAS_FIR.SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(TfcBlocks.WOOD_HICKORY.SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(TfcBlocks.WOOD_KAPOK.SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(TfcBlocks.WOOD_MAPLE.SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(TfcBlocks.WOOD_OAK.SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(TfcBlocks.WOOD_PALM.SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(TfcBlocks.WOOD_PINE.SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(TfcBlocks.WOOD_ROSEWOOD.SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(TfcBlocks.WOOD_SEQUOIA.SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(TfcBlocks.WOOD_SPRUCE.SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(TfcBlocks.WOOD_SYCAMORE.SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(TfcBlocks.WOOD_WHITE_CEDAR.SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(TfcBlocks.WOOD_WILLOW.SAPLING, RenderLayer.getCutout());
//        BlockRenderLayerMap.INSTANCE.putBlock(TfcBlocks.ANDESITE.BISMUTHINITE.POOR, RenderLayer.getCutout());
//        BlockRenderLayerMap.INSTANCE.putBlock(TfcBlocks.ANDESITE.BISMUTHINITE.NORMAL, RenderLayer.getCutout());
//        BlockRenderLayerMap.INSTANCE.putBlock(TfcBlocks.ANDESITE.BISMUTHINITE.RICH, RenderLayer.getCutout());
//        BlockRenderLayerMap.INSTANCE.putBlock(TfcBlocks.ANDESITE.CASSITERITE.POOR, RenderLayer.getCutout());
//        BlockRenderLayerMap.INSTANCE.putBlock(TfcBlocks.ANDESITE.CASSITERITE.NORMAL, RenderLayer.getCutout());
//        BlockRenderLayerMap.INSTANCE.putBlock(TfcBlocks.ANDESITE.CASSITERITE.RICH, RenderLayer.getCutout());
//        BlockRenderLayerMap.INSTANCE.putBlock(TfcBlocks.ANDESITE.GARNIERITE.POOR, RenderLayer.getCutout());
//        BlockRenderLayerMap.INSTANCE.putBlock(TfcBlocks.ANDESITE.GARNIERITE.NORMAL, RenderLayer.getCutout());
//        BlockRenderLayerMap.INSTANCE.putBlock(TfcBlocks.ANDESITE.GARNIERITE.RICH, RenderLayer.getCutout());
//        BlockRenderLayerMap.INSTANCE.putBlock(TfcBlocks.ANDESITE.HEMATITE.POOR, RenderLayer.getCutout());
//        BlockRenderLayerMap.INSTANCE.putBlock(TfcBlocks.ANDESITE.HEMATITE.NORMAL, RenderLayer.getCutout());
//        BlockRenderLayerMap.INSTANCE.putBlock(TfcBlocks.ANDESITE.HEMATITE.RICH, RenderLayer.getCutout());
//        BlockRenderLayerMap.INSTANCE.putBlock(TfcBlocks.ANDESITE.LIMONITE.POOR, RenderLayer.getCutout());
//        BlockRenderLayerMap.INSTANCE.putBlock(TfcBlocks.ANDESITE.LIMONITE.NORMAL, RenderLayer.getCutout());
//        BlockRenderLayerMap.INSTANCE.putBlock(TfcBlocks.ANDESITE.LIMONITE.RICH, RenderLayer.getCutout());
//        BlockRenderLayerMap.INSTANCE.putBlock(TfcBlocks.ANDESITE.MAGNETITE.POOR, RenderLayer.getCutout());
//        BlockRenderLayerMap.INSTANCE.putBlock(TfcBlocks.ANDESITE.MAGNETITE.NORMAL, RenderLayer.getCutout());
//        BlockRenderLayerMap.INSTANCE.putBlock(TfcBlocks.ANDESITE.MAGNETITE.RICH, RenderLayer.getCutout());
//        BlockRenderLayerMap.INSTANCE.putBlock(TfcBlocks.ANDESITE.MAGNETITE.NORMAL, RenderLayer.getCutout());
//        BlockRenderLayerMap.INSTANCE.putBlock(TfcBlocks.ANDESITE.MALACHITE.POOR, RenderLayer.getCutout());
//        BlockRenderLayerMap.INSTANCE.putBlock(TfcBlocks.ANDESITE.MALACHITE.NORMAL, RenderLayer.getCutout());
//        BlockRenderLayerMap.INSTANCE.putBlock(TfcBlocks.ANDESITE.MALACHITE.RICH, RenderLayer.getCutout());
    }
}

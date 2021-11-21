package com.bloomhousemc.terrafabricraft.client.registry;

import com.bloomhousemc.terrafabricraft.TerraFabriCraft;
import com.bloomhousemc.terrafabricraft.client.model.entity.CrabEntityModel;
import com.bloomhousemc.terrafabricraft.client.model.entity.RoosterEntityModel;
import com.bloomhousemc.terrafabricraft.client.model.entity.YakEntityModel;
import com.bloomhousemc.terrafabricraft.client.renderer.entity.CrabEntityRenderer;
import com.bloomhousemc.terrafabricraft.client.renderer.entity.RoosterRenderer;
import com.bloomhousemc.terrafabricraft.client.renderer.entity.CamelRenderer;
import com.bloomhousemc.terrafabricraft.client.renderer.entity.NautilusRenderer;
import com.bloomhousemc.terrafabricraft.client.renderer.entity.YakEntityRenderer;
import com.bloomhousemc.terrafabricraft.common.registry.TfcEntityTypes;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public final class TfcClientRegistry {

    public static final EntityModelLayer CRAB_LAYER = new EntityModelLayer(new Identifier(TerraFabriCraft.MODID, "crab_layer"), "crab_layer");
    public static final EntityModelLayer ROOSTER_LAYER = new EntityModelLayer(new Identifier(TerraFabriCraft.MODID, "rooster_layer"), "rooster_layer");
    public static final EntityModelLayer YAK_LAYER = new EntityModelLayer(new Identifier(TerraFabriCraft.MODID, "yak_layer"), "yak_layer");

    public static void init() {
        EntityRendererRegistry.register(TfcEntityTypes.CRAB, CrabEntityRenderer::new);
        EntityRendererRegistry.register(TfcEntityTypes.NAUTILUS, NautilusRenderer::new);
        EntityRendererRegistry.register(TfcEntityTypes.CAMEL, CamelRenderer::new);
        EntityRendererRegistry.register(TfcEntityTypes.ROOSTER, RoosterRenderer::new);
        EntityRendererRegistry.register(TfcEntityTypes.YAK, YakEntityRenderer::new);

        EntityModelLayerRegistry.registerModelLayer(CRAB_LAYER, CrabEntityModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(ROOSTER_LAYER, RoosterEntityModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(YAK_LAYER, YakEntityModel::getTexturedModelData);
    }
}

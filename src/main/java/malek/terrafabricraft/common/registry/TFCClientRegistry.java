package malek.terrafabricraft.common.registry;

import malek.terrafabricraft.TerraFabriCraft;
import malek.terrafabricraft.client.model.entity.CrabEntityModel;
import malek.terrafabricraft.client.model.entity.RoosterEntityModel;
import malek.terrafabricraft.client.model.entity.YakEntityModel;
import malek.terrafabricraft.client.renderer.entity.CrabEntityRenderer;
import malek.terrafabricraft.client.renderer.entity.RoosterRenderer;
import malek.terrafabricraft.client.renderer.entity.CamelRenderer;
import malek.terrafabricraft.client.renderer.entity.NautilusRenderer;
import malek.terrafabricraft.client.renderer.entity.YakEntityRenderer;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class TFCClientRegistry {

    public static final EntityModelLayer CRAB_LAYER = new EntityModelLayer(new Identifier(TerraFabriCraft.MODID, "crab_layer"), "crab_layer");
    public static final EntityModelLayer ROOSTER_LAYER = new EntityModelLayer(new Identifier(TerraFabriCraft.MODID, "rooster_layer"), "rooster_layer");
    public static final EntityModelLayer YAK_LAYER = new EntityModelLayer(new Identifier(TerraFabriCraft.MODID, "yak_layer"), "yak_layer");

    public static void init() {
        EntityRendererRegistry.INSTANCE.register(TFCEntityTypes.CRAB, CrabEntityRenderer::new);
        EntityRendererRegistry.INSTANCE.register(TFCEntityTypes.NAUTILUS, NautilusRenderer::new);
        EntityRendererRegistry.INSTANCE.register(TFCEntityTypes.CAMEL, CamelRenderer::new);
        EntityRendererRegistry.INSTANCE.register(TFCEntityTypes.ROOSTER, RoosterRenderer::new);
        EntityRendererRegistry.INSTANCE.register(TFCEntityTypes.YAK, YakEntityRenderer::new);

        EntityModelLayerRegistry.registerModelLayer(CRAB_LAYER, CrabEntityModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(ROOSTER_LAYER, RoosterEntityModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(YAK_LAYER, YakEntityModel::getTexturedModelData);
    }
}

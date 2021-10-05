package malek.terrafabricraft.common.registry;

import malek.terrafabricraft.TerraFabriCraft;
import malek.terrafabricraft.client.model.CrabEntityModel;
import malek.terrafabricraft.client.renderer.CrabEntityRenderer;
import malek.terrafabricraft.client.renderer.entity.NautilusRenderer;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class TFCClientRegistry {

    public static final EntityModelLayer CRAB_LAYER = new EntityModelLayer(new Identifier(TerraFabriCraft.MODID, "crab_layer"), "crab_layer");

    public static void init() {
        EntityRendererRegistry.INSTANCE.register(TFCEntityTypes.CRAB, CrabEntityRenderer::new);
        EntityRendererRegistry.INSTANCE.register(TFCEntityTypes.NAUTILUS, NautilusRenderer::new);

        EntityModelLayerRegistry.registerModelLayer(CRAB_LAYER, CrabEntityModel::getTexturedModelData);
    }
}

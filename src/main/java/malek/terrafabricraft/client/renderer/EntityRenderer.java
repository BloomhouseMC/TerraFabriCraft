package malek.terrafabricraft.client.renderer;

import malek.terrafabricraft.TerraFabriCraft;
import malek.terrafabricraft.client.model.RoosterEntityModel;
import malek.terrafabricraft.common.registry.TFCEntityTypes;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;

@Environment(EnvType.CLIENT)
public class EntityRenderer implements ClientModInitializer {
    public static final ModelLayerLocation MODEL_ROOSTER_LAYER = new ModelLayerLocation(new ResourceLocation(TerraFabriCraft.MODID, "rooster"), "main");
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.INSTANCE.register(TFCEntityTypes.ROOSTER, RoosterRenderer::new);

        EntityModelLayerRegistry.registerModelLayer(MODEL_ROOSTER_LAYER, RoosterEntityModel::getTexturedModelData);
    }
}

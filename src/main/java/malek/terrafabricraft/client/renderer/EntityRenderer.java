package malek.terrafabricraft.client.renderer;

import dev.architectury.registry.level.entity.EntityRendererRegistry;
import malek.terrafabricraft.TerraFabriCraft;
import malek.terrafabricraft.common.entity.RoosterEntityModel;
import malek.terrafabricraft.common.entity.RoosterRenderer;
import malek.terrafabricraft.common.registry.TFCEntityTypes;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityModelLayerRegistry;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class EntityRenderer implements ClientModInitializer {
    public static final EntityModelLayer MODEL_ROOSTER_LAYER = new EntityModelLayer(new Identifier(TerraFabriCraft.MODID, "rooster"), "main");
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(TFCEntityTypes.ROOSTER, RoosterRenderer::new);

        EntityModelLayerRegistry.registerModelLayer(MODEL_ROOSTER_LAYER, RoosterEntityModel::getTexturedModelData);
    }
}

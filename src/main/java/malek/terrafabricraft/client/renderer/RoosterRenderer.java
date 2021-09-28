package malek.terrafabricraft.client.renderer;

import malek.terrafabricraft.TerraFabriCraft;
import malek.terrafabricraft.client.model.RoosterEntityModel;
import malek.terrafabricraft.common.entity.RoosterEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class RoosterRenderer extends MobRenderer<RoosterEntity, RoosterEntityModel> {

    public RoosterRenderer(EntityRendererProvider.Context context) {
        super(context, new RoosterEntityModel(context.bakeLayer(EntityRenderer.MODEL_ROOSTER_LAYER)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(RoosterEntity entity) {
        return new ResourceLocation(TerraFabriCraft.MODID, "textures/entity/animal/rooster.png");
    }
}

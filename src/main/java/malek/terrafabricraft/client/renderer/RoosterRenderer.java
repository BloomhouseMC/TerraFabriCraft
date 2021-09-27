package malek.terrafabricraft.client.renderer;

import malek.terrafabricraft.TerraFabriCraft;
import malek.terrafabricraft.client.model.RoosterEntityModel;
import malek.terrafabricraft.common.entity.RoosterEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class RoosterRenderer extends MobEntityRenderer<RoosterEntity, RoosterEntityModel> {

    public RoosterRenderer(EntityRendererFactory.Context context) {
        super(context, new RoosterEntityModel(context.getPart(EntityRenderer.MODEL_ROOSTER_LAYER)), 0.5f);
    }

    @Override
    public Identifier getTexture(RoosterEntity entity) {
        return new Identifier(TerraFabriCraft.MODID, "textures/entity/animal/rooster.png");
    }
}

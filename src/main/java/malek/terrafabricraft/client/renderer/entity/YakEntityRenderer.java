package malek.terrafabricraft.client.renderer.entity;

import malek.terrafabricraft.TerraFabriCraft;
import malek.terrafabricraft.client.model.entity.YakEntityModel;
import malek.terrafabricraft.common.entity.YakEntity;
import malek.terrafabricraft.common.registry.TFCClientRegistry;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class YakEntityRenderer extends MobEntityRenderer<YakEntity, YakEntityModel> {
    private static final Identifier TEXTURE = new Identifier(TerraFabriCraft.MODID, "textures/entity/animal/yak.png");

    public YakEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new YakEntityModel(context.getPart(TFCClientRegistry.YAK_LAYER)), 0.7F);
    }

    public Identifier getTexture(YakEntity entity) {
        return TEXTURE;
    }
}

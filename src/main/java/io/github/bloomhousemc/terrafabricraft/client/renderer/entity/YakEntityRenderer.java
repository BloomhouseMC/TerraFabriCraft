package io.github.bloomhousemc.terrafabricraft.client.renderer.entity;

import io.github.bloomhousemc.terrafabricraft.TerraFabriCraft;
import io.github.bloomhousemc.terrafabricraft.client.model.entity.YakEntityModel;
import io.github.bloomhousemc.terrafabricraft.common.entity.YakEntity;
import io.github.bloomhousemc.terrafabricraft.common.registry.TFCClientRegistry;
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

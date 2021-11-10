package com.bloomhousemc.terrafabricraft.client.renderer.entity;

import com.bloomhousemc.terrafabricraft.TerraFabriCraft;
import com.bloomhousemc.terrafabricraft.client.model.entity.CrabEntityModel;
import com.bloomhousemc.terrafabricraft.common.entity.CrabEntity;
import com.bloomhousemc.terrafabricraft.common.registry.TFCClientRegistry;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class CrabEntityRenderer extends MobEntityRenderer<CrabEntity, CrabEntityModel> {
    private static final Identifier TEXTURE = new Identifier(TerraFabriCraft.MODID, "textures/entity/animal/crab.png");

    public CrabEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new CrabEntityModel(context.getPart(TFCClientRegistry.CRAB_LAYER)), 0.3F);
    }

    @Override
    public Identifier getTexture(CrabEntity scarecrowEntity) {
        return TEXTURE;
    }
}

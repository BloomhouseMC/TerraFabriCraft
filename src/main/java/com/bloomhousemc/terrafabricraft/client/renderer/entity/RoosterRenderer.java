package com.bloomhousemc.terrafabricraft.client.renderer.entity;

import com.bloomhousemc.terrafabricraft.TerraFabriCraft;
import com.bloomhousemc.terrafabricraft.client.model.entity.RoosterEntityModel;
import com.bloomhousemc.terrafabricraft.common.entity.RoosterEntity;
import com.bloomhousemc.terrafabricraft.client.registry.TfcClientRegistry;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class RoosterRenderer extends MobEntityRenderer<RoosterEntity, RoosterEntityModel> {

    public RoosterRenderer(EntityRendererFactory.Context context) {
        super(context, new RoosterEntityModel(context.getPart(TfcClientRegistry.ROOSTER_LAYER)), 0.5f);
    }

    @Override
    public Identifier getTexture(RoosterEntity entity) {
        return new Identifier(TerraFabriCraft.MODID, "textures/entity/animal/rooster.png");
    }
}

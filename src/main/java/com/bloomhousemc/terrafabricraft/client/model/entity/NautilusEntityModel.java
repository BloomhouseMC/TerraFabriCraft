package com.bloomhousemc.terrafabricraft.client.model.entity;

import com.bloomhousemc.terrafabricraft.TerraFabriCraft;
import com.bloomhousemc.terrafabricraft.common.entity.NautilusEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class NautilusEntityModel extends AnimatedGeoModel<NautilusEntity> {
    @Override
    public Identifier getAnimationFileLocation(NautilusEntity entity) {
        return new Identifier(TerraFabriCraft.MODID, "animations/nautilus.animation.json");
    }

    @Override
    public Identifier getModelLocation(NautilusEntity entity) {
        return new Identifier(TerraFabriCraft.MODID, "geo/nautilus.geo.json");
    }

    @Override
    public Identifier getTextureLocation(NautilusEntity entity) {
        return new Identifier(TerraFabriCraft.MODID, "textures/entity/animal/nautilus.png");
    }


}
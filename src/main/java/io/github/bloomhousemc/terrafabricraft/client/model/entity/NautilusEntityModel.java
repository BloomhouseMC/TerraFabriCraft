package io.github.bloomhousemc.terrafabricraft.client.model.entity;

import io.github.bloomhousemc.terrafabricraft.TerraFabriCraft;
import io.github.bloomhousemc.terrafabricraft.common.entity.NautilusEntity;
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
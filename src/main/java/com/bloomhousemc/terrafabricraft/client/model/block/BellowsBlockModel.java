package com.bloomhousemc.terrafabricraft.client.model.block;

import com.bloomhousemc.terrafabricraft.TerraFabriCraft;
import com.bloomhousemc.terrafabricraft.common.block.bellows.BellowsBlockEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class BellowsBlockModel extends AnimatedGeoModel<BellowsBlockEntity> {
    @Override
    public Identifier getAnimationFileLocation(BellowsBlockEntity entity) {
        return new Identifier(TerraFabriCraft.MODID, "animations/bellows.animation.json");
    }

    @Override
    public Identifier getModelLocation(BellowsBlockEntity animatable) {
        return new Identifier(TerraFabriCraft.MODID, "geo/bellows.geo.json");
    }

    @Override
    public Identifier getTextureLocation(BellowsBlockEntity entity) {
        return new Identifier(TerraFabriCraft.MODID, "textures/block/bellows.png");
    }
}
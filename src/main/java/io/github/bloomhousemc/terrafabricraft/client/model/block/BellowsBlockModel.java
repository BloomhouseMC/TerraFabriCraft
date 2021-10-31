package io.github.bloomhousemc.terrafabricraft.client.model.block;

import io.github.bloomhousemc.terrafabricraft.TerraFabriCraft;
import io.github.bloomhousemc.terrafabricraft.common.block.bellows.BellowsBlockEntity;
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
package com.bloomhousemc.terrafabricraft.client.model.block;

import com.bloomhousemc.terrafabricraft.TerraFabriCraft;
import com.bloomhousemc.terrafabricraft.common.block.keg.KegEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class KegModel extends AnimatedGeoModel<KegEntity> {
    @Override
    public Identifier getAnimationFileLocation(KegEntity entity) {
        return new Identifier(TerraFabriCraft.MODID, "animations/keg.animation.json");
    }

    @Override
    public Identifier getModelLocation(KegEntity animatable) {
        return new Identifier(TerraFabriCraft.MODID, "geo/keg.geo.json");
    }

    @Override
    public Identifier getTextureLocation(KegEntity entity) {
        String string = entity.getCachedState().getBlock().getName().getString();
        return new Identifier(TerraFabriCraft.MODID, "textures/block/wood/keg/"+string.substring(string.lastIndexOf(".")+1)+".png");
    }
}

package com.bloomhousemc.terrafabricraft.client.model.entity;

import com.bloomhousemc.terrafabricraft.TerraFabriCraft;
import com.bloomhousemc.terrafabricraft.common.entity.CamelEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

public class CamelEntityModel extends AnimatedGeoModel<CamelEntity> {
    @Override
    public Identifier getAnimationFileLocation(CamelEntity entity) {
        return new Identifier(TerraFabriCraft.MODID, "animations/camel.animation.json");
    }

    @Override
    public Identifier getModelLocation(CamelEntity entity) {
        return new Identifier(TerraFabriCraft.MODID, "geo/camel.geo.json");
    }

    @Override
    public Identifier getTextureLocation(CamelEntity entity) {
        return new Identifier(TerraFabriCraft.MODID, "textures/entity/animal/camel.png");
    }
    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public void setLivingAnimations(CamelEntity entity, Integer uniqueID, AnimationEvent customPredicate) {
        super.setLivingAnimations(entity, uniqueID, customPredicate);
        IBone head = this.getAnimationProcessor().getBone("head");

        EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);
        if (head != null) {
            head.setRotationX(extraData.headPitch * ((float) Math.PI / 180F));
            head.setRotationY(extraData.netHeadYaw * ((float) Math.PI / 180F));
        }
    }


}
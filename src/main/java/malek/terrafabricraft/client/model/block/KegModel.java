package malek.terrafabricraft.client.model.block;

import malek.terrafabricraft.TerraFabriCraft;
import malek.terrafabricraft.common.block.keg.KegEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class KegModel extends AnimatedGeoModel<KegEntity> {
    @Override
    public Identifier getAnimationFileLocation(KegEntity entity) {
        return new Identifier(TerraFabriCraft.MOD_ID, "animations/keg.animation.json");
    }

    @Override
    public Identifier getModelLocation(KegEntity animatable) {
        return new Identifier(TerraFabriCraft.MOD_ID, "geo/keg.geo.json");
    }

    @Override
    public Identifier getTextureLocation(KegEntity entity) {
        String string = entity.getCachedState().getBlock().getName().getString();
        return new Identifier(TerraFabriCraft.MOD_ID, "textures/block/wood/keg/"+string.substring(string.lastIndexOf(".")+1)+".png");
    }
}

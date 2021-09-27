package malek.terrafabricraft.client.model.block;

import malek.terrafabricraft.TerraFabriCraft;
import malek.terrafabricraft.common.block.keg.TFCKegEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class KegModel extends AnimatedGeoModel<TFCKegEntity> {
    @Override
    public Identifier getAnimationFileLocation(TFCKegEntity entity) {
        return new Identifier(TerraFabriCraft.MODID, "animations/keg.animation.json");
    }

    @Override
    public Identifier getModelLocation(TFCKegEntity animatable) {
        return new Identifier(TerraFabriCraft.MODID, "geo/keg.geo.json");
    }

    @Override
    public Identifier getTextureLocation(TFCKegEntity entity) {
        String string = entity.getCachedState().getBlock().getName().getString();
        return new Identifier(TerraFabriCraft.MODID, "textures/block/wood/keg/"+string.substring(string.lastIndexOf(".")+1)+".png");
    }
}

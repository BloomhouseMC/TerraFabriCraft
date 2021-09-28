//package malek.terrafabricraft.client.model.block;
//
//import malek.terrafabricraft.TerraFabriCraft;
//import malek.terrafabricraft.common.block.keg.TFCKegEntity;
//import net.minecraft.resources.ResourceLocation;
//import software.bernie.geckolib3.model.AnimatedGeoModel;
//
//public class KegModel extends AnimatedGeoModel<TFCKegEntity> {
//    @Override
//    public ResourceLocation getAnimationFileLocation(TFCKegEntity entity) {
//        return new ResourceLocation(TerraFabriCraft.MODID, "animations/keg.animation.json");
//    }
//
//    @Override
//    public ResourceLocation getModelLocation(TFCKegEntity animatable) {
//        return new ResourceLocation(TerraFabriCraft.MODID, "geo/keg.geo.json");
//    }
//
//    @Override
//    public ResourceLocation getTextureLocation(TFCKegEntity entity) {
//        String string = entity.getBlockState().getBlock().getName().getString();
//        return new ResourceLocation(TerraFabriCraft.MODID, "textures/block/wood/keg/"+string.substring(string.lastIndexOf(".")+1)+".png");
//    }
//}

//package malek.terrafabricraft.client.renderer.block;
//
//import com.mojang.blaze3d.vertex.PoseStack;
//import com.mojang.blaze3d.vertex.VertexConsumer;
//import malek.terrafabricraft.client.model.block.KegModel;
//import malek.terrafabricraft.common.block.keg.TFCKegEntity;
//import net.minecraft.client.renderer.MultiBufferSource;
//import net.minecraft.client.renderer.RenderType;
//import net.minecraft.resources.ResourceLocation;
//import software.bernie.geckolib3.renderers.geo.GeoBlockRenderer;
//
//public class KegRenderer extends GeoBlockRenderer<TFCKegEntity> {
//    public KegRenderer() {
//        super(new KegModel());
//    }
//
//    @Override
//    public RenderType getRenderType(TFCKegEntity animatable, float partialTicks, PoseStack stack, MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn, ResourceLocation textureLocation) {
//        return RenderType.entityTranslucent(getTextureLocation(animatable));
//    }
//}

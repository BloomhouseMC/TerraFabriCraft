package malek.terrafabricraft.client.renderer.block;

import malek.terrafabricraft.client.model.block.KegModel;
import malek.terrafabricraft.common.block.keg.TFCKegEntity;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.renderers.geo.GeoBlockRenderer;

public class KegRenderer extends GeoBlockRenderer<TFCKegEntity> {
    public KegRenderer() {
        super(new KegModel());
    }

    @Override
    public RenderLayer getRenderType(TFCKegEntity animatable, float partialTicks, MatrixStack stack, VertexConsumerProvider renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn, Identifier textureLocation) {
        return RenderLayer.getEntityTranslucent(getTextureLocation(animatable));
    }
}

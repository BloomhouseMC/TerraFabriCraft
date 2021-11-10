package io.github.bloomhousemc.terrafabricraft.client.renderer.block;

import io.github.bloomhousemc.terrafabricraft.client.model.block.BellowsBlockModel;
import io.github.bloomhousemc.terrafabricraft.common.block.bellows.BellowsBlockEntity;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.renderers.geo.GeoBlockRenderer;

public class BellowsRenderer extends GeoBlockRenderer<BellowsBlockEntity> {
    public BellowsRenderer() {
        super(new BellowsBlockModel());
    }

    @Override
    public RenderLayer getRenderType(BellowsBlockEntity animatable, float partialTicks, MatrixStack stack, VertexConsumerProvider renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn, Identifier textureLocation) {
        return RenderLayer.getEntityTranslucent(getTextureLocation(animatable));
    }
}

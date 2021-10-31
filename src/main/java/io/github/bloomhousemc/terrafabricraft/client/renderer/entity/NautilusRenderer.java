package io.github.bloomhousemc.terrafabricraft.client.renderer.entity;

import io.github.bloomhousemc.terrafabricraft.client.model.entity.NautilusEntityModel;
import io.github.bloomhousemc.terrafabricraft.common.entity.NautilusEntity;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class NautilusRenderer extends GeoEntityRenderer<NautilusEntity> {
    public NautilusRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new NautilusEntityModel());
    }

    @Override
    public RenderLayer getRenderType(NautilusEntity animatable, float partialTicks, MatrixStack stack, @Nullable VertexConsumerProvider renderTypeBuffer, @Nullable VertexConsumer vertexBuilder, int packedLightIn, Identifier textureLocation) {
        return RenderLayer.getEntityTranslucent(this.getTextureLocation(animatable));
    }

}
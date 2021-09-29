package malek.terrafabricraft.client.renderer.block;

import malek.terrafabricraft.client.model.block.KegModel;
import malek.terrafabricraft.common.block.keg.TFCKeg;
import malek.terrafabricraft.common.block.keg.TFCKegEntity;
import malek.terrafabricraft.common.registry.TFCParticleTypes;
import malek.terrafabricraft.common.registry.TFCProperties;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.texture.Sprite;
import net.minecraft.client.util.SpriteIdentifier;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Matrix4f;
import net.minecraft.world.World;
import software.bernie.geckolib3.renderers.geo.GeoBlockRenderer;

import static net.minecraft.client.texture.SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE;

public class KegRenderer extends GeoBlockRenderer<TFCKegEntity> {
    public KegRenderer() {
        super(new KegModel());
    }
    private static final float[] HEIGHT = {0, 0.55f, 0.65f, 0.85f};
    public static final SpriteIdentifier KEG_WATER = new SpriteIdentifier(BLOCK_ATLAS_TEXTURE, new Identifier("block/water_still"));

    @Override
    public RenderLayer getRenderType(TFCKegEntity animatable, float partialTicks, MatrixStack stack, VertexConsumerProvider renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn, Identifier textureLocation) {
        return RenderLayer.getEntityTranslucent(getTextureLocation(animatable));
    }

    @Override
    public void render(TFCKegEntity entity, float partialTicks, MatrixStack matrixStack, VertexConsumerProvider vertexConsumers, int light) {
        super.render(entity, partialTicks, matrixStack, vertexConsumers, light);
        World world = entity.getWorld();
        if (world != null) {
            BlockPos pos = entity.getPos();
            int level = entity.getCachedState().get(TFCProperties.LEVEL);
            if (level > 0) {
                matrixStack.push();
                matrixStack.translate(0, HEIGHT[level], 0);
                renderWater(entity, matrixStack, vertexConsumers.getBuffer(RenderLayer.getTranslucent()), light, KEG_WATER.getSprite());
                matrixStack.pop();
                if (!MinecraftClient.getInstance().isPaused()) {
                    float fluidHeight = 0;
                    float width = 0.45f;
                    switch (entity.getCachedState().get(TFCProperties.LEVEL)) {
                        case 1 -> fluidHeight = 0.55f;
                        case 2 -> fluidHeight = 0.65f;
                        case 3 -> fluidHeight = 0.85f;
                    }
                    if (fluidHeight > 0 && entity.getCachedState().get(TFCKeg.WORKING)) {
                        world.addParticle((ParticleEffect) TFCParticleTypes.KEG_BUBBLE, pos.getX() + 0.5 + MathHelper.nextDouble(world.random, -width, width), pos.getY() + fluidHeight, pos.getZ() + 0.5 + MathHelper.nextDouble(world.random, -width, width), ((entity.color >> 16) & 0xff) / 255f, ((entity.color >> 8) & 0xff) / 255f, (entity.color & 0xff) / 255f);
                    }
                }
            }
        }
    }

    private void renderWater(TFCKegEntity entity, MatrixStack matrices, VertexConsumer buffer, int light, Sprite sprite) {
        matrices.push();
        Matrix4f mat = matrices.peek().getModel();
        float sizeFactor = 0.125f;
        float maxV = (sprite.getMaxV() - sprite.getMinV()) * sizeFactor;
        float minV = (sprite.getMaxV() - sprite.getMinV()) * (1 - sizeFactor);
        int red = (entity.color >> 16) & 0xff;
        int green = (entity.color >> 8) & 0xff;
        int blue = entity.color & 0xff;
        buffer.vertex(mat, sizeFactor, 0, 1 - sizeFactor).color(red, green, blue, 255).texture(sprite.getMinU(), sprite.getMinV() + maxV).light(light).normal(1, 1, 1).next();
        buffer.vertex(mat, 1 - sizeFactor, 0, 1 - sizeFactor).color(red, green, blue, 255).texture(sprite.getMaxU(), sprite.getMinV() + maxV).light(light).normal(1, 1, 1).next();
        buffer.vertex(mat, 1 - sizeFactor, 0, sizeFactor).color(red, green, blue, 255).texture(sprite.getMaxU(), sprite.getMinV() + minV).light(light).normal(1, 1, 1).next();
        buffer.vertex(mat, sizeFactor, 0, sizeFactor).color(red, green, blue, 255).texture(sprite.getMinU(), sprite.getMinV() + minV).light(light).normal(1, 1, 1).next();
        matrices.pop();
    }

}

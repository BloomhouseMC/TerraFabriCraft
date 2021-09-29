package malek.terrafabricraft.mixin.client;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.block.Block;
import net.minecraft.block.StainedGlassPaneBlock;
import net.minecraft.block.TransparentBlock;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.*;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.texture.SpriteAtlasTexture;
import net.minecraft.client.texture.TextureManager;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static malek.terrafabricraft.common.temperature.ItemTemperature.getTemperature;
import static malek.terrafabricraft.mixin.client.RenderLayerAccessor.*;

@Mixin(ItemRenderer.class)
public class ItemRendererMixin {
    private static RenderLayer GLINT;

    static {
        GLINT = RenderLayer.of("glint", VertexFormats.POSITION_COLOR_TEXTURE, VertexFormat.DrawMode.QUADS, 262144, RenderLayer.MultiPhaseParameters.builder().shader(GLINT_SHADER()).texture(new RenderPhase.Texture(ItemRenderer.ENCHANTED_ITEM_GLINT, true, false)).writeMaskState(COLOR_MASK()).cull(DISABLE_CULLING()).depthTest(EQUAL_DEPTH_TEST()).transparency(GLINT_TRANSPARENCY()).texturing(GLINT_TEXTURING()).build(false));

    }
    @Shadow
    private TextureManager textureManager;
    @Shadow
    private float zOffset;

    @Inject(method = "renderItem(Lnet/minecraft/item/ItemStack;Lnet/minecraft/client/render/model/json/ModelTransformation$Mode;ZLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;IILnet/minecraft/client/render/model/BakedModel;)V", at = @At("HEAD"), cancellable = true)
    public void renderItemMixin(ItemStack stack, ModelTransformation.Mode renderMode, boolean leftHanded, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay, BakedModel model, CallbackInfo ci) {
        if (!stack.isEmpty()) {
            if (stack.hasNbt()) {
                if (getTemperature(stack) != 0) {
                    if (!stack.isEmpty()) {
                        matrices.push();
                        this.textureManager.getTexture(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE).setFilter(false, false);
//                        RenderSystem.setShaderTexture(0, SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE);
//                        RenderSystem.enableBlend();
//                        RenderSystem.blendFunc(GlStateManager.SrcFactor.SRC_ALPHA, GlStateManager.DstFactor.ONE_MINUS_SRC_ALPHA);
//                        RenderSystem.setShaderColor(0.5F, 1.0F, 1.0F, 1.0F);
                        boolean bl = renderMode == ModelTransformation.Mode.GUI || renderMode == ModelTransformation.Mode.GROUND || renderMode == ModelTransformation.Mode.FIXED;

                        model.getTransformation().getTransformation(renderMode).apply(leftHanded, matrices);
                        matrices.translate(-0.5D, -0.5D, -0.5D);
                        if (!model.isBuiltin() && (!stack.isOf(Items.TRIDENT) || bl)) {
                            boolean bl3;
                            if (renderMode != ModelTransformation.Mode.GUI && !renderMode.isFirstPerson() && stack.getItem() instanceof BlockItem) {
                                Block block = ((BlockItem) stack.getItem()).getBlock();
                                bl3 = !(block instanceof TransparentBlock) && !(block instanceof StainedGlassPaneBlock);
                            } else {
                                bl3 = true;
                            }

                            RenderLayer renderLayer = RenderLayers.getItemLayer(stack, bl3);
                            VertexConsumer vertexConsumer4;
                            MatrixStack.Entry entry = matrices.peek();
                            /*
                            if (renderMode == ModelTransformation.Mode.GUI) {
                                entry.getModel().multiply(0.5F);
                            } else if (renderMode.isFirstPerson()) {
                                entry.getModel().multiply(0.75F);
                            }

                             */
                            //VertexConsumer vertexConsumer2 = vertexConsumers.getBuffer(RenderLayer.getCutout());
                                //    vertexConsumer4 = VertexConsumers.union(new OverlayVertexConsumer(vertexConsumer2, entry.getModel(), entry.getNormal()), vertexConsumers.getBuffer(renderLayer));
                                    //vertexConsumer4.fixedColor(255, 0, 0, 255);
                           // vertexConsumer4.color(0, 1, 1, 1);
                            vertexConsumer4 = vertexConsumers.getBuffer(renderLayer).color(255, 255, 255, 255);

                            this.renderBakedItemModel(model, stack, light, overlay, matrices, vertexConsumer4);
                            matrices.pop();
                            ci.cancel();
                        }
                    }
                }
            }
        }
    }

    //@Overwrite
    /*
    public void renderGuiItemModel(ItemStack stack, int x, int y, BakedModel model) {
        this.textureManager.getTexture(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE).setFilter(false, false);
        RenderSystem.setShaderTexture(0, SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE);
        RenderSystem.enableBlend();
        RenderSystem.blendFunc(GlStateManager.SrcFactor.SRC_ALPHA, GlStateManager.DstFactor.ONE_MINUS_SRC_ALPHA);
        RenderSystem.setShaderColor(0.5F, 1.0F, 1.0F, 1.0F);
        MatrixStack matrixStack = RenderSystem.getModelViewStack();
        matrixStack.push();
        matrixStack.translate((double)x, (double)y, (double)(100.0F + this.zOffset));
        matrixStack.translate(8.0D, 8.0D, 0.0D);
        matrixStack.scale(1.0F, -1.0F, 1.0F);
        matrixStack.scale(16.0F, 16.0F, 16.0F);
        RenderSystem.applyModelViewMatrix();
        MatrixStack matrixStack2 = new MatrixStack();
        VertexConsumerProvider.Immediate immediate = MinecraftClient.getInstance().getBufferBuilders().getEntityVertexConsumers();
        boolean bl = !model.isSideLit();
        if (bl) {
            DiffuseLighting.disableGuiDepthLighting();
        }

        this.renderItem(stack, matrixStack2, immediate, model);
        immediate.draw();
        RenderSystem.enableDepthTest();
        if (bl) {
            DiffuseLighting.enableGuiDepthLighting();
        }

        matrixStack.pop();
        RenderSystem.applyModelViewMatrix();
    }
    @Shadow
    private void renderItem(ItemStack stack, MatrixStack matrixStack2, VertexConsumerProvider.Immediate immediate, BakedModel model) {
    }



     */
    @Shadow
    private void renderBakedItemModel(BakedModel model, ItemStack stack, int light, int overlay, MatrixStack matrices, VertexConsumer vertexConsumer4) {
    }
}
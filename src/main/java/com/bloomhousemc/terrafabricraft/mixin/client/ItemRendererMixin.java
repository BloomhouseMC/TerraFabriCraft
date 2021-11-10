package com.bloomhousemc.terrafabricraft.mixin.client;

import com.mojang.blaze3d.systems.RenderSystem;
import com.bloomhousemc.terrafabricraft.client.TextureTwo;
import com.bloomhousemc.terrafabricraft.common.item.MeltableItem;
import com.bloomhousemc.terrafabricraft.common.item.TFCFood;
import net.minecraft.block.Block;
import net.minecraft.block.StainedGlassPaneBlock;
import net.minecraft.block.TransparentBlock;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.color.item.ItemColors;
import net.minecraft.client.render.*;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.BakedQuad;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.texture.SpriteAtlasTexture;
import net.minecraft.client.texture.TextureManager;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Iterator;
import java.util.List;

import static com.bloomhousemc.terrafabricraft.client.CalendarClient.getMinuteHand;
import static com.bloomhousemc.terrafabricraft.common.temperature.ItemTemperature.getTemperature;
import static com.bloomhousemc.terrafabricraft.mixin.client.RenderLayerAccessor.*;
import static org.lwjgl.opengl.GL14.GL_FUNC_ADD;

@Mixin(ItemRenderer.class)
public class ItemRendererMixin {
    private static RenderLayer GLINT;
    private static TextureTwo textureTwo = new TextureTwo(ItemRenderer.ENCHANTED_ITEM_GLINT, true, false);

    static {
        GLINT = RenderLayer.of("my_glint", VertexFormats.POSITION_TEXTURE, VertexFormat.DrawMode.QUADS, 256, RenderLayer.MultiPhaseParameters.builder().shader(GLINT_SHADER()).texture(textureTwo).writeMaskState(COLOR_MASK()).cull(DISABLE_CULLING()).depthTest(EQUAL_DEPTH_TEST()).transparency(GLINT_TRANSPARENCY()).texturing(GLINT_TEXTURING()).build(false));
    }
    @Shadow
    private TextureManager textureManager;
    @Shadow
    private float zOffset;
    @Shadow
    @Final
    private ItemColors colors;

    /**
     * @author
     */
    @Overwrite
    private void renderBakedItemQuads(MatrixStack matrices, VertexConsumer vertices, List<BakedQuad> quads, ItemStack stack, int light, int overlay) {
        boolean bl = !stack.isEmpty();
        MatrixStack.Entry entry = matrices.peek();
        Iterator var9 = quads.iterator();
        while(var9.hasNext()) {
            BakedQuad bakedQuad = (BakedQuad)var9.next();
            int i = -1;
            if (bl && bakedQuad.hasColor()) {
                i = this.colors.getColor(stack, bakedQuad.getColorIndex());
            }

            float f = (float)(i >> 16 & 255) / 255.0F;
            float g = (float)(i >> 8 & 255) / 255.0F;
            float h = (float)(i & 255) / 255.0F;
            if (!stack.isEmpty()) {
                if (stack.hasNbt()) {
                    if(stack.getItem() instanceof TFCFood) {
                        int current = getMinuteHand() - stack.getOrCreateNbt().getInt("date_created");
                        int decayPercentage = current * 100 / 5;
                        if(decayPercentage > 100) {
                            decayPercentage = 100;
                        }
                        float decay = (float)decayPercentage/100.0f;
                        f = 1-decay;
                        h = 1-decay;
                        g = 1-(decay/30);
                        if(decay > 0.6) {
                            g = 1-(decay/2);
                        }
                    }
                    if (getTemperature(stack) != 0) {
                        float meltingPoint = 500;
                        if (stack.getItem() instanceof MeltableItem meltableItem) {
                            meltingPoint = meltableItem.getMeltingPoint();
                        }
                        float currentTemp = getTemperature(stack);
                        float red = 1f;
                        float green = 1f;
                        float blue = 1f;
                        if (currentTemp / meltingPoint < 0.5) {
                            green = 1f - currentTemp / meltingPoint;
                            blue = 1f - currentTemp / meltingPoint;
                        } else if (currentTemp / meltingPoint < 0.9f) {
                            green = currentTemp / meltingPoint - 1f;
                            blue = 1f - currentTemp / meltingPoint;
                        } else {
                            green = 1;
                            blue = 0;
                            red = 1;
                        }
                        f = red;
                        g = green;
                        h = blue;

                    }
                }
            }
            vertices.quad(entry, bakedQuad, f, g, h, light, overlay);

        }



    }
    private void rewriteBuffer(VertexConsumer vertexConsumer, int alpha) {
        if (vertexConsumer instanceof BufferBuilder bufferBuilder) {
            BufferBuilderAccessor bufferBuilderAccessor = ((BufferBuilderAccessor) bufferBuilder);

            int prevOffset = bufferBuilderAccessor.getElementOffset();

            if (prevOffset > 0) {
                int i = bufferBuilderAccessor.getVertexFormat().getVertexSize();

                for (int l = 1; l <= 4; l++) {
                    bufferBuilderAccessor.setElementOffset(prevOffset - i * l);
                    bufferBuilder.putByte(15, (byte) (alpha));
                }

                bufferBuilderAccessor.setElementOffset(prevOffset);
            }
        }
    }

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
//                            this.textureManager.getTexture(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE).setFilter(false, false);
//                            RenderSystem.setShaderTexture(0, SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE);
//                            RenderSystem.enableBlend();
//                            RenderSystem.blendFunc(GlStateManager.SrcFactor.SRC_ALPHA, GlStateManager.DstFactor.ONE_MINUS_SRC_ALPHA);
//                            RenderSystem.clearColor(0, 0, 0, 0);
//                            RenderSystem.setShaderColor(0F, 0F, 1.0F, 1.0F);
//                            RenderSystem.applyModelViewMatrix();

                         //   TerraFabriCraftClient.customLightmapTextureManager.enable();
                            VertexConsumer vertexConsumer2 = vertexConsumers.getBuffer(GLINT);
                             vertexConsumer2 = vertexConsumers.getBuffer(renderLayer);
                                   // vertexConsumer4 = VertexConsumers.union(new OverlayVertexConsumer(vertexConsumer2, entry.getModel(), entry.getNormal()), vertexConsumers.getBuffer(renderLayer));
                                    //vertexConsumer4.fixedColor(255, 0, 0, 255);
                           // vertexConsumer4.color(0, 1, 1, 1);
                            //vertexConsumer4 = vertexConsumers.getBuffer(renderLayer);

                            //TerraFabriCraftClient.customLightmapTextureManager.enable();
                            this.textureManager.getTexture(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE).setFilter(false, false);
                            RenderSystem.setShaderTexture(0, SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE);
                            RenderSystem.enableBlend();
                            RenderSystem.blendEquation(GL_FUNC_ADD);
                            RenderSystem.setShaderColor(0.5F, 1.0F, 1.0F, 1.0F);
//                            RenderSystem.blendFunc(GlStateManager.SrcFactor.SRC_ALPHA, GlStateManager.DstFactor.ONE_MINUS_SRC_ALPHA);
                            this.renderBakedItemModel(model, stack, light, overlay, matrices, vertexConsumer2);
                            RenderSystem.applyModelViewMatrix();
                            MatrixStack matrixStack2 = new MatrixStack();
                            VertexConsumerProvider.Immediate immediate = MinecraftClient.getInstance().getBufferBuilders().getEntityVertexConsumers();
                            immediate.draw();
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
package malek.terrafabricraft.mixin.client;

import net.minecraft.block.Block;
import net.minecraft.block.StainedGlassPaneBlock;
import net.minecraft.block.TransparentBlock;
import net.minecraft.client.render.*;
import net.minecraft.client.render.item.BuiltinModelItemRenderer;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.util.ModelIdentifier;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static malek.terrafabricraft.common.temperature.ItemTemperature.getTemperature;

@Mixin(ItemRenderer.class)
public class ItemRendererMixin {
    /**
     * @author - MalekiRe
     */
    @Shadow
    @Final
   static RenderPhase.WriteMaskState COLOR_SHADER;
    @Shadow
    @Final
    static RenderPhase.Shader GLINT_SHADER;

    private static RenderLayer GLINT;

    @Shadow
    @Final
    static RenderPhase.Cull DISABLE_CULLING;

    @Shadow
    @Final
    static RenderPhase.DepthTest EQUAL_DEPTH_TEST;

    @Shadow
    @Final
    static RenderPhase.Transparency GLINT_TRANSPARENCY;

    @Shadow
    @Final
    static RenderPhase.Texturing GLINT_TEXTURING;

    static {
            GLINT = RenderLayer.of("glint",VertexFormats.POSITION_TEXTURE, VertexFormat.DrawMode.QUADS, 256,RenderLayer.MultiPhaseParameters.builder().shader(GLINT_SHADER).texture(new RenderPhase.Texture(ItemRenderer.ENCHANTED_ITEM_GLINT, true, false)).writeMaskState(COLOR_SHADER).cull(DISABLE_CULLING).depthTest(EQUAL_DEPTH_TEST).transparency(GLINT_TRANSPARENCY).texturing(GLINT_TEXTURING).build(false));

    }
    @Inject(method = "renderItem(Lnet/minecraft/item/ItemStack;Lnet/minecraft/client/render/model/json/ModelTransformation$Mode;ZLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;IILnet/minecraft/client/render/model/BakedModel;)V", at = @At("HEAD"), cancellable = true)
    public void renderItemMixin(ItemStack stack, ModelTransformation.Mode renderMode, boolean leftHanded, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay, BakedModel model, CallbackInfo ci) {
        if(!stack.isEmpty()) {
            if(stack.hasNbt()) {
                if(getTemperature(stack) != 0) {

                }
            }
        }
    }
}

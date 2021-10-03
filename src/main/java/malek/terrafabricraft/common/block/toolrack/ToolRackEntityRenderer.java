package malek.terrafabricraft.common.block.toolrack;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3f;

@Environment(EnvType.CLIENT)
public class ToolRackEntityRenderer implements BlockEntityRenderer<ToolRackBlockEntity> {
    @Override
    public void render(ToolRackBlockEntity entity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        Direction direction = entity.getCachedState().get(Properties.HORIZONTAL_FACING);
        float rotation = -direction.asRotation();
        matrices.translate(0.5f, 0, 0.5f);
        matrices.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(rotation));
        matrices.scale(1 / 3f, 1 / 3f, 1 / 3f);
        renderRow(entity.inventory.get(0), entity.inventory.get(1), 0.67f, matrices, vertexConsumers, light, overlay);
        renderRow(entity.inventory.get(2), entity.inventory.get(3), 0.33f, matrices, vertexConsumers, light, overlay);
    }

    private static void renderRow(ItemStack one, ItemStack two, float yOffset, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        matrices.push();
        double xOffset = 0.33 * 4;
        double zOffset = - 0.33 * 2.6;
        yOffset *= 4;
        matrices.translate(-0.66, yOffset - 0.2, zOffset);
        MinecraftClient.getInstance().getItemRenderer().renderItem(two, ModelTransformation.Mode.FIXED, light, overlay, matrices, vertexConsumers, 0);
        matrices.translate(xOffset, 0, 0);
        MinecraftClient.getInstance().getItemRenderer().renderItem(one, ModelTransformation.Mode.FIXED, light, overlay, matrices, vertexConsumers, 0);
        matrices.pop();
    }
/*
    @Override
    public void render(ToolRackBlockEntity blockEntity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {

 */
        /*
        World world = blockEntity.getWorld();
        if(world == null || blockEntity.isEmpty()) return;

        BlockState state = world.getBlockState(blockEntity.getPos());
        if(!(state.getBlock() instanceof ToolRackBlock)) return;


        ItemStack itemStack0 = blockEntity.getStack(0);
        if(itemStack0.isEmpty()) {
            blockEntity.markDirty();
        }
        matrices.push();
        MinecraftClient minecraft = MinecraftClient.getInstance();
        BakedModel model = minecraft.getItemRenderer().getHeldItemModel(itemStack0, world, null, 0);
        Vec3f translate = model.getTransformation().ground.translation;
        ToolRackBlock toolRackBlock = (ToolRackBlock) state.getBlock();
        matrices.translate(translate.getX() + 0.5, translate.getY(), translate.getZ() + 0.5);
        minecraft.getItemRenderer().renderItem(itemStack0, ModelTransformation.Mode.NONE, light, overlay,matrices,vertexConsumers,0);
        matrices.pop();

         */

/*
        int lightAbove = WorldRenderer.getLightmapCoordinates(blockEntity.getWorld(), blockEntity.getPos().up());


        MinecraftClient.getInstance().getItemRenderer().renderItem(stack, ModelTransformation.Mode.GROUND, lightAbove, OverlayTexture.DEFAULT_UV, matrices, vertexConsumers, 0);

        ItemStack upperRight = blockEntity.getStack(0);
        matrices.translate(0.25, 0.75, 0.75);
        if(!upperRight.isEmpty()){
            MinecraftClient.getInstance().getItemRenderer().renderItem(upperRight, ModelTransformation.Mode.NONE, lightAbove, overlay, matrices, vertexConsumers, 0);
            System.out.println(upperRight);
        }
        matrices.pop();
        matrices.push();
        ItemStack upperLeft = blockEntity.getStack(2);
        matrices.translate(0.75, 0.75, 0.75);
        MinecraftClient.getInstance().getItemRenderer().renderItem(upperLeft, ModelTransformation.Mode.FIXED, lightAbove, overlay, matrices, vertexConsumers, 0);
        matrices.pop();
        matrices.push();
        ItemStack lowerRight = blockEntity.getStack(1);
        matrices.translate(0.25, 0.25, 0.75);
        MinecraftClient.getInstance().getItemRenderer().renderItem(lowerRight, ModelTransformation.Mode.FIXED, lightAbove, overlay, matrices, vertexConsumers, 0);
        matrices.pop();
        matrices.push();
        ItemStack lowerLeft = blockEntity.getStack(3);
        matrices.translate(0.75, 0.25, 0.75);
        BakedModel bakedModel = this.itemRenderer.getHeldItemModel(lowerLeft, blockEntity.getWorld(), null, 0);
        //MinecraftClient.getInstance().getItemRenderer().renderItem(lowerLeft, ModelTransformation.Mode.FIXED, lightAbove, overlay, matrices, vertexConsumers, 0);
        this.itemRenderer.renderItem(lowerLeft, ModelTransformation.Mode.GROUND, false, matrices, vertexConsumers, light, OverlayTexture.DEFAULT_UV, bakedModel);

        matrices.pop();

 */

}


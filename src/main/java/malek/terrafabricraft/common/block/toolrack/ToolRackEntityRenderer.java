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
}


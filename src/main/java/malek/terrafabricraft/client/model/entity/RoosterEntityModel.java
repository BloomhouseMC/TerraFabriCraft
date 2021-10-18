package malek.terrafabricraft.client.model.entity;// Made with Blockbench 4.0.0-beta.3
// Exported for Minecraft version 1.17 with Mojang mappings
// Paste this class into your mod and generate all required imports


import malek.terrafabricraft.TerraFabriCraft;
import malek.terrafabricraft.common.entity.RoosterEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class RoosterEntityModel extends EntityModel<RoosterEntity> {
	//This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final EntityModelLayer LAYER_LOCATION = new EntityModelLayer(new Identifier(TerraFabriCraft.MODID, "entity_animal_rooster"), "main");
	private final ModelPart bb_main;

	public RoosterEntityModel(ModelPart root) {
		this.bb_main = root.getChild("bb_main");
	}

	public static TexturedModelData getTexturedModelData() {
		var meshDefinition = new ModelData();
		var partDefinition = meshDefinition.getRoot();

		var bb_main = partDefinition.addChild("bb_main", ModelPartBuilder.create().uv(0, 0).cuboid(-2.0F, -17.0F, -3.0F, 4.0F, 6.0F, 3.0F, new Dilation(0.0F))
		.uv(14, 0).cuboid(-2.0F, -15.0F, -5.0F, 4.0F, 2.0F, 2.0F, new Dilation(0.0F))
		.uv(0, 23).cuboid(0.0F, -21.0F, -4.0F, 0.0F, 4.0F, 5.0F, new Dilation(0.0F))
		.uv(0, 9).cuboid(-3.0F, -13.0F, -1.0F, 6.0F, 8.0F, 6.0F, new Dilation(0.0F))
		.uv(36, 0).cuboid(-2.0F, -8.0F, 2.0F, 1.0F, 8.0F, 0.0F, new Dilation(0.0F))
		.uv(36, 3).cuboid(1.0F, -5.0F, 2.0F, 1.0F, 5.0F, 0.0F, new Dilation(0.0F))
		.uv(29, 0).cuboid(0.0F, 0.0F, -1.0F, 3.0F, 0.0F, 3.0F, new Dilation(0.0F))
		.uv(29, 0).cuboid(-3.0F, 0.0F, -1.0F, 3.0F, 0.0F, 3.0F, new Dilation(0.0F))
		.uv(24, 13).cuboid(-1.0F, -10.0F, 4.0F, 2.0F, 4.0F, 6.0F, new Dilation(0.0F))
		.uv(14, 4).cuboid(-2.0F, -11.0F, -3.0F, 4.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		var cube_r1 = bb_main.addChild("cube_r1", ModelPartBuilder.create().uv(45, -4).cuboid(-3.0F, -27.0F, 9.0F, 1.0F, 22.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(3.0F, -12.0F, -6.0F, -0.9163F, 0.0F, 0.0F));

		var cube_r2 = bb_main.addChild("cube_r2", ModelPartBuilder.create().uv(45, -4).cuboid(-3.0F, -30.0F, 6.0F, 1.0F, 22.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(3.0F, -12.0F, -6.0F, -1.1781F, 0.0F, 0.0F));

		var cube_r3 = bb_main.addChild("cube_r3", ModelPartBuilder.create().uv(45, -4).cuboid(-3.0F, -20.0F, 11.0F, 1.0F, 22.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(3.0F, -12.0F, -6.0F, -0.3054F, 0.0F, 0.0F));

		var cube_r4 = bb_main.addChild("cube_r4", ModelPartBuilder.create().uv(45, -4).cuboid(-3.0F, -24.0F, 11.0F, 1.0F, 22.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(3.0F, -12.0F, -6.0F, -0.6545F, 0.0F, 0.0F));

		var cube_r5 = bb_main.addChild("cube_r5", ModelPartBuilder.create().uv(45, -4).cuboid(-3.0F, -22.0F, 11.0F, 1.0F, 22.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(3.0F, -12.0F, -6.0F, -0.48F, 0.0F, 0.0F));

		return TexturedModelData.of(meshDefinition, 64, 32);
	}

	@Override
	public void setAngles(RoosterEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void render(MatrixStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		bb_main.render(poseStack, buffer, packedLight, packedOverlay);
	}
}
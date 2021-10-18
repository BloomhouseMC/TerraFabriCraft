package malek.terrafabricraft.client.model.entity;

import malek.terrafabricraft.common.entity.CrabEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;

public class CrabEntityModel extends EntityModel<CrabEntity> {
	private final ModelPart body;
	private final ModelPart left_claw;
	private final ModelPart dactyl_r1;
	private final ModelPart dactyl_r2;
	private final ModelPart propodus_r1;
	private final ModelPart carpus_r1;
	private final ModelPart right_claw;
	private final ModelPart dactyl_r3;
	private final ModelPart dactyl_r4;
	private final ModelPart propodus_r2;
	private final ModelPart carpus_r2;
	private final ModelPart right_walking_legs;
	private final ModelPart cube_r1;
	private final ModelPart cube_r2;
	private final ModelPart cube_r3;
	private final ModelPart cube_r4;
	private final ModelPart cube_r5;
	private final ModelPart right_swimming_legs;
	private final ModelPart left_walking_legs;
	private final ModelPart cube_r6;
	private final ModelPart cube_r7;
	private final ModelPart cube_r8;
	private final ModelPart cube_r9;
	private final ModelPart cube_r10;
	private final ModelPart left_swimming_legs;

	public CrabEntityModel(ModelPart root) {
		this.body = root.getChild("body");
		this.left_claw = root.getChild("left_claw");
		this.right_claw = this.left_claw.getChild("right_claw");
		this.carpus_r2 = this.right_claw.getChild("carpus_r2");
		this.propodus_r2 = this.right_claw.getChild("propodus_r2");
		this.dactyl_r4 = this.right_claw.getChild("dactyl_r4");
		this.dactyl_r3 = this.right_claw.getChild("dactyl_r3");
		this.carpus_r1 = this.left_claw.getChild("carpus_r1");
		this.propodus_r1 = this.left_claw.getChild("propodus_r1");
		this.dactyl_r2 = this.left_claw.getChild("dactyl_r2");
		this.dactyl_r1 = this.left_claw.getChild("dactyl_r1");
		this.right_walking_legs = root.getChild("right_walking_legs");
		this.cube_r5 = this.right_walking_legs.getChild("cube_r5");
		this.cube_r4 = this.right_walking_legs.getChild("cube_r4");
		this.cube_r3 = this.right_walking_legs.getChild("cube_r3");
		this.cube_r2 = this.right_walking_legs.getChild("cube_r2");
		this.cube_r1 = this.right_walking_legs.getChild("cube_r1");
		this.right_swimming_legs = root.getChild("right_swimming_legs");
		this.left_walking_legs = root.getChild("left_walking_legs");
		this.cube_r10 = this.left_walking_legs.getChild("cube_r10");
		this.cube_r9 = this.left_walking_legs.getChild("cube_r9");
		this.cube_r8 = this.left_walking_legs.getChild("cube_r8");
		this.cube_r7 = this.left_walking_legs.getChild("cube_r7");
		this.cube_r6 = this.left_walking_legs.getChild("cube_r6");
		this.left_swimming_legs = root.getChild("left_swimming_legs");
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		modelPartData.addChild("body", ModelPartBuilder.create().uv(0,0).cuboid(-4.0F, 1.0F, -5.0F, 8.0F, 2.0F, 7.0F).uv(0,9).cuboid(-3.0F, 3.0F, -4.0F, 6.0F, 1.0F, 5.0F).uv(0,15).cuboid(-2.0F, 0.0F, -5.0F, 4.0F, 1.0F, 6.0F), ModelTransform.pivot(0.0F,18.0F,0.0F));
		ModelPartData modelPartData1 = modelPartData.addChild("left_claw", ModelPartBuilder.create().uv(18,20).cuboid(-2.0F, -5.0F, -7.0F, 4.0F, 0.0F, 2.0F), ModelTransform.pivot(0.0F,24.0F,0.0F));
		modelPartData1.addChild("dactyl_r1", ModelPartBuilder.create().uv(0,0).cuboid(-2.75F, -4.5F, -10.75F, 2.0F, 2.0F, 1.0F), ModelTransform.pivot(0.0F,0.0F,0.0F));
		modelPartData1.addChild("dactyl_r2", ModelPartBuilder.create().uv(0,18).cuboid(-1.75F, -4.5F, -9.5F, 2.0F, 2.0F, 1.0F), ModelTransform.pivot(0.0F,0.0F,0.0F));
		modelPartData1.addChild("propodus_r1", ModelPartBuilder.create().uv(10,22).cuboid(-6.0F, -4.0F, 7.0F, 3.0F, 1.0F, 2.0F), ModelTransform.pivot(0.0F,0.0F,0.0F));
		modelPartData1.addChild("carpus_r1", ModelPartBuilder.create().uv(14,17).cuboid(-9.0F, -4.0F, -2.0F, 4.0F, 1.0F, 2.0F), ModelTransform.pivot(0.0F,0.0F,0.0F));
		ModelPartData modelPartData2 = modelPartData1.addChild("right_claw", ModelPartBuilder.create(), ModelTransform.pivot(0.0F,0.0F,0.0F));
		modelPartData2.addChild("dactyl_r3", ModelPartBuilder.create().uv(0,3).cuboid(-0.25F, -4.5F, -9.5F, 2.0F, 2.0F, 1.0F), ModelTransform.pivot(0.0F,0.0F,0.0F));
		modelPartData2.addChild("dactyl_r4", ModelPartBuilder.create().uv(0,15).cuboid(0.75F, -4.5F, -10.75F, 2.0F, 2.0F, 1.0F), ModelTransform.pivot(0.0F,0.0F,0.0F));
		modelPartData2.addChild("propodus_r2", ModelPartBuilder.create().uv(0,22).cuboid(3.0F, -4.0F, 7.0F, 3.0F, 1.0F, 2.0F), ModelTransform.pivot(0.0F,0.0F,0.0F));
		modelPartData2.addChild("carpus_r2", ModelPartBuilder.create().uv(17,11).cuboid(5.0F, -4.0F, -2.0F, 4.0F, 1.0F, 2.0F), ModelTransform.pivot(0.0F,0.0F,0.0F));
		ModelPartData modelPartData3 = modelPartData.addChild("right_walking_legs", ModelPartBuilder.create(), ModelTransform.pivot(0.0F,17.5F,-1.0F));
		modelPartData3.addChild("cube_r1", ModelPartBuilder.create().uv(8,25).cuboid(2.0F, -4.5F, -1.0F, 3.0F, 1.0F, 1.0F), ModelTransform.pivot(0.0F,6.5F,1.0F));
		modelPartData3.addChild("cube_r2", ModelPartBuilder.create().uv(23,4).cuboid(3.25F, -5.25F, -3.0F, 4.0F, 1.0F, 1.0F), ModelTransform.pivot(0.0F,6.5F,1.0F));
		modelPartData3.addChild("cube_r3", ModelPartBuilder.create().uv(17,9).cuboid(4.0F, 1.5F, -1.0F, 6.0F, 1.0F, 1.0F), ModelTransform.pivot(0.0F,0.0F,0.0F));
		modelPartData3.addChild("cube_r4", ModelPartBuilder.create().uv(19,24).cuboid(4.0F, 1.0F, -1.0F, 4.0F, 1.0F, 1.0F), ModelTransform.pivot(0.0F,0.0F,0.0F));
		modelPartData3.addChild("cube_r5", ModelPartBuilder.create().uv(24,17).cuboid(7.0F, 1.0F, 3.0F, 4.0F, 1.0F, 1.0F), ModelTransform.pivot(0.0F,0.0F,0.0F));
		modelPartData.addChild("right_swimming_legs", ModelPartBuilder.create(), ModelTransform.pivot(0.0F,24.0F,0.0F));
		ModelPartData modelPartData4 = modelPartData.addChild("left_walking_legs", ModelPartBuilder.create(), ModelTransform.pivot(0.0F,24.0F,0.0F));
		modelPartData4.addChild("cube_r6", ModelPartBuilder.create().uv(0,25).cuboid(-5.0F, -4.5F, -1.0F, 3.0F, 1.0F, 1.0F), ModelTransform.pivot(0.0F,0.0F,0.0F));
		modelPartData4.addChild("cube_r7", ModelPartBuilder.create().uv(23,2).cuboid(-7.25F, -5.25F, -3.0F, 4.0F, 1.0F, 1.0F), ModelTransform.pivot(0.0F,0.0F,0.0F));
		modelPartData4.addChild("cube_r8", ModelPartBuilder.create().uv(23,0).cuboid(-8.0F, 1.0F, -1.0F, 4.0F, 1.0F, 1.0F), ModelTransform.pivot(0.0F,-6.5F,-1.0F));
		modelPartData4.addChild("cube_r9", ModelPartBuilder.create().uv(18,22).cuboid(-11.0F, 1.0F, 3.0F, 4.0F, 1.0F, 1.0F), ModelTransform.pivot(0.0F,-6.5F,-1.0F));
		modelPartData4.addChild("cube_r10", ModelPartBuilder.create().uv(14,15).cuboid(-10.0F, 1.5F, -1.0F, 6.0F, 1.0F, 1.0F), ModelTransform.pivot(0.0F,-6.5F,-1.0F));
		modelPartData.addChild("left_swimming_legs", ModelPartBuilder.create(), ModelTransform.pivot(0.0F,24.0F,0.0F));
		return TexturedModelData.of(modelData,64,64);
	}

	@Override
	public void setAngles(CrabEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		setRotationAngle(dactyl_r1, 0.0F, -0.5236F, 0.0F);
		setRotationAngle(dactyl_r2, 0.0F, 0.2618F, 0.0F);
		setRotationAngle(propodus_r1, -3.1416F, -1.0472F, 3.1416F);
		setRotationAngle(carpus_r1, 0.0F, -0.7854F, 0.0F);

		setRotationAngle(dactyl_r3, 0.0F, -0.2618F, 0.0F);
		setRotationAngle(dactyl_r4, 0.0F, 0.5236F, 0.0F);
		setRotationAngle(propodus_r2, -3.1416F, 1.0472F, -3.1416F);
		setRotationAngle(carpus_r2, 0.0F, 0.7854F, 0.0F);

		setRotationAngle(cube_r1, 0.0F, -0.3054F, 0.3491F);
		setRotationAngle(cube_r2, -0.1745F, -0.7361F, 0.6038F);
		setRotationAngle(cube_r3, 0.0F, 0.0F, 0.4363F);
		setRotationAngle(cube_r4, 0.0F, 0.3927F, 0.48F);
		setRotationAngle(cube_r5, 0.0F, 0.9163F, 0.48F);


		setRotationAngle(cube_r6, 0.0F, 0.3054F, -0.3491F);
		setRotationAngle(cube_r7, -0.1745F, 0.7361F, -0.6038F);
		setRotationAngle(cube_r8, 0.0F, -0.3927F, -0.48F);
		setRotationAngle(cube_r9, 0.0F, -0.9163F, -0.48F);
		setRotationAngle(cube_r10, 0.0F, 0.0F, -0.4363F);
	}

	@Override
	public void render(MatrixStack matrixStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		body.render(matrixStack, buffer, packedLight, packedOverlay);
		left_claw.render(matrixStack, buffer, packedLight, packedOverlay);
		right_walking_legs.render(matrixStack, buffer, packedLight, packedOverlay);
		right_swimming_legs.render(matrixStack, buffer, packedLight, packedOverlay);
		left_walking_legs.render(matrixStack, buffer, packedLight, packedOverlay);
		left_swimming_legs.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelPart bone, float x, float y, float z) {
		bone.pitch = x;
		bone.yaw = y;
		bone.roll = z;
	}
}
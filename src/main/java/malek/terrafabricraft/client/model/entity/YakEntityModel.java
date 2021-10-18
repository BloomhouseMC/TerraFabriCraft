package malek.terrafabricraft.client.model.entity;

import malek.terrafabricraft.common.entity.YakEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;

public class YakEntityModel extends EntityModel<YakEntity> {
	private final ModelPart body;
	private final ModelPart head;
	private final ModelPart horns;
	private final ModelPart legs;
	private final ModelPart back_legs;
	private final ModelPart front_legs;

	public YakEntityModel(ModelPart root) {
		this.body = root.getChild("body");
		this.head = root.getChild("head");
		this.horns = this.head.getChild("horns");
		this.legs = root.getChild("legs");
		this.front_legs = this.legs.getChild("front_legs");
		this.back_legs = this.legs.getChild("back_legs");
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		modelPartData.addChild("body", ModelPartBuilder.create().uv(0,6).cuboid(-12.0F, -43.0F, -25.0F, 24.0F, 29.0F, 53.0F).uv(0,53).cuboid(-12.0F, -14.0F, -25.0F, 24.0F, 5.0F, 53.0F), ModelTransform.pivot(0.0F,24.0F,0.0F));
		ModelPartData modelPartData1 = modelPartData.addChild("head", ModelPartBuilder.create().uv(0,5).cuboid(-7.0F, -31.0F, -38.0F, 12.0F, 20.0F, 14.0F), ModelTransform.pivot(0.0F,28.0F,0.0F));
		modelPartData1.addChild("horns", ModelPartBuilder.create().uv(40,88).cuboid(-11.0F, -43.0F, -33.0F, 5.0F, 18.0F, 7.0F).uv(40,88).cuboid(4.0F, -43.0F, -33.0F, 5.0F, 18.0F, 7.0F), ModelTransform.pivot(0.0F,0.0F,-1.0F));
		ModelPartData modelPartData2 = modelPartData.addChild("legs", ModelPartBuilder.create(), ModelTransform.pivot(0.0F,24.0F,0.0F));
		modelPartData2.addChild("back_legs", ModelPartBuilder.create().uv(0,88).cuboid(-11.0F, -16.0F, 17.0F, 7.0F, 16.0F, 11.0F).uv(0,88).cuboid(3.0F, -16.0F, 17.0F, 7.0F, 16.0F, 11.0F), ModelTransform.pivot(0.0F,0.0F,-6.0F));
		modelPartData2.addChild("front_legs", ModelPartBuilder.create().uv(0,88).cuboid(-11.0F, -16.0F, -10.0F, 7.0F, 16.0F, 11.0F).uv(0,88).cuboid(3.0F, -16.0F, -10.0F, 7.0F, 16.0F, 11.0F), ModelTransform.pivot(0.0F,0.0F,-9.0F));
		return TexturedModelData.of(modelData,160,160);
	}

	@Override
	public void setAngles(YakEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch){
	/*	this.head.pitch = headPitch * 0.017453292F;
		this.head.yaw = headYaw * 0.017453292F;
		this.back_legs.pitch = MathHelper.cos(limbAngle * 0.6662F) * 1.4F * limbDistance;
		this.leftHindLeg.pitch = MathHelper.cos(limbAngle * 0.6662F + 3.1415927F) * 1.4F * limbDistance;
		this.front_legs.pitch = MathHelper.cos(limbAngle * 0.6662F + 3.1415927F) * 1.4F * limbDistance;
		this.leftFrontLeg.pitch = MathHelper.cos(limbAngle * 0.6662F) * 1.4F * limbDistance; */
	}

	@Override
	public void render(MatrixStack matrixStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		
		body.render(matrixStack, buffer, packedLight, packedOverlay);
		head.render(matrixStack, buffer, packedLight, packedOverlay);
		legs.render(matrixStack, buffer, packedLight, packedOverlay);
	}
}
package malek.terrafabricraft.client.model;// Made with Blockbench 4.0.0-beta.3
// Exported for Minecraft version 1.17 with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import malek.terrafabricraft.TerraFabriCraft;
import malek.terrafabricraft.common.entity.RoosterEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;

public class RoosterEntityModel extends EntityModel<RoosterEntity> {
	//This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(TerraFabriCraft.MODID, "entity_animal_rooster"), "main");
	private final ModelPart bb_main;

	public RoosterEntityModel(ModelPart root) {
		this.bb_main = root.getChild("bb_main");
	}

	public static LayerDefinition getTexturedModelData() {
		var meshDefinition = new MeshDefinition();
		var partDefinition = meshDefinition.getRoot();

		var bb_main = partDefinition.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -17.0F, -3.0F, 4.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(14, 0).addBox(-2.0F, -15.0F, -5.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 23).addBox(0.0F, -21.0F, -4.0F, 0.0F, 4.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(0, 9).addBox(-3.0F, -13.0F, -1.0F, 6.0F, 8.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(36, 0).addBox(-2.0F, -8.0F, 2.0F, 1.0F, 8.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(36, 3).addBox(1.0F, -5.0F, 2.0F, 1.0F, 5.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(29, 0).addBox(0.0F, 0.0F, -1.0F, 3.0F, 0.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(29, 0).addBox(-3.0F, 0.0F, -1.0F, 3.0F, 0.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(24, 13).addBox(-1.0F, -10.0F, 4.0F, 2.0F, 4.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(14, 4).addBox(-2.0F, -11.0F, -3.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		var cube_r1 = bb_main.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(45, -4).addBox(-3.0F, -27.0F, 9.0F, 1.0F, 22.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -12.0F, -6.0F, -0.9163F, 0.0F, 0.0F));

		var cube_r2 = bb_main.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(45, -4).addBox(-3.0F, -30.0F, 6.0F, 1.0F, 22.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -12.0F, -6.0F, -1.1781F, 0.0F, 0.0F));

		var cube_r3 = bb_main.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(45, -4).addBox(-3.0F, -20.0F, 11.0F, 1.0F, 22.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -12.0F, -6.0F, -0.3054F, 0.0F, 0.0F));

		var cube_r4 = bb_main.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(45, -4).addBox(-3.0F, -24.0F, 11.0F, 1.0F, 22.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -12.0F, -6.0F, -0.6545F, 0.0F, 0.0F));

		var cube_r5 = bb_main.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(45, -4).addBox(-3.0F, -22.0F, 11.0F, 1.0F, 22.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -12.0F, -6.0F, -0.48F, 0.0F, 0.0F));

		return LayerDefinition.create(meshDefinition, 64, 32);
	}

	@Override
	public void setupAnim(RoosterEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		bb_main.render(poseStack, buffer, packedLight, packedOverlay);
	}
}
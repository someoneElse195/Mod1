package net.juneclair.mod1.client.models;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.juneclair.mod1.Mod1;
import net.juneclair.mod1.entity.custom.jellyfish_entity;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;

public class JellyfishModel extends EntityModel<jellyfish_entity> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Mod1.MOD_ID, "jellyfish_entity"), "main");
	public final ModelPart body;

	public JellyfishModel(ModelPart root) {
		this.body = root.getChild("body");
	}

	public static LayerDefinition createBodyLayer() {
		var mesh = new MeshDefinition();
		PartDefinition parts = mesh.getRoot();
		PartDefinition body = parts.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, -11.0F));
		PartDefinition legs = body.addOrReplaceChild("legs", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition frontleft = legs.addOrReplaceChild("frontleft", CubeListBuilder.create(), PartPose.offset(-2.0969F, -10.5991F, 10.4726F));
		frontleft.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-2.673F, -0.8769F, -2.5271F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -3.1249F, 0.0F, -2.7486F));
		PartDefinition backleft = legs.addOrReplaceChild("backleft", CubeListBuilder.create(), PartPose.offset(-2.0969F, -10.5991F, 10.4726F));
		backleft.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 0).addBox(0.327F, 0.1231F, -2.5271F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -3.1249F, 0.0F, -2.7486F));
		PartDefinition backright = legs.addOrReplaceChild("backright", CubeListBuilder.create(), PartPose.offset(-2.0969F, -10.5991F, 10.4726F));
		backright.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(1, 0).addBox(0.327F, 0.1231F, 1.4729F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -3.1249F, 0.0F, -2.7486F));
		PartDefinition frontright = legs.addOrReplaceChild("frontright", CubeListBuilder.create(), PartPose.offset(-2.0969F, -10.5991F, 10.4726F));
		frontright.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-2.673F, -0.8769F, 1.4729F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -3.1249F, 0.0F, -2.7486F));
		PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
		head.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(4, 2).addBox(-2.9425F, -4.4009F, -2.5274F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0969F, -10.5991F, 10.4726F, -3.1416F, 0.0F, 3.1416F));
		return LayerDefinition.create(mesh, 24, 12);
	}

	@Override
	public void setupAnim(jellyfish_entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}
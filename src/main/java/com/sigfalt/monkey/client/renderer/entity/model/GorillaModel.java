package com.sigfalt.monkey.client.renderer.entity.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class GorillaModel<T extends Entity> extends EntityModel<T> {
	private final ModelRenderer bone;
	private final ModelRenderer cube_r1;
	private final ModelRenderer cube_r2;
	private final ModelRenderer cube_r3;
	private final ModelRenderer cube_r4;
	private final ModelRenderer cube_r5;
	private final ModelRenderer cube_r6;
	private final ModelRenderer cube_r7;
	private final ModelRenderer cube_r8;
	private final ModelRenderer cube_r9;

	public GorillaModel() {
		textureWidth = 64;
		textureHeight = 64;

		bone = new ModelRenderer(this);
		bone.setRotationPoint(0.0F, 24.0F, 0.0F);
		bone.setTextureOffset(37, 0).addBox(-6.7562F, -9.626F, -7.5103F, 4.8F, 7.2F, 3.9F, 0.0F, false);
		bone.setTextureOffset(35, 36).addBox(1.9071F, -9.626F, -7.5103F, 4.8F, 7.2F, 3.9F, 0.0F, false);
		bone.setTextureOffset(0, 40).addBox(1.9071F, -5.7756F, 7.8912F, 4.8F, 6.3F, 3.9F, 0.0F, false);
		bone.setTextureOffset(17, 39).addBox(-6.7562F, -5.7756F, 7.8912F, 4.8F, 6.3F, 3.9F, 0.0F, false);
		bone.setTextureOffset(46, 24).addBox(2.8697F, 0.0F, 5.966F, 2.9F, 1.4F, 3.9F, 0.0F, false);
		bone.setTextureOffset(48, 48).addBox(2.8697F, -0.5561F, -7.634F, 2.9F, 1.0F, 2.3F, 0.0F, false);
		bone.setTextureOffset(37, 16).addBox(-5.8059F, -0.5561F, -7.634F, 2.9F, 1.0F, 2.3F, 0.0F, false);
		bone.setTextureOffset(15, 29).addBox(-5.7936F, 0.0F, 5.966F, 2.9F, 1.4F, 3.9F, 0.0F, false);
		bone.setTextureOffset(20, 48).addBox(-5.7936F, -12.0325F, -7.5103F, 2.9F, 2.9F, 2.9F, 0.0F, false);
		bone.setTextureOffset(12, 48).addBox(2.8697F, -12.0325F, -7.5103F, 2.9F, 2.9F, 2.9F, 0.0F, false);
		bone.setTextureOffset(47, 44).addBox(2.8697F, -8.1821F, 7.8912F, 2.9F, 2.9F, 2.9F, 0.0F, false);
		bone.setTextureOffset(46, 34).addBox(-5.7936F, -8.1821F, 7.8912F, 2.9F, 2.9F, 2.9F, 0.0F, false);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(4.3136F, -2.4065F, -12.3233F);
		bone.addChild(cube_r1);
		setRotationAngle(cube_r1, -0.3927F, 0.0F, 0.0F);
		cube_r1.setTextureOffset(48, 10).addBox(-1.4439F, -3.3691F, 4.3317F, 2.0F, 3.0F, 1.0F, 0.0F, false);
		cube_r1.setTextureOffset(0, 49).addBox(-10.1073F, -3.3691F, 4.3317F, 2.0F, 3.0F, 1.0F, 0.0F, false);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setRotationPoint(0.4632F, -13.9576F, 12.2229F);
		bone.addChild(cube_r2);
		setRotationAngle(cube_r2, -0.3927F, 0.0F, 0.0F);
		cube_r2.setTextureOffset(0, 16).addBox(-6.2569F, -1.9252F, -4.813F, 11.0F, 5.0F, 8.0F, 0.0F, false);

		cube_r3 = new ModelRenderer(this);
		cube_r3.setRotationPoint(0.4632F, -21.6584F, -7.9916F);
		bone.addChild(cube_r3);
		setRotationAngle(cube_r3, 0.3927F, 0.0F, 0.0F);
		cube_r3.setTextureOffset(30, 16).addBox(-1.4439F, 1.9252F, -1.9252F, 1.0F, 1.0F, 5.0F, 0.0F, false);

		cube_r4 = new ModelRenderer(this);
		cube_r4.setRotationPoint(0.4632F, -19.7332F, -7.9916F);
		bone.addChild(cube_r4);
		setRotationAngle(cube_r4, 0.3927F, 0.0F, 0.0F);
		cube_r4.setTextureOffset(28, 46).addBox(-2.4065F, 0.9626F, -1.9252F, 3.0F, 1.0F, 3.0F, 0.0F, false);

		cube_r5 = new ModelRenderer(this);
		cube_r5.setRotationPoint(1.4258F, -23.5836F, -6.0664F);
		bone.addChild(cube_r5);
		setRotationAngle(cube_r5, 0.3927F, 0.0F, 0.0F);
		cube_r5.setTextureOffset(0, 8).addBox(-2.4439F, 1.9252F, -1.9252F, 4.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r5.setTextureOffset(30, 22).addBox(-5.2943F, 1.9252F, -1.9252F, 5.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r5.setTextureOffset(0, 29).addBox(-4.3317F, 0.0F, -3.8504F, 5.0F, 6.0F, 5.0F, 0.0F, false);

		cube_r6 = new ModelRenderer(this);
		cube_r6.setRotationPoint(0.4632F, -17.808F, 2.5969F);
		bone.addChild(cube_r6);
		setRotationAngle(cube_r6, -0.3927F, 0.0F, 0.0F);
		cube_r6.setTextureOffset(0, 0).addBox(-7.2195F, -1.9252F, -4.813F, 13.0F, 5.0F, 11.0F, 0.0F, false);

		cube_r7 = new ModelRenderer(this);
		cube_r7.setRotationPoint(-4.3498F, -10.1073F, 13.1855F);
		bone.addChild(cube_r7);
		setRotationAngle(cube_r7, -0.7854F, 0.0F, 0.0F);
		cube_r7.setTextureOffset(0, 16).addBox(-1.4439F, -0.9626F, -2.4065F, 2.0F, 5.0F, 2.0F, 0.0F, false);
		cube_r7.setTextureOffset(40, 46).addBox(7.2195F, -0.9626F, -2.4065F, 2.0F, 5.0F, 2.0F, 0.0F, false);

		cube_r8 = new ModelRenderer(this);
		cube_r8.setRotationPoint(-4.3498F, -17.808F, -1.2535F);
		bone.addChild(cube_r8);
		setRotationAngle(cube_r8, -0.7854F, 0.0F, 0.0F);
		cube_r8.setTextureOffset(20, 29).addBox(-3.3691F, -0.9626F, -2.4065F, 4.0F, 5.0F, 5.0F, 0.0F, false);
		cube_r8.setTextureOffset(33, 24).addBox(7.2195F, -0.9626F, -2.4065F, 4.0F, 5.0F, 5.0F, 0.0F, false);

		cube_r9 = new ModelRenderer(this);
		cube_r9.setRotationPoint(4.3136F, -13.9576F, -2.2161F);
		bone.addChild(cube_r9);
		setRotationAngle(cube_r9, -0.7854F, 0.0F, 0.0F);
		cube_r9.setTextureOffset(0, 0).addBox(-1.4439F, -0.9626F, -2.4065F, 2.0F, 5.0F, 3.0F, 0.0F, false);
		cube_r9.setTextureOffset(42, 16).addBox(-10.1073F, -0.9626F, -2.4065F, 2.0F, 5.0F, 3.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		bone.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}
package com.sigfalt.monkey.client.renderer.entity.model;

import com.google.common.collect.ImmutableList;
import com.sigfalt.monkey.common.entity.GorillaEntity;
import net.minecraft.client.renderer.entity.model.AgeableModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class GorillaModel<T extends GorillaEntity> extends AgeableModel<T> {
	private final ModelRenderer body;
	private final ModelRenderer head;

	public GorillaModel() {
		super(false, 12.0F, 4.0F);
		textureWidth = 128;
		textureHeight = 128;

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 24.0F, 0.0F);
		body.setTextureOffset(0, 0).addBox(-12.0F, -24.0F, -8.0F, 24.0F, 24.0F, 24.0F, 0.0F, false);

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 24.0F, 0.0F);
		head.setTextureOffset(0, 48).addBox(-4.0F, -32.0F, -14.0F, 8.0F, 10.0F, 8.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){}

	@Override
	protected Iterable<ModelRenderer> getHeadParts() {
		return ImmutableList.of(this.head);
	}

	@Override
	protected Iterable<ModelRenderer> getBodyParts() {
		return ImmutableList.of(this.body);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}
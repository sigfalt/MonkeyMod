package com.sigfalt.monkey.client.renderer.entity;

import com.sigfalt.monkey.MonkeyMod;
import com.sigfalt.monkey.client.renderer.entity.model.GorillaModel;
import com.sigfalt.monkey.common.entity.GorillaEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class GorillaRenderer extends MobRenderer<GorillaEntity, GorillaModel<GorillaEntity>> {

	private static final ResourceLocation MONKEY_TEXTURE = new ResourceLocation(MonkeyMod.MOD_ID, "textures/entity/gorilla.png");

	public GorillaRenderer(final EntityRendererManager manager) {
		super(manager, new GorillaModel<>(), .7F);
	}

	@Override
	public ResourceLocation getEntityTexture(final GorillaEntity entity) {
		return MONKEY_TEXTURE;
	}
}

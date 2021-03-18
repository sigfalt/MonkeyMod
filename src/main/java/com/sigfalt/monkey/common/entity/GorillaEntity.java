package com.sigfalt.monkey.common.entity;

import com.sigfalt.monkey.init.MonkeyEntities;
import com.sigfalt.monkey.init.MonkeyItems;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.Nullable;

public class GorillaEntity extends AnimalEntity {

	private static final Logger LOGGER = LogManager.getLogger();

	public static final String NAME = "gorilla";

	/*
	The following control the size of the hitbox, not the rendered model.
	This also changes what is considered "inside" of the entity, and when you will start to be pushed away.
	 */
	public static final float HEIGHT = 2;
	public static final float WIDTH = 2;

	private static final Item BANANA = MonkeyItems.BANANA_ITEM.get();

	public GorillaEntity(final EntityType<? extends AnimalEntity> entityType, final World world) {
		super(entityType, world);
	}

	protected void registerGoals() {
		this.goalSelector.addGoal(0, new SwimGoal(this));
		this.goalSelector.addGoal(1, new PanicGoal(this, 1.25D));
		this.goalSelector.addGoal(2, new BreedGoal(this, 1.0D));
		this.goalSelector.addGoal(3, new TemptGoal(this, 1.2D, Ingredient.fromItems(BANANA), false));
		this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.1D));
		this.goalSelector.addGoal(5, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
		this.goalSelector.addGoal(6, new LookAtGoal(this, PlayerEntity.class, 6.0F));
		this.goalSelector.addGoal(7, new LookRandomlyGoal(this));
	}

	public static AttributeModifierMap.MutableAttribute getAttributes() {
		return func_233666_p_().createMutableAttribute(Attributes.MAX_HEALTH, 30)
				.createMutableAttribute(Attributes.MOVEMENT_SPEED, .2)
				.createMutableAttribute(Attributes.ATTACK_DAMAGE, 5);
	}

	@Override
	public boolean isBreedingItem(ItemStack stack) {
		return stack.getItem() == BANANA;
	}

	@Nullable
	@Override
	public AgeableEntity func_241840_a(ServerWorld p_241840_1_, AgeableEntity p_241840_2_) {
		return MonkeyEntities.GORILLA.get().create(p_241840_1_);
	}
}

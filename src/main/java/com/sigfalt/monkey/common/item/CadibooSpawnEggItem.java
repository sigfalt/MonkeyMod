package com.sigfalt.monkey.common.item;

import net.minecraft.block.DispenserBlock;
import net.minecraft.dispenser.DefaultDispenseItemBehavior;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.util.Lazy;
import net.minecraftforge.common.util.NonNullSupplier;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Exists to work around a limitation with Spawn Eggs:
 * Spawn Eggs require an EntityType, but EntityTypes are created AFTER Items.
 * Therefore it is "impossible" for modded spawn eggs to exist.
 * This class gets around it by passing "null" to the SpawnEggItem constructor
 * and doing the initialisation after registry events have finished firing.
 * <p>
 * TODO: Remove once Forge adds this stuff in itself.
 *
 * @author Cadiboo
 */
public class CadibooSpawnEggItem extends SpawnEggItem {

	protected static final List<CadibooSpawnEggItem> UNADDED_EGGS = new ArrayList<>();
	private final Lazy<? extends EntityType<?>> entityTypeSupplier;

	public CadibooSpawnEggItem(final NonNullSupplier<? extends EntityType<?>> supplier, final int primaryColor, final int secondaryColor, final Properties properties) {
		super(null, primaryColor, secondaryColor, properties);
		this.entityTypeSupplier = Lazy.of(supplier::get);
		UNADDED_EGGS.add(this);
	}

	public CadibooSpawnEggItem(final RegistryObject<? extends EntityType<?>> supplier, final int primaryColor, final int secondaryColor, final Properties properties) {
		super(null, primaryColor, secondaryColor, properties);
		this.entityTypeSupplier = Lazy.of(supplier::get);
		UNADDED_EGGS.add(this);
	}

	/**
	 * Adds all the supplier based spawn eggs to vanilla's map and registers an
	 * IDispenseItemBehavior for each of them as normal spawn eggs have one
	 * registered for each of them during {@link net.minecraft.dispenser.IDispenseItemBehavior#init()}
	 * but supplier based ones won't have had their EntityTypes created yet.
	 */
	public static void initUnaddedEggs() {
		final Map<EntityType<?>, SpawnEggItem> EGGS = ObfuscationReflectionHelper.getPrivateValue(SpawnEggItem.class, null, "field_195987_b");
		DefaultDispenseItemBehavior defaultDispenseItemBehavior = new DefaultDispenseItemBehavior() {
			public ItemStack dispenseStack(IBlockSource source, ItemStack stack) {
				Direction direction = source.getBlockState().get(DispenserBlock.FACING);
				EntityType<?> entityType = ((SpawnEggItem) stack.getItem()).getType(stack.getTag());
				entityType.spawn(source.getWorld(), stack, null, source.getBlockPos().offset(direction), SpawnReason.DISPENSER, direction != Direction.UP, false);
				stack.shrink(1);
				return stack;
			}
		};
		for (final SpawnEggItem egg : UNADDED_EGGS) {
			EGGS.put(egg.getType(null), egg);
			DispenserBlock.registerDispenseBehavior(egg, defaultDispenseItemBehavior);
		}
		UNADDED_EGGS.clear();
	}

	@Override
	public EntityType<?> getType(@Nullable final CompoundNBT p_208076_1_) {
		return entityTypeSupplier.get();
	}

}

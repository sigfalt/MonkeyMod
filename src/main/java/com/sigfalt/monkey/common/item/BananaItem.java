package com.sigfalt.monkey.common.item;

import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class BananaItem extends Item {

	private static final int MAX_STACK = 16;
	public static final String NAME = "banana";

	public BananaItem() {
		super(new Item.Properties().maxStackSize(MAX_STACK).group(ItemGroup.FOOD)
				.food(new Food.Builder().hunger(4).saturation(2.4F).build()));
	}

}

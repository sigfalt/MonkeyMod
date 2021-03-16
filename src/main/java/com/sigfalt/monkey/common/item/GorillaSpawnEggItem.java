package com.sigfalt.monkey.common.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class GorillaSpawnEggItem extends Item {

	public static final String NAME = "gorilla_spawn_egg";

	public GorillaSpawnEggItem() {
		super(new Item.Properties().group(ItemGroup.MISC));
	}

}

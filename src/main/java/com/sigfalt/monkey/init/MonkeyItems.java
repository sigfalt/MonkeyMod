package com.sigfalt.monkey.init;

import com.sigfalt.monkey.MonkeyMod;
import com.sigfalt.monkey.common.item.BananaItem;
import com.sigfalt.monkey.common.item.GorillaSpawnEggItem;
import com.sigfalt.monkey.common.item.CadibooSpawnEggItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod.EventBusSubscriber(modid = MonkeyMod.MOD_ID)
public class MonkeyItems {

	private static final Logger LOGGER = LogManager.getLogger();

	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MonkeyMod.MOD_ID);

	public static final RegistryObject<Item> BANANA_ITEM = ITEMS.register(BananaItem.NAME, () -> new BananaItem());
	public static final RegistryObject<Item> GORILLA_SPAWN_EGG = ITEMS.register(GorillaSpawnEggItem.NAME, () ->
			new CadibooSpawnEggItem(MonkeyEntities.GORILLA, 0, 0, (new Item.Properties()).group(ItemGroup.MISC)));

}

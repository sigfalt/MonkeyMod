package com.sigfalt.monkey.init;

import com.sigfalt.monkey.MonkeyMod;
import com.sigfalt.monkey.common.item.CadibooSpawnEggItem;
import net.minecraft.entity.EntityType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod.EventBusSubscriber(modid = MonkeyMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class MonkeyEventSubscriber {

	private static final Logger LOGGER = LogManager.getLogger();

	/**
	 * Exists to work around a limitation with Spawn Eggs:
	 * Spawn Eggs require an EntityType, but EntityTypes are created AFTER Items.
	 * Therefore it is "impossible" for modded spawn eggs to exist.
	 * To get around this we have our own custom SpawnEggItem, but it needs
	 * some extra setup after Item and EntityType registration completes.
	 */
	@SubscribeEvent(priority = EventPriority.LOWEST)
	public static void onPostRegisterEntities(final RegistryEvent.Register<EntityType<?>> event) {
		LOGGER.debug("Finishing up after entity registration...");
		CadibooSpawnEggItem.initUnaddedEggs();
		LOGGER.debug("Finished.");
	}

}

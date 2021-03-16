package com.sigfalt.monkey.init;

import com.sigfalt.monkey.MonkeyMod;
import com.sigfalt.monkey.common.entity.GorillaEntity;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod.EventBusSubscriber(modid = MonkeyMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class MonkeyAttributeHandler {

	private static final Logger LOGGER = LogManager.getLogger();

	@SubscribeEvent
	public static void createEntityAttributes(final EntityAttributeCreationEvent event) {
		LOGGER.debug("Registering entity attributes...");
		event.put(MonkeyEntities.GORILLA.get(), GorillaEntity.getAttributes().create());
		LOGGER.debug("Finished registering entity attributes.");
	}

}

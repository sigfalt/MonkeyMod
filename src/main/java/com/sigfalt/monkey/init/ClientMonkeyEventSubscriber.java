package com.sigfalt.monkey.init;

import com.sigfalt.monkey.MonkeyMod;
import com.sigfalt.monkey.client.renderer.entity.GorillaRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod.EventBusSubscriber(modid = MonkeyMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientMonkeyEventSubscriber {

	private static final Logger LOGGER = LogManager.getLogger();

	@SubscribeEvent
	public static void onFMLClientSetupEvent(final FMLClientSetupEvent event) {

		LOGGER.debug("Registered entities...");
		RenderingRegistry.registerEntityRenderingHandler(MonkeyEntities.GORILLA.get(), GorillaRenderer::new);
		LOGGER.debug("Finished registering entities.");

	}

}

package com.sigfalt.monkey;

import com.sigfalt.monkey.init.MonkeyLootModifiers;
import com.sigfalt.monkey.init.MonkeyEntities;
import com.sigfalt.monkey.init.MonkeyItems;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(MonkeyMod.MOD_ID)
public class MonkeyMod {

	private static final Logger LOGGER = LogManager.getLogger();

	public static final String MOD_ID = "sig-monkey";

	public MonkeyMod() {
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

		bus.addListener(this::setup);
		bus.addListener(this::enqueueIMC);
		bus.addListener(this::processIMC);
		bus.addListener(this::doClientStuff);

		MinecraftForge.EVENT_BUS.register(this);

		MonkeyItems.ITEMS.register(bus);
		MonkeyEntities.ENTITY_TYPES.register(bus);
		MonkeyLootModifiers.GLM.register(bus);
	}

	private void setup(final FMLCommonSetupEvent event) {
		//LOGGER.info("Hello from setup");
	}

	private void doClientStuff(final FMLClientSetupEvent event) {
		//LOGGER.info("Got game settings {}", event.getMinecraftSupplier().get().gameSettings);
	}

	private void enqueueIMC(final InterModEnqueueEvent event) {
		//InterModComms.sendTo(MOD_ID, "helloworld", () -> {LOGGER.info("Hello world from the MDK"); return "Hello world";});
	}

	private void processIMC(final InterModProcessEvent event) {
		//LOGGER.info("Got IMC {}", event.getIMCStream()
		//		.map(m -> m.getMessageSupplier().get())
		//		.collect(Collectors.toList()));
	}

}

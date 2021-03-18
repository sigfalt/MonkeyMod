package com.sigfalt.monkey.init;

import com.sigfalt.monkey.MonkeyMod;
import net.minecraft.entity.EntityClassification;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraftforge.common.world.MobSpawnInfoBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod.EventBusSubscriber(modid = MonkeyMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class MonkeyForgeEventSubscriber {

	private static final Logger LOGGER = LogManager.getLogger();

	@SubscribeEvent(priority = EventPriority.HIGH)
	public static void onBiomeLoadingEvent(final BiomeLoadingEvent event) {
		if (event.getCategory() == Biome.Category.JUNGLE) {
			LOGGER.debug("Patching biome spawn info for {}...", event.getName());
			final MobSpawnInfoBuilder spawns = event.getSpawns();
			spawns.getSpawner(EntityClassification.CREATURE).removeIf(e -> e.type == MonkeyEntities.GORILLA.get());
			spawns.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(MonkeyEntities.GORILLA.get(), 5, 3, 5));
			LOGGER.debug("Finished.");
		}
	}

}

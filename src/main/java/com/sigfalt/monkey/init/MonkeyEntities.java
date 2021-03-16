package com.sigfalt.monkey.init;

import com.sigfalt.monkey.MonkeyMod;
import com.sigfalt.monkey.common.entity.GorillaEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod.EventBusSubscriber(modid = MonkeyMod.MOD_ID)
public class MonkeyEntities {

	private static final Logger LOGGER = LogManager.getLogger();

	public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, MonkeyMod.MOD_ID);
	public static final RegistryObject<EntityType<GorillaEntity>> GORILLA = ENTITY_TYPES.register(GorillaEntity.NAME,
			() -> EntityType.Builder.create(GorillaEntity::new, EntityClassification.CREATURE)
					.size(GorillaEntity.WIDTH, GorillaEntity.HEIGHT)
					.build(new ResourceLocation(MonkeyMod.MOD_ID, GorillaEntity.NAME).toString()));

}

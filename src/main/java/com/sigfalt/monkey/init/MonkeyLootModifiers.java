package com.sigfalt.monkey.init;

import com.google.gson.JsonObject;
import com.sigfalt.monkey.MonkeyMod;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootContext;
import net.minecraft.loot.conditions.*;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.Nonnull;
import java.util.List;

@Mod.EventBusSubscriber(modid = MonkeyMod.MOD_ID)
public class MonkeyLootModifiers {

	private static final Logger LOGGER = LogManager.getLogger();

	public static final DeferredRegister<GlobalLootModifierSerializer<?>> GLM =
			DeferredRegister.create(ForgeRegistries.LOOT_MODIFIER_SERIALIZERS, MonkeyMod.MOD_ID);

	private static final RegistryObject<BananasFromJungleLeavesModifier.Serializer> BANANAS_FROM_JUNGLE_LEAVES =
			GLM.register("bananas_from_jungle_leaves", BananasFromJungleLeavesModifier.Serializer::new);
	private static final ResourceLocation bananaRL = new ResourceLocation(MonkeyMod.MOD_ID, "banana");

	private static class BananasFromJungleLeavesModifier extends LootModifier {

		public BananasFromJungleLeavesModifier(ILootCondition[] conditionsIn) {
			super(conditionsIn);
		}

		@Nonnull
		@Override
		protected List<ItemStack> doApply(List<ItemStack> generatedLoot, LootContext context) {
			//LOGGER.info("Initial generated loot: {}", generatedLoot);
			generatedLoot.add(new ItemStack(ForgeRegistries.ITEMS.getValue(bananaRL)));
			//LOGGER.info("New generated loot: {}", generatedLoot);
			return generatedLoot;
		}

		private static class Serializer extends GlobalLootModifierSerializer<BananasFromJungleLeavesModifier> {

			@Override
			public BananasFromJungleLeavesModifier read(ResourceLocation location, JsonObject object, ILootCondition[] conditionsIn) {
				return new BananasFromJungleLeavesModifier(conditionsIn);
			}

			@Override
			public JsonObject write(BananasFromJungleLeavesModifier instance) {
				return makeConditions(instance.conditions);
			}
		}

	}

}

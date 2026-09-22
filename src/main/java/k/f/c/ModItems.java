package k.f.c;

import java.util.function.Function;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;

public class ModItems {

	public static void initialize() {
		CreativeModeTabEvents.modifyOutputEvent(
			CreativeModeTabs.INGREDIENTS
		).register(creativeTab -> creativeTab.accept(ModItems.KFC_ITEM));
	}

	public static final ResourceKey<Item> KFC_KEY = create("kfc");
	public static final Item KFC_ITEM = register(
		KFC_KEY,
		Item::new,
		new Item.Properties().food(
			new FoodProperties.Builder().nutrition(4).saturationModifier(3).build()
		)
	);

	public static ResourceKey<Item> create(String name) {
		return ResourceKey.create(Registries.ITEM, KFC.id(name));
	}

	public static Item register(
		ResourceKey<Item> itemKey,
		Function<Item.Properties, Item> itemFactory,
		Item.Properties settings
	) {
		Item item = itemFactory.apply(settings.setId(itemKey));
		Registry.register(BuiltInRegistries.ITEM, itemKey, item);

		return item;
	}
}

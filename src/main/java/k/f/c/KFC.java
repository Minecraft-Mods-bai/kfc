package k.f.c;

import net.fabricmc.api.ModInitializer;
import net.minecraft.resources.Identifier;

public class KFC implements ModInitializer {

	public static final String MOD_ID = "kfc";

	@Override
	public void onInitialize() {
		ModItems.initialize();
	}

	public static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID, path);
	}
}

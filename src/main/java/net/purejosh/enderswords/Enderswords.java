package net.purejosh.enderswords;

import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import net.purejosh.enderswords.item.ModItemGroups;
import net.purejosh.enderswords.item.ModItems;
import net.purejosh.enderswords.item.ModItemsCompat;
import net.purejosh.enderswords.world.ModGameRules;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Enderswords implements ModInitializer {
	public static final String MOD_ID = "enderswords";
	public static final String MOD_NAME = "Enderswords";
	public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

	// This code is executed when the mod is loaded.
	@Override
	public void onInitialize() {
		// Call the init methods in the registry classes.
		ModGameRules.init();
		ModItems.init();
		ModItemGroups.init();
		ModItemsCompat.init();

		// This is the log line that gets printed when the mod is finished loading.
		LOGGER.info(Enderswords.MOD_NAME + " by purejosh has been loaded!");
	}

	// This is used in the configured features and placed features registry. No idea why.
	public static Identifier id(String path) {
		return Identifier.of(MOD_ID, path);
	}
}

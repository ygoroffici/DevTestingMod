package me.ygoroffici.devtestingmod;

import me.ygoroffici.devtestingmod.item.ModItems;
import me.ygoroffici.devtestingmod.util.Reference;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DevTestingMod implements ModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger(Reference.MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerAllItems();
	}
}

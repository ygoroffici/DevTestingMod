package me.ygoroffici.devtestingmod;

import net.fabricmc.api.ClientModInitializer;

public class DevTestingModClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        DevTestingMod.LOGGER.info("Initialized on the Client!");
    }
}

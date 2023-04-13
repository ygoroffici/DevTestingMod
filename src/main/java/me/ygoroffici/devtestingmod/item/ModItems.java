package me.ygoroffici.devtestingmod.item;

import me.ygoroffici.devtestingmod.DevTestingMod;
import me.ygoroffici.devtestingmod.util.Reference;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {

    public static final Item SOUND_STICK = registerItem("sound_stick",
            new SoundStickItem(new FabricItemSettings()
                    .group(ModItemGroups.DEVTESTGROUP)));

    public static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(Reference.MOD_ID, name), item);
    }

    public static void registerAllItems() {
        DevTestingMod.LOGGER.info("Registering mod items for " + Reference.MOD_ID);
    }
}

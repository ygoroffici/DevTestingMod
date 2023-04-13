package me.ygoroffici.devtestingmod.item;

import me.ygoroffici.devtestingmod.util.Reference;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup DEVTESTGROUP = FabricItemGroupBuilder.build(
            new Identifier(Reference.MOD_ID, "devtesting_group"),
            () -> new ItemStack(ModItems.SOUND_STICK));
}

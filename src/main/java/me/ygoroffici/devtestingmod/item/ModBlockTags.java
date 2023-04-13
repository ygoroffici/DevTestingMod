package me.ygoroffici.devtestingmod.item;

import net.minecraft.block.Block;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlockTags
{
    public static final TagKey<Block> IGNORED_MUFFLER_BLOCKS = TagKey.of(Registry.BLOCK_KEY,
            new Identifier("c", "ignored_muffler_blocks"));
}

package me.ygoroffici.devtestingmod.item;

import me.ygoroffici.devtestingmod.DevTestingMod;
import net.minecraft.block.BlockState;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class SoundStickItem extends Item {

    private int curIndex = 0;
    private BlockPos[] blockList = new BlockPos[2];

    public SoundStickItem(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("item.devtestingmod.sound_stick.tooltip").formatted(Formatting.DARK_GRAY));
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context)
    {
        if (!Screen.hasShiftDown())
        {
            if (context.getWorld().isClient()) return ActionResult.PASS;

            BlockPos interactedBlock = context.getBlockPos();
            blockList[curIndex] = interactedBlock;

            BlockState block = context.getWorld().getBlockState(blockList[curIndex]); // debug
            DevTestingMod.LOGGER.info("The picked block was: " + block.getBlock().getName()); // debug

            curIndex++;

            if (curIndex >= 2)
            {
                curIndex = 0;
            }

            DevTestingMod.LOGGER.info("The current curIndex value is " + curIndex); // debug
            return ActionResult.SUCCESS;
        }

        return ActionResult.PASS;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand)
    {
        ItemStack itemStack = user.getStackInHand(hand);

        if (Screen.hasShiftDown())
        {
            if (!world.isClient)
            {
                BlockPos first = blockList[0];
                BlockPos second = blockList[1];

                int count = countBlocksBetween(first, second, world);
                DevTestingMod.LOGGER.info("There are " + count + " blocks between the two targets.");
                user.sendMessage(Text.literal("There are " + count + " blocks between the two targets.").formatted(Formatting.GOLD));
            }
        }

        return TypedActionResult.consume(itemStack);
    }

    public static int countBlocksBetween(BlockPos startPos, BlockPos endPos, World world)
    {
        int howManyBlocks = 0;

        for (BlockPos curBlock : BlockPos.iterate(startPos, endPos))
        {
            BlockState detected = world.getBlockState(curBlock);

            if (!detected.isIn(ModBlockTags.IGNORED_MUFFLER_BLOCKS))
            {
                DevTestingMod.LOGGER.info("Counted block: " + detected.getBlock().toString());
                howManyBlocks++;
            }
        }

        return howManyBlocks - 2; // - 2 because Iterate counts the start and end blocks by default
        // Also I am not going to find a better way to do this, too much work :(
    }
}

package malek.terrafabricraft.common.item;

import malek.terrafabricraft.common.block.TFCLooseRock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.ActionResult;

public class TFCLooseRockItem extends BlockItem {

    public TFCLooseRockItem(Block block, Settings settings) {
        super(block, settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        if(!context.getPlayer().isSneaking()) {
            return ActionResult.PASS;
        }
        if(context.getWorld().getBlockState(context.getBlockPos()).getBlock().asItem() != null
        && context.getWorld().getBlockState(context.getBlockPos()).getBlock().asItem() == context.getStack().getItem())
        {
            if(context.getWorld().getBlockState(context.getBlockPos()).get(TFCLooseRock.COUNT) == 3) {
                return ActionResult.PASS;
            }
            context.getWorld().setBlockState(context.getBlockPos(), context.getWorld().getBlockState(context.getBlockPos()).with(TFCLooseRock.COUNT, context.getWorld().getBlockState(context.getBlockPos()).get(TFCLooseRock.COUNT) + 1));
            context.getPlayer().getMainHandStack().setCount(context.getPlayer().getMainHandStack().getCount() - 1);
            return ActionResult.PASS;
        }
        else {
            ActionResult actionResult = this.place(new ItemPlacementContext(context));
            return actionResult;
        }
    }
}

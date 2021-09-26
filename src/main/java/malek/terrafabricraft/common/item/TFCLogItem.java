package malek.terrafabricraft.common.item;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.ActionResult;

import static malek.terrafabricraft.common.registry.TFCObjects.LOG_PILE;

public class TFCLogItem extends BlockItem {
    public TFCLogItem(Block block, Settings settings) {
        super(block, settings);
    }
    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        if(context.getPlayer().isSneaking())
        {
            if(context.getWorld().getBlockState(context.getBlockPos().add(context.getSide().getVector())).isAir()) {
                context.getWorld().setBlockState(context.getBlockPos().add(context.getSide().getVector()), LOG_PILE.getDefaultState());
            }
            return ActionResult.PASS;
        }
        else {
            ActionResult actionResult = this.place(new ItemPlacementContext(context));
            return actionResult;
        }
    }
}

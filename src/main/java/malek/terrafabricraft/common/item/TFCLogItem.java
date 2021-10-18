package malek.terrafabricraft.common.item;

import malek.terrafabricraft.common.temperature.ItemTemperature;
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
        if(context.getWorld().isClient) {
            return super.useOnBlock(context);
        }
        //ItemTemperature.setTemperature(context.getStack(), 1);
        if(context.getPlayer().isSneaking())
        {
            if(context.getWorld().getBlockState(context.getBlockPos().add(context.getSide().getVector())).isAir()) {
                context.getWorld().setBlockState(context.getBlockPos().add(context.getSide().getVector()), LOG_PILE.getDefaultState());
               // ((LogPileBlockEntity)context.getWorld().getBlockEntity(context.getBlockPos())).getItems().set(0, new ItemStack(context.getStack().getItem()));
                context.getPlayer().getMainHandStack().setCount(context.getPlayer().getMainHandStack().getCount()-1);
            }
            return ActionResult.PASS;
        }
        else {
            ActionResult actionResult = this.place(new ItemPlacementContext(context));
            return actionResult;
        }
    }
}

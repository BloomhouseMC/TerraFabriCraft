package malek.terrafabricraft.common.item;

import malek.terrafabricraft.common.block.TFCLooseRock;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;

import static malek.terrafabricraft.common.registry.TFCObjects.LOG_PILE;

public class TFCLooseRockItem extends BlockItem {

    public TFCLooseRockItem(Block block, Properties settings) {
        super(block, settings);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        if(!context.getPlayer().isShiftKeyDown()) {
            return InteractionResult.PASS;
        }
        if(context.getLevel().getBlockState(context.getClickedPos()).getBlock().asItem() != null
        && context.getLevel().getBlockState(context.getClickedPos()).getBlock().asItem() == context.getItemInHand().getItem())
        {
            if(context.getLevel().getBlockState(context.getClickedPos()).getValue(TFCLooseRock.COUNT) == 3) {
                return InteractionResult.PASS;
            }
            context.getLevel().setBlockAndUpdate(context.getClickedPos(), context.getLevel().getBlockState(context.getClickedPos()).setValue(TFCLooseRock.COUNT, context.getLevel().getBlockState(context.getClickedPos()).getValue(TFCLooseRock.COUNT) + 1));
            context.getPlayer().getMainHandItem().setCount(context.getPlayer().getMainHandItem().getCount() - 1);
            return InteractionResult.PASS;
        }
        else {
            InteractionResult actionResult = this.place(new BlockPlaceContext(context));
            return actionResult;
        }
    }
}

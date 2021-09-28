package malek.terrafabricraft.common.item;

import malek.terrafabricraft.common.block.logpile.LogPileBlockEntity;
import malek.terrafabricraft.common.temperature.ItemTemperature;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;

import static malek.terrafabricraft.common.registry.TFCObjects.LOG_PILE;

public class TFCLogItem extends BlockItem {
    public TFCLogItem(Block block, Properties settings) {
        super(block, settings);
    }
    @Override
    public InteractionResult useOn(UseOnContext context) {
        ItemTemperature.setTemperature(context.getItemInHand(), 1);
        if(context.getPlayer().isShiftKeyDown())
        {
            if(context.getLevel().getBlockState(context.getClickedPos().offset(context.getClickedFace().getNormal())).isAir()) {
                context.getLevel().setBlockAndUpdate(context.getClickedPos().offset(context.getClickedFace().getNormal()), LOG_PILE.defaultBlockState());
                //((LogPileBlockEntity)context.getWorld().getBlockEntity(context.getBlockPos())).getItems().set(0, new ItemStack(context.getStack().getItem()));
                context.getPlayer().getMainHandItem().setCount(context.getPlayer().getMainHandItem().getCount()-1);
            }
            return InteractionResult.PASS;
        }
        else {
            InteractionResult actionResult = this.place(new BlockPlaceContext(context));
            return actionResult;
        }
    }
}

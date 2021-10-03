package malek.terrafabricraft.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;

public class TFCGrassBlock extends Block {
    public TFCGrassBlock(Settings settings) {
        super(settings);
    }

//    public BlockState getPlacementState(ItemPlacementContext ctx) {
//        BlockView blockView = ctx.getWorld();
//        BlockPos blockPos = ctx.getBlockPos();
//        FluidState fluidState = ctx.getWorld().getFluidState(ctx.getBlockPos());
//        BlockPos blockPos2 = blockPos.north();
//        BlockPos blockPos3 = blockPos.east();
//        BlockPos blockPos4 = blockPos.south();
//        BlockPos blockPos5 = blockPos.west();
//        BlockState blockState = blockView.getBlockState(blockPos2);
//        BlockState blockState2 = blockView.getBlockState(blockPos3);
//        BlockState blockState3 = blockView.getBlockState(blockPos4);
//        BlockState blockState4 = blockView.getBlockState(blockPos5);
//        return (BlockState)((BlockState)((BlockState)((BlockState)((BlockState)super.getPlacementState(ctx).with(NORTH, this.canConnect(blockState, blockState.isSideSolidFullSquare(blockView, blockPos2, Direction.SOUTH), Direction.SOUTH))).with(EAST, this.canConnect(blockState2, blockState2.isSideSolidFullSquare(blockView, blockPos3, Direction.WEST), Direction.WEST))).with(SOUTH, this.canConnect(blockState3, blockState3.isSideSolidFullSquare(blockView, blockPos4, Direction.NORTH), Direction.NORTH))).with(WEST, this.canConnect(blockState4, blockState4.isSideSolidFullSquare(blockView, blockPos5, Direction.EAST), Direction.EAST))).with(WATERLOGGED, fluidState.getFluid() == Fluids.WATER);
//    }
}

package malek.terrafabricraft.common.block;


import malek.terrafabricraft.common.registry.TFCObjects;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ConnectingBlock;
import net.minecraft.block.GrassBlock;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;

import java.util.Map;

public class TFCGrassBlock extends GrassBlock {
    protected static final Map<Direction, BooleanProperty> FACING_PROPERTIES = ConnectingBlock.FACING_PROPERTIES.entrySet()
                                                                                                                .stream()
                                                                                                                .filter((entry) -> {
                                                                                                                    return ((Direction) entry.getKey()).getAxis()
                                                                                                                                                       .isHorizontal();
                                                                                                                })
                                                                                                                .collect(Util.toMap());

    public TFCGrassBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState()
                                              .with(Properties.NORTH, false)
                                              .with(Properties.EAST, false)
                                              .with(Properties.SOUTH, false)
                                              .with(Properties.WEST, false));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(Properties.NORTH, Properties.EAST, Properties.WEST, Properties.SOUTH, SNOWY);
    }

    public BlockState getPlacementState(ItemPlacementContext ctx) {
        BlockView blockView = ctx.getWorld();
        BlockPos blockPos = ctx.getBlockPos();
        BlockPos blockPos2 = blockPos.north().down();
        BlockPos blockPos3 = blockPos.east().down();
        BlockPos blockPos4 = blockPos.south().down();
        BlockPos blockPos5 = blockPos.west().down();
        BlockState blockState = blockView.getBlockState(blockPos2);
        BlockState blockState2 = blockView.getBlockState(blockPos3);
        BlockState blockState3 = blockView.getBlockState(blockPos4);
        BlockState blockState4 = blockView.getBlockState(blockPos5);
        return super.getPlacementState(ctx)
                    .with(Properties.NORTH, this.canConnect(blockState, blockState.isSideSolidFullSquare(blockView, blockPos2, Direction.SOUTH), Direction.SOUTH))
                    .with(Properties.EAST, this.canConnect(blockState2, blockState2.isSideSolidFullSquare(blockView, blockPos3, Direction.WEST), Direction.WEST))
                    .with(Properties.SOUTH, this.canConnect(blockState3, blockState3.isSideSolidFullSquare(blockView, blockPos4, Direction.NORTH), Direction.NORTH))
                    .with(Properties.WEST, this.canConnect(blockState4, blockState4.isSideSolidFullSquare(blockView, blockPos5, Direction.EAST), Direction.EAST));
    }

    public boolean canConnect(BlockState state, boolean neighborIsFullSquare, Direction dir) {
        boolean bl = this.canConnectToGrass(state);
        return bl;
    }

    public BlockState getStateForNeighborUpdate(BlockState state,
                                                Direction direction,
                                                BlockState neighborState,
                                                WorldAccess world,
                                                BlockPos pos,
                                                BlockPos neighborPos) {
        return direction.getAxis()
                        .getType() == Direction.Type.HORIZONTAL ? (BlockState) state.with(FACING_PROPERTIES.get(direction), this.canConnect(neighborState, neighborState.isSideSolidFullSquare(world, neighborPos, direction.getOpposite()), direction.getOpposite())) : super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }

    private boolean canConnectToGrass(BlockState state) {
        return state.isIn(TFCObjects.GRASS_BLOCK);
    }
}

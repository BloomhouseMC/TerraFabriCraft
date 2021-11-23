package com.bloomhousemc.terrafabricraft.common.block;


import com.bloomhousemc.terrafabricraft.common.registry.TfcTags;
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

public class TfcGrassBlock extends GrassBlock {
    protected static final Map<Direction, BooleanProperty> FACING_PROPERTIES = ConnectingBlock.FACING_PROPERTIES.entrySet().stream().filter((entry) -> {
        return ((Direction) entry.getKey()).getAxis().isHorizontal();
    }).collect(Util.toMap());

    public TfcGrassBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(Properties.NORTH, false).with(Properties.EAST, false).with(Properties.SOUTH, false).with(Properties.WEST, false));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(Properties.NORTH, Properties.EAST, Properties.WEST, Properties.SOUTH, SNOWY);
    }

    @Override
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
        return super.getPlacementState(ctx).with(Properties.NORTH, this.canConnect(blockState)).with(Properties.EAST, this.canConnect(blockState2)).with(Properties.SOUTH, this.canConnect(blockState3)).with(Properties.WEST, this.canConnect(blockState4));
    }

    public boolean canConnect(BlockState state) {
        return state.isIn(TfcTags.GRASS_BLOCKS);
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        return direction.getAxis().getType() == Direction.Type.HORIZONTAL ? state.with(FACING_PROPERTIES.get(direction), canConnect(neighborState)) : super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }
}

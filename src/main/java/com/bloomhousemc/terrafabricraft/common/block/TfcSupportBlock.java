package com.bloomhousemc.terrafabricraft.common.block;

import com.bloomhousemc.terrafabricraft.common.registry.TfcTags;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import net.minecraft.block.*;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;

import java.util.Map;

public class TfcSupportBlock extends Block implements Waterloggable {
    public static final BooleanProperty NORTH = ConnectingBlock.NORTH;
    public static final BooleanProperty EAST = ConnectingBlock.EAST;
    public static final BooleanProperty SOUTH = ConnectingBlock.SOUTH;
    public static final BooleanProperty WEST = ConnectingBlock.WEST;
    public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;
    protected final VoxelShape[] boundingShapes;
    protected static final Map<Direction, BooleanProperty> FACING_PROPERTIES = (Map)ConnectingBlock.FACING_PROPERTIES.entrySet().stream().filter(entry -> ((Direction)entry.getKey()).getAxis().isHorizontal()).collect(Util.toMap());
    private final Object2IntMap<BlockState> SHAPE_INDEX_CACHE = new Object2IntOpenHashMap<>();
    private final boolean HAS_PILLAR;

    public TfcSupportBlock(Settings settings, boolean hasPillar) {
        super(settings);
        boundingShapes = createShapes(3F, 3F, 16F, 10F, 16F);
        HAS_PILLAR = hasPillar;
    }


    @Override
    public boolean isTranslucent(BlockState state, BlockView world, BlockPos pos) {
        return !state.get(WATERLOGGED);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return this.boundingShapes[this.getShapeIndex(state)];
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(NORTH, EAST, WEST, SOUTH, WATERLOGGED);
    }

    protected int getShapeIndex(BlockState state) {
        return this.SHAPE_INDEX_CACHE.computeIntIfAbsent(state, blockState -> {
            int i = 0;
            if (blockState.get(NORTH)) {
                i |= getDirectionMask(Direction.NORTH);
            }

            if (blockState.get(EAST)) {
                i |= getDirectionMask(Direction.EAST);
            }

            if (blockState.get(SOUTH)) {
                i |= getDirectionMask(Direction.SOUTH);
            }

            if (blockState.get(WEST)) {
                i |= getDirectionMask(Direction.WEST);
            }

            return i;
        });
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        var floor = world.getBlockState(pos.down());
        return floor.isSideSolidFullSquare(world, pos, Direction.UP) || floor.isIn(TfcTags.SUPPORT_BEAMS);
    }

    protected VoxelShape[] createShapes(float radius1, float radius2, float height1, float offset2, float height2) {
        var minXZ = 8F - radius1;
        var maxXZ = 8F + radius1;
        var minXZ2 = 8F - radius2;
        var maxXZ2 = 8F + radius2;
        var voxelShape = (HAS_PILLAR) ? createCuboidShape(minXZ, 0.0, minXZ, maxXZ, height1, maxXZ) : createCuboidShape(minXZ, 10, minXZ, maxXZ, height1, maxXZ);
        var voxelShape2 = createCuboidShape(minXZ2, offset2, 0.0, maxXZ2, height2, maxXZ2);
        var voxelShape3 = createCuboidShape(minXZ2, offset2, minXZ2, maxXZ2, height2, 16.0);
        var voxelShape4 = createCuboidShape(0.0, offset2, minXZ2, maxXZ2, height2, maxXZ2);
        var voxelShape5 = createCuboidShape(minXZ2, offset2, minXZ2, 16.0, height2, maxXZ2);
        var voxelShape6 = VoxelShapes.union(voxelShape2, voxelShape5);
        var voxelShape7 = VoxelShapes.union(voxelShape3, voxelShape4);
        var voxelShapes = new VoxelShape[]{VoxelShapes.empty(), voxelShape3, voxelShape4, voxelShape7, voxelShape2, VoxelShapes.union(voxelShape3, voxelShape2), VoxelShapes.union(voxelShape4, voxelShape2), VoxelShapes.union(voxelShape7, voxelShape2), voxelShape5, VoxelShapes.union(voxelShape3, voxelShape5), VoxelShapes.union(voxelShape4, voxelShape5), VoxelShapes.union(voxelShape7, voxelShape5), voxelShape6, VoxelShapes.union(voxelShape3, voxelShape6), VoxelShapes.union(voxelShape4, voxelShape6), VoxelShapes.union(voxelShape7, voxelShape6)};

        for (int j = 0; j < 16; ++j) {
            voxelShapes[j] = VoxelShapes.union(voxelShape, voxelShapes[j]);
        }
        return voxelShapes;
    }

    public boolean canConnect(BlockState state) {
        var bl = state.isIn(TfcTags.SUPPORT_BEAMS);
        return !cannotConnect(state) && bl;
    }

    private static int getDirectionMask(Direction dir) {
        return 1 << dir.getHorizontal();
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        BlockView blockView = ctx.getWorld();
        var blockPos = ctx.getBlockPos();
        var fluidState = ctx.getWorld().getFluidState(ctx.getBlockPos());
        var northBlockPos = blockPos.north();
        var eastBlockPos = blockPos.east();
        var southBlockPos = blockPos.south();
        var westBlockPos = blockPos.west();
        var northBlockState = blockView.getBlockState(northBlockPos);
        var eastBlockState = blockView.getBlockState(eastBlockPos);
        var southBlockState = blockView.getBlockState(southBlockPos);
        var westBlockState = blockView.getBlockState(westBlockPos);
        return super.getPlacementState(ctx).with(NORTH, canConnect(northBlockState)).with(EAST, canConnect(eastBlockState)).with(SOUTH, canConnect(southBlockState)).with(WEST, canConnect(westBlockState)).with(WATERLOGGED, fluidState.getFluid() == Fluids.WATER);
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        return state.get(WATERLOGGED) ? Fluids.WATER.getStill(false) : super.getFluidState(state);
    }

    @Override
    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return switch (rotation) {
            case CLOCKWISE_180 -> state.with(NORTH, (Boolean) state.get(SOUTH)).with(EAST, (Boolean) state.get(WEST)).with(SOUTH, (Boolean) state.get(NORTH)).with(WEST, (Boolean) state.get(EAST));
            case COUNTERCLOCKWISE_90 -> state.with(NORTH, (Boolean) state.get(EAST)).with(EAST, (Boolean) state.get(SOUTH)).with(SOUTH, (Boolean) state.get(WEST)).with(WEST, (Boolean) state.get(NORTH));
            case CLOCKWISE_90 -> state.with(NORTH, (Boolean) state.get(WEST)).with(EAST, (Boolean) state.get(NORTH)).with(SOUTH, (Boolean) state.get(EAST)).with(WEST, (Boolean) state.get(SOUTH));
            default -> state;
        };
    }

    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        if (state.get(WATERLOGGED)) {
            world.createAndScheduleFluidTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(world));
        }

        return direction.getAxis().getType() == Direction.Type.HORIZONTAL ? state.with(FACING_PROPERTIES.get(direction), canConnect(neighborState)) : super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }

    @Override
    public BlockState mirror(BlockState state, BlockMirror mirror) {
        return switch (mirror) {
            case LEFT_RIGHT -> state.with(NORTH, (Boolean) state.get(SOUTH)).with(SOUTH, (Boolean) state.get(NORTH));
            case FRONT_BACK -> state.with(EAST, (Boolean) state.get(WEST)).with(WEST, (Boolean) state.get(EAST));
            default -> super.mirror(state, mirror);
        };
    }
}

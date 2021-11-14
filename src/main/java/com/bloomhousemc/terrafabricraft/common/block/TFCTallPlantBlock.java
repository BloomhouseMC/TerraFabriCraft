package com.bloomhousemc.terrafabricraft.common.block;

import com.bloomhousemc.terrafabricraft.common.registry.TFCObjects;
import com.bloomhousemc.terrafabricraft.common.registry.TFCTags;
import com.bloomhousemc.terrafabricraft.common.util.TFCProperties;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.enums.DoubleBlockHalf;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class TFCTallPlantBlock extends PlantBlock {
    public static final EnumProperty<DoubleBlockHalf> HALF;
    public final int MAX_AGE;
    private static final VoxelShape[] AGE_TO_SHAPE = {
            Block.createCuboidShape(0, 0, 0, 16, 2, 16),
            Block.createCuboidShape(0, 0, 0, 16, 4, 16),
            Block.createCuboidShape(0, 0, 0, 16, 6, 16),
            Block.createCuboidShape(0, 0, 0, 16, 8, 16),
            Block.createCuboidShape(0, 0, 0, 16, 10, 16),
            Block.createCuboidShape(0, 0, 0, 16, 12, 16),
            Block.createCuboidShape(0, 0, 0, 16, 14, 16),
            Block.createCuboidShape(0, 0, 0, 16, 16, 16)
    };
    public static IntProperty AGE_7;
    public static IntProperty AGE_6;
    public static IntProperty AGE_5;
    public static IntProperty AGE_4;

    public TFCTallPlantBlock(Settings settings, int temp, int speed, int collisionLevel, int maxAge) {
        super(settings);
        this.setDefaultState((BlockState)((BlockState)this.stateManager.getDefaultState()).with(HALF, DoubleBlockHalf.LOWER));
        MAX_AGE = maxAge;
    }

    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        DoubleBlockHalf doubleBlockHalf = (DoubleBlockHalf)state.get(HALF);
        if (direction.getAxis() == Direction.Axis.Y && doubleBlockHalf == DoubleBlockHalf.LOWER == (direction == Direction.UP) && (!neighborState.isOf(this) || neighborState.get(HALF) == doubleBlockHalf)) {
            return Blocks.AIR.getDefaultState();
        } else {
            return doubleBlockHalf == DoubleBlockHalf.LOWER && direction == Direction.DOWN && !state.canPlaceAt(world, pos) ? Blocks.AIR.getDefaultState() : super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
        }
    }

    @Nullable
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        BlockPos blockPos = ctx.getBlockPos();
        World world = ctx.getWorld();
        return blockPos.getY() < world.getTopY() - 1 && world.getBlockState(blockPos.up()).canReplace(ctx) ? super.getPlacementState(ctx) : null;
    }

    public void onPlaced(World world, BlockPos pos, BlockState state, LivingEntity placer, ItemStack itemStack) {
        BlockPos blockPos = pos.up();
        world.setBlockState(blockPos, withWaterloggedState(world, blockPos, (BlockState)this.getDefaultState().with(HALF, DoubleBlockHalf.UPPER)), 3);
    }

    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        if (state.get(HALF) != DoubleBlockHalf.UPPER) {
            return super.canPlaceAt(state, world, pos);
        } else {
            BlockState blockState = world.getBlockState(pos.down());
            return blockState.isOf(this) && blockState.get(HALF) == DoubleBlockHalf.LOWER;
        }
    }

    public static BlockState withWaterloggedState(WorldView world, BlockPos pos, BlockState state) {
        return state.contains(Properties.WATERLOGGED) ? (BlockState)state.with(Properties.WATERLOGGED, world.isWater(pos)) : state;
    }

    public void onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        if (!world.isClient) {
            if (player.isCreative()) {
                onBreakInCreative(world, pos, state, player);
            } else {
                dropStacks(state, world, pos, (BlockEntity)null, player, player.getMainHandStack());
            }
        }

        super.onBreak(world, pos, state, player);
    }

    public void afterBreak(World world, PlayerEntity player, BlockPos pos, BlockState state, @Nullable BlockEntity blockEntity, ItemStack stack) {
        super.afterBreak(world, player, pos, Blocks.AIR.getDefaultState(), blockEntity, stack);
    }

    protected static void onBreakInCreative(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        DoubleBlockHalf doubleBlockHalf = (DoubleBlockHalf)state.get(HALF);
        if (doubleBlockHalf == DoubleBlockHalf.UPPER) {
            BlockPos blockPos = pos.down();
            BlockState blockState = world.getBlockState(blockPos);
            if (blockState.isOf(state.getBlock()) && blockState.get(HALF) == DoubleBlockHalf.LOWER) {
                BlockState blockState2 = blockState.contains(Properties.WATERLOGGED) && (Boolean)blockState.get(Properties.WATERLOGGED) ? Blocks.WATER.getDefaultState() : Blocks.AIR.getDefaultState();
                world.setBlockState(blockPos, blockState2, 35);
                world.syncWorldEvent(player, 2001, blockPos, Block.getRawIdFromState(blockState));
            }
        }

    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(HALF);
        builder.add(getAgeProperty());
        super.appendProperties(builder);
    }

    public OffsetType getOffsetType() {
        return OffsetType.XZ;
    }

    public long getRenderingSeed(BlockState state, BlockPos pos) {
        return MathHelper.hashCode(pos.getX(), pos.down(state.get(HALF) == DoubleBlockHalf.LOWER ? 0 : 1).getY(), pos.getZ());
    }

    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isIn(TFCTags.CAN_PLANT_GRASS_PLANTS_ON);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        int age = getAge(state);
        int modelAge = 0;
        //The last 2 ages are Dead and small Dead
        if (this == TFCObjects.BARLEY_CROP) {
            modelAge = age == 0 ? 1 :
                    age == 1 ? 2 :
                            age == 2 ? 3 :
                                    age == 3 ? 4 :
                                            age == 4 ? 5 :
                                                    age == 5 ? 6 :
                                                            age == 6 ? 7 :
                                                                    age == 7 ? 7 :
                                                                            age == 8 ? 7 : 2;
        }
        return AGE_TO_SHAPE[modelAge];
    }

    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (world.getBaseLightLevel(pos, 0) >= 9) {
            int i = this.getAge(state);
            if (i < this.getMaxAge()) {
                if (random.nextInt((int) (25.0F) + 1) == 0) {
                    world.setBlockState(pos, this.withAge(i + 1), Block.NOTIFY_LISTENERS);
                }
            }
        }

    }

    protected int getAge(BlockState state) {
        return (Integer) state.get(this.getAgeProperty());
    }

    public IntProperty getAgeProperty() {
//        return CROP_AGE_7;
        switch (MAX_AGE) {
            case 9:
                return AGE_7;
            case 8:
                return AGE_6;
            case 7:
                return AGE_5;
            default:
                return AGE_4;
        }
    }

    public int getMaxAge() {
        return MAX_AGE;
    }

    public BlockState withAge(int age) {
        return (BlockState) this.getDefaultState().with(this.getAgeProperty(), age);
    }

    public boolean isMature(BlockState state) {
        return (Integer) state.get(this.getAgeProperty()) >= this.getMaxAge();
    }

    public boolean hasRandomTicks(BlockState state) {
        return !this.isMature(state);
    }

    static {
        HALF = TFCProperties.HALF;
        AGE_7 = IntProperty.of("age", 0, 9);//Age + 2 for dead stage
        AGE_6 = IntProperty.of("age", 0, 8);
        AGE_5 = IntProperty.of("age", 0, 7);
        AGE_4 = IntProperty.of("age", 0, 6);
    }
}

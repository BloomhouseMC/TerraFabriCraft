package malek.terrafabricraft.common.block;

import malek.terrafabricraft.common.registry.TFCObjects;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.enums.DoubleBlockHalf;
import net.minecraft.item.ItemConvertible;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

import java.util.Random;

public class TFCCropsTall extends CropBlock {
    public static IntProperty CROP_AGE_5 = IntProperty.of("age", 0, 7);
    public static EnumProperty<DoubleBlockHalf> HALF = EnumProperty.of("half", DoubleBlockHalf.class);
    private static final VoxelShape LOWER_SHAPE_0 = Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 5.0D, 16.0D);
    private static final VoxelShape LOWER_SHAPE_1 = Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 13.0D, 16.0D);
    private static final VoxelShape UPPER_SHAPE_2 = Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 12.0D, 16.0D);
    private static final VoxelShape UPPER_SHAPE_3 = Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 14.0D, 16.0D);

    public TFCCropsTall(Settings settings, int temp, int speed) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(this.getAgeProperty(), 0).with(HALF, DoubleBlockHalf.LOWER));

    }
    //TODO: implement random tick to support lower and upper

    @Override
    public boolean isFertilizable(BlockView world, BlockPos pos, BlockState state, boolean isClient) {
        DoubleBlockHalf doubleBlockHalf = state.get(HALF);
        BlockPos otherHalfPos = doubleBlockHalf == DoubleBlockHalf.LOWER ? pos.up() : pos.down();
        int age = this.getAge(state) + 1;
        if(age == 2) {
            if(!world.getBlockState(otherHalfPos).isAir()) {
                return false;
            }
        }
        if(age >= 3) {
            if(!world.getBlockState(otherHalfPos).isOf(this)) {
                return false;
            }
        }
        return !this.isMature(state);
    }


    @Environment(EnvType.CLIENT)
    @Override
    protected ItemConvertible getSeedsItem() {
        return this == TFCObjects.JUTE_CROP ? TFCObjects.JUTE_SEED : TFCObjects.MAIZE_SEED;


    }
    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        DoubleBlockHalf doubleBlockHalf = state.get(HALF);
        int age = this.getAge(state);
        if(doubleBlockHalf == DoubleBlockHalf.LOWER) {
            if(age == 0) {
                return LOWER_SHAPE_0;
            }
            if(age == 1) {
                return LOWER_SHAPE_1;
            }
        }
        if(doubleBlockHalf == DoubleBlockHalf.UPPER) {
            if(age == 2) {
                return UPPER_SHAPE_2;
            }
            if(age == 3) {
                return UPPER_SHAPE_3;
            }
        }
        return VoxelShapes.fullCube();
    }

    @Override
    public IntProperty getAgeProperty() {
        return CROP_AGE_5;
    }

    @Override
    public int getMaxAge() {
        return 7;
    }

    @Override
    protected int getGrowthAmount(World world) {
        return 1;
    }
    //TODO: This method stops the crop from growing to the last two stages, the dead stages
    @Override
    public void applyGrowth(World world, BlockPos pos, BlockState state) {
        DoubleBlockHalf doubleBlockHalf = state.get(HALF);
        int age = this.getAge(state) + this.getGrowthAmount(world);
        int maxAge = this.getMaxAge();
        if(age > maxAge) {
            age = maxAge;
        }
        world.setBlockState(pos, this.withAge(age).with(HALF, doubleBlockHalf), 2);
        if(age >= 2) {
            world.setBlockState(doubleBlockHalf == DoubleBlockHalf.LOWER ? pos.up() : pos.down(), this.withAge(age).with(HALF, doubleBlockHalf == DoubleBlockHalf.LOWER ? DoubleBlockHalf.UPPER : DoubleBlockHalf.LOWER), 2);
        }
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(HALF, CROP_AGE_5);
    }

}

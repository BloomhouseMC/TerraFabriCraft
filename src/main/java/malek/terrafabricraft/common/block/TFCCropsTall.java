package malek.terrafabricraft.common.block;

import malek.terrafabricraft.common.registry.TFCObjects;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import java.util.Random;

public class TFCCropsTall extends CropBlock {
    public static IntegerProperty CROP_AGE_5 = IntegerProperty.create("age", 0, 7);
    public static EnumProperty<DoubleBlockHalf> HALF = EnumProperty.create("half", DoubleBlockHalf.class);
    private static final VoxelShape LOWER_SHAPE_0 = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 5.0D, 16.0D);
    private static final VoxelShape LOWER_SHAPE_1 = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 13.0D, 16.0D);
    private static final VoxelShape UPPER_SHAPE_2 = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 12.0D, 16.0D);
    private static final VoxelShape UPPER_SHAPE_3 = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 14.0D, 16.0D);

    public TFCCropsTall(Properties settings, int temp, int speed) {
        super(settings);
        this.registerDefaultState(this.stateDefinition.any().setValue(this.getAgeProperty(), 0).setValue(HALF, DoubleBlockHalf.LOWER));

    }
    //TODO: implement random tick to support lower and upper

    @Override
    public boolean isValidBonemealTarget(BlockGetter world, BlockPos pos, BlockState state, boolean isClient) {
        DoubleBlockHalf doubleBlockHalf = state.getValue(HALF);
        BlockPos otherHalfPos = doubleBlockHalf == DoubleBlockHalf.LOWER ? pos.above() : pos.below();
        int age = this.getAge(state) + 1;
        if(age == 2) {
            if(!world.getBlockState(otherHalfPos).isAir()) {
                return false;
            }
        }
        if(age >= 3) {
            if(!world.getBlockState(otherHalfPos).is(this)) {
                return false;
            }
        }
        return !this.isMaxAge(state);
    }


    @Environment(EnvType.CLIENT)
    @Override
    protected ItemLike getBaseSeedId() {
        return this == TFCObjects.JUTE_CROP ? TFCObjects.JUTE_SEED : TFCObjects.MAIZE_SEED;


    }
    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        DoubleBlockHalf doubleBlockHalf = state.getValue(HALF);
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
        return Shapes.block();
    }

    @Override
    public IntegerProperty getAgeProperty() {
        return CROP_AGE_5;
    }

    @Override
    public int getMaxAge() {
        return 7;
    }

    @Override
    protected int getBonemealAgeIncrease(Level world) {
        return 1;
    }
    //TODO: This method stops the crop from growing to the last two stages, the dead stages
    @Override
    public void growCrops(Level world, BlockPos pos, BlockState state) {
        DoubleBlockHalf doubleBlockHalf = state.getValue(HALF);
        int age = this.getAge(state) + this.getBonemealAgeIncrease(world);
        int maxAge = this.getMaxAge();
        if(age > maxAge) {
            age = maxAge;
        }
        world.setBlock(pos, this.getStateForAge(age).setValue(HALF, doubleBlockHalf), 2);
        if(age >= 2) {
            world.setBlock(doubleBlockHalf == DoubleBlockHalf.LOWER ? pos.above() : pos.below(), this.getStateForAge(age).setValue(HALF, doubleBlockHalf == DoubleBlockHalf.LOWER ? DoubleBlockHalf.UPPER : DoubleBlockHalf.LOWER), 2);
        }
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(HALF, CROP_AGE_5);
    }

}

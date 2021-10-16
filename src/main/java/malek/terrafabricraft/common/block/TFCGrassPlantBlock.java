package malek.terrafabricraft.common.block;

import malek.terrafabricraft.common.registry.TFCObjects;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.PlantBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

import java.util.Random;

public class TFCGrassPlantBlock extends PlantBlock {
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

    static {
        AGE_7 = IntProperty.of("age", 0, 9);//Age + 2 for dead stage
        AGE_6 = IntProperty.of("age", 0, 8);
        AGE_5 = IntProperty.of("age", 0, 7);
        AGE_4 = IntProperty.of("age", 0, 6);
    }

    public final int MAX_AGE;

    //TODO: Both temp and hardy is unnecessary
    public TFCGrassPlantBlock(Settings settings, int temp, int speed, int collisionLevel, int maxAge) {
        super(settings);
        MAX_AGE = maxAge;

    }

    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isIn(TFCObjects.CAN_PLANT_GRASS_PLANTS_ON);
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

    protected int getGrowthAmount(World world) {
        return 1;
    }

    //TODO: This method stops the crop from growing to the last two stages, the dead stages
    public void applyGrowth(World world, BlockPos pos, BlockState state) {
        int i = this.getAge(state) + this.getGrowthAmount(world);
        int j = this.getMaxAge();
        if (i > j) {
            i = j;
        }
        if (this.getAge(state) + 1 < this.getMaxAge() - 1) {
            world.setBlockState(pos, this.withAge(i), 2);
        }
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(getAgeProperty());
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

}

package com.bloomhousemc.terrafabricraft.common.block.plant;

import com.bloomhousemc.terrafabricraft.common.registry.TfcBlocks;
import com.bloomhousemc.terrafabricraft.common.registry.TfcTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

/**
 * For plants that can be planted on top of grass blocks (not dirt or on the bottom or side of blocks)
 */
public class TfcGrassPlantBlock extends TfcAbstractPlantBlock {
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
    public static IntProperty AGE_7 = IntProperty.of("stage", 0, 9);
    public static IntProperty AGE_6 = IntProperty.of("stage", 0, 8);
    public static IntProperty AGE_5 = IntProperty.of("stage", 0, 7);
    public static IntProperty AGE_4 = IntProperty.of("stage", 0, 6);

    //TODO: Both temp and hardy are unnecessary
    public TfcGrassPlantBlock(Settings settings, int temp, int speed, int collisionLevel, int maxStage) {
        super(collisionLevel, maxStage, settings);
    }

    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        System.out.println("test2" + world.getBlockState(pos.up()));
        if (world.getBlockState(pos.up()).isIn(TfcTags.GRASS_PLANTS)) return floor.isIn(TfcTags.GRASS_BLOCKS);
        else return floor.isIn(TfcTags.DIRT);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        int age = getAge(state);
        int modelAge = 0;
        //The last 2 ages are Dead and small Dead
        //TODO: Uncomment this
//        if (this == TfcBlocks.BARLEY_CROP) {
//            modelAge = age == 0 ? 1 :
//                    age == 1 ? 2 :
//                            age == 2 ? 3 :
//                                    age == 3 ? 4 :
//                                            age == 4 ? 5 :
//                                                    age == 5 ? 6 :
//                                                            age == 6 ? 7 :
//                                                                    age == 7 ? 7 :
//                                                                            age == 8 ? 7 : 2;
//        }
        return AGE_TO_SHAPE[modelAge];
    }


    protected int getAge(BlockState state) {
        return (Integer) state.get(AGE);
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
        builder.add(AGE);
    }

    public BlockState withAge(int age) {
        return (BlockState) this.getDefaultState().with(AGE, age);
    }

    public boolean isMature(BlockState state) {
        return (Integer) state.get(AGE) >= this.getMaxAge();
    }

    public boolean hasRandomTicks(BlockState state) {
        return !this.isMature(state);
    }

}

package com.bloomhousemc.terrafabricraft.common.block;

import com.bloomhousemc.terrafabricraft.common.registry.TFCObjects;
import com.bloomhousemc.terrafabricraft.common.registry.TFCTags;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.ItemConvertible;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;


public class TFCCrops extends CropBlock {
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
    public static IntProperty CROP_AGE_7;
    public static IntProperty CROP_AGE_6;//Beet, Greenbean, Onion, Potato, Bell Pepper, Soybean
    public static IntProperty CROP_AGE_5;//Cabbage, Jute, Maize
    public static IntProperty CROP_AGE_4;//Carrot, Garlic

    static {
        CROP_AGE_7 = IntProperty.of("age", 0, 9);//Age + 2 for dead stage
        CROP_AGE_6 = IntProperty.of("age", 0, 8);
        CROP_AGE_5 = IntProperty.of("age", 0, 7);
        CROP_AGE_4 = IntProperty.of("age", 0, 6);
    }

    public final ItemConvertible seedItem;
    public final int maxAge;

    //TODO: Both temp and hardy is unnecessary

    //TODO: Move most of the methods also in TFCGrassPlantBlock to a common interface with default methods
    /**
     *
     * @param settings
     * @param temp Should maybe be an array for the hottest and coldest temperature the crop can survive in
     * @param speed Growth speed of the crop.
     * @param seedItem Id of the crop seed.
     * @param maxAge Amount of age blockstates, should be full growth state plus two dead states.
     * TODO: @param maxStage Amount of stage blockstates.
     * TODO: @param collisionLevel Should be an enum value like Small, Medium, or Big for how much to slow down the player when colliding with the crop.
     * TODO: @param collisionShape How big to make the crop's collision box, should maybe be an enum like collisionLevel's or else a different class for each size of crop.
     */
    public TFCCrops(Settings settings, int temp, int speed, ItemConvertible seedItem, int maxAge) {
        super(settings);
        this.seedItem = seedItem;
        this.maxAge = maxAge;

    }

    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isIn(TFCTags.CAN_PLANT_CROPS_ON);
    }

    @Environment(EnvType.CLIENT)
    @Override
    protected ItemConvertible getSeedsItem() {
        return seedItem;


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

    @Override
    public IntProperty getAgeProperty() {
//        return CROP_AGE_7;
        switch (maxAge) {
            case 9:
                return CROP_AGE_7;
            case 8:
                return CROP_AGE_6;
            case 7:
                return CROP_AGE_5;
            default:
                return CROP_AGE_4;
        }
    }

    @Override
    public int getMaxAge() {
        return maxAge;
    }

    @Override
    protected int getGrowthAmount(World world) {
        return 1;
    }

    //TODO: This method stops the crop from growing to the last two stages, the dead stages
    @Override
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

}

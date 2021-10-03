package malek.terrafabricraft.common.block;

import malek.terrafabricraft.common.registry.TFCObjects;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemConvertible;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

import static malek.terrafabricraft.common.registry.TFCObjects.CAN_PLANT_GRASS_ON;

public class TFCGrassCrop extends CropBlock {
    public static IntProperty CROP_AGE_7 = IntProperty.of("age", 0, 9);//Barley, Melon, Oat, Pumpkin, Rice, Rye, Squash, Sugarcane, Tomato, Wheat
    private final int COLLISION_LEVEL;
    //public static IntProperty CROP_AGE_6;//Beet, Greenbean, Onion, Potato, Bell Pepper, Soybean
    //public static IntProperty CROP_AGE_5;//Cabbage, Jute, Maize
    //public static IntProperty CROP_AGE_4;//Carrot, Garlic

    //TODO: Both temp and hardy is unnecessary
    public TFCGrassCrop(Settings settings, int temp, int speed, int collisionLevel) {
        super(settings);
        COLLISION_LEVEL = collisionLevel;
    }

    static {
        //CROP_AGE_7 = IntProperty.of("age", 0, 9);//Age + 2 for dead stage
        //CROP_AGE_6 = IntProperty.of("age", 0, 8);
        //CROP_AGE_5 = IntProperty.of("age", 0, 7);
        //CROP_AGE_4 = IntProperty.of("age", 0, 6);
    }

    private static final VoxelShape[] AGE_TO_SHAPE = {
            Block.createCuboidShape(0, 0, 0, 16, 2, 16),
            Block.createCuboidShape(0, 0, 0, 16, 4, 16),
            Block.createCuboidShape(0, 0, 0, 16, 6, 16),
            Block.createCuboidShape(0, 0, 0, 16, 8, 16),
            Block.createCuboidShape(0, 0, 0, 16, 10, 16),
            Block.createCuboidShape(0, 0, 0, 16, 12, 16),
            Block.createCuboidShape(0, 0, 0, 16, 14, 16),
            Block.createCuboidShape(0, 0, 0, 16, 16, 16)};


    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isIn(CAN_PLANT_GRASS_ON);
    }

    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        if (entity.isPlayer()) {
            PlayerEntity player = (PlayerEntity) entity;
            if (!player.isCreative())
                player.slowMovement(state, new Vec3d(1.8D, 1.8D, 1.8D));
        }
    }

    @Environment(EnvType.CLIENT)
    @Override
    protected ItemConvertible getSeedsItem() {
        return this == TFCObjects.BARLEY_CROP ? TFCObjects.BARLEY_SEED :
                this == TFCObjects.CABBAGE_CROP ? TFCObjects.CABBAGE_SEED :
                        this == TFCObjects.CARROT_CROP ? TFCObjects.CARROT_SEED :
                                this == TFCObjects.GARLIC_CROP ? TFCObjects.GARLIC_SEED :
                                        this == TFCObjects.GREENBEAN_CROP ? TFCObjects.GREENBEAN_SEED :
                                                this == TFCObjects.OAT_CROP ? TFCObjects.OAT_SEED :
                                                        this == TFCObjects.ONION_CROP ? TFCObjects.ONION_SEED :
                                                                this == TFCObjects.POTATO_CROP ? TFCObjects.POTATO_SEED :
                                                                        this == TFCObjects.RED_BELL_PEPPER_CROP ? TFCObjects.RED_BELL_PEPPER_SEED :
                                                                                this == TFCObjects.RICE_CROP ? TFCObjects.RICE_SEED :
                                                                                        this == TFCObjects.RUTABAGA_CROP ? TFCObjects.RUTABAGA_SEED :
                                                                                                this == TFCObjects.RYE_CROP ? TFCObjects.RYE_SEED :
                                                                                                        this == TFCObjects.SOYBEAN_CROP ? TFCObjects.SOYBEAN_SEED :
                                                                                                                this == TFCObjects.SQUASH_CROP ? TFCObjects.SQUASH_SEED :
                                                                                                                        this == TFCObjects.TOMATO_CROP ? TFCObjects.TOMATO_SEED :
                                                                                                                                this == TFCObjects.WHEAT_CROP ? TFCObjects.WHEAT_SEED : TFCObjects.YELLOW_BELL_PEPPER_SEED;


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
        return CROP_AGE_7;
    }
    /*
     @Override
    public IntProperty getAgeProperty() {
        return  this == TFCObjects.GREENBEAN_CROP ? CROP_AGE_6:
                this == TFCObjects.ONION_CROP ? CROP_AGE_6:
                this == TFCObjects.RED_BELL_PEPPER_CROP ? CROP_AGE_6:
                this == TFCObjects.SOYBEAN_CROP ? CROP_AGE_6:
                this == TFCObjects.POTATO_CROP ? CROP_AGE_6:
                this == TFCObjects.YELLOW_BELL_PEPPER_CROP ? CROP_AGE_6:

                this == TFCObjects.CABBAGE_CROP ? CROP_AGE_5:
                this == TFCObjects.JUTE_CROP ? CROP_AGE_5:
                this == TFCObjects.MAIZE_CROP ? CROP_AGE_5:

                this == TFCObjects.CARROT_CROP ? CROP_AGE_4:
                this == TFCObjects.GARLIC_CROP ? CROP_AGE_4: CROP_AGE_7;
    }
     */


    @Override
    public int getMaxAge() {
        return this == TFCObjects.GREENBEAN_CROP ? 8 :
                this == TFCObjects.ONION_CROP ? 8 :
                        this == TFCObjects.RED_BELL_PEPPER_CROP ? 8 :
                                this == TFCObjects.SOYBEAN_CROP ? 8 :
                                        this == TFCObjects.POTATO_CROP ? 8 :
                                                this == TFCObjects.YELLOW_BELL_PEPPER_CROP ? 8 :

                                                        this == TFCObjects.CABBAGE_CROP ? 7 :

                                                                this == TFCObjects.CARROT_CROP ? 6 :
                                                                        this == TFCObjects.GARLIC_CROP ? 6 : 9;
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

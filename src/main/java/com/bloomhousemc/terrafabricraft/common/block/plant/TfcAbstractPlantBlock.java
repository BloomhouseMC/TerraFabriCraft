package com.bloomhousemc.terrafabricraft.common.block.plant;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.PlantBlock;
import net.minecraft.entity.Entity;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public abstract class TfcAbstractPlantBlock extends PlantBlock {
    public static final int MAX_AGE = 3;
    public static final IntProperty AGE = Properties.AGE_3;
    public static final IntProperty STAGE_10 = IntProperty.of("stage", 0, 9);
    public static final IntProperty STAGE_9 = IntProperty.of("stage", 0, 9);
    public static final IntProperty STAGE_8 = IntProperty.of("stage", 0, 8);
    public static final IntProperty STAGE_7 = IntProperty.of("stage", 0, 7);
    public static final IntProperty STAGE_6 = IntProperty.of("stage", 0, 6);
    public static final IntProperty STAGE_5 = IntProperty.of("stage", 0, 5);
    public static final IntProperty STAGE_4 = IntProperty.of("stage", 0, 4);
    public final int MAX_STAGE;
    public final int COLLISION_LEVEL;

    protected TfcAbstractPlantBlock(int collisionLevel, int maxStage, Settings settings) {
        super(settings);
        MAX_STAGE = maxStage;
        COLLISION_LEVEL = collisionLevel;
    }

    @Override
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        switch (COLLISION_LEVEL) {
            case 1:
                entity.slowMovement(state, new Vec3d(0.25, 0.05F, 0.25));
            case 2:
                entity.slowMovement(state, new Vec3d(0.25, 0.05F, 0.25));
                // case 3
            case 3:
                entity.slowMovement(state, new Vec3d(0.25, 0.05F, 0.25));
            default:
                throw new IndexOutOfBoundsException("Collision level can only be between 1 and 3.");
        }
    }

    public IntProperty getStageProperty() {
//        return CROP_AGE_7;
        switch (MAX_STAGE) {
            case 9:
                return STAGE_9;
            case 8:
                return STAGE_8;
            case 7:
                return STAGE_7;
            case 6:
                return STAGE_6;
            case 5:
                return STAGE_5;
            case 4:
                return STAGE_4;
            default:
                throw new IndexOutOfBoundsException();
        }
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(getStageProperty(), AGE);
    }
}

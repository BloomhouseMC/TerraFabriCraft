package io.github.bloomhousemc.terrafabricraft.common.util;

import net.minecraft.block.Block;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;

public class BlockShapes {
    public static final VoxelShape FLAT_BUSH;
    public static final VoxelShape MEDIUM_BUSH;
    public static final VoxelShape LARGE_BUSH;
    public static final VoxelShape[] SHAPE_LAYERS;

    static {
        FLAT_BUSH = Block.createCuboidShape(0D, 0D, 0D, 16D, 4D, 16D);
        MEDIUM_BUSH = Block.createCuboidShape(0D, 0D, 0D, 16D, 8D, 16D);
        LARGE_BUSH = Block.createCuboidShape(0D, 0D, 0D, 16D, 16D, 16D);
        SHAPE_LAYERS = new VoxelShape[]{VoxelShapes.empty(), Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D), Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 4.0D, 16.0D), Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 6.0D, 16.0D), Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D), Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 10.0D, 16.0D), Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 12.0D, 16.0D), Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 14.0D, 16.0D), Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D)};
    }
}

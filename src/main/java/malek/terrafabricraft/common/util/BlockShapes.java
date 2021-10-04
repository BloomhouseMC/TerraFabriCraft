package malek.terrafabricraft.common.util;

import net.minecraft.block.Block;
import net.minecraft.util.shape.VoxelShape;

public class BlockShapes {
    public static final VoxelShape FLAT_BUSH;
    public static final VoxelShape MEDIUM_BUSH;
    public static final VoxelShape LARGE_BUSH;

    static {
        FLAT_BUSH = Block.createCuboidShape(0D, 0D, 0D, 16D, 4D, 16D);
        MEDIUM_BUSH = Block.createCuboidShape(0D, 0D, 0D, 16D, 8D, 16D);
        LARGE_BUSH = Block.createCuboidShape(0D, 0D, 0D, 16D, 16D, 16D);
    }
}

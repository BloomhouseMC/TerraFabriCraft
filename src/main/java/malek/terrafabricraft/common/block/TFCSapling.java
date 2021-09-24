package malek.terrafabricraft.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SaplingBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public class TFCSapling extends SaplingBlock {

    public TFCSapling(SaplingGenerator generator, Settings settings) {
        super(generator, settings);
    }
}

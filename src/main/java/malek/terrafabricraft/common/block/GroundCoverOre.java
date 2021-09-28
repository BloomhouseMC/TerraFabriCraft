package malek.terrafabricraft.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class GroundCoverOre extends GroundCoverBlock {
    public GroundCoverOre(Properties settings) {
        super(settings);
    }

    public GroundCoverOre(Properties settings, Item dropItem) {
        super(settings, dropItem);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return Block.box(6, 0, 6, 12, 2, 12);
    }
}

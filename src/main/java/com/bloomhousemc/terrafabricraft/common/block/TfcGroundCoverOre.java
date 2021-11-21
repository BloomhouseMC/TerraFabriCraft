package com.bloomhousemc.terrafabricraft.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public class TfcGroundCoverOre extends TfcGroundCoverBlock {
    public TfcGroundCoverOre(Settings settings) {
        super(settings);
    }

    public TfcGroundCoverOre(Settings settings, Item dropItem) {
        super(settings, dropItem);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return Block.createCuboidShape(6, 0, 6, 12, 2, 12);
    }
}

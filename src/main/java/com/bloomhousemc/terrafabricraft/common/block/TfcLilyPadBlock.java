package com.bloomhousemc.terrafabricraft.common.block;

import com.bloomhousemc.terrafabricraft.common.registry.TfcBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.LilyPadBlock;
import net.minecraft.block.Material;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

public class TfcLilyPadBlock extends LilyPadBlock {
    public TfcLilyPadBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        FluidState fluidState = world.getFluidState(pos);
        FluidState fluidState2 = world.getFluidState(pos.up());
        //TODO What does this do?
        return (fluidState.getBlockState() == TfcBlocks.ALABASTER_RAW_ALABASTER.getDefaultState() || floor.getMaterial() == Material.ICE) && fluidState2.getFluid() == Fluids.EMPTY;
    }
}

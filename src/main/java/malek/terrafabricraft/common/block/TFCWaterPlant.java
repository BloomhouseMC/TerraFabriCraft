package malek.terrafabricraft.common.block;

import malek.terrafabricraft.common.registry.TFCTags;
import net.minecraft.block.BlockState;
import net.minecraft.block.FluidFillable;
import net.minecraft.block.PlantBlock;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;

public class TFCWaterPlant extends PlantBlock implements FluidFillable {
    public TFCWaterPlant(Settings settings) {
        super(settings);
    }

    @Override
    public boolean canFillWithFluid(BlockView world, BlockPos pos, BlockState state, Fluid fluid) {
        return false;
    }

    @Override
    public boolean tryFillWithFluid(WorldAccess world, BlockPos pos, BlockState state, FluidState fluidState) {
        return false;
    }

    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isIn(TFCTags.CAN_PLANT_SALT_WATER_PLANTS_ON);
    }
}

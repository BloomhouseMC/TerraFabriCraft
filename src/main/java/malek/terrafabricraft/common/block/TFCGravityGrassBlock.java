package malek.terrafabricraft.common.block;


import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.GrassBlock;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Property;

public class TFCGravityGrassBlock extends GrassBlock {

    public TFCGravityGrassBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{SNOWY});
    }
}

package malek.terrafabricraft.common.block.toolrack;

import malek.terrafabricraft.common.registry.TFCObjects;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;

public class ToolRackBlockEntity extends BlockEntity {
    public ToolRackBlockEntity(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState) {
        super(blockEntityType, blockPos, blockState);
    }

    public ToolRackBlockEntity(BlockPos pos, BlockState state) {
        super(TFCObjects.TOOL_RACK_BLOCK_ENTITY, pos, state);
    }
}

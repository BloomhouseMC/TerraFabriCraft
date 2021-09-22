package malek.terrafabricraft.common.block.entity;

import malek.terrafabricraft.common.registry.TFCObjects;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;

public class RockBlockEntity extends BlockEntity {
    public RockBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }
    public RockBlockEntity(BlockPos pos, BlockState state) {
        this(TFCObjects.ROCK_BLOCK_ENTITY, pos, state);
    }
}

package malek.terrafabricraft.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

public class TFCLeaves extends LeavesBlock {
    public TFCLeaves(Properties settings) {
        super(settings);
    }

    @Override
    public void entityInside(BlockState state, Level world, BlockPos pos, Entity entity) {
        if (entity.isAlwaysTicking()) {
            Player player = (Player) entity;
            if (!player.isCreative())
                player.makeStuckInBlock(state, new Vec3(1.7D, 1.7D, 1.7D));
        }
    }

}

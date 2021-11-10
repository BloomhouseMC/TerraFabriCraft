package io.github.bloomhousemc.terrafabricraft.common.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.LeavesBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class TFCLeaves extends LeavesBlock {
    public TFCLeaves(Settings settings) {
        super(settings);
    }

    @Override
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        if (entity.isPlayer()) {
            PlayerEntity player = (PlayerEntity) entity;
            if (!player.isCreative())
                player.slowMovement(state, new Vec3d(1.7D, 1.7D, 1.7D));
        }
    }

}

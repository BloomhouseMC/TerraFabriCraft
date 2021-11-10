package io.github.bloomhousemc.terrafabricraft.mixin.common;

import io.github.bloomhousemc.terrafabricraft.common.block.logpile.LogPile;
import io.github.bloomhousemc.terrafabricraft.common.block.logpile.LogPileBlockEntity;
import io.github.bloomhousemc.terrafabricraft.common.registry.TFCObjects;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.Items;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ItemEntity.class)
public class ItemEntityMixin {

    @Inject(method = "tick", at = @At("HEAD"))
    public void tickMixin(CallbackInfo ci) {
        ItemEntity itemEntity = (ItemEntity) (Object)this;
        if (itemEntity.getStack().getItem() != Items.TORCH) {
            return;
        }
        World world = itemEntity.getEntityWorld();
        if (!(world.getBlockState(itemEntity.getBlockPos().down()).getBlock() instanceof LogPile)) {
            return;
        }

        LogPileBlockEntity logPileBlockEntity = (LogPileBlockEntity)world.getBlockEntity(itemEntity.getBlockPos().down());
        logPileBlockEntity.fireTicks++;
        if(logPileBlockEntity.fireTicks >= 140) {
            setLogpilesToFire(world, itemEntity.getBlockPos().down());
        }

            world.addParticle(ParticleTypes.SMOKE, itemEntity.getX(), itemEntity.getY(), itemEntity.getZ(), 0.0F, 0.1F, 0.0F);
            world.addParticle(ParticleTypes.FLAME, itemEntity.getX(), itemEntity.getY(), itemEntity.getZ(), 0.0F, 0.1F, 0.0F);

    }
    private void setLogpilesToFire(World world, BlockPos startingPos) {
        if(!(world.getBlockState(startingPos).getBlock() instanceof LogPile)) {
           return;
        }
        for(Direction direction : Direction.values()) {
                world.setBlockState(startingPos, TFCObjects.BURNING_LOG_PILE.getDefaultState());
                setLogpilesToFire(world, startingPos.offset(direction));
        }
    }

}

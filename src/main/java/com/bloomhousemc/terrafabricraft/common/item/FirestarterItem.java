package com.bloomhousemc.terrafabricraft.common.item;

import com.bloomhousemc.terrafabricraft.common.registry.TFCSounds;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;

import java.util.Random;

public class FirestarterItem extends Item {

    public FirestarterItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        if (context.getHand() != Hand.MAIN_HAND || world.isClient)
            return ActionResult.PASS;
        PlayerEntity player = context.getPlayer();
        if (player == null)
            return ActionResult.FAIL;
        player.setCurrentHand(Hand.MAIN_HAND);
        return ActionResult.SUCCESS;
    }

    @Override
    public void usageTick(World world, LivingEntity user, ItemStack stack, int ticksLeft) {
        if (user instanceof PlayerEntity player) {
            BlockHitResult result = raycast(world, player, RaycastContext.FluidHandling.NONE);
            BlockPos pos = result.getBlockPos();
            BlockPos upPos = pos.up();
            // The "1" at the beginning is the base chance. Later in configs this could possibly set to: 0.5, 0, or 1
            double chance = 1 * (world.hasRain(upPos) ? 0.3 : 1);
            if (world.isClient) {
                Vec3d location = result.getPos();
                createParticles(world, player, location.getX(), location.getY(), location.getZ(), ticksLeft, getMaxUseTime(stack), world.random);
            } else if (ticksLeft == 1) {
                if (world.getBlockState(upPos).isAir()) {
                    world.setBlockState(upPos, Blocks.FIRE.getDefaultState(), 11);
                    if (!player.getAbilities().creativeMode) {
                        stack.damage(1, player, (p) -> { p.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND); });
                    }
                }
            }
        }
    }

    private void createParticles(World world, PlayerEntity player, double x, double y, double z, int countLeft, int total, Random random) {
        int count = total - countLeft;
        if (random.nextFloat() + 0.3 < count / (double) total) {
            world.addParticle(ParticleTypes.SMOKE, x, y, z, 0.0F, 0.1F, 0.0F);
        }

        if (countLeft < 10 && random.nextFloat() + 0.3 < count / (double) total) {
            world.addParticle(ParticleTypes.FLAME, x, y, z, 0.0F, 0.1F, 0.0F);
        }

        if (count % 3 == 1) {
            if (random.nextFloat() <= 0.3F) {
                player.playSound(TFCSounds.FIRESTARTER2, 0.5F, 0.05F);
            } else if (random.nextFloat() <= 0.3F) {
                player.playSound(TFCSounds.FIRESTARTER3, 0.5F, 0.05F);
            } else
                player.playSound(TFCSounds.FIRESTARTER1, 0.5F, 0.05F);
        }
    }

    @Override
    public int getMaxUseTime(ItemStack stack) {
        return 72;
    }
}

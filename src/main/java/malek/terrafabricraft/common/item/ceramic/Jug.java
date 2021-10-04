package malek.terrafabricraft.common.item.ceramic;

import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.block.BlockState;
import net.minecraft.block.FluidDrainable;
import net.minecraft.block.FluidFillable;
import net.minecraft.entity.AreaEffectCloudEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.*;
import net.minecraft.potion.PotionUtil;
import net.minecraft.potion.Potions;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.tag.FluidTags;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;

public class Jug extends Item {

    private final Fluid fluid;
    public Jug(Fluid fluid, Settings settings) {
        super(settings);
        this.fluid = fluid;
    }
    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.DRINK;
    }
    @Override
    public int getMaxUseTime(ItemStack stack) {
        return 32;
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {

        return stack;
    }
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
            HitResult hitResult = raycast(world, user, RaycastContext.FluidHandling.SOURCE_ONLY);
            if (hitResult.getType() == HitResult.Type.MISS) {
                return TypedActionResult.pass(itemStack);
            } else {
                if (hitResult.getType() == HitResult.Type.BLOCK) {
                    BlockPos blockPos = ((BlockHitResult)hitResult).getBlockPos();
                    if (!world.canPlayerModifyAt(user, blockPos)) {
                        return TypedActionResult.pass(itemStack);
                    }

                    if (world.getFluidState(blockPos).isIn(FluidTags.WATER)) {
                        world.playSound(user, user.getX(), user.getY(), user.getZ(), SoundEvents.ITEM_BOTTLE_FILL, SoundCategory.NEUTRAL, 1.0F, 1.0F);
                        world.emitGameEvent(user, GameEvent.FLUID_PICKUP, blockPos);
                        return TypedActionResult.success(this.fill(itemStack, user, PotionUtil.setPotion(new ItemStack(Items.POTION), Potions.WATER)), world.isClient());
                    }
                }

                return TypedActionResult.pass(itemStack);
            }
        }

    protected ItemStack fill(ItemStack stack, PlayerEntity player, ItemStack outputStack) {
        player.incrementStat(Stats.USED.getOrCreateStat(this));
        return ItemUsage.exchangeStack(stack, player, outputStack);
    }
}

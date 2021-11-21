package com.bloomhousemc.terrafabricraft.common.item;

import com.bloomhousemc.terrafabricraft.common.api.type.MetalType;
import com.bloomhousemc.terrafabricraft.common.registry.TfcBlocks;
import com.bloomhousemc.terrafabricraft.common.api.type.RockType;
import com.bloomhousemc.terrafabricraft.common.registry.TfcTags;
import com.bloomhousemc.terrafabricraft.common.util.damage.CrushingDamageSource;
import com.bloomhousemc.terrafabricraft.common.util.damage.DamageTypeUtil;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.BlockState;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.tag.BlockTags;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class HammerItem extends ToolItem implements Vanishable {
    private final RockType.RockCategory category;
    private final MetalType metalType;

    public HammerItem(ToolMaterial toolMaterial, @Nullable RockType.RockCategory category, @Nullable MetalType metalType, Settings settings) {
        super(toolMaterial, settings);
        this.category = category;
        this.metalType = metalType;
    }

    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        PlayerEntity player = context.getPlayer();
        ItemStack stack = context.getStack();
        BlockPos pos = context.getBlockPos();
        BlockState state = world.getBlockState(pos);

        if (state.isIn(TfcTags.RAW_IGNEOUS)) {
            world.setBlockState(pos, TfcBlocks.METAL_ANVIL_STEEL.getDefaultState());
            stack.damage(1, player, (e) -> {
                e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND);
            });
            return ActionResult.CONSUME;
        }
        return ActionResult.PASS;
    }

    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (DamageTypeUtil.isWeakToCrushing(target)) {
            target.damage(new CrushingDamageSource(), 4.0F);
        } else if (DamageTypeUtil.isStrongAgainstCrushing(target)) {
            target.damage(new CrushingDamageSource(), 1.0F);
        } else {
            target.damage(new CrushingDamageSource(), 2.0F);
        }
        stack.damage(1, attacker, (e) -> {
            e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND);
        });
        return true;
    }

    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
        if (state.isIn(BlockTags.LOGS)) {
            stack.damage(1, miner, (e) -> {
                e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND);
            });
        }
        return true;
    }

    @Override
    @Environment(EnvType.CLIENT)
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if (metalType != null) {
            tooltip.add(new LiteralText("Metal Type:" + metalType).formatted(Formatting.DARK_GRAY));
        } else
            tooltip.add(new LiteralText("Rock Type:" + category).formatted(Formatting.DARK_GRAY));
    }
}

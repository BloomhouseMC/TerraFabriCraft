package com.bloomhousemc.terrafabricraft.common.event;

import com.bloomhousemc.terrafabricraft.common.block.logpile.LogPileBlockEntity;
import com.bloomhousemc.terrafabricraft.common.block.placeable.PlaceableBlock;
import com.bloomhousemc.terrafabricraft.common.block.placeable.PlaceableBlockEntity;
import com.bloomhousemc.terrafabricraft.common.registry.TFCObjects;
import com.bloomhousemc.terrafabricraft.common.registry.TFCTags;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;

import static com.bloomhousemc.terrafabricraft.common.util.TFCUtils.handleGUILessInventory;

public class TFCEvents {
    private static MinecraftServer currentServer;



    public static void init() {
        ServerLifecycleEvents.SERVER_STARTED.register((server -> currentServer = server));


        ServerLifecycleEvents.SERVER_STOPPED.register((server -> currentServer = null));



        UseBlockCallback.EVENT.register((player, world, hand, hitResult) -> {
            if(!TFCTags.CAN_LOGPILE.contains(player.getStackInHand(hand).getItem()) && TFCTags.PLACEABLE.contains(player.getStackInHand(hand).getItem())) return ActionResult.FAIL;
            BlockHitResult blockHitResult = hitResult;
            BlockPos pos = blockHitResult.getBlockPos().add(hitResult.getSide().getVector());
            BlockPos blockPos = new BlockPos(pos);
            Direction direction = player.getHorizontalFacing();
            if (player.isSneaking() && TFCTags.PLACEABLE.contains(player.getStackInHand(hand).getItem()) && world.getBlockState(hitResult.getBlockPos()) != TFCObjects.PLACEABLE.getDefaultState()) {
                BlockState newPlaceable = TFCObjects.PLACEABLE.getDefaultState();
                newPlaceable = TFCObjects.PLACEABLE.getDefaultState().with(Properties.HORIZONTAL_FACING, newPlaceable.get(PlaceableBlock.FACING));
                BlockPos checkAir = new BlockPos(pos.getX(), pos.getY() - 1, pos.getZ());
                if (world.getBlockState(checkAir).getBlock() != Blocks.AIR && world.getBlockState(checkAir).getBlock() != TFCObjects.PLACEABLE) {
                    world.setBlockState(blockPos, newPlaceable, 3);
                    BlockEntity placeableEntity = world.getBlockEntity(blockPos);
                    PlaceableBlockEntity placeableEntity1 = (PlaceableBlockEntity) placeableEntity;
                    double normalX = (hitResult.getPos().x - pos.getX());
                    double normalZ = (hitResult.getPos().z - pos.getZ());
                    if (normalX < 0.5 && normalZ > 0.5) handleGUILessInventory(player.getStackInHand(hand), player, hand, placeableEntity1.inventory, 2);
                    if (normalX > 0.5 && normalZ > 0.5) handleGUILessInventory(player.getStackInHand(hand), player, hand, placeableEntity1.inventory, 3);
                    if (normalX < 0.5 && normalZ < 0.5) handleGUILessInventory(player.getStackInHand(hand), player, hand, placeableEntity1.inventory, 0);
                    if (normalX > 0.5 && normalZ < 0.5) handleGUILessInventory(player.getStackInHand(hand), player, hand, placeableEntity1.inventory, 1);

                    return ActionResult.SUCCESS;
                }
                return ActionResult.PASS;
            }
            if (player.isSneaking() && TFCTags.CAN_LOGPILE.contains(player.getStackInHand(hand).getItem())) {
                BlockState newLogpile = TFCObjects.LOG_PILE.getDefaultState().with(Properties.AXIS, direction.getAxis());
                BlockPos checkAir = new BlockPos(pos.getX(), pos.getY() - 1, pos.getZ());
                if (world.getBlockState(checkAir).getBlock() != Blocks.AIR) {
                    world.setBlockState(blockPos, newLogpile, 3);
                    BlockEntity logEntity = world.getBlockEntity(blockPos);
                    LogPileBlockEntity logPileBlockEntity = (LogPileBlockEntity) logEntity;
                    logPileBlockEntity.inventory.set(0, player.getStackInHand(hand).split(1));
                    return ActionResult.SUCCESS;
                }
                return ActionResult.PASS;
            }
            return ActionResult.PASS;
        });

    }

    public static MinecraftServer getCurrentServer() {
        return currentServer;
    }


}

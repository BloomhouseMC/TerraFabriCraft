package malek.terrafabricraft.common.event;

import malek.terrafabricraft.common.block.logpile.LogPile;
import malek.terrafabricraft.common.block.logpile.LogPileBlockEntity;
import malek.terrafabricraft.common.block.placeable.PlaceableBlock;
import malek.terrafabricraft.common.block.placeable.PlaceableBlockEntity;
import malek.terrafabricraft.common.registry.TFCObjects;
import malek.terrafabricraft.common.registry.TFCTags;
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
import net.minecraft.util.math.Vec3i;

import static malek.terrafabricraft.common.util.TFCUtils.handleGUILessInventory;

public class TFCEvents {
    private static MinecraftServer currentServer;



    public static void init() {
        ServerLifecycleEvents.SERVER_STARTED.register((server -> currentServer = server));


        ServerLifecycleEvents.SERVER_STOPPED.register((server -> currentServer = null));



        //TODO: Change TFCObjects.CERAMIC_VESSEL to a TAG of all ceramics/placeable items instead.
        //This Callback lambda is responsible for generating a PlaceableBlock, upon Using an appropriate item which should be placeable in world.
        UseBlockCallback.EVENT.register((player, world, hand, hitResult) -> {
            if (player.isSneaking() && TFCTags.PLACEABLE.contains(player.getStackInHand(hand).getItem()) && world.getBlockState(hitResult.getBlockPos()) != TFCObjects.PLACEABLE.getDefaultState()) {
                BlockHitResult blockHitResult = hitResult;
                BlockPos pos = blockHitResult.getBlockPos().add(hitResult.getSide().getVector());
                //New BlockPos for the PlaceableBlock
                BlockPos blockPos = new BlockPos(pos);
                BlockState newPlaceable = TFCObjects.PLACEABLE.getDefaultState();
                newPlaceable = TFCObjects.PLACEABLE.getDefaultState().with(Properties.HORIZONTAL_FACING, newPlaceable.get(PlaceableBlock.FACING));
                //Check if the block under is valid
                //TODO: Add condition for a more narrow selection of full blocks.
                BlockPos checkAir = new BlockPos(pos.getX(), pos.getY() - 1, pos.getZ());
                if (world.getBlockState(checkAir).getBlock() != Blocks.AIR && world.getBlockState(checkAir).getBlock() != TFCObjects.PLACEABLE) {
                    //Place the PlaceableBlock
                    world.setBlockState(blockPos, newPlaceable, 3);
                    BlockEntity placeableEntity = world.getBlockEntity(blockPos);
                    PlaceableBlockEntity placeableEntity1 = (PlaceableBlockEntity) placeableEntity;
                    //Normalize X and Z coordinates to be 0-1 block length.
                    double normalX = (hitResult.getPos().x - pos.getX());
                    double normalZ = (hitResult.getPos().z - pos.getZ());
                    //With our Normailized coordinates get which part of the four corners of a block face to get depending on which is used.
                    if (normalX < 0.5 && normalZ > 0.5)
                        handleGUILessInventory(player.getStackInHand(hand), player, hand, placeableEntity1.inventory, 2);
                    if (normalX > 0.5 && normalZ > 0.5)
                        handleGUILessInventory(player.getStackInHand(hand), player, hand, placeableEntity1.inventory, 3);
                    if (normalX < 0.5 && normalZ < 0.5)
                        handleGUILessInventory(player.getStackInHand(hand), player, hand, placeableEntity1.inventory, 0);
                    if (normalX > 0.5 && normalZ < 0.5)
                        handleGUILessInventory(player.getStackInHand(hand), player, hand, placeableEntity1.inventory, 1);

                    return ActionResult.SUCCESS;
                }
                return ActionResult.PASS;
            }
            if (player.isSneaking() && TFCTags.CAN_LOGPILE.contains(player.getStackInHand(hand).getItem())) {
                BlockHitResult blockHitResult = hitResult;
                BlockPos pos = blockHitResult.getBlockPos().add(hitResult.getSide().getVector());
                //New BlockPos for the PlaceableBlock
                BlockPos blockPos = new BlockPos(pos);
                BlockState newPlaceable = TFCObjects.LOG_PILE.getDefaultState();
                Direction direction = player.getHorizontalFacing();
                newPlaceable = TFCObjects.LOG_PILE.getDefaultState().with(Properties.AXIS, direction.getAxis());
                //(BlockState)state.with(AXIS, Direction.Axis.Z);
                //Check if the block under is valid
                //TODO: Add condition for a more narrow selection of full blocks.
                BlockPos checkAir = new BlockPos(pos.getX(), pos.getY() - 1, pos.getZ());
                if (world.getBlockState(checkAir).getBlock() != Blocks.AIR) {
                    //Place the PlaceableBlock
                    world.setBlockState(blockPos, newPlaceable, 3);
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

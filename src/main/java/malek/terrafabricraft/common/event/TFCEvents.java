package malek.terrafabricraft.common.event;

import malek.terrafabricraft.common.block.placeable.PlaceableBlock;
import malek.terrafabricraft.common.block.placeable.PlaceableBlockEntity;
import malek.terrafabricraft.common.calendar.CalendarManager;
import malek.terrafabricraft.common.registry.TFCObjects;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;

import static malek.terrafabricraft.common.util.TFCUtils.handleGUILessInventory;

public class TFCEvents {
    private static MinecraftServer currentServer;



    public static void init() {
        ServerLifecycleEvents.SERVER_STARTED.register((server -> currentServer = server));


        ServerLifecycleEvents.SERVER_STOPPED.register((server -> currentserver = null));

        //TODO: Change TFCObjects.CERAMIC_VESSEL to a TAG of all ceramics/placeable items instead.

        //This Callback lambda is responsible for generating a PlaceableBlock, upon Using an appropriate item which should be placeable in world.
        UseBlockCallback.EVENT.register((player, world, hand, hitResult) -> {
            if (player.isSneaking() && player.getStackInHand(hand).getItem() == TFCObjects.CERAMIC_VESSEL && world.getBlockState(hitResult.getBlockPos()) != TFCObjects.PLACEABLE.getDefaultState()) {
                BlockPos pos = hitResult.getBlockPos();
                int newPosX = pos.getX();
                int newPosY = pos.getY();
                int newPosZ = pos.getZ();
                Direction direction = hitResult.getSide();
                //Depending on which side of a block the Placeable item is used on, choose the block next to it.
                switch (direction) {
                    case UP -> newPosY = pos.getY() + 1;
                    case DOWN -> newPosY = pos.getY() - 1;
                    case NORTH -> newPosZ = pos.getZ() - 1;
                    case SOUTH -> newPosZ = pos.getZ() + 1;
                    case EAST -> newPosX = pos.getX() + 1;
                    case WEST -> newPosX = pos.getX() - 1;
                }
                //Normalize X and Z coordinates to be 0-1 block length.
                double normalX = (hitResult.getPos().x - pos.getX());
                double normalZ = (hitResult.getPos().z - pos.getZ());

                //New BlockPos for the PlaceableBlock
                BlockPos blockPos = new BlockPos(newPosX, newPosY, newPosZ);
                BlockState newPlaceable = TFCObjects.PLACEABLE.getDefaultState();
                newPlaceable = TFCObjects.PLACEABLE.getDefaultState().with(Properties.HORIZONTAL_FACING, newPlaceable.get(PlaceableBlock.FACING));
                //Check if the block under is valid
                //TODO: Add condition for a more narrow selection of full blocks.
                BlockPos checkAir = new BlockPos(newPosX, newPosY - 1, newPosZ);
                if (world.getBlockState(checkAir).getBlock() != Blocks.AIR && world.getBlockState(checkAir).getBlock() != TFCObjects.PLACEABLE) {
                    //Place the PlaceableBlock
                    world.setBlockState(blockPos, newPlaceable, 3);
                    BlockEntity placeableEntity = world.getBlockEntity(blockPos);
                    PlaceableBlockEntity placeableEntity1 = (PlaceableBlockEntity) placeableEntity;
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
            return ActionResult.PASS;
        });

    }

    public static MinecraftServer getCurrentServer() {
        return currentServer;
    }


}

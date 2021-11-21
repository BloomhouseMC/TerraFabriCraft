package com.bloomhousemc.terrafabricraft.common.item;

import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Property;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;

public class TfcSupportItem extends BlockItem {
    public TfcSupportItem(Block block, Settings settings) {
        super(block, settings);
    }

    private static <T extends Comparable<T>> BlockState with(BlockState state, Property<T> property, String name) {
        return property.parse(name).map(value -> state.with(property, value)).orElse(state);
    }

    @Override
    public ActionResult place(ItemPlacementContext context) {
        if (!context.canPlace()) {
            return ActionResult.FAIL;
        } else {
            ItemPlacementContext itemPlacementContext = this.getPlacementContext(context);
            if (itemPlacementContext == null) {
                return ActionResult.FAIL;
            } else {
                var blockState = this.getPlacementState(itemPlacementContext);
                if (blockState == null) {
                    return ActionResult.FAIL;
                } else if (!this.place(itemPlacementContext, blockState)) {
                    return ActionResult.FAIL;
                } else {
                    var blockPos = itemPlacementContext.getBlockPos();
                    var world = itemPlacementContext.getWorld();
                    var playerEntity = itemPlacementContext.getPlayer();
                    var itemStack = itemPlacementContext.getStack();
                    var blockState2 = world.getBlockState(blockPos);
                    if (blockState2.isOf(blockState.getBlock())) {
                        blockState2 = placeFromTag(blockPos, world, itemStack, blockState2);
                        postPlacement(blockPos, world, playerEntity, itemStack, blockState2);
                        blockState2.getBlock().onPlaced(world, blockPos, blockState2, playerEntity, itemStack);
                        if (playerEntity instanceof ServerPlayerEntity) {
                            Criteria.PLACED_BLOCK.trigger((ServerPlayerEntity) playerEntity, blockPos, itemStack);
                        }
                    }

                    var blockSoundGroup = blockState2.getSoundGroup();
                    world.playSound(playerEntity, blockPos, this.getPlaceSound(blockState2), SoundCategory.BLOCKS, (blockSoundGroup.getVolume() + 1.0F) / 2.0F, blockSoundGroup.getPitch() * 0.8F);
                    world.emitGameEvent(playerEntity, GameEvent.BLOCK_PLACE, blockPos);
                    if (playerEntity == null || !playerEntity.getAbilities().creativeMode) {
                        itemStack.decrement(1);
                    }
                    return ActionResult.success(world.isClient);
                }
            }
        }
    }

    private BlockState placeFromTag(BlockPos pos, World world, ItemStack stack, BlockState state) {
        var blockState = state;
        var nbtCompound = stack.getNbt();
        if (nbtCompound != null) {
            var nbtCompound2 = nbtCompound.getCompound("BlockStateTag");
            StateManager<Block, BlockState> stateManager = state.getBlock().getStateManager();

            for (String string : nbtCompound2.getKeys()) {
                Property<?> property = stateManager.getProperty(string);
                if (property != null) {
                    var string2 = nbtCompound2.get(string).asString();
                    blockState = with(blockState, property, string2);
                }
            }
        }

        if (blockState != state) {
            world.setBlockState(pos, blockState, Block.NOTIFY_LISTENERS);
        }

        return blockState;
    }
}

package com.bloomhousemc.terrafabricraft.common.gui.ceramic;

import com.bloomhousemc.terrafabricraft.common.item.ceramic.CeramicVessel;
import com.bloomhousemc.terrafabricraft.common.registry.TFCScreens;
import com.bloomhousemc.terrafabricraft.common.util.TFCUtils.Dimension;
import com.bloomhousemc.terrafabricraft.common.util.TFCUtils.InventoryUtils;
import com.bloomhousemc.terrafabricraft.common.util.TFCUtils.Point;
import net.fabricmc.fabric.api.util.NbtType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtList;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;

public class CeramicVesselScreenHandler extends ScreenHandler {
    private final ItemStack itemStack;
    private int[] fluid = new int[4];
    private final int padding = 8;
    private final int extraPaddeing = 4;
    private final int titleSpace = 10;

    public CeramicVesselScreenHandler(int synchronizationID, PlayerInventory playerInventory, PacketByteBuf packetByteBuf) {
        this(synchronizationID, playerInventory, packetByteBuf.readItemStack());

    }

    public CeramicVesselScreenHandler(int synchronizationID, PlayerInventory playerInventory, ItemStack vesselStack) {
        super(TFCScreens.CERAMIC_VESSEL_SCREEN_HANDLER, synchronizationID);
        this.itemStack = vesselStack;


        if (vesselStack.getItem() instanceof CeramicVessel ceramicVessel) {
            switch (ceramicVessel.mode) {
                case INVENTORY -> setupContainerInventory(playerInventory, vesselStack);
                case ALLOY_LIQUID -> setupFluidInventory(playerInventory, vesselStack);
            }

        } else {
            PlayerEntity player = playerInventory.player;
            this.close(player);
        }
    }
    private void setupContainerInventory(PlayerInventory playerInventory, ItemStack vesselStack) {
        Dimension dimension = getDimension();
        int rowWidth = 2;
        int numberOfRows = 2;

        NbtList tag = vesselStack.getOrCreateNbt().getList("Inventory", NbtType.COMPOUND);
        SimpleInventory inventory = new SimpleInventory(rowWidth * numberOfRows) {
            @Override
            public void markDirty() {
                vesselStack.getOrCreateNbt().put("Inventory", InventoryUtils.toTag(this));
                super.markDirty();
            }
        };

        InventoryUtils.fromTag(tag, inventory);

        for (int y = 0; y < numberOfRows; y++) {
            for (int x = 0; x < rowWidth; x++) {
                Point vesselSlotPosition = getBackpackSlotPosition(dimension, x, y);
                addSlot(new BackpackLockedSlot(inventory, y * rowWidth + x, vesselSlotPosition.x - 9, vesselSlotPosition.y + 1 + 9));
            }
        }

        for (int y = 0; y < 3; ++y) {
            for (int x = 0; x < 9; ++x) {
                Point playerInvSlotPosition = getPlayerInvSlotPosition(dimension, x, y);
                this.addSlot(new BackpackLockedSlot(playerInventory, x + y * 9 + 9, playerInvSlotPosition.x + 1, playerInvSlotPosition.y + 1));
            }
        }

        for (int x = 0; x < 9; ++x) {
            Point playerInvSlotPosition = getPlayerInvSlotPosition(dimension, x, 3);
            this.addSlot(new BackpackLockedSlot(playerInventory, x, playerInvSlotPosition.x + 1, playerInvSlotPosition.y + 1));
        }
    }
    private void setupFluidInventory(PlayerInventory playerInventory, ItemStack vesselStack) {
        Dimension dimension = getDimension();
        int rowWidth = 1;
        int numberOfRows = 1;

        NbtList tag = vesselStack.getOrCreateNbt().getList("Inventory1", NbtType.COMPOUND);
        SimpleInventory inventory = new SimpleInventory(rowWidth * numberOfRows) {
            @Override
            public void markDirty() {
                vesselStack.getOrCreateNbt().put("Inventory1", InventoryUtils.toTag(this));
                super.markDirty();
            }
        };

        InventoryUtils.fromTag(tag, inventory);
        for (int y = 0; y < numberOfRows; y++) {
            for (int x = 0; x < rowWidth; x++) {
                Point vesselSlotPosition = getBackpackSlotPosition(dimension, x, y);
                addSlot(new BackpackLockedSlot(inventory, y * rowWidth + x, vesselSlotPosition.x - 9 + 9, vesselSlotPosition.y + 1 + 9 + 9));
            }
        }

        for (int y = 0; y < 3; ++y) {
            for (int x = 0; x < 9; ++x) {
                Point playerInvSlotPosition = getPlayerInvSlotPosition(dimension, x, y);
                this.addSlot(new BackpackLockedSlot(playerInventory, x + y * 9 + 9, playerInvSlotPosition.x + 1, playerInvSlotPosition.y + 1));
            }
        }

        for (int x = 0; x < 9; ++x) {
            Point playerInvSlotPosition = getPlayerInvSlotPosition(dimension, x, 3);
            this.addSlot(new BackpackLockedSlot(playerInventory, x, playerInvSlotPosition.x + 1, playerInvSlotPosition.y + 1));
        }
    }
    public Point getPlayerInvSlotPosition(Dimension dimension, int x, int y) {
        return new Point(dimension.getWidth() / 2 - 9 * 9 + x * 18, dimension.getHeight() - padding - 4 * 18 - 3 + y * 18 + (y == 3 ? 4 : 0));
    }
    public CeramicVessel getItem() {
        return (CeramicVessel) itemStack.getItem();
    }

    public Dimension getDimension() {
        return new Dimension(padding * 2 + 9 * 18, padding * 2 * extraPaddeing + titleSpace * 2 + 8 + 4 * 18);
    }
    public Point getBackpackSlotPosition(Dimension dimension, int x, int y) {
        return new Point(dimension.getWidth() / 2 - 9 + x * 18, padding + titleSpace + y * 18);
    }
    @Override
    public ItemStack transferSlot(PlayerEntity player, int index) {
        ItemStack itemStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(index);
        if (slot != null && slot.hasStack()) {
            ItemStack toInsert = slot.getStack();
            itemStack = toInsert.copy();
            if (index < 2 * 2) {
                if (!this.insertItem(toInsert, 2 * 2, this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.insertItem(toInsert, 0, 2 * 2, false)) {
                return ItemStack.EMPTY;
            }

            if (toInsert.isEmpty()) {
                slot.setStack(ItemStack.EMPTY);
            } else {
                slot.markDirty();
            }
        }

        return itemStack;
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return true;
    }

    private class BackpackLockedSlot extends Slot {

        public BackpackLockedSlot(Inventory inventory, int index, int x, int y) {
            super(inventory, index, x, y);
        }

        @Override
        public boolean canTakeItems(PlayerEntity playerEntity) {
            return stackMovementIsAllowed(getStack());
        }

        @Override
        public boolean canInsert(ItemStack stack) {
            return stackMovementIsAllowed(stack);
        }
        private boolean stackMovementIsAllowed(ItemStack stack) {
            return !(stack.getItem() instanceof CeramicVessel) && stack != itemStack;
        }
    }
}


package malek.terrafabricraft.client.screen;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.screen.slot.Slot;

public class TFCHandler extends ScreenHandler {

    public static TFCHandler create(ScreenHandlerType<?> type, int windowId, PlayerInventory playerInv)
    {
        return new TFCHandler(type, windowId).init(playerInv);
    }

    protected int containerSlots; // The number of slots in the container (not including the player inventory)

    protected TFCHandler(ScreenHandlerType<?> type, int windowId)
    {
        super(type, windowId);
    }

    /**
     * Problem: calling add slots from the container superclass, means that we cannot access subclass parameters, such as an item stack or tile entity, which are necessary in order to do some things such as setup container slots.
     * Solutions for running this at the right time are very difficult.
     * So, we have an explicit post-constructor-initialization method, which needs to be ran externally, but will always run after final fields have been initialized.
     *
     * @return The current container, casted down as required.
     */
    @SuppressWarnings("unchecked")
    public <C extends ScreenHandler> C init(PlayerInventory playerInventory, int yOffset)
    {
        addContainerSlots();
        containerSlots = slots.size();
        addPlayerInventorySlots(playerInventory, yOffset);
        return (C) this;
    }

    public <C extends ScreenHandler> C init(PlayerInventory playerInventory)
    {
        return init(playerInventory, 0);
    }

    @Override
    public ItemStack transferSlot(PlayerEntity player, int index)
    {
        final Slot slot = slots.get(index);
        if (slot.hasStack()) // Only move a stack when the index clicked has any contents
        {
            final ItemStack stack = slot.getStack(); // The stack in the current slot
            final ItemStack original = stack.copy(); // The original amount in the slot
            if (moveStack(stack, index))
            {
                return ItemStack.EMPTY;
            }

            if (stack.getCount() == original.getCount())
            {
                return ItemStack.EMPTY;
            }

            // Handle updates,
            if (stack.isEmpty())
            {
                slot.setStack(ItemStack.EMPTY);
            }
            else
            {
                slot.markDirty();
            }

            slot.onTakeItem(player, stack);
            return original;
        }
        return ItemStack.EMPTY;
    }

    @Override
    public boolean canUse(PlayerEntity playerIn)
    {
        return true;
    }

    /**
     * Handles the actual movement of stacks in {} with as little boilerplate as possible.
     * The default implementation only moves stacks between the main inventory and the hotbar.
     *
     * @return {@code true} if no movement is possible, or the result of {@code !moveItemStackTo(...) || ...}
     */
    protected boolean moveStack(ItemStack stack, int slotIndex)
    {
        return switch (typeOf(slotIndex))
                {
                    case CONTAINER -> true;
                    case HOTBAR -> !insertItem(stack, containerSlots, containerSlots + 27, false);
                    case MAIN_INVENTORY -> !insertItem(stack, containerSlots + 27, containerSlots + 36, false);
                };
    }

    /**
     * Adds container slots.
     * These are added before the player inventory (and as such, the player inventory will be shifted upwards by the number of slots added here.
     */
    protected void addContainerSlots() {}

    /**
     * Adds the player inventory slots to the container.
     */
    protected final void addPlayerInventorySlots(PlayerInventory playerInv, int yOffset)
    {
        // Main Inventory. Indexes [0, 27)
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 9; j++)
            {
                addSlot(new Slot(playerInv, j + i * 9 + 9, 8 + j * 18, 84 + i * 18 + yOffset));
            }
        }

        // Hotbar. Indexes [27, 36)
        for (int k = 0; k < 9; k++)
        {
            addSlot(new Slot(playerInv, k, 8 + k * 18, 142 + yOffset));
        }
    }

    protected final IndexType typeOf(int index)
    {
        if (index < containerSlots)
        {
            return IndexType.CONTAINER;
        }
        else if (index < containerSlots + 27)
        {
            return IndexType.MAIN_INVENTORY;
        }
        return IndexType.HOTBAR;
    }

    public enum IndexType
    {
        CONTAINER,
        MAIN_INVENTORY,
        HOTBAR
    }
}

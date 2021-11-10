package com.bloomhousemc.terrafabricraft.common.item;

import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;

public interface TemperatureReactiveItem {
    void doTemperatureReactiveThingsIfNeeded(Inventory inventory, int itemSlot, ItemStack stack);
}

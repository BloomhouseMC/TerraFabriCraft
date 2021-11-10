package com.bloomhousemc.terrafabricraft.common.item;

import com.bloomhousemc.terrafabricraft.common.temperature.ItemTemperature;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class TFCCeramic extends Item implements TemperatureReactiveItem{
    public final Item firedVersion;
    public TFCCeramic(Settings settings, Item firedVersion) {
        super(settings);
        this.firedVersion = firedVersion;
    }

    @Override
    public void doTemperatureReactiveThingsIfNeeded(Inventory inventory, int itemSlot, ItemStack stack) {
        if(ItemTemperature.getTemperature(stack) > 650) {
            int temp = ItemTemperature.getTemperature(stack);
            stack = new ItemStack(firedVersion);
            ItemTemperature.setTemperature(stack, temp);
            inventory.setStack(itemSlot, stack);
        }
    }
}

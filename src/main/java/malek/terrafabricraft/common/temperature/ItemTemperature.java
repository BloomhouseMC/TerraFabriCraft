package malek.terrafabricraft.common.temperature;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.ItemStack;

public class ItemTemperature {
    public static String temperature = "temperature";
    public static int getTemperature(ItemStack stack) {
        CompoundTag nbtCompound = stack.getTag();
        return nbtCompound == null ? 0 : nbtCompound.getInt(temperature);
    }
    public static void setTemperature(ItemStack stack, int temperatureAmount) {
        CompoundTag nbtCompound = stack.getOrCreateTag();
        nbtCompound.putInt(temperature, temperatureAmount);
    }
    public static void incrementTemperature(ItemStack stack) {
        CompoundTag nbtCompound = stack.getOrCreateTag();
        nbtCompound.putInt(temperature, getTemperature(stack)+1);
    }
    public static void decrementTemperature(ItemStack stack) {
        CompoundTag nbtCompound = stack.getOrCreateTag();
        nbtCompound.putInt(temperature, getTemperature(stack)-1);
    }
}

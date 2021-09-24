package malek.terrafabricraft.common.temperature;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;

public class ItemTemperature {
    public static String temperature = "temperature";
    public static int getTemperature(ItemStack stack) {
        NbtCompound nbtCompound = stack.getNbt();
        return nbtCompound == null ? 0 : nbtCompound.getInt(temperature);
    }
    public static void setTemperature(ItemStack stack, int temperatureAmount) {
        NbtCompound nbtCompound = stack.getOrCreateNbt();
        nbtCompound.putInt(temperature, temperatureAmount);
    }
    public static void incrementTemperature(ItemStack stack) {
        NbtCompound nbtCompound = stack.getOrCreateNbt();
        nbtCompound.putInt(temperature, getTemperature(stack)+1);
    }
    public static void decrementTemperature(ItemStack stack) {
        NbtCompound nbtCompound = stack.getOrCreateNbt();
        nbtCompound.putInt(temperature, getTemperature(stack)-1);
    }
}

package com.bloomhousemc.terrafabricraft.common.util;

import com.bloomhousemc.terrafabricraft.TerraFabriCraft;
import com.bloomhousemc.terrafabricraft.common.registry.TfcBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtList;
import net.minecraft.recipe.Ingredient;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Hand;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public final class TfcUtils {
    public static final Random RNG = new Random();

    public static boolean isBetweenTime(World world, int min, int max) {
        if (world.getTime() >= min && world.getTime() <= max) {
            return true;
        } else
            return false;
    }

    public static TranslatableText translateEnum(Enum<?> anEnum) {
        return new TranslatableText(getEnumTranslationKey(anEnum));
    }

    public static String getEnumTranslationKey(Enum<?> anEnum) {
        return getEnumTranslationKey(anEnum, anEnum.getDeclaringClass().getSimpleName());
    }

    public static String getEnumTranslationKey(Enum<?> anEnum, String enumName) {
        return String.join(".", TerraFabriCraft.MODID, "enum", enumName, anEnum.name()).toLowerCase(Locale.ROOT);
    }

    /**
     * Consumes an item from player inventory and adds a new one
     * @param player The player which is exchanging item
     * @param hand Player hand
     * @param toAdd which item to receive instead.
     */
    public static void addItemToInventoryAndConsume(PlayerEntity player, Hand hand, ItemStack toAdd) {
        boolean shouldAdd = false;
        ItemStack stack = player.getStackInHand(hand);
        if (stack.getCount() == 1) {
            if (player.isCreative()) {
                shouldAdd = true;
            } else {
                player.setStackInHand(hand, toAdd);
            }
        } else {
            stack.decrement(1);
            shouldAdd = true;
        }
        if (shouldAdd) {
            if (!player.getInventory().insertStack(toAdd)) {
                player.dropItem(toAdd, false, true);
            }
        }
    }


        public static BlockState getRandomRawStone (Random random){

            if (MathHelper.nextInt(random, 1, 7) == 1) {
                return TfcBlocks.ANDESITE.RAW.BLOCK.getDefaultState();
            } else if (MathHelper.nextInt(random, 1, 7) == 2) {
                return TfcBlocks.DOLOMITE.RAW.BLOCK.getDefaultState();
            } else if (MathHelper.nextInt(random, 1, 7) == 3) {
                return TfcBlocks.CHALK.RAW.BLOCK.getDefaultState();
            } else if (MathHelper.nextInt(random, 1, 7) == 4) {
                return TfcBlocks.LIMESTONE.RAW.BLOCK.getDefaultState();
            } else if (MathHelper.nextInt(random, 1, 7) == 5) {
                return TfcBlocks.CHERT.RAW.BLOCK.getDefaultState();
            } else if (MathHelper.nextInt(random, 1, 7) == 6) {
                return TfcBlocks.CONGLOMERATE.RAW.BLOCK.getDefaultState();
            } else if (MathHelper.nextInt(random, 1, 7) == 7) {
                return TfcBlocks.SHALE.RAW.BLOCK.getDefaultState();
            } else
                return TfcBlocks.CLAYSTONE.RAW.BLOCK.getDefaultState();

        }

    public static boolean matches(Inventory inv, DefaultedList<Ingredient> input) {
        List<ItemStack> checklist = new ArrayList<>();
        for (int i = 0; i < inv.size(); i++) {
            ItemStack stack = inv.getStack(i);
            if (!stack.isEmpty()) {
                checklist.add(stack);
            }
        }
        if (input.size() != checklist.size()) {
            return false;
        }
        for (Ingredient ingredient : input) {
            boolean found = false;
            for (ItemStack stack : checklist) {
                if (ingredient.test(stack)) {
                    found = true;
                    checklist.remove(stack);
                    break;
                }
            }
            if (!found) {
                return false;
            }
        }
        return true;
    }
    /**
     * Handles save and load, so inventories remain upon reload
     */
    public static class InventoryUtils {
        public static NbtList toTag(SimpleInventory inventory) {
            NbtList tag = new NbtList();
            for(int i = 0; i < inventory.size(); i++) {
                NbtCompound stackTag = new NbtCompound();
                stackTag.putInt("Slot", i);
                stackTag.put("Stack", inventory.getStack(i).writeNbt(new NbtCompound()));
                tag.add(stackTag);
            }
            return tag;
        }
        public static void fromTag(NbtList tag, SimpleInventory inventory) {
            inventory.clear();
            tag.forEach(element -> {
                NbtCompound stackTag = (NbtCompound) element;
                int slot = stackTag.getInt("Slot");
                ItemStack stack = ItemStack.fromNbt(stackTag.getCompound("Stack"));
                inventory.setStack(slot, stack);
            });
        }
    }
    /**
     * Type declaration for an area of a space
     */
    public static class Dimension {

        private int width;
        private int height;

        public Dimension(int width, int height) {
            this.width = width;
            this.height = height;
        }

        public int getWidth() {
            return width;
        }

        public int getHeight() {
            return height;
        }
    }
    /**
     * Type declaration for a point in 2D space
     */
    public static class Point {
        public int x;
        public int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    /**
     * Handles adding and taking items from a GUI-less inventory. "Hand.MAIN_HAND.equals(hand)" so we filter off the off-hand so the code doesnt run twice.
     * @param stack The ItemStack which the player wants to add.
     * @param player Player putting or taking item.
     * @param hand Mainhand or OffHand.
     * @param inventory The target inventory.
     * @param itemSlot The slot of the target inventory.
     */
    public static void handleGUILessInventory(ItemStack stack, PlayerEntity player, Hand hand, DefaultedList<ItemStack> inventory, int itemSlot){
        if(player.isSneaking() && Hand.MAIN_HAND.equals(hand)){
            if(player.getMainHandStack().isOf(stack.getItem()) && inventory.get(itemSlot).isEmpty()){
                inventory.set(itemSlot, stack.split(1));
            }else if(inventory.get(itemSlot).getItem() != Items.AIR && player.getStackInHand(hand).isEmpty()){
                player.setStackInHand(hand, inventory.get(itemSlot).copy());
                inventory.set(itemSlot, new ItemStack(Items.AIR));
            }
        }
    }

}

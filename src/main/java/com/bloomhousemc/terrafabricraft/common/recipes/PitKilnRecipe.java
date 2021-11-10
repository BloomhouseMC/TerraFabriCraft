package com.bloomhousemc.terrafabricraft.common.recipes;

import com.google.gson.JsonObject;
import com.bloomhousemc.terrafabricraft.common.registry.TFCRecipeTypes;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.JsonHelper;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;


public class PitKilnRecipe implements Recipe<Inventory> {
    private final Identifier identifier;
    public final Ingredient input;
    private final ItemStack output;
    public final int color;
    public final int time;

    public PitKilnRecipe(Identifier identifier, Ingredient input, ItemStack output, int color, int time) {
        this.identifier = identifier;
        this.input = input;
        this.output = output;
        this.color = color;
        this.time = time;
    }

    public boolean matches(ItemStack stack) {
        return input.test(stack);
    }
    @Override
    public boolean matches(Inventory inventory, World world) {
        return matches(inventory, input);
    }

    public static boolean matches(Inventory inv, Ingredient input) {
        List<ItemStack> checklist = new ArrayList<>();
        for (int i = 0; i < inv.size(); i++) {
            ItemStack stack = inv.getStack(i);
            if (!stack.isEmpty()) {
                checklist.add(stack);
            }
        }

        boolean found = false;
        for (ItemStack stack : checklist) {
            if (input.test(stack)) {
                found = true;
                checklist.remove(stack);
                break;
            }
        }
        return found;
    }

    @Override
    public ItemStack craft(Inventory inventory) {
        return output;
    }

    @Override
    public boolean fits(int width, int height) {
        return true;
    }

    @Override
    public ItemStack getOutput() {
        return output;
    }

    @Override
    public Identifier getId() {
        return identifier;
    }


    @Override
    public RecipeSerializer<?> getSerializer() {
        return TFCRecipeTypes.PIT_KILN_RECIPE_SERIALIZER;
    }

    @Override
    public RecipeType<?> getType() {
        return TFCRecipeTypes.PIT_KILN_RECIPE_TYPE;
    }


    public static class Serializer implements RecipeSerializer<PitKilnRecipe> {
        @Override
        public PitKilnRecipe read(Identifier id, JsonObject json) {
            return new PitKilnRecipe(id, Ingredient.fromJson(JsonHelper.getObject(json, "ingredient")), ShapedRecipe.outputFromJson(JsonHelper.getObject(json, "result")), JsonHelper.getInt(json, "color"), JsonHelper.getInt(json, "time"));
        }

        @Override
        public PitKilnRecipe read(Identifier id, PacketByteBuf buf) {
            Ingredient ingredient = Ingredient.fromPacket(buf);
            return new PitKilnRecipe(id, ingredient, buf.readItemStack(), buf.readInt(), buf.readInt());
        }

        @Override
        public void write(PacketByteBuf buf, PitKilnRecipe recipe) {
            recipe.input.write(buf);
            buf.writeItemStack(recipe.getOutput());
            buf.writeInt(recipe.color);
            buf.writeInt(recipe.time);
        }
    }
}

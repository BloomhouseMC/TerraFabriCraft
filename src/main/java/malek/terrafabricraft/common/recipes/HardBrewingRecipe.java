package malek.terrafabricraft.common.recipes;


import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import malek.terrafabricraft.common.registry.TFCRecipeTypes;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.JsonHelper;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

public class HardBrewingRecipe implements Recipe<Inventory> {
    private final Identifier identifier;
    public final DefaultedList<Ingredient> input;
    private final ItemStack output;
    public final int color;
    //TODO: Copy of BeerBrewingRecpie until implemented properly
    public HardBrewingRecipe(Identifier identifier, DefaultedList<Ingredient> input, ItemStack output, int color) {
        this.identifier = identifier;
        this.input = input;
        this.output = output;
        this.color = color;
    }

    @Override
    public boolean matches(Inventory inventory, World world) {
        return matches(inventory, input);
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


    @Override
    public RecipeSerializer<?> getSerializer() {
        return TFCRecipeTypes.HARD_BREWING_RECIPE_SERIALIZER;
    }

    @Override
    public RecipeType<?> getType() {
        return TFCRecipeTypes.HARD_BREWING_RECIPE_TYPE;
    }
    public static DefaultedList<Ingredient> getIngredients(JsonArray json) {
        DefaultedList<Ingredient> ingredients = DefaultedList.of();
        for (int i = 0; i < json.size(); i++) {
            Ingredient ingredient = Ingredient.fromJson(json.get(i));
            if (!ingredient.isEmpty()) {
                ingredients.add(ingredient);
            }
        }
        return ingredients;
    }

    public static class Serializer implements RecipeSerializer<HardBrewingRecipe> {
        @Override
        public HardBrewingRecipe read(Identifier id, JsonObject json) {
            DefaultedList<Ingredient> ingredients = getIngredients(JsonHelper.getArray(json, "ingredients"));
            if (ingredients.isEmpty()) {
                throw new JsonParseException("No ingredients for brew recipe");
            }
            else if (ingredients.size() > 3) {
                throw new JsonParseException("Too many ingredients for brew recipe");
            }
            return new HardBrewingRecipe(id, ingredients, ShapedRecipe.outputFromJson(JsonHelper.getObject(json, "result")), JsonHelper.getInt(json, "color"));
        }

        @Override
        public HardBrewingRecipe read(Identifier id, PacketByteBuf buf) {
            DefaultedList<Ingredient> defaultedList = DefaultedList.ofSize(buf.readVarInt(), Ingredient.EMPTY);
            for (int i = 0; i < defaultedList.size(); i++) {
                defaultedList.set(i, Ingredient.fromPacket(buf));
            }
            return new HardBrewingRecipe(id, defaultedList, buf.readItemStack(), buf.readInt());
        }

        @Override
        public void write(PacketByteBuf buf, HardBrewingRecipe recipe) {
            buf.writeVarInt(recipe.input.size());
            for (Ingredient ingredient : recipe.input) {
                ingredient.write(buf);
            }
            buf.writeItemStack(recipe.getOutput());
            buf.writeInt(recipe.color);
        }
    }
}

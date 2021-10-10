package malek.terrafabricraft.common.recipes;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import malek.terrafabricraft.common.registry.TFCRecipeTypes;
import malek.terrafabricraft.common.util.TFCUtils;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.JsonHelper;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;


public class BeerBrewingRecipe implements Recipe<Inventory> {
    private final Identifier identifier;
    public final DefaultedList<Ingredient> input;
    private final ItemStack output;
    public final int color;
    public final int time;

    public BeerBrewingRecipe(Identifier identifier, DefaultedList<Ingredient> input, ItemStack output, int color, int time) {
        this.identifier = identifier;
        this.input = input;
        this.output = output;
        this.color = color;
        this.time = time;
    }

    @Override
    public boolean matches(Inventory inventory, World world) {
        return TFCUtils.matches(inventory, input);
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
        return TFCRecipeTypes.BEER_BREWING_RECIPE_SERIALIZER;
    }

    @Override
    public RecipeType<?> getType() {
        return TFCRecipeTypes.BEER_BREWING_RECIPE_TYPE;
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

    public static class Serializer implements RecipeSerializer<BeerBrewingRecipe> {
        @Override
        public BeerBrewingRecipe read(Identifier id, JsonObject json) {
            DefaultedList<Ingredient> ingredients = getIngredients(JsonHelper.getArray(json, "ingredients"));
            if (ingredients.isEmpty()) {
                throw new JsonParseException("No ingredients for keg recipe");
            }
            else if (ingredients.size() > 4) {
                throw new JsonParseException("Too many ingredients for keg recipe");
            }
            return new BeerBrewingRecipe(id, ingredients, ShapedRecipe.outputFromJson(JsonHelper.getObject(json, "result")), JsonHelper.getInt(json, "color"), JsonHelper.getInt(json, "time"));
        }

        @Override
        public BeerBrewingRecipe read(Identifier id, PacketByteBuf buf) {
            DefaultedList<Ingredient> defaultedList = DefaultedList.ofSize(buf.readVarInt(), Ingredient.EMPTY);
            for (int i = 0; i < defaultedList.size(); i++) {
                defaultedList.set(i, Ingredient.fromPacket(buf));
            }
            return new BeerBrewingRecipe(id, defaultedList, buf.readItemStack(), buf.readInt(), buf.readInt());
        }

        @Override
        public void write(PacketByteBuf buf, BeerBrewingRecipe recipe) {
            buf.writeVarInt(recipe.input.size());
            for (Ingredient ingredient : recipe.input) {
                ingredient.write(buf);
            }
            buf.writeItemStack(recipe.getOutput());
            buf.writeInt(recipe.color);
            buf.writeInt(recipe.time);
        }
    }
}

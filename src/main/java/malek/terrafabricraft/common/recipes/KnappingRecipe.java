package malek.terrafabricraft.common.recipes;


import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.gson.*;
import malek.terrafabricraft.common.registry.TFCRecipeTypes;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.CraftingRecipe;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.util.Identifier;
import net.minecraft.util.JsonHelper;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class KnappingRecipe implements CraftingRecipe {
    final int width;
    final int height;
    final DefaultedList<Ingredient> input;
    final ItemStack output;
    private final Identifier id;
    final String group;

    public KnappingRecipe(Identifier identifier, String string, int i, int j, DefaultedList<Ingredient> defaultedList, ItemStack itemStack) {
        this.id = identifier;
        this.group = string;
        this.width = i;
        this.height = j;
        this.input = defaultedList;
        this.output = itemStack;
    }

    public Identifier getId() {
        return this.id;
    }

    public RecipeSerializer<?> getSerializer() {
        return TFCRecipeTypes.KNAPPING_RECIPE_SERIALIZER;
    }

    public String getGroup() {
        return this.group;
    }

    public ItemStack getOutput() {
        return this.output;
    }

    public DefaultedList<Ingredient> getIngredients() {
        return this.input;
    }

    public boolean fits(int width, int height) {
        return width >= this.width && height >= this.height;
    }

    public boolean matches(boolean[][] craftingInventory, World world) {

        for (int i = 0; i <= 5 - this.width; ++i) {
            for (int j = 0; j <= 5 - this.height; ++j) {
                if (this.matchesPattern(craftingInventory, i, j, true)) {
                    return true;
                }

                if (this.matchesPattern(craftingInventory, i, j, false)) {
                    return true;
                }
            }
        }



        return false;
    }

    private boolean matchesPattern(boolean[][] inv, int offsetX, int offsetY, boolean flipped) {
        for (int i = 0; i < 5; ++i) {
            for (int j = 0; j < 5; ++j) {
                int k = i - offsetX;
                int l = j - offsetY;
                Ingredient ingredient = Ingredient.EMPTY;
                if (k >= 0 && l >= 0 && k < this.width && l < this.height) {
                    if (flipped) {
                        ingredient = (Ingredient) this.input.get(this.width - k - 1 + l * this.width);
                    } else {
                        ingredient = (Ingredient) this.input.get(k + l * this.width);
                    }
                }
            }
        }

        return true;
    }

    @Override
    public boolean matches(CraftingInventory inventory, World world) {
        return false;
    }

    public ItemStack craft(CraftingInventory craftingInventory) {
        return this.getOutput().copy();
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    /**
     * Compiles a pattern and series of symbols into a list of ingredients (the matrix) suitable for matching
     * against a crafting grid.
     */
    static DefaultedList<Ingredient> createPatternMatrix(String[] pattern, int width, int height) {
        DefaultedList<Ingredient> defaultedList = DefaultedList.ofSize(width * height, Ingredient.EMPTY);
        /*
        Set<String> set = Sets.newHashSet((Iterable) symbols.keySet());
        set.remove(" ");

        for (int i = 0; i < pattern.length; ++i) {
            for (int j = 0; j < pattern[i].length(); ++j) {
                String string = pattern[i].substring(j, j + 1);
                Ingredient ingredient = (Ingredient) symbols.get(string);
                if (ingredient == null) {
                    throw new JsonSyntaxException("Pattern references symbol '" + string + "' but it's not defined in the key");
                }

                set.remove(string);
                defaultedList.set(j + width * i, ingredient);
            }
        }

        if (!set.isEmpty()) {
            throw new JsonSyntaxException("Key defines symbols that aren't used in pattern: " + set);
        } else {
            return defaultedList;
        }

         */
        return defaultedList;
    }

    /**
     * Removes empty space from around the recipe pattern.
     *
     * <p>Turns patterns such as:</p>
     * <pre>
     * {@code
     * "   o"
     * "   a"
     * "    "
     * }
     * </pre>
     * Into:
     * <pre>
     * {@code
     * "o"
     * "a"
     * }
     * </pre>
     *
     * @return a new recipe pattern with all leading and trailing empty rows/columns removed
     */
    @VisibleForTesting
    static String[] removePadding(String... pattern) {
        int i = Integer.MAX_VALUE;
        int j = 0;
        int k = 0;
        int l = 0;

        for (int m = 0; m < pattern.length; ++m) {
            String string = pattern[m];
            i = Math.min(i, findFirstSymbol(string));
            int n = findLastSymbol(string);
            j = Math.max(j, n);
            if (n < 0) {
                if (k == m) {
                    ++k;
                }

                ++l;
            } else {
                l = 0;
            }
        }

        if (pattern.length == l) {
            return new String[0];
        } else {
            String[] strings = new String[pattern.length - l - k];

            for (int o = 0; o < strings.length; ++o) {
                strings[o] = pattern[o + k].substring(i, j + 1);
            }

            return strings;
        }
    }

    public boolean isEmpty() {
        DefaultedList<Ingredient> defaultedList = this.getIngredients();
        return defaultedList.isEmpty() || defaultedList.stream().filter((ingredient) -> {
            return !ingredient.isEmpty();
        }).anyMatch((ingredient) -> {
            return ingredient.getMatchingStacks().length == 0;
        });
    }

    private static int findFirstSymbol(String line) {
        int i;
        for (i = 0; i < line.length() && line.charAt(i) == ' '; ++i) {
        }

        return i;
    }

    private static int findLastSymbol(String pattern) {
        int i;
        for (i = pattern.length() - 1; i >= 0 && pattern.charAt(i) == ' '; --i) {
        }

        return i;
    }

    static String[] getPattern(JsonArray json) {
        String[] strings = new String[json.size()];
        if (strings.length > 5) {
            throw new JsonSyntaxException("Invalid pattern: too many rows, 3 is maximum");
        } else if (strings.length == 0) {
            throw new JsonSyntaxException("Invalid pattern: empty pattern not allowed");
        } else {
            for (int i = 0; i < strings.length; ++i) {
                String string = JsonHelper.asString(json.get(i), "pattern[" + i + "]");
                if (string.length() > 5) {
                    throw new JsonSyntaxException("Invalid pattern: too many columns, 3 is maximum");
                }

                if (i > 0 && strings[0].length() != string.length()) {
                    throw new JsonSyntaxException("Invalid pattern: each row must be the same width");
                }

                strings[i] = string;
            }

            return strings;
        }
    }

    /**
     * Reads the pattern symbols.
     *
     * @return a mapping from a symbol to the ingredient it represents
     */
    static Map<String, Ingredient> readSymbols(JsonObject json) {
        Map<String, Ingredient> map = Maps.newHashMap();
        Iterator var2 = json.entrySet().iterator();

        while (var2.hasNext()) {
            Map.Entry<String, JsonElement> entry = (Map.Entry) var2.next();
            if (((String) entry.getKey()).length() != 1) {
                throw new JsonSyntaxException("Invalid key entry: '" + (String) entry.getKey() + "' is an invalid symbol (must be 1 character only).");
            }

            if (" ".equals(entry.getKey())) {
                throw new JsonSyntaxException("Invalid key entry: ' ' is a reserved symbol.");
            }

            map.put((String) entry.getKey(), Ingredient.fromJson((JsonElement) entry.getValue()));
        }

        map.put(" ", Ingredient.EMPTY);
        return map;
    }

    public static ItemStack outputFromJson(JsonObject json) {
        Item item = getItem(json);
        if (json.has("data")) {
            throw new JsonParseException("Disallowed data tag found");
        } else {
            int i = JsonHelper.getInt(json, "count", 1);
            if (i < 1) {
                throw new JsonSyntaxException("Invalid output count: " + i);
            } else {
                return new ItemStack(item, i);
            }
        }
    }

    public static Item getItem(JsonObject json) {
        String string = JsonHelper.getString(json, "item");
        Item item = (Item) Registry.ITEM.getOrEmpty(new Identifier(string)).orElseThrow(() -> {
            return new JsonSyntaxException("Unknown item '" + string + "'");
        });
        if (item == Items.AIR) {
            throw new JsonSyntaxException("Invalid item: " + string);
        } else {
            return item;
        }
    }

    public static class Serializer implements RecipeSerializer<KnappingRecipe> {
        public KnappingRecipe read(Identifier identifier, JsonObject jsonObject) {
            String string = JsonHelper.getString(jsonObject, "group", "");
            //Map<String, Ingredient> map = readSymbols(JsonHelper.getObject(jsonObject, "key"));
            String[] strings = removePadding(getPattern(JsonHelper.getArray(jsonObject, "pattern")));
            int i = strings[0].length();
            int j = strings.length;
            DefaultedList<Ingredient> defaultedList = createPatternMatrix(strings, i, j);
            ItemStack itemStack = outputFromJson(JsonHelper.getObject(jsonObject, "result"));
            return new KnappingRecipe(identifier, string, i, j, defaultedList, itemStack);
        }

        public KnappingRecipe read(Identifier identifier, PacketByteBuf packetByteBuf) {
            int i = packetByteBuf.readVarInt();
            int j = packetByteBuf.readVarInt();
            String string = packetByteBuf.readString();
            DefaultedList<Ingredient> defaultedList = DefaultedList.ofSize(i * j, Ingredient.EMPTY);

            for (int k = 0; k < defaultedList.size(); ++k) {
                defaultedList.set(k, Ingredient.fromPacket(packetByteBuf));
            }

            ItemStack itemStack = packetByteBuf.readItemStack();
            return new KnappingRecipe(identifier, string, i, j, defaultedList, itemStack);
        }

        public void write(PacketByteBuf packetByteBuf, KnappingRecipe knappingRecipe) {
            packetByteBuf.writeVarInt(knappingRecipe.width);
            packetByteBuf.writeVarInt(knappingRecipe.height);
            packetByteBuf.writeString(knappingRecipe.group);
            Iterator var3 = knappingRecipe.input.iterator();

            while (var3.hasNext()) {
                Ingredient ingredient = (Ingredient) var3.next();
                ingredient.write(packetByteBuf);
            }

            packetByteBuf.writeItemStack(knappingRecipe.output);
        }
    }
}

package malek.terrafabricraft.common.registry;

import malek.terrafabricraft.TerraFabriCraft;
import malek.terrafabricraft.common.recipes.KegRecipe;
import malek.terrafabricraft.common.recipes.KnappingRecipe;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.LinkedHashMap;
import java.util.Map;

public class TFCRecipeTypes {
    private static final Map<RecipeSerializer<?>, Identifier> RECIPE_SERIALIZERS = new LinkedHashMap<>();
    private static final Map<RecipeType<?>, Identifier> RECIPE_TYPES = new LinkedHashMap<>();


    public static final RecipeSerializer<KegRecipe> KEG_RECIPE_SERIALIZER = create("keg_recipe", new KegRecipe.Serializer());
    public static final RecipeType<KegRecipe> KEG_RECIPE_TYPE = create("keg_recipe");

    public static final RecipeSerializer<KnappingRecipe> KNAPPING_RECIPE_SERIALIZER = create("knapping_recipe", new KnappingRecipe.Serializer());
    public static final RecipeType<KnappingRecipe> KNAPPING_RECIPE_TYPE = create("knapping_recipe");


    private static <T extends Recipe<?>> RecipeSerializer<T> create(String name, RecipeSerializer<T> serializer) {
        RECIPE_SERIALIZERS.put(serializer, new Identifier(TerraFabriCraft.MODID, name));
        return serializer;
    }

    private static <T extends Recipe<?>> RecipeType<T> create(String name) {
        RecipeType<T> type = new RecipeType<>() {
            @Override
            public String toString() {
                return name;
            }
        };
        RECIPE_TYPES.put(type, new Identifier(TerraFabriCraft.MODID, name));
        return type;
    }

    public static void init() {
        RECIPE_SERIALIZERS.keySet().forEach(recipeSerializer -> Registry.register(Registry.RECIPE_SERIALIZER, RECIPE_SERIALIZERS.get(recipeSerializer), recipeSerializer));
        RECIPE_TYPES.keySet().forEach(recipeType -> Registry.register(Registry.RECIPE_TYPE, RECIPE_TYPES.get(recipeType), recipeType));
    }
}

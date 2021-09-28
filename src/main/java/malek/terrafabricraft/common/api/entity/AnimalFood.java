package malek.terrafabricraft.common.api.entity;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;

public class AnimalFood {
    private static final HashMap<Class<? extends Entity>, AnimalFood> ANIMAL_FOOD_MAP = new HashMap<>();

    @Nullable
    public static AnimalFood get(Class<? extends Entity> animalClass)
    {
        return ANIMAL_FOOD_MAP.get(animalClass);
    }

    private final List<Ingredient> acceptedFoods;
    private final boolean eatRotten;

    public AnimalFood(boolean eatRotten)
    {
        this.eatRotten = eatRotten;
        acceptedFoods = new ArrayList<>();
    }

    public void addFood(Ingredient ingredient)
    {
        acceptedFoods.add(ingredient);
    }

    public boolean isFood(ItemStack stack)
    {
        for (Ingredient acceptedFood : acceptedFoods)
        {
            if (acceptedFood.test(stack))
            {
                if (!eatRotten)
                {
                    return stack.isEdible();
                }
                return true;
            }
        }
        return false;
    }
}

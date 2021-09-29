package malek.terrafabricraft.common.util;

import malek.terrafabricraft.TerraFabriCraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;

import java.util.Locale;
import java.util.Random;

public final class HelperUtil {
    public static final Random RNG = new Random();

    public static boolean isClientSide(WorldView world)
    {
        return world instanceof World ? !(world instanceof ServerWorld) : world.isClient();
    }

    public static TranslatableText translateEnum(Enum<?> anEnum)
    {
        return new TranslatableText(getEnumTranslationKey(anEnum));
    }

    public static String getEnumTranslationKey(Enum<?> anEnum)
    {
        return getEnumTranslationKey(anEnum, anEnum.getDeclaringClass().getSimpleName());
    }

    public static String getEnumTranslationKey(Enum<?> anEnum, String enumName)
    {
        return String.join(".", TerraFabriCraft.MODID, "enum", enumName, anEnum.name()).toLowerCase(Locale.ROOT);
    }
    public static void addItemToInventoryAndConsume(PlayerEntity player, Hand hand, ItemStack toAdd) {
        boolean shouldAdd = false;
        ItemStack stack = player.getStackInHand(hand);
        if (stack.getCount() == 1) {
            if (player.isCreative()) {
                shouldAdd = true;
            }
            else {
                player.setStackInHand(hand, toAdd);
            }
        }
        else {
            stack.decrement(1);
            shouldAdd = true;
        }
        if (shouldAdd) {
            if (!player.getInventory().insertStack(toAdd)) {
                player.dropItem(toAdd, false, true);
            }
        }
    }
}

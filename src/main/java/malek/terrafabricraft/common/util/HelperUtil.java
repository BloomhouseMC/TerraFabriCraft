package malek.terrafabricraft.common.util;

import malek.terrafabricraft.TerraFabriCraft;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.TranslatableText;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;

import java.util.Locale;

public final class HelperUtil {

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
}

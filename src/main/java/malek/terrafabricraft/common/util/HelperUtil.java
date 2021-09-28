package malek.terrafabricraft.common.util;

import malek.terrafabricraft.TerraFabriCraft;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import java.util.Locale;
import java.util.Random;

public final class HelperUtil {
    public static final Random RNG = new Random();

    public static boolean isClientSide(LevelReader world)
    {
        return world instanceof Level ? !(world instanceof ServerLevel) : world.isClientSide();
    }

    public static TranslatableComponent translateEnum(Enum<?> anEnum)
    {
        return new TranslatableComponent(getEnumTranslationKey(anEnum));
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

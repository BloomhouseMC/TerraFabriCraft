package malek.terrafabricraft.common.util;

import malek.terrafabricraft.TerraFabriCraft;
import malek.terrafabricraft.common.registry.TFCObjects;
import net.minecraft.block.BlockState;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.math.MathHelper;
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

    public static BlockState getRandomRawStone(Random random) {
        if (MathHelper.nextInt(random, 1, 7) == 1) {
            return TFCObjects.ANDESITE.raw.block.getDefaultState();
        } else if (MathHelper.nextInt(random, 1, 7) == 2) {
            return TFCObjects.DOLOMITE.raw.block.getDefaultState();
        } else if (MathHelper.nextInt(random, 1, 7) == 3) {
            return TFCObjects.CHALK.raw.block.getDefaultState();
        } else if (MathHelper.nextInt(random, 1, 7) == 4) {
            return TFCObjects.LIMESTONE.raw.block.getDefaultState();
        } else if (MathHelper.nextInt(random, 1, 7) == 5) {
            return TFCObjects.CHERT.raw.block.getDefaultState();
        } else if (MathHelper.nextInt(random, 1, 7) == 6) {
            return TFCObjects.CONGLOMERATE.raw.block.getDefaultState();
        } else if (MathHelper.nextInt(random, 1, 7) == 7) {
            return TFCObjects.SHALE.raw.block.getDefaultState();
        } else
        return TFCObjects.CLAYSTONE.raw.block.getDefaultState();
    }
}

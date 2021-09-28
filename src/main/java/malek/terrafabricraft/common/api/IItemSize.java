package malek.terrafabricraft.common.api;

import malek.terrafabricraft.common.util.HelperUtil;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.world.item.ItemStack;
import javax.annotation.Nonnull;
import java.util.List;

public interface IItemSize {

    @Nonnull
    Size getSize(@Nonnull ItemStack stack);

    @Nonnull
    Weight getWeight(@Nonnull ItemStack stack);

    default boolean canStack(@Nonnull ItemStack stack)
    {
        return true;
    }

    @Environment(EnvType.CLIENT)
    default void addSizeInfo(@Nonnull ItemStack stack, @Nonnull List<String> text)
    {
        text.add("\u2696 " + I18n.get(HelperUtil.getEnumTranslationKey(getWeight(stack))) + " \u21F2 " + I18n.get(HelperUtil.getEnumTranslationKey(getSize(stack))));
    }

    default int getStackSize(@Nonnull ItemStack stack)
    {
        return canStack(stack) ? getWeight(stack).stackSize : 1;
    }
}

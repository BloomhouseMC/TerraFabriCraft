package malek.terrafabricraft.common.calendar;

import java.util.Locale;
import net.minecraft.util.StringRepresentable;

public enum Season implements StringRepresentable {
    SPRING,
    SUMMER,
    FALL,
    WINTER;

    private static final Season[] VALUES = values();

    private final String serializedName;

    Season()
    {
        this.serializedName = name().toLowerCase(Locale.ROOT);
    }

    public Season next()
    {
        return VALUES[(ordinal() + 1) & 0b11];
    }

    public Season previous()
    {
        return VALUES[(ordinal() - 1) & 0b11];
    }

    @Override
    public String getSerializedName()
    {
        return serializedName;
    }
}

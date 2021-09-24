package malek.terrafabricraft.common.calendar;

import net.minecraft.util.StringIdentifiable;

import java.util.Locale;

public enum Season implements StringIdentifiable {
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
    public String asString()
    {
        return serializedName;
    }
}

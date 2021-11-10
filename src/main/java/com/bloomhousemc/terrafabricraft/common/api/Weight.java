package com.bloomhousemc.terrafabricraft.common.api;

public enum Weight {
    VERY_LIGHT("very_light", 64),
    LIGHT("light", 32),
    MEDIUM("medium", 16),
    HEAVY("heavy", 4),
    VERY_HEAVY("very_heavy", 1);

    public final int stackSize;
    public final String name;

    Weight(String name, int stackSize)
    {
        this.name = name;
        this.stackSize = stackSize;
    }

    public boolean isSmallerThan(Weight other)
    {
        return this.stackSize > other.stackSize;
    }
}

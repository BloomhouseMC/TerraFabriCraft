package com.bloomhousemc.terrafabricraft.common.util;

import net.minecraft.block.enums.DoubleBlockHalf;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.IntProperty;

public class TFCProperties {

    public static final IntProperty HEAT_LEVEL = IntProperty.of("heat_level", 0, 7);
    public static final EnumProperty<DoubleBlockHalf> HALF = EnumProperty.of("part", DoubleBlockHalf.class);
}

package com.bloomhousemc.terrafabricraft.common.registry.util;

import com.bloomhousemc.terrafabricraft.common.block.TFCCoralBlock;
import com.bloomhousemc.terrafabricraft.common.block.TFCCoralFanBlock;
import com.bloomhousemc.terrafabricraft.common.block.TFCDeadCoralBlock;
import com.bloomhousemc.terrafabricraft.common.block.TFCDeadCoralFanBlock;

import static com.bloomhousemc.terrafabricraft.common.registry.TFCObjects.*;

public class CoralBlock {
    public TFCCoralBlock coral;
    public TFCCoralFanBlock fan;
    public TFCDeadCoralBlock dead_coral;
    public TFCDeadCoralFanBlock dead_fan;

    public CoralBlock(String variantId) {
        dead_coral = createDeadCoralBlock(variantId + "_dead_coral");
        dead_fan = createDeadCoralFanBlock(variantId + "_dead_coral_fan");
        coral = createCoralBlock(variantId + "_coral", dead_coral);
        fan = createCoralFanBlock(variantId + "_coral_fan", dead_fan);
    }
}


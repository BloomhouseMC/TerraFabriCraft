package io.github.bloomhousemc.terrafabricraft.common.registry.util;

import io.github.bloomhousemc.terrafabricraft.common.block.TFCCoralBlock;
import io.github.bloomhousemc.terrafabricraft.common.block.TFCCoralFanBlock;
import io.github.bloomhousemc.terrafabricraft.common.block.TFCDeadCoralBlock;
import io.github.bloomhousemc.terrafabricraft.common.block.TFCDeadCoralFanBlock;

import static io.github.bloomhousemc.terrafabricraft.common.registry.TFCObjects.*;

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


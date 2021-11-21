package com.bloomhousemc.terrafabricraft.common.registry.util;

import com.bloomhousemc.terrafabricraft.common.block.TfcCoralBlock;
import com.bloomhousemc.terrafabricraft.common.block.TfcCoralFanBlock;
import com.bloomhousemc.terrafabricraft.common.block.TfcDeadCoralBlock;
import com.bloomhousemc.terrafabricraft.common.block.TfcDeadCoralFanBlock;
import com.bloomhousemc.terrafabricraft.common.registry.TfcBlocks;


public class CoralBlock {
    public TfcCoralBlock coral;
    public TfcCoralFanBlock fan;
    public TfcDeadCoralBlock dead_coral;
    public TfcDeadCoralFanBlock dead_fan;

    public CoralBlock(String variantId) {
        dead_coral = TfcBlocks.createDeadCoralBlock(variantId + "_dead_coral");
        dead_fan = TfcBlocks.createDeadCoralFanBlock(variantId + "_dead_coral_fan");
        coral = TfcBlocks.createCoralBlock(variantId + "_coral", dead_coral);
        fan = TfcBlocks.createCoralFanBlock(variantId + "_coral_fan", dead_fan);
    }
}


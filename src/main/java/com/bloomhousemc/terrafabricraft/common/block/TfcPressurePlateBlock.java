package com.bloomhousemc.terrafabricraft.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.PressurePlateBlock;

public class TfcPressurePlateBlock extends PressurePlateBlock {
    public TfcPressurePlateBlock(Settings settings) {
        super(ActivationRule.EVERYTHING, settings);
    }
}

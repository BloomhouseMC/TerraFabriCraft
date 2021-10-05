package malek.terrafabricraft.common.registry;

import malek.terrafabricraft.common.block.TFCCoralBlock;
import malek.terrafabricraft.common.block.TFCCoralFanBlock;
import malek.terrafabricraft.common.block.TFCDeadCoralBlock;
import malek.terrafabricraft.common.block.TFCDeadCoralFanBlock;

import static malek.terrafabricraft.common.registry.TFCObjects.*;

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


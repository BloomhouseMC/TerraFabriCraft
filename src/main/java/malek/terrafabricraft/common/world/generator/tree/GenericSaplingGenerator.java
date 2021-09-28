package malek.terrafabricraft.common.world.generator.tree;

import blue.endless.jankson.annotation.Nullable;
import java.util.Random;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;

public class GenericSaplingGenerator extends AbstractTreeGrower {
    private final ConfiguredFeature<TreeConfiguration, ?> feature;

    public GenericSaplingGenerator(ConfiguredFeature<?, ?> feature) {
        this.feature = (ConfiguredFeature<TreeConfiguration, ?>) feature;
    }

    @Nullable
    @Override
    protected ConfiguredFeature<TreeConfiguration, ?> getConfiguredFeature(Random random, boolean bees) {
        return feature;
    }
}
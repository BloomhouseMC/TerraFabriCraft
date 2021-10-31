package io.github.bloomhousemc.terrafabricraft.common.world.generator.tree;

import blue.endless.jankson.annotation.Nullable;
import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;

import java.util.Random;

public class GenericSaplingGenerator extends SaplingGenerator {
    private final ConfiguredFeature<TreeFeatureConfig, ?> feature;

    public GenericSaplingGenerator(ConfiguredFeature<?, ?> feature) {
        this.feature = (ConfiguredFeature<TreeFeatureConfig, ?>) feature;
    }

    @Nullable
    @Override
    protected ConfiguredFeature<TreeFeatureConfig, ?> getTreeFeature(Random random, boolean bees) {
        return feature;
    }
}
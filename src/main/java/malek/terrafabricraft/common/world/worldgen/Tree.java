package malek.terrafabricraft.common.world.worldgen;

import malek.terrafabricraft.common.registry.TFCObjects;
import malek.terrafabricraft.mixin.common.TrunkPlacerTypeInvoker;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.stateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;
import net.minecraft.world.gen.trunk.TrunkPlacerType;

public class Tree {
//    Register

    public static final ConfiguredFeature<?, ?> TREE_ACACIA = Feature.TREE
            .configure(new TreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(TFCObjects.WOOD_ACACIA.log.getDefaultState()),
                    new StraightTrunkPlacer(8, 3, 0),
                    new SimpleBlockStateProvider(TFCObjects.WOOD_ACACIA.leaves.getDefaultState()),
                    new SimpleBlockStateProvider(TFCObjects.WOOD_ACACIA.sapling.getDefaultState()),
                    new BlobFoliagePlacer(ConstantIntProvider.create(5), ConstantIntProvider.create(0), 3),
                    new TwoLayersFeatureSize(1, 0, 1)
            ).build())
            .spreadHorizontally()
            .applyChance(3);

    public static final ConfiguredFeature<?, ?> TREE_ASH = Feature.TREE
            .configure(new TreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(TFCObjects.WOOD_ACACIA.log.getDefaultState()),
                    new StraightTrunkPlacer(8, 3, 0),
                    new SimpleBlockStateProvider(TFCObjects.WOOD_ACACIA.leaves.getDefaultState()),
                    new SimpleBlockStateProvider(TFCObjects.WOOD_ACACIA.sapling.getDefaultState()),
                    new BlobFoliagePlacer(ConstantIntProvider.create(5), ConstantIntProvider.create(0), 3),
                    new TwoLayersFeatureSize(1, 0, 1)
            ).build())
            .spreadHorizontally()
            .applyChance(3);

    public static final ConfiguredFeature<?, ?> TREE_ASPEN = Feature.TREE
            .configure(new TreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(TFCObjects.WOOD_ACACIA.log.getDefaultState()),
                    new StraightTrunkPlacer(8, 3, 0),
                    new SimpleBlockStateProvider(TFCObjects.WOOD_ACACIA.leaves.getDefaultState()),
                    new SimpleBlockStateProvider(TFCObjects.WOOD_ACACIA.sapling.getDefaultState()),
                    new BlobFoliagePlacer(ConstantIntProvider.create(5), ConstantIntProvider.create(0), 3),
                    new TwoLayersFeatureSize(1, 0, 1)
            ).build())
            .spreadHorizontally()
            .applyChance(3);

    public static final ConfiguredFeature<?, ?> TREE_BIRCH = Feature.TREE
            .configure(new TreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(TFCObjects.WOOD_ACACIA.log.getDefaultState()),
                    new StraightTrunkPlacer(8, 3, 0),
                    new SimpleBlockStateProvider(TFCObjects.WOOD_ACACIA.leaves.getDefaultState()),
                    new SimpleBlockStateProvider(TFCObjects.WOOD_ACACIA.sapling.getDefaultState()),
                    new BlobFoliagePlacer(ConstantIntProvider.create(5), ConstantIntProvider.create(0), 3),
                    new TwoLayersFeatureSize(1, 0, 1)
            ).build())
            .spreadHorizontally()
            .applyChance(3);

    public static final ConfiguredFeature<?, ?> TREE_BLACKWOOD = Feature.TREE
            .configure(new TreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(TFCObjects.WOOD_ACACIA.log.getDefaultState()),
                    new StraightTrunkPlacer(8, 3, 0),
                    new SimpleBlockStateProvider(TFCObjects.WOOD_ACACIA.leaves.getDefaultState()),
                    new SimpleBlockStateProvider(TFCObjects.WOOD_ACACIA.sapling.getDefaultState()),
                    new BlobFoliagePlacer(ConstantIntProvider.create(5), ConstantIntProvider.create(0), 3),
                    new TwoLayersFeatureSize(1, 0, 1)
            ).build())
            .spreadHorizontally()
            .applyChance(3);

    public static final ConfiguredFeature<?, ?> TREE_CHESTNUT = Feature.TREE
            .configure(new TreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(TFCObjects.WOOD_ACACIA.log.getDefaultState()),
                    new StraightTrunkPlacer(8, 3, 0),
                    new SimpleBlockStateProvider(TFCObjects.WOOD_ACACIA.leaves.getDefaultState()),
                    new SimpleBlockStateProvider(TFCObjects.WOOD_ACACIA.sapling.getDefaultState()),
                    new BlobFoliagePlacer(ConstantIntProvider.create(5), ConstantIntProvider.create(0), 3),
                    new TwoLayersFeatureSize(1, 0, 1)
            ).build())
            .spreadHorizontally()
            .applyChance(3);

    public static final ConfiguredFeature<?, ?> TREE_DOUGLAS_FIR = Feature.TREE
            .configure(new TreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(TFCObjects.WOOD_ACACIA.log.getDefaultState()),
                    new StraightTrunkPlacer(8, 3, 0),
                    new SimpleBlockStateProvider(TFCObjects.WOOD_ACACIA.leaves.getDefaultState()),
                    new SimpleBlockStateProvider(TFCObjects.WOOD_ACACIA.sapling.getDefaultState()),
                    new BlobFoliagePlacer(ConstantIntProvider.create(5), ConstantIntProvider.create(0), 3),
                    new TwoLayersFeatureSize(1, 0, 1)
            ).build())
            .spreadHorizontally()
            .applyChance(3);

    public static final ConfiguredFeature<?, ?> TREE_HICKORY = Feature.TREE
            .configure(new TreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(TFCObjects.WOOD_ACACIA.log.getDefaultState()),
                    new StraightTrunkPlacer(8, 3, 0),
                    new SimpleBlockStateProvider(TFCObjects.WOOD_ACACIA.leaves.getDefaultState()),
                    new SimpleBlockStateProvider(TFCObjects.WOOD_ACACIA.sapling.getDefaultState()),
                    new BlobFoliagePlacer(ConstantIntProvider.create(5), ConstantIntProvider.create(0), 3),
                    new TwoLayersFeatureSize(1, 0, 1)
            ).build())
            .spreadHorizontally()
            .applyChance(3);

    public static final ConfiguredFeature<?, ?> TREE_KAPOK = Feature.TREE
            .configure(new TreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(TFCObjects.WOOD_ACACIA.log.getDefaultState()),
                    new StraightTrunkPlacer(8, 3, 0),
                    new SimpleBlockStateProvider(TFCObjects.WOOD_ACACIA.leaves.getDefaultState()),
                    new SimpleBlockStateProvider(TFCObjects.WOOD_ACACIA.sapling.getDefaultState()),
                    new BlobFoliagePlacer(ConstantIntProvider.create(5), ConstantIntProvider.create(0), 3),
                    new TwoLayersFeatureSize(1, 0, 1)
            ).build())
            .spreadHorizontally()
            .applyChance(3);

    public static final ConfiguredFeature<?, ?> TREE_MAPLE = Feature.TREE
            .configure(new TreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(TFCObjects.WOOD_MAPLE.log.getDefaultState()),
                    new StraightTrunkPlacer(8, 3, 0),
                    new SimpleBlockStateProvider(TFCObjects.WOOD_MAPLE.leaves.getDefaultState()),
                    new SimpleBlockStateProvider(TFCObjects.WOOD_MAPLE.sapling.getDefaultState()),
                    new BlobFoliagePlacer(ConstantIntProvider.create(5), ConstantIntProvider.create(0), 3),
                    new TwoLayersFeatureSize(1, 0, 1)
            ).build())
            .spreadHorizontally()
            .applyChance(3);

    public static final ConfiguredFeature<?, ?> TREE_OAK = Feature.TREE
            .configure(new TreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(TFCObjects.WOOD_ACACIA.log.getDefaultState()),
                    new StraightTrunkPlacer(8, 3, 0),
                    new SimpleBlockStateProvider(TFCObjects.WOOD_ACACIA.leaves.getDefaultState()),
                    new SimpleBlockStateProvider(TFCObjects.WOOD_ACACIA.sapling.getDefaultState()),
                    new BlobFoliagePlacer(ConstantIntProvider.create(5), ConstantIntProvider.create(0), 3),
                    new TwoLayersFeatureSize(1, 0, 1)
            ).build())
            .spreadHorizontally()
            .applyChance(3);

    public static final ConfiguredFeature<?, ?> TREE_PALM = Feature.TREE
            .configure(new TreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(TFCObjects.WOOD_ACACIA.log.getDefaultState()),
                    new StraightTrunkPlacer(8, 3, 0),
                    new SimpleBlockStateProvider(TFCObjects.WOOD_ACACIA.leaves.getDefaultState()),
                    new SimpleBlockStateProvider(TFCObjects.WOOD_ACACIA.sapling.getDefaultState()),
                    new BlobFoliagePlacer(ConstantIntProvider.create(5), ConstantIntProvider.create(0), 3),
                    new TwoLayersFeatureSize(1, 0, 1)
            ).build())
            .spreadHorizontally()
            .applyChance(3);

    public static final ConfiguredFeature<?, ?> TREE_PINE = Feature.TREE
            .configure(new TreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(TFCObjects.WOOD_ACACIA.log.getDefaultState()),
                    new StraightTrunkPlacer(8, 3, 0),
                    new SimpleBlockStateProvider(TFCObjects.WOOD_ACACIA.leaves.getDefaultState()),
                    new SimpleBlockStateProvider(TFCObjects.WOOD_ACACIA.sapling.getDefaultState()),
                    new BlobFoliagePlacer(ConstantIntProvider.create(5), ConstantIntProvider.create(0), 3),
                    new TwoLayersFeatureSize(1, 0, 1)
            ).build())
            .spreadHorizontally()
            .applyChance(3);

    public static final ConfiguredFeature<?, ?> TREE_ROSEWOOD = Feature.TREE
            .configure(new TreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(TFCObjects.WOOD_ACACIA.log.getDefaultState()),
                    new StraightTrunkPlacer(8, 3, 0),
                    new SimpleBlockStateProvider(TFCObjects.WOOD_ACACIA.leaves.getDefaultState()),
                    new SimpleBlockStateProvider(TFCObjects.WOOD_ACACIA.sapling.getDefaultState()),
                    new BlobFoliagePlacer(ConstantIntProvider.create(5), ConstantIntProvider.create(0), 3),
                    new TwoLayersFeatureSize(1, 0, 1)
            ).build())
            .spreadHorizontally()
            .applyChance(3);

    public static final ConfiguredFeature<?, ?> TREE_SEQUOIA = Feature.TREE
            .configure(new TreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(TFCObjects.WOOD_ACACIA.log.getDefaultState()),
                    new StraightTrunkPlacer(8, 3, 0),
                    new SimpleBlockStateProvider(TFCObjects.WOOD_ACACIA.leaves.getDefaultState()),
                    new SimpleBlockStateProvider(TFCObjects.WOOD_ACACIA.sapling.getDefaultState()),
                    new BlobFoliagePlacer(ConstantIntProvider.create(5), ConstantIntProvider.create(0), 3),
                    new TwoLayersFeatureSize(1, 0, 1)
            ).build())
            .spreadHorizontally()
            .applyChance(3);

    public static final ConfiguredFeature<?, ?> TREE_SPRUCE = Feature.TREE
            .configure(new TreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(TFCObjects.WOOD_ACACIA.log.getDefaultState()),
                    new StraightTrunkPlacer(8, 3, 0),
                    new SimpleBlockStateProvider(TFCObjects.WOOD_ACACIA.leaves.getDefaultState()),
                    new SimpleBlockStateProvider(TFCObjects.WOOD_ACACIA.sapling.getDefaultState()),
                    new BlobFoliagePlacer(ConstantIntProvider.create(5), ConstantIntProvider.create(0), 3),
                    new TwoLayersFeatureSize(1, 0, 1)
            ).build())
            .spreadHorizontally()
            .applyChance(3);

    public static final ConfiguredFeature<?, ?> TREE_SYCAMORE = Feature.TREE
            .configure(new TreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(TFCObjects.WOOD_ACACIA.log.getDefaultState()),
                    new StraightTrunkPlacer(8, 3, 0),
                    new SimpleBlockStateProvider(TFCObjects.WOOD_ACACIA.leaves.getDefaultState()),
                    new SimpleBlockStateProvider(TFCObjects.WOOD_ACACIA.sapling.getDefaultState()),
                    new BlobFoliagePlacer(ConstantIntProvider.create(5), ConstantIntProvider.create(0), 3),
                    new TwoLayersFeatureSize(1, 0, 1)
            ).build())
            .spreadHorizontally()
            .applyChance(3);

    public static final ConfiguredFeature<?, ?> TREE_WHITE_CEDAR = Feature.TREE
            .configure(new TreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(TFCObjects.WOOD_ACACIA.log.getDefaultState()),
                    new StraightTrunkPlacer(8, 3, 0),
                    new SimpleBlockStateProvider(TFCObjects.WOOD_ACACIA.leaves.getDefaultState()),
                    new SimpleBlockStateProvider(TFCObjects.WOOD_ACACIA.sapling.getDefaultState()),
                    new BlobFoliagePlacer(ConstantIntProvider.create(5), ConstantIntProvider.create(0), 3),
                    new TwoLayersFeatureSize(1, 0, 1)
            ).build())
            .spreadHorizontally()
            .applyChance(3);

    public static final ConfiguredFeature<?, ?> TREE_WILLOW = Feature.TREE
            .configure(new TreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(TFCObjects.WOOD_ACACIA.log.getDefaultState()),
                    new StraightTrunkPlacer(8, 3, 0),
                    new SimpleBlockStateProvider(TFCObjects.WOOD_ACACIA.leaves.getDefaultState()),
                    new SimpleBlockStateProvider(TFCObjects.WOOD_ACACIA.sapling.getDefaultState()),
                    new BlobFoliagePlacer(ConstantIntProvider.create(5), ConstantIntProvider.create(0), 3),
                    new TwoLayersFeatureSize(1, 0, 1)
            ).build())
            .spreadHorizontally()
            .applyChance(3);

    public static void init() {

    }
}

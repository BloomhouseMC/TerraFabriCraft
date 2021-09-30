package malek.terrafabricraft.common.registry;

import malek.terrafabricraft.TerraFabriCraft;
import net.fabricmc.fabric.api.biome.v1.*;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.GenerationStep.Decoration;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.HeightmapConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.SimpleStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.placement.FeatureDecorator;
import java.util.function.Predicate;

public class TFCFeatures {


    public static final ConfiguredFeature<?, ?> TREE_ACACIA =   Feature.TREE
            .configured(new TreeConfiguration.TreeConfigurationBuilder(
                    new SimpleStateProvider(TFCObjects.WOOD_ACACIA.log.defaultBlockState()),
                    new StraightTrunkPlacer(5, 0, 0),
                    new SimpleStateProvider(TFCObjects.WOOD_ACACIA.leaves.defaultBlockState()),
                    new SimpleStateProvider(TFCObjects.WOOD_ACACIA.sapling.defaultBlockState()),
                    new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3),
                    new TwoLayersFeatureSize(0, 0, 0)
            ).ignoreVines().build())
            .rarity(3)
            .decorated(FeatureDecorator.HEIGHTMAP.configured(new HeightmapConfiguration(Heightmap.Types.MOTION_BLOCKING)));

    public static final ConfiguredFeature<?, ?> TREE_ASH = Feature.TREE
            .configured(new TreeConfiguration.TreeConfigurationBuilder(
                    new SimpleStateProvider(TFCObjects.WOOD_ASH.log.defaultBlockState()),
                    new StraightTrunkPlacer(8, 3, 0),
                    new SimpleStateProvider(TFCObjects.WOOD_ASH.leaves.defaultBlockState()),
                    new SimpleStateProvider(TFCObjects.WOOD_ASH.sapling.defaultBlockState()),
                    new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3),
                    new TwoLayersFeatureSize(1, 0, 1)
            ).ignoreVines().build())
            .rarity(3)
            .decorated(FeatureDecorator.HEIGHTMAP.configured(new HeightmapConfiguration(Heightmap.Types.MOTION_BLOCKING)));

    public static final ConfiguredFeature<?, ?> TREE_ASPEN = Feature.TREE
            .configured(new TreeConfiguration.TreeConfigurationBuilder(
                    new SimpleStateProvider(TFCObjects.WOOD_ASPEN.log.defaultBlockState()),
                    new StraightTrunkPlacer(8, 3, 0),
                    new SimpleStateProvider(TFCObjects.WOOD_ASPEN.leaves.defaultBlockState()),
                    new SimpleStateProvider(TFCObjects.WOOD_ASPEN.sapling.defaultBlockState()),
                    new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3),
                    new TwoLayersFeatureSize(1, 0, 1)
            ).ignoreVines().build())
            .rarity(3)
            .decorated(FeatureDecorator.HEIGHTMAP.configured(new HeightmapConfiguration(Heightmap.Types.MOTION_BLOCKING)));

    public static final ConfiguredFeature<?, ?> TREE_BIRCH = Feature.TREE
            .configured(new TreeConfiguration.TreeConfigurationBuilder(
                    new SimpleStateProvider(TFCObjects.WOOD_BIRCH.log.defaultBlockState()),
                    new StraightTrunkPlacer(12, 3, 0),
                    new SimpleStateProvider(TFCObjects.WOOD_BIRCH.leaves.defaultBlockState()),
                    new SimpleStateProvider(TFCObjects.WOOD_BIRCH.sapling.defaultBlockState()),
                    new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3),
                    new TwoLayersFeatureSize(1, 0, 1)
            ).build())
            .rarity(3)
            .decorated(FeatureDecorator.HEIGHTMAP.configured(new HeightmapConfiguration(Heightmap.Types.MOTION_BLOCKING)));

    public static final ConfiguredFeature<?, ?> TREE_BLACKWOOD = Feature.TREE
            .configured(new TreeConfiguration.TreeConfigurationBuilder(
                    new SimpleStateProvider(TFCObjects.WOOD_BLACKWOOD.log.defaultBlockState()),
                    new StraightTrunkPlacer(8, 3, 0),
                    new SimpleStateProvider(TFCObjects.WOOD_BLACKWOOD.leaves.defaultBlockState()),
                    new SimpleStateProvider(TFCObjects.WOOD_BLACKWOOD.sapling.defaultBlockState()),
                    new BlobFoliagePlacer(ConstantInt.of(5), ConstantInt.of(0), 3),
                    new TwoLayersFeatureSize(1, 0, 1)
            ).build())
            .rarity(3)
            .decorated(FeatureDecorator.HEIGHTMAP.configured(new HeightmapConfiguration(Heightmap.Types.MOTION_BLOCKING)));

    public static final ConfiguredFeature<?, ?> TREE_CHESTNUT = Feature.TREE
            .configured(new TreeConfiguration.TreeConfigurationBuilder(
                    new SimpleStateProvider(TFCObjects.WOOD_CHESTNUT.log.defaultBlockState()),
                    new StraightTrunkPlacer(8, 3, 0),
                    new SimpleStateProvider(TFCObjects.WOOD_CHESTNUT.leaves.defaultBlockState()),
                    new SimpleStateProvider(TFCObjects.WOOD_CHESTNUT.sapling.defaultBlockState()),
                    new BlobFoliagePlacer(ConstantInt.of(5), ConstantInt.of(0), 3),
                    new TwoLayersFeatureSize(1, 0, 1)
            ).build())
            .rarity(3)
            .decorated(FeatureDecorator.HEIGHTMAP.configured(new HeightmapConfiguration(Heightmap.Types.MOTION_BLOCKING)));

    public static final ConfiguredFeature<?, ?> TREE_DOUGLAS_FIR = Feature.TREE
            .configured(new TreeConfiguration.TreeConfigurationBuilder(
                    new SimpleStateProvider(TFCObjects.WOOD_DOUGLAS_FIR.log.defaultBlockState()),
                    new StraightTrunkPlacer(8, 3, 0),
                    new SimpleStateProvider(TFCObjects.WOOD_DOUGLAS_FIR.leaves.defaultBlockState()),
                    new SimpleStateProvider(TFCObjects.WOOD_DOUGLAS_FIR.sapling.defaultBlockState()),
                    new BlobFoliagePlacer(ConstantInt.of(5), ConstantInt.of(0), 3),
                    new TwoLayersFeatureSize(1, 0, 1)
            ).build())
            .rarity(3)
            .decorated(FeatureDecorator.HEIGHTMAP.configured(new HeightmapConfiguration(Heightmap.Types.MOTION_BLOCKING)));

    public static final ConfiguredFeature<?, ?> TREE_HICKORY = Feature.TREE
            .configured(new TreeConfiguration.TreeConfigurationBuilder(
                    new SimpleStateProvider(TFCObjects.WOOD_HICKORY.log.defaultBlockState()),
                    new StraightTrunkPlacer(8, 3, 0),
                    new SimpleStateProvider(TFCObjects.WOOD_HICKORY.leaves.defaultBlockState()),
                    new SimpleStateProvider(TFCObjects.WOOD_HICKORY.sapling.defaultBlockState()),
                    new BlobFoliagePlacer(ConstantInt.of(5), ConstantInt.of(0), 3),
                    new TwoLayersFeatureSize(1, 0, 1)
            ).build())
            .rarity(3)
            .decorated(FeatureDecorator.HEIGHTMAP.configured(new HeightmapConfiguration(Heightmap.Types.MOTION_BLOCKING)));

    public static final ConfiguredFeature<?, ?> TREE_KAPOK = Feature.TREE
            .configured(new TreeConfiguration.TreeConfigurationBuilder(
                    new SimpleStateProvider(TFCObjects.WOOD_KAPOK.log.defaultBlockState()),
                    new StraightTrunkPlacer(15, 9, 0),
                    new SimpleStateProvider(TFCObjects.WOOD_KAPOK.leaves.defaultBlockState()),
                    new SimpleStateProvider(TFCObjects.WOOD_KAPOK.sapling.defaultBlockState()),
                    new BlobFoliagePlacer(ConstantInt.of(5), ConstantInt.of(0), 3),
                    new TwoLayersFeatureSize(1, 0, 1)
            ).build())
            .rarity(3)
            .decorated(FeatureDecorator.HEIGHTMAP.configured(new HeightmapConfiguration(Heightmap.Types.MOTION_BLOCKING)));

    public static final ConfiguredFeature<?, ?> TREE_BIG_KAPOK = Feature.TREE
            .configured(new TreeConfiguration.TreeConfigurationBuilder(
                    new SimpleStateProvider(TFCObjects.WOOD_KAPOK.log.defaultBlockState()),
                    new StraightTrunkPlacer(30, 9, 0),
                    new SimpleStateProvider(TFCObjects.WOOD_KAPOK.leaves.defaultBlockState()),
                    new SimpleStateProvider(TFCObjects.WOOD_KAPOK.sapling.defaultBlockState()),
                    new BlobFoliagePlacer(ConstantInt.of(5), ConstantInt.of(0), 3),
                    new TwoLayersFeatureSize(1, 0, 1)
            ).build())
            .rarity(3)
            .decorated(FeatureDecorator.HEIGHTMAP.configured(new HeightmapConfiguration(Heightmap.Types.MOTION_BLOCKING)));

    public static final ConfiguredFeature<?, ?> TREE_SMALL_KAPOK = Feature.TREE
            .configured(new TreeConfiguration.TreeConfigurationBuilder(
                    new SimpleStateProvider(TFCObjects.WOOD_KAPOK.log.defaultBlockState()),
                    new StraightTrunkPlacer(15, 9, 0),
                    new SimpleStateProvider(TFCObjects.WOOD_KAPOK.leaves.defaultBlockState()),
                    new SimpleStateProvider(TFCObjects.WOOD_KAPOK.sapling.defaultBlockState()),
                    new BlobFoliagePlacer(ConstantInt.of(5), ConstantInt.of(0), 3),
                    new TwoLayersFeatureSize(1, 0, 1)
            ).build())
            .rarity(3)
            .decorated(FeatureDecorator.HEIGHTMAP.configured(new HeightmapConfiguration(Heightmap.Types.MOTION_BLOCKING)));

    public static final ConfiguredFeature<?, ?> TREE_MAPLE = Feature.TREE
            .configured(new TreeConfiguration.TreeConfigurationBuilder(
                    new SimpleStateProvider(TFCObjects.WOOD_MAPLE.log.defaultBlockState()),
                    new StraightTrunkPlacer(8, 3, 0),
                    new SimpleStateProvider(TFCObjects.WOOD_MAPLE.leaves.defaultBlockState()),
                    new SimpleStateProvider(TFCObjects.WOOD_MAPLE.sapling.defaultBlockState()),
                    new BlobFoliagePlacer(ConstantInt.of(5), ConstantInt.of(0), 3),
                    new TwoLayersFeatureSize(1, 0, 1)
            ).build())
            .rarity(3)
            .decorated(FeatureDecorator.HEIGHTMAP.configured(new HeightmapConfiguration(Heightmap.Types.MOTION_BLOCKING)));

    public static final ConfiguredFeature<?, ?> TREE_OAK = Feature.TREE
            .configured(new TreeConfiguration.TreeConfigurationBuilder(
                    new SimpleStateProvider(TFCObjects.WOOD_OAK.log.defaultBlockState()),
                    new StraightTrunkPlacer(8, 3, 0),
                    new SimpleStateProvider(TFCObjects.WOOD_OAK.leaves.defaultBlockState()),
                    new SimpleStateProvider(TFCObjects.WOOD_OAK.sapling.defaultBlockState()),
                    new BlobFoliagePlacer(ConstantInt.of(5), ConstantInt.of(0), 3),
                    new TwoLayersFeatureSize(1, 0, 1)
            ).build())
            .rarity(3)
            .decorated(FeatureDecorator.HEIGHTMAP.configured(new HeightmapConfiguration(Heightmap.Types.MOTION_BLOCKING)));

    public static final ConfiguredFeature<?, ?> TREE_PALM = Feature.TREE
            .configured(new TreeConfiguration.TreeConfigurationBuilder(
                    new SimpleStateProvider(TFCObjects.WOOD_PALM.log.defaultBlockState()),
                    new StraightTrunkPlacer(8, 3, 0),
                    new SimpleStateProvider(TFCObjects.WOOD_PALM.leaves.defaultBlockState()),
                    new SimpleStateProvider(TFCObjects.WOOD_PALM.sapling.defaultBlockState()),
                    new BlobFoliagePlacer(ConstantInt.of(5), ConstantInt.of(0), 3),
                    new TwoLayersFeatureSize(1, 0, 1)
            ).build())
            .rarity(3)
            .decorated(FeatureDecorator.HEIGHTMAP.configured(new HeightmapConfiguration(Heightmap.Types.MOTION_BLOCKING)));

    public static final ConfiguredFeature<?, ?> TREE_PINE = Feature.TREE
            .configured(new TreeConfiguration.TreeConfigurationBuilder(
                    new SimpleStateProvider(TFCObjects.WOOD_PINE.log.defaultBlockState()),
                    new StraightTrunkPlacer(8, 3, 0),
                    new SimpleStateProvider(TFCObjects.WOOD_PINE.leaves.defaultBlockState()),
                    new SimpleStateProvider(TFCObjects.WOOD_PINE.sapling.defaultBlockState()),
                    new BlobFoliagePlacer(ConstantInt.of(5), ConstantInt.of(0), 3),
                    new TwoLayersFeatureSize(1, 0, 1)
            ).build())
            .rarity(3)
            .decorated(FeatureDecorator.HEIGHTMAP.configured(new HeightmapConfiguration(Heightmap.Types.MOTION_BLOCKING)));

    public static final ConfiguredFeature<?, ?> TREE_ROSEWOOD = Feature.TREE
            .configured(new TreeConfiguration.TreeConfigurationBuilder(
                    new SimpleStateProvider(TFCObjects.WOOD_ROSEWOOD.log.defaultBlockState()),
                    new StraightTrunkPlacer(8, 3, 0),
                    new SimpleStateProvider(TFCObjects.WOOD_ROSEWOOD.leaves.defaultBlockState()),
                    new SimpleStateProvider(TFCObjects.WOOD_ROSEWOOD.sapling.defaultBlockState()),
                    new BlobFoliagePlacer(ConstantInt.of(5), ConstantInt.of(0), 3),
                    new TwoLayersFeatureSize(1, 0, 1)
            ).build())
            .rarity(3)
            .decorated(FeatureDecorator.HEIGHTMAP.configured(new HeightmapConfiguration(Heightmap.Types.MOTION_BLOCKING)));

    public static final ConfiguredFeature<?, ?> TREE_SEQUOIA = Feature.TREE
            .configured(new TreeConfiguration.TreeConfigurationBuilder(
                    new SimpleStateProvider(TFCObjects.WOOD_SEQUOIA.log.defaultBlockState()),
                    new StraightTrunkPlacer(8, 3, 0),
                    new SimpleStateProvider(TFCObjects.WOOD_SEQUOIA.leaves.defaultBlockState()),
                    new SimpleStateProvider(TFCObjects.WOOD_SEQUOIA.sapling.defaultBlockState()),
                    new BlobFoliagePlacer(ConstantInt.of(5), ConstantInt.of(0), 3),
                    new TwoLayersFeatureSize(1, 0, 1)
            ).build())
            .rarity(3)
            .decorated(FeatureDecorator.HEIGHTMAP.configured(new HeightmapConfiguration(Heightmap.Types.MOTION_BLOCKING)));

    public static final ConfiguredFeature<?, ?> TREE_SPRUCE = Feature.TREE
            .configured(new TreeConfiguration.TreeConfigurationBuilder(
                    new SimpleStateProvider(TFCObjects.WOOD_SPRUCE.log.defaultBlockState()),
                    new StraightTrunkPlacer(8, 3, 0),
                    new SimpleStateProvider(TFCObjects.WOOD_SPRUCE.leaves.defaultBlockState()),
                    new SimpleStateProvider(TFCObjects.WOOD_SPRUCE.sapling.defaultBlockState()),
                    new BlobFoliagePlacer(ConstantInt.of(5), ConstantInt.of(0), 3),
                    new TwoLayersFeatureSize(1, 0, 1)
            ).build())
            .rarity(3)
            .decorated(FeatureDecorator.HEIGHTMAP.configured(new HeightmapConfiguration(Heightmap.Types.MOTION_BLOCKING)));

    public static final ConfiguredFeature<?, ?> TREE_SYCAMORE = Feature.TREE
            .configured(new TreeConfiguration.TreeConfigurationBuilder(
                    new SimpleStateProvider(TFCObjects.WOOD_SYCAMORE.log.defaultBlockState()),
                    new StraightTrunkPlacer(8, 3, 0),
                    new SimpleStateProvider(TFCObjects.WOOD_SYCAMORE.leaves.defaultBlockState()),
                    new SimpleStateProvider(TFCObjects.WOOD_SYCAMORE.sapling.defaultBlockState()),
                    new BlobFoliagePlacer(ConstantInt.of(5), ConstantInt.of(0), 3),
                    new TwoLayersFeatureSize(1, 0, 1)
            ).build())
            .rarity(3)
            .decorated(FeatureDecorator.HEIGHTMAP.configured(new HeightmapConfiguration(Heightmap.Types.MOTION_BLOCKING)));

    public static final ConfiguredFeature<?, ?> TREE_WHITE_CEDAR = Feature.TREE
            .configured(new TreeConfiguration.TreeConfigurationBuilder(
                    new SimpleStateProvider(TFCObjects.WOOD_WHITE_CEDAR.log.defaultBlockState()),
                    new StraightTrunkPlacer(8, 3, 0),
                    new SimpleStateProvider(TFCObjects.WOOD_WHITE_CEDAR.leaves.defaultBlockState()),
                    new SimpleStateProvider(TFCObjects.WOOD_WHITE_CEDAR.sapling.defaultBlockState()),
                    new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3),
                    new TwoLayersFeatureSize(1, 0, 1)
            ).build())
            .rarity(3)
            .decorated(FeatureDecorator.HEIGHTMAP.configured(new HeightmapConfiguration(Heightmap.Types.MOTION_BLOCKING)));

    public static final ConfiguredFeature<?, ?> TREE_WILLOW = Feature.TREE
            .configured(new TreeConfiguration.TreeConfigurationBuilder(
                    new SimpleStateProvider(TFCObjects.WOOD_WILLOW.log.defaultBlockState()),
                    new StraightTrunkPlacer(8, 3, 0),
                    new SimpleStateProvider(TFCObjects.WOOD_WILLOW.leaves.defaultBlockState()),
                    new SimpleStateProvider(TFCObjects.WOOD_WILLOW.sapling.defaultBlockState()),
                    new BlobFoliagePlacer(ConstantInt.of(5), ConstantInt.of(0), 3),
                    new TwoLayersFeatureSize(1, 0, 1)
            ).build())
            .rarity(3)
            .decorated(FeatureDecorator.HEIGHTMAP.configured(new HeightmapConfiguration(Heightmap.Types.MOTION_BLOCKING)));

    public static void register(String id, ConfiguredFeature<?, ?> feature, Predicate<BiomeSelectionContext> biome, GenerationStep.Decoration generationStep) {
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new
                ResourceLocation(TerraFabriCraft.MODID, id), feature);
        BiomeModification worldGen = BiomeModifications.create(new ResourceLocation(TerraFabriCraft.MODID, "world_features"));
        worldGen.add(ModificationPhase.ADDITIONS, biome, context -> context.getGenerationSettings().
                addBuiltInFeature(GenerationStep.Decoration.VEGETAL_DECORATION, feature));
    }

    public static void init() {
        var vegetalGenStep = GenerationStep.Decoration.VEGETAL_DECORATION;
        var otherGenStep = GenerationStep.Decoration.TOP_LAYER_MODIFICATION;
        //Register new feature
        //Register configured feature
//        register("tree/acacia", TREE_ACACIA, BiomeSelectors.foundInOverworld(), vegetalGenStep);
        register("tree/ash", TREE_ASH, BiomeSelectors.foundInOverworld(), vegetalGenStep);
        register("tree/aspen", TREE_ASPEN, BiomeSelectors.foundInOverworld(), vegetalGenStep);
        register("tree/birch", TREE_BIRCH, BiomeSelectors.categories(Biome.BiomeCategory.PLAINS), vegetalGenStep);
        register("tree/blackwood", TREE_BLACKWOOD, BiomeSelectors.foundInOverworld(), vegetalGenStep);
        register("tree/chestnut", TREE_CHESTNUT, BiomeSelectors.foundInOverworld(), vegetalGenStep);
        register("tree/douglas_fir", TREE_DOUGLAS_FIR, BiomeSelectors.foundInOverworld(), vegetalGenStep);
        register("tree/hickory", TREE_HICKORY, BiomeSelectors.foundInOverworld(), vegetalGenStep);
        register("tree/big_kapok", TREE_BIG_KAPOK, BiomeSelectors.categories(Biome.BiomeCategory.JUNGLE), vegetalGenStep);
        register("tree/small_kapok", TREE_SMALL_KAPOK, BiomeSelectors.categories(Biome.BiomeCategory.JUNGLE), vegetalGenStep);
        register("tree/maple", TREE_MAPLE, BiomeSelectors.foundInOverworld(), vegetalGenStep);
        register("tree/oak", TREE_OAK, BiomeSelectors.foundInOverworld(), vegetalGenStep);
        register("tree/palm", TREE_PALM, BiomeSelectors.foundInOverworld(), vegetalGenStep);
        register("tree/pine", TREE_PINE, BiomeSelectors.foundInOverworld(), vegetalGenStep);
        register("tree/rosewood", TREE_ROSEWOOD, BiomeSelectors.foundInOverworld(), vegetalGenStep);
        register("tree/sequoia", TREE_SEQUOIA, BiomeSelectors.foundInOverworld(), vegetalGenStep);
        register("tree/spruce", TREE_SPRUCE, BiomeSelectors.foundInOverworld(), vegetalGenStep);
        register("tree/sycamore", TREE_SYCAMORE, BiomeSelectors.foundInOverworld(), vegetalGenStep);
        register("tree/white_cedar", TREE_WHITE_CEDAR, BiomeSelectors.foundInOverworld(), vegetalGenStep);
        register("tree/willow", TREE_WILLOW, BiomeSelectors.foundInOverworld(), vegetalGenStep);
    }
}

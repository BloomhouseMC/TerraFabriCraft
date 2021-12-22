package com.bloomhousemc.terrafabricraft.common.registry;

import com.bloomhousemc.terrafabricraft.TerraFabriCraft;
import com.bloomhousemc.terrafabricraft.common.config.ModuleConfig;
import com.bloomhousemc.terrafabricraft.common.util.TfcUtils;
import com.bloomhousemc.terrafabricraft.common.world.generator.feature.BoulderFeature;
import com.bloomhousemc.terrafabricraft.common.world.generator.feature.TestBoulderFeature;
import com.bloomhousemc.terrafabricraft.mixin.common.SimpleBlockStateProviderAccessor;
import net.fabricmc.fabric.api.biome.v1.*;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.decorator.*;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.foliage.BushFoliagePlacer;
import net.minecraft.world.gen.foliage.PineFoliagePlacer;
import net.minecraft.world.gen.heightprovider.UniformHeightProvider;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

import java.util.List;
import java.util.function.Predicate;

public class TfcFeatures {

    private static final Feature<DefaultFeatureConfig> BOULDER = new BoulderFeature(DefaultFeatureConfig.CODEC);

    public static final ConfiguredFeature<?, ?> TREE_ACACIA = Feature.TREE
            .configure(new TreeFeatureConfig.Builder(
                    SimpleBlockStateProviderAccessor.init(TfcBlocks.WOOD_ACACIA.LOG.getDefaultState()),
                    new StraightTrunkPlacer(5, 0, 0),
                    SimpleBlockStateProviderAccessor.init(TfcBlocks.WOOD_ACACIA.LEAVES.getDefaultState()),
                    new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 3),
                    new TwoLayersFeatureSize(1, 0, 1)
            ).ignoreVines().build());

    public static final ConfiguredFeature<?, ?> TREE_ASH = Feature.TREE
            .configure(new TreeFeatureConfig.Builder(
                    SimpleBlockStateProviderAccessor.init(TfcBlocks.WOOD_ASH.LOG.getDefaultState()),
                    new StraightTrunkPlacer(8, 3, 0),
                    SimpleBlockStateProviderAccessor.init(TfcBlocks.WOOD_ASH.LEAVES.getDefaultState()),
                    new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 3),
                    new TwoLayersFeatureSize(1, 0, 1)
            ).ignoreVines().build());

    public static final ConfiguredFeature<?, ?> TREE_ASPEN = Feature.TREE
            .configure(new TreeFeatureConfig.Builder(
                    SimpleBlockStateProviderAccessor.init(TfcBlocks.WOOD_ASPEN.LOG.getDefaultState()),
                    new StraightTrunkPlacer(8, 3, 0),
                    SimpleBlockStateProviderAccessor.init(TfcBlocks.WOOD_ASPEN.LEAVES.getDefaultState()),
                    new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 3),
                    new TwoLayersFeatureSize(1, 0, 1)
            ).ignoreVines().build());

    public static final ConfiguredFeature<?, ?> TREE_BIRCH = Feature.TREE
            .configure(new TreeFeatureConfig.Builder(
                    SimpleBlockStateProviderAccessor.init(TfcBlocks.WOOD_BIRCH.LOG.getDefaultState()),
                    new StraightTrunkPlacer(12, 3, 0),
                    SimpleBlockStateProviderAccessor.init(TfcBlocks.WOOD_BIRCH.LEAVES.getDefaultState()),
                    new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 3),
                    new TwoLayersFeatureSize(1, 0, 1)
            ).build());

    public static final ConfiguredFeature<?, ?> TREE_BLACKWOOD = Feature.TREE
            .configure(new TreeFeatureConfig.Builder(
                    SimpleBlockStateProviderAccessor.init(TfcBlocks.WOOD_BLACKWOOD.LOG.getDefaultState()),
                    new StraightTrunkPlacer(8, 3, 0),
                    SimpleBlockStateProviderAccessor.init(TfcBlocks.WOOD_BLACKWOOD.LEAVES.getDefaultState()),
                    new PineFoliagePlacer(ConstantIntProvider.create(5), ConstantIntProvider.create(5), ConstantIntProvider.create(5)),
                    new TwoLayersFeatureSize(1, 0, 1)
            ).build());

    public static final ConfiguredFeature<?, ?> TREE_CHESTNUT = Feature.TREE
            .configure(new TreeFeatureConfig.Builder(
                    SimpleBlockStateProviderAccessor.init(TfcBlocks.WOOD_CHESTNUT.LOG.getDefaultState()),
                    new StraightTrunkPlacer(5, 2, 3),
                    SimpleBlockStateProviderAccessor.init(TfcBlocks.WOOD_CHESTNUT.LEAVES.getDefaultState()),
                    new BushFoliagePlacer(ConstantIntProvider.create(5), ConstantIntProvider.create(0), 3),
                    new TwoLayersFeatureSize(1, 0, 1)
            ).build());

    public static final ConfiguredFeature<?, ?> TREE_DOUGLAS_FIR = Feature.TREE
            .configure(new TreeFeatureConfig.Builder(
                    SimpleBlockStateProviderAccessor.init(TfcBlocks.WOOD_DOUGLAS_FIR.LOG.getDefaultState()),
                    new StraightTrunkPlacer(8, 3, 0),
                    SimpleBlockStateProviderAccessor.init(TfcBlocks.WOOD_DOUGLAS_FIR.LEAVES.getDefaultState()),
                    new BlobFoliagePlacer(ConstantIntProvider.create(5), ConstantIntProvider.create(0), 3),
                    new TwoLayersFeatureSize(1, 0, 1)
            ).build());

    public static final ConfiguredFeature<?, ?> TREE_HICKORY = Feature.TREE
            .configure(new TreeFeatureConfig.Builder(
                    SimpleBlockStateProviderAccessor.init(TfcBlocks.WOOD_HICKORY.LOG.getDefaultState()),
                    new StraightTrunkPlacer(8, 3, 0),
                    SimpleBlockStateProviderAccessor.init(TfcBlocks.WOOD_HICKORY.LEAVES.getDefaultState()),
                    new BlobFoliagePlacer(ConstantIntProvider.create(5), ConstantIntProvider.create(0), 3),
                    new TwoLayersFeatureSize(1, 0, 1)
            ).build());

    public static final ConfiguredFeature<?, ?> TREE_KAPOK = Feature.TREE
            .configure(new TreeFeatureConfig.Builder(
                    SimpleBlockStateProviderAccessor.init(TfcBlocks.WOOD_KAPOK.LOG.getDefaultState()),
                    new StraightTrunkPlacer(15, 9, 0),
                    SimpleBlockStateProviderAccessor.init(TfcBlocks.WOOD_KAPOK.LEAVES.getDefaultState()),
                    new BlobFoliagePlacer(ConstantIntProvider.create(5), ConstantIntProvider.create(0), 3),
                    new TwoLayersFeatureSize(1, 0, 1)
            ).build());

    public static final ConfiguredFeature<?, ?> TREE_BIG_KAPOK = Feature.TREE
            .configure(new TreeFeatureConfig.Builder(
                    SimpleBlockStateProviderAccessor.init(TfcBlocks.WOOD_KAPOK.LOG.getDefaultState()),
                    new StraightTrunkPlacer(30, 9, 0),
                    SimpleBlockStateProviderAccessor.init(TfcBlocks.WOOD_KAPOK.LEAVES.getDefaultState()),
                    new BlobFoliagePlacer(ConstantIntProvider.create(5), ConstantIntProvider.create(0), 3),
                    new TwoLayersFeatureSize(1, 0, 1)
            ).build());

    public static final ConfiguredFeature<?, ?> TREE_SMALL_KAPOK = Feature.TREE
            .configure(new TreeFeatureConfig.Builder(
                    SimpleBlockStateProviderAccessor.init(TfcBlocks.WOOD_KAPOK.LOG.getDefaultState()),
                    new StraightTrunkPlacer(15, 9, 0),
                    SimpleBlockStateProviderAccessor.init(TfcBlocks.WOOD_KAPOK.LEAVES.getDefaultState()),
                    new BlobFoliagePlacer(ConstantIntProvider.create(5), ConstantIntProvider.create(0), 3),
                    new TwoLayersFeatureSize(1, 0, 1)
            ).build());

    public static final ConfiguredFeature<?, ?> TREE_MAPLE = Feature.TREE
            .configure(new TreeFeatureConfig.Builder(
                    SimpleBlockStateProviderAccessor.init(TfcBlocks.WOOD_MAPLE.LOG.getDefaultState()),
                    new StraightTrunkPlacer(8, 3, 0),
                    SimpleBlockStateProviderAccessor.init(TfcBlocks.WOOD_MAPLE.LEAVES.getDefaultState()),
                    new BlobFoliagePlacer(ConstantIntProvider.create(5), ConstantIntProvider.create(0), 3),
                    new TwoLayersFeatureSize(1, 0, 1)
            ).build());

    public static final ConfiguredFeature<?, ?> TREE_OAK = Feature.TREE
            .configure(new TreeFeatureConfig.Builder(
                    SimpleBlockStateProviderAccessor.init(TfcBlocks.WOOD_OAK.LOG.getDefaultState()),
                    new StraightTrunkPlacer(8, 3, 0),
                    SimpleBlockStateProviderAccessor.init(TfcBlocks.WOOD_OAK.LEAVES.getDefaultState()),
                    new BlobFoliagePlacer(ConstantIntProvider.create(5), ConstantIntProvider.create(0), 3),
                    new TwoLayersFeatureSize(1, 0, 1)
            ).build());

    public static final ConfiguredFeature<?, ?> TREE_PALM = Feature.TREE
            .configure(new TreeFeatureConfig.Builder(
                    SimpleBlockStateProviderAccessor.init(TfcBlocks.WOOD_PALM.LOG.getDefaultState()),
                    new StraightTrunkPlacer(8, 3, 0),
                    SimpleBlockStateProviderAccessor.init(TfcBlocks.WOOD_PALM.LEAVES.getDefaultState()),
                    new BlobFoliagePlacer(ConstantIntProvider.create(5), ConstantIntProvider.create(0), 3),
                    new TwoLayersFeatureSize(1, 0, 1)
            ).build());

    public static final ConfiguredFeature<?, ?> TREE_PINE = Feature.TREE
            .configure(new TreeFeatureConfig.Builder(
                    SimpleBlockStateProviderAccessor.init(TfcBlocks.WOOD_PINE.LOG.getDefaultState()),
                    new StraightTrunkPlacer(8, 3, 0),
                    SimpleBlockStateProviderAccessor.init(TfcBlocks.WOOD_PINE.LEAVES.getDefaultState()),
                    new BlobFoliagePlacer(ConstantIntProvider.create(5), ConstantIntProvider.create(0), 3),
                    new TwoLayersFeatureSize(1, 0, 1)
            ).build());

    public static final ConfiguredFeature<?, ?> TREE_ROSEWOOD = Feature.TREE
            .configure(new TreeFeatureConfig.Builder(
                    SimpleBlockStateProviderAccessor.init(TfcBlocks.WOOD_ROSEWOOD.LOG.getDefaultState()),
                    new StraightTrunkPlacer(8, 3, 0),
                    SimpleBlockStateProviderAccessor.init(TfcBlocks.WOOD_ROSEWOOD.LEAVES.getDefaultState()),
                    new BlobFoliagePlacer(ConstantIntProvider.create(5), ConstantIntProvider.create(0), 3),
                    new TwoLayersFeatureSize(1, 0, 1)
            ).build());

    public static final ConfiguredFeature<?, ?> TREE_SEQUOIA = Feature.TREE
            .configure(new TreeFeatureConfig.Builder(
                    SimpleBlockStateProviderAccessor.init(TfcBlocks.WOOD_SEQUOIA.LOG.getDefaultState()),
                    new StraightTrunkPlacer(8, 3, 0),
                    SimpleBlockStateProviderAccessor.init(TfcBlocks.WOOD_SEQUOIA.LEAVES.getDefaultState()),
                    new BlobFoliagePlacer(ConstantIntProvider.create(5), ConstantIntProvider.create(0), 3),
                    new TwoLayersFeatureSize(1, 0, 1)
            ).build());

    public static final ConfiguredFeature<?, ?> TREE_SPRUCE = Feature.TREE
            .configure(new TreeFeatureConfig.Builder(
                    SimpleBlockStateProviderAccessor.init(TfcBlocks.WOOD_SPRUCE.LOG.getDefaultState()),
                    new StraightTrunkPlacer(8, 3, 0),
                    SimpleBlockStateProviderAccessor.init(TfcBlocks.WOOD_SPRUCE.LEAVES.getDefaultState()),
                    new BlobFoliagePlacer(ConstantIntProvider.create(5), ConstantIntProvider.create(0), 3),
                    new TwoLayersFeatureSize(1, 0, 1)
            ).build());

    public static final ConfiguredFeature<?, ?> TREE_SYCAMORE = Feature.TREE
            .configure(new TreeFeatureConfig.Builder(
                    SimpleBlockStateProviderAccessor.init(TfcBlocks.WOOD_SYCAMORE.LOG.getDefaultState()),
                    new StraightTrunkPlacer(8, 3, 0),
                    SimpleBlockStateProviderAccessor.init(TfcBlocks.WOOD_SYCAMORE.LEAVES.getDefaultState()),
                    new BlobFoliagePlacer(ConstantIntProvider.create(5), ConstantIntProvider.create(0), 3),
                    new TwoLayersFeatureSize(1, 0, 1)
            ).build());

    public static final ConfiguredFeature<?, ?> TREE_WHITE_CEDAR = Feature.TREE
            .configure(new TreeFeatureConfig.Builder(
                    SimpleBlockStateProviderAccessor.init(TfcBlocks.WOOD_WHITE_CEDAR.LOG.getDefaultState()),
                    new StraightTrunkPlacer(8, 3, 0),
                    SimpleBlockStateProviderAccessor.init(TfcBlocks.WOOD_WHITE_CEDAR.LEAVES.getDefaultState()),
                    new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 3),
                    new TwoLayersFeatureSize(1, 0, 1)
            ).build());

    public static final ConfiguredFeature<?, ?> TREE_WILLOW = Feature.TREE
            .configure(new TreeFeatureConfig.Builder(
                    SimpleBlockStateProviderAccessor.init(TfcBlocks.WOOD_WILLOW.LOG.getDefaultState()),
                    new StraightTrunkPlacer(8, 3, 0),
                    SimpleBlockStateProviderAccessor.init(TfcBlocks.WOOD_WILLOW.LEAVES.getDefaultState()),
                    new BlobFoliagePlacer(ConstantIntProvider.create(5), ConstantIntProvider.create(0), 3),
                    new TwoLayersFeatureSize(1, 0, 1)
            ).build());

    public static void register(String id, ConfiguredFeature<?, ?> feature, Predicate<BiomeSelectionContext> biome, GenerationStep.Feature generationStep, Block sapling) {
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new
                Identifier(TerraFabriCraft.MODID, id), feature);
        BiomeModification worldGen = BiomeModifications.create(new Identifier(TerraFabriCraft.MODID, "world_features"));
        if (ModuleConfig.getValue("world")) {
            PlacedFeature placedFeature = feature.withPlacement(VegetationPlacedFeatures.modifiersWithWouldSurvive(RarityFilterPlacementModifier.of(10), sapling));
            worldGen.add(ModificationPhase.ADDITIONS, biome, context -> context.getGenerationSettings().
                    addBuiltInFeature(GenerationStep.Feature.VEGETAL_DECORATION, placedFeature));
        }
    }

//    public static void registerOre(String id, BlockState state) {
//        RegistryKey<ConfiguredFeature<?, ?>> ore = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier("terrafabricraft", id));
//        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, ore.getValue(), ROCK_FEATURE.configure(new OreFeatureConfig(
//                OreFeatureConfig.Rules.BASE_STONE_OVERWORLD,
//                state,
//                60)));
//        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, ore);
//    }

    public static final ConfiguredFeature<?, ?> BOULDER_ANDESITE = BOULDER.configure(new DefaultFeatureConfig());

    public static final Feature<SingleStateFeatureConfig> TEST_BOULDER = new TestBoulderFeature(SingleStateFeatureConfig.CODEC);
    public static final ConfiguredFeature<?, ?> TEST_BOULDER_CONFIGURED = TEST_BOULDER.configure(new SingleStateFeatureConfig(TfcUtils.getRandomRawStone(TfcUtils.RNG)));


    private static PlacedFeature ORE_WOOL_OVERWORLD = Feature.ORE
            .configure(new OreFeatureConfig(
                    OreConfiguredFeatures.BASE_STONE_OVERWORLD,
                    Blocks.WHITE_WOOL.getDefaultState(),
                    60)).withPlacement(oreWithCount(30, HeightRangePlacementModifier.uniform(YOffset.aboveBottom(0), YOffset.fixed(64))));

    public static final int SPAWN_RATE = 5;
    public static final OreFeatureConfig ORE_FEATURE_CONFIG = new OreFeatureConfig(OreConfiguredFeatures.BASE_STONE_OVERWORLD, Blocks.AIR.getDefaultState(), 9);// number of veins per chunk
    RangeDecoratorConfig rangeDecoratorConfig = new RangeDecoratorConfig(
            // You can also use one of the other height providers if you don't want a uniform distribution
            UniformHeightProvider.create(YOffset.aboveBottom(0), YOffset.fixed(64)));


    public static List<PlacementModifier> modifiersCount(int count, PlacementModifier heightmap) {
        return List.of(SquarePlacementModifier.of(), heightmap, CountPlacementModifier.of(count), BiomePlacementModifier.of());
    }

    private static List<PlacementModifier> oreWithCount(int count, PlacementModifier heightModifier) {
        return modifiers(CountPlacementModifier.of(count), heightModifier);
    }

    private static List<PlacementModifier> modifiers(PlacementModifier countModifier, PlacementModifier heightModifier) {
        return List.of(countModifier, SquarePlacementModifier.of(), heightModifier, BiomePlacementModifier.of());
    }

    public static void init() {
        var vegetalGenStep = GenerationStep.Feature.VEGETAL_DECORATION;
//        var otherGenStep = GenerationStep.Feature.TOP_LAYER_MODIFICATION;

        //Register new feature
        Registry.register(Registry.FEATURE, new Identifier("terrafabricraft", "boulder"), BOULDER);


      //  registerOre("ore_test", ORE_WOOL_OVERWORLD);

        //   Registry.register(Registry.FEATURE, new Identifier(TerraFabriCraft.MOD_ID, "test_boulder"), TEST_BOULDER);

        register("tree/acacia", TREE_ACACIA, BiomeSelectors.categories(Biome.Category.THEEND), vegetalGenStep, TfcBlocks.WOOD_ACACIA.SAPLING);
        register("tree/ash", TREE_ASH, BiomeSelectors.categories(Biome.Category.THEEND), vegetalGenStep, TfcBlocks.WOOD_ASH.SAPLING);
        register("tree/aspen", TREE_ASPEN, BiomeSelectors.categories(Biome.Category.THEEND), vegetalGenStep, TfcBlocks.WOOD_ASPEN.SAPLING);
        register("tree/birch", TREE_BIRCH, BiomeSelectors.categories(Biome.Category.NETHER), vegetalGenStep, TfcBlocks.WOOD_BIRCH.SAPLING);
        register("tree/blackwood", TREE_BLACKWOOD, BiomeSelectors.categories(Biome.Category.NETHER), vegetalGenStep, TfcBlocks.WOOD_BLACKWOOD.SAPLING);
        register("tree/chestnut", TREE_CHESTNUT, BiomeSelectors.categories(Biome.Category.NETHER), vegetalGenStep, TfcBlocks.WOOD_CHESTNUT.SAPLING);
        register("tree/douglas_fir", TREE_DOUGLAS_FIR, BiomeSelectors.categories(Biome.Category.THEEND), vegetalGenStep, TfcBlocks.WOOD_DOUGLAS_FIR.SAPLING);
        register("tree/hickory", TREE_HICKORY, BiomeSelectors.categories(Biome.Category.THEEND), vegetalGenStep, TfcBlocks.WOOD_HICKORY.SAPLING);
        register("tree/big_kapok", TREE_BIG_KAPOK, BiomeSelectors.categories(Biome.Category.JUNGLE), vegetalGenStep, TfcBlocks.WOOD_KAPOK.SAPLING);
        register("tree/small_kapok", TREE_SMALL_KAPOK, BiomeSelectors.categories(Biome.Category.JUNGLE), vegetalGenStep, TfcBlocks.WOOD_KAPOK.SAPLING);
        register("tree/maple", TREE_MAPLE, BiomeSelectors.categories(Biome.Category.THEEND), vegetalGenStep, TfcBlocks.WOOD_MAPLE.SAPLING);
        register("tree/oak", TREE_OAK, BiomeSelectors.categories(Biome.Category.THEEND), vegetalGenStep, TfcBlocks.WOOD_OAK.SAPLING);
        register("tree/palm", TREE_PALM, BiomeSelectors.categories(Biome.Category.THEEND), vegetalGenStep, TfcBlocks.WOOD_PALM.SAPLING);
        register("tree/pine", TREE_PINE, BiomeSelectors.categories(Biome.Category.THEEND), vegetalGenStep, TfcBlocks.WOOD_PINE.SAPLING);
        register("tree/rosewood", TREE_ROSEWOOD, BiomeSelectors.categories(Biome.Category.THEEND), vegetalGenStep, TfcBlocks.WOOD_ROSEWOOD.SAPLING);
        register("tree/sequoia", TREE_SEQUOIA, BiomeSelectors.categories(Biome.Category.EXTREME_HILLS ), vegetalGenStep, TfcBlocks.WOOD_SEQUOIA.SAPLING);
        register("tree/spruce", TREE_SPRUCE, BiomeSelectors.categories(Biome.Category.THEEND), vegetalGenStep, TfcBlocks.WOOD_SPRUCE.SAPLING);
        register("tree/sycamore", TREE_SYCAMORE, BiomeSelectors.categories(Biome.Category.THEEND), vegetalGenStep, TfcBlocks.WOOD_SYCAMORE.SAPLING);
        register("tree/white_cedar", TREE_WHITE_CEDAR, BiomeSelectors.categories(Biome.Category.THEEND), vegetalGenStep, TfcBlocks.WOOD_WHITE_CEDAR.SAPLING);
        register("tree/willow", TREE_WILLOW, BiomeSelectors.categories(Biome.Category.THEEND), vegetalGenStep, TfcBlocks.WOOD_WILLOW.SAPLING);
        //    register("boulder/andesite", BOULDER_ANDESITE, BiomeSelectors.foundInOverworld(), otherGenStep);
        //    BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), otherGenStep, BuiltinRegistries.CONFIGURED_FEATURE.getKey(TEST_BOULDER_CONFIGURED).get());
    }
}

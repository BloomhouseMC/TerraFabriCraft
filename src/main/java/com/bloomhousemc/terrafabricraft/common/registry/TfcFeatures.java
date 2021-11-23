package com.bloomhousemc.terrafabricraft.common.registry;

import com.bloomhousemc.terrafabricraft.TerraFabriCraft;
import com.bloomhousemc.terrafabricraft.common.config.ModuleConfig;
import com.bloomhousemc.terrafabricraft.common.util.TfcUtils;
import com.bloomhousemc.terrafabricraft.common.world.generator.feature.BoulderFeature;
import com.bloomhousemc.terrafabricraft.common.world.generator.feature.TestBoulderFeature;
import net.fabricmc.fabric.api.biome.v1.*;
import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.decorator.CountExtraDecoratorConfig;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.HeightmapDecoratorConfig;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.foliage.BushFoliagePlacer;
import net.minecraft.world.gen.foliage.PineFoliagePlacer;
import net.minecraft.world.gen.heightprovider.UniformHeightProvider;
import net.minecraft.world.gen.stateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

import java.util.function.Predicate;

public class TfcFeatures {

    private static final Feature<DefaultFeatureConfig> BOULDER = new BoulderFeature(DefaultFeatureConfig.CODEC);

    public static final ConfiguredFeature<?, ?> TREE_ACACIA = Feature.TREE
            .configure(new TreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(TfcBlocks.WOOD_ACACIA.LOG.getDefaultState()),
                    new StraightTrunkPlacer(5, 0, 0),
                    new SimpleBlockStateProvider(TfcBlocks.WOOD_ACACIA.LEAVES.getDefaultState()),
                    new SimpleBlockStateProvider(TfcBlocks.WOOD_ACACIA.SAPLING.getDefaultState()),
                    new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 3),
                    new TwoLayersFeatureSize(1, 0, 1)
            ).ignoreVines().build())
            .decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP_OCEAN_FLOOR_NO_WATER)
            .decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(10, 0.1F, 1)))
            .spreadHorizontally();

    public static final ConfiguredFeature<?, ?> TREE_ASH = Feature.TREE
            .configure(new TreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(TfcBlocks.WOOD_ASH.LOG.getDefaultState()),
                    new StraightTrunkPlacer(8, 3, 0),
                    new SimpleBlockStateProvider(TfcBlocks.WOOD_ASH.LEAVES.getDefaultState()),
                    new SimpleBlockStateProvider(TfcBlocks.WOOD_ASH.SAPLING.getDefaultState()),
                    new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 3),
                    new TwoLayersFeatureSize(1, 0, 1)
            ).ignoreVines().build())
            .decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP_OCEAN_FLOOR_NO_WATER)
            .decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(10, 0.1F, 1)))
            .spreadHorizontally();

    public static final ConfiguredFeature<?, ?> TREE_ASPEN = Feature.TREE
            .configure(new TreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(TfcBlocks.WOOD_ASPEN.LOG.getDefaultState()),
                    new StraightTrunkPlacer(8, 3, 0),
                    new SimpleBlockStateProvider(TfcBlocks.WOOD_ASPEN.LEAVES.getDefaultState()),
                    new SimpleBlockStateProvider(TfcBlocks.WOOD_ASPEN.SAPLING.getDefaultState()),
                    new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 3),
                    new TwoLayersFeatureSize(1, 0, 1)
            ).ignoreVines().build())
            .decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP_OCEAN_FLOOR_NO_WATER)
            .decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(10, 0.1F, 1)))
            .spreadHorizontally();

    public static final ConfiguredFeature<?, ?> TREE_BIRCH = Feature.TREE
            .configure(new TreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(TfcBlocks.WOOD_BIRCH.LOG.getDefaultState()),
                    new StraightTrunkPlacer(12, 3, 0),
                    new SimpleBlockStateProvider(TfcBlocks.WOOD_BIRCH.LEAVES.getDefaultState()),
                    new SimpleBlockStateProvider(TfcBlocks.WOOD_BIRCH.SAPLING.getDefaultState()),
                    new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 3),
                    new TwoLayersFeatureSize(1, 0, 1)
            ).build())
            .decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP_OCEAN_FLOOR_NO_WATER)
            .decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(10, 0.1F, 1)))
            .spreadHorizontally();

    public static final ConfiguredFeature<?, ?> TREE_BLACKWOOD = Feature.TREE
            .configure(new TreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(TfcBlocks.WOOD_BLACKWOOD.LOG.getDefaultState()),
                    new StraightTrunkPlacer(8, 3, 0),
                    new SimpleBlockStateProvider(TfcBlocks.WOOD_BLACKWOOD.LEAVES.getDefaultState()),
                    new SimpleBlockStateProvider(TfcBlocks.WOOD_BLACKWOOD.SAPLING.getDefaultState()),
                    new PineFoliagePlacer(ConstantIntProvider.create(5), ConstantIntProvider.create(5), ConstantIntProvider.create(5)),
                    new TwoLayersFeatureSize(1, 0, 1)
            ).build())
            .decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP_OCEAN_FLOOR_NO_WATER)
            .decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(10, 0.1F, 1)))
            .spreadHorizontally();

    public static final ConfiguredFeature<?, ?> TREE_CHESTNUT = Feature.TREE
            .configure(new TreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(TfcBlocks.WOOD_CHESTNUT.LOG.getDefaultState()),
                    new StraightTrunkPlacer(5, 2, 3),
                    new SimpleBlockStateProvider(TfcBlocks.WOOD_CHESTNUT.LEAVES.getDefaultState()),
                    new SimpleBlockStateProvider(TfcBlocks.WOOD_CHESTNUT.SAPLING.getDefaultState()),
                    new BushFoliagePlacer(ConstantIntProvider.create(5), ConstantIntProvider.create(0), 3),
                    new TwoLayersFeatureSize(1, 0, 1)
            ).build())
            .decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP_OCEAN_FLOOR_NO_WATER)
            .decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(10, 0.1F, 1)))
            .spreadHorizontally();

    public static final ConfiguredFeature<?, ?> TREE_DOUGLAS_FIR = Feature.TREE
            .configure(new TreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(TfcBlocks.WOOD_DOUGLAS_FIR.LOG.getDefaultState()),
                    new StraightTrunkPlacer(8, 3, 0),
                    new SimpleBlockStateProvider(TfcBlocks.WOOD_DOUGLAS_FIR.LEAVES.getDefaultState()),
                    new SimpleBlockStateProvider(TfcBlocks.WOOD_DOUGLAS_FIR.SAPLING.getDefaultState()),
                    new BlobFoliagePlacer(ConstantIntProvider.create(5), ConstantIntProvider.create(0), 3),
                    new TwoLayersFeatureSize(1, 0, 1)
            ).build())
            .decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP_OCEAN_FLOOR_NO_WATER)
            .decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(10, 0.1F, 1)))
            .spreadHorizontally();

    public static final ConfiguredFeature<?, ?> TREE_HICKORY = Feature.TREE
            .configure(new TreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(TfcBlocks.WOOD_HICKORY.LOG.getDefaultState()),
                    new StraightTrunkPlacer(8, 3, 0),
                    new SimpleBlockStateProvider(TfcBlocks.WOOD_HICKORY.LEAVES.getDefaultState()),
                    new SimpleBlockStateProvider(TfcBlocks.WOOD_HICKORY.SAPLING.getDefaultState()),
                    new BlobFoliagePlacer(ConstantIntProvider.create(5), ConstantIntProvider.create(0), 3),
                    new TwoLayersFeatureSize(1, 0, 1)
            ).build())
            .decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP_OCEAN_FLOOR_NO_WATER)
            .decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(10, 0.1F, 1)))
            .spreadHorizontally();

    public static final ConfiguredFeature<?, ?> TREE_KAPOK = Feature.TREE
            .configure(new TreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(TfcBlocks.WOOD_KAPOK.LOG.getDefaultState()),
                    new StraightTrunkPlacer(15, 9, 0),
                    new SimpleBlockStateProvider(TfcBlocks.WOOD_KAPOK.LEAVES.getDefaultState()),
                    new SimpleBlockStateProvider(TfcBlocks.WOOD_KAPOK.SAPLING.getDefaultState()),
                    new BlobFoliagePlacer(ConstantIntProvider.create(5), ConstantIntProvider.create(0), 3),
                    new TwoLayersFeatureSize(1, 0, 1)
            ).build())
            .decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP_OCEAN_FLOOR_NO_WATER)
            .decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(10, 0.1F, 1)))
            .spreadHorizontally();

    public static final ConfiguredFeature<?, ?> TREE_BIG_KAPOK = Feature.TREE
            .configure(new TreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(TfcBlocks.WOOD_KAPOK.LOG.getDefaultState()),
                    new StraightTrunkPlacer(30, 9, 0),
                    new SimpleBlockStateProvider(TfcBlocks.WOOD_KAPOK.LEAVES.getDefaultState()),
                    new SimpleBlockStateProvider(TfcBlocks.WOOD_KAPOK.SAPLING.getDefaultState()),
                    new BlobFoliagePlacer(ConstantIntProvider.create(5), ConstantIntProvider.create(0), 3),
                    new TwoLayersFeatureSize(1, 0, 1)
            ).build())
            .decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP_OCEAN_FLOOR_NO_WATER)
            .decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(10, 0.1F, 1)))
            .spreadHorizontally();

    public static final ConfiguredFeature<?, ?> TREE_SMALL_KAPOK = Feature.TREE
            .configure(new TreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(TfcBlocks.WOOD_KAPOK.LOG.getDefaultState()),
                    new StraightTrunkPlacer(15, 9, 0),
                    new SimpleBlockStateProvider(TfcBlocks.WOOD_KAPOK.LEAVES.getDefaultState()),
                    new SimpleBlockStateProvider(TfcBlocks.WOOD_KAPOK.SAPLING.getDefaultState()),
                    new BlobFoliagePlacer(ConstantIntProvider.create(5), ConstantIntProvider.create(0), 3),
                    new TwoLayersFeatureSize(1, 0, 1)
            ).build())
            .decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP_OCEAN_FLOOR_NO_WATER)
            .decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(10, 0.1F, 1)))
            .spreadHorizontally();

    public static final ConfiguredFeature<?, ?> TREE_MAPLE = Feature.TREE
            .configure(new TreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(TfcBlocks.WOOD_MAPLE.LOG.getDefaultState()),
                    new StraightTrunkPlacer(8, 3, 0),
                    new SimpleBlockStateProvider(TfcBlocks.WOOD_MAPLE.LEAVES.getDefaultState()),
                    new SimpleBlockStateProvider(TfcBlocks.WOOD_MAPLE.SAPLING.getDefaultState()),
                    new BlobFoliagePlacer(ConstantIntProvider.create(5), ConstantIntProvider.create(0), 3),
                    new TwoLayersFeatureSize(1, 0, 1)
            ).build())
            .decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP_OCEAN_FLOOR_NO_WATER)
            .decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(10, 0.1F, 1)))
            .spreadHorizontally();

    public static final ConfiguredFeature<?, ?> TREE_OAK = Feature.TREE
            .configure(new TreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(TfcBlocks.WOOD_OAK.LOG.getDefaultState()),
                    new StraightTrunkPlacer(8, 3, 0),
                    new SimpleBlockStateProvider(TfcBlocks.WOOD_OAK.LEAVES.getDefaultState()),
                    new SimpleBlockStateProvider(TfcBlocks.WOOD_OAK.SAPLING.getDefaultState()),
                    new BlobFoliagePlacer(ConstantIntProvider.create(5), ConstantIntProvider.create(0), 3),
                    new TwoLayersFeatureSize(1, 0, 1)
            ).build())
            .decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP_OCEAN_FLOOR_NO_WATER)
            .decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(10, 0.1F, 1)))
            .spreadHorizontally();

    public static final ConfiguredFeature<?, ?> TREE_PALM = Feature.TREE
            .configure(new TreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(TfcBlocks.WOOD_PALM.LOG.getDefaultState()),
                    new StraightTrunkPlacer(8, 3, 0),
                    new SimpleBlockStateProvider(TfcBlocks.WOOD_PALM.LEAVES.getDefaultState()),
                    new SimpleBlockStateProvider(TfcBlocks.WOOD_PALM.SAPLING.getDefaultState()),
                    new BlobFoliagePlacer(ConstantIntProvider.create(5), ConstantIntProvider.create(0), 3),
                    new TwoLayersFeatureSize(1, 0, 1)
            ).build())
            .decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP_OCEAN_FLOOR_NO_WATER)
            .decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(10, 0.1F, 1)))
            .spreadHorizontally();

    public static final ConfiguredFeature<?, ?> TREE_PINE = Feature.TREE
            .configure(new TreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(TfcBlocks.WOOD_PINE.LOG.getDefaultState()),
                    new StraightTrunkPlacer(8, 3, 0),
                    new SimpleBlockStateProvider(TfcBlocks.WOOD_PINE.LEAVES.getDefaultState()),
                    new SimpleBlockStateProvider(TfcBlocks.WOOD_PINE.SAPLING.getDefaultState()),
                    new BlobFoliagePlacer(ConstantIntProvider.create(5), ConstantIntProvider.create(0), 3),
                    new TwoLayersFeatureSize(1, 0, 1)
            ).build())
            .decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP_OCEAN_FLOOR_NO_WATER)
            .decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(10, 0.1F, 1)))
            .spreadHorizontally();

    public static final ConfiguredFeature<?, ?> TREE_ROSEWOOD = Feature.TREE
            .configure(new TreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(TfcBlocks.WOOD_ROSEWOOD.LOG.getDefaultState()),
                    new StraightTrunkPlacer(8, 3, 0),
                    new SimpleBlockStateProvider(TfcBlocks.WOOD_ROSEWOOD.LEAVES.getDefaultState()),
                    new SimpleBlockStateProvider(TfcBlocks.WOOD_ROSEWOOD.SAPLING.getDefaultState()),
                    new BlobFoliagePlacer(ConstantIntProvider.create(5), ConstantIntProvider.create(0), 3),
                    new TwoLayersFeatureSize(1, 0, 1)
            ).build())
            .decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP_OCEAN_FLOOR_NO_WATER)
            .decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(10, 0.1F, 1)))
            .spreadHorizontally();

    public static final ConfiguredFeature<?, ?> TREE_SEQUOIA = Feature.TREE
            .configure(new TreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(TfcBlocks.WOOD_SEQUOIA.LOG.getDefaultState()),
                    new StraightTrunkPlacer(8, 3, 0),
                    new SimpleBlockStateProvider(TfcBlocks.WOOD_SEQUOIA.LEAVES.getDefaultState()),
                    new SimpleBlockStateProvider(TfcBlocks.WOOD_SEQUOIA.SAPLING.getDefaultState()),
                    new BlobFoliagePlacer(ConstantIntProvider.create(5), ConstantIntProvider.create(0), 3),
                    new TwoLayersFeatureSize(1, 0, 1)
            ).build())
            .decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP_OCEAN_FLOOR_NO_WATER)
            .decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(10, 0.1F, 1)))
            .spreadHorizontally();

    public static final ConfiguredFeature<?, ?> TREE_SPRUCE = Feature.TREE
            .configure(new TreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(TfcBlocks.WOOD_SPRUCE.LOG.getDefaultState()),
                    new StraightTrunkPlacer(8, 3, 0),
                    new SimpleBlockStateProvider(TfcBlocks.WOOD_SPRUCE.LEAVES.getDefaultState()),
                    new SimpleBlockStateProvider(TfcBlocks.WOOD_SPRUCE.SAPLING.getDefaultState()),
                    new BlobFoliagePlacer(ConstantIntProvider.create(5), ConstantIntProvider.create(0), 3),
                    new TwoLayersFeatureSize(1, 0, 1)
            ).build())
            .decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP_OCEAN_FLOOR_NO_WATER)
            .decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(10, 0.1F, 1)))
            .spreadHorizontally();

    public static final ConfiguredFeature<?, ?> TREE_SYCAMORE = Feature.TREE
            .configure(new TreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(TfcBlocks.WOOD_SYCAMORE.LOG.getDefaultState()),
                    new StraightTrunkPlacer(8, 3, 0),
                    new SimpleBlockStateProvider(TfcBlocks.WOOD_SYCAMORE.LEAVES.getDefaultState()),
                    new SimpleBlockStateProvider(TfcBlocks.WOOD_SYCAMORE.SAPLING.getDefaultState()),
                    new BlobFoliagePlacer(ConstantIntProvider.create(5), ConstantIntProvider.create(0), 3),
                    new TwoLayersFeatureSize(1, 0, 1)
            ).build())
            .decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP_OCEAN_FLOOR_NO_WATER)
            .decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(10, 0.1F, 1)))
            .spreadHorizontally();

    public static final ConfiguredFeature<?, ?> TREE_WHITE_CEDAR = Feature.TREE
            .configure(new TreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(TfcBlocks.WOOD_WHITE_CEDAR.LOG.getDefaultState()),
                    new StraightTrunkPlacer(8, 3, 0),
                    new SimpleBlockStateProvider(TfcBlocks.WOOD_WHITE_CEDAR.LEAVES.getDefaultState()),
                    new SimpleBlockStateProvider(TfcBlocks.WOOD_WHITE_CEDAR.SAPLING.getDefaultState()),
                    new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 3),
                    new TwoLayersFeatureSize(1, 0, 1)
            ).build())
            .decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP_OCEAN_FLOOR_NO_WATER)
            .decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(10, 0.1F, 1)))
            .spreadHorizontally();

    public static final ConfiguredFeature<?, ?> TREE_WILLOW = Feature.TREE
            .configure(new TreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(TfcBlocks.WOOD_WILLOW.LOG.getDefaultState()),
                    new StraightTrunkPlacer(8, 3, 0),
                    new SimpleBlockStateProvider(TfcBlocks.WOOD_WILLOW.LEAVES.getDefaultState()),
                    new SimpleBlockStateProvider(TfcBlocks.WOOD_WILLOW.SAPLING.getDefaultState()),
                    new BlobFoliagePlacer(ConstantIntProvider.create(5), ConstantIntProvider.create(0), 3),
                    new TwoLayersFeatureSize(1, 0, 1)
            ).build())
            .decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP_OCEAN_FLOOR_NO_WATER)
            .decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(10, 0.1F, 1)))
            .spreadHorizontally();

    public static void register(String id, ConfiguredFeature<?, ?> feature, Predicate<BiomeSelectionContext> biome, GenerationStep.Feature generationStep) {
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new
                Identifier(TerraFabriCraft.MODID, id), feature);
        BiomeModification worldGen = BiomeModifications.create(new Identifier(TerraFabriCraft.MODID, "world_features"));
        if (ModuleConfig.getValue("world")) {
            worldGen.add(ModificationPhase.ADDITIONS, biome, context -> context.getGenerationSettings().
                    addBuiltInFeature(GenerationStep.Feature.VEGETAL_DECORATION, feature));
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

    public static final ConfiguredFeature<?, ?> BOULDER_ANDESITE = BOULDER.configure(new DefaultFeatureConfig())
            .decorate(Decorator.HEIGHTMAP.configure(new HeightmapDecoratorConfig(Heightmap.Type.OCEAN_FLOOR_WG)))
            .spreadHorizontally()
            .applyChance(5);

    public static final Feature<SingleStateFeatureConfig> TEST_BOULDER = new TestBoulderFeature(SingleStateFeatureConfig.CODEC);
    public static final ConfiguredFeature<?, ?> TEST_BOULDER_CONFIGURED = TEST_BOULDER.configure(new SingleStateFeatureConfig(TfcUtils.getRandomRawStone(TfcUtils.RNG))).decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP).applyChance(10);


    private static ConfiguredFeature<?, ?> ORE_WOOL_OVERWORLD = Feature.ORE
            .configure(new OreFeatureConfig(
                    OreFeatureConfig.Rules.BASE_STONE_OVERWORLD,
                    Blocks.WHITE_WOOL.getDefaultState(),
                    60)) // Vein size
            .range(new RangeDecoratorConfig(
                    // You can also use one of the other height providers if you don't want a uniform distribution
                    UniformHeightProvider.create(YOffset.aboveBottom(0), YOffset.fixed(64)))) // Inclusive min and max height
            .spreadHorizontally()
            .repeat(1);

    public static final int SPAWN_RATE = 5;
    public static final OreFeatureConfig ORE_FEATURE_CONFIG = new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, Blocks.AIR.getDefaultState(), 9);// number of veins per chunk
    RangeDecoratorConfig rangeDecoratorConfig = new RangeDecoratorConfig(
            // You can also use one of the other height providers if you don't want a uniform distribution
            UniformHeightProvider.create(YOffset.aboveBottom(0), YOffset.fixed(64)));




    public static void init() {
        var vegetalGenStep = GenerationStep.Feature.VEGETAL_DECORATION;
//        var otherGenStep = GenerationStep.Feature.TOP_LAYER_MODIFICATION;

        //Register new feature
        Registry.register(Registry.FEATURE, new Identifier("terrafabricraft", "boulder"), BOULDER);


      //  registerOre("ore_test", ORE_WOOL_OVERWORLD);

        //   Registry.register(Registry.FEATURE, new Identifier(TerraFabriCraft.MOD_ID, "test_boulder"), TEST_BOULDER);
        register("tree/acacia", TREE_ACACIA, BiomeSelectors.categories(Biome.Category.THEEND), vegetalGenStep);
        register("tree/ash", TREE_ASH, BiomeSelectors.categories(Biome.Category.THEEND), vegetalGenStep);
        register("tree/aspen", TREE_ASPEN, BiomeSelectors.categories(Biome.Category.THEEND), vegetalGenStep);
        register("tree/birch", TREE_BIRCH, BiomeSelectors.categories(Biome.Category.NETHER), vegetalGenStep);
        register("tree/blackwood", TREE_BLACKWOOD, BiomeSelectors.categories(Biome.Category.NETHER), vegetalGenStep);
        register("tree/chestnut", TREE_CHESTNUT, BiomeSelectors.categories(Biome.Category.NETHER), vegetalGenStep);
        register("tree/douglas_fir", TREE_DOUGLAS_FIR, BiomeSelectors.categories(Biome.Category.THEEND), vegetalGenStep);
        register("tree/hickory", TREE_HICKORY, BiomeSelectors.categories(Biome.Category.THEEND), vegetalGenStep);
        register("tree/big_kapok", TREE_BIG_KAPOK, BiomeSelectors.categories(Biome.Category.JUNGLE), vegetalGenStep);
        register("tree/small_kapok", TREE_SMALL_KAPOK, BiomeSelectors.categories(Biome.Category.JUNGLE), vegetalGenStep);
        register("tree/maple", TREE_MAPLE, BiomeSelectors.categories(Biome.Category.THEEND), vegetalGenStep);
        register("tree/oak", TREE_OAK, BiomeSelectors.categories(Biome.Category.THEEND), vegetalGenStep);
        register("tree/palm", TREE_PALM, BiomeSelectors.categories(Biome.Category.THEEND), vegetalGenStep);
        register("tree/pine", TREE_PINE, BiomeSelectors.categories(Biome.Category.THEEND), vegetalGenStep);
        register("tree/rosewood", TREE_ROSEWOOD, BiomeSelectors.categories(Biome.Category.THEEND), vegetalGenStep);
        register("tree/sequoia", TREE_SEQUOIA, BiomeSelectors.categories(Biome.Category.EXTREME_HILLS ), vegetalGenStep);
        register("tree/spruce", TREE_SPRUCE, BiomeSelectors.categories(Biome.Category.THEEND), vegetalGenStep);
        register("tree/sycamore", TREE_SYCAMORE, BiomeSelectors.categories(Biome.Category.THEEND), vegetalGenStep);
        register("tree/white_cedar", TREE_WHITE_CEDAR, BiomeSelectors.categories(Biome.Category.THEEND), vegetalGenStep);
        register("tree/willow", TREE_WILLOW, BiomeSelectors.categories(Biome.Category.THEEND), vegetalGenStep);
        //    register("boulder/andesite", BOULDER_ANDESITE, BiomeSelectors.foundInOverworld(), otherGenStep);
        //    BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), otherGenStep, BuiltinRegistries.CONFIGURED_FEATURE.getKey(TEST_BOULDER_CONFIGURED).get());
    }
}

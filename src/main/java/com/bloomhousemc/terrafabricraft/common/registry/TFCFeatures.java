package com.bloomhousemc.terrafabricraft.common.registry;

import com.bloomhousemc.terrafabricraft.TerraFabriCraft;
import com.bloomhousemc.terrafabricraft.common.config.ModuleConfig;
import com.bloomhousemc.terrafabricraft.common.util.TFCUtils;
import com.bloomhousemc.terrafabricraft.common.world.generator.feature.BoulderFeature;
import com.bloomhousemc.terrafabricraft.common.world.generator.feature.TestBoulderFeature;
import net.fabricmc.fabric.api.biome.v1.*;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
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

import static com.bloomhousemc.terrafabricraft.TerraFabriCraft.ROCK_FEATURE;

public class TFCFeatures {

    private static final Feature<DefaultFeatureConfig> BOULDER = new BoulderFeature(DefaultFeatureConfig.CODEC);

    public static final ConfiguredFeature<?, ?> TREE_ACACIA = Feature.TREE
            .configure(new TreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(TFCObjects.WOOD_ACACIA.log.getDefaultState()),
                    new StraightTrunkPlacer(5, 0, 0),
                    new SimpleBlockStateProvider(TFCObjects.WOOD_ACACIA.leaves.getDefaultState()),
                    new SimpleBlockStateProvider(TFCObjects.WOOD_ACACIA.sapling.getDefaultState()),
                    new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 3),
                    new TwoLayersFeatureSize(1, 0, 1)
            ).ignoreVines().build())
            .decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP_OCEAN_FLOOR_NO_WATER)
            .decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(10, 0.1F, 1)))
            .spreadHorizontally();

    public static final ConfiguredFeature<?, ?> TREE_ASH = Feature.TREE
            .configure(new TreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(TFCObjects.WOOD_ASH.log.getDefaultState()),
                    new StraightTrunkPlacer(8, 3, 0),
                    new SimpleBlockStateProvider(TFCObjects.WOOD_ASH.leaves.getDefaultState()),
                    new SimpleBlockStateProvider(TFCObjects.WOOD_ASH.sapling.getDefaultState()),
                    new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 3),
                    new TwoLayersFeatureSize(1, 0, 1)
            ).ignoreVines().build())
            .decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP_OCEAN_FLOOR_NO_WATER)
            .decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(10, 0.1F, 1)))
            .spreadHorizontally();

    public static final ConfiguredFeature<?, ?> TREE_ASPEN = Feature.TREE
            .configure(new TreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(TFCObjects.WOOD_ASPEN.log.getDefaultState()),
                    new StraightTrunkPlacer(8, 3, 0),
                    new SimpleBlockStateProvider(TFCObjects.WOOD_ASPEN.leaves.getDefaultState()),
                    new SimpleBlockStateProvider(TFCObjects.WOOD_ASPEN.sapling.getDefaultState()),
                    new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 3),
                    new TwoLayersFeatureSize(1, 0, 1)
            ).ignoreVines().build())
            .decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP_OCEAN_FLOOR_NO_WATER)
            .decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(10, 0.1F, 1)))
            .spreadHorizontally();

    public static final ConfiguredFeature<?, ?> TREE_BIRCH = Feature.TREE
            .configure(new TreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(TFCObjects.WOOD_BIRCH.log.getDefaultState()),
                    new StraightTrunkPlacer(12, 3, 0),
                    new SimpleBlockStateProvider(TFCObjects.WOOD_BIRCH.leaves.getDefaultState()),
                    new SimpleBlockStateProvider(TFCObjects.WOOD_BIRCH.sapling.getDefaultState()),
                    new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 3),
                    new TwoLayersFeatureSize(1, 0, 1)
            ).build())
            .decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP_OCEAN_FLOOR_NO_WATER)
            .decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(10, 0.1F, 1)))
            .spreadHorizontally();

    public static final ConfiguredFeature<?, ?> TREE_BLACKWOOD = Feature.TREE
            .configure(new TreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(TFCObjects.WOOD_BLACKWOOD.log.getDefaultState()),
                    new StraightTrunkPlacer(8, 3, 0),
                    new SimpleBlockStateProvider(TFCObjects.WOOD_BLACKWOOD.leaves.getDefaultState()),
                    new SimpleBlockStateProvider(TFCObjects.WOOD_BLACKWOOD.sapling.getDefaultState()),
                    new PineFoliagePlacer(ConstantIntProvider.create(5), ConstantIntProvider.create(5), ConstantIntProvider.create(5)),
                    new TwoLayersFeatureSize(1, 0, 1)
            ).build())
            .decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP_OCEAN_FLOOR_NO_WATER)
            .decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(10, 0.1F, 1)))
            .spreadHorizontally();

    public static final ConfiguredFeature<?, ?> TREE_CHESTNUT = Feature.TREE
            .configure(new TreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(TFCObjects.WOOD_CHESTNUT.log.getDefaultState()),
                    new StraightTrunkPlacer(5, 2, 3),
                    new SimpleBlockStateProvider(TFCObjects.WOOD_CHESTNUT.leaves.getDefaultState()),
                    new SimpleBlockStateProvider(TFCObjects.WOOD_CHESTNUT.sapling.getDefaultState()),
                    new BushFoliagePlacer(ConstantIntProvider.create(5), ConstantIntProvider.create(0), 3),
                    new TwoLayersFeatureSize(1, 0, 1)
            ).build())
            .decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP_OCEAN_FLOOR_NO_WATER)
            .decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(10, 0.1F, 1)))
            .spreadHorizontally();

    public static final ConfiguredFeature<?, ?> TREE_DOUGLAS_FIR = Feature.TREE
            .configure(new TreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(TFCObjects.WOOD_DOUGLAS_FIR.log.getDefaultState()),
                    new StraightTrunkPlacer(8, 3, 0),
                    new SimpleBlockStateProvider(TFCObjects.WOOD_DOUGLAS_FIR.leaves.getDefaultState()),
                    new SimpleBlockStateProvider(TFCObjects.WOOD_DOUGLAS_FIR.sapling.getDefaultState()),
                    new BlobFoliagePlacer(ConstantIntProvider.create(5), ConstantIntProvider.create(0), 3),
                    new TwoLayersFeatureSize(1, 0, 1)
            ).build())
            .decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP_OCEAN_FLOOR_NO_WATER)
            .decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(10, 0.1F, 1)))
            .spreadHorizontally();

    public static final ConfiguredFeature<?, ?> TREE_HICKORY = Feature.TREE
            .configure(new TreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(TFCObjects.WOOD_HICKORY.log.getDefaultState()),
                    new StraightTrunkPlacer(8, 3, 0),
                    new SimpleBlockStateProvider(TFCObjects.WOOD_HICKORY.leaves.getDefaultState()),
                    new SimpleBlockStateProvider(TFCObjects.WOOD_HICKORY.sapling.getDefaultState()),
                    new BlobFoliagePlacer(ConstantIntProvider.create(5), ConstantIntProvider.create(0), 3),
                    new TwoLayersFeatureSize(1, 0, 1)
            ).build())
            .decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP_OCEAN_FLOOR_NO_WATER)
            .decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(10, 0.1F, 1)))
            .spreadHorizontally();

    public static final ConfiguredFeature<?, ?> TREE_KAPOK = Feature.TREE
            .configure(new TreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(TFCObjects.WOOD_KAPOK.log.getDefaultState()),
                    new StraightTrunkPlacer(15, 9, 0),
                    new SimpleBlockStateProvider(TFCObjects.WOOD_KAPOK.leaves.getDefaultState()),
                    new SimpleBlockStateProvider(TFCObjects.WOOD_KAPOK.sapling.getDefaultState()),
                    new BlobFoliagePlacer(ConstantIntProvider.create(5), ConstantIntProvider.create(0), 3),
                    new TwoLayersFeatureSize(1, 0, 1)
            ).build())
            .decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP_OCEAN_FLOOR_NO_WATER)
            .decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(10, 0.1F, 1)))
            .spreadHorizontally();

    public static final ConfiguredFeature<?, ?> TREE_BIG_KAPOK = Feature.TREE
            .configure(new TreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(TFCObjects.WOOD_KAPOK.log.getDefaultState()),
                    new StraightTrunkPlacer(30, 9, 0),
                    new SimpleBlockStateProvider(TFCObjects.WOOD_KAPOK.leaves.getDefaultState()),
                    new SimpleBlockStateProvider(TFCObjects.WOOD_KAPOK.sapling.getDefaultState()),
                    new BlobFoliagePlacer(ConstantIntProvider.create(5), ConstantIntProvider.create(0), 3),
                    new TwoLayersFeatureSize(1, 0, 1)
            ).build())
            .decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP_OCEAN_FLOOR_NO_WATER)
            .decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(10, 0.1F, 1)))
            .spreadHorizontally();

    public static final ConfiguredFeature<?, ?> TREE_SMALL_KAPOK = Feature.TREE
            .configure(new TreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(TFCObjects.WOOD_KAPOK.log.getDefaultState()),
                    new StraightTrunkPlacer(15, 9, 0),
                    new SimpleBlockStateProvider(TFCObjects.WOOD_KAPOK.leaves.getDefaultState()),
                    new SimpleBlockStateProvider(TFCObjects.WOOD_KAPOK.sapling.getDefaultState()),
                    new BlobFoliagePlacer(ConstantIntProvider.create(5), ConstantIntProvider.create(0), 3),
                    new TwoLayersFeatureSize(1, 0, 1)
            ).build())
            .decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP_OCEAN_FLOOR_NO_WATER)
            .decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(10, 0.1F, 1)))
            .spreadHorizontally();

    public static final ConfiguredFeature<?, ?> TREE_MAPLE = Feature.TREE
            .configure(new TreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(TFCObjects.WOOD_MAPLE.log.getDefaultState()),
                    new StraightTrunkPlacer(8, 3, 0),
                    new SimpleBlockStateProvider(TFCObjects.WOOD_MAPLE.leaves.getDefaultState()),
                    new SimpleBlockStateProvider(TFCObjects.WOOD_MAPLE.sapling.getDefaultState()),
                    new BlobFoliagePlacer(ConstantIntProvider.create(5), ConstantIntProvider.create(0), 3),
                    new TwoLayersFeatureSize(1, 0, 1)
            ).build())
            .decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP_OCEAN_FLOOR_NO_WATER)
            .decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(10, 0.1F, 1)))
            .spreadHorizontally();

    public static final ConfiguredFeature<?, ?> TREE_OAK = Feature.TREE
            .configure(new TreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(TFCObjects.WOOD_OAK.log.getDefaultState()),
                    new StraightTrunkPlacer(8, 3, 0),
                    new SimpleBlockStateProvider(TFCObjects.WOOD_OAK.leaves.getDefaultState()),
                    new SimpleBlockStateProvider(TFCObjects.WOOD_OAK.sapling.getDefaultState()),
                    new BlobFoliagePlacer(ConstantIntProvider.create(5), ConstantIntProvider.create(0), 3),
                    new TwoLayersFeatureSize(1, 0, 1)
            ).build())
            .decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP_OCEAN_FLOOR_NO_WATER)
            .decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(10, 0.1F, 1)))
            .spreadHorizontally();

    public static final ConfiguredFeature<?, ?> TREE_PALM = Feature.TREE
            .configure(new TreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(TFCObjects.WOOD_PALM.log.getDefaultState()),
                    new StraightTrunkPlacer(8, 3, 0),
                    new SimpleBlockStateProvider(TFCObjects.WOOD_PALM.leaves.getDefaultState()),
                    new SimpleBlockStateProvider(TFCObjects.WOOD_PALM.sapling.getDefaultState()),
                    new BlobFoliagePlacer(ConstantIntProvider.create(5), ConstantIntProvider.create(0), 3),
                    new TwoLayersFeatureSize(1, 0, 1)
            ).build())
            .decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP_OCEAN_FLOOR_NO_WATER)
            .decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(10, 0.1F, 1)))
            .spreadHorizontally();

    public static final ConfiguredFeature<?, ?> TREE_PINE = Feature.TREE
            .configure(new TreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(TFCObjects.WOOD_PINE.log.getDefaultState()),
                    new StraightTrunkPlacer(8, 3, 0),
                    new SimpleBlockStateProvider(TFCObjects.WOOD_PINE.leaves.getDefaultState()),
                    new SimpleBlockStateProvider(TFCObjects.WOOD_PINE.sapling.getDefaultState()),
                    new BlobFoliagePlacer(ConstantIntProvider.create(5), ConstantIntProvider.create(0), 3),
                    new TwoLayersFeatureSize(1, 0, 1)
            ).build())
            .decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP_OCEAN_FLOOR_NO_WATER)
            .decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(10, 0.1F, 1)))
            .spreadHorizontally();

    public static final ConfiguredFeature<?, ?> TREE_ROSEWOOD = Feature.TREE
            .configure(new TreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(TFCObjects.WOOD_ROSEWOOD.log.getDefaultState()),
                    new StraightTrunkPlacer(8, 3, 0),
                    new SimpleBlockStateProvider(TFCObjects.WOOD_ROSEWOOD.leaves.getDefaultState()),
                    new SimpleBlockStateProvider(TFCObjects.WOOD_ROSEWOOD.sapling.getDefaultState()),
                    new BlobFoliagePlacer(ConstantIntProvider.create(5), ConstantIntProvider.create(0), 3),
                    new TwoLayersFeatureSize(1, 0, 1)
            ).build())
            .decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP_OCEAN_FLOOR_NO_WATER)
            .decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(10, 0.1F, 1)))
            .spreadHorizontally();

    public static final ConfiguredFeature<?, ?> TREE_SEQUOIA = Feature.TREE
            .configure(new TreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(TFCObjects.WOOD_SEQUOIA.log.getDefaultState()),
                    new StraightTrunkPlacer(8, 3, 0),
                    new SimpleBlockStateProvider(TFCObjects.WOOD_SEQUOIA.leaves.getDefaultState()),
                    new SimpleBlockStateProvider(TFCObjects.WOOD_SEQUOIA.sapling.getDefaultState()),
                    new BlobFoliagePlacer(ConstantIntProvider.create(5), ConstantIntProvider.create(0), 3),
                    new TwoLayersFeatureSize(1, 0, 1)
            ).build())
            .decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP_OCEAN_FLOOR_NO_WATER)
            .decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(10, 0.1F, 1)))
            .spreadHorizontally();

    public static final ConfiguredFeature<?, ?> TREE_SPRUCE = Feature.TREE
            .configure(new TreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(TFCObjects.WOOD_SPRUCE.log.getDefaultState()),
                    new StraightTrunkPlacer(8, 3, 0),
                    new SimpleBlockStateProvider(TFCObjects.WOOD_SPRUCE.leaves.getDefaultState()),
                    new SimpleBlockStateProvider(TFCObjects.WOOD_SPRUCE.sapling.getDefaultState()),
                    new BlobFoliagePlacer(ConstantIntProvider.create(5), ConstantIntProvider.create(0), 3),
                    new TwoLayersFeatureSize(1, 0, 1)
            ).build())
            .decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP_OCEAN_FLOOR_NO_WATER)
            .decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(10, 0.1F, 1)))
            .spreadHorizontally();

    public static final ConfiguredFeature<?, ?> TREE_SYCAMORE = Feature.TREE
            .configure(new TreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(TFCObjects.WOOD_SYCAMORE.log.getDefaultState()),
                    new StraightTrunkPlacer(8, 3, 0),
                    new SimpleBlockStateProvider(TFCObjects.WOOD_SYCAMORE.leaves.getDefaultState()),
                    new SimpleBlockStateProvider(TFCObjects.WOOD_SYCAMORE.sapling.getDefaultState()),
                    new BlobFoliagePlacer(ConstantIntProvider.create(5), ConstantIntProvider.create(0), 3),
                    new TwoLayersFeatureSize(1, 0, 1)
            ).build())
            .decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP_OCEAN_FLOOR_NO_WATER)
            .decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(10, 0.1F, 1)))
            .spreadHorizontally();

    public static final ConfiguredFeature<?, ?> TREE_WHITE_CEDAR = Feature.TREE
            .configure(new TreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(TFCObjects.WOOD_WHITE_CEDAR.log.getDefaultState()),
                    new StraightTrunkPlacer(8, 3, 0),
                    new SimpleBlockStateProvider(TFCObjects.WOOD_WHITE_CEDAR.leaves.getDefaultState()),
                    new SimpleBlockStateProvider(TFCObjects.WOOD_WHITE_CEDAR.sapling.getDefaultState()),
                    new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 3),
                    new TwoLayersFeatureSize(1, 0, 1)
            ).build())
            .decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP_OCEAN_FLOOR_NO_WATER)
            .decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(10, 0.1F, 1)))
            .spreadHorizontally();

    public static final ConfiguredFeature<?, ?> TREE_WILLOW = Feature.TREE
            .configure(new TreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(TFCObjects.WOOD_WILLOW.log.getDefaultState()),
                    new StraightTrunkPlacer(8, 3, 0),
                    new SimpleBlockStateProvider(TFCObjects.WOOD_WILLOW.leaves.getDefaultState()),
                    new SimpleBlockStateProvider(TFCObjects.WOOD_WILLOW.sapling.getDefaultState()),
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

    public static void registerOre(String id, BlockState state) {
        RegistryKey<ConfiguredFeature<?, ?>> ore = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier("terrafabricraft", id));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, ore.getValue(),  ROCK_FEATURE.configure(new OreFeatureConfig(
                OreFeatureConfig.Rules.BASE_STONE_OVERWORLD,
                state,
                60)));
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, ore);
    }

    public static final ConfiguredFeature<?, ?> BOULDER_ANDESITE = BOULDER.configure(new DefaultFeatureConfig())
            .decorate(Decorator.HEIGHTMAP.configure(new HeightmapDecoratorConfig(Heightmap.Type.OCEAN_FLOOR_WG)))
            .spreadHorizontally()
            .applyChance(5);

    public static final Feature<SingleStateFeatureConfig> TEST_BOULDER = new TestBoulderFeature(SingleStateFeatureConfig.CODEC);
    public static final ConfiguredFeature<?, ?> TEST_BOULDER_CONFIGURED = TEST_BOULDER.configure(new SingleStateFeatureConfig(TFCUtils.getRandomRawStone(TFCUtils.RNG))).decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP).applyChance(10);


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
        var otherGenStep = GenerationStep.Feature.TOP_LAYER_MODIFICATION;

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

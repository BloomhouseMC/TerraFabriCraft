package malek.terrafabricraft.common.registry;

import malek.terrafabricraft.TerraFabriCraft;
import malek.terrafabricraft.common.world.generator.feature.BoulderFeature;
import net.fabricmc.fabric.api.biome.v1.*;
import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.HeightmapDecoratorConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.stateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

import java.util.function.Predicate;

public class TFCFeatures {

    private static final Feature<DefaultFeatureConfig> BOULDER = new BoulderFeature(DefaultFeatureConfig.CODEC);

    public static final ConfiguredFeature<?, ?> TREE_ACACIA = Feature.TREE
            .configure(new TreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(TFCObjects.WOOD_ACACIA.log.getDefaultState()),
                    new StraightTrunkPlacer(5, 0, 0),
                    new SimpleBlockStateProvider(TFCObjects.WOOD_ACACIA.leaves.getDefaultState()),
                    new SimpleBlockStateProvider(TFCObjects.WOOD_ACACIA.sapling.getDefaultState()),
                    new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 3),
                    new TwoLayersFeatureSize(0, 0, 0)
            ).ignoreVines().build())
            .applyChance(3)
            .decorate(Decorator.HEIGHTMAP.configure(new HeightmapDecoratorConfig(Heightmap.Type.MOTION_BLOCKING)));

    public static final ConfiguredFeature<?, ?> TREE_ASH = Feature.TREE
            .configure(new TreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(TFCObjects.WOOD_ASH.log.getDefaultState()),
                    new StraightTrunkPlacer(8, 3, 0),
                    new SimpleBlockStateProvider(TFCObjects.WOOD_ASH.leaves.getDefaultState()),
                    new SimpleBlockStateProvider(TFCObjects.WOOD_ASH.sapling.getDefaultState()),
                    new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 3),
                    new TwoLayersFeatureSize(1, 0, 1)
            ).ignoreVines().build())
            .applyChance(3)
            .decorate(Decorator.HEIGHTMAP.configure(new HeightmapDecoratorConfig(Heightmap.Type.MOTION_BLOCKING)));

    public static final ConfiguredFeature<?, ?> TREE_ASPEN = Feature.TREE
            .configure(new TreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(TFCObjects.WOOD_ASPEN.log.getDefaultState()),
                    new StraightTrunkPlacer(8, 3, 0),
                    new SimpleBlockStateProvider(TFCObjects.WOOD_ASPEN.leaves.getDefaultState()),
                    new SimpleBlockStateProvider(TFCObjects.WOOD_ASPEN.sapling.getDefaultState()),
                    new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 3),
                    new TwoLayersFeatureSize(1, 0, 1)
            ).ignoreVines().build())
            .applyChance(3)
            .decorate(Decorator.HEIGHTMAP.configure(new HeightmapDecoratorConfig(Heightmap.Type.MOTION_BLOCKING)));

    public static final ConfiguredFeature<?, ?> TREE_BIRCH = Feature.TREE
            .configure(new TreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(TFCObjects.WOOD_BIRCH.log.getDefaultState()),
                    new StraightTrunkPlacer(12, 3, 0),
                    new SimpleBlockStateProvider(TFCObjects.WOOD_BIRCH.leaves.getDefaultState()),
                    new SimpleBlockStateProvider(TFCObjects.WOOD_BIRCH.sapling.getDefaultState()),
                    new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 3),
                    new TwoLayersFeatureSize(1, 0, 1)
            ).build())
            .applyChance(3)
            .decorate(Decorator.HEIGHTMAP.configure(new HeightmapDecoratorConfig(Heightmap.Type.MOTION_BLOCKING)));

    public static final ConfiguredFeature<?, ?> TREE_BLACKWOOD = Feature.TREE
            .configure(new TreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(TFCObjects.WOOD_BLACKWOOD.log.getDefaultState()),
                    new StraightTrunkPlacer(8, 3, 0),
                    new SimpleBlockStateProvider(TFCObjects.WOOD_BLACKWOOD.leaves.getDefaultState()),
                    new SimpleBlockStateProvider(TFCObjects.WOOD_BLACKWOOD.sapling.getDefaultState()),
                    new BlobFoliagePlacer(ConstantIntProvider.create(5), ConstantIntProvider.create(0), 3),
                    new TwoLayersFeatureSize(1, 0, 1)
            ).build())
            .applyChance(3)
            .decorate(Decorator.HEIGHTMAP.configure(new HeightmapDecoratorConfig(Heightmap.Type.MOTION_BLOCKING)));

    public static final ConfiguredFeature<?, ?> TREE_CHESTNUT = Feature.TREE
            .configure(new TreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(TFCObjects.WOOD_CHESTNUT.log.getDefaultState()),
                    new StraightTrunkPlacer(8, 3, 0),
                    new SimpleBlockStateProvider(TFCObjects.WOOD_CHESTNUT.leaves.getDefaultState()),
                    new SimpleBlockStateProvider(TFCObjects.WOOD_CHESTNUT.sapling.getDefaultState()),
                    new BlobFoliagePlacer(ConstantIntProvider.create(5), ConstantIntProvider.create(0), 3),
                    new TwoLayersFeatureSize(1, 0, 1)
            ).build())
            .applyChance(3)
            .decorate(Decorator.HEIGHTMAP.configure(new HeightmapDecoratorConfig(Heightmap.Type.MOTION_BLOCKING)));

    public static final ConfiguredFeature<?, ?> TREE_DOUGLAS_FIR = Feature.TREE
            .configure(new TreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(TFCObjects.WOOD_DOUGLAS_FIR.log.getDefaultState()),
                    new StraightTrunkPlacer(8, 3, 0),
                    new SimpleBlockStateProvider(TFCObjects.WOOD_DOUGLAS_FIR.leaves.getDefaultState()),
                    new SimpleBlockStateProvider(TFCObjects.WOOD_DOUGLAS_FIR.sapling.getDefaultState()),
                    new BlobFoliagePlacer(ConstantIntProvider.create(5), ConstantIntProvider.create(0), 3),
                    new TwoLayersFeatureSize(1, 0, 1)
            ).build())
            .applyChance(3)
            .decorate(Decorator.HEIGHTMAP.configure(new HeightmapDecoratorConfig(Heightmap.Type.MOTION_BLOCKING)));

    public static final ConfiguredFeature<?, ?> TREE_HICKORY = Feature.TREE
            .configure(new TreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(TFCObjects.WOOD_HICKORY.log.getDefaultState()),
                    new StraightTrunkPlacer(8, 3, 0),
                    new SimpleBlockStateProvider(TFCObjects.WOOD_HICKORY.leaves.getDefaultState()),
                    new SimpleBlockStateProvider(TFCObjects.WOOD_HICKORY.sapling.getDefaultState()),
                    new BlobFoliagePlacer(ConstantIntProvider.create(5), ConstantIntProvider.create(0), 3),
                    new TwoLayersFeatureSize(1, 0, 1)
            ).build())
            .applyChance(3)
            .decorate(Decorator.HEIGHTMAP.configure(new HeightmapDecoratorConfig(Heightmap.Type.MOTION_BLOCKING)));

    public static final ConfiguredFeature<?, ?> TREE_KAPOK = Feature.TREE
            .configure(new TreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(TFCObjects.WOOD_KAPOK.log.getDefaultState()),
                    new StraightTrunkPlacer(15, 9, 0),
                    new SimpleBlockStateProvider(TFCObjects.WOOD_KAPOK.leaves.getDefaultState()),
                    new SimpleBlockStateProvider(TFCObjects.WOOD_KAPOK.sapling.getDefaultState()),
                    new BlobFoliagePlacer(ConstantIntProvider.create(5), ConstantIntProvider.create(0), 3),
                    new TwoLayersFeatureSize(1, 0, 1)
            ).build())
            .applyChance(3)
            .decorate(Decorator.HEIGHTMAP.configure(new HeightmapDecoratorConfig(Heightmap.Type.MOTION_BLOCKING)));

    public static final ConfiguredFeature<?, ?> TREE_MAPLE = Feature.TREE
            .configure(new TreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(TFCObjects.WOOD_MAPLE.log.getDefaultState()),
                    new StraightTrunkPlacer(8, 3, 0),
                    new SimpleBlockStateProvider(TFCObjects.WOOD_MAPLE.leaves.getDefaultState()),
                    new SimpleBlockStateProvider(TFCObjects.WOOD_MAPLE.sapling.getDefaultState()),
                    new BlobFoliagePlacer(ConstantIntProvider.create(5), ConstantIntProvider.create(0), 3),
                    new TwoLayersFeatureSize(1, 0, 1)
            ).build())
            .applyChance(3)
            .decorate(Decorator.HEIGHTMAP.configure(new HeightmapDecoratorConfig(Heightmap.Type.MOTION_BLOCKING)));

    public static final ConfiguredFeature<?, ?> TREE_OAK = Feature.TREE
            .configure(new TreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(TFCObjects.WOOD_OAK.log.getDefaultState()),
                    new StraightTrunkPlacer(8, 3, 0),
                    new SimpleBlockStateProvider(TFCObjects.WOOD_OAK.leaves.getDefaultState()),
                    new SimpleBlockStateProvider(TFCObjects.WOOD_OAK.sapling.getDefaultState()),
                    new BlobFoliagePlacer(ConstantIntProvider.create(5), ConstantIntProvider.create(0), 3),
                    new TwoLayersFeatureSize(1, 0, 1)
            ).build())
            .applyChance(3)
            .decorate(Decorator.HEIGHTMAP.configure(new HeightmapDecoratorConfig(Heightmap.Type.MOTION_BLOCKING)));

    public static final ConfiguredFeature<?, ?> TREE_PALM = Feature.TREE
            .configure(new TreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(TFCObjects.WOOD_PALM.log.getDefaultState()),
                    new StraightTrunkPlacer(8, 3, 0),
                    new SimpleBlockStateProvider(TFCObjects.WOOD_PALM.leaves.getDefaultState()),
                    new SimpleBlockStateProvider(TFCObjects.WOOD_PALM.sapling.getDefaultState()),
                    new BlobFoliagePlacer(ConstantIntProvider.create(5), ConstantIntProvider.create(0), 3),
                    new TwoLayersFeatureSize(1, 0, 1)
            ).build())
            .applyChance(3)
            .decorate(Decorator.HEIGHTMAP.configure(new HeightmapDecoratorConfig(Heightmap.Type.MOTION_BLOCKING)));

    public static final ConfiguredFeature<?, ?> TREE_PINE = Feature.TREE
            .configure(new TreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(TFCObjects.WOOD_PINE.log.getDefaultState()),
                    new StraightTrunkPlacer(8, 3, 0),
                    new SimpleBlockStateProvider(TFCObjects.WOOD_PINE.leaves.getDefaultState()),
                    new SimpleBlockStateProvider(TFCObjects.WOOD_PINE.sapling.getDefaultState()),
                    new BlobFoliagePlacer(ConstantIntProvider.create(5), ConstantIntProvider.create(0), 3),
                    new TwoLayersFeatureSize(1, 0, 1)
            ).build())
            .applyChance(3)
            .decorate(Decorator.HEIGHTMAP.configure(new HeightmapDecoratorConfig(Heightmap.Type.MOTION_BLOCKING)));

    public static final ConfiguredFeature<?, ?> TREE_ROSEWOOD = Feature.TREE
            .configure(new TreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(TFCObjects.WOOD_ROSEWOOD.log.getDefaultState()),
                    new StraightTrunkPlacer(8, 3, 0),
                    new SimpleBlockStateProvider(TFCObjects.WOOD_ROSEWOOD.leaves.getDefaultState()),
                    new SimpleBlockStateProvider(TFCObjects.WOOD_ROSEWOOD.sapling.getDefaultState()),
                    new BlobFoliagePlacer(ConstantIntProvider.create(5), ConstantIntProvider.create(0), 3),
                    new TwoLayersFeatureSize(1, 0, 1)
            ).build())
            .applyChance(3)
            .decorate(Decorator.HEIGHTMAP.configure(new HeightmapDecoratorConfig(Heightmap.Type.MOTION_BLOCKING)));

    public static final ConfiguredFeature<?, ?> TREE_SEQUOIA = Feature.TREE
            .configure(new TreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(TFCObjects.WOOD_SEQUOIA.log.getDefaultState()),
                    new StraightTrunkPlacer(8, 3, 0),
                    new SimpleBlockStateProvider(TFCObjects.WOOD_SEQUOIA.leaves.getDefaultState()),
                    new SimpleBlockStateProvider(TFCObjects.WOOD_SEQUOIA.sapling.getDefaultState()),
                    new BlobFoliagePlacer(ConstantIntProvider.create(5), ConstantIntProvider.create(0), 3),
                    new TwoLayersFeatureSize(1, 0, 1)
            ).build())
            .applyChance(3)
            .decorate(Decorator.HEIGHTMAP.configure(new HeightmapDecoratorConfig(Heightmap.Type.MOTION_BLOCKING)));

    public static final ConfiguredFeature<?, ?> TREE_SPRUCE = Feature.TREE
            .configure(new TreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(TFCObjects.WOOD_SPRUCE.log.getDefaultState()),
                    new StraightTrunkPlacer(8, 3, 0),
                    new SimpleBlockStateProvider(TFCObjects.WOOD_SPRUCE.leaves.getDefaultState()),
                    new SimpleBlockStateProvider(TFCObjects.WOOD_SPRUCE.sapling.getDefaultState()),
                    new BlobFoliagePlacer(ConstantIntProvider.create(5), ConstantIntProvider.create(0), 3),
                    new TwoLayersFeatureSize(1, 0, 1)
            ).build())
            .applyChance(3)
            .decorate(Decorator.HEIGHTMAP.configure(new HeightmapDecoratorConfig(Heightmap.Type.MOTION_BLOCKING)));

    public static final ConfiguredFeature<?, ?> TREE_SYCAMORE = Feature.TREE
            .configure(new TreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(TFCObjects.WOOD_SYCAMORE.log.getDefaultState()),
                    new StraightTrunkPlacer(8, 3, 0),
                    new SimpleBlockStateProvider(TFCObjects.WOOD_SYCAMORE.leaves.getDefaultState()),
                    new SimpleBlockStateProvider(TFCObjects.WOOD_SYCAMORE.sapling.getDefaultState()),
                    new BlobFoliagePlacer(ConstantIntProvider.create(5), ConstantIntProvider.create(0), 3),
                    new TwoLayersFeatureSize(1, 0, 1)
            ).build())
            .applyChance(3)
            .decorate(Decorator.HEIGHTMAP.configure(new HeightmapDecoratorConfig(Heightmap.Type.MOTION_BLOCKING)));

    public static final ConfiguredFeature<?, ?> TREE_WHITE_CEDAR = Feature.TREE
            .configure(new TreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(TFCObjects.WOOD_WHITE_CEDAR.log.getDefaultState()),
                    new StraightTrunkPlacer(8, 3, 0),
                    new SimpleBlockStateProvider(TFCObjects.WOOD_WHITE_CEDAR.leaves.getDefaultState()),
                    new SimpleBlockStateProvider(TFCObjects.WOOD_WHITE_CEDAR.sapling.getDefaultState()),
                    new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 3),
                    new TwoLayersFeatureSize(1, 0, 1)
            ).build())
            .applyChance(3)
            .decorate(Decorator.HEIGHTMAP.configure(new HeightmapDecoratorConfig(Heightmap.Type.MOTION_BLOCKING)));

    public static final ConfiguredFeature<?, ?> TREE_WILLOW = Feature.TREE
            .configure(new TreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(TFCObjects.WOOD_WILLOW.log.getDefaultState()),
                    new StraightTrunkPlacer(8, 3, 0),
                    new SimpleBlockStateProvider(TFCObjects.WOOD_WILLOW.leaves.getDefaultState()),
                    new SimpleBlockStateProvider(TFCObjects.WOOD_WILLOW.sapling.getDefaultState()),
                    new BlobFoliagePlacer(ConstantIntProvider.create(5), ConstantIntProvider.create(0), 3),
                    new TwoLayersFeatureSize(1, 0, 1)
            ).build())
            .applyChance(3)
            .decorate(Decorator.HEIGHTMAP.configure(new HeightmapDecoratorConfig(Heightmap.Type.MOTION_BLOCKING)));

    public static void register(String id, ConfiguredFeature<?, ?> feature, Predicate<BiomeSelectionContext> biome, GenerationStep.Feature generationStep) {
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new
                Identifier(TerraFabriCraft.MODID, id), feature);
        BiomeModification worldGen = BiomeModifications.create(new Identifier(TerraFabriCraft.MODID, "world_features"));
        worldGen.add(ModificationPhase.ADDITIONS, biome, context -> context.getGenerationSettings().
                addBuiltInFeature(GenerationStep.Feature.VEGETAL_DECORATION, feature));
    }

    public static final ConfiguredFeature<?, ?> BOULDER_ANDESITE = BOULDER.configure(new DefaultFeatureConfig())
            .decorate(Decorator.HEIGHTMAP.configure(new HeightmapDecoratorConfig(Heightmap.Type.OCEAN_FLOOR_WG)))
            .spreadHorizontally()
            .applyChance(5);

    public static void init() {
        var vegetalGenStep = GenerationStep.Feature.VEGETAL_DECORATION;
        var otherGenStep = GenerationStep.Feature.TOP_LAYER_MODIFICATION;
        //Register new feature
        Registry.register(Registry.FEATURE, new Identifier("terrafirmacraft", "boulder"), BOULDER);
        //Register configured feature
        register("tree/acacia", TREE_ACACIA, BiomeSelectors.foundInOverworld(), vegetalGenStep);
        register("tree/ash", TREE_ASH, BiomeSelectors.foundInOverworld(), vegetalGenStep);
        register("tree/aspen", TREE_ASPEN, BiomeSelectors.foundInOverworld(), vegetalGenStep);
        register("tree/birch", TREE_BIRCH, BiomeSelectors.categories(Biome.Category.PLAINS), vegetalGenStep);
        register("tree/blackwood", TREE_BLACKWOOD, BiomeSelectors.foundInOverworld(), vegetalGenStep);
        register("tree/chestnut", TREE_CHESTNUT, BiomeSelectors.foundInOverworld(), vegetalGenStep);
        register("tree/douglas_fir", TREE_DOUGLAS_FIR, BiomeSelectors.foundInOverworld(), vegetalGenStep);
        register("tree/hickory", TREE_HICKORY, BiomeSelectors.foundInOverworld(), vegetalGenStep);
        register("tree/kapok", TREE_KAPOK, BiomeSelectors.categories(Biome.Category.JUNGLE), vegetalGenStep);
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
        register("boulder/andesite", BOULDER_ANDESITE, BiomeSelectors.foundInOverworld(), otherGenStep);

    }
}

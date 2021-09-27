package malek.terrafabricraft.common.registry;

import malek.terrafabricraft.TerraFabriCraft;
import malek.terrafabricraft.common.block.*;
import malek.terrafabricraft.common.block.logpile.LogPile;
import malek.terrafabricraft.common.block.logpile.LogPileBlockEntity;
import malek.terrafabricraft.common.item.GroundCoverOreBlockItem;
import malek.terrafabricraft.common.item.TFCLogItem;
import malek.terrafabricraft.common.world.generator.tree.*;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.item.*;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.LinkedHashMap;
import java.util.Map;

import static malek.terrafabricraft.common.registry.TFCFeatures.*;
import static net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings.copyOf;

public class TFCObjects {
    public static final Map<Block, Identifier> BLOCKS = new LinkedHashMap<>();
    private static final Map<BlockEntityType<?>, Identifier> BLOCK_ENTITY_TYPES = new LinkedHashMap<>();
    public static final Map<Item, Identifier> ITEMS = new LinkedHashMap<>();

    public static final Item DECAY_FOOD_TEST = createFood("decay_test", 1,1);
    public static final Item DECAY_FOOD_TEST2 = createFood("decay_test2", 1,1);

    public static final Block ALABASTER_RAW_ALABASTER = createRock("alabaster/raw/alabaster", true);
    public static final Block ALABASTER_RAW_ALABASTER_BRICKS = createRock("alabaster/raw/alabaster_bricks", true);
    public static final Block ALABASTER_RAW_POLISHED_ALABASTER = createRock("alabaster/raw/polished_alabaster", true);
    public static final StainedAlabasterBlock ALABASTER_STAINED_BLACK = new StainedAlabasterBlock("black");
    public static final StainedAlabasterBlock ALABASTER_STAINED_BLUE = new StainedAlabasterBlock("blue");
    public static final StainedAlabasterBlock ALABASTER_STAINED_BROWN = new StainedAlabasterBlock("brown");
    public static final StainedAlabasterBlock ALABASTER_STAINED_CYAN = new StainedAlabasterBlock("cyan");
    public static final StainedAlabasterBlock ALABASTER_STAINED_GRAY = new StainedAlabasterBlock("gray");
    public static final StainedAlabasterBlock ALABASTER_STAINED_GREEN = new StainedAlabasterBlock("green");
    public static final StainedAlabasterBlock ALABASTER_STAINED_LIGHT_BLUE = new StainedAlabasterBlock("light_blue");
    public static final StainedAlabasterBlock ALABASTER_STAINED_LIGHT_GRAY = new StainedAlabasterBlock("light_gray");
    public static final StainedAlabasterBlock ALABASTER_STAINED_LIME = new StainedAlabasterBlock("lime");
    public static final StainedAlabasterBlock ALABASTER_STAINED_MAGENTA = new StainedAlabasterBlock("magenta");
    public static final StainedAlabasterBlock ALABASTER_STAINED_ORANGE = new StainedAlabasterBlock("orange");
    public static final StainedAlabasterBlock ALABASTER_STAINED_PINK = new StainedAlabasterBlock("pink");
    public static final StainedAlabasterBlock ALABASTER_STAINED_PURPLE = new StainedAlabasterBlock("purple");
    public static final StainedAlabasterBlock ALABASTER_STAINED_RED = new StainedAlabasterBlock("red");
    public static final StainedAlabasterBlock ALABASTER_STAINED_WHITE = new StainedAlabasterBlock("white");
    public static final StainedAlabasterBlock ALABASTER_STAINED_YELLOW = new StainedAlabasterBlock("yellow");

    public static final CoralBlock CORAL_BRAIN = new CoralBlock("coral/brain");
    public static final CoralBlock CORAL_BUBBLE = new CoralBlock("coral/bubble");
    public static final CoralBlock CORAL_FIRE = new CoralBlock("coral/fire");
    public static final CoralBlock CORAL_HORN = new CoralBlock("coral/horn");
    public static final CoralBlock CORAL_TUBE = new CoralBlock("coral/tube");


    public static final Block BARLEY_CROP = createCrop("barley_crop", 0, 1, false, false);
    public static final Block CABBAGE_CROP = createCrop("cabbage_crop", 0, 1, false, false);
    public static final Block CARROT_CROP = createCrop("carrot_crop", 0, 1, false, false);
    public static final Block GARLIC_CROP = createCrop("garlic_crop", 0, 1, false, false);
    public static final Block GREENBEAN_CROP = createCrop("greenbean_crop", 0, 1, false, false);
    public static final Block JUTE_CROP = createCrop("jute_crop", 0, 1, true, false);
    public static final Block MAIZE_CROP = createCrop("maize_crop", 0, 1, true, false);
    public static final Block OAT_CROP = createCrop("oat_crop", 0, 1, false, false);
    public static final Block ONION_CROP = createCrop("onion_crop", 0, 1, false, false);
    public static final Block POTATO_CROP = createCrop("potato_crop", 0, 1, false, false);
    public static final Block RED_BELL_PEPPER_CROP = createCrop("red_bell_pepper_crop", 0, 1, false, false);
    public static final Block RICE_CROP = createCrop("rice_crop", 0, 1, false, false);
    public static final Block RUTABAGA_CROP = createCrop("rutabaga_crop", 0, 1, false, false);
    public static final Block RYE_CROP = createCrop("rye_crop", 0, 1, false, false);
    public static final Block SOYBEAN_CROP = createCrop("soybean_crop", 0, 1, false, false);
    public static final Block SQUASH_CROP = createCrop("squash_crop", 0, 1, false, false);
    public static final Block TOMATO_CROP = createCrop("tomato_crop", 0, 1, false, false);
    public static final Block WHEAT_CROP = createCrop("wheat_crop", 0, 1, false, false);
    public static final Block YELLOW_BELL_PEPPER_CROP = createCrop("yellow_bell_pepper_crop", 0, 1, false, false);

    //Seeds
    public static final Item BARLEY_SEED = createItem("seed/barley_seeds", new AliasedBlockItem(BARLEY_CROP, gen(TerraFabriCraft.FLORA_GROUP)));
    public static final Item CABBAGE_SEED = createItem("seed/cabbage_seeds", new AliasedBlockItem(CABBAGE_CROP, gen(TerraFabriCraft.FLORA_GROUP)));
    public static final Item CARROT_SEED = createItem("seed/carrot_seeds", new AliasedBlockItem(CARROT_CROP, gen(TerraFabriCraft.FLORA_GROUP)));
    public static final Item GARLIC_SEED = createItem("seed/garlic_seeds", new AliasedBlockItem(GARLIC_CROP, gen(TerraFabriCraft.FLORA_GROUP)));
    public static final Item GREENBEAN_SEED = createItem("seed/greenbean_seeds", new AliasedBlockItem(GREENBEAN_CROP, gen(TerraFabriCraft.FLORA_GROUP)));
    public static final Item JUTE_SEED = createItem("seed/jute_seeds", new AliasedBlockItem(JUTE_CROP, gen(TerraFabriCraft.FLORA_GROUP)));
    public static final Item MAIZE_SEED = createItem("seed/maize_seeds", new AliasedBlockItem(MAIZE_CROP, gen(TerraFabriCraft.FLORA_GROUP)));
    public static final Item OAT_SEED = createItem("seed/oat_seeds", new AliasedBlockItem(OAT_CROP, gen(TerraFabriCraft.FLORA_GROUP)));
    public static final Item ONION_SEED = createItem("seed/onion_seeds", new AliasedBlockItem(ONION_CROP, gen(TerraFabriCraft.FLORA_GROUP)));
    public static final Item POTATO_SEED = createItem("seed/potato_seeds", new AliasedBlockItem(POTATO_CROP, gen(TerraFabriCraft.FLORA_GROUP)));
    public static final Item RED_BELL_PEPPER_SEED = createItem("seed/red_bell_pepper_seeds", new AliasedBlockItem(RED_BELL_PEPPER_CROP, gen(TerraFabriCraft.FLORA_GROUP)));
    public static final Item RICE_SEED = createItem("seed/rice_seeds", new AliasedBlockItem(RICE_CROP, gen(TerraFabriCraft.FLORA_GROUP)));
    public static final Item RUTABAGA_SEED = createItem("seed/rutabaga_seeds", new AliasedBlockItem(RUTABAGA_CROP, gen(TerraFabriCraft.FLORA_GROUP)));
    public static final Item RYE_SEED = createItem("seed/rye_seeds", new AliasedBlockItem(RYE_CROP, gen(TerraFabriCraft.FLORA_GROUP)));
    public static final Item SOYBEAN_SEED = createItem("seed/soybean_seeds", new AliasedBlockItem(SOYBEAN_CROP, gen(TerraFabriCraft.FLORA_GROUP)));
    public static final Item SQUASH_SEED = createItem("seed/squash_seeds", new AliasedBlockItem(SQUASH_CROP, gen(TerraFabriCraft.FLORA_GROUP)));
    public static final Item TOMATO_SEED = createItem("seed/tomato_seeds", new AliasedBlockItem(TOMATO_CROP, gen(TerraFabriCraft.FLORA_GROUP)));
    public static final Item WHEAT_SEED = createItem("seed/wheat_seeds", new AliasedBlockItem(WHEAT_CROP, gen(TerraFabriCraft.FLORA_GROUP)));
    public static final Item YELLOW_BELL_PEPPER_SEED = createItem("seed/yellow_bell_pepper_seeds", new AliasedBlockItem(YELLOW_BELL_PEPPER_CROP, gen(TerraFabriCraft.FLORA_GROUP)));


    public static final SoilBlock CLAY = new SoilBlock("clay");
    public static final SoilBlock CLAY_GRASS = new SoilBlock("clay_grass");
    public static final SoilBlock DIRT = new SoilBlock("dirt");

    public static final TFCGravityBlock FARMLAND_LOAM = createFarmland("farmland/loam", true);
    public static final TFCGravityBlock FARMLAND_SANDY_LOAM = createFarmland("farmland/sandy_loam", true);
    public static final TFCGravityBlock FARMLAND_SILT = createFarmland("farmland/silt", true);
    public static final TFCGravityBlock FARMLAND_SILTY_LOAM = createFarmland("farmland/silty_loam", true);
    public static final SoilBlock GRASS = new SoilBlock("grass");

    public static final SoilBlock GRASS_PATH = new SoilBlock("grass_path");

    //Ground Cover
    public static final GroundCoverBlock GROUNDCOVER_BONE = createGroundcover("groundcover/bone", Items.BONE);
    public static final GroundCoverBlock GROUNDCOVER_CLAM = createGroundcover("groundcover/clam");
    public static final GroundCoverBlock GROUNDCOVER_DEAD_GRASS = createGroundcover("groundcover/dead_grass");
    public static final GroundCoverBlock GROUNDCOVER_DRIFTWOOD = createGroundcover("groundcover/driftwood");
    public static final GroundCoverBlock GROUNDCOVER_FEATHER = createGroundcover("groundcover/feather", Items.FEATHER);
    public static final GroundCoverBlock GROUNDCOVER_GUANO = createGroundcover("groundcover/guano");
    public static final GroundCoverBlock GROUNDCOVER_MOLLUSK = createGroundcover("groundcover/mollusk");
    public static final GroundCoverBlock GROUNDCOVER_MUSSEL = createGroundcover("groundcover/mussel");
    public static final GroundCoverBlock GROUNDCOVER_PINECONE = createGroundcover("groundcover/pinecone");
    public static final GroundCoverBlock GROUNDCOVER_PODZOL = createGroundcover("groundcover/podzol", Items.PODZOL);
    public static final GroundCoverBlock GROUNDCOVER_ROTTEN_FLESH = createGroundcover("groundcover/rotten_flesh", Items.ROTTEN_FLESH);
    public static final GroundCoverBlock GROUNDCOVER_SALT_LICK = createGroundcover("groundcover/seaweed");
    public static final GroundCoverBlock GROUNDCOVER_STICK = createGroundcover("groundcover/stick", Items.STICK);
    //Stone
    //Sample rock class :-)
    public static final Block ROCK_BLOCK = createRock("rock_block", true);

    public static final Block ORE_SMALL_BISMUTHINITE = createGroundOre("ore/small_bismuthinite", false, 271);
    public static final Block ORE_SMALL_CASSITERITE = createGroundOre("ore/small_cassiterite", false, 232);
    public static final Block ORE_SMALL_GARNIERITE = createGroundOre("ore/small_garnierite", false, 1455);
    public static final Block ORE_SMALL_HEMATITE = createGroundOre("ore/small_hematite", false, 1538);
    public static final Block ORE_SMALL_LIMONITE = createGroundOre("ore/small_limonite", false, 1538);
    public static final Block ORE_SMALL_MAGNETITE = createGroundOre("ore/small_magnetite", false, 1538);
    public static final Block ORE_SMALL_MALACHITE = createGroundOre("ore/small_malachite", false, 1085);
    public static final Block ORE_SMALL_NATIVE_COPPPER = createGroundOre("ore/small_native_copper", false, 1085);
    public static final Block ORE_SMALL_NATIVE_GOLD = createGroundOre("ore/small_native_gold", false, 1064);
    public static final Block ORE_SMALL_NATIVE_SILVER = createGroundOre("ore/small_native_silver", false, 961);
    public static final Block ORE_SMALL_SPHALERITE = createGroundOre("ore/small_sphalerite", false, 1085);
    public static final Block ORE_SMALL_TETRAHEDRITE = createGroundOre("ore/small_tetrahedrite", false, 1085);
    //Ores
    public static final RockBlock ANDESITE = new RockBlock("andesite");
    public static final RockBlock BASALT = new RockBlock("basalt");
    public static final RockBlock CHALK = new RockBlock("chalk");
    public static final RockBlock CHERT = new RockBlock("chert");
    public static final RockBlock CLAYSTONE = new RockBlock("claystone");
    public static final RockBlock CONGLOMERATE = new RockBlock("conglomerate");
    public static final RockBlock DACITE = new RockBlock("dacite");
    public static final RockBlock DIORITE = new RockBlock("diorite");
    public static final RockBlock DOLOMITE = new RockBlock("dolomite");
    public static final RockBlock GABBRO = new RockBlock("gabbro");
    public static final RockBlock GNEISS = new RockBlock("gneiss");
    public static final RockBlock GRANITE = new RockBlock("granite");
    public static final RockBlock LIMESTONE = new RockBlock("limestone");
    public static final RockBlock MARBLE = new RockBlock("marble");
    public static final RockBlock PHYLLITE = new RockBlock("phyllite");
    public static final RockBlock QUARTZITE = new RockBlock("quartzite");
    public static final RockBlock RHYOLITE = new RockBlock("rhyolite");
    public static final RockBlock SCHIST = new RockBlock("schist");
    public static final RockBlock SHALE = new RockBlock("shale");
    public static final RockBlock SLATE = new RockBlock("slate");
    //Peat grass
    public static final TFCGravityBlock PEAT_GRASS = createSand("peat_grass", true);
    //Sand
    public static final TFCGravityBlock SAND_BLACK = createSand("sand/black", true);
    public static final TFCGravityBlock SAND_BROWN = createSand("sand/brown", true);
    public static final TFCGravityBlock SAND_GREEN = createSand("sand/green", true);
    public static final TFCGravityBlock SAND_PINK = createSand("sand/pink", true);
    public static final TFCGravityBlock SAND_RED = createSand("sand/red", true);
    public static final TFCGravityBlock SAND_WHITE = createSand("sand/white", true);
    public static final TFCGravityBlock SAND_YELLOW = createSand("sand/yellow", true);
    //Wood blocks
    public static final WoodBlock WOOD_ACACIA = new WoodBlock("acacia", new GenericSaplingGenerator(TREE_ACACIA), MapColor.RED);
    public static final WoodBlock WOOD_ASH = new WoodBlock("ash", new GenericSaplingGenerator(TREE_ASH), MapColor.BRIGHT_RED);
    public static final WoodBlock WOOD_ASPEN = new WoodBlock("aspen", new GenericSaplingGenerator(TREE_ASPEN), MapColor.LICHEN_GREEN);
    public static final WoodBlock WOOD_BIRCH = new WoodBlock("birch", new GenericSaplingGenerator(TREE_BIRCH), MapColor.PALE_YELLOW);
    public static final WoodBlock WOOD_BLACKWOOD = new WoodBlock("blackwood", new GenericSaplingGenerator(TREE_BLACKWOOD), MapColor.BLACK);
    public static final WoodBlock WOOD_CHESTNUT = new WoodBlock("chestnut", new GenericSaplingGenerator(TREE_CHESTNUT), MapColor.WHITE);
    public static final WoodBlock WOOD_DOUGLAS_FIR = new WoodBlock("douglas_fir", new GenericSaplingGenerator(TREE_DOUGLAS_FIR), MapColor.WHITE);
    public static final WoodBlock WOOD_HICKORY = new WoodBlock("hickory", new GenericSaplingGenerator(TREE_HICKORY), MapColor.WHITE);
    public static final WoodBlock WOOD_KAPOK = new WoodBlock("kapok", new KapokSaplingGenerator(TREE_KAPOK), MapColor.WHITE);
    public static final WoodBlock WOOD_MAPLE = new WoodBlock("maple", new GenericSaplingGenerator(TREE_MAPLE), MapColor.WHITE);
    public static final WoodBlock WOOD_OAK = new WoodBlock("oak", new GenericSaplingGenerator(TREE_OAK), MapColor.WHITE);
    public static final WoodBlock WOOD_PALM = new WoodBlock("palm", new GenericSaplingGenerator(TREE_PALM), MapColor.WHITE);
    public static final WoodBlock WOOD_PINE = new WoodBlock("pine", new GenericSaplingGenerator(TREE_PINE), MapColor.WHITE);
    public static final WoodBlock WOOD_ROSEWOOD = new WoodBlock("rosewood", new GenericSaplingGenerator(TREE_ROSEWOOD), MapColor.WHITE);
    public static final WoodBlock WOOD_SEQUOIA = new WoodBlock("sequoia", new GenericSaplingGenerator(TREE_SEQUOIA), MapColor.WHITE);
    public static final WoodBlock WOOD_SPRUCE = new WoodBlock("spruce", new GenericSaplingGenerator(TREE_SPRUCE), MapColor.WHITE);
    public static final WoodBlock WOOD_SYCAMORE = new WoodBlock("sycamore", new GenericSaplingGenerator(TREE_SYCAMORE), MapColor.WHITE);
    public static final WoodBlock WOOD_WHITE_CEDAR = new WoodBlock("white_cedar", new GenericSaplingGenerator(TREE_WHITE_CEDAR), MapColor.WHITE);
    public static final WoodBlock WOOD_WILLOW = new WoodBlock("willow", new GenericSaplingGenerator(TREE_WILLOW), MapColor.WHITE);

    //Make a createBlock method, baldek :P
    public static final LogPile LOG_PILE = register("log_pile", new LogPile(FabricBlockSettings.copyOf(Blocks.STONE)));

    public static final SandstoneBlock SANDSTONE_BLACK = new SandstoneBlock("sandstone/black");
    public static final SandstoneBlock SANDSTONE_BROWN = new SandstoneBlock("sandstone/brown");
    public static final SandstoneBlock SANDSTONE_GREEN = new SandstoneBlock("sandstone/green");
    public static final SandstoneBlock SANDSTONE_PINK = new SandstoneBlock("sandstone/pink");
    public static final SandstoneBlock SANDSTONE_RED = new SandstoneBlock("sandstone/red");
    public static final SandstoneBlock SANDSTONE_WHITE = new SandstoneBlock("sandstone/white");
    public static final SandstoneBlock SANDSTONE_YELLOW = new SandstoneBlock("sandstone/yellow");

    //Peat
    public static final TFCGravityBlock PEAT = createRock("peat", true);

    public static final TFCLeaves THATCH = createLeaves("thatch", true);

    public static final Block FIRE_BRICKS = createLooseRock("fire_bricks", true);

    public static final Block CALCITE = createLooseRock("calcite", true);

    public static final Block BELLOWS = createLooseRock("bellows", true);

    public static final Block CHARCOAL_PILE = createLooseRock("charcoal_pile", true);

    //Block Entities
    public static final BlockEntityType<LogPileBlockEntity> LOG_PILE_BLOCK_ENTITY = register("log_pile_entity", FabricBlockEntityTypeBuilder.create(LogPileBlockEntity::new, TFCObjects.LOG_PILE).build(null));

    public static <T extends Block> T register(String id, T block) {
        BLOCKS.put(block, new Identifier(TerraFabriCraft.MODID, id));
        return block;
    }

    public static <T extends Block> T register(String id, T block, Boolean hasBlockItem, ItemGroup itemGroup) {
        BLOCKS.put(block, new Identifier(TerraFabriCraft.MODID, id));
        if (hasBlockItem) {
            ITEMS.put(new BlockItem(block, gen(itemGroup)), BLOCKS.get(block));
        }
        return block;
    }

    public static <T extends Block> T register(String id, T block, Item itemId) {
        //Do something with item id.
        BLOCKS.put(block, new Identifier(TerraFabriCraft.MODID, id));
        return block;
    }

    public static TFCLeaves createLeaves(String id, boolean hasBlockItem) {
        var block = new TFCLeaves(FabricBlockSettings.of(Material.LEAVES).breakByTool(FabricToolTags.HOES).sounds(BlockSoundGroup.SLIME).strength(2.0f).noCollision());
        register(id, block, hasBlockItem, TerraFabriCraft.WOOD_GROUP);
        return block;
    }

    public static TFCLog createLog(String id, boolean hasBlockItem) {
        var block = new TFCLog(FabricBlockSettings.of(Material.WOOD).breakByTool(FabricToolTags.AXES).sounds(BlockSoundGroup.WOOD).strength(2.0f));
        register(id, block, false, TerraFabriCraft.WOOD_GROUP);
        createItem(id, new TFCLogItem(block, gen(TerraFabriCraft.WOOD_GROUP)));
        return block;
    }

    public static TFCSapling createSapling(String id, boolean hasBlockItem, SaplingGenerator generator) {
        //TODO Give leaves an appropriate sound.
        var block = new TFCSapling(generator, FabricBlockSettings.copyOf(Blocks.OAK_SAPLING));
        BlockRenderLayerMap.INSTANCE.putBlock(block, RenderLayer.getCutout());
        register(id, block, hasBlockItem, TerraFabriCraft.WOOD_GROUP);
        return block;
    }

    public static TFCLog createStrippedLog(String id, MapColor color, boolean hasBlockItem) {
        var block = new TFCLog(FabricBlockSettings.of(Material.WOOD, color).breakByTool(FabricToolTags.AXES).sounds(BlockSoundGroup.WOOD).strength(2.0f));
        register(id, block, hasBlockItem, TerraFabriCraft.WOOD_GROUP);
        return block;
    }


    public static TFCLooseRock createLooseRock(String id, boolean hasBlockItem) {
        var block = new TFCLooseRock(FabricBlockSettings.of(Material.STONE).breakByTool(FabricToolTags.PICKAXES).sounds(BlockSoundGroup.STONE).strength(6.0f));
        register(id, block, hasBlockItem, TerraFabriCraft.ROCK_GROUP);
        return block;
    }

    public static TFCStairs createStoneStairs(String id, Block fullBlock) {
        var block = new TFCStairs(fullBlock.getDefaultState(), FabricBlockSettings.of(Material.STONE).breakByTool(FabricToolTags.PICKAXES).sounds(BlockSoundGroup.STONE).strength(6.0f));
        register(id, block, true, TerraFabriCraft.ROCK_GROUP);
        return block;
    }

    public static SlabBlock createStoneSlab(String id) {
        var block = new SlabBlock(FabricBlockSettings.of(Material.STONE).breakByTool(FabricToolTags.PICKAXES).sounds(BlockSoundGroup.STONE).strength(6.0f));
        register(id, block, true, TerraFabriCraft.ROCK_GROUP);
        return block;
    }

    public static WallBlock createWall(String id) {
        var block = new WallBlock(FabricBlockSettings.of(Material.STONE).breakByTool(FabricToolTags.PICKAXES).sounds(BlockSoundGroup.STONE).strength(6.0f));
        register(id, block, true, TerraFabriCraft.ROCK_GROUP);
        return block;
    }

    public static TFCGravityBlock createRock(String id, boolean hasBlockItem) {
        var block = new TFCGravityBlock(FabricBlockSettings.of(Material.STONE).breakByTool(FabricToolTags.PICKAXES).sounds(BlockSoundGroup.STONE).strength(2.0f));
        register(id, block, hasBlockItem,   TerraFabriCraft.ROCK_GROUP);
        return block;
    }


    public static Block createGroundOre(String id, boolean hasBlockItem, int meltingPoint) {
        var block = new GroundCoverOre(FabricBlockSettings.of(Material.WOOD).breakByTool(FabricToolTags.AXES).sounds(BlockSoundGroup.WOOD).strength(2.0f));
        createItem(id, new GroundCoverOreBlockItem(block, gen(TerraFabriCraft.ROCK_GROUP), meltingPoint));
        register(id, block);
        return block;
    }

    public static TFCTwig createTwig(String id, boolean hasBlockItem) {
        var block = new TFCTwig(FabricBlockSettings.of(Material.WOOD).breakByTool(FabricToolTags.AXES).sounds(BlockSoundGroup.WOOD).strength(2.0f));
        register(id, block, hasBlockItem, TerraFabriCraft.WOOD_GROUP);
        return block;
    }

    public static TFCSupport createSupport(String id, boolean hasBlockItem) {
        var block = new TFCSupport(FabricBlockSettings.of(Material.WOOD).breakByTool(FabricToolTags.AXES).sounds(BlockSoundGroup.WOOD).strength(2.0f));
        register(id, block, hasBlockItem, TerraFabriCraft.WOOD_GROUP);
        return block;
    }

    public static TFCGravityBlock createSand(String id, boolean hasBlockItem) {
        var block = new TFCGravityBlock(FabricBlockSettings.of(Material.SOIL).breakByTool(FabricToolTags.SHOVELS).sounds(BlockSoundGroup.SAND).strength(2.0f));
        register(id, block, hasBlockItem, TerraFabriCraft.EARTH_GROUP);
        return block;
    }

    public static TFCCoralBlock createCoralBlock(String id, TFCDeadCoralBlock deadCoralBlock) {
        var block = new TFCCoralBlock(deadCoralBlock, FabricBlockSettings.of(Material.STONE).breakByTool(FabricToolTags.PICKAXES).sounds(BlockSoundGroup.CORAL).strength(2.0f).noCollision());
        register(id, block, true, TerraFabriCraft.FLORA_GROUP);
        BlockRenderLayerMap.INSTANCE.putBlock(block, RenderLayer.getCutout());
        return block;
    }

    public static TFCCoralFanBlock createCoralFanBlock(String id, TFCDeadCoralFanBlock deadCoralFanBlock) {
        var block = new TFCCoralFanBlock(deadCoralFanBlock, FabricBlockSettings.of(Material.STONE).breakByTool(FabricToolTags.PICKAXES).sounds(BlockSoundGroup.CORAL).strength(2.0f).noCollision());
        register(id, block, true, TerraFabriCraft.FLORA_GROUP);
        BlockRenderLayerMap.INSTANCE.putBlock(block, RenderLayer.getCutout());
        return block;
    }

    public static TFCDeadCoralBlock createDeadCoralBlock(String id) {
        var block = new TFCDeadCoralBlock(FabricBlockSettings.of(Material.STONE).breakByTool(FabricToolTags.PICKAXES).sounds(BlockSoundGroup.CORAL).strength(2.0f).noCollision());
        register(id, block, true, TerraFabriCraft.FLORA_GROUP);
        return block;
    }

    public static TFCDeadCoralFanBlock createDeadCoralFanBlock(String id) {
        var block = new TFCDeadCoralFanBlock(FabricBlockSettings.of(Material.STONE).breakByTool(FabricToolTags.PICKAXES).sounds(BlockSoundGroup.CORAL).strength(2.0f).noCollision());
        register(id, block, true, TerraFabriCraft.FLORA_GROUP);
        BlockRenderLayerMap.INSTANCE.putBlock(block, RenderLayer.getCutout());
        return block;
    }


    public static TFCGravityGrassBlock createGrass(String id, boolean hasBlockItem) {
        var block = new TFCGravityGrassBlock(FabricBlockSettings.of(Material.LEAVES).breakByTool(FabricToolTags.HOES).sounds(BlockSoundGroup.SLIME).strength(2.0f));
        register(id, block, hasBlockItem, TerraFabriCraft.EARTH_GROUP);
        return block;
    }

    public static TFCGravityBlock createFarmland(String id, boolean hasItem) {
        var block = new TFCGravityBlock(FabricBlockSettings.of(Material.LEAVES).breakByTool(FabricToolTags.HOES).sounds(BlockSoundGroup.SLIME).strength(2.0f));
        register(id, block, hasItem, TerraFabriCraft.ROCK_GROUP);
        return block;
    }

    public static GroundCoverBlock createGroundcover(String id, Item dropId) {
        var block = new GroundCoverBlock(FabricBlockSettings.of(Material.STONE).breakByTool(FabricToolTags.PICKAXES).strength(6.0f));
        register(id, block, dropId);
        return block;
    }

    public static GroundCoverBlock createGroundcover(String id) {
        var block = new GroundCoverBlock(FabricBlockSettings.of(Material.STONE).breakByTool(FabricToolTags.PICKAXES).strength(6.0f));
        register(id, block);
        return block;
    }

    public static Block createCrop(String id, int temp, int speed, boolean tall, boolean hasBlockItem) {
        var block = tall ? new TFCCropsTall(copyOf(Blocks.WHEAT), temp, speed) : new TFCCrops(copyOf(Blocks.WHEAT), temp, speed);
        register("crop/" + id, block, hasBlockItem, TerraFabriCraft.FLORA_GROUP);
        return block;
    }
    public static Item createFood(String id, int weigthCategory, int sizeCategory){
        var item = new TFCFood(gen(TerraFabriCraft.FOOD_GROUP).maxCount(1), weigthCategory, sizeCategory);
        register("food/" + id, item);
        return item;
    }


    public static <T extends Item> T register(String id, T item) {
        ITEMS.put(item, new Identifier(TerraFabriCraft.MODID, id));
        return item;
    }


    //Register item
    private static <T extends Item> T createItem(String id, T item) {
        ITEMS.put(item, new Identifier(TerraFabriCraft.MODID, id));
        return item;
    }

    private static <T extends BlockEntity> BlockEntityType<T> register(String id, BlockEntityType<T> type) {
        BLOCK_ENTITY_TYPES.put(type, new Identifier(TerraFabriCraft.MODID, id));
        return type;
    }

    private static Item.Settings gen(ItemGroup itemGroup) {
        return new Item.Settings().group(itemGroup);
    }

    public static void init() {
        BLOCKS.keySet().forEach(block -> Registry.register(Registry.BLOCK, BLOCKS.get(block), block));
        BLOCK_ENTITY_TYPES.keySet().forEach(blockEntityType -> Registry.register(Registry.BLOCK_ENTITY_TYPE, BLOCK_ENTITY_TYPES.get(blockEntityType), blockEntityType));
        ITEMS.keySet().forEach(item -> Registry.register(Registry.ITEM, ITEMS.get(item), item));
    }
}
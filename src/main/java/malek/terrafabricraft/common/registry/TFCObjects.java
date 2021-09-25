package malek.terrafabricraft.common.registry;

import malek.terrafabricraft.TerraFabriCraft;
import malek.terrafabricraft.common.block.*;
import malek.terrafabricraft.common.block.entity.RockBlockEntity;
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
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Items;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.LinkedHashMap;
import java.util.Map;

import static malek.terrafabricraft.common.world.worldgen.Tree.*;

public class TFCObjects {
    public static final Map<Block, Identifier> BLOCKS = new LinkedHashMap<>();
    private static final Map<BlockEntityType<?>, Identifier> BLOCK_ENTITY_TYPES = new LinkedHashMap<>();
    private static final Map<Item, Identifier> ITEMS = new LinkedHashMap<>();

    public static final SoilBlock CLAY = new SoilBlock("clay");
    public static final SoilBlock CLAY_GRASS = new SoilBlock("clay_grass");
    public static final SoilBlock DIRT = new SoilBlock("dirt");
    public static final TFCGravityBlock FARMLAND_LOAM = createFarmland("farmland/loam", true);
    public static final TFCGravityBlock FARMLAND_SANDY_LOAM = createFarmland("farmland/sandy_loam", true);
    public static final TFCGravityBlock FARMLAND_SILT = createFarmland("farmland/silt", true);
    public static final TFCGravityBlock FARMLAND_SILTY_LOAM = createFarmland("farmland/silty_loam", true);
    public static final SoilBlock GRASS = new SoilBlock("grass");
    public static final SoilBlock GRASS_PATH = new SoilBlock("grass_path");

    //Peat
    public static final TFCGravityBlock PEAT = createSand("peat", true);

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
    public static final Block ROCK_BLOCK = createRock("rock_block", true);
    //TODO Create a class for small ores.
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
    public static final StoneBlock ANDESITE = new StoneBlock("andesite");
    public static final StoneBlock BASALT = new StoneBlock("basalt");
    public static final StoneBlock CHALK = new StoneBlock("chalk");
    public static final StoneBlock CHERT = new StoneBlock("chert");
    public static final StoneBlock CLAYSTONE = new StoneBlock("claystone");
    public static final StoneBlock CONGLOMERATE = new StoneBlock("conglomerate");
    public static final StoneBlock DACITE = new StoneBlock("dacite");
    public static final StoneBlock DIORITE = new StoneBlock("diorite");
    public static final StoneBlock DOLOMITE = new StoneBlock("dolomite");
    public static final StoneBlock GABBRO = new StoneBlock("gabbro");
    public static final StoneBlock GNEISS = new StoneBlock("gneiss");
    public static final StoneBlock GRANITE = new StoneBlock("granite");
    public static final StoneBlock LIMESTONE = new StoneBlock("limestone");
    public static final StoneBlock MARBLE = new StoneBlock("marble");
    public static final StoneBlock PHYLLITE = new StoneBlock("phyllite");
    public static final StoneBlock QUARTZITE = new StoneBlock("quartzite");
    public static final StoneBlock RHYOLITE = new StoneBlock("rhyolite");
    public static final StoneBlock SCHIST = new StoneBlock("schist");
    public static final StoneBlock SHALE = new StoneBlock("shale");
    public static final StoneBlock SLATE = new StoneBlock("slate");
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
    public static final WoodBlock WOOD_ACACIA = new WoodBlock("acacia", new AcaciaSaplingGenerator(TREE_ACACIA));
    public static final WoodBlock WOOD_ASH = new WoodBlock("ash", new AshSaplingGenerator(TREE_ASH));
    public static final WoodBlock WOOD_ASPEN = new WoodBlock("aspen", new AspenSaplingGenerator(TREE_ASPEN));
    public static final WoodBlock WOOD_BIRCH = new WoodBlock("birch", new BirchSaplingGenerator(TREE_BIRCH));
    public static final WoodBlock WOOD_BLACKWOOD = new WoodBlock("blackwood", new BlackwoodSaplingGenerator(TREE_BLACKWOOD));
    public static final WoodBlock WOOD_CHESTNUT = new WoodBlock("chestnut", new ChestnutSaplingGenerator(TREE_CHESTNUT));
    public static final WoodBlock WOOD_DOUGLAS_FIR = new WoodBlock("douglas_fir", new DouglasFirSaplingGenerator(TREE_DOUGLAS_FIR));
    public static final WoodBlock WOOD_HICKORY = new WoodBlock("hickory", new HickorySaplingGenerator(TREE_HICKORY));
    public static final WoodBlock WOOD_KAPOK = new WoodBlock("kapok", new KapokSaplingGenerator(TREE_KAPOK));
    public static final WoodBlock WOOD_MAPLE = new WoodBlock("maple", new MapleSaplingGenerator(TREE_MAPLE));
    public static final WoodBlock WOOD_OAK = new WoodBlock("oak", new OakSaplingGenerator(TREE_OAK));
    public static final WoodBlock WOOD_PALM = new WoodBlock("palm", new PalmSaplingGenerator(TREE_PALM));
    public static final WoodBlock WOOD_PINE = new WoodBlock("pine", new PineSaplingGenerator(TREE_PINE));
    public static final WoodBlock WOOD_ROSEWOOD = new WoodBlock("rosewood", new RosewoodSaplingGenerator(TREE_ROSEWOOD));
    public static final WoodBlock WOOD_SEQUOIA = new WoodBlock("sequoia", new SequoiaSaplingGenerator(TREE_SEQUOIA));
    public static final WoodBlock WOOD_SPRUCE = new WoodBlock("spruce", new SpruceSaplingGenerator(TREE_SPRUCE));
    public static final WoodBlock WOOD_SYCAMORE = new WoodBlock("sycamore", new SycamoreSaplingGenerator(TREE_SYCAMORE));
    public static final WoodBlock WOOD_WHITE_CEDAR = new WoodBlock("white_cedar", new WhiteCedarSaplingGenerator(TREE_WHITE_CEDAR));
    public static final WoodBlock WOOD_WILLOW = new WoodBlock("willow", new WillowSaplingGenerator(TREE_WILLOW));

    public static final LogPile LOG_PILE = register("log_pile", new LogPile(FabricBlockSettings.copyOf(Blocks.STONE)));

//    //Leaves
//    public static final TFCLeavesBlock WOOD_LEAVES_ACACIA = createLeaves("wood/leaves/acacia", true);
//    public static final TFCLeavesBlock WOOD_LEAVES_ASH = createLeaves("wood/leaves/ash", true);
//    public static final TFCLeavesBlock WOOD_LEAVES_ASPEN = createLeaves("wood/leaves/aspen", true);
//    public static final TFCLeavesBlock WOOD_LEAVES_BIRCH = createLeaves("wood/leaves/birch", true);
//    public static final TFCLeavesBlock WOOD_LEAVES_BLACKWOOD = createLeaves("wood/leaves/blackwood", true);
//    public static final TFCLeavesBlock WOOD_LEAVES_CHESTNUT = createLeaves("wood/leaves/chestnut", true);
//    public static final TFCLeavesBlock WOOD_LEAVES_DOUGLAS_FIR = createLeaves("wood/leaves/douglas_fir", true);
//    public static final TFCLeavesBlock WOOD_LEAVES_HICKORY = createLeaves("wood/leaves/hickory", true);
//    public static final TFCLeavesBlock WOOD_LEAVES_KAPOK = createLeaves("wood/leaves/kapok", true);
//    public static final TFCLeavesBlock WOOD_LEAVES_MAPLE = createLeaves("wood/leaves/maple", true);
//    public static final TFCLeavesBlock WOOD_LEAVES_OAK = createLeaves("wood/leaves/oak", true);
//    public static final TFCLeavesBlock WOOD_LEAVES_PALM = createLeaves("wood/leaves/palm", true);
//    public static final TFCLeavesBlock WOOD_LEAVES_PINE = createLeaves("wood/leaves/pine", true);
//    public static final TFCLeavesBlock WOOD_LEAVES_ROSEWOOD = createLeaves("wood/leaves/rosewood", true);
//    public static final TFCLeavesBlock WOOD_LEAVES_SEQUOIA = createLeaves("wood/leaves/sequoia", true);
//    public static final TFCLeavesBlock WOOD_LEAVES_SPRUCE = createLeaves("wood/leaves/spruce", true);
//    //Logs
//    public static final TFCLog WOOD_LOG_ACACIA = createLog("wood/log/acacia", true);
//    public static final TFCLog WOOD_LOG_ASH = createLog("wood/log/ash", true);
//    public static final TFCLog WOOD_LOG_ASPEN = createLog("wood/log/aspen", true);
//    public static final TFCLog WOOD_LOG_BIRCH = createLog("wood/log/birch", true);
//    public static final TFCLog WOOD_LOG_BLACKWOOD = createLog("wood/log/blackwood", true);
//    public static final TFCLog WOOD_LOG_CHESTNUT = createLog("wood/log/chestnut", true);
//    public static final TFCLog WOOD_LOG_DOUGLAS_FIR = createLog("wood/log/douglas_fir", true);
//    public static final TFCLog WOOD_LOG_HICKORY = createLog("wood/log/hickory", true);
//    public static final TFCLog WOOD_LOG_KAPOK = createLog("wood/log/kapok", true);
//    public static final TFCLog WOOD_LOG_MAPLE = createLog("wood/log/maple", true);
//    public static final TFCLog WOOD_LOG_OAK = createLog("wood/log/oak", true);
//    public static final TFCLog WOOD_LOG_PALM = createLog("wood/log/palm", true);
//    public static final TFCLog WOOD_LOG_PINE = createLog("wood/log/pine", true);
//    public static final TFCLog WOOD_LOG_ROSEWOOD = createLog("wood/log/rosewood", true);
//    public static final TFCLog WOOD_LOG_SEQUOIA = createLog("wood/log/sequoia", true);
//    public static final TFCLog WOOD_LOG_SPRUCE = createLog("wood/log/spruce", true);
//    public static final TFCLog WOOD_LOG_SYCAMORE = createLog("wood/log/sycamore", true);
//    public static final TFCLog WOOD_LOG_WHITE_CEDAR = createLog("wood/log/white_cedar", true);
//    public static final TFCLog WOOD_LOG_WILLOW = createLog("wood/log/willow", true);
//    //Stripped logs
//    public static final TFCLog WOOD_STRIPPED_LOG_ACACIA = createStrippedLog("wood/stripped_log/acacia", MapColor.RED, true);
//    public static final TFCLog WOOD_STRIPPED_LOG_ASH = createStrippedLog("wood/stripped_log/ash", MapColor.BRIGHT_RED, true);
//    public static final TFCLog WOOD_STRIPPED_LOG_ASPEN = createStrippedLog("wood/stripped_log/aspen", MapColor.LICHEN_GREEN, true);
//    public static final TFCLog WOOD_STRIPPED_LOG_BIRCH = createStrippedLog("wood/stripped_log/birch", MapColor.PALE_YELLOW, true);
//    public static final TFCLog WOOD_STRIPPED_LOG_BLACKWOOD = createStrippedLog("wood/stripped_log/blackwood", MapColor.BLACK, true);
//    public static final TFCLog WOOD_STRIPPED_LOG_CHESTNUT = createStrippedLog("wood/stripped_log/chestnut", MapColor.WHITE, true);
//    public static final TFCLog WOOD_STRIPPED_LOG_DOUGLAS_FIR = createStrippedLog("wood/stripped_log/douglas_fir", MapColor.WHITE, true);
//    public static final TFCLog WOOD_STRIPPED_LOG_HICKORY = createStrippedLog("wood/stripped_log/hickory", MapColor.WHITE, true);
//    public static final TFCLog WOOD_STRIPPED_LOG_KAPOK = createStrippedLog("wood/stripped_log/kapok", MapColor.WHITE, true);
//    public static final TFCLog WOOD_STRIPPED_LOG_MAPLE = createStrippedLog("wood/stripped_log/maple", MapColor.WHITE, true);
//    public static final TFCLog WOOD_STRIPPED_LOG_OAK = createStrippedLog("wood/stripped_log/oak", MapColor.WHITE, true);
//    public static final TFCLog WOOD_STRIPPED_LOG_PALM = createStrippedLog("wood/stripped_log/palm", MapColor.WHITE, true);
//    public static final TFCLog WOOD_STRIPPED_LOG_PINE = createStrippedLog("wood/stripped_log/pine", MapColor.WHITE, true);
//    public static final TFCLog WOOD_STRIPPED_LOG_ROSEWOOD = createStrippedLog("wood/stripped_log/rosewood", MapColor.WHITE, true);
//    public static final TFCLog WOOD_STRIPPED_LOG_SEQUOIA = createStrippedLog("wood/stripped_log/sequoia", MapColor.WHITE, true);
//    public static final TFCLog WOOD_STRIPPED_LOG_SPRUCE = createStrippedLog("wood/stripped_log/spruce", MapColor.WHITE, true);
//    public static final TFCLog WOOD_STRIPPED_LOG_SYCAMORE = createStrippedLog("wood/stripped_log/sycamore", MapColor.WHITE, true);
//    public static final TFCLog WOOD_STRIPPED_LOG_WHITE_CEDAR = createStrippedLog("wood/stripped_log/white_cedar", MapColor.WHITE, true);
//    public static final TFCLog WOOD_STRIPPED_LOG_WILLOW = createStrippedLog("wood/stripped_log/willow", MapColor.WHITE, true);

    //Saplings
    //TODO Make generic trees to register saplings.
//    public static final SaplingBlock WOOD_SAPLING_ACACIA = createSapling("wood/sapling/acacia", true);
//    public static final SaplingBlock WOOD_SAPLING_ASH = createSapling("wood/sapling/ash", true);
//    public static final SaplingBlock WOOD_SAPLING_ASPEN = createSapling("wood/sapling/aspen", true);
//    public static final SaplingBlock WOOD_SAPLING_BIRCH = createSapling("wood/sapling/birch", true);
//    public static final SaplingBlock WOOD_SAPLING_BLACKWOOD = createSapling("wood/sapling/blackwood", true);
//    public static final SaplingBlock WOOD_SAPLING_CHESTNUT = createSapling("wood/sapling/chestnut", true);
//    public static final SaplingBlock WOOD_SAPLING_DOUGLAS_FIR = createSapling("wood/sapling/douglas_fir", new DouglasFirSaplingGenerator(), true)
//    public static final SaplingBlock WOOD_SAPLING_HICKORY = createSapling("wood/sapling/hickory", true);
//    public static final SaplingBlock WOOD_SAPLING_KAPOK = createSapling("wood/sapling/kapok", true);
//    public static final SaplingBlock WOOD_SAPLING_MAPLE = createSapling("wood/sapling/maple", true);
//    public static final SaplingBlock WOOD_SAPLING_OAK = createSapling("wood/sapling/oak", true);
//    public static final SaplingBlock WOOD_SAPLING_PALM = createSapling("wood/sapling/palm", true);
//    public static final SaplingBlock WOOD_SAPLING_PINE = createSapling("wood/sapling/pine", true);
//    public static final SaplingBlock WOOD_SAPLING_ROSEWOOD = createSapling("wood/sapling/rosewood", true);
//    public static final SaplingBlock WOOD_SAPLING_SEQUOIA = createSapling("wood/sapling/sequoia", true);
//    public static final SaplingBlock WOOD_SAPLING_SPRUCE = createSapling("wood/sapling/spruce", true);
//    public static final SaplingBlock WOOD_SAPLING_SYCAMORE = createSapling("wood/sapling/sycamore", true);
//    public static final SaplingBlock WOOD_SAPLING_WHITE_CEDAR = createSapling("wood/sapling/white_cedar", true);
//    public static final SaplingBlock WOOD_SAPLING_WILLOW = createSapling("wood/sapling/willow", true);


    //Block Entities
    public static final BlockEntityType<RockBlockEntity> ROCK_BLOCK_ENTITY = register("rock_block_entity", FabricBlockEntityTypeBuilder.create(RockBlockEntity::new, TFCObjects.ROCK_BLOCK).build(null));

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
        var block = new TFCLeaves(FabricBlockSettings.of(Material.LEAVES).breakByTool(FabricToolTags.HOES).sounds(BlockSoundGroup.SLIME).strength(2.0f));
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


    public static Block createRock(String id, boolean hasBlockItem) {
        //TODO Fix material settings
        var block = new Block(FabricBlockSettings.of(Material.WOOD).breakByTool(FabricToolTags.AXES).sounds(BlockSoundGroup.WOOD).strength(2.0f));
        register(id, block, hasBlockItem, TerraFabriCraft.ROCK_GROUP);
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
        var block = new TFCGravityBlock(FabricBlockSettings.of(Material.LEAVES).breakByTool(FabricToolTags.HOES).sounds(BlockSoundGroup.SLIME).strength(2.0f));
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
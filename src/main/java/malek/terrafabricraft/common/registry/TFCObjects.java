package malek.terrafabricraft.common.registry;

import malek.terrafabricraft.TerraFabriCraft;
import malek.terrafabricraft.common.block.*;
import malek.terrafabricraft.common.block.entity.RockBlockEntity;
import malek.terrafabricraft.common.item.GroundCoverOreBlockItem;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.LinkedHashMap;
import java.util.Map;

public class TFCObjects {
    public static final Map<Block, Identifier> BLOCKS = new LinkedHashMap<>();
    private static final Map<BlockEntityType<?>, Identifier> BLOCK_ENTITY_TYPES = new LinkedHashMap<>();
    private static final Map<Item, Identifier> ITEMS = new LinkedHashMap<>();

    //Clay
    public static final Block CLAY_LOAM = createSand("clay/loam", true);
    public static final Block CLAY_SANDY_LOAM = createSand("clay/sandy_loam", true);
    public static final Block CLAY_SILT = createSand("clay/silt", true);
    public static final Block CLAY_SILTY_LOAM = createSand("clay/silty_loam", true);
    //Dirt
    public static final TFCGravityBlock DIRT_SILT = createSand("dirt/silt", true);
    public static final TFCGravityBlock DIRT_SILTY_LOAM = createSand("dirt/silty_loam", true);
    public static final TFCGravityBlock DIRT_LOAM = createSand("dirt/loam", true);
    public static final TFCGravityBlock DIRT_SANDY_LOAM = createSand("dirt/sandy_loam", true);
    public static final TFCGravityBlock PEAT = createSand("peat", true);
    //Farmland
    public static final Block FARMLAND_LOAM = createFarmland("farmland/loam", true);
    public static final Block FARMLAND_SANDY_LOAM = createFarmland("farmland/sandy_loam", true);
    public static final Block FARMLAND_SILT = createFarmland("farmland/silt", true);
    public static final Block FARMLAND_SILTY_LOAM = createFarmland("farmland/silty_loam", true);
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
    public static final Block ORE_SMALL_BISMUTHINITE = createGroundOre("ore/small_bismuthinite", true, 271);
    public static final Block ORE_SMALL_CASSITERITE = createGroundOre("ore/small_cassiterite", true, 232);
    public static final Block ORE_SMALL_GARNIERITE = createGroundOre("ore/small_garnierite", true, 1455);
    public static final Block ORE_SMALL_HEMATITE = createGroundOre("ore/small_hematite", true, 1538);
    public static final Block ORE_SMALL_LIMONITE = createGroundOre("ore/small_limonite", true, 1538);
    public static final Block ORE_SMALL_MAGNETITE = createGroundOre("ore/small_magnetite", true, 1538);
    public static final Block ORE_SMALL_MALACHITE = createGroundOre("ore/small_malachite", true, 1085);
    public static final Block ORE_SMALL_NATIVE_COPPPER = createGroundOre("ore/small_native_copper", true, 1085);
    public static final Block ORE_SMALL_NATIVE_GOLD = createGroundOre("ore/small_native_gold", true, 1064);
    public static final Block ORE_SMALL_NATIVE_SILVER = createGroundOre("ore/small_native_silver", true, 961);
    public static final Block ORE_SMALL_SPHALERITE = createGroundOre("ore/small_sphalerite", true, 1085);
    public static final Block ORE_SMALL_TETRAHEDRITE = createGroundOre("ore/small_tetrahedrite", true, 1085);
    //Ore
    /*public static final Block ORE_AMETHYST_ANDESITE = createRock("ore/amethyst/andesite", true);
    public static final Block ORE_AMETHYST_BASALT = createRock("ore/amethyst/basalt", true);
    public static final Block ORE_AMETHYST_CHALK = createRock("ore/amethyst/chalk", true);
    public static final Block ORE_AMETHYST_CHERT = createRock("ore/amethyst/chert", true);
    public static final Block ORE_AMETHYST_CLAYSTONE = createRock("ore/amethyst/claystone", true);
    public static final Block ORE_AMETHYST_CONGLOMERATE = createRock("ore/amethyst/conglomerate", true);
    public static final Block ORE_AMETHYST_DACITE = createRock("ore/amethyst/dacite", true);
    public static final Block ORE_AMETHYST_DIORITE = createRock("ore/amethyst/diorite", true);
    public static final Block ORE_AMETHYST_DOLOMITE = createRock("ore/amethyst/dolomite", true);
    public static final Block ORE_AMETHYST_GABBRO = createRock("ore/amethyst/gabbro", true);
    public static final Block ORE_AMETHYST_GNEISS = createRock("ore/amethyst/gneiss", true);
    public static final Block ORE_AMETHYST_GRANITE = createRock("ore/amethyst/granite", true);
    public static final Block ORE_AMETHYST_LIMESTONE = createRock("ore/amethyst/limestone", true);
    public static final Block ORE_AMETHYST_MARBLE = createRock("ore/amethyst/marble", true);
    public static final Block ORE_AMETHYST_PHYLLITE = createRock("ore/amethyst/phyllite", true);
    public static final Block ORE_AMETHYST_QUARTZITE = createRock("ore/amethyst/quartzite", true);
    public static final Block ORE_AMETHYST_RHYOLITE = createRock("ore/amethyst/rhyolite", true);
    public static final Block ORE_AMETHYST_SCHIST = createRock("ore/amethyst/schist", true);
    public static final Block ORE_AMETHYST_SHALE = createRock("ore/amethyst/shale", true);
    public static final Block ORE_AMETHYST_SLATE = createRock("ore/amethyst/slate", true);*/
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
    //Leaves
    public static final TFCLeavesBlock WOOD_LEAVES_ACACIA = createLeaves("wood/leaves/acacia", true);
    public static final TFCLeavesBlock WOOD_LEAVES_ASH = createLeaves("wood/leaves/ash", true);
    public static final TFCLeavesBlock WOOD_LEAVES_ASPEN = createLeaves("wood/leaves/aspen", true);
    public static final TFCLeavesBlock WOOD_LEAVES_BIRCH = createLeaves("wood/leaves/birch", true);
    public static final TFCLeavesBlock WOOD_LEAVES_BLACKWOOD = createLeaves("wood/leaves/blackwood", true);
    public static final TFCLeavesBlock WOOD_LEAVES_CHESTNUT = createLeaves("wood/leaves/chestnut", true);
    public static final TFCLeavesBlock WOOD_LEAVES_DOUGLAS_FIR = createLeaves("wood/leaves/douglas_fir", true);
    public static final TFCLeavesBlock WOOD_LEAVES_HICKORY = createLeaves("wood/leaves/hickory", true);
    public static final TFCLeavesBlock WOOD_LEAVES_KAPOK = createLeaves("wood/leaves/kapok", true);
    public static final TFCLeavesBlock WOOD_LEAVES_MAPLE = createLeaves("wood/leaves/maple", true);
    public static final TFCLeavesBlock WOOD_LEAVES_OAK = createLeaves("wood/leaves/oak", true);
    public static final TFCLeavesBlock WOOD_LEAVES_PALM = createLeaves("wood/leaves/palm", true);
    public static final TFCLeavesBlock WOOD_LEAVES_PINE = createLeaves("wood/leaves/pine", true);
    public static final TFCLeavesBlock WOOD_LEAVES_ROSEWOOD = createLeaves("wood/leaves/rosewood", true);
    public static final TFCLeavesBlock WOOD_LEAVES_SEQUOIA = createLeaves("wood/leaves/sequoia", true);
    public static final TFCLeavesBlock WOOD_LEAVES_SPRUCE = createLeaves("wood/leaves/spruce", true);

    //Logs
    public static final TFCLogs WOOD_LOG_ACACIA = createLog("wood/log/acacia", true);
    public static final TFCLogs WOOD_LOG_ASH = createLog("wood/log/ash", true);
    public static final TFCLogs WOOD_LOG_ASPEN = createLog("wood/log/aspen", true);
    public static final TFCLogs WOOD_LOG_BIRCH = createLog("wood/log/birch", true);
    public static final TFCLogs WOOD_LOG_BLACKWOOD = createLog("wood/log/blackwood", true);
    public static final TFCLogs WOOD_LOG_CHESTNUT = createLog("wood/log/chestnut", true);
    public static final TFCLogs WOOD_LOG_DOUGLAS_FIR = createLog("wood/log/douglas_fir", true);
    public static final TFCLogs WOOD_LOG_HICKORY = createLog("wood/log/hickory", true);
    public static final TFCLogs WOOD_LOG_KAPOK = createLog("wood/log/kapok", true);
    public static final TFCLogs WOOD_LOG_MAPLE = createLog("wood/log/maple", true);
    public static final TFCLogs WOOD_LOG_OAK = createLog("wood/log/oak", true);
    public static final TFCLogs WOOD_LOG_PALM = createLog("wood/log/palm", true);
    public static final TFCLogs WOOD_LOG_PINE = createLog("wood/log/pine", true);
    public static final TFCLogs WOOD_LOG_ROSEWOOD = createLog("wood/log/rosewood", true);
    public static final TFCLogs WOOD_LOG_SEQUOIA = createLog("wood/log/sequoia", true);
    public static final TFCLogs WOOD_LOG_SPRUCE = createLog("wood/log/spruce", true);
    public static final TFCLogs WOOD_LOG_SYCAMORE = createLog("wood/log/sycamore", true);
    public static final TFCLogs WOOD_LOG_WHITE_CEDAR = createLog("wood/log/white_cedar", true);
    public static final TFCLogs WOOD_LOG_WILLOW = createLog("wood/log/willow", true);
    //Stripped logs
    public static final TFCLogs WOOD_STRIPPED_LOG_ACACIA = createStrippedLog("wood/stripped_log/acacia", MapColor.RED, true);
    public static final TFCLogs WOOD_STRIPPED_LOG_ASH = createStrippedLog("wood/stripped_log/ash", MapColor.BRIGHT_RED, true);
    public static final TFCLogs WOOD_STRIPPED_LOG_ASPEN = createStrippedLog("wood/stripped_log/aspen", MapColor.LICHEN_GREEN, true);
    public static final TFCLogs WOOD_STRIPPED_LOG_BIRCH = createStrippedLog("wood/stripped_log/birch", MapColor.PALE_YELLOW, true);
    public static final TFCLogs WOOD_STRIPPED_LOG_BLACKWOOD = createStrippedLog("wood/stripped_log/blackwood", MapColor.BLACK, true);
    public static final TFCLogs WOOD_STRIPPED_LOG_CHESTNUT = createStrippedLog("wood/stripped_log/chestnut", MapColor.WHITE, true);
    public static final TFCLogs WOOD_STRIPPED_LOG_DOUGLAS_FIR = createStrippedLog("wood/stripped_log/douglas_fir", MapColor.WHITE, true);
    public static final TFCLogs WOOD_STRIPPED_LOG_HICKORY = createStrippedLog("wood/stripped_log/hickory", MapColor.WHITE, true);
    public static final TFCLogs WOOD_STRIPPED_LOG_KAPOK = createStrippedLog("wood/stripped_log/kapok", MapColor.WHITE, true);
    public static final TFCLogs WOOD_STRIPPED_LOG_MAPLE = createStrippedLog("wood/stripped_log/maple", MapColor.WHITE, true);
    public static final TFCLogs WOOD_STRIPPED_LOG_OAK = createStrippedLog("wood/stripped_log/oak", MapColor.WHITE, true);
    public static final TFCLogs WOOD_STRIPPED_LOG_PALM = createStrippedLog("wood/stripped_log/palm", MapColor.WHITE, true);
    public static final TFCLogs WOOD_STRIPPED_LOG_PINE = createStrippedLog("wood/stripped_log/pine", MapColor.WHITE, true);
    public static final TFCLogs WOOD_STRIPPED_LOG_ROSEWOOD = createStrippedLog("wood/stripped_log/rosewood", MapColor.WHITE, true);
    public static final TFCLogs WOOD_STRIPPED_LOG_SEQUOIA = createStrippedLog("wood/stripped_log/sequoia", MapColor.WHITE, true);
    public static final TFCLogs WOOD_STRIPPED_LOG_SPRUCE = createStrippedLog("wood/stripped_log/spruce", MapColor.WHITE, true);
    public static final TFCLogs WOOD_STRIPPED_LOG_SYCAMORE = createStrippedLog("wood/stripped_log/sycamore", MapColor.WHITE, true);
    public static final TFCLogs WOOD_STRIPPED_LOG_WHITE_CEDAR = createStrippedLog("wood/stripped_log/white_cedar", MapColor.WHITE, true);
    public static final TFCLogs WOOD_STRIPPED_LOG_WILLOW = createStrippedLog("wood/stripped_log/willow", MapColor.WHITE, true);

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

    //Saplings
    //Todo Make generic trees to register saplings.
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

    public static <T extends Block> T register(String id, T block, boolean hasItem) {
        BLOCKS.put(block, new Identifier(TerraFabriCraft.MODID, id));
        if (hasItem) {
            ITEMS.put(new BlockItem(block, gen()), BLOCKS.get(block));
        }
        return block;
    }

    public static <T extends Block> T register(String id, T block, Item itemId) {
        BLOCKS.put(block, new Identifier(TerraFabriCraft.MODID, id));
        return block;
    }

    public static TFCLeavesBlock createLeaves(String id, boolean hasItem) {
        var block = new TFCLeavesBlock(FabricBlockSettings.of(Material.LEAVES).breakByTool(FabricToolTags.HOES).sounds(BlockSoundGroup.SLIME).strength(2.0f));
        register(id, block, hasItem);
        return block;
    }

    public static TFCLogs createLog(String id, boolean hasItem) {
        var block = new TFCLogs(FabricBlockSettings.of(Material.WOOD).breakByTool(FabricToolTags.AXES).sounds(BlockSoundGroup.WOOD).strength(2.0f));
        register(id, block, hasItem);
        return block;
    }

    public static TFCSaplingBlock createSapling(String id, boolean hasItem, SaplingGenerator generator) {
        //TODO Give leaves an appropriate sound.
        var block = new TFCSaplingBlock(generator, FabricBlockSettings.of(Material.LEAVES).breakByTool(FabricToolTags.HOES).sounds(BlockSoundGroup.SLIME).strength(2.0f));
        register(id, block, hasItem);
        return block;
    }

    public static TFCLogs createStrippedLog(String id, MapColor color, boolean hasItem) {
        var block = new TFCLogs(FabricBlockSettings.of(Material.WOOD, color).breakByTool(FabricToolTags.AXES).sounds(BlockSoundGroup.WOOD).strength(2.0f));
        register(id, block, hasItem);
        return block;
    }

    public static Block createRock(String id, boolean hasItem) {
        var block = new Block(FabricBlockSettings.of(Material.WOOD).breakByTool(FabricToolTags.AXES).sounds(BlockSoundGroup.WOOD).strength(2.0f));
        register(id, block, hasItem);
        return block;
    }

    public static Block createGroundOre(String id, boolean hasItem, int meltingPoint) {
        var block = new GroundCoverOre(FabricBlockSettings.of(Material.WOOD).breakByTool(FabricToolTags.AXES).sounds(BlockSoundGroup.WOOD).strength(2.0f));
        createItem(id, new GroundCoverOreBlockItem(block, gen(), meltingPoint));
        register(id, block, false);
        return block;
    }

    public static TFCGravityBlock createSand(String id, boolean hasItem) {
        var block = new TFCGravityBlock(FabricBlockSettings.of(Material.LEAVES).breakByTool(FabricToolTags.HOES).sounds(BlockSoundGroup.SLIME).strength(2.0f));
        register(id, block, hasItem);
        return block;
    }

    public static TFCGravityBlock createFarmland(String id, boolean hasItem) {
        var block = new TFCGravityBlock(FabricBlockSettings.of(Material.LEAVES).breakByTool(FabricToolTags.HOES).sounds(BlockSoundGroup.SLIME).strength(2.0f));
        register(id, block, hasItem);
        return block;
    }

    public static GroundCoverBlock createGroundcover(String id, Item dropId) {
        var block = new GroundCoverBlock(FabricBlockSettings.of(Material.STONE).breakByTool(FabricToolTags.PICKAXES).strength(6.0f));
        register(id, block, dropId);
        return block;
    }

    public static GroundCoverBlock createGroundcover(String id) {
        var block = new GroundCoverBlock(FabricBlockSettings.of(Material.STONE).breakByTool(FabricToolTags.PICKAXES).strength(6.0f));
        register(id, block, true);
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

    private static Item.Settings gen() {
        return new Item.Settings().group(TerraFabriCraft.TERRAFABRICRAFT_GROUP);
    }

    public static void init() {
        BLOCKS.keySet().forEach(block -> Registry.register(Registry.BLOCK, BLOCKS.get(block), block));
        BLOCK_ENTITY_TYPES.keySet().forEach(blockEntityType -> Registry.register(Registry.BLOCK_ENTITY_TYPE, BLOCK_ENTITY_TYPES.get(blockEntityType), blockEntityType));
        ITEMS.keySet().forEach(item -> Registry.register(Registry.ITEM, ITEMS.get(item), item));
    }
}
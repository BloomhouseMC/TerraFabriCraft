package com.bloomhousemc.terrafabricraft.common.registry;

import com.bloomhousemc.terrafabricraft.common.block.*;
import com.bloomhousemc.terrafabricraft.common.block.anvil.TfcAnvil;
import com.bloomhousemc.terrafabricraft.common.block.bellows.BellowsBlock;
import com.bloomhousemc.terrafabricraft.common.block.forge.Forge;
import com.bloomhousemc.terrafabricraft.common.block.keg.Keg;
import com.bloomhousemc.terrafabricraft.common.block.logpile.LogPile;
import com.bloomhousemc.terrafabricraft.common.block.placeable.PlaceableBlock;
import com.bloomhousemc.terrafabricraft.common.block.plant.TfcGrassPlantBlock;
import com.bloomhousemc.terrafabricraft.common.block.plant.TfcCropBlock;
import com.bloomhousemc.terrafabricraft.common.block.plant.TfcTallCropBlock;
import com.bloomhousemc.terrafabricraft.common.block.plant.TfcWaterPlantBlock;
import com.bloomhousemc.terrafabricraft.common.block.toolrack.ToolRackBlock;
import com.bloomhousemc.terrafabricraft.common.item.GroundCoverOreBlockItem;
import com.bloomhousemc.terrafabricraft.common.item.TfcLogItem;
import com.bloomhousemc.terrafabricraft.common.item.TfcSupportItem;
import com.bloomhousemc.terrafabricraft.common.registry.util.CoralBlock;
import com.bloomhousemc.terrafabricraft.common.registry.util.*;
import com.bloomhousemc.terrafabricraft.common.world.generator.tree.GenericSaplingGenerator;
import com.bloomhousemc.terrafabricraft.common.world.generator.tree.KapokSaplingGenerator;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Items;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static com.bloomhousemc.terrafabricraft.TerraFabriCraft.MODID;
import static com.bloomhousemc.terrafabricraft.common.registry.TfcFeatures.*;
import static com.bloomhousemc.terrafabricraft.common.registry.TfcItemGroups.*;
import static net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings.copyOf;

@SuppressWarnings("unused")
public final class TfcBlocks {
    public static final TfcFarmlandBlock FARMLAND_LOAM = createFarmland("farmland/loam");
    public static final TfcFarmlandBlock FARMLAND_SANDY_LOAM = createFarmland("farmland/sandy_loam");
    public static final TfcFarmlandBlock FARMLAND_SILT = createFarmland("farmland/silt");
    public static final TfcFarmlandBlock FARMLAND_SILTY_LOAM = createFarmland("farmland/silty_loam");
    public static final SoilBlock GRASS = new SoilBlock("grass", BlockSoundGroup.GRASS);

    public static final CoralBlock CORAL_BRAIN = new CoralBlock("coral/brain");
    public static final CoralBlock CORAL_BUBBLE = new CoralBlock("coral/bubble");
    public static final CoralBlock CORAL_FIRE = new CoralBlock("coral/fire");
    public static final CoralBlock CORAL_HORN = new CoralBlock("coral/horn");
    public static final CoralBlock CORAL_TUBE = new CoralBlock("coral/tube");

//    public static final Block BARLEY_CROP = createCrop("barley_crop", 0, 1, false, TfcItems.BARLEY_SEED, 9);

    public static final SoilBlock CLAY = new SoilBlock("clay", BlockSoundGroup.GRAVEL);
//    public static final TFCFood MILK = new TFCFood("barley_bread", new FabricItemSettings(), 1, 1);
    public static final SoilBlock CLAY_GRASS = new SoilBlock("clay_grass", BlockSoundGroup.GRAVEL);
    public static final SoilBlock DIRT = new SoilBlock("dirt", BlockSoundGroup.GRAVEL);
    public static final SoilBlock GRASS_PATH = new SoilBlock("grass_path", BlockSoundGroup.GRASS);
    public static final Block ALABASTER_RAW_ALABASTER = createRock("alabaster/raw/alabaster", DECORATIONS_GROUP);
    public static final Block ALABASTER_RAW_ALABASTER_BRICKS = createRock("alabaster/raw/alabaster_bricks", DECORATIONS_GROUP);
    public static final Block ALABASTER_RAW_POLISHED_ALABASTER = createRock("alabaster/raw/polished_alabaster", DECORATIONS_GROUP);
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

    public static final TfcAnvil METAL_ANVIL_BISMUTH_BRONZE = createAnvil("bismuth_bronze");
    public static final TfcAnvil METAL_ANVIL_BLACK_BRONZE = createAnvil("black_bronze");
    public static final TfcAnvil METAL_ANVIL_BLACK_STEEL = createAnvil("black_steel");
    public static final TfcAnvil METAL_ANVIL_BLUE_STEEL = createAnvil("blue_steel");
    public static final TfcAnvil METAL_ANVIL_BRONZE = createAnvil("bronze");
    public static final TfcAnvil METAL_ANVIL_COPPER = createAnvil("copper");
    public static final TfcAnvil METAL_ANVIL_RED_STEEL = createAnvil("red_steel");
    public static final TfcAnvil METAL_ANVIL_STEEL = createAnvil("steel");
    public static final TfcAnvil METAL_ANVIL_WROUGHT_IRON = createAnvil("wrought_iron");
    public static final TfcGroundCoverBlock GROUNDCOVER_BONE = createGroundcover("groundcover/bone", Items.BONE);
    public static final TfcGroundCoverBlock GROUNDCOVER_DEAD_GRASS = createGroundcover("groundcover/dead_grass");
    public static final TfcGroundCoverBlock GROUNDCOVER_DRIFTWOOD = createGroundcover("groundcover/driftwood");
    public static final TfcGroundCoverBlock GROUNDCOVER_FEATHER = createGroundcover("groundcover/feather", Items.FEATHER);
    public static final TfcGroundCoverBlock GROUNDCOVER_GUANO = createGroundcover("groundcover/guano");
    public static final TfcGroundCoverBlock GROUNDCOVER_MOLLUSK = createGroundcover("groundcover/mollusk");
    public static final TfcGroundCoverBlock GROUNDCOVER_MUSSEL = createGroundcover("groundcover/mussel");
    public static final TfcGroundCoverBlock GROUNDCOVER_PINECONE = createGroundcover("groundcover/pinecone");
    public static final TfcGroundCoverBlock GROUNDCOVER_PODZOL = createGroundcover("groundcover/podzol", Items.PODZOL);
    public static final TfcGroundCoverBlock GROUNDCOVER_ROTTEN_FLESH = createGroundcover("groundcover/rotten_flesh", Items.ROTTEN_FLESH);
    public static final TfcGroundCoverBlock GROUNDCOVER_SALT_LICK = createGroundcover("groundcover/seaweed");
    public static final TfcGroundCoverBlock GROUNDCOVER_STICK = createGroundcover("groundcover/stick", Items.STICK);
    //Stone
    //Sample rock class :-)
    public static final Block ROCK_BLOCK = createRock("rock_block", EARTH_GROUP);
    public static final LanternBlock METAL_LAMP_BISMUTH_BRONZE = createLamp("bismuth_bronze");
    public static final LanternBlock METAL_LAMP_BLACK_BRONZE = createLamp("black_bronze");
    public static final LanternBlock METAL_LAMP_BLACK_STEEL = createLamp("black_steel");
    public static final LanternBlock METAL_LAMP_BLUE_STEEL = createLamp("blue_steel");
    public static final LanternBlock METAL_LAMP_BRONZE = createLamp("bronze");
    public static final LanternBlock METAL_LAMP_COPPER = createLamp("copper");
    public static final LanternBlock METAL_LAMP_RED_STEEL = createLamp("red_steel");
    public static final LanternBlock METAL_LAMP_STEEL = createLamp("steel");
    public static final LanternBlock METAL_LAMP_WROUGHT_IRON = createLamp("wrought_iron");
    public static final Block ORE_SMALL_BISMUTHINITE = createGroundOre("ore/small_bismuthinite", 271);
    public static final Block ORE_SMALL_CASSITERITE = createGroundOre("ore/small_cassiterite", 232);
    public static final Block ORE_SMALL_GARNIERITE = createGroundOre("ore/small_garnierite", 1455);
    public static final Block ORE_SMALL_HEMATITE = createGroundOre("ore/small_hematite", 1538);
    public static final Block ORE_SMALL_LIMONITE = createGroundOre("ore/small_limonite", 1538);
    public static final Block ORE_SMALL_MAGNETITE = createGroundOre("ore/small_magnetite", 1538);
    public static final Block ORE_SMALL_MALACHITE = createGroundOre("ore/small_malachite", 1085);
    public static final Block ORE_SMALL_NATIVE_COPPPER = createGroundOre("ore/small_native_copper", 1085);
    public static final Block ORE_SMALL_NATIVE_GOLD = createGroundOre("ore/small_native_gold", 1064);
    public static final Block ORE_SMALL_NATIVE_SILVER = createGroundOre("ore/small_native_silver", 961);
    public static final Block ORE_SMALL_SPHALERITE = createGroundOre("ore/small_sphalerite", 1085);
    public static final Block ORE_SMALL_TETRAHEDRITE = createGroundOre("ore/small_tetrahedrite", 1085);
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

//    public static final Block CABBAGE_CROP = createCrop("cabbage_crop", 0, 1, false, TfcItems.CABBAGE_SEED, 7);
//    public static final Block CARROT_CROP = createCrop("carrot_crop", 0, 1, false, TfcItems.CARROT_SEED, 6);
//    public static final Block GARLIC_CROP = createCrop("garlic_crop", 0, 1, false, TfcItems.GARLIC_SEED, 6);
//    public static final Block GREENBEAN_CROP = createCrop("greenbean_crop", 0, 1, false, TfcItems.GREENBEAN_SEED, 8);
//    public static final Block JUTE_CROP = createCrop("jute_crop", 0, 1, true, TfcItems.JUTE_SEED, 7);
//    public static final Block MAIZE_CROP = createCrop("maize_crop", 0, 1, true, TfcItems.MAIZE_SEED, 7);
//    public static final Block OAT_CROP = createCrop("oat_crop", 0, 1, false, TfcItems.OAT_SEED, 9);
//    public static final Block ONION_CROP = createCrop("onion_crop", 0, 1, false, TfcItems.ONION_SEED, 8);
//    public static final Block POTATO_CROP = createCrop("potato_crop", 0, 1, false, TfcItems.POTATO_SEED, 8);
//    public static final Block RED_BELL_PEPPER_CROP = createCrop("red_bell_pepper_crop", 0, 1, false, TfcItems.RED_BELL_PEPPER_SEED, 8);
//    public static final Block RICE_CROP = createCrop("rice_crop", 0, 1, false, TfcItems.RICE_SEED, 9);
//    public static final Block RUTABAGA_CROP = createCrop("rutabaga_crop", 0, 1, false, TfcItems.RUTABAGA_SEED, 9);
//    public static final Block RYE_CROP = createCrop("rye_crop", 0, 1, false, TfcItems.RYE_SEED, 9);
//    public static final Block SOYBEAN_CROP = createCrop("soybean_crop", 0, 1, false, TfcItems.SOYBEAN_SEED, 8);
//    public static final Block SQUASH_CROP = createCrop("squash_crop", 0, 1, false, TfcItems.SQUASH_SEED, 9);
//    public static final Block TOMATO_CROP = createCrop("tomato_crop", 0, 1, false, TfcItems.TOMATO_SEED, 9);
//    public static final Block WHEAT_CROP = createCrop("wheat_crop", 0, 1, false, TfcItems.WHEAT_SEED, 9);
//    public static final Block YELLOW_BELL_PEPPER_CROP = createCrop("yellow_bell_pepper_crop", 0, 1, false, TfcItems.YELLOW_BELL_PEPPER_SEED, 8);

    public static final TfcGrassPlantBlock PLANT_ARUNDO = createGrassPlant("plant/arundo", 1, 1, 3);
    public static final TfcGrassPlantBlock PLANT_ATHYRIUM_FERN = createGrassPlant("plant/athyrium_fern", 1, 1, 1);
    //Badderlocks [dirt]
    public static final TfcGrassPlantBlock PLANT_BANANA_SAPLING = createGrassPlant("plant/banana_sapling", 1, 1, 1);
    public static final TfcGrassPlantBlock PLANT_BLACK_ORCHID = createGrassPlant("plant/black_orchid", 1, 1, 1);
    public static final TfcGrassPlantBlock PLANT_BLACKBERRY_BUSH = createGrassPlant("plant/blackberry_bush", 1, 1, 3);
    //Blackberry bush cane [side]
    public static final TfcGrassPlantBlock PLANT_BLOOD_LILY = createGrassPlant("plant/blood_lily", 1, 1, 3);
    public static final TfcGrassPlantBlock PLANT_BLUE_ORCHID = createGrassPlant("plant/blue_orchid", 1, 1, 3);
    public static final TfcGrassPlantBlock PLANT_BLUEBERRY_BUSH = createGrassPlant("plant/blueberry_bush", 1, 1, 3);
    public static final TfcGrassPlantBlock PLANT_BUNCHBERRY_BUSH = createGrassPlant("plant/bunchberry_bush", 1, 1, 3);
    public static final TfcGrassPlantBlock PLANT_BUTTERFLY_MILKWEED = createGrassPlant("plant/butterfly_milkweed", 1, 1, 3);
    public static final TfcGrassPlantBlock PLANT_CALENDULA = createGrassPlant("plant/calendula", 1, 1, 3);
    public static final TfcGrassPlantBlock PLANT_CANNA = createGrassPlant("plant/canna", 1, 1, 3);
    //Cattail [dirt]
    public static final TfcGrassPlantBlock PLANT_CHERRY_SAPLING = createGrassPlant("plant/cherry_sapling", 1, 1, 3);
    public static final TfcGrassPlantBlock PLANT_CLOUDBERRY_BUSH = createGrassPlant("plant/cloudberry_bush", 1, 1, 3);
    public static final TfcWaterPlantBlock PLANT_COONTAIL = createWaterPlant("plant/coontail");
    public static final TfcGrassPlantBlock PLANT_CRANBERRY_BUSH = createGrassPlant("plant/cranberry_bush", 1, 1, 3);
    public static final TfcGrassPlantBlock PLANT_DANDELION = createGrassPlant("plant/dandelion", 1, 1, 3);
    //Dead berry bush has no item
    //Dead cane has no item
    public static final TfcLilyPadBlock PLANT_DUCKWEED = createLilyPad("plant/duckweed");
    public static final TfcWaterPlantBlock PLANT_EEL_GRASS = createWaterPlant("plant/eel_grass");
    public static final TfcGrassPlantBlock PLANT_ELDERBERRY_BUSH = createGrassPlant("plant/elderberry_bush", 1, 1, 3);
    public static final TfcGrassPlantBlock PLANT_FIELD_HORSETAIL = createGrassPlant("plant/field_horsetail", 1, 1, 3);
    public static final TfcGrassPlantBlock PLANT_FOUNTAIN_GRASS = createGrassPlant("plant/fountain_grass", 1, 1, 3);
    public static final TfcGrassPlantBlock PLANT_FOXGLOVE = createGrassPlant("plant/foxglove", 1, 1, 3);
    public static final TfcWaterPlantBlock PLANT_GIANT_KELP_FLOWER = createWaterPlant("plant/giant_kelp_flower");
    //Giant kelp plant has no item
    public static final TfcGrassPlantBlock PLANT_GOLDENROD = createGrassPlant("plant/goldenrod", 1, 1, 3);
    public static final TfcGrassPlantBlock PLANT_GOOSEBERRY_BUSH = createGrassPlant("plant/gooseberry_bush", 1, 1, 3);
    public static final TfcGrassPlantBlock PLANT_GRAPE_HYACINTH = createGrassPlant("plant/grape_hyacinth", 1, 1, 3);
    public static final TfcGrassPlantBlock PLANT_GREEN_APPLE_SAPLING = createGrassPlant("plant/green_apple_sapling", 1, 1, 3);
    //Gutweed [nowhere]
    //Guzmania [nowhere]
    //Hanging vines [top]
    public static final TfcGrassPlantBlock PLANT_HOUSTONIA = createGrassPlant("plant/houstonia", 1, 1, 3);
    //Ivy [side]
    //Jungle vines [side]
    public static final TfcGrassPlantBlock PLANT_LABRADOR_TEA = createGrassPlant("plant/labrador_tea", 1, 1, 3);
    public static final TfcGrassPlantBlock PLANT_LADY_FERN = createGrassPlant("plant/lady_fern", 1, 1, 3);
    //Laminaria [nowhere]
    public static final TfcWaterPlantBlock PLANT_LEAFY_KELP = createWaterPlant("plant/leafy_kelp");
    public static final TfcGrassPlantBlock PLANT_LEMON_SAPLING = createGrassPlant("plant/lemon_sapling", 1, 1, 3);
    //Liana [top]
    //Licore plant [side]
    public static final TfcLilyPadBlock PLANT_LOTUS = createLilyPad("plant/lotus");
    public static final TfcWaterPlantBlock PLANT_MANATEE_GRASS = createWaterPlant("plant/manatee_grass");
    public static final TfcWaterPlantBlock PLANT_MARIGOLD = createWaterPlant("plant/marigold");
    public static final TfcGrassPlantBlock PLANT_MEADS_MILKWEED = createGrassPlant("plant/meads_milkweed", 1, 1, 3);
    public static final TfcGrassPlantBlock PLANT_MILFOIL = createGrassPlant("plant/milfoil", 1, 1, 3);
    //Morning glory [all sides]
    //Moss [all sides]
    public static final TfcGrassPlantBlock PLANT_NASTURTIUM = createGrassPlant("plant/nasturtium", 1, 1, 3);
    public static final TfcGrassPlantBlock PLANT_OLIVE_SAPLING = createGrassPlant("plant/olive_sapling", 1, 1, 3);
    public static final TfcGrassPlantBlock PLANT_ORANGE_SAPLING = createGrassPlant("plant/orange_sapling", 1, 1, 3);
    public static final TfcGrassPlantBlock PLANT_ORCHARD_GRASS = createGrassPlant("plant/orchard_grass", 1, 1, 3);
    public static final TfcGrassPlantBlock PLANT_OSTRICH_FERN = createGrassPlant("plant/ostrich_fern", 1, 1, 3);
    public static final TfcGrassPlantBlock PLANT_OXEYE_DAISY = createGrassPlant("plant/oxeye_daisy", 1, 1, 3);
    public static final TfcGrassPlantBlock PLANT_PAMPAS_GRASS = createGrassPlant("plant/pampas_grass", 1, 1, 3);
    public static final TfcGrassPlantBlock PLANT_PEACH_SAPLING = createGrassPlant("plant/peach_sapling", 1, 1, 3);
    public static final TfcGrassPlantBlock PLANT_PEROVSKIA = createGrassPlant("plant/perovskia", 1, 1, 3);
    public static final TfcLilyPadBlock PLANT_PISTIA = createLilyPad("plant/pistia");
    public static final TfcGrassPlantBlock PLANT_PLUM_SAPLING = createGrassPlant("plant/plum_sapling", 1, 1, 3);
    public static final TfcGrassPlantBlock PLANT_POPPY = createGrassPlant("plant/poppy", 1, 1, 3);
    public static final TfcGrassPlantBlock PLANT_PRIMROSE = createGrassPlant("plant/primrose", 1, 1, 3);
    public static final TfcGrassPlantBlock PLANT_PULSATILLA = createGrassPlant("plant/pulsatilla", 1, 1, 3);
    public static final TfcGrassPlantBlock PLANT_RASPBERRY_BUSH = createGrassPlant("plant/raspberry_bush", 1, 1, 3);
    //Rattan has no item
    public static final TfcGrassPlantBlock PLANT_RED_APPLE_SAPLING = createGrassPlant("plant/red_apple_sapling", 1, 1, 3);
    //Reindeer lichen [moss]
    public static final TfcGrassPlantBlock PLANT_ROSE = createGrassPlant("plant/rose", 1, 1, 3);
    public static final TfcGrassPlantBlock PLANT_RYEGRASS = createGrassPlant("plant/ryegrass", 1, 1, 3);
    public static final TfcGrassPlantBlock PLANT_SACRED_DATURA = createGrassPlant("plant/sacred_datura", 1, 1, 3);
    public static final TfcGrassPlantBlock PLANT_SAGEBRUSH = createGrassPlant("plant/sagebrush", 1, 1, 3);
    //Sago can't be placed
    public static final TfcGrassPlantBlock PLANT_SAPPHIRE_TOWER = createGrassPlant("plant/sapphire_tower", 1, 1, 3);
    public static final TfcLilyPadBlock PLANT_SARGASSUM = createLilyPad("plant/sargassum");
    public static final TfcGrassPlantBlock PLANT_SCUTCH_GRASS = createGrassPlant("plant/scutch_grass", 1, 1, 3);
    public static final TfcGrassPlantBlock PLANT_SNAPDRAGON_PINK = createGrassPlant("plant/snapdragon_pink", 1, 1, 3);
    public static final TfcGrassPlantBlock PLANT_SNAPDRAGON_RED = createGrassPlant("plant/snapdragon_red", 1, 1, 3);
    public static final TfcGrassPlantBlock PLANT_SNAPDRAGON_WHITE = createGrassPlant("plant/snapdragon_white", 1, 1, 3);
    public static final TfcGrassPlantBlock PLANT_SNAPDRAGON_YELLOW = createGrassPlant("plant/snapdragon_yellow", 1, 1, 3);
    public static final TfcGrassPlantBlock PLANT_SNOWBERRY_BUSH = createGrassPlant("plant/snowberry_bush", 1, 1, 3);
    //Spanish moss can't be placed
    public static final TfcWaterPlantBlock PLANT_STAR_GRASS = createWaterPlant("plant/star_grass");
    public static final TfcGrassPlantBlock PLANT_STRAWBERRY_BUSH = createGrassPlant("plant/strawberry_bush", 1, 1, 3);
    public static final TfcGrassPlantBlock PLANT_STRELITZIA = createGrassPlant("plant/strelitzia", 1, 1, 3);
    //Sugar cane has no item
    public static final TfcGrassPlantBlock PLANT_SWORD_FERN = createGrassPlant("plant/sword_fern", 1, 1, 3);
    public static final TfcGrassPlantBlock PLANT_TALL_FESCUE_GRASS = createGrassPlant("plant/tall_fescue_grass", 1, 1, 3);
    public static final TfcGrassPlantBlock PLANT_TIMOTHY_GRASS = createGrassPlant("plant/timothy_grass", 1, 1, 3);
    public static final TfcGrassPlantBlock PLANT_TOQUILLA_PALM = createGrassPlant("plant/toquilla_palm", 1, 1, 3);
    public static final TfcGrassPlantBlock PLANT_TREE_FERN = createGrassPlant("plant/tree_fern", 1, 1, 3);
    public static final TfcGrassPlantBlock PLANT_TRILLIUM = createGrassPlant("plant/trillium", 1, 1, 3);
    public static final TfcGrassPlantBlock PLANT_TROPICAL_MILKWEED = createGrassPlant("plant/tropical_milkweed", 1, 1, 3);
    public static final TfcGrassPlantBlock PLANT_TULIP_ORANGE = createGrassPlant("plant/tulip_orange", 1, 1, 3);
    public static final TfcGrassPlantBlock PLANT_TULIP_PINK = createGrassPlant("plant/tulip_pink", 1, 1, 3);
    public static final TfcGrassPlantBlock PLANT_TULIP_RED = createGrassPlant("plant/tulip_red", 1, 1, 3);
    public static final TfcGrassPlantBlock PLANT_TULIP_WHITE = createGrassPlant("plant/tulip_white", 1, 1, 3);
    public static final TfcWaterPlantBlock PLANT_TURTLE_GRASS = createWaterPlant("plant/turtle_grass");
    //vrisea can't be placed
    public static final TfcLilyPadBlock PLANT_WATER_CANNA = createLilyPad("plant/water_canna");
    public static final TfcLilyPadBlock PLANT_WATER_LILY = createLilyPad("plant/water_lily");
    public static final TfcWaterPlantBlock PLANT_WINGED_KELP = createWaterPlant("plant/winged_kelp");
    public static final TfcGrassPlantBlock PLANT_YUCCA = createGrassPlant("plant/yucca", 1, 1, 3);
    //Sand
    public static final TfcGravityBlock SAND_BROWN = createSand("sand/brown");
    public static final TfcGravityBlock SAND_GREEN = createSand("sand/green");
    public static final TfcGravityBlock SAND_PINK = createSand("sand/pink");
    public static final TfcGravityBlock SAND_RED = createSand("sand/red");
    public static final TfcGravityBlock SAND_WHITE = createSand("sand/white");
    public static final TfcGravityBlock SAND_YELLOW = createSand("sand/yellow");
    public static final TfcGravityBlock SAND_BLACK = createSand("sand/black");
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
    public static final LogPile LOG_PILE = register("log_pile", new LogPile(FabricBlockSettings.copyOf(Blocks.STONE)), DEVICES_GROUP);
    public static final SandstoneBlock SANDSTONE_BLACK = new SandstoneBlock("sandstone/black");
    public static final SandstoneBlock SANDSTONE_BROWN = new SandstoneBlock("sandstone/brown");
    public static final SandstoneBlock SANDSTONE_GREEN = new SandstoneBlock("sandstone/green");
    public static final SandstoneBlock SANDSTONE_PINK = new SandstoneBlock("sandstone/pink");
    public static final SandstoneBlock SANDSTONE_RED = new SandstoneBlock("sandstone/red");
    public static final SandstoneBlock SANDSTONE_WHITE = new SandstoneBlock("sandstone/white");
    public static final SandstoneBlock SANDSTONE_YELLOW = new SandstoneBlock("sandstone/yellow");
    //Misc
    public static final Block PEAT_GRASS = createGrass("peat_grass", BlockSoundGroup.GRAVEL);
    public static final Block FORGE = register("charcoal_forge", new Forge(FabricBlockSettings.copyOf(Blocks.SAND)), DEVICES_GROUP);
    public static final TfcGravityBlock PEAT = createRock("peat", EARTH_GROUP);
    public static final TfcLeaves THATCH = createLeaves("thatch");
    public static final Block FIRE_BRICKS = createLooseRock("fire_bricks");
    public static final Block CALCITE = createLooseRock("calcite");
    public static final Block CHARCOAL_PILE = createLooseRock("charcoal_pile");
    public static final Block BELLOWS_BLOCK = register("bellows", new BellowsBlock(FabricBlockSettings.copyOf(Blocks.SAND)), DEVICES_GROUP);
    public static final Block PLACEABLE = register("pit_kiln", new PlaceableBlock(FabricBlockSettings.copyOf(Blocks.NETHERRACK)), DEVICES_GROUP);
    public static final Block BURNING_LOG_PILE = register("burning_log_pile", new Block(FabricBlockSettings.copyOf(Blocks.SAND)), DEVICES_GROUP);

    private TfcBlocks() {
    }

    public static TfcGravityBlock createRock(String id, ItemGroup group) {
        var block = new TfcGravityBlock(FabricBlockSettings.copyOf(Blocks.STONE));
        register(id, block, group);
        return block;
    }

    public static TfcStairs createStoneStairs(String id, Block fullBlock, ItemGroup group) {
        var block = new TfcStairs(fullBlock.getDefaultState(), FabricBlockSettings.copyOf(Blocks.ACACIA_STAIRS));
        register(id, block, group);
        return block;
    }

    public static SlabBlock createStoneSlab(String id, ItemGroup group) {
        var block = new SlabBlock(FabricBlockSettings.copyOf(Blocks.ACACIA_SLAB));
        register(id, block, group);
        return block;
    }

    public static WallBlock createWall(String id, ItemGroup group) {
        var block = new WallBlock(FabricBlockSettings.copyOf(Blocks.ANDESITE_WALL));
        register(id, block, group);
        return block;
    }

    public static TFCGrassBlock createGrass(String id, BlockSoundGroup sound) {
        var block = new TFCGrassBlock(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(sound));
        register(id, block, EARTH_GROUP);
        return block;
    }

    public static TfcCoralBlock createCoralBlock(String id, TfcDeadCoralBlock deadCoralBlock) {
        var block = new TfcCoralBlock(deadCoralBlock, FabricBlockSettings.copyOf(Blocks.BRAIN_CORAL));
        register(id, block, FLORA_GROUP);
//        BlockRenderLayerMap.INSTANCE.putBlock(block, RenderLayer.getCutout());
        return block;
    }

    public static TfcCoralFanBlock createCoralFanBlock(String id, TfcDeadCoralFanBlock deadCoralFanBlock) {
        var block = new TfcCoralFanBlock(deadCoralFanBlock, FabricBlockSettings.copyOf(Blocks.BRAIN_CORAL_FAN));
        register(id, block, FLORA_GROUP);
//        BlockRenderLayerMap.INSTANCE.putBlock(block, RenderLayer.getCutout());
        return block;
    }

    public static TfcDeadCoralBlock createDeadCoralBlock(String id) {
        var block = new TfcDeadCoralBlock(FabricBlockSettings.copyOf(Blocks.DEAD_BRAIN_CORAL_BLOCK));
        register(id, block, FLORA_GROUP);
//        BlockRenderLayerMap.INSTANCE.putBlock(block, RenderLayer.getCutout());
        return block;
    }

    public static TfcDeadCoralFanBlock createDeadCoralFanBlock(String id) {
        var block = new TfcDeadCoralFanBlock(FabricBlockSettings.copyOf(Blocks.DEAD_BRAIN_CORAL_FAN));
        register(id, block, FLORA_GROUP);
//        BlockRenderLayerMap.INSTANCE.putBlock(block, RenderLayer.getCutout());
        return block;
    }

    public static Block createCrop(String id, int temp, int speed, boolean tall, Item cropItem, int maxAge) {
        var block = tall ? new TfcTallCropBlock(copyOf(Blocks.WHEAT), temp, speed) : new TfcCropBlock(copyOf(Blocks.WHEAT), temp, speed, cropItem, maxAge);
        register("crop/" + id, block, FLORA_GROUP);
        return block;
    }

    public static TfcFarmlandBlock createFarmland(String id) {
        var block = new TfcFarmlandBlock(FabricBlockSettings.copyOf(Blocks.FARMLAND));
        register(id, block, ROCK_GROUP);
        return block;
    }

    public static TfcGroundCoverBlock createGroundcover(String id, Item dropId) {
        //TODO: Replace with a tag
        var block = register(id, new TfcGroundCoverBlock(FabricBlockSettings.of(Material.STONE).strength(6.0f)), dropId);
        return block;
    }

    public static TfcGroundCoverBlock createGroundcover(String id) {
        //TODO: Replace with a tag
        var block = registerWithoutItem(id, new TfcGroundCoverBlock(FabricBlockSettings.of(Material.STONE).strength(6.0f)));
        return block;
    }

    public static LanternBlock createLamp(String id) {
        //TODO: Fix lamp bounding box
        var block = new LanternBlock(FabricBlockSettings.copyOf(Blocks.LANTERN));
        register("metal/lamp/" + id, block, METAL_GROUP);
        return block;
    }

    public static TfcGrassPlantBlock createGrassPlant(String id, int temp, int speed, int collisionLevel) {
        var block = new TfcGrassPlantBlock(FabricBlockSettings.copyOf(Blocks.WHEAT), temp, speed, collisionLevel, 8);
        register(id, block, FLORA_GROUP);
        return block;
    }

    public static TfcWaterPlantBlock createWaterPlant(String id) {
        var block = new TfcWaterPlantBlock(FabricBlockSettings.copyOf(Blocks.KELP_PLANT));
        register(id, block, FLORA_GROUP);
        return block;
    }

    public static TfcLilyPadBlock createLilyPad(String id) {
        var block = new TfcLilyPadBlock(FabricBlockSettings.copyOf(Blocks.LILY_PAD));
        register(id, block, FLORA_GROUP);
        return block;
    }

    public static TfcStoneButtonBlock createStoneButton(String id) {
        var block = new TfcStoneButtonBlock(FabricBlockSettings.copyOf(Blocks.STONE_BUTTON));
        register(id, block, DECORATIONS_GROUP);
        return block;
    }

    public static Block createGroundOre(String id, int meltingPoint) {
        var block = new TfcGroundCoverOre(FabricBlockSettings.of(Material.WOOD).sounds(BlockSoundGroup.WOOD).strength(2.0f));
        register(id, new GroundCoverOreBlockItem(block, genItemSettings(EARTH_GROUP), meltingPoint));
        registerWithoutItem(id, block);
        return block;
    }

    public static TfcGravityBlock createSand(String id) {
        var block = new TfcGravityBlock(FabricBlockSettings.copyOf(Blocks.SAND));
        register(id, block, EARTH_GROUP);
        return block;
    }

    public static TfcFallenLeavesBlock createFallenLeaves(String id) {
        var block = new TfcFallenLeavesBlock(FabricBlockSettings.copyOf(Blocks.ACACIA_LEAVES).noCollision());
        register(id, block, WOOD_GROUP);
        return block;
    }

    public static TfcSupportBlock createSupport(String id, Boolean hasPillar) {
        var block = new TfcSupportBlock(FabricBlockSettings.copyOf(Blocks.OAK_WOOD).nonOpaque(), hasPillar);
        if (hasPillar) register(id, block, new TfcSupportItem(block, genItemSettings(WOOD_GROUP)));
        else registerWithoutItem(id, block);
        return block;
    }

    public static Keg createKeg(String id) {
        var block = new Keg(FabricBlockSettings.copyOf(Blocks.OAK_WOOD));
        register(id, block, WOOD_GROUP);
        return block;
    }

    public static TfcLeaves createLeaves(String id) {
        var block = new TfcLeaves(FabricBlockSettings.copyOf(Blocks.ACACIA_LEAVES).noCollision());
        register(id, block, WOOD_GROUP);
        return block;
    }

    public static TfcLog createLog(String id, MapColor color) {
        var block = new TfcLog(FabricBlockSettings.copyOf(Blocks.OAK_WOOD).mapColor(color));
        //TODO: What is this?
        registerWithoutItem(id, block);
        register(id, new TfcLogItem(block, new FabricItemSettings().group(WOOD_GROUP)));
        return block;
    }    //Block Entities

    public static Block createFlammable(String id, MapColor color) {
        var block = new Block(FabricBlockSettings.copyOf(Blocks.OAK_WOOD).mapColor(color));
        register(id, block, WOOD_GROUP);
        return block;
    }

    public static TfcOreBlock createOre(String name, String id, String special) {
        var block = new TfcOreBlock(FabricBlockSettings.copyOf(Blocks.IRON_ORE));
        register(id + special + "/" + name, block, ORES_GROUP);
        return block;
    }

    public static ToolRackBlock createRack(String id) {
        var block = new ToolRackBlock(FabricBlockSettings.copyOf(Blocks.OAK_WOOD));
        register(id, block, WOOD_GROUP);
        return block;
    }

    public static TFCGrassBlock createGrass(String id) {
        var block = new TFCGrassBlock(FabricBlockSettings.of(Material.LEAVES).sounds(BlockSoundGroup.GRASS).strength(2.0f));
        register(id, block, EARTH_GROUP);
        return block;
    }

    public static TfcSapling createSapling(String id, SaplingGenerator generator) {
        var block = new TfcSapling(generator, FabricBlockSettings.copyOf(Blocks.OAK_SAPLING));
//        BlockRenderLayerMap.INSTANCE.putBlock(block, RenderLayer.getCutout());
        register(id, block, WOOD_GROUP);
        return block;
    }

    public static TfcTwig createTwig(String id) {
        var block = new TfcTwig(FabricBlockSettings.of(Material.WOOD).sounds(BlockSoundGroup.WOOD).strength(2.0f));
        register(id, block, WOOD_GROUP);
        return block;
    }

    public static TfcLooseRock createLooseRock(String id) {
        var block = new TfcLooseRock(FabricBlockSettings.of(Material.STONE).sounds(BlockSoundGroup.STONE).strength(6.0f));
        register(id, block, ROCK_GROUP);
        return block;
    }

    public static TfcAnvil createAnvil(String id) {
        var block = new TfcAnvil(FabricBlockSettings.copyOf(Blocks.ANVIL));
        register("metal/anvil/" + id, block, METAL_GROUP);
        return block;
    }

    /**
     * Registers a block with a block item
     *
     * @param id        id of the block and the item
     * @param block     instance of the block to register
     * @param itemGroup item group
     * @param <T>       class of the block to register
     * @return returns block from {@code block}
     */
    private static <T extends Block> T register(String id, T block, ItemGroup itemGroup) {
        var fullId = new Identifier(MODID, id);
        Registry.register(Registry.BLOCK, fullId, block);
        Registry.register(Registry.ITEM, fullId, new BlockItem(block, new Item.Settings().group(itemGroup)));
        return block;
    }

    private static <T extends Block> T register(String id, T block, Item item) {
        //TODO: Make block drop item from param
        var fullId = new Identifier(MODID, id);
        Registry.register(Registry.BLOCK, fullId, block);
        return block;
    }

    /**
     * Registers an item
     * Used with blocks that require custom items
     *
     * @param id   id of the item
     * @param item instance of the item to register
     * @param <T>  class of the item to register
     * @return returns item from {@code item}
     */
    private static <T extends Item> T register(String id, T item) {
        Registry.register(Registry.ITEM, new Identifier(MODID, id), item);
        return item;
    }

    /**
     * Generates generic item settings from a {@code ItemGroup}
     *
     * @param itemGroup item group to use for the {@code Settings}
     * @return generic item settings
     */
    private static Item.Settings genItemSettings(ItemGroup itemGroup) {
        return new Item.Settings().group(itemGroup);
    }

    private static <T extends Block> T registerWithoutItem(String id, T block) {
        Registry.register(Registry.BLOCK, new Identifier(MODID, id), block);
        return block;
    }

    public static void init() {
    }
}

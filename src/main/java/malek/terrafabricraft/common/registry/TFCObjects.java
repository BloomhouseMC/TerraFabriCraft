package malek.terrafabricraft.common.registry;

import malek.terrafabricraft.TerraFabriCraft;
import malek.terrafabricraft.common.block.*;
import malek.terrafabricraft.common.block.bellows.BellowsBlock;
import malek.terrafabricraft.common.block.bellows.BellowsBlockEntity;
import malek.terrafabricraft.common.block.forge.Forge;
import malek.terrafabricraft.common.block.forge.ForgeBlockEntity;
import malek.terrafabricraft.common.block.keg.Keg;
import malek.terrafabricraft.common.block.keg.KegEntity;
import malek.terrafabricraft.common.block.logpile.LogPile;
import malek.terrafabricraft.common.block.logpile.LogPileBlockEntity;
import malek.terrafabricraft.common.block.placeable.PlaceableBlock;
import malek.terrafabricraft.common.block.placeable.PlaceableBlockEntity;
import malek.terrafabricraft.common.block.toolrack.ToolRackBlock;
import malek.terrafabricraft.common.block.toolrack.ToolRackBlockEntity;
import malek.terrafabricraft.common.item.*;
import malek.terrafabricraft.common.item.ceramic.CeramicVessel;
import malek.terrafabricraft.common.registry.util.*;
import malek.terrafabricraft.common.registry.util.CoralBlock;
import malek.terrafabricraft.common.world.generator.tree.GenericSaplingGenerator;
import malek.terrafabricraft.common.world.generator.tree.KapokSaplingGenerator;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.item.*;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.LinkedHashMap;
import java.util.Map;

import static malek.terrafabricraft.common.registry.TFCFeatures.*;
import static net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings.copyOf;

@SuppressWarnings("unused")
public class TFCObjects {
    public static final Map<Block, Identifier> BLOCKS = new LinkedHashMap<>();
    public static final Map<Item, Identifier> ITEMS = new LinkedHashMap<>();
    private static final Map<BlockEntityType<?>, Identifier> BLOCK_ENTITY_TYPES = new LinkedHashMap<>();


    public static final TFCFarmlandBlock FARMLAND_LOAM = createFarmland("farmland/loam", true);
    public static final TFCFarmlandBlock FARMLAND_SANDY_LOAM = createFarmland("farmland/sandy_loam", true);
    public static final TFCFarmlandBlock FARMLAND_SILT = createFarmland("farmland/silt", true);
    public static final TFCFarmlandBlock FARMLAND_SILTY_LOAM = createFarmland("farmland/silty_loam", true);
    public static final SoilBlock GRASS = new SoilBlock("grass", BlockSoundGroup.GRASS);
    // Debug + Testing
    public static final Item TEST_FOOD = createFood("test_food", 1, 1);

    public static final Block ALABASTER_RAW_ALABASTER = createRock("alabaster/raw/alabaster", TerraFabriCraft.DECORATIONS_GROUP);
    public static final Block ALABASTER_RAW_ALABASTER_BRICKS = createRock("alabaster/raw/alabaster_bricks", TerraFabriCraft.DECORATIONS_GROUP);
    public static final Block ALABASTER_RAW_POLISHED_ALABASTER = createRock("alabaster/raw/polished_alabaster", TerraFabriCraft.DECORATIONS_GROUP);
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
    public static final malek.terrafabricraft.common.registry.util.CoralBlock CORAL_BRAIN = new malek.terrafabricraft.common.registry.util.CoralBlock("coral/brain");
    public static final malek.terrafabricraft.common.registry.util.CoralBlock CORAL_BUBBLE = new malek.terrafabricraft.common.registry.util.CoralBlock("coral/bubble");
    public static final malek.terrafabricraft.common.registry.util.CoralBlock CORAL_FIRE = new malek.terrafabricraft.common.registry.util.CoralBlock("coral/fire");
    public static final malek.terrafabricraft.common.registry.util.CoralBlock CORAL_HORN = new malek.terrafabricraft.common.registry.util.CoralBlock("coral/horn");
    public static final malek.terrafabricraft.common.registry.util.CoralBlock CORAL_TUBE = new CoralBlock("coral/tube");
    public static final Block BARLEY_CROP = createCrop("barley_crop", 0, 1, false, TFCObjects.BARLEY_SEED, 9);
    //Seeds
    public static final Item BARLEY_SEED = createItem("seed/barley_seeds", new AliasedBlockItem(BARLEY_CROP, gen(TerraFabriCraft.FLORA_GROUP)));
    public static final Block CABBAGE_CROP = createCrop("cabbage_crop", 0, 1, false, TFCObjects.CABBAGE_SEED, 7);
    public static final Item CABBAGE_SEED = createItem("seed/cabbage_seeds", new AliasedBlockItem(CABBAGE_CROP, gen(TerraFabriCraft.FLORA_GROUP)));
    public static final Block CARROT_CROP = createCrop("carrot_crop", 0, 1, false, TFCObjects.CARROT_SEED, 6);
    public static final Item CARROT_SEED = createItem("seed/carrot_seeds", new AliasedBlockItem(CARROT_CROP, gen(TerraFabriCraft.FLORA_GROUP)));
    public static final Block GARLIC_CROP = createCrop("garlic_crop", 0, 1, false, TFCObjects.GARLIC_SEED, 6);
    public static final Item GARLIC_SEED = createItem("seed/garlic_seeds", new AliasedBlockItem(GARLIC_CROP, gen(TerraFabriCraft.FLORA_GROUP)));
    public static final Block GREENBEAN_CROP = createCrop("greenbean_crop", 0, 1, false, TFCObjects.GREENBEAN_SEED, 8);
    public static final Item GREENBEAN_SEED = createItem("seed/greenbean_seeds", new AliasedBlockItem(GREENBEAN_CROP, gen(TerraFabriCraft.FLORA_GROUP)));
    public static final Block JUTE_CROP = createCrop("jute_crop", 0, 1, true, TFCObjects.JUTE_SEED, 7);
    public static final Item JUTE_SEED = createItem("seed/jute_seeds", new AliasedBlockItem(JUTE_CROP, gen(TerraFabriCraft.FLORA_GROUP)));
    public static final Block MAIZE_CROP = createCrop("maize_crop", 0, 1, true, TFCObjects.MAIZE_SEED, 7);
    public static final Item MAIZE_SEED = createItem("seed/maize_seeds", new AliasedBlockItem(MAIZE_CROP, gen(TerraFabriCraft.FLORA_GROUP)));
    public static final Block OAT_CROP = createCrop("oat_crop", 0, 1, false, TFCObjects.OAT_SEED, 9);
    public static final Item OAT_SEED = createItem("seed/oat_seeds", new AliasedBlockItem(OAT_CROP, gen(TerraFabriCraft.FLORA_GROUP)));
    public static final Block ONION_CROP = createCrop("onion_crop", 0, 1, false, TFCObjects.ONION_SEED, 8);
    public static final Item ONION_SEED = createItem("seed/onion_seeds", new AliasedBlockItem(ONION_CROP, gen(TerraFabriCraft.FLORA_GROUP)));
    public static final Block POTATO_CROP = createCrop("potato_crop", 0, 1, false, TFCObjects.POTATO_SEED, 8);
    public static final Item POTATO_SEED = createItem("seed/potato_seeds", new AliasedBlockItem(POTATO_CROP, gen(TerraFabriCraft.FLORA_GROUP)));
    public static final Block RED_BELL_PEPPER_CROP = createCrop("red_bell_pepper_crop", 0, 1, false, TFCObjects.RED_BELL_PEPPER_SEED, 8);
    public static final Item RED_BELL_PEPPER_SEED = createItem("seed/red_bell_pepper_seeds", new AliasedBlockItem(RED_BELL_PEPPER_CROP, gen(TerraFabriCraft.FLORA_GROUP)));
    public static final Block RICE_CROP = createCrop("rice_crop", 0, 1, false, TFCObjects.RICE_SEED, 9);
    public static final Item RICE_SEED = createItem("seed/rice_seeds", new AliasedBlockItem(RICE_CROP, gen(TerraFabriCraft.FLORA_GROUP)));
    public static final Block RUTABAGA_CROP = createCrop("rutabaga_crop", 0, 1, false, TFCObjects.RUTABAGA_SEED, 9);
    public static final Item RUTABAGA_SEED = createItem("seed/rutabaga_seeds", new AliasedBlockItem(RUTABAGA_CROP, gen(TerraFabriCraft.FLORA_GROUP)));
    public static final Block RYE_CROP = createCrop("rye_crop", 0, 1, false, TFCObjects.RYE_SEED, 9);
    public static final Item RYE_SEED = createItem("seed/rye_seeds", new AliasedBlockItem(RYE_CROP, gen(TerraFabriCraft.FLORA_GROUP)));
    public static final Block SOYBEAN_CROP = createCrop("soybean_crop", 0, 1, false, TFCObjects.SOYBEAN_SEED, 8);
    public static final Item SOYBEAN_SEED = createItem("seed/soybean_seeds", new AliasedBlockItem(SOYBEAN_CROP, gen(TerraFabriCraft.FLORA_GROUP)));
    public static final Block SQUASH_CROP = createCrop("squash_crop", 0, 1, false, TFCObjects.SQUASH_SEED, 9);
    public static final Item SQUASH_SEED = createItem("seed/squash_seeds", new AliasedBlockItem(SQUASH_CROP, gen(TerraFabriCraft.FLORA_GROUP)));
    public static final Block TOMATO_CROP = createCrop("tomato_crop", 0, 1, false, TFCObjects.TOMATO_SEED, 9);
    public static final Item TOMATO_SEED = createItem("seed/tomato_seeds", new AliasedBlockItem(TOMATO_CROP, gen(TerraFabriCraft.FLORA_GROUP)));
    public static final Block WHEAT_CROP = createCrop("wheat_crop", 0, 1, false, TFCObjects.WHEAT_SEED, 9);
    public static final Item WHEAT_SEED = createItem("seed/wheat_seeds", new AliasedBlockItem(WHEAT_CROP, gen(TerraFabriCraft.FLORA_GROUP)));
    public static final Block YELLOW_BELL_PEPPER_CROP = createCrop("yellow_bell_pepper_crop", 0, 1, false, TFCObjects.YELLOW_BELL_PEPPER_SEED, 8);
    public static final Item YELLOW_BELL_PEPPER_SEED = createItem("seed/yellow_bell_pepper_seeds", new AliasedBlockItem(YELLOW_BELL_PEPPER_CROP, gen(TerraFabriCraft.FLORA_GROUP)));
    public static final Item BITUMINOUSE_COAL = createItemSimple("ore/bituminous_coal", TerraFabriCraft.ORES_GROUP);
    public static final Item LIGNITE = createItemSimple("ore/lignite", TerraFabriCraft.ORES_GROUP);
    public static final Item KAOLINITE = createItemSimple("ore/kaolinite", TerraFabriCraft.ORES_GROUP);
    public static final Item GYPSUM = createItemSimple("ore/gypsum", TerraFabriCraft.ORES_GROUP);
    public static final Item GRAPHITE = createItemSimple("ore/graphite", TerraFabriCraft.ORES_GROUP);
    public static final Item SULFUR = createItemSimple("ore/sulfur", TerraFabriCraft.ORES_GROUP);
    public static final Item CINNABAR = createItemSimple("ore/cinnabar", TerraFabriCraft.ORES_GROUP);
    public static final Item CRYOLITE = createItemSimple("ore/cryolite", TerraFabriCraft.ORES_GROUP);
    public static final Item SALPETER = createItemSimple("ore/saltpeter", TerraFabriCraft.ORES_GROUP);
    public static final Item SYLVITE = createItemSimple("ore/sylvite", TerraFabriCraft.ORES_GROUP);
    public static final Item BORAX = createItemSimple("ore/borax", TerraFabriCraft.ORES_GROUP);
    public static final Item HALITE = createItemSimple("ore/halite", TerraFabriCraft.ORES_GROUP);
    public static final Item AMETHYST = createItemSimple("ore/amethyst", TerraFabriCraft.ORES_GROUP);
    public static final Item DIAMOND = createItemSimple("ore/diamond", TerraFabriCraft.ORES_GROUP);
    public static final Item EMERALD = createItemSimple("ore/emerald", TerraFabriCraft.ORES_GROUP);
    public static final Item LAPIS_LAZULI = createItemSimple("ore/lapis_lazuli", TerraFabriCraft.ORES_GROUP);
    public static final Item OPAL = createItemSimple("ore/opal", TerraFabriCraft.ORES_GROUP);
    public static final Item PYRITE = createItemSimple("ore/pyrite", TerraFabriCraft.ORES_GROUP);
    public static final Item RUBY = createItemSimple("ore/ruby", TerraFabriCraft.ORES_GROUP);
    public static final Item SAPPHIRE = createItemSimple("ore/sapphire", TerraFabriCraft.ORES_GROUP);
    public static final Item TOPAZ = createItemSimple("ore/topaz", TerraFabriCraft.ORES_GROUP);
    public static final OreItem RICH_ORE_ITEM = new OreItem("rich");
    public static final OreItem NORMAL_ORE_ITEM = new OreItem("normal");
    public static final OreItem POOR_ORE_ITEM = new OreItem("poor");
    public static final StoneItem STONE_HEAD = new StoneItem("stone");
    public static final MetalItem DOUBLE_INGOT = new MetalItem("double_ingot");
    public static final MetalItem DOUBLE_SHEET = new MetalItem("double_sheet");
    public static final MetalItem INGOT = new MetalItem("ingot");
    public static final MetalItem ROD = new MetalItem("rod");
    public static final MetalItem SHEET = new MetalItem("sheet");
    public static final MetalItem UN_BOOTS = new MetalItem("unfinished_boots");
    public static final MetalItem UN_CHEST = new MetalItem("unfinished_chestplate");
    public static final MetalItem UN_GREAVES = new MetalItem("unfinished_greaves");
    public static final MetalItem UN_HELMET = new MetalItem("unfinished_helmet");
    public static final MetalItem AXE_HEAD = new MetalItem("axe_head");
    public static final MetalItem CHISEL_HEAD = new MetalItem("chisel_head");
    public static final MetalItem HAMMER_HEAD = new MetalItem("hammer_head");
    public static final MetalItem JAVELIN_HEAD = new MetalItem("javelin_head");
    public static final MetalItem HOE_HEAD = new MetalItem("hoe_head");
    public static final MetalItem KNIFE_HEAD = new MetalItem("knife_blade");
    public static final MetalItem MACE_HEAD = new MetalItem("mace_head");
    public static final MetalItem PICKAXE_HEAD = new MetalItem("pickaxe_head");
    public static final MetalItem PROPICK_HEAD = new MetalItem("propick_head");
    public static final MetalItem SAW_BLADE = new MetalItem("saw_blade");
    public static final MetalItem SCYTHE_BLADE = new MetalItem("scythe_blade");
    public static final MetalItem SHOVEL_HEAD = new MetalItem("shovel_head");
    public static final MetalItem SWORD_BLADE = new MetalItem("sword_blade");
    public static final MetalItem TUYERE = new MetalItem("tuyere");
    //Fruit
    public static final Item BANANA = createFood("banana", 1, 1);
    public static final Item BLACKBERRY = createFood("blackberry", 1, 1);
    public static final Item BLUEBERRY = createFood("blueberry", 1, 1);
    public static final Item BUNCHBERRY = createFood("bunchberry", 1, 1);
    public static final Item CHERRY = createFood("cherry", 1, 1);
    public static final Item CLOUDBERRY = createFood("cloudberry", 1, 1);
    public static final Item CRANBERRY = createFood("cranberry", 1, 1);
    public static final Item ELDERBERRY = createFood("elderberry", 1, 1);
    public static final Item GOOSEBERRY = createFood("gooseberry", 1, 1);
    public static final Item GREEN_APPLE = createFood("green_apple", 1, 1);
    public static final Item LEMON = createFood("lemon", 1, 1);
    public static final Item OLIVE = createFood("olive", 1, 1);
    public static final Item ORANGE = createFood("orange", 1, 1);
    public static final Item PEACH = createFood("peach", 1, 1);
    public static final Item PLUM = createFood("plum", 1, 1);
    public static final Item RASPBERRY = createFood("raspberry", 1, 1);
    public static final Item RED_APPLE = createFood("red_apple", 1, 1);
    public static final Item SNOWBERRY = createFood("snowberry", 1, 1);
    public static final Item STRAWBERRY = createFood("strawberry", 1, 1);
    public static final Item WINTERGREEN_BERRY = createFood("wintergreen_berry", 1, 1);
    //Vegetable
    public static final Item CABBAGE = createFood("cabbage", 1, 1);
    public static final Item CARROT = createFood("carrot", 1, 1);
    public static final Item GARLIC = createFood("garlic", 1, 1);
    public static final Item GREEN_BEAN = createFood("green_bean", 1, 1);
    public static final Item GREEN_BELL_PEPPER = createFood("green_bell_pepper", 1, 1);
    public static final Item ONION = createFood("onion", 1, 1);
    public static final Item POTATO = createFood("potato", 1, 1);
    public static final Item RED_BELL_PEPPER = createFood("red_bell_pepper", 1, 1);
    public static final Item RUTABAGA = createFood("rutabaga", 1, 1);
    public static final Item SEA_WEED = createFood("sea_weed", 1, 1);
    public static final Item SQUASH = createFood("squash", 1, 1);
    public static final Item TOMATO = createFood("tomato", 1, 1);
    public static final Item YELLOW_BELL_PEPPER = createFood("yellow_bell_pepper", 1, 1);
    //Brewing
    public static final Item YEAST_BREWERS = createItemSimple("food/yeast_brewers", TerraFabriCraft.FOOD_GROUP);
    public static final Item YEAST_LAGER = createItemSimple("food/yeast_lager", TerraFabriCraft.FOOD_GROUP);
    public static final Item YEAST_ALE = createItemSimple("food/yeast_ale", TerraFabriCraft.FOOD_GROUP);
    public static final Item HOP_CENTENNIAL = createItemSimple("food/hop_centennial", TerraFabriCraft.FOOD_GROUP);
    public static final Item HOP_CASCADE = createItemSimple("food/hop_cascade", TerraFabriCraft.FOOD_GROUP);
    public static final Item HOP_CITRA = createItemSimple("food/hop_citra", TerraFabriCraft.FOOD_GROUP);
    public static final Item HOP_MOSAIC = createItemSimple("food/hop_mosaic", TerraFabriCraft.FOOD_GROUP);
    //Grain
    public static final Item BARLEY_BREAD = createFood("barley_bread", 1, 1);
    public static final Item BARLEY_GRAIN = createFood("barley_grain", 1, 1);
    public static final Item MAIZE_BREAD = createFood("maize_bread", 1, 1);
    //public static final Item MAIZE_EAR = createFood("maize_ear", 1, 1);
    public static final Item OAT_BREAD = createFood("oat_bread", 1, 1);
    public static final Item OAT_GRAIN = createFood("oat_grain", 1, 1);
    public static final Item RICE_BREAD = createFood("rice_bread", 1, 1);
    public static final Item RICE_GRAIN = createFood("rice_grain", 1, 1);
    public static final Item RYE_BREAD = createFood("rye_bread", 1, 1);
    public static final Item RYE_GRAIN = createFood("rye_grain", 1, 1);
    public static final Item WHEAT_BREAD = createFood("wheat_bread", 1, 1);
    public static final Item WHEAT_GRAIN = createFood("wheat_grain", 1, 1);
    //Grain Simple Items
    public static final Item BARLEY = createItemSimple("food/barley", TerraFabriCraft.FOOD_GROUP);
    public static final Item BARLEY_FLOUR = createItemSimple("food/barley_flour", TerraFabriCraft.FOOD_GROUP);
    public static final Item BARLEY_DOUGH = createItemSimple("food/barley_dough", TerraFabriCraft.FOOD_GROUP);
    public static final Item MAIZE = createItemSimple("food/maize", TerraFabriCraft.FOOD_GROUP);
    public static final Item MAIZE_FLOUR = createItemSimple("food/maize_flour", TerraFabriCraft.FOOD_GROUP);
    public static final Item MAIZE_DOUGH = createItemSimple("food/maize_dough", TerraFabriCraft.FOOD_GROUP);
    public static final Item OAT = createItemSimple("food/oat", TerraFabriCraft.FOOD_GROUP);
    public static final Item OAT_FLOUR = createItemSimple("food/oat_flour", TerraFabriCraft.FOOD_GROUP);
    public static final Item OAT_DOUGH = createItemSimple("food/oat_dough", TerraFabriCraft.FOOD_GROUP);
    public static final Item RYE = createItemSimple("food/rye", TerraFabriCraft.FOOD_GROUP);
    public static final Item RYE_FLOUR = createItemSimple("food/rye_flour", TerraFabriCraft.FOOD_GROUP);
    public static final Item RYE_DOUGH = createItemSimple("food/rye_dough", TerraFabriCraft.FOOD_GROUP);
    public static final Item RICE = createItemSimple("food/rice", TerraFabriCraft.FOOD_GROUP);
    public static final Item RICE_FLOUR = createItemSimple("food/rice_flour", TerraFabriCraft.FOOD_GROUP);
    public static final Item RICE_DOUGH = createItemSimple("food/rice_dough", TerraFabriCraft.FOOD_GROUP);
    public static final Item WHEAT = createItemSimple("food/wheat", TerraFabriCraft.FOOD_GROUP);
    public static final Item WHEAT_FLOUR = createItemSimple("food/wheat_flour", TerraFabriCraft.FOOD_GROUP);
    public static final Item WHEAT_DOUGH = createItemSimple("food/wheat_dough", TerraFabriCraft.FOOD_GROUP);
    //Protein
    public static final Item RAW_BEAR = createFood("bear", 1, 1);
    public static final Item COOKED_BEAR = createFood("cooked_bear", 1, 1);
    public static final Item RAW_BEEF = createFood("beef", 1, 1);
    public static final Item COOKED_BEEF = createFood("cooked_beef", 1, 1);
    public static final Item RAW_CALAMARI = createFood("calamari", 1, 1);
    public static final Item COOKED_CALAMARI = createFood("cooked_calamari", 1, 1);
    public static final Item RAW_CAMELIDAE = createFood("camelidae", 1, 1);
    public static final Item COOKED_CAMELIDAE = createFood("cooked_camelidae", 1, 1);
    public static final Item RAW_CHEVON = createFood("chevon", 1, 1);
    public static final Item COOKED_CHEVNON = createFood("cooked_chevon", 1, 1);
    public static final Item RAW_DUCK = createFood("duck", 1, 1);
    public static final Item RAW_COD = createFood("cod", 1, 1);
    public static final Item COOKED_COD = createFood("cooked_cod", 1, 1);
    public static final Item COOKED_DUCK = createFood("cooked_duck", 1, 1);
    public static final Item COOKED_EGG = createFood("cooked_egg", 1, 1);
    public static final Item RAW_GRAN_FELINE = createFood("gran_feline", 1, 1);
    public static final Item COOKED_GRAN_FELINE = createFood("cooked_gran_feline", 1, 1);
    public static final Item RAW_HORSE_MEAT = createFood("horse_meat", 1, 1);
    public static final Item COOKED_HORSE_MEAT = createFood("cooked_horse_meat", 1, 1);
    public static final Item RAW_HYENA = createFood("hyena", 1, 1);
    public static final Item COOKED_HYENA = createFood("cooked_hyena", 1, 1);
    public static final Item RAW_MUTTON = createFood("mutton", 1, 1);
    public static final Item COOKED_MUTTON = createFood("cooked_mutton", 1, 1);
    public static final Item RAW_PHEASANT = createFood("pheasant", 1, 1);
    public static final Item COOKED_PHEASANT = createFood("cooked_pheasant", 1, 1);
    public static final Item RAW_PORK = createFood("pork", 1, 1);
    public static final Item COOKED_PORK = createFood("cooked_pork", 1, 1);
    public static final Item RAW_RABBIT = createFood("rabbit", 1, 1);
    public static final Item COOKED_RABBIT = createFood("cooked_rabbit", 1, 1);
    public static final Item RAW_CHICKEN = createFood("chicken", 1, 1);
    public static final Item COOKED_CHICKEN = createFood("cooked_chicken", 1, 1);
    public static final Item RAW_VENISON = createFood("venison", 1, 1);
    public static final Item COOKED_VENISON = createFood("cooked_venison", 1, 1);
    public static final Item RAW_WOLF = createFood("wolf", 1, 1);
    public static final Item COOKED_WOLF = createFood("cooked_wolf", 1, 1);
    public static final Item SOYBEAN = createFood("soybean", 1, 1);
    //Dairy
    public static final Item CHEESE = createFood("cheese", 1, 1);
    public static final SoilBlock CLAY = new SoilBlock("clay", BlockSoundGroup.GRAVEL);
    //public static final TFCFood MILK = new TFCFood("barley_bread", new FabricItemSettings(), 1, 1);
    public static final SoilBlock CLAY_GRASS = new SoilBlock("clay_grass", BlockSoundGroup.GRAVEL);
    public static final SoilBlock DIRT = new SoilBlock("dirt", BlockSoundGroup.GRAVEL);
    public static final SoilBlock GRASS_PATH = new SoilBlock("grass_path", BlockSoundGroup.GRASS);
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
    public static final Block ROCK_BLOCK = createRock("rock_block", TerraFabriCraft.EARTH_GROUP);
    public static final TFCAnvil METAL_ANVIL_BISMUTH_BRONZE = createAnvil("bismuth_bronze");
    public static final TFCAnvil METAL_ANVIL_BLACK_BRONZE = createAnvil("black_bronze");
    public static final TFCAnvil METAL_ANVIL_BLACK_STEEL = createAnvil("black_steel");
    public static final TFCAnvil METAL_ANVIL_BLUE_STEEL = createAnvil("blue_steel");
    public static final TFCAnvil METAL_ANVIL_BRONZE = createAnvil("bronze");
    public static final TFCAnvil METAL_ANVIL_COPPER = createAnvil("copper");
    public static final TFCAnvil METAL_ANVIL_RED_STEEL = createAnvil("red_steel");
    public static final TFCAnvil METAL_ANVIL_STEEL = createAnvil("steel");
    public static final TFCAnvil METAL_ANVIL_WROUGHT_IRON = createAnvil("wrought_iron");
    public static final LanternBlock METAL_LAMP_BISMUTH_BRONZE = createLamp("bismuth_bronze");
    public static final LanternBlock METAL_LAMP_BLACK_BRONZE = createLamp("black_bronze");
    public static final LanternBlock METAL_LAMP_BLACK_STEEL = createLamp("black_steel");
    public static final LanternBlock METAL_LAMP_BLUE_STEEL = createLamp("blue_steel");
    public static final LanternBlock METAL_LAMP_BRONZE = createLamp("bronze");
    public static final LanternBlock METAL_LAMP_COPPER = createLamp("copper");
    public static final LanternBlock METAL_LAMP_RED_STEEL = createLamp("red_steel");
    public static final LanternBlock METAL_LAMP_STEEL = createLamp("steel");
    public static final LanternBlock METAL_LAMP_WROUGHT_IRON = createLamp("wrought_iron");
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
    public static final TFCGrassPlantBlock PLANT_ARUNDO = createGrassPlant("plant/arundo", 1, 1, 3);
    public static final TFCGrassPlantBlock PLANT_ATHYRIUM_FERN = createGrassPlant("plant/athyrium_fern", 1, 1, 1);
    //Badderlocks [dirt]
    public static final TFCGrassPlantBlock PLANT_BANANA_SAPLING = createGrassPlant("plant/banana_sapling", 1, 1, 1);
    public static final TFCGrassPlantBlock PLANT_BLACK_ORCHID = createGrassPlant("plant/black_orchid", 1, 1, 1);
    public static final TFCGrassPlantBlock PLANT_BLACKBERRY_BUSH = createGrassPlant("plant/blackberry_bush", 1, 1, 3);
    //Blackberry bush cane [side]
    public static final TFCGrassPlantBlock PLANT_BLOOD_LILY = createGrassPlant("plant/blood_lily", 1, 1, 3);
    public static final TFCGrassPlantBlock PLANT_BLUE_ORCHID = createGrassPlant("plant/blue_orchid", 1, 1, 3);
    public static final TFCGrassPlantBlock PLANT_BLUEBERRY_BUSH = createGrassPlant("plant/blueberry_bush", 1, 1, 3);
    public static final TFCGrassPlantBlock PLANT_BUNCHBERRY_BUSH = createGrassPlant("plant/bunchberry_bush", 1, 1, 3);
    public static final TFCGrassPlantBlock PLANT_BUTTERFLY_MILKWEED = createGrassPlant("plant/butterfly_milkweed", 1, 1, 3);
    public static final TFCGrassPlantBlock PLANT_CALENDULA = createGrassPlant("plant/calendula", 1, 1, 3);
    public static final TFCGrassPlantBlock PLANT_CANNA = createGrassPlant("plant/canna", 1, 1, 3);
    //Cattail [dirt]
    public static final TFCGrassPlantBlock PLANT_CHERRY_SAPLING = createGrassPlant("plant/cherry_sapling", 1, 1, 3);
    public static final TFCGrassPlantBlock PLANT_CLOUDBERRY_BUSH = createGrassPlant("plant/cloudberry_bush", 1, 1, 3);
    public static final TFCWaterPlant PLANT_COONTAIL = createWaterPlant("plant/coontail");
    public static final TFCGrassPlantBlock PLANT_CRANBERRY_BUSH = createGrassPlant("plant/cranberry_bush", 1, 1, 3);
    public static final TFCGrassPlantBlock PLANT_DANDELION = createGrassPlant("plant/dandelion", 1, 1, 3);
    //Dead berry bush has no item
    //Dead cane has no item
    public static final TFCLilyPadBlock PLANT_DUCKWEED = createLilyPad("plant/duckweed");
    public static final TFCWaterPlant PLANT_EEL_GRASS = createWaterPlant("plant/eel_grass");
    public static final TFCGrassPlantBlock PLANT_ELDERBERRY_BUSH = createGrassPlant("plant/elderberry_bush", 1, 1, 3);
    public static final TFCGrassPlantBlock PLANT_FIELD_HORSETAIL = createGrassPlant("plant/field_horsetail", 1, 1, 3);
    public static final TFCGrassPlantBlock PLANT_FOUNTAIN_GRASS = createGrassPlant("plant/fountain_grass", 1, 1, 3);
    public static final TFCGrassPlantBlock PLANT_FOXGLOVE = createGrassPlant("plant/foxglove", 1, 1, 3);
    public static final TFCWaterPlant PLANT_GIANT_KELP_FLOWER = createWaterPlant("plant/giant_kelp_flower");
    //Giant kelp plant has no item
    public static final TFCGrassPlantBlock PLANT_GOLDENROD = createGrassPlant("plant/goldenrod", 1, 1, 3);
    public static final TFCGrassPlantBlock PLANT_GOOSEBERRY_BUSH = createGrassPlant("plant/gooseberry_bush", 1, 1, 3);
    public static final TFCGrassPlantBlock PLANT_GRAPE_HYACINTH = createGrassPlant("plant/grape_hyacinth", 1, 1, 3);
    public static final TFCGrassPlantBlock PLANT_GREEN_APPLE_SAPLING = createGrassPlant("plant/green_apple_sapling", 1, 1, 3);
    //Gutweed [nowhere]
    //Guzmania [nowhere]
    //Hanging vines [top]
    public static final TFCGrassPlantBlock PLANT_HOUSTONIA = createGrassPlant("plant/houstonia", 1, 1, 3);
    //Ivy [side]
    //Jungle vines [side]
    public static final TFCGrassPlantBlock PLANT_LABRADOR_TEA = createGrassPlant("plant/labrador_tea", 1, 1, 3);
    public static final TFCGrassPlantBlock PLANT_LADY_FERN = createGrassPlant("plant/lady_fern", 1, 1, 3);
    //Laminaria [nowhere]
    public static final TFCWaterPlant PLANT_LEAFY_KELP = createWaterPlant("plant/leafy_kelp");
    public static final TFCGrassPlantBlock PLANT_LEMON_SAPLING = createGrassPlant("plant/lemon_sapling", 1, 1, 3);
    //Liana [top]
    //Licore plant [side]
    public static final TFCLilyPadBlock PLANT_LOTUS = createLilyPad("plant/lotus");
    public static final TFCWaterPlant PLANT_MANATEE_GRASS = createWaterPlant("plant/manatee_grass");
    public static final TFCWaterPlant PLANT_MARIGOLD = createWaterPlant("plant/marigold");
    public static final TFCGrassPlantBlock PLANT_MEADS_MILKWEED = createGrassPlant("plant/meads_milkweed", 1, 1, 3);
    public static final TFCGrassPlantBlock PLANT_MILFOIL = createGrassPlant("plant/milfoil", 1, 1, 3);
    //Morning glory [all sides]
    //Moss [all sides]
    public static final TFCGrassPlantBlock PLANT_NASTURTIUM = createGrassPlant("plant/nasturtium", 1, 1, 3);
    public static final TFCGrassPlantBlock PLANT_OLIVE_SAPLING = createGrassPlant("plant/olive_sapling", 1, 1, 3);
    public static final TFCGrassPlantBlock PLANT_ORANGE_SAPLING = createGrassPlant("plant/orange_sapling", 1, 1, 3);
    public static final TFCGrassPlantBlock PLANT_ORCHARD_GRASS = createGrassPlant("plant/orchard_grass", 1, 1, 3);
    public static final TFCGrassPlantBlock PLANT_OSTRICH_FERN = createGrassPlant("plant/ostrich_fern", 1, 1, 3);
    public static final TFCGrassPlantBlock PLANT_OXEYE_DAISY = createGrassPlant("plant/oxeye_daisy", 1, 1, 3);
    public static final TFCGrassPlantBlock PLANT_PAMPAS_GRASS = createGrassPlant("plant/pampas_grass", 1, 1, 3);
    public static final TFCGrassPlantBlock PLANT_PEACH_SAPLING = createGrassPlant("plant/peach_sapling", 1, 1, 3);
    public static final TFCGrassPlantBlock PLANT_PEROVSKIA = createGrassPlant("plant/perovskia", 1, 1, 3);
    public static final TFCLilyPadBlock PLANT_PISTIA = createLilyPad("plant/pistia");
    public static final TFCGrassPlantBlock PLANT_PLUM_SAPLING = createGrassPlant("plant/plum_sapling", 1, 1, 3);
    public static final TFCGrassPlantBlock PLANT_POPPY = createGrassPlant("plant/poppy", 1, 1, 3);
    public static final TFCGrassPlantBlock PLANT_PRIMROSE = createGrassPlant("plant/primrose", 1, 1, 3);
    public static final TFCGrassPlantBlock PLANT_PULSATILLA = createGrassPlant("plant/pulsatilla", 1, 1, 3);
    public static final TFCGrassPlantBlock PLANT_RASPBERRY_BUSH = createGrassPlant("plant/raspberry_bush", 1, 1, 3);
    //Rattan has no item
    public static final TFCGrassPlantBlock PLANT_RED_APPLE_SAPLING = createGrassPlant("plant/red_apple_sapling", 1, 1, 3);
    //Reindeer lichen [moss]
    public static final TFCGrassPlantBlock PLANT_ROSE = createGrassPlant("plant/rose", 1, 1, 3);
    public static final TFCGrassPlantBlock PLANT_RYEGRASS = createGrassPlant("plant/ryegrass", 1, 1, 3);
    public static final TFCGrassPlantBlock PLANT_SACRED_DATURA = createGrassPlant("plant/sacred_datura", 1, 1, 3);
    public static final TFCGrassPlantBlock PLANT_SAGEBRUSH = createGrassPlant("plant/sagebrush", 1, 1, 3);
    //Sago can't be placed
    public static final TFCGrassPlantBlock PLANT_SAPPHIRE_TOWER = createGrassPlant("plant/sapphire_tower", 1, 1, 3);
    public static final TFCLilyPadBlock PLANT_SARGASSUM = createLilyPad("plant/sargassum");
    public static final TFCGrassPlantBlock PLANT_SCUTCH_GRASS = createGrassPlant("plant/scutch_grass", 1, 1, 3);
    public static final TFCGrassPlantBlock PLANT_SNAPDRAGON_PINK = createGrassPlant("plant/snapdragon_pink", 1, 1, 3);
    public static final TFCGrassPlantBlock PLANT_SNAPDRAGON_RED = createGrassPlant("plant/snapdragon_red", 1, 1, 3);
    public static final TFCGrassPlantBlock PLANT_SNAPDRAGON_WHITE = createGrassPlant("plant/snapdragon_white", 1, 1, 3);
    public static final TFCGrassPlantBlock PLANT_SNAPDRAGON_YELLOW = createGrassPlant("plant/snapdragon_yellow", 1, 1, 3);
    public static final TFCGrassPlantBlock PLANT_SNOWBERRY_BUSH = createGrassPlant("plant/snowberry_bush", 1, 1, 3);
    //Spanish moss can't be placed
    public static final TFCWaterPlant PLANT_STAR_GRASS = createWaterPlant("plant/star_grass");
    public static final TFCGrassPlantBlock PLANT_STRAWBERRY_BUSH = createGrassPlant("plant/strawberry_bush", 1, 1, 3);
    public static final TFCGrassPlantBlock PLANT_STRELITZIA = createGrassPlant("plant/strelitzia", 1, 1, 3);
    //Sugar cane has no item
    public static final TFCGrassPlantBlock PLANT_SWORD_FERN = createGrassPlant("plant/sword_fern", 1, 1, 3);
    public static final TFCGrassPlantBlock PLANT_TALL_FESCUE_GRASS = createGrassPlant("plant/tall_fescue_grass", 1, 1, 3);
    public static final TFCGrassPlantBlock PLANT_TIMOTHY_GRASS = createGrassPlant("plant/timothy_grass", 1, 1, 3);
    public static final TFCGrassPlantBlock PLANT_TOQUILLA_PALM = createGrassPlant("plant/toquilla_palm", 1, 1, 3);
    public static final TFCGrassPlantBlock PLANT_TREE_FERN = createGrassPlant("plant/tree_fern", 1, 1, 3);
    public static final TFCGrassPlantBlock PLANT_TRILLIUM = createGrassPlant("plant/trillium", 1, 1, 3);
    public static final TFCGrassPlantBlock PLANT_TROPICAL_MILKWEED = createGrassPlant("plant/tropical_milkweed", 1, 1, 3);
    public static final TFCGrassPlantBlock PLANT_TULIP_ORANGE = createGrassPlant("plant/tulip_orange", 1, 1, 3);
    public static final TFCGrassPlantBlock PLANT_TULIP_PINK = createGrassPlant("plant/tulip_pink", 1, 1, 3);
    public static final TFCGrassPlantBlock PLANT_TULIP_RED = createGrassPlant("plant/tulip_red", 1, 1, 3);
    public static final TFCGrassPlantBlock PLANT_TULIP_WHITE = createGrassPlant("plant/tulip_white", 1, 1, 3);
    public static final TFCWaterPlant PLANT_TURTLE_GRASS = createWaterPlant("plant/turtle_grass");
    //vrisea can't be placed
    public static final TFCLilyPadBlock PLANT_WATER_CANNA = createLilyPad("plant/water_canna");
    public static final TFCLilyPadBlock PLANT_WATER_LILY = createLilyPad("plant/water_lily");
    public static final TFCWaterPlant PLANT_WINGED_KELP = createWaterPlant("plant/winged_kelp");
    public static final TFCGrassPlantBlock PLANT_YUCCA = createGrassPlant("plant/yucca", 1, 1, 3);
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
    public static final LogPile LOG_PILE = register("log_pile", new LogPile(FabricBlockSettings.copyOf(Blocks.STONE)));
    public static final SandstoneBlock SANDSTONE_BLACK = new SandstoneBlock("sandstone/black");
    //public static final ToolRackBlock TOOL_RACK_BLOCK = register("tool_rack_block", new ToolRackBlock(FabricBlockSettings.copyOf(Blocks.OAK_WOOD)));
    public static final SandstoneBlock SANDSTONE_BROWN = new SandstoneBlock("sandstone/brown");
    public static final SandstoneBlock SANDSTONE_GREEN = new SandstoneBlock("sandstone/green");
    public static final SandstoneBlock SANDSTONE_PINK = new SandstoneBlock("sandstone/pink");
    public static final SandstoneBlock SANDSTONE_RED = new SandstoneBlock("sandstone/red");
    public static final SandstoneBlock SANDSTONE_WHITE = new SandstoneBlock("sandstone/white");
    public static final SandstoneBlock SANDSTONE_YELLOW = new SandstoneBlock("sandstone/yellow");
    //Misc
    public static final TFCGravityBlock PEAT_GRASS = createSand("peat_grass", true);
    public static final Block FORGE = register("forge", new Forge(FabricBlockSettings.copyOf(Blocks.SAND)), true, TerraFabriCraft.DEVICES_GROUP);
    public static final TFCGravityBlock PEAT = createRock("peat", TerraFabriCraft.EARTH_GROUP);
    public static final TFCLeaves THATCH = createLeaves("thatch", true);
    public static final Block FIRE_BRICKS = createLooseRock("fire_bricks", true);
    public static final Block CALCITE = createLooseRock("calcite", true);
    public static final Block CHARCOAL_PILE = createLooseRock("charcoal_pile", true);
    public static final Block BELLOWS_BLOCK = register("bellows", new BellowsBlock(FabricBlockSettings.copyOf(Blocks.SAND)), true, TerraFabriCraft.DEVICES_GROUP);

    //Block Entities
    public static final BlockEntityType<LogPileBlockEntity> LOG_PILE_BLOCK_ENTITY = register("log_pile_entity", FabricBlockEntityTypeBuilder.create(LogPileBlockEntity::new, TFCObjects.LOG_PILE).build(null));
    public static final BlockEntityType<KegEntity> KEG_BLOCK_ENTITY = register("keg_entity", FabricBlockEntityTypeBuilder.create(KegEntity::new, TFCObjects.WOOD_ACACIA.keg, TFCObjects.WOOD_ASH.keg, TFCObjects.WOOD_ASPEN.keg, TFCObjects.WOOD_BIRCH.keg, TFCObjects.WOOD_BLACKWOOD.keg, TFCObjects.WOOD_CHESTNUT.keg, TFCObjects.WOOD_DOUGLAS_FIR.keg, TFCObjects.WOOD_HICKORY.keg, TFCObjects.WOOD_KAPOK.keg, TFCObjects.WOOD_MAPLE.keg, TFCObjects.WOOD_OAK.keg, TFCObjects.WOOD_PALM.keg, TFCObjects.WOOD_PINE.keg, TFCObjects.WOOD_ROSEWOOD.keg, TFCObjects.WOOD_SEQUOIA.keg, TFCObjects.WOOD_SPRUCE.keg, TFCObjects.WOOD_SYCAMORE.keg, TFCObjects.WOOD_WHITE_CEDAR.keg, TFCObjects.WOOD_WILLOW.keg).build(null));
    public static final Block PLACEABLE = register("pit_kiln", new PlaceableBlock(FabricBlockSettings.copyOf(Blocks.NETHERRACK)), true, TerraFabriCraft.DEVICES_GROUP);
    public static final BlockEntityType<PlaceableBlockEntity> PLACEABLE_BLOCK_ENTITY = register("placeable_block_entity", FabricBlockEntityTypeBuilder.create(PlaceableBlockEntity::new, PLACEABLE).build(null));
    //public static final BlockEntityType<ForgeBlockEntity> FORGE_BLOCK_ENTITY = register("forge_entity", FabricBlockEntityTypeBuilder.create(ForgeBlockEntity::new, FORGE).build(null));
    public static final BlockEntityType<ForgeBlockEntity> FORGE_BLOCK_ENTITY = register("forge_entity", FabricBlockEntityTypeBuilder.create(ForgeBlockEntity::new, FORGE).build(null));
    public static final BlockEntityType<ToolRackBlockEntity> TOOL_RACK_BLOCK_ENTITY = register("tool_rack_block_entity", FabricBlockEntityTypeBuilder.create(ToolRackBlockEntity::new, TFCObjects.WOOD_ACACIA.rack, TFCObjects.WOOD_ASH.rack, TFCObjects.WOOD_ASPEN.rack, TFCObjects.WOOD_BIRCH.rack, TFCObjects.WOOD_BLACKWOOD.rack, TFCObjects.WOOD_CHESTNUT.rack, TFCObjects.WOOD_DOUGLAS_FIR.rack, TFCObjects.WOOD_HICKORY.rack, TFCObjects.WOOD_KAPOK.rack, TFCObjects.WOOD_MAPLE.rack, TFCObjects.WOOD_OAK.rack, TFCObjects.WOOD_PALM.rack, TFCObjects.WOOD_PINE.rack, TFCObjects.WOOD_ROSEWOOD.rack, TFCObjects.WOOD_SEQUOIA.rack, TFCObjects.WOOD_SPRUCE.rack, TFCObjects.WOOD_SYCAMORE.rack, TFCObjects.WOOD_WHITE_CEDAR.rack, TFCObjects.WOOD_WILLOW.rack).build(null));
    public static final BlockEntityType<BellowsBlockEntity> BELLOWS_BLOCK_ENTITY = register("bellows_entity", FabricBlockEntityTypeBuilder.create(BellowsBlockEntity::new,BELLOWS_BLOCK).build(null));

    public static final Block BURNING_LOG_PILE = register("burning_log_pile", new Block(FabricBlockSettings.copyOf(Blocks.SAND)));

    public static final Item STRAW = register("straw", new Item(new FabricItemSettings().group(TerraFabriCraft.DEVICES_GROUP)));
    public static final Item FIRESTARTER = register("firestarter", new FirestarterItem(new FabricItemSettings().group(TerraFabriCraft.DEVICES_GROUP)));


    public static final Item INGOT_MOLD = createItem("ceramic/new_ingot_mold", new Item(gen(TerraFabriCraft.MISC_GROUP)));
    public static final Item UNFIRED_INGOT_MOLD = createItem("ceramic/unfired_ingot_mold", new TFCCeramic(gen(TerraFabriCraft.MISC_GROUP), INGOT_MOLD));

    public static final Item CERAMIC_VESSEL = createItem("ceramic/vessel", new CeramicVessel(gen(TerraFabriCraft.MISC_GROUP)));
    public static final Item UNFIRED_CERAMIC_VESSEL = createItem("ceramic/unfired_vessel", new TFCCeramic(gen(TerraFabriCraft.MISC_GROUP), CERAMIC_VESSEL));


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

    public static <T extends Item> T register(String id, T item) {
        ITEMS.put(item, new Identifier(TerraFabriCraft.MODID, id));
        return item;
    }

    private static <T extends BlockEntity> BlockEntityType<T> register(String id, BlockEntityType<T> type) {
        BLOCK_ENTITY_TYPES.put(type, new Identifier(TerraFabriCraft.MODID, id));
        return type;
    }

    //Blocks
    public static TFCGravityBlock createRock(String id, ItemGroup group) {
        var block = new TFCGravityBlock(FabricBlockSettings.copyOf(Blocks.STONE));
        register(id, block, true, group);
        return block;
    }

    public static TFCStairs createStoneStairs(String id, Block fullBlock, ItemGroup group) {
        var block = new TFCStairs(fullBlock.getDefaultState(), FabricBlockSettings.copyOf(Blocks.ACACIA_STAIRS));
        register(id, block, true, group);
        return block;
    }

    public static SlabBlock createStoneSlab(String id, ItemGroup group) {
        var block = new SlabBlock(FabricBlockSettings.copyOf(Blocks.ACACIA_SLAB));
        register(id, block, true, group);
        return block;
    }

    public static WallBlock createWall(String id, ItemGroup group) {
        var block = new WallBlock(FabricBlockSettings.copyOf(Blocks.ANDESITE_WALL));
        register(id, block, true, group);
        return block;
    }

    public static TFCGrassBlock createGrass(String id, BlockSoundGroup sound) {
        var block = new TFCGrassBlock(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(sound));
        register(id, block, true, TerraFabriCraft.EARTH_GROUP);
        return block;
    }

    public static TFCCoralBlock createCoralBlock(String id, TFCDeadCoralBlock deadCoralBlock) {
        var block = new TFCCoralBlock(deadCoralBlock, FabricBlockSettings.copyOf(Blocks.BRAIN_CORAL));
        register(id, block, true, TerraFabriCraft.FLORA_GROUP);
//        BlockRenderLayerMap.INSTANCE.putBlock(block, RenderLayer.getCutout());
        return block;
    }

    public static TFCCoralFanBlock createCoralFanBlock(String id, TFCDeadCoralFanBlock deadCoralFanBlock) {
        var block = new TFCCoralFanBlock(deadCoralFanBlock, FabricBlockSettings.copyOf(Blocks.BRAIN_CORAL_FAN));
        register(id, block, true, TerraFabriCraft.FLORA_GROUP);
//        BlockRenderLayerMap.INSTANCE.putBlock(block, RenderLayer.getCutout());
        return block;
    }

    public static TFCDeadCoralBlock createDeadCoralBlock(String id) {
        var block = new TFCDeadCoralBlock(FabricBlockSettings.copyOf(Blocks.DEAD_BRAIN_CORAL_BLOCK));
        register(id, block, true, TerraFabriCraft.FLORA_GROUP);
//        BlockRenderLayerMap.INSTANCE.putBlock(block, RenderLayer.getCutout());
        return block;
    }

    public static TFCDeadCoralFanBlock createDeadCoralFanBlock(String id) {
        var block = new TFCDeadCoralFanBlock(FabricBlockSettings.copyOf(Blocks.DEAD_BRAIN_CORAL_FAN));
        register(id, block, true, TerraFabriCraft.FLORA_GROUP);
//        BlockRenderLayerMap.INSTANCE.putBlock(block, RenderLayer.getCutout());
        return block;
    }

    public static Block createCrop(String id, int temp, int speed, boolean tall, Item cropItem, int maxAge) {
        var block = tall ? new TFCCropsTall(copyOf(Blocks.WHEAT), temp, speed) : new TFCCrops(copyOf(Blocks.WHEAT), temp, speed, cropItem, maxAge);
        register("crop/" + id, block, true, TerraFabriCraft.FLORA_GROUP);
        return block;
    }

    public static TFCFarmlandBlock createFarmland(String id, boolean hasItem) {
        var block = new TFCFarmlandBlock(FabricBlockSettings.copyOf(Blocks.FARMLAND));
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

    public static TFCAnvil createAnvil(String id) {
        var block = new TFCAnvil(FabricBlockSettings.copyOf(Blocks.ANVIL));
        register("metal/anvil/" + id, block, true, TerraFabriCraft.METAL_GROUP);
        return block;
    }

    public static LanternBlock createLamp(String id) {
        //TODO: Fix lamp bounding box
        var block = new LanternBlock(FabricBlockSettings.copyOf(Blocks.LANTERN));
        register("metal/lamp/" + id, block, true, TerraFabriCraft.METAL_GROUP);
        return block;
    }

    public static TFCGrassPlantBlock createGrassPlant(String id, int temp, int speed, int collisionLevel) {
        var block = new TFCGrassPlantBlock(FabricBlockSettings.copyOf(Blocks.WHEAT), temp, speed, collisionLevel, 8);
        register(id, block, true, TerraFabriCraft.FLORA_GROUP);
        return block;
    }

    public static TFCWaterPlant createWaterPlant(String id) {
        var block = new TFCWaterPlant(FabricBlockSettings.copyOf(Blocks.KELP_PLANT));
        register(id, block, true, TerraFabriCraft.FLORA_GROUP);
        return block;
    }

    public static TFCLilyPadBlock createLilyPad(String id) {
        var block = new TFCLilyPadBlock(FabricBlockSettings.copyOf(Blocks.LILY_PAD));
        register(id, block, true, TerraFabriCraft.FLORA_GROUP);
        return block;
    }

    public static TFCStoneButtonBlock createStoneButton(String id) {
        var block = new TFCStoneButtonBlock(FabricBlockSettings.copyOf(Blocks.STONE_BUTTON));
        register(id, block, true, TerraFabriCraft.DECORATIONS_GROUP);
        return block;
    }

    public static Block createGroundOre(String id, boolean hasBlockItem, int meltingPoint) {
        var block = new GroundCoverOre(FabricBlockSettings.of(Material.WOOD).breakByTool(FabricToolTags.AXES).sounds(BlockSoundGroup.WOOD).strength(2.0f));
        createItem(id, new GroundCoverOreBlockItem(block, gen(TerraFabriCraft.EARTH_GROUP), meltingPoint));
        register(id, block);
        return block;
    }

    public static TFCGravityBlock createSand(String id, boolean hasBlockItem) {
        var block = new TFCGravityBlock(FabricBlockSettings.copyOf(Blocks.SAND));
        register(id, block, hasBlockItem, TerraFabriCraft.EARTH_GROUP);
        return block;
    }

    public static TFCFallenLeavesBlock createFallenLeaves(String id) {
        var block = new TFCFallenLeavesBlock(FabricBlockSettings.copyOf(Blocks.ACACIA_LEAVES).noCollision());
        register(id, block, true, TerraFabriCraft.WOOD_GROUP);
        return block;
    }

    public static TFCSupport createSupport(String id, boolean hasBlockItem) {
        var block = new TFCSupport(FabricBlockSettings.copyOf(Blocks.OAK_WOOD).nonOpaque());
        register(id, block, hasBlockItem, TerraFabriCraft.WOOD_GROUP);
        return block;
    }

    public static Keg createKeg(String id, boolean hasBlockItem) {
        var block = new Keg(FabricBlockSettings.copyOf(Blocks.OAK_WOOD));
        register(id, block, hasBlockItem, TerraFabriCraft.WOOD_GROUP);
        return block;
    }

    public static TFCLeaves createLeaves(String id, boolean hasBlockItem) {
        var block = new TFCLeaves(FabricBlockSettings.copyOf(Blocks.ACACIA_LEAVES).noCollision());
        register(id, block, hasBlockItem, TerraFabriCraft.WOOD_GROUP);
        return block;
    }

    public static TFCLog createLog(String id, MapColor color, boolean hasBlockItem) {
        var block = new TFCLog(FabricBlockSettings.copyOf(Blocks.OAK_WOOD).mapColor(color));
        register(id, block, false, TerraFabriCraft.WOOD_GROUP);
        register(id, new TFCLogItem(block, new FabricItemSettings().group(TerraFabriCraft.WOOD_GROUP)));
        return block;
    }

    public static Block createFlammableBlock(String id, MapColor color, boolean hasBlockItem) {
        var block = new Block(FabricBlockSettings.copyOf(Blocks.OAK_WOOD).mapColor(color));
        register(id, block, true, TerraFabriCraft.WOOD_GROUP);
        return block;
    }

    public static ToolRackBlock createRack(String id, boolean hasBlockItem) {
        var block = new ToolRackBlock(FabricBlockSettings.copyOf(Blocks.OAK_WOOD));
        register(id, block, hasBlockItem, TerraFabriCraft.WOOD_GROUP);
        return block;
    }

    public static TFCGrassBlock createGrass(String id, boolean hasBlockItem) {
        var block = new TFCGrassBlock(FabricBlockSettings.of(Material.LEAVES).breakByTool(FabricToolTags.HOES).sounds(BlockSoundGroup.GRASS).strength(2.0f));
        register(id, block, hasBlockItem, TerraFabriCraft.EARTH_GROUP);
        return block;
    }

    public static TFCSapling createSapling(String id, boolean hasBlockItem, SaplingGenerator generator) {
        var block = new TFCSapling(generator, FabricBlockSettings.copyOf(Blocks.OAK_SAPLING));
//        BlockRenderLayerMap.INSTANCE.putBlock(block, RenderLayer.getCutout());
        register(id, block, hasBlockItem, TerraFabriCraft.WOOD_GROUP);
        return block;
    }

    public static TFCTwig createTwig(String id, boolean hasBlockItem) {
        var block = new TFCTwig(FabricBlockSettings.of(Material.WOOD).breakByTool(FabricToolTags.AXES).sounds(BlockSoundGroup.WOOD).strength(2.0f));
        register(id, block, hasBlockItem, TerraFabriCraft.WOOD_GROUP);
        return block;
    }

    public static TFCLooseRock createLooseRock(String id, boolean hasBlockItem) {
        var block = new TFCLooseRock(FabricBlockSettings.of(Material.STONE).breakByTool(FabricToolTags.PICKAXES).sounds(BlockSoundGroup.STONE).strength(6.0f));
        register(id, block, hasBlockItem, TerraFabriCraft.ROCK_GROUP);
        return block;
    }

    //Items

    public static Item createFood(String id, int weigthCategory, int sizeCategory) {
        var item = new TFCFood(id, gen(TerraFabriCraft.FOOD_GROUP), weigthCategory, sizeCategory);
        register("food/" + id, item);
        return item;
    }

    private static <T extends Item> T createItem(String id, T item) {
        ITEMS.put(item, new Identifier(TerraFabriCraft.MODID, id));
        return item;
    }

    public static Item createItemSimple(String id, ItemGroup group) {
        var item = new Item(gen(group));
        register(id, item);
        return item;
    }

    public static TFCMetalItem createMetalItem(String id, ItemGroup group, int temp) {
        var item = new TFCMetalItem(gen(group), temp);
        register(id, item);
        return item;
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
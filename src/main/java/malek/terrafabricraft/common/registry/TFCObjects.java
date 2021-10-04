package malek.terrafabricraft.common.registry;

import malek.terrafabricraft.TerraFabriCraft;
import malek.terrafabricraft.common.block.*;
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
import malek.terrafabricraft.common.item.GroundCoverOreBlockItem;
import malek.terrafabricraft.common.item.TFCFood;
import malek.terrafabricraft.common.item.TFCMetalItem;
import malek.terrafabricraft.common.item.ceramic.CeramicVessel;
import malek.terrafabricraft.common.world.generator.tree.GenericSaplingGenerator;
import malek.terrafabricraft.common.world.generator.tree.KapokSaplingGenerator;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.fabricmc.fabric.api.tag.TagFactory;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.item.*;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.tag.Tag;
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

    // Debug + Testing
    public static final Item TEST_FOOD = createFood("test_food", 1, 1);
    public static final Item CERAMIC_VESSEL = createItem("ceramic/vessel", new CeramicVessel(gen(TerraFabriCraft.DEVICES_GROUP)));

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
    //public static final TFCFood MILK = new TFCFood("barley_bread", new FabricItemSettings(), 1, 1);


    public static final SoilBlock CLAY = new SoilBlock("clay", BlockSoundGroup.GRAVEL);
    public static final SoilBlock CLAY_GRASS = new SoilBlock("clay_grass", BlockSoundGroup.GRAVEL);
    public static final SoilBlock DIRT = new SoilBlock("dirt", BlockSoundGroup.GRAVEL);

    public static final TFCGravityBlock FARMLAND_LOAM = createFarmland("farmland/loam", true);
    public static final TFCGravityBlock FARMLAND_SANDY_LOAM = createFarmland("farmland/sandy_loam", true);
    public static final TFCGravityBlock FARMLAND_SILT = createFarmland("farmland/silt", true);
    public static final TFCGravityBlock FARMLAND_SILTY_LOAM = createFarmland("farmland/silty_loam", true);
    public static final SoilBlock GRASS = new SoilBlock("grass", BlockSoundGroup.GRASS);

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

    public static final TFCGrassCrop PLANT_ALLIUM = createGrassCrop("plant/allium", 1, 1, 1);
    public static final TFCGrassCrop PLANT_ARUNDO = createGrassCrop("plant/arundo", 1, 1, 3);
    public static final TFCGrassCrop PLANT_ATHYRIUM_FERN = createGrassCrop("plant/athyrium_fern", 1, 1, 1);
    //Badderlocks [dirt]
    public static final TFCGrassCrop PLANT_BANANA_SAPLING = createGrassCrop("plant/banana_sapling", 1, 1, 1);
    public static final TFCGrassCrop PLANT_BLACK_ORCHID = createGrassCrop("plant/black_orchid", 1, 1, 1);
    public static final TFCGrassCrop PLANT_BLACKBERRY_BUSH = createGrassCrop("plant/blackberry_bush", 1, 1, 3);
    //Blackberry bush cane [side]
    public static final TFCGrassCrop PLANT_BLOOD_LILY = createGrassCrop("plant/blood_lily", 1, 1, 3);
    public static final TFCGrassCrop PLANT_BLUE_ORCHID = createGrassCrop("plant/blue_orchid", 1, 1, 3);
    public static final TFCGrassCrop PLANT_BLUEBERRY_BUSH = createGrassCrop("plant/blueberry_bush", 1, 1, 3);
    public static final TFCGrassCrop PLANT_BUNCHBERRY_BUSH = createGrassCrop("plant/bunchberry_bush", 1, 1, 3);
    public static final TFCGrassCrop PLANT_BUTTERFLY_MILKWEED = createGrassCrop("plant/butterfly_milkweed", 1, 1, 3);
    public static final TFCGrassCrop PLANT_CALENDULA = createGrassCrop("plant/calendula", 1, 1, 3);
    public static final TFCGrassCrop PLANT_CANNA = createGrassCrop("plant/canna", 1, 1, 3);
    //Cattail [dirt]
    public static final TFCGrassCrop PLANT_CHERRY_SAPLING = createGrassCrop("plant/cherry_sapling", 1, 1, 3);
    public static final TFCGrassCrop PLANT_CLOUDBERRY_BUSH = createGrassCrop("plant/cloudberry_bush", 1, 1, 3);
    //Coontail [water]
    public static final TFCGrassCrop PLANT_CRANBERRY_BUSH = createGrassCrop("plant/cranberry_bush", 1, 1, 3);
    public static final TFCGrassCrop PLANT_DANDELION = createGrassCrop("plant/dandelion", 1, 1, 3);
    //Dead berry bush has no item
    //Dead cane has no item
    //Duckweed [water]
    //Eel grass [water]
    public static final TFCGrassCrop PLANT_ELDERBERRY_BUSH = createGrassCrop("plant/elderberry_bush", 1, 1, 3);
    public static final TFCGrassCrop PLANT_FIELD_HORSETAIL = createGrassCrop("plant/field_horsetail", 1, 1, 3);
    public static final TFCGrassCrop PLANT_FOUNTAIN_GRASS = createGrassCrop("plant/fountain_grass", 1, 1, 3);
    public static final TFCGrassCrop PLANT_FOXGLOVE = createGrassCrop("plant/foxglove", 1, 1, 3);
    //Kelp [water]
    public static final TFCGrassCrop PLANT_GOLDENROD = createGrassCrop("plant/goldenrod", 1, 1, 3);
    public static final TFCGrassCrop PLANT_GOOSEBERRY_BUSH = createGrassCrop("plant/gooseberry_bush", 1, 1, 3);
    public static final TFCGrassCrop PLANT_GRAPE_HYACINTH = createGrassCrop("plant/grape_hyacinth", 1, 1, 3);
    public static final TFCGrassCrop PLANT_GREEN_APPLE_SAPLING = createGrassCrop("plant/green_apple_sapling", 1, 1, 3);
    //Gutweed [nowhere]
    //Guzmania [nowhere]
    //Hanging vines [top]
    public static final TFCGrassCrop PLANT_HOUSTONIA = createGrassCrop("plant/houstonia", 1, 1, 3);
    //Ivy [side]
    //Jungle vines [side]
    public static final TFCGrassCrop PLANT_LABRADOR_TEA = createGrassCrop("plant/labrador_tea", 1, 1, 3);
    public static final TFCGrassCrop PLANT_LADY_FERN = createGrassCrop("plant/lady_fern", 1, 1, 3);
    //Laminaria [nowhere]
    //Leafy kelp [water]
    public static final TFCGrassCrop PLANT_LEMON_SAPLING = createGrassCrop("plant/lemon_sapling", 1, 1, 3);
    //Liana [top]
    //Licore plant [side]
    //Lotus [lilypad]
    //Manatee grass [water]
    //Marigold [water]
    public static final TFCGrassCrop PLANT_MEADS_MILKWEED = createGrassCrop("plant/meads_milkweed", 1, 1, 3);
    public static final TFCGrassCrop PLANT_MILFOIL = createGrassCrop("plant/milfoil", 1, 1, 3);
    //Morning glory [all sides]
    //Moss [all sides]
    public static final TFCGrassCrop PLANT_NASTURTIUM = createGrassCrop("plant/nasturtium", 1, 1, 3);
    public static final TFCGrassCrop PLANT_OLIVE_SAPLING = createGrassCrop("plant/olive_sapling", 1, 1, 3);
    public static final TFCGrassCrop PLANT_ORANGE_SAPLING = createGrassCrop("plant/orange_sapling", 1, 1, 3);
    public static final TFCGrassCrop PLANT_ORCHARD_GRASS = createGrassCrop("plant/orchard_grass", 1, 1, 3);
    public static final TFCGrassCrop PLANT_OSTRICH_FERN = createGrassCrop("plant/ostrich_fern", 1, 1, 3);
    public static final TFCGrassCrop PLANT_OXEYE_DAISY = createGrassCrop("plant/oxeye_daisy", 1, 1, 3);
    public static final TFCGrassCrop PLANT_PAMPAS_GRASS = createGrassCrop("plant/pampas_grass", 1, 1, 3);
    public static final TFCGrassCrop PLANT_PEACH_SAPLING = createGrassCrop("plant/peach_sapling", 1, 1, 3);
    public static final TFCGrassCrop PLANT_PEROVSKIA = createGrassCrop("plant/perovskia", 1, 1, 3);
    //Pistia [lilypad]
    public static final TFCGrassCrop PLANT_PLUM_SAPLING = createGrassCrop("plant/plum_sapling", 1, 1, 3);
    public static final TFCGrassCrop PLANT_POPPY = createGrassCrop("plant/poppy", 1, 1, 3);
    public static final TFCGrassCrop PLANT_PRIMROSE = createGrassCrop("plant/primrose", 1, 1, 3);
    public static final TFCGrassCrop PLANT_PULSATILLA = createGrassCrop("plant/pulsatilla", 1, 1, 3);
    public static final TFCGrassCrop PLANT_RASPBERRY_BUSH = createGrassCrop("plant/raspberry_bush", 1, 1, 3);
    //Rattan has no item
    public static final TFCGrassCrop PLANT_RED_APPLE_SAPLING = createGrassCrop("plant/red_apple_sapling", 1, 1, 3);
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
    //public static final ToolRackBlock TOOL_RACK_BLOCK = register("tool_rack_block", new ToolRackBlock(FabricBlockSettings.copyOf(Blocks.OAK_WOOD)));

    public static final SandstoneBlock SANDSTONE_BLACK = new SandstoneBlock("sandstone/black");
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
    public static final Block BELLOWS = createLooseRock("bellows", true);
    public static final Block CHARCOAL_PILE = createLooseRock("charcoal_pile", true);


    //Misc
    public static final Block PLACEABLE = register("placeable", new PlaceableBlock(FabricBlockSettings.copyOf(Blocks.SAND)),true, TerraFabriCraft.DEVICES_GROUP);


    //Block Entities
    public static final BlockEntityType<LogPileBlockEntity> LOG_PILE_BLOCK_ENTITY = register("log_pile_entity", FabricBlockEntityTypeBuilder.create(LogPileBlockEntity::new, TFCObjects.LOG_PILE).build(null));
    public static final BlockEntityType<KegEntity> KEG_BLOCK_ENTITY = register("keg_entity", FabricBlockEntityTypeBuilder.create(KegEntity::new, TFCObjects.WOOD_ACACIA.keg, TFCObjects.WOOD_ASH.keg, TFCObjects.WOOD_ASPEN.keg, TFCObjects.WOOD_BIRCH.keg, TFCObjects.WOOD_BLACKWOOD.keg, TFCObjects.WOOD_CHESTNUT.keg, TFCObjects.WOOD_DOUGLAS_FIR.keg, TFCObjects.WOOD_HICKORY.keg, TFCObjects.WOOD_KAPOK.keg, TFCObjects.WOOD_MAPLE.keg, TFCObjects.WOOD_OAK.keg, TFCObjects.WOOD_PALM.keg, TFCObjects.WOOD_PINE.keg, TFCObjects.WOOD_ROSEWOOD.keg, TFCObjects.WOOD_SEQUOIA.keg, TFCObjects.WOOD_SPRUCE.keg, TFCObjects.WOOD_SYCAMORE.keg, TFCObjects.WOOD_WHITE_CEDAR.keg, TFCObjects.WOOD_WILLOW.keg).build(null));

    public static final BlockEntityType<ToolRackBlockEntity> TOOL_RACK_BLOCK_ENTITY = register("tool_rack_block_entity", FabricBlockEntityTypeBuilder.create(ToolRackBlockEntity::new, TFCObjects.WOOD_ACACIA.rack, TFCObjects.WOOD_ASH.rack, TFCObjects.WOOD_ASPEN.rack, TFCObjects.WOOD_BIRCH.rack, TFCObjects.WOOD_BLACKWOOD.rack, TFCObjects.WOOD_CHESTNUT.rack, TFCObjects.WOOD_DOUGLAS_FIR.rack, TFCObjects.WOOD_HICKORY.rack, TFCObjects.WOOD_KAPOK.rack, TFCObjects.WOOD_MAPLE.rack, TFCObjects.WOOD_OAK.rack, TFCObjects.WOOD_PALM.rack, TFCObjects.WOOD_PINE.rack, TFCObjects.WOOD_ROSEWOOD.rack, TFCObjects.WOOD_SEQUOIA.rack, TFCObjects.WOOD_SPRUCE.rack, TFCObjects.WOOD_SYCAMORE.rack, TFCObjects.WOOD_WHITE_CEDAR.rack, TFCObjects.WOOD_WILLOW.rack).build(null));

    public static final BlockEntityType<ForgeBlockEntity> FORGE_BLOCK_ENTITY = register("forge_entity", FabricBlockEntityTypeBuilder.create(ForgeBlockEntity::new, FORGE).build(null));
    public static final BlockEntityType<PlaceableBlockEntity> PLACEABLE_BLOCK_ENTITY = register("placeable_block_entity", FabricBlockEntityTypeBuilder.create(PlaceableBlockEntity::new, PLACEABLE).build(null));
    //public static final BlockEntityType<ForgeBlockEntity> FORGE_BLOCK_ENTITY = register("forge_entity", FabricBlockEntityTypeBuilder.create(ForgeBlockEntity::new, FORGE).build(null));

    //Tags
    public static final Tag<Block> CAN_PLANT_GRASS_ON = TagFactory.BLOCK.create(new Identifier(TerraFabriCraft.MODID, "can_plant_grass_on"));
    public static final Tag<Block> CAN_PLANT_CROPS_ON = TagFactory.BLOCK.create(new Identifier(TerraFabriCraft.MODID, "can_plant_crops_on"));

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

    public static TFCGravityGrassBlock createGrass(String id, BlockSoundGroup sound) {
        var block = new TFCGravityGrassBlock(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(sound));
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

    public static Block createCrop(String id, int temp, int speed, boolean tall, boolean hasBlockItem) {
        var block = tall ? new TFCCropsTall(copyOf(Blocks.WHEAT), temp, speed) : new TFCCrops(copyOf(Blocks.WHEAT), temp, speed);
        register("crop/" + id, block, hasBlockItem, TerraFabriCraft.FLORA_GROUP);
        return block;
    }

    public static TFCGravityBlock createFarmland(String id, boolean hasItem) {
        var block = new TFCGravityBlock(FabricBlockSettings.copyOf(Blocks.FARMLAND));
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
    public static TFCGrassCrop createGrassCrop(String id, int temp, int speed, int collisionLevel) {
        var block = new TFCGrassCrop(FabricBlockSettings.copyOf(Blocks.WHEAT), temp, speed, collisionLevel);
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
        register(id, block, hasBlockItem, TerraFabriCraft.WOOD_GROUP);
        return block;
    }


    public static Block createFlammableBlock(String id, MapColor color, boolean hasBlockItem) {
        var block = new Block(FabricBlockSettings.copyOf(Blocks.OAK_WOOD).mapColor(color));
        register(id, block, hasBlockItem, TerraFabriCraft.WOOD_GROUP);
        return block;
    }

    public static ToolRackBlock createRack(String id, boolean hasBlockItem) {
        var block = new ToolRackBlock(FabricBlockSettings.copyOf(Blocks.OAK_WOOD));
        register(id, block, hasBlockItem, TerraFabriCraft.WOOD_GROUP);
        return block;
    }

    public static TFCGravityGrassBlock createGrass(String id, boolean hasBlockItem) {
        var block = new TFCGravityGrassBlock(FabricBlockSettings.of(Material.LEAVES).breakByTool(FabricToolTags.HOES).sounds(BlockSoundGroup.GRASS).strength(2.0f));
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
package com.bloomhousemc.terrafabricraft.common.registry;

import com.bloomhousemc.terrafabricraft.common.item.FirestarterItem;
import com.bloomhousemc.terrafabricraft.common.item.TfcCeramicItem;
import com.bloomhousemc.terrafabricraft.common.item.TfcFoodItem;
import com.bloomhousemc.terrafabricraft.common.item.TfcMetalItem;
import com.bloomhousemc.terrafabricraft.common.item.ceramic.CeramicVessel;
import com.bloomhousemc.terrafabricraft.common.registry.util.MetalItem;
import com.bloomhousemc.terrafabricraft.common.registry.util.OreItem;
import com.bloomhousemc.terrafabricraft.common.registry.util.StoneItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Block;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static com.bloomhousemc.terrafabricraft.TerraFabriCraft.MODID;
import static com.bloomhousemc.terrafabricraft.common.registry.TfcItemGroups.*;

@SuppressWarnings("unused")
public final class TfcItems {
    public static final Item BITUMINOUSE_COAL = createSimpleItem("ore/bituminous_coal", ORES_GROUP);
    public static final Item LIGNITE = createSimpleItem("ore/lignite", ORES_GROUP);
    public static final Item KAOLINITE = createSimpleItem("ore/kaolinite", ORES_GROUP);    //Seeds    public static final Block BARLEY_CROP = createCrop("barley_crop", 0, 1, false, TfcItems.BARLEY_SEED, 9);
    public static final Item GYPSUM = createSimpleItem("ore/gypsum", ORES_GROUP);
    public static final Item GRAPHITE = createSimpleItem("ore/graphite", ORES_GROUP);
    public static final Item SULFUR = createSimpleItem("ore/sulfur", ORES_GROUP);
    public static final Item CINNABAR = createSimpleItem("ore/cinnabar", ORES_GROUP);
    public static final Item CRYOLITE = createSimpleItem("ore/cryolite", ORES_GROUP);
    public static final Item SALPETER = createSimpleItem("ore/saltpeter", ORES_GROUP);
    public static final Item SYLVITE = createSimpleItem("ore/sylvite", ORES_GROUP);
    public static final Item BORAX = createSimpleItem("ore/borax", ORES_GROUP);
    public static final Item HALITE = createSimpleItem("ore/halite", ORES_GROUP);
    public static final Item AMETHYST = createSimpleItem("ore/amethyst", ORES_GROUP);
    public static final Item DIAMOND = createSimpleItem("ore/diamond", ORES_GROUP);
    public static final Item EMERALD = createSimpleItem("ore/emerald", ORES_GROUP);
    public static final Item LAPIS_LAZULI = createSimpleItem("ore/lapis_lazuli", ORES_GROUP);
    public static final Item OPAL = createSimpleItem("ore/opal", ORES_GROUP);
    public static final Item PYRITE = createSimpleItem("ore/pyrite", ORES_GROUP);
    public static final Item RUBY = createSimpleItem("ore/ruby", ORES_GROUP);
    public static final Item SAPPHIRE = createSimpleItem("ore/sapphire", ORES_GROUP);
    public static final Item TOPAZ = createSimpleItem("ore/topaz", ORES_GROUP);
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
    //Seed
//    public static final Item BARLEY_SEED = createFlora("seed/barley_seeds", TfcBlocks.BARLEY_CROP);
//    public static final Item CABBAGE_SEED = createFlora("seed/cabbage_seeds", TfcBlocks.CABBAGE_CROP);
//    public static final Item CARROT_SEED = createFlora("seed/carrot_seeds", TfcBlocks.CARROT_CROP);
//    public static final Item GARLIC_SEED = createFlora("seed/garlic_seeds", TfcBlocks.GARLIC_CROP);
//    public static final Item GREENBEAN_SEED = createFlora("seed/greenbean_seeds", TfcBlocks.GREENBEAN_CROP);
//    public static final Item JUTE_SEED = createFlora("seed/jute_seeds", TfcBlocks.JUTE_CROP);
//    public static final Item MAIZE_SEED = createFlora("seed/maize_seeds", TfcBlocks.MAIZE_CROP);
//    public static final Item OAT_SEED = createFlora("seed/oat_seeds", TfcBlocks.OAT_CROP);
//    public static final Item ONION_SEED = createFlora("seed/onion_seeds", TfcBlocks.ONION_CROP);
//    public static final Item POTATO_SEED = createFlora("seed/potato_seeds", TfcBlocks.POTATO_CROP);
//    public static final Item RED_BELL_PEPPER_SEED = createFlora("seed/red_bell_pepper_seeds", TfcBlocks.RED_BELL_PEPPER_CROP);
//    public static final Item RICE_SEED = createFlora("seed/rice_seeds", TfcBlocks.RICE_CROP);
//    public static final Item RUTABAGA_SEED = createFlora("seed/rutabaga_seeds", TfcBlocks.RUTABAGA_CROP);
//    public static final Item RYE_SEED = createFlora("seed/rye_seeds", TfcBlocks.RYE_CROP);
//    public static final Item SOYBEAN_SEED = createFlora("seed/soybean_seeds", TfcBlocks.SOYBEAN_CROP);
//    public static final Item SQUASH_SEED = createFlora("seed/squash_seeds", TfcBlocks.SQUASH_CROP);
//    public static final Item TOMATO_SEED = createFlora("seed/tomato_seeds", TfcBlocks.TOMATO_CROP);
//    public static final Item WHEAT_SEED = createFlora("seed/wheat_seeds", TfcBlocks.WHEAT_CROP);
//    public static final Item YELLOW_BELL_PEPPER_SEED = createFlora("seed/yellow_bell_pepper_seeds", TfcBlocks.YELLOW_BELL_PEPPER_CROP);
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
    public static final Item YEAST_BREWERS = createSimpleItem("food/yeast_brewers", FOOD_GROUP);
    public static final Item YEAST_LAGER = createSimpleItem("food/yeast_lager", FOOD_GROUP);
    public static final Item YEAST_ALE = createSimpleItem("food/yeast_ale", FOOD_GROUP);
    public static final Item HOP_CENTENNIAL = createSimpleItem("food/hop_centennial", FOOD_GROUP);
    public static final Item HOP_CASCADE = createSimpleItem("food/hop_cascade", FOOD_GROUP);
    public static final Item HOP_CITRA = createSimpleItem("food/hop_citra", FOOD_GROUP);
    public static final Item HOP_MOSAIC = createSimpleItem("food/hop_mosaic", FOOD_GROUP);
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
    public static final Item BARLEY = createSimpleItem("food/barley", FOOD_GROUP);
    public static final Item BARLEY_FLOUR = createSimpleItem("food/barley_flour", FOOD_GROUP);
    public static final Item BARLEY_DOUGH = createSimpleItem("food/barley_dough", FOOD_GROUP);
    public static final Item MAIZE = createSimpleItem("food/maize", FOOD_GROUP);
    public static final Item MAIZE_FLOUR = createSimpleItem("food/maize_flour", FOOD_GROUP);
    public static final Item MAIZE_DOUGH = createSimpleItem("food/maize_dough", FOOD_GROUP);
    public static final Item OAT = createSimpleItem("food/oat", FOOD_GROUP);
    public static final Item OAT_FLOUR = createSimpleItem("food/oat_flour", FOOD_GROUP);
    public static final Item OAT_DOUGH = createSimpleItem("food/oat_dough", FOOD_GROUP);
    public static final Item RYE = createSimpleItem("food/rye", FOOD_GROUP);
    public static final Item RYE_FLOUR = createSimpleItem("food/rye_flour", FOOD_GROUP);
    public static final Item RYE_DOUGH = createSimpleItem("food/rye_dough", FOOD_GROUP);
    public static final Item RICE = createSimpleItem("food/rice", FOOD_GROUP);
    public static final Item RICE_FLOUR = createSimpleItem("food/rice_flour", FOOD_GROUP);
    public static final Item RICE_DOUGH = createSimpleItem("food/rice_dough", FOOD_GROUP);
    public static final Item WHEAT = createSimpleItem("food/wheat", FOOD_GROUP);
    public static final Item WHEAT_FLOUR = createSimpleItem("food/wheat_flour", FOOD_GROUP);
    public static final Item WHEAT_DOUGH = createSimpleItem("food/wheat_dough", FOOD_GROUP);
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
    public static final Item STRAW = register("straw", new Item(new FabricItemSettings().group(DEVICES_GROUP)));
    public static final Item FIRESTARTER = register("firestarter", new FirestarterItem(new FabricItemSettings().group(DEVICES_GROUP)));
    public static final Item INGOT_MOLD = register("ceramic/new_ingot_mold", new Item(gen(MISC_GROUP)));
    public static final Item UNFIRED_INGOT_MOLD = register("ceramic/unfired_ingot_mold", new TfcCeramicItem(gen(MISC_GROUP), INGOT_MOLD));
    public static final Item CERAMIC_VESSEL = register("ceramic/vessel", new CeramicVessel(gen(MISC_GROUP)));
    public static final Item UNFIRED_CERAMIC_VESSEL = register("ceramic/unfired_vessel", new TfcCeramicItem(gen(MISC_GROUP), CERAMIC_VESSEL));

    private TfcItems() {
    }

    public static Item createSimpleItem(String id, ItemGroup group) {
        var item = new Item(gen(group));
        register(id, item);
        return item;
    }

    public static Item createFlora(String id, Block block) {
        var item = new AliasedBlockItem(block, gen(FLORA_GROUP));
        register(id, item);
        return item;
    }

    public static TfcMetalItem createMetal(String id, ItemGroup group, int temp) {
        var item = new TfcMetalItem(gen(group), temp);
        register(id, item);
        return item;
    }


    public static TfcFoodItem createFood(String id, int weightCategory, int sizeCategory) {
        var item = new TfcFoodItem(id, gen(FOOD_GROUP), weightCategory, sizeCategory);
        register("food/" + id, item);
        return item;
    }

    private static Item.Settings gen(ItemGroup itemGroup) {
        return new Item.Settings().group(itemGroup);
    }

    private static <T extends Item> T register(String id, T item) {
        Registry.register(Registry.ITEM, new Identifier(MODID, id), item);
        return item;
    }

    public static void init() {
    }
}

package malek.terrafabricraft.common.registry;

import malek.terrafabricraft.TerraFabriCraft;
import malek.terrafabricraft.common.block.TFCGravityBlock;
import malek.terrafabricraft.common.block.TFCLogs;
import malek.terrafabricraft.common.block.entity.RockBlockEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.LeavesBlock;
import net.minecraft.block.Material;
import net.minecraft.block.SandBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
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
    public static final Block CLAY_LOAM = createGravel("clay/loam", true);
    //Stone
    public static final Block ROCK_BLOCK = createRock("rock_block", true);
    public static final Block ORE_SMALL_BISMUTHINITE = createRock("ore/small_bismuthinite", true);
    public static final Block ORE_SMALL_CASSITERITE = createRock("ore/small_cassiterite", true);
    public static final Block ORE_SMALL_GARNIERITE = createRock("ore/small_garnierite", true);
    public static final Block ORE_SMALL_HEMATITE = createRock("ore/small_hematite", true);
    public static final Block ORE_SMALL_LIMONITE = createRock("ore/small_limonite", true);
    public static final Block ORE_SMALL_MAGNETITE = createRock("ore/small_magnetite", true);
    public static final Block ORE_SMALL_MALACHITE = createLog("ore/small_malachite", true);
    public static final Block ORE_SMALL_NATIVE_COPPPER = createRock("ore/small_native_copper", true);
    public static final Block ORE_SMALL_NATIVE_GOLD = createRock("ore/small_native_gold", true);
    public static final Block ORE_SMALL_NATIVE_SILVER = createRock("ore/small_native_silver", true);
    public static final Block ORE_SMALL_SPHALERITE = createRock("ore/small_sphalerite", true);
    public static final Block ORE_SMALL_TETRAHEDRITE = createRock("ore/small_tetrahedrite", true);

    //Dirt
    public static final TFCGravityBlock DIRT_SILT = createSand("dirt/silt", true);
    public static final TFCGravityBlock DIRT_SILTY_LOAM = createSand("dirt/silty_loam", true);
    public static final TFCGravityBlock DIRT_LOAM = createSand("dirt/loam", true);
    public static final TFCGravityBlock DIRT_SANDY_LOAM = createSand("dirt/sandy_loam", true);
    public static final TFCGravityBlock DIRT_PEAT = createSand("dirt/peat", true);
    //Ground Cover
    public static final Block GROUNDCOVER_BONE = createGroundcover("groundcover/bone", Items.BONE);
    public static final Block GROUNDCOVER_CLAM = createGroundcover("groundcover/clam");
    public static final Block GROUNDCOVER_DEAD_GRASS = createGroundcover("groundcover/dead_grass");
    public static final Block GROUNDCOVER_DRIFTWOOD = createGroundcover("groundcover/driftwood");
    public static final Block GROUNDCOVER_FEATHER = createGroundcover("groundcover/feather", Items.FEATHER);
    public static final Block GROUNDCOVER_GUANO = createGroundcover("groundcover/guano");
    public static final Block GROUNDCOVER_MOLLUSK = createGroundcover("groundcover/mollusk");
    public static final Block GROUNDCOVER_MUSSEL = createGroundcover("groundcover/mussel");
    public static final Block GROUNDCOVER_PINECONE = createGroundcover("groundcover/pinecone");
    public static final Block GROUNDCOVER_PODZOL = createGroundcover("groundcover/podzol", Items.PODZOL);
    public static final Block GROUNDCOVER_ROTTEN_FLESH = createGroundcover("groundcover/rotten_flesh", Items.ROTTEN_FLESH);
    public static final Block GROUNDCOVER_SALT_LICK = createGroundcover("groundcover/seaweed");
    public static final Block GROUNDCOVER_STICK = createGroundcover("groundcover/stick", Items.STICK);
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
    //Sand
    public static final TFCGravityBlock SAND_BLACK = createSand("sand/black", true);
    public static final TFCGravityBlock SAND_BROWN = createSand("sand/brown", true);
    public static final TFCGravityBlock SAND_GREEN = createSand("sand/green", true);
    public static final TFCGravityBlock SAND_PINK = createSand("sand/pink", true);
    public static final TFCGravityBlock SAND_RED = createSand("sand/red", true);
    public static final TFCGravityBlock SAND_WHITE = createSand("sand/white", true);
    public static final TFCGravityBlock SAND_YELLOW = createSand("sand/yellow", true);

    //Items
    public static final Item ROCK = createItem("rock", new Item(gen()));
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
//Do something with the item id.
        return block;
    }

    public static TFCLogs createLog(String id, boolean hasItem) {
        var block = new TFCLogs(FabricBlockSettings.of(Material.WOOD).breakByTool(FabricToolTags.AXES).sounds(BlockSoundGroup.WOOD).strength(2.0f));
        register(id, block, hasItem);
        return block;
    }

    public static Block createRock(String id, boolean hasItem) {
        var block = new Block(FabricBlockSettings.of(Material.WOOD).breakByTool(FabricToolTags.AXES).sounds(BlockSoundGroup.WOOD).strength(2.0f));
        register(id, block, hasItem);
        return block;
    }

    public static Block createGravel(String id, boolean hasItem) {
        var block = new Block(FabricBlockSettings.of(Material.SOIL).breakByTool(FabricToolTags.SHOVELS).sounds(BlockSoundGroup.GRAVEL).strength(0.2f));
        register(id, block, hasItem);
        return block;
    }

    public static LeavesBlock createLeaves(String id, boolean hasItem) {
        var block = new LeavesBlock(FabricBlockSettings.of(Material.LEAVES).breakByTool(FabricToolTags.HOES).sounds(BlockSoundGroup.SLIME).strength(2.0f));
        register(id, block, hasItem);
        return block;
    }

    public static TFCGravityBlock createSand(String id, boolean hasItem) {
        var block = new TFCGravityBlock(FabricBlockSettings.of(Material.LEAVES).breakByTool(FabricToolTags.HOES).sounds(BlockSoundGroup.SLIME).strength(2.0f));
        register(id, block, hasItem);
        return block;
    }

    public static Block createGroundcover(String id, Item dropId) {
        var block = new Block(FabricBlockSettings.of(Material.STONE).breakByTool(FabricToolTags.PICKAXES).strength(6.0f));
        register(id, block, dropId);
        return block;
    }

    public static Block createGroundcover(String id) {
        var block = new Block(FabricBlockSettings.of(Material.STONE).breakByTool(FabricToolTags.PICKAXES).strength(6.0f));
//Assume drop id is the same as the block id
        register(id, block, true);
        return block;
    }

    static TFCLogs createStrippedLog(String id) {
        var block = new TFCLogs(FabricBlockSettings.of(Material.WOOD).breakByTool(FabricToolTags.AXES).sounds(BlockSoundGroup.WOOD).strength(2.0f));
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
package malek.terrafabricraft.common.registry;

import malek.terrafabricraft.TerraFabriCraft;
import malek.terrafabricraft.common.block.RotatingBlock;
import malek.terrafabricraft.common.block.entity.RockBlockEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
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
    //Should use leaves sound.
    public static final FabricBlockSettings LEAVES_TAG = FabricBlockSettings.of(Material.LEAVES).breakByTool(FabricToolTags.HOES).sounds(BlockSoundGroup.SLIME).strength(2.0f);
    public static final FabricBlockSettings STONE_TAG = FabricBlockSettings.of(Material.STONE).breakByTool(FabricToolTags.PICKAXES).sounds(BlockSoundGroup.STONE).strength(6.0f);
    public static final FabricBlockSettings DIRT_TAG = FabricBlockSettings.of(Material.SOIL).breakByTool(FabricToolTags.SHOVELS).sounds(BlockSoundGroup.GRAVEL).strength(0.2f);
    //Should be rotatable block.
    public static final FabricBlockSettings LOG_TAG = FabricBlockSettings.of(Material.WOOD).breakByTool(FabricToolTags.AXES).sounds(BlockSoundGroup.WOOD).strength(2.0f);
    public static final FabricBlockSettings GROUNDCOVER_TAG = FabricBlockSettings.of(Material.STONE).breakByTool(FabricToolTags.PICKAXES).strength(6.0f);

    //Stone
    public static final Block ROCK_BLOCK = create("rock_block", new Block(STONE_TAG), true);
    //Dirt
    public static final Block DIRT_SILT = create("dirt/silt", new Block(DIRT_TAG), true);
    public static final Block DIRT_SILTY_LOAM = create("dirt/silty_loam", new Block(DIRT_TAG), true);
    public static final Block DIRT_LOAM = create("dirt/loam", new Block(DIRT_TAG), true);
    public static final Block DIRT_SANDY_LOAM = create("dirt/sandy_loam", new Block(DIRT_TAG), true);
    public static final Block DIRT_PEAT = create("dirt/peat", new Block(DIRT_TAG), true);
    //Ground Cover
    public static final Block GROUNDCOVER_STICK = create("groundcover/stick", new Block(GROUNDCOVER_TAG), Items.STICK);
    public static final Block ORE_SMALL_BISMUTHINITE = create("ore/small_bismuthinite", new Block(GROUNDCOVER_TAG), true);
    public static final Block ORE_SMALL_CASSITERITE = create("ore/small_cassiterite", new Block(GROUNDCOVER_TAG), true);
    public static final Block ORE_SMALL_GARNIERITE = create("ore/small_garnierite", new Block(GROUNDCOVER_TAG), true);
    public static final Block ORE_SMALL_HEMATITE = create("ore/small_hematite", new Block(GROUNDCOVER_TAG), true);
    public static final Block ORE_SMALL_LIMONITE = create("ore/small_limonite", new Block(GROUNDCOVER_TAG), true);
    public static final Block ORE_SMALL_MAGNETITE = create("ore/small_magnetite", new Block(GROUNDCOVER_TAG), true);
    public static final Block ORE_SMALL_MALACHITE = create("ore/small_malachite", new Block(GROUNDCOVER_TAG), true);
    public static final Block ORE_SMALL_NATIVE_COPPPER = create("ore/small_native_copper", new Block(GROUNDCOVER_TAG), true);
    public static final Block ORE_SMALL_NATIVE_GOLD = create("ore/small_native_gold", new Block(GROUNDCOVER_TAG), true);
    public static final Block ORE_SMALL_NATIVE_SILVER = create("ore/small_native_silver", new Block(GROUNDCOVER_TAG), true);
    public static final Block ORE_SMALL_SPHALERITE = create("ore/small_sphalerite", new Block(GROUNDCOVER_TAG), true);
    public static final Block ORE_SMALL_TETRAHEDRITE = create("ore/small_tetrahedrite", new Block(GROUNDCOVER_TAG),true);

    //Logs
    public static final Block WOOD_LOG_ACACIA = create("wood/log/acacia", new RotatingBlock(LOG_TAG), true);
    public static final Block WOOD_LOG_ASH = create("wood/log/ash", new RotatingBlock(LOG_TAG), true);
    public static final Block WOOD_LOG_ASPEN = create("wood/log/aspen", new RotatingBlock(LOG_TAG), true);
    public static final Block WOOD_LOG_BIRCH = create("wood/log/birch", new Block(LOG_TAG), true);
    public static final Block WOOD_LOG_BLACKWOOD = create("wood/log/blackwood", new RotatingBlock(LOG_TAG), true);
    public static final Block WOOD_LOG_CHESTNUT = create("wood/log/chestnut", new RotatingBlock(LOG_TAG), true);
    public static final Block WOOD_LOG_DOUGLAS_FIR = create("wood/log/douglas_fir", new RotatingBlock(LOG_TAG), true);
    public static final Block WOOD_LOG_HICKORY = create("wood/log/hickory", new RotatingBlock(LOG_TAG), true);
    public static final Block WOOD_LOG_KAPOK = create("wood/log/kapok", new RotatingBlock(LOG_TAG), true);
    public static final Block WOOD_LOG_MAPLE = create("wood/log/maple", new RotatingBlock(LOG_TAG), true);
    public static final Block WOOD_LOG_OAK = create("wood/log/oak", new RotatingBlock(LOG_TAG), true);
    public static final Block WOOD_LOG_PALM = create("wood/log/palm", new RotatingBlock(LOG_TAG), true);
    public static final Block WOOD_LOG_PINE = create("wood/log/pine", new RotatingBlock(LOG_TAG), true);
    public static final Block WOOD_LOG_ROSEWOOD = create("wood/log/rosewood", new RotatingBlock(LOG_TAG), true);
    public static final Block WOOD_LOG_SEQUOIA = create("wood/log/sequoia", new RotatingBlock(LOG_TAG), true);
    public static final Block WOOD_LOG_SPRUCE = create("wood/log/spruce", new RotatingBlock(LOG_TAG), true);
    public static final Block WOOD_LOG_SYCAMORE = create("wood/log/sycamore", new RotatingBlock(LOG_TAG), true);
    public static final Block WOOD_LOG_WHITE_CEDAR = create("wood/log/white_cedar", new RotatingBlock(LOG_TAG), true);
    public static final Block WOOD_LOG_WILLOW = create("wood/log/willow", new RotatingBlock(LOG_TAG), true);
    //Items
    public static final Item ROCK = create("rock", new Item(gen()));
    //Block Entities
    public static final BlockEntityType<RockBlockEntity> ROCK_BLOCK_ENTITY = register("rock_block_entity", FabricBlockEntityTypeBuilder.create(RockBlockEntity::new, TFCObjects.ROCK_BLOCK).build(null));

    public static <T extends Block> T create(String id, T block, boolean hasItem) {
        BLOCKS.put(block, new Identifier(TerraFabriCraft.MODID, id));
        if (hasItem) {
            ITEMS.put(new BlockItem(block, gen()), BLOCKS.get(block));
        }
        return block;
    }

    public static <T extends Block> T create(String id, T block, Item dropId) {
        BLOCKS.put(block, new Identifier(TerraFabriCraft.MODID, id));
        return block;
    }


//Register item
    private static <T extends Item> T create(String id, T item) {
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
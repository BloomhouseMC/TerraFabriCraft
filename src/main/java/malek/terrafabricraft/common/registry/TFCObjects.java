package malek.terrafabricraft.common.registry;

import malek.terrafabricraft.TerraFabriCraft;
import malek.terrafabricraft.common.block.GroundCoverBlock;
import malek.terrafabricraft.common.block.entity.RockBlockEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.LeavesBlock;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.LinkedHashMap;
import java.util.Map;

public class TFCObjects {
    public static final Map<Block, Identifier> BLOCKS = new LinkedHashMap<>();
    private static final Map<BlockEntityType<?>, Identifier> BLOCK_ENTITY_TYPES = new LinkedHashMap<>();
    private static final Map<Item, Identifier> ITEMS = new LinkedHashMap<>();

    public static final Block ROCK_BLOCK = createRock("rock_block", true);

    //Dirt
    public static final Block SILT = createDirt("dirt/silt", true);
    public static final Block SILTY_LOAM = createDirt("dirt/silty_loam", true);
    public static final Block LOAM = createDirt("dirt/loam", true);
    public static final Block SANDY_LOAM = createDirt("dirt/sandy_loam", true);
    public static final Block PEAT = createDirt("peat", true);

    //Ground Cover
    public static final Block STICK = createGroundCover("groundcover/stick", true);

    //Logs
    public static final Block ACACIA_LOG = createLog("acacia_log", true);
    public static final Block ASH_LOG = createLog("ash_log", true);
    public static final Block ASPEN_LOG = createLog("aspen_log", true);
    public static final Block BIRCH_LOG = createLog("birch_log", true);
    public static final Block BLACKWOOD_LOG = createLog("blackwood_log", true);
    public static final Block CHESTNUT_LOG = createLog("chestnut_log", true);
    public static final Block DOUGLAS_FIR_LOG = createLog("douglas_fir_log", true);
    public static final Block HICKORY_LOG = createLog("hickory_log", true);
    public static final Block KAPOK_LOG = createLog("kapok_log", true);
    public static final Block MAPLE_LOG = createLog("maple_log", true);
    public static final Block OAK_LOG = createLog("oak_log", true);
    public static final Block PALM_LOG = createLog("palm_log", true);
    public static final Block PINE_LOG = createLog("pine_log", true);
    public static final Block ROSEWOOD_LOG = createLog("rosewood_log", true);
    public static final Block SEQUOIA_LOG = createLog("sequoia_log", true);
    public static final Block SPRUCE_LOG = createLog("spruce_log", true);
    public static final Block SYCAMORE_LOG = createLog("sycamore_log", true);
    public static final Block WHITE_CEDAR_LOG = createLog("white_cedar_log", true);
    public static final Block WILLOW_LOG = createLog("willow_log", true);

    public static final Item ROCK = createItem("rock", new Item(gen()));

    public static final BlockEntityType<RockBlockEntity> ROCK_BLOCK_ENTITY = register("rock_block_entity", FabricBlockEntityTypeBuilder.create(RockBlockEntity::new, TFCObjects.ROCK_BLOCK).build(null));

    public static <T extends Block> T register(String id, T block, boolean hasItem) {
        BLOCKS.put(block, new Identifier(TerraFabriCraft.MODID, id));
        if (hasItem) {
            ITEMS.put(new BlockItem(block, gen()), BLOCKS.get(block));
        }
        return block;
    }

    private static <T extends Item> T createItem(String id, T item) {
        ITEMS.put(item, new Identifier(TerraFabriCraft.MODID, id));
        return item;
    }

    private static <T extends BlockEntity> BlockEntityType<T> register(String id, BlockEntityType<T> type) {
        BLOCK_ENTITY_TYPES.put(type, new Identifier(TerraFabriCraft.MODID, id));
        return type;
    }

    public static Block createDirt(String id, boolean hasItem) {
        var block = new Block(FabricBlockSettings.of(Material.SOIL).breakByTool(FabricToolTags.SHOVELS).strength(0.2f));
        register(id, block, hasItem);
        return block;
    }

    public static Block createRock(String id, boolean hasItem) {
        var block = new Block(FabricBlockSettings.of(Material.STONE).breakByTool(FabricToolTags.PICKAXES).strength(6.0f));
        register(id, block, hasItem);
        return block;
    }

    public static Block createGroundCover(String id, boolean hasItem) {
        var block = new GroundCoverBlock(FabricBlockSettings.of(Material.STONE).breakByTool(FabricToolTags.PICKAXES).strength(6.0f));
        register(id, block, hasItem);
        return block;
    }

    public static Block createLog(String id, boolean hasItem) {
//        Should be rotatable block.
        var block = new Block(FabricBlockSettings.of(Material.WOOD).breakByTool(FabricToolTags.AXES).sounds(BlockSoundGroup.WOOD).strength(2.0f));
        register(id, block, hasItem);
        return block;
    }

    static Block createLeaves(String id) {
//        Should use leaves sound.
        var block = new LeavesBlock(FabricBlockSettings.of(Material.LEAVES).breakByTool(FabricToolTags.HOES).strength(0.2F).sounds(BlockSoundGroup.SLIME));
        register(id, block, true);
        return block;
    }

    static Block createStrippedLog(String id) {
//        Should be rotatable block.
        var block = new Block(FabricBlockSettings.of(Material.WOOD).breakByTool(FabricToolTags.AXES).sounds(BlockSoundGroup.WOOD).strength(2.0f));
        register(id, block, true);
        return block;
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

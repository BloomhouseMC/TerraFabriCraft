package malek.terrafabricraft.common.registry;

import malek.terrafabricraft.TerraFabriCraft;
import malek.terrafabricraft.common.block.entity.RockBlockEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.HorizontalFacingBlock;
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
    private static final Map<Block, Identifier> BLOCKS = new LinkedHashMap<>();
    private static final Map<BlockEntityType<?>, Identifier> BLOCK_ENTITY_TYPES = new LinkedHashMap<>();
    private static final Map<Item, Identifier> ITEMS = new LinkedHashMap<>();

    public static final FabricBlockSettings LEAVES_TAG = FabricBlockSettings.of(Material.WOOD).breakByTool(FabricToolTags.AXES).sounds(BlockSoundGroup.WOOD).strength(2.0f);
    public static final FabricBlockSettings STONE_TAG = FabricBlockSettings.of(Material.STONE).breakByTool(FabricToolTags.PICKAXES).strength(6.0f);
    public static final FabricBlockSettings DIRT_TAG = FabricBlockSettings.of(Material.SOIL).breakByTool(FabricToolTags.SHOVELS).strength(0.2f);
    //        Should be rotatable block.
    public static final FabricBlockSettings LOG_TAG = FabricBlockSettings.of(Material.WOOD).breakByTool(FabricToolTags.AXES).sounds(BlockSoundGroup.WOOD).strength(2.0f);


    public static final Block ROCK_BLOCK = create("rock_block", new Block(STONE_TAG), true);

    public static final Block SILT = create("silt", new Block(DIRT_TAG), true);
    public static final Block SILTY_LOAM = create("silty_loam", new Block(DIRT_TAG), true);
    public static final Block LOAM = create("loam", new Block(DIRT_TAG), true);
    public static final Block SANDY_LOAM = create("sandy_loam", new Block(DIRT_TAG), true);
    public static final Block PEAT = create("peat", new Block(LOG_TAG), true);
    public static final Block ACACIA_LOG = create("acacia_log", new Block(LOG_TAG), true);
    public static final Block ASH_LOG = create("ash_log", new Block(LOG_TAG), true);
    public static final Block ASPEN_LOG = create("aspen_log", new Block(LOG_TAG), true);
    public static final Block BIRCH_LOG = create("birch_log", new Block(LOG_TAG), true);
    public static final Block BLACKWOOD_LOG = create("blackwood_log", new Block(LOG_TAG), true);
    public static final Block CHESTNUT_LOG = create("chestnut_log", new Block(LOG_TAG), true);
    public static final Block DOUGLAS_FIR_LOG = create("douglas_fir_log", new Block(LOG_TAG), true);
    public static final Block HICKORY_LOG = create("hickory_log", new Block(LOG_TAG), true);
    public static final Block KAPOK_LOG = create("kapok_log", new Block(LOG_TAG), true);
    public static final Block MAPLE_LOG = create("maple_log", new Block(LOG_TAG), true);
    public static final Block OAK_LOG = create("oak_log", new Block(LOG_TAG), true);
    public static final Block PALM_LOG = create("palm_log", new Block(LOG_TAG), true);
    public static final Block PINE_LOG = create("pine_log", new Block(LOG_TAG), true);
    public static final Block ROSEWOOD_LOG = create("rosewood_log", new Block(LOG_TAG), true);
    public static final Block SEQUOIA_LOG = create("sequoia_log", new Block(LOG_TAG), true);
    public static final Block SPRUCE_LOG = create("spruce_log", new Block(LOG_TAG), true);
    public static final Block SYCAMORE_LOG = create("sycamore_log", new Block(LOG_TAG), true);
    public static final Block WHITE_CEDAR_LOG = create("white_cedar_log", new Block(LOG_TAG), true);
    public static final Block WILLOW_LOG = create("willow_log", new Block(LOG_TAG), true);

    public static final Item ROCK = create("rock", new Item(gen()));

    public static final BlockEntityType<RockBlockEntity> ROCK_BLOCK_ENTITY = register("rock_block_entity", FabricBlockEntityTypeBuilder.create(RockBlockEntity::new, TFCObjects.ROCK_BLOCK).build(null));

    private static <T extends Item> T create(String id, T item) {
        ITEMS.put(item, new Identifier(TerraFabriCraft.MODID, id));
        return item;
    }

    private static <T extends BlockEntity> BlockEntityType<T> register(String id, BlockEntityType<T> type) {
        BLOCK_ENTITY_TYPES.put(type, new Identifier(TerraFabriCraft.MODID, id));
        return type;
    }

    public static <T extends Block> T create(String id, T block, boolean hasItem) {
        BLOCKS.put(block, new Identifier(TerraFabriCraft.MODID, id));
        if (hasItem) {
            ITEMS.put(new BlockItem(block, gen()), BLOCKS.get(block));
        }
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

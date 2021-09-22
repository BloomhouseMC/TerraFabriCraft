package malek.terrafabricraft.common.registry;

import malek.terrafabricraft.TerraFabriCraft;
import malek.terrafabricraft.common.block.RockBlock;
import malek.terrafabricraft.common.block.entity.RockBlockEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.LinkedHashMap;
import java.util.Map;

public class TFCObjects {
    private static final Map<Block, Identifier> BLOCKS = new LinkedHashMap<>();
    private static final Map<BlockEntityType<?>, Identifier> BLOCK_ENTITY_TYPES = new LinkedHashMap<>();
    private static final Map<Item, Identifier> ITEMS = new LinkedHashMap<>();

    //Items
    public static final Item ROCK = create("rock", new Item(gen()));
    //Blocks
    public static final Block ROCK_BLOCK  = create("rock_block", new RockBlock(FabricBlockSettings.copyOf(Blocks.STONE)), true);
    //BlockEntities
    public static final BlockEntityType<RockBlockEntity> ROCK_BLOCK_ENTITY = create("rock_block_entity", FabricBlockEntityTypeBuilder.create(RockBlockEntity::new, TFCObjects.ROCK_BLOCK).build(null));


    private static <T extends Block> T create(String name, T block, boolean createItem) {
        BLOCKS.put(block, new Identifier(TerraFabriCraft.MODID, name));
        if (createItem) {
            ITEMS.put(new BlockItem(block, gen()), BLOCKS.get(block));
        }
        return block;
    }

    private static <T extends Item> T create(String name, T item) {
        ITEMS.put(item, new Identifier(TerraFabriCraft.MODID, name));
        return item;
    }

    private static <T extends BlockEntity> BlockEntityType<T> create(String name, BlockEntityType<T> type) {
        BLOCK_ENTITY_TYPES.put(type, new Identifier(TerraFabriCraft.MODID, name));
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

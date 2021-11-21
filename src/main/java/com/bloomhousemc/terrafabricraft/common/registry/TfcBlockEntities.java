package com.bloomhousemc.terrafabricraft.common.registry;

import com.bloomhousemc.terrafabricraft.common.block.anvil.TfcAnvilBlockEntity;
import com.bloomhousemc.terrafabricraft.common.block.bellows.BellowsBlockEntity;
import com.bloomhousemc.terrafabricraft.common.block.forge.ForgeBlockEntity;
import com.bloomhousemc.terrafabricraft.common.block.keg.KegEntity;
import com.bloomhousemc.terrafabricraft.common.block.logpile.LogPileBlockEntity;
import com.bloomhousemc.terrafabricraft.common.block.placeable.PlaceableBlockEntity;
import com.bloomhousemc.terrafabricraft.common.block.toolrack.ToolRackBlockEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static com.bloomhousemc.terrafabricraft.TerraFabriCraft.MODID;

@SuppressWarnings("unused")
public final class TfcBlockEntities {
    public static final BlockEntityType<BellowsBlockEntity> BELLOWS_BLOCK_ENTITY = register("bellows_entity", FabricBlockEntityTypeBuilder.create(BellowsBlockEntity::new, TfcBlocks.BELLOWS_BLOCK).build(null));
    public static final BlockEntityType<TfcAnvilBlockEntity> ANVIL_BLOCK_ENTITY = register("anvil_block_entity", FabricBlockEntityTypeBuilder.create(TfcAnvilBlockEntity::new, TfcBlocks.METAL_ANVIL_BISMUTH_BRONZE, TfcBlocks.METAL_ANVIL_STEEL, TfcBlocks.METAL_ANVIL_BLACK_BRONZE, TfcBlocks.METAL_ANVIL_BRONZE, TfcBlocks.METAL_ANVIL_BLACK_STEEL, TfcBlocks.METAL_ANVIL_BLUE_STEEL, TfcBlocks.METAL_ANVIL_COPPER, TfcBlocks.METAL_ANVIL_RED_STEEL, TfcBlocks.METAL_ANVIL_WROUGHT_IRON).build(null));
    public static final BlockEntityType<ToolRackBlockEntity> TOOL_RACK_BLOCK_ENTITY = register("tool_rack_block_entity", FabricBlockEntityTypeBuilder.create(ToolRackBlockEntity::new, TfcBlocks.WOOD_ACACIA.rack, TfcBlocks.WOOD_ASH.rack, TfcBlocks.WOOD_ASPEN.rack, TfcBlocks.WOOD_BIRCH.rack, TfcBlocks.WOOD_BLACKWOOD.rack, TfcBlocks.WOOD_CHESTNUT.rack, TfcBlocks.WOOD_DOUGLAS_FIR.rack, TfcBlocks.WOOD_HICKORY.rack, TfcBlocks.WOOD_KAPOK.rack, TfcBlocks.WOOD_MAPLE.rack, TfcBlocks.WOOD_OAK.rack, TfcBlocks.WOOD_PALM.rack, TfcBlocks.WOOD_PINE.rack, TfcBlocks.WOOD_ROSEWOOD.rack, TfcBlocks.WOOD_SEQUOIA.rack, TfcBlocks.WOOD_SPRUCE.rack, TfcBlocks.WOOD_SYCAMORE.rack, TfcBlocks.WOOD_WHITE_CEDAR.rack, TfcBlocks.WOOD_WILLOW.rack).build(null));
    public static final BlockEntityType<ForgeBlockEntity> FORGE_BLOCK_ENTITY = register("forge_entity", FabricBlockEntityTypeBuilder.create(ForgeBlockEntity::new, TfcBlocks.FORGE).build(null));
    public static final BlockEntityType<PlaceableBlockEntity> PLACEABLE_BLOCK_ENTITY = register("placeable_block_entity", FabricBlockEntityTypeBuilder.create(PlaceableBlockEntity::new, TfcBlocks.PLACEABLE).build(null));
    public static final BlockEntityType<LogPileBlockEntity> LOG_PILE_BLOCK_ENTITY = register("log_pile_entity", FabricBlockEntityTypeBuilder.create(LogPileBlockEntity::new, TfcBlocks.LOG_PILE).build(null));
    public static final BlockEntityType<KegEntity> KEG_BLOCK_ENTITY = register("keg_entity", FabricBlockEntityTypeBuilder.create(KegEntity::new, TfcBlocks.WOOD_ACACIA.keg, TfcBlocks.WOOD_ASH.keg, TfcBlocks.WOOD_ASPEN.keg, TfcBlocks.WOOD_BIRCH.keg, TfcBlocks.WOOD_BLACKWOOD.keg, TfcBlocks.WOOD_CHESTNUT.keg, TfcBlocks.WOOD_DOUGLAS_FIR.keg, TfcBlocks.WOOD_HICKORY.keg, TfcBlocks.WOOD_KAPOK.keg, TfcBlocks.WOOD_MAPLE.keg, TfcBlocks.WOOD_OAK.keg, TfcBlocks.WOOD_PALM.keg, TfcBlocks.WOOD_PINE.keg, TfcBlocks.WOOD_ROSEWOOD.keg, TfcBlocks.WOOD_SEQUOIA.keg, TfcBlocks.WOOD_SPRUCE.keg, TfcBlocks.WOOD_SYCAMORE.keg, TfcBlocks.WOOD_WHITE_CEDAR.keg, TfcBlocks.WOOD_WILLOW.keg).build(null));
    private TfcBlockEntities() {
    }

    private static <T extends BlockEntity> BlockEntityType<T> register(String id, BlockEntityType<T> type) {
        Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(MODID, id), type);
        return type;
    }

    public static <T extends Block> T register(String id, T block, Boolean hasBlockItem, ItemGroup itemGroup) {
        var fullId = new Identifier(MODID, id);
        Registry.register(Registry.BLOCK, fullId, block);
        if (hasBlockItem) {
            Registry.register(Registry.ITEM, fullId, new BlockItem(block, new Item.Settings().group(itemGroup)));
        }
        return block;
    }

    public static void init() {
    }
}

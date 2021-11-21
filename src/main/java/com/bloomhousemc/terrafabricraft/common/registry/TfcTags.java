package com.bloomhousemc.terrafabricraft.common.registry;

import com.bloomhousemc.terrafabricraft.TerraFabriCraft;
import net.fabricmc.fabric.api.tag.TagFactory;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;

import static com.bloomhousemc.terrafabricraft.TerraFabriCraft.MODID;

public final class TfcTags {
    // Block
    public static final String COMMON = "c";
    public static final Tag<Block> DIRT = TagFactory.BLOCK.create(new Identifier(COMMON, "dirt"));
    public static final Tag<Block> FARMLAND = TagFactory.BLOCK.create(new Identifier(COMMON, "farmland"));    //Block Entities
    public static final Tag<Block> SALT_WATER = TagFactory.BLOCK.create(new Identifier(MODID, "salt_water"));
    public static final Tag<Block> GRASS_BLOCKS = TagFactory.BLOCK.create(new Identifier(COMMON, "grass_blocks"));
    public static final Tag<Block> RAW_IGNEOUS = TagFactory.BLOCK.create(new Identifier(MODID, "raw_igneous"));
    public static final Tag<Block> CAN_COLLAPSE = TagFactory.BLOCK.create(new Identifier(MODID, "can_collapse"));
    public static final Tag<Block> CAN_TRIGGER_COLLAPSE = TagFactory.BLOCK.create(new Identifier(MODID, "can_trigger_collapse"));
    public static final Tag<Block> GRASS_PLANTS = TagFactory.BLOCK.create(new Identifier(MODID, "grass_plants"));
    public static final Tag<Block> DIRT_PLANTS = TagFactory.BLOCK.create(new Identifier(MODID, "dirt_plants"));
    public static final Tag<Block> RIVER_WATER = TagFactory.BLOCK.create(new Identifier(MODID, "river_water"));
    public static final Tag<Block> SUPPORT_BEAMS = TagFactory.BLOCK.create(new Identifier(MODID, "support_beams"));


    // Items
    public static final Tag<Item> GRAIN = TagFactory.ITEM.create(new Identifier(MODID, "grain"));
    public static final Tag<Item> PLACEABLE = TagFactory.ITEM.create(new Identifier(MODID, "placeable"));
    public static final Tag<Item> CAN_LOGPILE = TagFactory.ITEM.create(new Identifier(MODID, "can_logpile"));

    private TfcTags() {
    }

    public static void init() {
    }
}

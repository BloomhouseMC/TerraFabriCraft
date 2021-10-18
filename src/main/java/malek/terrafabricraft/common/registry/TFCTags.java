package malek.terrafabricraft.common.registry;

import malek.terrafabricraft.TerraFabriCraft;
import net.fabricmc.fabric.api.tag.TagFactory;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;

public class TFCTags {
    // Blocks
    public static final Tag<Block> CAN_PLANT_GRASS_PLANTS_ON = TagFactory.BLOCK.create(new Identifier(TerraFabriCraft.MODID, "can_plant_grass_plants_on"));
    public static final Tag<Block> CAN_PLANT_CROPS_ON = TagFactory.BLOCK.create(new Identifier(TerraFabriCraft.MODID, "can_plant_crops_on"));    //Block Entities
    public static final Tag<Block> CAN_PLANT_RIVER_PLANTS_ON = TagFactory.BLOCK.create(new Identifier(TerraFabriCraft.MODID, "can_plant_river_plants_on"));
    public static final Tag<Block> CAN_PLANT_SALT_WATER_PLANTS_ON = TagFactory.BLOCK.create(new Identifier(TerraFabriCraft.MODID, "can_plant_salt_water_plants_on"));
    public static final Tag<Block> GRASS_BLOCK = TagFactory.BLOCK.create(new Identifier(TerraFabriCraft.MODID, "grass_block"));

    // Items
    public static final Tag<Item> GRAIN = TagFactory.ITEM.create(new Identifier(TerraFabriCraft.MODID, "grain"));
}

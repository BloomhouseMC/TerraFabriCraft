package com.bloomhousemc.terrafabricraft.common.registry.util;

import com.bloomhousemc.terrafabricraft.TerraFabriCraft;
import net.minecraft.item.Item;

import static com.bloomhousemc.terrafabricraft.common.registry.TFCObjects.createItemSimple;

public class StoneItem {
    public Item axe_head;
    public Item hammer_head;
    public Item hoe_head;
    public Item javelin_head;
    public Item knife_head;
    public Item shovel_head;


    public StoneItem(String id) {
        axe_head = setCreateItemSimple(id,"axe_head");
        hammer_head   = setCreateItemSimple(id,"hammer_head");
        hoe_head    = setCreateItemSimple(id,"hoe_head");
        javelin_head     = setCreateItemSimple(id,"javelin_head");
        knife_head         = setCreateItemSimple(id,"knife_head");
        shovel_head      = setCreateItemSimple(id,"shovel_head");
    }

    private static Item setCreateItemSimple(String variantId, String special) {
        return createItemSimple(variantId + "/" + special + "/metamorphic", TerraFabriCraft.ROCK_GROUP);
    }
}

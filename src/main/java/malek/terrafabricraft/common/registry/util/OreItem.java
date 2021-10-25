package malek.terrafabricraft.common.registry.util;

import malek.terrafabricraft.TerraFabriCraft;
import net.minecraft.item.Item;

import static malek.terrafabricraft.common.registry.TFCObjects.createItemSimple;

public class OreItem {
    public Item native_copper;
    public Item native_gold;
    public Item hematite;
    public Item native_silver;
    public Item cassiterite;
    public Item bismuthinite;
    public Item garnierite;
    public Item malachite;
    public Item magnetite;
    public Item limonite;
    public Item sphalerite;
    public Item tetrahedrite;


    public OreItem(String id) {
        native_copper = setCreateItemSimple(id,"native_copper");
        native_gold   = setCreateItemSimple(id,"native_gold");
        hematite    = setCreateItemSimple(id,"hematite");
        native_silver     = setCreateItemSimple(id,"native_silver");
        cassiterite         = setCreateItemSimple(id,"cassiterite");
        bismuthinite      = setCreateItemSimple(id,"bismuthinite");
        garnierite         = setCreateItemSimple(id,"garnierite");
        malachite      = setCreateItemSimple(id,"malachite");
        magnetite          = setCreateItemSimple(id,"magnetite");
        limonite          = setCreateItemSimple(id,"limonite");
        sphalerite   = setCreateItemSimple(id,"sphalerite");
        tetrahedrite   = setCreateItemSimple(id,"tetrahedrite");
    }

    private static Item setCreateItemSimple(String variantId, String special) {
        return createItemSimple("ore/"+ variantId + "_" + special, TerraFabriCraft.ORES_GROUP);
    }
}

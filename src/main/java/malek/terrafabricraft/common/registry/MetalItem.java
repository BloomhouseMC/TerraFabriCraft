package malek.terrafabricraft.common.registry;

import malek.terrafabricraft.TerraFabriCraft;
import net.minecraft.item.Item;

import static malek.terrafabricraft.common.registry.TFCObjects.createItemSimple;

public class MetalItem {
    public Item bismuth_bronze;
    public Item black_bronze;
    public Item black_steel;
    public Item blue_steel;
    public Item bronze;
    public Item cast_iron;
    public Item copper;
    public Item red_steel;
    public Item steel;
    public Item wrought_iron;


    public MetalItem(String id) {
        bismuth_bronze = setCreateItemSimple(id,"bismuth_bronze");
        black_bronze   = setCreateItemSimple(id,"black_bronze");
        black_steel    = setCreateItemSimple(id,"black_steel");
        blue_steel     = setCreateItemSimple(id,"blue_steel");
        bronze         = setCreateItemSimple(id,"bronze");
        cast_iron      = setCreateItemSimple(id,"cast_iron");
        copper         = setCreateItemSimple(id,"copper");
        red_steel      = setCreateItemSimple(id,"red_steel");
        steel          = setCreateItemSimple(id,"steel");
        wrought_iron   = setCreateItemSimple(id,"wrought_iron");
    }

    private static Item setCreateItemSimple(String variantId, String special) {
        return createItemSimple("metal/"+variantId + "/" + special, TerraFabriCraft.METAL_GROUP);
    }
}

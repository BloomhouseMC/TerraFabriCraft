package malek.terrafabricraft.common.registry;

import malek.terrafabricraft.TerraFabriCraft;
import malek.terrafabricraft.common.item.TFCMetalItem;

import static malek.terrafabricraft.common.registry.TFCObjects.createMetalItem;

public class MetalItem {
    public TFCMetalItem bismuth_bronze;
    public TFCMetalItem black_bronze;
    public TFCMetalItem black_steel;
    public TFCMetalItem blue_steel;
    public TFCMetalItem bronze;
    public TFCMetalItem cast_iron;
    public TFCMetalItem copper;
    public TFCMetalItem red_steel;
    public TFCMetalItem steel;
    public TFCMetalItem wrought_iron;


    public MetalItem(String id) {
        bismuth_bronze = setCreateItemSimple(id,"bismuth_bronze", 785);
        black_bronze   = setCreateItemSimple(id,"black_bronze", 950);
        black_steel    = setCreateItemSimple(id,"black_steel", 2570);
        blue_steel     = setCreateItemSimple(id,"blue_steel", 2570);
        bronze         = setCreateItemSimple(id,"bronze", 904);
        cast_iron      = setCreateItemSimple(id,"cast_iron", 1127);
        copper         = setCreateItemSimple(id,"copper", 1984);
        red_steel      = setCreateItemSimple(id,"red_steel", 2570);
        steel          = setCreateItemSimple(id,"steel", 1371);
        wrought_iron   = setCreateItemSimple(id,"wrought_iron", 1482);
    }

    private static TFCMetalItem setCreateItemSimple(String variantId, String special, int meltingPoint) {
        return createMetalItem("metal/"+variantId + "/" + special, TerraFabriCraft.METAL_GROUP, meltingPoint);
    }
}

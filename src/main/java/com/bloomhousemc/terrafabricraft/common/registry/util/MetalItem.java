package com.bloomhousemc.terrafabricraft.common.registry.util;

import com.bloomhousemc.terrafabricraft.common.item.TfcMetalItem;

import static com.bloomhousemc.terrafabricraft.common.registry.TfcItemGroups.METAL_GROUP;
import static com.bloomhousemc.terrafabricraft.common.registry.TfcItems.createMetal;

public class MetalItem {
    public TfcMetalItem bismuth_bronze;
    public TfcMetalItem black_bronze;
    public TfcMetalItem black_steel;
    public TfcMetalItem blue_steel;
    public TfcMetalItem bronze;
    public TfcMetalItem cast_iron;
    public TfcMetalItem copper;
    public TfcMetalItem red_steel;
    public TfcMetalItem steel;
    public TfcMetalItem wrought_iron;


    public MetalItem(String id) {
        bismuth_bronze = setCreateItemSimple(id, "bismuth_bronze", 785);
        black_bronze = setCreateItemSimple(id, "black_bronze", 950);
        black_steel = setCreateItemSimple(id, "black_steel", 2570);
        blue_steel = setCreateItemSimple(id, "blue_steel", 2570);
        bronze = setCreateItemSimple(id, "bronze", 904);
        cast_iron = setCreateItemSimple(id, "cast_iron", 1127);
        copper = setCreateItemSimple(id, "copper", 1984);
        red_steel = setCreateItemSimple(id, "red_steel", 2570);
        steel = setCreateItemSimple(id, "steel", 1371);
        wrought_iron = setCreateItemSimple(id, "wrought_iron", 1482);
    }

    private static TfcMetalItem setCreateItemSimple(String variantId, String special, int meltingPoint) {
        return createMetal("metal/" + variantId + "/" + special, METAL_GROUP, meltingPoint);
    }
}

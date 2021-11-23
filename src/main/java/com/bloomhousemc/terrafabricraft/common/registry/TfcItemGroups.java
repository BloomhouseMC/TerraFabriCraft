package com.bloomhousemc.terrafabricraft.common.registry;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

import static com.bloomhousemc.terrafabricraft.TerraFabriCraft.MODID;

public final class TfcItemGroups {
    public static final ItemGroup EARTH_GROUP = FabricItemGroupBuilder.build(new Identifier(MODID, "earth"), () -> new ItemStack(TfcBlocks.SAND_WHITE));
    public static final ItemGroup ORES_GROUP = FabricItemGroupBuilder.build(new Identifier(MODID, "ores"), () -> new ItemStack(TfcBlocks.ORE_SMALL_NATIVE_COPPPER));
    public static final ItemGroup ROCK_GROUP = FabricItemGroupBuilder.build(new Identifier(MODID, "rock"), () -> new ItemStack(TfcBlocks.ANDESITE.raw.block));
    public static final ItemGroup METAL_GROUP = FabricItemGroupBuilder.build(new Identifier(MODID, "metal"), () -> new ItemStack(TfcItems.INGOT.wrought_iron));
    public static final ItemGroup WOOD_GROUP = FabricItemGroupBuilder.build(new Identifier(MODID, "wood"), () -> new ItemStack(TfcBlocks.WOOD_DOUGLAS_FIR.LOG));
    public static final ItemGroup FOOD_GROUP = FabricItemGroupBuilder.build(new Identifier(MODID, "food"), () -> new ItemStack(TfcItems.RED_APPLE));
    public static final ItemGroup FLORA_GROUP = FabricItemGroupBuilder.build(new Identifier(MODID, "flora"), () -> new ItemStack(TfcBlocks.PLANT_GOLDENROD));
    public static final ItemGroup DECORATIONS_GROUP = FabricItemGroupBuilder.build(new Identifier(MODID, "decorations"), () -> new ItemStack(TfcBlocks.ALABASTER_STAINED_CYAN.brick.block));
    public static final ItemGroup MISC_GROUP = FabricItemGroupBuilder.build(new Identifier(MODID, "misc"), () -> new ItemStack(TfcBlocks.WOOD_SPRUCE.LOG));
    public static final ItemGroup DEVICES_GROUP = FabricItemGroupBuilder.build(new Identifier(MODID, "devices"), () -> new ItemStack(TfcBlocks.WOOD_SPRUCE.LOG));

    private TfcItemGroups() {
    }

    public static void init() {
    }
}

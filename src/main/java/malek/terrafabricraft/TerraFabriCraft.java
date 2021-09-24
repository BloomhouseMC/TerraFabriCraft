package malek.terrafabricraft;

import malek.terrafabricraft.common.registry.TFCEntityTypes;
import malek.terrafabricraft.common.registry.TFCObjects;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class TerraFabriCraft implements ModInitializer {

    public static final String MODID = "terrafabricraft";
    public static final ItemGroup TFCROCKETSOIL_GROUP = FabricItemGroupBuilder.build(new Identifier(MODID, MODID), () -> new ItemStack(TFCObjects.ROCK_BLOCK));
    public static final ItemGroup TFCROCK_GROUP = FabricItemGroupBuilder.build(new Identifier(MODID, MODID), () -> new ItemStack(TFCObjects.ORE_SMALL_BISMUTHINITE));
    public static final ItemGroup TFCWOOD_GROUP = FabricItemGroupBuilder.build(new Identifier(MODID, MODID), () -> new ItemStack(TFCObjects.WOOD_SPRUCE.log));
    public static final ItemGroup TFCMETAL_GROUP = FabricItemGroupBuilder.build(new Identifier(MODID, MODID), () -> new ItemStack(TFCObjects.WOOD_SPRUCE.log));
    public static final ItemGroup TFCGEMS_GROUP = FabricItemGroupBuilder.build(new Identifier(MODID, MODID), () -> new ItemStack(TFCObjects.WOOD_SPRUCE.log));
    public static final ItemGroup TFCPOTTERY_GROUP = FabricItemGroupBuilder.build(new Identifier(MODID, MODID), () -> new ItemStack(TFCObjects.WOOD_SPRUCE.log));
    public static final ItemGroup TFCMISC_GROUP = FabricItemGroupBuilder.build(new Identifier(MODID, MODID), () -> new ItemStack(TFCObjects.WOOD_SPRUCE.log));

    @Override
    public void onInitialize() {
        TFCObjects.init();
        TFCEntityTypes.init();
    }
}

package malek.terrafabricraft;

import malek.terrafabricraft.common.event.TFCEvents;
import malek.terrafabricraft.common.registry.*;
import malek.terrafabricraft.common.registry.TFCScreens;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Identifier;

public class TerraFabriCraft implements ModInitializer {

    public static final String MODID = "terrafabricraft";
    public static final ItemGroup EARTH_GROUP = FabricItemGroupBuilder.build(new Identifier(MODID, "earth"), () -> new ItemStack(TFCObjects.SAND_WHITE));
    public static final ItemGroup ORES_GROUP = FabricItemGroupBuilder.build(new Identifier(MODID, "ores"), () -> new ItemStack(TFCObjects.ORE_SMALL_NATIVE_COPPPER));
    public static final ItemGroup ROCK_GROUP = FabricItemGroupBuilder.build(new Identifier(MODID, "rock"), () -> new ItemStack(TFCObjects.ANDESITE.raw.block));
    public static final ItemGroup METAL_GROUP = FabricItemGroupBuilder.build(new Identifier(MODID, "metal"), () -> new ItemStack(TFCObjects.ANDESITE.borax));
    public static final ItemGroup WOOD_GROUP = FabricItemGroupBuilder.build(new Identifier(MODID, "wood"), () -> new ItemStack(TFCObjects.WOOD_DOUGLAS_FIR.log));
    public static final ItemGroup FLORA_GROUP = FabricItemGroupBuilder.build(new Identifier(MODID, "flora"), () -> new ItemStack(TFCObjects.WOOD_SPRUCE.log));
    public static final ItemGroup DEVICES_GROUP = FabricItemGroupBuilder.build(new Identifier(MODID, "devices"), () -> new ItemStack(TFCObjects.WOOD_SPRUCE.log));
    public static final ItemGroup FOOD_GROUP = FabricItemGroupBuilder.build(new Identifier(MODID, "food"), () -> new ItemStack(TFCObjects.RED_APPLE));
    public static final ItemGroup MISC_GROUP = FabricItemGroupBuilder.build(new Identifier(MODID, "misc"), () -> new ItemStack(TFCObjects.WOOD_SPRUCE.log));
    public static final ItemGroup DECORATIONS_GROUP = FabricItemGroupBuilder.build(new Identifier(MODID, "decorations"), () -> new ItemStack(TFCObjects.ALABASTER_STAINED_CYAN.brick.block));


    @Override
    public void onInitialize() {
        //Must always be loaded before TFCObjects.
        TFCFeatures.init();
        TFCObjects.init();
        TFCBiome.init();
        TFCEntityTypes.init();
        TFCEvents.init();
        TFCScreens.init();


        ItemTooltipCallback.EVENT.register((stack, context, lines) -> {
            lines.add(new TranslatableText("tooltip.terrafabricraft.itemprop", new TranslatableText("Pog", new TranslatableText("Big"))));
            /*
            ClientWorld world = MinecraftClient.getInstance().world;
            if (world != null && stack.isFood() && stack.getItem() != TFCObjects.DECAY_FOOD_TEST2) {
                int percent = ((TFCFood.FoodDecay) (Object) stack).getRotPercentage(world);
                lines.add(new TranslatableText("tooltip.terrafabricraft.rot_status", percent).setStyle(Style.EMPTY.withColor(TextColor.parse("gray"))));
            }

             */
        });
    }
}

package malek.terrafabricraft;

import malek.terrafabricraft.common.event.TFCEvents;
import malek.terrafabricraft.common.registry.*;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class TerraFabriCraft implements ModInitializer {

    public static final String MODID = "terrafabricraft";
    public static final CreativeModeTab EARTH_GROUP = FabricItemGroupBuilder.build(new ResourceLocation(MODID, "earth"), () -> new ItemStack(TFCObjects.SAND_WHITE));
    public static final CreativeModeTab ORES_GROUP = FabricItemGroupBuilder.build(new ResourceLocation(MODID, "ores"), () -> new ItemStack(TFCObjects.ORE_SMALL_NATIVE_COPPPER));
    public static final CreativeModeTab ROCK_GROUP = FabricItemGroupBuilder.build(new ResourceLocation(MODID, "rock"), () -> new ItemStack(TFCObjects.ANDESITE.raw.block));
    public static final CreativeModeTab METAL_GROUP = FabricItemGroupBuilder.build(new ResourceLocation(MODID, "metal"), () -> new ItemStack(TFCObjects.INGOT.wrought_iron));
    public static final CreativeModeTab WOOD_GROUP = FabricItemGroupBuilder.build(new ResourceLocation(MODID, "wood"), () -> new ItemStack(TFCObjects.WOOD_DOUGLAS_FIR.log));
    public static final CreativeModeTab FLORA_GROUP = FabricItemGroupBuilder.build(new ResourceLocation(MODID, "flora"), () -> new ItemStack(TFCObjects.WOOD_SPRUCE.log));
    public static final CreativeModeTab DEVICES_GROUP = FabricItemGroupBuilder.build(new ResourceLocation(MODID, "devices"), () -> new ItemStack(TFCObjects.WOOD_SPRUCE.log));
    public static final CreativeModeTab FOOD_GROUP = FabricItemGroupBuilder.build(new ResourceLocation(MODID, "food"), () -> new ItemStack(TFCObjects.RED_APPLE));
    public static final CreativeModeTab MISC_GROUP = FabricItemGroupBuilder.build(new ResourceLocation(MODID, "misc"), () -> new ItemStack(TFCObjects.WOOD_SPRUCE.log));
    public static final CreativeModeTab DECORATIONS_GROUP = FabricItemGroupBuilder.build(new ResourceLocation(MODID, "decorations"), () -> new ItemStack(TFCObjects.ALABASTER_STAINED_CYAN.brick.block));


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
            lines.add(new TranslatableComponent("tooltip.terrafabricraft.itemprop", new TranslatableComponent("Pog", new TranslatableComponent("Big"))));
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

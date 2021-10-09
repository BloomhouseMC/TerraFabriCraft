package malek.terrafabricraft;

import malek.terrafabricraft.common.calendar.CalendarManager;
import malek.terrafabricraft.common.config.TFCConfig;
import malek.terrafabricraft.common.event.TFCEvents;
import malek.terrafabricraft.common.registry.*;
import malek.terrafabricraft.common.world.generator.feature.RockFeature;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class TerraFabriCraft implements ModInitializer {

    public static final Logger LOGGER = LogManager.getLogger(TerraFabriCraft.MODID);

    public static final String MODID = "terrafabricraft";
    public static final ItemGroup EARTH_GROUP = FabricItemGroupBuilder.build(new Identifier(MODID, "earth"), () -> new ItemStack(TFCObjects.SAND_WHITE));
    public static final ItemGroup ORES_GROUP = FabricItemGroupBuilder.build(new Identifier(MODID, "ores"), () -> new ItemStack(TFCObjects.ORE_SMALL_NATIVE_COPPPER));
    public static final ItemGroup ROCK_GROUP = FabricItemGroupBuilder.build(new Identifier(MODID, "rock"), () -> new ItemStack(TFCObjects.ANDESITE.raw.block));
    public static final ItemGroup METAL_GROUP = FabricItemGroupBuilder.build(new Identifier(MODID, "metal"), () -> new ItemStack(TFCObjects.INGOT.wrought_iron));
    public static final ItemGroup WOOD_GROUP = FabricItemGroupBuilder.build(new Identifier(MODID, "wood"), () -> new ItemStack(TFCObjects.WOOD_DOUGLAS_FIR.log));
    public static final ItemGroup FOOD_GROUP = FabricItemGroupBuilder.build(new Identifier(MODID, "food"), () -> new ItemStack(TFCObjects.RED_APPLE));
    public static final ItemGroup FLORA_GROUP = FabricItemGroupBuilder.build(new Identifier(MODID, "flora"), () -> new ItemStack(TFCObjects.PLANT_GOLDENROD));
    public static final ItemGroup DECORATIONS_GROUP = FabricItemGroupBuilder.build(new Identifier(MODID, "decorations"), () -> new ItemStack(TFCObjects.ALABASTER_STAINED_CYAN.brick.block));
    public static final ItemGroup MISC_GROUP = FabricItemGroupBuilder.build(new Identifier(MODID, "misc"), () -> new ItemStack(TFCObjects.WOOD_SPRUCE.log));
    public static final ItemGroup DEVICES_GROUP = FabricItemGroupBuilder.build(new Identifier(MODID, "devices"), () -> new ItemStack(TFCObjects.WOOD_SPRUCE.log));

    public static final Feature<OreFeatureConfig> ROCK_FEATURE = new RockFeature(OreFeatureConfig.CODEC);
    @Override
    public void onInitialize() {

        Registry.register(Registry.FEATURE, new Identifier("terrafabricraft", "rock_feature"), ROCK_FEATURE);
        // Config *must* be loaded before any other registry
        TFCConfig.init();
        CalendarManager.init();
        //Features must always be loaded before TFCObjects.
        TFCFeatures.init();
        TFCObjects.init();
        TFCBiome.init();
        TFCEntityTypes.init();
        TFCEvents.init();
        TFCScreens.init();
        TFCParticleTypes.init();
        TFCRecipeTypes.init();
        TFCSounds.init();

        ServerTickEvents.END_WORLD_TICK.register(world -> {

        });

    }
}

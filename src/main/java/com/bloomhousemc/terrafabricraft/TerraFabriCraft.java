package com.bloomhousemc.terrafabricraft;

import com.bloomhousemc.terrafabricraft.common.calendar.CalendarManager;
import com.bloomhousemc.terrafabricraft.common.config.TFCConfig;
import com.bloomhousemc.terrafabricraft.common.event.TFCEvents;
import com.bloomhousemc.terrafabricraft.common.registry.*;
import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public final class TerraFabriCraft implements ModInitializer {
    public static final String MODID = "terrafabricraft";
    public static final Logger LOGGER = LogManager.getLogger(TerraFabriCraft.MODID);

    @Override
    public void onInitialize() {
        // Config *must* be loaded before any other registry
        TFCConfig.init();
        CalendarManager.init();
        // Features must always be loaded before TfcBlocks.
        TfcFeatures.init();
        TfcItemGroups.init();
        TfcTags.init();
        TfcBlocks.init();
        TfcItems.init();
        TfcBlockEntities.init();
        TfcBiomes.init();
        TfcEntityTypes.init();
        TFCEvents.init();
        TfcScreens.init();
        TfcParticleTypes.init();
        TfcRecipeTypes.init();
        TfcSounds.init();
    }
}

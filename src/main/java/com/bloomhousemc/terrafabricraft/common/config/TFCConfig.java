package com.bloomhousemc.terrafabricraft.common.config;

import com.google.gson.JsonObject;

import java.io.File;

public class TFCConfig {
    public static void init() {
        ModuleConfig.init();

        String defaultConfig =
                "{\n" +
                        "  \"re_create_config_file\": false\n" +
                        "}";

        File configFile = Config.createFile("config/terrafabricraft/emergency_config.json", defaultConfig, false);
        JsonObject json = Config.getJsonObject(Config.readFile(configFile));

        ModuleConfig.generateConfigs(json == null || !json.has("re_create_config_file") || json.get("re_create_config_file").getAsBoolean());
        ModuleConfig.loadConfig();
    }
}

package malek.terrafabricraft.common.config;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.io.File;
import java.util.HashMap;
import java.util.Map;


public class ModuleConfig {
    private static final HashMap<String, Boolean> MODULES = new HashMap<>();

    public static boolean getValue(String key) {
        if (!MODULES.containsKey(key)) {
            System.out.println(key);
        }
        return MODULES.getOrDefault(key, null);
    }

    public static void init() {
        MODULES.put("world", true);
        MODULES.put("husbandry", true);
        MODULES.put("crops", true);
        MODULES.put("metallurgy", true);
        MODULES.put("construction", true);
    }

    public static void loadConfig() {
        JsonObject json = Config.getJsonObject(Config.readFile(new File("config/terrafabricraft/modules.json5")));
        for (Map.Entry<String, JsonElement> entry : json.entrySet()) {
            MODULES.put(entry.getKey(), entry.getValue().getAsBoolean());
        }
    }

    public static void generateConfigs(boolean overwrite) {
        StringBuilder config = new StringBuilder("{\n");
        int i = 0;
        for (String key : MODULES.keySet()) {
            config.append("  \"").append(key).append("\": ").append(MODULES.get(key));
            ++i;
            if (i < MODULES.size()) {
                config.append(",");
            }
            config.append("\n");
        }
        config.append("}");
        Config.createFile("config/terrafabricraft/modules.json5", config.toString(), overwrite);
    }
}

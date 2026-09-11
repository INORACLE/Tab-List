package ru.logitechno;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.fabricmc.loader.api.FabricLoader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Config {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final Path CONFIG_PATH = FabricLoader.getInstance().getConfigDir().resolve("tablist.json");

    public static String header = "#N             &a&lYOUR SERVER           #N&a&l&m    #N";
    public static String footer = "#N&f\u73a9\u5bb6: &e#PLAYERCOUNT &f| \u5ef6\u8fdf: &e#PING#N&fTPS: &e#TPS &f| MSPT: &e#MSPT#N";

    private static class ConfigData {
        String header;
        String footer;
    }

    public static void load() {
        if (Files.exists(CONFIG_PATH)) {
            try {
                String content = Files.readString(CONFIG_PATH);
                ConfigData data = GSON.fromJson(content, ConfigData.class);
                if (data != null) {
                    if (data.header != null) header = data.header;
                    if (data.footer != null) footer = data.footer;
                }
            } catch (IOException e) {
                // Use defaults on error
            }
        } else {
            save();
        }
    }

    public static void save() {
        ConfigData data = new ConfigData();
        data.header = header;
        data.footer = footer;
        try {
            Files.createDirectories(CONFIG_PATH.getParent());
            Files.writeString(CONFIG_PATH, GSON.toJson(data));
        } catch (IOException e) {
            // Ignore save errors
        }
    }
}

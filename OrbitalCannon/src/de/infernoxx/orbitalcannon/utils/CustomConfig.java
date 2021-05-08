package de.infernoxx.orbitalcannon.utils;
import org.bukkit.configuration.file.YamlConfiguration;

import de.infernoxx.orbitalcannon.main.Main;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;

public class CustomConfig {

    private static File configFile;
    private static YamlConfiguration customFile;

    public static void setup() {
    	System.out.println("setting up");
        configFile = new File(Main.getInstance().getDataFolder(),"config.yml");


        if(!configFile.exists()) {
            try {
            	System.out.println("creating file");
                configFile.createNewFile();
            } catch (IOException e) {
            	e.printStackTrace();
                Main.getInstance().pm.disablePlugin(Main.getInstance());
            }
        }

        customFile = YamlConfiguration.loadConfiguration(configFile);

        Reader stream = new InputStreamReader(Main.getInstance().getResource("defaultconfig.yml"), StandardCharsets.UTF_8);

        if (stream != null) {
            YamlConfiguration defConfig = YamlConfiguration.loadConfiguration(stream);
            customFile.setDefaults(defConfig);
            try {
                stream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static YamlConfiguration get() {
        return customFile;
    }

    public static void save() {
        try {
            customFile.save(configFile);
        } catch (IOException e) {
        }
    }

    public static void relaod() {
        customFile = YamlConfiguration.loadConfiguration(configFile);
    }
}
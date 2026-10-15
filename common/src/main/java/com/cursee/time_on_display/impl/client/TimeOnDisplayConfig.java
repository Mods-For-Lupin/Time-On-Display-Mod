package com.cursee.time_on_display.impl.client;

import com.cursee.time_on_display.Constants;
import com.electronwill.nightconfig.core.Config;
import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

public class TimeOnDisplayConfig {

    public static boolean displayEnabled = true;
    public static boolean displayOnlySystemTime = false;
    public static boolean displayClockIcons = true;
    public static boolean display24Hour = false;

    public static String displayLocation = "upper-left";
    public static String displaySystemTimeIcon = "";

    public static void load(Path configDir) {
        File configDirectory = new File(configDir.toUri());
        if (!configDirectory.isDirectory() && !configDirectory.mkdirs()) {
            Constants.LOG.info("Failed to get or create config directory {}", configDirectory.getAbsolutePath());
            return;
        }

        Path configFilepath = configDir.resolve(Constants.MOD_ID + ".toml");
        File configFile = new File(configFilepath.toUri());

        boolean insertionOrderPreserved = Config.isInsertionOrderPreserved();
        Config.setInsertionOrderPreserved(true);
        try (CommentedFileConfig config = CommentedFileConfig.builder(configFile).build()) {
            if (Files.exists(configFilepath)) {
                config.load();
            }
            displayEnabled = config.getOrElse("displayEnabled", displayEnabled);
            displayOnlySystemTime = config.getOrElse("displayOnlySystemTime", displayOnlySystemTime);
            displayClockIcons = config.getOrElse("displayClockIcons", displayClockIcons);
            display24Hour = config.getOrElse("display24Hour", display24Hour);
            displayLocation = config.getOrElse("displayLocation", displayLocation);
            displaySystemTimeIcon = config.getOrElse("displaySystemTimeIcon", displaySystemTimeIcon);
            config.remove("_comment1");
            config.remove("_comment2");

            config.set("displayEnabled", displayEnabled);
            config.set("displayOnlySystemTime", displayOnlySystemTime);
            config.set("displayClockIcons", displayClockIcons);
            config.set("display24Hour", display24Hour);
            config.setComment("displayLocation", " displayLocation can be lower-left, upper-left, upper-middle, upper-right, or lower-right (in quotes) for alternate positions");
            config.set("displayLocation", displayLocation);
            config.setComment("displaySystemTimeIcon", " displaySystemTimeIcon can be 1 or 2 (in quotes) for alternate icons");
            config.set("displaySystemTimeIcon", displaySystemTimeIcon);
            config.save();
        } catch (Exception e) {
            Constants.LOG.error(e.getMessage());
            Constants.LOG.info("Failed to read or write config file {}", configFile.getAbsolutePath());
        }
        Config.setInsertionOrderPreserved(insertionOrderPreserved);
    }
}

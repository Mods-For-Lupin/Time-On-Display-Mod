package com.cursee.time_on_display.impl.client;

import com.cursee.time_on_display.Constants;
import io.github.jason13official.monolib.api.common.EnvironmentSide;
import io.github.jason13official.monolib.api.common.config.ConfigGetterSetter.Commented;
import io.github.jason13official.monolib.impl.common.config.ModSidedConfigIO;
import java.nio.file.Path;
import java.util.List;

public class TimeOnDisplayConfig {

    public static boolean displayEnabled = true;
    public static Commented<Boolean> DISPLAY_ENABLED = new Commented<>("displayEnabled", () -> displayEnabled, value -> displayEnabled = value, "Whether the display can be shown at all.");
    public static boolean displayOnlySystemTime = false;
    public static Commented<Boolean> DISPLAY_ONLY_SYSTEM_TIME = new Commented<>("displayOnlySystemTime", () -> displayOnlySystemTime, value -> displayOnlySystemTime = value, "Whether to hide the game time and only show the system time.");
    public static boolean displayClockIcons = true;
    public static Commented<Boolean> DISPLAY_CLOCK_ICONS = new Commented<>("displayClockIcons", () -> displayClockIcons, value -> displayClockIcons = value, "Whether to show clock icons beside the times.");
    public static boolean display24Hour = false;
    public static Commented<Boolean> DISPLAY_24_HOUR = new Commented<>("display24Hour", () -> display24Hour, value -> display24Hour = value, "Whether the system time uses 24-hour format.");
    public static String displayLocation = "upper-left";
    public static Commented<String> DISPLAY_LOCATION = new Commented<>("displayLocation", () -> displayLocation, value -> displayLocation = value, "Can be lower-left, upper-left, upper-middle, upper-right, or lower-right (in quotes) for alternate positions.");
    public static String displaySystemTimeIcon = "";
    public static Commented<String> DISPLAY_SYSTEM_TIME_ICON = new Commented<>("displaySystemTimeIcon", () -> displaySystemTimeIcon, value -> displaySystemTimeIcon = value, "Can be 1 or 2 (in quotes) for alternate icons.");

    public static void load(Path configDir) {
        ModSidedConfigIO.load(configDir, Constants.MOD_ID, EnvironmentSide.CLIENT, List.of(
            DISPLAY_ENABLED,
            DISPLAY_ONLY_SYSTEM_TIME,
            DISPLAY_CLOCK_ICONS,
            DISPLAY_24_HOUR,
            DISPLAY_LOCATION,
            DISPLAY_SYSTEM_TIME_ICON
        ));
    }
}

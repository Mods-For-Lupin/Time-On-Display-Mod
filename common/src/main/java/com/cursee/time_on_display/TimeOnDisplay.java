package com.cursee.time_on_display;

import io.github.jason13official.monolib.impl.common.sailing.Sailing;
import net.minecraft.resources.Identifier;

public class TimeOnDisplay {

    public static void init() {

      Sailing.register(Constants.MOD_ID, "time_on_display-merged-26.1.2-2.0.0.jar");
    }

    public static Identifier identifier(final String path) {
        return Identifier.fromNamespaceAndPath(Constants.MOD_ID, path);
    }
}

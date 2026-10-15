package com.cursee.time_on_display;

import net.minecraft.resources.Identifier;

public class TimeOnDisplay {

    public static void init() {}

    public static Identifier identifier(final String path) {
        return Identifier.fromNamespaceAndPath(Constants.MOD_ID, path);
    }
}

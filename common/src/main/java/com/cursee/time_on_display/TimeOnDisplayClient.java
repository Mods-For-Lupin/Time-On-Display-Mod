package com.cursee.time_on_display;

import com.cursee.time_on_display.impl.client.TimeOnDisplayConfig;
import com.cursee.time_on_display.platform.Services;
import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import org.lwjgl.glfw.GLFW;

public class TimeOnDisplayClient {

  public static final String KEY_NAME = "key.time_on_display.toggle";
  public static final KeyMapping.Category KEY_CATEGORY = new KeyMapping.Category(TimeOnDisplay.identifier("overlay"));
  public static final KeyMapping TOGGLE_KEY = new KeyMapping(KEY_NAME, InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_F8, KEY_CATEGORY);

  public static boolean displayToggle = false;

  public static void init() {

    // TODO resource load events should do this for us?
    // TimeOnDisplayConfig.load(Services.PLATFORM.getConfigDirectory());
  }

  public static void tick() {
    while (TOGGLE_KEY.consumeClick()) {
      if (Minecraft.getInstance().player != null) {
        displayToggle = !displayToggle;
      }
    }
  }
}

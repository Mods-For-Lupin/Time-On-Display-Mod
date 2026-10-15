package com.cursee.time_on_display;

import com.cursee.time_on_display.impl.client.ConfigReloadListener;
import com.cursee.time_on_display.impl.client.TimeOnDisplayOverlay;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keymapping.v1.KeyMappingHelper;
import net.fabricmc.fabric.api.client.rendering.v1.hud.HudElementRegistry;
import net.fabricmc.fabric.api.resource.v1.ResourceLoader;
import net.minecraft.client.KeyMapping;
import net.minecraft.server.packs.PackType;

public class TimeOnDisplayFabricClient implements ClientModInitializer {

  @Override
  public void onInitializeClient() {
    TimeOnDisplayClient.init();
    KeyMapping.Category.register(TimeOnDisplayClient.KEY_CATEGORY.id());
    KeyMappingHelper.registerKeyMapping(TimeOnDisplayClient.TOGGLE_KEY);
    ClientTickEvents.END_CLIENT_TICK.register(client -> TimeOnDisplayClient.tick());
    ResourceLoader.get(PackType.CLIENT_RESOURCES).registerReloadListener(TimeOnDisplay.identifier("config"), new ConfigReloadListener());
    HudElementRegistry.addLast(TimeOnDisplay.identifier(Constants.MOD_ID), TimeOnDisplayOverlay::render);
  }
}

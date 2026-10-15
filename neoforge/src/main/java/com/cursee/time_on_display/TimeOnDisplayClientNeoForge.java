package com.cursee.time_on_display;

import com.cursee.time_on_display.impl.client.TimeOnDisplayOverlay;
import java.util.function.Consumer;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.neoforge.client.event.RegisterGuiLayersEvent;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import net.neoforged.neoforge.common.NeoForge;

public class TimeOnDisplayClientNeoForge {

  public TimeOnDisplayClientNeoForge(final IEventBus modEventBus) {

    modEventBus.addListener((Consumer<FMLClientSetupEvent>) event -> TimeOnDisplayClient.init());

    modEventBus.addListener((Consumer<RegisterKeyMappingsEvent>) event -> {
      event.registerCategory(TimeOnDisplayClient.KEY_CATEGORY);
      event.register(TimeOnDisplayClient.TOGGLE_KEY);
    });

    modEventBus.addListener((Consumer<RegisterGuiLayersEvent>) event ->
        event.registerAboveAll(TimeOnDisplay.identifier(Constants.MOD_ID), TimeOnDisplayOverlay::render));

    NeoForge.EVENT_BUS.addListener((Consumer<ClientTickEvent.Post>) event -> TimeOnDisplayClient.tick());
  }
}

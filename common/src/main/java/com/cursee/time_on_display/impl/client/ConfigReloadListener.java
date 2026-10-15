package com.cursee.time_on_display.impl.client;

import com.cursee.time_on_display.TimeOnDisplay;
import com.cursee.time_on_display.platform.Services;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.resources.SimplePreparableReloadListener;
import net.minecraft.util.profiling.ProfilerFiller;

public class ConfigReloadListener extends SimplePreparableReloadListener<Void> {

  @Override
  public String getName() {
    return TimeOnDisplay.identifier("config").toString();
  }

  @Override
  protected void apply(Void unused, ResourceManager resourceManager, ProfilerFiller profilerFiller) {
    TimeOnDisplayConfig.load(Services.PLATFORM.getConfigDirectory());
  }

  @Override
  protected Void prepare(ResourceManager resourceManager, ProfilerFiller profilerFiller) {
    return null;
  }
}

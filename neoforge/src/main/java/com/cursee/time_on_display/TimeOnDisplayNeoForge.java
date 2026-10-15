package com.cursee.time_on_display;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.loading.FMLLoader;

@Mod(Constants.MOD_ID)
public class TimeOnDisplayNeoForge {

    public TimeOnDisplayNeoForge(IEventBus bus) {

        TimeOnDisplay.init();

        if (FMLLoader.getCurrent().getDist() == Dist.CLIENT) {
            new TimeOnDisplayClientNeoForge(bus);
        }
    }
}

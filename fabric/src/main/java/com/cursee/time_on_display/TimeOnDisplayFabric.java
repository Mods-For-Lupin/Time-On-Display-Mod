package com.cursee.time_on_display;

import net.fabricmc.api.ModInitializer;

public class TimeOnDisplayFabric implements ModInitializer {
    
    @Override
    public void onInitialize() {
        
        TimeOnDisplay.init();
    }
}

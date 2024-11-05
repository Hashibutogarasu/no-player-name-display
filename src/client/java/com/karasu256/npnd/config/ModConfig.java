package com.karasu256.npnd.config;

import com.karasu256.npnd.NoPlayerNameDisplayClient;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;

@Config(name = NoPlayerNameDisplayClient.MOD_ID)
public class ModConfig implements ConfigData {
    public boolean hidePlayerNames = false;
}

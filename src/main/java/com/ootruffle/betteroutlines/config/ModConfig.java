package com.ootruffle.betteroutlines.config;

import cc.polyfrost.oneconfig.config.Config;
import cc.polyfrost.oneconfig.config.annotations.Color;
import cc.polyfrost.oneconfig.config.annotations.Slider;
import cc.polyfrost.oneconfig.config.data.Mod;
import cc.polyfrost.oneconfig.config.data.ModType;
import cc.polyfrost.oneconfig.config.data.OptionSize;
import cc.polyfrost.oneconfig.config.core.OneColor;
import com.ootruffle.betteroutlines.BetterOutlinesMod;

public class ModConfig extends Config {

    @Color(
            name = "Outline Color",
            size = OptionSize.SINGLE // Optional
    )
    public static OneColor outlineColor = new OneColor(255, 255, 255); // Default color (white)

    @Slider(
            name = "Outline Thickness",
            min = 1, max = 100, // Minimum and maximum values for the slider.
            step = 1 // The amount of steps that the slider should have.
    )
    public static int outlineThickness = 10; // Default thickness (adjusted to an int scale)

    public ModConfig() {
        super(new Mod(BetterOutlinesMod.NAME, ModType.UTIL_QOL), BetterOutlinesMod.MODID + ".json");
        initialize();
    }
}
package com.ootruffle.betteroutlines.config;

import cc.polyfrost.oneconfig.config.Config;
import cc.polyfrost.oneconfig.config.annotations.*;
import cc.polyfrost.oneconfig.config.data.InfoType;
import cc.polyfrost.oneconfig.config.data.Mod;
import cc.polyfrost.oneconfig.config.data.ModType;
import cc.polyfrost.oneconfig.config.data.OptionSize;
import cc.polyfrost.oneconfig.config.core.OneColor;
import com.ootruffle.betteroutlines.BetterOutlinesMod;

public class ModConfig extends Config {
    @Info(
    text = "This mod is very horrid edit of a exsisting mod, it doesint even use mixins",
    size = 2,
    type = InfoType.INFO
    )

    public static boolean ignored;

    @Color(
            name = "Outline Color",
            size = 1
    )
    public static OneColor outlineColor = new OneColor(255, 255, 255); 

    @Slider(
            name = "Outline Thickness",
            min = 1, max = 10, 
            step = 1 
    )
    public static int outlineThickness = 2; 

    @Slider(
        name = "Outline Transparency",
        min = 0, max = 255, 
        step = 1 
)
public static int outlineTransparency = 255; 

    public ModConfig() {
        super(new Mod("Better Outlines", ModType.UTIL_QOL, "/assets/betteroutlines/icon.png"), "betteroutlines.json");
        initialize();
    }
}
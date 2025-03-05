package com.ootruffle.betteroutlines;

import com.ootruffle.betteroutlines.config.ModConfig;
import com.ootruffle.betteroutlines.client.BlockOverlay;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = BetterOutlinesMod.MODID, name = BetterOutlinesMod.NAME, version = BetterOutlinesMod.VERSION)
public class BetterOutlinesMod {
    public static final String MODID = "betteroutlines";
    public static final String NAME = "Better Outlines";
    public static final String VERSION = "1.0";

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        new ModConfig();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(new BlockOverlay());
    }
}
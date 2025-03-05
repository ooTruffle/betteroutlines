package com.ootruffle.betteroutlines.client;

import com.ootruffle.betteroutlines.config.ModConfig;
import net.minecraft.client.renderer.GlStateManager;
import org.lwjgl.opengl.GL11;
import cc.polyfrost.oneconfig.config.core.OneColor;

public class OutlineRenderer {

    public static void applyOutlineSettings() {
        // Get the current outline color and thickness from the config
        OneColor color = ModConfig.outlineColor;
        int thickness = ModConfig.outlineThickness;

        float red = color.getRed() / 255.0F;
        float green = color.getGreen() / 255.0F;
        float blue = color.getBlue() / 255.0F;

        // Set the OpenGL color and line width for outlines
        GlStateManager.color(red, green, blue, 1.0F); // Assuming alpha is 1.0F
        GL11.glLineWidth(thickness / 10.0F); // Adjust thickness back to float scale
    }
}
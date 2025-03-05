package com.ootruffle.betteroutlines.client;

import com.ootruffle.betteroutlines.config.ModConfig;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MovingObjectPosition;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.opengl.GL11;
import cc.polyfrost.oneconfig.config.core.OneColor;

public class BlockOverlay {
    private static final Minecraft mc = Minecraft.getMinecraft();

    @SubscribeEvent
    public void onRenderWorldLast(RenderWorldLastEvent event) {
        if (mc.thePlayer == null || mc.objectMouseOver == null) {
            return;
        }
        MovingObjectPosition mop = mc.objectMouseOver;
        if (mop.typeOfHit != MovingObjectPosition.MovingObjectType.BLOCK) {
            return;
        }
        BlockPos pos = mop.getBlockPos();
        if (pos == null) {
            return;
        }
        double x = pos.getX() - (mc.thePlayer.lastTickPosX + (mc.thePlayer.posX - mc.thePlayer.lastTickPosX) * event.partialTicks);
        double y = pos.getY() - (mc.thePlayer.lastTickPosY + (mc.thePlayer.posY - mc.thePlayer.lastTickPosY) * event.partialTicks);
        double z = pos.getZ() - (mc.thePlayer.lastTickPosZ + (mc.thePlayer.posZ - mc.thePlayer.lastTickPosZ) * event.partialTicks);
        drawDefaultOutline(x, y, z, ModConfig.outlineColor, ModConfig.outlineTransparency);
    }

    private void drawDefaultOutline(double x, double y, double z, OneColor color, int transparency) {
        GlStateManager.pushMatrix();
        GlStateManager.enableBlend();
        GlStateManager.blendFunc(770, 771);
        GlStateManager.disableTexture2D();
        GlStateManager.depthMask(false);
        int red = color.getRed();
        int green = color.getGreen();
        int blue = color.getBlue();
        int alpha = transparency;
        GlStateManager.color(red / 255.0f, green / 255.0f, blue / 255.0f, alpha / 255.0f);
        GL11.glLineWidth(ModConfig.outlineThickness);
        RenderGlobal.drawOutlinedBoundingBox(new AxisAlignedBB(x, y, z, x + 1.0, y + 1.0, z + 1.0), red, green, blue, alpha);
        GlStateManager.depthMask(true);
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
        GlStateManager.popMatrix();
    }
}
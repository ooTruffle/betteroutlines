package com.ootruffle.betteroutlines.mixin;

import com.ootruffle.betteroutlines.client.OutlineRenderer;
import net.minecraft.client.renderer.BlockRendererDispatcher;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.util.BlockPos;
import net.minecraft.world.IBlockAccess;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BlockRendererDispatcher.class)
public class MixinBlockRendererDispatcher {

    @Inject(method = "renderBlock", at = @At("HEAD"))
    public void onRenderBlock(IBlockAccess blockAccess, BlockPos pos, net.minecraft.block.state.IBlockState state, WorldRenderer worldRenderer, CallbackInfo ci) {
        // Apply the outline settings before rendering the block
        OutlineRenderer.applyOutlineSettings();
    }
}
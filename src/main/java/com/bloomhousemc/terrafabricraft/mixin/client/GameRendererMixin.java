package com.bloomhousemc.terrafabricraft.mixin.client;

import com.bloomhousemc.terrafabricraft.TerraFabriCraftClient;
import com.bloomhousemc.terrafabricraft.client.CustomLightmapTextureManager;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.BufferBuilderStorage;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.resource.ResourceManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GameRenderer.class)
public class GameRendererMixin {
    private CustomLightmapTextureManager customLightmapTextureManager;
    @Inject(method = "<init>", cancellable = false,  at = @At("TAIL"))
    public void gameRenderer(MinecraftClient minecraftClient, ResourceManager resourceManager, BufferBuilderStorage bufferBuilderStorage, CallbackInfo ci) {
        TerraFabriCraftClient.customLightmapTextureManager = new CustomLightmapTextureManager(minecraftClient.gameRenderer, minecraftClient);
    }
    @Inject(method = "close()V", cancellable = true, at = @At("HEAD"))
    public void close(CallbackInfo ci) {
        TerraFabriCraftClient.customLightmapTextureManager.close();
    }
}

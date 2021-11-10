package com.bloomhousemc.terrafabricraft.client;

import com.mojang.blaze3d.systems.RenderSystem;
import com.bloomhousemc.terrafabricraft.TerraFabriCraftClient;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.RenderPhase;
import net.minecraft.client.texture.TextureManager;
import net.minecraft.util.Identifier;

import java.util.Optional;
@Environment(EnvType.CLIENT)
public class TextureTwo extends RenderPhase.TextureBase {

    private final Optional<Identifier> id;
    private final boolean blur;
    private final boolean mipmap;
    public TextureTwo(Identifier identifier, boolean bl, boolean bl2){
            super(() -> {
                TerraFabriCraftClient.customLightmapTextureManager.enable();
                RenderSystem.enableTexture();

                TextureManager textureManager = MinecraftClient.getInstance().getTextureManager();
                textureManager.getTexture(identifier).setFilter(bl, bl2);
                RenderSystem.setShaderTexture(0, identifier);
            }, () -> {
            });
            this.id = Optional.of(identifier);
            this.blur = bl;
            this.mipmap = bl2;
        }

        public String toString () {
            return this.name + "[" + this.id + "(blur=" + this.blur + ", mipmap=" + this.mipmap + ")]";
        }

        protected Optional<Identifier> getId () {
            return this.id;
        }

}

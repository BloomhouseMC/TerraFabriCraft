package com.bloomhousemc.terrafabricraft.client.screens;

import com.mojang.blaze3d.systems.RenderSystem;
import io.github.cottonmc.cotton.gui.client.CottonInventoryScreen;
import com.bloomhousemc.terrafabricraft.TerraFabriCraft;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class AnvilScreen extends CottonInventoryScreen<AnvilGuiDescription> {
    private static final Identifier TEXTURE = new Identifier(TerraFabriCraft.MODID, "textures/gui/anvil.png");

    public AnvilScreen(AnvilGuiDescription gui, PlayerEntity player, Text title) {
        super(gui, player, title);
    }

    @Override
    protected void drawBackground(MatrixStack matrices, float partialTicks, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
    }
}

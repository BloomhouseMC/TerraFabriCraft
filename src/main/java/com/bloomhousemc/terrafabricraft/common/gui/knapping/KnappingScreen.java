package com.bloomhousemc.terrafabricraft.common.gui.knapping;

import com.bloomhousemc.terrafabricraft.TerraFabriCraft;
import com.bloomhousemc.terrafabricraft.client.screens.KnappingScreenHandler;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.gui.screen.recipebook.RecipeBookProvider;
import net.minecraft.client.gui.screen.recipebook.RecipeBookWidget;
import net.minecraft.client.gui.widget.TexturedButtonWidget;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Identifier;

import static com.bloomhousemc.terrafabricraft.TerraFabriCraft.MODID;

public class KnappingScreen extends HandledScreen<KnappingScreenHandler> implements RecipeBookProvider {
    private static final Identifier KNAPPING_BUTTON_TEXTURE = new Identifier(MODID, "textures/gui/knapping/clay_ball.png");
    private static final Identifier KNAPPING_TEXTURE = new Identifier(MODID, "textures/gui/knapping.png");
    private final RecipeBookWidget recipeBook = new RecipeBookWidget();
    private boolean narrow;

    public KnappingScreen(KnappingScreenHandler screenHandler, PlayerInventory playerInventory, Text text) {
        super(screenHandler, playerInventory, text);
    }

    @Override
    public void init() {
        super.init();
        narrow = this.width < 379;
        this.recipeBook.initialize(this.width, this.height, this.client, this.narrow, this.handler);
        this.x = this.recipeBook.findLeftEdge(this.width, this.backgroundWidth);
        int l;
        for (int m = 0; m < 5; ++m) {
            for (l = 0; l < 5; ++l) {
                addDrawableChild(new TexturedButtonWidget(l + m * 9 + 9, 8 + l * 18, 10, 10, 20, 38, 20, KNAPPING_BUTTON_TEXTURE, 256, 256, button -> {
                    onButtonClick(false, new TranslatableText("gui.socialInteractions.shown_in_chat"));
                }));
            }
        }
    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        this.renderBackground(matrices);
        if (this.recipeBook.isOpen() && this.narrow) {
            this.drawBackground(matrices, delta, mouseX, mouseY);
            this.recipeBook.render(matrices, mouseX, mouseY, delta);
        } else {
            this.recipeBook.render(matrices, mouseX, mouseY, delta);
            super.render(matrices, mouseX, mouseY, delta);
            this.recipeBook.drawGhostSlots(matrices, this.x, this.y, true, delta);
        }

        this.drawMouseoverTooltip(matrices, mouseX, mouseY);
        this.recipeBook.drawTooltip(matrices, this.x, this.y, mouseX, mouseY);
    }

    @Override
    protected void drawBackground(MatrixStack matrices, float delta, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, KNAPPING_TEXTURE);
        int i = this.x;
        int j = (this.height - this.backgroundHeight) / 2;
        this.drawTexture(matrices, i, j, 0, 0, this.backgroundWidth, this.backgroundHeight);
    }

    private void onButtonClick(boolean showButtonVisible, Text chatMessage) {
        TerraFabriCraft.LOGGER.debug("TFC is blessed");
    }

    @Override
    public void refreshRecipeBook() {
        recipeBook.refresh();
    }

    @Override
    public RecipeBookWidget getRecipeBookWidget() {
        return recipeBook;
    }
}

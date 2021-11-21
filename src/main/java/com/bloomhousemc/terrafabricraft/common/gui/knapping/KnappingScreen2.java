//package com.bloomhousemc.terrafabricraft.common.gui.knapping;
//
//import com.bloomhousemc.terrafabricraft.TerraFabriCraft;
//import com.mojang.blaze3d.systems.RenderSystem;
//import net.fabricmc.api.EnvType;
//import net.fabricmc.api.Environment;
//import net.minecraft.client.gui.screen.ingame.HandledScreen;
//import net.minecraft.client.gui.screen.recipebook.RecipeBookProvider;
//import net.minecraft.client.gui.screen.recipebook.RecipeBookWidget;
//import net.minecraft.client.gui.widget.TexturedButtonWidget;
//import net.minecraft.client.render.*;
//import net.minecraft.client.util.math.MatrixStack;
//import net.minecraft.entity.player.PlayerInventory;
//import net.minecraft.text.Text;
//import net.minecraft.util.Identifier;
//import net.minecraft.util.math.Matrix4f;
//
//@Environment(EnvType.CLIENT)
//public class KnappingScreen extends HandledScreen<KnappingScreenHandler> implements RecipeBookProvider {
//    private static final Identifier GUI_TEXTURE = new Identifier(TerraFabriCraft.MODID, "textures/gui/knapping.png");
//    private static final Identifier RECIPE_BUTTON_TEXTURE = new Identifier("textures/gui/recipe_button.png");
//    private final RecipeBookWidget recipeBook = new RecipeBookWidget();
//    private boolean narrow;
//    private float scrollAmount;
//    private int scrollOffset;
//    private KnappingButton focusedButton;
//
//    public KnappingScreen(KnappingScreenHandler screenHandler, PlayerInventory playerInventory, Text text) {
//        super(screenHandler, playerInventory, text);
//    }
//
//    private static void drawTexturedQuad(Matrix4f matrices, int x0, int x1, int y0, int y1, int z, float u0, float u1, float v0, float v1) {
//        RenderSystem.setShader(GameRenderer::getPositionTexShader);
//        BufferBuilder bufferBuilder = Tessellator.getInstance().getBuffer();
//        bufferBuilder.begin(VertexFormat.DrawMode.QUADS, VertexFormats.POSITION_TEXTURE);
//        bufferBuilder.vertex(matrices, (float) x0, (float) y1, (float) z).texture(u0, v1).next();
//        bufferBuilder.vertex(matrices, (float) x1, (float) y1, (float) z).texture(u1, v1).next();
//        bufferBuilder.vertex(matrices, (float) x1, (float) y0, (float) z).texture(u1, v0).next();
//        bufferBuilder.vertex(matrices, (float) x0, (float) y0, (float) z).texture(u0, v0).next();
//        bufferBuilder.end();
//        BufferRenderer.draw(bufferBuilder);
//    }
//
//    public static void drawSlotHighlight(MatrixStack matrices, int x, int y, int z) {
//        RenderSystem.disableDepthTest();
//        RenderSystem.colorMask(true, true, true, false);
//        fillGradient(matrices, x, y, x + 16, y + 16, -2130706433, -2130706433, z);
//        RenderSystem.colorMask(true, true, true, true);
//        RenderSystem.enableDepthTest();
//    }
//
//    @Override
//    protected void init() {
//        super.init();
//        this.narrow = this.width < 379;
//        this.recipeBook.initialize(this.width, this.height, this.client, this.narrow, this.handler);
//        this.x = this.recipeBook.findLeftEdge(this.width, this.backgroundWidth);
//        this.addDrawableChild(new TexturedButtonWidget(this.x + 5, this.height / 2 - 49, 20, 18, 0, 0, 19, RECIPE_BUTTON_TEXTURE, (button) -> {
//            this.recipeBook.toggleOpen();
//            this.x = this.recipeBook.findLeftEdge(this.width, this.backgroundWidth);
//            ((TexturedButtonWidget) button).setPos(this.x + 5, this.height / 2 - 49);
//        }));
//        this.addSelectableChild(this.recipeBook);
//        this.setInitialFocus(this.recipeBook);
//        this.titleX = 29;
//    }
//
//    public void refreshRecipeBook() {
//        this.recipeBook.refresh();
//    }
//
//    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
//        this.renderBackground(matrices);
//        if (this.recipeBook.isOpen() && this.narrow) {
//            this.drawBackground(matrices, delta, mouseX, mouseY);
//            this.recipeBook.render(matrices, mouseX, mouseY, delta);
//        } else {
//            this.recipeBook.render(matrices, mouseX, mouseY, delta);
//            super.render(matrices, mouseX, mouseY, delta);
//            this.recipeBook.drawGhostSlots(matrices, this.x, this.y, true, delta);
//        }
//
//        this.drawMouseoverTooltip(matrices, mouseX, mouseY);
//        this.recipeBook.drawTooltip(matrices, this.x, this.y, mouseX, mouseY);
//
//        int p;
//        int q;
//        for (int k = 0; k < this.handler.knappingButtons.size(); ++k) {
//            KnappingButton knappingButton = this.handler.knappingButtons.get(k);
//            if (knappingButton.isEnabled()) {
//                RenderSystem.setShader(GameRenderer::getPositionTexShader);
//                this.drawKnappingButton(matrices, knappingButton);
//            }
//
//            if (this.isPointOverButton(knappingButton, (double) mouseX, (double) mouseY) && knappingButton.isEnabled()) {
//                this.focusedButton = knappingButton;
//                p = knappingButton.x;
//                q = knappingButton.y;
//                drawSlotHighlight(matrices, p, q, this.getZOffset());
//            }
//        }
//    }
//
//    private boolean isPointOverButton(KnappingButton button, double pointX, double pointY) {
//        return this.isPointWithinBounds(button.x, button.y, 16, 16, pointX, pointY);
//    }
//
//    @Override
//    protected void drawBackground(MatrixStack matrices, float delta, int mouseX, int mouseY) {
//        RenderSystem.setShader(GameRenderer::getPositionTexShader);
//        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
//        RenderSystem.setShaderTexture(0, GUI_TEXTURE);
//        int i = x;
//        int j = (this.height - this.backgroundHeight) / 2;
//        this.drawTexture(matrices, i, j, 0, 0, this.backgroundWidth, this.backgroundHeight);
//    }
//
//    private void drawKnappingButton(MatrixStack matrices, KnappingButton button) {
//        var width = 18;
//        var height = 18;
//
//        if (width <= 0) width = 1;
//        if (height <= 0) height = 1;
//
//        float r = (0xFFFFFFFF >> 16 & 255) / 255.0F;
//        float g = (0xFFFFFFFF >> 8 & 255) / 255.0F;
//        float b = (0xFFFFFFFF & 255) / 255.0F;
//        Tessellator tessellator = Tessellator.getInstance();
//        BufferBuilder buffer = tessellator.getBuffer();
//        Matrix4f model = matrices.peek().getModel();
//        RenderSystem.enableBlend();
//        RenderSystem.setShaderTexture(0, new Identifier(TerraFabriCraft.MODID, "textures/gui/knapping/rock/loose/andesite.png"));
//        RenderSystem.setShaderColor(r, g, b, 1.0f);
//        RenderSystem.setShader(GameRenderer::getPositionTexShader);
//        buffer.begin(VertexFormat.DrawMode.QUADS, VertexFormats.POSITION_TEXTURE);
//        buffer.vertex(model, button.x + 100, button.y + 40 + height, 0).texture(0.0F, 1.0F).next();
//        buffer.vertex(model, button.x + 100 + width, button.y + 40 + height, 0).texture(1.0F, 1.0F).next();
//        buffer.vertex(model, button.x + 100 + width, button.y + 40, 0).texture(1.0F, 0.0F).next();
//        buffer.vertex(model, button.x + 100, button.y + 40, 0).texture(0.0F, 0.0F).next();
//        buffer.end();
//        BufferRenderer.draw(buffer);
//        RenderSystem.disableBlend();
//    }
//
//    public RecipeBookWidget getRecipeBookWidget() {
//        return this.recipeBook;
//    }
//
//    public boolean mouseClicked(double mouseX, double mouseY, int button) {
//        if (this.recipeBook.mouseClicked(mouseX, mouseY, button)) {
//            this.setFocused(this.recipeBook);
//            return true;
//        } else {
//            return this.narrow && this.recipeBook.isOpen() || super.mouseClicked(mouseX, mouseY, button);
//        }
//    }
//
//    public void handledScreenTick() {
//        super.handledScreenTick();
//        this.recipeBook.update();
//    }
//}
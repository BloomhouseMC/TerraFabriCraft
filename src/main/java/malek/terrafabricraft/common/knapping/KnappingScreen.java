package malek.terrafabricraft.common.knapping;

import com.mojang.blaze3d.systems.RenderSystem;
import malek.terrafabricraft.TerraFabriCraft;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.gui.screen.recipebook.RecipeBookProvider;
import net.minecraft.client.gui.screen.recipebook.RecipeBookWidget;
import net.minecraft.client.gui.widget.TexturedButtonWidget;
import net.minecraft.client.render.*;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.slot.Slot;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Matrix4f;

@Environment(EnvType.CLIENT)
public class KnappingScreen extends HandledScreen<KnappingScreenHandler> implements RecipeBookProvider {
    private static final Identifier TEXTURE = new Identifier("textures/gui/container/hopper.png");

    private static final Identifier GUI_TEXTURE = new Identifier(TerraFabriCraft.MODID, "textures/gui/vessel_container.png");
    private static final Identifier RECIPE_BUTTON_TEXTURE = new Identifier("textures/gui/recipe_button.png");
    private final RecipeBookWidget recipeBook = new RecipeBookWidget();
    private boolean narrow;

    public KnappingScreen(KnappingScreenHandler screenHandler, PlayerInventory playerInventory, Text text) {
        super(screenHandler, playerInventory, text);
    }

    private static void drawTexturedQuad(Matrix4f matrices, int x0, int x1, int y0, int y1, int z, float u0, float u1, float v0, float v1) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        BufferBuilder bufferBuilder = Tessellator.getInstance().getBuffer();
        bufferBuilder.begin(VertexFormat.DrawMode.QUADS, VertexFormats.POSITION_TEXTURE);
        bufferBuilder.vertex(matrices, (float) x0, (float) y1, (float) z).texture(u0, v1).next();
        bufferBuilder.vertex(matrices, (float) x1, (float) y1, (float) z).texture(u1, v1).next();
        bufferBuilder.vertex(matrices, (float) x1, (float) y0, (float) z).texture(u1, v0).next();
        bufferBuilder.vertex(matrices, (float) x0, (float) y0, (float) z).texture(u0, v0).next();
        bufferBuilder.end();
        BufferRenderer.draw(bufferBuilder);
    }

    @Override
    protected void init() {
        super.init();
        this.narrow = this.width < 379;
        this.recipeBook.initialize(this.width, this.height, this.client, this.narrow, this.handler);
        this.x = this.recipeBook.findLeftEdge(this.width, this.backgroundWidth);
        this.addDrawableChild(new TexturedButtonWidget(this.x + 5, this.height / 2 - 49, 20, 18, 0, 0, 19, RECIPE_BUTTON_TEXTURE, (button) -> {
            this.recipeBook.toggleOpen();
            this.x = this.recipeBook.findLeftEdge(this.width, this.backgroundWidth);
            ((TexturedButtonWidget) button).setPos(this.x + 5, this.height / 2 - 49);
        }));
        this.addSelectableChild(this.recipeBook);
        this.setInitialFocus(this.recipeBook);
        this.titleX = 29;
    }

    public void refreshRecipeBook() {
        this.recipeBook.refresh();
    }

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
        //Must match removedSpacing in KnappingScreenHandler
        var addedSpacing = 35;
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        renderBackgroundTexture(matrices, new Rectangle(x, y, backgroundWidth, backgroundHeight + addedSpacing), delta, 0xFFFFFFFF);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int i = this.x;
        int j = (this.height - this.backgroundHeight) / 2;
        for (Slot slot : getScreenHandler().slots) {
            this.drawTexture(matrices, x + slot.x - 1, y + slot.y - 1, 43, 19, 18, 18);
        }
    }

    public void renderBackgroundTexture(MatrixStack matrices, KnappingScreen.Rectangle bounds, float delta, int color) {
        float alpha = ((color >> 24) & 0xFF) / 255f;
        float red = ((color >> 16) & 0xFF) / 255f;
        float green = ((color >> 8) & 0xFF) / 255f;
        float blue = (color & 0xFF) / 255f;
        RenderSystem.clearColor(red, green, blue, alpha);
        RenderSystem.setShaderTexture(0, GUI_TEXTURE);
        int x = bounds.x, y = bounds.y, width = bounds.width, height = bounds.height;
        int xTextureOffset = 0;
        int yTextureOffset = 66;

        // Four Corners
        this.drawTexture(matrices, x, y, 106 + xTextureOffset, 124 + yTextureOffset, 8, 8);
        this.drawTexture(matrices, x + width - 8, y, 248 + xTextureOffset, 124 + yTextureOffset, 8, 8);
        this.drawTexture(matrices, x, y + height - 8, 106 + xTextureOffset, 182 + yTextureOffset, 8, 8);
        this.drawTexture(matrices, x + width - 8, y + height - 8, 248 + xTextureOffset, 182 + yTextureOffset, 8, 8);

        Matrix4f matrix = matrices.peek().getModel();
        // Sides
        drawTexturedQuad(matrix, x + 8, x + width - 8, y, y + 8, getZOffset(), (114 + xTextureOffset) / 256f, (248 + xTextureOffset) / 256f, (124 + yTextureOffset) / 256f, (132 + yTextureOffset) / 256f);
        drawTexturedQuad(matrix, x + 8, x + width - 8, y + height - 8, y + height, getZOffset(), (114 + xTextureOffset) / 256f, (248 + xTextureOffset) / 256f, (182 + yTextureOffset) / 256f, (190 + yTextureOffset) / 256f);
        drawTexturedQuad(matrix, x, x + 8, y + 8, y + height - 8, getZOffset(), (106 + xTextureOffset) / 256f, (114 + xTextureOffset) / 256f, (132 + yTextureOffset) / 256f, (182 + yTextureOffset) / 256f);
        drawTexturedQuad(matrix, x + width - 8, x + width, y + 8, y + height - 8, getZOffset(), (248 + xTextureOffset) / 256f, (256 + xTextureOffset) / 256f, (132 + yTextureOffset) / 256f, (182 + yTextureOffset) / 256f);

        // Center
        drawTexturedQuad(matrix, x + 8, x + width - 8, y + 8, y + height - 8, getZOffset(), (114 + xTextureOffset) / 256f, (248 + xTextureOffset) / 256f, (132 + yTextureOffset) / 256f, (182 + yTextureOffset) / 256f);
    }

    public RecipeBookWidget getRecipeBookWidget() {
        return this.recipeBook;
    }

    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        if (this.recipeBook.mouseClicked(mouseX, mouseY, button)) {
            this.setFocused(this.recipeBook);
            return true;
        } else {
            return this.narrow && this.recipeBook.isOpen() ? true : super.mouseClicked(mouseX, mouseY, button);
        }
    }

    public void handledScreenTick() {
        super.handledScreenTick();
        this.recipeBook.update();
    }

    public class Rectangle {
        public int x;
        public int y;
        public int width;
        public int height;

        public Rectangle(int x, int y, int width, int height) {
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
        }
    }
}

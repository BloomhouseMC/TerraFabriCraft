package malek.terrafabricraft.client.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import malek.terrafabricraft.TerraFabriCraft;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class TFCScreen<C extends ScreenHandler> extends HandledScreen<C> {
    public static final Identifier INVENTORY_1x1 = new Identifier(TerraFabriCraft.MODID, "textures/gui/single_inventory.png");
    public static final Identifier INVENTORY_2x2 = new Identifier(TerraFabriCraft.MODID, "textures/gui/small_inventory.png");

    protected final Identifier texture;
    protected final PlayerInventory playerInventory;

    public TFCScreen(C container, PlayerInventory playerInventory, Text name, Identifier texture) {
        super(container, playerInventory, name);
        this.texture = texture;
        this.playerInventory = playerInventory;
    }

    @Override
    public void render(MatrixStack poseStack, int mouseX, int mouseY, float partialTicks)
    {
        renderBackground(poseStack);
        super.render(poseStack, mouseX, mouseY, partialTicks);
    //    renderTooltip(poseStack, mouseX, mouseY);
    }

    @Override
    protected void drawBackground(MatrixStack matrixStack, float partialTicks, int mouseX, int mouseY) {
        drawDefaultBackground(matrixStack);
    }

    protected void drawDefaultBackground(MatrixStack poseStack) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1f, 1f, 1f, 1f);
        RenderSystem.setShaderTexture(0, this.texture);

        drawTexture(poseStack, titleX, titleY, 0, 0, 0, backgroundWidth, backgroundHeight, 256, 256);
    }

    protected void drawCenteredLine(MatrixStack stack, String text, int y) {
        final int x = (backgroundWidth - textRenderer.getWidth(text)) / 2;
        textRenderer.draw(stack, text, x, y, 0x404040);
    }
}

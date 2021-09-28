package malek.terrafabricraft.client.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import malek.terrafabricraft.TerraFabriCraft;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;

public class TFCScreen<C extends AbstractContainerMenu> extends AbstractContainerScreen<C> {
    public static final ResourceLocation INVENTORY_1x1 = new ResourceLocation(TerraFabriCraft.MODID, "textures/gui/single_inventory.png");
    public static final ResourceLocation INVENTORY_2x2 = new ResourceLocation(TerraFabriCraft.MODID, "textures/gui/small_inventory.png");

    protected final ResourceLocation texture;
    protected final Inventory playerInventory;

    public TFCScreen(C container, Inventory playerInventory, Component name, ResourceLocation texture) {
        super(container, playerInventory, name);
        this.texture = texture;
        this.playerInventory = playerInventory;
    }

    @Override
    public void render(PoseStack poseStack, int mouseX, int mouseY, float partialTicks)
    {
        renderBackground(poseStack);
        super.render(poseStack, mouseX, mouseY, partialTicks);
    //    renderTooltip(poseStack, mouseX, mouseY);
    }

    @Override
    protected void renderBg(PoseStack matrixStack, float partialTicks, int mouseX, int mouseY) {
        drawDefaultBackground(matrixStack);
    }

    protected void drawDefaultBackground(PoseStack poseStack) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1f, 1f, 1f, 1f);
        RenderSystem.setShaderTexture(0, this.texture);

        blit(poseStack, titleLabelX, titleLabelY, 0, 0, 0, imageWidth, imageHeight, 256, 256);
    }

    protected void drawCenteredLine(PoseStack stack, String text, int y) {
        final int x = (imageWidth - font.width(text)) / 2;
        font.draw(stack, text, x, y, 0x404040);
    }
}

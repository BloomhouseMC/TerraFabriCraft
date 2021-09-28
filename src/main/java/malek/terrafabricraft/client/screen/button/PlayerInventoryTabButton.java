package malek.terrafabricraft.client.screen.button;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import malek.terrafabricraft.TerraFabriCraft;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.inventory.InventoryScreen;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.resources.ResourceLocation;
import java.awt.*;

public class PlayerInventoryTabButton extends Button {
    private static final ResourceLocation TEXTURE = new ResourceLocation(TerraFabriCraft.MODID, "textures/gui/icons.png");

    private final int textureU;
    private final int textureV;
    private final int iconU;
    private final int iconV;
    private int iconX;
    private int iconY;
    private int prevGuiLeft;
    private int prevGuiTop;
    private Runnable tickCallback;

/*    public PlayerInventoryTabButton(int guiLeft, int guiTop, int xIn, int yIn, int widthIn, int heightIn, int textureU, int textureV, int iconX, int iconY, int iconU, int iconV, SwitchInventoryTabPacket.Type type)
    {
        this(guiLeft, guiTop, xIn, yIn, widthIn, heightIn, textureU, textureV, iconX, iconY, iconU, iconV, button -> button.);
    } */

    public PlayerInventoryTabButton(int guiLeft, int guiTop, int xIn, int yIn, int widthIn, int heightIn, int textureU, int textureV, int iconX, int iconY, int iconU, int iconV, OnPress onPressIn)
    {
        super(guiLeft + xIn, guiTop + yIn, widthIn, heightIn, TextComponent.EMPTY, onPressIn);
        this.prevGuiLeft = guiLeft;
        this.prevGuiTop = guiTop;
        this.textureU = textureU;
        this.textureV = textureV;
        this.iconX = guiLeft + xIn + iconX;
        this.iconY = guiTop + yIn + iconY;
        this.iconU = iconU;
        this.iconV = iconV;
        this.tickCallback = () -> {};
    }

    public PlayerInventoryTabButton setRecipeBookCallback(InventoryScreen screen)
    {
        this.tickCallback = new Runnable()
        {
            boolean recipeBookVisible = screen.getRecipeBookComponent().isVisible();

            @Override
            public void run()
            {
                boolean newRecipeBookVisible = screen.getRecipeBookComponent().isVisible();
                if (newRecipeBookVisible != recipeBookVisible)
                {
                    recipeBookVisible = newRecipeBookVisible;
                    PlayerInventoryTabButton.this.updateGuiSize(screen.width, screen.height);
                }
            }
        };
        return this;
    }

    @Override
    public void renderButton(PoseStack matrixStack, int mouseX, int mouseY, float partialTicks)
    {
        RenderSystem.setShaderTexture(0, TEXTURE);
        RenderSystem.disableDepthTest();

        tickCallback.run();

        blit(matrixStack, x, y, 0, (float) textureU, (float) textureV, width, height, 256, 256);
        blit(matrixStack, iconX, iconY, 16, 16, (float) iconU, (float) iconV, 32, 32, 256, 256);
        RenderSystem.enableDepthTest();
    }

    public void updateGuiSize(int guiLeft, int guiTop)
    {
        this.x += guiLeft - prevGuiLeft;
        this.y += guiTop - prevGuiTop;

        this.iconX += guiLeft - prevGuiLeft;
        this.iconY += guiTop - prevGuiTop;

        prevGuiLeft = guiLeft;
        prevGuiTop = guiTop;
    }
}

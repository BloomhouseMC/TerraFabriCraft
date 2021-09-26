package malek.terrafabricraft.client.screen.button;

import com.mojang.blaze3d.systems.RenderSystem;
import malek.terrafabricraft.TerraFabriCraft;
import net.minecraft.client.gui.screen.ingame.InventoryScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.LiteralText;
import net.minecraft.util.Identifier;

import java.awt.*;

public class PlayerInventoryTabButton extends ButtonWidget {
    private static final Identifier TEXTURE = new Identifier(TerraFabriCraft.MODID, "textures/gui/icons.png");

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

    public PlayerInventoryTabButton(int guiLeft, int guiTop, int xIn, int yIn, int widthIn, int heightIn, int textureU, int textureV, int iconX, int iconY, int iconU, int iconV, PressAction onPressIn)
    {
        super(guiLeft + xIn, guiTop + yIn, widthIn, heightIn, LiteralText.EMPTY, onPressIn);
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
            boolean recipeBookVisible = screen.getRecipeBookWidget().isOpen();

            @Override
            public void run()
            {
                boolean newRecipeBookVisible = screen.getRecipeBookWidget().isOpen();
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
    public void renderButton(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks)
    {
        RenderSystem.setShaderTexture(0, TEXTURE);
        RenderSystem.disableDepthTest();

        tickCallback.run();

        drawTexture(matrixStack, x, y, 0, (float) textureU, (float) textureV, width, height, 256, 256);
        drawTexture(matrixStack, iconX, iconY, 16, 16, (float) iconU, (float) iconV, 32, 32, 256, 256);
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

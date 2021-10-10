package malek.terrafabricraft.common.knapping;

import com.mojang.blaze3d.systems.RenderSystem;
import io.github.cottonmc.cotton.gui.client.CottonClientScreen;
import io.github.cottonmc.cotton.gui.client.CottonInventoryScreen;
import malek.terrafabricraft.common.block.forge.ForgeGuiDescription;
import malek.terrafabricraft.common.item.ceramic.CeramicVesselScreenHandler;
import malek.terrafabricraft.common.util.TFCUtils;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.minecraft.text.Text;
import net.minecraft.util.math.Matrix4f;

public class KnappingScreen extends CottonInventoryScreen<KnappingScreenHandler> {
    public boolean mouseDown = false;

    public KnappingScreen(KnappingScreenHandler description, PlayerInventory player, Text title) {
        super(description, player.player, title);
        description.parent = this;

    }


    @Override
    public boolean isPauseScreen() {
        return false;
    }

    @Override
    protected void drawBackground(MatrixStack matrices, float delta, int mouseX, int mouseY) {

    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int mouseButton) {
        if (mouseButton == 0)
            mouseDown = true;
        return super.mouseClicked(mouseX, mouseY, mouseButton);
    }

    @Override
    public boolean mouseReleased(double mouseX, double mouseY, int mouseButton) {
        if (mouseButton == 0)
            mouseDown = false;
        return super.mouseReleased(mouseX, mouseY, mouseButton);
    }


}

package malek.terrafabricraft.common.knapping;

import io.github.cottonmc.cotton.gui.client.CottonInventoryScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;

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

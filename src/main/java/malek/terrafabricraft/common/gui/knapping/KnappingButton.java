package malek.terrafabricraft.common.gui.knapping;

import net.minecraft.client.util.math.MatrixStack;

public class KnappingButton {
    MatrixStack matrices;
    int index;
    int x;
    int y;
    int mouseX = -1;
    int mouseY = -1;
    public int id;

    public KnappingButton(int index, int x, int y) {
        this.index = index;
        this.x = x;
        this.y = y;
    }

    public boolean isEnabled() {
        return true;
    }
}

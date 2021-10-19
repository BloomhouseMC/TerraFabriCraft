package malek.terrafabricraft.common.knapping;

import com.mojang.blaze3d.systems.RenderSystem;
import malek.terrafabricraft.TerraFabriCraft;
import net.minecraft.client.render.*;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Matrix4f;

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

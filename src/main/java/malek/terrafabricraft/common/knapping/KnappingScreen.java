package malek.terrafabricraft.common.knapping;

import io.github.cottonmc.cotton.gui.client.CottonInventoryScreen;
import malek.terrafabricraft.common.block.logpile.LogPileGuiDescription;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.screen.slot.SlotActionType;
import net.minecraft.text.Text;
import org.jetbrains.annotations.Nullable;

public class KnappingScreen extends HandledScreen<KnappingScreenHandler> {

    public KnappingScreen(KnappingScreenHandler screenHandler, PlayerInventory playerInventory, Text text) {
        super(screenHandler, playerInventory, text);
    }

    @Override
    protected void drawBackground(MatrixStack matrices, float delta, int mouseX, int mouseY) {

    }
}

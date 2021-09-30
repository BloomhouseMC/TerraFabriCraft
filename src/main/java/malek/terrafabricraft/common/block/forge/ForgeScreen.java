package malek.terrafabricraft.common.block.forge;

import io.github.cottonmc.cotton.gui.client.CottonInventoryScreen;
import malek.terrafabricraft.common.block.logpile.LogPileGuiDescription;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;

public class ForgeScreen extends CottonInventoryScreen<ForgeGuiDescription> {
    public ForgeScreen(ForgeGuiDescription description, PlayerEntity player, Text title) {
        super(description, player, title);
    }
}

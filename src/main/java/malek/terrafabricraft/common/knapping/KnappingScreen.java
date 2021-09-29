package malek.terrafabricraft.common.knapping;

import io.github.cottonmc.cotton.gui.client.CottonInventoryScreen;
import malek.terrafabricraft.common.block.logpile.LogPileGuiDescription;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;

public class KnappingScreen extends CottonInventoryScreen<LogPileGuiDescription> {
    public KnappingScreen(LogPileGuiDescription description, PlayerEntity player, Text title) {
        super(description, player, title);
    }
}

package malek.terrafabricraft.common.block.logpile;

import io.github.cottonmc.cotton.gui.client.CottonInventoryScreen;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;

public class LogPileScreen extends CottonInventoryScreen<LogPileGuiDescription> {
    public LogPileScreen(LogPileGuiDescription description, PlayerEntity player, Text title) {
        super(description, player, title);
    }
}

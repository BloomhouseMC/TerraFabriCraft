package malek.terrafabricraft.common.block.logpile;

import io.github.cottonmc.cotton.gui.client.CottonInventoryScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;

public class LogPileScreen extends CottonInventoryScreen<LogPileGuiDescription> {
    public LogPileScreen(LogPileGuiDescription description, Player player, Component title) {
        super(description, player, title);
    }
}

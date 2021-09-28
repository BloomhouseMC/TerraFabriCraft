package malek.terrafabricraft.common.block.keg;

import io.github.cottonmc.cotton.gui.client.CottonInventoryScreen;
import malek.terrafabricraft.common.block.logpile.LogPileGuiDescription;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;

public class KegScreen extends CottonInventoryScreen<KegGuiDescription> {
    public KegScreen(KegGuiDescription description, Player player, Component title) {
        super(description, player, title);
    }
}

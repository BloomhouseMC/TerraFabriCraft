package malek.terrafabricraft.common.block.keg;

import io.github.cottonmc.cotton.gui.client.CottonInventoryScreen;
import malek.terrafabricraft.common.block.logpile.LogPileGuiDescription;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;

public class KegScreen extends CottonInventoryScreen<KegGuiDescription> {
    public KegScreen(KegGuiDescription description, PlayerEntity player, Text title) {
        super(description, player, title);
    }
}

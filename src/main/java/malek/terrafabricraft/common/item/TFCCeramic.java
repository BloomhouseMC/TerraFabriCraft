package malek.terrafabricraft.common.item;

import net.minecraft.item.Item;

public class TFCCeramic extends Item {
    public final Item firedVersion;
    public TFCCeramic(Settings settings, Item firedVersion) {
        super(settings);
        this.firedVersion = firedVersion;
    }

}

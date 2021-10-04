package malek.terrafabricraft.common.item;

import net.minecraft.item.Item;

public class TFCMetalItem extends Item implements MeltableItem {
    private int meltingPoint = 0;
    public TFCMetalItem(Settings settings, int meltingPoint) {
        super(settings);
        this.meltingPoint = meltingPoint;
    }

    @Override
    public int getMeltingPoint() {
        return meltingPoint;
    }
}

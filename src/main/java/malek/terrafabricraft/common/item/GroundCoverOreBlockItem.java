package malek.terrafabricraft.common.item;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;

public class GroundCoverOreBlockItem extends BlockItem implements MeltableItem {
    private int meltingPoint;
    public GroundCoverOreBlockItem(Block block, Settings settings, int meltingPoint) {
        super(block, settings);
        this.meltingPoint = meltingPoint;
    }

    @Override
    public int getMeltingPoint() {
        return meltingPoint;
    }
}

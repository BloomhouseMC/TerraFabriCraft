package malek.terrafabricraft.common.item;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;

public class GroundCoverOreBlockItem extends BlockItem implements MeltableItem {
    private int meltingPoint;

    public GroundCoverOreBlockItem(Block block, Properties settings, int meltingPoint) {
        super(block, settings);
        this.meltingPoint = meltingPoint;
    }

    @Override
    public int getMeltingPoint() {
        return meltingPoint;
    }
}

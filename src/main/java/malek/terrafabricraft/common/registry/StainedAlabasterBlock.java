package malek.terrafabricraft.common.registry;

import malek.terrafabricraft.common.block.TFCGravityBlock;
import malek.terrafabricraft.common.block.TFCStairs;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.WallBlock;

import static malek.terrafabricraft.common.registry.TFCObjects.*;

public class StainedAlabasterBlock {

    public BlockVariant brick;
    public BlockVariant polished;
    public TFCGravityBlock raw;

    public StainedAlabasterBlock(String id) {
        brick = new BlockVariant(id, "_alabaster_bricks");
        polished = new BlockVariant(id, "_polished_alabaster");
        raw = createRock("alabaster/stained/" + id + "_raw_alabaster", true); 
    }

    public class BlockVariant {
        public TFCGravityBlock block;
        public SlabBlock slab;
        public TFCStairs stairs;
        public WallBlock wall;

        public BlockVariant(String id, String special) {
            var fullId = "alabaster/stained/" + id + special;
            block = createRock(fullId, true);
            slab = createStoneSlab(fullId + "_slab");
            stairs = createStoneStairs(fullId + "_stairs", block);
            wall = createWall(fullId + "_wall");
        }
    }
}

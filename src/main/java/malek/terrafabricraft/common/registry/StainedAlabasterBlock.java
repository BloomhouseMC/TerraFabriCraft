package malek.terrafabricraft.common.registry;

import malek.terrafabricraft.TerraFabriCraft;
import malek.terrafabricraft.common.block.TFCGravityBlock;
import malek.terrafabricraft.common.block.TFCStairs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.WallBlock;

import static malek.terrafabricraft.common.registry.TFCObjects.*;

public class StainedAlabasterBlock {

    public BlockVariant brick;
    public BlockVariant polished;
    public TFCGravityBlock raw;
    public CreativeModeTab group = TerraFabriCraft.DECORATIONS_GROUP;


    public StainedAlabasterBlock(String id) {
        brick = new BlockVariant(id, "_alabaster_bricks");
        polished = new BlockVariant(id, "_polished_alabaster");
        raw = createRock("alabaster/stained/" + id + "_raw_alabaster", group);
    }

    public class BlockVariant {
        public TFCGravityBlock block;
        public SlabBlock slab;
        public TFCStairs stairs;
        public WallBlock wall;

        public BlockVariant(String id, String special) {
            var fullId = "alabaster/stained/" + id + special;
            block = createRock(fullId, group);
            slab = createStoneSlab(fullId + "_slab", group);
            stairs = createStoneStairs(fullId + "_stairs", block, group);
            wall = createWall(fullId + "_wall", group);
        }
    }
}

package com.bloomhousemc.terrafabricraft.common.registry.util;

import com.bloomhousemc.terrafabricraft.common.block.TfcGravityBlock;
import com.bloomhousemc.terrafabricraft.common.block.TfcStairs;
import com.bloomhousemc.terrafabricraft.common.registry.TfcBlocks;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.WallBlock;
import net.minecraft.item.ItemGroup;

import static com.bloomhousemc.terrafabricraft.common.registry.TfcItemGroups.DECORATIONS_GROUP;

public class StainedAlabasterBlock {

    public BlockVariant brick;
    public BlockVariant polished;
    public TfcGravityBlock raw;
    public ItemGroup group = DECORATIONS_GROUP;


    public StainedAlabasterBlock(String id) {
        brick = new BlockVariant(id, "_alabaster_bricks");
        polished = new BlockVariant(id, "_polished_alabaster");
        raw = TfcBlocks.createRock("alabaster/stained/" + id + "_raw_alabaster", group);
    }

    public class BlockVariant {
        public TfcGravityBlock block;
        public SlabBlock slab;
        public TfcStairs stairs;
        public WallBlock wall;

        public BlockVariant(String id, String special) {
            var fullId = "alabaster/stained/" + id + special;
            block = TfcBlocks.createRock(fullId, group);
            slab = TfcBlocks.createStoneSlab(fullId + "_slab", group);
            stairs = TfcBlocks.createStoneStairs(fullId + "_stairs", block, group);
            wall = TfcBlocks.createWall(fullId + "_wall", group);
        }
    }
}

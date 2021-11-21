package com.bloomhousemc.terrafabricraft.common.registry.util;

import com.bloomhousemc.terrafabricraft.common.block.TfcGravityBlock;
import com.bloomhousemc.terrafabricraft.common.block.TfcStairs;
import com.bloomhousemc.terrafabricraft.common.registry.TfcBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.WallBlock;
import net.minecraft.item.ItemGroup;

import static com.bloomhousemc.terrafabricraft.common.registry.TfcItemGroups.EARTH_GROUP;

public class SandstoneBlock {
    public TfcGravityBlock cutFullBlock;
    public SlabBlock cutSlab;
    public Block cutStairs;
    public Block cutWall;
    public TfcGravityBlock rawFullBlock;
    public SlabBlock rawSlab;
    public Block rawStairs;
    public Block rawWall;
    public TfcGravityBlock smoothFullBlock;
    public SlabBlock smoothSlab;
    public Block smoothStairs;
    public Block smoothWall;
    public static ItemGroup group = EARTH_GROUP;

    public SandstoneBlock(String variantId) {
        var cut = "cut_" + variantId;
        cutFullBlock = setCreateBlock(cut);
        cutSlab = setCreateSlab(cut);
        cutStairs = setCreateStairs(cut, cutFullBlock);
        cutWall = setCreateWall(cut);
        var raw = "raw_" + variantId;
        rawFullBlock = setCreateBlock(raw);
        rawSlab = setCreateSlab(raw);
        rawStairs = setCreateStairs(raw, rawFullBlock);
        rawWall = setCreateWall(raw);
        var smooth = "smooth_" + variantId;
        smoothFullBlock = setCreateBlock(smooth);
        smoothSlab = setCreateSlab(smooth);
        smoothStairs = setCreateStairs(smooth, smoothFullBlock);
        smoothWall = setCreateWall(smooth);
    }

    public static TfcGravityBlock setCreateBlock(String variantId) {
        return TfcBlocks.createRock(variantId, group);
    }

    public static SlabBlock setCreateSlab(String variantId) {
        return TfcBlocks.createStoneSlab(variantId + "_slab", group);
    }

    public static TfcStairs setCreateStairs(String variantId, Block fullBlock) {
        return TfcBlocks.createStoneStairs(variantId + "_stairs", fullBlock, group);
    }

    public static WallBlock setCreateWall(String variantId) {
        return TfcBlocks.createWall(variantId + "_wall", group);
    }
}
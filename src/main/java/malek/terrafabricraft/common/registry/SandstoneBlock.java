package malek.terrafabricraft.common.registry;

import malek.terrafabricraft.TerraFabriCraft;
import malek.terrafabricraft.common.block.*;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.WallBlock;

import static malek.terrafabricraft.common.registry.TFCObjects.*;

public class SandstoneBlock {
    public TFCGravityBlock cutFullBlock;
    public SlabBlock cutSlab;
    public Block cutStairs;
    public Block cutWall;
    public TFCGravityBlock rawFullBlock;
    public SlabBlock rawSlab;
    public Block rawStairs;
    public Block rawWall;
    public TFCGravityBlock smoothFullBlock;
    public SlabBlock smoothSlab;
    public Block smoothStairs;
    public Block smoothWall;
    public static CreativeModeTab group = TerraFabriCraft.EARTH_GROUP;

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

    public static TFCGravityBlock setCreateBlock(String variantId) {
        return createRock(variantId, group);
    }

    public static SlabBlock setCreateSlab(String variantId) {
        return createStoneSlab(variantId + "_slab", group);
    }

    public static TFCStairs setCreateStairs(String variantId, Block fullBlock) {
        return createStoneStairs(variantId + "_stairs", fullBlock, group);
    }

    public static WallBlock setCreateWall(String variantId) {
        return createWall(variantId + "_wall", group);
    }
}
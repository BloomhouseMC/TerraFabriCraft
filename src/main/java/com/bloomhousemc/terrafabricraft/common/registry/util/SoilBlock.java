package com.bloomhousemc.terrafabricraft.common.registry.util;

import com.bloomhousemc.terrafabricraft.common.block.TfcGrassBlock;
import net.minecraft.block.Block;
import net.minecraft.sound.BlockSoundGroup;

import static com.bloomhousemc.terrafabricraft.common.registry.TfcBlocks.createGrass;

public class SoilBlock {
    public Block loam;
    public Block sandy_loam;
    public Block silt;
    public Block silty_loam;

    public SoilBlock(String id, BlockSoundGroup sound) {
        loam = setCreateGrassBlock(id, "loam", sound);
        sandy_loam = setCreateGrassBlock(id, "sandy_loam", sound);
        silt = setCreateGrassBlock(id, "silt", sound);
        silty_loam = setCreateGrassBlock(id, "silty_loam", sound);
    }

    private static TfcGrassBlock setCreateGrassBlock(String variantId, String special, BlockSoundGroup sound) {
        return createGrass(variantId + "/" + special, sound);
    }
}


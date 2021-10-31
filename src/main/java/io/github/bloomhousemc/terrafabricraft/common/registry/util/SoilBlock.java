package io.github.bloomhousemc.terrafabricraft.common.registry.util;

import io.github.bloomhousemc.terrafabricraft.common.block.TFCGravityBlock;
import io.github.bloomhousemc.terrafabricraft.common.block.TFCGrassBlock;
import net.minecraft.block.Block;
import net.minecraft.sound.BlockSoundGroup;

import static io.github.bloomhousemc.terrafabricraft.common.registry.TFCObjects.createGrass;
import static io.github.bloomhousemc.terrafabricraft.common.registry.TFCObjects.createSand;

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

    private static TFCGravityBlock setCreateBlock(String variantId, String special) {
        return createSand(variantId + "/" + special, true);
    }

    private static TFCGrassBlock setCreateGrassBlock(String variantId, String special, BlockSoundGroup sound) {
        return createGrass(variantId + "/" + special, sound);
    }
}


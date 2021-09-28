package malek.terrafabricraft.common.registry;

import malek.terrafabricraft.common.block.TFCGravityBlock;
import malek.terrafabricraft.common.block.TFCGravityGrassBlock;
import net.minecraft.world.level.block.Block;

import static malek.terrafabricraft.common.registry.TFCObjects.createSand;
import static malek.terrafabricraft.common.registry.TFCObjects.createGrass;

public class SoilBlock {
    public Block loam;
    public Block sandy_loam;
    public Block silt;
    public Block silty_loam;

    public SoilBlock(String id) {
        loam = setCreateGrassBlock(id, "loam");
        sandy_loam = setCreateGrassBlock(id, "sandy_loam");
        silt = setCreateGrassBlock(id, "silt");
        silty_loam = setCreateGrassBlock(id, "silty_loam");
    }

    private static TFCGravityBlock setCreateBlock(String variantId, String special) {
        return createSand(variantId + "/" + special, true);
    }

    private static TFCGravityGrassBlock setCreateGrassBlock(String variantId, String special) {
        return createGrass(variantId + "/" + special, true);
    }
}


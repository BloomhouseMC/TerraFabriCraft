package malek.terrafabricraft.common.block;

import net.minecraft.block.Block;

import static malek.terrafabricraft.common.registry.TFCObjects.createSand;

public class SoilBlock {
    public Block loam;
    public Block sandy_loam;
    public Block silt;
    public Block silty_loam;

    public SoilBlock(String id) {
        loam = setCreateBlock(id, "loam");
        sandy_loam = setCreateBlock(id, "sandy_loam");
        silt = setCreateBlock(id, "silt");
        silty_loam = setCreateBlock(id, "silty_loam");
    }

    private static TFCGravityBlock setCreateBlock(String variantId, String special) {
        return createSand(variantId + "/" + special, true);
    }
}


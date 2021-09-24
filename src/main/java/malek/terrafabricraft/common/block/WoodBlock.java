package malek.terrafabricraft.common.block;

import net.minecraft.block.Block;

import static malek.terrafabricraft.common.registry.TFCObjects.createLog;

public class WoodBlock {
    public Block leaves;
    public Block log;
    public Block planks;
    public Block sapling;
    public Block stripped_log;
    public Block twig;
    public Block vertical_support;

    public WoodBlock(String variantId) {
        //TODO Register with their own method.
        leaves = setCreateBlock(variantId, "leaves");
        //TODO Register with their own method.
        log = setCreateBlock(variantId, "log");

        planks = setCreateBlock(variantId, "planks");
        sapling = setCreateBlock(variantId, "sapling");
        stripped_log = setCreateBlock(variantId, "stripped_log");
        //TODO Register with their own method.
        twig = setCreateBlock(variantId, "twig");
        vertical_support = setCreateBlock(variantId, "vertical_support");
    }


    private static Block setCreateBlock(String variantId, String special) {
        return createLog("wood/" + special + "/" + variantId, true);
    }
}

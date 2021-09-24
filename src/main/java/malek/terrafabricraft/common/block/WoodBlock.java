package malek.terrafabricraft.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.sapling.SaplingGenerator;

import static malek.terrafabricraft.common.registry.TFCObjects.*;

public class WoodBlock {
    public TFCLeaves leaves;
    public TFCLog log;
    public Block planks;
    public TFCSapling sapling;
    public TFCLog stripped_log;
    public TFCTwig twig;
    public TFCSupport vertical_support;

    public WoodBlock(String variantId, SaplingGenerator saplingGenerator) {
        leaves = setCreateLeaves(variantId);
        log = setCreateLog(variantId, "log");
        planks = setCreateBlock(variantId, "planks");
        sapling = setCreateSapling(variantId, saplingGenerator);
        stripped_log = setCreateLog(variantId, "stripped_log");
        twig = setCreateTwig(variantId);
        vertical_support = setCreateSupport(variantId);
    }

    //TODO: Refactor unnecessary methods.
    private static Block setCreateBlock(String variantId, String special) {
        return createLog("wood/" + special + "/" + variantId, true);
    }

    private static TFCTwig setCreateTwig(String variantId) {
        return createTwig("wood/twig/" + variantId, true);
    }

    private static TFCLog setCreateLog(String variantId, String special) {
        return createLog("wood/" + special + "/" + variantId, true);
    }

    private static TFCSupport setCreateSupport(String variantId) {
        return createSupport("wood/support/" + variantId, true);
    }

    private static TFCLeaves setCreateLeaves(String variantId) {
        return createLeaves("wood/leaves/" + variantId, true);
    }

    private static TFCSapling setCreateSapling(String variantId, SaplingGenerator generator) {
        return createSapling("wood/sapling/" + variantId, true, generator);
    }
}

package malek.terrafabricraft.common.registry;

import malek.terrafabricraft.common.block.*;
import malek.terrafabricraft.common.block.keg.Keg;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.block.sapling.SaplingGenerator;

import static malek.terrafabricraft.common.registry.TFCObjects.*;

public class WoodBlock {
    public final TFCFallenLeavesBlock fallen_leaves;
    public final Keg keg;
    public final TFCLeaves leaves;
    public final TFCLog log;
    public final Block planks;
    public final TFCSapling sapling;
    public final TFCLog stripped_log;
    public final TFCTwig twig;
    public final TFCSupport vertical_support;

    public WoodBlock(String variantId, SaplingGenerator saplingGenerator, MapColor color) {
        fallen_leaves = createFallenLeaves("wood/fallen_leaves/" + variantId);
        keg = setCreateKeg(variantId);
        leaves = setCreateLeaves(variantId);
        log = setCreateLog("wood/stripped_log/", variantId, color);
        planks = setCreateFlammableBlock("wood/planks/", variantId, color);
        sapling = setCreateSapling(variantId, saplingGenerator);
        stripped_log = setCreateLog("wood/log/", variantId, color);
        twig = setCreateTwig(variantId);
        vertical_support = setCreateSupport(variantId);
    }

    //TODO: Refactor unnecessary methods.

    private static TFCLeaves setCreateLeaves(String variantId) {
        return createLeaves("wood/leaves/" + variantId, true);
    }

    private static TFCTwig setCreateTwig(String variantId) {
        return createTwig("wood/twig/" + variantId, true);
    }

    private static TFCLog setCreateLog(String special, String variantId, MapColor color) {
        return createLog(special +  variantId, color, true);
    }

    private static Block setCreateFlammableBlock(String special, String variantId, MapColor color) {
        return createFlammableBlock(special + variantId, color, true);
    }

    private static TFCSapling setCreateSapling(String variantId, SaplingGenerator generator) {
        return createSapling("wood/sapling/" + variantId, true, generator);
    }

    private static TFCSupport setCreateSupport(String variantId) {
        return createSupport("wood/support/" + variantId, true);
    }
    private static Keg setCreateKeg(String variantId) {
        return createKeg("wood/keg/" + variantId, true);
    }
}

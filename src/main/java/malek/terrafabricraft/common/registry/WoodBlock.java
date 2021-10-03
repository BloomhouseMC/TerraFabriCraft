package malek.terrafabricraft.common.registry;

import malek.terrafabricraft.common.block.*;
import malek.terrafabricraft.common.block.keg.Keg;
import malek.terrafabricraft.common.block.toolrack.ToolRackBlock;
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
    public ToolRackBlock rack;

    public WoodBlock(String variantId, SaplingGenerator saplingGenerator, MapColor color) {
        fallen_leaves = createFallenLeaves("wood/fallen_leaves/" + variantId);
        keg = createKeg("wood/keg/" + variantId, true);
        leaves = createLeaves("wood/leaves/" + variantId, true);
        log = setCreateLog("wood/log/", variantId, color);
        planks = setCreateFlammableBlock("wood/planks/", variantId, color);
        sapling = createSapling("wood/sapling/" + variantId, true, saplingGenerator);
        stripped_log = setCreateLog("wood/stripped_log/", variantId, color);
        twig = setCreateTwig(variantId);
        vertical_support = setCreateSupport(variantId);
        rack = createRack("wood/rack/" + variantId, true);
    }

    //TODO: Refactor unnecessary methods.
    private static TFCTwig setCreateTwig(String variantId) {
        return createTwig("wood/twig/" + variantId, true);
    }

    private static TFCLog setCreateLog(String special, String variantId, MapColor color) {
        return createLog(special + variantId, color, true);
    }

    private static Block setCreateFlammableBlock(String special, String variantId, MapColor color) {
        return createFlammableBlock(special + variantId, color, true);
    }

    private static TFCSupport setCreateSupport(String variantId) {
        return createSupport("wood/support/" + variantId + "_vertical", true);
    }
}

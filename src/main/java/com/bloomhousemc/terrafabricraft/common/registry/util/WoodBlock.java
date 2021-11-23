package com.bloomhousemc.terrafabricraft.common.registry.util;

import com.bloomhousemc.terrafabricraft.common.block.*;
import com.bloomhousemc.terrafabricraft.common.block.keg.Keg;
import com.bloomhousemc.terrafabricraft.common.block.toolrack.ToolRackBlock;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.block.sapling.SaplingGenerator;

import static com.bloomhousemc.terrafabricraft.common.registry.TfcBlocks.*;

public class WoodBlock {
    public final TfcFallenLeavesBlock FALLEN_LEAVES;
    public final Keg KEG;
    public final TfcLeaves LEAVES;
    public final TfcLog LOG;
    public final Block PLANKS;
    public final TfcSapling SAPLING;
    public final TfcLog STRIPPED_LOG;
    public final TfcTwig TWIG;
    public final TfcSupportBlock VERTICAL_SUPPORT;
    public final TfcSupportBlock HORISONTAL_SUPPORT;
    public ToolRackBlock RACK;

    public WoodBlock(String variantId, SaplingGenerator saplingGenerator, MapColor color) {
        FALLEN_LEAVES = createFallenLeaves("wood/fallen_leaves/" + variantId);
        KEG = createKeg("wood/keg/" + variantId);
        LEAVES = createLeaves("wood/leaves/" + variantId);
        LOG = setCreateLog("wood/log/", variantId, color);
        PLANKS = setCreateFlammableBlock("wood/planks/", variantId, color);
        SAPLING = createSapling("wood/sapling/" + variantId, saplingGenerator);
        STRIPPED_LOG = setCreateLog("wood/stripped_log/", variantId, color);
        TWIG = createTwig("wood/twig/" + variantId);
        VERTICAL_SUPPORT = createSupport("wood/vertical_support/" + variantId, true);
        HORISONTAL_SUPPORT = createSupport("wood/horizontal_support/" + variantId, false);
        RACK = createRack("wood/rack/" + variantId);
    }


    private static TfcLog setCreateLog(String special, String variantId, MapColor color) {
        return createLog(special + variantId, color);
    }

    //TODO: Refactor unnecessary methods.
    private static Block setCreateFlammableBlock(String special, String variantId, MapColor color) {
        return createFlammable(special + variantId, color);
    }
}

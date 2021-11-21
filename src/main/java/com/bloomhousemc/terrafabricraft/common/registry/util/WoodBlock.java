package com.bloomhousemc.terrafabricraft.common.registry.util;

import com.bloomhousemc.terrafabricraft.common.block.*;
import com.bloomhousemc.terrafabricraft.common.block.keg.Keg;
import com.bloomhousemc.terrafabricraft.common.block.toolrack.ToolRackBlock;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.block.sapling.SaplingGenerator;

import static com.bloomhousemc.terrafabricraft.common.registry.TfcBlocks.*;

public class WoodBlock {
    public final TfcFallenLeavesBlock fallen_leaves;
    public final Keg keg;
    public final TfcLeaves leaves;
    public final TfcLog log;
    public final Block planks;
    public final TfcSapling sapling;
    public final TfcLog stripped_log;
    public final TfcTwig twig;
    public final TfcSupport vertical_support;
    public final TfcSupport horizontal_support;
    public ToolRackBlock rack;

    public WoodBlock(String variantId, SaplingGenerator saplingGenerator, MapColor color) {
        fallen_leaves = createFallenLeaves("wood/fallen_leaves/" + variantId);
        keg = createKeg("wood/keg/" + variantId);
        leaves = createLeaves("wood/leaves/" + variantId);
        log = setCreateLog("wood/log/", variantId, color);
        planks = setCreateFlammableBlock("wood/planks/", variantId, color);
        sapling = createSapling("wood/sapling/" + variantId, saplingGenerator);
        stripped_log = setCreateLog("wood/stripped_log/", variantId, color);
        twig = createTwig("wood/twig/" + variantId);
        vertical_support = createSupport("wood/vertical_support/" + variantId, true);
        horizontal_support = createSupport("wood/horizontal_support/" + variantId, false);
        rack = createRack("wood/rack/" + variantId);
    }


    private static TfcLog setCreateLog(String special, String variantId, MapColor color) {

        return createLog(special + variantId, color);
    }

    //TODO: Refactor unnecessary methods.
    private static Block setCreateFlammableBlock(String special, String variantId, MapColor color) {
        return createFlammable(special + variantId, color);
    }
}

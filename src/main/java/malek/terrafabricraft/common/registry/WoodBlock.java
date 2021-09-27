package malek.terrafabricraft.common.registry;

import malek.terrafabricraft.common.block.*;
import malek.terrafabricraft.common.block.keg.TFCKeg;
import malek.terrafabricraft.common.block.keg.TFCKegEntity;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.block.sapling.SaplingGenerator;

import static malek.terrafabricraft.common.registry.TFCObjects.*;

public class WoodBlock {
    private static TFCKegEntity keg_entity;
    private static TFCKeg keg;
    public TFCLeaves leaves;
    public TFCLog log;
    public Block planks;
    public TFCSapling sapling;
    public TFCLog stripped_log;
    public TFCTwig twig;
    public TFCSupport vertical_support;
    //public TFCKeg keg;
    //public TFCKegEntity keg_entity;

    public WoodBlock(String variantId, SaplingGenerator saplingGenerator, MapColor color) {
        leaves = setCreateLeaves(variantId);
        log = setCreateLog(variantId);
        planks = setCreateBlock(variantId, "planks");
        sapling = setCreateSapling(variantId, saplingGenerator);
        stripped_log = setCreateStrippedLog(variantId, color);
        twig = setCreateTwig(variantId);
        vertical_support = setCreateSupport(variantId);
        //keg = setCreateKeg(variantId);
        keg_entity = setCreateKegEntity(variantId);
    }

    //TODO: Refactor unnecessary methods.
    private static Block setCreateBlock(String variantId, String special) {
        return createLog("wood/" + special + "/" + variantId, true);
    }

    private static TFCLeaves setCreateLeaves(String variantId) {
        return createLeaves("wood/leaves/" + variantId, true);
    }

    private static TFCTwig setCreateTwig(String variantId) {
        return createTwig("wood/twig/" + variantId, true);
    }

    private static TFCLog setCreateLog(String variantId) {
        return createLog("wood/log/" + variantId, true);
    }

    private static TFCSapling setCreateSapling(String variantId, SaplingGenerator generator) {
        return createSapling("wood/sapling/" + variantId, true, generator);
    }

    private static TFCLog setCreateStrippedLog(String variantId, MapColor color) {
        return createStrippedLog("wood/stripped_log/" + variantId, color, true);
    }

    private static TFCSupport setCreateSupport(String variantId) {
        return createSupport("wood/support/" + variantId, true);
    }
    /*
    private static TFCKeg setCreateKeg(String variantId) {
        return createKeg("wood/keg/" + variantId, true);
    }

     */
    private static TFCKegEntity setCreateKegEntity(String variantId) {
        keg = createKeg("wood/keg/" + variantId, true);
        //return createKegEntity("wood/keg/entity/" + variantId);
        keg_entity = createKegEntity("wood/keg/entity", keg);
        return keg_entity;
    }
}

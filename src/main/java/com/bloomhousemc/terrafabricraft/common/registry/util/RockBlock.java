package com.bloomhousemc.terrafabricraft.common.registry.util;

import com.bloomhousemc.terrafabricraft.common.block.TfcLooseRock;
import com.bloomhousemc.terrafabricraft.common.block.TfcOreBlock;
import com.bloomhousemc.terrafabricraft.common.block.TfcStairs;
import com.bloomhousemc.terrafabricraft.common.block.TfcStoneButtonBlock;
import com.bloomhousemc.terrafabricraft.common.registry.TfcBlocks;
import net.minecraft.block.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static com.bloomhousemc.terrafabricraft.common.registry.TfcItemGroups.ROCK_GROUP;

public class RockBlock {


    public static HashMap<BlockState, RockBlock> stateToRock = new HashMap<>();
    public List<Block> oreStones = new ArrayList<>();
    // public Block groundCover;
    //TODO : Add facing and power varation for the stone button
    public final TfcStoneButtonBlock BUTTON;
    public final BlockVariant BRICK;
    public final Block CHISELED;
    public final BlockVariant COBBLE;
    public final BlockVariant CRACKED_BRICK;
    public final Block GRAVEL;
    public final Block HARDENED;
    public final TfcLooseRock LOOSE;
    public final BlockVariant MOOSY_BRICK;
    public final BlockVariant MOOSY_COBBLE;
    public final Block PRESSURE_PLATE;
    public final BlockVariant RAW;
    public final BlockVariant SMOOTH;
    public final Block SPIKE;

    public final OreStoneBlock BISMUTHINITE;
    public final OreStoneBlock CASSITERITE;
    public final OreStoneBlock GARNIERITE;
    public final OreStoneBlock HEMATITE;
    public final OreStoneBlock LIMONITE;
    public final OreStoneBlock MAGNETITE;
    public final OreStoneBlock MALACHITE;
    public final OreStoneBlock NATIVE_COPPER;
    public final OreStoneBlock NATIVE_GOLD;
    public final OreStoneBlock NATIVE_SILVER;
    public final OreStoneBlock sphalerite;
    public final OreStoneBlock TETRAHEDRITE;

    public final Block AMETHYST;
    public final Block BITUMINOUS_COAL;
    public final Block BORAX;
    public final Block CINNABAR;
    public final Block CRYOLITE;
    public final Block DIAMOND;
    public final Block EMERALD;
    public final Block GRAPHITE;
    public final Block GYPSUM;
    public final Block HALITE;
    public final Block KAOLINITE;
    public final Block LAPIS_LAZULI;
    public final Block LIGNITE;
    public final Block OPAL;
    public final Block PYRITE;
    public final Block RUBY;
    public final Block SALTPETER;
    public final Block SAPPHIRE;
    public final Block SULFUR;
    public final Block SYLVITE;
    public final Block TOPAZ;

    public RockBlock(String name) {

        var id = "rock/";
        BUTTON = TfcBlocks.createStoneButton("rock/button/" + name);
        BRICK = new BlockVariant(name, "bricks");
        CHISELED = setCreateBlock(name, id, "chiseled");
        COBBLE = new BlockVariant(name, "cobble");
        CRACKED_BRICK = new BlockVariant(name, "cracked_bricks");
        GRAVEL = setCreateBlock(name, id, "gravel");
        HARDENED = setCreateBlock(name, id, "hardened");
        LOOSE = TfcBlocks.createLooseRock("rock/loose/" + name);
        MOOSY_BRICK = new BlockVariant(name, "mossy_bricks");
        MOOSY_COBBLE = new BlockVariant(name, "mossy_cobble");
        PRESSURE_PLATE = TfcBlocks.createPressurePlate("rock/pressure_plate/" + name, ROCK_GROUP);
        RAW = new BlockVariant(name, "raw");
        SMOOTH = new BlockVariant(name, "smooth");
        SPIKE = setCreateBlock(name, id, "spike");

        BISMUTHINITE = new OreStoneBlock(name, "bismuthinite");
        CASSITERITE = new OreStoneBlock(name, "cassiterite");
        GARNIERITE = new OreStoneBlock(name, "garnierite");
        HEMATITE = new OreStoneBlock(name, "hematite");
        LIMONITE = new OreStoneBlock(name, "limonite");
        MAGNETITE = new OreStoneBlock(name, "magnetite");
        MALACHITE = new OreStoneBlock(name, "malachite");
        NATIVE_COPPER = new OreStoneBlock(name, "native_copper");
        NATIVE_GOLD = new OreStoneBlock(name, "native_gold");
        NATIVE_SILVER = new OreStoneBlock(name, "native_silver");
        sphalerite = new OreStoneBlock(name, "sphalerite");
        TETRAHEDRITE = new OreStoneBlock(name, "tetrahedrite");
        id = "ore/";
        AMETHYST = setCreateBlock(name, id, "amethyst");
        BITUMINOUS_COAL = setCreateBlock(name, id, "bituminous_coal");
        BORAX = setCreateBlock(name, id, "borax");
        CINNABAR = setCreateBlock(name, id, "cinnabar");
        CRYOLITE = setCreateBlock(name, id, "cryolite");
        DIAMOND = setCreateBlock(name, id, "diamond");
        EMERALD = setCreateBlock(name, id, "emerald");
        GRAPHITE = setCreateBlock(name, id, "graphite");
        GYPSUM = setCreateBlock(name, id, "gypsum");
        HALITE = setCreateBlock(name, id, "halite");
        KAOLINITE = setCreateBlock(name, id, "kaolinite");
        LAPIS_LAZULI = setCreateBlock(name, id, "lapis_lazuli");
        LIGNITE = setCreateBlock(name, id, "lignite");
        OPAL = setCreateBlock(name, id, "opal");
        PYRITE = setCreateBlock(name, id, "pyrite");
        RUBY = setCreateBlock(name, id, "ruby");
        SALTPETER = setCreateBlock(name, id, "saltpeter");
        SAPPHIRE = setCreateBlock(name, id, "sapphire");
        SULFUR = setCreateBlock(name, id, "sulfur");
        SYLVITE = setCreateBlock(name, id, "sylvite");
        TOPAZ = setCreateBlock(name, id, "topaz");
        stateToRock.put(RAW.BLOCK.getDefaultState(), this);

        add(AMETHYST, BITUMINOUS_COAL, BORAX, CINNABAR, CRYOLITE, DIAMOND, EMERALD, GRAPHITE, GYPSUM, HALITE, KAOLINITE, LAPIS_LAZULI, LIGNITE, OPAL, PYRITE, RUBY, SALTPETER, SAPPHIRE, SULFUR, SYLVITE, TOPAZ);
        add(BISMUTHINITE, CASSITERITE, GARNIERITE, HEMATITE, LIMONITE, MAGNETITE, MALACHITE, NATIVE_COPPER, NATIVE_GOLD, NATIVE_SILVER, sphalerite, TETRAHEDRITE);
//        TfcFeatures.registerOre(name, raw.block.getDefaultState());
    }
    public void add(OreStoneBlock ... oreStoneBlocks) {
        for(OreStoneBlock oreStoneBlock : oreStoneBlocks) {
            oreStones.add(oreStoneBlock.POOR);
            oreStones.add(oreStoneBlock.NORMAL);
            oreStones.add(oreStoneBlock.RICH);
        }
    }
    public void add(Block ... blocks) {
        oreStones.addAll(Arrays.asList(blocks));
    }

    private static Block setCreateBlock(String name, String id, String special) {
        return TfcBlocks.createRock(id + special + "/" + name, ROCK_GROUP);
    }

    public static class OreStoneBlock {
        public final TfcOreBlock POOR;
        public final TfcOreBlock NORMAL;
        public final TfcOreBlock RICH;

        public OreStoneBlock(String rockType, String oreType) {
            POOR = TfcBlocks.createOre(rockType, "ore/poor_" + oreType, "");
            NORMAL = TfcBlocks.createOre(rockType, "ore/normal_" + oreType, "");
            RICH = TfcBlocks.createOre(rockType, "ore/rich_" + oreType, "");
        }
    }

    public static class BlockVariant {
        public final Block BLOCK;
        public final SlabBlock SLAB;
        public final TfcStairs STAIRS;
        public final WallBlock WALL;

        public BlockVariant(String name, String special) {
            var group = ROCK_GROUP;
            BLOCK = setCreateBlock(name, "rock/", special);
            String variant = "rock/" + special + "/" + name;
            SLAB = TfcBlocks.createStoneSlab(variant + "_slab", group);
            STAIRS = TfcBlocks.createStoneStairs(variant + "_stairs", BLOCK, group);
            WALL = TfcBlocks.createWall(variant + "_wall", group);
        }
    }
}


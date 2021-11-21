package com.bloomhousemc.terrafabricraft.common.registry.util;

import com.bloomhousemc.terrafabricraft.common.block.TfcLooseRock;
import com.bloomhousemc.terrafabricraft.common.block.TfcOreBlock;
import com.bloomhousemc.terrafabricraft.common.block.TfcStairs;
import com.bloomhousemc.terrafabricraft.common.block.TfcStoneButtonBlock;
import com.bloomhousemc.terrafabricraft.common.registry.TfcBlocks;
import com.bloomhousemc.terrafabricraft.common.registry.TfcFeatures;
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
    public TfcStoneButtonBlock button;
    public Block anvil;
    public BlockVariant brick;
    public Block chiseled;
    public BlockVariant cobble;
    public BlockVariant crackedBrick;
    public Block gravel;
    public Block hardened;
    public TfcLooseRock loose;
    public BlockVariant mossyBrick;
    public BlockVariant mossyCobble;
    public Block pressurePlate;
    public BlockVariant raw;
    public BlockVariant smooth;
    public Block spike;

    public SlabBlock slab;

    public OreStoneBlock bismuthinite;
    public OreStoneBlock cassiterite;
    public OreStoneBlock garnierite;
    public OreStoneBlock hematite;
    public OreStoneBlock limonite;
    public OreStoneBlock magnetite;
    public OreStoneBlock malachite;
    public OreStoneBlock nativeCopper;
    public OreStoneBlock nativeGold;
    public OreStoneBlock nativeSilver;
    public OreStoneBlock sphalerite;
    public OreStoneBlock tetrahedrite;

    public Block amethyst;
    public Block bituminousCoal;
    public Block borax;
    public Block cinnabar;
    public Block cryolite;
    public Block diamond;
    public Block emerald;
    public Block graphite;
    public Block gypsum;
    public Block halite;
    public Block kaolinite;
    public Block lapisLazuil;
    public Block lignite;
    public Block opal;
    public Block pyrite;
    public Block ruby;
    public Block saltpeter;
    public Block sapphire;
    public Block sulfur;
    public Block sylvite;
    public Block topaz;

    public RockBlock(String name) {

        var id = "rock/";
        button = TfcBlocks.createStoneButton(id + "button/" + name);
        brick = new BlockVariant(name, "bricks");
        chiseled = setCreateBlock(name, id, "chiseled");
        cobble = new BlockVariant(name, "cobble");
        crackedBrick = new BlockVariant(name, "cracked_bricks");
        gravel = setCreateBlock(name, id, "gravel");
        hardened = setCreateBlock(name, id, "hardened");
        loose = setCreateTFCLooseRock(name, id, "loose");
        mossyBrick = new BlockVariant(name, "mossy_bricks");
        mossyCobble = new BlockVariant(name, "mossy_cobble");
        pressurePlate = setCreateBlock(name, id, "pressure_plate");
        raw = new BlockVariant(name, "raw");
        smooth = new BlockVariant(name, "smooth");
        spike = setCreateBlock(name, id, "spike");

        bismuthinite = new OreStoneBlock(name, "bismuthinite");
        cassiterite = new OreStoneBlock(name, "cassiterite");
        garnierite = new OreStoneBlock(name, "garnierite");
        hematite = new OreStoneBlock(name, "hematite");
        limonite = new OreStoneBlock(name, "limonite");
        magnetite = new OreStoneBlock(name, "magnetite");
        malachite = new OreStoneBlock(name, "malachite");
        nativeCopper = new OreStoneBlock(name, "native_copper");
        nativeGold = new OreStoneBlock(name, "native_gold");
        nativeSilver = new OreStoneBlock(name, "native_silver");
        sphalerite = new OreStoneBlock(name, "sphalerite");
        tetrahedrite = new OreStoneBlock(name, "tetrahedrite");
        id = "ore/";
        amethyst = setCreateBlock(name, id, "amethyst");
        bituminousCoal = setCreateBlock(name, id, "bituminous_coal");
        borax = setCreateBlock(name, id, "borax");
        cinnabar = setCreateBlock(name, id, "cinnabar");
        cryolite = setCreateBlock(name, id, "cryolite");
        diamond = setCreateBlock(name, id, "diamond");
        emerald = setCreateBlock(name, id, "emerald");
        graphite = setCreateBlock(name, id, "graphite");
        gypsum = setCreateBlock(name, id, "gypsum");
        halite = setCreateBlock(name, id, "halite");
        kaolinite = setCreateBlock(name, id, "kaolinite");
        lapisLazuil = setCreateBlock(name, id, "lapis_lazuli");
        lignite = setCreateBlock(name, id, "lignite");
        opal = setCreateBlock(name, id, "opal");
        pyrite = setCreateBlock(name, id, "pyrite");
        ruby = setCreateBlock(name, id, "ruby");
        saltpeter = setCreateBlock(name, id, "saltpeter");
        sapphire = setCreateBlock(name, id, "sapphire");
        sulfur = setCreateBlock(name, id, "sulfur");
        sylvite = setCreateBlock(name, id, "sylvite");
        topaz = setCreateBlock(name, id, "topaz");
        stateToRock.put(raw.block.getDefaultState(), this);

        add(amethyst, bituminousCoal, borax, cinnabar, cryolite, diamond, emerald, graphite, gypsum, halite, kaolinite, lapisLazuil, lignite, opal, pyrite, ruby, saltpeter, sapphire, sulfur, sylvite, topaz);
        add(bismuthinite, cassiterite, garnierite, hematite, limonite, magnetite, malachite, nativeCopper, nativeGold, nativeSilver, sphalerite, tetrahedrite);
//        TfcFeatures.registerOre(name, raw.block.getDefaultState());
    }
    public void add(OreStoneBlock ... oreStoneBlocks) {
        for(OreStoneBlock oreStoneBlock : oreStoneBlocks) {
            oreStones.add(oreStoneBlock.poor);
            oreStones.add(oreStoneBlock.normal);
            oreStones.add(oreStoneBlock.rich);
        }
    }
    public void add(Block ... blocks) {
        oreStones.addAll(Arrays.asList(blocks));
    }

    private static TfcLooseRock setCreateTFCLooseRock(String name, String id, String special) {
        TfcLooseRock rock = TfcBlocks.createLooseRock(id + special + "/" + name);
        return rock;
    }

    private static Block setCreateBlock(String name, String id, String special) {
        return TfcBlocks.createRock(id + special + "/" + name, ROCK_GROUP);
    }

    public class OreStoneBlock {
        public TfcOreBlock poor;
        public TfcOreBlock normal;
        public TfcOreBlock rich;

        public OreStoneBlock(String rockType, String oreType) {
            poor = TfcBlocks.createOre(rockType, "ore/poor_" + oreType, "");
            normal = TfcBlocks.createOre(rockType, "ore/normal_" + oreType, "");
            rich = TfcBlocks.createOre(rockType, "ore/rich_" + oreType, "");
        }
    }

    public class BlockVariant {
        public Block block;
        public SlabBlock slab;
        public TfcStairs stairs;
        public WallBlock wall;

        public BlockVariant(String name, String special) {
            var group = ROCK_GROUP;
            block = setCreateBlock(name, "rock/", special);
            String variant = "rock/" + special + "/" + name;
            slab = TfcBlocks.createStoneSlab(variant + "_slab", group);
            stairs = TfcBlocks.createStoneStairs(variant + "_stairs", block, group);
            wall = TfcBlocks.createWall(variant + "_wall", group);
        }
    }
}


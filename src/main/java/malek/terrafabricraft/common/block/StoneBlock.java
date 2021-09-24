package malek.terrafabricraft.common.block;

import net.minecraft.block.Block;
import net.minecraft.util.Identifier;

import static malek.terrafabricraft.common.registry.TFCObjects.createRock;

public class StoneBlock {
   // public Block groundCover;
    //TODO : Add facing and power varation for the stone button
    public Block button;
    public Block anvil;
    public Block brick;
    public Block chiseled;
    public Block cobble;
    public Block crackedBrick;
    public Block gravel;
    public Block hardened;
    public Block loose;
    public Block mossyBrick;
    public Block mossyCobble;
    public Block pressurePlate;
    public Block raw;
    public Block smooth;
    public Block spike;

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
    public Block bitumiousCoal;
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

    public StoneBlock(String name) {
        String id = "rock/";
        button = setCreateBlock(name, id, "button");
        anvil = setCreateBlock(name, id, "anvil");
        brick = setCreateBlock(name, id, "bricks");
        chiseled = setCreateBlock(name, id, "chisled");
        cobble = setCreateBlock(name, id, "cobble");
        crackedBrick = setCreateBlock(name, id, "cracked_bricks");
        gravel = setCreateBlock(name, id, "gravel");
        hardened = setCreateBlock(name, id, "hardened");
        loose = setCreateBlock(name, id, "loose");
        mossyBrick = setCreateBlock(name, id, "mossy_bricks");
        mossyCobble = setCreateBlock(name, id, "mossy_cobble");
        pressurePlate = setCreateBlock(name, id, "pressure_plate");
        raw = setCreateBlock(name, id, "raw");
        smooth = setCreateBlock(name, id, "smooth");
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
        bitumiousCoal = setCreateBlock(name, id, "bitumious_coal");
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



    }

    private static Block setCreateBlock(String name, String id, String special) {
        return createRock(id+special+"/"+name, true);
    }
    public class OreStoneBlock {
        public Block poor;
        public Block normal;
        public Block rich;
        public OreStoneBlock(String rockType, String oreType) {
            poor = setCreateBlock(rockType, "ore/poor_"+oreType, "");
            normal = setCreateBlock(rockType, "ore/normal_"+oreType, "");
            rich = setCreateBlock(rockType, "ore/rich_"+oreType, "");
        }
    }
}


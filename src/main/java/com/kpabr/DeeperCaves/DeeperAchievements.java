package com.kpabr.DeeperCaves;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;

public class DeeperAchievements {

    public static Achievement enterDrop;
    public static Achievement enterMaze;
    public static Achievement enterCrystal;
    public static Achievement enterCompressed;
    public static Achievement enterBedrockPlains;

    public static Achievement enterNearNether;
    public static Achievement enterLava;
    public static Achievement enterNearVoid;

    public static Achievement enterDeepWorld;
    public static Achievement enterDarkness;
    public static Achievement enterAbandonedCaves;
    public static Achievement enterMutation;
    public static Achievement enterFarVoid;

    public static Achievement enterForgotten;
    public static Achievement enterEvil;
    public static Achievement enterFinalLabyrinth;

    public static Achievement mineAmetrine;
    public static Achievement mineCompressedOre;
    public static Achievement makeAmetrineTippedPickaxe;
    public static Achievement solidifyRobustium;
    public static Achievement smeltRobustium;
    public static Achievement mineTenebrium;
    public static Achievement mineVesperite;
    public static Achievement makeVoidCharm;
    public static Achievement mineEvanescite;
    public static Achievement makeForgottenCharm;
    public static Achievement mineForgottenGemstone;

    public static Achievement returnToOverworld;

    public static AchievementPage deeperPage;

    public static void setupAchievements()
    {

        enterDrop = new Achievement("enterDrop", "enterDrop", 0, 0, Items.diamond_pickaxe, null);
        enterMaze = new Achievement("enterMaze", "enterMaze", 2, 1, Blocks.stone, enterDrop);
        enterCrystal = new Achievement("enterCrystal", "enterCrystal", 4, -1, DeeperBlocks.crystal, enterMaze);
        enterCompressed = new Achievement("enterCompressed", "enterCompressed", 6, -1, DeeperBlocks.cdiamondOre, enterCrystal);
        enterBedrockPlains = new Achievement("enterBedrockPlains", "enterBedrockPlains", 4, -3, DeeperBlocks.fragmentedBedrock, enterCompressed);

        enterNearNether = new Achievement("enterNearNether", "enterNearNether", 2, -3, Blocks.netherrack, enterBedrockPlains);
        enterLava = new Achievement("enterLava", "enterLava", 0, -2, Items.lava_bucket, enterNearNether);
        enterNearVoid = new Achievement("enterNearVoid", "enterNearVoid", -1, -4, DeeperItems.tenebriumIngot, enterLava);

        enterDeepWorld = new Achievement("enterDeepWorld", "enterDeepWorld", -3, -3, Blocks.diamond_ore, enterNearVoid);
        enterDarkness = new Achievement("enterDarkness", "enterDarkness", -3, -1, DeeperBlocks.darkStone, enterDeepWorld);
        enterAbandonedCaves = new Achievement("enterAbandonedCaves", "enterAbandonedCaves", -2, 1, DeeperBlocks.abandonedStone, enterDarkness);
        enterMutation = new Achievement("enterMutation", "enterMutation", -4, 2, DeeperItems.bucketV, enterAbandonedCaves);
        enterFarVoid = new Achievement("enterFarVoid", "enterFarVoid", -4, 4, DeeperBlocks.cooledObsidian, enterMutation);

        enterForgotten = new Achievement("enterForgotten", "enterForgotten", -3, 3, DeeperItems.evanesciteGem, enterFarVoid);
        enterEvil = new Achievement("enterEvil", "enterEvil", -3,6, DeeperBlocks.cryingObsidian, enterForgotten);
        enterFinalLabyrinth = new Achievement("enterFinalLabyrinth", "enterFinalLabyrinth", 0, 9, DeeperBlocks.forgottenGemstoneOre, enterEvil);

        mineAmetrine = new Achievement("mineAmetrine", "mineAmetrine", 4 , 1, DeeperBlocks.ametrineOre, enterCrystal);
        mineCompressedOre = new Achievement("mineCompressedOre", "mineCompressedOre", 8, -1, DeeperBlocks.credstoneOre, enterCompressed);
        makeAmetrineTippedPickaxe = new Achievement("makeAmetrineTippedPickaxe", "makeAmetrineTippedPickaxe", 5, 3, DeeperItems.ametrineTippedDiamondPickaxe, enterCrystal);
        solidifyRobustium = new Achievement("solidifyRobustium", "solidifyRobustium", 4, -5, DeeperBlocks.robustiumRaw, enterBedrockPlains);
        smeltRobustium = new Achievement("smeltRobustium", "smeltRobustium", 5, -6, DeeperItems.robustiumIngot, solidifyRobustium);
        mineTenebrium = new Achievement("mineTenebrium", "mineTenebrium", -1, -6, DeeperBlocks.tenebriumOre, enterNearVoid);
        mineVesperite = new Achievement("mineVesperite", "mineVesperite", -5, -1, DeeperBlocks.vesperiteOre, enterDarkness);
        makeVoidCharm = new Achievement("makeVoidCharm", "makeVoidCharm", -6, 0, DeeperItems.voidCharm, mineVesperite);
        mineEvanescite = new Achievement("mineEvanescite", "mineEvanescite", 0, 9, DeeperBlocks.evanesciteOre, enterForgotten);
        makeForgottenCharm = new Achievement("makeForgottenCharm", "makeForgottenCharm", 0, 9, DeeperItems.forgottenCharm, mineEvanescite);
        mineForgottenGemstone = new Achievement("mineForgottenGemstone", "mineForgottenGemstone", 0, 9, DeeperItems.forgottenGemstone, enterFinalLabyrinth);
        returnToOverworld = new Achievement("returnToOverworld", "returnToOverworld", 0, 9, DeeperBlocks.returnPortal, mineForgottenGemstone);


    }

    public static void registerAchievements()
    {
        enterDrop.registerStat();
        enterMaze.registerStat();
        enterCrystal.registerStat();
        enterCompressed.registerStat();
        enterBedrockPlains.registerStat();

        enterNearNether.registerStat();
        enterLava.registerStat();
        enterNearVoid.registerStat();

        enterDeepWorld.registerStat();
        enterDarkness.registerStat();
        enterAbandonedCaves.registerStat();
        enterMutation.registerStat();
        enterFarVoid.registerStat();

        //enterForgotten.registerStat();
        //enterEvil.registerStat();
        //enterFinalLabyrinth.registerStat();

        mineAmetrine.registerStat();
        mineCompressedOre.registerStat();
        makeAmetrineTippedPickaxe.registerStat();
        solidifyRobustium.registerStat();
        smeltRobustium.registerStat();
        mineTenebrium.registerStat();
        mineVesperite.registerStat();
        makeVoidCharm.registerStat();
        mineEvanescite.registerStat();
        makeForgottenCharm.registerStat();
        mineForgottenGemstone.registerStat();
        returnToOverworld.registerStat();


        deeperPage = new AchievementPage("Deeper Caves", enterDrop, enterMaze, enterCrystal, enterCompressed, enterBedrockPlains, enterNearNether, enterLava, enterNearVoid, enterDeepWorld, enterDarkness, enterAbandonedCaves, enterMutation, enterFarVoid, mineAmetrine, mineCompressedOre, makeAmetrineTippedPickaxe, solidifyRobustium, smeltRobustium, mineTenebrium, mineVesperite, makeVoidCharm, mineEvanescite, makeForgottenCharm, mineForgottenGemstone, returnToOverworld);
        //enterForgotten, enterEvil, enterFinalLabyrinth
        AchievementPage.registerAchievementPage(deeperPage);

    }
}

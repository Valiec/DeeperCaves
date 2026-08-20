package com.kpabr.DeeperCaves;

import com.kpabr.DeeperCore.worldgen.LayerOregen;
import com.kpabr.DeeperCaves.structure.cavevillage.CaveVillage;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

import java.util.Random;

public class DeeperOreGenerators
{
       public static void generateDrop(World world, Random random, int x, int z)
       {
    	   
    	   LayerOregen.addOre(Blocks.gold_ore, world, random, x, z, 16, 16, 16, 8, 0, 256, Blocks.stone);
    	   LayerOregen.addOre(Blocks.diamond_ore, world, random, x, z, 16, 16, 12, 2, 0, 256, Blocks.stone);
    	   LayerOregen.addOre(Blocks.emerald_ore, world, random, x, z, 16, 16, 8, 1, 0, 256, Blocks.stone);
           
       }
       public static void generateMaze(World world, Random random, int x, int z)
       {
    	   
    	   LayerOregen.addOre(DeeperBlocks.silverOre, world, random, x, z, 16, 16, 4, 32, 0, 255, Blocks.stone);
    	   LayerOregen.addOre(DeeperBlocks.rubyOre, world, random, x, z, 16, 16, 5, 35, 0, 255, Blocks.stone);
           
       }
       public static void generateCrystal(World world, Random random, int x, int z)
       {
    	   
    	   LayerOregen.addOre(DeeperBlocks.sapphireOre, world, random, x, z, 16, 16, 4, 32, 0, 255, Blocks.stone);
    	   LayerOregen.addOre(DeeperBlocks.aquamarineOre, world, random, x, z, 16, 16, 9, 40, 0, 255, Blocks.stone);
    	   LayerOregen.addOre(DeeperBlocks.ametrineOre, world, random, x, z, 16, 16, 12, 4, 0, 255, Blocks.stone);
    	   
    	   for(int i = 0; i<16; i++)
    	   {
    		   LayerOregen.addOre(DeeperBlocks.crystal, i, world, random, x, z, 16, 16, 15, 6, 0, 255, Blocks.stone);
    	   }
           
       }
       public static void generateCompressed(World world, Random random, int x, int z)
       {
    	   
    	   LayerOregen.addOre(DeeperBlocks.ccoalOre, world, random, x, z, 16, 16, 15, 160, 0, 255, Blocks.stone);
    	   LayerOregen.addOre(DeeperBlocks.cironOre, world, random, x, z, 16, 16, 10, 130, 0, 255, Blocks.stone);
    	   LayerOregen.addOre(DeeperBlocks.cgoldOre, world, random, x, z, 16, 16, 8, 30, 0, 255, Blocks.stone);
    	   LayerOregen.addOre(DeeperBlocks.clapisOre, world, random, x, z, 16, 16, 7, 35, 0, 255, Blocks.stone);
    	   LayerOregen.addOre(DeeperBlocks.credstoneOre, world, random, x, z, 16, 16, 8, 108, 0, 255, Blocks.stone);
    	   LayerOregen.addOre(DeeperBlocks.cdiamondOre, world, random, x, z, 16, 16, 8, 13, 0, 255, Blocks.stone);
    	   LayerOregen.addOre(DeeperBlocks.cemeraldOre, world, random, x, z, 16, 16, 3, 8, 0, 255, Blocks.stone);
    	   LayerOregen.addOre(DeeperBlocks.csapphireOre, world, random, x, z, 16, 16, 4, 32, 0, 255, Blocks.stone);
    	   LayerOregen.addOre(DeeperBlocks.caquamarineOre, world, random, x, z, 16, 16, 9, 40, 0, 255, Blocks.stone);
    	   LayerOregen.addOre(DeeperBlocks.csilverOre, world, random, x, z, 16, 16, 4, 32, 0, 255, Blocks.stone);
    	   LayerOregen.addOre(DeeperBlocks.crubyOre, world, random, x, z, 16, 16, 5, 35, 0, 255, Blocks.stone);
           
       }
       public static void generateBedrockPlains(World world, Random random, int x, int z)
       {
    	   
    	   LayerOregen.addOre(DeeperBlocks.fragmentedBedrock, world, random, x, z, 16, 16, 8, 4, 150, 255, Blocks.bedrock);
           
       }
       public static void generateNearNether(World world, Random random, int x, int z)
       {
    	   
    	   LayerOregen.addOre(Blocks.netherrack, world, random, x, z, 16, 16, 15, 180, 0, 255, Blocks.stone);
    	   LayerOregen.addOre(Blocks.quartz_ore, world, random, x, z, 16, 16, 8, 55, 0, 255, Blocks.stone);
    	   LayerOregen.addOre(Blocks.glowstone, world, random, x, z, 16, 16, 20, 60, 0, 255, Blocks.stone);
           
       }
       public static void generateLava(World world, Random random, int x, int z)
       {
    	   LayerOregen.addOre(DeeperBlocks.magmaStone, world, random, x, z, 16, 16, 40, 80, 0, 255, Blocks.stone);
    	   LayerOregen.addOre(Blocks.cobblestone, world, random, x, z, 16, 16, 15, 120, 0, 255, Blocks.stone);
    	   LayerOregen.addOre(DeeperBlocks.fragmentedCobble, world, random, x, z, 16, 16, 14, 80, 0, 255, Blocks.stone);
    	   LayerOregen.addOre(DeeperBlocks.fragmentedBedrock, world, random, x, z, 16, 16, 8, 55, 0, 255, Blocks.stone);
    	   LayerOregen.addOre(Blocks.flowing_lava, world, random, x, z, 16, 16, 1, 65, 0, 255, Blocks.stone);
		   LayerOregen.addOre(DeeperBlocks.incenditeOre, world, random, x, z, 16, 16, 3, 4, 0, 50, Blocks.stone);

           
       }
       public static void generateNearVoid(World world, Random random, int x, int z)
       {
    	   
    	   LayerOregen.addOre(DeeperBlocks.tenebriumOre, world, random, x, z, 16, 16, 8, 8, 0, 255, Blocks.stone);
           
       }
       public static void generateDeepWorld(World world, Random random, int x, int z)
       {
    	   
    	   LayerOregen.addOre(Blocks.coal_ore, world, random, x, z, 16, 16, 15, 160, 0, 255, Blocks.stone);
    	   LayerOregen.addOre(Blocks.iron_ore, world, random, x, z, 16, 16, 10, 130, 0, 255, Blocks.stone);
    	   LayerOregen.addOre(Blocks.gold_ore, world, random, x, z, 16, 16, 8, 30, 0, 255, Blocks.stone);
    	   LayerOregen.addOre(Blocks.lapis_ore, world, random, x, z, 16, 16, 7, 35, 0, 255, Blocks.stone);
    	   LayerOregen.addOre(Blocks.redstone_ore, world, random, x, z, 16, 16, 8, 108, 0, 255, Blocks.stone);
    	   LayerOregen.addOre(Blocks.diamond_ore, world, random, x, z, 16, 16, 8, 13, 0, 255, Blocks.stone);
    	   LayerOregen.addOre(Blocks.emerald_ore, world, random, x, z, 16, 16, 3, 8, 0, 255, Blocks.stone);
           
       }
       public static void generateDarkness(World world, Random random, int x, int z)
       {
    	   
    	   LayerOregen.addOre(DeeperBlocks.ddcoalOre, world, random, x, z, 16, 16, 15, 80, 0, 255, DeeperBlocks.darkStone);
    	   LayerOregen.addOre(DeeperBlocks.ddironOre, world, random, x, z, 16, 16, 10, 65, 0, 255, DeeperBlocks.darkStone);
    	   LayerOregen.addOre(DeeperBlocks.ddgoldOre, world, random, x, z, 16, 16, 8, 15, 0, 255, DeeperBlocks.darkStone);
    	   LayerOregen.addOre(DeeperBlocks.ddlapisOre, world, random, x, z, 16, 16, 7, 18, 0, 255, DeeperBlocks.darkStone);
    	   LayerOregen.addOre(DeeperBlocks.ddredstoneOre, world, random, x, z, 16, 16, 8, 54, 0, 255, DeeperBlocks.darkStone);
    	   LayerOregen.addOre(DeeperBlocks.dddiamondOre, world, random, x, z, 16, 16, 8, 7, 0, 255, DeeperBlocks.darkStone);
    	   LayerOregen.addOre(DeeperBlocks.ddemeraldOre, world, random, x, z, 16, 16, 3, 4, 0, 255, DeeperBlocks.darkStone);
    	   
    	   LayerOregen.addOre(DeeperBlocks.vesperiteOre, world, random, x, z, 16, 16, 6, 80, 0, 255, DeeperBlocks.darkStone);
    	   
           
       }
       
       public static void generateAbandonedCaves(World world, Random random, int x, int z)
       {
    	   
    	   LayerOregen.addOre(DeeperBlocks.dcoalOre, world, random, x, z, 16, 16, 15, 80, 0, 255, DeeperBlocks.abandonedStone);
    	   LayerOregen.addOre(DeeperBlocks.dironOre, world, random, x, z, 16, 16, 10, 65, 0, 255, DeeperBlocks.abandonedStone);
    	   LayerOregen.addOre(DeeperBlocks.dgoldOre, world, random, x, z, 16, 16, 8, 15, 0, 255, DeeperBlocks.abandonedStone);
    	   LayerOregen.addOre(DeeperBlocks.dlapisOre, world, random, x, z, 16, 16, 7, 18, 0, 255, DeeperBlocks.abandonedStone);
    	   LayerOregen.addOre(DeeperBlocks.dredstoneOre, world, random, x, z, 16, 16, 8, 54, 0, 255, DeeperBlocks.abandonedStone);
    	   LayerOregen.addOre(DeeperBlocks.ddiamondOre, world, random, x, z, 16, 16, 8, 7, 0, 255, DeeperBlocks.abandonedStone);
    	   LayerOregen.addOre(DeeperBlocks.demeraldOre, world, random, x, z, 16, 16, 3, 4, 0, 255, DeeperBlocks.abandonedStone);
    	   
    	   if (random.nextInt(6) == 0) //TODO tweak?
           {
               int i = x + random.nextInt(16) + 8;
               int j = z + random.nextInt(16) + 8;
               int k = random.nextInt(60);
               (new CaveVillage()).generate(world, random, i, k, j);
           }
           
       }
       
       public static void generateMutation(World world, Random random, int x, int z)
       {
    	   LayerOregen.addOre(DeeperBlocks.dpcoalOre, world, random, x, z, 16, 16, 15, 80, 0, 255, DeeperBlocks.deepStone);
    	   LayerOregen.addOre(DeeperBlocks.dpironOre, world, random, x, z, 16, 16, 10, 65, 0, 255, DeeperBlocks.deepStone);
    	   LayerOregen.addOre(DeeperBlocks.dpgoldOre, world, random, x, z, 16, 16, 8, 15, 0, 255, DeeperBlocks.deepStone);
    	   LayerOregen.addOre(DeeperBlocks.dplapisOre, world, random, x, z, 16, 16, 7, 18, 0, 255, DeeperBlocks.deepStone);
    	   LayerOregen.addOre(DeeperBlocks.dpredstoneOre, world, random, x, z, 16, 16, 8, 54, 0, 255, DeeperBlocks.deepStone);
    	   LayerOregen.addOre(DeeperBlocks.dpdiamondOre, world, random, x, z, 16, 16, 8, 7, 0, 255, DeeperBlocks.deepStone);
    	   LayerOregen.addOre(DeeperBlocks.dpemeraldOre, world, random, x, z, 16, 16, 3, 4, 0, 255, DeeperBlocks.deepStone);
    	   for(int i = 0; i<16; i++)
    	   {
    		   LayerOregen.addOre(DeeperBlocks.crystal, i, world, random, x, z, 16, 16, 8, 4, 0, 255, DeeperBlocks.deepStone);
    	   }
       }
       
       public static void generateFarVoid(World world, Random random, int x, int z)
       {
    	   
    	   LayerOregen.addOre(DeeperBlocks.dccoalOre, world, random, x, z, 16, 16, 15, 4, 220, 235, DeeperBlocks.deepStone);
    	   LayerOregen.addOre(DeeperBlocks.dcironOre, world, random, x, z, 16, 16, 10, 2, 220, 235, DeeperBlocks.deepStone);
    	   LayerOregen.addOre(DeeperBlocks.dcgoldOre, world, random, x, z, 16, 16, 8, 1, 220, 235, DeeperBlocks.deepStone);
    	   LayerOregen.addOre(DeeperBlocks.dclapisOre, world, random, x, z, 16, 16, 7, 1, 220, 235, DeeperBlocks.deepStone);
    	   LayerOregen.addOre(DeeperBlocks.dcredstoneOre, world, random, x, z, 16, 16, 8, 1, 220, 235, DeeperBlocks.deepStone);
    	   LayerOregen.addOre(DeeperBlocks.dcdiamondOre, world, random, x, z, 16, 16, 8, 1, 220, 235, DeeperBlocks.deepStone);
    	   LayerOregen.addOre(DeeperBlocks.dcemeraldOre, world, random, x, z, 16, 16, 3, 1, 220, 235, DeeperBlocks.deepStone);
    	   LayerOregen.addOre(Blocks.obsidian, world, random, x, z, 16, 16, 15, 3, 220, 255, DeeperBlocks.deepStone);
    	   LayerOregen.addOre(DeeperBlocks.cooledObsidian, world, random, x, z, 16, 16, 15, 3, 220, 255, DeeperBlocks.deepStone);
    	   LayerOregen.addOre(DeeperBlocks.heatedObsidian, world, random, x, z, 16, 16, 15, 3, 220, 255, DeeperBlocks.deepStone);
    	   LayerOregen.addOre(Blocks.end_stone, world, random, x, z, 16, 16, 15, 1, 128, 255, DeeperBlocks.deepStone);
    	   LayerOregen.addOre(DeeperBlocks.dcsapphireOre, world, random, x, z, 16, 16, 4, 32, 0, 255, DeeperBlocks.deepStone);
    	   LayerOregen.addOre(DeeperBlocks.dcaquamarineOre, world, random, x, z, 16, 16, 9, 40, 0, 255, DeeperBlocks.deepStone);
    	   LayerOregen.addOre(DeeperBlocks.dcsilverOre, world, random, x, z, 16, 16, 4, 32, 0, 255, DeeperBlocks.deepStone);
    	   LayerOregen.addOre(DeeperBlocks.dcrubyOre, world, random, x, z, 16, 16, 5, 35, 0, 255, DeeperBlocks.deepStone);
           
       }
       
       public static void generateForgotten(World world, Random random, int x, int z)
       {
    	   LayerOregen.addOre(DeeperBlocks.dpcoalOre, world, random, x, z, 16, 16, 15, 80, 0, 255, DeeperBlocks.deepStone);
    	   LayerOregen.addOre(DeeperBlocks.dpironOre, world, random, x, z, 16, 16, 10, 65, 0, 255, DeeperBlocks.deepStone);
    	   LayerOregen.addOre(DeeperBlocks.dpgoldOre, world, random, x, z, 16, 16, 8, 15, 0, 255, DeeperBlocks.deepStone);
    	   LayerOregen.addOre(DeeperBlocks.dplapisOre, world, random, x, z, 16, 16, 7, 18, 0, 255, DeeperBlocks.deepStone);
    	   LayerOregen.addOre(DeeperBlocks.dpredstoneOre, world, random, x, z, 16, 16, 8, 54, 0, 255, DeeperBlocks.deepStone);
    	   LayerOregen.addOre(DeeperBlocks.dpdiamondOre, world, random, x, z, 16, 16, 8, 7, 0, 255, DeeperBlocks.deepStone);
    	   LayerOregen.addOre(DeeperBlocks.dpemeraldOre, world, random, x, z, 16, 16, 3, 4, 0, 255, DeeperBlocks.deepStone);
    	   LayerOregen.addOre(DeeperBlocks.evanesciteOre, world, random, x, z, 16, 16, 6, 180, 0, 255, DeeperBlocks.deepStone);
		   LayerOregen.addOre(DeeperBlocks.profundiumOre, world, random, x, z, 16, 16, 6, 90, 0, 255, DeeperBlocks.deepStone);
       }
       
       public static void generateEvil(World world, Random random, int x, int z)
       {
    	   LayerOregen.addOre(DeeperBlocks.soulStone, world, random, x, z, 16, 16, 25, 180, 0, 255, DeeperBlocks.deepStone);
    	   LayerOregen.addOre(DeeperBlocks.corruptedSoulStone, world, random, x, z, 16, 16, 16, 120, 0, 255, DeeperBlocks.deepStone);
    	   LayerOregen.addOre(DeeperBlocks.cryingObsidian, world, random, x, z, 16, 16, 14, 92, 0, 255, DeeperBlocks.deepStone);
    	   LayerOregen.addOre(DeeperBlocks.prisciumOre, world, random, x, z, 16, 16, 6, 67, 0, 255, DeeperBlocks.deepStone);
		   LayerOregen.addOre(DeeperBlocks.profundiumOre, world, random, x, z, 16, 16, 3, 50, 0, 255, DeeperBlocks.deepStone);
       }
       
       
       public static void generateFinalLabyrinth(World world, Random random, int x, int z)
       { 
    	   LayerOregen.addOre(DeeperBlocks.forgottenGemstoneOre, world, random, x, z, 16, 16, 4, 50, 0, 255, DeeperBlocks.fragmentedBedrock); 
       }
}
       
       
       
       
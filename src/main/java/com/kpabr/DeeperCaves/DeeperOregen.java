package com.kpabr.DeeperCaves;
/*
 * Created by Valiec2019
 * on February 18, 2014
 * using Minecraft Forge 10.12.0.1022
 */
import static net.minecraftforge.event.terraingen.OreGenEvent.GenerateMinable.EventType.QUARTZ;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenBigTree;
import net.minecraft.world.gen.feature.WorldGenFlowers;
import net.minecraft.world.gen.feature.WorldGenForest;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenSpikes;
import net.minecraft.world.gen.structure.MapGenVillage;
import net.minecraftforge.event.terraingen.TerrainGen;
import cpw.mods.fml.common.IWorldGenerator;
import cpw.mods.fml.common.registry.GameRegistry;

import java.util.Date;
public class DeeperOregen implements IWorldGenerator
{   
	   @Override
       public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
       {
             switch(world.provider.dimensionId)
             {
                    case -1:
                    		generateNether(world, random, chunkX * 16, chunkZ * 16);
                    		break;
                    case 7: 
                    		generateDeeper(world, random, chunkX * 16, chunkZ * 16);
                    		break;
                    case 0:
                    		generateOverworld(world, random, chunkX * 16, chunkZ * 16);
                    		break;
                    default: generateNether(world, random, chunkX * 16, chunkZ * 16); //testing
             }
       }
      
       private void generateOverworld(World world, Random random, int x, int z)
       {
    	   this.addOre(DeeperCaves.blocks.dropPortal, world, random, x, z, 16, 16, 8, 4, 0, 16, Blocks.stone);
    	   /*
           if (world.provider.dimensionId == 1)
           {
        	   //this.addOre(DeeperCaves.blocks.enderiteOre, world, random, x, z, 16, 16, 9, 10, 5, 100, Blocks.end_stone);
        	   //this.addOre(DeeperCaves.blocks.endRedstoneOre, world, random, x, z, 16, 16, 9, 48, 5, 100, Blocks.end_stone);
        	   //this.addOre(DeeperCaves.blocks.enderEssence, world, random, x, z, 16, 16, 13, 10, 5, 100, Blocks.end_stone);
        	   if(random.nextInt(17) == 0)
        	   {
        	       int Xcoord1 = x + random.nextInt(16);
        	       int Zcoord1 = z + random.nextInt(16);
        	       int Ycoord1 = world.getTopSolidOrLiquidBlock(Xcoord1, Zcoord1);
        	       (new WorldGenWart()).generate(world, random, Xcoord1, Ycoord1, Zcoord1);
        	   }
               if (random.nextInt(5) == 0)
               {
                   int i = x + random.nextInt(16) + 8;
                   int j = z + random.nextInt(16) + 8;
                   int k = world.getTopSolidOrLiquidBlock(i, j);
                   (new WorldGenEnderSpikes(DeeperCaves.blocks.endGrass)).generate(world, random, i, k, j);
               }
               if (random.nextInt(15) == 0)
               {
                   int i = x + random.nextInt(16) + 8;
                   int j = z + random.nextInt(16) + 8;
                   int k = world.getTopSolidOrLiquidBlock(i, j);
                   (new WorldGenEnderStructure(DeeperCaves.blocks.endGrass)).generate(world, random, i, k, j);
               }
               if(random.nextInt(3) == 0)
               {
                   int Xcoord1 = x + random.nextInt(16);
                   int Zcoord1 = z + random.nextInt(16);
                   int Ycoord1 = world.getTopSolidOrLiquidBlock(Xcoord1, Zcoord1);
                   //System.out.println(Xcoord1);
                   //System.out.println(Ycoord1);
                   //System.out.println(Zcoord1);
                   (new WorldGenEnderForest(false,true)).generate(world, random, Xcoord1, Ycoord1, Zcoord1);
               }
           }
 
*/

       }

       private void generateDeeper(World world, Random random, int x, int z)
       {
    	   
    	   this.addOre(Blocks.gold_ore, world, random, x, z, 16, 16, 16, 8, 0, 256, Blocks.stone);
    	   this.addOre(Blocks.diamond_ore, world, random, x, z, 16, 16, 12, 2, 0, 256, Blocks.stone);
    	   this.addOre(Blocks.emerald_ore, world, random, x, z, 16, 16, 8, 1, 0, 256, Blocks.stone);
    	   this.addOre(DeeperCaves.blocks.returnPortal, world, random, x, z, 16, 16, 8, 4, 0, 16, Blocks.stone);
    	   //this.addOre(Blocks.overworldEssence, world, random, x, z, 16, 16, 13, 10, 0, 256, Blocks.stone);
           /*if (random.nextInt(17) == 0)
           {
               int i = x + random.nextInt(16) + 8;
               int j = z + random.nextInt(16) + 8;
               int k = world.getTopSolidOrLiquidBlock(i, j);
               (new WorldGenEnderSpikes(DeeperCaves.blocks.endGrass)).generate(world, random, i, k, j);
           }*/
           
       }

       private void generateNether(World world, Random random, int x, int z)
       {
    	   /*
    	  
    	   this.addOre(DeeperCaves.blocks.flameriteOre, world, random, x, z, 16, 16, 7, 10, 0, 64, DeeperCaves.blocks.netherStone); //?
    	   this.addOre(DeeperCaves.blocks.netherStoneQuartz, world, random, x, z, 16, 16, 13, 10, 0, 64, DeeperCaves.blocks.netherStone); //?
    	   this.addOre(DeeperCaves.blocks.umbriteOre, world, random, x, z, 16, 16, 8, 10, 64, 128, DeeperCaves.blocks.netherStone); //?
    	   this.addOre(DeeperCaves.blocks.netherEssence, world, random, x, z, 16, 16, 13, 10, 59, 69, DeeperCaves.blocks.netherStone);
           this.addOre(Blocks.soul_sand, world, random, x, z, 16, 16, 32, 10, 64, 128, DeeperCaves.blocks.soulDirt);
    	   if(random.nextInt(17) == 0)
           {
    	       int j1 = x + random.nextInt(16);
    	       int k1 = random.nextInt(80);
               int l1 = z + random.nextInt(16);
               (new WorldGenFlowers(Blocks.nether_wart)).generate(world, random, j1, k1, l1);
           }
           */
    	   
       }

       public void addOre(Block block, World world, Random random, int x, int z, int maxX, int maxZ, int maxVeinSize, int chancesToSpawn, int minY, int maxY, Block generateIn)
       {
             int heightRange = maxY - minY;             
             WorldGenMinable worldgenminable = new WorldGenMinable(block, maxVeinSize, generateIn);
             for (int k1 = 0; k1 < chancesToSpawn; ++k1)
             {
                 int l1 = random.nextInt(16);
                 int i2 = random.nextInt(heightRange) + minY;
                 int j2 = random.nextInt(16);
                 worldgenminable.generate(world, random, x+l1, i2, z+j2);
             }
       }
}
       
       
       
       
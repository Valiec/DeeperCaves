package com.kpabr.DeeperCaves;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

import com.kpabr.DeeperCaves.structure.cavevillage.CaveVillage;
public class DeeperOregen implements IWorldGenerator
{   
	   @Override
       public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
       {
					if (world.provider.dimensionId == DeeperCaves.worldgen.finalLabyrinthDimID)
					{
							generateFinalLabyrinth(world, random, chunkX * 16, chunkZ * 16);
					}
					else if (world.provider.dimensionId == DeeperCaves.worldgen.evilDimID)
					{
							generateEvil(world, random, chunkX * 16, chunkZ * 16);
					}
					else if (world.provider.dimensionId == DeeperCaves.worldgen.forgottenDimID)
					{
							generateForgotten(world, random, chunkX * 16, chunkZ * 16);
					}
					else if (world.provider.dimensionId == DeeperCaves.worldgen.farVoidDimID)
					{
							generateFarVoid(world, random, chunkX * 16, chunkZ * 16);
					}
					else if (world.provider.dimensionId == DeeperCaves.worldgen.mutationDimID)
					{
							generateMutation(world, random, chunkX * 16, chunkZ * 16);
					}
					else if (world.provider.dimensionId == DeeperCaves.worldgen.abandonedCavesDimID)
					{
							generateAbandonedCaves(world, random, chunkX * 16, chunkZ * 16);
					}
					else if (world.provider.dimensionId == DeeperCaves.worldgen.darknessDimID)
					{
							generateDarkness(world, random, chunkX * 16, chunkZ * 16);
					}
					else if (world.provider.dimensionId == DeeperCaves.worldgen.deepWorldDimID)
					{
  							generateDeepWorld(world, random, chunkX * 16, chunkZ * 16);
      				}
					else if (world.provider.dimensionId == DeeperCaves.worldgen.nearVoidDimID)
					{
      						generateNearVoid(world, random, chunkX * 16, chunkZ * 16);
      				}
					else if (world.provider.dimensionId == DeeperCaves.worldgen.lavaDimID)
					{
 							generateLava(world, random, chunkX * 16, chunkZ * 16);
             		}
					else if (world.provider.dimensionId == DeeperCaves.worldgen.nearNetherDimID)
					{
             				generateNearNether(world, random, chunkX * 16, chunkZ * 16);
		            }
					else if (world.provider.dimensionId == DeeperCaves.worldgen.bedrockPlainsDimID)
					{
		             		generateBedrockPlains(world, random, chunkX * 16, chunkZ * 16);
		            }
					else if (world.provider.dimensionId == DeeperCaves.worldgen.compressedDimID)
					{
		             		generateCompressed(world, random, chunkX * 16, chunkZ * 16);		
		            }
					else if (world.provider.dimensionId == DeeperCaves.worldgen.crystalDimID)
					{
		             		generateCrystal(world, random, chunkX * 16, chunkZ * 16);	
                    }
					else if (world.provider.dimensionId == DeeperCaves.worldgen.mazeDimID)
					{
                    		generateMaze(world, random, chunkX * 16, chunkZ * 16);
                    }
					else if (world.provider.dimensionId == DeeperCaves.worldgen.dropDimID)
					{ 
                    		generateDrop(world, random, chunkX * 16, chunkZ * 16);
					}
                    else if (world.provider.dimensionId == 0)
                    {
                    		generateOverworld(world, random, chunkX * 16, chunkZ * 16);
                    }
       }
      
       private void generateOverworld(World world, Random random, int x, int z)
       {

       }
       
       private void generateDefault(World world, Random random, int x, int z)
       {

       }

       private void generateDrop(World world, Random random, int x, int z)
       {
    	   
    	   this.addOre(Blocks.gold_ore, world, random, x, z, 16, 16, 16, 8, 0, 256, Blocks.stone);
    	   this.addOre(Blocks.diamond_ore, world, random, x, z, 16, 16, 12, 2, 0, 256, Blocks.stone);
    	   this.addOre(Blocks.emerald_ore, world, random, x, z, 16, 16, 8, 1, 0, 256, Blocks.stone);
           
       }
       private void generateMaze(World world, Random random, int x, int z)
       {
    	   
    	   this.addOre(DeeperBlocks.silverOre, world, random, x, z, 16, 16, 4, 32, 0, 255, Blocks.stone);
    	   this.addOre(DeeperBlocks.rubyOre, world, random, x, z, 16, 16, 5, 35, 0, 255, Blocks.stone);
           
       }
       private void generateCrystal(World world, Random random, int x, int z)
       {
    	   
    	   this.addOre(DeeperBlocks.sapphireOre, world, random, x, z, 16, 16, 4, 32, 0, 255, Blocks.stone);
    	   this.addOre(DeeperBlocks.aquamarineOre, world, random, x, z, 16, 16, 9, 40, 0, 255, Blocks.stone);
    	   this.addOre(DeeperBlocks.ametrineOre, world, random, x, z, 16, 16, 12, 4, 0, 255, Blocks.stone);
    	   
    	   for(int i = 0; i<13; i++)
    	   {
    		   this.addOre(DeeperBlocks.crystal, i, world, random, x, z, 16, 16, 15, 6, 0, 255, Blocks.stone);
    	   }
           
       }
       private void generateCompressed(World world, Random random, int x, int z)
       {
    	   
    	   this.addOre(DeeperBlocks.ccoalOre, world, random, x, z, 16, 16, 15, 160, 0, 255, Blocks.stone);
    	   this.addOre(DeeperBlocks.cironOre, world, random, x, z, 16, 16, 10, 130, 0, 255, Blocks.stone);
    	   this.addOre(DeeperBlocks.cgoldOre, world, random, x, z, 16, 16, 8, 30, 0, 255, Blocks.stone);
    	   this.addOre(DeeperBlocks.clapisOre, world, random, x, z, 16, 16, 7, 35, 0, 255, Blocks.stone);
    	   this.addOre(DeeperBlocks.credstoneOre, world, random, x, z, 16, 16, 8, 108, 0, 255, Blocks.stone);
    	   this.addOre(DeeperBlocks.cdiamondOre, world, random, x, z, 16, 16, 8, 13, 0, 255, Blocks.stone);
    	   this.addOre(DeeperBlocks.cemeraldOre, world, random, x, z, 16, 16, 3, 8, 0, 255, Blocks.stone);
    	   this.addOre(DeeperBlocks.csapphireOre, world, random, x, z, 16, 16, 4, 32, 0, 255, Blocks.stone);
    	   this.addOre(DeeperBlocks.caquamarineOre, world, random, x, z, 16, 16, 9, 40, 0, 255, Blocks.stone);
    	   this.addOre(DeeperBlocks.csilverOre, world, random, x, z, 16, 16, 4, 32, 0, 255, Blocks.stone);
    	   this.addOre(DeeperBlocks.crubyOre, world, random, x, z, 16, 16, 5, 35, 0, 255, Blocks.stone);
           
       }
       private void generateBedrockPlains(World world, Random random, int x, int z)
       {
    	   
    	   this.addOre(DeeperBlocks.fragmentedBedrock, world, random, x, z, 16, 16, 8, 4, 150, 255, Blocks.bedrock);
           
       }
       private void generateNearNether(World world, Random random, int x, int z)
       {
    	   
    	   this.addOre(Blocks.netherrack, world, random, x, z, 16, 16, 15, 180, 0, 255, Blocks.stone);
    	   this.addOre(Blocks.quartz_ore, world, random, x, z, 16, 16, 8, 55, 0, 255, Blocks.stone);
    	   this.addOre(Blocks.glowstone, world, random, x, z, 16, 16, 20, 60, 0, 255, Blocks.stone);
           
       }
       private void generateLava(World world, Random random, int x, int z)
       {
    	   this.addOre(DeeperBlocks.magmaStone, world, random, x, z, 16, 16, 40, 80, 0, 255, Blocks.stone);
    	   this.addOre(Blocks.cobblestone, world, random, x, z, 16, 16, 15, 120, 0, 255, Blocks.stone);
    	   this.addOre(DeeperBlocks.fragmentedCobble, world, random, x, z, 16, 16, 14, 80, 0, 255, Blocks.stone);
    	   this.addOre(DeeperBlocks.fragmentedBedrock, world, random, x, z, 16, 16, 8, 55, 0, 255, Blocks.stone);
    	   this.addOre(Blocks.flowing_lava, world, random, x, z, 16, 16, 1, 65, 0, 255, Blocks.stone);
		   this.addOre(DeeperBlocks.incenditeOre, world, random, x, z, 16, 16, 3, 4, 0, 50, Blocks.stone);

           
       }
       private void generateNearVoid(World world, Random random, int x, int z)
       {
    	   
    	   this.addOre(DeeperBlocks.tenebriumOre, world, random, x, z, 16, 16, 8, 8, 0, 255, Blocks.stone);
           
       }
       private void generateDeepWorld(World world, Random random, int x, int z)
       {
    	   
    	   this.addOre(Blocks.coal_ore, world, random, x, z, 16, 16, 15, 160, 0, 255, Blocks.stone);
    	   this.addOre(Blocks.iron_ore, world, random, x, z, 16, 16, 10, 130, 0, 255, Blocks.stone);
    	   this.addOre(Blocks.gold_ore, world, random, x, z, 16, 16, 8, 30, 0, 255, Blocks.stone);
    	   this.addOre(Blocks.lapis_ore, world, random, x, z, 16, 16, 7, 35, 0, 255, Blocks.stone);
    	   this.addOre(Blocks.redstone_ore, world, random, x, z, 16, 16, 8, 108, 0, 255, Blocks.stone);
    	   this.addOre(Blocks.diamond_ore, world, random, x, z, 16, 16, 8, 13, 0, 255, Blocks.stone);
    	   this.addOre(Blocks.emerald_ore, world, random, x, z, 16, 16, 3, 8, 0, 255, Blocks.stone);
           
       }
       private void generateDarkness(World world, Random random, int x, int z)
       {
    	   
    	   this.addOre(DeeperBlocks.ddcoalOre, world, random, x, z, 16, 16, 15, 80, 0, 255, DeeperBlocks.darkStone);
    	   this.addOre(DeeperBlocks.ddironOre, world, random, x, z, 16, 16, 10, 65, 0, 255, DeeperBlocks.darkStone);
    	   this.addOre(DeeperBlocks.ddgoldOre, world, random, x, z, 16, 16, 8, 15, 0, 255, DeeperBlocks.darkStone);
    	   this.addOre(DeeperBlocks.ddlapisOre, world, random, x, z, 16, 16, 7, 18, 0, 255, DeeperBlocks.darkStone);
    	   this.addOre(DeeperBlocks.ddredstoneOre, world, random, x, z, 16, 16, 8, 54, 0, 255, DeeperBlocks.darkStone);
    	   this.addOre(DeeperBlocks.dddiamondOre, world, random, x, z, 16, 16, 8, 7, 0, 255, DeeperBlocks.darkStone);
    	   this.addOre(DeeperBlocks.ddemeraldOre, world, random, x, z, 16, 16, 3, 4, 0, 255, DeeperBlocks.darkStone);
    	   
    	   this.addOre(DeeperBlocks.vesperiteOre, world, random, x, z, 16, 16, 6, 80, 0, 255, DeeperBlocks.darkStone);
    	   
           
       }
       
       private void generateAbandonedCaves(World world, Random random, int x, int z)
       {
    	   
    	   this.addOre(DeeperBlocks.dcoalOre, world, random, x, z, 16, 16, 15, 80, 0, 255, DeeperBlocks.abandonedStone);
    	   this.addOre(DeeperBlocks.dironOre, world, random, x, z, 16, 16, 10, 65, 0, 255, DeeperBlocks.abandonedStone);
    	   this.addOre(DeeperBlocks.dgoldOre, world, random, x, z, 16, 16, 8, 15, 0, 255, DeeperBlocks.abandonedStone);
    	   this.addOre(DeeperBlocks.dlapisOre, world, random, x, z, 16, 16, 7, 18, 0, 255, DeeperBlocks.abandonedStone);
    	   this.addOre(DeeperBlocks.dredstoneOre, world, random, x, z, 16, 16, 8, 54, 0, 255, DeeperBlocks.abandonedStone);
    	   this.addOre(DeeperBlocks.ddiamondOre, world, random, x, z, 16, 16, 8, 7, 0, 255, DeeperBlocks.abandonedStone);
    	   this.addOre(DeeperBlocks.demeraldOre, world, random, x, z, 16, 16, 3, 4, 0, 255, DeeperBlocks.abandonedStone);
    	   
    	   if (random.nextInt(6) == 0) //TODO tweak?
           {
               int i = x + random.nextInt(16) + 8;
               int j = z + random.nextInt(16) + 8;
               int k = random.nextInt(60);
               (new CaveVillage()).generate(world, random, i, k, j);
           }
           
       }
       
       private void generateMutation(World world, Random random, int x, int z)
       {
    	   this.addOre(DeeperBlocks.dpcoalOre, world, random, x, z, 16, 16, 15, 80, 0, 255, DeeperBlocks.deepStone);
    	   this.addOre(DeeperBlocks.dpironOre, world, random, x, z, 16, 16, 10, 65, 0, 255, DeeperBlocks.deepStone);
    	   this.addOre(DeeperBlocks.dpgoldOre, world, random, x, z, 16, 16, 8, 15, 0, 255, DeeperBlocks.deepStone);
    	   this.addOre(DeeperBlocks.dplapisOre, world, random, x, z, 16, 16, 7, 18, 0, 255, DeeperBlocks.deepStone);
    	   this.addOre(DeeperBlocks.dpredstoneOre, world, random, x, z, 16, 16, 8, 54, 0, 255, DeeperBlocks.deepStone);
    	   this.addOre(DeeperBlocks.dpdiamondOre, world, random, x, z, 16, 16, 8, 7, 0, 255, DeeperBlocks.deepStone);
    	   this.addOre(DeeperBlocks.dpemeraldOre, world, random, x, z, 16, 16, 3, 4, 0, 255, DeeperBlocks.deepStone);
    	   for(int i = 0; i<13; i++)
    	   {
    		   this.addOre(DeeperBlocks.crystal, i, world, random, x, z, 16, 16, 8, 4, 0, 255, DeeperBlocks.deepStone);
    	   }
       }
       
       private void generateFarVoid(World world, Random random, int x, int z)
       {
    	   
    	   this.addOre(DeeperBlocks.dccoalOre, world, random, x, z, 16, 16, 15, 4, 220, 235, DeeperBlocks.deepStone);
    	   this.addOre(DeeperBlocks.dcironOre, world, random, x, z, 16, 16, 10, 2, 220, 235, DeeperBlocks.deepStone);
    	   this.addOre(DeeperBlocks.dcgoldOre, world, random, x, z, 16, 16, 8, 1, 220, 235, DeeperBlocks.deepStone);
    	   this.addOre(DeeperBlocks.dclapisOre, world, random, x, z, 16, 16, 7, 1, 220, 235, DeeperBlocks.deepStone);
    	   this.addOre(DeeperBlocks.dcredstoneOre, world, random, x, z, 16, 16, 8, 1, 220, 235, DeeperBlocks.deepStone);
    	   this.addOre(DeeperBlocks.dcdiamondOre, world, random, x, z, 16, 16, 8, 1, 220, 235, DeeperBlocks.deepStone);
    	   this.addOre(DeeperBlocks.dcemeraldOre, world, random, x, z, 16, 16, 3, 1, 220, 235, DeeperBlocks.deepStone);
    	   this.addOre(Blocks.obsidian, world, random, x, z, 16, 16, 15, 3, 220, 255, DeeperBlocks.deepStone);
    	   this.addOre(DeeperBlocks.cooledObsidian, world, random, x, z, 16, 16, 15, 3, 220, 255, DeeperBlocks.deepStone);
    	   this.addOre(DeeperBlocks.heatedObsidian, world, random, x, z, 16, 16, 15, 3, 220, 255, DeeperBlocks.deepStone);
    	   this.addOre(Blocks.end_stone, world, random, x, z, 16, 16, 15, 1, 128, 255, DeeperBlocks.deepStone);
    	   this.addOre(DeeperBlocks.dcsapphireOre, world, random, x, z, 16, 16, 4, 32, 0, 255, DeeperBlocks.deepStone);
    	   this.addOre(DeeperBlocks.dcaquamarineOre, world, random, x, z, 16, 16, 9, 40, 0, 255, DeeperBlocks.deepStone);
    	   this.addOre(DeeperBlocks.dcsilverOre, world, random, x, z, 16, 16, 4, 32, 0, 255, DeeperBlocks.deepStone);
    	   this.addOre(DeeperBlocks.dcrubyOre, world, random, x, z, 16, 16, 5, 35, 0, 255, DeeperBlocks.deepStone);
           
       }
       
       private void generateForgotten(World world, Random random, int x, int z)
       {
    	   this.addOre(DeeperBlocks.dpcoalOre, world, random, x, z, 16, 16, 15, 80, 0, 255, DeeperBlocks.deepStone);
    	   this.addOre(DeeperBlocks.dpironOre, world, random, x, z, 16, 16, 10, 65, 0, 255, DeeperBlocks.deepStone);
    	   this.addOre(DeeperBlocks.dpgoldOre, world, random, x, z, 16, 16, 8, 15, 0, 255, DeeperBlocks.deepStone);
    	   this.addOre(DeeperBlocks.dplapisOre, world, random, x, z, 16, 16, 7, 18, 0, 255, DeeperBlocks.deepStone);
    	   this.addOre(DeeperBlocks.dpredstoneOre, world, random, x, z, 16, 16, 8, 54, 0, 255, DeeperBlocks.deepStone);
    	   this.addOre(DeeperBlocks.dpdiamondOre, world, random, x, z, 16, 16, 8, 7, 0, 255, DeeperBlocks.deepStone);
    	   this.addOre(DeeperBlocks.dpemeraldOre, world, random, x, z, 16, 16, 3, 4, 0, 255, DeeperBlocks.deepStone);
    	   this.addOre(DeeperBlocks.evanesciteOre, world, random, x, z, 16, 16, 6, 180, 0, 255, DeeperBlocks.deepStone);
		   this.addOre(DeeperBlocks.profundiumOre, world, random, x, z, 16, 16, 6, 90, 0, 255, DeeperBlocks.deepStone);
       }
       
       private void generateEvil(World world, Random random, int x, int z)
       {
    	   this.addOre(DeeperBlocks.soulStone, world, random, x, z, 16, 16, 25, 180, 0, 255, DeeperBlocks.deepStone);
    	   this.addOre(DeeperBlocks.corruptedSoulStone, world, random, x, z, 16, 16, 16, 120, 0, 255, DeeperBlocks.deepStone);
    	   this.addOre(DeeperBlocks.cryingObsidian, world, random, x, z, 16, 16, 14, 92, 0, 255, DeeperBlocks.deepStone);
    	   this.addOre(DeeperBlocks.prisciumOre, world, random, x, z, 16, 16, 6, 67, 0, 255, DeeperBlocks.deepStone);
		   this.addOre(DeeperBlocks.profundiumOre, world, random, x, z, 16, 16, 3, 50, 0, 255, DeeperBlocks.deepStone);
       }
       
       
       private void generateFinalLabyrinth(World world, Random random, int x, int z)
       { 
    	   this.addOre(DeeperBlocks.forgottenGemstoneOre, world, random, x, z, 16, 16, 4, 50, 0, 255, DeeperBlocks.fragmentedBedrock); 
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
       public void addOre(Block block, int meta, World world, Random random, int x, int z, int maxX, int maxZ, int maxVeinSize, int chancesToSpawn, int minY, int maxY, Block generateIn)
       {
             int heightRange = maxY - minY;             
             WorldGenMinable worldgenminable = new WorldGenMinable(block, meta, maxVeinSize, generateIn);
             for (int k1 = 0; k1 < chancesToSpawn; ++k1)
             {
                 int l1 = random.nextInt(16);
                 int i2 = random.nextInt(heightRange) + minY;
                 int j2 = random.nextInt(16);
                 worldgenminable.generate(world, random, x+l1, i2, z+j2);
             }
       }
}
       
       
       
       
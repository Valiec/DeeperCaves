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
import net.minecraft.world.gen.feature.WorldGenLiquids;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenSpikes;
import net.minecraft.world.gen.structure.MapGenVillage;
import net.minecraftforge.event.terraingen.TerrainGen;
import cpw.mods.fml.common.IWorldGenerator;
import cpw.mods.fml.common.registry.GameRegistry;

import java.util.Date;

import com.kpabr.DeeperCaves.structure.StructureCaveVillage;
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
    	   
    	   this.addOre(DeeperCaves.blocks.silverOre, world, random, x, z, 16, 16, 4, 32, 0, 255, Blocks.stone);
    	   this.addOre(DeeperCaves.blocks.rubyOre, world, random, x, z, 16, 16, 5, 35, 0, 255, Blocks.stone);
           
       }
       private void generateCrystal(World world, Random random, int x, int z)
       {
    	   
    	   this.addOre(DeeperCaves.blocks.sapphireOre, world, random, x, z, 16, 16, 4, 32, 0, 255, Blocks.stone);
    	   this.addOre(DeeperCaves.blocks.aquamarineOre, world, random, x, z, 16, 16, 9, 40, 0, 255, Blocks.stone);
    	   this.addOre(DeeperCaves.blocks.ametrineOre, world, random, x, z, 16, 16, 12, 4, 0, 255, Blocks.stone);
    	   
    	   for(int i = 0; i<13; i++)
    	   {
    		   this.addOre(DeeperCaves.blocks.crystal, i, world, random, x, z, 16, 16, 15, 6, 0, 255, Blocks.stone);
    	   }
           
       }
       private void generateCompressed(World world, Random random, int x, int z)
       {
    	   
    	   this.addOre(DeeperCaves.blocks.ccoalOre, world, random, x, z, 16, 16, 15, 160, 0, 255, Blocks.stone);
    	   this.addOre(DeeperCaves.blocks.cironOre, world, random, x, z, 16, 16, 10, 130, 0, 255, Blocks.stone);
    	   this.addOre(DeeperCaves.blocks.cgoldOre, world, random, x, z, 16, 16, 8, 30, 0, 255, Blocks.stone);
    	   this.addOre(DeeperCaves.blocks.clapisOre, world, random, x, z, 16, 16, 7, 35, 0, 255, Blocks.stone);
    	   this.addOre(DeeperCaves.blocks.credstoneOre, world, random, x, z, 16, 16, 8, 108, 0, 255, Blocks.stone);
    	   this.addOre(DeeperCaves.blocks.cdiamondOre, world, random, x, z, 16, 16, 8, 13, 0, 255, Blocks.stone);
    	   this.addOre(DeeperCaves.blocks.cemeraldOre, world, random, x, z, 16, 16, 3, 8, 0, 255, Blocks.stone);
    	   this.addOre(DeeperCaves.blocks.csapphireOre, world, random, x, z, 16, 16, 4, 32, 0, 255, Blocks.stone);
    	   this.addOre(DeeperCaves.blocks.caquamarineOre, world, random, x, z, 16, 16, 9, 40, 0, 255, Blocks.stone);
    	   this.addOre(DeeperCaves.blocks.csilverOre, world, random, x, z, 16, 16, 4, 32, 0, 255, Blocks.stone);
    	   this.addOre(DeeperCaves.blocks.crubyOre, world, random, x, z, 16, 16, 5, 35, 0, 255, Blocks.stone);
           
       }
       private void generateBedrockPlains(World world, Random random, int x, int z)
       {
    	   
    	   this.addOre(DeeperCaves.blocks.fragmentedBedrock, world, random, x, z, 16, 16, 8, 4, 150, 255, Blocks.bedrock);
           
       }
       private void generateNearNether(World world, Random random, int x, int z)
       {
    	   
    	   this.addOre(Blocks.netherrack, world, random, x, z, 16, 16, 15, 180, 0, 255, Blocks.stone);
    	   this.addOre(Blocks.quartz_ore, world, random, x, z, 16, 16, 8, 55, 0, 255, Blocks.stone);
    	   this.addOre(Blocks.glowstone, world, random, x, z, 16, 16, 20, 60, 0, 255, Blocks.stone);
           
       }
       private void generateLava(World world, Random random, int x, int z)
       {
    	   this.addOre(DeeperCaves.blocks.magmaStone, world, random, x, z, 16, 16, 40, 80, 0, 255, Blocks.stone);
    	   this.addOre(Blocks.cobblestone, world, random, x, z, 16, 16, 15, 120, 0, 255, Blocks.stone);
    	   this.addOre(DeeperCaves.blocks.fragmentedCobble, world, random, x, z, 16, 16, 14, 80, 0, 255, Blocks.stone);
    	   this.addOre(Blocks.bedrock, world, random, x, z, 16, 16, 8, 55, 0, 255, Blocks.stone);
    	   this.addOre(Blocks.flowing_lava, world, random, x, z, 16, 16, 1, 65, 0, 255, Blocks.stone);
		   this.addOre(DeeperBlocks.incenditeOre, world, random, x, z, 16, 16, 3, 4, 0, 50, Blocks.stone);

           
       }
       private void generateNearVoid(World world, Random random, int x, int z)
       {
    	   
    	   this.addOre(DeeperCaves.blocks.tenebriumOre, world, random, x, z, 16, 16, 8, 8, 0, 255, Blocks.stone);
           
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
    	   
    	   this.addOre(DeeperCaves.blocks.ddcoalOre, world, random, x, z, 16, 16, 15, 80, 0, 255, DeeperCaves.blocks.darkStone);
    	   this.addOre(DeeperCaves.blocks.ddironOre, world, random, x, z, 16, 16, 10, 65, 0, 255, DeeperCaves.blocks.darkStone);
    	   this.addOre(DeeperCaves.blocks.ddgoldOre, world, random, x, z, 16, 16, 8, 15, 0, 255, DeeperCaves.blocks.darkStone);
    	   this.addOre(DeeperCaves.blocks.ddlapisOre, world, random, x, z, 16, 16, 7, 18, 0, 255, DeeperCaves.blocks.darkStone);
    	   this.addOre(DeeperCaves.blocks.ddredstoneOre, world, random, x, z, 16, 16, 8, 54, 0, 255, DeeperCaves.blocks.darkStone);
    	   this.addOre(DeeperCaves.blocks.dddiamondOre, world, random, x, z, 16, 16, 8, 7, 0, 255, DeeperCaves.blocks.darkStone);
    	   this.addOre(DeeperCaves.blocks.ddemeraldOre, world, random, x, z, 16, 16, 3, 4, 0, 255, DeeperCaves.blocks.darkStone);
    	   
    	   this.addOre(DeeperCaves.blocks.vesperiteOre, world, random, x, z, 16, 16, 6, 80, 0, 255, DeeperCaves.blocks.darkStone);
    	   
           
       }
       
       private void generateAbandonedCaves(World world, Random random, int x, int z)
       {
    	   
    	   this.addOre(DeeperCaves.blocks.dcoalOre, world, random, x, z, 16, 16, 15, 80, 0, 255, DeeperCaves.blocks.abandonedStone);
    	   this.addOre(DeeperCaves.blocks.dironOre, world, random, x, z, 16, 16, 10, 65, 0, 255, DeeperCaves.blocks.abandonedStone);
    	   this.addOre(DeeperCaves.blocks.dgoldOre, world, random, x, z, 16, 16, 8, 15, 0, 255, DeeperCaves.blocks.abandonedStone);
    	   this.addOre(DeeperCaves.blocks.dlapisOre, world, random, x, z, 16, 16, 7, 18, 0, 255, DeeperCaves.blocks.abandonedStone);
    	   this.addOre(DeeperCaves.blocks.dredstoneOre, world, random, x, z, 16, 16, 8, 54, 0, 255, DeeperCaves.blocks.abandonedStone);
    	   this.addOre(DeeperCaves.blocks.ddiamondOre, world, random, x, z, 16, 16, 8, 7, 0, 255, DeeperCaves.blocks.abandonedStone);
    	   this.addOre(DeeperCaves.blocks.demeraldOre, world, random, x, z, 16, 16, 3, 4, 0, 255, DeeperCaves.blocks.abandonedStone);
    	   
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
    	   this.addOre(DeeperCaves.blocks.dpcoalOre, world, random, x, z, 16, 16, 15, 80, 0, 255, DeeperCaves.blocks.deepStone);
    	   this.addOre(DeeperCaves.blocks.dpironOre, world, random, x, z, 16, 16, 10, 65, 0, 255, DeeperCaves.blocks.deepStone);
    	   this.addOre(DeeperCaves.blocks.dpgoldOre, world, random, x, z, 16, 16, 8, 15, 0, 255, DeeperCaves.blocks.deepStone);
    	   this.addOre(DeeperCaves.blocks.dplapisOre, world, random, x, z, 16, 16, 7, 18, 0, 255, DeeperCaves.blocks.deepStone);
    	   this.addOre(DeeperCaves.blocks.dpredstoneOre, world, random, x, z, 16, 16, 8, 54, 0, 255, DeeperCaves.blocks.deepStone);
    	   this.addOre(DeeperCaves.blocks.dpdiamondOre, world, random, x, z, 16, 16, 8, 7, 0, 255, DeeperCaves.blocks.deepStone);
    	   this.addOre(DeeperCaves.blocks.dpemeraldOre, world, random, x, z, 16, 16, 3, 4, 0, 255, DeeperCaves.blocks.deepStone);
    	   for(int i = 0; i<13; i++)
    	   {
    		   this.addOre(DeeperCaves.blocks.crystal, i, world, random, x, z, 16, 16, 8, 4, 0, 255, DeeperCaves.blocks.deepStone);
    	   }
       }
       
       private void generateFarVoid(World world, Random random, int x, int z)
       {
    	   
    	   this.addOre(DeeperCaves.blocks.dccoalOre, world, random, x, z, 16, 16, 15, 4, 220, 235, DeeperCaves.blocks.deepStone);
    	   this.addOre(DeeperCaves.blocks.dcironOre, world, random, x, z, 16, 16, 10, 2, 220, 235, DeeperCaves.blocks.deepStone);
    	   this.addOre(DeeperCaves.blocks.dcgoldOre, world, random, x, z, 16, 16, 8, 1, 220, 235, DeeperCaves.blocks.deepStone);
    	   this.addOre(DeeperCaves.blocks.dclapisOre, world, random, x, z, 16, 16, 7, 1, 220, 235, DeeperCaves.blocks.deepStone);
    	   this.addOre(DeeperCaves.blocks.dcredstoneOre, world, random, x, z, 16, 16, 8, 1, 220, 235, DeeperCaves.blocks.deepStone);
    	   this.addOre(DeeperCaves.blocks.dcdiamondOre, world, random, x, z, 16, 16, 8, 1, 220, 235, DeeperCaves.blocks.deepStone);
    	   this.addOre(DeeperCaves.blocks.dcemeraldOre, world, random, x, z, 16, 16, 3, 1, 220, 235, DeeperCaves.blocks.deepStone);
    	   this.addOre(Blocks.obsidian, world, random, x, z, 16, 16, 15, 3, 220, 255, DeeperCaves.blocks.deepStone);
    	   this.addOre(DeeperCaves.blocks.cooledObsidian, world, random, x, z, 16, 16, 15, 3, 220, 255, DeeperCaves.blocks.deepStone);
    	   this.addOre(DeeperCaves.blocks.heatedObsidian, world, random, x, z, 16, 16, 15, 3, 220, 255, DeeperCaves.blocks.deepStone);
    	   this.addOre(Blocks.end_stone, world, random, x, z, 16, 16, 15, 1, 128, 255, DeeperCaves.blocks.deepStone);
    	   this.addOre(DeeperCaves.blocks.dcsapphireOre, world, random, x, z, 16, 16, 4, 32, 0, 255, DeeperCaves.blocks.deepStone);
    	   this.addOre(DeeperCaves.blocks.dcaquamarineOre, world, random, x, z, 16, 16, 9, 40, 0, 255, DeeperCaves.blocks.deepStone);
    	   this.addOre(DeeperCaves.blocks.dcsilverOre, world, random, x, z, 16, 16, 4, 32, 0, 255, DeeperCaves.blocks.deepStone);
    	   this.addOre(DeeperCaves.blocks.dcrubyOre, world, random, x, z, 16, 16, 5, 35, 0, 255, DeeperCaves.blocks.deepStone);
           
       }
       
       private void generateForgotten(World world, Random random, int x, int z)
       {
    	   this.addOre(DeeperCaves.blocks.dpcoalOre, world, random, x, z, 16, 16, 15, 80, 0, 255, DeeperCaves.blocks.deepStone);
    	   this.addOre(DeeperCaves.blocks.dpironOre, world, random, x, z, 16, 16, 10, 65, 0, 255, DeeperCaves.blocks.deepStone);
    	   this.addOre(DeeperCaves.blocks.dpgoldOre, world, random, x, z, 16, 16, 8, 15, 0, 255, DeeperCaves.blocks.deepStone);
    	   this.addOre(DeeperCaves.blocks.dplapisOre, world, random, x, z, 16, 16, 7, 18, 0, 255, DeeperCaves.blocks.deepStone);
    	   this.addOre(DeeperCaves.blocks.dpredstoneOre, world, random, x, z, 16, 16, 8, 54, 0, 255, DeeperCaves.blocks.deepStone);
    	   this.addOre(DeeperCaves.blocks.dpdiamondOre, world, random, x, z, 16, 16, 8, 7, 0, 255, DeeperCaves.blocks.deepStone);
    	   this.addOre(DeeperCaves.blocks.dpemeraldOre, world, random, x, z, 16, 16, 3, 4, 0, 255, DeeperCaves.blocks.deepStone);
    	   this.addOre(DeeperCaves.blocks.evanesciteOre, world, random, x, z, 16, 16, 6, 180, 0, 255, DeeperCaves.blocks.deepStone);
		   this.addOre(DeeperBlocks.prisciumOre, world, random, x, z, 16, 16, 6, 90, 0, 255, DeeperCaves.blocks.deepStone);
       }
       
       private void generateEvil(World world, Random random, int x, int z)
       {
    	   this.addOre(DeeperCaves.blocks.soulStone, world, random, x, z, 16, 16, 25, 180, 0, 255, DeeperCaves.blocks.deepStone);
    	   this.addOre(DeeperCaves.blocks.corruptedSoulStone, world, random, x, z, 16, 16, 16, 120, 0, 255, DeeperCaves.blocks.deepStone);
    	   this.addOre(DeeperCaves.blocks.cryingObsidian, world, random, x, z, 16, 16, 14, 92, 0, 255, DeeperCaves.blocks.deepStone);
    	   this.addOre(DeeperCaves.blocks.profundiumOre, world, random, x, z, 16, 16, 6, 67, 0, 255, DeeperCaves.blocks.deepStone);
		   this.addOre(DeeperBlocks.prisciumOre, world, random, x, z, 16, 16, 3, 50, 0, 255, DeeperCaves.blocks.deepStone);
       }
       
       
       private void generateFinalLabyrinth(World world, Random random, int x, int z)
       { 
    	   this.addOre(DeeperCaves.blocks.forgottenGemstoneOre, world, random, x, z, 16, 16, 4, 50, 0, 255, DeeperCaves.blocks.fragmentedBedrock); 
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
       
       
       
       
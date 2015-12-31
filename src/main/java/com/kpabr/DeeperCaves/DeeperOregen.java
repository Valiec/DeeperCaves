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
             switch(world.provider.dimensionId)
             {
					case 22:
							generateFinalLabyrinth(world, random, chunkX * 16, chunkZ * 16);
							break;
					case 19:
							generateFarVoid(world, random, chunkX * 16, chunkZ * 16);
							break;
					case 17:
							generateAbandonedCaves(world, random, chunkX * 16, chunkZ * 16);
							break;
					case 16:
							generateDarkness(world, random, chunkX * 16, chunkZ * 16);
							break;
					case 15:
  							generateDeepWorld(world, random, chunkX * 16, chunkZ * 16);
  							break;
      				case 14:
      						generateNearVoid(world, random, chunkX * 16, chunkZ * 16);
      						break;
      				case 13:
 							generateLava(world, random, chunkX * 16, chunkZ * 16);
 							break;
             		case 12:
             				generateNearNether(world, random, chunkX * 16, chunkZ * 16);
             				break;
		            case 11:
		             		generateBedrockPlains(world, random, chunkX * 16, chunkZ * 16);
		             		break;
		            case 10:
		             		generateCompressed(world, random, chunkX * 16, chunkZ * 16);
		             		break;		
		            case 9:
		             		generateCrystal(world, random, chunkX * 16, chunkZ * 16);
		             		break;		
                    case 8:
                    		generateMaze(world, random, chunkX * 16, chunkZ * 16);
                    		break;
                    case 7: 
                    		generateDrop(world, random, chunkX * 16, chunkZ * 16);
                    		break;
                    case 0:
                    		generateOverworld(world, random, chunkX * 16, chunkZ * 16);
                    		break;
                    default: generateDefault(world, random, chunkX * 16, chunkZ * 16);
             }
       }
      
       private void generateOverworld(World world, Random random, int x, int z)
       {
    	   //this.addOre(Blocks.air, world, random, x, z, 16, 16, 8, 4, 0, 6, Blocks.bedrock);
    	   //this.addOre(DeeperCaves.blocks.dropPortal, world, random, x, z, 16, 16, 8, 16, 0, 6, Blocks.air);

       }
       
       private void generateDefault(World world, Random random, int x, int z)
       {
    	   //this.addOre(DeeperCaves.blocks.dropPortal, world, random, x, z, 16, 16, 8, 4, 0, 16, Blocks.stone);

       }

       private void generateDrop(World world, Random random, int x, int z)
       {
    	   
    	   this.addOre(Blocks.gold_ore, world, random, x, z, 16, 16, 16, 8, 0, 256, Blocks.stone);
    	   this.addOre(Blocks.diamond_ore, world, random, x, z, 16, 16, 12, 2, 0, 256, Blocks.stone);
    	   this.addOre(Blocks.emerald_ore, world, random, x, z, 16, 16, 8, 1, 0, 256, Blocks.stone);
    	   //this.addOre(DeeperCaves.blocks.mazePortal, world, random, x, z, 16, 16, 8, 4, 0, 16, Blocks.stone);
    	   //this.addOre(DeeperCaves.blocks.returnPortal, world, random, x, z, 16, 16, 8, 4, 239, 255, Blocks.stone);
           
       }
       private void generateMaze(World world, Random random, int x, int z)
       {
    	   
    	   //this.addOre(DeeperCaves.blocks.crystalPortal, world, random, x, z, 16, 16, 8, 4, 0, 16, Blocks.stone);
    	   //this.addOre(DeeperCaves.blocks.dropPortal, world, random, x, z, 16, 16, 8, 4, 239, 255, Blocks.stone);
    	   this.addOre(DeeperCaves.blocks.silverOre, world, random, x, z, 16, 16, 4, 32, 0, 255, Blocks.stone);
           
       }
       private void generateCrystal(World world, Random random, int x, int z)
       {
    	   
    	   //this.addOre(DeeperCaves.blocks.compressedPortal, world, random, x, z, 16, 16, 8, 4, 0, 16, Blocks.stone);
    	   //this.addOre(DeeperCaves.blocks.mazePortal, world, random, x, z, 16, 16, 8, 4, 239, 255, Blocks.stone);
    	   this.addOre(DeeperCaves.blocks.sapphireOre, world, random, x, z, 16, 16, 4, 32, 0, 255, Blocks.stone);
    	   this.addOre(DeeperCaves.blocks.aquamarineOre, world, random, x, z, 16, 16, 9, 40, 0, 255, Blocks.stone);
    	   this.addOre(DeeperCaves.blocks.ametrineOre, world, random, x, z, 16, 16, 12, 4, 0, 255, Blocks.stone);
           
       }
       private void generateCompressed(World world, Random random, int x, int z)
       {
    	   
    	   //this.addOre(DeeperCaves.blocks.bedrockPlainsPortal, world, random, x, z, 16, 16, 8, 4, 0, 16, Blocks.stone);
    	   //this.addOre(DeeperCaves.blocks.crystalPortal, world, random, x, z, 16, 16, 8, 4, 239, 255, Blocks.stone);
    	   this.addOre(DeeperCaves.blocks.ccoalOre, world, random, x, z, 16, 16, 15, 160, 0, 255, Blocks.stone);
    	   this.addOre(DeeperCaves.blocks.cironOre, world, random, x, z, 16, 16, 10, 130, 0, 255, Blocks.stone);
    	   this.addOre(DeeperCaves.blocks.cgoldOre, world, random, x, z, 16, 16, 8, 30, 0, 255, Blocks.stone);
    	   this.addOre(DeeperCaves.blocks.clapisOre, world, random, x, z, 16, 16, 7, 35, 0, 255, Blocks.stone);
    	   this.addOre(DeeperCaves.blocks.credstoneOre, world, random, x, z, 16, 16, 8, 108, 0, 255, Blocks.stone);
    	   this.addOre(DeeperCaves.blocks.cdiamondOre, world, random, x, z, 16, 16, 8, 13, 0, 255, Blocks.stone);
    	   this.addOre(DeeperCaves.blocks.cemeraldOre, world, random, x, z, 16, 16, 3, 8, 0, 255, Blocks.stone);
           
       }
       private void generateBedrockPlains(World world, Random random, int x, int z)
       {
    	   
    	   //this.addOre(DeeperCaves.blocks.returnPortal, world, random, x, z, 16, 16, 4, 1, 150, 160, Blocks.bedrock);
    	   //this.addOre(DeeperCaves.blocks.compressedPortal, world, random, x, z, 16, 16, 8, 4, 239, 255, Blocks.bedrock);
    	   this.addOre(DeeperCaves.blocks.fragmentedBedrock, world, random, x, z, 16, 16, 8, 4, 150, 255, Blocks.bedrock);
           
       }
       private void generateNearNether(World world, Random random, int x, int z)
       {
    	   
    	   //this.addOre(DeeperCaves.blocks.returnPortal, world, random, x, z, 16, 16, 4, 1, 150, 160, Blocks.bedrock);
    	   //this.addOre(DeeperCaves.blocks.compressedPortal, world, random, x, z, 16, 16, 8, 4, 239, 255, Blocks.bedrock);
    	   this.addOre(Blocks.netherrack, world, random, x, z, 16, 16, 15, 180, 0, 255, Blocks.stone);
    	   this.addOre(Blocks.quartz_ore, world, random, x, z, 16, 16, 8, 55, 0, 255, Blocks.stone);
           
       }
       private void generateLava(World world, Random random, int x, int z)
       {
    	   /*for (int var3 = 0; var3 < 40; ++var3)
   			{
   		    int var4 = x + random.nextInt(16) + 8;
   		    int var5 = random.nextInt(240) + 16;
   		    int var6 = z + random.nextInt(16) + 8;
   		    System.out.println("GEN-ER-ATE!");
   		    (new WorldGenLiquids(Blocks.flowing_lava)).generate(world, random, var4, var5, var6);
   			}*/
    	   //this.addOre(DeeperCaves.blocks.returnPortal, world, random, x, z, 16, 16, 4, 1, 150, 160, Blocks.bedrock);
    	   //this.addOre(DeeperCaves.blocks.compressedPortal, world, random, x, z, 16, 16, 8, 4, 239, 255, Blocks.bedrock);
    	   this.addOre(Blocks.cobblestone, world, random, x, z, 16, 16, 15, 180, 0, 255, Blocks.stone);
    	   this.addOre(Blocks.bedrock, world, random, x, z, 16, 16, 8, 55, 0, 255, Blocks.stone);
    	   this.addOre(Blocks.flowing_lava, world, random, x, z, 16, 16, 1, 65, 0, 255, Blocks.stone);
           
       }
       private void generateNearVoid(World world, Random random, int x, int z)
       {
    	   
    	   //this.addOre(DeeperCaves.blocks.returnPortal, world, random, x, z, 16, 16, 4, 1, 150, 160, Blocks.bedrock);
    	   //this.addOre(DeeperCaves.blocks.compressedPortal, world, random, x, z, 16, 16, 8, 4, 239, 255, Blocks.bedrock);
    	   //this.addOre(Blocks.netherrack, world, random, x, z, 16, 16, 15, 180, 0, 255, Blocks.stone);
    	   this.addOre(DeeperCaves.blocks.tenebriumOre, world, random, x, z, 16, 16, 8, 8, 0, 255, Blocks.stone);
           
       }
       private void generateDeepWorld(World world, Random random, int x, int z)
       {
    	   
    	   //this.addOre(DeeperCaves.blocks.returnPortal, world, random, x, z, 16, 16, 4, 1, 150, 160, Blocks.bedrock);
    	   //this.addOre(DeeperCaves.blocks.compressedPortal, world, random, x, z, 16, 16, 8, 4, 239, 255, Blocks.bedrock);
    	   //this.addOre(Blocks.netherrack, world, random, x, z, 16, 16, 15, 180, 0, 255, Blocks.stone);
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
    	   
    	   //this.addOre(DeeperCaves.blocks.returnPortal, world, random, x, z, 16, 16, 4, 1, 150, 160, Blocks.bedrock);
    	   //this.addOre(DeeperCaves.blocks.compressedPortal, world, random, x, z, 16, 16, 8, 4, 239, 255, Blocks.bedrock);
    	   this.addOre(DeeperCaves.blocks.ddcoalOre, world, random, x, z, 16, 16, 15, 80, 0, 255, DeeperCaves.blocks.darkStone); //FIX TO USE DARKSTONE!!!
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
    	   
    	   //this.addOre(DeeperCaves.blocks.returnPortal, world, random, x, z, 16, 16, 4, 1, 150, 160, Blocks.bedrock);
    	   //this.addOre(DeeperCaves.blocks.compressedPortal, world, random, x, z, 16, 16, 8, 4, 239, 255, Blocks.bedrock);
    	   //this.addOre(Blocks.netherrack, world, random, x, z, 16, 16, 15, 180, 0, 255, Blocks.stone);
    	   this.addOre(DeeperCaves.blocks.dcoalOre, world, random, x, z, 16, 16, 15, 80, 0, 255, DeeperCaves.blocks.abandonedStone); //FIX TO USE DARKSTONE!!!
    	   this.addOre(DeeperCaves.blocks.dironOre, world, random, x, z, 16, 16, 10, 65, 0, 255, DeeperCaves.blocks.abandonedStone);
    	   this.addOre(DeeperCaves.blocks.dgoldOre, world, random, x, z, 16, 16, 8, 15, 0, 255, DeeperCaves.blocks.abandonedStone);
    	   this.addOre(DeeperCaves.blocks.dlapisOre, world, random, x, z, 16, 16, 7, 18, 0, 255, DeeperCaves.blocks.abandonedStone);
    	   this.addOre(DeeperCaves.blocks.dredstoneOre, world, random, x, z, 16, 16, 8, 54, 0, 255, DeeperCaves.blocks.abandonedStone);
    	   this.addOre(DeeperCaves.blocks.ddiamondOre, world, random, x, z, 16, 16, 8, 7, 0, 255, DeeperCaves.blocks.abandonedStone);
    	   this.addOre(DeeperCaves.blocks.demeraldOre, world, random, x, z, 16, 16, 3, 4, 0, 255, DeeperCaves.blocks.abandonedStone);
    	   
    	   //this.addOre(DeeperCaves.blocks.vesperiteOre, world, random, x, z, 16, 16, 6, 108, 0, 255, DeeperCaves.blocks.darkStone);
    	   if (random.nextInt(20) == 0)
           {
               int i = x + random.nextInt(16) + 8;
               int j = z + random.nextInt(16) + 8;
               int k = random.nextInt(80);
               System.out.println("i: "+Integer.toString(i)+", j: "+Integer.toString(j)+", k: "+Integer.toString(k));
               (new CaveVillage()).generate(world, random, i, k, j);
           }
           
       }
       
       private void generateFarVoid(World world, Random random, int x, int z)
       {
    	   
    	   //this.addOre(DeeperCaves.blocks.bedrockPlainsPortal, world, random, x, z, 16, 16, 8, 4, 0, 16, Blocks.stone);
    	   //this.addOre(DeeperCaves.blocks.crystalPortal, world, random, x, z, 16, 16, 8, 4, 239, 255, Blocks.stone);
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
           
       }

       private void generateFinalLabyrinth(World world, Random random, int x, int z)
       {
    	   
    	   //this.addOre(DeeperCaves.blocks.returnPortal, world, random, x, z, 16, 16, 4, 1, 150, 160, Blocks.bedrock);
    	   //this.addOre(DeeperCaves.blocks.compressedPortal, world, random, x, z, 16, 16, 8, 4, 239, 255, Blocks.bedrock);
    	   //this.addOre(Blocks.netherrack, world, random, x, z, 16, 16, 15, 180, 0, 255, Blocks.stone);
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
}
       
       
       
       
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
       
       
       
       
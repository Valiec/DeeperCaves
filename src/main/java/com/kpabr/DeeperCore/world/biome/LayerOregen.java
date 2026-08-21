package com.kpabr.DeeperCore.world.biome;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.event.terraingen.OreGenEvent;
import net.minecraftforge.event.terraingen.TerrainGen;

public class LayerOregen
{
       public static void addOre(Block block, World world, Random random, int x, int z, int maxX, int maxZ, int maxVeinSize, int chancesToSpawn, int minY, int maxY, Block generateIn)
       {
             int heightRange = maxY - minY;
             WorldGenMinable worldgenminable = new WorldGenMinable(block, maxVeinSize, generateIn);
             if(TerrainGen.generateOre(world, random, worldgenminable, x, z, OreGenEvent.GenerateMinable.EventType.CUSTOM)) {
                 for (int k1 = 0; k1 < chancesToSpawn; ++k1) {
                     int l1 = random.nextInt(16);
                     int i2 = random.nextInt(heightRange) + minY;
                     int j2 = random.nextInt(16);
                     worldgenminable.generate(world, random, x + l1, i2, z + j2);
                 }
             }
       }
       public static void addOre(Block block, int meta, World world, Random random, int x, int z, int maxX, int maxZ, int maxVeinSize, int chancesToSpawn, int minY, int maxY, Block generateIn)
       {
             int heightRange = maxY - minY;             
             WorldGenMinable worldgenminable = new WorldGenMinable(block, meta, maxVeinSize, generateIn);
             if(TerrainGen.generateOre(world, random, worldgenminable, x, z, OreGenEvent.GenerateMinable.EventType.CUSTOM)) {
               for (int k1 = 0; k1 < chancesToSpawn; ++k1) {
                   int l1 = random.nextInt(16);
                   int i2 = random.nextInt(heightRange) + minY;
                   int j2 = random.nextInt(16);
                   worldgenminable.generate(world, random, x + l1, i2, z + j2);
               }
           }
       }
}
       
       
       
       
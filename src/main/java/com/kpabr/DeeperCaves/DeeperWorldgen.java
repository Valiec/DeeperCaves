package com.kpabr.DeeperCaves;

import java.lang.reflect.Field;
import java.util.ArrayList;

import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.WorldServer;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.ChunkProviderEnd;
import net.minecraft.world.gen.ChunkProviderGenerate;
import net.minecraft.world.gen.ChunkProviderHell;
import net.minecraft.world.gen.ChunkProviderServer;
import net.minecraft.world.gen.feature.WorldGenLiquids;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.GenLayerBiome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.event.terraingen.ChunkProviderEvent;
import net.minecraftforge.event.terraingen.PopulateChunkEvent;
import net.minecraftforge.event.terraingen.ChunkProviderEvent.ReplaceBiomeBlocks;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.eventhandler.Event.Result;
import cpw.mods.fml.common.registry.GameRegistry;

public class DeeperWorldgen {
    /*World Generator Declaration*/
    DeeperOregen deeperblock = new DeeperOregen();
    public int dropDimID = 7;
    public int mazeDimID = 8;
    public int crystalDimID = 9;
    public int compressedDimID = 10;
    public int bedrockPlainsDimID = 11;
    
    public int nearNetherDimID = 12;
    public int lavaDimID = 13;
    public int nearVoidDimID = 14;
    
    public int deepWorldDimID = 15;
    public int darknessDimID = 16;
    public int abandonedCavesDimID = 17;
    public int mutationDimID = 18;
    public int farVoidDimID = 19;
    
    public int forgottenDimID = 10;
    public int evilDimID = 21;
    public int finalLabyrinthDimID = 22;    
    public BiomeGenDrop biomeDrop;
    public BiomeGenMaze biomeMaze;
    public BiomeGenCrystal biomeCrystal;
    public BiomeGenCompressed biomeCompressed;
    public BiomeGenBedrockPlains biomeBedrockPlains;
    public BiomeGenFinalLabyrinth biomeFinalLabyrinth;
    
    public BiomeGenNearNether biomeNearNether;
    //public BiomeGenLava biomeLava;
    public BiomeGenNearVoid biomeNearVoid;
    public BiomeGenDeepWorld biomeDeepWorld;
    public void setupWorldgen()
    {
        
       
        /*Setting up worldgen*/
        DimensionManager.registerProviderType(dropDimID, WorldProviderDrop.class, true);
        DimensionManager.registerDimension(dropDimID, dropDimID);
        DimensionManager.registerProviderType(mazeDimID, WorldProviderMaze.class, true);
        DimensionManager.registerDimension(mazeDimID, mazeDimID);
        DimensionManager.registerProviderType(crystalDimID, WorldProviderCrystal.class, true);
        DimensionManager.registerDimension(crystalDimID, crystalDimID);
        DimensionManager.registerProviderType(compressedDimID, WorldProviderCompressed.class, true);
        DimensionManager.registerDimension(compressedDimID, compressedDimID);
        DimensionManager.registerProviderType(bedrockPlainsDimID, WorldProviderBedrockPlains.class, true);
        DimensionManager.registerDimension(bedrockPlainsDimID, bedrockPlainsDimID);
        
        DimensionManager.registerProviderType(nearNetherDimID, WorldProviderNearNether.class, true);
        DimensionManager.registerDimension(nearNetherDimID, nearNetherDimID);
        //DimensionManager.registerProviderType(lavaDimID, WorldProviderLava.class, true);
        //DimensionManager.registerDimension(lavaDimID, lavaDimID);
        DimensionManager.registerProviderType(nearVoidDimID, WorldProviderNearVoid.class, true);
        DimensionManager.registerDimension(nearVoidDimID, nearVoidDimID);
        DimensionManager.registerProviderType(deepWorldDimID, WorldProviderDeepWorld.class, true);
        DimensionManager.registerDimension(deepWorldDimID, deepWorldDimID);
        
        DimensionManager.registerProviderType(finalLabyrinthDimID, WorldProviderFinalLabyrinth.class, true);
        DimensionManager.registerDimension(finalLabyrinthDimID, finalLabyrinthDimID);
        GameRegistry.registerWorldGenerator(deeperblock, 1);
        this.biomeDrop = new BiomeGenDrop(80, 0);
        BiomeEntry dropEntry = new BiomeEntry(this.biomeDrop, 50);
        BiomeDictionary.registerBiomeType(this.biomeDrop, Type.PLAINS);
        BiomeManager.addSpawnBiome(this.biomeDrop);
        this.biomeMaze = new BiomeGenMaze(81, 0);
        BiomeEntry mazeEntry = new BiomeEntry(this.biomeMaze, 50);
        BiomeDictionary.registerBiomeType(this.biomeMaze, Type.PLAINS);
        BiomeManager.addSpawnBiome(this.biomeMaze);
        this.biomeCrystal = new BiomeGenCrystal(82, 0);
        BiomeEntry crystalEntry = new BiomeEntry(this.biomeCrystal, 50);
        BiomeDictionary.registerBiomeType(this.biomeCrystal, Type.PLAINS);
        BiomeManager.addSpawnBiome(this.biomeCrystal);
        this.biomeCompressed = new BiomeGenCompressed(83, 0);
        BiomeEntry compressedEntry = new BiomeEntry(this.biomeCompressed, 50);
        BiomeDictionary.registerBiomeType(this.biomeCompressed, Type.PLAINS);
        BiomeManager.addSpawnBiome(this.biomeCompressed);
        this.biomeBedrockPlains = new BiomeGenBedrockPlains(84, 0);
        BiomeEntry bedrockPlainsEntry = new BiomeEntry(this.biomeBedrockPlains, 50);
        BiomeDictionary.registerBiomeType(this.biomeBedrockPlains, Type.PLAINS);
        BiomeManager.addSpawnBiome(this.biomeBedrockPlains);
        this.biomeNearNether = new BiomeGenNearNether(85, 0);
        
        BiomeEntry nearNetherEntry = new BiomeEntry(this.biomeNearNether, 50);
        BiomeDictionary.registerBiomeType(this.biomeNearNether, Type.PLAINS);
        BiomeManager.addSpawnBiome(this.biomeNearNether);
        //this.biomeLava = new BiomeGenLava(86, 0);
        //BiomeEntry lavaEntry = new BiomeEntry(this.biomeLava, 50);
        //BiomeDictionary.registerBiomeType(this.biomeLava, Type.PLAINS);
        //BiomeManager.addSpawnBiome(this.biomeLava);
        this.biomeNearVoid = new BiomeGenNearVoid(87, 0);
        BiomeEntry nearVoidEntry = new BiomeEntry(this.biomeNearVoid, 50);
        BiomeDictionary.registerBiomeType(this.biomeNearVoid, Type.PLAINS);
        BiomeManager.addSpawnBiome(this.biomeNearVoid);
        this.biomeDeepWorld = new BiomeGenDeepWorld(88, 0);
        BiomeEntry deepWorldEntry = new BiomeEntry(this.biomeDeepWorld, 50);
        BiomeDictionary.registerBiomeType(this.biomeDeepWorld, Type.PLAINS);
        BiomeManager.addSpawnBiome(this.biomeDeepWorld);
        
        this.biomeFinalLabyrinth = new BiomeGenFinalLabyrinth(95, 0);
        BiomeEntry finalLabyrinthEntry = new BiomeEntry(this.biomeFinalLabyrinth, 50);
        BiomeDictionary.registerBiomeType(this.biomeFinalLabyrinth, Type.PLAINS);
        BiomeManager.addSpawnBiome(this.biomeFinalLabyrinth);
    }
    @SubscribeEvent
    public void onOverworldBiomes(ReplaceBiomeBlocks event)
    {
        if (event.chunkProvider.getClass() == ChunkProviderGenerate.class)
        {
            
        
            
        	//ChunkProviderGenerate gen = new ChunkProviderGenerate(DimensionManager.getWorld(0), DimensionManager.getWorld(0).getSeed(), true);


            ChunkProviderGenerateDuplicate gen = (ChunkProviderGenerateDuplicate)(new ChunkProviderGenerateDuplicate(event.world, event.world.getSeed(), true));
            event.setResult(Result.DENY);
            gen.replaceBlocksForBiome(event.chunkX, event.chunkZ, event.blockArray, event.metaArray, event.biomeArray);
        	for (int k = 0; k < 16; ++k)
            {
                for (int l = 0; l < 16; ++l)
                {
                    //BiomeGenBase biomegenbase = p_147422_5_[l + k * 16];
                    //biomegenbase.genTerrainBlocks(this.worldObj, this.rand, p_147422_3_, p_147422_4_, p_147422_1_ * 16 + k, p_147422_2_ * 16 + l, this.stoneNoise[l + k * 16]);
                    int i1 = event.chunkX * 16 + k & 15;
                    int j1 = event.chunkZ * 16 + l & 15;
                    int k1 = event.blockArray.length / 256;
                    for (int l1 = 255; l1 >= 0; --l1)
                    {
                        int i2 = (j1 * 16 + i1) * k1 + l1;

                        if (l1 <= 5 && l1 >= 0 && event.blockArray[i2] == Blocks.bedrock)
                        {
                        	event.blockArray[i2] = Blocks.stone;
                        }
                        if (l1 == 2)
                        {
                        	//event.blockArray[i2] = DeeperCaves.blocks.dropPortal;
                        }
                        if (l1 == 1)
                        {
                        	//event.blockArray[i2] = Blocks.stone;
                        }
                    }
                }
        }

    }
    
}
}

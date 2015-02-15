package com.kpabr.DeeperCaves;

import java.lang.reflect.Field;
import java.util.ArrayList;

import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.WorldServer;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.ChunkProviderEnd;
import net.minecraft.world.gen.ChunkProviderGenerate;
import net.minecraft.world.gen.ChunkProviderHell;
import net.minecraft.world.gen.ChunkProviderServer;
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
    public BiomeGenDrop biomeDrop;
    public BiomeGenMaze biomeMaze;
    public BiomeGenCrystal biomeCrystal;
    public BiomeGenCompressed biomeCompressed;
    public BiomeGenBedrockPlains biomeBedrockPlains;
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
    }
    @SubscribeEvent
    public void onOverworldBiomes(ReplaceBiomeBlocks event)
    {
        if (event.chunkProvider.getClass() == ChunkProviderGenerate.class)
        {
            
        
            ChunkProviderGenerate2 gen = (ChunkProviderGenerate2)(new ChunkProviderGenerate2(DimensionManager.getWorld(0), DimensionManager.getWorld(0).getSeed(), true));

            event.setResult(Result.DENY);
            gen.replaceBlocksForBiome(event.chunkX, event.chunkZ, event.blockArray, event.metaArray, event.biomeArray);
        }

    }
    
}

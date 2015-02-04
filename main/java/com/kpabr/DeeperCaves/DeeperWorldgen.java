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
    }
    
}

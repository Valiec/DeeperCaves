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
    public void setupWorldgen()
    {
        
       
        /*Setting up worldgen*/
        //WorldServer world = DimensionManager.getWorld(1);
        DimensionManager.registerProviderType(dropDimID, WorldProviderDrop.class, true);
        DimensionManager.registerDimension(dropDimID, dropDimID);
        //DimensionManager.registerProviderType(mazeDimID, WorldProviderEnder.class, true);
        //DimensionManager.registerDimension(mazeDimID, mazeDimID);
        GameRegistry.registerWorldGenerator(deeperblock, 1);
    }
    
    @SubscribeEvent
    public void onEndGen(ChunkProviderEvent.InitNoiseField event)
    {
        
        if (event.chunkProvider.getClass() == ChunkProviderEnd.class)
        {

            ChunkProviderEnder end = (ChunkProviderEnder)(new ChunkProviderEnder(DimensionManager.getWorld(1), DimensionManager.getWorld(1).getSeed()));
            event.setResult(Result.DENY);

            event.noisefield = end.initializeNoiseField(null, event.posX, event.posY, event.posZ, event.sizeX, event.sizeY, event.sizeZ);
    
        }  
    }
    /*@SubscribeEvent
    public void onNetherBiomes(ReplaceBiomeBlocks event)
    {
        if (event.chunkProvider.getClass() == ChunkProviderHell.class)
        {
            
        
            //ChunkProviderNether end = (ChunkProviderNether)(new ChunkProviderNether(DimensionManager.getWorld(-1), DimensionManager.getWorld(-1).getSeed()));

            event.setResult(Result.DENY);
            //end.func_147418_b(event.chunkX, event.chunkZ, event.blockArray);
        }

    }*/
    /*@SubscribeEvent
    public void onNetherDecorate(PopulateChunkEvent event)
    {
        if (event.world.provider.dimensionId == -1)
        {
            ChunkProviderDrop end = (ChunkProviderDrop)(new ChunkProviderDrop(DimensionManager.getWorld(event.world.provider.dimensionId), DimensionManager.getWorld(event.world.provider.dimensionId).getSeed(), true));

            event.setResult(Result.DENY);
            end.populate(event.chunkProvider, event.chunkX, event.chunkZ);
        }
    }*/
    /*@SubscribeEvent
    public void onEndBiomes(ReplaceBiomeBlocks event)
    {
        if (event.chunkProvider.getClass() == ChunkProviderEnd.class)
        {
            
        
            ChunkProviderEnder end = (ChunkProviderEnder)(new ChunkProviderEnder(DimensionManager.getWorld(1), DimensionManager.getWorld(1).getSeed()));

            event.setResult(Result.DENY);
            end.func_147421_b(event.chunkX, event.chunkZ, event.blockArray);
        }

    }*/
    /*@SubscribeEvent
    public void onEndDecorate(PopulateChunkEvent event)
    {
        if (event.chunkProvider.getClass() != ChunkProviderServer.class && event.world.provider.dimensionId == 1)
        {
            ChunkProviderEnder end = (ChunkProviderEnder)(new ChunkProviderEnder(DimensionManager.getWorld(1), DimensionManager.getWorld(1).getSeed()));

            event.setResult(Result.DENY);
            end.populate(event.chunkProvider, event.chunkX, event.chunkZ);
        }
    }*/
}

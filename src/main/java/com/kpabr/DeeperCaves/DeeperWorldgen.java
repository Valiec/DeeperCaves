package com.kpabr.DeeperCaves;

import java.lang.reflect.Field;
import java.util.ArrayList;

import com.kpabr.DeeperCaves.world.biome.BiomeGenAbandonedCaves;
import com.kpabr.DeeperCaves.world.biome.BiomeGenBedrockPlains;
import com.kpabr.DeeperCaves.world.biome.BiomeGenCompressed;
import com.kpabr.DeeperCaves.world.biome.BiomeGenCrystal;
import com.kpabr.DeeperCaves.world.biome.BiomeGenDarkness;
import com.kpabr.DeeperCaves.world.biome.BiomeGenDeepWorld;
import com.kpabr.DeeperCaves.world.biome.BiomeGenDrop;
import com.kpabr.DeeperCaves.world.biome.BiomeGenEvil;
import com.kpabr.DeeperCaves.world.biome.BiomeGenFarVoid;
import com.kpabr.DeeperCaves.world.biome.BiomeGenFinalLabyrinth;
import com.kpabr.DeeperCaves.world.biome.BiomeGenForgotten;
import com.kpabr.DeeperCaves.world.biome.BiomeGenLava;
import com.kpabr.DeeperCaves.world.biome.BiomeGenMaze;
import com.kpabr.DeeperCaves.world.biome.BiomeGenMutation;
import com.kpabr.DeeperCaves.world.biome.BiomeGenNearNether;
import com.kpabr.DeeperCaves.world.biome.BiomeGenNearVoid;
import com.kpabr.DeeperCaves.world.chunk.ChunkProviderGenerateDuplicate;
import com.kpabr.DeeperCaves.world.provider.WorldProviderAbandonedCaves;
import com.kpabr.DeeperCaves.world.provider.WorldProviderBedrockPlains;
import com.kpabr.DeeperCaves.world.provider.WorldProviderCompressed;
import com.kpabr.DeeperCaves.world.provider.WorldProviderCrystal;
import com.kpabr.DeeperCaves.world.provider.WorldProviderDarkness;
import com.kpabr.DeeperCaves.world.provider.WorldProviderDeepWorld;
import com.kpabr.DeeperCaves.world.provider.WorldProviderDrop;
import com.kpabr.DeeperCaves.world.provider.WorldProviderEvil;
import com.kpabr.DeeperCaves.world.provider.WorldProviderFarVoid;
import com.kpabr.DeeperCaves.world.provider.WorldProviderFinalLabyrinth;
import com.kpabr.DeeperCaves.world.provider.WorldProviderForgotten;
import com.kpabr.DeeperCaves.world.provider.WorldProviderLava;
import com.kpabr.DeeperCaves.world.provider.WorldProviderMaze;
import com.kpabr.DeeperCaves.world.provider.WorldProviderMutation;
import com.kpabr.DeeperCaves.world.provider.WorldProviderNearNether;
import com.kpabr.DeeperCaves.world.provider.WorldProviderNearVoid;

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
    public int dropDimID;
    public int mazeDimID;
    public int crystalDimID;
    public int compressedDimID;
    public int bedrockPlainsDimID;
    
    public int nearNetherDimID;
    public int lavaDimID;
    public int nearVoidDimID;
    
    public int deepWorldDimID;
    public int darknessDimID;
    public int abandonedCavesDimID;
    public int mutationDimID;
    public int farVoidDimID;
    
    public int forgottenDimID;
    public int evilDimID;
    public int finalLabyrinthDimID;    
    
    //-----------------

    public int dropBiomeID;
    public int mazeBiomeID;
    public int crystalBiomeID;
    public int compressedBiomeID;
    public int bedrockPlainsBiomeID;
    
    public int nearNetherBiomeID;
    public int lavaBiomeID;
    public int nearVoidBiomeID;
    
    public int deepWorldBiomeID;
    public int darknessBiomeID;
    public int abandonedCavesBiomeID;
    public int mutationBiomeID;
    public int farVoidBiomeID;
    
    public int forgottenBiomeID;
    public int evilBiomeID;
    public int finalLabyrinthBiomeID;    

    public BiomeGenDrop biomeDrop;
    public BiomeGenMaze biomeMaze;
    public BiomeGenCrystal biomeCrystal;
    public BiomeGenCompressed biomeCompressed;
    public BiomeGenBedrockPlains biomeBedrockPlains;
    
    public BiomeGenNearNether biomeNearNether;
    public BiomeGenLava biomeLava;
    public BiomeGenNearVoid biomeNearVoid;
    
    public BiomeGenDeepWorld biomeDeepWorld;
    public BiomeGenDarkness biomeDarkness;
    public BiomeGenAbandonedCaves biomeAbandonedCaves;
    public BiomeGenMutation biomeMutation;
    public BiomeGenFarVoid biomeFarVoid;
    
    public BiomeGenForgotten biomeForgotten;
    public BiomeGenEvil biomeEvil;
    public BiomeGenFinalLabyrinth biomeFinalLabyrinth;
    
	public int bedrockPlainsFloorHeight;
	public int bedrockPlainsCeilingHeight;
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
        DimensionManager.registerProviderType(lavaDimID, WorldProviderLava.class, true);
        DimensionManager.registerDimension(lavaDimID, lavaDimID);
        DimensionManager.registerProviderType(nearVoidDimID, WorldProviderNearVoid.class, true);
        DimensionManager.registerDimension(nearVoidDimID, nearVoidDimID);
        
        DimensionManager.registerProviderType(deepWorldDimID, WorldProviderDeepWorld.class, true);
        DimensionManager.registerDimension(deepWorldDimID, deepWorldDimID);
        DimensionManager.registerProviderType(darknessDimID, WorldProviderDarkness.class, true);
        DimensionManager.registerDimension(darknessDimID, darknessDimID);
        DimensionManager.registerProviderType(abandonedCavesDimID, WorldProviderAbandonedCaves.class, true);
        DimensionManager.registerDimension(abandonedCavesDimID, abandonedCavesDimID);

        DimensionManager.registerProviderType(mutationDimID, WorldProviderMutation.class, true);
        DimensionManager.registerDimension(mutationDimID, mutationDimID);
        
        DimensionManager.registerProviderType(farVoidDimID, WorldProviderFarVoid.class, true);
        DimensionManager.registerDimension(farVoidDimID, farVoidDimID);
        
        DimensionManager.registerProviderType(forgottenDimID, WorldProviderForgotten.class, true);
        DimensionManager.registerDimension(forgottenDimID, forgottenDimID);
        
        DimensionManager.registerProviderType(evilDimID, WorldProviderEvil.class, true);
        DimensionManager.registerDimension(evilDimID, evilDimID);
        
        DimensionManager.registerProviderType(finalLabyrinthDimID, WorldProviderFinalLabyrinth.class, true);
        DimensionManager.registerDimension(finalLabyrinthDimID, finalLabyrinthDimID);
        GameRegistry.registerWorldGenerator(deeperblock, 1);
        this.biomeDrop = new BiomeGenDrop(dropBiomeID, 0);
        BiomeEntry dropEntry = new BiomeEntry(this.biomeDrop, 50);
        BiomeDictionary.registerBiomeType(this.biomeDrop, Type.PLAINS);
        BiomeManager.addSpawnBiome(this.biomeDrop);
        this.biomeMaze = new BiomeGenMaze(mazeBiomeID, 0);
        BiomeEntry mazeEntry = new BiomeEntry(this.biomeMaze, 50);
        BiomeDictionary.registerBiomeType(this.biomeMaze, Type.PLAINS);
        BiomeManager.addSpawnBiome(this.biomeMaze);
        this.biomeCrystal = new BiomeGenCrystal(crystalBiomeID, 0);
        BiomeEntry crystalEntry = new BiomeEntry(this.biomeCrystal, 50);
        BiomeDictionary.registerBiomeType(this.biomeCrystal, Type.PLAINS);
        BiomeManager.addSpawnBiome(this.biomeCrystal);
        this.biomeCompressed = new BiomeGenCompressed(compressedBiomeID, 0);
        BiomeEntry compressedEntry = new BiomeEntry(this.biomeCompressed, 50);
        BiomeDictionary.registerBiomeType(this.biomeCompressed, Type.PLAINS);
        BiomeManager.addSpawnBiome(this.biomeCompressed);
        this.biomeBedrockPlains = new BiomeGenBedrockPlains(bedrockPlainsBiomeID, 0);
        BiomeEntry bedrockPlainsEntry = new BiomeEntry(this.biomeBedrockPlains, 50);
        BiomeDictionary.registerBiomeType(this.biomeBedrockPlains, Type.PLAINS);
        BiomeManager.addSpawnBiome(this.biomeBedrockPlains);
        this.biomeNearNether = new BiomeGenNearNether(nearNetherBiomeID, 0);
        
        BiomeEntry nearNetherEntry = new BiomeEntry(this.biomeNearNether, 50);
        BiomeDictionary.registerBiomeType(this.biomeNearNether, Type.PLAINS);
        BiomeManager.addSpawnBiome(this.biomeNearNether);
        this.biomeLava = new BiomeGenLava(lavaBiomeID, 0);
        BiomeEntry lavaEntry = new BiomeEntry(this.biomeLava, 50);
        BiomeDictionary.registerBiomeType(this.biomeLava, Type.PLAINS);
        BiomeManager.addSpawnBiome(this.biomeLava);
        this.biomeNearVoid = new BiomeGenNearVoid(nearVoidBiomeID, 0);
        BiomeEntry nearVoidEntry = new BiomeEntry(this.biomeNearVoid, 50);
        BiomeDictionary.registerBiomeType(this.biomeNearVoid, Type.PLAINS);
        BiomeManager.addSpawnBiome(this.biomeNearVoid);
        
        this.biomeDeepWorld = new BiomeGenDeepWorld(deepWorldBiomeID, 0);
        BiomeEntry deepWorldEntry = new BiomeEntry(this.biomeDeepWorld, 50);
        BiomeDictionary.registerBiomeType(this.biomeDeepWorld, Type.PLAINS);
        BiomeManager.addSpawnBiome(this.biomeDeepWorld);   
        this.biomeDarkness = new BiomeGenDarkness(darknessBiomeID, 0);
        BiomeEntry darknessEntry = new BiomeEntry(this.biomeDarkness, 50);
        BiomeDictionary.registerBiomeType(this.biomeDarkness, Type.PLAINS);
        BiomeManager.addSpawnBiome(this.biomeDarkness);
        this.biomeAbandonedCaves = new BiomeGenAbandonedCaves(abandonedCavesBiomeID, 0);
        BiomeEntry abandonedCavesEntry = new BiomeEntry(this.biomeAbandonedCaves, 50);
        BiomeDictionary.registerBiomeType(this.biomeAbandonedCaves, Type.PLAINS);
        BiomeManager.addSpawnBiome(this.biomeAbandonedCaves);
        this.biomeMutation = new BiomeGenMutation(mutationBiomeID, 0);
        BiomeEntry mutationEntry = new BiomeEntry(this.biomeMutation, 50);
        BiomeDictionary.registerBiomeType(this.biomeMutation, Type.PLAINS);
        BiomeManager.addSpawnBiome(this.biomeMutation);
        this.biomeFarVoid = new BiomeGenFarVoid(farVoidBiomeID, 0);
        BiomeEntry farVoidEntry = new BiomeEntry(this.biomeFarVoid, 50);
        BiomeDictionary.registerBiomeType(this.biomeFarVoid, Type.PLAINS);
        BiomeManager.addSpawnBiome(this.biomeFarVoid);
        
        this.biomeForgotten = new BiomeGenForgotten(forgottenBiomeID, 0);
        BiomeEntry forgottenEntry = new BiomeEntry(this.biomeForgotten, 50);
        BiomeDictionary.registerBiomeType(this.biomeForgotten, Type.PLAINS);
        BiomeManager.addSpawnBiome(this.biomeForgotten);
        this.biomeEvil = new BiomeGenEvil(evilBiomeID, 0);
        BiomeEntry evilEntry = new BiomeEntry(this.biomeEvil, 50);
        BiomeDictionary.registerBiomeType(this.biomeEvil, Type.PLAINS);
        BiomeManager.addSpawnBiome(this.biomeEvil);
        this.biomeFinalLabyrinth = new BiomeGenFinalLabyrinth(finalLabyrinthBiomeID, 0);
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
                    }
                }
        }

    }
    
}
}

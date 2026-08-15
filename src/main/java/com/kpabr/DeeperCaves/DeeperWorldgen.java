package com.kpabr.DeeperCaves;

import com.kpabr.DeeperCaves.world.DeeperLayer;
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
import com.kpabr.DeeperCaves.world.chunk.*;
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
import net.minecraft.world.gen.ChunkProviderGenerate;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.event.terraingen.ChunkProviderEvent.ReplaceBiomeBlocks;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.eventhandler.Event.Result;
import cpw.mods.fml.common.registry.GameRegistry;

public class DeeperWorldgen {
    /*World Generator Declaration*/
    DeeperOregen deeperblock = new DeeperOregen();

    public DeeperLayer drop;
    public DeeperLayer maze;
    public DeeperLayer crystal;
    public DeeperLayer compressed;
    public DeeperLayer bedrockPlains;

    public DeeperLayer nearNether;
    public DeeperLayer lava;
    public DeeperLayer nearVoid;

    public DeeperLayer deepWorld;
    public DeeperLayer darkness;
    public DeeperLayer abandonedCaves;
    public DeeperLayer mutation;
    public DeeperLayer farVoid;

    public DeeperLayer forgotten;
    public DeeperLayer evil;
    public DeeperLayer finalLabyrinth;

    public void setupWorldgen()
    {

        this.drop = new DeeperLayer("Drop", DeeperConfig.dropDimID).setLayerBounds(0, 202).setUpperArrivalRange(12)
                .setChunkProvider(ChunkProviderDrop.class).setWorldProvider(WorldProviderDrop.class)
                .setBiome(new BiomeGenDrop(DeeperConfig.dropBiomeID, 0), Type.PLAINS);

        this.maze = new DeeperLayer("Maze", DeeperConfig.mazeDimID).setLayerBounds(0, 202).setUpperArrivalRange(12)
                .setChunkProvider(ChunkProviderMaze.class).setWorldProvider(WorldProviderMaze.class)
                .setBiome(new BiomeGenMaze(DeeperConfig.mazeBiomeID, 0), Type.PLAINS);

        this.crystal = new DeeperLayer("Crystal", DeeperConfig.crystalDimID).setLayerBounds(0, 152).setUpperArrivalRange(12)
                .setChunkProvider(ChunkProviderCrystal.class).setWorldProvider(WorldProviderCrystal.class)
                .setBiome(new BiomeGenCrystal(DeeperConfig.crystalBiomeID, 0), Type.PLAINS);

        this.compressed = new DeeperLayer("Compressed", DeeperConfig.compressedDimID).setLayerBounds(0, 102).setUpperArrivalRange(12)
                .setChunkProvider(ChunkProviderCompressed.class).setWorldProvider(WorldProviderCompressed.class)
                .setBiome(new BiomeGenCompressed(DeeperConfig.compressedBiomeID, 0), Type.PLAINS);

        this.bedrockPlains = new DeeperLayer("Bedrock Plains", DeeperConfig.bedrockPlainsDimID).setLayerBounds(0, DeeperConfig.bedrockPlainsCeilingHeight+8)
                .setUpperArrivalBounds(DeeperConfig.bedrockPlainsFloorHeight-8, DeeperConfig.bedrockPlainsCeilingHeight+3)
                .setLowerArrivalBounds(DeeperConfig.bedrockPlainsFloorHeight-8, DeeperConfig.bedrockPlainsCeilingHeight+3)
                .setUpperArrivalRange(12).setChunkProvider(ChunkProviderBedrockPlains.class).setWorldProvider(WorldProviderBedrockPlains.class)
                .setBiome(new BiomeGenBedrockPlains(DeeperConfig.bedrockPlainsBiomeID, 0), Type.PLAINS).setStoneBlock(DeeperBlocks.fragmentedBedrock);

        this.nearNether = new DeeperLayer("Near Nether", DeeperConfig.nearNetherDimID).setLayerBounds(0, 102).setUpperArrivalRange(7)
                .setChunkProvider(ChunkProviderNearNether.class).setWorldProvider(WorldProviderNearNether.class)
                .setBiome(new BiomeGenNearNether(DeeperConfig.nearNetherBiomeID, 0), Type.PLAINS);

        this.lava = new DeeperLayer("Lava", DeeperConfig.lavaDimID).setLayerBounds(0, 52).setUpperArrivalRange(7)
                .setChunkProvider(ChunkProviderLava.class).setWorldProvider(WorldProviderLava.class)
                .setBiome(new BiomeGenLava(DeeperConfig.lavaBiomeID, 0), Type.PLAINS);

        this.nearVoid = new DeeperLayer("Near Void", DeeperConfig.nearVoidDimID).setLayerBounds(120, 247)
                .setUpperArrivalBounds(235, 242).setLowerArrivalBounds(235, 242)
                .setChunkProvider(ChunkProviderNearVoid.class).setWorldProvider(WorldProviderNearVoid.class)
                .setBiome(new BiomeGenNearVoid(DeeperConfig.nearVoidBiomeID, 0), Type.PLAINS);

        this.deepWorld = new DeeperLayer("Deep World", DeeperConfig.deepWorldDimID).setLayerBounds(0, 77).setUpperArrivalRange(7)
                .setChunkProvider(ChunkProviderDeepWorld.class).setWorldProvider(WorldProviderDeepWorld.class)
                .setBiome(new BiomeGenDeepWorld(DeeperConfig.deepWorldBiomeID, 0), Type.PLAINS);

        this.darkness = new DeeperLayer("Darkness", DeeperConfig.darknessDimID).setLayerBounds(0, 247).setUpperArrivalRange(12)
                .setChunkProvider(ChunkProviderDarkness.class).setWorldProvider(WorldProviderDarkness.class)
                .setBiome(new BiomeGenDarkness(DeeperConfig.darknessBiomeID, 0), Type.PLAINS).setStoneBlock(DeeperBlocks.darkStone);

        this.abandonedCaves = new DeeperLayer("Abandoned Caves", DeeperConfig.abandonedCavesDimID).setLayerBounds(0, 102).setUpperArrivalRange(7)
                .setChunkProvider(ChunkProviderAbandonedCaves.class).setWorldProvider(WorldProviderAbandonedCaves.class)
                .setBiome(new BiomeGenAbandonedCaves(DeeperConfig.abandonedCavesBiomeID, 0), Type.PLAINS).setStoneBlock(DeeperBlocks.abandonedStone);

        this.mutation = new DeeperLayer("Mutation", DeeperConfig.mutationDimID).setLayerBounds(0, 102).setUpperArrivalRange(7)
                .setChunkProvider(ChunkProviderMutation.class).setWorldProvider(WorldProviderMutation.class)
                .setBiome(new BiomeGenMutation(DeeperConfig.mutationBiomeID, 0), Type.PLAINS).setStoneBlock(DeeperBlocks.deepStone);

        this.farVoid = new DeeperLayer("Far Void", DeeperConfig.farVoidDimID).setLayerBounds(120, 247)
                .setUpperArrivalBounds(235, 242).setLowerArrivalBounds(235, 242)
                .setChunkProvider(ChunkProviderFarVoid.class).setWorldProvider(WorldProviderFarVoid.class)
                .setBiome(new BiomeGenFarVoid(DeeperConfig.farVoidBiomeID, 0), Type.PLAINS).setStoneBlock(DeeperBlocks.deepStone);

        this.forgotten = new DeeperLayer("Forgotten", DeeperConfig.forgottenDimID).setLayerBounds(0, 232).setUpperArrivalRange(42)
                .setChunkProvider(ChunkProviderForgotten.class).setWorldProvider(WorldProviderForgotten.class)
                .setBiome(new BiomeGenForgotten(DeeperConfig.forgottenBiomeID, 0), Type.PLAINS).setStoneBlock(DeeperBlocks.deepStone);

        this.evil = new DeeperLayer("Evil", DeeperConfig.evilDimID).setLayerBounds(0, 102).setUpperArrivalRange(7)
                .setChunkProvider(ChunkProviderEvil.class).setWorldProvider(WorldProviderEvil.class)
                .setBiome(new BiomeGenEvil(DeeperConfig.evilBiomeID, 0), Type.PLAINS).setStoneBlock(DeeperBlocks.deepStone);

        this.finalLabyrinth = new DeeperLayer("Final Labyrinth", DeeperConfig.finalLabyrinthDimID).setLayerBounds(0, 247).setUpperArrivalRange(57)
                .setChunkProvider(ChunkProviderFinalLabyrinth.class).setWorldProvider(WorldProviderFinalLabyrinth.class)
                .setBiome(new BiomeGenFinalLabyrinth(DeeperConfig.finalLabyrinthBiomeID, 0), Type.PLAINS).setStoneBlock(DeeperBlocks.fragmentedBedrock);

        DeeperLayer.registerAllLayers();

        /*Setting up worldgen*/
        GameRegistry.registerWorldGenerator(deeperblock, 1);
    }
    @SubscribeEvent
    public void onOverworldBiomes(ReplaceBiomeBlocks event)
    {
        if (event.chunkProvider.getClass() == ChunkProviderGenerate.class)
        {

            ChunkProviderGenerateDuplicate gen = new ChunkProviderGenerateDuplicate(event.world, event.world.getSeed(), true);
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

                        if (l1 <= 5 && event.blockArray[i2] == Blocks.bedrock)
                        {
                        	event.blockArray[i2] = Blocks.stone;
                        }
                    }
                }
        }

    }
    
}
}

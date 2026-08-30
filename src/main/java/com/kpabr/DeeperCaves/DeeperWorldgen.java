package com.kpabr.DeeperCaves;

import com.kpabr.DeeperCore.dimstack.DeeperLayer;
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

import com.kpabr.DeeperCore.world.biome.LayerOregen;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraft.init.Blocks;
import net.minecraft.world.gen.ChunkProviderGenerate;
import net.minecraftforge.event.terraingen.ChunkProviderEvent.ReplaceBiomeBlocks;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.eventhandler.Event.Result;
import net.minecraftforge.event.terraingen.PopulateChunkEvent;

public class DeeperWorldgen {
    /*World Generator Declaration*/
    LayerOregen deeperblock = new LayerOregen();

    public DeeperLayer surface;

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

    public static BiomeDictionary.Type deeperCavesType = BiomeDictionary.Type.getType("DEEPERCAVES");

    public static boolean farVoidCheck(EntityPlayerMP player, boolean lower) {
        if(lower) {
            return true;
        }
        return (DeeperCaves.instance.voidFlag.get(player.getUniqueID()) != null) ? DeeperCaves.instance.voidFlag.get(player.getUniqueID()) : false;
    }

    public double getTotalDepth(int dimID, double dimY)
    {
        if(dimID ==  this.surface.dimID)
        {
            return dimY;
        }
        else {
            return (-1 * DeeperLayer.getTotalDepth(dimID, dimY, this.drop));
        }
    }

    public void setupWorldgen()
    {

        this.surface = new DeeperLayer("Overworld", 0).setLayerBounds(0, 255);

        this.drop = new DeeperLayer("Drop", DeeperConfig.dropDimID).setLayerBounds(0, 202).setUpperArrivalRange(12)
                .setChunkProvider(ChunkProviderDrop.class).setWorldProvider(WorldProviderDrop.class)
                .setBiome(new BiomeGenDrop(DeeperConfig.dropBiomeID), deeperCavesType);

        this.maze = new DeeperLayer("Maze", DeeperConfig.mazeDimID).setLayerBounds(0, 202).setUpperArrivalRange(12)
                .setChunkProvider(ChunkProviderMaze.class).setWorldProvider(WorldProviderMaze.class)
                .setBiome(new BiomeGenMaze(DeeperConfig.mazeBiomeID), deeperCavesType);

        this.crystal = new DeeperLayer("Crystal", DeeperConfig.crystalDimID).setLayerBounds(0, 152).setUpperArrivalRange(12)
                .setChunkProvider(ChunkProviderCrystal.class).setWorldProvider(WorldProviderCrystal.class)
                .setBiome(new BiomeGenCrystal(DeeperConfig.crystalBiomeID), deeperCavesType);

        this.compressed = new DeeperLayer("Compressed", DeeperConfig.compressedDimID).setLayerBounds(0, 102).setUpperArrivalRange(12)
                .setChunkProvider(ChunkProviderCompressed.class).setWorldProvider(WorldProviderCompressed.class)
                .setBiome(new BiomeGenCompressed(DeeperConfig.compressedBiomeID), deeperCavesType);

        this.bedrockPlains = new DeeperLayer("Bedrock Plains", DeeperConfig.bedrockPlainsDimID).setLayerBounds(0, DeeperConfig.bedrockPlainsCeilingHeight+8)
                .setUpperArrivalBounds(DeeperConfig.bedrockPlainsFloorHeight-8, DeeperConfig.bedrockPlainsCeilingHeight+3)
                .setLowerArrivalBounds(DeeperConfig.bedrockPlainsFloorHeight-8, DeeperConfig.bedrockPlainsCeilingHeight+3)
                .setUpperArrivalRange(12).setChunkProvider(ChunkProviderBedrockPlains.class).setWorldProvider(WorldProviderBedrockPlains.class)
                .setBiome(new BiomeGenBedrockPlains(DeeperConfig.bedrockPlainsBiomeID), deeperCavesType).setStoneBlock(DeeperBlocks.fragmentedBedrock);

        this.nearNether = new DeeperLayer("Near Nether", DeeperConfig.nearNetherDimID).setLayerBounds(0, 102).setUpperArrivalRange(7)
                .setChunkProvider(ChunkProviderNearNether.class).setWorldProvider(WorldProviderNearNether.class)
                .setBiome(new BiomeGenNearNether(DeeperConfig.nearNetherBiomeID), deeperCavesType).setStoneBlock(DeeperBlocks.deepStone);

        this.lava = new DeeperLayer("Lava", DeeperConfig.lavaDimID).setLayerBounds(0, 52).setUpperArrivalRange(7)
                .setChunkProvider(ChunkProviderLava.class).setWorldProvider(WorldProviderLava.class)
                .setBiome(new BiomeGenLava(DeeperConfig.lavaBiomeID), deeperCavesType).setStoneBlock(DeeperBlocks.deepStone);

        this.nearVoid = new DeeperLayer("Near Void", DeeperConfig.nearVoidDimID).setLayerBounds(220, 247)
                .setTPTriggerBounds(120, 245).setUpperArrivalBounds(235, 242).setLowerArrivalBounds(235, 242)
                .setChunkProvider(ChunkProviderNearVoid.class).setWorldProvider(WorldProviderNearVoid.class)
                .setBiome(new BiomeGenNearVoid(DeeperConfig.nearVoidBiomeID), deeperCavesType).setStoneBlock(DeeperBlocks.deepStone);

        this.deepWorld = new DeeperLayer("Deep World", DeeperConfig.deepWorldDimID).setLayerBounds(0, 77).setUpperArrivalRange(7)
                .setChunkProvider(ChunkProviderDeepWorld.class).setWorldProvider(WorldProviderDeepWorld.class)
                .setBiome(new BiomeGenDeepWorld(DeeperConfig.deepWorldBiomeID), deeperCavesType).setStoneBlock(DeeperBlocks.abandonedStone);

        this.abandonedCaves = new DeeperLayer("Abandoned Caves", DeeperConfig.abandonedCavesDimID).setLayerBounds(0, 207).setUpperArrivalRange(12)
                .setChunkProvider(ChunkProviderAbandonedCaves.class).setWorldProvider(WorldProviderAbandonedCaves.class)
                .setBiome(new BiomeGenAbandonedCaves(DeeperConfig.abandonedCavesBiomeID), deeperCavesType).setStoneBlock(DeeperBlocks.abandonedStone);

        this.darkness = new DeeperLayer("Darkness", DeeperConfig.darknessDimID).setLayerBounds(0, 152).setUpperArrivalRange(7)
                .setChunkProvider(ChunkProviderDarkness.class).setWorldProvider(WorldProviderDarkness.class)
                .setBiome(new BiomeGenDarkness(DeeperConfig.darknessBiomeID), deeperCavesType).setStoneBlock(DeeperBlocks.darkStone);

        this.mutation = new DeeperLayer("Mutation", DeeperConfig.mutationDimID).setLayerBounds(0, 102).setUpperArrivalRange(7)
                .setChunkProvider(ChunkProviderMutation.class).setWorldProvider(WorldProviderMutation.class)
                .setBiome(new BiomeGenMutation(DeeperConfig.mutationBiomeID), deeperCavesType).setStoneBlock(DeeperBlocks.darkStone);

        this.farVoid = new DeeperLayer("Far Void", DeeperConfig.farVoidDimID).setLayerBounds(220, 247)
                .setTPTriggerBounds(120, 245).setUpperArrivalBounds(235, 242).setLowerArrivalBounds(235, 242)
                .setChunkProvider(ChunkProviderFarVoid.class).setWorldProvider(WorldProviderFarVoid.class)
                .setBiome(new BiomeGenFarVoid(DeeperConfig.farVoidBiomeID), deeperCavesType).setStoneBlock(DeeperBlocks.darkStone)
                .setExitCheck(DeeperWorldgen::farVoidCheck);

        this.forgotten = new DeeperLayer("Forgotten", DeeperConfig.forgottenDimID).setLayerBounds(0, 232).setUpperArrivalRange(42)
                .setChunkProvider(ChunkProviderForgotten.class).setWorldProvider(WorldProviderForgotten.class)
                .setBiome(new BiomeGenForgotten(DeeperConfig.forgottenBiomeID), deeperCavesType).setStoneBlock(DeeperBlocks.forgottenStone);

        this.evil = new DeeperLayer("Evil", DeeperConfig.evilDimID).setLayerBounds(0, 102).setUpperArrivalRange(7)
                .setChunkProvider(ChunkProviderEvil.class).setWorldProvider(WorldProviderEvil.class)
                .setBiome(new BiomeGenEvil(DeeperConfig.evilBiomeID), deeperCavesType).setStoneBlock(DeeperBlocks.forgottenStone);

        this.finalLabyrinth = new DeeperLayer("Final Labyrinth", DeeperConfig.finalLabyrinthDimID).setLayerBounds(0, 247).setUpperArrivalRange(57)
                .setChunkProvider(ChunkProviderFinalLabyrinth.class).setWorldProvider(WorldProviderFinalLabyrinth.class)
                .setBiome(new BiomeGenFinalLabyrinth(DeeperConfig.finalLabyrinthBiomeID), deeperCavesType).setStoneBlock(DeeperBlocks.fragmentedBedrock);

        DeeperLayer.registerAllLayers();

        String prevName = null;

        for(String levelName: DeeperConfig.levelOrder) {
            if(prevName != null) {
                DeeperLayer.layerNames.get(levelName).insertAfter(DeeperLayer.layerNames.get(prevName));
            }
            prevName = levelName;
        }

        /*Setting up worldgen*/
        //GameRegistry.registerWorldGenerator(deeperblock, 1);
    }
    @SubscribeEvent
    public void onOverworldBiomes(PopulateChunkEvent.Post event)
    {

        if (event.world.provider.dimensionId == DeeperCaves.worldgen.surface.dimID)
        {
        	for (int x = 0; x < 16; ++x)
            {
                for (int z = 0; z < 16; ++z)
                {
                    for (int y = 5; y >= 0; --y)
                    {
                        if (event.world.getBlock(event.chunkX * 16 + x, y, event.chunkZ * 16 + z) == Blocks.bedrock)
                        {
                        	event.world.setBlock(event.chunkX * 16 + x, y, event.chunkZ * 16 + z, Blocks.stone, 0, 2);
                        }
                    }
                }
        }

    }
    
}
}

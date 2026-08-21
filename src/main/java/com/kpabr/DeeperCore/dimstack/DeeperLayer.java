package com.kpabr.DeeperCore.dimstack;

import com.kpabr.DeeperCore.world.WorldProviderDeeperBase;
import com.kpabr.DeeperCore.world.WorldProviderDeeperCaves;
import com.kpabr.DeeperCore.world.chunk.ChunkProviderDeeperBase;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.DimensionManager;

import java.util.*;
import java.util.function.BiPredicate;

public class DeeperLayer {

    public static List<DeeperLayer> deeperLayers = new ArrayList<DeeperLayer>();

    private static int curSeedOffset = 1;

    public int seedOffset;

    public int minY;
    public int maxY;

    public int tpTriggerLower;
    public int tpTriggerUpper;

    public int arrivalCapLower;
    public int arrivalMinLower;

    public int arrivalCapUpper;
    public int arrivalMinUpper;

    public Block stoneBlock;

    public DeeperLayer prevLayer;
    public DeeperLayer nextLayer;

    public int dimID;

    //public List<DeeperBiomeInfo> biomes;

    DeeperBiomeInfo biomeData;

    public BiPredicate<EntityPlayerMP, Boolean> canExitFrom;

    //public QuadConsumer<World, Random, Integer, Integer> generateOres;

    public static Map<String, DeeperLayer> layerNames = new HashMap<String, DeeperLayer>();

    public BiomeGenBase biome;

    public Class<? extends IChunkProvider> chunkProvider;
    public Class<? extends WorldProvider> worldProvider;
    public String layerName;

    public int lowerArrivalRange = 15;
    public int upperArrivalRange = 7;

    public static void registerAllLayers() {
        for(DeeperLayer layer : DeeperLayer.deeperLayers) {
            layer.registerDimension();
            layer.registerBiomes();
        }
    }

    public DeeperLayer(String layerName) {
        this.seedOffset = curSeedOffset;
        curSeedOffset++;
        this.layerName = layerName;
        this.setLayerBounds(0, 255);
        this.setStoneBlock(Blocks.stone);
        deeperLayers.add(this);
    }

    public DeeperLayer(String layerName, int dimID) {
        this(layerName);
        layerNames.put(layerName, this);
        this.setDimID(dimID);
    }

    public DeeperLayer setWorldProvider(Class<? extends WorldProviderDeeperCaves> worldProvider) {
        this.worldProvider = worldProvider;
        return this;
    }

    public DeeperLayer insertAfter(DeeperLayer otherLayer) {
        if(otherLayer.nextLayer != null) {
            this.nextLayer = otherLayer.nextLayer;
        }
        this.prevLayer = otherLayer;
        otherLayer.nextLayer = this;
        return this;
    }

    public DeeperLayer insertBefore(DeeperLayer otherLayer) {
        if(otherLayer.prevLayer != null) {
            this.prevLayer = otherLayer.prevLayer;
        }
        this.nextLayer = otherLayer;
        otherLayer.prevLayer = this;
        return this;
    }

    public DeeperLayer setExitCheck(BiPredicate<EntityPlayerMP, Boolean> checkFunc) {
        this.canExitFrom = checkFunc;
        return this;
    }

    //public DeeperLayer setOreGeneration(QuadConsumer<World, Random, Integer, Integer> oreGen) {
    //    this.generateOres = oreGen;
    //    return this;
    //}

    //public DeeperLayer addBiome(Class<? extends BiomeGenBase> biomeGen, int biomeID, BiomeManager.BiomeType biomeType) {
   //     this.biomes.add(new DeeperBiomeInfo(biomeID, biomeGen, biomeType));
   //     return this;
   // }

    public DeeperLayer setBiome(BiomeGenBase biomeGen, BiomeDictionary.Type biomeType) {
        this.biomeData = new DeeperBiomeInfo(biomeGen, biomeType);
        this.biome = biomeGen;
        return this;
    }

    public DeeperLayer registerBiomes() {
        if(this.biomeData != null) {
            this.biomeData.register();
        }
        return this;
    }

    public DeeperLayer registerDimension() {
        if(this.worldProvider != null) {
            DimensionManager.registerProviderType(this.dimID, this.worldProvider, false);
            DimensionManager.registerDimension(this.dimID, this.dimID);
        }
        return this;
    }

    public DeeperLayer setChunkProvider(Class<? extends ChunkProviderDeeperBase> chunkProvider) {
        this.chunkProvider = chunkProvider;
        return this;
    }

    public DeeperLayer setDimID(int dimID) {
        this.dimID = dimID;
        return this;
    }

    public DeeperLayer setStoneBlock(Block stoneBlock) {
        this.stoneBlock = stoneBlock;
        return this;
    }

    public DeeperLayer setLayerBounds(int minY, int maxY) {
        this.minY = minY;
        this.maxY = maxY;

        this.setTPTriggerBounds(minY, maxY-2);
        computeUpperArrivalBounds();
        computeLowerArrivalBounds();

        return this;
    }

    public DeeperLayer setTPTriggerBounds(int lower, int upper) {
        this.tpTriggerUpper = upper;
        this.tpTriggerLower = lower;
        return this;
    }

    public DeeperLayer setUpperArrivalBounds(int min, int cap) {
        this.arrivalCapUpper = cap;
        this.arrivalMinUpper = min;
        return this;
    }

    public DeeperLayer setLowerArrivalBounds(int min, int cap) {
        this.arrivalCapLower = cap;
        this.arrivalMinLower = min;
        return this;
    }


    public DeeperLayer setUpperArrivalRange(int range, boolean updateBounds) {
        this.upperArrivalRange = range;

        if(updateBounds) {
            computeUpperArrivalBounds();
        }

        return this;
    }

    public DeeperLayer setLowerArrivalRange(int range, boolean updateBounds) {
        this.lowerArrivalRange = range;

        if(updateBounds) {
            computeLowerArrivalBounds();
        }

        return this;
    }

    public DeeperLayer setUpperArrivalRange(int range) {
        return setUpperArrivalRange(range, true);
    }

    public DeeperLayer setLowerArrivalRange(int range) {
        return setLowerArrivalRange(range, true);
    }

    public DeeperLayer computeLowerArrivalBounds() {
        if(this.minY == 0 && this.maxY == 0) {
            throw new IllegalArgumentException("level bounds both 0 or unset!");
        }
        this.arrivalCapLower = minY+1+lowerArrivalRange;
        this.arrivalMinLower = minY+1;

        return this;
    }

    public DeeperLayer computeUpperArrivalBounds() {
        if(this.minY == 0 && this.maxY == 0) {
            throw new IllegalArgumentException("level bounds both 0 or unset!");
        }
        this.arrivalCapUpper = maxY-5;
        this.arrivalMinUpper = maxY-5-upperArrivalRange;

        return this;
    }
}

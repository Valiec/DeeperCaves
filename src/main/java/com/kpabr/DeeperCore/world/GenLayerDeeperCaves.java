package com.kpabr.DeeperCore.world;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerDeeperCaves extends GenLayer {

    public int[] biomeIDs;

    public GenLayerDeeperCaves(long p_i2125_1_, BiomeGenBase[] biomeArr) {
        super(p_i2125_1_);
        this.biomeIDs = new int[biomeArr.length];
        for (int i = 0; i < biomeArr.length; ++i) {
            this.biomeIDs[i] = biomeArr[i].biomeID;
        }
    }

    public int[] getInts(int p_75904_1_, int p_75904_2_, int p_75904_3_, int p_75904_4_)
    {
        int[] aint1 = IntCache.getIntCache(p_75904_3_ * p_75904_4_);

        for (int i1 = 0; i1 < p_75904_4_; ++i1)
        {
            for (int j1 = 0; j1 < p_75904_3_; ++j1)
            {
                this.initChunkSeed((long)(j1 + p_75904_1_), (long)(i1 + p_75904_2_));
                aint1[j1 + i1 * p_75904_3_] = selectRandom(biomeIDs);
            }
        }

        return aint1;
    }

}

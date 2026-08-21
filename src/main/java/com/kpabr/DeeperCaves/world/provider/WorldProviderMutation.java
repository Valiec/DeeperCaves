package com.kpabr.DeeperCaves.world.provider;


import com.kpabr.DeeperCaves.DeeperCaves;
import com.kpabr.DeeperCore.world.WorldProviderDeeperCaves;

public class WorldProviderMutation extends WorldProviderDeeperCaves
{
    public WorldProviderMutation() {
        super(DeeperCaves.worldgen.mutation);
    }
}

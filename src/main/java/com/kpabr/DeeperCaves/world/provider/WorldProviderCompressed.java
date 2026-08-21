package com.kpabr.DeeperCaves.world.provider;


import com.kpabr.DeeperCaves.DeeperCaves;
import com.kpabr.DeeperCore.world.WorldProviderDeeperCaves;

public class WorldProviderCompressed extends WorldProviderDeeperCaves
{

    public WorldProviderCompressed() {
        super(DeeperCaves.worldgen.compressed);
    }
}

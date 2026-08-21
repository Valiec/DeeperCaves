package com.kpabr.DeeperCaves.world.provider;


import com.kpabr.DeeperCaves.DeeperCaves;
import com.kpabr.DeeperCore.world.WorldProviderDeeperCaves;

public class WorldProviderMaze extends WorldProviderDeeperCaves
{
    public WorldProviderMaze() {
        super(DeeperCaves.worldgen.maze);
    }
}

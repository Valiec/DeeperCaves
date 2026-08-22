package com.kpabr.DeeperCaves.world.chunk;

import com.kpabr.DeeperCaves.DeeperBlocks;
import com.kpabr.DeeperCaves.DeeperCaves;
import com.kpabr.DeeperCaves.world.gen.cave.MapGenDeeperCavesFinalLabyrinth;

import com.kpabr.DeeperCaves.world.gen.cave.MapGenDeeperRavineFinalLabyrinth;
import com.kpabr.DeeperCore.world.chunk.ChunkProviderDeeperBase;
import net.minecraft.world.World;
import net.minecraft.world.gen.MapGenBase;


public class ChunkProviderFinalLabyrinth extends ChunkProviderDeeperBase
{
    private MapGenBase caveGenerator = new MapGenDeeperCavesFinalLabyrinth();
    private MapGenBase ravineGenerator = new MapGenDeeperRavineFinalLabyrinth(234, 15, 3.5, 1.8, DeeperBlocks.fakeBedrock);

    public ChunkProviderFinalLabyrinth(World par1World, long par2, boolean par4)
    {
        super(par1World, par2, par4);
        this.doMineshafts = false;
        super.initCaveRavineGen(caveGenerator, ravineGenerator);
        this.setupGenFromLayer(DeeperCaves.worldgen.finalLabyrinth);
    }


}
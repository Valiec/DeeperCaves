package com.kpabr.DeeperCaves.world.chunk;

import com.kpabr.DeeperCaves.DeeperBlocks;
import com.kpabr.DeeperCaves.DeeperCaves;
import com.kpabr.DeeperCaves.DeeperWorldgen;
import com.kpabr.DeeperCore.dimstack.DeeperLayer;
import com.kpabr.DeeperCore.world.chunk.ChunkProviderDeeperBase;
import com.kpabr.DeeperCore.world.cave.MapGenDeeperCavesDefault;
import com.kpabr.DeeperCore.world.cave.MapGenDeeperRavine;

import net.minecraft.world.World;
import net.minecraft.world.gen.MapGenBase;


public class ChunkProviderAbandonedCaves extends ChunkProviderDeeperCavesBase
{
    private MapGenBase caveGenerator = new MapGenDeeperCavesDefault(true,  1.0F, 12.0D, 150, 0,   0, 36,  7, true,  false, DeeperBlocks.abandonedStone);
    private MapGenBase ravineGenerator = new MapGenDeeperRavine(234, 13, 7.5, 5.5, DeeperBlocks.abandonedStone);

    public ChunkProviderAbandonedCaves(World par1World, long par2, boolean par4)
    {
        super(par1World, par2, par4);
        super.initCaveRavineGen(caveGenerator, ravineGenerator);
        this.setupGenFromLayer(DeeperCaves.worldgen.abandonedCaves);
    }


}
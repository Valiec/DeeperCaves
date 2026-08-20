package com.kpabr.DeeperCaves.world.chunk;

import com.kpabr.DeeperCaves.DeeperBlocks;
import com.kpabr.DeeperCore.worldgen.ChunkProviderDeeperBase;
import com.kpabr.DeeperCore.worldgen.MapGenDeeperCavesDefault;
import com.kpabr.DeeperCore.worldgen.MapGenDeeperRavine;

import net.minecraft.world.World;
import net.minecraft.world.gen.MapGenBase;


public class ChunkProviderAbandonedCaves extends ChunkProviderDeeperBase
{
    private MapGenBase caveGenerator = new MapGenDeeperCavesDefault(true,  1.0F, 12.0D, 150, 0,   0, 36,  7, true,  false, DeeperBlocks.abandonedStone);
    private MapGenBase ravineGenerator = new MapGenDeeperRavine(234, 13, 7.5, 5.5, DeeperBlocks.abandonedStone);

    {
        //caveGenerator = TerrainGen.getModdedMapGen(caveGenerator, CAVE);
        //ravineGenerator = TerrainGen.getModdedMapGen(ravineGenerator, RAVINE);
    }

    public ChunkProviderAbandonedCaves(World par1World, long par2, boolean par4)
    {
        super(par1World, par2, par4);
        this.barrierBlock = DeeperBlocks.barrierLayer;
        super.initCaveRavineGen(caveGenerator, ravineGenerator);
        this.upperBarrierY = 102;
        this.baseBlock = DeeperBlocks.abandonedStone;
    }


}
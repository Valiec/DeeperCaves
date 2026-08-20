package com.kpabr.DeeperCaves.world.chunk;

import com.kpabr.DeeperCaves.DeeperBlocks;
import com.kpabr.DeeperCore.worldgen.ChunkProviderDeeperBase;
import com.kpabr.DeeperCore.worldgen.MapGenDeeperCavesDefault;
import com.kpabr.DeeperCore.worldgen.MapGenDeeperRavine;

import net.minecraft.world.World;
import net.minecraft.world.gen.MapGenBase;


public class ChunkProviderEvil extends ChunkProviderDeeperBase
{
    private MapGenBase caveGenerator = new MapGenDeeperCavesDefault(false, 1.0F, 1.5D, 255, 0, 0, 47, 4, true, false, DeeperBlocks.deepStone);
    private MapGenBase ravineGenerator = new MapGenDeeperRavine(234, 15, 1.5, 1.0, DeeperBlocks.deepStone);

    {
        //caveGenerator = TerrainGen.getModdedMapGen(caveGenerator, CAVE);
        //ravineGenerator = TerrainGen.getModdedMapGen(ravineGenerator, RAVINE);
    }

    public ChunkProviderEvil(World par1World, long par2, boolean par4)
    {
        super(par1World, par2, par4);
        this.barrierBlock = DeeperBlocks.barrierLayer;
        super.initCaveRavineGen(caveGenerator, ravineGenerator);
        this.upperBarrierY = 102;
        this.baseBlock = DeeperBlocks.deepStone;
    }


}
package com.kpabr.DeeperCaves.world.chunk;

import com.kpabr.DeeperCaves.DeeperBlocks;
import com.kpabr.DeeperCore.worldgen.ChunkProviderDeeperBase;
import com.kpabr.DeeperCore.worldgen.MapGenDeeperCavesDefault;
import com.kpabr.DeeperCore.worldgen.MapGenDeeperRavine;

import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.MapGenBase;

public class ChunkProviderDeepWorld extends ChunkProviderDeeperBase
{
    private MapGenBase caveGenerator = new MapGenDeeperCavesDefault();
    private MapGenBase ravineGenerator = new MapGenDeeperRavine(234, 3, 1.5, 1.0, Blocks.stone);

    {
        //caveGenerator = TerrainGen.getModdedMapGen(caveGenerator, CAVE);
        //ravineGenerator = TerrainGen.getModdedMapGen(ravineGenerator, RAVINE);
    }

    public ChunkProviderDeepWorld(World par1World, long par2, boolean par4)
    {
        super(par1World, par2, par4);
        this.barrierBlock = DeeperBlocks.barrierLayer;
        super.initCaveRavineGen(caveGenerator, ravineGenerator);
        this.upperBarrierY = 77;
    }

}
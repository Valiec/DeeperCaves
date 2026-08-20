package com.kpabr.DeeperCaves.world.chunk;

import com.kpabr.DeeperCaves.DeeperBlocks;
import com.kpabr.DeeperCore.worldgen.ChunkProviderDeeperBase;
import com.kpabr.DeeperCore.worldgen.MapGenDeeperCavesDefault;
import com.kpabr.DeeperCore.worldgen.MapGenDeeperRavine;

import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.MapGenBase;

public class ChunkProviderDrop extends ChunkProviderDeeperBase {
    /**
     * RNG.
     */
    //private MapGenBase caveGenerator = new MapGenDeeperCavesDrop();
    private MapGenBase caveGenerator = new MapGenDeeperCavesDefault(false, 1.0F, 4.0D, 254, 0, 140, 30, 3, true, false, Blocks.stone);
    private MapGenBase ravineGenerator = new MapGenDeeperRavine(234, 13, 7.5, 5.5, Blocks.stone);

    {
        //caveGenerator = TerrainGen.getModdedMapGen(caveGenerator, CAVE);
        //ravineGenerator = TerrainGen.getModdedMapGen(ravineGenerator, RAVINE);
    }

    public ChunkProviderDrop(World par1World, long par2, boolean par4) {
        super(par1World, par2, par4);
        this.barrierBlock = DeeperBlocks.barrierLayer;
        super.initCaveRavineGen(caveGenerator, ravineGenerator);
        this.upperBarrierY = 202;
    }
}
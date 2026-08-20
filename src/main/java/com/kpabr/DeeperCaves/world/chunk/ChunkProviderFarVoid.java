package com.kpabr.DeeperCaves.world.chunk;

import com.kpabr.DeeperCaves.DeeperBlocks;

import com.kpabr.DeeperCore.worldgen.ChunkProviderDeeperBase;
import com.kpabr.DeeperCore.worldgen.MapGenDeeperCavesDefault;
import com.kpabr.DeeperCore.worldgen.MapGenDeeperRavine;
import net.minecraft.world.World;
import net.minecraft.world.gen.MapGenBase;

public class ChunkProviderFarVoid extends ChunkProviderDeeperBase
{
    private MapGenBase caveGenerator = new MapGenDeeperCavesDefault(false,  1.0F,  4.0D, 254, 0, 220, 20, 12, false, false, DeeperBlocks.deepStone);
    private MapGenBase ravineGenerator = new MapGenDeeperRavine(220, 13, 7.5, 3.5, DeeperBlocks.deepStone);

    {
        //caveGenerator = TerrainGen.getModdedMapGen(caveGenerator, CAVE);
        //ravineGenerator = TerrainGen.getModdedMapGen(ravineGenerator, RAVINE);
    }

    public ChunkProviderFarVoid(World par1World, long par2, boolean par4)
    {
        super(par1World, par2, par4);
        this.barrierBlock = DeeperBlocks.barrierLayer;
        this.doMineshafts = false;
        super.initCaveRavineGen(caveGenerator, ravineGenerator);
        this.upperBarrierY = 247;
        this.voidTerrainCutoff = 220;
        this.baseBlock = DeeperBlocks.deepStone;
    }

}
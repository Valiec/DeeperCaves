package com.kpabr.DeeperCaves.world.chunk;

import com.kpabr.DeeperCaves.DeeperBlocks;
import com.kpabr.DeeperCore.world.cave.MapGenDeeperCavesDefault;
import com.kpabr.DeeperCore.world.cave.MapGenDeeperRavine;
import com.kpabr.DeeperCore.world.chunk.ChunkProviderDeeperBase;

import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.MapGenBase;

public class ChunkProviderNearVoid extends ChunkProviderDeeperBase
{
    private MapGenBase caveGenerator = new MapGenDeeperCavesDefault(false,  1.0F,  4.0D, 254, 0, 220, 15, 12, false, false, Blocks.stone);
    private MapGenBase ravineGenerator = new MapGenDeeperRavine(220, 13, 7.5, 3.5, Blocks.stone);

    {
        //caveGenerator = TerrainGen.getModdedMapGen(caveGenerator, CAVE);
        //ravineGenerator = TerrainGen.getModdedMapGen(ravineGenerator, RAVINE);
    }

    public ChunkProviderNearVoid(World par1World, long par2, boolean par4)
    {
        super(par1World, par2, par4);
        this.barrierBlock = DeeperBlocks.barrierLayer;
        this.doMineshafts = false;
        super.initCaveRavineGen(caveGenerator, ravineGenerator);
        this.upperBarrierY = 247;
        this.voidTerrainCutoff = 220;
    }

}
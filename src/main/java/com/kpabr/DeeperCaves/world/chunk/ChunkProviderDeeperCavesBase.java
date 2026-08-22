package com.kpabr.DeeperCaves.world.chunk;

import com.kpabr.DeeperCaves.DeeperBlocks;
import com.kpabr.DeeperCore.world.cave.MapGenDeeperCavesDefault;
import com.kpabr.DeeperCore.world.cave.MapGenDeeperRavine;
import com.kpabr.DeeperCore.world.chunk.ChunkProviderDeeperBase;
import net.minecraft.world.World;
import net.minecraft.world.gen.MapGenBase;


public class ChunkProviderDeeperCavesBase extends ChunkProviderDeeperBase
{

    public ChunkProviderDeeperCavesBase(World par1World, long par2, boolean par4)
    {
        super(par1World, par2, par4);
        this.barrierBlock = DeeperBlocks.barrierLayer;
        this.doMineshafts = true;
    }


}
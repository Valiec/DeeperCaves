package com.kpabr.DeeperCaves.world.chunk;

import com.kpabr.DeeperCaves.DeeperBlocks;
import com.kpabr.DeeperCaves.DeeperCaves;
import com.kpabr.DeeperCore.world.chunk.ChunkProviderDeeperBase;
import com.kpabr.DeeperCore.world.cave.MapGenDeeperCavesDefault;
import com.kpabr.DeeperCore.world.cave.MapGenDeeperRavine;

import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.MapGenBase;

public class ChunkProviderDrop extends ChunkProviderDeeperCavesBase {
    private MapGenBase caveGenerator = new MapGenDeeperCavesDefault(false, 1.0F, 4.0D, 254, 0, 140, 30, 3, true, false, Blocks.stone);
    private MapGenBase ravineGenerator = new MapGenDeeperRavine(234, 13, 7.5, 5.5, Blocks.stone);

    public ChunkProviderDrop(World par1World, long par2, boolean par4) {
        super(par1World, par2, par4);
        super.initCaveRavineGen(caveGenerator, ravineGenerator);
        this.setupGenFromLayer(DeeperCaves.worldgen.drop);
    }
}
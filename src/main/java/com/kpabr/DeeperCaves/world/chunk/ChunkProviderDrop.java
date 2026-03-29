package com.kpabr.DeeperCaves.world.chunk;

import com.kpabr.DeeperCaves.world.gen.cave.MapGenDeeperCavesDrop;
import com.kpabr.DeeperCaves.world.gen.cave.MapGenDeeperRavine;

import net.minecraft.world.World;
import net.minecraft.world.gen.MapGenBase;

import static net.minecraftforge.event.terraingen.InitMapGenEvent.EventType.*;

import net.minecraftforge.event.terraingen.*;

public class ChunkProviderDrop extends ChunkProviderDeeperBase {
    /**
     * RNG.
     */
    private MapGenBase caveGenerator = new MapGenDeeperCavesDrop();
    private MapGenBase ravineGenerator = new MapGenDeeperRavine(234, 13, 7.5, 5.5);

    {
        caveGenerator = TerrainGen.getModdedMapGen(caveGenerator, CAVE);
        ravineGenerator = TerrainGen.getModdedMapGen(ravineGenerator, RAVINE);
    }

    public ChunkProviderDrop(World par1World, long par2, boolean par4) {
        super(par1World, par2, par4);
        super.initCaveRavineGen(caveGenerator, ravineGenerator);
        this.upperBarrierY = 202;
    }
}
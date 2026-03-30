package com.kpabr.DeeperCaves.world.chunk;

import com.kpabr.DeeperCaves.DeeperBlocks;
import com.kpabr.DeeperCaves.world.gen.cave.MapGenDeeperCavesDarknessLower;
import com.kpabr.DeeperCaves.world.gen.cave.MapGenDeeperCavesDarknessUpper;
import com.kpabr.DeeperCaves.world.gen.cave.MapGenDeeperRavine;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.gen.MapGenBase;
import static net.minecraftforge.event.terraingen.InitMapGenEvent.EventType.*;

import net.minecraftforge.event.terraingen.*;


public class ChunkProviderAbandonedCaves extends ChunkProviderDeeperBase
{
    private MapGenBase caveGenerator = new MapGenDeeperCavesDarknessLower();
    private MapGenBase ravineGenerator = new MapGenDeeperRavine(234, 13, 7.5, 5.5, DeeperBlocks.abandonedStone);

    {
        caveGenerator = TerrainGen.getModdedMapGen(caveGenerator, CAVE);
        ravineGenerator = TerrainGen.getModdedMapGen(ravineGenerator, RAVINE);
    }

    public ChunkProviderAbandonedCaves(World par1World, long par2, boolean par4)
    {
        super(par1World, par2, par4);
        super.initCaveRavineGen(caveGenerator, ravineGenerator);
        this.upperBarrierY = 102;
        this.baseBlock = DeeperBlocks.abandonedStone;
    }


}
package com.kpabr.DeeperCaves.world.chunk;

import com.kpabr.DeeperCaves.DeeperBlocks;
import com.kpabr.DeeperCaves.world.gen.cave.MapGenDeeperCavesDefaultDenserEvil;
import com.kpabr.DeeperCaves.world.gen.cave.MapGenDeeperRavine;

import net.minecraft.world.World;
import net.minecraft.world.gen.MapGenBase;
import static net.minecraftforge.event.terraingen.InitMapGenEvent.EventType.*;

import net.minecraftforge.event.terraingen.*;


public class ChunkProviderMutation extends ChunkProviderDeeperBase
{
    private MapGenBase caveGenerator = new MapGenDeeperCavesDefaultDenserEvil();
    private MapGenBase ravineGenerator = new MapGenDeeperRavine(234, 15, 7.5, 3.5, DeeperBlocks.deepStone);

    {
        caveGenerator = TerrainGen.getModdedMapGen(caveGenerator, CAVE);
        ravineGenerator = TerrainGen.getModdedMapGen(ravineGenerator, RAVINE);
    }

    public ChunkProviderMutation(World par1World, long par2, boolean par4)
    {
        super(par1World, par2, par4);
        super.initCaveRavineGen(caveGenerator, ravineGenerator);
        this.upperBarrierY = 102;
        this.baseBlock = DeeperBlocks.deepStone;
    }


}
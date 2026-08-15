package com.kpabr.DeeperCaves.world.chunk;

import com.kpabr.DeeperCaves.world.gen.cave.MapGenDeeperCavesDefault;
import com.kpabr.DeeperCaves.world.gen.cave.MapGenDeeperRavine;

import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.MapGenBase;
import static net.minecraftforge.event.terraingen.InitMapGenEvent.EventType.*;
import net.minecraftforge.event.terraingen.*;

public class ChunkProviderMaze extends ChunkProviderDeeperBase
{
    /** RNG. */
    //private MapGenBase caveGenerator = new MapGenDeeperCavesMaze();
    private MapGenBase caveGenerator = new MapGenDeeperCavesDefault(false, 1.0F, 1.0D, 200, 0, 0, 36, 7, false, false, Blocks.stone, 2);
    private MapGenBase ravineGenerator = new MapGenDeeperRavine(234, 80, 2.0, 1.0, Blocks.stone);

    {
        //caveGenerator = TerrainGen.getModdedMapGen(caveGenerator, CAVE);
        //ravineGenerator = TerrainGen.getModdedMapGen(ravineGenerator, RAVINE);
    }

    public ChunkProviderMaze(World par1World, long par2, boolean par4)
    {
    	super(par1World, par2, par4);
        super.initCaveRavineGen(caveGenerator, ravineGenerator);
        this.upperBarrierY = 202;
    }


}
package com.kpabr.DeeperCaves.world.chunk;

import com.kpabr.DeeperCaves.world.gen.cave.MapGenDeeperCavesDefault;
import com.kpabr.DeeperCaves.world.gen.cave.MapGenDeeperRavineCompressed;

import net.minecraft.world.World;
import net.minecraft.world.gen.MapGenBase;
import static net.minecraftforge.event.terraingen.InitMapGenEvent.EventType.*;
import net.minecraftforge.event.terraingen.*;

public class ChunkProviderCrystal extends ChunkProviderDeeperBase
{
    /** RNG. */
    private MapGenBase caveGenerator = new MapGenDeeperCavesDefault();
    private MapGenBase ravineGenerator = new MapGenDeeperRavineCompressed();

    {
        caveGenerator = TerrainGen.getModdedMapGen(caveGenerator, CAVE);
        ravineGenerator = TerrainGen.getModdedMapGen(ravineGenerator, RAVINE);
    }    

    public ChunkProviderCrystal(World par1World, long par2, boolean par4)
    {
    	super(par1World, par2, par4);
        super.initCaveRavineGen(caveGenerator, ravineGenerator);
        this.upperBarrierY = 152;
    }
    
}
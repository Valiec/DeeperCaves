package com.kpabr.DeeperCaves.world.chunk;

import com.kpabr.DeeperCaves.world.gen.cave.MapGenDeeperCavesDefaultDenser;
import com.kpabr.DeeperCaves.world.gen.cave.MapGenDeeperRavine;

import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.MapGenBase;
import static net.minecraftforge.event.terraingen.InitMapGenEvent.EventType.*;
import net.minecraftforge.event.terraingen.*;

public class ChunkProviderNearNether extends ChunkProviderDeeperBase
{
    private MapGenBase caveGenerator = new MapGenDeeperCavesDefaultDenser();
    private MapGenBase ravineGenerator = new MapGenDeeperRavine(234, 3, 1.5, 1.0, Blocks.stone);

    {
        caveGenerator = TerrainGen.getModdedMapGen(caveGenerator, CAVE);
        ravineGenerator = TerrainGen.getModdedMapGen(ravineGenerator, RAVINE);
    }

    public ChunkProviderNearNether(World par1World, long par2, boolean par4)
    {
        super(par1World, par2, par4);
        super.initCaveRavineGen(caveGenerator, ravineGenerator);
        this.upperBarrierY = 102;
    }

}
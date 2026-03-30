package com.kpabr.DeeperCaves.world.chunk;

import com.kpabr.DeeperCaves.world.gen.cave.MapGenDeeperCavesDefault;
import com.kpabr.DeeperCaves.world.gen.cave.MapGenDeeperCavesNearVoid;
import com.kpabr.DeeperCaves.world.gen.cave.MapGenDeeperRavine;
import com.kpabr.DeeperCaves.world.gen.cave.MapGenDeeperRavineCompressed;

import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.MapGenBase;
import static net.minecraftforge.event.terraingen.InitMapGenEvent.EventType.*;
import net.minecraftforge.event.terraingen.*;

public class ChunkProviderNearVoid extends ChunkProviderDeeperBase
{
    /** RNG. */
    private MapGenBase caveGenerator = new MapGenDeeperCavesNearVoid();
    private MapGenBase ravineGenerator = new MapGenDeeperRavine(220, 13, 7.5, 3.5, Blocks.stone);

    {
        caveGenerator = TerrainGen.getModdedMapGen(caveGenerator, CAVE);
        ravineGenerator = TerrainGen.getModdedMapGen(ravineGenerator, RAVINE);
    }

    public ChunkProviderNearVoid(World par1World, long par2, boolean par4)
    {
        super(par1World, par2, par4);
        this.doMineshafts = false;
        super.initCaveRavineGen(caveGenerator, ravineGenerator);
        this.upperBarrierY = 247;
        this.voidTerrainCutoff = 220;
    }

}
package com.kpabr.DeeperCaves.world.chunk;

import com.kpabr.DeeperCaves.DeeperBlocks;
import com.kpabr.DeeperCaves.world.gen.cave.*;

import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.MapGenBase;
import static net.minecraftforge.event.terraingen.InitMapGenEvent.EventType.*;
import net.minecraftforge.event.terraingen.*;

public class ChunkProviderFarVoid extends ChunkProviderDeeperBase
{
    private MapGenBase caveGenerator = new MapGenDeeperCavesFarVoid();
    private MapGenBase ravineGenerator = new MapGenDeeperRavine(220, 13, 7.5, 3.5, DeeperBlocks.deepStone);

    {
        //caveGenerator = TerrainGen.getModdedMapGen(caveGenerator, CAVE);
        //ravineGenerator = TerrainGen.getModdedMapGen(ravineGenerator, RAVINE);
    }

    public ChunkProviderFarVoid(World par1World, long par2, boolean par4)
    {
        super(par1World, par2, par4);
        this.doMineshafts = false;
        super.initCaveRavineGen(caveGenerator, ravineGenerator);
        this.upperBarrierY = 247;
        this.voidTerrainCutoff = 220;
        this.baseBlock = DeeperBlocks.deepStone;
    }

}
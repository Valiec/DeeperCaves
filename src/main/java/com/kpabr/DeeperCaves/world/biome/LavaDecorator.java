package com.kpabr.DeeperCaves.world.biome;

//import static net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.LAKE;

import com.kpabr.DeeperCaves.DeeperBlocks;
import com.kpabr.DeeperCaves.DeeperCaves;

import com.kpabr.DeeperCaves.DeeperFluids;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;
//import net.minecraftforge.event.terraingen.TerrainGen;

public class LavaDecorator extends DeeperDecorator {

	@Override
	protected void genDecorations(BiomeGenBase biome)
    {
        MinecraftForge.EVENT_BUS.post(new DecorateBiomeEvent.Pre(currentWorld, randomGenerator, chunk_X, chunk_Z));
        this.generateOres();
        int i1;
        int i;
        
        int j;
        int k;

        //boolean doGen = TerrainGen.decorate(currentWorld, randomGenerator, chunk_X, chunk_Z, LAKE);
        for (i1 = 0; i1 < ((this.currentWorld.provider.dimensionId == DeeperCaves.worldgen.mutation.dimID)?64:250); ++i1)
        {
            i = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
            j = this.randomGenerator.nextInt((this.currentWorld.provider.dimensionId == DeeperCaves.worldgen.mutation.dimID)?(100):(50));
            k = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
            (new WorldGenDeeperLiquids((this.currentWorld.provider.dimensionId == DeeperCaves.worldgen.mutation.dimID)?(DeeperFluids.veneniumBlock):(Blocks.flowing_lava))).setReplaceBlock((this.currentWorld.provider.dimensionId == DeeperCaves.worldgen.mutation.dimID)?(DeeperBlocks.deepStone):(Blocks.stone)).generate(this.currentWorld, this.randomGenerator, i, j, k);
        }

        MinecraftForge.EVENT_BUS.post(new DecorateBiomeEvent.Post(currentWorld, randomGenerator, chunk_X, chunk_Z));
    }
}

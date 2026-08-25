package com.kpabr.DeeperCaves.world.biome;

import static net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.LAKE;

import com.kpabr.DeeperCaves.structure.cavevillage.CaveVillage;
import com.kpabr.DeeperCore.world.biome.DeeperBaseDecorator;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenLiquids;
import net.minecraftforge.event.terraingen.TerrainGen;

public class DeeperDecorator extends DeeperBaseDecorator {

	@Override
	protected void decorate(BiomeGenBase biome)
    {
        int i;
        
        int j;
        int k;

        int i1;

        boolean doGen = TerrainGen.decorate(currentWorld, randomGenerator, chunk_X, chunk_Z, LAKE);
        if (doGen && this.generateLakes)
        {
            for (i1 = 0; i1 < 50; ++i1)
            {
                i = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
                j = this.randomGenerator.nextInt(this.randomGenerator.nextInt(248) + 8);
                k = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
                (new WorldGenLiquids(Blocks.flowing_water)).generate(this.currentWorld, this.randomGenerator, i, j, k);
            }

            for (i1 = 0; i1 < 20; ++i1)
            {
                i = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
                j = this.randomGenerator.nextInt(this.randomGenerator.nextInt(this.randomGenerator.nextInt(240) + 8) + 8);
                k = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
                (new WorldGenLiquids(Blocks.flowing_lava)).generate(this.currentWorld, this.randomGenerator, i, j, k);
            }
        }

        decorateAdditional(biome);
    }

    protected void decorateAdditional(BiomeGenBase biome)
    {
        //do nothing
    }
}

package com.kpabr.DeeperCaves.world.biome;

import com.kpabr.DeeperCaves.structure.cavevillage.CaveVillage;
import net.minecraft.world.biome.BiomeGenBase;

public class AbandonedCavesDecorator extends DeeperDecorator {

	@Override
	protected void decorate(BiomeGenBase biome)
    {
        super.decorate(biome);

        if (randomGenerator.nextInt(6) == 0)
        {
            int i = this.chunk_X + randomGenerator.nextInt(16) + 8;
            int j = this.chunk_Z + randomGenerator.nextInt(16) + 8;
            int k = randomGenerator.nextInt(60);
            (new CaveVillage()).generate(this.currentWorld, this.randomGenerator, i, k, j);
        }
    }
}

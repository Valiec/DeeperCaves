package com.kpabr.DeeperCaves.world.biome;

import com.kpabr.DeeperCaves.structure.cavevillage.CaveVillage;
import com.kpabr.DeeperCore.worldgen.DeeperBaseDecorator;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenLiquids;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;
import net.minecraftforge.event.terraingen.TerrainGen;

import static net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.LAKE;

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

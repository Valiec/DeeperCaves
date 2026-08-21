package com.kpabr.DeeperCore.worldgen;

import com.kpabr.DeeperCore.dimstack.DeeperLayer;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;
import net.minecraftforge.event.terraingen.OreGenEvent;

public class DeeperBaseDecorator extends BiomeDecorator {

	@Override
	protected void genDecorations(BiomeGenBase biome)
    {
        MinecraftForge.EVENT_BUS.post(new DecorateBiomeEvent.Pre(currentWorld, randomGenerator, chunk_X, chunk_Z));
        this.generateOres();
        this.decorate(biome);
        MinecraftForge.EVENT_BUS.post(new DecorateBiomeEvent.Post(currentWorld, randomGenerator, chunk_X, chunk_Z));
    }

    protected void decorate(BiomeGenBase biome)
    {
        //no-op
    }

	protected void generateOres(BiomeGenDeeperBase biome) {
        for (DeeperLayer layer : DeeperLayer.deeperLayers) {
            if (currentWorld.provider.dimensionId == layer.dimID) {
                MinecraftForge.ORE_GEN_BUS.post(new OreGenEvent.Pre(currentWorld, randomGenerator, chunk_X, chunk_Z));
                //layer.generateOres.accept(currentWorld, randomGenerator, chunk_X, chunk_Z);
                biome.generateOres(currentWorld, randomGenerator, chunk_X, chunk_Z);
                MinecraftForge.ORE_GEN_BUS.post(new OreGenEvent.Post(currentWorld, randomGenerator, chunk_X, chunk_Z));
                break;

            }
        }
    }

    @Override
    protected void generateOres() {
        //no-op
    }
}

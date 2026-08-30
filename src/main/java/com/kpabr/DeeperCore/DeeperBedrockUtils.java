package com.kpabr.DeeperCore;

import com.kpabr.DeeperCore.dimstack.DeeperLayer;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.NoiseGeneratorPerlin;
import net.minecraftforge.event.world.WorldEvent;

import java.util.HashMap;
import java.util.Random;

public class DeeperBedrockUtils {
    public static HashMap<Integer, NoiseGeneratorPerlin> bedrockPerlin = new HashMap<Integer, NoiseGeneratorPerlin>();

    @SubscribeEvent
    public void onWorldLoad(WorldEvent.Load event) {
        if (!event.world.isRemote) {
            long seed = event.world.getSeed();
            if(DeeperLayer.layersForDimId.containsKey(event.world.provider.dimensionId))
            {
                seed += DeeperLayer.layersForDimId.get(event.world.provider.dimensionId).seedOffset;
            }
            NoiseGeneratorPerlin gen = new NoiseGeneratorPerlin(new Random(seed), 1);
            bedrockPerlin.put(event.world.provider.dimensionId, gen);
        }
    }

    @SubscribeEvent
    public void onWorldUnload(WorldEvent.Unload event) {
        if (!event.world.isRemote) {
            bedrockPerlin.remove(event.world.provider.dimensionId);
        }
    }

    public static void removeAllBedrock(World world, int chunkX, int chunkZ, Block replaceBlock) {
        for (int x = chunkX * 16; x < (chunkX + 1) * 16; ++x) {
            for (int z = chunkZ * 16; z < (chunkZ + 1) * 16; ++z) {
                for (int y = 5; y >= 0; --y) {
                    if (world.getBlock(x, y, z) == Blocks.bedrock) {
                        world.setBlock(x, y, z, replaceBlock, 0, 2);
                    }
                }
            }
        }
    }

    public static void removeSomeBedrock(World world, int chunkX, int chunkZ, Block replaceBlock) {

        NoiseGeneratorPerlin bedrockNoiseGen = DeeperBedrockUtils.bedrockPerlin.get(world.provider.dimensionId);

        if (bedrockNoiseGen != null) {

            double[] bedrockNoise = new double[256];
            bedrockNoise = bedrockNoiseGen.func_151599_a(bedrockNoise, chunkX * 16, chunkZ * 16, 16, 16, 0.05, 0.05, 1);

            for (int x = 0; x < 16; ++x) {
                for (int z = 0; z < 16; ++z) {
                    for (int y = 5; y >= 0; --y) {
                        int worldX = chunkX * 16 + x;
                        int worldZ = chunkZ * 16 + z;
                        if (world.getBlock(worldX, y, worldZ) == Blocks.bedrock && bedrockNoise[z * 16 + x] > 0) {
                            world.setBlock(worldX, y, worldZ, replaceBlock, 0, 2);
                        }
                    }
                }
            }
        }
    }
}

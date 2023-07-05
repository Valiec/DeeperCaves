package com.kpabr.deepercaves.world.carver;

import com.kpabr.deepercaves.DeeperCaves;
import com.mojang.serialization.Codec;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.gen.carver.*;
import net.minecraft.world.gen.chunk.AquiferSampler;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.function.Function;

public class BedrockPlainsCaveCarver extends CaveCarver {
    public BedrockPlainsCaveCarver(Codec<CaveCarverConfig> codec) {
        super(codec);
    }

    @Override
    public boolean carve(CarverContext carverContext, CaveCarverConfig caveCarverConfig, Chunk chunk, Function<BlockPos, RegistryEntry<Biome>> function, Random random, AquiferSampler aquiferSampler, ChunkPos chunkPos, CarvingMask carvingMask) {

        AquiferSampler.FluidLevel fluidLevel = new AquiferSampler.FluidLevel(-64, Blocks.AIR.getDefaultState());
        AquiferSampler.FluidLevelSampler patchedFluidLevelSampler = (x, y, z) -> {
            return fluidLevel;
        };
        aquiferSampler = AquiferSampler.seaLevel(patchedFluidLevelSampler);

        return super.carve(carverContext, caveCarverConfig, chunk, function, random, aquiferSampler, chunkPos, carvingMask);
    }
}

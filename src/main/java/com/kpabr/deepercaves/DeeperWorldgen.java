package com.kpabr.deepercaves;

import com.kpabr.deepercaves.world.carver.BedrockPlainsCaveCarver;
import com.kpabr.deepercaves.world.carver.BedrockPlainsRavineCarver;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.carver.CaveCarverConfig;
import net.minecraft.world.gen.carver.RavineCarverConfig;

public class DeeperWorldgen {
    public static void setupWorldgen() {
        Registry.register(Registry.CARVER, new Identifier("deepercaves", "no_fluid_cave"), new BedrockPlainsCaveCarver(CaveCarverConfig.CAVE_CODEC));
        Registry.register(Registry.CARVER, new Identifier("deepercaves", "no_fluid_ravine"), new BedrockPlainsRavineCarver(RavineCarverConfig.RAVINE_CODEC));
    }
}

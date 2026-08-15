package com.kpabr.DeeperCaves.world.provider;


import com.kpabr.DeeperCaves.DeeperCaves;
import com.kpabr.DeeperCaves.DeeperWorldgen;
import com.kpabr.DeeperCaves.world.chunk.ChunkProviderAbandonedCaves;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;
public class WorldProviderAbandonedCaves extends WorldProviderDeeperCaves
{
    public WorldProviderAbandonedCaves() {
        super(DeeperCaves.worldgen.abandonedCaves);
    }

}

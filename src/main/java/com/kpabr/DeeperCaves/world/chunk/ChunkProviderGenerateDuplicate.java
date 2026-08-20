package com.kpabr.DeeperCaves.world.chunk;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.ChunkProviderGenerate;

public class ChunkProviderGenerateDuplicate extends ChunkProviderGenerate implements IChunkProvider
{
	//Duplicate of ChunkProviderGenerate (for now). Used to change class name to prevent recursion loop in Overworld gen
    public ChunkProviderGenerateDuplicate(World p_i2006_1_, long p_i2006_2_, boolean p_i2006_4_)
    {
    	super(p_i2006_1_, p_i2006_2_, p_i2006_4_);
    }

}
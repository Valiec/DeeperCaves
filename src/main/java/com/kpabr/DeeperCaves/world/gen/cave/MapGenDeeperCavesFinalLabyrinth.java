package com.kpabr.DeeperCaves.world.gen.cave;

import java.util.Random;

import com.kpabr.DeeperCaves.DeeperBlocks;
import com.kpabr.DeeperCaves.DeeperCaves;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.MapGenBase;

public class MapGenDeeperCavesFinalLabyrinth extends MapGenDeeperCavesDefault
{

    public MapGenDeeperCavesFinalLabyrinth() {
        super(true, 1.0F, 4.0D, 254, 0, 0, 36, 7, true, false, DeeperBlocks.fakeBedrock);
    }

    //Determine if the block at the specified location is the top block for the biome, we take into account
    //Vanilla bugs to make sure that we generate the map the same way vanilla does.
    public boolean isTopBlock(Block[] data, int index, int x, int y, int z, int chunkX, int chunkZ)
    {
        return data[index] == DeeperBlocks.fragmentedBedrock;
    }

    /**
     * Digs out the current block, default implementation removes stone, filler, and top block
     * Sets the block to lava if y is less then 10, and air other wise.
     * If setting to air, it also checks to see if we've broken the surface and if so 
     * tries to make the floor the biome's top block
     * 
     * @param data Block data array
     * @param index Pre-calculated index into block data
     * @param x local X position
     * @param y local Y position
     * @param z local Z position
     * @param chunkX Chunk X position
     * @param chunkZ Chunk Y position
     * @param foundTop True if we've encountered the biome's top block. Ideally if we've broken the surface.
     */
    protected void digBlock(Block[] data, int index, int x, int y, int z, int chunkX, int chunkZ, boolean foundTop)
    {
        BiomeGenBase biome = worldObj.getBiomeGenForCoords(x + chunkX * 16, z + chunkZ * 16);
        Block top    = (isExceptionBiome(biome) ? Blocks.grass : biome.topBlock);
        Block filler = (isExceptionBiome(biome) ? Blocks.dirt  : biome.fillerBlock);
        Block block  = data[index];

        if (block == Blocks.stone || block == filler || block == top || block == DeeperBlocks.fakeBedrock)
        {
                data[index] = null;
                data[index - 1] = DeeperBlocks.fakeBedrock;
                if(data[index+1] == DeeperBlocks.fakeBedrock)
                {
                    data[index+1] = null;
                }
                if(data[index-2] == Blocks.air)
                {
                    data[index-1] = null;
                }
        }
    }
}
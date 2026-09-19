package com.kpabr.DeeperCaves.world.gen.cave;

import com.kpabr.DeeperCaves.DeeperBlocks;
import com.kpabr.DeeperCore.world.cave.MapGenDeeperRavine;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;

public class MapGenDeeperRavineFinalLabyrinth extends MapGenDeeperRavine
{
    public MapGenDeeperRavineFinalLabyrinth(int minY, int maxY, int genRarity, double widthFactor, double heightFactor, int minCarvingDepth, int maxCarvingDepth, boolean jitterMin, int seedSalt, boolean floorCutoff, Block... fillerBlock){
        super(minY, maxY, genRarity, widthFactor, heightFactor, minCarvingDepth, maxCarvingDepth, jitterMin, seedSalt, floorCutoff, fillerBlock);
    }

    public MapGenDeeperRavineFinalLabyrinth(int minY, int maxY, int genRarity, double widthFactor, double heightFactor, int minCarvingDepth, int maxCarvingDepth, boolean jitterMin, Block... fillerBlock){
        this(minY, maxY, genRarity, widthFactor, heightFactor, minCarvingDepth, maxCarvingDepth, jitterMin, 0, false, fillerBlock);
    }

    public MapGenDeeperRavineFinalLabyrinth(int maxY, int genRarity, double widthFactor, double heightFactor, Block... fillerBlock){
        this(0, maxY, genRarity, widthFactor, heightFactor, -1, 255, true, 0, false, fillerBlock);
    }

    public MapGenDeeperRavineFinalLabyrinth(){
        this(234, 13, 7.5, 5.5, DeeperBlocks.fakeBedrock);
    }


    protected void digBlock(Block[] data, int index, int x, int y, int z, int chunkX, int chunkZ, boolean foundTop, int minHeight)
    {
        BiomeGenBase biome = worldObj.getBiomeGenForCoords(x + chunkX * 16, z + chunkZ * 16);
        Block block  = data[index];

        if (block == Blocks.stone || block == biome.fillerBlock || block == biome.topBlock || this.fillerBlock.contains(block))
        {
            if (y < minHeight || y > maxCarvingDepth)
            {
                data[index] = biome.fillerBlock;
            }
            else
            {
                data[index] = null;

                //fake bedrock floor replacing solid blocks under the cave, unless there's air under that solid block
                if(index > 0 && data[index-1] != Blocks.air && (index == 1 || data[index-2] != Blocks.air))
                {
                    data[index-1] = DeeperBlocks.fakeBedrock;
                }

                //if there's fake bedrock floor directly above this block, remove it too
                if(index < data.length-1 && data[index+1] == DeeperBlocks.fakeBedrock)
                {
                    data[index+1] = null;
                }

                if (foundTop && (index & 255) != 0 && data[index - 1] == biome.fillerBlock)
                {
                    data[index - 1] = biome.topBlock;
                }
            }
        }
    }
}
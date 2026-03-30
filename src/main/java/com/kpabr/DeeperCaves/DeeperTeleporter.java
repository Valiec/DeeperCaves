package com.kpabr.DeeperCaves;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.util.MathHelper;
import net.minecraft.world.Teleporter;
import net.minecraft.world.WorldServer;

public class DeeperTeleporter extends Teleporter
{

    private final WorldServer worldServerInstance;
    private final Random random;
    public int[] ids = {DeeperCaves.worldgen.dropDimID, DeeperCaves.worldgen.mazeDimID, DeeperCaves.worldgen.crystalDimID, DeeperCaves.worldgen.compressedDimID, DeeperCaves.worldgen.bedrockPlainsDimID, DeeperCaves.worldgen.nearNetherDimID, DeeperCaves.worldgen.lavaDimID, DeeperCaves.worldgen.nearVoidDimID, DeeperCaves.worldgen.deepWorldDimID, DeeperCaves.worldgen.darknessDimID, DeeperCaves.worldgen.abandonedCavesDimID, DeeperCaves.worldgen.mutationDimID, DeeperCaves.worldgen.farVoidDimID, DeeperCaves.worldgen.forgottenDimID, DeeperCaves.worldgen.evilDimID, DeeperCaves.worldgen.finalLabyrinthDimID};
    public int[] caps = {252, 252, 147, 97, 160, 97, 47, 256, 72, 252, 97, 0, 235, 0, 147, 252};
    public int[] mins = {185, 185, 135, 90, 156, 90, 40, 235, 65, 185, 90, 0, 256, 0, 135, 185}; //the zeroes are placeholders

    public int[] capsLower = {16, 16, 16, 16, 160, 16, 16, 256, 16, 16, 16, 16, 256, 16, 16, 16};
    public int[] minsLower = {2, 2, 2, 2, 156, 2, 2, 235, 2, 2, 2, 2, 235, 2, 2, 2};
    public Block[] stones = {Blocks.stone, Blocks.stone, Blocks.stone, Blocks.stone, DeeperBlocks.fragmentedBedrock, Blocks.stone, Blocks.stone, Blocks.stone, Blocks.stone, DeeperBlocks.darkStone, DeeperBlocks.abandonedStone, DeeperBlocks.deepStone, DeeperBlocks.deepStone, DeeperBlocks.deepStone, DeeperBlocks.deepStone, DeeperBlocks.fragmentedBedrock};
    public int min;
    public int cap;
    public boolean isLower;
    public Block stone;

	public DeeperTeleporter(WorldServer p_i1963_1_, boolean isLower)
    {
        super(p_i1963_1_);
        this.isLower = isLower;
        this.worldServerInstance = p_i1963_1_;
        this.random = new Random(p_i1963_1_.getSeed());
        for(int i = 0; i<ids.length; i++)
        {
        	if(this.worldServerInstance.provider.dimensionId == ids[i])
        	{
                min = this.isLower ? minsLower[i] : mins[i];
                cap = this.isLower ? capsLower[i] : caps[i];
                stone = stones[i];
        		break;
        	}
        }
    }

    /**
     * Place an entity in a nearby portal, creating one if necessary.
     */
    public void placeInPortal(Entity p_77185_1_, double p_77185_2_, double p_77185_4_, double p_77185_6_, float p_77185_8_)
    {
    		
       
            int i = MathHelper.floor_double(p_77185_1_.posX);
            int j = this.min;
            int cap = this.cap;
            if(this.worldServerInstance.provider.dimensionId == 0)
            {
            j = MathHelper.floor_double(this.worldServerInstance.getTopSolidOrLiquidBlock((p_77185_1_.serverPosX), p_77185_1_.serverPosZ)) - 1;
            }
            else if(this.worldServerInstance.provider.dimensionId == DeeperCaves.worldgen.bedrockPlainsDimID)
            {
            j = DeeperCaves.worldgen.bedrockPlainsFloorHeight+2;
            }
            int k = MathHelper.floor_double(p_77185_1_.posZ);
            makePortal(p_77185_1_, cap, i, j, k);
    }
    public void makePortal(Entity entity, int cap, int i, int j, int k)
    {
        byte b0 = 16;

        int min = j;

        int baseX = i;
        int baseY = j;
        int baseZ = k;

        for (int testX = i - b0; testX <= i + b0; ++testX)
        {
            for (int testZ = k - b0; testZ <= k + b0; ++testZ)
            {
                int incr = this.isLower ? 1 : -1;
                int startY = this.isLower ? min : cap;
                int endY = this.isLower ? cap : min;
                for (int testY = startY; testY >= endY; testY+=incr)
                {
                    if(this.worldServerInstance.getBlock(testX, testY-1, testZ) != Blocks.air &&
                            this.worldServerInstance.getBlock(testX, testY, testZ) == Blocks.air &&
                            this.worldServerInstance.getBlock(testX, testY+1, testZ) != Blocks.air)
                    {
                        baseX = i;
                        baseY = j;
                        baseZ = k;
                        break;
                    }
                }
            }
        }

        for (int xCoord = baseX-1; xCoord <= baseX+1; ++xCoord)
        {
            for (int zCoord = baseZ-1; zCoord <= baseZ+1; ++zCoord)
            {
                for (int yCoord = baseY; yCoord <= baseY+2; ++yCoord)
                {
                    this.worldServerInstance.setBlock(xCoord, yCoord, zCoord, Blocks.air, 0, 2);
                }
            }
        }


        for (int xCoord = baseX-1; xCoord <= baseX+1; ++xCoord)
        {
            for (int zCoord = baseZ-1; zCoord <= baseZ+1; ++zCoord)
            {
                if(this.worldServerInstance.getBlock(xCoord, baseY-1, zCoord) == Blocks.air) {
                    this.worldServerInstance.setBlock(xCoord, baseY - 1, zCoord, stone, 0, 2);
                }
            }
        }

        entity.setPosition(baseX+0.5, baseY, baseZ+0.5);

    }

}
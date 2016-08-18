package com.kpabr.DeeperCaves;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.Direction;
import net.minecraft.util.LongHashMap;
import net.minecraft.util.MathHelper;
import net.minecraft.world.Teleporter;
import net.minecraft.world.WorldServer;

public class DeeperTeleporter extends Teleporter
{

    private WorldServer worldServerInstance;
    private final Random random;
    public int[] ids = {DeeperCaves.worldgen.dropDimID, DeeperCaves.worldgen.mazeDimID, DeeperCaves.worldgen.crystalDimID, DeeperCaves.worldgen.compressedDimID, DeeperCaves.worldgen.bedrockPlainsDimID, DeeperCaves.worldgen.nearNetherDimID, DeeperCaves.worldgen.lavaDimID, DeeperCaves.worldgen.nearVoidDimID, DeeperCaves.worldgen.deepWorldDimID, DeeperCaves.worldgen.darknessDimID, DeeperCaves.worldgen.abandonedCavesDimID, DeeperCaves.worldgen.mutationDimID, DeeperCaves.worldgen.farVoidDimID, DeeperCaves.worldgen.forgottenDimID, DeeperCaves.worldgen.evilDimID, DeeperCaves.worldgen.finalLabyrinthDimID};
    public int[] caps = {252, 252, 147, 97, 160, 97, 47, 235, 72, 252, 97, 0, 235, 0 ,147, 252};
    public int[] mins = {185, 185, 135, 90, 156, 90, 40, 256, 65, 185, 90, 0, 256, 0 ,135, 185}; //the zeroes are placholders
    public int min;
    public int cap;

	public DeeperTeleporter(WorldServer p_i1963_1_)
    {
        super(p_i1963_1_);
        this.worldServerInstance = p_i1963_1_;
        this.random = new Random(p_i1963_1_.getSeed());
        for(int i = 0; i<ids.length; i++)
        {
        	if(this.worldServerInstance.provider.dimensionId == ids[i])
        	{
                min = mins[i];
                cap = caps[i];
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
            else if(this.worldServerInstance.provider.dimensionId == DeeperCaves.worldgen.nearVoidDimID)
            {
            j = 235;
            }
            else if(this.worldServerInstance.provider.dimensionId == DeeperCaves.worldgen.farVoidDimID)
            {
            j = 235;
            }
            int k = MathHelper.floor_double(p_77185_1_.posZ);
            p_77185_1_.setPosition((double)i, (double)j+1, (double)k);
            byte b0 = 1;
            byte b1 = 0;
            boolean blockIsAir = false;
            makePortal(p_77185_1_, cap);
    }
    public boolean makePortal(Entity p_85188_1_, int cap)
    {
        byte b0 = 16;
        double d0 = -1.0D;
        int i = MathHelper.floor_double(p_85188_1_.posX);
        int j = MathHelper.floor_double(p_85188_1_.posY);
        int k = MathHelper.floor_double(p_85188_1_.posZ);
        int l = i;
        int i1 = j;
        int j1 = k;
        int k1 = 0;
        int l1 = this.random.nextInt(4);
        int i2;
        double d1;
        int k2;
        double d2;
        int i3;
        int j3;
        int k3;
        int l3;
        int i4;
        int j4;
        int k4;
        int l4;
        int i5;
        double d3;
        double d4;

        for (i2 = i - b0; i2 <= i + b0; ++i2)
        {
            d1 = (double)i2 + 0.5D - p_85188_1_.posX;

            for (k2 = k - b0; k2 <= k + b0; ++k2)
            {
                d2 = (double)k2 + 0.5D - p_85188_1_.posZ;
                label274:

                for (i3 = 195; i3 >= 0; --i3)
                {
                    if (this.worldServerInstance.isAirBlock(i2, i3, k2))
                    {
                        while (i3 > 0 && this.worldServerInstance.isAirBlock(i2, i3 - 1, k2))
                        {
                            --i3;
                        }

                        for (j3 = l1; j3 < l1 + 4; ++j3)
                        {
                            k3 = j3 % 2;
                            l3 = 1 - k3;

                            if (j3 % 4 >= 2)
                            {
                                k3 = -k3;
                                l3 = -l3;
                            }

                            for (i4 = 0; i4 < 3; ++i4)
                            {
                                for (j4 = 0; j4 < 4; ++j4)
                                {
                                    for (k4 = -1; k4 < 4; ++k4)
                                    {
                                        l4 = i2 + (j4 - 1) * k3 + i4 * l3;
                                        i5 = i3 + k4;
                                        int j5 = k2 + (j4 - 1) * l3 - i4 * k3;

                                        if (k4 < 0 && !this.worldServerInstance.getBlock(l4, i5, j5).getMaterial().isSolid() || k4 >= 0 && !this.worldServerInstance.isAirBlock(l4, i5, j5))
                                        {
                                            continue label274;
                                        }
                                    }
                                }
                            }

                            d3 = (double)i3 + 0.5D - p_85188_1_.posY;
                            d4 = d1 * d1 + d3 * d3 + d2 * d2;

                            if (d0 < 0.0D || d4 < d0)
                            {
                                d0 = d4;
                                l = i2;
                                i1 = i3;
                                j1 = k2;
                                k1 = j3 % 4;
                            }
                        }
                    }
                }
            }
        }

        if (d0 < 0.0D)
        {
            for (i2 = i - b0; i2 <= i + b0; ++i2)
            {
                d1 = (double)i2 + 0.5D - p_85188_1_.posX;

                for (k2 = k - b0; k2 <= k + b0; ++k2)
                {
                    d2 = (double)k2 + 0.5D - p_85188_1_.posZ;
                    label222:

                    for (i3 = 195 - 1; i3 >= 0; --i3)
                    {
                        if (this.worldServerInstance.isAirBlock(i2, i3, k2))
                        {
                            while (i3 > 0 && this.worldServerInstance.isAirBlock(i2, i3 - 1, k2))
                            {
                                --i3;
                            }

                            for (j3 = l1; j3 < l1 + 2; ++j3)
                            {
                                k3 = j3 % 2;
                                l3 = 1 - k3;

                                for (i4 = 0; i4 < 4; ++i4)
                                {
                                    for (j4 = -1; j4 < 4; ++j4)
                                    {
                                        k4 = i2 + (i4 - 1) * k3;
                                        l4 = i3 + j4;
                                        i5 = k2 + (i4 - 1) * l3;

                                        if (j4 < 0 && !this.worldServerInstance.getBlock(k4, l4, i5).getMaterial().isSolid() || j4 >= 0 && !this.worldServerInstance.isAirBlock(k4, l4, i5))
                                        {
                                            continue label222;
                                        }
                                    }
                                }

                                d3 = (double)i3 + 0.5D - p_85188_1_.posY;
                                d4 = d1 * d1 + d3 * d3 + d2 * d2;

                                if (d0 < 0.0D || d4 < d0)
                                {
                                    d0 = d4;
                                    l = i2;
                                    i1 = i3;
                                    j1 = k2;
                                    k1 = j3 % 2;
                                }
                            }
                        }
                    }
                }
            }
        }

        int k5 = l;
        int j2 = i1;
        k2 = j1;
        int l5 = k1 % 2;
        int l2 = 1 - l5;

        if (k1 % 4 >= 2)
        {
            l5 = -l5;
            l2 = -l2;
        }

        boolean flag;

        if (d0 < 0.0D)
        {
            if (i1 < 70)
            {
                i1 = 70;
            }

            if (i1 > cap)
            {
                i1 = cap;
            }

            j2 = i1;

            for (i3 = -1; i3 < 3; ++i3)
            {
                for (j3 = -1; j3 < 3; ++j3)
                {
                    for (k3 = -1; k3 < 3; ++k3)
                    {
                        l3 = k5 + (j3 - 1) * l5 + i3 * l2;
                        i4 = j2 + k3;
                        j4 = k2 + (j3 - 1) * l2 - i3 * l5;
                        flag = k3 < 0;
                        if(!flag)
                        {
                        this.worldServerInstance.setBlock(l3, i4, j4, Blocks.air);
                        }
                    }
                }
            }
        }

        for (i3 = 0; i3 < 4; ++i3)
        {
            for (j3 = 0; j3 < 4; ++j3)
            {
                for (k3 = -1; k3 < 4; ++k3)
                {
                    l3 = k5 + (j3 - 1) * l5;
                    i4 = j2 + k3;
                    j4 = k2 + (j3 - 1) * l2;
                    flag = j3 == 0 || j3 == 3 || k3 == -1 || k3 == 3;
                    if(j3 == 1 && k3 == 0)
                    {
                    p_85188_1_.setPosition(l3, i4, j4);
                    }
                    if(!flag)
                    {
                    this.worldServerInstance.setBlock(l3, i4, j4, (Block)(Blocks.air), 0, 2);
                    }
                }
            }

            for (j3 = 0; j3 < 4; ++j3)
            {
                for (k3 = -1; k3 < 4; ++k3)
                {
                    l3 = k5 + (j3 - 1) * l5;
                    i4 = j2 + k3;
                    j4 = k2 + (j3 - 1) * l2;
                    this.worldServerInstance.notifyBlocksOfNeighborChange(l3, i4, j4, this.worldServerInstance.getBlock(l3, i4, j4));
                }
            }
        }

        return true;
    }
    

 
}
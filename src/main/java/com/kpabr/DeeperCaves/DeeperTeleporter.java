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

	public DeeperTeleporter(WorldServer p_i1963_1_)
    {
        super(p_i1963_1_);
        this.worldServerInstance = p_i1963_1_;
    }

    /**
     * Place an entity in a nearby portal, creating one if necessary.
     */
    public void placeInPortal(Entity p_77185_1_, double p_77185_2_, double p_77185_4_, double p_77185_6_, float p_77185_8_)
    {
       
            int i = MathHelper.floor_double(p_77185_1_.posX);
            int j = MathHelper.floor_double(p_77185_1_.posY) - 1;
            int k = MathHelper.floor_double(p_77185_1_.posZ);
            byte b0 = 1;
            byte b1 = 0;

            for (int l = -2; l <= 2; ++l)
            {
                for (int i1 = -2; i1 <= 2; ++i1)
                {
                    for (int j1 = -1; j1 < 3; ++j1)
                    {
                        int k1 = i + i1 * b0 + l * b1;
                        int l1 = j + j1;
                        int i2 = k + i1 * b1 - l * b0;
                        boolean flag = j1 < 0;
                        this.worldServerInstance.setBlock(k1, l1, i2, flag ? Blocks.obsidian : Blocks.air);
                    }
                }
            }
    }
    

 
}
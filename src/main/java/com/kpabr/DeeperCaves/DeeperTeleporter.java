package com.kpabr.DeeperCaves;

import java.util.Random;

import com.kpabr.DeeperCaves.world.DeeperLayer;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.util.MathHelper;
import net.minecraft.world.Teleporter;
import net.minecraft.world.WorldServer;

import static java.lang.Math.abs;

public class DeeperTeleporter extends Teleporter
{

    private final WorldServer worldServerInstance;
    private final Random random;
    //public int[] ids = {DeeperCaves.worldgen.drop.dimID, DeeperCaves.worldgen.maze.dimID, DeeperCaves.worldgen.crystal.dimID, DeeperCaves.worldgen.compressed.dimID, DeeperCaves.worldgen.bedrockPlains.dimID, DeeperCaves.worldgen.nearNether.dimID, DeeperCaves.worldgen.lava.dimID, DeeperCaves.worldgen.nearVoid.dimID, DeeperCaves.worldgen.deepWorld.dimID, DeeperCaves.worldgen.darkness.dimID, DeeperCaves.worldgen.abandonedCaves.dimID, DeeperCaves.worldgen.mutation.dimID, DeeperCaves.worldgen.farVoid.dimID, DeeperCaves.worldgen.forgotten.dimID, DeeperCaves.worldgen.evil.dimID, DeeperCaves.worldgen.finalLabyrinth.dimID};
    //public int[] caps = {197, 197, 147, 97, DeeperConfig.bedrockPlainsCeilingHeight+3, 97, 47, 242, 72, 242, 97, 97, 242, 227, 97, 242};
    //public int[] mins = {185, 185, 135, 90, DeeperConfig.bedrockPlainsFloorHeight-8, 90, 40, 235, 65, 185, 90, 90, 235, 185, 90, 185};

    //public int[] capsLower = {16, 16, 16, 16, DeeperCaves.worldgen.bedrockPlainsCeilingHeight+3, 16, 16, 242, 16, 16, 16, 16, 242, 16, 16, 16};
    //public int[] minsLower = {2, 2, 2, 2, DeeperCaves.worldgen.bedrockPlainsFloorHeight-8, 2, 2, 235, 2, 2, 2, 2, 235, 2, 2, 2};
    //public Block[] stones = {Blocks.stone, Blocks.stone, Blocks.stone, Blocks.stone, DeeperBlocks.fragmentedBedrock, Blocks.stone, Blocks.stone, Blocks.stone, Blocks.stone, DeeperBlocks.darkStone, DeeperBlocks.abandonedStone, DeeperBlocks.deepStone, DeeperBlocks.deepStone, DeeperBlocks.deepStone, DeeperBlocks.deepStone, DeeperBlocks.fragmentedBedrock};
    public int min;
    public int cap;
    public boolean isLower;
    public boolean isReturnPortal;
    public Block stone;

    public DeeperTeleporter(WorldServer worldServer, boolean isLower, boolean isReturnPortal)
    {
        this(worldServer, isLower);
        this.isReturnPortal = isReturnPortal;
    }

	public DeeperTeleporter(WorldServer worldServer, boolean isLower)
    {
        super(worldServer);
        this.isLower = isLower;
        this.isReturnPortal = false;
        this.worldServerInstance = worldServer;
        this.random = new Random(worldServer.getSeed());

        //this.handleBedrockPlainsConfig();

        for(DeeperLayer layer: DeeperLayer.deeperLayers)
        {
        	if(this.worldServerInstance.provider.dimensionId == layer.dimID)
        	{
                min = this.isLower ? layer.arrivalMinLower : layer.arrivalMinUpper;
                cap = this.isLower ? layer.arrivalCapLower : layer.arrivalCapUpper;
                stone = layer.stoneBlock;
        		break;
        	}
        }
    }

    /*public void handleBedrockPlainsConfig() {
        int cap = DeeperCaves.worldgen.bedrockPlainsFloorHeight+5;
        int min = DeeperCaves.worldgen.bedrockPlainsFloorHeight+1;

        int capLower = DeeperCaves.worldgen.bedrockPlainsFloorHeight+5;
        int minLower = DeeperCaves.worldgen.bedrockPlainsFloorHeight+1;

        caps[4] = cap;
        mins[4] = min;

        capsLower[4] = capLower;
        minsLower[4] = minLower;
    }*/

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
                if(this.isReturnPortal) {
                    j = MathHelper.floor_double(this.worldServerInstance.getTopSolidOrLiquidBlock(((int) p_77185_1_.posX), (int) p_77185_1_.posZ));
                    cap = 255;
                }
                else {
                    j = 1;
                    cap = 255;
                }
            }
            //else if(this.worldServerInstance.provider.dimensionId == DeeperCaves.worldgen.bedrockPlains.dimID)
            //{
            //j = DeeperCaves.worldgen.bedrockPlainsFloorHeight+2;
            //}
            int k = MathHelper.floor_double(p_77185_1_.posZ);
            makePortal(p_77185_1_, cap, i, j, k);
    }

    public boolean isValidGround(Block block) {
        return block != Blocks.air && block != Blocks.water && block != Blocks.lava && block != DeeperBlocks.magmaStone && block != Blocks.flowing_water && block != Blocks.flowing_lava;
    }

    public boolean isPositionValid(int testX, int testY, int testZ) {
        return this.worldServerInstance.getBlock(testX, testY+1, testZ) == Blocks.air &&
                this.worldServerInstance.getBlock(testX, testY, testZ) == Blocks.air &&
                this.isValidGround(this.worldServerInstance.getBlock(testX, testY-1, testZ));
    }


    public void makePortal(Entity entity, int cap, int i, int j, int k)
    {
        int maxRadius = 32;

        int min = j;

        int baseX = i;
        int baseY = j;
        int baseZ = k;

        boolean pos_ok = false;

        System.out.println("attempting TP to: "+i+","+k+" between y="+min+" and y="+cap+" in "+this.worldServerInstance.provider.getDimensionName());


        pos_scan:
        for (int radius = 0; radius <= maxRadius; radius++)
        {

            int testX = baseX - radius;

            while (testX <= baseX + radius) {

                int testZ = baseZ - radius;

                while (testZ <= baseZ + radius) {

                    if (abs(testX-baseX) < radius && abs(testZ-baseZ) < radius) {
                        testZ = baseZ + radius;
                        //skip middle
                    }

                    int incr = this.isLower ? 1 : -1;
                    int startY = this.isLower ? min : cap;
                    int endY = this.isLower ? cap : min;
                    for (int testY = startY; (testY >= endY && !this.isLower) || (testY <= endY && this.isLower); testY += incr) {
                        if (isPositionValid(testX, testY, testZ)) {
                            baseX = testX;
                            baseY = testY;
                            baseZ = testZ;
                            pos_ok = true;
                            break pos_scan;
                        }
                    }
                    testZ++;
                }
                testX++;
            }
        }

        if(!pos_ok) {

            for (int xCoord = baseX - 1; xCoord <= baseX + 1; ++xCoord) {
                for (int zCoord = baseZ - 1; zCoord <= baseZ + 1; ++zCoord) {
                    for (int yCoord = baseY; yCoord <= baseY + 2; ++yCoord) {
                        this.worldServerInstance.setBlock(xCoord, yCoord, zCoord, Blocks.air, 0, 2);
                    }
                }
            }


            for (int xCoord = baseX - 1; xCoord <= baseX + 1; ++xCoord) {
                for (int zCoord = baseZ - 1; zCoord <= baseZ + 1; ++zCoord) {
                    if (this.worldServerInstance.getBlock(xCoord, baseY - 1, zCoord) == Blocks.air) {
                        this.worldServerInstance.setBlock(xCoord, baseY - 1, zCoord, stone, 0, 2);
                    }
                }
            }

        }

        System.out.println("placing at: "+(baseX+0.5)+","+(baseY)+","+(baseZ+0.5)+" in "+this.worldServerInstance.provider.getDimensionName());
        entity.setLocationAndAngles(baseX+0.5, baseY, baseZ+0.5, entity.rotationYaw, entity.rotationPitch);
        entity.motionX = entity.motionY = entity.motionZ = 0.0D;
    }
}
package com.kpabr.DeeperCaves.world.provider;


import com.kpabr.DeeperCaves.DeeperCaves;
import com.kpabr.DeeperCaves.world.chunk.ChunkProviderAbandonedCaves;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;
public class WorldProviderAbandonedCaves extends WorldProvider
{
    /**
     * creates a new world chunk manager for WorldProvider
     */
    public void registerWorldChunkManager()
    {
        this.worldChunkMgr = new WorldChunkManagerHell(DeeperCaves.worldgen.biomeAbandonedCaves, 0.5F);
        this.dimensionId = DeeperCaves.worldgen.abandonedCavesDimID;
        this.hasNoSky = true;
    }

    /**
     * Returns a new chunk provider which generates chunks for this world
     */
    public IChunkProvider createChunkGenerator()
    {
        //return new ChunkProviderEnder(this.worldObj, this.worldObj.getSeed());
    	return new ChunkProviderAbandonedCaves(this.worldObj, this.worldObj.getSeed()+11, true);
    }

    /**
     * Calculates the angle of sun and moon in the sky relative to a specified time (usually worldTime)
     */
    public float calculateCelestialAngle(long par1, float par3)
    {
        return 0.0F;
    }


    /**
     * Returns array with sunrise/sunset colors
     */
    @SideOnly(Side.CLIENT)
    public float[] calcSunriseSunsetColors(float par1, float par2)
    {
        return null;
    }

    @SideOnly(Side.CLIENT)
    public boolean isSkyColored()
    {
        return false;
    }
    
    /*public double getVoidFogYFactor()
    {
    	return 0.5859375;
    }*/

    /**
     * True if the player can respawn in this dimension (true = overworld, false = nether).
     */
    public boolean canRespawnHere()
    {
        return false;
    }

    /**
     * Returns 'true' if in the "main surface world", but 'false' if in the Nether or End dimensions.
     */
    public boolean isSurfaceWorld()
    {
        return false;
    }


    /**
     * the y level at which clouds are rendered.
     */
    @SideOnly(Side.CLIENT)
    public float getCloudHeight()
    {
        return 8.0F;
    }

    /**
     * Will check if the x, z position specified is alright to be set as the map spawn point
     */
    public boolean canCoordinateBeSpawn(int par1, int par2)
    {
        Block k = this.worldObj.getTopBlock(par1, par2);
        return k == Blocks.air;// ? false : k..blocksMovement();
    }

    public int getAverageGroundLevel()
    {
        return 200;
    }

    /**
     * Returns true if the given X,Z coordinate should show environmental fog.
     */
    @SideOnly(Side.CLIENT)
    public boolean doesXZShowFog(int par1, int par2)
    {
        return false;
    }

    /**
     * Returns the dimension's name, e.g. "The End", "Nether", or "Overworld".
     */
    public String getDimensionName()
    {
        return "Abandoned Caves";
    }
}

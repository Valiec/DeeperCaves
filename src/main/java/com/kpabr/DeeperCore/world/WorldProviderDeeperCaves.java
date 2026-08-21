package com.kpabr.DeeperCore.world;

import com.kpabr.DeeperCore.dimstack.DeeperLayer;
import com.kpabr.DeeperCore.world.chunk.ChunkProviderDeeperBase;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class WorldProviderDeeperCaves extends WorldProviderDeeperBase
{

    public WorldProviderDeeperCaves(DeeperLayer layer) {
        super(layer);
    }

    /**
     * creates a new world chunk manager for WorldProvider
     */
    public void registerWorldChunkManager()
    {
        this.worldChunkMgr = new WorldChunkManagerHell(this.layer.biome, 0.5F);
        this.dimensionId = this.layer.dimID;
        this.hasNoSky = true;
    }

    /**
     * Returns a new chunk provider which generates chunks for this world
     */
    public IChunkProvider createChunkGenerator()
    {
        //return new ChunkProviderEnder(this.worldObj, this.worldObj.getSeed());

        try {
            Constructor<? extends IChunkProvider> constructor = layer.chunkProvider.getConstructor(World.class, long.class, boolean.class);
            return constructor.newInstance(this.worldObj, this.worldObj.getSeed()+this.layer.seedOffset, true);
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * Calculates the angle of sun and moon in the sky relative to a specified time (usually worldTime)
     */
    public float calculateCelestialAngle(long par1, float par3)
    {
        return 0.0F;
    }

    @SideOnly(Side.CLIENT)

    /**
     * Returns array with sunrise/sunset colors
     */
    public float[] calcSunriseSunsetColors(float par1, float par2)
    {
        return null;
    }

    @SideOnly(Side.CLIENT)
    public boolean isSkyColored()
    {
        return false;
    }

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

    @SideOnly(Side.CLIENT)

    /**
     * the y level at which clouds are rendered.
     */
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
        return this.layer.maxY;
    }

    @SideOnly(Side.CLIENT)

    /**
     * Returns true if the given X,Z coordinate should show environmental fog.
     */
    public boolean doesXZShowFog(int par1, int par2)
    {
        return false;
    }

    /**
     * Returns the dimension's name, e.g. "The End", "Nether", or "Overworld".
     */
    public String getDimensionName() {
        return this.layer.layerName;
    }
}

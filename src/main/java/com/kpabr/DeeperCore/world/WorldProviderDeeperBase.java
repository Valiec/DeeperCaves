package com.kpabr.DeeperCore.world;

import com.kpabr.DeeperCore.dimstack.DeeperLayer;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public abstract class WorldProviderDeeperBase extends WorldProvider
{

    public DeeperLayer layer;
    public boolean hasConstantFog = true;
    public int skyColor = 0x808080;
    public int fogColor = 0x808080;


    public WorldProviderDeeperBase(DeeperLayer layer) {
        super();
        this.layer = layer;

    }

    @SideOnly(Side.CLIENT)
    public Vec3 getSkyColor(Entity cameraEntity, float partialTicks)
    {
        double r = (this.skyColor >> 16 & 255)/255.0;
        double g = (this.skyColor >> 8 & 255)/255.0;
        double b = (this.skyColor & 255)/255.0;
        return Vec3.createVectorHelper(r, g, b);
    }

    public double getVoidFogYFactor()
    {
        return 1.0;
    }

    @SideOnly(Side.CLIENT)
    public Vec3 getFogColor(float p_76562_1_, float p_76562_2_)
    {
        double r = (this.fogColor >> 16 & 255)/255.0;
        double g = (this.fogColor >> 8 & 255)/255.0;
        double b = (this.fogColor & 255)/255.0;
        if(!this.hasConstantFog) {

            float f2 = MathHelper.cos(p_76562_1_ * (float) Math.PI * 2.0F) * 2.0F + 0.5F;

            if (f2 < 0.0F) {
                f2 = 0.0F;
            }

            if (f2 > 1.0F) {
                f2 = 1.0F;
            }

            r *= f2 * 0.94F + 0.06F;
            g *= f2 * 0.94F + 0.06F;
            b *= f2 * 0.91F + 0.09F;
        }
        return Vec3.createVectorHelper(r, g, b);
    }
}

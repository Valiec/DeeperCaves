package com.kpabr.DeeperCore.world;

import com.kpabr.DeeperCore.dimstack.DeeperLayer;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.WorldProvider;

public abstract class WorldProviderDeeperBase extends WorldProvider
{

    public DeeperLayer layer;
    public boolean hasConstantFog = true;
    public int skyColor;
    public int fogColor;
    public boolean weather;


    public WorldProviderDeeperBase(DeeperLayer layer) {
        super();
        this.layer = layer;
        this.skyColor = this.layer.skyColor;
        this.fogColor = this.layer.fogColor;
        this.weather = this.layer.weather;
    }

    @Override
    public void calculateInitialWeather()
    {
        //if weather is enabled
        if(weather)
        {
            super.calculateInitialWeather();
        }
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
    public Vec3 getBaseFogColor(float celestialAngle, float partialTicks)
    {
        double r = (this.fogColor >> 16 & 255)/255.0;
        double g = (this.fogColor >> 8 & 255)/255.0;
        double b = (this.fogColor & 255)/255.0;
        return Vec3.createVectorHelper(r, g, b);
    }

    public static Vec3 interpolate(Vec3 v1, Vec3 v2, double frac)
    {
        double newX = interpolate(v1.xCoord, v2.xCoord, frac);
        double newY = interpolate(v1.yCoord, v2.yCoord, frac);
        double newZ = interpolate(v1.zCoord, v2.zCoord, frac);

        return Vec3.createVectorHelper(newX, newY, newZ);
    }

    public static double interpolate(double d1, double d2, double frac)
    {
        return d1 + (Math.abs(d2 - d1)*frac*(d1 < d2 ? 1 : -1));
    }

    @SideOnly(Side.CLIENT)
    public Vec3 getFogColor(float celestialAngle, float partialTicks)
    {
        Vec3 baseFog = getBaseFogColor(celestialAngle, partialTicks);
        if(!this.hasConstantFog) {

            double r = baseFog.xCoord;
            double g = baseFog.yCoord;
            double b = baseFog.zCoord;
            float f2 = MathHelper.cos(celestialAngle * (float) Math.PI * 2.0F) * 2.0F + 0.5F;

            if (f2 < 0.0F) {
                f2 = 0.0F;
            }

            if (f2 > 1.0F) {
                f2 = 1.0F;
            }

            r *= f2 * 0.94F + 0.06F;
            g *= f2 * 0.94F + 0.06F;
            b *= f2 * 0.91F + 0.09F;

            return Vec3.createVectorHelper(r, g, b);
        }
        else
        {
            return baseFog;
        }
    }
}

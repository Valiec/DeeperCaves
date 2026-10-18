package com.kpabr.DeeperCaves.world.provider;


import com.kpabr.DeeperCaves.DeeperCaves;
import com.kpabr.DeeperCaves.DeeperConfig;
import com.kpabr.DeeperCore.world.WorldProviderDeeperCaves;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.util.Vec3;

public class WorldProviderEvil extends WorldProviderDeeperCaves
{

    public int fogActive;

    public WorldProviderEvil() {
        super(DeeperCaves.worldgen.evil);
        this.fogActive = DeeperConfig.forgottenActiveFogColor;
    }

    @SideOnly(Side.CLIENT)
    public Vec3 getSkyColor(Entity cameraEntity, float partialTicks)
    {
        return this.getBaseFogColor(0.0F, partialTicks);
        //celestialAngle is not used
    }

    @Override
    @SideOnly(Side.CLIENT)
    public Vec3 getBaseFogColor(float celestialAngle, float partialTicks)
    {

        double r = (this.fogColor >> 16 & 255)/255.0;
        double g = (this.fogColor >> 8 & 255)/255.0;
        double b = (this.fogColor & 255)/255.0;

        Vec3 baseColor = Vec3.createVectorHelper(r, g, b);

        r = (this.fogActive >> 16 & 255)/255.0;
        g = (this.fogActive >> 8 & 255)/255.0;
        b = (this.fogActive & 255)/255.0;

        Vec3 activeColor = Vec3.createVectorHelper(r, g, b);

        double frac = 0;

        double worldTimePartial = this.worldObj.getWorldTime()+partialTicks;

        double cycleProgress = (((worldTimePartial % 17000) / 17000.0) + 0.2) % 1.0;

        if(cycleProgress <= 0.5) {
            frac = (0.5-cycleProgress)*2;
        }

        else if(cycleProgress > 0.5) {
            frac = (cycleProgress-0.5)*2;
        }

        return interpolate(baseColor, activeColor, frac);
    }
}

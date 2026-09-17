package com.kpabr.DeeperCaves.client;


import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

public class ParticleSpore extends DeeperParticleBase {

    public float getParticleSize(float partialTicks) {
        return this.particleScale;
    }

    public ParticleSpore(World world, double srcX, double srcY, double srcZ)
    {
        this(world, srcX, srcY, srcZ, 0.0, 0.0, 0.0, 100);
        this.particleMaxAge = 100;
        this.particleScale = 0.01F;

        this.motionX = (double)((float)(Math.random() * 2.0D - 1.0D) * 0.4F);
        this.motionY = (double)((float)(Math.random() * 2.0D - 1.0D) * 0.4F);
        this.motionZ = (double)((float)(Math.random() * 2.0D - 1.0D) * 0.4F);
        float f = (float)(Math.random() + Math.random() + 1.0D) * 0.015F;
        float f1 = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionY * this.motionY + this.motionZ * this.motionZ);
        this.motionX = this.motionX / (double)f1 * (double)f * 0.4000000059604645D;
        this.motionY = this.motionY / (double)f1 * (double)f * 0.4000000059604645D;
        this.motionZ = this.motionZ / (double)f1 * (double)f * 0.4000000059604645D;
    }

    public void doUpdate() {
        super.doUpdate();

    }

    public ParticleSpore(World world, double srcX, double srcY, double srcZ, double motionX, double motionY, double motionZ, int lifetime)
    {
        super(world, srcX, srcY, srcZ, motionX, motionY, motionZ);
        this.setupVariedTexture(new ResourceLocation("deepercaves:particles/spore.png"), 3);
        this.particleMaxAge = lifetime;
    }

    public int getBrightnessForRender(float p_70070_1_)
    {
        return 15728880;
    }

    public void renderParticle(Tessellator tessellator, float partialTicks, float rotationX, float rotationXZ, float rotationZ, float rotationYZ, float rotationXY)
    {
        super.renderParticle(tessellator, partialTicks, rotationX, rotationXZ, rotationZ, rotationYZ, rotationXY);
    }
}

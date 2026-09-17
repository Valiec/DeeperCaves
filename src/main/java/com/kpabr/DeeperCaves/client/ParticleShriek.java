package com.kpabr.DeeperCaves.client;


import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

public class ParticleShriek extends DeeperParticleBase {


    public ParticleShriek(World world, double srcX, double srcY, double srcZ, int delay)
    {
        this(world, srcX, srcY, srcZ, 0.0, 0.0, 0.0, 1);
        this.motionX = 0;
        this.motionY = 0.1;
        this.motionZ = 0;
        this.particleMaxAge = 100;
        this.delay = delay;
        this.particleScale = 0.85F;
        //System.out.println("INIT WITH: "+srcX+", "+srcY+", "+srcZ+" -> at "+motionX+", "+motionY+", "+motionZ);

    }

    public float getParticleSize(float partialTicks) {
        float scaleFactor = ((this.particleAge + partialTicks) / this.particleMaxAge) * 0.75F;
        if(scaleFactor < 0.0)
        {
            scaleFactor = 0.0F;
        }
        if(scaleFactor > 1.0F) {
            scaleFactor = 1.0F;
        }
        return this.particleScale * scaleFactor;
    }

    public ParticleShriek(World world, double srcX, double srcY, double srcZ, double motionX, double motionY, double motionZ, int lifetime)
    {
        super(world, srcX, srcY, srcZ, motionX, motionY, motionZ);
        this.setupTexture(new ResourceLocation("deepercaves:particles/shriek.png"));
        this.particleMaxAge = lifetime;
        this.noClip = true;
    }

    public void doUpdate() {
        super.doUpdate();

    }

    public void renderParticle(Tessellator tessellator, float partialTicks, float rotationX, float rotationXZ, float rotationZ, float rotationYZ, float rotationXY)
    {
        if(this.delay <= 0) {
            this.particleAlpha = 1.0F - ((this.particleAge + partialTicks) / this.particleMaxAge);
            if(this.particleAlpha < 0.0F) {
                this.particleAlpha = 0.0F;
            }
            if(this.particleAlpha > 1.0F) {
                this.particleAlpha = 1.0F;
            }

            //turn off backface culling so I don't have to do this twice
            GL11.glDisable(GL11.GL_CULL_FACE);
            //compute angles using the same logic vanilla does for the camera
            float[] angles = computeWorldRotation(-60.0F, 0.0F);
            this.doRenderParticle(tessellator, partialTicks, angles[0], angles[1], angles[2], angles[3], angles[4]);
            GL11.glEnable(GL11.GL_CULL_FACE);
        }
    }

    public int getBrightnessForRender(float p_70070_1_)
    {
        return 15728880;
    }
}

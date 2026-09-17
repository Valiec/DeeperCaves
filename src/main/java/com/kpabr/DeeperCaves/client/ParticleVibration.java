package com.kpabr.DeeperCaves.client;


import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.IIcon;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

public class ParticleVibration extends DeeperParticleBase {

    double dirX;
    double dirY;
    double dirZ;

    double dist3D;

    public ParticleVibration(World world, double srcX, double srcY, double srcZ, double destX, double destY, double destZ)
    {
        this(world, srcX, srcY, srcZ, destX, destY, destZ, 1.0F);

    }

    public float getParticleSize(float partialTicks) {
        return this.particleScale;
    }

    public ParticleVibration(World world, double srcX, double srcY, double srcZ, double destX, double destY, double destZ, double speedMul)
    {
        this(world, srcX, srcY, srcZ, 0.0, 0.0, 0.0, 1);
        double distX = destX - srcX;
        double distY = destY - srcY;
        double distZ = destZ - srcZ;
        double dist3D = Math.sqrt((distX * distX) + (distY * distY) + (distZ * distZ));
        double tickTime = dist3D * speedMul;
        this.motionX = distX/tickTime;
        this.motionY = distY/tickTime;
        this.motionZ = distZ/tickTime;
        this.particleMaxAge = (int)Math.ceil(tickTime);
        this.particleScale = 0.3F;

        this.dirX = distX/dist3D;
        this.dirY = distY/dist3D;
        this.dirZ = distZ/dist3D;
        this.dist3D = dist3D;
        this.globalFrame = true;

    }

    public void doUpdate() {
        super.doUpdate();

    }

    public ParticleVibration(World world, double srcX, double srcY, double srcZ, double motionX, double motionY, double motionZ, int lifetime)
    {
        super(world, srcX, srcY, srcZ, motionX, motionY, motionZ);
        this.setupAnimatedTexture(new ResourceLocation("deepercaves:particles/vibration.png"), 7, 1);
        this.particleMaxAge = lifetime;
        this.noClip = true;
    }

    public int getBrightnessForRender(float p_70070_1_)
    {
        return 15728880;
    }

    public void renderParticle(Tessellator tessellator, float partialTicks, float rotationX, float rotationXZ, float rotationZ, float rotationYZ, float rotationXY)
    {
        //compute angles using the same logic vanilla does for the camera
        //Math.PI/2.0 addition based on vanilla
        //actually this sort of does it twice because I don't fully get vanilla's
        //computing pitch/yaw from a vector, and then back to what seems to be vector components
        double pitch = (((-Math.asin(this.dirY))+ Math.PI/2.0)/Math.PI)*180.0;
        double yaw = ((-Math.atan2(this.dirX, this.dirZ))/Math.PI)*180.0;

        float[] angles = computeWorldRotation((float)pitch, (float)yaw);
        //turn off backface culling so I don't have to do this twice
        GL11.glDisable(GL11.GL_CULL_FACE);
        super.renderParticle(tessellator, partialTicks, angles[0], angles[1], angles[2], angles[3], angles[4]);
        GL11.glEnable(GL11.GL_CULL_FACE);
    }
}

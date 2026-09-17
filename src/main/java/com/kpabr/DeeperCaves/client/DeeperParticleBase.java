package com.kpabr.DeeperCaves.client;


import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

public class DeeperParticleBase extends EntityFX {

    public ResourceLocation texture;
    public int frameCount;
    public int frameTime;
    public int frameCycleTime;
    public int delay;
    public boolean globalFrame = false;

    public DeeperParticleBase(World world, double srcX, double srcY, double srcZ, double motionX, double motionY, double motionZ)
    {
        super(world, srcX, srcY, srcZ, motionX, motionY, motionZ);
    }

    public DeeperParticleBase(World world, double srcX, double srcY, double srcZ, double motionX, double motionY, double motionZ, int delay)
    {
        super(world, srcX, srcY, srcZ, motionX, motionY, motionZ);
        this.delay = delay;
    }

    public void onUpdate()
    {
        if(this.delay > 0)
        {
            delay--;
        }
        else {
            this.doUpdate();
        }
    }

    public void doUpdate() {
        super.onUpdate();
    }


    public DeeperParticleBase setupTexture(ResourceLocation texture)
    {
        this.texture = texture;
        this.frameCount = 1;
        return this;
    }

    public DeeperParticleBase setupAnimatedTexture(ResourceLocation texture, int frameCount, int frameTime)
    {
        this.setupTexture(texture);
        this.frameCount = frameCount;
        this.frameTime = frameTime;
        this.frameCycleTime = frameCount*frameTime;
        return this;
    }

    public float getParticleSize(float partialTicks) {
        return 0.1F * this.particleScale;
    }

    public int getFXLayer()
    {
        return 3;
    }

    public float[] computeWorldRotation(float rotationPitch, float rotationYaw) {
        //vanilla camera rotation logic, but in a function
        float rotationX = MathHelper.cos(rotationYaw * (float)Math.PI / 180.0F);
        float rotationZ = MathHelper.sin(rotationYaw * (float)Math.PI / 180.0F);
        float rotationYZ = -rotationZ * MathHelper.sin(rotationPitch * (float)Math.PI / 180.0F);
        float rotationXY = rotationX * MathHelper.sin(rotationPitch * (float)Math.PI / 180.0F);
        float rotationXZ = MathHelper.cos(rotationPitch * (float)Math.PI / 180.0F);
        return new float[]{rotationX, rotationXZ, rotationZ, rotationYZ, rotationXY};

    }

    public void renderParticle(Tessellator tessellator, float partialTicks, float rotationX, float rotationXZ, float rotationZ, float rotationYZ, float rotationXY)
    {
       this.doRenderParticle(tessellator, partialTicks, rotationX, rotationXZ, rotationZ, rotationYZ, rotationXY);
    }

    public void doRenderParticle(Tessellator tessellator, float partialTicks, float rotationX, float rotationXZ, float rotationZ, float rotationYZ, float rotationXY)
    {

        double frameHeight = 1;
        int frameNum = 0;

        if(frameCount > 1) {
            double exactAge;
            if(this.globalFrame) {
                exactAge = Minecraft.getMinecraft().theWorld.getWorldTime() + partialTicks;
            }
            else {
                exactAge = this.particleAge + partialTicks;
            }


            frameNum = (int) Math.floor((exactAge % this.frameCycleTime) / frameTime);

            frameHeight = 1.0 / frameCount;
        }

        Minecraft.getMinecraft().renderEngine.bindTexture(this.texture);


        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glDepthMask(false);
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        GL11.glAlphaFunc(GL11.GL_GREATER, 0.003921569F);
        tessellator.startDrawingQuads();
        tessellator.setBrightness(this.getBrightnessForRender(partialTicks));


        double minU = 0;
        double maxU = 1;
        double minV = frameHeight*frameNum;
        double maxV = frameHeight*(frameNum+1);


        float f10 = this.getParticleSize(partialTicks);

        float f11 = (float)(this.prevPosX + (this.posX - this.prevPosX) * (double)partialTicks - interpPosX);
        float f12 = (float)(this.prevPosY + (this.posY - this.prevPosY) * (double)partialTicks - interpPosY);
        float f13 = (float)(this.prevPosZ + (this.posZ - this.prevPosZ) * (double)partialTicks - interpPosZ);
        tessellator.setColorRGBA_F(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha);
        tessellator.addVertexWithUV((double)(f11 - rotationX * f10 - rotationYZ * f10), (double)(f12 - rotationXZ * f10), (double)(f13 - rotationZ * f10 - rotationXY * f10), (double)maxU, (double)maxV);
        tessellator.addVertexWithUV((double)(f11 - rotationX * f10 + rotationYZ * f10), (double)(f12 + rotationXZ * f10), (double)(f13 - rotationZ * f10 + rotationXY * f10), (double)maxU, (double)minV);
        tessellator.addVertexWithUV((double)(f11 + rotationX * f10 + rotationYZ * f10), (double)(f12 + rotationXZ * f10), (double)(f13 + rotationZ * f10 + rotationXY * f10), (double)minU, (double)minV);
        tessellator.addVertexWithUV((double)(f11 + rotationX * f10 - rotationYZ * f10), (double)(f12 - rotationXZ * f10), (double)(f13 + rotationZ * f10 - rotationXY * f10), (double)minU, (double)maxV);

        tessellator.draw();

        GL11.glDisable(GL11.GL_BLEND);
        GL11.glDepthMask(true);
        GL11.glAlphaFunc(GL11.GL_GREATER, 0.1F);

    }
}

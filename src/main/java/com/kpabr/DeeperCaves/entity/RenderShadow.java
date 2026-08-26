package com.kpabr.DeeperCaves.entity;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RenderShadow extends RenderBiped {

	private static final ResourceLocation texture = new ResourceLocation("deepercaves:mobs/shadow.png");
	/**
	 * @param par1ModelBiped
	 * @param par2
	 */
	public RenderShadow(ModelBiped par1ModelBiped, float par2) {
		super(par1ModelBiped, par2);
	}



	@Override
	protected void preRenderCallback(EntityLivingBase par1Entity, float p_77041_2_)
	{
		float scaleFactor = ((EntityShadow)par1Entity).num;
		GL11.glScalef(scaleFactor, scaleFactor, scaleFactor);
	}

	@Override
	public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
	{
		super.doRender(par1Entity, par2, par4, par6, par8, par9);
		this.bindEntityTexture(par1Entity);
	}

	/**
	 * @param par1ModelBiped
	 * @param par2
	 * @param par3
	 */
	public RenderShadow(ModelBiped par1ModelBiped, float par2, float par3) {
		super(par1ModelBiped, par2, par3);
	}
	@Override
	
	
	protected ResourceLocation getEntityTexture(Entity a)
	{
		return texture;
	}


}

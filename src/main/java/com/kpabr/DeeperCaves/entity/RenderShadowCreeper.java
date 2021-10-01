package com.kpabr.DeeperCaves.entity;

import net.minecraft.client.renderer.entity.RenderCreeper;
import net.minecraft.client.renderer.entity.RenderSpider;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.util.ResourceLocation;

public class RenderShadowCreeper extends RenderCreeper {
	private static final ResourceLocation caveSpiderTextures = new ResourceLocation("deepercaves:mobs/shadow_creeper.png");

@Override
protected ResourceLocation getEntityTexture(EntityCreeper p_110775_1_)
{
    return caveSpiderTextures;
}
@Override
protected ResourceLocation getEntityTexture(Entity p_110775_1_)
{
    return caveSpiderTextures;
}
}

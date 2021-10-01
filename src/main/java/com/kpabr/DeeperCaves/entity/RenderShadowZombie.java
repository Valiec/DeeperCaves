package com.kpabr.DeeperCaves.entity;

import net.minecraft.client.renderer.entity.RenderSpider;
import net.minecraft.client.renderer.entity.RenderZombie;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.util.ResourceLocation;

public class RenderShadowZombie extends RenderZombie {
	private static final ResourceLocation caveSpiderTextures = new ResourceLocation("deepercaves:mobs/shadow_zombie.png");

@Override
protected ResourceLocation getEntityTexture(EntityZombie p_110775_1_)
{
    return caveSpiderTextures;
}
@Override
protected ResourceLocation getEntityTexture(Entity p_110775_1_)
{
    return caveSpiderTextures;
}
}

package com.kpabr.DeeperCaves.entity;

import net.minecraft.client.renderer.entity.RenderSpider;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.util.ResourceLocation;

public class RenderDeepSpider extends RenderSpider {
	private static final ResourceLocation caveSpiderTextures = new ResourceLocation("textures/entity/spider/cave_spider.png");

@Override
protected ResourceLocation getEntityTexture(EntitySpider p_110775_1_)
{
    return caveSpiderTextures;
}
@Override
protected ResourceLocation getEntityTexture(Entity p_110775_1_)
{
    return caveSpiderTextures;
}
}

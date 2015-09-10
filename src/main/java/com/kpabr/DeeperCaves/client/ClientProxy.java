package com.kpabr.DeeperCaves.client;
/*
 * Created by Valiec2019
 * on February 18, 2014
 * using Minecraft Forge 10.12.0.1022
 */
import com.kpabr.DeeperCaves.CommonProxy;
//import com.kpabr.DeeperCaves.EndRenderHandler;
//import com.kpabr.DeeperCaves.EntityDragonfire;
//import com.kpabr.DeeperCaves.RenderDragonfire;



import com.kpabr.DeeperCaves.EntityDeepCaveSpider;

import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelSpider;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.entity.RenderCaveSpider;
import net.minecraft.client.renderer.entity.RenderDeepSpider;
import net.minecraft.client.renderer.entity.RenderSpider;
import net.minecraftforge.client.MinecraftForgeClient;

public class ClientProxy extends CommonProxy {

    @Override
    public void registerRenderers() 
    {
        
            RenderingRegistry.registerEntityRenderingHandler(EntityDeepCaveSpider.class, new RenderDeepSpider());
//the 0.5F is the shadowsize
    }      
}
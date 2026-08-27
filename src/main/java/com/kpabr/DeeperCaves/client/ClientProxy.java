package com.kpabr.DeeperCaves.client;

import com.kpabr.DeeperCaves.CommonProxy;
//import com.kpabr.DeeperCaves.EndRenderHandler;
//import com.kpabr.DeeperCaves.EntityDragonfire;
//import com.kpabr.DeeperCaves.RenderDragonfire;


import com.kpabr.DeeperCaves.DeeperF3Mesages;
import com.kpabr.DeeperCaves.entity.EntityDeepCaveSpider;
import com.kpabr.DeeperCaves.entity.EntityMutatedCaveSpider;
import com.kpabr.DeeperCaves.entity.EntityShadow;
import com.kpabr.DeeperCaves.entity.RenderDeepSpider;
import com.kpabr.DeeperCaves.entity.RenderMutatedSpider;
import com.kpabr.DeeperCaves.entity.RenderShadow;

import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraft.client.model.ModelBiped;
import net.minecraftforge.common.MinecraftForge;

public class ClientProxy extends CommonProxy {

    @Override
    public void registerRenderers() 
    {
        
            RenderingRegistry.registerEntityRenderingHandler(EntityDeepCaveSpider.class, new RenderDeepSpider());
            RenderingRegistry.registerEntityRenderingHandler(EntityMutatedCaveSpider.class, new RenderMutatedSpider());
            RenderingRegistry.registerEntityRenderingHandler(EntityShadow.class, new RenderShadow(new ModelBiped(), 0.5F));
            MinecraftForge.EVENT_BUS.register(new DeeperF3Mesages());
    }      
}
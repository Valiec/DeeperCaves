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

import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraftforge.client.MinecraftForgeClient;

public class ClientProxy extends CommonProxy {
        //EndRenderHandler erh = new EndRenderHandler();
        @Override
        public void registerRenderers() 
        {
            
                //RenderingRegistry.registerEntityRenderingHandler(EntityDragonfire.class, new RenderDragonfire(new ModelBiped(), 0.5F));
//the 0.5F is the shadowsize
                //RenderingRegistry.registerBlockHandler(500, erh);
        }
        
}
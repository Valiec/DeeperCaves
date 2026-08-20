package com.kpabr.DeeperCore;

import com.kpabr.DeeperCaves.*;
import com.kpabr.DeeperCaves.version.DeeperVersionChecker;
import com.kpabr.DeeperCaves.version.VersionCommand;
import com.kpabr.DeeperCore.dimstack.DeeperDimensionHandler;
import com.kpabr.DeeperCore.dimstack.DeeperTeleporter;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.common.MinecraftForge;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Mod(modid = DeeperCore.MODID, version = DeeperCore.VERSION, name = DeeperCore.NAME)
public class DeeperCore
{
    //@SidedProxy(clientSide="com.kpabr.DeeperCaves.client.ClientProxy", serverSide="com.kpabr.DeeperCaves.CommonProxy")
    //public static CommonProxy proxy;
 
    /*Mod ID and Version declarations*/
    public static final String MODID = "deepercore";
    public static final String VERSION = "1.0.0";
    public static final String NAME = "DeeperCore";
    
    public static DeeperCore instance;
    
    //event handlers
    public static DeeperDimensionHandler dimension = new DeeperDimensionHandler();


    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        instance = this;
        
        FMLCommonHandler.instance().bus().register(dimension);
		MinecraftForge.EVENT_BUS.register(dimension);
        
        FMLCommonHandler.instance().bus().register(this);
        MinecraftForge.EVENT_BUS.register(this);
    }
    
    
}


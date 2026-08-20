package com.kpabr.DeeperCore;

//import com.kpabr.DeeperCaves.*;
import com.kpabr.DeeperCore.dimstack.DeeperDimensionHandler;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
//import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.MinecraftForge;

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


package com.kpabr.DeeperCaves;
/*
 * Created by Valiec2019
 * started on July 6, 2013
 * released on November 28, 2013
 * currently using Minecraft Forge 10.12.0.1022
 */

import java.io.IOException;
import java.net.UnknownHostException;

import com.kpabr.DeeperCaves.CommonProxy;

import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.command.ServerCommandManager;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.util.EnumHelper;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.eventhandler.Event.Result;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.VillagerRegistry;
import cpw.mods.fml.relauncher.Side;
import net.minecraftforge.event.*;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import scala.actors.threadpool.Arrays;
@Mod(modid = DeeperCaves.MODID, version = DeeperCaves.VERSION, name = DeeperCaves.NAME)//, guiFactory = "com.kpabr.DeeperCaves.EndPlusConfigGUIFactory")
public class DeeperCaves
{
    @SidedProxy(clientSide="com.kpabr.DeeperCaves.client.ClientProxy", serverSide="com.kpabr.DeeperCaves.CommonProxy")
    public static CommonProxy proxy;
 
    /*Mod ID and Version declarations*/
    public static final String MODID = "DeeperCaves";
    public static final String VERSION = "0.4.2";
    public static final String NAME = "DeeperCaves";
    static int versionID = 9; //Used by version checker!
    
    public static DeeperMaterials materials = new DeeperMaterials();
    public static DeeperBlocks blocks = new DeeperBlocks();
    public static DeeperFluids fluids = new DeeperFluids();
    public static DeeperItems items = new DeeperItems();
    public static DeeperRecipes recipes = new DeeperRecipes();
    public static DeeperWorldgen worldgen = new DeeperWorldgen();
    public static DeeperMobs mobs = new DeeperMobs();
    public static DeeperVersionChecker versionChecker = new DeeperVersionChecker();
    public static DeeperConfig config = new DeeperConfig();
    public static DeeperBucketHandler bucket;
    public static DeeperCaves instance;
    //public static Configuration config;
    public int nearvoid_counter = 0;
    public int farvoid_counter = 0;
    public int deep_counter = 0;
    public static boolean voidFlag = false;
    public static boolean deepFlag = false;
    
    static CreativeTabs tabDeeperCaves = new TabDeeperCavesBlocks(CreativeTabs.getNextID(), "Deeper Caves Blocks", DeeperCaves.blocks.fragmentedBedrock);
    static CreativeTabs tabDeeperCavesItems = new TabDeeperCaves(CreativeTabs.getNextID(), "Deeper Caves Items", 0);
    static CreativeTabs tabDeeperCavesTools = new TabDeeperCaves(CreativeTabs.getNextID(), "Deeper Caves Tools", 1);
    

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        //config = new Configuration(event.getSuggestedConfigurationFile()); //gets default config file
        
        this.instance = this;
        
        //config.load();
        
        
        FMLCommonHandler.instance().bus().register(worldgen);
        MinecraftForge.EVENT_BUS.register(worldgen);
        
        FMLCommonHandler.instance().bus().register(versionChecker);
        MinecraftForge.EVENT_BUS.register(versionChecker);
        
        FMLCommonHandler.instance().bus().register(config);
        MinecraftForge.EVENT_BUS.register(config);
        
        FMLCommonHandler.instance().bus().register(this);
        MinecraftForge.EVENT_BUS.register(this);
        
        
        
        ClientCommandHandler.instance.registerCommand(new VersionCommand());

        
        config.initConfig(event);
     	fluids.setupFluids();
     	fluids.setupFluidBlocks();
        items.setupItems();
     	items.registerItems();
     	items.registerItemsOreDict();
     	blocks.setupBlocks();
     	blocks.registerBlocks();
     	blocks.registerBlocksOreDict();
        blocks.setupHarvestLevels();
     	recipes.setupShapelessCrafting();
     	recipes.setupShapedCrafting();
     	recipes.setupSmelting();
     	worldgen.setupWorldgen();
     	mobs.setupMobs();
     	GameRegistry.registerFuelHandler(new DeeperFuel());
     	proxy.registerRenderers();
     	
     	bucket = new DeeperBucketHandler();
     	
        FMLCommonHandler.instance().bus().register(bucket);
		MinecraftForge.EVENT_BUS.register(bucket);
    }
    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent event) {
    		try
        	{
	        	EntityPlayerMP player = (EntityPlayerMP)event.player;
	        	if(player.dimension == 0 && event.player.posY <= 0.0D) //0 = overworld
	        	{
	        		player.mcServer.getConfigurationManager().transferPlayerToDimension(player, DeeperCaves.worldgen.dropDimID, new DeeperTeleporter(player.mcServer.worldServerForDimension(DeeperCaves.worldgen.dropDimID)));
	        	}
	        	else if(player.dimension>=DeeperCaves.worldgen.dropDimID && event.player.posY <= 0.0D)
	        	{
	        		player.mcServer.getConfigurationManager().transferPlayerToDimension(player, DeeperCaves.worldgen.mazeDimID, new DeeperTeleporter(player.mcServer.worldServerForDimension(DeeperCaves.worldgen.mazeDimID)));
	        	}
	        	else if(player.dimension>=DeeperCaves.worldgen.mazeDimID && event.player.posY <= 0.0D)
	        	{
	        		player.mcServer.getConfigurationManager().transferPlayerToDimension(player, DeeperCaves.worldgen.crystalDimID, new DeeperTeleporter(player.mcServer.worldServerForDimension(DeeperCaves.worldgen.crystalDimID)));
	        	}
	        	else if(player.dimension>=DeeperCaves.worldgen.crystalDimID && event.player.posY <= 0.0D)
	        	{
	        		player.mcServer.getConfigurationManager().transferPlayerToDimension(player, DeeperCaves.worldgen.compressedDimID, new DeeperTeleporter(player.mcServer.worldServerForDimension(DeeperCaves.worldgen.compressedDimID)));
	        	}
	        	else if(player.dimension>=DeeperCaves.worldgen.compressedDimID && event.player.posY <= 0.0D)
	        	{
	        		player.mcServer.getConfigurationManager().transferPlayerToDimension(player, DeeperCaves.worldgen.bedrockPlainsDimID, new DeeperTeleporter(player.mcServer.worldServerForDimension(DeeperCaves.worldgen.bedrockPlainsDimID)));
	        	}
	        	else if(player.dimension>=DeeperCaves.worldgen.bedrockPlainsDimID && event.player.posY <= 0.0D)
	        	{
	        		player.mcServer.getConfigurationManager().transferPlayerToDimension(player, DeeperCaves.worldgen.nearNetherDimID, new DeeperTeleporter(player.mcServer.worldServerForDimension(DeeperCaves.worldgen.nearNetherDimID)));
	        	}
	        	else if(player.dimension>=DeeperCaves.worldgen.nearNetherDimID && event.player.posY <= 0.0D)
	        	{
	        		player.mcServer.getConfigurationManager().transferPlayerToDimension(player, DeeperCaves.worldgen.lavaDimID, new DeeperTeleporter(player.mcServer.worldServerForDimension(DeeperCaves.worldgen.lavaDimID)));
	        	}
	        	else if(player.dimension>=DeeperCaves.worldgen.lavaDimID && event.player.posY <= 0.0D)
	        	{
	        		player.mcServer.getConfigurationManager().transferPlayerToDimension(player, DeeperCaves.worldgen.nearVoidDimID, new DeeperTeleporter(player.mcServer.worldServerForDimension(DeeperCaves.worldgen.nearVoidDimID)));
	        	}
	        	else if(player.dimension == DeeperCaves.worldgen.nearVoidDimID && event.player.posY <= 120.0D)
	        	{
	        		player.mcServer.getConfigurationManager().transferPlayerToDimension(player, DeeperCaves.worldgen.deepWorldDimID, new DeeperTeleporter(player.mcServer.worldServerForDimension(DeeperCaves.worldgen.deepWorldDimID)));
	        	}
	        	else if(player.dimension>=DeeperCaves.worldgen.deepWorldDimID && event.player.posY <= 0.0D)
	        	{
	        		player.mcServer.getConfigurationManager().transferPlayerToDimension(player, DeeperCaves.worldgen.darknessDimID, new DeeperTeleporter(player.mcServer.worldServerForDimension(DeeperCaves.worldgen.darknessDimID)));
	        	}
	        	else if(player.dimension>=DeeperCaves.worldgen.darknessDimID && event.player.posY <= 0.0D)
	        	{
	        		player.mcServer.getConfigurationManager().transferPlayerToDimension(player, DeeperCaves.worldgen.abandonedCavesDimID, new DeeperTeleporter(player.mcServer.worldServerForDimension(DeeperCaves.worldgen.abandonedCavesDimID)));
	        	}
	        	else if(player.dimension>=DeeperCaves.worldgen.abandonedCavesDimID && event.player.posY <= 0.0D)
	        	{
	        		player.mcServer.getConfigurationManager().transferPlayerToDimension(player, DeeperCaves.worldgen.mutationDimID, new DeeperTeleporter(player.mcServer.worldServerForDimension(DeeperCaves.worldgen.mutationDimID)));
	        	}
	        	else if(player.dimension>=DeeperCaves.worldgen.mutationDimID && event.player.posY <= 0.0D)
	        	{
	        		player.mcServer.getConfigurationManager().transferPlayerToDimension(player, DeeperCaves.worldgen.farVoidDimID, new DeeperTeleporter(player.mcServer.worldServerForDimension(DeeperCaves.worldgen.farVoidDimID)));
	        	}
	        	else if(player.dimension == DeeperCaves.worldgen.farVoidDimID && event.player.posY <= 120.0D && voidFlag)
	        	{
	        		player.mcServer.getConfigurationManager().transferPlayerToDimension(player, DeeperCaves.worldgen.forgottenDimID, new DeeperTeleporter(player.mcServer.worldServerForDimension(DeeperCaves.worldgen.forgottenDimID)));
	        	}
	        	else if(player.dimension == DeeperCaves.worldgen.forgottenDimID && event.player.posY <= 0.0D)
	        	{
	        		player.mcServer.getConfigurationManager().transferPlayerToDimension(player, DeeperCaves.worldgen.evilDimID, new DeeperTeleporter(player.mcServer.worldServerForDimension(DeeperCaves.worldgen.evilDimID)));
	        	}
	        	else if(player.dimension>=DeeperCaves.worldgen.evilDimID && event.player.posY <= 0.0D)
	        	{
	        		player.mcServer.getConfigurationManager().transferPlayerToDimension(player, DeeperCaves.worldgen.finalLabyrinthDimID, new DeeperTeleporter(player.mcServer.worldServerForDimension(DeeperCaves.worldgen.finalLabyrinthDimID)));
	        	}


	        	else{}
        	}
        	catch(ClassCastException e)
        	{
        		return; //not a player
        	}
    		try
        	{
	        	EntityPlayerMP player = (EntityPlayerMP)event.player;
	        	if(player.dimension == DeeperCaves.worldgen.dropDimID && event.player.posY >= 200.0)
	        	{
	        		player.mcServer.getConfigurationManager().transferPlayerToDimension(player, 0, new DeeperTeleporterLower(player.mcServer.worldServerForDimension(0)));
	        	}
	        	if(player.dimension == DeeperCaves.worldgen.mazeDimID && event.player.posY >= 200.0)
	        	{
	        		player.mcServer.getConfigurationManager().transferPlayerToDimension(player, DeeperCaves.worldgen.dropDimID, new DeeperTeleporterLower(player.mcServer.worldServerForDimension(DeeperCaves.worldgen.dropDimID)));
	        	}
	        	if(player.dimension == DeeperCaves.worldgen.crystalDimID && event.player.posY >= 150.0)
	        	{
	        		player.mcServer.getConfigurationManager().transferPlayerToDimension(player, DeeperCaves.worldgen.mazeDimID, new DeeperTeleporterLower(player.mcServer.worldServerForDimension(DeeperCaves.worldgen.mazeDimID)));
	        	}
	        	if(player.dimension == DeeperCaves.worldgen.compressedDimID && event.player.posY >= 100.0)
	        	{
	        		player.mcServer.getConfigurationManager().transferPlayerToDimension(player, DeeperCaves.worldgen.crystalDimID, new DeeperTeleporterLower(player.mcServer.worldServerForDimension(DeeperCaves.worldgen.crystalDimID)));
	        	}
	         	if(player.dimension == DeeperCaves.worldgen.bedrockPlainsDimID && event.player.posY >= 172.0)
	        	{
	        		player.mcServer.getConfigurationManager().transferPlayerToDimension(player, DeeperCaves.worldgen.compressedDimID, new DeeperTeleporterLower(player.mcServer.worldServerForDimension(DeeperCaves.worldgen.compressedDimID)));
	        	}
	         	if(player.dimension == DeeperCaves.worldgen.nearNetherDimID && event.player.posY >= 100.0)
	        	{
	        		player.mcServer.getConfigurationManager().transferPlayerToDimension(player, DeeperCaves.worldgen.bedrockPlainsDimID, new DeeperTeleporterLower(player.mcServer.worldServerForDimension(DeeperCaves.worldgen.bedrockPlainsDimID)));
	        	}
	         	if(player.dimension == DeeperCaves.worldgen.lavaDimID && event.player.posY >= 50.0)
	        	{
	        		player.mcServer.getConfigurationManager().transferPlayerToDimension(player, DeeperCaves.worldgen.nearNetherDimID, new DeeperTeleporterLower(player.mcServer.worldServerForDimension(DeeperCaves.worldgen.nearNetherDimID)));
	        	}
	         	if(player.dimension == DeeperCaves.worldgen.nearVoidDimID && event.player.posY >= 245.0)
	        	{
	        		player.mcServer.getConfigurationManager().transferPlayerToDimension(player, DeeperCaves.worldgen.lavaDimID, new DeeperTeleporterLower(player.mcServer.worldServerForDimension(DeeperCaves.worldgen.lavaDimID)));
	        	}
	         	if(player.dimension == DeeperCaves.worldgen.deepWorldDimID && event.player.posY >= 75.0)
	        	{
	        		player.mcServer.getConfigurationManager().transferPlayerToDimension(player, DeeperCaves.worldgen.nearVoidDimID, new DeeperTeleporter(player.mcServer.worldServerForDimension(DeeperCaves.worldgen.nearVoidDimID)));
	        	}
	         	if(player.dimension == DeeperCaves.worldgen.darknessDimID && event.player.posY >= 245.0)
	        	{
	        		player.mcServer.getConfigurationManager().transferPlayerToDimension(player, DeeperCaves.worldgen.deepWorldDimID, new DeeperTeleporterLower(player.mcServer.worldServerForDimension(DeeperCaves.worldgen.deepWorldDimID)));
	        	}
	         	if(player.dimension == DeeperCaves.worldgen.abandonedCavesDimID && event.player.posY >= 100.0)
	        	{
	        		player.mcServer.getConfigurationManager().transferPlayerToDimension(player, DeeperCaves.worldgen.darknessDimID, new DeeperTeleporterLower(player.mcServer.worldServerForDimension(DeeperCaves.worldgen.darknessDimID)));
	        	}
	         	if(player.dimension == DeeperCaves.worldgen.mutationDimID && event.player.posY >= 100.0)
	        	{
	        		player.mcServer.getConfigurationManager().transferPlayerToDimension(player, DeeperCaves.worldgen.abandonedCavesDimID, new DeeperTeleporterLower(player.mcServer.worldServerForDimension(DeeperCaves.worldgen.abandonedCavesDimID)));
	        	}
	         	if(player.dimension == DeeperCaves.worldgen.farVoidDimID && event.player.posY >= 245.0)
	        	{
	        		player.mcServer.getConfigurationManager().transferPlayerToDimension(player, DeeperCaves.worldgen.mutationDimID, new DeeperTeleporterLower(player.mcServer.worldServerForDimension(DeeperCaves.worldgen.mutationDimID)));
	        	}
	        	if(player.dimension == DeeperCaves.worldgen.forgottenDimID && event.player.posY >= 230.0)
	        	{
	        		player.mcServer.getConfigurationManager().transferPlayerToDimension(player, DeeperCaves.worldgen.farVoidDimID, new DeeperTeleporter(player.mcServer.worldServerForDimension(DeeperCaves.worldgen.farVoidDimID)));
	        	}
	        	if(player.dimension == DeeperCaves.worldgen.evilDimID && event.player.posY >= 100.0)
	        	{
	        		player.mcServer.getConfigurationManager().transferPlayerToDimension(player, DeeperCaves.worldgen.forgottenDimID, new DeeperTeleporter(player.mcServer.worldServerForDimension(DeeperCaves.worldgen.forgottenDimID)));
	        	}
	        	if(player.dimension == DeeperCaves.worldgen.finalLabyrinthDimID && event.player.posY >= 245.0)
	        	{
	        		player.mcServer.getConfigurationManager().transferPlayerToDimension(player, DeeperCaves.worldgen.evilDimID, new DeeperTeleporter(player.mcServer.worldServerForDimension(DeeperCaves.worldgen.evilDimID)));
	        	}
	        	else{}
        	}
        	catch(ClassCastException e)
        	{
        		//do nothing, not a player
        	}
    		try
            {
            EntityPlayerMP player = (EntityPlayerMP)event.player;
            if(event.player.posY <= 240.0D && player.dimension == DeeperCaves.worldgen.nearVoidDimID)
            {
	    		if(!voidFlag)
	    		{
	    			if(this.nearvoid_counter == 200)
	    			{
	    				player.attackEntityFrom(DamageSource.outOfWorld, 0.5F);
	    				this.nearvoid_counter = 0;
	    			}
	    			else
	    			{
	    				this.nearvoid_counter = this.nearvoid_counter+1;
	    			}
	
	    		}
				else if(this.nearvoid_counter == 0 && voidFlag) 
				{
					this.voidFlag = false;
					this.nearvoid_counter = this.nearvoid_counter+1;
				}
				else if(this.nearvoid_counter == 200 && voidFlag) 
				{
					this.nearvoid_counter = 0;
				}
				else
				{
					this.nearvoid_counter = this.nearvoid_counter+1;
				}
            }
            if(event.player.posY <= 240.0D && player.dimension == DeeperCaves.worldgen.farVoidDimID)
            {
	    		if(!voidFlag)
	    		{
	    			if(this.farvoid_counter == 9) //200
	    			{
	    				player.attackEntityFrom(DamageSource.outOfWorld, 4.0F);
	    				this.farvoid_counter = 0;
	    			}
	    			else
	    			{
	    				this.farvoid_counter = this.farvoid_counter+1;
	    			}
	
	    		}
				else if(this.farvoid_counter == 0 && voidFlag) 
				{
					this.voidFlag = false;
					this.farvoid_counter = this.farvoid_counter+1;
				}
				else if(this.farvoid_counter == 9 && voidFlag) 
				{
					this.farvoid_counter = 0;
				}
				else
				{
					this.farvoid_counter = this.farvoid_counter+1;
				}
            }
            if(player.dimension == DeeperCaves.worldgen.forgottenDimID)
            {
				if(this.deep_counter == 0 && deepFlag) 
				{
					this.deepFlag = false;
					this.deep_counter = this.deep_counter+1;
				}
				else if(this.deep_counter >= 1 && deepFlag) 
				{
					this.deep_counter = 0;
				}
				else
				{
					this.deep_counter = this.deep_counter+1;
				}
            }
            }
            catch(ClassCastException e)
            {
            	return; //not a player
            }
    		
    }
    
}


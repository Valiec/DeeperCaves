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
@Mod(modid = DeeperCaves.MODID, version = DeeperCaves.VERSION, name = DeeperCaves.NAME)//, guiFactory = "com.kpabr.DeeperCaves.EndPlusConfigGUIFactory")
public class DeeperCaves
{
    @SidedProxy(clientSide="com.kpabr.DeeperCaves.client.ClientProxy", serverSide="com.kpabr.DeeperCaves.CommonProxy")
    public static CommonProxy proxy;
 
    /*Mod ID and Version declarations*/
    public static final String MODID = "DeeperCaves";
    public static final String VERSION = "0.3.0";
    public static final String NAME = "DeeperCaves";
    static int versionID = 6; //Used by version checker!
    
    public static DeeperMaterials materials = new DeeperMaterials();
    public static DeeperBlocks blocks = new DeeperBlocks();
    public static DeeperFluids fluids = new DeeperFluids();
    public static DeeperItems items = new DeeperItems();
    public static DeeperRecipes recipes = new DeeperRecipes();
    public static DeeperWorldgen worldgen = new DeeperWorldgen();
    public static DeeperMobs mobs = new DeeperMobs();
    public static DeeperVersionChecker versionChecker = new DeeperVersionChecker();
    public static DeeperCaves instance;
    public static Configuration config;
    public int nearvoid_counter = 0;
    
    static CreativeTabs tabDeeperCaves = new TabDeeperCavesBlocks(CreativeTabs.getNextID(), "Deeper Caves Blocks", DeeperCaves.blocks.fragmentedBedrock);
    static CreativeTabs tabDeeperCavesItems = new TabDeeperCaves(CreativeTabs.getNextID(), "Deeper Caves Items", 0);
    static CreativeTabs tabDeeperCavesTools = new TabDeeperCaves(CreativeTabs.getNextID(), "Deeper Caves Tools", 1);
    

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        config = new Configuration(event.getSuggestedConfigurationFile()); //gets default config file
        
        this.instance = this;
        
        
        FMLCommonHandler.instance().bus().register(worldgen);
        MinecraftForge.EVENT_BUS.register(worldgen);
        
        FMLCommonHandler.instance().bus().register(versionChecker);
        MinecraftForge.EVENT_BUS.register(versionChecker);
        
        FMLCommonHandler.instance().bus().register(this);
        MinecraftForge.EVENT_BUS.register(this);
        
        
        
        ClientCommandHandler.instance.registerCommand(new VersionCommand());

        
        
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
     	proxy.registerRenderers();
    }
    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent event) {
        	if(event.player.posY <= 0.0D)
        	{
        		try
            	{
            	EntityPlayerMP player = (EntityPlayerMP)event.player;
            	if(player.dimension == 22)
            	{
            	player.mcServer.getConfigurationManager().transferPlayerToDimension(player, 0, new DeeperTeleporter(player.mcServer.worldServerForDimension(0)));
            	}
            	if(player.dimension == 15)
            	{
            	player.mcServer.getConfigurationManager().transferPlayerToDimension(player, 22, new DeeperTeleporter(player.mcServer.worldServerForDimension(22)));
            	}
            	else if(player.dimension == 0)
            	{
            	player.mcServer.getConfigurationManager().transferPlayerToDimension(player, 7, new DeeperTeleporter(player.mcServer.worldServerForDimension(7)));
            	}
            	else if(player.dimension>=7 && player.dimension<15)
            	{
            	player.mcServer.getConfigurationManager().transferPlayerToDimension(player, player.dimension+1, new DeeperTeleporter(player.mcServer.worldServerForDimension(player.dimension+1)));
            	}
            	else{}
            	}
            	catch(ClassCastException e)
            	{
            		return; //not a player
            	}
        	}
        	else if(event.player.posY >= 255.0D)
        	{
        		try
            	{
            	EntityPlayerMP player = (EntityPlayerMP)event.player;
            	if(player.dimension == 7)
            	{
            	player.mcServer.getConfigurationManager().transferPlayerToDimension(player, 0, new DeeperTeleporter(player.mcServer.worldServerForDimension(0)));
            	}
            	else if(player.dimension>7 && player.dimension<=15)
            	{
            	player.mcServer.getConfigurationManager().transferPlayerToDimension(player, player.dimension-1, new DeeperTeleporter(player.mcServer.worldServerForDimension(player.dimension-1)));
            	}
            	if(player.dimension == 22)
            	{
            	player.mcServer.getConfigurationManager().transferPlayerToDimension(player, 15, new DeeperTeleporter(player.mcServer.worldServerForDimension(14)));
            	}
            	else{}
            	}
            	catch(ClassCastException e)
            	{
            		return; //not a player
            	}
        	}
        	else{}
    		try
            {
            EntityPlayerMP player = (EntityPlayerMP)event.player;
    		if(event.player.posY <= 240.0D && player.dimension == 14)
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
            }
            catch(ClassCastException e)
            {
            	return; //not a player
            }
    }
}


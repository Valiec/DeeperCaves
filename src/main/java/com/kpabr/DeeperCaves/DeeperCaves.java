package com.kpabr.DeeperCaves;
/*
 * Created by Valiec2019
 * started on July 6, 2013
 * released on November 28, 2013
 * currently using Minecraft Forge 10.12.0.1022
 */

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

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
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
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
@Mod(modid = DeeperCaves.MODID, version = DeeperCaves.VERSION, name = DeeperCaves.NAME)
public class DeeperCaves
{
    @SidedProxy(clientSide="com.kpabr.DeeperCaves.client.ClientProxy", serverSide="com.kpabr.DeeperCaves.CommonProxy")
    public static CommonProxy proxy;
 
    /*Mod ID and Version declarations*/
    public static final String MODID = "DeeperCaves";
    public static final String VERSION = "1.0.0";
    public static final String NAME = "DeeperCaves";
    static int versionID = 11; //Used by version checker!
    
    public static DeeperCaves instance;
    
    //event handlers
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
    public static DeeperDimensionHandler dimension = new DeeperDimensionHandler();
    public static DeeperEventHandler events = new DeeperEventHandler();
    public static DeeperAchievements achievements = new DeeperAchievements();
    
    //player state data
    public Map<UUID, Integer> nearvoid_counter = new HashMap<UUID, Integer>();
    public Map<UUID, Integer> farvoid_counter = new HashMap<UUID, Integer>();
    public Map<UUID, Integer> deep_counter = new HashMap<UUID, Integer>();
    public static Map<UUID, Boolean> voidFlag = new HashMap<UUID, Boolean>();
    public static Map<UUID, Boolean> deepFlag = new HashMap<UUID, Boolean>();
    
    //creative tabs
    static CreativeTabs tabDeeperCaves = new TabDeeperCavesBlocks(CreativeTabs.getNextID(), "Deeper Caves Blocks", DeeperCaves.blocks.fragmentedBedrock);
    static CreativeTabs tabDeeperCavesItems = new TabDeeperCaves(CreativeTabs.getNextID(), "Deeper Caves Items", 0);
    static CreativeTabs tabDeeperCavesOres = new TabDeeperCavesOres(CreativeTabs.getNextID(), "Deeper Caves Ores", DeeperCaves.blocks.dcdiamondOre);
    static CreativeTabs tabDeeperCavesTools = new TabDeeperCaves(CreativeTabs.getNextID(), "Deeper Caves Tools", 1);
    static CreativeTabs tabDeeperCavesCombat = new TabDeeperCaves(CreativeTabs.getNextID(), "Deeper Caves Combat", 2);
    

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        
        this.instance = this;
        
        FMLCommonHandler.instance().bus().register(worldgen);
        MinecraftForge.EVENT_BUS.register(worldgen);
        
        FMLCommonHandler.instance().bus().register(versionChecker);
        MinecraftForge.EVENT_BUS.register(versionChecker);
        
        FMLCommonHandler.instance().bus().register(config);
        MinecraftForge.EVENT_BUS.register(config);
        
        FMLCommonHandler.instance().bus().register(dimension);
		MinecraftForge.EVENT_BUS.register(dimension);
        
        FMLCommonHandler.instance().bus().register(this);
        MinecraftForge.EVENT_BUS.register(this);

        FMLCommonHandler.instance().bus().register(events);
        MinecraftForge.EVENT_BUS.register(events);
        
        
        
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

     	DeeperAchievements.setupAchievements();
     	DeeperAchievements.registerAchievements();
     	
     	bucket = new DeeperBucketHandler(); //initialized here because blocks and items must be set up first
     	
        FMLCommonHandler.instance().bus().register(bucket);
		MinecraftForge.EVENT_BUS.register(bucket);
    }
    
    
}


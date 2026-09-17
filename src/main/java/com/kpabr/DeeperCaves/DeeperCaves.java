package com.kpabr.DeeperCaves;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.kpabr.DeeperCaves.network.PacketSculkActivationS2C;
import com.kpabr.DeeperCaves.network.PacketSculkShriekS2C;
import com.kpabr.DeeperCaves.version.DeeperVersionChecker;
import com.kpabr.DeeperCaves.version.VersionCommand;
import com.kpabr.DeeperCaves.world.biome.EvilDecorator;
import com.kpabr.DeeperCaves.world.biome.FinalLabyrinthDecorator;
import com.kpabr.DeeperCore.dimstack.DeeperTeleporter;
import cpw.mods.fml.common.event.FMLServerStoppingEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = DeeperCaves.MODID, version = DeeperCaves.VERSION, name = DeeperCaves.NAME, dependencies = "required-after:deepercore")
public class DeeperCaves
{
    @SidedProxy(clientSide="com.kpabr.DeeperCaves.client.ClientProxy", serverSide="com.kpabr.DeeperCaves.CommonProxy")
    public static CommonProxy proxy;

    public static SimpleNetworkWrapper network;
 
    /*Mod ID and Version declarations*/
    public static final String MODID = "DeeperCaves";
    public static final String VERSION = "2.0.0";
    public static final String NAME = "DeeperCaves";
    //static int versionID = 11; //Used by version checker!
    
    public static DeeperCaves instance;


    
    //event handlers
    public static DeeperBlocks blocks = new DeeperBlocks();
    public static DeeperFluids fluids = new DeeperFluids();
    public static DeeperItems items = new DeeperItems();
    public static DeeperRecipes recipes = new DeeperRecipes();
    public static DeeperWorldgen worldgen = new DeeperWorldgen();
    public static DeeperMobs mobs = new DeeperMobs();
    public static DeeperVersionChecker versionChecker = new DeeperVersionChecker();
    public static DeeperConfig config = new DeeperConfig();
    public static DeeperBucketHandler bucket;
    public static DeeperEventHandler events = new DeeperEventHandler();
    public static DeeperSculkManager sculk = new DeeperSculkManager();

    //creative tabs
    public static CreativeTabs tabDeeperCaves = new TabDeeperCavesBlocks(CreativeTabs.getNextID(), "Deeper Caves Blocks", DeeperBlocks.fragmentedBedrock);
    public static CreativeTabs tabDeeperCavesItems = new TabDeeperCaves(CreativeTabs.getNextID(), "Deeper Caves Items", 0);
    public static CreativeTabs tabDeeperCavesOres = new TabDeeperCavesOres(CreativeTabs.getNextID(), "Deeper Caves Ores", DeeperBlocks.dcdiamondOre);
    public static CreativeTabs tabDeeperCavesTools = new TabDeeperCaves(CreativeTabs.getNextID(), "Deeper Caves Tools", 1);
    public static CreativeTabs tabDeeperCavesCombat = new TabDeeperCaves(CreativeTabs.getNextID(), "Deeper Caves Combat", 2);

    public static Logger logger = LogManager.getLogger("DeeperCaves");

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {

        
        instance = this;

        network = NetworkRegistry.INSTANCE.newSimpleChannel(DeeperCaves.MODID);
        network.registerMessage(PacketSculkActivationS2C.Handler.class, PacketSculkActivationS2C.class, 0, Side.CLIENT);
        network.registerMessage(PacketSculkShriekS2C.Handler.class, PacketSculkShriekS2C.class, 1, Side.CLIENT);
        
        FMLCommonHandler.instance().bus().register(worldgen);
        MinecraftForge.EVENT_BUS.register(worldgen);
        
        FMLCommonHandler.instance().bus().register(versionChecker);
        MinecraftForge.EVENT_BUS.register(versionChecker);
        
        FMLCommonHandler.instance().bus().register(config);
        MinecraftForge.EVENT_BUS.register(config);
        
        FMLCommonHandler.instance().bus().register(this);
        MinecraftForge.EVENT_BUS.register(this);

        FMLCommonHandler.instance().bus().register(events);
        MinecraftForge.EVENT_BUS.register(events);

        FMLCommonHandler.instance().bus().register(sculk);
        MinecraftForge.EVENT_BUS.register(sculk);
        
        //ClientCommandHandler.instance.registerCommand(new VersionCommand());

        ClientCommandHandler.instance.registerCommand(new DepthCommand());

        
        config.initConfig(event);
     	fluids.setupFluids();
     	fluids.setupFluidBlocks();
        items.setupItems();
     	items.registerItems();
     	items.registerItemsOreDict();
     	blocks.setupBlocks();
        blocks.registerTileEntities();
     	blocks.registerBlocks();
     	blocks.registerBlocksOreDict();
        blocks.setupHarvestLevels();
     	recipes.setupShapelessCrafting();
		recipes.setupShapedCrafting();
     	recipes.setupSmelting();
     	worldgen.setupWorldgen();
        blocks.setupPortals();
        blocks.registerPortals();
     	mobs.setupMobs();
     	GameRegistry.registerFuelHandler(new DeeperFuel());
     	proxy.registerRenderers();

     	DeeperAchievements.setupAchievements();
     	DeeperAchievements.registerAchievements();
     	
     	bucket = new DeeperBucketHandler(); //initialized here because blocks and items must be set up first

        DeeperTeleporter.solidGroundBlacklist.addAll(Arrays.asList(DeeperBlocks.magmaStone, DeeperFluids.moltenIronBlock));
     	
        FMLCommonHandler.instance().bus().register(bucket);
		MinecraftForge.EVENT_BUS.register(bucket);
    }

    public void cleanupWorldData() {
        EvilDecorator.sculkNoise = null;
        EvilDecorator.vineTendrilNoise = null;
        EvilDecorator.vineTendrilNoise2 = null;
        FinalLabyrinthDecorator.sculkNoise = null;
        FinalLabyrinthDecorator.boneNoise = null;

    }

    @EventHandler
    public void onServerStopping(FMLServerStoppingEvent event) {
        if(FMLCommonHandler.instance().getSide() == Side.CLIENT) {
            cleanupWorldData();
        }
    }
}


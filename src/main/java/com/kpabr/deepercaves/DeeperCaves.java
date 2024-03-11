package com.kpabr.deepercaves;

import com.kpabr.deepercaves.block.CrystalBlock;
import com.kpabr.deepercaves.block.StoneBlock;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.ModificationPhase;
import net.fabricmc.fabric.api.entity.event.v1.ServerPlayerEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerChunkEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerWorldEvents;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.client.MinecraftClient;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import net.minecraft.world.WorldEvents;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.dimension.DimensionTypes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import qouteall.imm_ptl.core.portal.Portal;
import qouteall.imm_ptl.core.portal.global_portals.VerticalConnectingPortal;
import qouteall.q_misc_util.MiscHelper;

import java.util.HashMap;
import java.util.Map;

public class DeeperCaves implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger("deepercaves");

	public static Map<String, DeeperLevel> levels = new HashMap<>();

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		DeeperBlocks.setupBlocks();
		DeeperItems.setupItems();
		DeeperWorldgen.setupWorldgen();

		ServerWorldEvents.LOAD.register((server, world) -> {
			LOGGER.warn(world.getRegistryKey().getValue().toString());

		});

		ServerLifecycleEvents.SERVER_STARTED.register(((server) -> {
			VerticalConnectingPortal.connect(World.OVERWORLD, VerticalConnectingPortal.ConnectorType.floor, RegistryKey.of(Registry.WORLD_KEY, new Identifier("deepercaves:drop")));
			VerticalConnectingPortal.connect(RegistryKey.of(Registry.WORLD_KEY, new Identifier("deepercaves:drop")), VerticalConnectingPortal.ConnectorType.ceil, World.OVERWORLD);

			VerticalConnectingPortal.connect(RegistryKey.of(Registry.WORLD_KEY, new Identifier("deepercaves:drop")), VerticalConnectingPortal.ConnectorType.floor, RegistryKey.of(Registry.WORLD_KEY, new Identifier("deepercaves:maze")));
			VerticalConnectingPortal.connect(RegistryKey.of(Registry.WORLD_KEY, new Identifier("deepercaves:maze")), VerticalConnectingPortal.ConnectorType.ceil, RegistryKey.of(Registry.WORLD_KEY, new Identifier("deepercaves:drop")));

			VerticalConnectingPortal.connect(RegistryKey.of(Registry.WORLD_KEY, new Identifier("deepercaves:maze")), VerticalConnectingPortal.ConnectorType.floor, RegistryKey.of(Registry.WORLD_KEY, new Identifier("deepercaves:crystal")));
			VerticalConnectingPortal.connect(RegistryKey.of(Registry.WORLD_KEY, new Identifier("deepercaves:crystal")), VerticalConnectingPortal.ConnectorType.ceil, RegistryKey.of(Registry.WORLD_KEY, new Identifier("deepercaves:maze")));

			VerticalConnectingPortal.connect(RegistryKey.of(Registry.WORLD_KEY, new Identifier("deepercaves:crystal")), VerticalConnectingPortal.ConnectorType.floor, RegistryKey.of(Registry.WORLD_KEY, new Identifier("deepercaves:compressed")));
			VerticalConnectingPortal.connect(RegistryKey.of(Registry.WORLD_KEY, new Identifier("deepercaves:compressed")), VerticalConnectingPortal.ConnectorType.ceil, RegistryKey.of(Registry.WORLD_KEY, new Identifier("deepercaves:crystal")));

			VerticalConnectingPortal.connect(RegistryKey.of(Registry.WORLD_KEY, new Identifier("deepercaves:compressed")), VerticalConnectingPortal.ConnectorType.floor, RegistryKey.of(Registry.WORLD_KEY, new Identifier("deepercaves:bedrock_plains")));
			VerticalConnectingPortal.connect(RegistryKey.of(Registry.WORLD_KEY, new Identifier("deepercaves:bedrock_plains")), VerticalConnectingPortal.ConnectorType.ceil, RegistryKey.of(Registry.WORLD_KEY, new Identifier("deepercaves:compressed")));

			VerticalConnectingPortal.connect(RegistryKey.of(Registry.WORLD_KEY, new Identifier("deepercaves:bedrock_plains")), VerticalConnectingPortal.ConnectorType.floor, RegistryKey.of(Registry.WORLD_KEY, new Identifier("deepercaves:near_nether")));
			VerticalConnectingPortal.connect(RegistryKey.of(Registry.WORLD_KEY, new Identifier("deepercaves:near_nether")), VerticalConnectingPortal.ConnectorType.ceil, RegistryKey.of(Registry.WORLD_KEY, new Identifier("deepercaves:bedrock_plains")));

			VerticalConnectingPortal.connect(RegistryKey.of(Registry.WORLD_KEY, new Identifier("deepercaves:near_nether")), VerticalConnectingPortal.ConnectorType.floor, RegistryKey.of(Registry.WORLD_KEY, new Identifier("deepercaves:lava")));
			VerticalConnectingPortal.connect(RegistryKey.of(Registry.WORLD_KEY, new Identifier("deepercaves:lava")), VerticalConnectingPortal.ConnectorType.ceil, RegistryKey.of(Registry.WORLD_KEY, new Identifier("deepercaves:near_nether")));

			VerticalConnectingPortal.connect(RegistryKey.of(Registry.WORLD_KEY, new Identifier("deepercaves:lava")), VerticalConnectingPortal.ConnectorType.floor, RegistryKey.of(Registry.WORLD_KEY, new Identifier("deepercaves:near_void")));
			VerticalConnectingPortal.connect(RegistryKey.of(Registry.WORLD_KEY, new Identifier("deepercaves:near_void")), VerticalConnectingPortal.ConnectorType.ceil, RegistryKey.of(Registry.WORLD_KEY, new Identifier("deepercaves:lava")));
		}));

		ServerChunkEvents.CHUNK_LOAD.register(((world, chunk) -> {
			if(world.getRegistryKey() == World.OVERWORLD) //is this the Overworld
			{
				if(chunk.getBlockState(new BlockPos(0,chunk.getBottomY(),0)).getBlock() == Blocks.BEDROCK) //has Bedrock
				{
					for(int x=0; x<16; x++)
					{
						for(int z=0; z<16; z++)
						{
							for(int y=0; y<6; y++)
							{
								if(chunk.getBlockState(new BlockPos(x,chunk.getBottomY()+y,z)).getBlock() == Blocks.BEDROCK)
								{
									chunk.setBlockState(new BlockPos(x,chunk.getBottomY()+y,z), Blocks.STONE.getDefaultState(), false);
								}
							}
						}
					}
				}
			}
		}));

	}
}

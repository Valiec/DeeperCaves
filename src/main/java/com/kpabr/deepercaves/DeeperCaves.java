package com.kpabr.deepercaves;

import com.kpabr.deepercaves.block.CrystalBlock;
import com.kpabr.deepercaves.block.StoneBlock;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DeeperCaves implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger("deepercaves");

	//public static final Block CRYSTAL = new CrystalBlock(FabricBlockSettings.of(Material.AMETHYST).strength(1.5f));



	//public static final Block MAZE_STONE = new CrystalBlock(FabricBlockSettings.of(Material.STONE).strength(1.5f));

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Hello Fabric world!");
		DeeperBlocks.setupBlocks();
		DeeperItems.setupItems();

		//Registry.register(Registry.BLOCK, new Identifier("deepercaves", "crystal"), CRYSTAL);
		//Registry.register(Registry.ITEM, new Identifier("deepercaves", "crystal"), new BlockItem(CRYSTAL, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));



	}
}

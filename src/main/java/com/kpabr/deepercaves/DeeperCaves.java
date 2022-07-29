package com.kpabr.deepercaves;

import com.kpabr.deepercaves.block.CrystalBlock;
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

	public static final Block CRYSTAL = new CrystalBlock(FabricBlockSettings.of(Material.AMETHYST).strength(1.5f));

	public static final Block WHITE_CRYSTAL = new CrystalBlock(FabricBlockSettings.of(Material.AMETHYST).strength(1.5f));
	public static final Block ORANGE_CRYSTAL = new CrystalBlock(FabricBlockSettings.of(Material.AMETHYST).strength(1.5f));
	public static final Block MAGENTA_CRYSTAL = new CrystalBlock(FabricBlockSettings.of(Material.AMETHYST).strength(1.5f));
	public static final Block LIGHT_BLUE_CRYSTAL = new CrystalBlock(FabricBlockSettings.of(Material.AMETHYST).strength(1.5f));
	public static final Block YELLOW_CRYSTAL = new CrystalBlock(FabricBlockSettings.of(Material.AMETHYST).strength(1.5f));
	public static final Block LIGHT_GREEN_CRYSTAL = new CrystalBlock(FabricBlockSettings.of(Material.AMETHYST).strength(1.5f));
	public static final Block PINK_CRYSTAL = new CrystalBlock(FabricBlockSettings.of(Material.AMETHYST).strength(1.5f));
	public static final Block AQUA_CRYSTAL = new CrystalBlock(FabricBlockSettings.of(Material.AMETHYST).strength(1.5f));
	public static final Block TURQUOISE_CRYSTAL = new CrystalBlock(FabricBlockSettings.of(Material.AMETHYST).strength(1.5f));
	public static final Block PURPLE_CRYSTAL = new CrystalBlock(FabricBlockSettings.of(Material.AMETHYST).strength(1.5f));
	public static final Block DARK_BLUE_CRYSTAL = new CrystalBlock(FabricBlockSettings.of(Material.AMETHYST).strength(1.5f));
	public static final Block DARK_GREEN_CRYSTAL = new CrystalBlock(FabricBlockSettings.of(Material.AMETHYST).strength(1.5f));
	public static final Block RED_CRYSTAL = new CrystalBlock(FabricBlockSettings.of(Material.AMETHYST).strength(1.5f));

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Hello Fabric world!");
		Registry.register(Registry.BLOCK, new Identifier("deepercaves", "white_crystal"), WHITE_CRYSTAL);
		Registry.register(Registry.ITEM, new Identifier("deepercaves", "white_crystal"), new BlockItem(WHITE_CRYSTAL, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));

		Registry.register(Registry.BLOCK, new Identifier("deepercaves", "orange_crystal"), ORANGE_CRYSTAL);
		Registry.register(Registry.ITEM, new Identifier("deepercaves", "orange_crystal"), new BlockItem(ORANGE_CRYSTAL, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));

		Registry.register(Registry.BLOCK, new Identifier("deepercaves", "magenta_crystal"), MAGENTA_CRYSTAL);
		Registry.register(Registry.ITEM, new Identifier("deepercaves", "magenta_crystal"), new BlockItem(MAGENTA_CRYSTAL, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));

		Registry.register(Registry.BLOCK, new Identifier("deepercaves", "light_blue_crystal"), LIGHT_BLUE_CRYSTAL);
		Registry.register(Registry.ITEM, new Identifier("deepercaves", "light_blue_crystal"), new BlockItem(LIGHT_BLUE_CRYSTAL, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));

		Registry.register(Registry.BLOCK, new Identifier("deepercaves", "yellow_crystal"), YELLOW_CRYSTAL);
		Registry.register(Registry.ITEM, new Identifier("deepercaves", "yellow_crystal"), new BlockItem(YELLOW_CRYSTAL, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));

		Registry.register(Registry.BLOCK, new Identifier("deepercaves", "light_green_crystal"), LIGHT_GREEN_CRYSTAL);
		Registry.register(Registry.ITEM, new Identifier("deepercaves", "light_green_crystal"), new BlockItem(LIGHT_GREEN_CRYSTAL, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));

		Registry.register(Registry.BLOCK, new Identifier("deepercaves", "pink_crystal"), PINK_CRYSTAL);
		Registry.register(Registry.ITEM, new Identifier("deepercaves", "pink_crystal"), new BlockItem(PINK_CRYSTAL, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));

		Registry.register(Registry.BLOCK, new Identifier("deepercaves", "aqua_crystal"), AQUA_CRYSTAL);
		Registry.register(Registry.ITEM, new Identifier("deepercaves", "aqua_crystal"), new BlockItem(AQUA_CRYSTAL, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));

		Registry.register(Registry.BLOCK, new Identifier("deepercaves", "turquoise_crystal"), TURQUOISE_CRYSTAL);
		Registry.register(Registry.ITEM, new Identifier("deepercaves", "turquoise_crystal"), new BlockItem(TURQUOISE_CRYSTAL, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));

		Registry.register(Registry.BLOCK, new Identifier("deepercaves", "purple_crystal"), PURPLE_CRYSTAL);
		Registry.register(Registry.ITEM, new Identifier("deepercaves", "purple_crystal"), new BlockItem(PURPLE_CRYSTAL, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));

		Registry.register(Registry.BLOCK, new Identifier("deepercaves", "dark_blue_crystal"), DARK_BLUE_CRYSTAL);
		Registry.register(Registry.ITEM, new Identifier("deepercaves", "dark_blue_crystal"), new BlockItem(DARK_BLUE_CRYSTAL, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));

		Registry.register(Registry.BLOCK, new Identifier("deepercaves", "dark_green_crystal"), DARK_GREEN_CRYSTAL);
		Registry.register(Registry.ITEM, new Identifier("deepercaves", "dark_green_crystal"), new BlockItem(DARK_GREEN_CRYSTAL, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));

		Registry.register(Registry.BLOCK, new Identifier("deepercaves", "red_crystal"), RED_CRYSTAL);
		Registry.register(Registry.ITEM, new Identifier("deepercaves", "red_crystal"), new BlockItem(RED_CRYSTAL, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));

		Registry.register(Registry.BLOCK, new Identifier("deepercaves", "crystal"), CRYSTAL);
		Registry.register(Registry.ITEM, new Identifier("deepercaves", "crystal"), new BlockItem(CRYSTAL, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));



	}
}

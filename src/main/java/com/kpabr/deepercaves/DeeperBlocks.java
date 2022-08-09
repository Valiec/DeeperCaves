package com.kpabr.deepercaves;

import com.kpabr.deepercaves.block.CrystalBlock;
import com.kpabr.deepercaves.block.StoneBlock;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class DeeperBlocks {

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



    public static final Block DEEP_STONE = new StoneBlock(FabricBlockSettings.of(Material.STONE).strength(3.0F, 6.0F));
    public static final Block DARK_STONE = new StoneBlock(FabricBlockSettings.of(Material.STONE).strength(3.0F, 6.0F));
    public static final Block ABANDONED_STONE = new StoneBlock(FabricBlockSettings.of(Material.STONE).strength(2.0F, 6.0F));
    public static final Block SOUL_STONE = new StoneBlock(FabricBlockSettings.of(Material.STONE).strength(1.5F, 6.0F));
    public static final Block CORRUPTED_SOUL_STONE = new StoneBlock(FabricBlockSettings.of(Material.STONE).strength(1.5F, 6.0F));

    public static final Block SILVER_ORE = new StoneBlock(FabricBlockSettings.of(Material.STONE).strength(3.0F, 3.0F));
    public static final Block RAW_SILVER = new StoneBlock(FabricBlockSettings.of(Material.STONE).strength(5.0F, 6.0F));

    public static final Block ONYX_BLOCK = new AmethystBlock(FabricBlockSettings.of(Material.AMETHYST).sounds(BlockSoundGroup.AMETHYST_BLOCK).strength(1.5F).requiresTool());
    public static final Block BUDDING_ONYX = new BuddingAmethystBlock(FabricBlockSettings.of(Material.AMETHYST).sounds(BlockSoundGroup.AMETHYST_BLOCK).strength(1.5F).requiresTool());

    public static final Block ONYX_CLUSTER = new AmethystClusterBlock(7, 3, FabricBlockSettings.of(Material.AMETHYST).nonOpaque().ticksRandomly().sounds(BlockSoundGroup.AMETHYST_CLUSTER).requiresTool().luminance((state) -> 5));

    public static final Block LARGE_ONYX_BUD = new AmethystClusterBlock(5, 3, FabricBlockSettings.of(Material.AMETHYST).nonOpaque().ticksRandomly().sounds(BlockSoundGroup.LARGE_AMETHYST_BUD).luminance((state) -> 4));

    public static final Block MEDIUM_ONYX_BUD = new AmethystClusterBlock(4, 3, FabricBlockSettings.of(Material.AMETHYST).nonOpaque().ticksRandomly().sounds(BlockSoundGroup.MEDIUM_AMETHYST_BUD).luminance((state) -> 2));

    public static final Block SMALL_ONYX_BUD = new AmethystClusterBlock(3, 4, FabricBlockSettings.of(Material.AMETHYST).nonOpaque().ticksRandomly().sounds(BlockSoundGroup.SMALL_AMETHYST_BUD).luminance((state) -> 1));



    //public static final Block MAZE_STONE = new CrystalBlock(FabricBlockSettings.of(Material.STONE).strength(1.5f));


    public static void setupBlocks()
    {
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

        Registry.register(Registry.BLOCK, new Identifier("deepercaves", "abandoned_stone"), ABANDONED_STONE);
        Registry.register(Registry.ITEM, new Identifier("deepercaves", "abandoned_stone"), new BlockItem(ABANDONED_STONE, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));

        Registry.register(Registry.BLOCK, new Identifier("deepercaves", "deep_stone"), DEEP_STONE);
        Registry.register(Registry.ITEM, new Identifier("deepercaves", "deep_stone"), new BlockItem(DEEP_STONE, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));

        Registry.register(Registry.BLOCK, new Identifier("deepercaves", "dark_stone"), DARK_STONE);
        Registry.register(Registry.ITEM, new Identifier("deepercaves", "dark_stone"), new BlockItem(DARK_STONE, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));

        Registry.register(Registry.BLOCK, new Identifier("deepercaves", "soul_stone"), SOUL_STONE);
        Registry.register(Registry.ITEM, new Identifier("deepercaves", "soul_stone"), new BlockItem(SOUL_STONE, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));

        Registry.register(Registry.BLOCK, new Identifier("deepercaves", "corrupted_soul_stone"), CORRUPTED_SOUL_STONE);
        Registry.register(Registry.ITEM, new Identifier("deepercaves", "corrupted_soul_stone"), new BlockItem(CORRUPTED_SOUL_STONE, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));

        Registry.register(Registry.BLOCK, new Identifier("deepercaves", "silver_ore"), SILVER_ORE);
        Registry.register(Registry.ITEM, new Identifier("deepercaves", "silver_ore"), new BlockItem(SILVER_ORE, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));

        Registry.register(Registry.BLOCK, new Identifier("deepercaves", "raw_silver_block"), RAW_SILVER);
        Registry.register(Registry.ITEM, new Identifier("deepercaves", "raw_silver_block"), new BlockItem(RAW_SILVER, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));

        Registry.register(Registry.BLOCK, new Identifier("deepercaves", "onyx_block"), ONYX_BLOCK);
        Registry.register(Registry.ITEM, new Identifier("deepercaves", "onyx_block"), new BlockItem(ONYX_BLOCK, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));

        Registry.register(Registry.BLOCK, new Identifier("deepercaves", "budding_onyx"), BUDDING_ONYX);
        Registry.register(Registry.ITEM, new Identifier("deepercaves", "budding_onyx"), new BlockItem(BUDDING_ONYX, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));

        Registry.register(Registry.BLOCK, new Identifier("deepercaves", "onyx_cluster"), ONYX_CLUSTER);
        Registry.register(Registry.ITEM, new Identifier("deepercaves", "onyx_cluster"), new BlockItem(ONYX_CLUSTER, new FabricItemSettings().group(ItemGroup.DECORATIONS)));

        Registry.register(Registry.BLOCK, new Identifier("deepercaves", "small_onyx_bud"), SMALL_ONYX_BUD);
        Registry.register(Registry.ITEM, new Identifier("deepercaves", "small_onyx_bud"), new BlockItem(SMALL_ONYX_BUD, new FabricItemSettings().group(ItemGroup.DECORATIONS)));

        Registry.register(Registry.BLOCK, new Identifier("deepercaves", "medium_onyx_bud"), MEDIUM_ONYX_BUD);
        Registry.register(Registry.ITEM, new Identifier("deepercaves", "medium_onyx_bud"), new BlockItem(MEDIUM_ONYX_BUD, new FabricItemSettings().group(ItemGroup.DECORATIONS)));

        Registry.register(Registry.BLOCK, new Identifier("deepercaves", "large_onyx_bud"), LARGE_ONYX_BUD);
        Registry.register(Registry.ITEM, new Identifier("deepercaves", "large_onyx_bud"), new BlockItem(LARGE_ONYX_BUD, new FabricItemSettings().group(ItemGroup.DECORATIONS)));

    }

}

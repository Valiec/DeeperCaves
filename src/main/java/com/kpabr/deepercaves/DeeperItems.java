package com.kpabr.deepercaves;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class DeeperItems {

    public static final Item WHITE_CRYSTAL_SHARD = new Item(new FabricItemSettings().group(ItemGroup.MISC));
    public static final Item ORANGE_CRYSTAL_SHARD = new Item(new FabricItemSettings().group(ItemGroup.MISC));
    public static final Item MAGENTA_CRYSTAL_SHARD = new Item(new FabricItemSettings().group(ItemGroup.MISC));
    public static final Item LIGHT_BLUE_CRYSTAL_SHARD = new Item(new FabricItemSettings().group(ItemGroup.MISC));
    public static final Item YELLOW_CRYSTAL_SHARD = new Item(new FabricItemSettings().group(ItemGroup.MISC));
    public static final Item LIGHT_GREEN_CRYSTAL_SHARD = new Item(new FabricItemSettings().group(ItemGroup.MISC));
    public static final Item PINK_CRYSTAL_SHARD = new Item(new FabricItemSettings().group(ItemGroup.MISC));
    public static final Item AQUA_CRYSTAL_SHARD = new Item(new FabricItemSettings().group(ItemGroup.MISC));
    public static final Item TURQUOISE_CRYSTAL_SHARD = new Item(new FabricItemSettings().group(ItemGroup.MISC));
    public static final Item PURPLE_CRYSTAL_SHARD = new Item(new FabricItemSettings().group(ItemGroup.MISC));
    public static final Item DARK_BLUE_CRYSTAL_SHARD = new Item(new FabricItemSettings().group(ItemGroup.MISC));
    public static final Item DARK_GREEN_CRYSTAL_SHARD = new Item(new FabricItemSettings().group(ItemGroup.MISC));
    public static final Item RED_CRYSTAL_SHARD = new Item(new FabricItemSettings().group(ItemGroup.MISC));

    public static final Item RAW_SILVER = new Item(new FabricItemSettings().group(ItemGroup.MATERIALS));
    public static final Item ONYX_SHARD = new Item(new FabricItemSettings().group(ItemGroup.MISC));

    public static final Item AQUAMARINE = new Item(new FabricItemSettings().group(ItemGroup.MATERIALS));
    public static final Item RUBY = new Item(new FabricItemSettings().group(ItemGroup.MATERIALS));
    public static final Item SAPPHIRE = new Item(new FabricItemSettings().group(ItemGroup.MATERIALS));
    public static final Item AMETRINE = new Item(new FabricItemSettings().group(ItemGroup.MATERIALS));


    public static void setupItems()
    {
        Registry.register(Registry.ITEM, new Identifier("deepercaves", "white_crystal_shard"), WHITE_CRYSTAL_SHARD);
        Registry.register(Registry.ITEM, new Identifier("deepercaves", "orange_crystal_shard"), ORANGE_CRYSTAL_SHARD);
        Registry.register(Registry.ITEM, new Identifier("deepercaves", "magenta_crystal_shard"), MAGENTA_CRYSTAL_SHARD);
        Registry.register(Registry.ITEM, new Identifier("deepercaves", "light_blue_crystal_shard"), LIGHT_BLUE_CRYSTAL_SHARD);
        Registry.register(Registry.ITEM, new Identifier("deepercaves", "yellow_crystal_shard"), YELLOW_CRYSTAL_SHARD);
        Registry.register(Registry.ITEM, new Identifier("deepercaves", "light_green_crystal_shard"), LIGHT_GREEN_CRYSTAL_SHARD);
        Registry.register(Registry.ITEM, new Identifier("deepercaves", "pink_crystal_shard"), PINK_CRYSTAL_SHARD);
        Registry.register(Registry.ITEM, new Identifier("deepercaves", "aqua_crystal_shard"), AQUA_CRYSTAL_SHARD);
        Registry.register(Registry.ITEM, new Identifier("deepercaves", "turquoise_crystal_shard"), TURQUOISE_CRYSTAL_SHARD);
        Registry.register(Registry.ITEM, new Identifier("deepercaves", "purple_crystal_shard"), PURPLE_CRYSTAL_SHARD);
        Registry.register(Registry.ITEM, new Identifier("deepercaves", "dark_blue_crystal_shard"), DARK_BLUE_CRYSTAL_SHARD);
        Registry.register(Registry.ITEM, new Identifier("deepercaves", "dark_green_crystal_shard"), DARK_GREEN_CRYSTAL_SHARD);
        Registry.register(Registry.ITEM, new Identifier("deepercaves", "red_crystal_shard"), RED_CRYSTAL_SHARD);

        Registry.register(Registry.ITEM, new Identifier("deepercaves", "raw_silver"), RAW_SILVER);
        Registry.register(Registry.ITEM, new Identifier("deepercaves", "onyx_shard"), ONYX_SHARD);

        Registry.register(Registry.ITEM, new Identifier("deepercaves", "aquamarine"), AQUAMARINE);
        Registry.register(Registry.ITEM, new Identifier("deepercaves", "ruby"), RUBY);
        Registry.register(Registry.ITEM, new Identifier("deepercaves", "sapphire"), SAPPHIRE);
        Registry.register(Registry.ITEM, new Identifier("deepercaves", "ametrine"), AMETRINE);


    }
}

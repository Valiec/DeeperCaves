package com.kpabr.DeeperCaves;

import com.kpabr.DeeperCaves.item.*;

import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.registry.GameRegistry;

public class DeeperItems {
    /*Item declarations*/
    public static Item silverIngot;
    public static Item sapphireGem;
    public static Item ametrineGem;
    
    public static Item aquamarine;
    
    public static Item ametrineTippedDiamondPickaxe;
    
    public static Item ametrineTippedSilverPickaxe;
    
    public static Item silverPickaxe;
    
    public static Item ametrineTippedSilverAxe;
    
    public static Item silverAxe;
    
    public static Item ametrineTippedSilverShovel;
    
    public static Item silverShovel;
    
    public static Item ametrineTippedSilverSword;
    
    public static Item silverSword;
    
    public static Item ametrineTippedSilverHoe;
    
    public static Item silverHoe;
    
    public static Item ametrineTippedGoldenPickaxe;
    public static Item ametrineTippedIronPickaxe;
    public static Item ametrineTippedStonePickaxe;
    
    public static Item ametrineTippedWoodenPickaxe;
    
    public static Item tenebriumIngot;
    
    public static Item tenebriumIngotRaw;
    
    public static Item fragmentedBedrockBucket;
    
    public static Item fragmentedBedrockBucketMI;
    public static Item fragmentedBedrockBucketW;
    public static Item fragmentedBedrockBucketL;
    
    public static Item vesperiteGem;
    
    public static Item voidCharm;
    
    public static Item forgottenCharm;
    
    public static Item prisciumIngot;
    
    public static Item prisciumDust;
    
	public static Item bucketV;
	
	public static Item fragmentedBedrockBucketV;
	
	public static Item evanesciteGem;
	
	public static Item crystalShard;
	
	public static Item ruby;

    public static Item incenditeGem;

    public static Item robustiumIngot;

    public static Item profundiumIngot;

    public static Item rottenDoor;

    /*Tool and Armor Material declarations*/
    static ToolMaterial AmetrineD = EnumHelper.addToolMaterial("AMETRINE_D", 4, 1561, 14.0F, 3.0F, 10);
    
    static ToolMaterial AmetrineG = EnumHelper.addToolMaterial("AMETRINE_G", 1, 32, 18.0F, 0.0F, 22);
    static ToolMaterial AmetrineI = EnumHelper.addToolMaterial("AMETRINE_I", 3, 250, 11.0F, 2.0F, 14);
    static ToolMaterial AmetrineS = EnumHelper.addToolMaterial("AMETRINE_S", 2, 131, 9.0F, 1.0F, 5);
    
    static ToolMaterial AmetrineAg = EnumHelper.addToolMaterial("AMETRINE_AG", 3, 1000, 16.0F, 2.5F, 30); //silver
    
    static ToolMaterial Silver = EnumHelper.addToolMaterial("SILVER", 2, 300, 16.0F, 2.5F, 30); //silver
    
    static ToolMaterial AmetrineW = EnumHelper.addToolMaterial("AMETRINE_W", 1, 50, 7.0F, 0.0F, 15);
    
    static ArmorMaterial AmetrineLArmor = EnumHelper.addArmorMaterial("AMETRINE_L_ARMOR", 5, new int[]{2, 5, 4, 1}, 15);
    
    static ArmorMaterial AmetrineCArmor = EnumHelper.addArmorMaterial("AMETRINE_C_ARMOR", 15, new int[]{2, 6, 5, 2}, 12);
    
    static ArmorMaterial AmetrineIArmor = EnumHelper.addArmorMaterial("AMETRINE_I_ARMOR", 15, new int[]{3, 8, 6, 3}, 9);
    
    static ArmorMaterial AmetrineGArmor = EnumHelper.addArmorMaterial("AMETRINE_G_ARMOR", 7, new int[]{2, 6, 5, 2}, 25);
    
    static ArmorMaterial AmetrineDArmor = EnumHelper.addArmorMaterial("AMETRINE_D_ARMOR", 33, new int[]{4, 10, 7, 3}, 10);
    
    public static Item forgottenGemstone;
    
    public void registerItems()
    {
       
        GameRegistry.registerItem(silverIngot, "silver_ingot");
        GameRegistry.registerItem(sapphireGem, "sapphire_gem");
        GameRegistry.registerItem(ametrineGem, "ametrine_gem");
        
        GameRegistry.registerItem(aquamarine, "aquamarine");
        
        GameRegistry.registerItem(ametrineTippedDiamondPickaxe, "ametrine_tipped_diamond_pickaxe");
        
        GameRegistry.registerItem(ametrineTippedSilverPickaxe, "ametrine_tipped_silver_pickaxe");
        
        GameRegistry.registerItem(silverPickaxe, "silver_pickaxe");
        
        GameRegistry.registerItem(ametrineTippedSilverAxe, "ametrine_tipped_silver_axe");
        
        GameRegistry.registerItem(silverAxe, "silver_axe");
        
        GameRegistry.registerItem(ametrineTippedSilverShovel, "ametrine_tipped_silver_shovel");
        
        GameRegistry.registerItem(silverShovel, "silver_shovel");
        
        GameRegistry.registerItem(ametrineTippedSilverSword, "ametrine_tipped_silver_sword");
        
        GameRegistry.registerItem(silverSword, "silver_sword");
        
        GameRegistry.registerItem(ametrineTippedSilverHoe, "ametrine_tipped_silver_hoe");
        
        GameRegistry.registerItem(silverHoe, "silver_hoe");
        
        GameRegistry.registerItem(ametrineTippedGoldenPickaxe, "ametrine_tipped_golden_pickaxe");
        GameRegistry.registerItem(ametrineTippedIronPickaxe, "ametrine_tipped_iron_pickaxe");
        GameRegistry.registerItem(ametrineTippedStonePickaxe, "ametrine_tipped_stone_pickaxe");
        
        GameRegistry.registerItem(ametrineTippedWoodenPickaxe, "ametrine_tipped_wooden_pickaxe");
        
        GameRegistry.registerItem(tenebriumIngot, "tenebrium_ingot");
        
        //GameRegistry.registerItem(tenebriumIngotRaw, "tenebriumIngotRaw");
        
        GameRegistry.registerItem(forgottenGemstone, "forgottenGemstone");
        
        GameRegistry.registerItem(fragmentedBedrockBucket, "fragmented_bedrock_bucket");
        
        GameRegistry.registerItem(fragmentedBedrockBucketMI, "fragmented_bedrock_bucket_molten_iron");
        GameRegistry.registerItem(fragmentedBedrockBucketW, "fragmented_bedrock_bucket_water");
        GameRegistry.registerItem(fragmentedBedrockBucketL, "fragmented_bedrock_bucket_lava");
        
        GameRegistry.registerItem(vesperiteGem, "vesperite_gem");
        
        GameRegistry.registerItem(voidCharm, "void_charm");
        
        GameRegistry.registerItem(forgottenCharm, "forgotten_charm");
        
        GameRegistry.registerItem(prisciumIngot, "priscium_ingot");
        
        GameRegistry.registerItem(prisciumDust, "priscium_dust");

        GameRegistry.registerItem(bucketV, "bucket_venenium");
        GameRegistry.registerItem(fragmentedBedrockBucketV, "fragmented_bedrock_bucket_venenium");
        
        GameRegistry.registerItem(evanesciteGem, "evanescite_gem");
        
        GameRegistry.registerItem(crystalShard, "crystal_shard");
        
        GameRegistry.registerItem(ruby, "ruby");

        GameRegistry.registerItem(profundiumIngot, "profundium_ingot");
        GameRegistry.registerItem(robustiumIngot, "robustium_ingot");
        GameRegistry.registerItem(incenditeGem, "incendite_gem");

        GameRegistry.registerItem(rottenDoor, "rotten_door_item");
    }
    
    public void registerItemsOreDict()
    {
    	OreDictionary.registerOre("ingotSilver", silverIngot);
    	OreDictionary.registerOre("gemSapphire", sapphireGem);
    	OreDictionary.registerOre("gemAmetrine", ametrineGem);
        
    	OreDictionary.registerOre("gemAquamarine", aquamarine);
    	
    	OreDictionary.registerOre("ingotTenebrium", tenebriumIngot);
    	
    	OreDictionary.registerOre("gemForgotten", forgottenGemstone);
    	
    	OreDictionary.registerOre("ingotPriscium", prisciumIngot);
    	
    	OreDictionary.registerOre("dustPriscium", prisciumDust);
    	
    	OreDictionary.registerOre("gemVesperite", vesperiteGem);
    	
    	OreDictionary.registerOre("gemEvanescite", evanesciteGem);
    	
    	OreDictionary.registerOre("gemRuby", ruby);

        OreDictionary.registerOre("gemIncendite", incenditeGem);
        OreDictionary.registerOre("ingotProfundium", profundiumIngot);
        OreDictionary.registerOre("ingotRobustium", robustiumIngot);
    }
    
    public void setupItems()
    {
    
        silverIngot = new ItemBase().setTextureName("deepercaves:silver_ingot").setUnlocalizedName("silverIngot").setCreativeTab(DeeperCaves.tabDeeperCavesItems);
        sapphireGem = new ItemBase().setTextureName("deepercaves:sapphireGem").setUnlocalizedName("sapphireGem").setCreativeTab(DeeperCaves.tabDeeperCavesItems);
        ametrineGem = new ItemBase().setTextureName("deepercaves:ametrineGem").setUnlocalizedName("ametrineGem").setCreativeTab(DeeperCaves.tabDeeperCavesItems);
        
        aquamarine = new ItemBase().setTextureName("deepercaves:aquamarine").setUnlocalizedName("aquamarine").setCreativeTab(DeeperCaves.tabDeeperCavesItems);
        
        ametrineTippedDiamondPickaxe = new ItemPickaxeBase(AmetrineD).setTextureName("deepercaves:ametrineTippedDiamondPickaxe").setUnlocalizedName("ametrineTippedDiamondPickaxe").setCreativeTab(DeeperCaves.tabDeeperCavesTools);
        
        ametrineTippedSilverPickaxe = new ItemPickaxeBase(AmetrineAg).setTextureName("deepercaves:ametrineTippedSilverPickaxe").setUnlocalizedName("ametrineTippedSilverPickaxe").setCreativeTab(DeeperCaves.tabDeeperCavesTools);
        silverPickaxe = new ItemPickaxeBase(Silver).setTextureName("deepercaves:silver_pickaxe").setUnlocalizedName("silverPickaxe").setCreativeTab(DeeperCaves.tabDeeperCavesTools);
        
        ametrineTippedSilverAxe = new ItemAxeBase(AmetrineAg).setTextureName("deepercaves:ametrineTippedSilverAxe").setUnlocalizedName("ametrineTippedSilverAxe").setCreativeTab(DeeperCaves.tabDeeperCavesTools);
        silverAxe = new ItemAxeBase(Silver).setTextureName("deepercaves:silver_axe").setUnlocalizedName("silverAxe").setCreativeTab(DeeperCaves.tabDeeperCavesTools);
        
        ametrineTippedSilverShovel = new ItemSpadeBase(AmetrineAg).setTextureName("deepercaves:ametrineTippedSilverShovel").setUnlocalizedName("ametrineTippedSilverShovel").setCreativeTab(DeeperCaves.tabDeeperCavesTools);
        silverShovel = new ItemSpadeBase(Silver).setTextureName("deepercaves:silver_shovel").setUnlocalizedName("silverShovel").setCreativeTab(DeeperCaves.tabDeeperCavesTools);
        
        ametrineTippedSilverSword = new ItemSwordBase(AmetrineAg).setTextureName("deepercaves:ametrineTippedSilverSword").setUnlocalizedName("ametrineTippedSilverSword").setCreativeTab(DeeperCaves.tabDeeperCavesCombat);
        silverSword = new ItemSwordBase(Silver).setTextureName("deepercaves:silver_sword").setUnlocalizedName("silverSword").setCreativeTab(DeeperCaves.tabDeeperCavesCombat);
        
        ametrineTippedSilverHoe = new ItemHoeBase(AmetrineAg).setTextureName("deepercaves:ametrineTippedSilverHoe").setUnlocalizedName("ametrineTippedSilverHoe").setCreativeTab(DeeperCaves.tabDeeperCavesTools);
        silverHoe = new ItemHoeBase(Silver).setTextureName("deepercaves:silver_hoe").setUnlocalizedName("silverHoe").setCreativeTab(DeeperCaves.tabDeeperCavesTools);
        
        ametrineTippedGoldenPickaxe = new ItemPickaxeBase(AmetrineG).setTextureName("deepercaves:ametrineTippedGoldenPickaxe").setUnlocalizedName("ametrineTippedGoldenPickaxe").setCreativeTab(DeeperCaves.tabDeeperCavesTools);
        ametrineTippedIronPickaxe = new ItemPickaxeBase(AmetrineI).setTextureName("deepercaves:ametrineTippedIronPickaxe").setUnlocalizedName("ametrineTippedIronPickaxe").setCreativeTab(DeeperCaves.tabDeeperCavesTools);
        ametrineTippedStonePickaxe = new ItemPickaxeBase(AmetrineS).setTextureName("deepercaves:ametrineTippedStonePickaxe").setUnlocalizedName("ametrineTippedStonePickaxe").setCreativeTab(DeeperCaves.tabDeeperCavesTools);
        
        ametrineTippedWoodenPickaxe = new ItemPickaxeBase(AmetrineW).setTextureName("deepercaves:ametrineTippedWoodenPickaxe").setUnlocalizedName("ametrineTippedWoodenPickaxe").setCreativeTab(DeeperCaves.tabDeeperCavesTools);
        
        tenebriumIngot = new ItemBase().setTextureName("deepercaves:tenebriumIngot").setUnlocalizedName("tenebriumIngot").setCreativeTab(DeeperCaves.tabDeeperCavesItems);
        
        tenebriumIngotRaw = new ItemBase().setTextureName("deepercaves:drippingTenebriumIngot").setUnlocalizedName("tenebriumIngotDripping").setCreativeTab(DeeperCaves.tabDeeperCavesItems);
        
        forgottenGemstone = new ItemBase().setTextureName("deepercaves:forgottenGemstone").setUnlocalizedName("forgottenGemstone").setCreativeTab(DeeperCaves.tabDeeperCavesItems);
        
        fragmentedBedrockBucket = new ItemFragmentedBedrockBucket(Blocks.air).setTextureName("deepercaves:fragmented_bedrock_bucket").setUnlocalizedName("fragmentedBedrockBucket").setCreativeTab(DeeperCaves.tabDeeperCavesItems);
        
        fragmentedBedrockBucketMI = new ItemFragmentedBedrockBucket(DeeperFluids.moltenIronBlock).setTextureName("deepercaves:fragmented_bedrock_bucket_mi").setUnlocalizedName("fragmentedBedrockBucketMoltenIron").setCreativeTab(DeeperCaves.tabDeeperCavesItems);
        
        fragmentedBedrockBucketW = new ItemFragmentedBedrockBucket(Blocks.flowing_water).setTextureName("deepercaves:fragmented_bedrock_bucket_w").setUnlocalizedName("fragmentedBedrockBucketWater").setCreativeTab(DeeperCaves.tabDeeperCavesItems);
        
        fragmentedBedrockBucketL = new ItemFragmentedBedrockBucket(Blocks.flowing_lava).setTextureName("deepercaves:fragmented_bedrock_bucket_l").setUnlocalizedName("fragmentedBedrockBucketLava").setCreativeTab(DeeperCaves.tabDeeperCavesItems);
        
        vesperiteGem = new ItemBase().setTextureName("deepercaves:vesperite_gem").setUnlocalizedName("vesperiteGem").setCreativeTab(DeeperCaves.tabDeeperCavesItems);
        
        voidCharm = new ItemVoidCharm().setTextureName("deepercaves:voidCharm").setUnlocalizedName("voidCharm").setCreativeTab(DeeperCaves.tabDeeperCavesItems);
        
        forgottenCharm = new ItemForgottenCharm().setTextureName("deepercaves:forgottenCharm").setUnlocalizedName("forgottenCharm").setCreativeTab(DeeperCaves.tabDeeperCavesItems);
        
        prisciumIngot = new ItemBase().setTextureName("deepercaves:priscium_ingot").setUnlocalizedName("prisciumIngot").setCreativeTab(DeeperCaves.tabDeeperCavesItems);

        prisciumDust = new ItemBase().setTextureName("deepercaves:priscium_dust").setUnlocalizedName("prisciumDust").setCreativeTab(DeeperCaves.tabDeeperCavesItems);
        
        bucketV = new ItemVeneniumBucket(DeeperFluids.veneniumBlock).setTextureName("deepercaves:bucket_v").setUnlocalizedName("bucketVenenium").setCreativeTab(DeeperCaves.tabDeeperCavesItems);
        
        fragmentedBedrockBucketV = new ItemFragmentedBedrockBucket(DeeperFluids.veneniumBlock).setTextureName("deepercaves:fragmented_bedrock_bucket_v").setUnlocalizedName("fragmentedBedrockBucketVenenium").setCreativeTab(DeeperCaves.tabDeeperCavesItems);
        
        evanesciteGem = new ItemBase().setTextureName("deepercaves:evanescite_gem").setUnlocalizedName("evanesciteGem").setCreativeTab(DeeperCaves.tabDeeperCavesItems);
        
        crystalShard = new ItemCrystal().setUnlocalizedName("crystalShard").setCreativeTab(DeeperCaves.tabDeeperCavesItems);
        
        ruby = new ItemBase().setTextureName("deepercaves:ruby").setUnlocalizedName("ruby").setCreativeTab(DeeperCaves.tabDeeperCavesItems);

        incenditeGem = new ItemBase().setTextureName("deepercaves:incendite_gem").setUnlocalizedName("incenditeGem").setCreativeTab(DeeperCaves.tabDeeperCavesItems);
        profundiumIngot = new ItemBase().setTextureName("deepercaves:profundium_ingot").setUnlocalizedName("profundiumIngot").setCreativeTab(DeeperCaves.tabDeeperCavesItems);
        robustiumIngot = new ItemBase().setTextureName("deepercaves:robustium_ingot").setUnlocalizedName("robustiumIngot").setCreativeTab(DeeperCaves.tabDeeperCavesItems);

        rottenDoor = new ItemRottenDoor(Material.wood).setTextureName("deepercaves:rotting_door").setUnlocalizedName("rottenDoor").setCreativeTab(DeeperCaves.tabDeeperCaves);

    }
}

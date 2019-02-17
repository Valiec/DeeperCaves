package com.kpabr.DeeperCaves;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;

public class DeeperRecipes {

    public void setupShapedCrafting()
    {
        /*Registering shaped crafting recipes in GameRegistry*/
        GameRegistry.addRecipe(new ItemStack(DeeperCaves.blocks.silverBlock, 1), new Object[]{"ZZZ", "ZZZ", "ZZZ", 'Z', DeeperCaves.items.silverIngot});
        
        GameRegistry.addRecipe(new ItemStack(DeeperCaves.blocks.sapphireBlock, 1), new Object[]{"ZZZ", "ZZZ", "ZZZ", 'Z', DeeperCaves.items.sapphireGem});
        GameRegistry.addRecipe(new ItemStack(DeeperCaves.blocks.aquamarineBlock, 1), new Object[]{"ZZZ", "ZZZ", "ZZZ", 'Z', DeeperCaves.items.aquamarine});
        GameRegistry.addRecipe(new ItemStack(DeeperCaves.blocks.ametrineBlock, 1), new Object[]{"ZZZ", "ZZZ", "ZZZ", 'Z', DeeperCaves.items.ametrineGem});
        
        GameRegistry.addRecipe(new ItemStack(DeeperCaves.items.ametrineTippedDiamondPickaxe, 1), new Object[]{"XYX", 'X', DeeperCaves.items.ametrineGem, 'Y', Items.diamond_pickaxe});
        
        GameRegistry.addRecipe(new ItemStack(DeeperCaves.items.ametrineTippedGoldenPickaxe, 1), new Object[]{"XYX", 'X', DeeperCaves.items.ametrineGem, 'Y', Items.golden_pickaxe});
        GameRegistry.addRecipe(new ItemStack(DeeperCaves.items.ametrineTippedIronPickaxe, 1), new Object[]{"XYX", 'X', DeeperCaves.items.ametrineGem, 'Y', Items.iron_pickaxe});
        GameRegistry.addRecipe(new ItemStack(DeeperCaves.items.ametrineTippedStonePickaxe, 1), new Object[]{"XYX", 'X', DeeperCaves.items.ametrineGem, 'Y', Items.stone_pickaxe});
        
        GameRegistry.addRecipe(new ItemStack(DeeperCaves.items.ametrineTippedWoodenPickaxe, 1), new Object[]{"XYX", 'X', DeeperCaves.items.ametrineGem, 'Y', Items.wooden_pickaxe});
        
        GameRegistry.addRecipe(new ItemStack(DeeperCaves.blocks.tenebriumBlock, 1), new Object[]{"ZZZ", "ZZZ", "ZZZ", 'Z', DeeperCaves.items.tenebriumIngot});
        
        GameRegistry.addRecipe(new ItemStack(DeeperCaves.items.fragmentedBedrockBucket, 1), new Object[]{"Z Z", "Z", 'Z', DeeperCaves.blocks.fragmentedBedrock});
        
        GameRegistry.addRecipe(new ItemStack(DeeperCaves.blocks.forgottenGemstoneBlock, 1), new Object[]{"ZZZ", "ZZZ", "ZZZ", 'Z', DeeperCaves.items.forgottenGemstone});
        
        GameRegistry.addRecipe(new ItemStack(DeeperCaves.blocks.dropPortal, 1), new Object[]{"ZZZ", "Z Z", "ZZZ", 'Z', Blocks.obsidian});
        
        GameRegistry.addRecipe(new ItemStack(DeeperCaves.items.voidCharm, 1), new Object[]{" X ", "XYX", " X ", 'X', DeeperCaves.items.tenebriumIngot, 'Y', DeeperCaves.items.vesperiteGem});
        
        GameRegistry.addRecipe(new ItemStack(DeeperCaves.blocks.vesperiteBlock, 1), new Object[]{"ZZZ", "ZZZ", "ZZZ", 'Z', DeeperCaves.items.vesperiteGem});
        
        GameRegistry.addRecipe(new ItemStack(DeeperCaves.blocks.profundiumBlock, 1), new Object[]{"ZZZ", "ZZZ", "ZZZ", 'Z', DeeperCaves.items.profundiumIngot});
        
        GameRegistry.addRecipe(new ItemStack(DeeperCaves.blocks.cryingObsidian, 1), new Object[]{"ZZZ", "ZXZ", "ZZZ", 'X', Blocks.obsidian, 'Z', new ItemStack(Items.dye, 1, 4)});
        
        if(Loader.isModLoaded("ExtraUtilities"))
        {
        	System.out.println("DeeperCaves: ExtraUtilities is installed. Changing fragmented cobblestone recipe.");
        	GameRegistry.addRecipe(new ItemStack(DeeperCaves.blocks.fragmentedCobble, 2), new Object[]{"ZX", "XZ", 'X', Blocks.cobblestone, 'Z', Blocks.gravel});
        }
        else
        {
        	GameRegistry.addRecipe(new ItemStack(DeeperCaves.blocks.fragmentedCobble, 2), new Object[]{"ZZ", "ZZ", 'Z', Blocks.gravel});
        }
        
        GameRegistry.addRecipe(new ItemStack(DeeperCaves.items.forgottenCharm, 1), new Object[]{" X ", "XYX", " X ", 'X', DeeperCaves.items.tenebriumIngot, 'Y', DeeperCaves.items.evanesciteGem});
        
        GameRegistry.addRecipe(new ItemStack(DeeperCaves.blocks.evanesciteBlock, 1), new Object[]{"ZZZ", "ZZZ", "ZZZ", 'Z', DeeperCaves.items.evanesciteGem});
        for(int i = 0; i<13; i++)
        {
            GameRegistry.addRecipe(new ItemStack(DeeperCaves.blocks.crystal, 1, i), new Object[]{"WW", "WW", 'W', new ItemStack(DeeperCaves.items.crystalShard, 1, i)});
        }
        
        GameRegistry.addRecipe(new ItemStack(DeeperCaves.items.ametrineTippedSilverPickaxe, 1), new Object[]{"XYX", 'X', DeeperCaves.items.ametrineGem, 'Y', DeeperCaves.items.silverPickaxe});
        GameRegistry.addRecipe(new ItemStack(DeeperCaves.items.ametrineTippedSilverAxe, 1), new Object[]{"XYX", 'X', DeeperCaves.items.ametrineGem, 'Y', DeeperCaves.items.silverAxe});
        GameRegistry.addRecipe(new ItemStack(DeeperCaves.items.ametrineTippedSilverShovel, 1), new Object[]{"XYX", 'X', DeeperCaves.items.ametrineGem, 'Y', DeeperCaves.items.silverShovel});
        GameRegistry.addRecipe(new ItemStack(DeeperCaves.items.ametrineTippedSilverSword, 1), new Object[]{"XYX", 'X', DeeperCaves.items.ametrineGem, 'Y', DeeperCaves.items.silverSword});
        GameRegistry.addRecipe(new ItemStack(DeeperCaves.items.ametrineTippedSilverHoe, 1), new Object[]{"XYX", 'X', DeeperCaves.items.ametrineGem, 'Y', DeeperCaves.items.silverHoe});
        
        GameRegistry.addRecipe(new ItemStack(DeeperCaves.items.silverPickaxe, 1), new Object[]{"XXX", " Y ", " Y ", 'X', DeeperCaves.items.silverIngot, 'Y', Items.stick});
        GameRegistry.addRecipe(new ItemStack(DeeperCaves.items.silverAxe, 1), new Object[]{"XX ", "XY ", " Y ", 'X', DeeperCaves.items.silverIngot, 'Y', Items.stick});
        GameRegistry.addRecipe(new ItemStack(DeeperCaves.items.silverAxe, 1), new Object[]{" XX", " YX", " Y ", 'X', DeeperCaves.items.silverIngot, 'Y', Items.stick});
        GameRegistry.addRecipe(new ItemStack(DeeperCaves.items.silverShovel, 1), new Object[]{" X ", " Y ", " Y ", 'X', DeeperCaves.items.silverIngot, 'Y', Items.stick});
        GameRegistry.addRecipe(new ItemStack(DeeperCaves.items.silverSword, 1), new Object[]{" X ", " X ", " Y ", 'X', DeeperCaves.items.silverIngot, 'Y', Items.stick});
        GameRegistry.addRecipe(new ItemStack(DeeperCaves.items.silverHoe, 1), new Object[]{" XX", " Y ", " Y ", 'X', DeeperCaves.items.silverIngot, 'Y', Items.stick});
        GameRegistry.addRecipe(new ItemStack(DeeperCaves.items.silverHoe, 1), new Object[]{"XX ", " Y ", " Y ", 'X', DeeperCaves.items.silverIngot, 'Y', Items.stick});
        
        GameRegistry.addRecipe(new ItemStack(DeeperCaves.blocks.rubyBlock, 1), new Object[]{"ZZZ", "ZZZ", "ZZZ", 'Z', DeeperCaves.items.ruby});
    }
    public void setupShapelessCrafting()
    {
        /*Registering shapeless crafting recipes in GameRegistry*/
        GameRegistry.addShapelessRecipe(new ItemStack(DeeperCaves.items.silverIngot, 9), new Object[]{DeeperCaves.blocks.silverBlock});
        
        GameRegistry.addShapelessRecipe(new ItemStack(DeeperCaves.items.sapphireGem, 9), new Object[]{DeeperCaves.blocks.sapphireBlock});
        GameRegistry.addShapelessRecipe(new ItemStack(DeeperCaves.items.aquamarine, 9), new Object[]{DeeperCaves.blocks.aquamarineBlock});
        GameRegistry.addShapelessRecipe(new ItemStack(DeeperCaves.items.ametrineGem, 9), new Object[]{DeeperCaves.blocks.ametrineBlock});
        
        GameRegistry.addShapelessRecipe(new ItemStack(DeeperCaves.items.tenebriumIngot, 9), new Object[]{DeeperCaves.blocks.tenebriumBlock});
        
        GameRegistry.addShapelessRecipe(new ItemStack(DeeperCaves.items.forgottenGemstone, 9), new Object[]{DeeperCaves.blocks.forgottenGemstoneBlock});
        
        GameRegistry.addShapelessRecipe(new ItemStack(DeeperCaves.items.vesperiteGem, 9), new Object[]{DeeperCaves.blocks.vesperiteBlock});
        
        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.obsidian, 2), new Object[]{DeeperCaves.blocks.cooledObsidian, DeeperCaves.blocks.heatedObsidian});
        
        GameRegistry.addShapelessRecipe(new ItemStack(DeeperCaves.items.profundiumDust, 2), new Object[]{DeeperCaves.items.profundiumIngot});
        
        GameRegistry.addShapelessRecipe(new ItemStack(DeeperCaves.items.profundiumIngot, 9), new Object[]{DeeperCaves.blocks.profundiumBlock});
        
        GameRegistry.addShapelessRecipe(new ItemStack(DeeperCaves.items.evanesciteGem, 9), new Object[]{DeeperCaves.blocks.evanesciteBlock});
        
        GameRegistry.addShapelessRecipe(new ItemStack(DeeperCaves.items.ruby, 9), new Object[]{DeeperCaves.blocks.rubyBlock});
        
        for(ItemStack woodType:OreDictionary.getOres("plankWood"))
        {
        	GameRegistry.addShapelessRecipe(new ItemStack(DeeperCaves.blocks.rottenPlanks, 1), new Object[]{woodType.getItem(), Items.water_bucket.setContainerItem(Items.bucket)});
        
        	GameRegistry.addShapelessRecipe(new ItemStack(DeeperCaves.blocks.rottenPlanks, 1), new Object[]{woodType.getItem(), new ItemStack(Items.potionitem.setContainerItem(Items.glass_bottle), 1, 0)});
        
        	GameRegistry.addShapelessRecipe(new ItemStack(DeeperCaves.blocks.rottenPlanks, 1), new Object[]{woodType.getItem(), Blocks.dirt});
        }
        GameRegistry.addShapelessRecipe(new ItemStack(DeeperCaves.blocks.rustedBars, 1), new Object[]{Blocks.iron_bars, Items.water_bucket.setContainerItem(Items.bucket)});
        
        GameRegistry.addShapelessRecipe(new ItemStack(DeeperCaves.blocks.rustedBars, 1), new Object[]{new ItemStack(Blocks.iron_bars, 1), new ItemStack(Items.potionitem.setContainerItem(Items.glass_bottle), 1, 0)});
        
        GameRegistry.addShapelessRecipe(new ItemStack(DeeperCaves.blocks.rustedBars, 1), new Object[]{Blocks.iron_bars, Blocks.dirt});
        
    }
    public void setupSmelting()
    {
        /*Registering smelting recipes in GameRegistry*/
        GameRegistry.addSmelting(DeeperCaves.blocks.silverOre, new ItemStack(DeeperCaves.items.silverIngot, 1) , 0.6F);
        
        GameRegistry.addSmelting(DeeperCaves.blocks.tenebriumOre, new ItemStack(DeeperCaves.items.tenebriumIngot, 1) , 1.0F);
        
        //GameRegistry.addSmelting(DeeperCaves.items.tenebriumIngotRaw, new ItemStack(DeeperCaves.items.tenebriumIngot, 1) , 1.0F);
        
        GameRegistry.addSmelting(DeeperCaves.blocks.sapphireOre, new ItemStack(DeeperCaves.items.sapphireGem, 1) , 0.5F);
        GameRegistry.addSmelting(DeeperCaves.blocks.aquamarineOre, new ItemStack(DeeperCaves.items.aquamarine, 1) , 0.5F);
        GameRegistry.addSmelting(DeeperCaves.blocks.ametrineOre, new ItemStack(DeeperCaves.items.ametrineGem, 1) , 0.5F);
        
        GameRegistry.addSmelting(DeeperCaves.blocks.ccoalOre, new ItemStack(Items.coal, 2) , 0.2F);
        GameRegistry.addSmelting(DeeperCaves.blocks.cironOre, new ItemStack(Items.iron_ingot, 2) , 1.4F);
        GameRegistry.addSmelting(DeeperCaves.blocks.cgoldOre, new ItemStack(Items.gold_ingot, 2) , 2.0F);
        GameRegistry.addSmelting(DeeperCaves.blocks.clapisOre, new ItemStack(Items.dye, 2, 4) , 0.4F);
        GameRegistry.addSmelting(DeeperCaves.blocks.credstoneOre, new ItemStack(Items.redstone, 2) , 1.4F);
        GameRegistry.addSmelting(DeeperCaves.blocks.cdiamondOre, new ItemStack(Items.diamond, 2) , 2.0F);
        GameRegistry.addSmelting(DeeperCaves.blocks.cemeraldOre, new ItemStack(Items.emerald, 2) , 2.0F);
        
        GameRegistry.addSmelting(DeeperCaves.blocks.forgottenGemstoneOre, new ItemStack(DeeperCaves.items.forgottenGemstone, 1) , 2.0F);
        
        GameRegistry.addSmelting(DeeperCaves.blocks.deepCobble, new ItemStack(DeeperCaves.blocks.deepStone, 1) , 0.1F);
        
        GameRegistry.addSmelting(DeeperCaves.blocks.profundiumOre, new ItemStack(DeeperCaves.items.profundiumIngot, 1) , 1.5F);
        
        GameRegistry.addSmelting(DeeperCaves.blocks.fragmentedCobble, new ItemStack(Blocks.cobblestone, 1) , 0.1F);
        
        GameRegistry.addSmelting(DeeperCaves.blocks.evanesciteOre, new ItemStack(DeeperCaves.items.evanesciteGem, 1) , 1.5F);
        
        GameRegistry.addSmelting(DeeperCaves.blocks.vesperiteOre, new ItemStack(DeeperCaves.items.vesperiteGem, 1) , 1.5F);
        
        GameRegistry.addSmelting(DeeperCaves.blocks.dcoalOre, new ItemStack(Items.coal, 1) , 0.1F);
        GameRegistry.addSmelting(DeeperCaves.blocks.dironOre, new ItemStack(Items.iron_ingot, 1) , 0.7F);
        GameRegistry.addSmelting(DeeperCaves.blocks.dgoldOre, new ItemStack(Items.gold_ingot, 1) , 1.0F);
        GameRegistry.addSmelting(DeeperCaves.blocks.dlapisOre, new ItemStack(Items.dye, 1, 4) , 0.2F);
        GameRegistry.addSmelting(DeeperCaves.blocks.dredstoneOre, new ItemStack(Items.redstone, 1) , 0.7F);
        GameRegistry.addSmelting(DeeperCaves.blocks.ddiamondOre, new ItemStack(Items.diamond, 1) , 1.0F);
        GameRegistry.addSmelting(DeeperCaves.blocks.demeraldOre, new ItemStack(Items.emerald, 1) , 1.0F);
        
        GameRegistry.addSmelting(DeeperCaves.blocks.ddcoalOre, new ItemStack(Items.coal, 1) , 0.1F);
        GameRegistry.addSmelting(DeeperCaves.blocks.ddironOre, new ItemStack(Items.iron_ingot, 1) , 0.7F);
        GameRegistry.addSmelting(DeeperCaves.blocks.ddgoldOre, new ItemStack(Items.gold_ingot, 1) , 1.0F);
        GameRegistry.addSmelting(DeeperCaves.blocks.ddlapisOre, new ItemStack(Items.dye, 1, 4) , 0.2F);
        GameRegistry.addSmelting(DeeperCaves.blocks.ddredstoneOre, new ItemStack(Items.redstone, 1) , 0.7F);
        GameRegistry.addSmelting(DeeperCaves.blocks.dddiamondOre, new ItemStack(Items.diamond, 1) , 1.0F);
        GameRegistry.addSmelting(DeeperCaves.blocks.ddemeraldOre, new ItemStack(Items.emerald, 1) , 1.0F);
        
        GameRegistry.addSmelting(DeeperCaves.blocks.dccoalOre, new ItemStack(Items.coal, 2) , 0.2F);
        GameRegistry.addSmelting(DeeperCaves.blocks.dcironOre, new ItemStack(Items.iron_ingot, 2) , 1.4F);
        GameRegistry.addSmelting(DeeperCaves.blocks.dcgoldOre, new ItemStack(Items.gold_ingot, 2) , 2.0F);
        GameRegistry.addSmelting(DeeperCaves.blocks.dclapisOre, new ItemStack(Items.dye, 2, 4) , 0.4F);
        GameRegistry.addSmelting(DeeperCaves.blocks.dcredstoneOre, new ItemStack(Items.redstone, 2) , 1.4F);
        GameRegistry.addSmelting(DeeperCaves.blocks.dcdiamondOre, new ItemStack(Items.diamond, 2) , 2.0F);
        GameRegistry.addSmelting(DeeperCaves.blocks.dcemeraldOre, new ItemStack(Items.emerald, 2) , 2.0F);
        
        GameRegistry.addSmelting(DeeperCaves.blocks.dpcoalOre, new ItemStack(Items.coal, 1) , 0.1F);
        GameRegistry.addSmelting(DeeperCaves.blocks.dpironOre, new ItemStack(Items.iron_ingot, 1) , 0.7F);
        GameRegistry.addSmelting(DeeperCaves.blocks.dpgoldOre, new ItemStack(Items.gold_ingot, 1) , 1.0F);
        GameRegistry.addSmelting(DeeperCaves.blocks.dplapisOre, new ItemStack(Items.dye, 1, 4) , 0.2F);
        GameRegistry.addSmelting(DeeperCaves.blocks.dpredstoneOre, new ItemStack(Items.redstone, 1) , 0.7F);
        GameRegistry.addSmelting(DeeperCaves.blocks.dpdiamondOre, new ItemStack(Items.diamond, 1) , 1.0F);
        GameRegistry.addSmelting(DeeperCaves.blocks.dpemeraldOre, new ItemStack(Items.emerald, 1) , 1.0F);
        
        
    }
}

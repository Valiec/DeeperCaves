package com.kpabr.DeeperCaves;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;

public class DeeperRecipes {

    public void setupShapedCrafting()
    {
        /*Registering shaped crafting recipes in GameRegistry*/
        GameRegistry.addRecipe(new ItemStack(DeeperBlocks.silverBlock, 1), "ZZZ", "ZZZ", "ZZZ", 'Z', DeeperItems.silverIngot);
        
        GameRegistry.addRecipe(new ItemStack(DeeperBlocks.sapphireBlock, 1), "ZZZ", "ZZZ", "ZZZ", 'Z', DeeperItems.sapphireGem);
        GameRegistry.addRecipe(new ItemStack(DeeperBlocks.aquamarineBlock, 1), "ZZZ", "ZZZ", "ZZZ", 'Z', DeeperItems.aquamarine);
        GameRegistry.addRecipe(new ItemStack(DeeperBlocks.ametrineBlock, 1), "ZZZ", "ZZZ", "ZZZ", 'Z', DeeperItems.ametrineGem);
        
        GameRegistry.addRecipe(new ItemStack(DeeperItems.ametrineTippedDiamondPickaxe, 1), "XYX", 'X', DeeperItems.ametrineGem, 'Y', Items.diamond_pickaxe);
        
        GameRegistry.addRecipe(new ItemStack(DeeperItems.ametrineTippedGoldenPickaxe, 1), "XYX", 'X', DeeperItems.ametrineGem, 'Y', Items.golden_pickaxe);
        GameRegistry.addRecipe(new ItemStack(DeeperItems.ametrineTippedIronPickaxe, 1), "XYX", 'X', DeeperItems.ametrineGem, 'Y', Items.iron_pickaxe);
        GameRegistry.addRecipe(new ItemStack(DeeperItems.ametrineTippedStonePickaxe, 1), "XYX", 'X', DeeperItems.ametrineGem, 'Y', Items.stone_pickaxe);
        
        GameRegistry.addRecipe(new ItemStack(DeeperItems.ametrineTippedWoodenPickaxe, 1), "XYX", 'X', DeeperItems.ametrineGem, 'Y', Items.wooden_pickaxe);
        
        GameRegistry.addRecipe(new ItemStack(DeeperBlocks.tenebriumBlock, 1), "ZZZ", "ZZZ", "ZZZ", 'Z', DeeperItems.tenebriumIngot);
        
        GameRegistry.addRecipe(new ItemStack(DeeperItems.fragmentedBedrockBucket, 1), "Z Z", "Z", 'Z', DeeperBlocks.fragmentedBedrock);
        
        GameRegistry.addRecipe(new ItemStack(DeeperBlocks.forgottenGemstoneBlock, 1), "ZZZ", "ZZZ", "ZZZ", 'Z', DeeperItems.forgottenGemstone);
        
        GameRegistry.addRecipe(new ItemStack(DeeperBlocks.dropPortal, 1), "ZZZ", "Z Z", "ZZZ", 'Z', Blocks.obsidian);
        
        GameRegistry.addRecipe(new ItemStack(DeeperItems.voidCharm, 1), " X ", "XYX", " X ", 'X', DeeperItems.tenebriumIngot, 'Y', DeeperItems.vesperiteGem);
        
        GameRegistry.addRecipe(new ItemStack(DeeperBlocks.vesperiteBlock, 1), "ZZZ", "ZZZ", "ZZZ", 'Z', DeeperItems.vesperiteGem);
        
        GameRegistry.addRecipe(new ItemStack(DeeperBlocks.prisciumBlock, 1), "ZZZ", "ZZZ", "ZZZ", 'Z', DeeperItems.prisciumIngot);
        
        GameRegistry.addRecipe(new ItemStack(DeeperBlocks.cryingObsidian, 1), "ZZZ", "ZXZ", "ZZZ", 'X', Blocks.obsidian, 'Z', new ItemStack(Items.dye, 1, 4));
        
        if(Loader.isModLoaded("ExtraUtilities"))
        {
        	System.out.println("DeeperCaves: ExtraUtilities is installed. Changing fragmented cobblestone recipe.");
        	GameRegistry.addRecipe(new ItemStack(DeeperBlocks.fragmentedCobble, 2), "ZX", "XZ", 'X', Blocks.cobblestone, 'Z', Blocks.gravel);
        }
        else
        {
        	GameRegistry.addRecipe(new ItemStack(DeeperBlocks.fragmentedCobble, 2), "ZZ", "ZZ", 'Z', Blocks.gravel);
        }
        
        GameRegistry.addRecipe(new ItemStack(DeeperItems.forgottenCharm, 1), " X ", "XYX", " X ", 'X', DeeperItems.tenebriumIngot, 'Y', DeeperItems.evanesciteGem);
        
        GameRegistry.addRecipe(new ItemStack(DeeperBlocks.evanesciteBlock, 1), "ZZZ", "ZZZ", "ZZZ", 'Z', DeeperItems.evanesciteGem);
        for(int i = 0; i<13; i++)
        {
            GameRegistry.addRecipe(new ItemStack(DeeperBlocks.crystal, 1, i), "WW", "WW", 'W', new ItemStack(DeeperItems.crystalShard, 1, i));
        }
        
        GameRegistry.addRecipe(new ItemStack(DeeperItems.ametrineTippedSilverPickaxe, 1), "XYX", 'X', DeeperItems.ametrineGem, 'Y', DeeperItems.silverPickaxe);
        GameRegistry.addRecipe(new ItemStack(DeeperItems.ametrineTippedSilverAxe, 1), "XYX", 'X', DeeperItems.ametrineGem, 'Y', DeeperItems.silverAxe);
        GameRegistry.addRecipe(new ItemStack(DeeperItems.ametrineTippedSilverShovel, 1), "XYX", 'X', DeeperItems.ametrineGem, 'Y', DeeperItems.silverShovel);
        GameRegistry.addRecipe(new ItemStack(DeeperItems.ametrineTippedSilverSword, 1), "XYX", 'X', DeeperItems.ametrineGem, 'Y', DeeperItems.silverSword);
        GameRegistry.addRecipe(new ItemStack(DeeperItems.ametrineTippedSilverHoe, 1), "XYX", 'X', DeeperItems.ametrineGem, 'Y', DeeperItems.silverHoe);
        
        GameRegistry.addRecipe(new ItemStack(DeeperItems.silverPickaxe, 1), "XXX", " Y ", " Y ", 'X', DeeperItems.silverIngot, 'Y', Items.stick);
        GameRegistry.addRecipe(new ItemStack(DeeperItems.silverAxe, 1), "XX ", "XY ", " Y ", 'X', DeeperItems.silverIngot, 'Y', Items.stick);
        GameRegistry.addRecipe(new ItemStack(DeeperItems.silverAxe, 1), " XX", " YX", " Y ", 'X', DeeperItems.silverIngot, 'Y', Items.stick);
        GameRegistry.addRecipe(new ItemStack(DeeperItems.silverShovel, 1), " X ", " Y ", " Y ", 'X', DeeperItems.silverIngot, 'Y', Items.stick);
        GameRegistry.addRecipe(new ItemStack(DeeperItems.silverSword, 1), " X ", " X ", " Y ", 'X', DeeperItems.silverIngot, 'Y', Items.stick);
        GameRegistry.addRecipe(new ItemStack(DeeperItems.silverHoe, 1), " XX", " Y ", " Y ", 'X', DeeperItems.silverIngot, 'Y', Items.stick);
        GameRegistry.addRecipe(new ItemStack(DeeperItems.silverHoe, 1), "XX ", " Y ", " Y ", 'X', DeeperItems.silverIngot, 'Y', Items.stick);
        
        GameRegistry.addRecipe(new ItemStack(DeeperBlocks.rubyBlock, 1), "ZZZ", "ZZZ", "ZZZ", 'Z', DeeperItems.ruby);
    }
    public void setupShapelessCrafting()
    {
        /*Registering shapeless crafting recipes in GameRegistry*/
        GameRegistry.addShapelessRecipe(new ItemStack(DeeperItems.silverIngot, 9), DeeperBlocks.silverBlock);
        
        GameRegistry.addShapelessRecipe(new ItemStack(DeeperItems.sapphireGem, 9), DeeperBlocks.sapphireBlock);
        GameRegistry.addShapelessRecipe(new ItemStack(DeeperItems.aquamarine, 9), DeeperBlocks.aquamarineBlock);
        GameRegistry.addShapelessRecipe(new ItemStack(DeeperItems.ametrineGem, 9), DeeperBlocks.ametrineBlock);
        
        GameRegistry.addShapelessRecipe(new ItemStack(DeeperItems.tenebriumIngot, 9), DeeperBlocks.tenebriumBlock);
        
        GameRegistry.addShapelessRecipe(new ItemStack(DeeperItems.forgottenGemstone, 9), DeeperBlocks.forgottenGemstoneBlock);
        
        GameRegistry.addShapelessRecipe(new ItemStack(DeeperItems.vesperiteGem, 9), DeeperBlocks.vesperiteBlock);
        
        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.obsidian, 2), DeeperBlocks.cooledObsidian, DeeperBlocks.heatedObsidian);
        
        GameRegistry.addShapelessRecipe(new ItemStack(DeeperItems.prisciumDust, 2), DeeperItems.prisciumIngot);
        
        GameRegistry.addShapelessRecipe(new ItemStack(DeeperItems.prisciumIngot, 9), DeeperBlocks.prisciumBlock);
        
        GameRegistry.addShapelessRecipe(new ItemStack(DeeperItems.evanesciteGem, 9), DeeperBlocks.evanesciteBlock);
        
        GameRegistry.addShapelessRecipe(new ItemStack(DeeperItems.ruby, 9), DeeperBlocks.rubyBlock);

        //TODO: ??? isn't there a way to do this w/ oredict?
        for(ItemStack woodType : OreDictionary.getOres("plankWood"))
        {
        	GameRegistry.addShapelessRecipe(new ItemStack(DeeperBlocks.rottenPlanks, 1), woodType.getItem(), Items.water_bucket.setContainerItem(Items.bucket));
        
        	GameRegistry.addShapelessRecipe(new ItemStack(DeeperBlocks.rottenPlanks, 1), woodType.getItem(), new ItemStack(Items.potionitem.setContainerItem(Items.glass_bottle), 1, 0));
        
        	GameRegistry.addShapelessRecipe(new ItemStack(DeeperBlocks.rottenPlanks, 1), woodType.getItem(), Blocks.dirt);
        }
        GameRegistry.addShapelessRecipe(new ItemStack(DeeperBlocks.rustedBars, 1), Blocks.iron_bars, Items.water_bucket.setContainerItem(Items.bucket));
        
        GameRegistry.addShapelessRecipe(new ItemStack(DeeperBlocks.rustedBars, 1), new ItemStack(Blocks.iron_bars, 1), new ItemStack(Items.potionitem.setContainerItem(Items.glass_bottle), 1, 0));
        
        GameRegistry.addShapelessRecipe(new ItemStack(DeeperBlocks.rustedBars, 1), Blocks.iron_bars, Blocks.dirt);
        
    }
    public void setupSmelting()
    {
        /*Registering smelting recipes in GameRegistry*/
        GameRegistry.addSmelting(DeeperBlocks.silverOre, new ItemStack(DeeperItems.silverIngot, 1) , 0.6F);
        
        GameRegistry.addSmelting(DeeperBlocks.tenebriumOre, new ItemStack(DeeperItems.tenebriumIngot, 1) , 1.0F);
        
        //GameRegistry.addSmelting(DeeperItems.tenebriumIngotRaw, new ItemStack(DeeperItems.tenebriumIngot, 1) , 1.0F);
        
        GameRegistry.addSmelting(DeeperBlocks.sapphireOre, new ItemStack(DeeperItems.sapphireGem, 1) , 0.5F);
        GameRegistry.addSmelting(DeeperBlocks.aquamarineOre, new ItemStack(DeeperItems.aquamarine, 1) , 0.5F);
        GameRegistry.addSmelting(DeeperBlocks.ametrineOre, new ItemStack(DeeperItems.ametrineGem, 1) , 0.5F);
        
        GameRegistry.addSmelting(DeeperBlocks.ccoalOre, new ItemStack(Items.coal, 2) , 0.2F);
        GameRegistry.addSmelting(DeeperBlocks.cironOre, new ItemStack(Items.iron_ingot, 2) , 1.4F);
        GameRegistry.addSmelting(DeeperBlocks.cgoldOre, new ItemStack(Items.gold_ingot, 2) , 2.0F);
        GameRegistry.addSmelting(DeeperBlocks.clapisOre, new ItemStack(Items.dye, 2, 4) , 0.4F);
        GameRegistry.addSmelting(DeeperBlocks.credstoneOre, new ItemStack(Items.redstone, 2) , 1.4F);
        GameRegistry.addSmelting(DeeperBlocks.cdiamondOre, new ItemStack(Items.diamond, 2) , 2.0F);
        GameRegistry.addSmelting(DeeperBlocks.cemeraldOre, new ItemStack(Items.emerald, 2) , 2.0F);
        
        GameRegistry.addSmelting(DeeperBlocks.forgottenGemstoneOre, new ItemStack(DeeperItems.forgottenGemstone, 1) , 2.0F);
        
        GameRegistry.addSmelting(DeeperBlocks.deepCobble, new ItemStack(DeeperBlocks.deepStone, 1) , 0.1F);
        
        GameRegistry.addSmelting(DeeperBlocks.prisciumOre, new ItemStack(DeeperItems.prisciumIngot, 1) , 1.5F);
        
        GameRegistry.addSmelting(DeeperBlocks.fragmentedCobble, new ItemStack(Blocks.cobblestone, 1) , 0.1F);
        
        GameRegistry.addSmelting(DeeperBlocks.evanesciteOre, new ItemStack(DeeperItems.evanesciteGem, 1) , 1.5F);
        
        GameRegistry.addSmelting(DeeperBlocks.vesperiteOre, new ItemStack(DeeperItems.vesperiteGem, 1) , 1.5F);
        
        GameRegistry.addSmelting(DeeperBlocks.dcoalOre, new ItemStack(Items.coal, 1) , 0.1F);
        GameRegistry.addSmelting(DeeperBlocks.dironOre, new ItemStack(Items.iron_ingot, 1) , 0.7F);
        GameRegistry.addSmelting(DeeperBlocks.dgoldOre, new ItemStack(Items.gold_ingot, 1) , 1.0F);
        GameRegistry.addSmelting(DeeperBlocks.dlapisOre, new ItemStack(Items.dye, 1, 4) , 0.2F);
        GameRegistry.addSmelting(DeeperBlocks.dredstoneOre, new ItemStack(Items.redstone, 1) , 0.7F);
        GameRegistry.addSmelting(DeeperBlocks.ddiamondOre, new ItemStack(Items.diamond, 1) , 1.0F);
        GameRegistry.addSmelting(DeeperBlocks.demeraldOre, new ItemStack(Items.emerald, 1) , 1.0F);
        
        GameRegistry.addSmelting(DeeperBlocks.ddcoalOre, new ItemStack(Items.coal, 1) , 0.1F);
        GameRegistry.addSmelting(DeeperBlocks.ddironOre, new ItemStack(Items.iron_ingot, 1) , 0.7F);
        GameRegistry.addSmelting(DeeperBlocks.ddgoldOre, new ItemStack(Items.gold_ingot, 1) , 1.0F);
        GameRegistry.addSmelting(DeeperBlocks.ddlapisOre, new ItemStack(Items.dye, 1, 4) , 0.2F);
        GameRegistry.addSmelting(DeeperBlocks.ddredstoneOre, new ItemStack(Items.redstone, 1) , 0.7F);
        GameRegistry.addSmelting(DeeperBlocks.dddiamondOre, new ItemStack(Items.diamond, 1) , 1.0F);
        GameRegistry.addSmelting(DeeperBlocks.ddemeraldOre, new ItemStack(Items.emerald, 1) , 1.0F);
        
        GameRegistry.addSmelting(DeeperBlocks.dccoalOre, new ItemStack(Items.coal, 2) , 0.2F);
        GameRegistry.addSmelting(DeeperBlocks.dcironOre, new ItemStack(Items.iron_ingot, 2) , 1.4F);
        GameRegistry.addSmelting(DeeperBlocks.dcgoldOre, new ItemStack(Items.gold_ingot, 2) , 2.0F);
        GameRegistry.addSmelting(DeeperBlocks.dclapisOre, new ItemStack(Items.dye, 2, 4) , 0.4F);
        GameRegistry.addSmelting(DeeperBlocks.dcredstoneOre, new ItemStack(Items.redstone, 2) , 1.4F);
        GameRegistry.addSmelting(DeeperBlocks.dcdiamondOre, new ItemStack(Items.diamond, 2) , 2.0F);
        GameRegistry.addSmelting(DeeperBlocks.dcemeraldOre, new ItemStack(Items.emerald, 2) , 2.0F);
        
        GameRegistry.addSmelting(DeeperBlocks.dpcoalOre, new ItemStack(Items.coal, 1) , 0.1F);
        GameRegistry.addSmelting(DeeperBlocks.dpironOre, new ItemStack(Items.iron_ingot, 1) , 0.7F);
        GameRegistry.addSmelting(DeeperBlocks.dpgoldOre, new ItemStack(Items.gold_ingot, 1) , 1.0F);
        GameRegistry.addSmelting(DeeperBlocks.dplapisOre, new ItemStack(Items.dye, 1, 4) , 0.2F);
        GameRegistry.addSmelting(DeeperBlocks.dpredstoneOre, new ItemStack(Items.redstone, 1) , 0.7F);
        GameRegistry.addSmelting(DeeperBlocks.dpdiamondOre, new ItemStack(Items.diamond, 1) , 1.0F);
        GameRegistry.addSmelting(DeeperBlocks.dpemeraldOre, new ItemStack(Items.emerald, 1) , 1.0F);
        
        
    }
}

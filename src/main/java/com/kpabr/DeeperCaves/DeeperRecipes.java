package com.kpabr.DeeperCaves;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
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
        
    }
    public void setupSmelting()
    {
        /*Registering smelting recipes in GameRegistry*/
        GameRegistry.addSmelting(DeeperCaves.blocks.silverOre, new ItemStack(DeeperCaves.items.silverIngot, 1) , 0.6F);
        
        GameRegistry.addSmelting(DeeperCaves.blocks.tenebriumOre, new ItemStack(DeeperCaves.items.tenebriumIngot, 1) , 1.0F);
        
        GameRegistry.addSmelting(DeeperCaves.blocks.sapphireOre, new ItemStack(DeeperCaves.items.sapphireGem, 1) , 0.5F);
        GameRegistry.addSmelting(DeeperCaves.blocks.aquamarineOre, new ItemStack(DeeperCaves.items.aquamarine, 1) , 0.5F);
        GameRegistry.addSmelting(DeeperCaves.blocks.ametrineOre, new ItemStack(DeeperCaves.items.ametrineGem, 1) , 0.5F);
        
        GameRegistry.addSmelting(DeeperCaves.blocks.ccoalOre, new ItemStack(Items.coal, 2) , 0.5F);
        GameRegistry.addSmelting(DeeperCaves.blocks.cironOre, new ItemStack(Items.iron_ingot, 2) , 0.5F);
        GameRegistry.addSmelting(DeeperCaves.blocks.cgoldOre, new ItemStack(Items.gold_ingot, 2) , 0.5F);
        GameRegistry.addSmelting(DeeperCaves.blocks.clapisOre, new ItemStack(Items.dye, 2, 4) , 0.5F);
        GameRegistry.addSmelting(DeeperCaves.blocks.credstoneOre, new ItemStack(Items.redstone, 2) , 0.5F);
        GameRegistry.addSmelting(DeeperCaves.blocks.cdiamondOre, new ItemStack(Items.diamond, 2) , 0.5F);
        GameRegistry.addSmelting(DeeperCaves.blocks.cemeraldOre, new ItemStack(Items.emerald, 2) , 0.5F);
        
        GameRegistry.addSmelting(DeeperCaves.blocks.forgottenGemstoneOre, new ItemStack(DeeperCaves.items.forgottenGemstone, 1) , 2.0F);
        
        GameRegistry.addSmelting(DeeperCaves.blocks.deepCobble, new ItemStack(DeeperCaves.blocks.deepStone, 1) , 0.1F);
        
        GameRegistry.addSmelting(DeeperCaves.blocks.profundiumOre, new ItemStack(DeeperCaves.items.profundiumIngot, 1) , 1.5F);
        
    }
}

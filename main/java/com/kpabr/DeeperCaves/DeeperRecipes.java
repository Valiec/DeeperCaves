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
        
        
    }
    public void setupShapelessCrafting()
    {
        /*Registering shapeless crafting recipes in GameRegistry*/
        GameRegistry.addShapelessRecipe(new ItemStack(DeeperCaves.items.silverIngot, 9), new Object[]{DeeperCaves.blocks.silverBlock});
        
        GameRegistry.addShapelessRecipe(new ItemStack(DeeperCaves.items.sapphireGem, 9), new Object[]{DeeperCaves.blocks.sapphireBlock});
        GameRegistry.addShapelessRecipe(new ItemStack(DeeperCaves.items.aquamarine, 9), new Object[]{DeeperCaves.blocks.aquamarineBlock});
        GameRegistry.addShapelessRecipe(new ItemStack(DeeperCaves.items.ametrineGem, 9), new Object[]{DeeperCaves.blocks.ametrineBlock});
        
    }
    public void setupSmelting()
    {
        /*Registering smelting recipes in GameRegistry*/
        GameRegistry.addSmelting(DeeperCaves.blocks.silverOre, new ItemStack(DeeperCaves.items.silverIngot, 1) , 0.6F);
        
        
    }
}

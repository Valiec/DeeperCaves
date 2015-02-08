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
        //GameRegistry.addRecipe(new ItemStack(DeeperCaves.items.swordEnderite, 1), new Object[]{" X ", " X ", " W ", 'W', Items.stick, 'X', DeeperCaves.items.enderiteGem});
        
        
    }
    public void setupShapelessCrafting()
    {
        /*Registering shapeless crafting recipes in GameRegistry*/
        //GameRegistry.addShapelessRecipe(new ItemStack(Items.skull, 3), new Object[]{Blocks.soul_sand, DeeperCaves.items.umbriteCrystal, Items.arrow});
        
    }
    public void setupSmelting()
    {
        /*Registering smelting recipes in GameRegistry*/
        GameRegistry.addSmelting(DeeperCaves.blocks.silverOre, new ItemStack(DeeperCaves.items.silverIngot, 1) , 0.6F);
        
        
    }
}

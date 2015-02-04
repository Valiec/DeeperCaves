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
    public void addEgg(Item mobItem, int id)
    {
        /*Registering shapeless spawn egg crafting recipes in GameRegistry*/
        //GameRegistry.addShapelessRecipe(new ItemStack(Items.spawn_egg, 4, id), new Object[]{mobItem, DeeperCaves.items.umbriteCrystal});
    }
    public void addEgg(Block mobBlock, int id)
    {
        /*Registering shapeless spawn egg crafting recipes in GameRegistry*/
        //GameRegistry.addShapelessRecipe(new ItemStack(Items.spawn_egg, 4, id), new Object[]{mobBlock, DeeperCaves.items.umbriteCrystal});
    }
    public void setupEggs()
    {
        /*Registering shapeless crafting recipes for spawn eggs in GameRegistry by calling addEgg*/
        /*addEgg(Items.blaze_rod, 61);
        addEgg(Items.spider_eye, 59);
        addEgg(Items.gunpowder, 50);
        addEgg(Items.ender_pearl, 58);
        addEgg(Items.ghast_tear, 56); 
        addEgg(Items.magma_cream, 62);
        addEgg(Blocks.stone, 60);
        addEgg(Items.arrow, 51); //Work In Progress (skeleton/wither skeleton egg)
        addEgg(Items.slime_ball, 55);
        addEgg(Items.string, 52);
        addEgg(Items.glowstone_dust, 66);
        addEgg(Items.rotten_flesh, 54);
        addEgg(Items.gold_nugget, 57);
        addEgg(Blocks.cobblestone, 65);
        addEgg(Items.chicken, 93);
        addEgg(Items.beef, 92);
        addEgg(Items.leather, 100);
        addEgg(Blocks.red_mushroom, 96);
        addEgg(Items.fish, 98);
        addEgg(Items.porkchop, 90);
        addEgg(Blocks.wool, 91);
        addEgg(Items.dye, 94);
        addEgg(Items.bone, 95);
        addEgg(Items.emerald, 120);
        addEgg(DeeperCaves.items.enderiteGem, 80);*/
    }
    public void setupSmelting()
    {
        /*Registering smelting recipes in GameRegistry*/
        GameRegistry.addSmelting(DeeperCaves.blocks.silverOre, new ItemStack(DeeperCaves.items.silverIngot, 1) , 0.6F);
        /*GameRegistry.addSmelting(DeeperCaves.blocks.enderiteOre, new ItemStack(DeeperCaves.items.enderiteGem, 1) , 0.6F);
        GameRegistry.addSmelting(DeeperCaves.blocks.umbriteOre, new ItemStack(DeeperCaves.items.umbriteCrystal, 1) , 0.6F);
        GameRegistry.addSmelting(DeeperCaves.blocks.luciteOre, new ItemStack(DeeperCaves.items.luciteCrystal, 1) , 0.6F);
        GameRegistry.addSmelting(DeeperCaves.blocks.golderaldOre, new ItemStack(DeeperCaves.items.golderaldGem, 1) , 0.6F);
        GameRegistry.addSmelting(DeeperCaves.items.enderWart, new ItemStack(DeeperCaves.items.enderWartCooked, 1) , 0.2F);
        GameRegistry.addSmelting(DeeperCaves.blocks.endLog, new ItemStack(Items.coal, 1, 1) , 0.15F);*/
        
        
    }
}

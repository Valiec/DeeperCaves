package com.kpabr.DeeperCaves;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionHealth;

public class DeeperEventHandler {

    public static boolean isPlayerInBlock(EntityPlayer player, Block block)
    {
        //System.out.println("==============");
        //System.out.println("CHECK: "+(int)player.posX+", "+(int)player.posY+", "+((int)(player.posZ)-1));
        Block block1 = player.worldObj.getBlock((int)player.posX, (int)player.posY, (int)player.posZ-1);
        //System.out.println("BLOCK1: "+block1.getUnlocalizedName());
        if(block1 == block)
        {
            //System.out.println("==============");
            return true;
        }
        Block block2 = player.worldObj.getBlock((int)player.posX, (int)player.posY+1, (int)player.posZ-1);
        //System.out.println("BLOCK2: "+block2.getUnlocalizedName());
        if(block2 == block)
        {
            //System.out.println("==============");
            return true;
        }
        //System.out.println("==============");
        return false;
    }

    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if(isPlayerInBlock(event.player, DeeperFluids.veneniumBlock))
        {
            event.player.addPotionEffect(new PotionEffect(Potion.poison.id, 100, 1));
        }
    }
}

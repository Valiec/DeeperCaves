package com.kpabr.DeeperCaves;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;

public class DeeperEventHandler {

    public static boolean isPlayerInBlock(EntityLivingBase player, Block block)
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
        //System.out.println("==============");
        return block2 == block;
        //System.out.println("==============");
    }

    //@SubscribeEvent
    //public void onLivingUpdate(LivingEvent event) {
        //if(event.entityLiving != null) {
            //if (isPlayerInBlock(event.entityLiving, DeeperFluids.veneniumBlock)) {
            //    event.entityLiving.addPotionEffect(new PotionEffect(Potion.poison.id, 100, 1));
            //}
        //}
   // }
}

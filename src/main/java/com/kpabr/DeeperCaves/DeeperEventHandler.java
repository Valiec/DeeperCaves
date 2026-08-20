package com.kpabr.DeeperCaves;

import com.kpabr.DeeperCaves.world.DeeperLayer;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.DamageSource;

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

    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent event) {
        try
        {
            EntityPlayerMP player = (EntityPlayerMP)event.player;
            boolean voidFlag = ((DeeperCaves.instance.voidFlag.get(player.getUniqueID()) != null) ? DeeperCaves.instance.voidFlag.get(player.getUniqueID()) : false);
            boolean deepFlag = ((DeeperCaves.instance.deepFlag.get(player.getUniqueID()) != null) ? DeeperCaves.instance.deepFlag.get(player.getUniqueID()) : false);

            int nearvoid_counter = ((DeeperCaves.instance.nearvoid_counter.get(player.getUniqueID()) != null) ? DeeperCaves.instance.nearvoid_counter.get(player.getUniqueID()) : 0);
            int farvoid_counter = ((DeeperCaves.instance.farvoid_counter.get(player.getUniqueID()) != null) ? DeeperCaves.instance.farvoid_counter.get(player.getUniqueID()) : 0);
            int deep_counter = ((DeeperCaves.instance.deep_counter.get(player.getUniqueID()) != null) ? DeeperCaves.instance.deep_counter.get(player.getUniqueID()) : 0);
            if(event.player.posY <= 240.0D && player.dimension == DeeperCaves.worldgen.nearVoid.dimID)
            {
                if(!voidFlag)
                {
                    if(nearvoid_counter == 200)
                    {
                        player.attackEntityFrom(DamageSource.outOfWorld, 0.5F);
                        nearvoid_counter = 0;
                        DeeperCaves.instance.nearvoid_counter.put(player.getUniqueID(), nearvoid_counter);
                    }
                    else
                    {
                        nearvoid_counter++;
                        DeeperCaves.instance.nearvoid_counter.put(player.getUniqueID(), nearvoid_counter);
                    }

                }
                else if(nearvoid_counter == 0)
                {
                    DeeperCaves.instance.nearvoid_counter.put(player.getUniqueID(), nearvoid_counter);
                    DeeperCaves.instance.voidFlag.put(player.getUniqueID(), false);
                }
                else if(nearvoid_counter == 200)
                {
                    nearvoid_counter = 0;
                    DeeperCaves.instance.nearvoid_counter.put(player.getUniqueID(), nearvoid_counter);
                }
                else
                {
                    nearvoid_counter++;
                    DeeperCaves.instance.nearvoid_counter.put(player.getUniqueID(), nearvoid_counter);
                }
            }
            if(event.player.posY <= 240.0D && player.dimension == DeeperCaves.worldgen.farVoid.dimID)
            {
                if(!voidFlag)
                {
                    if(farvoid_counter == 9)
                    {
                        player.attackEntityFrom(DamageSource.outOfWorld, 4.0F);
                        farvoid_counter = 0;
                        DeeperCaves.instance.farvoid_counter.put(player.getUniqueID(), farvoid_counter);
                    }
                    else
                    {
                        farvoid_counter++;
                        DeeperCaves.instance.farvoid_counter.put(player.getUniqueID(), farvoid_counter);
                    }

                }
                else if(farvoid_counter == 0)
                {
                    DeeperCaves.instance.voidFlag.put(player.getUniqueID(), false);

                    farvoid_counter++;
                    DeeperCaves.instance.farvoid_counter.put(player.getUniqueID(), farvoid_counter);
                }
                else if(farvoid_counter == 9)
                {
                    farvoid_counter = 0;
                    DeeperCaves.instance.farvoid_counter.put(player.getUniqueID(), farvoid_counter);
                }
                else
                {
                    farvoid_counter++;
                    DeeperCaves.instance.farvoid_counter.put(player.getUniqueID(), farvoid_counter);
                }
            }
            if(player.dimension == DeeperCaves.worldgen.forgotten.dimID)
            {
                if(deep_counter == 0 && deepFlag)
                {
                    DeeperCaves.instance.deepFlag.put(player.getUniqueID(), false);

                    deep_counter++;
                    DeeperCaves.instance.deep_counter.put(player.getUniqueID(), deep_counter);
                }
                else if(deep_counter >= 1 && deepFlag)
                {
                    deep_counter = 0;
                    DeeperCaves.instance.deep_counter.put(player.getUniqueID(), deep_counter);
                }
                else
                {
                    deep_counter++;
                    DeeperCaves.instance.deep_counter.put(player.getUniqueID(), deep_counter);
                }
            }
        }
        catch(ClassCastException e)
        {
            //not a player
        }

    }
}

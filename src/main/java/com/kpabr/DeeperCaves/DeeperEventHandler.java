package com.kpabr.DeeperCaves;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.event.entity.PlaySoundAtEntityEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.world.BlockEvent;

public class DeeperEventHandler {

    @SubscribeEvent
    public void onVibration(VibrationEvent event) {
        int x = (int) event.x;
        int y = (int) event.y;
        int z = (int) event.z;

        int isq;
        int jsq;
        int ksq;

        for(int i = -8; i <= 8; ++i) {
            isq = i * i;
            for(int j = -8; j <= 8; ++j) {
                jsq = j * j;
                for(int k = -8; k <= 8; ++k) {
                    ksq = k * k;
                    if(isq+jsq+ksq <= 8*8) {
                        Block block = event.world.getBlock(x+i, y+j, z+k);
                        if(block == DeeperBlocks.sculkSensor) {
                            System.out.println("Sculk found!!!!!!!");
                        }
                    }
                }
            }
        }
    }

    @SubscribeEvent
    public void onPlaySound(PlaySoundAtEntityEvent event) {
        if(!event.entity.worldObj.isRemote) {
            double entityX = event.entity.posX;
            double entityY = event.entity.posY;
            double entityZ = event.entity.posZ;

            //System.out.println(event.name);

            if(!event.entity.isSneaking()) {
                FMLCommonHandler.instance().bus().post(new VibrationEvent(VibrationEvent.VibrationEventType.ENTITY_SOUND, entityX, entityY, entityZ, event.entity, event.entity.worldObj));
            }
        }
    }

    @SubscribeEvent
    public void onBlockBreak(BlockEvent.BreakEvent event) {
        if(event.block != Blocks.wool && event.block != Blocks.carpet) {
            FMLCommonHandler.instance().bus().post(new VibrationEvent(VibrationEvent.VibrationEventType.BLOCK_BREAK, event.x, event.y, event.z, event.getPlayer(), event.world));
        }
    }

    @SubscribeEvent
    public void onBlockPlace(BlockEvent.PlaceEvent event) {
        if(event.block != Blocks.wool && event.block != Blocks.carpet) {
            FMLCommonHandler.instance().bus().post(new VibrationEvent(VibrationEvent.VibrationEventType.BLOCK_PLACE, event.x, event.y, event.z, event.player, event.world));
        }
    }


    @SubscribeEvent
    public void onEntityConstructing(EntityEvent.EntityConstructing event) {
        if(event.entity instanceof EntityPlayer && (event.entity).getExtendedProperties(DeeperCavesExtendedPlayerData.NAME) == null) {
            EntityPlayer player = (EntityPlayer)event.entity;
            player.registerExtendedProperties(DeeperCavesExtendedPlayerData.NAME, new DeeperCavesExtendedPlayerData(player));
        }
    }

    @SubscribeEvent
    public void onPlayerClone(PlayerEvent.Clone event) {
        event.entity.registerExtendedProperties(DeeperCavesExtendedPlayerData.NAME, event.original.getExtendedProperties(DeeperCavesExtendedPlayerData.NAME));
    }

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
            //boolean voidFlag = ((DeeperCaves.instance.voidFlag.get(player.getUniqueID()) != null) ? DeeperCaves.instance.voidFlag.get(player.getUniqueID()) : false);
            //boolean deepFlag = ((DeeperCaves.instance.deepFlag.get(player.getUniqueID()) != null) ? DeeperCaves.instance.deepFlag.get(player.getUniqueID()) : false);

            DeeperCavesExtendedPlayerData extData = (DeeperCavesExtendedPlayerData) player.getExtendedProperties(DeeperCavesExtendedPlayerData.NAME);

            if (extData != null) {

                boolean voidFlag = extData.voidCharm();
                boolean deepFlag = extData.forgottenCharm();

                int voidCounter = extData.voidCounter();
                int deepCounter = extData.deepCounter();

                if (event.player.posY <= 240.0D && player.dimension == DeeperCaves.worldgen.nearVoid.dimID) {
                    if (!voidFlag) {
                        if (voidCounter == 200) {
                            player.attackEntityFrom(DamageSource.outOfWorld, 0.5F);
                            voidCounter = 0;
                            extData.setVoidCounter(voidCounter);
                        } else {
                            voidCounter++;
                            extData.setVoidCounter(voidCounter);
                        }

                    } else if (voidCounter == 0) {
                        extData.setVoidCounter(voidCounter);
                        extData.unsetVoidCharm();
                    } else if (voidCounter == 200) {
                        voidCounter = 0;
                        extData.setVoidCounter(voidCounter);
                    } else {
                        voidCounter++;
                        extData.setVoidCounter(voidCounter);
                    }
                }
                if (event.player.posY <= 240.0D && player.dimension == DeeperCaves.worldgen.farVoid.dimID) {
                    if (!voidFlag) {
                        if (voidCounter >= 9) {
                            player.attackEntityFrom(DamageSource.outOfWorld, 4.0F);
                            voidCounter = 0;
                            extData.setVoidCounter(voidCounter);
                        } else {
                            voidCounter++;
                            extData.setVoidCounter(voidCounter);
                        }

                    } else if (voidCounter == 0) {

                        extData.unsetVoidCharm();
                        voidCounter++;
                        extData.setVoidCounter(voidCounter);
                    } else if (voidCounter >= 9) {
                        voidCounter = 0;
                        extData.setVoidCounter(voidCounter);
                    } else {
                        voidCounter++;
                        extData.setVoidCounter(voidCounter);
                    }
                }
                if (player.dimension == DeeperCaves.worldgen.forgotten.dimID) {
                    if (deepCounter == 0 && deepFlag) {
                        extData.unsetForgottenCharm();
                        deepCounter++;
                        extData.setDeepCounter(deepCounter);
                    } else if (deepCounter >= 1 && deepFlag) {
                        deepCounter = 0;
                        extData.setDeepCounter(deepCounter);
                    } else {
                        deepCounter++;
                        extData.setDeepCounter(deepCounter);
                    }
                }
            }
        }
        catch(ClassCastException e)
        {
            //not a player
        }

    }
}

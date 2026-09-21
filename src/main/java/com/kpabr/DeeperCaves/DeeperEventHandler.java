package com.kpabr.DeeperCaves;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;

public class DeeperEventHandler {

    @SubscribeEvent
    public void onVibrationBefore(VibrationEvent.Before event) {
        if(event.hasEntity && event.entity instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer)event.entity;
            DeeperCavesExtendedPlayerData extData = (DeeperCavesExtendedPlayerData) player.getExtendedProperties(DeeperCavesExtendedPlayerData.NAME);
            if(extData != null && extData.echoCharm()) {
                event.setCanceled(true);
            }
            else {
            }
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

    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent event) {
        try
        {
            EntityPlayerMP player = (EntityPlayerMP)event.player;

            DeeperCavesExtendedPlayerData extData = (DeeperCavesExtendedPlayerData) player.getExtendedProperties(DeeperCavesExtendedPlayerData.NAME);

            if (extData != null) {
                if(player.inventory.hasItemStack(new ItemStack(DeeperItems.voidCharm))) {
                    extData.setVoidCharm();
                }
                else {
                    extData.unsetVoidCharm();
                }

                if(player.inventory.hasItemStack(new ItemStack(DeeperItems.forgottenCharm))) {
                    extData.setForgottenCharm();
                }
                else {
                    extData.unsetForgottenCharm();
                }

                if(player.inventory.hasItemStack(new ItemStack(DeeperItems.echoCharm))) {
                    extData.setEchoCharm();
                }
                else {
                    extData.unsetEchoCharm();
                }

                if(player.inventory.hasItemStack(new ItemStack(DeeperItems.unblemishedCharm))) {
                    extData.setUnblemishedCharm();
                }
                else {
                    extData.unsetUnblemishedCharm();
                }

                boolean voidFlag = extData.voidCharm();
                boolean deepFlag = extData.forgottenCharm();
                boolean unblemishedFlag = extData.unblemishedCharm();
                boolean echoFlag = extData.echoCharm();

                int voidCounter = extData.voidCounter();

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

                    } else if (voidCounter >= 9) {
                        voidCounter = 0;
                        extData.setVoidCounter(voidCounter);
                    } else {
                        voidCounter++;
                        extData.setVoidCounter(voidCounter);
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

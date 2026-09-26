package com.kpabr.DeeperCaves;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
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

                extData.setVoidCharm(player.inventory.hasItemStack(new ItemStack(DeeperItems.voidCharm)));
                extData.setForgottenCharm(player.inventory.hasItemStack(new ItemStack(DeeperItems.forgottenCharm)));
                extData.setEchoCharm(player.inventory.hasItemStack(new ItemStack(DeeperItems.echoCharm)));
                extData.setUnblemishedCharm(player.inventory.hasItemStack(new ItemStack(DeeperItems.unblemishedCharm)));
                extData.setFeatherCharm(player.inventory.hasItemStack(new ItemStack(DeeperItems.featherCharm)));
                extData.setAmetrineCharm(player.inventory.hasItemStack(new ItemStack(DeeperItems.ametrineCharm)));
                extData.setCavernCharm(player.inventory.hasItemStack(new ItemStack(DeeperItems.cavernCharm)));
                extData.setWaterCharm(player.inventory.hasItemStack(new ItemStack(DeeperItems.waterCharm)));


                boolean voidFlag = extData.voidCharm();
                boolean cavernFlag = extData.cavernCharm();
                //boolean deepFlag = extData.forgottenCharm();
                //boolean unblemishedFlag = extData.unblemishedCharm();
                //boolean echoFlag = extData.echoCharm();

                if (event.player.posY <= 240.0D && player.dimension == DeeperCaves.worldgen.nearVoid.dimID) {
                    if (!voidFlag) {
                        if (event.player.ticksExisted % 200 == 0 && !event.player.capabilities.disableDamage) {
                            player.attackEntityFrom(DamageSource.outOfWorld, 0.5F);
                        }
                    }
                }

                if (event.player.posY <= 240.0D && player.dimension == DeeperCaves.worldgen.farVoid.dimID) {
                    if (!voidFlag) {
                        if(event.player.ticksExisted % 8 == 0 && !event.player.capabilities.disableDamage) {
                            player.attackEntityFrom(DamageSource.outOfWorld, 4.0F);
                        }

                    }
                }

                if(event.player.ticksExisted % 20 == 0 && cavernFlag) {
                    player.addPotionEffect(new PotionEffect(Potion.nightVision.id, 300, 0, true));
                }
            }
        }
        catch(ClassCastException e)
        {
            //not a player
        }

    }
}

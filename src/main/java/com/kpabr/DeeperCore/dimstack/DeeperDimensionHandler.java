package com.kpabr.DeeperCore.dimstack;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;

public class DeeperDimensionHandler {

	@SubscribeEvent
	public void onEntityConstructing(EntityEvent.EntityConstructing event) {
		if(event.entity instanceof EntityPlayer && (event.entity).getExtendedProperties(DeeperCoreExtendedPlayerData.NAME) == null) {
			EntityPlayer player = (EntityPlayer)event.entity;
			player.registerExtendedProperties(DeeperCoreExtendedPlayerData.NAME, new DeeperCoreExtendedPlayerData(player));
		}
	}

	@SubscribeEvent
	public void onPlayerClone(PlayerEvent.Clone event) {
		event.entity.registerExtendedProperties(DeeperCoreExtendedPlayerData.NAME, event.original.getExtendedProperties(DeeperCoreExtendedPlayerData.NAME));
	}

	@SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent event) {
    		try
        	{
				EntityPlayerMP player = (EntityPlayerMP)event.player;

				DeeperCoreExtendedPlayerData data = ((DeeperCoreExtendedPlayerData) event.player.getExtendedProperties(DeeperCoreExtendedPlayerData.NAME));

				if(data == null || data.tpEnabled) {
					for (DeeperLayer layer : DeeperLayer.deeperLayers) {
						if (player.dimension == layer.dimID && event.player.posY <= layer.tpTriggerLower && layer.nextLayer != null && (layer.canExitFrom == null || layer.canExitFrom.test(player, false))) {
							player.mcServer.getConfigurationManager().transferPlayerToDimension(player, layer.nextLayer.dimID, new DeeperTeleporter(player.mcServer.worldServerForDimension(layer.nextLayer.dimID), false));
							break;
						}
						if (player.dimension == layer.dimID && event.player.posY >= layer.tpTriggerUpper && layer.prevLayer != null && (layer.canExitFrom == null || layer.canExitFrom.test(player, true))) {
							player.mcServer.getConfigurationManager().transferPlayerToDimension(player, layer.prevLayer.dimID, new DeeperTeleporter(player.mcServer.worldServerForDimension(layer.prevLayer.dimID), true));
							break;
						}
					}
				}
        	}
        	catch(ClassCastException e)
        	{
        		return; //not a player
        	}
    }
}

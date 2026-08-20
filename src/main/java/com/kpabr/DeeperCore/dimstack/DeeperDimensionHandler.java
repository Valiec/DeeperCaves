package com.kpabr.DeeperCore.dimstack;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import net.minecraft.entity.player.EntityPlayerMP;

public class DeeperDimensionHandler {

	@SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent event) {
    		try
        	{
				EntityPlayerMP player = (EntityPlayerMP)event.player;

				for(DeeperLayer layer: DeeperLayer.deeperLayers) {
					if(player.dimension == layer.dimID && event.player.posY <= layer.tpTriggerLower && layer.nextLayer != null && (layer.canExitFrom == null || layer.canExitFrom.test(player, false))) {
						player.mcServer.getConfigurationManager().transferPlayerToDimension(player, layer.nextLayer.dimID, new DeeperTeleporter(player.mcServer.worldServerForDimension(layer.nextLayer.dimID), false));
						break;
					}
				}
        	}
        	catch(ClassCastException e)
        	{
        		return; //not a player
        	}
    		try
        	{
	        	EntityPlayerMP player = (EntityPlayerMP)event.player;

				for(DeeperLayer layer: DeeperLayer.deeperLayers) {
					if(player.dimension == layer.dimID && event.player.posY >= layer.tpTriggerUpper && layer.prevLayer != null && (layer.canExitFrom == null || layer.canExitFrom.test(player, true))) {
						player.mcServer.getConfigurationManager().transferPlayerToDimension(player, layer.prevLayer.dimID, new DeeperTeleporter(player.mcServer.worldServerForDimension(layer.prevLayer.dimID), true));
						break;
					}
				}
        	}
        	catch(ClassCastException e)
        	{
        		//do nothing, not a player
        	}
    }
}

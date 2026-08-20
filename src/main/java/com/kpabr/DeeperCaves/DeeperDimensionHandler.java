package com.kpabr.DeeperCaves;

import com.kpabr.DeeperCaves.world.DeeperLayer;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.DamageSource;

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

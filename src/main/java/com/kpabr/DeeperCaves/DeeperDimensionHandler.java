package com.kpabr.DeeperCaves;

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
	        	if(player.dimension == 0 && event.player.posY <= 0.0D) //0 = overworld
	        	{
	        		player.mcServer.getConfigurationManager().transferPlayerToDimension(player, DeeperCaves.worldgen.dropDimID, new DeeperTeleporter(player.mcServer.worldServerForDimension(DeeperCaves.worldgen.dropDimID)));
	        	}
	        	else if(player.dimension>=DeeperCaves.worldgen.dropDimID && event.player.posY <= 0.0D)
	        	{
	        		player.mcServer.getConfigurationManager().transferPlayerToDimension(player, DeeperCaves.worldgen.mazeDimID, new DeeperTeleporter(player.mcServer.worldServerForDimension(DeeperCaves.worldgen.mazeDimID)));
	        	}
	        	else if(player.dimension>=DeeperCaves.worldgen.mazeDimID && event.player.posY <= 0.0D)
	        	{
	        		player.mcServer.getConfigurationManager().transferPlayerToDimension(player, DeeperCaves.worldgen.crystalDimID, new DeeperTeleporter(player.mcServer.worldServerForDimension(DeeperCaves.worldgen.crystalDimID)));
	        	}
	        	else if(player.dimension>=DeeperCaves.worldgen.crystalDimID && event.player.posY <= 0.0D)
	        	{
	        		player.mcServer.getConfigurationManager().transferPlayerToDimension(player, DeeperCaves.worldgen.compressedDimID, new DeeperTeleporter(player.mcServer.worldServerForDimension(DeeperCaves.worldgen.compressedDimID)));
	        	}
	        	else if(player.dimension>=DeeperCaves.worldgen.compressedDimID && event.player.posY <= 0.0D)
	        	{
	        		player.mcServer.getConfigurationManager().transferPlayerToDimension(player, DeeperCaves.worldgen.bedrockPlainsDimID, new DeeperTeleporter(player.mcServer.worldServerForDimension(DeeperCaves.worldgen.bedrockPlainsDimID)));
	        	}
	        	else if(player.dimension>=DeeperCaves.worldgen.bedrockPlainsDimID && event.player.posY <= 0.0D)
	        	{
	        		player.mcServer.getConfigurationManager().transferPlayerToDimension(player, DeeperCaves.worldgen.nearNetherDimID, new DeeperTeleporter(player.mcServer.worldServerForDimension(DeeperCaves.worldgen.nearNetherDimID)));
	        	}
	        	else if(player.dimension>=DeeperCaves.worldgen.nearNetherDimID && event.player.posY <= 0.0D)
	        	{
	        		player.mcServer.getConfigurationManager().transferPlayerToDimension(player, DeeperCaves.worldgen.lavaDimID, new DeeperTeleporter(player.mcServer.worldServerForDimension(DeeperCaves.worldgen.lavaDimID)));
	        	}
	        	else if(player.dimension>=DeeperCaves.worldgen.lavaDimID && event.player.posY <= 0.0D)
	        	{
	        		player.mcServer.getConfigurationManager().transferPlayerToDimension(player, DeeperCaves.worldgen.nearVoidDimID, new DeeperTeleporter(player.mcServer.worldServerForDimension(DeeperCaves.worldgen.nearVoidDimID)));
	        	}
	        	else if(player.dimension == DeeperCaves.worldgen.nearVoidDimID && event.player.posY <= 120.0D)
	        	{
	        		player.mcServer.getConfigurationManager().transferPlayerToDimension(player, DeeperCaves.worldgen.deepWorldDimID, new DeeperTeleporter(player.mcServer.worldServerForDimension(DeeperCaves.worldgen.deepWorldDimID)));
	        	}
	        	else if(player.dimension>=DeeperCaves.worldgen.deepWorldDimID && event.player.posY <= 0.0D)
	        	{
	        		player.mcServer.getConfigurationManager().transferPlayerToDimension(player, DeeperCaves.worldgen.darknessDimID, new DeeperTeleporter(player.mcServer.worldServerForDimension(DeeperCaves.worldgen.darknessDimID)));
	        	}
	        	else if(player.dimension>=DeeperCaves.worldgen.darknessDimID && event.player.posY <= 0.0D)
	        	{
	        		player.mcServer.getConfigurationManager().transferPlayerToDimension(player, DeeperCaves.worldgen.abandonedCavesDimID, new DeeperTeleporter(player.mcServer.worldServerForDimension(DeeperCaves.worldgen.abandonedCavesDimID)));
	        	}
	        	else if(player.dimension>=DeeperCaves.worldgen.abandonedCavesDimID && event.player.posY <= 0.0D)
	        	{
	        		player.mcServer.getConfigurationManager().transferPlayerToDimension(player, DeeperCaves.worldgen.mutationDimID, new DeeperTeleporter(player.mcServer.worldServerForDimension(DeeperCaves.worldgen.mutationDimID)));
	        	}
	        	else if(player.dimension>=DeeperCaves.worldgen.mutationDimID && event.player.posY <= 0.0D)
	        	{
	        		player.mcServer.getConfigurationManager().transferPlayerToDimension(player, DeeperCaves.worldgen.farVoidDimID, new DeeperTeleporter(player.mcServer.worldServerForDimension(DeeperCaves.worldgen.farVoidDimID)));
	        	}
	        	else if(player.dimension == DeeperCaves.worldgen.farVoidDimID && event.player.posY <= 120.0D && DeeperCaves.instance.voidFlag)
	        	{
	        		player.mcServer.getConfigurationManager().transferPlayerToDimension(player, DeeperCaves.worldgen.forgottenDimID, new DeeperTeleporter(player.mcServer.worldServerForDimension(DeeperCaves.worldgen.forgottenDimID)));
	        	}
	        	else if(player.dimension == DeeperCaves.worldgen.forgottenDimID && event.player.posY <= 0.0D)
	        	{
	        		player.mcServer.getConfigurationManager().transferPlayerToDimension(player, DeeperCaves.worldgen.evilDimID, new DeeperTeleporter(player.mcServer.worldServerForDimension(DeeperCaves.worldgen.evilDimID)));
	        	}
	        	else if(player.dimension>=DeeperCaves.worldgen.evilDimID && event.player.posY <= 0.0D)
	        	{
	        		player.mcServer.getConfigurationManager().transferPlayerToDimension(player, DeeperCaves.worldgen.finalLabyrinthDimID, new DeeperTeleporter(player.mcServer.worldServerForDimension(DeeperCaves.worldgen.finalLabyrinthDimID)));
	        	}


	        	else{}
        	}
        	catch(ClassCastException e)
        	{
        		return; //not a player
        	}
    		try
        	{
	        	EntityPlayerMP player = (EntityPlayerMP)event.player;
	        	if(player.dimension == DeeperCaves.worldgen.dropDimID && event.player.posY >= 200.0)
	        	{
	        		player.mcServer.getConfigurationManager().transferPlayerToDimension(player, 0, new DeeperTeleporterLower(player.mcServer.worldServerForDimension(0)));
	        	}
	        	if(player.dimension == DeeperCaves.worldgen.mazeDimID && event.player.posY >= 200.0)
	        	{
	        		player.mcServer.getConfigurationManager().transferPlayerToDimension(player, DeeperCaves.worldgen.dropDimID, new DeeperTeleporterLower(player.mcServer.worldServerForDimension(DeeperCaves.worldgen.dropDimID)));
	        	}
	        	if(player.dimension == DeeperCaves.worldgen.crystalDimID && event.player.posY >= 150.0)
	        	{
	        		player.mcServer.getConfigurationManager().transferPlayerToDimension(player, DeeperCaves.worldgen.mazeDimID, new DeeperTeleporterLower(player.mcServer.worldServerForDimension(DeeperCaves.worldgen.mazeDimID)));
	        	}
	        	if(player.dimension == DeeperCaves.worldgen.compressedDimID && event.player.posY >= 100.0)
	        	{
	        		player.mcServer.getConfigurationManager().transferPlayerToDimension(player, DeeperCaves.worldgen.crystalDimID, new DeeperTeleporterLower(player.mcServer.worldServerForDimension(DeeperCaves.worldgen.crystalDimID)));
	        	}
	         	if(player.dimension == DeeperCaves.worldgen.bedrockPlainsDimID && event.player.posY >= 172.0)
	        	{
	        		player.mcServer.getConfigurationManager().transferPlayerToDimension(player, DeeperCaves.worldgen.compressedDimID, new DeeperTeleporterLower(player.mcServer.worldServerForDimension(DeeperCaves.worldgen.compressedDimID)));
	        	}
	         	if(player.dimension == DeeperCaves.worldgen.nearNetherDimID && event.player.posY >= 100.0)
	        	{
	        		player.mcServer.getConfigurationManager().transferPlayerToDimension(player, DeeperCaves.worldgen.bedrockPlainsDimID, new DeeperTeleporterLower(player.mcServer.worldServerForDimension(DeeperCaves.worldgen.bedrockPlainsDimID)));
	        	}
	         	if(player.dimension == DeeperCaves.worldgen.lavaDimID && event.player.posY >= 50.0)
	        	{
	        		player.mcServer.getConfigurationManager().transferPlayerToDimension(player, DeeperCaves.worldgen.nearNetherDimID, new DeeperTeleporterLower(player.mcServer.worldServerForDimension(DeeperCaves.worldgen.nearNetherDimID)));
	        	}
	         	if(player.dimension == DeeperCaves.worldgen.nearVoidDimID && event.player.posY >= 245.0)
	        	{
	        		player.mcServer.getConfigurationManager().transferPlayerToDimension(player, DeeperCaves.worldgen.lavaDimID, new DeeperTeleporterLower(player.mcServer.worldServerForDimension(DeeperCaves.worldgen.lavaDimID)));
	        	}
	         	if(player.dimension == DeeperCaves.worldgen.deepWorldDimID && event.player.posY >= 75.0)
	        	{
	        		player.mcServer.getConfigurationManager().transferPlayerToDimension(player, DeeperCaves.worldgen.nearVoidDimID, new DeeperTeleporter(player.mcServer.worldServerForDimension(DeeperCaves.worldgen.nearVoidDimID)));
	        	}
	         	if(player.dimension == DeeperCaves.worldgen.darknessDimID && event.player.posY >= 245.0)
	        	{
	        		player.mcServer.getConfigurationManager().transferPlayerToDimension(player, DeeperCaves.worldgen.deepWorldDimID, new DeeperTeleporterLower(player.mcServer.worldServerForDimension(DeeperCaves.worldgen.deepWorldDimID)));
	        	}
	         	if(player.dimension == DeeperCaves.worldgen.abandonedCavesDimID && event.player.posY >= 100.0)
	        	{
	        		player.mcServer.getConfigurationManager().transferPlayerToDimension(player, DeeperCaves.worldgen.darknessDimID, new DeeperTeleporterLower(player.mcServer.worldServerForDimension(DeeperCaves.worldgen.darknessDimID)));
	        	}
	         	if(player.dimension == DeeperCaves.worldgen.mutationDimID && event.player.posY >= 100.0)
	        	{
	        		player.mcServer.getConfigurationManager().transferPlayerToDimension(player, DeeperCaves.worldgen.abandonedCavesDimID, new DeeperTeleporterLower(player.mcServer.worldServerForDimension(DeeperCaves.worldgen.abandonedCavesDimID)));
	        	}
	         	if(player.dimension == DeeperCaves.worldgen.farVoidDimID && event.player.posY >= 245.0)
	        	{
	        		player.mcServer.getConfigurationManager().transferPlayerToDimension(player, DeeperCaves.worldgen.mutationDimID, new DeeperTeleporterLower(player.mcServer.worldServerForDimension(DeeperCaves.worldgen.mutationDimID)));
	        	}
	        	if(player.dimension == DeeperCaves.worldgen.forgottenDimID && event.player.posY >= 230.0)
	        	{
	        		player.mcServer.getConfigurationManager().transferPlayerToDimension(player, DeeperCaves.worldgen.farVoidDimID, new DeeperTeleporter(player.mcServer.worldServerForDimension(DeeperCaves.worldgen.farVoidDimID)));
	        	}
	        	if(player.dimension == DeeperCaves.worldgen.evilDimID && event.player.posY >= 100.0)
	        	{
	        		player.mcServer.getConfigurationManager().transferPlayerToDimension(player, DeeperCaves.worldgen.forgottenDimID, new DeeperTeleporter(player.mcServer.worldServerForDimension(DeeperCaves.worldgen.forgottenDimID)));
	        	}
	        	if(player.dimension == DeeperCaves.worldgen.finalLabyrinthDimID && event.player.posY >= 245.0)
	        	{
	        		player.mcServer.getConfigurationManager().transferPlayerToDimension(player, DeeperCaves.worldgen.evilDimID, new DeeperTeleporter(player.mcServer.worldServerForDimension(DeeperCaves.worldgen.evilDimID)));
	        	}
	        	else{}
        	}
        	catch(ClassCastException e)
        	{
        		//do nothing, not a player
        	}
    		try
            {
            EntityPlayerMP player = (EntityPlayerMP)event.player;
            if(event.player.posY <= 240.0D && player.dimension == DeeperCaves.worldgen.nearVoidDimID)
            {
	    		if(!DeeperCaves.instance.voidFlag)
	    		{
	    			if(DeeperCaves.instance.nearvoid_counter == 200)
	    			{
	    				player.attackEntityFrom(DamageSource.outOfWorld, 0.5F);
	    				DeeperCaves.instance.nearvoid_counter = 0;
	    			}
	    			else
	    			{
	    				DeeperCaves.instance.nearvoid_counter = DeeperCaves.instance.nearvoid_counter+1;
	    			}
	
	    		}
				else if(DeeperCaves.instance.nearvoid_counter == 0 && DeeperCaves.instance.voidFlag) 
				{
					DeeperCaves.instance.voidFlag = false;
					DeeperCaves.instance.nearvoid_counter = DeeperCaves.instance.nearvoid_counter+1;
				}
				else if(DeeperCaves.instance.nearvoid_counter == 200 && DeeperCaves.instance.voidFlag) 
				{
					DeeperCaves.instance.nearvoid_counter = 0;
				}
				else
				{
					DeeperCaves.instance.nearvoid_counter = DeeperCaves.instance.nearvoid_counter+1;
				}
            }
            if(event.player.posY <= 240.0D && player.dimension == DeeperCaves.worldgen.farVoidDimID)
            {
	    		if(!DeeperCaves.instance.voidFlag)
	    		{
	    			if(DeeperCaves.instance.farvoid_counter == 9)
	    			{
	    				player.attackEntityFrom(DamageSource.outOfWorld, 4.0F);
	    				DeeperCaves.instance.farvoid_counter = 0;
	    			}
	    			else
	    			{
	    				DeeperCaves.instance.farvoid_counter = DeeperCaves.instance.farvoid_counter+1;
	    			}
	
	    		}
				else if(DeeperCaves.instance.farvoid_counter == 0 && DeeperCaves.instance.voidFlag) 
				{
					DeeperCaves.instance.voidFlag = false;
					DeeperCaves.instance.farvoid_counter = DeeperCaves.instance.farvoid_counter+1;
				}
				else if(DeeperCaves.instance.farvoid_counter == 9 && DeeperCaves.instance.voidFlag) 
				{
					DeeperCaves.instance.farvoid_counter = 0;
				}
				else
				{
					DeeperCaves.instance.farvoid_counter = DeeperCaves.instance.farvoid_counter+1;
				}
            }
            if(player.dimension == DeeperCaves.worldgen.forgottenDimID)
            {
				if(DeeperCaves.instance.deep_counter == 0 && DeeperCaves.instance.deepFlag) 
				{
					DeeperCaves.instance.deepFlag = false;
					DeeperCaves.instance.deep_counter = DeeperCaves.instance.deep_counter+1;
				}
				else if(DeeperCaves.instance.deep_counter >= 1 && DeeperCaves.instance.deepFlag) 
				{
					DeeperCaves.instance.deep_counter = 0;
				}
				else
				{
					DeeperCaves.instance.deep_counter = DeeperCaves.instance.deep_counter+1;
				}
            }
            }
            catch(ClassCastException e)
            {
            	return; //not a player
            }
    		
    }
}

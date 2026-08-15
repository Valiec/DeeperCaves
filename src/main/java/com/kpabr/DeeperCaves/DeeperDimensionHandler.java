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
				boolean voidFlag = ((DeeperCaves.instance.voidFlag.get(player.getUniqueID()) != null) ? DeeperCaves.instance.voidFlag.get(player.getUniqueID()) : false);

				if(player.dimension == 0 && event.player.posY <= 0.0D) //0 = overworld
	        	{
	        		player.mcServer.getConfigurationManager().transferPlayerToDimension(player, DeeperCaves.worldgen.drop.dimID, new DeeperTeleporter(player.mcServer.worldServerForDimension(DeeperCaves.worldgen.drop.dimID), false));
	        	}
	        	else if(player.dimension == DeeperCaves.worldgen.drop.dimID && event.player.posY <= 0.0D)
	        	{
	        		player.mcServer.getConfigurationManager().transferPlayerToDimension(player, DeeperCaves.worldgen.maze.dimID, new DeeperTeleporter(player.mcServer.worldServerForDimension(DeeperCaves.worldgen.maze.dimID), false));
	        	}
	        	else if(player.dimension == DeeperCaves.worldgen.maze.dimID && event.player.posY <= 0.0D)
	        	{
	        		player.mcServer.getConfigurationManager().transferPlayerToDimension(player, DeeperCaves.worldgen.crystal.dimID, new DeeperTeleporter(player.mcServer.worldServerForDimension(DeeperCaves.worldgen.crystal.dimID), false));
	        	}
	        	else if(player.dimension == DeeperCaves.worldgen.crystal.dimID && event.player.posY <= 0.0D)
	        	{
	        		player.mcServer.getConfigurationManager().transferPlayerToDimension(player, DeeperCaves.worldgen.compressed.dimID, new DeeperTeleporter(player.mcServer.worldServerForDimension(DeeperCaves.worldgen.compressed.dimID), false));
	        	}
	        	else if(player.dimension == DeeperCaves.worldgen.compressed.dimID && event.player.posY <= 0.0D)
	        	{
	        		player.mcServer.getConfigurationManager().transferPlayerToDimension(player, DeeperCaves.worldgen.bedrockPlains.dimID, new DeeperTeleporter(player.mcServer.worldServerForDimension(DeeperCaves.worldgen.bedrockPlains.dimID), false));
	        	}
	        	else if(player.dimension == DeeperCaves.worldgen.bedrockPlains.dimID && event.player.posY <= 0.0D)
	        	{
	        		player.mcServer.getConfigurationManager().transferPlayerToDimension(player, DeeperCaves.worldgen.nearNether.dimID, new DeeperTeleporter(player.mcServer.worldServerForDimension(DeeperCaves.worldgen.nearNether.dimID), false));
	        	}
	        	else if(player.dimension == DeeperCaves.worldgen.nearNether.dimID && event.player.posY <= 0.0D)
	        	{
	        		player.mcServer.getConfigurationManager().transferPlayerToDimension(player, DeeperCaves.worldgen.lava.dimID, new DeeperTeleporter(player.mcServer.worldServerForDimension(DeeperCaves.worldgen.lava.dimID), false));
	        	}
	        	else if(player.dimension == DeeperCaves.worldgen.lava.dimID && event.player.posY <= 0.0D)
	        	{
	        		player.mcServer.getConfigurationManager().transferPlayerToDimension(player, DeeperCaves.worldgen.nearVoid.dimID, new DeeperTeleporter(player.mcServer.worldServerForDimension(DeeperCaves.worldgen.nearVoid.dimID), false));
	        	}
	        	else if(player.dimension == DeeperCaves.worldgen.nearVoid.dimID && event.player.posY <= 120.0D)
	        	{
	        		player.mcServer.getConfigurationManager().transferPlayerToDimension(player, DeeperCaves.worldgen.deepWorld.dimID, new DeeperTeleporter(player.mcServer.worldServerForDimension(DeeperCaves.worldgen.deepWorld.dimID), false));
	        	}
	        	else if(player.dimension == DeeperCaves.worldgen.deepWorld.dimID && event.player.posY <= 0.0D)
	        	{
	        		player.mcServer.getConfigurationManager().transferPlayerToDimension(player, DeeperCaves.worldgen.darkness.dimID, new DeeperTeleporter(player.mcServer.worldServerForDimension(DeeperCaves.worldgen.darkness.dimID), false));
	        	}
	        	else if(player.dimension == DeeperCaves.worldgen.darkness.dimID && event.player.posY <= 0.0D)
	        	{
	        		player.mcServer.getConfigurationManager().transferPlayerToDimension(player, DeeperCaves.worldgen.abandonedCaves.dimID, new DeeperTeleporter(player.mcServer.worldServerForDimension(DeeperCaves.worldgen.abandonedCaves.dimID), false));
	        	}
	        	else if(player.dimension == DeeperCaves.worldgen.abandonedCaves.dimID && event.player.posY <= 0.0D)
	        	{
	        		player.mcServer.getConfigurationManager().transferPlayerToDimension(player, DeeperCaves.worldgen.mutation.dimID, new DeeperTeleporter(player.mcServer.worldServerForDimension(DeeperCaves.worldgen.mutation.dimID), false));
	        	}
	        	else if(player.dimension == DeeperCaves.worldgen.mutation.dimID && event.player.posY <= 0.0D)
	        	{
	        		player.mcServer.getConfigurationManager().transferPlayerToDimension(player, DeeperCaves.worldgen.farVoid.dimID, new DeeperTeleporter(player.mcServer.worldServerForDimension(DeeperCaves.worldgen.farVoid.dimID), false));
	        	}
	        	else if(player.dimension == DeeperCaves.worldgen.farVoid.dimID && event.player.posY <= 120.0D && voidFlag)
	        	{
	        		player.mcServer.getConfigurationManager().transferPlayerToDimension(player, DeeperCaves.worldgen.forgotten.dimID, new DeeperTeleporter(player.mcServer.worldServerForDimension(DeeperCaves.worldgen.forgotten.dimID), false));
	        	}
	        	else if(player.dimension == DeeperCaves.worldgen.forgotten.dimID && event.player.posY <= 0.0D)
	        	{
	        		player.mcServer.getConfigurationManager().transferPlayerToDimension(player, DeeperCaves.worldgen.evil.dimID, new DeeperTeleporter(player.mcServer.worldServerForDimension(DeeperCaves.worldgen.evil.dimID), false));
	        	}
	        	else if(player.dimension == DeeperCaves.worldgen.evil.dimID && event.player.posY <= 0.0D)
	        	{
	        		player.mcServer.getConfigurationManager().transferPlayerToDimension(player, DeeperCaves.worldgen.finalLabyrinth.dimID, new DeeperTeleporter(player.mcServer.worldServerForDimension(DeeperCaves.worldgen.finalLabyrinth.dimID), false));
	        	}
        	}
        	catch(ClassCastException e)
        	{
        		return; //not a player
        	}
    		try
        	{
	        	EntityPlayerMP player = (EntityPlayerMP)event.player;

	        	if(player.dimension == DeeperCaves.worldgen.drop.dimID && event.player.posY >= 200.0)
	        	{
	        		player.mcServer.getConfigurationManager().transferPlayerToDimension(player, 0, new DeeperTeleporter(player.mcServer.worldServerForDimension(0), true));
	        	}
	        	if(player.dimension == DeeperCaves.worldgen.maze.dimID && event.player.posY >= 200.0)
	        	{
	        		player.mcServer.getConfigurationManager().transferPlayerToDimension(player, DeeperCaves.worldgen.drop.dimID, new DeeperTeleporter(player.mcServer.worldServerForDimension(DeeperCaves.worldgen.drop.dimID), true));
	        	}
	        	if(player.dimension == DeeperCaves.worldgen.crystal.dimID && event.player.posY >= 150.0)
	        	{
	        		player.mcServer.getConfigurationManager().transferPlayerToDimension(player, DeeperCaves.worldgen.maze.dimID, new DeeperTeleporter(player.mcServer.worldServerForDimension(DeeperCaves.worldgen.maze.dimID), true));
	        	}
	        	if(player.dimension == DeeperCaves.worldgen.compressed.dimID && event.player.posY >= 100.0)
	        	{
	        		player.mcServer.getConfigurationManager().transferPlayerToDimension(player, DeeperCaves.worldgen.crystal.dimID, new DeeperTeleporter(player.mcServer.worldServerForDimension(DeeperCaves.worldgen.crystal.dimID), true));
	        	}
	         	if(player.dimension == DeeperCaves.worldgen.bedrockPlains.dimID && event.player.posY >= DeeperConfig.bedrockPlainsCeilingHeight+6)
	        	{
	        		player.mcServer.getConfigurationManager().transferPlayerToDimension(player, DeeperCaves.worldgen.compressed.dimID, new DeeperTeleporter(player.mcServer.worldServerForDimension(DeeperCaves.worldgen.compressed.dimID), true));
	        	}
	         	if(player.dimension == DeeperCaves.worldgen.nearNether.dimID && event.player.posY >= 100.0)
	        	{
	        		player.mcServer.getConfigurationManager().transferPlayerToDimension(player, DeeperCaves.worldgen.bedrockPlains.dimID, new DeeperTeleporter(player.mcServer.worldServerForDimension(DeeperCaves.worldgen.bedrockPlains.dimID), true));
	        	}
	         	if(player.dimension == DeeperCaves.worldgen.lava.dimID && event.player.posY >= 50.0)
	        	{
	        		player.mcServer.getConfigurationManager().transferPlayerToDimension(player, DeeperCaves.worldgen.nearNether.dimID, new DeeperTeleporter(player.mcServer.worldServerForDimension(DeeperCaves.worldgen.nearNether.dimID), true));
	        	}
	         	if(player.dimension == DeeperCaves.worldgen.nearVoid.dimID && event.player.posY >= 245.0)
	        	{
	        		player.mcServer.getConfigurationManager().transferPlayerToDimension(player, DeeperCaves.worldgen.lava.dimID, new DeeperTeleporter(player.mcServer.worldServerForDimension(DeeperCaves.worldgen.lava.dimID), true));
	        	}
	         	if(player.dimension == DeeperCaves.worldgen.deepWorld.dimID && event.player.posY >= 75.0)
	        	{
	        		player.mcServer.getConfigurationManager().transferPlayerToDimension(player, DeeperCaves.worldgen.nearVoid.dimID, new DeeperTeleporter(player.mcServer.worldServerForDimension(DeeperCaves.worldgen.nearVoid.dimID), true));
	        	}
	         	if(player.dimension == DeeperCaves.worldgen.darkness.dimID && event.player.posY >= 245.0)
	        	{
	        		player.mcServer.getConfigurationManager().transferPlayerToDimension(player, DeeperCaves.worldgen.deepWorld.dimID, new DeeperTeleporter(player.mcServer.worldServerForDimension(DeeperCaves.worldgen.deepWorld.dimID), true));
	        	}
	         	if(player.dimension == DeeperCaves.worldgen.abandonedCaves.dimID && event.player.posY >= 100.0)
	        	{
	        		player.mcServer.getConfigurationManager().transferPlayerToDimension(player, DeeperCaves.worldgen.darkness.dimID, new DeeperTeleporter(player.mcServer.worldServerForDimension(DeeperCaves.worldgen.darkness.dimID), true));
	        	}
	         	if(player.dimension == DeeperCaves.worldgen.mutation.dimID && event.player.posY >= 100.0)
	        	{
	        		player.mcServer.getConfigurationManager().transferPlayerToDimension(player, DeeperCaves.worldgen.abandonedCaves.dimID, new DeeperTeleporter(player.mcServer.worldServerForDimension(DeeperCaves.worldgen.abandonedCaves.dimID), true));
	        	}
	         	if(player.dimension == DeeperCaves.worldgen.farVoid.dimID && event.player.posY >= 245.0)
	        	{
	        		player.mcServer.getConfigurationManager().transferPlayerToDimension(player, DeeperCaves.worldgen.mutation.dimID, new DeeperTeleporter(player.mcServer.worldServerForDimension(DeeperCaves.worldgen.mutation.dimID), true));
	        	}
	        	if(player.dimension == DeeperCaves.worldgen.forgotten.dimID && event.player.posY >= 230.0)
	        	{
	        		player.mcServer.getConfigurationManager().transferPlayerToDimension(player, DeeperCaves.worldgen.farVoid.dimID, new DeeperTeleporter(player.mcServer.worldServerForDimension(DeeperCaves.worldgen.farVoid.dimID), true));
	        	}
	        	if(player.dimension == DeeperCaves.worldgen.evil.dimID && event.player.posY >= 100.0)
	        	{
	        		player.mcServer.getConfigurationManager().transferPlayerToDimension(player, DeeperCaves.worldgen.forgotten.dimID, new DeeperTeleporter(player.mcServer.worldServerForDimension(DeeperCaves.worldgen.forgotten.dimID), true));
	        	}
	        	if(player.dimension == DeeperCaves.worldgen.finalLabyrinth.dimID && event.player.posY >= 245.0)
	        	{
	        		player.mcServer.getConfigurationManager().transferPlayerToDimension(player, DeeperCaves.worldgen.evil.dimID, new DeeperTeleporter(player.mcServer.worldServerForDimension(DeeperCaves.worldgen.evil.dimID), true));
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

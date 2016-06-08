package com.kpabr.DeeperCaves;

import java.util.HashMap;

import com.kpabr.DeeperCaves.item.ItemFragmentedBedrockBucket;

import cpw.mods.fml.common.eventhandler.Event.Result;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.FillBucketEvent;

public class DeeperBucketHandler {
	
	private HashMap<Block, Item> map = new HashMap<Block, Item>();
	
	private HashMap<Block, Item> mapfr = new HashMap<Block, Item>();
	
	public DeeperBucketHandler()
	{
		map.put(Blocks.water, Items.water_bucket);
		map.put(Blocks.flowing_water, Items.water_bucket);
		map.put(Blocks.lava, Items.lava_bucket);
		map.put(Blocks.flowing_lava, Items.lava_bucket);
		map.put(DeeperCaves.fluids.veneniumBlock, DeeperCaves.items.bucketV);
		mapfr.put(DeeperCaves.fluids.moltenIronBlock, DeeperCaves.items.fragmentedBedrockBucketMI);
		mapfr.put(Blocks.water, DeeperCaves.items.fragmentedBedrockBucketW);
		mapfr.put(Blocks.flowing_water, DeeperCaves.items.fragmentedBedrockBucketW);
		mapfr.put(Blocks.lava, DeeperCaves.items.fragmentedBedrockBucketL);
		mapfr.put(Blocks.flowing_lava, DeeperCaves.items.fragmentedBedrockBucketL);
		mapfr.put(DeeperCaves.fluids.veneniumBlock, DeeperCaves.items.fragmentedBedrockBucketV);
	}
	@SubscribeEvent
	public void onBucketFill(FillBucketEvent event)
	{
		Block block = event.world.getBlock(event.target.blockX, event.target.blockY, event.target.blockZ);
		if(map.containsKey(block) && event.current.getItem() == Items.bucket)
		{
			event.setResult(Result.ALLOW);
			event.result = new ItemStack(map.get(block));
			event.world.setBlock(event.target.blockX, event.target.blockY, event.target.blockZ, Blocks.air);
		}
		else if(mapfr.containsKey(block) && !map.containsKey(block) && event.current.getItem() == Items.bucket)
		{
			event.setCanceled(true);
		}
		else if(mapfr.containsKey(block) && event.current.getItem() == DeeperCaves.items.fragmentedBedrockBucket)
		{
			event.setResult(Result.ALLOW);
			event.result = new ItemStack(mapfr.get(block));
			System.out.println(event.result.getUnlocalizedName());
			event.world.setBlock(event.target.blockX, event.target.blockY, event.target.blockZ, Blocks.air);
		}
		else if(!mapfr.containsKey(block) && map.containsKey(block) && event.current.getItem() == DeeperCaves.items.fragmentedBedrockBucket)
		{
			event.setCanceled(true);
		}
		else
		{
		event.setResult(Result.DEFAULT);
		event.result = event.current;//event.current;//new ItemStack(Items.fish);
		}
		return;
		
	}
}

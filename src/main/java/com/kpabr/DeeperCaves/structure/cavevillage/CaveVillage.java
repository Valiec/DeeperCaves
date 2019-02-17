//Schematic to java Structure by jajo_11 | inspired by "MITHION'S .SCHEMATIC TO JAVA CONVERTINGTOOL"

package com.kpabr.DeeperCaves.structure.cavevillage;

import java.util.Random;

import com.kpabr.DeeperCaves.DeeperCaves;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class CaveVillage extends WorldGenerator
{
	public CaveVillage instance;
	
	protected static Block[] GetValidSpawnBlocks()
	{
		return new Block[]
		{
			DeeperCaves.blocks.abandonedStone,
		};
	}

	public static boolean LocationIsValidSpawn(World world, int x, int y, int z)
 {

		Block checkBlock = world.getBlock(x, y - 1, z);
		Block blockAbove = world.getBlock(x, y , z);
		Block blockBelow = world.getBlock(x, y - 2, z);

		for (Block i : GetValidSpawnBlocks())
		{
			if (blockAbove != Blocks.air)
			{
				return false;
			}
			if (checkBlock == i)
			{
				return true;
			}
			else if (checkBlock == Blocks.snow_layer && blockBelow == i)
			{
				return true;
			}
			else if (checkBlock.getMaterial() == Material.plants && blockBelow == i)
			{
				return true;
			}
		}
		return false;
	}

	public boolean generate(World world, Random rand, int x, int y, int z)
	{
		int i = rand.nextInt(4);

		if(i == 0)
		{
		    generate_r0(world, rand, x, y, z);
		}

		if(i == 1)
		{
			new CaveVillage007().generate_r1(world, rand, x, y, z);
		}

		if(i == 2)
		{
			new CaveVillage014().generate_r2(world, rand, x, y, z);
		}

		if(i == 3)
		{
			new CaveVillage021().generate_r3(world, rand, x, y, z);
		}

       return true;

	}

	public boolean generate_r0(World world, Random rand, int x, int y, int z)
	{
		if(!LocationIsValidSpawn(world, x + 49, y, z + 35))
		{
			return false;
		}

		world.setBlock(x + 55, y + 0, z + 4, Blocks.cobblestone, 0, 3);
		world.setBlock(x + 56, y + 0, z + 4, Blocks.cobblestone, 0, 3);
		world.setBlock(x + 57, y + 0, z + 4, Blocks.cobblestone, 0, 3);
		world.setBlock(x + 55, y + 0, z + 5, Blocks.cobblestone, 0, 3);
		world.setBlock(x + 56, y + 0, z + 5, Blocks.cobblestone, 0, 3);
		world.setBlock(x + 57, y + 0, z + 5, Blocks.cobblestone, 0, 3);
		world.setBlock(x + 55, y + 0, z + 6, Blocks.cobblestone, 0, 3);
		world.setBlock(x + 56, y + 0, z + 6, Blocks.cobblestone, 0, 3);
		world.setBlock(x + 57, y + 0, z + 6, Blocks.cobblestone, 0, 3);
		world.setBlock(x + 55, y + 0, z + 7, Blocks.cobblestone, 0, 3);
		world.setBlock(x + 56, y + 0, z + 7, Blocks.cobblestone, 0, 3);
		world.setBlock(x + 57, y + 0, z + 7, Blocks.cobblestone, 0, 3);
		world.setBlock(x + 55, y + 0, z + 8, Blocks.cobblestone, 0, 3);
		world.setBlock(x + 56, y + 0, z + 8, Blocks.cobblestone, 0, 3);
		world.setBlock(x + 57, y + 0, z + 8, Blocks.cobblestone, 0, 3);
		world.setBlock(x + 55, y + 0, z + 9, Blocks.cobblestone, 0, 3);
		world.setBlock(x + 56, y + 0, z + 9, Blocks.cobblestone, 0, 3);
		world.setBlock(x + 57, y + 0, z + 9, Blocks.cobblestone, 0, 3);
		world.setBlock(x + 58, y + 0, z + 9, Blocks.cobblestone, 0, 3);
		world.setBlock(x + 59, y + 0, z + 9, Blocks.cobblestone, 0, 3);
		world.setBlock(x + 60, y + 0, z + 9, Blocks.cobblestone, 0, 3);
		world.setBlock(x + 61, y + 0, z + 9, Blocks.cobblestone, 0, 3);
		world.setBlock(x + 62, y + 0, z + 9, Blocks.cobblestone, 0, 3);
		world.setBlock(x + 63, y + 0, z + 9, Blocks.cobblestone, 0, 3);
		world.setBlock(x + 64, y + 0, z + 9, Blocks.cobblestone, 0, 3);
		world.setBlock(x + 65, y + 0, z + 9, Blocks.cobblestone, 0, 3);
		world.setBlock(x + 66, y + 0, z + 9, Blocks.cobblestone, 0, 3);
		world.setBlock(x + 67, y + 0, z + 9, Blocks.cobblestone, 0, 3);
		world.setBlock(x + 68, y + 0, z + 9, Blocks.cobblestone, 0, 3);
		world.setBlock(x + 69, y + 0, z + 9, Blocks.cobblestone, 0, 3);
		world.setBlock(x + 70, y + 0, z + 9, Blocks.cobblestone, 0, 3);
		world.setBlock(x + 71, y + 0, z + 9, Blocks.cobblestone, 0, 3);
		world.setBlock(x + 72, y + 0, z + 9, Blocks.cobblestone, 0, 3);
		world.setBlock(x + 73, y + 0, z + 9, Blocks.cobblestone, 0, 3);
		world.setBlock(x + 74, y + 0, z + 9, Blocks.cobblestone, 0, 3);
		world.setBlock(x + 75, y + 0, z + 9, Blocks.cobblestone, 0, 3);
		world.setBlock(x + 76, y + 0, z + 9, Blocks.cobblestone, 0, 3);
		world.setBlock(x + 77, y + 0, z + 9, Blocks.cobblestone, 0, 3);
		world.setBlock(x + 78, y + 0, z + 9, Blocks.cobblestone, 0, 3);
		world.setBlock(x + 79, y + 0, z + 9, Blocks.cobblestone, 0, 3);
		world.setBlock(x + 80, y + 0, z + 9, Blocks.cobblestone, 0, 3);
		world.setBlock(x + 81, y + 0, z + 9, Blocks.cobblestone, 0, 3);

		new CaveVillage001().generate_r00(world, rand, x, y, z);
		return true;

	}
}
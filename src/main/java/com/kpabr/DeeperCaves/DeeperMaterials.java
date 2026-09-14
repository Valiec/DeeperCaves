package com.kpabr.DeeperCaves;


import com.kpabr.DeeperCaves.block.MaterialMoltenIron;

import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialLiquid;

public class DeeperMaterials {
	public static MaterialLiquid moltenIron = (new MaterialMoltenIron());

	public static Material sculk = new Material(MapColor.cyanColor);

	public static Block.SoundType sculkSound = new DeeperSoundType("sculk", 1.0F, 1.0F);
	public static Block.SoundType sculkSensorSound = new DeeperSoundType("sculk_sensor", 1.0F, 1.0F);
	public static Block.SoundType sculkShriekerSound = new DeeperSoundType("sculk_shrieker", 1.0F, 1.0F);
	public static Block.SoundType sculkVeinSound = new DeeperSoundType("sculk_vein", 1.0F, 1.0F);
	public static Block.SoundType sculkCatalystSound = new DeeperSoundType("sculk_catalyst", 1.0F, 1.0F);

}

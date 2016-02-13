package com.kpabr.DeeperCaves;

import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.config.Configuration;

public class DeeperConfig {

	public Configuration config;
	public String CATEGORY_DIM_IDS = "dimension ids";
	public String CATEGORY_BIOME_IDS = "biome ids";

    public void initConfig(FMLPreInitializationEvent event)
    {
        config = new Configuration(event.getSuggestedConfigurationFile()); //gets default config file
        
        config.load();
        config.addCustomCategoryComment("dimension ids", "Dimension IDs");
        
        DeeperCaves.worldgen.dropDimID = config.getInt("Drop ID", this.CATEGORY_DIM_IDS, -2, Integer.MIN_VALUE, Integer.MAX_VALUE, "");
        DeeperCaves.worldgen.mazeDimID = config.getInt("Maze ID", this.CATEGORY_DIM_IDS, -3, Integer.MIN_VALUE, Integer.MAX_VALUE, "");
        DeeperCaves.worldgen.crystalDimID = config.getInt("Crystal ID", this.CATEGORY_DIM_IDS, -4, Integer.MIN_VALUE, Integer.MAX_VALUE, "");
        DeeperCaves.worldgen.compressedDimID = config.getInt("Compressed ID", this.CATEGORY_DIM_IDS, -5, Integer.MIN_VALUE, Integer.MAX_VALUE, "");
        DeeperCaves.worldgen.bedrockPlainsDimID = config.getInt("Bedrock Plains ID", this.CATEGORY_DIM_IDS, -6, Integer.MIN_VALUE, Integer.MAX_VALUE, "");
        
        DeeperCaves.worldgen.nearNetherDimID = config.getInt("Near Nether ID", this.CATEGORY_DIM_IDS, -7, Integer.MIN_VALUE, Integer.MAX_VALUE, "");
        DeeperCaves.worldgen.lavaDimID = config.getInt("Lava ID", this.CATEGORY_DIM_IDS, -8, Integer.MIN_VALUE, Integer.MAX_VALUE, "");
        DeeperCaves.worldgen.nearVoidDimID = config.getInt("Near Void ID", this.CATEGORY_DIM_IDS, -9, Integer.MIN_VALUE, Integer.MAX_VALUE, "");
        
        DeeperCaves.worldgen.deepWorldDimID = config.getInt("Deep World ID", this.CATEGORY_DIM_IDS, -10, Integer.MIN_VALUE, Integer.MAX_VALUE, "");
        DeeperCaves.worldgen.darknessDimID = config.getInt("Darkness ID", this.CATEGORY_DIM_IDS, -11, Integer.MIN_VALUE, Integer.MAX_VALUE, "");
        DeeperCaves.worldgen.abandonedCavesDimID = config.getInt("Abandoned Caves ID", this.CATEGORY_DIM_IDS, -12, Integer.MIN_VALUE, Integer.MAX_VALUE, "");
        DeeperCaves.worldgen.mutationDimID = config.getInt("Mutation ID (level to be added)", this.CATEGORY_DIM_IDS, -13, Integer.MIN_VALUE, Integer.MAX_VALUE, "");
        DeeperCaves.worldgen.farVoidDimID = config.getInt("Far Void ID", this.CATEGORY_DIM_IDS, -14, Integer.MIN_VALUE, Integer.MAX_VALUE, "");
        
        DeeperCaves.worldgen.forgottenDimID = config.getInt("Forgotten ID (level to be added)", this.CATEGORY_DIM_IDS, -15, Integer.MIN_VALUE, Integer.MAX_VALUE, "");
        DeeperCaves.worldgen.evilDimID = config.getInt("Evil ID (level to be added)", this.CATEGORY_DIM_IDS, -16, Integer.MIN_VALUE, Integer.MAX_VALUE, "");
        DeeperCaves.worldgen.finalLabyrinthDimID = config.getInt("Final Labyrinth ID", this.CATEGORY_DIM_IDS, -17, Integer.MIN_VALUE, Integer.MAX_VALUE, "");
        
        //------------------
        
        config.addCustomCategoryComment("biome ids", "Biome IDs");
        
        DeeperCaves.worldgen.dropBiomeID = config.getInt("Drop Biome ID", this.CATEGORY_BIOME_IDS, 170, 0, 245, "");
        DeeperCaves.worldgen.mazeBiomeID = config.getInt("Maze Biome ID", this.CATEGORY_BIOME_IDS, 171, 0, 245, "");
        DeeperCaves.worldgen.crystalBiomeID = config.getInt("Crystal Biome ID", this.CATEGORY_BIOME_IDS, 172, 0, 245, "");
        DeeperCaves.worldgen.compressedBiomeID = config.getInt("Compressed Biome ID", this.CATEGORY_BIOME_IDS, 173, 0, 245, "");
        DeeperCaves.worldgen.bedrockPlainsBiomeID = config.getInt("Bedrock Plains Biome ID", this.CATEGORY_BIOME_IDS, 174, 0, 245, "");
        
        DeeperCaves.worldgen.nearNetherBiomeID = config.getInt("Near Nether Biome ID", this.CATEGORY_BIOME_IDS, 175, 0, 245, "");
        DeeperCaves.worldgen.lavaBiomeID = config.getInt("Lava Biome ID", this.CATEGORY_BIOME_IDS, 176, 0, 245, "");
        DeeperCaves.worldgen.nearVoidBiomeID = config.getInt("Near Void Biome ID", this.CATEGORY_BIOME_IDS, 177, 0, 245, "");
        
        DeeperCaves.worldgen.deepWorldBiomeID = config.getInt("Deep World Biome ID", this.CATEGORY_BIOME_IDS, 178, 0, 245, "");
        DeeperCaves.worldgen.darknessBiomeID = config.getInt("Darkness Biome ID", this.CATEGORY_BIOME_IDS, 179, 0, 245, "");
        DeeperCaves.worldgen.abandonedCavesBiomeID = config.getInt("Abandoned Caves Biome ID", this.CATEGORY_BIOME_IDS, 180, 0, 245, "");
        DeeperCaves.worldgen.mutationBiomeID = config.getInt("Mutation Biome ID (level to be added)", this.CATEGORY_BIOME_IDS, 181, 0, 245, "");
        DeeperCaves.worldgen.farVoidBiomeID = config.getInt("Far Void Biome ID", this.CATEGORY_BIOME_IDS, 182, 0, 245, "");
        
        DeeperCaves.worldgen.forgottenBiomeID = config.getInt("Forgotten Biome ID (level to be added)", this.CATEGORY_BIOME_IDS, 183, 0, 245, "");
        DeeperCaves.worldgen.evilBiomeID = config.getInt("Evil Biome ID (level to be added)", this.CATEGORY_BIOME_IDS, 184, 0, 245, "");
        DeeperCaves.worldgen.finalLabyrinthBiomeID = config.getInt("Final Labyrinth Biome ID", this.CATEGORY_BIOME_IDS, 185, 0, 245, "");
        
        config.save();
    }
}

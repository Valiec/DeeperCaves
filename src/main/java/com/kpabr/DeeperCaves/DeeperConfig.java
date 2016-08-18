package com.kpabr.DeeperCaves;

import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.config.Configuration;

public class DeeperConfig {

	public Configuration config;
	public String CATEGORY_DIM_IDS = "dimension ids";
	public String CATEGORY_BIOME_IDS = "biome ids";
	public String CATEGORY_ENTITY_IDS = "entity ids";
	public String CATEGORY_OTHER = "other";

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
        DeeperCaves.worldgen.mutationDimID = config.getInt("Mutation ID", this.CATEGORY_DIM_IDS, -13, Integer.MIN_VALUE, Integer.MAX_VALUE, "");
        DeeperCaves.worldgen.farVoidDimID = config.getInt("Far Void ID", this.CATEGORY_DIM_IDS, -14, Integer.MIN_VALUE, Integer.MAX_VALUE, "");
        
        DeeperCaves.worldgen.forgottenDimID = config.getInt("Forgotten ID", this.CATEGORY_DIM_IDS, -15, Integer.MIN_VALUE, Integer.MAX_VALUE, "");
        DeeperCaves.worldgen.evilDimID = config.getInt("Evil ID", this.CATEGORY_DIM_IDS, -16, Integer.MIN_VALUE, Integer.MAX_VALUE, "");
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
        DeeperCaves.worldgen.mutationBiomeID = config.getInt("Mutation Biome ID", this.CATEGORY_BIOME_IDS, 181, 0, 245, "");
        DeeperCaves.worldgen.farVoidBiomeID = config.getInt("Far Void Biome ID", this.CATEGORY_BIOME_IDS, 182, 0, 245, "");
        
        DeeperCaves.worldgen.forgottenBiomeID = config.getInt("Forgotten Biome ID", this.CATEGORY_BIOME_IDS, 183, 0, 245, "");
        DeeperCaves.worldgen.evilBiomeID = config.getInt("Evil Biome ID", this.CATEGORY_BIOME_IDS, 184, 0, 245, "");
        DeeperCaves.worldgen.finalLabyrinthBiomeID = config.getInt("Final Labyrinth Biome ID", this.CATEGORY_BIOME_IDS, 185, 0, 245, "");
        
        //------------------
        
        config.addCustomCategoryComment("entity ids", "Entity IDs");
        
        DeeperCaves.mobs.deepZombieID = config.getInt("Deep World Zombie Entity ID", this.CATEGORY_ENTITY_IDS, 102, 0, 255, "");
        DeeperCaves.mobs.deepSkeletonID = config.getInt("Deep World Skeleton Entity ID", this.CATEGORY_ENTITY_IDS, 103, 0, 255, "");
        DeeperCaves.mobs.deepCaveSpiderID = config.getInt("Deep World Cave Spider Entity ID", this.CATEGORY_ENTITY_IDS, 104, 0, 255, "");
        DeeperCaves.mobs.deepCreeperID = config.getInt("Deep World Creeper Entity ID", this.CATEGORY_ENTITY_IDS, 105, 0, 255, "");
        
        DeeperCaves.mobs.mutatedZombieID = config.getInt("Mutated Zombie Entity ID", this.CATEGORY_ENTITY_IDS, 106, 0, 255, "");
        DeeperCaves.mobs.mutatedSkeletonID = config.getInt("Mutated Skeleton Entity ID", this.CATEGORY_ENTITY_IDS, 107, 0, 255, "");
        DeeperCaves.mobs.mutatedCaveSpiderID = config.getInt("Mutated Cave Spider Entity ID", this.CATEGORY_ENTITY_IDS, 108, 0, 255, "");
        DeeperCaves.mobs.mutatedCreeperID = config.getInt("Mutated Creeper Entity ID", this.CATEGORY_ENTITY_IDS, 109, 0, 255, "");
        
        DeeperCaves.mobs.shadowID = config.getInt("Shadow Entity ID", this.CATEGORY_ENTITY_IDS, 110, 0, 255, "");
        
        //------------------
        
        config.addCustomCategoryComment("other", "Other");
        
        DeeperCaves.worldgen.bedrockPlainsFloorHeight = config.getInt("Bedrock Plains Floor Height", this.CATEGORY_OTHER, 155, 1, 255, "");
        DeeperCaves.worldgen.bedrockPlainsCeilingHeight = config.getInt("Bedrock Plains Ceiling Height", this.CATEGORY_OTHER, 175, 0, 255, "This is the height of the level barrier. The bedrock ceiling extends about 5 blocks below this.");
        
        config.save();
    }
}

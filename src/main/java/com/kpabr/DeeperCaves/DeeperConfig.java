package com.kpabr.DeeperCaves;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.config.Configuration;

import java.util.regex.Pattern;

public class DeeperConfig {

	public Configuration config;
	public String CATEGORY_DIM_IDS = "dimension ids";
	public String CATEGORY_BIOME_IDS = "biome ids";
    public String CATEGORY_FOG_COLORS = "fog colors";
	public String CATEGORY_ENTITY_IDS = "entity ids";
	public String CATEGORY_OTHER = "other";

    public Pattern hexColor = Pattern.compile("^(#|0x)?([A-Fa-f0-9]{6})$");


    public static int dropDimID;
    public static int mazeDimID;
    public static int crystalDimID;
    public static int compressedDimID;
    public static int bedrockPlainsDimID;

    public static int nearNetherDimID;
    public static int lavaDimID;
    public static int nearVoidDimID;

    public static int deepWorldDimID;
    public static int darknessDimID;
    public static int abandonedCavesDimID;
    public static int mutationDimID;
    public static int farVoidDimID;

    public static int forgottenDimID;
    public static int evilDimID;
    public static int finalLabyrinthDimID;

    //-----------------

    public static int dropBiomeID;
    public static int mazeBiomeID;
    public static int crystalBiomeID;
    public static int compressedBiomeID;
    public static int bedrockPlainsBiomeID;

    public static int nearNetherBiomeID;
    public static int nearNetherBasaltBiomeID;
    public static int lavaBiomeID;
    public static int nearVoidBiomeID;

    public static int deepWorldBiomeID;
    public static int darknessBiomeID;
    public static int abandonedCavesBiomeID;
    public static int mutationBiomeID;
    public static int farVoidBiomeID;

    public static int forgottenBiomeID;
    public static int evilBiomeID;
    public static int finalLabyrinthBiomeID;
    public static int finalLabyrinthSculkBiomeID;

    //-----------------

    public static String dropFogColorStr;
    public static String mazeFogColorStr;
    public static String crystalFogColorStr;
    public static String compressedFogColorStr;
    public static String bedrockPlainsFogColorStr;

    public static String nearNetherFogColorStr;
    public static String lavaFogColorStr;
    public static String nearVoidFogColorStr;

    public static String deepWorldFogColorStr;
    public static String darknessFogColorStr;
    public static String abandonedCavesFogColorStr;
    public static String mutationFogColorStr;
    public static String farVoidFogColorStr;

    public static String forgottenFogColorStr;
    public static String evilFogColorStr;
    public static String finalLabyrinthFogColorStr;

    public static int dropFogColor;
    public static int mazeFogColor;
    public static int crystalFogColor;
    public static int compressedFogColor;
    public static int bedrockPlainsFogColor;

    public static int nearNetherFogColor;
    public static int lavaFogColor;
    public static int nearVoidFogColor;

    public static int deepWorldFogColor;
    public static int darknessFogColor;
    public static int abandonedCavesFogColor;
    public static int mutationFogColor;
    public static int farVoidFogColor;

    public static int forgottenFogColor;
    public static int evilFogColor;
    public static int finalLabyrinthFogColor;

    public static int bedrockPlainsFloorHeight;
    public static int bedrockPlainsCeilingHeight;

    public static String[] levelOrder = new String[] { "Overworld", "Drop", "Maze", "Crystal", "Compressed",
            "Bedrock Plains", "Near Nether", "Lava", "Near Void", "Deep World", "Abandoned Caves",
            "Darkness", "Mutation", "Far Void", "Forgotten", "Evil", "Final Labyrinth" };

    public static int bedrockRemovalType;

    public int colorFromHex(String colorHex) {
        if (colorHex.startsWith("#")) {
            colorHex = colorHex.substring(1);
        }
        else if(colorHex.startsWith("0x")) {
            colorHex = colorHex.substring(2);
        }
        return Integer.parseInt(colorHex, 16);
    }

    public void initConfig(FMLPreInitializationEvent event)
    {
        config = new Configuration(event.getSuggestedConfigurationFile()); //gets default config file
        
        config.load();
        config.addCustomCategoryComment("dimension ids", "Dimension IDs");
        
        dropDimID = config.getInt("Drop ID", this.CATEGORY_DIM_IDS, -2, Integer.MIN_VALUE, Integer.MAX_VALUE, "");
        mazeDimID = config.getInt("Maze ID", this.CATEGORY_DIM_IDS, -3, Integer.MIN_VALUE, Integer.MAX_VALUE, "");
        crystalDimID = config.getInt("Crystal ID", this.CATEGORY_DIM_IDS, -4, Integer.MIN_VALUE, Integer.MAX_VALUE, "");
        compressedDimID = config.getInt("Compressed ID", this.CATEGORY_DIM_IDS, -5, Integer.MIN_VALUE, Integer.MAX_VALUE, "");
        bedrockPlainsDimID = config.getInt("Bedrock Plains ID", this.CATEGORY_DIM_IDS, -6, Integer.MIN_VALUE, Integer.MAX_VALUE, "");
        
        nearNetherDimID = config.getInt("Near Nether ID", this.CATEGORY_DIM_IDS, -7, Integer.MIN_VALUE, Integer.MAX_VALUE, "");
        lavaDimID = config.getInt("Lava ID", this.CATEGORY_DIM_IDS, -8, Integer.MIN_VALUE, Integer.MAX_VALUE, "");
        nearVoidDimID = config.getInt("Near Void ID", this.CATEGORY_DIM_IDS, -9, Integer.MIN_VALUE, Integer.MAX_VALUE, "");
        
        deepWorldDimID = config.getInt("Deep World ID", this.CATEGORY_DIM_IDS, -10, Integer.MIN_VALUE, Integer.MAX_VALUE, "");
        darknessDimID = config.getInt("Darkness ID", this.CATEGORY_DIM_IDS, -11, Integer.MIN_VALUE, Integer.MAX_VALUE, "");
        abandonedCavesDimID = config.getInt("Abandoned Caves ID", this.CATEGORY_DIM_IDS, -12, Integer.MIN_VALUE, Integer.MAX_VALUE, "");
        mutationDimID = config.getInt("Mutation ID", this.CATEGORY_DIM_IDS, -13, Integer.MIN_VALUE, Integer.MAX_VALUE, "");
        farVoidDimID = config.getInt("Far Void ID", this.CATEGORY_DIM_IDS, -14, Integer.MIN_VALUE, Integer.MAX_VALUE, "");
        
        forgottenDimID = config.getInt("Forgotten ID", this.CATEGORY_DIM_IDS, -15, Integer.MIN_VALUE, Integer.MAX_VALUE, "");
        evilDimID = config.getInt("Evil ID", this.CATEGORY_DIM_IDS, -16, Integer.MIN_VALUE, Integer.MAX_VALUE, "");
        finalLabyrinthDimID = config.getInt("Final Labyrinth ID", this.CATEGORY_DIM_IDS, -17, Integer.MIN_VALUE, Integer.MAX_VALUE, "");
        
        //------------------
        
        config.addCustomCategoryComment("biome ids", "Biome IDs");
        
        dropBiomeID = config.getInt("Drop Biome ID", this.CATEGORY_BIOME_IDS, 170, 0, 65536, "");
        mazeBiomeID = config.getInt("Maze Biome ID", this.CATEGORY_BIOME_IDS, 171, 0, 65536, "");
        crystalBiomeID = config.getInt("Crystal Biome ID", this.CATEGORY_BIOME_IDS, 172, 0, 65536, "");
        compressedBiomeID = config.getInt("Compressed Biome ID", this.CATEGORY_BIOME_IDS, 173, 0, 65536, "");
        bedrockPlainsBiomeID = config.getInt("Bedrock Plains Biome ID", this.CATEGORY_BIOME_IDS, 174, 0, 65536, "");
        
        nearNetherBiomeID = config.getInt("Near Nether Biome ID", this.CATEGORY_BIOME_IDS, 175, 0, 65536, "");
        nearNetherBasaltBiomeID = config.getInt("Near Nether Basalt Biome ID", this.CATEGORY_BIOME_IDS, 187, 0, 65536, "");
        lavaBiomeID = config.getInt("Lava Biome ID", this.CATEGORY_BIOME_IDS, 176, 0, 65536, "");
        nearVoidBiomeID = config.getInt("Near Void Biome ID", this.CATEGORY_BIOME_IDS, 177, 0, 65536, "");
        
        deepWorldBiomeID = config.getInt("Deep World Biome ID", this.CATEGORY_BIOME_IDS, 178, 0, 65536, "");
        darknessBiomeID = config.getInt("Darkness Biome ID", this.CATEGORY_BIOME_IDS, 179, 0, 65536, "");
        abandonedCavesBiomeID = config.getInt("Abandoned Caves Biome ID", this.CATEGORY_BIOME_IDS, 180, 0, 65536, "");
        mutationBiomeID = config.getInt("Mutation Biome ID", this.CATEGORY_BIOME_IDS, 181, 0, 65536, "");
        farVoidBiomeID = config.getInt("Far Void Biome ID", this.CATEGORY_BIOME_IDS, 182, 0, 65536, "");
        
        forgottenBiomeID = config.getInt("Forgotten Biome ID", this.CATEGORY_BIOME_IDS, 183, 0, 65536, "");
        evilBiomeID = config.getInt("Evil Biome ID", this.CATEGORY_BIOME_IDS, 184, 0, 65536, "");
        finalLabyrinthBiomeID = config.getInt("Final Labyrinth Biome ID", this.CATEGORY_BIOME_IDS, 185, 0, 65536, "");
        finalLabyrinthSculkBiomeID = config.getInt("Final Labyrinth Sculk Biome ID", this.CATEGORY_BIOME_IDS, 186, 0, 65536, "");

        //------------------

        config.addCustomCategoryComment("fog colors", "Fog Colors");

        dropFogColorStr = config.getString("Drop Fog Color", this.CATEGORY_FOG_COLORS, "0x202020", "", hexColor);
        mazeFogColorStr = config.getString("Maze Fog Color", this.CATEGORY_FOG_COLORS, "0x202020", "", hexColor);
        crystalFogColorStr = config.getString("Crystal Fog Color", this.CATEGORY_FOG_COLORS, "0x202020", "", hexColor);
        compressedFogColorStr = config.getString("Compressed Fog Color", this.CATEGORY_FOG_COLORS, "0x202020", "", hexColor);
        bedrockPlainsFogColorStr = config.getString("Bedrock Plains Fog Color", this.CATEGORY_FOG_COLORS, "0x202020", "", hexColor);

        nearNetherFogColorStr = config.getString("Near Nether Fog Color", this.CATEGORY_FOG_COLORS, "0x202020", "", hexColor);
        lavaFogColorStr = config.getString("Lava Fog Color", this.CATEGORY_FOG_COLORS, "0x202020", "", hexColor);
        nearVoidFogColorStr = config.getString("Near Void Fog Color", this.CATEGORY_FOG_COLORS, "0x202020", "", hexColor);

        deepWorldFogColorStr = config.getString("Deep World Fog Color", this.CATEGORY_FOG_COLORS, "0x202020", "", hexColor);
        darknessFogColorStr = config.getString("Darkness Fog Color", this.CATEGORY_FOG_COLORS, "0x202020", "", hexColor);
        abandonedCavesFogColorStr = config.getString("Abandoned Caves Fog Color", this.CATEGORY_FOG_COLORS, "0x202020", "", hexColor);
        mutationFogColorStr = config.getString("Mutation Fog Color", this.CATEGORY_FOG_COLORS, "0x202020", "", hexColor);
        farVoidFogColorStr = config.getString("Far Void Fog Color", this.CATEGORY_FOG_COLORS, "0x202020", "", hexColor);

        forgottenFogColorStr = config.getString("Forgotten Fog Color", this.CATEGORY_FOG_COLORS, "0x202020", "", hexColor);
        evilFogColorStr = config.getString("Evil Fog Color", this.CATEGORY_FOG_COLORS, "0x202020", "", hexColor);
        finalLabyrinthFogColorStr = config.getString("Final Labyrinth Fog Color", this.CATEGORY_FOG_COLORS, "0x202020", "", hexColor);

        dropFogColor = colorFromHex(dropFogColorStr);
        mazeFogColor = colorFromHex(mazeFogColorStr);
        crystalFogColor = colorFromHex(crystalFogColorStr);
        compressedFogColor = colorFromHex(compressedFogColorStr);
        bedrockPlainsFogColor = colorFromHex(bedrockPlainsFogColorStr);
        
        nearNetherFogColor = colorFromHex(nearNetherFogColorStr);
        lavaFogColor = colorFromHex(lavaFogColorStr);
        nearVoidFogColor = colorFromHex(nearVoidFogColorStr);

        deepWorldFogColor = colorFromHex(deepWorldFogColorStr);
        darknessFogColor = colorFromHex(darknessFogColorStr);
        abandonedCavesFogColor = colorFromHex(abandonedCavesFogColorStr);
        mutationFogColor = colorFromHex(mutationFogColorStr);
        farVoidFogColor = colorFromHex(farVoidFogColorStr);

        forgottenFogColor = colorFromHex(forgottenFogColorStr);
        evilFogColor = colorFromHex(evilFogColorStr);
        finalLabyrinthFogColor = colorFromHex(finalLabyrinthFogColorStr);

        //------------------
        
        config.addCustomCategoryComment("entity ids", "Entity IDs");
        
        DeeperCaves.mobs.deepZombieID = config.getInt("Deep World Zombie Entity ID", this.CATEGORY_ENTITY_IDS, 102, 0, 32768, "");
        DeeperCaves.mobs.deepSkeletonID = config.getInt("Deep World Skeleton Entity ID", this.CATEGORY_ENTITY_IDS, 103, 0, 32768, "");
        DeeperCaves.mobs.deepCaveSpiderID = config.getInt("Deep World Cave Spider Entity ID", this.CATEGORY_ENTITY_IDS, 104, 0, 32768, "");
        DeeperCaves.mobs.deepCreeperID = config.getInt("Deep World Creeper Entity ID", this.CATEGORY_ENTITY_IDS, 105, 0, 32768, "");
        
        DeeperCaves.mobs.mutatedZombieID = config.getInt("Mutated Zombie Entity ID", this.CATEGORY_ENTITY_IDS, 106, 0, 32768, "");
        DeeperCaves.mobs.mutatedSkeletonID = config.getInt("Mutated Skeleton Entity ID", this.CATEGORY_ENTITY_IDS, 107, 0, 32768, "");
        DeeperCaves.mobs.mutatedCaveSpiderID = config.getInt("Mutated Cave Spider Entity ID", this.CATEGORY_ENTITY_IDS, 108, 0, 32768, "");
        DeeperCaves.mobs.mutatedCreeperID = config.getInt("Mutated Creeper Entity ID", this.CATEGORY_ENTITY_IDS, 109, 0, 32768, "");
        
        DeeperCaves.mobs.shadowID = config.getInt("Shadow Entity ID", this.CATEGORY_ENTITY_IDS, 110, 0, 32768, "");
        
        //------------------
        
        config.addCustomCategoryComment("other", "Other");
        
        bedrockPlainsFloorHeight = config.getInt("Bedrock Plains Floor Height", this.CATEGORY_OTHER, 32, 1, 255, "");
        bedrockPlainsCeilingHeight = config.getInt("Bedrock Plains Ceiling Height", this.CATEGORY_OTHER, 52, 0, 255, "This is the height of the level barrier. The bedrock ceiling extends about 5 blocks below this.");

        bedrockRemovalType = config.getInt("Bedrock Removal Type", this.CATEGORY_OTHER, 0, 0, 3, "This is the method used for Overworld bedrock removal. 0=replace all bedrock with stone (default), 1=replace patches of bedrock with stone, 2=replace patches of bedrock with fragmented bedrock, 3=do not alter the bedrock layer");

        config.save();
    }
}

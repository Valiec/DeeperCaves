package com.kpabr.DeeperCaves;

import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.BiomeGenBase;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.VillagerRegistry;

public class DeeperMobs {
    public void setupMobs()
    {
        /*Registering mobs*/
        EntityRegistry.registerGlobalEntityID(EntityDeepZombie.class, "deepZombie", 102, 0x007A7A, 0x365226); //*
        EntityRegistry.addSpawn(EntityDeepZombie.class, 100, 4, 4, EnumCreatureType.monster, DeeperCaves.worldgen.biomeDeepWorld);
        EntityRegistry.registerGlobalEntityID(EntityDeepSkeleton.class, "deepSkeleton", 103, 0x7A7A7A, 0x000000);
        EntityRegistry.addSpawn(EntityDeepSkeleton.class, 100, 4, 4, EnumCreatureType.monster, DeeperCaves.worldgen.biomeDeepWorld);
        EntityRegistry.registerGlobalEntityID(EntityDeepCaveSpider.class, "deepCaveSpider", 104, 0x00040F, 0x4B0000);
        EntityRegistry.addSpawn(EntityDeepCaveSpider.class, 100, 4, 4, EnumCreatureType.monster, DeeperCaves.worldgen.biomeDeepWorld);
        EntityRegistry.registerGlobalEntityID(EntityDeepCreeper.class, "deepCreeper", 105, 0x006200, 0x000000);
        EntityRegistry.addSpawn(EntityDeepCreeper.class, 100, 4, 4, EnumCreatureType.monster, DeeperCaves.worldgen.biomeDeepWorld);
        
    }
}

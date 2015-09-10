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
        EntityRegistry.registerGlobalEntityID(EntityDeepZombie.class, "Deep World Zombie", 102, 0x000000, 0x5555FF);
        EntityRegistry.addSpawn(EntityDeepZombie.class, 100, 4, 4, EnumCreatureType.monster, DeeperCaves.worldgen.biomeDeepWorld);
        EntityRegistry.registerGlobalEntityID(EntityDeepSkeleton.class, "Deep World Skeleton", 103, 0x000000, 0x5555FF);
        EntityRegistry.addSpawn(EntityDeepSkeleton.class, 100, 4, 4, EnumCreatureType.monster, DeeperCaves.worldgen.biomeDeepWorld);
        EntityRegistry.registerGlobalEntityID(EntityDeepCaveSpider.class, "Deep World Cave Spider", 104, 0x000000, 0x5555FF);
        EntityRegistry.addSpawn(EntityDeepCaveSpider.class, 100, 4, 4, EnumCreatureType.monster, DeeperCaves.worldgen.biomeDeepWorld);
        EntityRegistry.registerGlobalEntityID(EntityDeepCreeper.class, "Deep World Creeper", 105, 0x000000, 0x5555FF);
        EntityRegistry.addSpawn(EntityDeepCreeper.class, 100, 4, 4, EnumCreatureType.monster, DeeperCaves.worldgen.biomeDeepWorld);
        
    }
}

package com.kpabr.DeeperCaves;

import com.kpabr.DeeperCaves.entity.EntityDeepCaveSpider;
import com.kpabr.DeeperCaves.entity.EntityDeepCreeper;
import com.kpabr.DeeperCaves.entity.EntityDeepSkeleton;
import com.kpabr.DeeperCaves.entity.EntityDeepZombie;
import com.kpabr.DeeperCaves.entity.EntityMutatedCaveSpider;
import com.kpabr.DeeperCaves.entity.EntityMutatedCreeper;
import com.kpabr.DeeperCaves.entity.EntityMutatedSkeleton;
import com.kpabr.DeeperCaves.entity.EntityMutatedZombie;
import com.kpabr.DeeperCaves.entity.EntityShadow;

import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.BiomeGenBase;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.VillagerRegistry;

public class DeeperMobs {
	
	public int deepZombieID;
	public int deepSkeletonID;
	public int deepCreeperID;
	public int deepCaveSpiderID;
	
	public int mutatedZombieID;
	public int mutatedSkeletonID;
	public int mutatedCreeperID;
	public int mutatedCaveSpiderID;
	
	public int shadowID;
	
    public void setupMobs()
    {
        /*Registering mobs*/
        EntityRegistry.registerGlobalEntityID(EntityDeepZombie.class, "deepZombie", this.deepZombieID, 0x007A7A, 0x365226); //*
        EntityRegistry.addSpawn(EntityDeepZombie.class, 100, 4, 4, EnumCreatureType.monster, DeeperCaves.worldgen.biomeDeepWorld);
        EntityRegistry.registerGlobalEntityID(EntityDeepSkeleton.class, "deepSkeleton", this.deepSkeletonID, 0x8A8A8A, 0x0A0A0A);
        EntityRegistry.addSpawn(EntityDeepSkeleton.class, 100, 4, 4, EnumCreatureType.monster, DeeperCaves.worldgen.biomeDeepWorld);
        EntityRegistry.registerGlobalEntityID(EntityDeepCaveSpider.class, "deepCaveSpider", this.deepCaveSpiderID, 0x00141F, 0x5B0000);
        EntityRegistry.addSpawn(EntityDeepCaveSpider.class, 100, 4, 4, EnumCreatureType.monster, DeeperCaves.worldgen.biomeDeepWorld);
        EntityRegistry.registerGlobalEntityID(EntityDeepCreeper.class, "deepCreeper", this.deepCreeperID, 0x007200, 0x000000);
        EntityRegistry.addSpawn(EntityDeepCreeper.class, 100, 4, 4, EnumCreatureType.monster, DeeperCaves.worldgen.biomeDeepWorld);
        
        EntityRegistry.registerGlobalEntityID(EntityMutatedCaveSpider.class, "mutatedCaveSpider", this.mutatedCaveSpiderID, 0x00141F, 0x5B0000);
        EntityRegistry.addSpawn(EntityMutatedCaveSpider.class, 100, 4, 4, EnumCreatureType.monster, DeeperCaves.worldgen.biomeMutation);
        EntityRegistry.registerGlobalEntityID(EntityMutatedZombie.class, "mutatedZombie", this.mutatedZombieID, 0x007A7A, 0x365226);
        EntityRegistry.addSpawn(EntityMutatedZombie.class, 100, 4, 4, EnumCreatureType.monster, DeeperCaves.worldgen.biomeMutation);
        EntityRegistry.registerGlobalEntityID(EntityMutatedSkeleton.class, "mutatedSkeleton", this.mutatedSkeletonID, 0x8A8A8A, 0x0A0A0A);
        EntityRegistry.addSpawn(EntityMutatedSkeleton.class, 100, 4, 4, EnumCreatureType.monster, DeeperCaves.worldgen.biomeMutation);
        EntityRegistry.registerGlobalEntityID(EntityMutatedCreeper.class, "mutatedCreeper", this.mutatedCreeperID, 0x007200, 0x000000);
        EntityRegistry.addSpawn(EntityMutatedCreeper.class, 100, 4, 4, EnumCreatureType.monster, DeeperCaves.worldgen.biomeMutation);
        
        EntityRegistry.registerGlobalEntityID(EntityShadow.class, "Shadow", this.shadowID, 0x050505, 0x7C0000);
        EntityRegistry.addSpawn(EntityShadow.class, 100, 4, 4, EnumCreatureType.monster, DeeperCaves.worldgen.biomeForgotten);
        
        
    }
}

package com.kpabr.DeeperCaves.entity;

import cpw.mods.fml.relauncher.ReflectionHelper;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityCaveSpider;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeModContainer;

public class EntityMutatedCreeper extends EntityCreeper {

	public EntityMutatedCreeper(World p_i1745_1_) {
		super(p_i1745_1_);
        ReflectionHelper.setPrivateValue(EntityCreeper.class, this, 5, "explosionRadius");
	}
	protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(35.D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.275D);
    }

}

package com.kpabr.DeeperCaves.entity;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeModContainer;

public class EntityDeepZombie extends EntityZombie {

	public EntityDeepZombie(World p_i1745_1_) {
		super(p_i1745_1_);
		// TODO Auto-generated constructor stub
	}
	protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(35.0D);
    }

}

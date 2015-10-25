package com.kpabr.DeeperCaves.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityCaveSpider;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeModContainer;

public class EntityDeepCaveSpider extends EntitySpider {

	public EntityDeepCaveSpider(World p_i1745_1_) {
		super(p_i1745_1_);
		// TODO Auto-generated constructor stub
	}
	protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(21.0D);
    }
	@Override
	public boolean attackEntityAsMob(Entity p_70652_1_)
    {
        if (super.attackEntityAsMob(p_70652_1_))
        {
            if (p_70652_1_ instanceof EntityLivingBase)
            {
                byte b0 = 0;

                if (this.worldObj.difficultySetting == EnumDifficulty.NORMAL)
                {
                    b0 = 7;
                }
                else if (this.worldObj.difficultySetting == EnumDifficulty.HARD)
                {
                    b0 = 15;
                }

                if (b0 > 0)
                {
                    ((EntityLivingBase)p_70652_1_).addPotionEffect(new PotionEffect(Potion.poison.id, b0 * 20, 0));
                }
            }

            return true;
        }
        else
        {
            return false;
        }
    }

}

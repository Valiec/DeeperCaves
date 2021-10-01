package com.kpabr.DeeperCaves.entity;

import java.util.Calendar;

import com.kpabr.DeeperCaves.entity.ai.EntityAIShadowTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.MathHelper;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import java.util.Random;

import com.kpabr.DeeperCaves.DeeperCaves;
/*
 * Created by Valiec2019
 * on February 18, 2014
 * using Minecraft Forge 10.12.0.1022
 */
public class EntityShadow extends EntityMob
{
	
    private String texture;
	private double moveSpeed;
	private float num;

	public EntityShadow(World par1World)
    {
        super(par1World);
        Random rand = new Random();
        this.num = 1;//Float.parseFloat(Double.toString(((rand.nextInt(5))/2.0)));
        this.setSize(((1.0F)*(this.num)), (2.0F*this.num));
        this.moveSpeed = 0.58D/this.num;
        this.tasks.addTask(0, new EntityAISwimming(this));
        //this.tasks.addTask(1, new EntityAIBreakDoor(this));
        this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityPlayer.class, this.moveSpeed, true));
        this.tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        this.tasks.addTask(4, new EntityAIWander(this, this.moveSpeed));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
        this.targetTasks.addTask(2, new EntityAIShadowTarget(this, EntityPlayer.class, 0, true));
    }



	/**
     * Get this Entity's EnumCreatureAttribute
     */
	@Override
    public EnumCreatureAttribute getCreatureAttribute()
    {
        return EnumCreatureAttribute.UNDEAD;
    }
	public IEntityLivingData onSpawnWithEgg(IEntityLivingData p_110161_1_)
    {
        p_110161_1_ = super.onSpawnWithEgg(p_110161_1_);

        this.setCanPickUpLoot(this.rand.nextFloat() < 0.55F * this.worldObj.func_147462_b(this.posX, this.posY, this.posZ));

        if (this.getEquipmentInSlot(4) == null)
        {
            Calendar calendar = this.worldObj.getCurrentDate();

            if (calendar.get(2) + 1 == 10 && calendar.get(5) == 31 && this.rand.nextFloat() < 0.25F)
            {
                this.setCurrentItemOrArmor(4, new ItemStack(this.rand.nextFloat() < 0.1F ? Blocks.lit_pumpkin : Blocks.pumpkin));
                this.equipmentDropChances[4] = 0.0F;
            }
        }

        return p_110161_1_;
    }

	@Override
	protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(100.0D);
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(16.0D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.32D);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(4.0D);
    }
	@Override
	protected boolean isAIEnabled()
	{
    
        return true;
    }
	@Override
	public boolean attackEntityAsMob(Entity p_70652_1_)
    {
    	if(DeeperCaves.deepFlag.get(p_70652_1_.getUniqueID())) //cancel with proper item (CHANGE ITEM VOID CHARM IS WRONG ITEM)
    	{
    		return false;
    	}
        if (super.attackEntityAsMob(p_70652_1_))
        {
            if (p_70652_1_ instanceof EntityLivingBase)
            {
                byte b0 = 0;

                if (this.worldObj.difficultySetting == EnumDifficulty.NORMAL)
                {
                    b0 = 4;
                }
                else if (this.worldObj.difficultySetting == EnumDifficulty.HARD)
                {
                    b0 = 9;
                }

                if (b0 > 0)
                {
                    ((EntityLivingBase)p_70652_1_).addPotionEffect(new PotionEffect(Potion.blindness.id, b0 * 20, 0));
                }
            }

            return true;
        }
        else
        {
            return false;
        }
    }
    @Override
    protected Item getDropItem()
    {
       
        return DeeperCaves.items.profundiumIngot;
    }
    @Override
    protected String getLivingSound()
    {
        return "mob.blaze.breathe";
    }
    @Override
    protected String getHurtSound()
    {
        return "mob.endermen.hit";
    }
    @Override
    protected String getDeathSound()
    {
        return "mob.spider.death";
    }
    @Override
    protected float getSoundVolume()
    {
    	return 0.5F;
    }
}

    


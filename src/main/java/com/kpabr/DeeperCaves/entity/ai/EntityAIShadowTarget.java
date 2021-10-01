package com.kpabr.DeeperCaves.entity.ai;

import com.kpabr.DeeperCaves.DeeperCaves;
import cpw.mods.fml.relauncher.ReflectionHelper;
import net.minecraft.command.IEntitySelector;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.player.EntityPlayer;

import java.rmi.server.UID;
import java.util.UUID;

public class EntityAIShadowTarget extends EntityAINearestAttackableTarget {


    public EntityAIShadowTarget(EntityCreature p_i1663_1_, Class p_i1663_2_, int p_i1663_3_, boolean p_i1663_4_) {
        super(p_i1663_1_, p_i1663_2_, p_i1663_3_, p_i1663_4_);

        IEntitySelector targetEntitySelector = new IEntitySelector()
        {
            private static final String __OBFID = "CL_00001621";
            /**
             * Return whether the specified entity is applicable to this filter.
             */
            public boolean isEntityApplicable(Entity p_82704_1_)
            {
                if(!(p_82704_1_ instanceof EntityLivingBase))
                {
                    return false;
                }
                else if((p_82704_1_ instanceof EntityPlayer))
                {
                    UUID id = ((EntityPlayer)p_82704_1_).getUniqueID();
                    Boolean flag = DeeperCaves.instance.deepFlag.get(id);
                    if(flag == null || !flag)
                    {
                        return (EntityAIShadowTarget.this.isSuitableTarget((EntityLivingBase) p_82704_1_, false));
                    }
                    else
                    {
                        return false;
                    }
                }
                else
                {
                    return (EntityAIShadowTarget.this.isSuitableTarget((EntityLivingBase) p_82704_1_, false));
                }
            }
        };

        ReflectionHelper.setPrivateValue(EntityAINearestAttackableTarget.class, this, targetEntitySelector, "targetEntitySelector");
    }
}

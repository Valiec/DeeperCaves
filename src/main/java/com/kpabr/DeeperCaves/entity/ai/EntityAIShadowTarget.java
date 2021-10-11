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


    public EntityAIShadowTarget(EntityCreature entity, Class entityClass, int i, boolean b) {
        super(entity, entityClass, i, b);

        IEntitySelector targetEntitySelector = new IEntitySelector()
        {
            public boolean isEntityApplicable(Entity e)
            {
                if(!(e instanceof EntityLivingBase))
                {
                    return false;
                }
                else if((e instanceof EntityPlayer))
                {
                    UUID id = ((EntityPlayer)e).getUniqueID();
                    Boolean flag = DeeperCaves.instance.deepFlag.get(id);
                    if(flag == null || !flag)
                    {
                        return (EntityAIShadowTarget.this.isSuitableTarget((EntityLivingBase) e, false));
                    }
                    else
                    {
                        return false;
                    }
                }
                else
                {
                    return (EntityAIShadowTarget.this.isSuitableTarget((EntityLivingBase) e, false));
                }
            }
        };

        ReflectionHelper.setPrivateValue(EntityAINearestAttackableTarget.class, this, targetEntitySelector, "targetEntitySelector");
    }
}

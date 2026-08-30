package com.kpabr.DeeperCaves.entity.ai;

import com.kpabr.DeeperCaves.DeeperCaves;
import com.kpabr.DeeperCaves.DeeperCavesExtendedPlayerData;
import cpw.mods.fml.relauncher.ReflectionHelper;
import net.minecraft.command.IEntitySelector;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.player.EntityPlayer;

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
                    boolean flag = false;

                    DeeperCavesExtendedPlayerData extData = (DeeperCavesExtendedPlayerData) e.getExtendedProperties(DeeperCavesExtendedPlayerData.NAME);
                    if(extData != null) {
                        flag = extData.forgottenCharm();
                    }

                    if(flag)
                    {
                        return false;
                    }
                    else
                    {
                        return (EntityAIShadowTarget.this.isSuitableTarget((EntityLivingBase) e, false));
                    }
                }
                else
                {
                    return (EntityAIShadowTarget.this.isSuitableTarget((EntityLivingBase) e, false));
                }
            }
        };
        ReflectionHelper.setPrivateValue(EntityAINearestAttackableTarget.class, this, targetEntitySelector, "targetEntitySelector", "field_82643_g");
    }
}

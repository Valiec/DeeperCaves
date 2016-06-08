package com.kpabr.DeeperCaves.item;

import com.kpabr.DeeperCaves.DeeperCaves;

import cpw.mods.fml.common.eventhandler.Event;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBucket;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.FillBucketEvent;

public class ItemFragmentedBedrockBucket extends ItemBucket {
	
    private Block isFull;

	public ItemFragmentedBedrockBucket(Block p_i45331_1_) {
		super(p_i45331_1_);
		this.isFull = p_i45331_1_;
	}
    /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    public ItemStack onItemRightClick(ItemStack p_77659_1_, World p_77659_2_, EntityPlayer p_77659_3_)
    {
        boolean flag = this.isFull == Blocks.air;
        MovingObjectPosition movingobjectposition = this.getMovingObjectPositionFromPlayer(p_77659_2_, p_77659_3_, flag);

        if (movingobjectposition == null)
        {
            return p_77659_1_;
        }
        else
        {
            FillBucketEvent event = new FillBucketEvent(p_77659_3_, p_77659_1_, p_77659_2_, movingobjectposition);
            if (MinecraftForge.EVENT_BUS.post(event))
            {
                return p_77659_1_;
            }
            if (event.getResult() == Event.Result.ALLOW)
            {
                if (p_77659_3_.capabilities.isCreativeMode)
                {
                    return p_77659_1_;
                }

                if (--p_77659_1_.stackSize <= 0)
                {
                    return event.result;
                }

                if (!p_77659_3_.inventory.addItemStackToInventory(event.result))
                {
                    p_77659_3_.dropPlayerItemWithRandomChoice(event.result, false);
                }

                return p_77659_1_;
            }
            if (movingobjectposition.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK)
            {
                int i = movingobjectposition.blockX;
                int j = movingobjectposition.blockY;
                int k = movingobjectposition.blockZ;

                if (!p_77659_2_.canMineBlock(p_77659_3_, i, j, k))
                {
                    return p_77659_1_;
                }

                if (flag)
                {
                    if (!p_77659_3_.canPlayerEdit(i, j, k, movingobjectposition.sideHit, p_77659_1_))
                    {
                        return p_77659_1_;
                    }

                    Material material = p_77659_2_.getBlock(i, j, k).getMaterial();
                    int l = p_77659_2_.getBlockMetadata(i, j, k);

                    if (material == Material.water && l == 0)
                    {
                        p_77659_2_.setBlockToAir(i, j, k);
                        return this.func_150910_a(p_77659_1_, p_77659_3_, DeeperCaves.items.fragmentedBedrockBucketW);
                    }
                    
                    if (material == DeeperCaves.materials.moltenIron && l == 0)
                    {
                        p_77659_2_.setBlockToAir(i, j, k);
                        return this.func_150910_a(p_77659_1_, p_77659_3_, DeeperCaves.items.fragmentedBedrockBucketMI);
                    }

                    if (material == Material.lava && l == 0)
                    {
                        p_77659_2_.setBlockToAir(i, j, k);
                        return this.func_150910_a(p_77659_1_, p_77659_3_, DeeperCaves.items.fragmentedBedrockBucketL);
                    }
                }
                else
                {
                    if (this.isFull == Blocks.air)
                    {
                        return new ItemStack(DeeperCaves.items.fragmentedBedrockBucket);
                    }

                    if (movingobjectposition.sideHit == 0)
                    {
                        --j;
                    }

                    if (movingobjectposition.sideHit == 1)
                    {
                        ++j;
                    }

                    if (movingobjectposition.sideHit == 2)
                    {
                        --k;
                    }

                    if (movingobjectposition.sideHit == 3)
                    {
                        ++k;
                    }

                    if (movingobjectposition.sideHit == 4)
                    {
                        --i;
                    }

                    if (movingobjectposition.sideHit == 5)
                    {
                        ++i;
                    }

                    if (!p_77659_3_.canPlayerEdit(i, j, k, movingobjectposition.sideHit, p_77659_1_))
                    {
                        return p_77659_1_;
                    }

                    if (this.tryPlaceContainedLiquid(p_77659_2_, i, j, k) && !p_77659_3_.capabilities.isCreativeMode)
                    {
                        return new ItemStack(DeeperCaves.items.fragmentedBedrockBucket);
                    }
                }
            }

            return p_77659_1_;
        }
    }
    /*Same as ItemBucket's, included because it is private and ItemBucket's cannot be called from here*/
    private ItemStack func_150910_a(ItemStack p_150910_1_, EntityPlayer p_150910_2_, Item p_150910_3_)
    {
        if (p_150910_2_.capabilities.isCreativeMode)
        {
            return p_150910_1_;
        }
        else if (--p_150910_1_.stackSize <= 0)
        {
            return new ItemStack(p_150910_3_);
        }
        else
        {
            if (!p_150910_2_.inventory.addItemStackToInventory(new ItemStack(p_150910_3_)))
            {
                p_150910_2_.dropPlayerItemWithRandomChoice(new ItemStack(p_150910_3_, 1, 0), false);
            }

            return p_150910_1_;
        }
    }

}

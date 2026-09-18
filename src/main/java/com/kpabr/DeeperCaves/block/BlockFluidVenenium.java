package com.kpabr.DeeperCaves.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;

public class BlockFluidVenenium extends BlockFluidClassic {
	
	public Fluid fluid;
	private IIcon still;
	private IIcon flow;

	public BlockFluidVenenium(Fluid fluid, Material material) {
		super(fluid, material);
		this.fluid = fluid;
		this.opaque = false;
		this.displacements.put(Blocks.water, false);
		this.displacements.put(Blocks.flowing_water, false);
		this.displacements.put(Blocks.lava, false);
		this.displacements.put(Blocks.flowing_lava, false);
		// TODO Auto-generated constructor stub
	}
	@Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
		this.still = iconRegister.registerIcon("DeeperCaves:venenium_still");
		this.flow = iconRegister.registerIcon("DeeperCaves:venenium_flow");
		this.getFluid().setIcons(this.still, this.flow);
    }
	@Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int i, int j)
    {
            if (i <= 1)
            {
                    return this.still;
            }
            else
            {
                    return this.flow;
            }
    }

	@Override
	public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity) {
		if(!world.isRemote && entity instanceof EntityLivingBase) {
			if(!((EntityLivingBase)entity).isPotionActive(Potion.poison)) {
				((EntityLivingBase)entity).addPotionEffect(new PotionEffect(Potion.poison.id, 100, 2));
			}
		}
	}

	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}

	@Override
	public boolean func_149698_L()
	{
		return true;
	}

}

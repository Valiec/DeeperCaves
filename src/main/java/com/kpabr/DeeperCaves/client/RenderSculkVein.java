package com.kpabr.DeeperCaves.client;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;

public class RenderSculkVein implements ISimpleBlockRenderingHandler {

    public static int renderID = RenderingRegistry.getNextAvailableRenderId();

    @Override
    public void renderInventoryBlock(Block block, int metadata, int modelId, RenderBlocks renderer) {
        //do nothing
    }

    @Override
    public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
        //renderer.setRenderBounds(0.0D, 0.0D, 0.0D, 1.0D, 0.5D, 1.0D);
        Tessellator tessellator = Tessellator.instance;



        tessellator.setBrightness(block.getMixedBrightnessForBlock(world, x, y, z));
        tessellator.setColorOpaque_F(1.0F, 1.0F, 1.0F);

        int l = world.getBlockMetadata(x, y, z);

        IIcon iicon = block.getIcon(0, l);
        double d0 = (double)iicon.getMinU();
        double d1 = (double)iicon.getMinV();
        double d2 = (double)iicon.getMaxU();
        double d3 = (double)iicon.getMaxV();

        double d5 = 0.05D;

        // x -> u
        // z -> v
        // vertex order counterclockwise from rendered side

        tessellator.addVertexWithUV((double)(x + 0), (double)(y) + d5, (double)(z + 0), d0, d1);
        tessellator.addVertexWithUV((double)(x + 0), (double)(y) + d5, (double)(z + 1), d0, d3);
        tessellator.addVertexWithUV((double)(x + 1), (double)(y) + d5, (double)(z + 1), d2, d3);
        tessellator.addVertexWithUV((double)(x + 1), (double)(y) + d5, (double)(z + 0), d2, d1);


        return true;
    }

    @Override
    public boolean shouldRender3DInInventory(int modelId) {
        return false;
    }

    @Override
    public int getRenderId() {
        return renderID;
    }
}

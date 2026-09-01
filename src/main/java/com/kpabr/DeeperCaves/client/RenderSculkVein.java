package com.kpabr.DeeperCaves.client;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import org.lwjgl.opengl.GL11;

public class RenderSculkVein implements ISimpleBlockRenderingHandler {

    public static int renderID = RenderingRegistry.getNextAvailableRenderId();

    @Override
    public void renderInventoryBlock(Block block, int metadata, int modelId, RenderBlocks renderer) {
        Tessellator tessellator = Tessellator.instance;

        block.setBlockBoundsForItemRender();
        renderer.setRenderBounds(0.0D, 0.0D, 0.0D, 1.0D, 0.0625D, 1.0D);
        GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
        GL11.glTranslatef(-0.5F, -0.5F, -0.5F);

        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, 1.0F, 0.0F);
        renderer.renderFaceYPos(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata(block, 1, metadata));
        tessellator.draw();

        GL11.glTranslatef(0.5F, 0.5F, 0.5F);
    }

    @Override
    public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
        //renderer.setRenderBounds(0.0D, 0.0D, 0.0D, 1.0D, 0.5D, 1.0D);
        Tessellator tessellator = Tessellator.instance;



        tessellator.setBrightness(block.getMixedBrightnessForBlock(world, x, y, z));
        tessellator.setColorOpaque_F(1.0F, 1.0F, 1.0F);

        int l = world.getBlockMetadata(x, y, z);

        IIcon iicon = block.getIcon(0, l);

        double d5 = 0.0625D;

        // x -> u
        // z -> v
        // vertex order counterclockwise from rendered side

        if(world.getBlock(x, y-1, z).isBlockNormalCube()) {
            tessellator.addVertexWithUV((double) (x), (double) (y + d5), (double) (z), iicon.getMinU(), iicon.getMinV());
            tessellator.addVertexWithUV((double) (x), (double) (y + d5), (double) (z + 1), iicon.getMinU(), iicon.getMaxV());
            tessellator.addVertexWithUV((double) (x + 1), (double) (y + d5), (double) (z + 1), iicon.getMaxU(), iicon.getMaxV());
            tessellator.addVertexWithUV((double) (x + 1), (double) (y + d5), (double) (z), iicon.getMaxU(), iicon.getMinV());
        }

        if(world.getBlock(x, y+1, z).isBlockNormalCube()) {
            tessellator.addVertexWithUV((double) (x + 1), (double) (y + 1 - d5), (double) (z), iicon.getMaxU(), iicon.getMaxV());
            tessellator.addVertexWithUV((double) (x + 1), (double) (y + 1 - d5), (double) (z + 1), iicon.getMaxU(), iicon.getMinV());
            tessellator.addVertexWithUV((double) (x), (double) (y + 1 - d5), (double) (z + 1), iicon.getMinU(), iicon.getMinV());
            tessellator.addVertexWithUV((double) (x), (double) (y + 1 - d5), (double) (z), iicon.getMinU(), iicon.getMaxV());
        }

        if(world.getBlock(x-1, y, z).isBlockNormalCube()) {
            tessellator.addVertexWithUV((double) (x + d5), (double) (y + 1), (double) (z), iicon.getMaxU(), iicon.getMinV());
            tessellator.addVertexWithUV((double) (x + d5), (double) (y + 1), (double) (z + 1), iicon.getMinU(), iicon.getMinV());
            tessellator.addVertexWithUV((double) (x + d5), (double) (y), (double) (z + 1), iicon.getMinU(), iicon.getMaxV());
            tessellator.addVertexWithUV((double) (x + d5), (double) (y), (double) (z), iicon.getMaxU(), iicon.getMaxV());
        }

        if(world.getBlock(x+1, y, z).isBlockNormalCube()) {
            tessellator.addVertexWithUV((double) (x + 1 - d5), (double) (y), (double) (z), iicon.getMinU(), iicon.getMaxV());
            tessellator.addVertexWithUV((double) (x + 1 - d5), (double) (y), (double) (z + 1), iicon.getMaxU(), iicon.getMaxV());
            tessellator.addVertexWithUV((double) (x + 1 - d5), (double) (y + 1), (double) (z + 1), iicon.getMaxU(), iicon.getMinV());
            tessellator.addVertexWithUV((double) (x + 1 - d5), (double) (y + 1), (double) (z), iicon.getMinU(), iicon.getMinV());
        }


        if(world.getBlock(x, y, z-1).isBlockNormalCube()) {
            tessellator.addVertexWithUV((double) (x), (double) (y), (double) (z + d5), iicon.getMinU(), iicon.getMaxV());
            tessellator.addVertexWithUV((double) (x + 1), (double) (y), (double) (z + d5), iicon.getMaxU(), iicon.getMaxV());
            tessellator.addVertexWithUV((double) (x + 1), (double) (y + 1), (double) (z + d5), iicon.getMaxU(), iicon.getMinV());
            tessellator.addVertexWithUV((double) (x), (double) (y + 1), (double) (z + d5), iicon.getMinU(), iicon.getMinV());
        }

        if(world.getBlock(x, y, z+1).isBlockNormalCube()) {
            tessellator.addVertexWithUV((double) (x), (double) (y + 1), (double) (z + 1 - d5), iicon.getMaxU(), iicon.getMinV());
            tessellator.addVertexWithUV((double) (x + 1), (double) (y + 1), (double) (z + 1 - d5), iicon.getMinU(), iicon.getMinV());
            tessellator.addVertexWithUV((double) (x + 1), (double) (y), (double) (z + 1 - d5), iicon.getMinU(), iicon.getMaxV());
            tessellator.addVertexWithUV((double) (x), (double) (y), (double) (z + 1 - d5), iicon.getMaxU(), iicon.getMaxV());
        }


        return true;
    }

    @Override
    public boolean shouldRender3DInInventory(int modelId) {
        return true;
    }

    @Override
    public int getRenderId() {
        return renderID;
    }
}

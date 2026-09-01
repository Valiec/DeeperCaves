package com.kpabr.DeeperCaves.client;

import com.kpabr.DeeperCaves.block.BlockSculkSensor;
import com.kpabr.DeeperCaves.block.BlockSculkShrieker;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import org.lwjgl.opengl.GL11;

public class RenderSculkShrieker implements ISimpleBlockRenderingHandler {

    public static int renderID = RenderingRegistry.getNextAvailableRenderId();

    @Override
    public void renderInventoryBlock(Block block, int metadata, int modelId, RenderBlocks renderer) {

        Tessellator tessellator = Tessellator.instance;

        block.setBlockBoundsForItemRender();
        renderer.setRenderBounds(0.0D, 0.0D, 0.0D, 1.0D, 0.5D, 1.0D);
        GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
        GL11.glTranslatef(-0.5F, -0.5F, -0.5F);


        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, -1.0F, 0.0F);
        renderer.renderFaceYNeg(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata(block, 0, metadata));
        tessellator.draw();
        
        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, 1.0F, 0.0F);
        renderer.renderFaceYPos(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata(block, 1, metadata));
        tessellator.draw();

        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, 0.0F, -1.0F);
        renderer.renderFaceZNeg(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata(block, 2, metadata));
        tessellator.draw();

        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, 0.0F, 1.0F);
        renderer.renderFaceZPos(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata(block, 3, metadata));
        tessellator.draw();

        tessellator.startDrawingQuads();
        tessellator.setNormal(-1.0F, 0.0F, 0.0F);
        renderer.renderFaceXNeg(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata(block, 4, metadata));
        tessellator.draw();

        tessellator.startDrawingQuads();
        tessellator.setNormal(1.0F, 0.0F, 0.0F);
        renderer.renderFaceXPos(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata(block, 5, metadata));
        tessellator.draw();

        tessellator.startDrawingQuads();
        renderShriekerUpper(block,0, 0, 0, tessellator);
        tessellator.draw();

        GL11.glTranslatef(0.5F, 0.5F, 0.5F);
    }

    @Override
    public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
        Tessellator tessellator = Tessellator.instance;

        tessellator.setBrightness(block.getMixedBrightnessForBlock(world, x, y, z));
        tessellator.setColorOpaque_F(1.0F, 1.0F, 1.0F);

        renderer.setRenderBounds(0.0D, 0.0D, 0.0D, 1.0D, 0.5D, 1.0D);
        renderer.renderStandardBlock(block, x, y, z);

        renderShriekerUpper(block, x, y, z, tessellator);
        

        return true;
    }

    public void renderShriekerUpper(Block block, int x, int y, int z, Tessellator tessellator) {

        // x -> u
        // z -> v
        // vertex order counterclockwise from rendered side
        IIcon side = ((BlockSculkShrieker)block).side;
        IIcon top = ((BlockSculkShrieker)block).top;

        float minU = side.getMinU();
        float minV = side.getMinV();

        float maxU = side.getMaxU();
        float fullMaxV = side.getMaxV();

        float maxV = fullMaxV - (fullMaxV-minV)/2.0F;

        double offset = 0.0625;


        //face 1
        tessellator.setNormal(0.0F, 0.0F, -1.0F);
        tessellator.addVertexWithUV((double)(x + 0), (double)(y + 0.5), (double)(z + offset), minU, maxV);
        tessellator.addVertexWithUV((double)(x + 0), (double)(y + 1), (double)(z + offset), minU, minV);
        tessellator.addVertexWithUV((double)(x + 1), (double)(y + 1), (double)(z + offset), maxU, minV);
        tessellator.addVertexWithUV((double)(x + 1), (double)(y + 0.5), (double)(z + offset), maxU, maxV);

        tessellator.setNormal(0.0F, 0.0F, 1.0F);
        tessellator.addVertexWithUV((double)(x + 1), (double)(y + 0.5), (double)(z + offset), maxU, maxV);
        tessellator.addVertexWithUV((double)(x + 1), (double)(y + 1), (double)(z + offset), maxU, minV);
        tessellator.addVertexWithUV((double)(x + 0), (double)(y + 1), (double)(z + offset), minU, minV);
        tessellator.addVertexWithUV((double)(x + 0), (double)(y + 0.5), (double)(z + offset), minU, maxV);

        //face 2
        tessellator.setNormal(0.0F, 0.0F, 1.0F);
        tessellator.addVertexWithUV((double)(x + 1), (double)(y + 0.5), (double)(z + 1 - offset), maxU, maxV);
        tessellator.addVertexWithUV((double)(x + 1), (double)(y + 1), (double)(z + 1 - offset), maxU, minV);
        tessellator.addVertexWithUV((double)(x + 0), (double)(y + 1), (double)(z + 1 - offset), minU, minV);
        tessellator.addVertexWithUV((double)(x + 0), (double)(y + 0.5), (double)(z + 1 - offset), minU, maxV);

        tessellator.setNormal(0.0F, 0.0F, -1.0F);
        tessellator.addVertexWithUV((double)(x + 0), (double)(y + 0.5), (double)(z + 1 - offset), minU, maxV);
        tessellator.addVertexWithUV((double)(x + 0), (double)(y + 1), (double)(z + 1 - offset), minU, minV);
        tessellator.addVertexWithUV((double)(x + 1), (double)(y + 1), (double)(z + 1 - offset), maxU, minV);
        tessellator.addVertexWithUV((double)(x + 1), (double)(y + 0.5), (double)(z + 1 - offset), maxU, maxV);

        //face 3
        tessellator.setNormal(-1.0F, 0.0F, 0.0F);
        tessellator.addVertexWithUV((double)(x + offset), (double)(y + 0.5), (double)(z + 1), maxU, maxV);
        tessellator.addVertexWithUV((double)(x + offset), (double)(y + 1), (double)(z + 1), maxU, minV);
        tessellator.addVertexWithUV((double)(x + offset), (double)(y + 1), (double)(z + 0), minU, minV);
        tessellator.addVertexWithUV((double)(x + offset), (double)(y + 0.5), (double)(z + 0), minU, maxV);

        tessellator.setNormal(1.0F, 0.0F, 0.0F);
        tessellator.addVertexWithUV((double)(x + offset), (double)(y + 0.5), (double)(z + 0), minU, maxV);
        tessellator.addVertexWithUV((double)(x + offset), (double)(y + 1), (double)(z + 0), minU, minV);
        tessellator.addVertexWithUV((double)(x + offset), (double)(y + 1), (double)(z + 1), maxU, minV);
        tessellator.addVertexWithUV((double)(x + offset), (double)(y + 0.5), (double)(z + 1), maxU, maxV);


        //face 4
        tessellator.setNormal(1.0F, 0.0F, 0.0F);
        tessellator.addVertexWithUV((double)(x + 1 - offset), (double)(y + 0.5), (double)(z + 0), minU, maxV);
        tessellator.addVertexWithUV((double)(x + 1 - offset), (double)(y + 1), (double)(z + 0), minU, minV);
        tessellator.addVertexWithUV((double)(x + 1 - offset), (double)(y + 1), (double)(z + 1), maxU, minV);
        tessellator.addVertexWithUV((double)(x + 1 - offset), (double)(y + 0.5), (double)(z + 1), maxU, maxV);

        tessellator.setNormal(-1.0F, 0.0F, 0.0F);
        tessellator.addVertexWithUV((double)(x + 1 - offset), (double)(y + 0.5), (double)(z + 1), maxU, maxV);
        tessellator.addVertexWithUV((double)(x + 1 - offset), (double)(y + 1), (double)(z + 1), maxU, minV);
        tessellator.addVertexWithUV((double)(x + 1 - offset), (double)(y + 1), (double)(z + 0), minU, minV);
        tessellator.addVertexWithUV((double)(x + 1 - offset), (double)(y + 0.5), (double)(z + 0), minU, maxV);



        //top
        tessellator.setNormal(0.0F, 1.0F, 0.0F);
        tessellator.addVertexWithUV((double)(x + 0), (double)(y + 1 - offset), (double)(z + 0), top.getMinU(), top.getMinV());
        tessellator.addVertexWithUV((double)(x + 0), (double)(y + 1 - offset), (double)(z + 1), top.getMinU(), top.getMaxV());
        tessellator.addVertexWithUV((double)(x + 1), (double)(y + 1 - offset), (double)(z + 1), top.getMaxU(), top.getMaxV());
        tessellator.addVertexWithUV((double)(x + 1), (double)(y + 1 - offset), (double)(z + 0), top.getMaxU(), top.getMinV());

        tessellator.setNormal(0.0F, -1.0F, 0.0F);
        tessellator.addVertexWithUV((double)(x + 1), (double)(y + 1 - offset), (double)(z + 0), top.getMaxU(), top.getMinV());
        tessellator.addVertexWithUV((double)(x + 1), (double)(y + 1 - offset), (double)(z + 1), top.getMaxU(), top.getMaxV());
        tessellator.addVertexWithUV((double)(x + 0), (double)(y + 1 - offset), (double)(z + 1), top.getMinU(), top.getMaxV());
        tessellator.addVertexWithUV((double)(x + 0), (double)(y + 1 - offset), (double)(z + 0), top.getMinU(), top.getMinV());

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

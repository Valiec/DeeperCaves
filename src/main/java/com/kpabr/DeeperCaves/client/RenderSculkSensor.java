package com.kpabr.DeeperCaves.client;

import com.kpabr.DeeperCaves.block.BlockSculkSensor;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import org.lwjgl.opengl.GL11;

public class RenderSculkSensor implements ISimpleBlockRenderingHandler {

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
        renderTendrils(block,0, 0, 0, tessellator);
        tessellator.draw();

        GL11.glTranslatef(0.5F, 0.5F, 0.5F);
    }

    @Override
    public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
        Tessellator tessellator = Tessellator.instance;

        // x -> u
        // z -> v
        // vertex order counterclockwise from rendered side

        tessellator.setBrightness(block.getMixedBrightnessForBlock(world, x, y, z));
        tessellator.setColorOpaque_F(1.0F, 1.0F, 1.0F);

        renderer.setRenderBounds(0.0D, 0.0D, 0.0D, 1.0D, 0.5D, 1.0D);
        renderer.renderStandardBlock(block, x, y, z);

        renderTendrils(block,x, y, z, tessellator);

        return true;
    }

    public void renderTendrils(Block block, int x, int y, int z, Tessellator tessellator) {

        IIcon iicon = ((BlockSculkSensor)block).tendrils;

        float minU = iicon.getMinU();
        float fullMinV = iicon.getMinV();

        float maxU = iicon.getMaxU();
        float maxV = iicon.getMaxV();

        float trueUWidth = (float) (Math.sqrt(0.5))*(maxU - minU);
        float uOffset = ((maxU - minU)/2.0F)-(trueUWidth/2.0F);
        float minV = fullMinV + (maxV-fullMinV)/2.0F;

        //tendril 1
        tessellator.setNormal((float) (Math.sqrt(0.5F)),0, (float) (-1.0F*Math.sqrt(0.5F)));
        tessellator.addVertexWithUV((double)(x), (double)(y + 0.5), (double)(z + 0.5), maxU-uOffset, maxV);
        tessellator.addVertexWithUV((double)(x), (double)(y + 1), (double)(z + 0.5), maxU-uOffset, minV);
        tessellator.addVertexWithUV((double)(x + 0.5) , (double)(y + 1), (double)(z + 1), minU+uOffset, minV);
        tessellator.addVertexWithUV((double)(x + 0.5), (double)(y + 0.5), (double)(z + 1), minU+uOffset, maxV);

        tessellator.setNormal((float) (-1.0F*Math.sqrt(0.5F)),0, (float) (Math.sqrt(0.5F)));
        tessellator.addVertexWithUV((double)(x + 0.5), (double)(y + 0.5), (double)(z + 1), maxU-uOffset, maxV);
        tessellator.addVertexWithUV((double)(x + 0.5) , (double)(y + 1), (double)(z + 1), maxU-uOffset, minV);
        tessellator.addVertexWithUV((double)(x), (double)(y + 1), (double)(z + 0.5), minU+uOffset, minV);
        tessellator.addVertexWithUV((double)(x), (double)(y + 0.5), (double)(z + 0.5), minU+uOffset, maxV);


        //tendril 2
        tessellator.setNormal((float) (-1.0F*Math.sqrt(0.5F)),0, (float) (Math.sqrt(0.5F)));
        tessellator.addVertexWithUV((double)(x + 1), (double)(y + 0.5), (double)(z + 0.5), minU+uOffset, maxV);
        tessellator.addVertexWithUV((double)(x + 1), (double)(y + 1), (double)(z + 0.5), minU+uOffset, minV);
        tessellator.addVertexWithUV((double)(x + 0.5) , (double)(y + 1), (double)(z), maxU-uOffset, minV);
        tessellator.addVertexWithUV((double)(x + 0.5), (double)(y + 0.5), (double)(z), maxU-uOffset, maxV);

        tessellator.setNormal((float) (Math.sqrt(0.5F)),0, (float) (-1.0F*Math.sqrt(0.5F)));
        tessellator.addVertexWithUV((double)(x + 0.5), (double)(y + 0.5), (double)(z), minU+uOffset, maxV);
        tessellator.addVertexWithUV((double)(x + 0.5) , (double)(y + 1), (double)(z), minU+uOffset, minV);
        tessellator.addVertexWithUV((double)(x + 1), (double)(y + 1), (double)(z + 0.5), maxU-uOffset, minV);
        tessellator.addVertexWithUV((double)(x + 1), (double)(y + 0.5), (double)(z + 0.5), maxU-uOffset, maxV);
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

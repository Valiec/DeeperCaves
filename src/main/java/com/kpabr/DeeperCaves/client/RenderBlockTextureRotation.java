package com.kpabr.DeeperCaves.client;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

public class RenderBlockTextureRotation implements ISimpleBlockRenderingHandler {

    public static int renderID = RenderingRegistry.getNextAvailableRenderId();

    @Override
    public void renderInventoryBlock(Block block, int metadata, int modelId, RenderBlocks renderer) {
        //do nothing
    }


    @Override
    public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
        //renderer.setRenderBounds(0.0D, 0.0D, 0.0D, 1.0D, 0.5D, 1.0D);

        int l = world.getBlockMetadata(x, y, z);

        IIcon iicon = block.getIcon(0, l);

        //int rotation = Math.abs(((((((1123 + x) * 1301) + y) * 2543) + z) * 1021) % 4);

        //lily pad rotation hash
        long rotationHash = (long)(x * 3129871) ^ (long)y * 116129781L ^ (long)z;
        rotationHash = rotationHash * rotationHash * 42317861L + l * 11L;
        int rotation = (int)(rotationHash >> 16 & 3L);

        //int rotation = (Math.abs((x * 104087) ^ (y * 104971) ^ (z * 104327)) % 4);

        renderer.uvRotateTop = rotation;
        renderer.uvRotateBottom = rotation;
        renderer.uvRotateNorth = rotation;
        renderer.uvRotateSouth = rotation;
        renderer.uvRotateEast = rotation;
        renderer.uvRotateWest = rotation;

        renderer.setRenderBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        renderer.renderStandardBlock(block, x, y, z);

        renderer.uvRotateTop = 0;
        renderer.uvRotateBottom = 0;
        renderer.uvRotateNorth = 0;
        renderer.uvRotateSouth = 0;
        renderer.uvRotateEast = 0;
        renderer.uvRotateWest = 0;

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

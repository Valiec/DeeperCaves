package com.kpabr.DeeperCaves;

import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.rcon.RConConsoleSource;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentText;

import java.io.IOException;

public class DepthCommand extends CommandBase
{

    public String getCommandName()
    {
        return "depth";
    }

    public String getCommandUsage(ICommandSender par1ICommandSender)
    {
        return "/depth";
    }

    // JAVADOC METHOD $$ func_82362_a
    public int getRequiredPermissionLevel()
    {
        return 0;
    }

    public void processCommand(ICommandSender par1ICommandSender, String[] par2ArrayOfStr)
    {

        if (par1ICommandSender instanceof MinecraftServer || par1ICommandSender instanceof RConConsoleSource) {
            Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("Error: must be used from a player or command block"));
        }
        else {
            double dimY;
            if (par1ICommandSender instanceof EntityPlayer) {
                dimY = ((EntityPlayer) par1ICommandSender).boundingBox.minY;
            }
            else {
                dimY = par1ICommandSender.getPlayerCoordinates().posY;
            }

            double depth = DeeperCaves.worldgen.getTotalDepth(par1ICommandSender.getEntityWorld().provider.dimensionId, dimY);

            String depthStr = String.format("Depth: %.3f (%s, y: %.3f)", depth, par1ICommandSender.getEntityWorld().provider.getDimensionName(), dimY);
            Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(depthStr));
        }
    }
}
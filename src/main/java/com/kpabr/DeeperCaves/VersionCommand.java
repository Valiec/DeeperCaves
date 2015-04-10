package com.kpabr.DeeperCaves;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.crash.CrashReport;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentText;

public class VersionCommand extends CommandBase
{

    public String getCommandName()
    {
        return "version";
    }

    public String getCommandUsage(ICommandSender par1ICommandSender)
    {
        return "/version";
    }

    // JAVADOC METHOD $$ func_82362_a
    public int getRequiredPermissionLevel()
    {
        return 0;
    }
    public void processCommand(ICommandSender par1ICommandSender, String[] par2ArrayOfStr)
    {
      
    try
    {
        Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("You have DeeperCaves "+DeeperCaves.VERSION+". Newest release is DeeperCaves "+DeeperCaves.versionChecker.getNewestVersionNumber()+"."));
    }
    catch (UnknownHostException e)
    {
        Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("Failed to get latest version number from server. Check your Internet connection."));
    }
    catch (IOException e)
    {
        Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("Failed to get latest version number from server. Check your Internet connection."));
    }
        
      
        
    }
    @Override
    public int compareTo(Object o)
    {
        return 0;
    }
    
    // JAVADOC METHOD $$ func_71516_a
    protected String[] func_147209_d()
    {
        return MinecraftServer.getServer().getAllUsernames();
    }

    // JAVADOC METHOD $$ func_82358_a
    public boolean isUsernameIndex(String[] par1ArrayOfStr, int par2)
    {
        return par2 == 0;
    }
}
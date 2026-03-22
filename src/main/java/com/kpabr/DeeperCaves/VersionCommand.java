package com.kpabr.DeeperCaves;

import java.io.IOException;

import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
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
    catch (IOException e)
    {
        Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("Failed to get latest version number from server. Check your Internet connection."));
    }
        
      
        
    }
}
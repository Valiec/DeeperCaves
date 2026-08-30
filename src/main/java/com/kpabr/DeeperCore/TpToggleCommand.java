package com.kpabr.DeeperCore;

import com.kpabr.DeeperCore.dimstack.DeeperCoreExtendedPlayerData;
import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;

public class TpToggleCommand extends CommandBase
{

    public String getCommandName()
    {
        return "tptoggle";
    }

    public String getCommandUsage(ICommandSender par1ICommandSender)
    {
        return "/tptoggle";
    }

    // JAVADOC METHOD $$ func_82362_a
    public int getRequiredPermissionLevel()
    {
        return 0;
    }

    public void processCommand(ICommandSender par1ICommandSender, String[] par2ArrayOfStr)
    {

        if (!(par1ICommandSender instanceof EntityPlayer)) {
            par1ICommandSender.addChatMessage(new ChatComponentText("Error: must be used from a player"));
        }
        else {
            boolean enabled = ((DeeperCoreExtendedPlayerData)((EntityPlayer)par1ICommandSender).getExtendedProperties(DeeperCoreExtendedPlayerData.NAME)).toggleTPEnabled();
            par1ICommandSender.addChatMessage(new ChatComponentText("TP enabled: " + enabled));
        }
    }
}
package com.kpabr.DeeperCaves;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;

import net.minecraft.client.Minecraft;
import net.minecraft.crash.CrashReport;
import net.minecraft.util.ChatComponentText;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;

public class DeeperVersionChecker {
    public int getNewestVersionID(boolean debug) throws UnknownHostException, IOException
    {
        int newestVersion = -1;
        URL check;
        if(!debug)
        {
            check = new URL("http://www.kpabr.com/mcmods/deepercaves/versioncheck");
        }
        else
        {
            check = new URL("http://www.kpabr.com/debug/mcmods/deepercaves/versioncheck");
        }
        URLConnection read = check.openConnection();
        BufferedReader reader = new BufferedReader(new InputStreamReader(read.getInputStream()));
        String newestVersionStr = reader.readLine();
        newestVersion = Integer.parseInt(newestVersionStr);
        
        if (newestVersion < 0)
        {
            throw new IOException();
        }
        else
        {
            return newestVersion; 
        }
    }
    public String getNewestVersionNumber() throws UnknownHostException, IOException
    {
        return toVersionNumber(getNewestVersionID(true));
    }
    public String toVersionNumber(int id)
    {
        Object[][] versions = {{1, "1.0.0"}};
        for (int i = 0; i<versions.length; i++)
        {
            if((Integer)(versions[i][0]) == id)
            {
                return (String)(versions[i][1]);
            }
        }
        return "0.0.0";
    }
    @SubscribeEvent
    public void onUpdateMessage(PlayerEvent.PlayerLoggedInEvent event) throws UnknownHostException, IOException
    {
        try
        {
            int version = getNewestVersionID(false);
            
            if(version>DeeperCaves.versionID)
            {
                event.player.addChatMessage(new ChatComponentText("Deeper Caves is out of date. Go to the Minecraft Forums thread for updates."));
            }
                else if(version<DeeperCaves.versionID)
            {
                event.player.addChatMessage(new ChatComponentText("You are running a development version of Deeper Caves. Bugs may be present."));
            }
        
        }
        catch (IOException e)
        {
            event.player.addChatMessage(new ChatComponentText("Failed to get latest version number from server. Check your Internet connection."));
        }
            
    }
}

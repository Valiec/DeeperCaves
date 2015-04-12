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
    public String getNewestVersionID(boolean debug) throws UnknownHostException, IOException
    {
        int newestVersion = -1;
        URL check;
        if(!debug)
        {
            check = new URL("http://www.kpabr.com/mcmods/deepercaves/versionchecknew");
        }
        else
        {
            check = new URL("http://www.kpabr.com/debug/mcmods/deepercaves/versionchecknew");
        }
        URLConnection read = check.openConnection();
        BufferedReader reader = new BufferedReader(new InputStreamReader(read.getInputStream()));
        String newestVersionStr = reader.readLine();
        newestVersion = Integer.parseInt(newestVersionStr.split("-")[1]);
        
        if (newestVersion < 0)
        {
            throw new IOException();
        }
        else
        {
            return newestVersionStr; 
        }
    }
    public String getNewestVersionNumber() throws UnknownHostException, IOException
    {
        return (getNewestVersionID(true).split("-"))[0];
    }
    @SubscribeEvent
    public void onUpdateMessage(PlayerEvent.PlayerLoggedInEvent event) throws UnknownHostException, IOException
    {
        try
        {
        	String version = getNewestVersionID(false);
            int versionID = Integer.parseInt((version.split("-"))[1]);
            String versionStr = (version.split("-"))[0];
            
            if(versionID>DeeperCaves.versionID)
            {
                event.player.addChatMessage(new ChatComponentText("Deeper Caves is out of date. The newest version is "+versionStr+". Go to the Minecraft Forums thread for updates."));
            }
                else if(versionID<DeeperCaves.versionID)
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

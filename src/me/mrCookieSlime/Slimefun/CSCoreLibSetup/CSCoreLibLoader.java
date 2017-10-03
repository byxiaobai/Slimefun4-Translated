// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   CSCoreLibLoader.java

package me.mrCookieSlime.Slimefun.CSCoreLibSetup;

import java.io.*;
import java.net.*;
import org.bukkit.Server;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.scheduler.BukkitScheduler;
import org.json.simple.*;

public class CSCoreLibLoader
{

    Plugin plugin;
    URL url;
    URL download;
    File file;

    public CSCoreLibLoader(Plugin plugin)
    {
        this.plugin = plugin;
        try
        {
            url = new URL("https://api.curseforge.com/servermods/files?projectIds=88802");
        }
        catch(MalformedURLException malformedurlexception) { }
    }

    public boolean load()
    {
        if(plugin.getServer().getPluginManager().isPluginEnabled("CS-CoreLib"))
        {
            return true;
        } else
        {
            System.err.println(" ");
            System.err.println("#################### - INFO - ####################");
            System.err.println(" ");
            System.err.println((new StringBuilder(String.valueOf(plugin.getName()))).append(" could not be loaded.").toString());
            System.err.println("It appears that you have not installed CS-CoreLib");
            System.err.println("Your Server will now try to download and install");
            System.err.println("CS-CoreLib for you.");
            System.err.println("You will be asked to restart your Server when it's finished.");
            System.err.println("If this somehow fails, please download and install CS-CoreLib manually:");
            System.err.println("https://dev.bukkit.org/projects/cs-corelib");
            System.err.println(" ");
            System.err.println("#################### - INFO - ####################");
            System.err.println(" ");
            plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {

                final CSCoreLibLoader this$0;

                public void run()
                {
                    if(connect())
                        install();
                }

            
            {
                this$0 = CSCoreLibLoader.this;
                super();
            }
            }
, 10L);
            return false;
        }
    }

    private boolean connect()
    {
        try
        {
            URLConnection connection = url.openConnection();
            connection.setConnectTimeout(5000);
            connection.addRequestProperty("User-Agent", "CS-CoreLib Loader (by mrCookieSlime)");
            connection.setDoOutput(true);
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            JSONArray array = (JSONArray)JSONValue.parse(reader.readLine());
            download = traceURL(((String)((JSONObject)array.get(array.size() - 1)).get("downloadUrl")).replace("https:", "http:"));
            file = new File((new StringBuilder("plugins/")).append((String)((JSONObject)array.get(array.size() - 1)).get("name")).append(".jar").toString());
        }
        catch(IOException e)
        {
            System.err.println(" ");
            System.err.println("#################### - WARNING - ####################");
            System.err.println(" ");
            System.err.println("Could not connect to BukkitDev.");
            System.err.println("Please download & install CS-CoreLib manually:");
            System.err.println("https://dev.bukkit.org/projects/cs-corelib");
            System.err.println(" ");
            System.err.println("#################### - WARNING - ####################");
            System.err.println(" ");
            return false;
        }
        return true;
    }

    private URL traceURL(String location)
        throws IOException
    {
        HttpURLConnection connection = null;
        do
        {
            URL url = new URL(location);
            connection = (HttpURLConnection)url.openConnection();
            connection.setInstanceFollowRedirects(false);
            connection.setConnectTimeout(5000);
            connection.addRequestProperty("User-Agent", "Auto Updater (by mrCookieSlime)");
            switch(connection.getResponseCode())
            {
            case 301: 
            case 302: 
                String loc = connection.getHeaderField("Location");
                location = (new URL(new URL(location), loc)).toExternalForm();
                break;

            default:
                return new URL(connection.getURL().toString().replaceAll(" ", "%20"));
            }
        } while(true);
    }

    private void install()
    {
        BufferedInputStream input;
        FileOutputStream output;
        input = null;
        output = null;
        try
        {
            input = new BufferedInputStream(download.openStream());
            output = new FileOutputStream(file);
            byte data[] = new byte[1024];
            int read;
            while((read = input.read(data, 0, 1024)) != -1) 
                output.write(data, 0, read);
            break MISSING_BLOCK_LABEL_389;
        }
        catch(Exception ex)
        {
            System.err.println(" ");
            System.err.println("#################### - WARNING - ####################");
            System.err.println(" ");
            System.err.println("Failed to download CS-CoreLib");
            System.err.println("Please download & install CS-CoreLib manually:");
            System.err.println("https://dev.bukkit.org/projects/cs-corelib");
            System.err.println(" ");
            System.err.println("#################### - WARNING - ####################");
            System.err.println(" ");
        }
        try
        {
            if(input != null)
                input.close();
            if(output != null)
                output.close();
            System.err.println(" ");
            System.err.println("#################### - INFO - ####################");
            System.err.println(" ");
            System.err.println("Please restart your Server to finish the Installation");
            System.err.println((new StringBuilder("of ")).append(plugin.getName()).append(" and CS-CoreLib").toString());
            System.err.println(" ");
            System.err.println("#################### - INFO - ####################");
            System.err.println(" ");
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        break MISSING_BLOCK_LABEL_509;
        Exception exception;
        exception;
        try
        {
            if(input != null)
                input.close();
            if(output != null)
                output.close();
            System.err.println(" ");
            System.err.println("#################### - INFO - ####################");
            System.err.println(" ");
            System.err.println("Please restart your Server to finish the Installation");
            System.err.println((new StringBuilder("of ")).append(plugin.getName()).append(" and CS-CoreLib").toString());
            System.err.println(" ");
            System.err.println("#################### - INFO - ####################");
            System.err.println(" ");
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        throw exception;
        try
        {
            if(input != null)
                input.close();
            if(output != null)
                output.close();
            System.err.println(" ");
            System.err.println("#################### - INFO - ####################");
            System.err.println(" ");
            System.err.println("Please restart your Server to finish the Installation");
            System.err.println((new StringBuilder("of ")).append(plugin.getName()).append(" and CS-CoreLib").toString());
            System.err.println(" ");
            System.err.println("#################### - INFO - ####################");
            System.err.println(" ");
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }


}

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
            System.err.println("#################### - 信息 - ####################");
            System.err.println(" ");
            System.err.println((new StringBuilder(String.valueOf(plugin.getName()))).append(" 未能被加载.").toString());
            System.err.println("粗心大意的你一定忘记安装了 CS-CoreLib");
            System.err.println("但机智的我正在自动下载并安装 CS-Corelib");
            System.err.println("下载完成的时候麻烦你重启一下");
            System.err.println("如果你的机子处在好多层墙里, 请带好梯子去这里下载:");
            System.err.println("https://dev.bukkit.org/projects/cs-corelib");
            System.err.println(" ");
            System.err.println("#################### - 信息 - ####################");
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
            System.err.println("#################### - 警告 - ####################");
            System.err.println(" ");
            System.err.println("我TM的连不上 BukkitDev啦!");
            System.err.println("快! 打开这个连接去下载!");
            System.err.println("https://dev.bukkit.org/projects/cs-corelib");
            System.err.println(" ");
            System.err.println("#################### - 警告 - ####################");
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
            System.err.println("#################### - 警告 - ####################");
            System.err.println(" ");
            System.err.println("您与 Ubisoft 的连接已中断, 我们无法连接至 Ubisoft 服务器");
            System.err.println("请手动下载并安装 CS-Corelib:");
            System.err.println("https://dev.bukkit.org/projects/cs-corelib");
            System.err.println(" ");
            System.err.println("#################### - 警告 - ####################");
            System.err.println(" ");
        }
        try
        {
            if(input != null)
                input.close();
            if(output != null)
                output.close();
            System.err.println(" ");
            System.err.println("#################### - 信息 - ####################");
            System.err.println(" ");
            System.err.println("请重启你的服务器以完成");
            System.err.println((new StringBuilder("of ")).append(plugin.getName()).append(" 与 CS-CoreLib 的安装").toString());
            System.err.println(" ");
            System.err.println("#################### - 信息 - ####################");
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
            System.err.println("#################### - 信息 - ####################");
            System.err.println(" ");
            System.err.println("Please restart your Server to finish the Installation");
            System.err.println((new StringBuilder("of ")).append(plugin.getName()).append(" and CS-CoreLib").toString());
            System.err.println(" ");
            System.err.println("#################### - 信息 - ####################");
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
            System.err.println("#################### - 信息 - ####################");
            System.err.println(" ");
            System.err.println("请重启你的服务器以完成");
            System.err.println((new StringBuilder("of ")).append(plugin.getName()).append(" 与 CS-CoreLib 的安装").toString());
            System.err.println(" ");
            System.err.println("#################### - 信息 - ####################");
            System.err.println(" ");
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }


}

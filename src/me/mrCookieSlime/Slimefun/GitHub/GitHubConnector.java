package me.mrCookieSlime.Slimefun.GitHub;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.util.HashSet;
import java.util.Set;
import me.mrCookieSlime.CSCoreLibPlugin.Configuration.Config;
import me.mrCookieSlime.Slimefun.SlimefunStartup;

public abstract class GitHubConnector
{

    public static Set connectors = new HashSet();
    private File file;

    public GitHubConnector()
    {
        file = new File((new StringBuilder("plugins/Slimefun/cache/github/")).append(getFileName()).append(".json").toString());
        connectors.add(this);
    }

    public abstract String getFileName();

    public abstract String getRepository();

    public abstract String getURLSuffix();

    public abstract void onSuccess(JsonElement jsonelement);

    public abstract void onFailure();

    public void pullFile()
    {
        if(SlimefunStartup.getCfg().getBoolean("options.print-out-github-data-retrieving"))
            System.out.println((new StringBuilder("[Slimefun - GitHub] 正从 Github 上获取 '")).append(getFileName()).append(".json' ...").toString());
        try
        {
            URL website = new URL((new StringBuilder("https://api.github.com/repos/")).append(getRepository()).append(getURLSuffix()).toString());
            URLConnection connection = website.openConnection();
            connection.setConnectTimeout(3000);
            connection.addRequestProperty("User-Agent", "Slimefun 4 GitHub Agent (by TheBusyBiscuit)");
            connection.setDoOutput(true);
            java.nio.channels.ReadableByteChannel rbc = Channels.newChannel(connection.getInputStream());
            FileOutputStream fos = new FileOutputStream(file);
            fos.getChannel().transferFrom(rbc, 0L, 0x7fffffffffffffffL);
            fos.close();
            parseData();
        }
        catch(IOException e)
        {
            if(SlimefunStartup.getCfg().getBoolean("options.print-out-github-data-retrieving"))
                System.err.println("[Slimefun - GitHub] 错误 - 无法连接至 GitHub!");
            if(hasData())
                parseData();
            else
                onFailure();
        }
    }

    public boolean hasData()
    {
        return getFile().exists();
    }

    public File getFile()
    {
        return file;
    }

    public void parseData()
    {
        try
        {
            BufferedReader reader = new BufferedReader(new FileReader(getFile()));
            String full;
            String line;
            for(full = ""; (line = reader.readLine()) != null; full = (new StringBuilder(String.valueOf(full))).append(line).toString());
            reader.close();
            JsonElement element = (new JsonParser()).parse(full);
            onSuccess(element);
        }
        catch(IOException e)
        {
            e.printStackTrace();
            onFailure();
        }
    }

}

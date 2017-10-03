package me.mrCookieSlime.Slimefun.Hashing;

import java.io.PrintStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.SlimefunStartup;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;

public class ItemHash
{

    public static MessageDigest digest;
    public static int LENGTH;
    public static Map map = new HashMap();

    public ItemHash()
    {
    }

    public static String hash(String input)
    {
        digest.update(input.getBytes());
        byte hash[] = digest.digest();
        return (new BigInteger(1, hash)).toString(16);
    }

    public static String toString(SlimefunItem item)
    {
        StringBuilder builder = new StringBuilder(LENGTH * 2);
        char ac[];
        int j = (ac = item.hash.toCharArray()).length;
        for(int i = 0; i < j; i++)
        {
            char c = ac[i];
            builder.append('\uFFFD');
            builder.append(c);
        }

        return builder.toString();
    }

    public static SlimefunItem fromString(String input)
    {
        if(input == null || input.length() != LENGTH * 2)
            return null;
        String hex = input.replaceAll("\uFFFD", "");
        if(hex.length() != LENGTH || !map.containsKey(hex))
            return null;
        else
            return (SlimefunItem)map.get(hex);
    }

    public static void register(SlimefunItem item)
    {
        String hash = hash(item.getName());
        if(map.containsKey(hash) && !item.getName().equals(((SlimefunItem)map.get(hash)).hash))
        {
            System.out.println("致命安全错误 - Slimefun 已被禁用.");
            Bukkit.getPluginManager().disablePlugin(SlimefunStartup.instance);
            throw new IllegalStateException((new StringBuilder("Hash Collision: ")).append(hash).toString());
        } else
        {
            item.hash = hash;
            map.put(hash, item);
            return;
        }
    }

    static 
    {
        try
        {
            digest = MessageDigest.getInstance("SHA");
            LENGTH = hash("The Busy Biscuit").length();
        }
        catch(NoSuchAlgorithmException e)
        {
            System.out.println("致命安全错误 - Slimefun 已被禁用.");
            Bukkit.getPluginManager().disablePlugin(SlimefunStartup.instance);
            e.printStackTrace();
        }
    }
}

// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   Backpacks.java

package me.mrCookieSlime.Slimefun.api;

import java.io.File;
import java.util.*;
import me.mrCookieSlime.CSCoreLibPlugin.Configuration.Config;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Backpacks
{

    public Backpacks()
    {
    }

    public static String createBackpack(Player p, int size)
    {
        List ids = new ArrayList();
        Config cfg = new Config(new File((new StringBuilder("data-storage/Slimefun/Players/")).append(p.getUniqueId()).append(".yml").toString()));
        for(int i = 0; i < 1000; i++)
        {
            if(!cfg.contains((new StringBuilder("backpacks.")).append(i).append(".size").toString()))
                break;
            ids.add(Integer.valueOf(i));
        }

        int id = ids.isEmpty() ? 0 : ((Integer)ids.get(ids.size() - 1)).intValue() + 1;
        ids.add(Integer.valueOf(id));
        cfg.setValue((new StringBuilder("backpacks.")).append(id).append(".size").toString(), Integer.valueOf(size));
        cfg.save();
        return (new StringBuilder()).append(p.getUniqueId()).append("#").append(id).toString();
    }

    public static void openBackpack(Player p, ItemStack item)
    {
        Inventory inv = getInventory(p, item);
        if(inv != null)
            p.openInventory(inv);
    }

    public static Inventory getInventory(Player p, ItemStack item)
    {
        if(item == null || !item.hasItemMeta() || !item.getItemMeta().hasLore())
            return null;
        int id = -1;
        String uuid = "";
        for(Iterator iterator = item.getItemMeta().getLore().iterator(); iterator.hasNext();)
        {
            String line = (String)iterator.next();
            if(line.startsWith(ChatColor.translateAlternateColorCodes('&', "&7ID: ")) && line.contains("#"))
                try
                {
                    id = Integer.parseInt(line.split("#")[1]);
                    uuid = line.split("#")[0].replace(ChatColor.translateAlternateColorCodes('&', "&7ID: "), "");
                }
                catch(NumberFormatException numberformatexception) { }
        }

        if(id >= 0)
        {
            Config cfg = new Config(new File((new StringBuilder("data-storage/Slimefun/Players/")).append(uuid).append(".yml").toString()));
            int size = cfg.getInt((new StringBuilder("backpacks.")).append(id).append(".size").toString());
            Inventory inv = Bukkit.createInventory(null, size, (new StringBuilder("\u80CC\u5305 [")).append(size).append(" \u683C]").toString());
            for(int i = 0; i < size; i++)
                inv.setItem(i, cfg.getItem((new StringBuilder("backpacks.")).append(id).append(".contents.").append(i).toString()));

            return inv;
        } else
        {
            return null;
        }
    }

    public static void saveBackpack(Inventory inv, ItemStack item)
    {
        int id = -1;
        String uuid = "";
        for(Iterator iterator = item.getItemMeta().getLore().iterator(); iterator.hasNext();)
        {
            String line = (String)iterator.next();
            if(line.startsWith(ChatColor.translateAlternateColorCodes('&', "&7ID: ")) && line.contains("#"))
                try
                {
                    id = Integer.parseInt(line.split("#")[1]);
                    uuid = line.split("#")[0].replace(ChatColor.translateAlternateColorCodes('&', "&7ID: "), "");
                }
                catch(NumberFormatException numberformatexception) { }
        }

        if(id >= 0)
        {
            Config cfg = new Config(new File((new StringBuilder("data-storage/Slimefun/Players/")).append(uuid).append(".yml").toString()));
            for(int i = 0; i < inv.getContents().length; i++)
                cfg.setValue((new StringBuilder("backpacks.")).append(id).append(".contents.").append(i).toString(), inv.getContents()[i]);

            cfg.save();
        }
    }
}

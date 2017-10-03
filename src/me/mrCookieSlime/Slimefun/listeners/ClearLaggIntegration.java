// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   ClearLaggIntegration.java

package me.mrCookieSlime.Slimefun.listeners;

import java.util.Iterator;
import java.util.List;
import me.minebuilders.clearlag.events.EntityRemoveEvent;
import me.mrCookieSlime.Slimefun.SlimefunStartup;
import org.bukkit.Server;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;

public class ClearLaggIntegration
    implements Listener
{

    public ClearLaggIntegration(SlimefunStartup plugin)
    {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    public void oNEntityRemove(EntityRemoveEvent e)
    {
        for(Iterator iterator = e.getEntityList().iterator(); iterator.hasNext();)
        {
            Entity n = (Entity)iterator.next();
            if((n instanceof Item) && n.hasMetadata("no_pickup"))
                iterator.remove();
        }

    }
}

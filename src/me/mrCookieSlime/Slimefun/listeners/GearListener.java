// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   GearListener.java

package me.mrCookieSlime.Slimefun.listeners;

import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.*;
import me.mrCookieSlime.Slimefun.Objects.tasks.*;
import me.mrCookieSlime.Slimefun.SlimefunStartup;
import me.mrCookieSlime.Slimefun.api.Slimefun;
import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.plugin.PluginManager;
import org.bukkit.scheduler.BukkitScheduler;

public class GearListener
    implements Listener
{

    public GearListener(SlimefunStartup plugin)
    {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    public void onToggleSneak(PlayerToggleSneakEvent e)
    {
        if(e.isSneaking())
        {
            Player p = e.getPlayer();
            if(SlimefunItem.getByItem(p.getInventory().getChestplate()) != null)
            {
                SlimefunItem item = SlimefunItem.getByItem(p.getInventory().getChestplate());
                if(item instanceof Jetpack)
                {
                    if(Slimefun.hasUnlocked(p, item.getItem(), true))
                    {
                        double thrust = ((Jetpack)item).getThrust();
                        if(thrust > 0.20000000000000001D)
                        {
                            JetpackTask task = new JetpackTask(p, thrust);
                            task.setID(Bukkit.getScheduler().scheduleSyncRepeatingTask(SlimefunStartup.instance, task, 0L, 3L));
                        }
                    }
                } else
                if(item.isItem(SlimefunItem.getItem("PARACHUTE")) && Slimefun.hasUnlocked(p, SlimefunItem.getItem("PARACHUTE"), true))
                {
                    ParachuteTask task = new ParachuteTask(p);
                    task.setID(Bukkit.getScheduler().scheduleSyncRepeatingTask(SlimefunStartup.instance, task, 0L, 3L));
                }
            }
            if(SlimefunItem.getByItem(p.getInventory().getBoots()) != null)
            {
                SlimefunItem item = SlimefunItem.getByItem(p.getInventory().getBoots());
                if((item instanceof JetBoots) && Slimefun.hasUnlocked(p, item.getItem(), true))
                {
                    double speed = ((JetBoots)item).getSpeed();
                    if(speed > 0.20000000000000001D)
                    {
                        JetBootsTask task = new JetBootsTask(p, speed);
                        task.setID(Bukkit.getScheduler().scheduleSyncRepeatingTask(SlimefunStartup.instance, task, 0L, 2L));
                    }
                }
            }
            if(p.getInventory().containsAtLeast(SlimefunItem.getItem("INFUSED_MAGNET"), 1))
            {
                MagnetTask task = new MagnetTask(p);
                task.setID(Bukkit.getScheduler().scheduleSyncRepeatingTask(SlimefunStartup.instance, task, 0L, 8L));
            }
        }
    }
}

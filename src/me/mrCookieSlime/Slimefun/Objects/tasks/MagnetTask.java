// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   MagnetTask.java

package me.mrCookieSlime.Slimefun.Objects.tasks;

import java.util.*;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.scheduler.BukkitScheduler;

public class MagnetTask
    implements Runnable
{

    UUID uuid;
    int id;

    public MagnetTask(Player p)
    {
        uuid = p.getUniqueId();
    }

    public void setID(int id)
    {
        this.id = id;
    }

    public void run()
    {
        if(Bukkit.getPlayer(uuid) == null)
            Bukkit.getScheduler().cancelTask(id);
        else
        if(Bukkit.getPlayer(uuid).isDead())
            Bukkit.getScheduler().cancelTask(id);
        else
        if(!Bukkit.getPlayer(uuid).isSneaking())
        {
            Bukkit.getScheduler().cancelTask(id);
        } else
        {
            for(Iterator iterator = Bukkit.getPlayer(uuid).getNearbyEntities(6D, 6D, 6D).iterator(); iterator.hasNext();)
            {
                Entity item = (Entity)iterator.next();
                if((item instanceof Item) && !item.hasMetadata("no_pickup") && ((Item)item).getPickupDelay() <= 0)
                {
                    item.teleport(Bukkit.getPlayer(uuid).getEyeLocation());
                    Bukkit.getPlayer(uuid).getWorld().playSound(Bukkit.getPlayer(uuid).getEyeLocation(), Sound.ENTITY_ENDERMEN_TELEPORT, 5F, 2.0F);
                }
            }

        }
    }
}

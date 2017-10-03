// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   ReactorHologram.java

package me.mrCookieSlime.Slimefun.holograms;

import me.mrCookieSlime.CSCoreLibPlugin.general.World.ArmorStandFactory;
import me.mrCookieSlime.Slimefun.SlimefunStartup;
import org.bukkit.*;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.scheduler.BukkitScheduler;

public class ReactorHologram
{

    public ReactorHologram()
    {
    }

    public static ArmorStand getArmorStand(Location reactor)
    {
        Location l = new Location(reactor.getWorld(), reactor.getX() + 0.5D, reactor.getY(), reactor.getZ() + 0.5D);
        Entity aentity[];
        int j = (aentity = l.getChunk().getEntities()).length;
        for(int i = 0; i < j; i++)
        {
            Entity n = aentity[i];
            if((n instanceof ArmorStand) && l.distanceSquared(n.getLocation()) < 0.40000000000000002D)
                return (ArmorStand)n;
        }

        ArmorStand hologram = ArmorStandFactory.createHidden(l);
        hologram.setCustomNameVisible(false);
        hologram.setCustomName(null);
        return hologram;
    }

    public static void update(final Location l, final String name)
    {
        Bukkit.getScheduler().scheduleSyncDelayedTask(SlimefunStartup.instance, new Runnable() {

            private final Location val$l;
            private final String val$name;

            public void run()
            {
                ArmorStand hologram = ReactorHologram.getArmorStand(l);
                if(!hologram.isCustomNameVisible())
                    hologram.setCustomNameVisible(true);
                hologram.setCustomName(ChatColor.translateAlternateColorCodes('&', name));
            }

            
            {
                l = location;
                name = s;
                super();
            }
        }
);
    }

    public static void remove(Location l)
    {
        ArmorStand hologram = getArmorStand(l);
        hologram.remove();
    }
}

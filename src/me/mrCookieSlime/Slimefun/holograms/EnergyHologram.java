// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   EnergyHologram.java

package me.mrCookieSlime.Slimefun.holograms;

import me.mrCookieSlime.CSCoreLibPlugin.general.Math.DoubleHandler;
import me.mrCookieSlime.CSCoreLibPlugin.general.World.ArmorStandFactory;
import me.mrCookieSlime.Slimefun.SlimefunStartup;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.scheduler.BukkitScheduler;

public class EnergyHologram
{

    public EnergyHologram()
    {
    }

    public static void update(Block b, double supply, double demand)
    {
        update(b, demand <= supply ? (new StringBuilder("&2&l+ &a")).append(DoubleHandler.getFancyDouble(supply - demand)).append(" &7J &e\u26A1").toString() : (new StringBuilder("&4&l- &c")).append(DoubleHandler.getFancyDouble(Math.abs(supply - demand))).append(" &7J &e\u26A1").toString());
    }

    public static void update(final Block b, final String name)
    {
        Bukkit.getScheduler().scheduleSyncDelayedTask(SlimefunStartup.instance, new Runnable() {

            private final Block val$b;
            private final String val$name;

            public void run()
            {
                ArmorStand hologram = EnergyHologram.getArmorStand(b);
                hologram.setCustomName(ChatColor.translateAlternateColorCodes('&', name));
            }

            
            {
                b = block;
                name = s;
                super();
            }
        }
);
    }

    public static void remove(final Block b)
    {
        Bukkit.getScheduler().scheduleSyncDelayedTask(SlimefunStartup.instance, new Runnable() {

            private final Block val$b;

            public void run()
            {
                ArmorStand hologram = EnergyHologram.getArmorStand(b);
                hologram.remove();
            }

            
            {
                b = block;
                super();
            }
        }
);
    }

    private static ArmorStand getArmorStand(Block b)
    {
        Location l = new Location(b.getWorld(), (double)b.getX() + 0.5D, (float)b.getY() - 0.7F, (double)b.getZ() + 0.5D);
        Entity aentity[];
        int j = (aentity = l.getChunk().getEntities()).length;
        for(int i = 0; i < j; i++)
        {
            Entity n = aentity[i];
            if((n instanceof ArmorStand) && n.getCustomName() != null && l.distanceSquared(n.getLocation()) < 0.40000000000000002D)
                return (ArmorStand)n;
        }

        ArmorStand hologram = ArmorStandFactory.createHidden(l);
        return hologram;
    }

}

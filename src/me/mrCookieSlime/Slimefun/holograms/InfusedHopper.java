// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   InfusedHopper.java

package me.mrCookieSlime.Slimefun.holograms;

import me.mrCookieSlime.CSCoreLibPlugin.general.World.ArmorStandFactory;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;

public class InfusedHopper
{

    private static final double offset = 1.2D;

    public InfusedHopper()
    {
    }

    public static ArmorStand getArmorStand(Block hopper)
    {
        Location l = new Location(hopper.getWorld(), (double)hopper.getX() + 0.5D, (double)hopper.getY() + 1.2D, (double)hopper.getZ() + 0.5D);
        Entity aentity[];
        int j = (aentity = l.getChunk().getEntities()).length;
        for(int i = 0; i < j; i++)
        {
            Entity n = aentity[i];
            if((n instanceof ArmorStand) && n.getCustomName() == null && l.distanceSquared(n.getLocation()) < 0.40000000000000002D)
                return (ArmorStand)n;
        }

        ArmorStand hologram = ArmorStandFactory.createHidden(l);
        hologram.setCustomNameVisible(false);
        hologram.setCustomName(null);
        return hologram;
    }
}

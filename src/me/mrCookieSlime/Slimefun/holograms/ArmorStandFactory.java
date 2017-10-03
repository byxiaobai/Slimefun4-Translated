// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   ArmorStandFactory.java

package me.mrCookieSlime.Slimefun.holograms;

import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.EulerAngle;

/**
 * @deprecated Class ArmorStandFactory is deprecated
 */

public class ArmorStandFactory
{

    public ArmorStandFactory()
    {
    }

    /**
     * @deprecated Method createHidden is deprecated
     */

    public static ArmorStand createHidden(Location l)
    {
        return me.mrCookieSlime.CSCoreLibPlugin.general.World.ArmorStandFactory.createHidden(l);
    }

    /**
     * @deprecated Method createSmall is deprecated
     */

    public static ArmorStand createSmall(Location l, ItemStack item, EulerAngle arm, float yaw)
    {
        return me.mrCookieSlime.CSCoreLibPlugin.general.World.ArmorStandFactory.createSmall(l, item, arm, yaw);
    }

    /**
     * @deprecated Method createSmall is deprecated
     */

    public static ArmorStand createSmall(Location l, ItemStack head, float yaw)
    {
        return me.mrCookieSlime.CSCoreLibPlugin.general.World.ArmorStandFactory.createSmall(l, head, yaw);
    }
}

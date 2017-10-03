// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   EnergyTicker.java

package me.mrCookieSlime.Slimefun.api.energy;

import me.mrCookieSlime.CSCoreLibPlugin.Configuration.Config;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.handlers.ItemHandler;
import org.bukkit.Location;

public abstract class EnergyTicker extends ItemHandler
{

    public EnergyTicker()
    {
    }

    public abstract double generateEnergy(Location location, SlimefunItem slimefunitem, Config config);

    public abstract boolean explode(Location location);

    public String toCodename()
    {
        return "EnergyTicker";
    }
}

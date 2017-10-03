// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   AdvancedRainbowTicker.java

package me.mrCookieSlime.Slimefun.Objects.tasks;

import me.mrCookieSlime.CSCoreLibPlugin.Configuration.Config;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.handlers.BlockTicker;
import org.bukkit.block.Block;

public class AdvancedRainbowTicker extends BlockTicker
{

    public int index;
    public int data[];

    public transient AdvancedRainbowTicker(int data[])
    {
        this.data = data;
        index = 0;
    }

    public void tick(Block b, SlimefunItem item, Config cfg)
    {
        b.setData((byte)data[index], false);
    }

    public void uniqueTick()
    {
        index = index != data.length - 1 ? index + 1 : 0;
    }

    public boolean isSynchronized()
    {
        return true;
    }
}

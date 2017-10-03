// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   RainbowTicker.java

package me.mrCookieSlime.Slimefun.Objects.tasks;

import me.mrCookieSlime.CSCoreLibPlugin.Configuration.Config;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.handlers.BlockTicker;
import org.bukkit.block.Block;

public class RainbowTicker extends BlockTicker
{

    public int meta;
    public int index;
    public int queue[];

    public RainbowTicker()
    {
        this(new int[] {
            0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 
            10, 11, 12, 13, 14, 15
        });
    }

    public transient RainbowTicker(int data[])
    {
        queue = data;
        meta = data[0];
        index = 0;
    }

    public void tick(Block b, SlimefunItem item, Config data)
    {
        b.setData((byte)meta, false);
    }

    public void uniqueTick()
    {
        index = index != queue.length - 1 ? index + 1 : 0;
        meta = queue[index];
    }

    public boolean isSynchronized()
    {
        return true;
    }
}

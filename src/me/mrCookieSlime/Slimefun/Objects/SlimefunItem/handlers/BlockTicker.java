// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   BlockTicker.java

package me.mrCookieSlime.Slimefun.Objects.SlimefunItem.handlers;

import me.mrCookieSlime.CSCoreLibPlugin.Configuration.Config;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import org.bukkit.block.Block;

// Referenced classes of package me.mrCookieSlime.Slimefun.Objects.SlimefunItem.handlers:
//            ItemHandler

public abstract class BlockTicker extends ItemHandler
{

    public boolean unique;

    public BlockTicker()
    {
        unique = true;
    }

    public void update()
    {
        if(unique)
        {
            uniqueTick();
            unique = false;
        }
    }

    public abstract boolean isSynchronized();

    public abstract void uniqueTick();

    public abstract void tick(Block block, SlimefunItem slimefunitem, Config config);

    public String toCodename()
    {
        return "BlockTicker";
    }
}

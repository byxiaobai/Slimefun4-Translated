// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   BlockPlaceHandler.java

package me.mrCookieSlime.Slimefun.Objects.SlimefunItem.handlers;

import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;

// Referenced classes of package me.mrCookieSlime.Slimefun.Objects.SlimefunItem.handlers:
//            ItemHandler

public abstract class BlockPlaceHandler extends ItemHandler
{

    public BlockPlaceHandler()
    {
    }

    public abstract boolean onBlockPlace(BlockPlaceEvent blockplaceevent, ItemStack itemstack);

    public String toCodename()
    {
        return "BlockPlaceHandler";
    }
}

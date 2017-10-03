// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   BlockBreakHandler.java

package me.mrCookieSlime.Slimefun.Objects.SlimefunItem.handlers;

import java.util.List;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

// Referenced classes of package me.mrCookieSlime.Slimefun.Objects.SlimefunItem.handlers:
//            ItemHandler

public abstract class BlockBreakHandler extends ItemHandler
{

    public BlockBreakHandler()
    {
    }

    public abstract boolean onBlockBreak(BlockBreakEvent blockbreakevent, ItemStack itemstack, int i, List list);

    public String toCodename()
    {
        return "BlockBreakHandler";
    }
}

// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   MultiBlockInteractionHandler.java

package me.mrCookieSlime.Slimefun.Objects.SlimefunItem.handlers;

import me.mrCookieSlime.Slimefun.Objects.MultiBlock;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

// Referenced classes of package me.mrCookieSlime.Slimefun.Objects.SlimefunItem.handlers:
//            ItemHandler

public abstract class MultiBlockInteractionHandler extends ItemHandler
{

    public MultiBlockInteractionHandler()
    {
    }

    public abstract boolean onInteract(Player player, MultiBlock multiblock, Block block);

    public String toCodename()
    {
        return "MultiBlockInteractionHandler";
    }
}

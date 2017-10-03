// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   SlimefunBlockHandler.java

package me.mrCookieSlime.Slimefun.Objects;

import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.UnregisterReason;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

public interface SlimefunBlockHandler
{

    public abstract void onPlace(Player player, Block block, SlimefunItem slimefunitem);

    public abstract boolean onBreak(Player player, Block block, SlimefunItem slimefunitem, UnregisterReason unregisterreason);
}

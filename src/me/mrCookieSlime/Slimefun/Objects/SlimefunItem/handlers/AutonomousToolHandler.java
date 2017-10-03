// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   AutonomousToolHandler.java

package me.mrCookieSlime.Slimefun.Objects.SlimefunItem.handlers;

import org.bukkit.block.Block;
import org.bukkit.block.Dispenser;
import org.bukkit.event.block.BlockDispenseEvent;

// Referenced classes of package me.mrCookieSlime.Slimefun.Objects.SlimefunItem.handlers:
//            ItemHandler

public abstract class AutonomousToolHandler extends ItemHandler
{

    public AutonomousToolHandler()
    {
    }

    public String toCodename()
    {
        return "AutonomousToolHandler";
    }

    public abstract boolean onBlockDispense(BlockDispenseEvent blockdispenseevent, Block block, Dispenser dispenser, Block block1, Block block2, int i);
}

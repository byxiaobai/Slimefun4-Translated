// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   AutonomousMachineHandler.java

package me.mrCookieSlime.Slimefun.Objects.SlimefunItem.handlers;

import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import org.bukkit.block.Block;
import org.bukkit.block.Dispenser;
import org.bukkit.event.block.BlockDispenseEvent;

// Referenced classes of package me.mrCookieSlime.Slimefun.Objects.SlimefunItem.handlers:
//            ItemHandler

public abstract class AutonomousMachineHandler extends ItemHandler
{

    public AutonomousMachineHandler()
    {
    }

    public String toCodename()
    {
        return "AutonomousMachineHandler";
    }

    public abstract boolean onBlockDispense(BlockDispenseEvent blockdispenseevent, Block block, Dispenser dispenser, Block block1, Block block2, SlimefunItem slimefunitem);
}

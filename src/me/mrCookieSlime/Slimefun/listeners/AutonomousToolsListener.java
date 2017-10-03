// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   AutonomousToolsListener.java

package me.mrCookieSlime.Slimefun.listeners;

import java.util.Iterator;
import java.util.Set;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.handlers.*;
import me.mrCookieSlime.Slimefun.SlimefunStartup;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.block.*;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDispenseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.PluginManager;

public class AutonomousToolsListener
    implements Listener
{

    public AutonomousToolsListener(SlimefunStartup plugin)
    {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    public void onBlockDispensing(BlockDispenseEvent e)
    {
        Block dispenser = e.getBlock();
        if(dispenser.getType() == Material.DISPENSER)
        {
            Dispenser d = (Dispenser)dispenser.getState();
            BlockFace face = BlockFace.DOWN;
            if(dispenser.getData() == 8)
                face = BlockFace.DOWN;
            else
            if(dispenser.getData() == 9)
                face = BlockFace.UP;
            else
            if(dispenser.getData() == 10)
                face = BlockFace.NORTH;
            else
            if(dispenser.getData() == 11)
                face = BlockFace.SOUTH;
            else
            if(dispenser.getData() == 12)
                face = BlockFace.WEST;
            else
            if(dispenser.getData() == 13)
                face = BlockFace.EAST;
            Block block = dispenser.getRelative(face);
            Block chest = dispenser.getRelative(face.getOppositeFace());
            SlimefunItem machine = BlockStorage.check(dispenser);
            if(machine != null)
            {
                for(Iterator iterator = SlimefunItem.getHandlers("AutonomousMachineHandler").iterator(); iterator.hasNext();)
                {
                    ItemHandler handler = (ItemHandler)iterator.next();
                    if(((AutonomousMachineHandler)handler).onBlockDispense(e, dispenser, d, block, chest, machine))
                        break;
                }

            } else
            {
                for(int i = 0; i < d.getInventory().getContents().length; i++)
                {
                    for(Iterator iterator1 = SlimefunItem.getHandlers("AutonomousToolHandler").iterator(); iterator1.hasNext();)
                    {
                        ItemHandler handler = (ItemHandler)iterator1.next();
                        if(((AutonomousToolHandler)handler).onBlockDispense(e, dispenser, d, block, chest, i))
                            break;
                    }

                }

            }
        }
    }
}

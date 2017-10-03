// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   TeleporterListener.java

package me.mrCookieSlime.Slimefun.listeners;

import java.util.UUID;
import me.mrCookieSlime.Slimefun.GPS.Elevator;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems.Teleporter;
import me.mrCookieSlime.Slimefun.SlimefunStartup;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import org.bukkit.Server;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.PluginManager;

public class TeleporterListener
    implements Listener
{

    BlockFace faces[];

    public TeleporterListener(SlimefunStartup plugin)
    {
        faces = (new BlockFace[] {
            BlockFace.NORTH, BlockFace.NORTH_EAST, BlockFace.EAST, BlockFace.SOUTH_EAST, BlockFace.SOUTH, BlockFace.SOUTH_WEST, BlockFace.WEST, BlockFace.NORTH_WEST
        });
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    public void onStarve(PlayerInteractEvent e)
    {
        if(!e.getAction().equals(Action.PHYSICAL))
            return;
        if(e.getClickedBlock() == null)
            return;
        SlimefunItem item = BlockStorage.check(e.getClickedBlock());
        if(item == null)
            return;
        if(item.getName().equals("GPS_ACTIVATION_DEVICE_SHARED"))
        {
            SlimefunItem teleporter = BlockStorage.check(e.getClickedBlock().getRelative(BlockFace.DOWN));
            if(teleporter instanceof Teleporter)
            {
                BlockFace ablockface[];
                int k = (ablockface = faces).length;
                for(int i = 0; i < k; i++)
                {
                    BlockFace face = ablockface[i];
                    if(!BlockStorage.check(e.getClickedBlock().getRelative(BlockFace.DOWN).getRelative(face), "GPS_TELEPORTER_PYLON"))
                        return;
                }

                try
                {
                    ((Teleporter)teleporter).onInteract(e.getPlayer(), e.getClickedBlock().getRelative(BlockFace.DOWN));
                }
                catch(Exception x)
                {
                    x.printStackTrace();
                }
            }
        } else
        if(item.getName().equals("GPS_ACTIVATION_DEVICE_PERSONAL"))
        {
            if(BlockStorage.getBlockInfo(e.getClickedBlock(), "owner").equals(e.getPlayer().getUniqueId().toString()))
            {
                SlimefunItem teleporter = BlockStorage.check(e.getClickedBlock().getRelative(BlockFace.DOWN));
                if(teleporter instanceof Teleporter)
                {
                    BlockFace ablockface1[];
                    int l = (ablockface1 = faces).length;
                    for(int j = 0; j < l; j++)
                    {
                        BlockFace face = ablockface1[j];
                        if(!BlockStorage.check(e.getClickedBlock().getRelative(BlockFace.DOWN).getRelative(face), "GPS_TELEPORTER_PYLON"))
                            return;
                    }

                    try
                    {
                        ((Teleporter)teleporter).onInteract(e.getPlayer(), e.getClickedBlock().getRelative(BlockFace.DOWN));
                    }
                    catch(Exception x)
                    {
                        x.printStackTrace();
                    }
                }
            } else
            {
                e.setCancelled(true);
            }
        } else
        if(item.getName().equals("ELEVATOR_PLATE"))
            Elevator.openDialogue(e.getPlayer(), e.getClickedBlock());
    }
}

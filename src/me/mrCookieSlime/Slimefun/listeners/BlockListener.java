// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   BlockListener.java

package me.mrCookieSlime.Slimefun.listeners;

import java.util.*;
import me.mrCookieSlime.CSCoreLibPlugin.general.Block.BlockAdjacents;
import me.mrCookieSlime.Slimefun.Events.MultiBlockInteractEvent;
import me.mrCookieSlime.Slimefun.Objects.MultiBlock;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.handlers.ItemHandler;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.handlers.MultiBlockInteractionHandler;
import me.mrCookieSlime.Slimefun.SlimefunStartup;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.block.*;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.plugin.PluginManager;

public class BlockListener
    implements Listener
{

    public BlockListener(SlimefunStartup plugin)
    {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    public void onPistonExtend(BlockPistonExtendEvent e)
    {
        for(Iterator iterator = e.getBlocks().iterator(); iterator.hasNext();)
        {
            Block b = (Block)iterator.next();
            if(BlockStorage.hasBlockInfo(b))
            {
                e.setCancelled(true);
                return;
            }
        }

    }

    public void onPistonRetract(BlockPistonRetractEvent e)
    {
        if(e.isSticky() && BlockStorage.hasBlockInfo(e.getRetractLocation().getBlock()))
        {
            e.setCancelled(true);
            return;
        } else
        {
            return;
        }
    }

    public void onRightClick(PlayerInteractEvent e)
    {
        if(e.getAction() == Action.RIGHT_CLICK_BLOCK)
        {
            if(!e.getHand().equals(EquipmentSlot.HAND))
                return;
            Player p = e.getPlayer();
            Block b = e.getClickedBlock();
            List multiblocks = new ArrayList();
            for(Iterator iterator = MultiBlock.list().iterator(); iterator.hasNext();)
            {
                MultiBlock mb = (MultiBlock)iterator.next();
                if(mb.getTriggerBlock() == b.getType())
                {
                    org.bukkit.Material blocks[] = mb.getBuild();
                    if(mb.getTriggerBlock() == blocks[1])
                    {
                        if(BlockAdjacents.hasMaterialOnSide(b, blocks[0]) && BlockAdjacents.hasMaterialOnSide(b, blocks[2]) && BlockAdjacents.isMaterial(b.getRelative(BlockFace.DOWN), blocks[4]) && BlockAdjacents.hasMaterialOnSide(b.getRelative(BlockFace.DOWN), blocks[3]) && BlockAdjacents.hasMaterialOnSide(b.getRelative(BlockFace.DOWN), blocks[5]) && BlockAdjacents.isMaterial(b.getRelative(BlockFace.DOWN).getRelative(BlockFace.DOWN), blocks[7]) && BlockAdjacents.hasMaterialOnSide(b.getRelative(BlockFace.DOWN).getRelative(BlockFace.DOWN), blocks[6]) && BlockAdjacents.hasMaterialOnSide(b.getRelative(BlockFace.DOWN).getRelative(BlockFace.DOWN), blocks[8]) && (blocks[0] == null || blocks[0] != blocks[2] || BlockAdjacents.hasMaterialOnBothSides(b.getRelative(0, 0, 0), blocks[0])) && (blocks[3] == null || blocks[3] != blocks[5] || BlockAdjacents.hasMaterialOnBothSides(b.getRelative(0, -1, 0), blocks[5])) && (blocks[6] == null || blocks[6] != blocks[8] || BlockAdjacents.hasMaterialOnBothSides(b.getRelative(0, -2, 0), blocks[8])))
                            multiblocks.add(mb);
                    } else
                    if(mb.getTriggerBlock() == blocks[4])
                    {
                        if(BlockAdjacents.hasMaterialOnSide(b, blocks[3]) && BlockAdjacents.hasMaterialOnSide(b, blocks[5]) && BlockAdjacents.isMaterial(b.getRelative(BlockFace.DOWN), blocks[7]) && BlockAdjacents.hasMaterialOnSide(b.getRelative(BlockFace.DOWN), blocks[6]) && BlockAdjacents.hasMaterialOnSide(b.getRelative(BlockFace.DOWN), blocks[8]) && BlockAdjacents.isMaterial(b.getRelative(BlockFace.UP), blocks[1]) && BlockAdjacents.hasMaterialOnSide(b.getRelative(BlockFace.UP), blocks[0]) && BlockAdjacents.hasMaterialOnSide(b.getRelative(BlockFace.UP), blocks[2]) && (blocks[0] == null || blocks[0] != blocks[2] || BlockAdjacents.hasMaterialOnBothSides(b.getRelative(0, 1, 0), blocks[0])) && (blocks[3] == null || blocks[3] != blocks[5] || BlockAdjacents.hasMaterialOnBothSides(b.getRelative(0, 0, 0), blocks[5])) && (blocks[6] == null || blocks[6] != blocks[8] || BlockAdjacents.hasMaterialOnBothSides(b.getRelative(0, -1, 0), blocks[8])))
                            multiblocks.add(mb);
                    } else
                    if(mb.getTriggerBlock() == blocks[7] && BlockAdjacents.hasMaterialOnSide(b, blocks[6]) && BlockAdjacents.hasMaterialOnSide(b, blocks[8]) && BlockAdjacents.isMaterial(b.getRelative(BlockFace.UP).getRelative(BlockFace.UP), blocks[1]) && BlockAdjacents.hasMaterialOnSide(b.getRelative(BlockFace.UP).getRelative(BlockFace.UP), blocks[0]) && BlockAdjacents.hasMaterialOnSide(b.getRelative(BlockFace.UP).getRelative(BlockFace.UP), blocks[2]) && BlockAdjacents.isMaterial(b.getRelative(BlockFace.UP), blocks[4]) && BlockAdjacents.hasMaterialOnSide(b.getRelative(BlockFace.UP), blocks[3]) && BlockAdjacents.hasMaterialOnSide(b.getRelative(BlockFace.UP), blocks[5]) && (blocks[0] == null || blocks[0] != blocks[2] || BlockAdjacents.hasMaterialOnBothSides(b.getRelative(0, 2, 0), blocks[0])) && (blocks[3] == null || blocks[3] != blocks[5] || BlockAdjacents.hasMaterialOnBothSides(b.getRelative(0, 1, 0), blocks[5])) && (blocks[6] == null || blocks[6] != blocks[8] || BlockAdjacents.hasMaterialOnBothSides(b.getRelative(0, 0, 0), blocks[8])))
                        multiblocks.add(mb);
                }
            }

            if(!multiblocks.isEmpty())
            {
                e.setCancelled(true);
                for(Iterator iterator1 = SlimefunItem.getHandlers("MultiBlockInteractionHandler").iterator(); iterator1.hasNext();)
                {
                    ItemHandler handler = (ItemHandler)iterator1.next();
                    if(((MultiBlockInteractionHandler)handler).onInteract(p, (MultiBlock)multiblocks.get(multiblocks.size() - 1), b))
                        break;
                }

                MultiBlockInteractEvent event = new MultiBlockInteractEvent(p, (MultiBlock)multiblocks.get(multiblocks.size() - 1), b);
                Bukkit.getPluginManager().callEvent(event);
            }
        }
    }
}

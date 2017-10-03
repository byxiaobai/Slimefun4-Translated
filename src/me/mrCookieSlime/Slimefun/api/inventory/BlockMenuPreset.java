// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   BlockMenuPreset.java

package me.mrCookieSlime.Slimefun.api.inventory;

import java.util.*;
import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu;
import me.mrCookieSlime.Slimefun.SlimefunStartup;
import me.mrCookieSlime.Slimefun.api.item_transport.ItemTransportFlow;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitScheduler;

// Referenced classes of package me.mrCookieSlime.Slimefun.api.inventory:
//            BlockMenu, UniversalBlockMenu, ItemManipulationEvent

public abstract class BlockMenuPreset extends ChestMenu
{

    public static Map presets = new HashMap();
    private String title;
    private Set occupied;
    private String id;
    private int size;
    private boolean universal;
    private ItemManipulationEvent event;

    public BlockMenuPreset(String id, String title)
    {
        super(title);
        occupied = new HashSet();
        size = -1;
        this.id = id;
        this.title = title;
        init();
        universal = false;
        presets.put(id, this);
    }

    public void registerEvent(ItemManipulationEvent event)
    {
        this.event = event;
    }

    public BlockMenuPreset(String id, String title, boolean universal)
    {
        super(title);
        occupied = new HashSet();
        size = -1;
        this.id = id;
        this.title = title;
        init();
        this.universal = universal;
        presets.put(id, this);
    }

    public abstract void init();

    public abstract void newInstance(BlockMenu blockmenu, Block block);

    public abstract boolean canOpen(Block block, Player player);

    public abstract int[] getSlotsAccessedByItemTransport(ItemTransportFlow itemtransportflow);

    public int[] getSlotsAccessedByItemTransport(BlockMenu menu, ItemTransportFlow flow, ItemStack item)
    {
        return getSlotsAccessedByItemTransport(flow);
    }

    public int[] getSlotsAccessedByItemTransport(UniversalBlockMenu menu, ItemTransportFlow flow, ItemStack item)
    {
        return getSlotsAccessedByItemTransport(flow);
    }

    public ChestMenu addItem(int slot, ItemStack item)
    {
        occupied.add(Integer.valueOf(slot));
        return super.addItem(slot, item);
    }

    public ChestMenu setSize(int size)
    {
        this.size = size;
        return this;
    }

    public int getSize()
    {
        return size;
    }

    public String getTitle()
    {
        return title;
    }

    public Set getPresetSlots()
    {
        return occupied;
    }

    public Set getInventorySlots()
    {
        Set empty = new HashSet();
        if(size > -1)
        {
            for(int i = 0; i < size; i++)
                if(!occupied.contains(Integer.valueOf(i)))
                    empty.add(Integer.valueOf(i));

        } else
        {
            for(int i = 0; i < toInventory().getSize(); i++)
                if(!occupied.contains(Integer.valueOf(i)))
                    empty.add(Integer.valueOf(i));

        }
        return empty;
    }

    public static BlockMenuPreset getPreset(String id)
    {
        return (BlockMenuPreset)presets.get(id);
    }

    public static boolean isInventory(String id)
    {
        return presets.containsKey(id);
    }

    public static boolean isUniversalInventory(String id)
    {
        return presets.containsKey(id) && ((BlockMenuPreset)presets.get(id)).isUniversal();
    }

    public boolean isUniversal()
    {
        return universal;
    }

    public void clone(BlockMenu menu)
    {
        menu.setPlayerInventoryClickable(true);
        int slot;
        for(Iterator iterator = occupied.iterator(); iterator.hasNext(); menu.addItem(slot, getItemInSlot(slot)))
            slot = ((Integer)iterator.next()).intValue();

        if(size > -1)
            menu.addItem(size - 1, null);
        newInstance(menu, menu.getLocation());
        for(int slot = 0; slot < 54; slot++)
            if(getMenuClickHandler(slot) != null)
                menu.addMenuClickHandler(slot, getMenuClickHandler(slot));

        menu.addMenuOpeningHandler(getMenuOpeningHandler());
        menu.addMenuCloseHandler(getMenuCloseHandler());
        menu.registerEvent(event);
    }

    public void clone(UniversalBlockMenu menu)
    {
        menu.setPlayerInventoryClickable(true);
        int slot;
        for(Iterator iterator = occupied.iterator(); iterator.hasNext(); menu.addItem(slot, getItemInSlot(slot)))
            slot = ((Integer)iterator.next()).intValue();

        if(size > -1)
            menu.addItem(size - 1, null);
        for(int slot = 0; slot < 54; slot++)
            if(getMenuClickHandler(slot) != null)
                menu.addMenuClickHandler(slot, getMenuClickHandler(slot));

        menu.addMenuOpeningHandler(getMenuOpeningHandler());
        menu.addMenuCloseHandler(getMenuCloseHandler());
        menu.registerEvent(event);
    }

    public String getID()
    {
        return id;
    }

    public void newInstance(final BlockMenu menu, final Location l)
    {
        Bukkit.getScheduler().scheduleSyncDelayedTask(SlimefunStartup.instance, new Runnable() {

            final BlockMenuPreset this$0;
            private final BlockMenu val$menu;
            private final Location val$l;

            public void run()
            {
                newInstance(menu, l.getBlock());
            }

            
            {
                this$0 = BlockMenuPreset.this;
                menu = blockmenu;
                l = location;
                super();
            }
        }
);
    }

}

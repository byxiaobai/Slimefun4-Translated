// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   ItemRequest.java

package me.mrCookieSlime.Slimefun.api.item_transport;

import org.bukkit.Location;
import org.bukkit.inventory.ItemStack;

// Referenced classes of package me.mrCookieSlime.Slimefun.api.item_transport:
//            ItemTransportFlow

public class ItemRequest
{

    ItemStack item;
    ItemTransportFlow flow;
    Location terminal;
    int slot;

    public ItemRequest(Location terminal, int slot, ItemStack item, ItemTransportFlow flow)
    {
        this.terminal = terminal;
        this.item = item;
        this.slot = slot;
        this.flow = flow;
    }

    public Location getTerminal()
    {
        return terminal;
    }

    public ItemStack getItem()
    {
        return item;
    }

    public ItemTransportFlow getDirection()
    {
        return flow;
    }

    public int getSlot()
    {
        return slot;
    }
}

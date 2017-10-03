// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   ItemSlot.java

package me.mrCookieSlime.Slimefun.api.item_transport;

import org.bukkit.inventory.ItemStack;

public class ItemSlot
{

    public int slot;
    public ItemStack item;

    public ItemSlot(ItemStack item, int slot)
    {
        this.slot = slot;
        this.item = item;
    }

    public int getSlot()
    {
        return slot;
    }

    public ItemStack getItem()
    {
        return item;
    }
}

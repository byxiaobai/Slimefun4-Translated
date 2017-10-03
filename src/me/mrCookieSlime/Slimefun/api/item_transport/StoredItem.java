// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   StoredItem.java

package me.mrCookieSlime.Slimefun.api.item_transport;

import org.bukkit.inventory.ItemStack;

public class StoredItem
{

    public int amount;
    public ItemStack item;

    public StoredItem(ItemStack item, int amount)
    {
        this.amount = amount;
        this.item = item;
    }

    public int getAmount()
    {
        return amount;
    }

    public ItemStack getItem()
    {
        return item;
    }

    public void add(int amount)
    {
        this.amount = this.amount + amount;
    }
}

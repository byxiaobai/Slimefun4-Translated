// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   RecipeSorter.java

package me.mrCookieSlime.Slimefun.api.item_transport;

import java.util.Comparator;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import org.bukkit.inventory.ItemStack;

public class RecipeSorter
    implements Comparator
{

    BlockMenu menu;

    public RecipeSorter(BlockMenu menu)
    {
        this.menu = menu;
    }

    public int compare(Integer slot1, Integer slot2)
    {
        return menu.getItemInSlot(slot1.intValue()).getAmount() - menu.getItemInSlot(slot2.intValue()).getAmount();
    }

    public volatile int compare(Object obj, Object obj1)
    {
        return compare((Integer)obj, (Integer)obj1);
    }
}

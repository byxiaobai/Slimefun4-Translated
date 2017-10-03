// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   Soul.java

package me.mrCookieSlime.Slimefun.api;

import java.util.*;
import me.mrCookieSlime.Slimefun.Variables;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class Soul
{

    public Soul()
    {
    }

    public static void storeItem(UUID uuid, ItemStack drop)
    {
        List items = new ArrayList();
        if(Variables.soulbound.containsKey(uuid))
            items = (List)Variables.soulbound.get(uuid);
        items.add(drop);
        Variables.soulbound.put(uuid, items);
    }

    public static void retrieveItems(Player p)
    {
        if(Variables.soulbound.containsKey(p.getUniqueId()))
        {
            ItemStack item;
            for(Iterator iterator = ((List)Variables.soulbound.get(p.getUniqueId())).iterator(); iterator.hasNext(); p.getInventory().addItem(new ItemStack[] {
    item
}))
                item = (ItemStack)iterator.next();

            Variables.soulbound.remove(p.getUniqueId());
        }
    }
}

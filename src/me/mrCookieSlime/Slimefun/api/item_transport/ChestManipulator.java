// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   ChestManipulator.java

package me.mrCookieSlime.Slimefun.api.item_transport;

import java.util.*;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;

// Referenced classes of package me.mrCookieSlime.Slimefun.api.item_transport:
//            CargoTransportEvent

public class ChestManipulator
{

    public static List listeners = new ArrayList();

    public ChestManipulator()
    {
    }

    public static void registerListener(CargoTransportEvent listener)
    {
        listeners.add(listener);
    }

    public static ItemStack trigger(Block b, int slot, ItemStack prev, ItemStack next)
    {
        for(Iterator iterator = listeners.iterator(); iterator.hasNext();)
        {
            CargoTransportEvent listener = (CargoTransportEvent)iterator.next();
            next = listener.onEvent(b, slot, prev, next);
        }

        return next;
    }

}

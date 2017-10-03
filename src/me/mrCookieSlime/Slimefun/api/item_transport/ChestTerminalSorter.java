// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   ChestTerminalSorter.java

package me.mrCookieSlime.Slimefun.api.item_transport;

import java.util.Comparator;

// Referenced classes of package me.mrCookieSlime.Slimefun.api.item_transport:
//            StoredItem

public class ChestTerminalSorter
    implements Comparator
{

    public ChestTerminalSorter()
    {
    }

    public int compare(StoredItem item1, StoredItem item2)
    {
        return item2.getAmount() - item1.getAmount();
    }

    public volatile int compare(Object obj, Object obj1)
    {
        return compare((StoredItem)obj, (StoredItem)obj1);
    }
}

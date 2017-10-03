// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   Category.java

package me.mrCookieSlime.Slimefun.Objects;

import java.util.*;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.URID.URID;
import me.mrCookieSlime.Slimefun.api.Slimefun;
import org.bukkit.inventory.ItemStack;

// Referenced classes of package me.mrCookieSlime.Slimefun.Objects:
//            SeasonCategory

public class Category
{
    class CategorySorter
        implements Comparator
    {

        final Category this$0;

        public int compare(Category c1, Category c2)
        {
            return c1.getTier() <= c2.getTier() ? c1.getTier() != c2.getTier() ? -1 : 0 : 1;
        }

        public volatile int compare(Object obj, Object obj1)
        {
            return compare((Category)obj, (Category)obj1);
        }

        CategorySorter()
        {
            this$0 = Category.this;
            super();
        }
    }


    public static List list = new ArrayList();
    private ItemStack item;
    private List items;
    private URID urid;
    private int tier;

    public Category(ItemStack item)
    {
        this.item = item;
        items = new ArrayList();
        urid = URID.nextURID(this, false);
        tier = 3;
    }

    public Category(ItemStack item, int tier)
    {
        this.item = item;
        items = new ArrayList();
        urid = URID.nextURID(this, false);
        this.tier = tier;
    }

    public void register()
    {
        list.add(this);
        Collections.sort(list, new CategorySorter());
        if(this instanceof SeasonCategory)
        {
            if(((SeasonCategory)this).isUnlocked())
                Slimefun.current_categories.add(this);
        } else
        {
            Slimefun.current_categories.add(this);
        }
        Collections.sort(Slimefun.current_categories, new CategorySorter());
    }

    public static List list()
    {
        return list;
    }

    public void add(SlimefunItem item)
    {
        items.add(item);
    }

    public ItemStack getItem()
    {
        return item;
    }

    public List getItems()
    {
        return items;
    }

    public static Category getByItem(ItemStack item)
    {
        for(Iterator iterator = list.iterator(); iterator.hasNext();)
        {
            Category c = (Category)iterator.next();
            if(c.getItem().isSimilar(item))
                return c;
        }

        return null;
    }

    public URID getURID()
    {
        return urid;
    }

    public int getTier()
    {
        return tier;
    }

}

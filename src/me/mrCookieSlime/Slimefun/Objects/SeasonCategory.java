// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   SeasonCategory.java

package me.mrCookieSlime.Slimefun.Objects;

import java.util.Calendar;
import org.bukkit.inventory.ItemStack;

// Referenced classes of package me.mrCookieSlime.Slimefun.Objects:
//            Category

public class SeasonCategory extends Category
{

    private int month;

    public SeasonCategory(int month, int tier, ItemStack item)
    {
        super(item, tier);
        this.month = -1;
        this.month = month - 1;
    }

    public int getMonth()
    {
        return month;
    }

    public boolean isUnlocked()
    {
        if(month == -1)
            return true;
        Calendar calendar = Calendar.getInstance();
        return month == calendar.get(2);
    }
}

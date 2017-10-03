// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   MultiTool.java

package me.mrCookieSlime.Slimefun.Objects.SlimefunItem;

import java.util.ArrayList;
import java.util.List;
import me.mrCookieSlime.Slimefun.Lists.Categories;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.api.Slimefun;
import org.bukkit.inventory.ItemStack;

// Referenced classes of package me.mrCookieSlime.Slimefun.Objects.SlimefunItem:
//            DamagableChargableItem

public class MultiTool extends DamagableChargableItem
{

    List modes;

    public MultiTool(ItemStack item, String name, RecipeType recipeType, ItemStack recipe[], String keys[], Object values[])
    {
        super(Categories.TECH, item, name, recipeType, recipe, "Multi Tool", keys, values);
    }

    public void create()
    {
        List list = new ArrayList();
        for(int i = 0; i < 50; i++)
            if(Slimefun.getItemValue(name, (new StringBuilder("mode.")).append(i).append(".enabled").toString()) != null && ((Boolean)Slimefun.getItemValue(name, (new StringBuilder("mode.")).append(i).append(".enabled").toString())).booleanValue())
                list.add(Integer.valueOf(i));

        modes = list;
    }

    public List getModes()
    {
        return modes;
    }
}

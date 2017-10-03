// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   Alloy.java

package me.mrCookieSlime.Slimefun.Objects.SlimefunItem;

import me.mrCookieSlime.Slimefun.Lists.Categories;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import org.bukkit.inventory.ItemStack;

// Referenced classes of package me.mrCookieSlime.Slimefun.Objects.SlimefunItem:
//            SlimefunItem

public class Alloy extends SlimefunItem
{

    public Alloy(ItemStack item, String id, ItemStack recipe[])
    {
        super(Categories.RESOURCES, item, id, RecipeType.SMELTERY, recipe);
    }

    public Alloy(Category category, ItemStack item, String id, ItemStack recipe[])
    {
        super(category, item, id, RecipeType.SMELTERY, recipe);
    }
}

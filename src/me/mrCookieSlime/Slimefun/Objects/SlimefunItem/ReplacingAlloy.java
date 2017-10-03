// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   ReplacingAlloy.java

package me.mrCookieSlime.Slimefun.Objects.SlimefunItem;

import me.mrCookieSlime.Slimefun.Lists.Categories;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import org.bukkit.inventory.ItemStack;

// Referenced classes of package me.mrCookieSlime.Slimefun.Objects.SlimefunItem:
//            ReplacingItem

public class ReplacingAlloy extends ReplacingItem
{

    public ReplacingAlloy(ItemStack item, String name, ItemStack recipe[])
    {
        super(Categories.RESOURCES, item, name, RecipeType.SMELTERY, recipe);
    }

    public ReplacingAlloy(Category category, ItemStack item, String name, ItemStack recipe[])
    {
        super(category, item, name, RecipeType.SMELTERY, recipe);
    }
}

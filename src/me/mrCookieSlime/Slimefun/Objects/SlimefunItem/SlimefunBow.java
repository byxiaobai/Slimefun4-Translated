// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   SlimefunBow.java

package me.mrCookieSlime.Slimefun.Objects.SlimefunItem;

import me.mrCookieSlime.Slimefun.Lists.Categories;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import org.bukkit.inventory.ItemStack;

// Referenced classes of package me.mrCookieSlime.Slimefun.Objects.SlimefunItem:
//            SlimefunItem

public class SlimefunBow extends SlimefunItem
{

    public SlimefunBow(ItemStack item, String name, ItemStack recipe[])
    {
        super(Categories.WEAPONS, item, name, RecipeType.MAGIC_WORKBENCH, recipe);
    }
}

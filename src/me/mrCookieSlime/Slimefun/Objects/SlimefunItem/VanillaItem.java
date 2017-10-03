// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   VanillaItem.java

package me.mrCookieSlime.Slimefun.Objects.SlimefunItem;

import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import org.bukkit.inventory.ItemStack;

// Referenced classes of package me.mrCookieSlime.Slimefun.Objects.SlimefunItem:
//            SlimefunItem

public class VanillaItem extends SlimefunItem
{

    public VanillaItem(Category category, ItemStack item, String id, RecipeType recipeType, ItemStack recipe[])
    {
        super(category, item, id, recipeType, recipe);
    }
}

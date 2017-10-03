// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   ExcludedSoulboundTool.java

package me.mrCookieSlime.Slimefun.Objects.SlimefunItem;

import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.Interfaces.NotPlaceable;
import org.bukkit.inventory.ItemStack;

// Referenced classes of package me.mrCookieSlime.Slimefun.Objects.SlimefunItem:
//            SoulboundItem

public class ExcludedSoulboundTool extends SoulboundItem
    implements NotPlaceable
{

    public ExcludedSoulboundTool(Category category, ItemStack item, String name, RecipeType type, ItemStack recipe[])
    {
        super(category, item, name, type, recipe);
    }

    public ExcludedSoulboundTool(Category category, ItemStack item, String name, ItemStack recipe[])
    {
        super(category, item, name, recipe);
    }
}

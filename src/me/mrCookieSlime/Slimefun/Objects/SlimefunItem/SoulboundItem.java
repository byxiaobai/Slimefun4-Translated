// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   SoulboundItem.java

package me.mrCookieSlime.Slimefun.Objects.SlimefunItem;

import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import org.bukkit.inventory.ItemStack;

// Referenced classes of package me.mrCookieSlime.Slimefun.Objects.SlimefunItem:
//            SlimefunItem

public class SoulboundItem extends SlimefunItem
{

    public SoulboundItem(Category category, ItemStack item, String name, ItemStack recipe[])
    {
        super(category, item, name, RecipeType.MAGIC_WORKBENCH, recipe);
    }

    public SoulboundItem(Category category, ItemStack item, String name, RecipeType type, ItemStack recipe[])
    {
        super(category, item, name, type, recipe);
    }
}

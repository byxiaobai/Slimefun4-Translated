// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   SoulboundBackpack.java

package me.mrCookieSlime.Slimefun.Objects.SlimefunItem;

import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import org.bukkit.inventory.ItemStack;

// Referenced classes of package me.mrCookieSlime.Slimefun.Objects.SlimefunItem:
//            SlimefunBackpack

public class SoulboundBackpack extends SlimefunBackpack
{

    public SoulboundBackpack(int size, Category category, ItemStack item, String name, ItemStack recipe[])
    {
        super(size, category, item, name, RecipeType.MAGIC_WORKBENCH, recipe);
    }

    public SoulboundBackpack(int size, Category category, ItemStack item, String name, RecipeType type, ItemStack recipe[])
    {
        super(size, category, item, name, type, recipe);
    }
}

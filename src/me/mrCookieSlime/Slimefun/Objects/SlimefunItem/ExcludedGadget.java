// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   ExcludedGadget.java

package me.mrCookieSlime.Slimefun.Objects.SlimefunItem;

import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.Interfaces.NotPlaceable;
import org.bukkit.inventory.ItemStack;

// Referenced classes of package me.mrCookieSlime.Slimefun.Objects.SlimefunItem:
//            SlimefunGadget

public class ExcludedGadget extends SlimefunGadget
    implements NotPlaceable
{

    public ExcludedGadget(Category category, ItemStack item, String name, RecipeType recipeType, ItemStack recipe[], ItemStack machineRecipes[])
    {
        super(category, item, name, recipeType, recipe, machineRecipes);
    }

    public ExcludedGadget(Category category, ItemStack item, String name, RecipeType recipeType, ItemStack recipe[], ItemStack machineRecipes[], String keys[], 
            Object values[])
    {
        super(category, item, name, recipeType, recipe, machineRecipes, keys, values);
    }
}

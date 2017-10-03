// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   ElectricFurnace.java

package me.mrCookieSlime.Slimefun.Objects.SlimefunItem.machines;

import java.util.Iterator;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems.AContainer;
import org.bukkit.Bukkit;
import org.bukkit.inventory.*;

public abstract class ElectricFurnace extends AContainer
{

    public ElectricFurnace(Category category, ItemStack item, String name, RecipeType recipeType, ItemStack recipe[])
    {
        super(category, item, name, recipeType, recipe);
    }

    public void registerDefaultRecipes()
    {
        for(Iterator iterator = Bukkit.recipeIterator(); iterator.hasNext();)
        {
            Recipe r = (Recipe)iterator.next();
            if(r instanceof FurnaceRecipe)
                registerRecipe(4, new ItemStack[] {
                    ((FurnaceRecipe)r).getInput()
                }, new ItemStack[] {
                    r.getResult()
                });
        }

    }

    public String getMachineIdentifier()
    {
        return "ELECTRIC_FURNACE";
    }
}

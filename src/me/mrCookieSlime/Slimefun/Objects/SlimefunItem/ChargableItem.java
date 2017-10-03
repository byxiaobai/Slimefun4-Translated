// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   ChargableItem.java

package me.mrCookieSlime.Slimefun.Objects.SlimefunItem;

import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import org.bukkit.inventory.ItemStack;

// Referenced classes of package me.mrCookieSlime.Slimefun.Objects.SlimefunItem:
//            SlimefunItem

public class ChargableItem extends SlimefunItem
{

    String chargeType;

    public ChargableItem(Category category, ItemStack item, String name, RecipeType recipeType, ItemStack recipe[], String chargeType)
    {
        super(category, item, name, recipeType, recipe);
        this.chargeType = chargeType;
    }

    public ChargableItem(Category category, ItemStack item, String name, RecipeType recipeType, ItemStack recipe[], String chargeType, String keys[], 
            Object values[])
    {
        super(category, item, name, recipeType, recipe, keys, values);
        this.chargeType = chargeType;
    }

    public String getChargeType()
    {
        return chargeType;
    }
}

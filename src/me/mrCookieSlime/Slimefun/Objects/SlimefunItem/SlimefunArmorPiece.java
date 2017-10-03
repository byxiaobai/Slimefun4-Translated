// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   SlimefunArmorPiece.java

package me.mrCookieSlime.Slimefun.Objects.SlimefunItem;

import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;

// Referenced classes of package me.mrCookieSlime.Slimefun.Objects.SlimefunItem:
//            SlimefunItem

public class SlimefunArmorPiece extends SlimefunItem
{

    PotionEffect effects[];

    public SlimefunArmorPiece(Category category, ItemStack item, String name, RecipeType recipeType, ItemStack recipe[], PotionEffect effects[])
    {
        super(category, item, name, recipeType, recipe);
        this.effects = effects;
    }

    public SlimefunArmorPiece(Category category, ItemStack item, String name, RecipeType recipeType, ItemStack recipe[], PotionEffect effects[], String keys[], 
            Object values[])
    {
        super(category, item, name, recipeType, recipe, keys, values);
        this.effects = effects;
    }

    public PotionEffect[] getEffects()
    {
        return effects;
    }
}

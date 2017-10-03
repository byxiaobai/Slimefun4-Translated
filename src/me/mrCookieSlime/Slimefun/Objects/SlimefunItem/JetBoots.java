// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   JetBoots.java

package me.mrCookieSlime.Slimefun.Objects.SlimefunItem;

import me.mrCookieSlime.Slimefun.Lists.Categories;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import org.bukkit.inventory.ItemStack;

// Referenced classes of package me.mrCookieSlime.Slimefun.Objects.SlimefunItem:
//            DamagableChargableItem

public class JetBoots extends DamagableChargableItem
{

    double speed;

    public JetBoots(ItemStack item, String name, ItemStack recipe[], double speed)
    {
        super(Categories.TECH, item, name, RecipeType.ENHANCED_CRAFTING_TABLE, recipe, "Jet Boots");
        this.speed = speed;
    }

    public double getSpeed()
    {
        return speed;
    }
}

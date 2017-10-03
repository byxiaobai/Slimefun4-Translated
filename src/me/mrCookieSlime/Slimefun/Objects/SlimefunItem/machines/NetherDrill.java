// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   NetherDrill.java

package me.mrCookieSlime.Slimefun.Objects.SlimefunItem.machines;

import me.mrCookieSlime.Slimefun.GEO.OreGenResource;
import me.mrCookieSlime.Slimefun.GEO.OreGenSystem;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Lists.SlimefunItems;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems.ADrill;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public abstract class NetherDrill extends ADrill
{

    public NetherDrill(Category category, ItemStack item, String name, RecipeType recipeType, ItemStack recipe[])
    {
        super(category, item, name, recipeType, recipe);
    }

    public OreGenResource getOreGenResource()
    {
        return OreGenSystem.getResource("Nether Ice");
    }

    public ItemStack[] getOutputItems()
    {
        return (new ItemStack[] {
            SlimefunItems.NETHER_ICE
        });
    }

    public int getProcessingTime()
    {
        return 24;
    }

    public String getInventoryTitle()
    {
        return "&4Nether Drill";
    }

    public ItemStack getProgressBar()
    {
        return new ItemStack(Material.DIAMOND_PICKAXE);
    }

    public String getMachineIdentifier()
    {
        return "NETHER_DRILL";
    }
}

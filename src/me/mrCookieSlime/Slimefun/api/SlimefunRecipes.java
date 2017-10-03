// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   SlimefunRecipes.java

package me.mrCookieSlime.Slimefun.api;

import java.util.Iterator;
import java.util.List;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems.AContainer;
import org.bukkit.inventory.ItemStack;

public class SlimefunRecipes
{

    public SlimefunRecipes()
    {
    }

    public static void registerMachineRecipe(String machine, int seconds, ItemStack input[], ItemStack output[])
    {
        for(Iterator iterator = SlimefunItem.all.iterator(); iterator.hasNext();)
        {
            SlimefunItem item = (SlimefunItem)iterator.next();
            if((item instanceof AContainer) && ((AContainer)item).getMachineIdentifier().equals(machine))
                ((AContainer)item).registerRecipe(seconds, input, output);
        }

    }
}

// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   SlimefunGadget.java

package me.mrCookieSlime.Slimefun.Objects.SlimefunItem;

import java.util.ArrayList;
import java.util.List;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import org.bukkit.inventory.ItemStack;

// Referenced classes of package me.mrCookieSlime.Slimefun.Objects.SlimefunItem:
//            SlimefunItem

public class SlimefunGadget extends SlimefunItem
{

    List recipes;
    List display_recipes;

    public SlimefunGadget(Category category, ItemStack item, String name, RecipeType recipeType, ItemStack recipe[], ItemStack machineRecipes[])
    {
        super(category, item, name, recipeType, recipe);
        recipes = new ArrayList();
        display_recipes = new ArrayList();
        ItemStack aitemstack[];
        int k = (aitemstack = machineRecipes).length;
        for(int j = 0; j < k; j++)
        {
            ItemStack i = aitemstack[j];
            recipes.add(new ItemStack[] {
                i
            });
            display_recipes.add(i);
        }

    }

    public SlimefunGadget(Category category, ItemStack item, String name, RecipeType recipeType, ItemStack recipe[], ItemStack machineRecipes[], String keys[], 
            Object values[])
    {
        super(category, item, name, recipeType, recipe, keys, values);
        recipes = new ArrayList();
        display_recipes = new ArrayList();
        ItemStack aitemstack[];
        int k = (aitemstack = machineRecipes).length;
        for(int j = 0; j < k; j++)
        {
            ItemStack i = aitemstack[j];
            recipes.add(new ItemStack[] {
                i
            });
            display_recipes.add(i);
        }

    }

    public List getRecipes()
    {
        return recipes;
    }

    public List getDisplayRecipes()
    {
        return display_recipes;
    }

    public void addRecipe(ItemStack input, ItemStack output)
    {
        recipes.add(new ItemStack[] {
            input
        });
        recipes.add(new ItemStack[] {
            output
        });
        display_recipes.add(input);
        display_recipes.add(output);
    }
}

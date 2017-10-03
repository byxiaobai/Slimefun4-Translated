// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   SlimefunMachine.java

package me.mrCookieSlime.Slimefun.Objects.SlimefunItem;

import java.util.*;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.Objects.MultiBlock;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

// Referenced classes of package me.mrCookieSlime.Slimefun.Objects.SlimefunItem:
//            SlimefunItem

public class SlimefunMachine extends SlimefunItem
{

    List recipes;
    List shownRecipes;
    Material trigger;

    public SlimefunMachine(Category category, ItemStack item, String name, ItemStack recipe[], ItemStack machineRecipes[], Material trigger)
    {
        super(category, item, name, RecipeType.MULTIBLOCK, recipe);
        recipes = new ArrayList();
        shownRecipes = new ArrayList();
        ItemStack aitemstack[];
        int k = (aitemstack = machineRecipes).length;
        for(int j = 0; j < k; j++)
        {
            ItemStack i = aitemstack[j];
            shownRecipes.add(i);
        }

        this.trigger = trigger;
    }

    public SlimefunMachine(Category category, ItemStack item, String name, ItemStack recipe[], ItemStack machineRecipes[], Material trigger, boolean ghost)
    {
        super(category, item, name, RecipeType.MULTIBLOCK, recipe, ghost);
        recipes = new ArrayList();
        shownRecipes = new ArrayList();
        ItemStack aitemstack[];
        int k = (aitemstack = machineRecipes).length;
        for(int j = 0; j < k; j++)
        {
            ItemStack i = aitemstack[j];
            shownRecipes.add(i);
        }

        this.trigger = trigger;
    }

    public SlimefunMachine(Category category, ItemStack item, String name, ItemStack recipe[], ItemStack machineRecipes[], Material trigger, String keys[], 
            Object values[])
    {
        super(category, item, name, RecipeType.MULTIBLOCK, recipe, keys, values);
        recipes = new ArrayList();
        shownRecipes = new ArrayList();
        ItemStack aitemstack[];
        int k = (aitemstack = machineRecipes).length;
        for(int j = 0; j < k; j++)
        {
            ItemStack i = aitemstack[j];
            shownRecipes.add(i);
        }

        this.trigger = trigger;
    }

    public List getRecipes()
    {
        return recipes;
    }

    public List getDisplayRecipes()
    {
        return shownRecipes;
    }

    public void addRecipe(ItemStack input[], ItemStack output)
    {
        recipes.add(input);
        recipes.add(new ItemStack[] {
            output
        });
    }

    public void create()
    {
        toMultiBlock().register();
    }

    public void install()
    {
        for(Iterator iterator = getDisplayRecipes().iterator(); iterator.hasNext();)
        {
            ItemStack i = (ItemStack)iterator.next();
            SlimefunItem item = SlimefunItem.getByItem(i);
            if(item == null)
                recipes.add(new ItemStack[] {
                    i
                });
            else
            if(!SlimefunItem.isDisabled(i))
                recipes.add(new ItemStack[] {
                    i
                });
        }

    }

    public MultiBlock toMultiBlock()
    {
        List mats = new ArrayList();
        ItemStack aitemstack[];
        int k = (aitemstack = recipe).length;
        for(int j = 0; j < k; j++)
        {
            ItemStack i = aitemstack[j];
            if(i == null)
                mats.add(null);
            else
            if(i.getType() == Material.CAULDRON_ITEM)
                mats.add(Material.CAULDRON);
            else
            if(i.getType() == Material.FLINT_AND_STEEL)
                mats.add(Material.FIRE);
            else
                mats.add(i.getType());
        }

        Material build[] = (Material[])mats.toArray(new Material[mats.size()]);
        return new MultiBlock(build, trigger);
    }

    public Iterator recipeIterator()
    {
        return recipes.iterator();
    }
}

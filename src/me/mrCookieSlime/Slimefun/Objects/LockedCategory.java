// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   LockedCategory.java

package me.mrCookieSlime.Slimefun.Objects;

import java.util.*;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.api.Slimefun;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

// Referenced classes of package me.mrCookieSlime.Slimefun.Objects:
//            Category, Research

public class LockedCategory extends Category
{

    private List parents;

    public transient LockedCategory(ItemStack item, Category parents[])
    {
        super(item);
        this.parents = Arrays.asList(parents);
    }

    public transient LockedCategory(ItemStack item, int tier, Category parents[])
    {
        super(item, tier);
        this.parents = Arrays.asList(parents);
    }

    public List getParents()
    {
        return parents;
    }

    public void addParent(Category category)
    {
        if(category == this)
        {
            throw new IllegalArgumentException((new StringBuilder("Category '")).append(getItem().getItemMeta().getDisplayName()).append("' cannot be a parent of itself.").toString());
        } else
        {
            parents.add(category);
            return;
        }
    }

    public void removeParent(Category category)
    {
        parents.remove(category);
    }

    public boolean hasUnlocked(Player p)
    {
        for(Iterator iterator = parents.iterator(); iterator.hasNext();)
        {
            Category category = (Category)iterator.next();
            for(Iterator iterator1 = category.getItems().iterator(); iterator1.hasNext();)
            {
                SlimefunItem item = (SlimefunItem)iterator1.next();
                if(Slimefun.isEnabled(p, item.getItem(), false) && Slimefun.hasPermission(p, item, false) && item.getResearch() != null && !item.getResearch().hasUnlocked(p))
                    return false;
            }

        }

        return true;
    }
}

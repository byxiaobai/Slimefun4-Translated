// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   EnderTalisman.java

package me.mrCookieSlime.Slimefun.Objects.SlimefunItem;

import me.mrCookieSlime.Slimefun.Lists.Categories;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.api.Slimefun;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;

// Referenced classes of package me.mrCookieSlime.Slimefun.Objects.SlimefunItem:
//            SlimefunItem, Talisman

public class EnderTalisman extends SlimefunItem
{

    boolean consumed;
    boolean cancel;
    PotionEffect effects[];
    String suffix;
    int chance;

    public EnderTalisman(Talisman parent)
    {
        super(Categories.TALISMANS_2, parent.upgrade(), (new StringBuilder("ENDER_")).append(parent.getName()).toString(), RecipeType.MAGIC_WORKBENCH, new ItemStack[] {
            SlimefunItem.getItem("ENDER_LUMP_3"), 0, SlimefunItem.getItem("ENDER_LUMP_3"), 0, parent.getItem(), 0, SlimefunItem.getItem("ENDER_LUMP_3"), 0, SlimefunItem.getItem("ENDER_LUMP_3")
        }, parent.upgrade());
        consumed = parent.isConsumable();
        cancel = parent.isEventCancelled();
        suffix = parent.getSuffix();
        effects = parent.getEffects();
        chance = parent.getChance();
        Slimefun.addHint((new StringBuilder("ENDER_")).append(parent.getName()).toString(), new String[] {
            "&eEnder Talismans have the advantage", "&eof still working while they", "&eare in your Ender Chest"
        });
    }

    public PotionEffect[] getEffects()
    {
        return effects;
    }

    public boolean isConsumable()
    {
        return consumed;
    }

    public boolean isEventCancelled()
    {
        return cancel;
    }

    public String getSuffix()
    {
        return suffix;
    }

    public int getChance()
    {
        return chance;
    }
}

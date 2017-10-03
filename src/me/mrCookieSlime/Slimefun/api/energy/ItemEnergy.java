// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   ItemEnergy.java

package me.mrCookieSlime.Slimefun.api.energy;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemEnergy
{

    public ItemEnergy()
    {
    }

    public static float getStoredEnergy(ItemStack item)
    {
        if(item == null || item.getType() == null || item.getType().equals(Material.AIR))
            return 0.0F;
        if(!item.hasItemMeta() || !item.getItemMeta().hasLore())
            return 0.0F;
        for(Iterator iterator = item.getItemMeta().getLore().iterator(); iterator.hasNext();)
        {
            String line = (String)iterator.next();
            if(line.startsWith(ChatColor.translateAlternateColorCodes('&', "&c&o&8\u21E8 &e\u26A1 &7")) && line.contains(" / ") && line.endsWith(" J"))
                return Float.valueOf(line.split(" / ")[0].replace(ChatColor.translateAlternateColorCodes('&', "&c&o&8\u21E8 &e\u26A1 &7"), "")).floatValue();
        }

        return 0.0F;
    }

    public static float getMaxEnergy(ItemStack item)
    {
        if(item == null || item.getType() == null || item.getType().equals(Material.AIR))
            return 0.0F;
        if(!item.hasItemMeta() || !item.getItemMeta().hasLore())
            return 0.0F;
        for(Iterator iterator = item.getItemMeta().getLore().iterator(); iterator.hasNext();)
        {
            String line = (String)iterator.next();
            if(line.startsWith(ChatColor.translateAlternateColorCodes('&', "&c&o&8\u21E8 &e\u26A1 &7")) && line.contains(" / ") && line.endsWith(" J"))
                return Float.valueOf(line.split(" / ")[1].replace(" J", "")).floatValue();
        }

        return 0.0F;
    }

    public static float addStoredEnergy(ItemStack item, float energy)
    {
        if(item == null || item.getType() == null || item.getType().equals(Material.AIR))
            return 0.0F;
        if(!item.hasItemMeta() || !item.getItemMeta().hasLore())
            return 0.0F;
        float rest = 0.0F;
        float capacity = getMaxEnergy(item);
        if(capacity == 0.0F)
            return rest;
        float stored = getStoredEnergy(item);
        if(stored + energy > capacity)
        {
            rest = (stored + energy) - capacity;
            stored = capacity;
        } else
        if(stored + energy < 0.0F)
            stored = 0.0F;
        else
            stored += energy;
        List lore = item.getItemMeta().getLore();
        int index = -1;
        for(int i = 0; i < lore.size(); i++)
        {
            String line = (String)lore.get(i);
            if(!line.startsWith(ChatColor.translateAlternateColorCodes('&', "&c&o&8\u21E8 &e\u26A1 &7")) || !line.contains(" / ") || !line.endsWith(" J"))
                continue;
            index = i;
            break;
        }

        BigDecimal decimal = (new BigDecimal(stored)).setScale(2, 4);
        lore.set(index, (new StringBuilder(String.valueOf(ChatColor.translateAlternateColorCodes('&', "&c&o&8\u21E8 &e\u26A1 &7")))).append(decimal.floatValue()).append(" / ").append(capacity).append(" J").toString());
        ItemMeta im = item.getItemMeta();
        im.setLore(lore);
        item.setItemMeta(im);
        return rest;
    }

    public static ItemStack chargeItem(ItemStack item, float energy)
    {
        addStoredEnergy(item, energy);
        return item;
    }

    public static void chargeInventory(Player p, float energy)
    {
        p.getInventory().setItemInMainHand(chargeItem(p.getInventory().getItemInMainHand(), energy));
        p.getInventory().setItemInOffHand(chargeItem(p.getInventory().getItemInOffHand(), energy));
        p.getInventory().setHelmet(chargeItem(p.getInventory().getHelmet(), energy));
        p.getInventory().setChestplate(chargeItem(p.getInventory().getChestplate(), energy));
        p.getInventory().setLeggings(chargeItem(p.getInventory().getLeggings(), energy));
        p.getInventory().setBoots(chargeItem(p.getInventory().getBoots(), energy));
        me.mrCookieSlime.CSCoreLibPlugin.general.Player.PlayerInventory.update(p);
    }
}

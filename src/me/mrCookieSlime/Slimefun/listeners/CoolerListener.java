// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   CoolerListener.java

package me.mrCookieSlime.Slimefun.listeners;

import java.util.Iterator;
import java.util.List;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.Setup.SlimefunManager;
import me.mrCookieSlime.Slimefun.SlimefunStartup;
import me.mrCookieSlime.Slimefun.api.Backpacks;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.plugin.PluginManager;
import org.bukkit.potion.PotionEffect;

public class CoolerListener
    implements Listener
{

    public CoolerListener(SlimefunStartup plugin)
    {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    public void onStarve(FoodLevelChangeEvent e)
    {
        if(e.getFoodLevel() < ((Player)e.getEntity()).getFoodLevel())
        {
            Player p = (Player)e.getEntity();
            ItemStack aitemstack[];
            int k = (aitemstack = p.getInventory().getContents()).length;
            for(int j = 0; j < k; j++)
            {
                ItemStack item = aitemstack[j];
                if(!SlimefunManager.isItemSimiliar(item, SlimefunItem.getItem("COOLER"), false))
                    continue;
                Inventory inv = Backpacks.getInventory(p, item);
                if(inv == null)
                    continue;
                ItemStack drink = null;
                ItemStack aitemstack1[];
                int i1 = (aitemstack1 = inv.getContents()).length;
                for(int l = 0; l < i1; l++)
                {
                    ItemStack i = aitemstack1[l];
                    if(i == null || i.getType() != Material.POTION || !i.hasItemMeta())
                        continue;
                    drink = i;
                    break;
                }

                if(drink == null)
                    continue;
                PotionMeta im = (PotionMeta)drink.getItemMeta();
                PotionEffect effect;
                for(Iterator iterator = im.getCustomEffects().iterator(); iterator.hasNext(); p.addPotionEffect(effect))
                    effect = (PotionEffect)iterator.next();

                p.setSaturation(6F);
                p.playSound(p.getLocation(), Sound.ENTITY_GENERIC_DRINK, 1.0F, 1.0F);
                inv.removeItem(new ItemStack[] {
                    drink
                });
                Backpacks.saveBackpack(inv, item);
                break;
            }

        }
    }
}

// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   BackpackListener.java

package me.mrCookieSlime.Slimefun.listeners;

import java.util.List;
import java.util.Map;
import me.mrCookieSlime.CSCoreLibPlugin.Configuration.Localization;
import me.mrCookieSlime.CSCoreLibPlugin.Configuration.Variable;
import me.mrCookieSlime.Slimefun.Lists.SlimefunItems;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.*;
import me.mrCookieSlime.Slimefun.Setup.Messages;
import me.mrCookieSlime.Slimefun.Setup.SlimefunManager;
import me.mrCookieSlime.Slimefun.SlimefunStartup;
import me.mrCookieSlime.Slimefun.Variables;
import me.mrCookieSlime.Slimefun.api.Backpacks;
import me.mrCookieSlime.Slimefun.api.Slimefun;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.*;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.PluginManager;

public class BackpackListener
    implements Listener
{

    public BackpackListener(SlimefunStartup plugin)
    {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    public void onClose(InventoryCloseEvent e)
    {
        if(Variables.enchanting.containsKey(e.getPlayer().getUniqueId()))
            Variables.enchanting.remove(e.getPlayer().getUniqueId());
        if(Variables.backpack.containsKey(e.getPlayer().getUniqueId()))
        {
            ((Player)e.getPlayer()).playSound(e.getPlayer().getLocation(), Sound.ENTITY_HORSE_ARMOR, 1.0F, 1.0F);
            Backpacks.saveBackpack(e.getInventory(), (ItemStack)Variables.backpack.get(e.getPlayer().getUniqueId()));
            Variables.backpack.remove(e.getPlayer().getUniqueId());
        }
    }

    public void onItemDrop(PlayerDropItemEvent e)
    {
        if(Variables.backpack.containsKey(e.getPlayer().getUniqueId()))
        {
            ItemStack item = e.getItemDrop().getItemStack();
            SlimefunItem sfItem = SlimefunItem.getByItem(item);
            if(sfItem instanceof SlimefunBackpack)
                e.setCancelled(true);
        }
    }

    public void onClick(InventoryClickEvent e)
    {
        if(Variables.backpack.containsKey(e.getWhoClicked().getUniqueId()))
        {
            ItemStack item = (ItemStack)Variables.backpack.get(e.getWhoClicked().getUniqueId());
            if(e.getClick() == ClickType.NUMBER_KEY)
            {
                ItemStack hotbarItem = e.getWhoClicked().getInventory().getItem(e.getHotbarButton());
                SlimefunItem sfItem = SlimefunItem.getByItem(hotbarItem);
                if(hotbarItem != null && hotbarItem.getType().toString().contains("SHULKER_BOX"))
                    e.setCancelled(true);
                else
                if(sfItem instanceof SlimefunBackpack)
                    e.setCancelled(true);
            } else
            {
                SlimefunItem sfItem = SlimefunItem.getByItem(e.getCurrentItem());
                if(SlimefunManager.isItemSimiliar(item, SlimefunItem.getItem("COOLER"), false))
                {
                    if(e.getCurrentItem() != null)
                        if(sfItem == null)
                            e.setCancelled(true);
                        else
                        if(!(sfItem instanceof Juice))
                            e.setCancelled(true);
                } else
                if(e.getCurrentItem() != null && e.getCurrentItem().getType().toString().contains("SHULKER_BOX"))
                    e.setCancelled(true);
                else
                if(sfItem instanceof SlimefunBackpack)
                    e.setCancelled(true);
                else
                if(SlimefunManager.isItemSimiliar(e.getCurrentItem(), SlimefunItems.VOIDBAG_SMALL, false))
                    e.setCancelled(true);
                else
                if(SlimefunManager.isItemSimiliar(e.getCurrentItem(), SlimefunItems.VOIDBAG_MEDIUM, false))
                    e.setCancelled(true);
                else
                if(SlimefunManager.isItemSimiliar(e.getCurrentItem(), SlimefunItems.VOIDBAG_BIG, false))
                    e.setCancelled(true);
                else
                if(SlimefunManager.isItemSimiliar(e.getCurrentItem(), SlimefunItems.VOIDBAG_LARGE, false))
                    e.setCancelled(true);
                else
                if(SlimefunManager.isItemSimiliar(e.getCurrentItem(), SlimefunItems.BOUND_VOIDBAG, false))
                    e.setCancelled(true);
            }
        }
    }

    public void onInteract(PlayerInteractEvent e)
    {
        if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK)
        {
            ItemStack item = e.getPlayer().getInventory().getItemInMainHand();
            Player p = e.getPlayer();
            if(SlimefunManager.isItemSimiliar(item, SlimefunItems.BACKPACK_SMALL, false))
            {
                e.setCancelled(true);
                if(Slimefun.hasUnlocked(p, SlimefunItems.BACKPACK_SMALL, true))
                    if(item.getAmount() == 1)
                    {
                        for(int line = 0; line < item.getItemMeta().getLore().size(); line++)
                        {
                            if(!((String)item.getItemMeta().getLore().get(line)).equals(ChatColor.translateAlternateColorCodes('&', "&7ID: <ID>")))
                                continue;
                            ItemMeta im = item.getItemMeta();
                            List lore = im.getLore();
                            lore.set(line, ((String)lore.get(line)).replace("<ID>", Backpacks.createBackpack(p, 9)));
                            im.setLore(lore);
                            item.setItemMeta(im);
                            break;
                        }

                        if(!Variables.backpack.containsValue(item))
                        {
                            Backpacks.openBackpack(p, item);
                            p.playSound(p.getLocation(), Sound.ENTITY_HORSE_ARMOR, 1.0F, 1.0F);
                            Variables.backpack.put(p.getUniqueId(), item);
                        } else
                        {
                            Messages.local.sendTranslation(p, "backpack.already-open", true, new Variable[0]);
                        }
                    } else
                    {
                        Messages.local.sendTranslation(p, "backpack.no-stack", true, new Variable[0]);
                    }
            } else
            if(SlimefunManager.isItemSimiliar(item, SlimefunItems.BACKPACK_MEDIUM, false))
            {
                e.setCancelled(true);
                if(Slimefun.hasUnlocked(p, SlimefunItems.BACKPACK_MEDIUM, true))
                    if(item.getAmount() == 1)
                    {
                        for(int line = 0; line < item.getItemMeta().getLore().size(); line++)
                        {
                            if(!((String)item.getItemMeta().getLore().get(line)).equals(ChatColor.translateAlternateColorCodes('&', "&7ID: <ID>")))
                                continue;
                            ItemMeta im = item.getItemMeta();
                            List lore = im.getLore();
                            lore.set(line, ((String)lore.get(line)).replace("<ID>", Backpacks.createBackpack(p, 18)));
                            im.setLore(lore);
                            item.setItemMeta(im);
                            break;
                        }

                        if(!Variables.backpack.containsValue(item))
                        {
                            Backpacks.openBackpack(p, item);
                            p.playSound(p.getLocation(), Sound.ENTITY_HORSE_ARMOR, 1.0F, 1.0F);
                            Variables.backpack.put(p.getUniqueId(), item);
                        } else
                        {
                            Messages.local.sendTranslation(p, "backpack.already-open", true, new Variable[0]);
                        }
                    } else
                    {
                        Messages.local.sendTranslation(p, "backpack.no-stack", true, new Variable[0]);
                    }
            } else
            if(SlimefunManager.isItemSimiliar(item, SlimefunItems.BACKPACK_LARGE, false))
            {
                e.setCancelled(true);
                if(Slimefun.hasUnlocked(p, SlimefunItems.BACKPACK_LARGE, true))
                    if(item.getAmount() == 1)
                    {
                        for(int line = 0; line < item.getItemMeta().getLore().size(); line++)
                        {
                            if(!((String)item.getItemMeta().getLore().get(line)).equals(ChatColor.translateAlternateColorCodes('&', "&7ID: <ID>")))
                                continue;
                            ItemMeta im = item.getItemMeta();
                            List lore = im.getLore();
                            lore.set(line, ((String)lore.get(line)).replace("<ID>", Backpacks.createBackpack(p, 27)));
                            im.setLore(lore);
                            item.setItemMeta(im);
                            break;
                        }

                        if(!Variables.backpack.containsValue(item))
                        {
                            Backpacks.openBackpack(p, item);
                            p.playSound(p.getLocation(), Sound.ENTITY_HORSE_ARMOR, 1.0F, 1.0F);
                            Variables.backpack.put(p.getUniqueId(), item);
                        } else
                        {
                            Messages.local.sendTranslation(p, "backpack.already-open", true, new Variable[0]);
                        }
                    } else
                    {
                        Messages.local.sendTranslation(p, "backpack.no-stack", true, new Variable[0]);
                    }
            } else
            if(SlimefunManager.isItemSimiliar(item, SlimefunItems.WOVEN_BACKPACK, false))
            {
                e.setCancelled(true);
                if(Slimefun.hasUnlocked(p, SlimefunItems.WOVEN_BACKPACK, true))
                    if(item.getAmount() == 1)
                    {
                        for(int line = 0; line < item.getItemMeta().getLore().size(); line++)
                        {
                            if(!((String)item.getItemMeta().getLore().get(line)).equals(ChatColor.translateAlternateColorCodes('&', "&7ID: <ID>")))
                                continue;
                            ItemMeta im = item.getItemMeta();
                            List lore = im.getLore();
                            lore.set(line, ((String)lore.get(line)).replace("<ID>", Backpacks.createBackpack(p, 36)));
                            im.setLore(lore);
                            item.setItemMeta(im);
                            break;
                        }

                        if(!Variables.backpack.containsValue(item))
                        {
                            Backpacks.openBackpack(p, item);
                            p.playSound(p.getLocation(), Sound.ENTITY_HORSE_ARMOR, 1.0F, 1.0F);
                            Variables.backpack.put(p.getUniqueId(), item);
                        } else
                        {
                            Messages.local.sendTranslation(p, "backpack.already-open", true, new Variable[0]);
                        }
                    } else
                    {
                        Messages.local.sendTranslation(p, "backpack.no-stack", true, new Variable[0]);
                    }
            } else
            if(SlimefunManager.isItemSimiliar(item, SlimefunItems.GILDED_BACKPACK, false))
            {
                e.setCancelled(true);
                if(Slimefun.hasUnlocked(p, SlimefunItems.GILDED_BACKPACK, true))
                    if(item.getAmount() == 1)
                    {
                        for(int line = 0; line < item.getItemMeta().getLore().size(); line++)
                        {
                            if(!((String)item.getItemMeta().getLore().get(line)).equals(ChatColor.translateAlternateColorCodes('&', "&7ID: <ID>")))
                                continue;
                            ItemMeta im = item.getItemMeta();
                            List lore = im.getLore();
                            lore.set(line, ((String)lore.get(line)).replace("<ID>", Backpacks.createBackpack(p, 45)));
                            im.setLore(lore);
                            item.setItemMeta(im);
                            break;
                        }

                        if(!Variables.backpack.containsValue(item))
                        {
                            Backpacks.openBackpack(p, item);
                            p.playSound(p.getLocation(), Sound.ENTITY_HORSE_ARMOR, 1.0F, 1.0F);
                            Variables.backpack.put(p.getUniqueId(), item);
                        } else
                        {
                            Messages.local.sendTranslation(p, "backpack.already-open", true, new Variable[0]);
                        }
                    } else
                    {
                        Messages.local.sendTranslation(p, "backpack.no-stack", true, new Variable[0]);
                    }
            } else
            if(SlimefunManager.isItemSimiliar(item, SlimefunItems.BOUND_BACKPACK, false))
            {
                e.setCancelled(true);
                if(Slimefun.hasUnlocked(p, SlimefunItems.BOUND_BACKPACK, true))
                    if(item.getAmount() == 1)
                    {
                        for(int line = 0; line < item.getItemMeta().getLore().size(); line++)
                        {
                            if(!((String)item.getItemMeta().getLore().get(line)).equals(ChatColor.translateAlternateColorCodes('&', "&7ID: <ID>")))
                                continue;
                            ItemMeta im = item.getItemMeta();
                            List lore = im.getLore();
                            lore.set(line, ((String)lore.get(line)).replace("<ID>", Backpacks.createBackpack(p, 36)));
                            im.setLore(lore);
                            item.setItemMeta(im);
                            break;
                        }

                        if(!Variables.backpack.containsValue(item))
                        {
                            Backpacks.openBackpack(p, item);
                            p.playSound(p.getLocation(), Sound.ENTITY_HORSE_ARMOR, 1.0F, 1.0F);
                            Variables.backpack.put(p.getUniqueId(), item);
                        } else
                        {
                            Messages.local.sendTranslation(p, "backpack.already-open", true, new Variable[0]);
                        }
                    } else
                    {
                        Messages.local.sendTranslation(p, "backpack.no-stack", true, new Variable[0]);
                    }
            } else
            if(SlimefunManager.isItemSimiliar(item, SlimefunItems.COOLER, false))
            {
                e.setCancelled(true);
                if(Slimefun.hasUnlocked(p, SlimefunItems.COOLER, true))
                    if(item.getAmount() == 1)
                    {
                        for(int line = 0; line < item.getItemMeta().getLore().size(); line++)
                        {
                            if(!((String)item.getItemMeta().getLore().get(line)).equals(ChatColor.translateAlternateColorCodes('&', "&7ID: <ID>")))
                                continue;
                            ItemMeta im = item.getItemMeta();
                            List lore = im.getLore();
                            lore.set(line, ((String)lore.get(line)).replace("<ID>", Backpacks.createBackpack(p, 27)));
                            im.setLore(lore);
                            item.setItemMeta(im);
                            break;
                        }

                        if(!Variables.backpack.containsValue(item))
                        {
                            Backpacks.openBackpack(p, item);
                            p.playSound(p.getLocation(), Sound.ENTITY_HORSE_ARMOR, 1.0F, 1.0F);
                            Variables.backpack.put(p.getUniqueId(), item);
                        } else
                        {
                            Messages.local.sendTranslation(p, "backpack.already-open", true, new Variable[0]);
                        }
                    } else
                    {
                        Messages.local.sendTranslation(p, "backpack.no-stack", true, new Variable[0]);
                    }
            }
        }
    }
}

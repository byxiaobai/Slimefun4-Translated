// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   AncientAltarListener.java

package me.mrCookieSlime.Slimefun.listeners;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import me.mrCookieSlime.CSCoreLibPlugin.Configuration.Localization;
import me.mrCookieSlime.CSCoreLibPlugin.Configuration.Variable;
import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.Item.CustomItem;
import me.mrCookieSlime.CSCoreLibPlugin.general.String.StringUtils;
import me.mrCookieSlime.Slimefun.AncientAltar.Pedestals;
import me.mrCookieSlime.Slimefun.AncientAltar.RitualAnimation;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.Setup.Messages;
import me.mrCookieSlime.Slimefun.SlimefunStartup;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryPickupItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.material.MaterialData;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.plugin.PluginManager;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.util.Vector;

public class AncientAltarListener
    implements Listener
{

    List altars;
    Set removed_items;

    public AncientAltarListener(SlimefunStartup plugin)
    {
        altars = new ArrayList();
        removed_items = new HashSet();
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    public void onInteract(PlayerInteractEvent e)
    {
        if(e.isCancelled())
            return;
        if(e.getAction() != Action.RIGHT_CLICK_BLOCK)
            return;
        Block b = e.getClickedBlock();
        SlimefunItem item = BlockStorage.check(b);
        if(item != null)
            if(item.getName().equals("ANCIENT_PEDESTAL"))
            {
                e.setCancelled(true);
                Item stack = findItem(b);
                if(stack == null)
                    insertItem(e.getPlayer(), b);
                else
                if(!removed_items.contains(stack.getUniqueId()))
                {
                    final UUID uuid = stack.getUniqueId();
                    removed_items.add(uuid);
                    SlimefunStartup.instance.getServer().getScheduler().scheduleSyncDelayedTask(SlimefunStartup.instance, new Runnable() {

                        final AncientAltarListener this$0;
                        private final UUID val$uuid;

                        public void run()
                        {
                            removed_items.remove(uuid);
                        }

            
            {
                this$0 = AncientAltarListener.this;
                uuid = uuid1;
                super();
            }
                    }
, 30L);
                    stack.remove();
                    e.getPlayer().getInventory().addItem(new ItemStack[] {
                        fixItemStack(stack.getItemStack(), stack.getCustomName())
                    });
                    e.getPlayer().playSound(b.getLocation(), Sound.ENTITY_ITEM_PICKUP, 1.0F, 1.0F);
                    me.mrCookieSlime.CSCoreLibPlugin.general.Player.PlayerInventory.update(e.getPlayer());
                }
            } else
            if(item.getName().equals("ANCIENT_ALTAR"))
            {
                e.setCancelled(true);
                ItemStack catalyst = new CustomItem(e.getPlayer().getInventory().getItemInMainHand(), 1);
                List pedestals = Pedestals.getPedestals(b);
                if(!altars.contains(e.getClickedBlock()))
                {
                    altars.add(e.getClickedBlock());
                    if(pedestals.size() == 8)
                    {
                        if(catalyst != null && !catalyst.getType().equals(Material.AIR))
                        {
                            List input = new ArrayList();
                            for(Iterator iterator = pedestals.iterator(); iterator.hasNext();)
                            {
                                Block pedestal = (Block)iterator.next();
                                Item stack = findItem(pedestal);
                                if(stack != null)
                                    input.add(fixItemStack(stack.getItemStack(), stack.getCustomName()));
                            }

                            ItemStack result = Pedestals.getRecipeOutput(catalyst, input);
                            if(result != null)
                            {
                                List consumed = new ArrayList();
                                consumed.add(catalyst);
                                me.mrCookieSlime.CSCoreLibPlugin.general.Player.PlayerInventory.consumeItemInHand(e.getPlayer());
                                Bukkit.getScheduler().scheduleSyncDelayedTask(SlimefunStartup.instance, new RitualAnimation(altars, b, b.getLocation().add(0.5D, 1.3D, 0.5D), result, pedestals, consumed), 10L);
                            } else
                            {
                                altars.remove(e.getClickedBlock());
                                Messages.local.sendTranslation(e.getPlayer(), "machines.ANCIENT_ALTAR.unknown-recipe", true, new Variable[0]);
                            }
                        } else
                        {
                            altars.remove(e.getClickedBlock());
                            Messages.local.sendTranslation(e.getPlayer(), "machines.ANCIENT_ALTAR.unknown-catalyst", true, new Variable[0]);
                        }
                    } else
                    {
                        altars.remove(e.getClickedBlock());
                        Messages.local.sendTranslation(e.getPlayer(), "machines.ANCIENT_ALTAR.not-enough-pedestals", true, new Variable[] {
                            new Variable("%pedestals%", String.valueOf(pedestals.size()))
                        });
                    }
                }
            }
    }

    public static ItemStack fixItemStack(ItemStack itemStack, String customName)
    {
        ItemStack stack = itemStack.clone();
        if(customName.equals(StringUtils.formatItemName(itemStack.getData().toItemStack(1), false)))
        {
            ItemMeta im = stack.getItemMeta();
            im.setDisplayName(null);
            stack.setItemMeta(im);
        } else
        {
            ItemMeta im = stack.getItemMeta();
            im.setDisplayName(customName);
            stack.setItemMeta(im);
        }
        return stack;
    }

    public static Item findItem(Block b)
    {
        Entity aentity[];
        int j = (aentity = b.getChunk().getEntities()).length;
        for(int i = 0; i < j; i++)
        {
            Entity n = aentity[i];
            if((n instanceof Item) && b.getLocation().add(0.5D, 1.2D, 0.5D).distanceSquared(n.getLocation()) < 0.5D && n.getCustomName() != null)
                return (Item)n;
        }

        return null;
    }

    private void insertItem(Player p, Block b)
    {
        ItemStack stack = p.getInventory().getItemInMainHand();
        if(stack != null && !stack.getType().equals(Material.AIR))
        {
            me.mrCookieSlime.CSCoreLibPlugin.general.Player.PlayerInventory.consumeItemInHand(p);
            String nametag = StringUtils.formatItemName(stack, false);
            Item entity = b.getWorld().dropItem(b.getLocation().add(0.5D, 1.2D, 0.5D), new CustomItem(new CustomItem(stack, 1), (new StringBuilder("&5&dALTAR &3Probe - &e")).append(System.nanoTime()).toString()));
            entity.setVelocity(new Vector(0.0D, 0.10000000000000001D, 0.0D));
            entity.setMetadata("no_pickup", new FixedMetadataValue(SlimefunStartup.instance, "altar_item"));
            entity.setCustomNameVisible(true);
            entity.setCustomName(nametag);
            p.playSound(b.getLocation(), Sound.ENTITY_ITEM_PICKUP, 0.3F, 0.3F);
        }
    }

    public void onPickup(PlayerPickupItemEvent e)
    {
        if(e.getItem().hasMetadata("no_pickup"))
            e.setCancelled(true);
        else
        if(!e.getItem().hasMetadata("no_pickup") && e.getItem().getItemStack().hasItemMeta() && e.getItem().getItemStack().getItemMeta().hasDisplayName() && e.getItem().getItemStack().getItemMeta().getDisplayName().startsWith("&5&dALTAR &3Probe - &e"))
        {
            e.setCancelled(true);
            e.getItem().remove();
        }
    }

    public void onMinecartPickup(InventoryPickupItemEvent e)
    {
        if(e.getItem().hasMetadata("no_pickup"))
            e.setCancelled(true);
        else
        if(!e.getItem().hasMetadata("no_pickup") && e.getItem().getItemStack().hasItemMeta() && e.getItem().getItemStack().getItemMeta().hasDisplayName() && e.getItem().getItemStack().getItemMeta().getDisplayName().startsWith("&5&dALTAR &3Probe - &e"))
        {
            e.setCancelled(true);
            e.getItem().remove();
        }
    }
}

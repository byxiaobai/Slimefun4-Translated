// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   ArmorListener.java

package me.mrCookieSlime.Slimefun.listeners;

import java.util.*;
import me.mrCookieSlime.Slimefun.Lists.SlimefunItems;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.Setup.SlimefunManager;
import me.mrCookieSlime.Slimefun.SlimefunStartup;
import me.mrCookieSlime.Slimefun.api.Slimefun;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.*;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.plugin.PluginManager;
import org.bukkit.util.Vector;

public class ArmorListener
    implements Listener
{

    public ArmorListener(SlimefunStartup plugin)
    {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    public void onDamage(EntityDamageEvent e)
    {
        if((e.getEntity() instanceof Player) && !e.isCancelled())
        {
            Player p = (Player)e.getEntity();
            ItemStack aitemstack[];
            int k = (aitemstack = p.getInventory().getArmorContents()).length;
            for(int j = 0; j < k; j++)
            {
                ItemStack armor = aitemstack[j];
                if(armor != null && SlimefunItem.getByItem(armor) != null)
                    if(SlimefunItem.getByItem(armor).isItem(SlimefunItems.ENDER_BOOTS) && Slimefun.hasUnlocked(p, SlimefunItems.ENDER_BOOTS, true))
                    {
                        if((e instanceof EntityDamageByEntityEvent) && (((EntityDamageByEntityEvent)e).getDamager() instanceof EnderPearl))
                            e.setCancelled(true);
                    } else
                    if(SlimefunItem.getByItem(armor).isItem(SlimefunItems.SLIME_BOOTS) && Slimefun.hasUnlocked(p, SlimefunItems.SLIME_BOOTS, true))
                    {
                        if(e.getCause() == org.bukkit.event.entity.EntityDamageEvent.DamageCause.FALL)
                            e.setCancelled(true);
                    } else
                    if(SlimefunItem.getByItem(armor).isItem(SlimefunItems.BOOTS_OF_THE_STOMPER) && Slimefun.hasUnlocked(p, SlimefunItems.BOOTS_OF_THE_STOMPER, true))
                    {
                        if(e.getCause() == org.bukkit.event.entity.EntityDamageEvent.DamageCause.FALL)
                        {
                            e.setCancelled(true);
                            p.getWorld().playSound(p.getLocation(), Sound.ENTITY_ZOMBIE_BREAK_DOOR_WOOD, 2.0F, 2.0F);
                            p.setVelocity(new Vector(0.0D, 0.69999999999999996D, 0.0D));
                            for(Iterator iterator = p.getNearbyEntities(4D, 4D, 4D).iterator(); iterator.hasNext();)
                            {
                                Entity n = (Entity)iterator.next();
                                if((n instanceof LivingEntity) && !n.getUniqueId().toString().equalsIgnoreCase(p.getUniqueId().toString()))
                                {
                                    n.setVelocity(n.getLocation().toVector().subtract(p.getLocation().toVector()).normalize().multiply(1.3999999999999999D));
                                    if(p.getWorld().getPVP())
                                    {
                                        EntityDamageByEntityEvent event = new EntityDamageByEntityEvent(p, n, org.bukkit.event.entity.EntityDamageEvent.DamageCause.ENTITY_ATTACK, e.getDamage() / 2D);
                                        Bukkit.getPluginManager().callEvent(event);
                                        if(!event.isCancelled())
                                            ((LivingEntity)n).damage(e.getDamage() / 2D);
                                    }
                                }
                            }

                            for(int i = 0; i < 2; i++)
                            {
                                BlockFace ablockface[];
                                int i1 = (ablockface = BlockFace.values()).length;
                                for(int l = 0; l < i1; l++)
                                {
                                    BlockFace face = ablockface[l];
                                    p.getWorld().playEffect(p.getLocation().getBlock().getRelative(BlockFace.DOWN).getRelative(face).getLocation(), Effect.STEP_SOUND, p.getLocation().getBlock().getRelative(BlockFace.DOWN).getRelative(face).getType());
                                }

                            }

                        }
                    } else
                    if(SlimefunItem.getByItem(armor).isItem(SlimefunItems.SLIME_BOOTS_STEEL) && Slimefun.hasUnlocked(p, SlimefunItems.SLIME_BOOTS_STEEL, true) && e.getCause() == org.bukkit.event.entity.EntityDamageEvent.DamageCause.FALL)
                        e.setCancelled(true);
            }

        }
    }

    public void onTrample(PlayerInteractEvent e)
    {
        if(e.getAction() == Action.PHYSICAL && e.getClickedBlock().getType() == Material.SOIL && SlimefunManager.isItemSimiliar(e.getPlayer().getInventory().getBoots(), SlimefunItem.getItem("FARMER_SHOES"), true))
            e.setCancelled(true);
    }
}

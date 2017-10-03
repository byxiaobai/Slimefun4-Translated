// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   DamageListener.java

package me.mrCookieSlime.Slimefun.listeners;

import java.text.SimpleDateFormat;
import java.util.*;
import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.Item.CustomItem;
import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.Item.SkullItem;
import me.mrCookieSlime.EmeraldEnchants.*;
import me.mrCookieSlime.Slimefun.GPS.GPSNetwork;
import me.mrCookieSlime.Slimefun.Lists.SlimefunItems;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.*;
import me.mrCookieSlime.Slimefun.Setup.SlimefunManager;
import me.mrCookieSlime.Slimefun.SlimefunStartup;
import me.mrCookieSlime.Slimefun.Variables;
import me.mrCookieSlime.Slimefun.api.Slimefun;
import me.mrCookieSlime.Slimefun.api.Soul;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.*;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.plugin.PluginManager;

public class DamageListener
    implements Listener
{

    private SimpleDateFormat format;
    private static int $SWITCH_TABLE$org$bukkit$entity$Skeleton$SkeletonType[];

    public DamageListener(SlimefunStartup plugin)
    {
        format = new SimpleDateFormat("(MMM d, yyyy @ hh:mm)");
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    public void onDamage(EntityDeathEvent e)
    {
        if(e.getEntity() instanceof Player)
        {
            Player p = (Player)e.getEntity();
            if(p.getInventory().containsAtLeast(SlimefunItems.GPS_EMERGENCY_TRANSMITTER, 1))
                Slimefun.getGPSNetwork().addWaypoint(p, (new StringBuilder("&4Deathpoint &7")).append(format.format(new Date())).toString(), p.getLocation().getBlock().getLocation());
            for(Iterator drops = e.getDrops().iterator(); drops.hasNext();)
            {
                ItemStack item = (ItemStack)drops.next();
                if(item != null)
                    if(SlimefunManager.isItemSimiliar(item, SlimefunItems.BOUND_BACKPACK, false))
                    {
                        Soul.storeItem(e.getEntity().getUniqueId(), item);
                        drops.remove();
                    } else
                    if(SlimefunItem.getByItem(removeEnchantments(item)) != null && (SlimefunItem.getByItem(removeEnchantments(item)) instanceof SoulboundItem))
                    {
                        Soul.storeItem(e.getEntity().getUniqueId(), item);
                        drops.remove();
                    }
            }

        }
        if(e.getEntity().getKiller() instanceof Player)
        {
            Player p = e.getEntity().getKiller();
            ItemStack item = p.getInventory().getItemInMainHand();
            if(SlimefunManager.drops.containsKey(e.getEntity().getType()))
            {
                for(Iterator iterator = ((List)SlimefunManager.drops.get(e.getEntity().getType())).iterator(); iterator.hasNext();)
                {
                    ItemStack drop = (ItemStack)iterator.next();
                    if(Slimefun.hasUnlocked(p, item, true))
                        e.getDrops().add(drop);
                }

            }
            if(item != null && Slimefun.hasUnlocked(p, item, true) && SlimefunManager.isItemSimiliar(item, SlimefunItem.getItem("SWORD_OF_BEHEADING"), true))
                if(e.getEntity() instanceof Zombie)
                {
                    if(SlimefunStartup.chance(100, ((Integer)Slimefun.getItemValue("SWORD_OF_BEHEADING", "chance.ZOMBIE")).intValue()))
                        e.getDrops().add(new CustomItem(Material.SKULL_ITEM, 2));
                } else
                if(e.getEntity() instanceof Skeleton)
                    switch($SWITCH_TABLE$org$bukkit$entity$Skeleton$SkeletonType()[((Skeleton)e.getEntity()).getSkeletonType().ordinal()])
                    {
                    case 1: // '\001'
                        if(SlimefunStartup.chance(100, ((Integer)Slimefun.getItemValue("SWORD_OF_BEHEADING", "chance.SKELETON")).intValue()))
                            e.getDrops().add(new CustomItem(Material.SKULL_ITEM, 0));
                        break;

                    case 2: // '\002'
                        if(SlimefunStartup.chance(100, ((Integer)Slimefun.getItemValue("SWORD_OF_BEHEADING", "chance.WITHER_SKELETON")).intValue()))
                            e.getDrops().add(new CustomItem(Material.SKULL_ITEM, 1));
                        break;
                    }
                else
                if(e.getEntity() instanceof Creeper)
                {
                    if(SlimefunStartup.chance(100, ((Integer)Slimefun.getItemValue("SWORD_OF_BEHEADING", "chance.CREEPER")).intValue()))
                        e.getDrops().add(new CustomItem(Material.SKULL_ITEM, 4));
                } else
                if((e.getEntity() instanceof Player) && SlimefunStartup.chance(100, ((Integer)Slimefun.getItemValue("SWORD_OF_BEHEADING", "chance.PLAYER")).intValue()))
                    e.getDrops().add(new SkullItem(((Player)e.getEntity()).getName()));
            if(Talisman.checkFor(e, SlimefunItem.getByName("HUNTER_TALISMAN")) && !(e.getEntity() instanceof Player))
            {
                List newDrops = new ArrayList();
                ItemStack drop;
                for(Iterator iterator1 = e.getDrops().iterator(); iterator1.hasNext(); newDrops.add(drop))
                    drop = (ItemStack)iterator1.next();

                ItemStack drop;
                for(Iterator iterator2 = newDrops.iterator(); iterator2.hasNext(); e.getDrops().add(drop))
                    drop = (ItemStack)iterator2.next();

            }
        }
    }

    public void onArrowHit(EntityDamageEvent e)
    {
        if((e.getEntity() instanceof Player) && e.getCause() == org.bukkit.event.entity.EntityDamageEvent.DamageCause.FALL && Variables.damage.containsKey(e.getEntity().getUniqueId()))
        {
            e.setCancelled(true);
            Variables.damage.remove(e.getEntity().getUniqueId());
        }
    }

    public void onRespawn(PlayerRespawnEvent e)
    {
        Soul.retrieveItems(e.getPlayer());
    }

    private ItemStack removeEnchantments(ItemStack itemStack)
    {
        ItemStack strippedItem = itemStack.clone();
        Enchantment enchantment;
        for(Iterator iterator = itemStack.getEnchantments().keySet().iterator(); iterator.hasNext(); strippedItem.removeEnchantment(enchantment))
            enchantment = (Enchantment)iterator.next();

        if(Slimefun.isEmeraldEnchantsInstalled())
        {
            ItemEnchantment enchantment;
            for(Iterator iterator1 = EmeraldEnchants.getInstance().getRegistry().getEnchantments(itemStack).iterator(); iterator1.hasNext(); EmeraldEnchants.getInstance().getRegistry().applyEnchantment(strippedItem, enchantment.getEnchantment(), 0))
                enchantment = (ItemEnchantment)iterator1.next();

        }
        return strippedItem;
    }

    static int[] $SWITCH_TABLE$org$bukkit$entity$Skeleton$SkeletonType()
    {
        $SWITCH_TABLE$org$bukkit$entity$Skeleton$SkeletonType;
        if($SWITCH_TABLE$org$bukkit$entity$Skeleton$SkeletonType == null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        JVM INSTR pop ;
        int ai[] = new int[org.bukkit.entity.Skeleton.SkeletonType.values().length];
        try
        {
            ai[org.bukkit.entity.Skeleton.SkeletonType.NORMAL.ordinal()] = 1;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[org.bukkit.entity.Skeleton.SkeletonType.STRAY.ordinal()] = 3;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[org.bukkit.entity.Skeleton.SkeletonType.WITHER.ordinal()] = 2;
        }
        catch(NoSuchFieldError _ex) { }
        return $SWITCH_TABLE$org$bukkit$entity$Skeleton$SkeletonType = ai;
    }
}

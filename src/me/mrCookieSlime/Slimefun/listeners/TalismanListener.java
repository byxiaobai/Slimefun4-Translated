// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   TalismanListener.java

package me.mrCookieSlime.Slimefun.listeners;

import java.util.*;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.Talisman;
import me.mrCookieSlime.Slimefun.Setup.SlimefunManager;
import me.mrCookieSlime.Slimefun.SlimefunStartup;
import me.mrCookieSlime.Slimefun.api.Slimefun;
import org.bukkit.*;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.*;
import org.bukkit.event.Listener;
import org.bukkit.event.enchantment.EnchantItemEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerItemBreakEvent;
import org.bukkit.event.player.PlayerToggleSprintEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.plugin.PluginManager;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

public class TalismanListener
    implements Listener
{

    public TalismanListener(SlimefunStartup plugin)
    {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    public void onDamageGet(EntityDamageEvent e)
    {
        if(!e.isCancelled())
        {
            if((e instanceof EntityDamageByEntityEvent) && (((EntityDamageByEntityEvent)e).getDamager() instanceof Player) && SlimefunStartup.chance(100, 45) && SlimefunManager.isItemSimiliar(((Player)((EntityDamageByEntityEvent)e).getDamager()).getInventory().getItemInMainHand(), SlimefunItem.getItem("BLADE_OF_VAMPIRES"), true))
            {
                ((Player)((EntityDamageByEntityEvent)e).getDamager()).playSound(((EntityDamageByEntityEvent)e).getDamager().getLocation(), Sound.ENTITY_ARROW_HIT_PLAYER, 0.7F, 0.7F);
                ((Player)((EntityDamageByEntityEvent)e).getDamager()).addPotionEffect(new PotionEffect(PotionEffectType.HEAL, 1, 1));
            }
            if((e.getEntity() instanceof Player) && !e.isCancelled())
            {
                if(e.getCause() == org.bukkit.event.entity.EntityDamageEvent.DamageCause.LAVA)
                    Talisman.checkFor(e, SlimefunItem.getByName("LAVA_TALISMAN"));
                if(e.getCause() == org.bukkit.event.entity.EntityDamageEvent.DamageCause.DROWNING)
                    Talisman.checkFor(e, SlimefunItem.getByName("WATER_TALISMAN"));
                if(e.getCause() == org.bukkit.event.entity.EntityDamageEvent.DamageCause.FALL)
                    Talisman.checkFor(e, SlimefunItem.getByName("ANGEL_TALISMAN"));
                if(e.getCause() == org.bukkit.event.entity.EntityDamageEvent.DamageCause.FIRE)
                    Talisman.checkFor(e, SlimefunItem.getByName("FIRE_TALISMAN"));
                if(e.getCause() == org.bukkit.event.entity.EntityDamageEvent.DamageCause.ENTITY_ATTACK)
                    Talisman.checkFor(e, SlimefunItem.getByName("WARRIOR_TALISMAN"));
                if(e.getCause() == org.bukkit.event.entity.EntityDamageEvent.DamageCause.ENTITY_ATTACK)
                    Talisman.checkFor(e, SlimefunItem.getByName("KNIGHT_TALISMAN"));
                if(e.getCause() == org.bukkit.event.entity.EntityDamageEvent.DamageCause.PROJECTILE && Talisman.checkFor(e, SlimefunItem.getByName("WHIRLWIND_TALISMAN")) && (((EntityDamageByEntityEvent)e).getDamager() instanceof Projectile))
                {
                    Vector direction = ((Player)e.getEntity()).getEyeLocation().getDirection().multiply(2D);
                    Projectile projectile = (Projectile)e.getEntity().getWorld().spawnEntity(((LivingEntity)e.getEntity()).getEyeLocation().add(direction.getX(), direction.getY(), direction.getZ()), ((EntityDamageByEntityEvent)e).getDamager().getType());
                    projectile.setVelocity(direction);
                    ((EntityDamageByEntityEvent)e).getDamager().remove();
                }
            }
        }
    }

    public void onItemBreak(PlayerItemBreakEvent e)
    {
        if(Talisman.checkFor(e, SlimefunItem.getByName("ANVIL_TALISMAN")))
            e.getBrokenItem().setAmount(1);
    }

    public void onSprint(PlayerToggleSprintEvent e)
    {
        if(e.isSprinting())
            Talisman.checkFor(e, SlimefunItem.getByName("TRAVELLER_TALISMAN"));
    }

    public void onEnchant(EnchantItemEvent e)
    {
        if(Talisman.checkFor(e, SlimefunItem.getByName("MAGICIAN_TALISMAN")))
        {
            List enchantments = new ArrayList();
            Enchantment aenchantment[];
            int k = (aenchantment = Enchantment.values()).length;
            for(int j = 0; j < k; j++)
            {
                Enchantment en = aenchantment[j];
                for(int i = 1; i <= en.getMaxLevel(); i++)
                    if(((Boolean)Slimefun.getItemValue("MAGICIAN_TALISMAN", (new StringBuilder("allow-enchantments.")).append(en.getName()).append(".level.").append(i).toString())).booleanValue() && en.canEnchantItem(e.getItem()))
                        enchantments.add((new StringBuilder(String.valueOf(en.getName()))).append("-").append(i).toString());

            }

            String enchant = (String)enchantments.get(SlimefunStartup.randomize(enchantments.size()));
            e.getEnchantsToAdd().put(Enchantment.getByName(enchant.split("-")[0]), Integer.valueOf(Integer.parseInt(enchant.split("-")[1])));
        }
        if(!e.getEnchantsToAdd().containsKey(Enchantment.SILK_TOUCH) && Enchantment.LOOT_BONUS_BLOCKS.canEnchantItem(e.getItem()) && Talisman.checkFor(e, SlimefunItem.getByName("WIZARD_TALISMAN")))
        {
            if(e.getEnchantsToAdd().containsKey(Enchantment.LOOT_BONUS_BLOCKS))
                e.getEnchantsToAdd().remove(Enchantment.LOOT_BONUS_BLOCKS);
            Set enchantments = e.getEnchantsToAdd().keySet();
            for(Iterator iterator = enchantments.iterator(); iterator.hasNext();)
            {
                Enchantment en = (Enchantment)iterator.next();
                if(SlimefunStartup.chance(100, 40))
                    e.getEnchantsToAdd().put(en, Integer.valueOf(SlimefunStartup.randomize(3) + 1));
            }

            e.getItem().addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, SlimefunStartup.randomize(3) + 3);
        }
    }
}

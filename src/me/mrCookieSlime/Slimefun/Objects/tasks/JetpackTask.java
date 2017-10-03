// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   JetpackTask.java

package me.mrCookieSlime.Slimefun.Objects.tasks;

import java.util.UUID;
import me.mrCookieSlime.Slimefun.api.energy.ItemEnergy;
import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.util.Vector;

public class JetpackTask
    implements Runnable
{

    UUID uuid;
    double thrust;
    int id;

    public JetpackTask(Player p, double thrust)
    {
        uuid = p.getUniqueId();
        this.thrust = thrust;
    }

    public void setID(int id)
    {
        this.id = id;
    }

    public void run()
    {
        if(Bukkit.getPlayer(uuid) == null)
            Bukkit.getScheduler().cancelTask(id);
        else
        if(Bukkit.getPlayer(uuid).isDead())
            Bukkit.getScheduler().cancelTask(id);
        else
        if(!Bukkit.getPlayer(uuid).isSneaking())
        {
            Bukkit.getScheduler().cancelTask(id);
        } else
        {
            Player p = Bukkit.getPlayer(uuid);
            float cost = 0.08F;
            float charge = ItemEnergy.getStoredEnergy(p.getInventory().getChestplate());
            if(charge >= cost)
            {
                p.getInventory().setChestplate(ItemEnergy.chargeItem(p.getInventory().getChestplate(), -cost));
                me.mrCookieSlime.CSCoreLibPlugin.general.Player.PlayerInventory.update(p);
                p.getWorld().playSound(p.getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 0.25F, 1.0F);
                p.getWorld().playEffect(p.getLocation(), Effect.SMOKE, 1, 1);
                p.setFallDistance(0.0F);
                Vector vector = new Vector(0, 1, 0);
                vector.multiply(thrust);
                vector.add(p.getEyeLocation().getDirection().multiply(0.2F));
                p.setVelocity(vector);
            } else
            {
                Bukkit.getScheduler().cancelTask(id);
            }
        }
    }
}

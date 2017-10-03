// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   JetBootsTask.java

package me.mrCookieSlime.Slimefun.Objects.tasks;

import java.text.DecimalFormat;
import java.util.UUID;
import me.mrCookieSlime.Slimefun.SlimefunStartup;
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

public class JetBootsTask
    implements Runnable
{

    UUID uuid;
    double speed;
    int id;

    public JetBootsTask(Player p, double speed)
    {
        uuid = p.getUniqueId();
        this.speed = speed;
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
            float cost = 0.075F;
            float charge = ItemEnergy.getStoredEnergy(p.getInventory().getBoots());
            double accuracy = Double.valueOf((new DecimalFormat("##.##")).format(speed - 0.69999999999999996D).replace(",", ".")).doubleValue();
            if(charge >= cost)
            {
                p.getInventory().setBoots(ItemEnergy.chargeItem(p.getInventory().getBoots(), -cost));
                me.mrCookieSlime.CSCoreLibPlugin.general.Player.PlayerInventory.update(p);
                p.getWorld().playSound(p.getLocation(), Sound.ENTITY_TNT_PRIMED, 0.25F, 1.0F);
                p.getWorld().playEffect(p.getLocation(), Effect.SMOKE, 1, 1);
                p.setFallDistance(0.0F);
                double gravity = 0.040000000000000001D;
                double offset = SlimefunStartup.chance(100, 50) ? accuracy : -accuracy;
                Vector vector = new Vector(p.getEyeLocation().getDirection().getX() * speed + offset, gravity, p.getEyeLocation().getDirection().getZ() * speed - offset);
                p.setVelocity(vector);
            } else
            {
                Bukkit.getScheduler().cancelTask(id);
            }
        }
    }
}

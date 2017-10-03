// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   BowListener.java

package me.mrCookieSlime.Slimefun.listeners;

import java.util.*;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.handlers.BowShootHandler;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.handlers.ItemHandler;
import me.mrCookieSlime.Slimefun.SlimefunStartup;
import me.mrCookieSlime.Slimefun.Variables;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.*;
import org.bukkit.plugin.PluginManager;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.util.Vector;

public class BowListener
    implements Listener
{

    public BowListener(SlimefunStartup plugin)
    {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    public void onBowUse(EntityShootBowEvent e)
    {
        if(!(e.getEntity() instanceof Player) || !(e.getProjectile() instanceof Arrow))
            return;
        if(SlimefunItem.getByItem(e.getBow()) != null)
            Variables.arrows.put(e.getProjectile().getUniqueId(), e.getBow());
    }

    public void onArrowHit(final ProjectileHitEvent e)
    {
        Bukkit.getScheduler().scheduleSyncDelayedTask(SlimefunStartup.instance, new Runnable() {

            final BowListener this$0;
            private final ProjectileHitEvent val$e;

            public void run()
            {
                if(!e.getEntity().isValid())
                    return;
                if(Variables.arrows.containsKey(e.getEntity().getUniqueId()))
                    Variables.arrows.remove(e.getEntity().getUniqueId());
                if(e.getEntity() instanceof Arrow)
                    handleGrapplingHook((Arrow)e.getEntity());
            }

            
            {
                this$0 = BowListener.this;
                e = projectilehitevent;
                super();
            }
        }
, 4L);
    }

    private void handleGrapplingHook(Arrow arrow)
    {
        if((arrow instanceof Arrow) && (arrow.getShooter() instanceof Player) && Variables.jump.containsKey(((Player)arrow.getShooter()).getUniqueId()))
        {
            final Player p = (Player)arrow.getShooter();
            if(p.getGameMode() != GameMode.CREATIVE && ((Boolean)Variables.jump.get(p.getUniqueId())).booleanValue())
                arrow.getWorld().dropItem(arrow.getLocation(), SlimefunItem.getItem("GRAPPLING_HOOK"));
            if(p.getLocation().distance(arrow.getLocation()) < 3D)
            {
                if(arrow.getLocation().getY() > p.getLocation().getY())
                    p.setVelocity(new Vector(0.0D, 0.25D, 0.0D));
                else
                    p.setVelocity(arrow.getLocation().toVector().subtract(p.getLocation().toVector()));
                Entity aentity[];
                int j = (aentity = (Entity[])Variables.remove.get(p.getUniqueId())).length;
                for(int i = 0; i < j; i++)
                {
                    Entity n = aentity[i];
                    n.remove();
                }

                Bukkit.getScheduler().scheduleSyncDelayedTask(SlimefunStartup.instance, new Runnable() {

                    final BowListener this$0;
                    private final Player val$p;

                    public void run()
                    {
                        Variables.jump.remove(p.getUniqueId());
                        Variables.remove.remove(p.getUniqueId());
                    }

            
            {
                this$0 = BowListener.this;
                p = player;
                super();
            }
                }
, 20L);
            } else
            {
                Location l = p.getLocation();
                l.setY(l.getY() + 0.5D);
                p.teleport(l);
                double g = -0.080000000000000002D;
                double d = arrow.getLocation().distance(l);
                double t = d;
                double v_x = ((1.0D + 0.080000000000000016D * t) * (arrow.getLocation().getX() - l.getX())) / t;
                double v_y = ((1.0D + 0.040000000000000001D * t) * (arrow.getLocation().getY() - l.getY())) / t - 0.5D * g * t;
                double v_z = ((1.0D + 0.080000000000000016D * t) * (arrow.getLocation().getZ() - l.getZ())) / t;
                Vector v = p.getVelocity();
                v.setX(v_x);
                v.setY(v_y);
                v.setZ(v_z);
                p.setVelocity(v);
                Entity aentity1[];
                int i1 = (aentity1 = (Entity[])Variables.remove.get(p.getUniqueId())).length;
                for(int k = 0; k < i1; k++)
                {
                    Entity n = aentity1[k];
                    n.remove();
                }

                Bukkit.getScheduler().scheduleSyncDelayedTask(SlimefunStartup.instance, new Runnable() {

                    final BowListener this$0;
                    private final Player val$p;

                    public void run()
                    {
                        Variables.jump.remove(p.getUniqueId());
                        Variables.remove.remove(p.getUniqueId());
                    }

            
            {
                this$0 = BowListener.this;
                p = player;
                super();
            }
                }
, 20L);
            }
        }
    }

    public void onArrowSuccessfulHit(EntityDamageByEntityEvent e)
    {
        if(e.getDamager() instanceof Arrow)
        {
            if(Variables.arrows.containsKey(e.getDamager().getUniqueId()) && (e.getEntity() instanceof LivingEntity))
            {
                for(Iterator iterator = SlimefunItem.getHandlers("BowShootHandler").iterator(); iterator.hasNext();)
                {
                    ItemHandler handler = (ItemHandler)iterator.next();
                    if(((BowShootHandler)handler).onHit(e, (LivingEntity)e.getEntity()))
                        break;
                }

                Variables.arrows.remove(e.getDamager().getUniqueId());
            }
            handleGrapplingHook((Arrow)e.getDamager());
        }
    }

}

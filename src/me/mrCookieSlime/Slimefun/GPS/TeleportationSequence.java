// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   TeleportationSequence.java

package me.mrCookieSlime.Slimefun.GPS;

import java.util.*;
import me.mrCookieSlime.CSCoreLibPlugin.general.Particles.MC_1_8.ParticleEffect;
import me.mrCookieSlime.CSCoreLibPlugin.general.World.TitleBuilder;
import me.mrCookieSlime.Slimefun.SlimefunStartup;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitScheduler;

public class TeleportationSequence
{

    public static Set players = new HashSet();

    public TeleportationSequence()
    {
    }

    public static void start(UUID uuid, int complexity, Location source, Location destination, boolean resistance)
    {
        players.add(uuid);
        updateProgress(uuid, getSpeed(complexity, source, destination), 1, source, destination, resistance);
    }

    public static int getSpeed(int complexity, Location source, Location destination)
    {
        int speed = complexity / 200;
        if(speed > 50)
            speed = 50;
        speed -= distance(source, destination) / 200;
        return speed >= 1 ? speed : 1;
    }

    private static int distance(Location source, Location destination)
    {
        if(source.getWorld().getName().equals(destination.getWorld().getName()))
        {
            int distance = (int)source.distance(destination);
            return distance <= 8000 ? distance : 8000;
        } else
        {
            return 8000;
        }
    }

    private static boolean isValid(Player p, Location source)
    {
        if(p == null)
            return false;
        return p.getLocation().distance(source) <= 1.3999999999999999D;
    }

    private static void cancel(UUID uuid, Player p)
    {
        players.remove(uuid);
        if(p != null)
            try
            {
                TitleBuilder title = (TitleBuilder)(new TitleBuilder(20, 60, 20)).addText("&4\u4F20\u9001\u88AB\u53D6\u6D88!");
                TitleBuilder subtitle = (TitleBuilder)(new TitleBuilder(20, 60, 20)).addText("&40%");
                title.send(me.mrCookieSlime.CSCoreLibPlugin.general.World.TitleBuilder.TitleType.TITLE, new Player[] {
                    p
                });
                subtitle.send(me.mrCookieSlime.CSCoreLibPlugin.general.World.TitleBuilder.TitleType.SUBTITLE, new Player[] {
                    p
                });
            }
            catch(Exception x)
            {
                x.printStackTrace();
            }
    }

    private static void updateProgress(final UUID uuid, final int speed, final int progress, final Location source, final Location destination, final boolean resistance)
    {
        Player p = Bukkit.getPlayer(uuid);
        if(isValid(p, source))
            try
            {
                if(progress > 99)
                {
                    TitleBuilder title = (TitleBuilder)(new TitleBuilder(20, 60, 20)).addText("&3\u4F20\u9001\u6210\u529F!");
                    TitleBuilder subtitle = (TitleBuilder)(new TitleBuilder(20, 60, 20)).addText("&b100%");
                    title.send(me.mrCookieSlime.CSCoreLibPlugin.general.World.TitleBuilder.TitleType.TITLE, new Player[] {
                        p
                    });
                    subtitle.send(me.mrCookieSlime.CSCoreLibPlugin.general.World.TitleBuilder.TitleType.SUBTITLE, new Player[] {
                        p
                    });
                    p.teleport(destination);
                    if(resistance)
                    {
                        p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 600, 20));
                        p.sendMessage("&b&l\u4F60\u83B7\u5F97\u4E8630\u79D2\u7684\u4FDD\u62A4!");
                    }
                    ParticleEffect.PORTAL.display(new Location(destination.getWorld(), destination.getX(), destination.getY() + 1.0D, destination.getZ()), 0.2F, 0.8F, 0.2F, 1.0F, progress * 2);
                    destination.getWorld().playSound(destination, Sound.ENTITY_BLAZE_DEATH, 2.0F, 1.4F);
                    players.remove(uuid);
                } else
                {
                    TitleBuilder title = (TitleBuilder)(new TitleBuilder(0, 60, 0)).addText("&3\u6B63\u5728\u4F20\u9001\u4E2D...");
                    TitleBuilder subtitle = (TitleBuilder)(new TitleBuilder(0, 60, 0)).addText((new StringBuilder("&b")).append(progress).append("%").toString());
                    title.send(me.mrCookieSlime.CSCoreLibPlugin.general.World.TitleBuilder.TitleType.TITLE, new Player[] {
                        p
                    });
                    subtitle.send(me.mrCookieSlime.CSCoreLibPlugin.general.World.TitleBuilder.TitleType.SUBTITLE, new Player[] {
                        p
                    });
                    ParticleEffect.PORTAL.display(source, 0.2F, 0.8F, 0.2F, 1.0F, progress * 2);
                    source.getWorld().playSound(source, Sound.UI_BUTTON_CLICK, 1.7F, 0.6F);
                    Bukkit.getScheduler().scheduleSyncDelayedTask(SlimefunStartup.instance, new Runnable() {

                        private final UUID val$uuid;
                        private final int val$speed;
                        private final int val$progress;
                        private final Location val$source;
                        private final Location val$destination;
                        private final boolean val$resistance;

                        public void run()
                        {
                            TeleportationSequence.updateProgress(uuid, speed, progress + speed, source, destination, resistance);
                        }

            
            {
                uuid = uuid1;
                speed = i;
                progress = j;
                source = location;
                destination = location1;
                resistance = flag;
                super();
            }
                    }
, 10L);
                }
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        else
            cancel(uuid, p);
    }


}

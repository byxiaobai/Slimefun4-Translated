// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   Research.java

package me.mrCookieSlime.Slimefun.Objects;

import java.io.File;
import java.io.PrintStream;
import java.util.*;
import me.mrCookieSlime.CSCoreLibPlugin.Configuration.*;
import me.mrCookieSlime.CSCoreLibPlugin.general.Particles.FireworkShow;
import me.mrCookieSlime.Slimefun.Events.ResearchUnlockEvent;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.Setup.Messages;
import me.mrCookieSlime.Slimefun.SlimefunStartup;
import org.bukkit.*;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.scheduler.BukkitScheduler;

public class Research
{

    public static boolean enabled;
    public static List list = new ArrayList();
    public static List researching = new ArrayList();
    public static boolean creative_research = true;
    private int id;
    private String name;
    private List items;
    private int cost;

    public Research(int id, String name, int cost)
    {
        this.id = id;
        this.name = name;
        this.cost = cost;
        items = new ArrayList();
    }

    public int getID()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    /**
     * @deprecated Method getLevel is deprecated
     */

    public int getLevel()
    {
        return cost;
    }

    /**
     * @deprecated Method setLevel is deprecated
     */

    public void setLevel(int level)
    {
        cost = level;
    }

    public int getCost()
    {
        return cost;
    }

    public void setCost(int cost)
    {
        this.cost = cost;
    }

    public transient void addItems(SlimefunItem items[])
    {
        SlimefunItem aslimefunitem[];
        int j = (aslimefunitem = items).length;
        for(int i = 0; i < j; i++)
        {
            SlimefunItem item = aslimefunitem[i];
            if(item != null)
                item.bindToResearch(this);
        }

    }

    public List getEffectedItems()
    {
        return items;
    }

    public boolean hasUnlocked(Player p)
    {
        return hasUnlocked(p.getUniqueId());
    }

    public boolean hasUnlocked(UUID uuid)
    {
        if(!enabled)
            return true;
        if(!SlimefunStartup.getResearchCfg().getBoolean((new StringBuilder(String.valueOf(id))).append(".enabled").toString()))
            return true;
        else
            return (new Config(new File((new StringBuilder("data-storage/Slimefun/Players/")).append(uuid.toString()).append(".yml").toString()))).contains((new StringBuilder("researches.")).append(id).toString());
    }

    public boolean canUnlock(Player p)
    {
        if(!enabled)
            return true;
        if(!SlimefunStartup.getResearchCfg().getBoolean((new StringBuilder(String.valueOf(id))).append(".enabled").toString()))
            return true;
        return p.getGameMode() == GameMode.CREATIVE && creative_research || p.getLevel() >= cost;
    }

    public void lock(Player p)
    {
        Config cfg = new Config(new File((new StringBuilder("data-storage/Slimefun/Players/")).append(p.getUniqueId()).append(".yml").toString()));
        cfg.setValue((new StringBuilder("researches.")).append(id).toString(), null);
        cfg.save();
        Messages.local.sendTranslation(p, "commands.research.reset-target", true, new Variable[0]);
    }

    public void unlock(final Player p, boolean instant)
    {
        if(!hasUnlocked(p))
        {
            ResearchUnlockEvent event = new ResearchUnlockEvent(p, this);
            Bukkit.getPluginManager().callEvent(event);
            if(!event.isCancelled())
            {
                final int research = id;
                if(instant)
                {
                    Config cfg = new Config(new File((new StringBuilder("data-storage/Slimefun/Players/")).append(p.getUniqueId()).append(".yml").toString()));
                    cfg.setValue((new StringBuilder("researches.")).append(research).toString(), Boolean.valueOf(true));
                    cfg.save();
                    Messages.local.sendTranslation(p, "messages.unlocked", true, new Variable[] {
                        new Variable("%research%", getName())
                    });
                    if(SlimefunStartup.getCfg().getBoolean("options.research-give-fireworks"))
                        FireworkShow.launchRandom(p, 1);
                } else
                if(!researching.contains(p.getUniqueId()))
                {
                    researching.add(p.getUniqueId());
                    Messages.local.sendTranslation(p, "messages.research.start", true, new Variable[] {
                        new Variable("%research%", getName())
                    });
                    Bukkit.getScheduler().scheduleSyncDelayedTask(SlimefunStartup.instance, new Runnable() {

                        final Research this$0;
                        private final Player val$p;
                        private final int val$research;

                        public void run()
                        {
                            p.playSound(p.getLocation(), Sound.ENTITY_BAT_TAKEOFF, 0.7F, 1.0F);
                            Messages.local.sendTranslation(p, "messages.research.progress", true, new Variable[] {
                                new Variable("%research%", getName()), new Variable("%progress%", "23%")
                            });
                            Bukkit.getScheduler().scheduleSyncDelayedTask(SlimefunStartup.instance, new Runnable() {

                                final _cls1 this$1;
                                private final Player val$p;
                                private final int val$research;

                                public void run()
                                {
                                    p.playSound(p.getLocation(), Sound.ENTITY_BAT_TAKEOFF, 0.7F, 1.0F);
                                    Messages.local.sendTranslation(p, "messages.research.progress", true, new Variable[] {
                                        new Variable("%research%", getName()), new Variable("%progress%", "44%")
                                    });
                                    Bukkit.getScheduler().scheduleSyncDelayedTask(SlimefunStartup.instance, new Runnable() {

                                        final _cls1 this$2;
                                        private final Player val$p;
                                        private final int val$research;

                                        public void run()
                                        {
                                            p.playSound(p.getLocation(), Sound.ENTITY_BAT_TAKEOFF, 0.7F, 1.0F);
                                            Messages.local.sendTranslation(p, "messages.research.progress", true, new Variable[] {
                                                new Variable("%research%", getName()), new Variable("%progress%", "57%")
                                            });
                                            Bukkit.getScheduler().scheduleSyncDelayedTask(SlimefunStartup.instance, new Runnable() {

                                                final _cls1 this$3;
                                                private final Player val$p;
                                                private final int val$research;

                                                public void run()
                                                {
                                                    p.playSound(p.getLocation(), Sound.ENTITY_BAT_TAKEOFF, 0.7F, 1.0F);
                                                    Messages.local.sendTranslation(p, "messages.research.progress", true, new Variable[] {
                                                        new Variable("%research%", getName()), new Variable("%progress%", "92%")
                                                    });
                                                    Bukkit.getScheduler().scheduleSyncDelayedTask(SlimefunStartup.instance, new Runnable() {

                                                        final _cls1 this$4;
                                                        private final Player val$p;
                                                        private final int val$research;

                                                        public void run()
                                                        {
                                                            Config cfg = new Config(new File((new StringBuilder("data-storage/Slimefun/Players/")).append(p.getUniqueId()).append(".yml").toString()));
                                                            cfg.setValue((new StringBuilder("researches.")).append(research).toString(), Boolean.valueOf(true));
                                                            cfg.save();
                                                            Messages.local.sendTranslation(p, "messages.unlocked", true, new Variable[] {
                                                                new Variable("%research%", getName())
                                                            });
                                                            if(SlimefunStartup.getCfg().getBoolean("options.research-unlock-fireworks"))
                                                                FireworkShow.launchRandom(p, 1);
                                                            Research.researching.remove(p.getUniqueId());
                                                        }

                                
                                {
                                    this$4 = _cls1.this;
                                    p = player;
                                    research = i;
                                    super();
                                }
                                                    }
, 20L);
                                                }


                            
                            {
                                this$3 = _cls1.this;
                                p = player;
                                research = i;
                                super();
                            }
                                            }
, 20L);
                                        }


                        
                        {
                            this$2 = _cls1.this;
                            p = player;
                            research = i;
                            super();
                        }
                                    }
, 20L);
                                }


                    
                    {
                        this$1 = _cls1.this;
                        p = player;
                        research = i;
                        super();
                    }
                            }
, 20L);
                        }


            
            {
                this$0 = Research.this;
                p = player;
                research = i;
                super();
            }
                    }
, 20L);
                }
            }
        }
    }

    public void register()
    {
        SlimefunStartup.getResearchCfg().setDefaultValue("enable-researching", Boolean.valueOf(true));
        if(SlimefunStartup.getResearchCfg().contains((new StringBuilder(String.valueOf(getID()))).append(".enabled").toString()) && !SlimefunStartup.getResearchCfg().getBoolean((new StringBuilder(String.valueOf(getID()))).append(".enabled").toString()))
        {
            for(Iterator iterator = items.iterator(); iterator.hasNext(); iterator.remove())
            {
                SlimefunItem item = (SlimefunItem)iterator.next();
                if(item != null)
                    item.bindToResearch(null);
            }

            return;
        }
        SlimefunStartup.getResearchCfg().setDefaultValue((new StringBuilder(String.valueOf(getID()))).append(".name").toString(), getName());
        SlimefunStartup.getResearchCfg().setDefaultValue((new StringBuilder(String.valueOf(getID()))).append(".cost").toString(), Integer.valueOf(getCost()));
        SlimefunStartup.getResearchCfg().setDefaultValue((new StringBuilder(String.valueOf(getID()))).append(".enabled").toString(), Boolean.valueOf(true));
        name = SlimefunStartup.getResearchCfg().getString((new StringBuilder(String.valueOf(getID()))).append(".name").toString());
        cost = SlimefunStartup.getResearchCfg().getInt((new StringBuilder(String.valueOf(getID()))).append(".cost").toString());
        list.add(this);
        if(SlimefunStartup.getCfg().getBoolean("options.print-out-loading"))
            System.out.println((new StringBuilder("[Slimefun] Loaded Research \"")).append(getName()).append("\"").toString());
    }

    public static List list()
    {
        return list;
    }

    public static boolean isResearching(Player p)
    {
        return researching.contains(p.getUniqueId());
    }

    public static void sendStats(CommandSender sender, Player p)
    {
        List researched = new ArrayList();
        int levels = 0;
        for(Iterator iterator = list().iterator(); iterator.hasNext();)
        {
            Research r = (Research)iterator.next();
            if(r.hasUnlocked(p))
            {
                researched.add(r);
                levels += r.getLevel();
            }
        }

        String progress = String.valueOf((float)Math.round((((float)researched.size() * 100F) / (float)list().size()) * 100F) / 100F);
        if(Float.parseFloat(progress) < 16F)
            progress = (new StringBuilder("&4")).append(progress).append(" &r% ").toString();
        else
        if(Float.parseFloat(progress) < 32F)
            progress = (new StringBuilder("&c")).append(progress).append(" &r% ").toString();
        else
        if(Float.parseFloat(progress) < 48F)
            progress = (new StringBuilder("&6")).append(progress).append(" &r% ").toString();
        else
        if(Float.parseFloat(progress) < 64F)
            progress = (new StringBuilder("&e")).append(progress).append(" &r% ").toString();
        else
        if(Float.parseFloat(progress) < 80F)
            progress = (new StringBuilder("&2")).append(progress).append(" &r% ").toString();
        else
            progress = (new StringBuilder("&a")).append(progress).append(" &r% ").toString();
        sender.sendMessage("");
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', (new StringBuilder("&7Statistics for Player: &b")).append(p.getName()).toString()));
        sender.sendMessage("");
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', (new StringBuilder("&7Title: &b")).append(getTitle(p, researched)).toString()));
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', (new StringBuilder("&7Research Progress: ")).append(progress).append("&e(").append(researched.size()).append(" / ").append(list().size()).append(")").toString()));
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', (new StringBuilder("&7Total XP Levels spent: &b")).append(levels).toString()));
    }

    public static String getTitle(Player p, List researched)
    {
        int index = Math.round(Float.valueOf(String.valueOf((float)Math.round((((float)researched.size() * 100F) / (float)list().size()) * 100F) / 100F)).floatValue() / 100F) * SlimefunStartup.getCfg().getStringList("research-ranks").size();
        if(index > 0)
            index--;
        return (String)SlimefunStartup.getCfg().getStringList("research-ranks").get(index);
    }

    public static Research getByID(int id)
    {
        for(Iterator iterator = list.iterator(); iterator.hasNext();)
        {
            Research research = (Research)iterator.next();
            if(research.getID() == id)
                return research;
        }

        return null;
    }

    public static List getResearches(UUID uuid)
    {
        List researched = new ArrayList();
        for(Iterator iterator = list().iterator(); iterator.hasNext();)
        {
            Research r = (Research)iterator.next();
            if(r.hasUnlocked(uuid))
                researched.add(r);
        }

        return researched;
    }

    public static List getResearches(String uuid)
    {
        return getResearches(UUID.fromString(uuid));
    }

}

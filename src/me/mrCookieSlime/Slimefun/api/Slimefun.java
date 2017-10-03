// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   Slimefun.java

package me.mrCookieSlime.Slimefun.api;

import java.util.*;
import me.mrCookieSlime.CSCoreLibPlugin.Configuration.*;
import me.mrCookieSlime.Slimefun.GPS.GPSNetwork;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.Objects.Research;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.VanillaItem;
import me.mrCookieSlime.Slimefun.Setup.Messages;
import me.mrCookieSlime.Slimefun.SlimefunStartup;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

// Referenced classes of package me.mrCookieSlime.Slimefun.api:
//            GuideHandler

public class Slimefun
{

    public static Map guide_handlers = new HashMap();
    public static List guide_handlers2 = new ArrayList();
    private static GPSNetwork gps = new GPSNetwork();
    public static boolean emeraldenchants = false;
    public static List current_categories = new ArrayList();

    public Slimefun()
    {
    }

    public static void registerGuideHandler(GuideHandler handler)
    {
        List handlers = new ArrayList();
        if(guide_handlers.containsKey(Integer.valueOf(handler.getTier())))
            handlers = (List)guide_handlers.get(Integer.valueOf(handler.getTier()));
        handlers.add(handler);
        guide_handlers.put(Integer.valueOf(handler.getTier()), handlers);
        guide_handlers2.add(handler);
    }

    public static GPSNetwork getGPSNetwork()
    {
        return gps;
    }

    public static Object getItemValue(String id, String key)
    {
        return getItemConfig().getValue((new StringBuilder(String.valueOf(id))).append(".").append(key).toString());
    }

    public static void setItemVariable(String id, String key, Object value)
    {
        getItemConfig().setDefaultValue((new StringBuilder(String.valueOf(id))).append(".").append(key).toString(), value);
    }

    public static Config getItemConfig()
    {
        return SlimefunStartup.getItemCfg();
    }

    public static transient void registerResearch(Research research, ItemStack items[])
    {
        ItemStack aitemstack[];
        int j = (aitemstack = items).length;
        for(int i = 0; i < j; i++)
        {
            ItemStack item = aitemstack[i];
            research.addItems(new SlimefunItem[] {
                SlimefunItem.getByItem(item)
            });
        }

        research.register();
    }

    public static boolean hasUnlocked(Player p, ItemStack item, boolean message)
    {
        SlimefunItem sfItem = SlimefunItem.getByItem(item);
        me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem.State state = SlimefunItem.getState(item);
        if(sfItem == null)
            if(state != me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem.State.ENABLED)
            {
                if(message && state != me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem.State.VANILLA)
                    Messages.local.sendTranslation(p, "messages.disabled-item", true, new Variable[0]);
                return false;
            } else
            {
                return true;
            }
        if(isEnabled(p, item, message) && hasPermission(p, sfItem, message))
        {
            if(sfItem.getResearch() == null)
                return true;
            if(sfItem.getResearch().hasUnlocked(p))
                return true;
            if(message && !(sfItem instanceof VanillaItem))
                Messages.local.sendTranslation(p, "messages.not-researched", true, new Variable[0]);
            return false;
        } else
        {
            return false;
        }
    }

    public static boolean hasUnlocked(Player p, SlimefunItem sfItem, boolean message)
    {
        if(isEnabled(p, sfItem, message) && hasPermission(p, sfItem, message))
        {
            if(sfItem.getResearch() == null)
                return true;
            if(sfItem.getResearch().hasUnlocked(p))
                return true;
            if(message && !(sfItem instanceof VanillaItem))
                Messages.local.sendTranslation(p, "messages.not-researched", true, new Variable[0]);
            return false;
        } else
        {
            return false;
        }
    }

    public static boolean hasPermission(Player p, SlimefunItem item, boolean message)
    {
        if(item == null)
            return true;
        if(SlimefunStartup.getItemCfg().getString((new StringBuilder(String.valueOf(item.getName()))).append(".required-permission").toString()).equalsIgnoreCase(""))
            return true;
        if(p.hasPermission(SlimefunStartup.getItemCfg().getString((new StringBuilder(String.valueOf(item.getName()))).append(".required-permission").toString())))
            return true;
        if(message)
            Messages.local.sendTranslation(p, "messages.no-permission", true, new Variable[0]);
        return false;
    }

    public static boolean isEnabled(Player p, ItemStack item, boolean message)
    {
        String world = p.getWorld().getName();
        SlimefunItem sfItem = SlimefunItem.getByItem(item);
        if(sfItem == null)
            return !SlimefunItem.isDisabled(item);
        if(SlimefunStartup.getWhitelist().contains((new StringBuilder(String.valueOf(world))).append(".enabled").toString()))
        {
            if(SlimefunStartup.getWhitelist().getBoolean((new StringBuilder(String.valueOf(world))).append(".enabled").toString()))
            {
                if(!SlimefunStartup.getWhitelist().contains((new StringBuilder(String.valueOf(world))).append(".enabled-items.").append(sfItem.getName()).toString()))
                    SlimefunStartup.getWhitelist().setDefaultValue((new StringBuilder(String.valueOf(world))).append(".enabled-items.").append(sfItem.getName()).toString(), Boolean.valueOf(true));
                if(SlimefunStartup.getWhitelist().getBoolean((new StringBuilder(String.valueOf(world))).append(".enabled-items.").append(sfItem.getName()).toString()))
                    return true;
                if(message)
                    Messages.local.sendTranslation(p, "messages.disabled-in-world", true, new Variable[0]);
                return false;
            }
            if(message)
                Messages.local.sendTranslation(p, "messages.disabled-in-world", true, new Variable[0]);
            return false;
        } else
        {
            return true;
        }
    }

    public static boolean isEnabled(Player p, SlimefunItem sfItem, boolean message)
    {
        String world = p.getWorld().getName();
        if(SlimefunStartup.getWhitelist().contains((new StringBuilder(String.valueOf(world))).append(".enabled").toString()))
        {
            if(SlimefunStartup.getWhitelist().getBoolean((new StringBuilder(String.valueOf(world))).append(".enabled").toString()))
            {
                if(!SlimefunStartup.getWhitelist().contains((new StringBuilder(String.valueOf(world))).append(".enabled-items.").append(sfItem.getName()).toString()))
                    SlimefunStartup.getWhitelist().setDefaultValue((new StringBuilder(String.valueOf(world))).append(".enabled-items.").append(sfItem.getName()).toString(), Boolean.valueOf(true));
                if(SlimefunStartup.getWhitelist().getBoolean((new StringBuilder(String.valueOf(world))).append(".enabled-items.").append(sfItem.getName()).toString()))
                    return true;
                if(message)
                    Messages.local.sendTranslation(p, "messages.disabled-in-world", true, new Variable[0]);
                return false;
            }
            if(message)
                Messages.local.sendTranslation(p, "messages.disabled-in-world", true, new Variable[0]);
            return false;
        } else
        {
            return true;
        }
    }

    public static List listIDs()
    {
        List ids = new ArrayList();
        SlimefunItem item;
        for(Iterator iterator = SlimefunItem.list().iterator(); iterator.hasNext(); ids.add(item.getName()))
            item = (SlimefunItem)iterator.next();

        return ids;
    }

    public static List listCategories()
    {
        List items = new ArrayList();
        Category c;
        for(Iterator iterator = Category.list().iterator(); iterator.hasNext(); items.add(c.getItem()))
            c = (Category)iterator.next();

        return items;
    }

    /**
     * @deprecated Method addDescription is deprecated
     */

    public static transient void addDescription(String id, String description[])
    {
        getItemConfig().setDefaultValue((new StringBuilder(String.valueOf(id))).append(".description").toString(), Arrays.asList(description));
    }

    public static transient void addHint(String id, String hint[])
    {
        getItemConfig().setDefaultValue((new StringBuilder(String.valueOf(id))).append(".hint").toString(), Arrays.asList(hint));
    }

    public static void addYoutubeVideo(String id, String link)
    {
        getItemConfig().setDefaultValue((new StringBuilder(String.valueOf(id))).append(".youtube").toString(), link);
    }

    public static void addWikiPage(String id, String link)
    {
        getItemConfig().setDefaultValue((new StringBuilder(String.valueOf(id))).append(".wiki").toString(), link);
    }

    public static void addOfficialWikiPage(String id, String page)
    {
        addWikiPage(id, (new StringBuilder("https://github.com/TheBusyBiscuit/Slimefun4/wiki/")).append(page).toString());
    }

    public static boolean isEmeraldEnchantsInstalled()
    {
        return emeraldenchants;
    }

    public static List getGuideHandlers(int tier)
    {
        return ((List) (guide_handlers.containsKey(Integer.valueOf(tier)) ? (List)guide_handlers.get(Integer.valueOf(tier)) : new ArrayList()));
    }

}

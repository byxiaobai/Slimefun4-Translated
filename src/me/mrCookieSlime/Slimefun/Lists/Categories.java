// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   Categories.java

package me.mrCookieSlime.Slimefun.Lists;

import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.Item.*;
import me.mrCookieSlime.CSCoreLibPlugin.general.World.CustomSkull;
import me.mrCookieSlime.Slimefun.Objects.*;
import org.bukkit.*;

public class Categories
{

    public static Category WEAPONS;
    public static Category PORTABLE = null;
    public static Category FOOD;
    public static Category MACHINES_1;
    public static LockedCategory ELECTRICITY = null;
    public static LockedCategory GPS = null;
    public static Category ARMOR;
    public static Category LUMPS_AND_MAGIC;
    public static Category MAGIC;
    public static Category MISC = null;
    public static Category TECH;
    public static Category RESOURCES = null;
    public static Category CARGO = null;
    public static Category TECH_MISC;
    public static Category MAGIC_ARMOR;
    public static Category TALISMANS_1;
    public static LockedCategory TALISMANS_2;
    public static Category TOOLS;
    public static SeasonCategory CHRISTMAS;
    public static SeasonCategory VALENTINES_DAY;
    public static SeasonCategory EASTER;
    public static SeasonCategory BIRTHDAY;

    public Categories()
    {
    }

    static 
    {
        WEAPONS = new Category(new MenuItem(Material.GOLD_SWORD, "&7\u6B66\u5668", 0, "open"), 1);
        FOOD = new Category(new MenuItem(Material.APPLE, "&7\u98DF\u7269", 0, "open"), 2);
        MACHINES_1 = null;
        ARMOR = new Category(new MenuItem(Material.IRON_CHESTPLATE, "&7\u9632\u5177", 0, "open"), 2);
        LUMPS_AND_MAGIC = new Category(new MenuItem(Material.FIREBALL, "&7\u9B54\u6CD5\u7269\u54C1", 0, "open"), 2);
        MAGIC = new Category(new MenuItem(Material.BLAZE_POWDER, "&7\u9B54\u6CD5\u5668\u5177", 0, "open"), 3);
        TECH = new Category(new CustomArmor(new MenuItem(Material.LEATHER_CHESTPLATE, "&7\u79D1\u6280\u5668\u5177", 0, "open"), Color.SILVER), 3);
        TECH_MISC = new Category(new MenuItem(Material.REDSTONE_COMPARATOR, "&7\u79D1\u6280\u96F6\u4EF6", 0, "open"), 2);
        MAGIC_ARMOR = new Category(new MenuItem(Material.GOLD_CHESTPLATE, "&7\u9B54\u6CD5\u9632\u5177", 0, "open"), 2);
        TALISMANS_1 = new Category(new MenuItem(Material.EMERALD, "&7\u62A4\u8EAB\u7B26 - &aI \u7EA7", 0, "open"), 2);
        TALISMANS_2 = new LockedCategory(new MenuItem(Material.EMERALD, "&7\u62A4\u8EAB\u7B26 - &aII \u7EA7", 0, "open"), 3, new Category[] {
            TALISMANS_1
        });
        TOOLS = new Category(new MenuItem(Material.GOLD_PICKAXE, "&7\u5DE5\u5177", 0, "open"), 1);
        CHRISTMAS = new SeasonCategory(12, 1, new MenuItem(Material.NETHER_STAR, "&a\u5723&c\u8BDE&a\u8282", 0, ChatColor.translateAlternateColorCodes('&', "&c\u5E2E\u52A9 &a\u5723\u8BDE\u8001\u4EBA")));
        VALENTINES_DAY = new SeasonCategory(2, 2, new MenuItem(Material.RED_ROSE, "&d\u60C5\u4EBA\u8282", 0, ChatColor.translateAlternateColorCodes('&', "&d\u5E86\u795D\u7231\u60C5 &7&m(FFF)")));
        EASTER = new SeasonCategory(1, 2, new MenuItem(Material.EGG, "&6\u590D\u6D3B\u8282", 0, ChatColor.translateAlternateColorCodes('&', "&a\u7ED9\u4E00\u4E9B\u86CB\u4E0A\u8272")));
        BIRTHDAY = new SeasonCategory(10, 1, new MenuItem(Material.FIREWORK, "&a&lmrCookieSlime \u7684\u751F\u65E5 &7(10/26)", 0, ChatColor.translateAlternateColorCodes('&', "&a\u548C\u6211\u4E00\u8D77\u5E86\u795D")));
        try
        {
            MISC = new Category(new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOTRkYTk3ZjA4MGUzOTViODQyYzRjYzgyYTg0MDgyM2Q0ZGJkOGNhNjg4YTIwNjg1M2U1NzgzZTRiZmRjMDEyIn19fQ=="), "&7\u6742\u7269", new String[] {
                "", "&a> \u70B9\u51FB\u5F00\u542F"
            }), 2);
            PORTABLE = new Category(new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNDBjYjFlNjdiNTEyYWIyZDRiZjNkN2FjZTBlYWFmNjFjMzJjZDQ2ODFkZGMzOTg3Y2ViMzI2NzA2YTMzZmEifX19"), "&7\u7269\u54C1", new String[] {
                "", "&a> \u70B9\u51FB\u5F00\u542F"
            }), 1);
            MACHINES_1 = new Category(new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOTM0M2NlNThkYTU0Yzc5OTI0YTJjOTMzMWNmYzQxN2ZlOGNjYmJlYTliZTQ1YTdhYzg1ODYwYTZjNzMwIn19fQ=="), "&7\u57FA\u7840\u673A\u5668", new String[] {
                "", "&a> \u70B9\u51FB\u5F00\u542F"
            }), 1);
            ELECTRICITY = new LockedCategory(new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNTU4NDQzMmFmNmYzODIxNjcxMjAyNThkMWVlZThjODdjNmU3NWQ5ZTQ3OWU3YjBkNGM3YjZhZDQ4Y2ZlZWYifX19"), "&b\u80FD\u6E90\u4E0E\u673A\u5668", new String[] {
                "", "&a> \u70B9\u51FB\u5F00\u542F"
            }), 4, new Category[] {
                MACHINES_1
            });
            GPS = new LockedCategory(new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjBjOWMxYTAyMmY0MGI3M2YxNGI0Y2JhMzdjNzE4YzZhNTMzZjNhMjg2NGI2NTM2ZDVmNDU2OTM0Y2MxZiJ9fX0="), "&bGPS\u57FA\u7840\u673A\u68B0", new String[] {
                "", "&a> \u70B9\u51FB\u5F00\u542F"
            }), 4, new Category[] {
                MACHINES_1
            });
            RESOURCES = new Category(new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvY2U4ZjVhZGIxNGQ2YzlmNmI4MTBkMDI3NTQzZjFhOGMxZjQxN2UyZmVkOTkzYzk3YmNkODljNzRmNWUyZTgifX19"), "&7\u77FF\u7269\u8D44\u6E90", new String[] {
                "", "&a> \u70B9\u51FB\u5F00\u542F"
            }), 1);
            CARGO = new LockedCategory(new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZTUxMGJjODUzNjJhMTMwYTZmZjlkOTFmZjExZDZmYTQ2ZDdkMTkxMmEzNDMxZjc1MTU1OGVmM2M0ZDljMiJ9fX0="), "&c\u8D27\u7269\u7BA1\u7406", new String[] {
                "", "&a> \u70B9\u51FB\u5F00\u542F"
            }), 4, new Category[] {
                MACHINES_1
            });
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}

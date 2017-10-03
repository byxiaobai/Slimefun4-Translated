// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   MachineHelper.java

package me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class MachineHelper
{

    public MachineHelper()
    {
    }

    public static String getTimeLeft(int l)
    {
        String timeleft = "";
        int minutes = (int)((long)l / 60L);
        if(minutes > 0)
            timeleft = (new StringBuilder(String.valueOf(String.valueOf(timeleft)))).append(minutes).append("m ").toString();
        l -= minutes * 60;
        int seconds = l;
        timeleft = (new StringBuilder(String.valueOf(String.valueOf(timeleft)))).append(seconds).append("s").toString();
        return ChatColor.translateAlternateColorCodes('&', (new StringBuilder("&7")).append(timeleft).append(" left").toString());
    }

    public static String getProgress(int time, int total)
    {
        StringBuilder progress = new StringBuilder();
        float percentage = Math.round(((((float)(total - time) * 100F) / (float)total) * 100F) / 100F);
        if(percentage < 16F)
            progress.append("&4");
        else
        if(percentage < 32F)
            progress.append("&c");
        else
        if(percentage < 48F)
            progress.append("&6");
        else
        if(percentage < 64F)
            progress.append("&e");
        else
        if(percentage < 80F)
            progress.append("&2");
        else
            progress = progress.append("&a");
        int rest = 20;
        for(int i = (int)percentage; i >= 5; i -= 5)
        {
            progress.append(":");
            rest--;
        }

        progress.append("&7");
        for(int i = 0; i < rest; i++)
            progress.append(":");

        progress.append((new StringBuilder(" - ")).append(percentage).append("%").toString());
        return ChatColor.translateAlternateColorCodes('&', progress.toString());
    }

    public static String getCoolant(int time, int total)
    {
        int passed = (total - time) % 25;
        StringBuilder progress = new StringBuilder();
        float percentage = Math.round(((((float)(25 - passed) * 100F) / 25F) * 100F) / 100F);
        if(percentage < 33F)
            progress.append("&9");
        else
        if(percentage < 66F)
            progress.append("&1");
        else
            progress = progress.append("&b");
        int rest = 20;
        for(int i = (int)percentage; i >= 5; i -= 5)
        {
            progress.append(":");
            rest--;
        }

        progress.append("&7");
        for(int i = 0; i < rest; i++)
            progress.append(":");

        progress.append((new StringBuilder(" - ")).append(percentage).append("%").toString());
        return ChatColor.translateAlternateColorCodes('&', progress.toString());
    }

    public static float getPercentage(int time, int total)
    {
        int passed = (total - time) % 25;
        return (float)Math.round(((((float)(25 - passed) * 100F) / 25F) * 100F) / 100F);
    }

    public static short getDurability(ItemStack item, int timeleft, int max)
    {
        return (short)((item.getType().getMaxDurability() / max) * timeleft);
    }
}

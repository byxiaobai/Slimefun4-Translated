// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   GuideHandler.java

package me.mrCookieSlime.Slimefun.api;

import java.util.List;
import me.mrCookieSlime.CSCoreLibPlugin.PlayerRunnable;
import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu;
import me.mrCookieSlime.Slimefun.SlimefunGuide;
import me.mrCookieSlime.Slimefun.URID.URID;
import org.bukkit.entity.Player;

public abstract class GuideHandler
{

    URID urid;

    public GuideHandler()
    {
        urid = URID.nextURID(this, false);
    }

    public URID getURID()
    {
        return urid;
    }

    public abstract void addEntry(List list, List list1);

    public abstract PlayerRunnable getRunnable();

    public abstract int getTier();

    public abstract boolean trackHistory();

    public abstract int next(Player player, int i, ChestMenu chestmenu);

    public PlayerRunnable getRunnable(boolean book)
    {
        return getRunnable();
    }

    public void run(Player p, boolean survival, boolean book)
    {
        getRunnable(book).run(p);
        if(survival && trackHistory())
            SlimefunGuide.addToHistory(p, getURID());
    }
}

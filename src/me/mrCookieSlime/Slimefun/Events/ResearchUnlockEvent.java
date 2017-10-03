// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   ResearchUnlockEvent.java

package me.mrCookieSlime.Slimefun.Events;

import me.mrCookieSlime.Slimefun.Objects.Research;
import org.bukkit.entity.Player;
import org.bukkit.event.*;

public class ResearchUnlockEvent extends Event
    implements Cancellable
{

    private static final HandlerList handlers = new HandlerList();
    Player p;
    Research r;
    boolean cancelled;

    public HandlerList getHandlers()
    {
        return handlers;
    }

    public static HandlerList getHandlerList()
    {
        return handlers;
    }

    public ResearchUnlockEvent(Player p, Research res)
    {
        this.p = p;
        r = res;
    }

    public Player getPlayer()
    {
        return p;
    }

    public Research getResearch()
    {
        return r;
    }

    public boolean isCancelled()
    {
        return cancelled;
    }

    public void setCancelled(boolean cancel)
    {
        cancelled = cancel;
    }

}

package me.mrCookieSlime.Slimefun.Events;

import me.mrCookieSlime.Slimefun.Objects.MultiBlock;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.*;

public class MultiBlockInteractEvent extends Event
    implements Cancellable
{

    private static final HandlerList handlers = new HandlerList();
    Player p;
    MultiBlock mb;
    Block b;
    boolean cancelled;

    public HandlerList getHandlers()
    {
        return handlers;
    }

    public static HandlerList getHandlerList()
    {
        return handlers;
    }

    public MultiBlockInteractEvent(Player p, MultiBlock mb, Block clicked)
    {
        this.p = p;
        this.mb = mb;
        b = clicked;
    }

    public Player getPlayer()
    {
        return p;
    }

    public MultiBlock getMultiBlock()
    {
        return mb;
    }

    public Block getClickedBlock()
    {
        return b;
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

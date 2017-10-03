// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   ItemInteractionHandler.java

package me.mrCookieSlime.Slimefun.Objects.SlimefunItem.handlers;

import me.mrCookieSlime.CSCoreLibPlugin.events.ItemUseEvent;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

// Referenced classes of package me.mrCookieSlime.Slimefun.Objects.SlimefunItem.handlers:
//            ItemHandler

public abstract class ItemInteractionHandler extends ItemHandler
{

    public ItemInteractionHandler()
    {
    }

    public abstract boolean onRightClick(ItemUseEvent itemuseevent, Player player, ItemStack itemstack);

    public String toCodename()
    {
        return "ItemInteractionHandler";
    }
}

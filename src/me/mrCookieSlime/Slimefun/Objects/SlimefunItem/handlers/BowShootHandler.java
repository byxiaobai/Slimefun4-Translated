// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   BowShootHandler.java

package me.mrCookieSlime.Slimefun.Objects.SlimefunItem.handlers;

import org.bukkit.entity.LivingEntity;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

// Referenced classes of package me.mrCookieSlime.Slimefun.Objects.SlimefunItem.handlers:
//            ItemHandler

public abstract class BowShootHandler extends ItemHandler
{

    public BowShootHandler()
    {
    }

    public abstract boolean onHit(EntityDamageByEntityEvent entitydamagebyentityevent, LivingEntity livingentity);

    public String toCodename()
    {
        return "BowShootHandler";
    }
}

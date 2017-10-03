// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   EnergyFlowListener.java

package me.mrCookieSlime.Slimefun.api.energy;

import org.bukkit.block.Block;

public interface EnergyFlowListener
{

    public abstract void onPulse(Block block);
}

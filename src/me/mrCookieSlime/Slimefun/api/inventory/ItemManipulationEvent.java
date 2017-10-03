// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   ItemManipulationEvent.java

package me.mrCookieSlime.Slimefun.api.inventory;

import org.bukkit.inventory.ItemStack;

public interface ItemManipulationEvent
{

    public abstract ItemStack onEvent(int i, ItemStack itemstack, ItemStack itemstack1);
}

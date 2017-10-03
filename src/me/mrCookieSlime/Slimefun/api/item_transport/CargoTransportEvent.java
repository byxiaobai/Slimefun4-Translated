// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   CargoTransportEvent.java

package me.mrCookieSlime.Slimefun.api.item_transport;

import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;

public interface CargoTransportEvent
{

    public abstract ItemStack onEvent(Block block, int i, ItemStack itemstack, ItemStack itemstack1);
}

// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   MachineFuel.java

package me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems;

import org.bukkit.inventory.ItemStack;

public class MachineFuel
{

    int seconds;
    ItemStack fuel;
    ItemStack output;

    public MachineFuel(int seconds, ItemStack fuel)
    {
        this.seconds = seconds * 2;
        this.fuel = fuel;
        output = null;
    }

    public MachineFuel(int seconds, ItemStack fuel, ItemStack output)
    {
        this.seconds = seconds * 2;
        this.fuel = fuel;
        this.output = output;
    }

    public ItemStack getInput()
    {
        return fuel;
    }

    public ItemStack getOutput()
    {
        return output;
    }

    public int getTicks()
    {
        return seconds;
    }
}

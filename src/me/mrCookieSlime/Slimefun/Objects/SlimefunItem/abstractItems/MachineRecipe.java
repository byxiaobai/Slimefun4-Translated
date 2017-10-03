// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   MachineRecipe.java

package me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems;

import org.bukkit.inventory.ItemStack;

public class MachineRecipe
{

    int ticks;
    ItemStack input[];
    ItemStack output[];

    public MachineRecipe(int seconds, ItemStack input[], ItemStack output[])
    {
        ticks = seconds * 2;
        this.input = input;
        this.output = output;
    }

    public ItemStack[] getInput()
    {
        return input;
    }

    public ItemStack[] getOutput()
    {
        return output;
    }

    public void setTicks(int ticks)
    {
        this.ticks = ticks;
    }

    public int getTicks()
    {
        return ticks;
    }
}

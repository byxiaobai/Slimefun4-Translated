// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   Charge.java

package me.mrCookieSlime.Slimefun.Objects;


public class Charge
{

    double charge;
    double capacity;

    public Charge(double charge, double capacity)
    {
        this.charge = charge;
        this.capacity = capacity;
    }

    public double getStoredEnergy()
    {
        return charge;
    }

    public double getCapacity()
    {
        return capacity;
    }
}

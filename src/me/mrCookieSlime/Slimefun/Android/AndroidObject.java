// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   AndroidObject.java

package me.mrCookieSlime.Slimefun.Android;

import org.bukkit.block.Block;

// Referenced classes of package me.mrCookieSlime.Slimefun.Android:
//            ProgrammableAndroid

public class AndroidObject
{

    ProgrammableAndroid android;
    Block b;

    public AndroidObject(ProgrammableAndroid android, Block b)
    {
        this.android = android;
        this.b = b;
    }

    public ProgrammableAndroid getAndroid()
    {
        return android;
    }

    public Block getBlock()
    {
        return b;
    }
}

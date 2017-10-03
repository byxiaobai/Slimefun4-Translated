// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   URID.java

package me.mrCookieSlime.Slimefun.URID;

import java.util.HashMap;
import java.util.Map;

public class URID
{

    public static Map objects = new HashMap();
    public static Map ids = new HashMap();
    private static int next = 0;
    private int id;
    private boolean dirty;

    public URID(Object object, boolean dirty)
    {
        id = next;
        next++;
        objects.put(this, object);
        ids.put(Integer.valueOf(toInteger()), this);
    }

    public int toInteger()
    {
        return id;
    }

    public static URID nextURID(Object object, boolean dirty)
    {
        URID urid = new URID(object, dirty);
        return urid;
    }

    public static URID fromInteger(int id)
    {
        return (URID)ids.get(Integer.valueOf(id));
    }

    public static Object decode(URID urid)
    {
        return objects.get(urid);
    }

    public void markDirty()
    {
        if(dirty)
        {
            ids.remove(Integer.valueOf(toInteger()));
            objects.remove(this);
        }
    }

}

// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   ScriptDownloadSorter.java

package me.mrCookieSlime.Slimefun.Android.ScriptComparators;

import java.util.Comparator;
import me.mrCookieSlime.CSCoreLibPlugin.Configuration.Config;
import me.mrCookieSlime.Slimefun.Android.ProgrammableAndroid;

public class ScriptDownloadSorter
    implements Comparator
{

    ProgrammableAndroid android;

    public ScriptDownloadSorter(ProgrammableAndroid programmableAndroid)
    {
        android = programmableAndroid;
    }

    public int compare(Config c1, Config c2)
    {
        return c2.getInt("downloads") - c1.getInt("downloads");
    }

    public volatile int compare(Object obj, Object obj1)
    {
        return compare((Config)obj, (Config)obj1);
    }
}

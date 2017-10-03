// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   MachineSettings.java

package me.mrCookieSlime.Slimefun.api.machine;

import java.util.List;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems.AContainer;

// Referenced classes of package me.mrCookieSlime.Slimefun.api.machine:
//            MachineConfig

public class MachineSettings
{

    MachineConfig cfg;
    String prefix;

    public MachineSettings(MachineConfig cfg)
    {
        prefix = "global";
        this.cfg = cfg;
    }

    public MachineSettings(MachineConfig cfg, AContainer machine)
    {
        prefix = "global";
        this.cfg = cfg;
        prefix = machine.getName();
    }

    public String getString(String path)
    {
        return cfg.getString((new StringBuilder(String.valueOf(prefix))).append(".").append(path).toString());
    }

    public int getInt(String path)
    {
        return cfg.getInt((new StringBuilder(String.valueOf(prefix))).append(".").append(path).toString());
    }

    public List getStringList(String path)
    {
        return cfg.getStringList((new StringBuilder(String.valueOf(prefix))).append(".").append(path).toString());
    }
}

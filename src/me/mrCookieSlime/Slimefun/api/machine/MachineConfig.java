// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   MachineConfig.java

package me.mrCookieSlime.Slimefun.api.machine;

import java.util.HashMap;
import java.util.Map;
import me.mrCookieSlime.CSCoreLibPlugin.Configuration.Config;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems.AContainer;

// Referenced classes of package me.mrCookieSlime.Slimefun.api.machine:
//            MachineSettings

public class MachineConfig extends Config
{

    MachineSettings global;
    Map children;

    public MachineConfig(String id)
    {
        super((new StringBuilder("plugins/Slimefun/machines/")).append(id).append(".yml").toString());
        global = new MachineSettings(this);
        children = new HashMap();
    }

    public MachineSettings getGlobalSettings()
    {
        return global;
    }

    public MachineSettings getSettings(AContainer item)
    {
        if(!children.containsKey(item.getName()))
            children.put(item.getName(), new MachineSettings(this, item));
        return (MachineSettings)children.get(item.getName());
    }
}

// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   MultiBlock.java

package me.mrCookieSlime.Slimefun.Objects;

import java.util.ArrayList;
import java.util.List;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunMachine;
import org.bukkit.Material;

public class MultiBlock
{

    public static List list = new ArrayList();
    Material blocks[];
    Material trigger;

    public MultiBlock(Material build[], Material trigger)
    {
        blocks = build;
        this.trigger = trigger;
    }

    public Material[] getBuild()
    {
        return blocks;
    }

    public Material getTriggerBlock()
    {
        return trigger;
    }

    public void register()
    {
        list.add(this);
    }

    public static List list()
    {
        return list;
    }

    public boolean isMultiBlock(SlimefunItem machine)
    {
        if(machine == null)
            return false;
        if(!(machine instanceof SlimefunMachine))
            return false;
        if(machine instanceof SlimefunMachine)
        {
            MultiBlock mb = ((SlimefunMachine)machine).toMultiBlock();
            if(trigger == mb.getTriggerBlock())
            {
                for(int i = 0; i < mb.getBuild().length; i++)
                    if(mb.getBuild()[i] != null)
                        if(mb.getBuild()[i] == Material.LOG)
                        {
                            if(!blocks[i].toString().contains("LOG"))
                                return false;
                        } else
                        if(mb.getBuild()[i] != blocks[i])
                            return false;

                return true;
            } else
            {
                return false;
            }
        } else
        {
            return false;
        }
    }

    public boolean isMultiBlock(MultiBlock mb)
    {
        if(mb == null)
            return false;
        if(trigger == mb.getTriggerBlock())
        {
            for(int i = 0; i < mb.getBuild().length; i++)
                if(mb.getBuild()[i] != null)
                    if(mb.getBuild()[i] == Material.LOG)
                    {
                        if(!blocks[i].toString().contains("LOG"))
                            return false;
                    } else
                    if(mb.getBuild()[i] != blocks[i])
                        return false;

            return true;
        } else
        {
            return false;
        }
    }

}

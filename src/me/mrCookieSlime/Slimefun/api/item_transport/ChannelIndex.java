// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   ChannelIndex.java

package me.mrCookieSlime.Slimefun.api.item_transport;


public class ChannelIndex
{

    public int channel;
    public int index;

    public ChannelIndex(int channel, int index)
    {
        this.channel = channel;
        this.index = index;
    }

    public void setIndex(int index)
    {
        this.index = index;
    }

    public int getChannel()
    {
        return channel;
    }

    public int getIndex()
    {
        return index;
    }
}

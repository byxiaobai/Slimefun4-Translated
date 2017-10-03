// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   NetworkStatus.java

package me.mrCookieSlime.Slimefun.GPS;


public final class NetworkStatus extends Enum
{

    public static final NetworkStatus ONLINE;
    public static final NetworkStatus OFFLINE;
    private static final NetworkStatus ENUM$VALUES[];

    private NetworkStatus(String s, int i)
    {
        super(s, i);
    }

    public static NetworkStatus[] values()
    {
        NetworkStatus anetworkstatus[];
        int i;
        NetworkStatus anetworkstatus1[];
        System.arraycopy(anetworkstatus = ENUM$VALUES, 0, anetworkstatus1 = new NetworkStatus[i = anetworkstatus.length], 0, i);
        return anetworkstatus1;
    }

    public static NetworkStatus valueOf(String s)
    {
        return (NetworkStatus)Enum.valueOf(me/mrCookieSlime/Slimefun/GPS/NetworkStatus, s);
    }

    static 
    {
        ONLINE = new NetworkStatus("ONLINE", 0);
        OFFLINE = new NetworkStatus("OFFLINE", 1);
        ENUM$VALUES = (new NetworkStatus[] {
            ONLINE, OFFLINE
        });
    }
}

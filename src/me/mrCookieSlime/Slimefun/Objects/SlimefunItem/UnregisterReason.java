// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   UnregisterReason.java

package me.mrCookieSlime.Slimefun.Objects.SlimefunItem;


public final class UnregisterReason extends Enum
{

    public static final UnregisterReason EXPLODE;
    public static final UnregisterReason PLAYER_BREAK;
    private static final UnregisterReason ENUM$VALUES[];

    private UnregisterReason(String s, int i)
    {
        super(s, i);
    }

    public static UnregisterReason[] values()
    {
        UnregisterReason aunregisterreason[];
        int i;
        UnregisterReason aunregisterreason1[];
        System.arraycopy(aunregisterreason = ENUM$VALUES, 0, aunregisterreason1 = new UnregisterReason[i = aunregisterreason.length], 0, i);
        return aunregisterreason1;
    }

    public static UnregisterReason valueOf(String s)
    {
        return (UnregisterReason)Enum.valueOf(me/mrCookieSlime/Slimefun/Objects/SlimefunItem/UnregisterReason, s);
    }

    static 
    {
        EXPLODE = new UnregisterReason("EXPLODE", 0);
        PLAYER_BREAK = new UnregisterReason("PLAYER_BREAK", 1);
        ENUM$VALUES = (new UnregisterReason[] {
            EXPLODE, PLAYER_BREAK
        });
    }
}

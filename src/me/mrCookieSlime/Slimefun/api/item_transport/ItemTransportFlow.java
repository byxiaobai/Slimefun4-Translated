// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   ItemTransportFlow.java

package me.mrCookieSlime.Slimefun.api.item_transport;


public final class ItemTransportFlow extends Enum
{

    public static final ItemTransportFlow INSERT;
    public static final ItemTransportFlow WITHDRAW;
    private static final ItemTransportFlow ENUM$VALUES[];

    private ItemTransportFlow(String s, int i)
    {
        super(s, i);
    }

    public static ItemTransportFlow[] values()
    {
        ItemTransportFlow aitemtransportflow[];
        int i;
        ItemTransportFlow aitemtransportflow1[];
        System.arraycopy(aitemtransportflow = ENUM$VALUES, 0, aitemtransportflow1 = new ItemTransportFlow[i = aitemtransportflow.length], 0, i);
        return aitemtransportflow1;
    }

    public static ItemTransportFlow valueOf(String s)
    {
        return (ItemTransportFlow)Enum.valueOf(me/mrCookieSlime/Slimefun/api/item_transport/ItemTransportFlow, s);
    }

    static 
    {
        INSERT = new ItemTransportFlow("INSERT", 0);
        WITHDRAW = new ItemTransportFlow("WITHDRAW", 1);
        ENUM$VALUES = (new ItemTransportFlow[] {
            INSERT, WITHDRAW
        });
    }
}

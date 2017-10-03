// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   AndroidType.java

package me.mrCookieSlime.Slimefun.Android;


public final class AndroidType extends Enum
{

    public static final AndroidType NONE;
    public static final AndroidType MINER;
    public static final AndroidType FARMER;
    public static final AndroidType ADVANCED_FARMER;
    public static final AndroidType WOODCUTTER;
    public static final AndroidType FIGHTER;
    public static final AndroidType FISHERMAN;
    public static final AndroidType NON_FIGHTER;
    private static final AndroidType ENUM$VALUES[];

    private AndroidType(String s, int i)
    {
        super(s, i);
    }

    public boolean isType(AndroidType type)
    {
        return type.equals(NONE) || type.equals(this) || type.equals(NON_FIGHTER) && !equals(FIGHTER);
    }

    public static AndroidType[] values()
    {
        AndroidType aandroidtype[];
        int i;
        AndroidType aandroidtype1[];
        System.arraycopy(aandroidtype = ENUM$VALUES, 0, aandroidtype1 = new AndroidType[i = aandroidtype.length], 0, i);
        return aandroidtype1;
    }

    public static AndroidType valueOf(String s)
    {
        return (AndroidType)Enum.valueOf(me/mrCookieSlime/Slimefun/Android/AndroidType, s);
    }

    static 
    {
        NONE = new AndroidType("NONE", 0);
        MINER = new AndroidType("MINER", 1);
        FARMER = new AndroidType("FARMER", 2);
        ADVANCED_FARMER = new AndroidType("ADVANCED_FARMER", 3);
        WOODCUTTER = new AndroidType("WOODCUTTER", 4);
        FIGHTER = new AndroidType("FIGHTER", 5);
        FISHERMAN = new AndroidType("FISHERMAN", 6);
        NON_FIGHTER = new AndroidType("NON_FIGHTER", 7);
        ENUM$VALUES = (new AndroidType[] {
            NONE, MINER, FARMER, ADVANCED_FARMER, WOODCUTTER, FIGHTER, FISHERMAN, NON_FIGHTER
        });
    }
}

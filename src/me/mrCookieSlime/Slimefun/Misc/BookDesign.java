// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   BookDesign.java

package me.mrCookieSlime.Slimefun.Misc;


public final class BookDesign extends Enum
{

    public static final BookDesign BOOK;
    public static final BookDesign CHEST;
    public static final BookDesign CHEAT_SHEET;
    private static final BookDesign ENUM$VALUES[];

    private BookDesign(String s, int i)
    {
        super(s, i);
    }

    public static BookDesign[] values()
    {
        BookDesign abookdesign[];
        int i;
        BookDesign abookdesign1[];
        System.arraycopy(abookdesign = ENUM$VALUES, 0, abookdesign1 = new BookDesign[i = abookdesign.length], 0, i);
        return abookdesign1;
    }

    public static BookDesign valueOf(String s)
    {
        return (BookDesign)Enum.valueOf(me/mrCookieSlime/Slimefun/Misc/BookDesign, s);
    }

    static 
    {
        BOOK = new BookDesign("BOOK", 0);
        CHEST = new BookDesign("CHEST", 1);
        CHEAT_SHEET = new BookDesign("CHEAT_SHEET", 2);
        ENUM$VALUES = (new BookDesign[] {
            BOOK, CHEST, CHEAT_SHEET
        });
    }
}

// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   IntegerFormat.java

package me.mrCookieSlime.Slimefun.GitHub;

import java.text.*;
import java.util.Date;
import java.util.Locale;

public class IntegerFormat
{

    private static SimpleDateFormat date_format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public IntegerFormat()
    {
    }

    public static String formatBigNumber(int i)
    {
        return NumberFormat.getNumberInstance(Locale.US).format(i);
    }

    public static Date parseGitHubDate(String str)
    {
        try
        {
            return date_format.parse(str.replace("T", " ").replace("Z", ""));
        }
        catch(ParseException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public static String timeDelta(Date date)
    {
        long timestamp = date.getTime();
        int hours = (int)((System.currentTimeMillis() - timestamp) / 0x36ee80L);
        if(hours == 0)
            return "> 1h";
        if(hours / 24 == 0)
            return (new StringBuilder(String.valueOf(hours % 24))).append("h").toString();
        if(hours % 24 == 0)
            return (new StringBuilder(String.valueOf(hours / 24))).append("d").toString();
        else
            return (new StringBuilder(String.valueOf(hours / 24))).append("d ").append(hours % 24).append("h").toString();
    }

}

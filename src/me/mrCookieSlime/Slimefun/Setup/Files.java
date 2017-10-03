// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   Files.java

package me.mrCookieSlime.Slimefun.Setup;

import java.io.File;
import java.io.PrintStream;

public class Files
{

    public static File RESEARCHES = new File("plugins/Slimefun/Researches.yml");
    public static File CONFIG = new File("plugins/Slimefun/config.yml");
    public static File ITEMS = new File("plugins/Slimefun/Items.yml");
    public static File DATABASE = new File("data-storage/Slimefun/Players");
    public static File WHITELIST = new File("plugins/Slimefun/whitelist.yml");

    public Files()
    {
    }

    public static void cleanup()
    {
        if(!RESEARCHES.exists())
        {
            System.err.println("################################################");
            System.err.println("################################################");
            System.err.println("############### = - \u9519\u8BEF - = ##################");
            System.err.println("################################################");
            System.err.println("################################################");
            System.err.println("      ");
            System.err.println("Slimefun \u8B66\u544A:");
            System.err.println("         ");
            System.err.println("Slimefun \u68C0\u6D4B\u5230\u4F60\u7684\u6587\u4EF6");
            System.err.println("\u5DF2\u8FC7\u671F\u6216\u4E0D\u5B58\u5728. \u6211\u4EEC\u521B\u5EFA\u4E86\u65B0\u7684\u6587\u4EF6");
            System.err.println("\u4EE5\u786E\u4FDD Slimefun \u53EF\u4EE5\u5DE5\u4F5C. \u5982\u679C\u60A8");
            System.err.println("\u66FE\u7ECF\u4F7F\u7528\u8FC7\u7C98\u6DB2\u79D1\u6280, \u4F60\u539F\u6765\u7684\u8BBE\u7F6E\u5C06\u4F1A\u4E22\u5931.");
            System.err.println("\u4F46 Slimefun \u5DE5\u4F5C\u4E86 :)");
            System.err.println("        ");
            System.err.println("################################################");
            System.err.println("################################################");
            System.err.println("############### = - \u9519\u8BEF - = ##################");
            System.err.println("################################################");
            System.err.println("################################################");
            delete(new File("plugins/Slimefun"));
            delete(new File("data-storage/Slimefun"));
        }
        if(!DATABASE.exists())
            DATABASE.mkdirs();
    }

    public static void delete(File folder)
    {
        File files[] = folder.listFiles();
        if(files != null)
        {
            File afile[];
            int j = (afile = files).length;
            for(int i = 0; i < j; i++)
            {
                File current = afile[i];
                if(current.isDirectory())
                    delete(current);
                else
                    current.delete();
            }

        }
        folder.delete();
    }

}

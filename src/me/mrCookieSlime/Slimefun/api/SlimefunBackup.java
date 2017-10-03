// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   SlimefunBackup.java

package me.mrCookieSlime.Slimefun.api;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import me.mrCookieSlime.CSCoreLibPlugin.general.Clock;

public class SlimefunBackup
{

    public SlimefunBackup()
    {
    }

    public static void start()
    {
        File folder = new File("data-storage/Slimefun/block-backups");
        List backups = Arrays.asList(folder.listFiles());
        if(backups.size() > 20)
        {
            Collections.sort(backups, new Comparator() {

                public int compare(File f1, File f2)
                {
                    try
                    {
                        return (int)((new SimpleDateFormat("yyyy-MM-dd-HH-mm")).parse(f1.getName().replace(".zip", "")).getTime() - (new SimpleDateFormat("yyyy-MM-dd-HH-mm")).parse(f2.getName().replace(".zip", "")).getTime());
                    }
                    catch(ParseException e)
                    {
                        return 0;
                    }
                }

                public volatile int compare(Object obj, Object obj1)
                {
                    return compare((File)obj, (File)obj1);
                }

            }
);
            for(int i = backups.size() - 20; i > 0; i--)
                ((File)backups.get(i)).delete();

        }
        File file = new File((new StringBuilder("data-storage/Slimefun/block-backups/")).append(Clock.format(new Date())).append(".zip").toString());
        byte buffer[] = new byte[1024];
        if(file.exists())
            file.delete();
        try
        {
            file.createNewFile();
            ZipOutputStream output = new ZipOutputStream(new FileOutputStream(file));
            File afile[];
            int i1 = (afile = (new File("data-storage/Slimefun/stored-blocks/")).listFiles()).length;
            for(int j = 0; j < i1; j++)
            {
                File f1 = afile[j];
                File afile1[];
                int k1 = (afile1 = f1.listFiles()).length;
                for(int j1 = 0; j1 < k1; j1++)
                {
                    File f = afile1[j1];
                    ZipEntry entry = new ZipEntry((new StringBuilder("stored-blocks/")).append(f1.getName()).append("/").append(f.getName()).toString());
                    output.putNextEntry(entry);
                    FileInputStream input = new FileInputStream(f);
                    int length;
                    while((length = input.read(buffer)) > 0) 
                        output.write(buffer, 0, length);
                    input.close();
                    output.closeEntry();
                }

            }

            i1 = (afile = (new File("data-storage/Slimefun/universal-inventories/")).listFiles()).length;
            for(int k = 0; k < i1; k++)
            {
                File f = afile[k];
                ZipEntry entry = new ZipEntry((new StringBuilder("universal-inventories/")).append(f.getName()).toString());
                output.putNextEntry(entry);
                FileInputStream input = new FileInputStream(f);
                int length;
                while((length = input.read(buffer)) > 0) 
                    output.write(buffer, 0, length);
                input.close();
                output.closeEntry();
            }

            i1 = (afile = (new File("data-storage/Slimefun/stored-inventories/")).listFiles()).length;
            for(int l = 0; l < i1; l++)
            {
                File f = afile[l];
                ZipEntry entry = new ZipEntry((new StringBuilder("stored-inventories/")).append(f.getName()).toString());
                output.putNextEntry(entry);
                FileInputStream input = new FileInputStream(f);
                int length;
                while((length = input.read(buffer)) > 0) 
                    output.write(buffer, 0, length);
                input.close();
                output.closeEntry();
            }

            if((new File("data-storage/Slimefun/stored-chunks/chunks.sfc")).exists())
            {
                ZipEntry entry = new ZipEntry("stored-chunks/chunks.sfc");
                output.putNextEntry(entry);
                FileInputStream input = new FileInputStream(new File("data-storage/Slimefun/stored-chunks/chunks.sfc"));
                int length;
                while((length = input.read(buffer)) > 0) 
                    output.write(buffer, 0, length);
                input.close();
                output.closeEntry();
            }
            output.close();
            System.out.println((new StringBuilder("[Slimfun] Backed up Blocks to ")).append(file.getName()).toString());
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}

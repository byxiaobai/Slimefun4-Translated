package me.mrCookieSlime.Slimefun.URID;

import java.io.PrintStream;
import java.util.*;
import me.mrCookieSlime.CSCoreLibPlugin.Configuration.Config;
import me.mrCookieSlime.Slimefun.SlimefunStartup;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import org.bukkit.Bukkit;
import org.bukkit.World;

public class AutoSavingTask
    implements Runnable
{

    public AutoSavingTask()
    {
    }

    public void run()
    {
        Set worlds = new HashSet();
        for(Iterator iterator = Bukkit.getWorlds().iterator(); iterator.hasNext();)
        {
            World world = (World)iterator.next();
            if(BlockStorage.isWorldRegistered(world.getName()))
            {
                BlockStorage storage = BlockStorage.getStorage(world);
                storage.computeChanges();
                if(storage.getChanges() > 0)
                    worlds.add(storage);
            }
        }

        if(!worlds.isEmpty())
        {
            System.out.println((new StringBuilder("[Slimefun] 少女祈祷中... (下一次祈祷在 ")).append(SlimefunStartup.getCfg().getInt("options.auto-save-delay-in-minutes")).append(" 分钟后)").toString());
            BlockStorage storage;
            for(Iterator iterator1 = worlds.iterator(); iterator1.hasNext(); storage.save(false))
                storage = (BlockStorage)iterator1.next();

        }
    }
}

package me.mrCookieSlime.Slimefun.Commands;

import java.util.*;
import me.mrCookieSlime.Slimefun.Objects.Research;
import me.mrCookieSlime.Slimefun.api.Slimefun;
import org.bukkit.command.*;

// Referenced classes of package me.mrCookieSlime.Slimefun.Commands:
//            SlimefunCommand

public class SlimefunTabCompleter
    implements TabCompleter
{

    public SlimefunTabCompleter()
    {
    }

    public List onTabComplete(CommandSender sender, Command cmd, String label, String args[])
    {
        if(args.length == 1)
            return SlimefunCommand.tabs;
        if(args.length == 3)
        {
            if(args[0].equalsIgnoreCase("give"))
                return Slimefun.listIDs();
            if(args[0].equalsIgnoreCase("research"))
            {
                List researches = new ArrayList();
                Research res;
                for(Iterator iterator = Research.list().iterator(); iterator.hasNext(); researches.add(res.getName().toUpperCase().replace(" ", "_")))
                    res = (Research)iterator.next();

                researches.add("all");
                return researches;
            } else
            {
                return null;
            }
        } else
        {
            return null;
        }
    }
}

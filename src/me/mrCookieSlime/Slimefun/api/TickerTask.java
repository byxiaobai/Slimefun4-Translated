// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   TickerTask.java

package me.mrCookieSlime.Slimefun.api;

import java.io.*;
import java.util.*;
import me.mrCookieSlime.CSCoreLibPlugin.general.Chat.TellRawMessage;
import me.mrCookieSlime.CSCoreLibPlugin.general.Clock;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.handlers.BlockTicker;
import me.mrCookieSlime.Slimefun.SlimefunStartup;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.*;
import org.bukkit.scheduler.BukkitScheduler;

// Referenced classes of package me.mrCookieSlime.Slimefun.api:
//            BlockStorage

public class TickerTask
    implements Runnable
{

    public boolean HALTED;
    public Map move;
    public Map delete;
    private Set tickers;
    private int skipped;
    private int chunks;
    private int machines;
    private long time;
    private Map map_chunk;
    private Map map_machine;
    private Map map_machinetime;
    private Map map_chunktime;
    private Set skipped_chunks;
    public static Map block_timings = new HashMap();
    public static Map bugged_blocks = new HashMap();

    public TickerTask()
    {
        HALTED = false;
        move = new HashMap();
        delete = new HashMap();
        tickers = new HashSet();
        skipped = 0;
        chunks = 0;
        machines = 0;
        time = 0L;
        map_chunk = new HashMap();
        map_machine = new HashMap();
        map_machinetime = new HashMap();
        map_chunktime = new HashMap();
        skipped_chunks = new HashSet();
    }

    public void run()
    {
        long timestamp = System.currentTimeMillis();
        skipped = 0;
        chunks = 0;
        machines = 0;
        map_chunk.clear();
        map_machine.clear();
        time = 0L;
        map_chunktime.clear();
        skipped_chunks.clear();
        map_machinetime.clear();
        block_timings.clear();
        final Map bugged = new HashMap(bugged_blocks);
        bugged_blocks.clear();
        Map remove = new HashMap(delete);
        java.util.Map.Entry entry;
        for(Iterator iterator = remove.entrySet().iterator(); iterator.hasNext(); delete.remove(entry.getKey()))
        {
            entry = (java.util.Map.Entry)iterator.next();
            BlockStorage._integrated_removeBlockInfo((Location)entry.getKey(), ((Boolean)entry.getValue()).booleanValue());
        }

        if(!HALTED)
        {
            final String c;
            long timestamp2;
            for(Iterator iterator1 = BlockStorage.getTickingChunks().iterator(); iterator1.hasNext(); map_chunktime.put(c, Long.valueOf(System.currentTimeMillis() - timestamp2)))
            {
                c = (String)iterator1.next();
                timestamp2 = System.currentTimeMillis();
                chunks++;
                Iterator iterator4 = BlockStorage.getTickingBlocks(c).iterator();
                while(iterator4.hasNext()) 
                {
                    final Block b = (Block)iterator4.next();
                    if(b.getChunk().isLoaded())
                    {
                        final Location l = b.getLocation();
                        final SlimefunItem item = BlockStorage.check(l);
                        if(item != null)
                        {
                            machines++;
                            try
                            {
                                item.getTicker().update();
                                if(item.getTicker().isSynchronized())
                                {
                                    Bukkit.getScheduler().scheduleSyncDelayedTask(SlimefunStartup.instance, new Runnable() {

                                        final TickerTask this$0;
                                        private final SlimefunItem val$item;
                                        private final Block val$b;
                                        private final Location val$l;
                                        private final String val$c;
                                        private final Map val$bugged;

                                        public void run()
                                        {
                                            try
                                            {
                                                long timestamp3 = System.currentTimeMillis();
                                                item.getTicker().tick(b, item, BlockStorage.getBlockInfo(l));
                                                map_machinetime.put(item.getName(), Long.valueOf((map_machinetime.containsKey(item.getName()) ? ((Long)map_machinetime.get(item.getName())).longValue() : 0L) + (System.currentTimeMillis() - timestamp3)));
                                                map_chunk.put(c, Integer.valueOf((map_chunk.containsKey(c) ? ((Integer)map_chunk.get(c)).intValue() : 0) + 1));
                                                map_machine.put(item.getName(), Integer.valueOf((map_machine.containsKey(item.getName()) ? ((Integer)map_machine.get(item.getName())).intValue() : 0) + 1));
                                                TickerTask.block_timings.put(l, Long.valueOf(System.currentTimeMillis() - timestamp3));
                                            }
                                            catch(Exception x)
                                            {
                                                int errors = 0;
                                                if(bugged.containsKey(l))
                                                    errors = ((Integer)bugged.get(l)).intValue();
                                                if(++errors == 1)
                                                {
                                                    File file = new File((new StringBuilder("plugins/Slimefun/error-reports/")).append(Clock.getFormattedTime()).append(".err").toString());
                                                    if(file.exists())
                                                    {
                                                        file = new File((new StringBuilder("plugins/Slimefun/error-reports/")).append(Clock.getFormattedTime()).append("(2).err").toString());
                                                        if(file.exists())
                                                        {
                                                            file = new File((new StringBuilder("plugins/Slimefun/error-reports/")).append(Clock.getFormattedTime()).append("(3).err").toString());
                                                            if(file.exists())
                                                            {
                                                                file = new File((new StringBuilder("plugins/Slimefun/error-reports/")).append(Clock.getFormattedTime()).append("(4).err").toString());
                                                                if(file.exists())
                                                                {
                                                                    file = new File((new StringBuilder("plugins/Slimefun/error-reports/")).append(Clock.getFormattedTime()).append("(5).err").toString());
                                                                    if(file.exists())
                                                                    {
                                                                        file = new File((new StringBuilder("plugins/Slimefun/error-reports/")).append(Clock.getFormattedTime()).append("(6).err").toString());
                                                                        if(file.exists())
                                                                        {
                                                                            file = new File((new StringBuilder("plugins/Slimefun/error-reports/")).append(Clock.getFormattedTime()).append("(7).err").toString());
                                                                            if(file.exists())
                                                                            {
                                                                                file = new File((new StringBuilder("plugins/Slimefun/error-reports/")).append(Clock.getFormattedTime()).append("(8).err").toString());
                                                                                if(file.exists())
                                                                                {
                                                                                    file = new File((new StringBuilder("plugins/Slimefun/error-reports/")).append(Clock.getFormattedTime()).append("(9).err").toString());
                                                                                    if(file.exists())
                                                                                        file = new File((new StringBuilder("plugins/Slimefun/error-reports/")).append(Clock.getFormattedTime()).append("(10).err").toString());
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                    try
                                                    {
                                                        PrintStream stream = new PrintStream(file);
                                                        stream.println();
                                                        stream.println((new StringBuilder("Server Software: ")).append(Bukkit.getName()).toString());
                                                        stream.println((new StringBuilder("  Build: ")).append(Bukkit.getVersion()).toString());
                                                        stream.println((new StringBuilder("  Minecraft: ")).append(Bukkit.getBukkitVersion()).toString());
                                                        stream.println();
                                                        stream.println((new StringBuilder("Installed Plugins (")).append(Bukkit.getPluginManager().getPlugins().length).append(")").toString());
                                                        Plugin aplugin1[];
                                                        int i1 = (aplugin1 = Bukkit.getPluginManager().getPlugins()).length;
                                                        for(int k = 0; k < i1; k++)
                                                        {
                                                            Plugin p = aplugin1[k];
                                                            if(Bukkit.getPluginManager().isPluginEnabled(p))
                                                                stream.println((new StringBuilder("  + ")).append(p.getName()).append(" ").append(p.getDescription().getVersion()).toString());
                                                            else
                                                                stream.println((new StringBuilder("  - ")).append(p.getName()).append(" ").append(p.getDescription().getVersion()).toString());
                                                        }

                                                        stream.println();
                                                        stream.println("Ticked Block:");
                                                        stream.println((new StringBuilder("  World: ")).append(l.getWorld().getName()).toString());
                                                        stream.println((new StringBuilder("  X: ")).append(l.getBlockX()).toString());
                                                        stream.println((new StringBuilder("  Y: ")).append(l.getBlockY()).toString());
                                                        stream.println((new StringBuilder("  Z: ")).append(l.getBlockZ()).toString());
                                                        stream.println();
                                                        stream.println("Slimefun Data:");
                                                        stream.println((new StringBuilder("  ID: ")).append(item.getName()).toString());
                                                        stream.println((new StringBuilder("  Inventory: ")).append(BlockStorage.getStorage(l.getWorld()).hasInventory(l)).toString());
                                                        stream.println((new StringBuilder("  Data: ")).append(BlockStorage.getBlockInfoAsJson(l)).toString());
                                                        stream.println();
                                                        stream.println("Stacktrace:");
                                                        stream.println();
                                                        x.printStackTrace(stream);
                                                        stream.close();
                                                    }
                                                    catch(FileNotFoundException e)
                                                    {
                                                        e.printStackTrace();
                                                    }
                                                    System.err.println((new StringBuilder("[Slimefun] Exception caught while ticking a Block:")).append(x.getClass().getName()).toString());
                                                    System.err.println((new StringBuilder("[Slimefun] X: ")).append(l.getBlockX()).append(" Y: ").append(l.getBlockY()).append(" Z: ").append(l.getBlockZ()).toString());
                                                    System.err.println("[Slimefun] Saved as: ");
                                                    System.err.println((new StringBuilder("[Slimefun] /plugins/Slimefun/error-reports/")).append(file.getName()).toString());
                                                    System.err.println("[Slimefun] Please consider sending this File to the developer(s) of Slimefun, sending this Error won't get you any help though.");
                                                    System.err.println("[Slimefun] ");
                                                    TickerTask.bugged_blocks.put(l, Integer.valueOf(errors));
                                                } else
                                                if(errors == 4)
                                                {
                                                    System.err.println((new StringBuilder("[Slimefun] X: ")).append(l.getBlockX()).append(" Y: ").append(l.getBlockY()).append(" Z: ").append(l.getBlockZ()).append("(").append(item.getName()).append(")").toString());
                                                    System.err.println("[Slimefun] has thrown 4 Exceptions in the last 4 Ticks, the Block has been terminated.");
                                                    System.err.println("[Slimefun] Check your /plugins/Slimefun/error-reports/ folder for details.");
                                                    System.err.println("[Slimefun] ");
                                                    BlockStorage._integrated_removeBlockInfo(l, true);
                                                    Bukkit.getScheduler().scheduleSyncDelayedTask(SlimefunStartup.instance, new Runnable() {

                                                        final _cls1 this$1;
                                                        private final Location val$l;

                                                        public void run()
                                                        {
                                                            l.getBlock().setType(Material.AIR);
                                                        }

                    
                    {
                        this$1 = _cls1.this;
                        l = location;
                        super();
                    }
                                                    }
);
                                                } else
                                                {
                                                    TickerTask.bugged_blocks.put(l, Integer.valueOf(errors));
                                                }
                                            }
                                        }

            
            {
                this$0 = TickerTask.this;
                item = slimefunitem;
                b = block;
                l = location;
                c = s;
                bugged = map;
                super();
            }
                                    }
);
                                } else
                                {
                                    long timestamp3 = System.currentTimeMillis();
                                    item.getTicker().tick(b, item, BlockStorage.getBlockInfo(l));
                                    map_machinetime.put(item.getName(), Long.valueOf((map_machinetime.containsKey(item.getName()) ? ((Long)map_machinetime.get(item.getName())).longValue() : 0L) + (System.currentTimeMillis() - timestamp3)));
                                    map_chunk.put(c, Integer.valueOf((map_chunk.containsKey(c) ? ((Integer)map_chunk.get(c)).intValue() : 0) + 1));
                                    map_machine.put(item.getName(), Integer.valueOf((map_machine.containsKey(item.getName()) ? ((Integer)map_machine.get(item.getName())).intValue() : 0) + 1));
                                    block_timings.put(l, Long.valueOf(System.currentTimeMillis() - timestamp3));
                                }
                                tickers.add(item.getTicker());
                            }
                            catch(Exception x)
                            {
                                int errors = 0;
                                if(bugged.containsKey(l))
                                    errors = ((Integer)bugged.get(l)).intValue();
                                if(++errors == 1)
                                {
                                    File file = new File((new StringBuilder("plugins/Slimefun/error-reports/")).append(Clock.getFormattedTime()).append(".err").toString());
                                    if(file.exists())
                                    {
                                        file = new File((new StringBuilder("plugins/Slimefun/error-reports/")).append(Clock.getFormattedTime()).append("(2).err").toString());
                                        if(file.exists())
                                        {
                                            file = new File((new StringBuilder("plugins/Slimefun/error-reports/")).append(Clock.getFormattedTime()).append("(3).err").toString());
                                            if(file.exists())
                                            {
                                                file = new File((new StringBuilder("plugins/Slimefun/error-reports/")).append(Clock.getFormattedTime()).append("(4).err").toString());
                                                if(file.exists())
                                                {
                                                    file = new File((new StringBuilder("plugins/Slimefun/error-reports/")).append(Clock.getFormattedTime()).append("(5).err").toString());
                                                    if(file.exists())
                                                    {
                                                        file = new File((new StringBuilder("plugins/Slimefun/error-reports/")).append(Clock.getFormattedTime()).append("(6).err").toString());
                                                        if(file.exists())
                                                        {
                                                            file = new File((new StringBuilder("plugins/Slimefun/error-reports/")).append(Clock.getFormattedTime()).append("(7).err").toString());
                                                            if(file.exists())
                                                            {
                                                                file = new File((new StringBuilder("plugins/Slimefun/error-reports/")).append(Clock.getFormattedTime()).append("(8).err").toString());
                                                                if(file.exists())
                                                                {
                                                                    file = new File((new StringBuilder("plugins/Slimefun/error-reports/")).append(Clock.getFormattedTime()).append("(9).err").toString());
                                                                    if(file.exists())
                                                                        file = new File((new StringBuilder("plugins/Slimefun/error-reports/")).append(Clock.getFormattedTime()).append("(10).err").toString());
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    try
                                    {
                                        PrintStream stream = new PrintStream(file);
                                        stream.println();
                                        stream.println((new StringBuilder("Server Software: ")).append(Bukkit.getName()).toString());
                                        stream.println((new StringBuilder("  Build: ")).append(Bukkit.getVersion()).toString());
                                        stream.println((new StringBuilder("  Minecraft: ")).append(Bukkit.getBukkitVersion()).toString());
                                        stream.println();
                                        stream.println((new StringBuilder("Installed Plugins (")).append(Bukkit.getPluginManager().getPlugins().length).append(")").toString());
                                        Plugin aplugin[];
                                        int j = (aplugin = Bukkit.getPluginManager().getPlugins()).length;
                                        for(int i = 0; i < j; i++)
                                        {
                                            Plugin p = aplugin[i];
                                            if(Bukkit.getPluginManager().isPluginEnabled(p))
                                                stream.println((new StringBuilder("  + ")).append(p.getName()).append(" ").append(p.getDescription().getVersion()).toString());
                                            else
                                                stream.println((new StringBuilder("  - ")).append(p.getName()).append(" ").append(p.getDescription().getVersion()).toString());
                                        }

                                        stream.println();
                                        stream.println("Ticked Block:");
                                        stream.println((new StringBuilder("  World: ")).append(l.getWorld().getName()).toString());
                                        stream.println((new StringBuilder("  X: ")).append(l.getBlockX()).toString());
                                        stream.println((new StringBuilder("  Y: ")).append(l.getBlockY()).toString());
                                        stream.println((new StringBuilder("  Z: ")).append(l.getBlockZ()).toString());
                                        stream.println();
                                        stream.println("Slimefun Data:");
                                        stream.println((new StringBuilder("  ID: ")).append(item.getName()).toString());
                                        stream.println((new StringBuilder("  Inventory: ")).append(BlockStorage.getStorage(l.getWorld()).hasInventory(l)).toString());
                                        stream.println((new StringBuilder("  Data: ")).append(BlockStorage.getBlockInfoAsJson(l)).toString());
                                        stream.println();
                                        stream.println("Stacktrace:");
                                        stream.println();
                                        x.printStackTrace(stream);
                                        stream.close();
                                    }
                                    catch(FileNotFoundException e)
                                    {
                                        e.printStackTrace();
                                    }
                                    System.err.println((new StringBuilder("[Slimefun] Exception caught while ticking a Block:")).append(x.getClass().getName()).toString());
                                    System.err.println((new StringBuilder("[Slimefun] X: ")).append(l.getBlockX()).append(" Y: ").append(l.getBlockY()).append(" Z: ").append(l.getBlockZ()).toString());
                                    System.err.println("[Slimefun] Saved as: ");
                                    System.err.println((new StringBuilder("[Slimefun] /plugins/Slimefun/error-reports/")).append(file.getName()).toString());
                                    System.err.println("[Slimefun] Please consider sending this File to the developer(s) of Slimefun, sending this Error won't get you any help though.");
                                    System.err.println("[Slimefun] ");
                                    bugged_blocks.put(l, Integer.valueOf(errors));
                                } else
                                if(errors == 4)
                                {
                                    System.err.println((new StringBuilder("[Slimefun] X: ")).append(l.getBlockX()).append(" Y: ").append(l.getBlockY()).append(" Z: ").append(l.getBlockZ()).append("(").append(item.getName()).append(")").toString());
                                    System.err.println("[Slimefun] has thrown 4 Exceptions in the last 4 Ticks, the Block has been terminated.");
                                    System.err.println("[Slimefun] Check your /plugins/Slimefun/error-reports/ folder for details.");
                                    System.err.println("[Slimefun] ");
                                    BlockStorage._integrated_removeBlockInfo(l, true);
                                    Bukkit.getScheduler().scheduleSyncDelayedTask(SlimefunStartup.instance, new Runnable() {

                                        final TickerTask this$0;
                                        private final Location val$l;

                                        public void run()
                                        {
                                            l.getBlock().setType(Material.AIR);
                                        }

            
            {
                this$0 = TickerTask.this;
                l = location;
                super();
            }
                                    }
);
                                } else
                                {
                                    bugged_blocks.put(l, Integer.valueOf(errors));
                                }
                            }
                        } else
                        {
                            skipped++;
                        }
                        continue;
                    }
                    skipped += BlockStorage.getTickingBlocks(c).size();
                    skipped_chunks.add(c);
                    chunks--;
                    break;
                }
            }

        }
        java.util.Map.Entry entry;
        for(Iterator iterator2 = move.entrySet().iterator(); iterator2.hasNext(); BlockStorage._integrated_moveBlockInfo((Block)entry.getKey(), (Block)entry.getValue()))
            entry = (java.util.Map.Entry)iterator2.next();

        move.clear();
        for(Iterator iterator3 = tickers.iterator(); iterator3.hasNext();)
        {
            BlockTicker ticker = (BlockTicker)iterator3.next();
            ticker.unique = true;
        }

        tickers.clear();
        time = System.currentTimeMillis() - timestamp;
    }

    public void info(CommandSender sender)
    {
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&2== &aSlimefun Diagnostic Tool &2=="));
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', (new StringBuilder("&6Halted: &e&l")).append(String.valueOf(HALTED).toUpperCase()).toString()));
        sender.sendMessage("");
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', (new StringBuilder("&6Impact: &e")).append(time).append("ms / 50-750ms").toString()));
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', (new StringBuilder("&6Ticked Chunks: &e")).append(chunks).toString()));
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', (new StringBuilder("&6Ticked Machines: &e")).append(machines).toString()));
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', (new StringBuilder("&6Skipped Machines: &e")).append(skipped).toString()));
        sender.sendMessage("");
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6Ticking Machines:"));
        if(sender instanceof Player)
        {
            TellRawMessage tellraw = new TellRawMessage();
            tellraw.addText("   &7&oHover for more Info");
            StringBuilder hover = new StringBuilder();
            int hidden = 0;
            for(Iterator iterator2 = map_machine.keySet().iterator(); iterator2.hasNext();)
            {
                String item = (String)iterator2.next();
                if(((Long)map_machinetime.get(item)).longValue() > 0L)
                    hover.append((new StringBuilder("\n&c")).append(item).append(" - ").append(map_machine.get(item)).append("x &7(").append(map_machinetime.get(item)).append("ms)").toString());
                else
                    hidden++;
            }

            hover.append((new StringBuilder("\n\n&c+ &4")).append(hidden).append(" Hidden").toString());
            tellraw.addHoverEvent(me.mrCookieSlime.CSCoreLibPlugin.general.Chat.TellRawMessage.HoverAction.SHOW_TEXT, hover.toString());
            try
            {
                tellraw.send(new Player[] {
                    (Player)sender
                });
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        } else
        {
            int hidden = 0;
            for(Iterator iterator = map_machine.keySet().iterator(); iterator.hasNext();)
            {
                String item = (String)iterator.next();
                if(((Long)map_machinetime.get(item)).longValue() > 0L)
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', (new StringBuilder("  &e")).append(item).append(" - ").append(map_machine.get(item)).append("x &7(").append(map_machinetime.get(item)).append("ms)").toString()));
                else
                    hidden++;
            }

            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', (new StringBuilder("&c+ &4")).append(hidden).append(" Hidden").toString()));
        }
        sender.sendMessage("");
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6Ticking Chunks:"));
        if(sender instanceof Player)
        {
            TellRawMessage tellraw = new TellRawMessage();
            tellraw.addText("   &7&oHover for more Info");
            StringBuilder hover = new StringBuilder();
            int hidden = 0;
            for(Iterator iterator3 = map_chunktime.keySet().iterator(); iterator3.hasNext();)
            {
                String c = (String)iterator3.next();
                if(!skipped_chunks.contains(c))
                    if(((Long)map_chunktime.get(c)).longValue() > 0L)
                        hover.append((new StringBuilder("\n&c")).append(c.replace("CraftChunk", "")).append(" - ").append(map_chunk.containsKey(c) ? ((Integer)map_chunk.get(c)).intValue() : 0).append("x &7(").append(map_chunktime.get(c)).append("ms)").toString());
                    else
                        hidden++;
            }

            hover.append((new StringBuilder("\n\n&c+ &4")).append(hidden).append(" Hidden").toString());
            tellraw.addHoverEvent(me.mrCookieSlime.CSCoreLibPlugin.general.Chat.TellRawMessage.HoverAction.SHOW_TEXT, hover.toString());
            try
            {
                tellraw.send(new Player[] {
                    (Player)sender
                });
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        } else
        {
            int hidden = 0;
            for(Iterator iterator1 = map_chunktime.keySet().iterator(); iterator1.hasNext();)
            {
                String c = (String)iterator1.next();
                if(!skipped_chunks.contains(c))
                    if(((Long)map_chunktime.get(c)).longValue() > 0L)
                        sender.sendMessage((new StringBuilder("  &c")).append(c.replace("CraftChunk", "")).append(" - ").append(map_chunk.containsKey(c) ? ((Integer)map_chunk.get(c)).intValue() : 0).append("x &7(").append(map_chunktime.get(c)).append("ms)").toString());
                    else
                        hidden++;
            }

            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', (new StringBuilder("&c+ &4")).append(hidden).append(" Hidden").toString()));
        }
    }

    public long getTimings(Block b)
    {
        return block_timings.containsKey(b.getLocation()) ? ((Long)block_timings.get(b.getLocation())).longValue() : 0L;
    }

    public long getTimings(String item)
    {
        return map_machinetime.containsKey(item) ? ((Long)map_machinetime.get(item)).longValue() : 0L;
    }

    public long getTimings(Chunk c)
    {
        return map_chunktime.containsKey(c.toString()) ? ((Long)map_chunktime.get(c.toString())).longValue() : 0L;
    }




}

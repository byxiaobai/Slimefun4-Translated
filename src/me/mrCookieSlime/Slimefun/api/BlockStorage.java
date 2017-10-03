// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   BlockStorage.java

package me.mrCookieSlime.Slimefun.api;

import java.io.File;
import java.io.PrintStream;
import java.util.*;
import me.mrCookieSlime.CSCoreLibPlugin.Configuration.Config;
import me.mrCookieSlime.CSCoreLibPlugin.general.Math.DoubleHandler;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.SlimefunStartup;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenuPreset;
import me.mrCookieSlime.Slimefun.api.inventory.UniversalBlockMenu;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.HumanEntity;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

// Referenced classes of package me.mrCookieSlime.Slimefun.api:
//            TickerTask

public class BlockStorage
{

    private static final String path_blocks = "data-storage/Slimefun/stored-blocks/";
    private static final String path_chunks = "data-storage/Slimefun/stored-chunks/";
    public static Map worlds = new HashMap();
    public static Map ticking_chunks = new HashMap();
    public static Set loaded_tickers = new HashSet();
    private World world;
    private Map storage;
    private static Map map_chunks = new HashMap();
    private Map inventories;
    public static Map universal_inventories = new HashMap();
    private Map cache_blocks;
    public static int info_delay;
    private static int chunk_changes = 0;
    private int changes;

    public static BlockStorage getStorage(World world)
    {
        return (BlockStorage)worlds.get(world.getName());
    }

    public static BlockStorage getForcedStorage(World world)
    {
        return isWorldRegistered(world.getName()) ? (BlockStorage)worlds.get(world.getName()) : new BlockStorage(world);
    }

    private static String serializeLocation(Location l)
    {
        return (new StringBuilder(String.valueOf(l.getWorld().getName()))).append(";").append(l.getBlockX()).append(";").append(l.getBlockY()).append(";").append(l.getBlockZ()).toString();
    }

    private static String serializeChunk(Chunk chunk)
    {
        return (new StringBuilder(String.valueOf(chunk.getWorld().getName()))).append(";Chunk;").append(chunk.getX()).append(";").append(chunk.getZ()).toString();
    }

    private static Location deserializeLocation(String l)
    {
        try
        {
            World w = Bukkit.getWorld(l.split(";")[0]);
            if(w != null)
                return new Location(w, Integer.parseInt(l.split(";")[1]), Integer.parseInt(l.split(";")[2]), Integer.parseInt(l.split(";")[3]));
        }
        catch(NumberFormatException numberformatexception) { }
        return null;
    }

    public BlockStorage(World w)
    {
        File f;
        long total;
        long start;
        long done;
        long timestamp;
        long totalBlocks;
        storage = new HashMap();
        inventories = new HashMap();
        cache_blocks = new HashMap();
        changes = 0;
        if(worlds.containsKey(w.getName()))
            return;
        world = w;
        System.out.println((new StringBuilder("[Slimefun] \u52A0\u8F7D\u4E16\u754C \"")).append(w.getName()).append("\" \u4E2D\u7684\u65B9\u5757").toString());
        System.out.println("[Slimefun] \u8FD9\u53EF\u80FD\u9700\u8981\u4E00\u9996\u6B4C\u7684\u65F6\u95F4....");
        f = new File((new StringBuilder("data-storage/Slimefun/stored-blocks/")).append(w.getName()).toString());
        if(!f.exists())
            break MISSING_BLOCK_LABEL_850;
        total = f.listFiles().length;
        start = System.currentTimeMillis();
        done = 0L;
        timestamp = System.currentTimeMillis();
        totalBlocks = 0L;
        File afile1[];
        int j1 = (afile1 = f.listFiles()).length;
        for(int i1 = 0; i1 < j1; i1++)
        {
            File file = afile1[i1];
            if(file.getName().endsWith(".sfb"))
            {
                if(timestamp + (long)info_delay < System.currentTimeMillis())
                {
                    System.out.println((new StringBuilder("[Slimefun] \u6B63\u5728\u8BFB\u53D6\u65B9\u5757...")).append(Math.round(((((float)done * 100F) / (float)total) * 100F) / 100F)).append("% \u5DF2\u5B8C\u6210 (\"").append(w.getName()).append("\")").toString());
                    timestamp = System.currentTimeMillis();
                }
                FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
                for(Iterator iterator1 = cfg.getKeys(false).iterator(); iterator1.hasNext();)
                {
                    String key = (String)iterator1.next();
                    try
                    {
                        totalBlocks++;
                        storage.put(deserializeLocation(key), cfg.getString(key));
                        if(SlimefunItem.isTicking(file.getName().replace(".sfb", "")))
                        {
                            Set blocks = ((Set) (ticking_chunks.containsKey(deserializeLocation(key).getChunk().toString()) ? (Set)ticking_chunks.get(deserializeLocation(key).getChunk().toString()) : ((Set) (new HashSet()))));
                            blocks.add(deserializeLocation(key).getBlock());
                            ticking_chunks.put(deserializeLocation(key).getChunk().toString(), blocks);
                            if(!loaded_tickers.contains(deserializeLocation(key).getChunk().toString()))
                                loaded_tickers.add(deserializeLocation(key).getChunk().toString());
                        }
                    }
                    catch(Exception x)
                    {
                        System.err.println((new StringBuilder("[Slimefun] \u52A0\u8F7D\u5931\u8D25\u5728")).append(file.getName()).append("(ERR: ").append(key).append(")").toString());
                        x.printStackTrace();
                    }
                }

                done++;
            }
        }

        break MISSING_BLOCK_LABEL_715;
        Exception exception1;
        exception1;
        long time = System.currentTimeMillis() - start;
        System.out.println((new StringBuilder("[Slimefun] \u6B63\u5728\u8BFB\u53D6\u65B9\u5757... 100% (\u5B8C\u6210 - ")).append(time).append("ms)").toString());
        System.out.println((new StringBuilder("[Slimefun] \u52A0\u8F7D\u5168\u90E8")).append(totalBlocks).append(" \u4E2A\u65B9\u5757\u5728\u4E16\u754C \"").append(world.getName()).append("\"").toString());
        if(totalBlocks > 0L)
            System.out.println((new StringBuilder("[Slimefun] \u5E73\u5747: ")).append(DoubleHandler.fixDouble((double)time / (double)totalBlocks, 3)).append("ms/\u4E2A\u65B9\u5757").toString());
        throw exception1;
        long time = System.currentTimeMillis() - start;
        System.out.println((new StringBuilder("[Slimefun] \u6B63\u5728\u8BFB\u53D6\u65B9\u5757... 100% (\u5B8C\u6210 - ")).append(time).append("ms)").toString());
        System.out.println((new StringBuilder("[Slimefun] \u52A0\u8F7D\u5168\u90E8")).append(totalBlocks).append(" \u4E2A\u65B9\u5757\u5728\u4E16\u754C \"").append(world.getName()).append("\"").toString());
        if(totalBlocks > 0L)
            System.out.println((new StringBuilder("[Slimefun] \u5E73\u5747: ")).append(DoubleHandler.fixDouble((double)time / (double)totalBlocks, 3)).append("ms/\u4E2A\u65B9\u5757").toString());
        break MISSING_BLOCK_LABEL_855;
        f.mkdirs();
        File chunks = new File("data-storage/Slimefun/stored-chunks/chunks.sfc");
        if(chunks.exists())
        {
            FileConfiguration cfg = YamlConfiguration.loadConfiguration(chunks);
            for(Iterator iterator = cfg.getKeys(false).iterator(); iterator.hasNext();)
            {
                String key = (String)iterator.next();
                try
                {
                    if(world.getName().equals(key.split(";")[0]))
                        map_chunks.put(key, cfg.getString(key));
                }
                catch(Exception x)
                {
                    System.err.println((new StringBuilder("[Slimefun] \u52A0\u8F7D\u5931\u8D25")).append(chunks.getName()).append(" \u5728\u4E16\u754C \"").append(world.getName()).append("\" (ERR: ").append(key).append(")").toString());
                    x.printStackTrace();
                }
            }

        }
        worlds.put(world.getName(), this);
        File afile[];
        int k = (afile = (new File("data-storage/Slimefun/stored-inventories")).listFiles()).length;
        for(int i = 0; i < k; i++)
        {
            File file = afile[i];
            if(file.getName().startsWith(w.getName()) && file.getName().endsWith(".sfi"))
            {
                Location l = deserializeLocation(file.getName().replace(".sfi", ""));
                Config cfg = new Config(file);
                try
                {
                    if(cfg.getString("preset") != null)
                    {
                        BlockMenuPreset preset = BlockMenuPreset.getPreset(cfg.getString("preset"));
                        inventories.put(l, new BlockMenu(preset, l, cfg));
                    } else
                    {
                        BlockMenuPreset preset = BlockMenuPreset.getPreset(checkID(l));
                        inventories.put(l, new BlockMenu(preset, l, cfg));
                    }
                }
                catch(Exception exception) { }
            }
        }

        k = (afile = (new File("data-storage/Slimefun/universal-inventories")).listFiles()).length;
        for(int j = 0; j < k; j++)
        {
            File file = afile[j];
            if(file.getName().endsWith(".sfi"))
            {
                Config cfg = new Config(file);
                BlockMenuPreset preset = BlockMenuPreset.getPreset(cfg.getString("preset"));
                universal_inventories.put(preset.getID(), new UniversalBlockMenu(preset, cfg));
            }
        }

        return;
    }

    public void computeChanges()
    {
        changes = cache_blocks.size() + chunk_changes;
        Map inventories2 = new HashMap(inventories);
        for(Iterator iterator = inventories2.entrySet().iterator(); iterator.hasNext();)
        {
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
            changes += ((BlockMenu)entry.getValue()).changes;
        }

        Map universal_inventories2 = new HashMap(universal_inventories);
        for(Iterator iterator1 = universal_inventories2.entrySet().iterator(); iterator1.hasNext();)
        {
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator1.next();
            changes += ((UniversalBlockMenu)entry.getValue()).changes;
        }

    }

    public int getChanges()
    {
        return changes;
    }

    public void save(boolean remove)
    {
        save(true, remove);
    }

    public void save(boolean computeChanges, boolean remove)
    {
        if(computeChanges)
            computeChanges();
        if(changes == 0)
            return;
        System.out.println((new StringBuilder("[Slimefun] \u6B63\u5728\u4FDD\u5B58\u4E16\u754C \"")).append(world.getName()).append("\" \u4E2D\u7684\u65B9\u5757 (").append(changes).append(" \u4E2A\u66F4\u6539\u5DF2\u5217\u961F)").toString());
        Map cache = new HashMap(cache_blocks);
        for(Iterator iterator = cache.entrySet().iterator(); iterator.hasNext();)
        {
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
            cache_blocks.remove(entry.getKey());
            Config cfg = (Config)entry.getValue();
            if(cfg.getKeys().isEmpty())
                cfg.getFile().delete();
            else
                cfg.save();
        }

        Map inventories2 = new HashMap(inventories);
        java.util.Map.Entry entry;
        for(Iterator iterator1 = inventories2.entrySet().iterator(); iterator1.hasNext(); ((BlockMenu)entry.getValue()).save((Location)entry.getKey()))
            entry = (java.util.Map.Entry)iterator1.next();

        Map universal_inventories2 = new HashMap(universal_inventories);
        java.util.Map.Entry entry;
        for(Iterator iterator2 = universal_inventories2.entrySet().iterator(); iterator2.hasNext(); ((UniversalBlockMenu)entry.getValue()).save())
            entry = (java.util.Map.Entry)iterator2.next();

        if(chunk_changes > 0)
        {
            File chunks = new File("data-storage/Slimefun/stored-chunks/chunks.sfc");
            Config cfg = new Config("data-storage/Slimefun/temp.yml");
            java.util.Map.Entry entry;
            for(Iterator iterator3 = map_chunks.entrySet().iterator(); iterator3.hasNext(); cfg.setValue((String)entry.getKey(), entry.getValue()))
                entry = (java.util.Map.Entry)iterator3.next();

            cfg.save(chunks);
            if(remove)
                worlds.remove(world.getName());
        }
        changes = 0;
        chunk_changes = 0;
    }

    public static void store(Block block, ItemStack item)
    {
        SlimefunItem sfitem = SlimefunItem.getByItem(item);
        if(sfitem != null)
            addBlockInfo(block, "id", sfitem.getName(), true);
    }

    public static void store(Block block, String item)
    {
        addBlockInfo(block, "id", item, true);
    }

    public static ItemStack retrieve(Block block)
    {
        if(!hasBlockInfo(block))
            return null;
        SlimefunItem item = SlimefunItem.getByName(getBlockInfo(block, "id"));
        clearBlockInfo(block);
        if(item == null)
            return null;
        else
            return item.getItem();
    }

    public static Config getBlockInfo(Block block)
    {
        return getBlockInfo(block.getLocation());
    }

    public static Config getBlockInfo(Location l)
    {
        Config cfg;
        try
        {
            BlockStorage storage = getStorage(l.getWorld());
            cfg = new Config("data-storage/Slimefun/temp.yml");
            if(!storage.storage.containsKey(l))
                return cfg;
        }
        catch(Exception x)
        {
            System.err.println(x.getClass().getName());
            System.err.println((new StringBuilder("[Slimefun] \u65E0\u6CD5\u89E3\u6790\u65B9\u5757\u4FE1\u606F\u5728\u65B9\u5757 @ ")).append(l.getBlockX()).append(", ").append(l.getBlockY()).append(", ").append(l.getBlockZ()).toString());
            try
            {
                System.err.println(getJSONData(l));
            }
            catch(Exception x2)
            {
                System.err.println("No Metadata found!");
            }
            System.err.println("[Slimefun] ");
            System.err.println("[Slimefun] \u5FFD\u7565\u6B64\u4FE1\u606F, \u9664\u975E\u5B83\u4E00\u76F4\u5237\u5C4F.");
            System.err.println("[Slimefun] ");
            x.printStackTrace();
            return new Config("data-storage/Slimefun/temp.yml");
        }
        java.util.Map.Entry entry;
        for(Iterator iterator = parseJSON(getJSONData(l)).entrySet().iterator(); iterator.hasNext(); cfg.setValue((String)entry.getKey(), entry.getValue()))
            entry = (java.util.Map.Entry)iterator.next();

        return cfg;
    }

    private static Map parseJSON(String json)
    {
        Map map = new HashMap();
        if(json != null && json.length() > 2)
            try
            {
                JSONParser parser = new JSONParser();
                JSONObject obj = (JSONObject)parser.parse(json);
                String key;
                String value;
                for(Iterator iterator = obj.keySet().iterator(); iterator.hasNext(); map.put(key, value))
                {
                    Object entry = iterator.next();
                    key = entry.toString();
                    value = obj.get(entry).toString();
                }

            }
            catch(ParseException e)
            {
                e.printStackTrace();
            }
        return map;
    }

    private static String getJSONData(Location l)
    {
        BlockStorage storage = getStorage(l.getWorld());
        return (String)storage.storage.get(l);
    }

    private static String getJSONData(Chunk chunk)
    {
        return (String)map_chunks.get(serializeChunk(chunk));
    }

    public static String getBlockInfo(Block block, String key)
    {
        return getBlockInfo(block.getLocation(), key);
    }

    public static String getBlockInfo(Location l, String key)
    {
        return (String)parseJSON(getJSONData(l)).get(key);
    }

    public static void addBlockInfo(Location l, String key, String value)
    {
        addBlockInfo(l, key, value, false);
    }

    public static void addBlockInfo(Block block, String key, String value)
    {
        addBlockInfo(block.getLocation(), key, value);
    }

    public static void addBlockInfo(Block block, String key, String value, boolean updateTicker)
    {
        addBlockInfo(block.getLocation(), key, value, updateTicker);
    }

    public static void addBlockInfo(Location l, String key, String value, boolean updateTicker)
    {
        Config cfg = new Config("data-storage/Slimefun/temp.yml");
        if(hasBlockInfo(l))
            cfg = getBlockInfo(l);
        cfg.setValue(key, value);
        setBlockInfo(l, cfg, updateTicker);
    }

    public static boolean hasBlockInfo(Block block)
    {
        return hasBlockInfo(block.getLocation());
    }

    public static boolean hasBlockInfo(Location l)
    {
        BlockStorage storage = getStorage(l.getWorld());
        return storage != null && storage.storage.containsKey(l) && getBlockInfo(l, "id") != null;
    }

    public static void setBlockInfo(Block block, Config cfg, boolean updateTicker)
    {
        setBlockInfo(block.getLocation(), cfg, updateTicker);
    }

    public static void setBlockInfo(Location l, Config cfg, boolean updateTicker)
    {
        _integrated_removeBlockInfo(l, false);
        JSONObject json = new JSONObject();
        String key;
        for(Iterator iterator = cfg.getKeys().iterator(); iterator.hasNext(); json.put(key, cfg.getString(key)))
            key = (String)iterator.next();

        setBlockInfo(l, json.toJSONString(), updateTicker);
    }

    public static void setBlockInfo(Block b, String json, boolean updateTicker)
    {
        setBlockInfo(b.getLocation(), json, updateTicker);
    }

    public static void setBlockInfo(Location l, String json, boolean updateTicker)
    {
        BlockStorage storage = getStorage(l.getWorld());
        storage.storage.put(l, json);
        Map parsed = parseJSON(json);
        if(BlockMenuPreset.isInventory((String)parsed.get("id")))
            if(BlockMenuPreset.isUniversalInventory((String)parsed.get("id")))
            {
                if(!universal_inventories.containsKey(parsed.get("id")))
                    storage.loadUniversalInventory(BlockMenuPreset.getPreset((String)parsed.get("id")));
            } else
            if(!storage.hasInventory(l))
            {
                File file = new File((new StringBuilder("data-storage/Slimefun/stored-inventories/")).append(serializeLocation(l)).append(".sfi").toString());
                if(file.exists())
                    storage.inventories.put(l, new BlockMenu(BlockMenuPreset.getPreset((String)parsed.get("id")), l, new Config(file)));
                else
                    storage.loadInventory(l, BlockMenuPreset.getPreset((String)parsed.get("id")));
            }
        refreshCache(getStorage(l.getWorld()), l, (String)parsed.get("id"), json, updateTicker);
    }

    public static void clearBlockInfo(Block block)
    {
        clearBlockInfo(block.getLocation());
    }

    public static void clearBlockInfo(Location l)
    {
        clearBlockInfo(l, true);
    }

    public static void clearBlockInfo(Block b, boolean destroy)
    {
        clearBlockInfo(b.getLocation(), destroy);
    }

    public static void clearBlockInfo(Location l, boolean destroy)
    {
        SlimefunStartup.ticker.delete.put(l, Boolean.valueOf(destroy));
    }

    public static void _integrated_removeBlockInfo(Location l, boolean destroy)
    {
        BlockStorage storage = getStorage(l.getWorld());
        if(hasBlockInfo(l))
        {
            refreshCache(storage, l, getBlockInfo(l).getString("id"), null, destroy);
            storage.storage.remove(l);
        }
        if(destroy)
        {
            if(storage.hasInventory(l))
                storage.clearInventory(l);
            if(storage.hasUniversalInventory(l))
            {
                UniversalBlockMenu menu = storage.getUniversalInventory(l);
                HumanEntity n;
                for(Iterator iterator = menu.toInventory().getViewers().iterator(); iterator.hasNext(); n.closeInventory())
                    n = (HumanEntity)iterator.next();

                storage.getUniversalInventory(l).save();
            }
            if(ticking_chunks.containsKey(l.getChunk().toString()))
            {
                Set blocks = (Set)ticking_chunks.get(l.getChunk().toString());
                blocks.remove(l.getBlock());
                if(blocks.isEmpty())
                {
                    ticking_chunks.remove(l.getChunk().toString());
                    loaded_tickers.remove(l.getChunk().toString());
                } else
                {
                    ticking_chunks.put(l.getChunk().toString(), blocks);
                }
            }
        }
    }

    public static void moveBlockInfo(Block block, Block newBlock)
    {
        SlimefunStartup.ticker.move.put(block, newBlock);
    }

    public static void _integrated_moveBlockInfo(Block block, Block newBlock)
    {
        if(!hasBlockInfo(block))
            return;
        BlockStorage storage = getStorage(block.getWorld());
        setBlockInfo(newBlock, getBlockInfo(block), true);
        if(storage.inventories.containsKey(block.getLocation()))
        {
            BlockMenu menu = (BlockMenu)storage.inventories.get(block.getLocation());
            storage.inventories.put(newBlock.getLocation(), menu);
            storage.clearInventory(block.getLocation());
            menu.move(newBlock);
        }
        refreshCache(storage, block, getBlockInfo(block).getString("id"), null, true);
        storage.storage.remove(block.getLocation());
        try
        {
            if(ticking_chunks.containsKey(block.getChunk().toString()))
            {
                Set blocks = (Set)ticking_chunks.get(block.getChunk().toString());
                blocks.remove(block);
                if(blocks.isEmpty())
                {
                    ticking_chunks.remove(block.getChunk().toString());
                    loaded_tickers.remove(block.getChunk().toString());
                } else
                {
                    ticking_chunks.put(block.getChunk().toString(), blocks);
                }
            }
        }
        catch(IllegalStateException illegalstateexception) { }
    }

    private static void refreshCache(BlockStorage storage, Block b, String key, String value, boolean updateTicker)
    {
        refreshCache(storage, b.getLocation(), key, value, updateTicker);
    }

    private static void refreshCache(BlockStorage storage, Location l, String key, String value, boolean updateTicker)
    {
        Config cfg = storage.cache_blocks.containsKey(key) ? (Config)storage.cache_blocks.get(key) : new Config((new StringBuilder("data-storage/Slimefun/stored-blocks/")).append(l.getWorld().getName()).append("/").append(key).append(".sfb").toString());
        cfg.setValue(serializeLocation(l), value);
        storage.cache_blocks.put(key, cfg);
        if(updateTicker)
        {
            SlimefunItem item = SlimefunItem.getByName(key);
            if(item != null && item.isTicking())
            {
                Chunk chunk = l.getChunk();
                if(value != null)
                {
                    Set blocks = ((Set) (ticking_chunks.containsKey(chunk.toString()) ? (Set)ticking_chunks.get(chunk.toString()) : ((Set) (new HashSet()))));
                    blocks.add(l.getBlock());
                    ticking_chunks.put(chunk.toString(), blocks);
                    if(!loaded_tickers.contains(chunk.toString()))
                        loaded_tickers.add(chunk.toString());
                }
            }
        }
    }

    public static SlimefunItem check(Block block)
    {
        return check(block.getLocation());
    }

    public static SlimefunItem check(Location l)
    {
        if(!hasBlockInfo(l))
            return null;
        else
            return SlimefunItem.getByName(getBlockInfo(l, "id"));
    }

    public static String checkID(Block block)
    {
        return checkID(block.getLocation());
    }

    public static boolean check(Block block, String slimefunItem)
    {
        return check(block.getLocation(), slimefunItem);
    }

    public static String checkID(Location l)
    {
        if(!hasBlockInfo(l))
            return null;
        else
            return getBlockInfo(l, "id");
    }

    public static boolean check(Location l, String slimefunItem)
    {
        if(!hasBlockInfo(l))
            return false;
        try
        {
            String id = getBlockInfo(l, "id");
            return id != null && id.equalsIgnoreCase(slimefunItem);
        }
        catch(NullPointerException x)
        {
            return false;
        }
    }

    public static boolean isWorldRegistered(String name)
    {
        return worlds.containsKey(name);
    }

    public static Set getTickingChunks()
    {
        return new HashSet(loaded_tickers);
    }

    public static Set getTickingBlocks(Chunk chunk)
    {
        return getTickingBlocks(chunk.toString());
    }

    public static Set getTickingBlocks(String chunk)
    {
        return new HashSet((Collection)ticking_chunks.get(chunk));
    }

    public BlockMenu loadInventory(Location l, BlockMenuPreset preset)
    {
        BlockMenu menu = new BlockMenu(preset, l);
        inventories.put(l, menu);
        return menu;
    }

    public void loadUniversalInventory(BlockMenuPreset preset)
    {
        universal_inventories.put(preset.getID(), new UniversalBlockMenu(preset));
    }

    public void clearInventory(Location l)
    {
        BlockMenu menu = getInventory(l);
        HumanEntity n;
        for(Iterator iterator = menu.toInventory().getViewers().iterator(); iterator.hasNext(); n.closeInventory())
            n = (HumanEntity)iterator.next();

        ((BlockMenu)inventories.get(l)).delete(l);
        inventories.remove(l);
    }

    public boolean hasInventory(Location l)
    {
        return inventories.containsKey(l);
    }

    public boolean hasUniversalInventory(String id)
    {
        return universal_inventories.containsKey(id);
    }

    public UniversalBlockMenu getUniversalInventory(Block block)
    {
        return getUniversalInventory(block.getLocation());
    }

    public UniversalBlockMenu getUniversalInventory(Location l)
    {
        String id = checkID(l);
        return id != null ? getUniversalInventory(id) : null;
    }

    public UniversalBlockMenu getUniversalInventory(String id)
    {
        return (UniversalBlockMenu)universal_inventories.get(id);
    }

    public static BlockMenu getInventory(Block b)
    {
        return getInventory(b.getLocation());
    }

    public static BlockMenu getInventory(Location l)
    {
        BlockStorage storage = getStorage(l.getWorld());
        if(storage == null)
            return null;
        if(!storage.hasInventory(l))
            return storage.loadInventory(l, BlockMenuPreset.getPreset(checkID(l)));
        else
            return (BlockMenu)storage.inventories.get(l);
    }

    public static JSONParser getParser()
    {
        return new JSONParser();
    }

    public static Config getChunkInfo(Chunk chunk)
    {
        Config cfg;
        try
        {
            cfg = new Config("data-storage/Slimefun/temp.yml");
            if(!map_chunks.containsKey(serializeChunk(chunk)))
                return cfg;
        }
        catch(Exception x)
        {
            System.err.println(x.getClass().getName());
            System.err.println((new StringBuilder("[Slimefun] \u65E0\u6CD5\u89E3\u6790\u533A\u5757\u4FE1\u606F\u5728\u533A\u5757 @ ")).append(chunk.getX()).append(", ").append(chunk.getZ()).toString());
            try
            {
                System.err.println(getJSONData(chunk));
            }
            catch(Exception x2)
            {
                System.err.println("No Metadata found!");
            }
            x.printStackTrace();
            return new Config("data-storage/Slimefun/temp.yml");
        }
        java.util.Map.Entry entry;
        for(Iterator iterator = parseJSON(getJSONData(chunk)).entrySet().iterator(); iterator.hasNext(); cfg.setValue((String)entry.getKey(), entry.getValue()))
            entry = (java.util.Map.Entry)iterator.next();

        return cfg;
    }

    public static boolean hasChunkInfo(Chunk chunk)
    {
        return map_chunks.containsKey(serializeChunk(chunk));
    }

    public static void setChunkInfo(Chunk chunk, String key, String value)
    {
        Config cfg = new Config("data-storage/Slimefun/temp.yml");
        if(hasChunkInfo(chunk))
            cfg = getChunkInfo(chunk);
        cfg.setValue(key, value);
        JSONObject json = new JSONObject();
        String path;
        for(Iterator iterator = cfg.getKeys().iterator(); iterator.hasNext(); json.put(path, cfg.getString(path)))
            path = (String)iterator.next();

        map_chunks.put(serializeChunk(chunk), json.toJSONString());
        chunk_changes++;
    }

    public static String getChunkInfo(Chunk chunk, String key)
    {
        return getChunkInfo(chunk).getString(key);
    }

    public static boolean hasChunkInfo(Chunk chunk, String key)
    {
        return getChunkInfo(chunk, key) != null;
    }

    public static void clearChunkInfo(Chunk chunk)
    {
        map_chunks.remove(serializeChunk(chunk));
    }

    public static String getBlockInfoAsJson(Block block)
    {
        return getBlockInfoAsJson(block.getLocation());
    }

    public static String getBlockInfoAsJson(Location l)
    {
        return getJSONData(l);
    }

    public boolean hasUniversalInventory(Block block)
    {
        return hasUniversalInventory(block.getLocation());
    }

    public boolean hasUniversalInventory(Location l)
    {
        String id = checkID(l);
        return id != null ? hasUniversalInventory(id) : false;
    }

}

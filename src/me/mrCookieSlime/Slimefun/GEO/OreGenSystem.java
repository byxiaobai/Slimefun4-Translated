package me.mrCookieSlime.Slimefun.GEO;

import java.io.PrintStream;
import java.util.*;
import me.mrCookieSlime.CSCoreLibPlugin.Configuration.Config;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import org.bukkit.Chunk;
import org.bukkit.block.Biome;
import org.bukkit.block.Block;

// Referenced classes of package me.mrCookieSlime.Slimefun.GEO:
//            OreGenResource

public class OreGenSystem
{

    public static Map map = new HashMap();

    public OreGenSystem()
    {
    }

    public static Collection listResources()
    {
        return map.values();
    }

    public static void registerResource(OreGenResource resource)
    {
        map.put(resource.getName(), resource);
        System.out.println((new StringBuilder("[Slimefun - GEO] 正在注册矿物生成器: ")).append(resource.getName()).toString());
        Config cfg = new Config((new StringBuilder("plugins/Slimefun/generators/")).append(resource.getName()).append(".cfg").toString());
        Biome abiome[];
        int j = (abiome = Biome.values()).length;
        for(int i = 0; i < j; i++)
        {
            Biome biome = abiome[i];
            cfg.setDefaultValue(biome.toString(), Integer.valueOf(resource.getDefaultSupply(biome)));
        }

        cfg.save();
    }

    public static OreGenResource getResource(String name)
    {
        return (OreGenResource)map.get(name);
    }

    private static int getDefault(OreGenResource resource, Biome biome)
    {
        if(resource == null)
        {
            return 0;
        } else
        {
            Config cfg = new Config((new StringBuilder("plugins/Slimefun/generators/")).append(resource.getName()).append(".cfg").toString());
            return cfg.getInt(biome.toString());
        }
    }

    public static void setSupplies(OreGenResource resource, Chunk chunk, int amount)
    {
        if(resource == null)
        {
            return;
        } else
        {
            BlockStorage.setChunkInfo(chunk, (new StringBuilder("resources_")).append(resource.getName().toUpperCase()).toString(), String.valueOf(amount));
            return;
        }
    }

    public static int generateSupplies(OreGenResource resource, Chunk chunk)
    {
        if(resource == null)
        {
            return 0;
        } else
        {
            int supplies = getDefault(resource, chunk.getBlock(5, 50, 5).getBiome());
            BlockStorage.setChunkInfo(chunk, (new StringBuilder("resources_")).append(resource.getName().toUpperCase()).toString(), String.valueOf(supplies));
            return supplies;
        }
    }

    public static int getSupplies(OreGenResource resource, Chunk chunk, boolean generate)
    {
        if(resource == null)
            return 0;
        if(BlockStorage.hasChunkInfo(chunk, (new StringBuilder("resources_")).append(resource.getName().toUpperCase()).toString()))
            return Integer.parseInt(BlockStorage.getChunkInfo(chunk, (new StringBuilder("resources_")).append(resource.getName().toUpperCase()).toString()));
        if(!generate)
            return 0;
        else
            return generateSupplies(resource, chunk);
    }

    public static boolean wasResourceGenerated(OreGenResource resource, Chunk chunk)
    {
        if(resource == null)
            return false;
        else
            return BlockStorage.hasChunkInfo(chunk, (new StringBuilder("resources_")).append(resource.getName().toUpperCase()).toString());
    }

}

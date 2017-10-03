// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   NetherIceResource.java

package me.mrCookieSlime.Slimefun.GEO.Resources;

import me.mrCookieSlime.Slimefun.GEO.OreGenResource;
import me.mrCookieSlime.Slimefun.Lists.SlimefunItems;
import org.bukkit.block.Biome;
import org.bukkit.inventory.ItemStack;

public class NetherIceResource
    implements OreGenResource
{

    private static int $SWITCH_TABLE$org$bukkit$block$Biome[];

    public NetherIceResource()
    {
    }

    public int getDefaultSupply(Biome biome)
    {
        switch($SWITCH_TABLE$org$bukkit$block$Biome()[biome.ordinal()])
        {
        case 9: // '\t'
            return 32;
        }
        return 0;
    }

    public String getName()
    {
        return "Nether Ice";
    }

    public ItemStack getIcon()
    {
        return SlimefunItems.NETHER_ICE.clone();
    }

    public String getMeasurementUnit()
    {
        return "Blocks";
    }

    static int[] $SWITCH_TABLE$org$bukkit$block$Biome()
    {
        $SWITCH_TABLE$org$bukkit$block$Biome;
        if($SWITCH_TABLE$org$bukkit$block$Biome == null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        JVM INSTR pop ;
        int ai[] = new int[Biome.values().length];
        try
        {
            ai[Biome.BEACHES.ordinal()] = 17;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Biome.BIRCH_FOREST.ordinal()] = 28;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Biome.BIRCH_FOREST_HILLS.ordinal()] = 29;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Biome.COLD_BEACH.ordinal()] = 27;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Biome.DEEP_OCEAN.ordinal()] = 25;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Biome.DESERT.ordinal()] = 3;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Biome.DESERT_HILLS.ordinal()] = 18;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Biome.EXTREME_HILLS.ordinal()] = 4;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Biome.EXTREME_HILLS_WITH_TREES.ordinal()] = 35;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Biome.FOREST.ordinal()] = 5;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Biome.FOREST_HILLS.ordinal()] = 19;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Biome.FROZEN_OCEAN.ordinal()] = 11;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Biome.FROZEN_RIVER.ordinal()] = 12;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Biome.HELL.ordinal()] = 9;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Biome.ICE_FLATS.ordinal()] = 13;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Biome.ICE_MOUNTAINS.ordinal()] = 14;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Biome.JUNGLE.ordinal()] = 22;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Biome.JUNGLE_EDGE.ordinal()] = 24;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Biome.JUNGLE_HILLS.ordinal()] = 23;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Biome.MESA.ordinal()] = 38;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Biome.MESA_CLEAR_ROCK.ordinal()] = 40;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Biome.MESA_ROCK.ordinal()] = 39;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Biome.MUSHROOM_ISLAND.ordinal()] = 15;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Biome.MUSHROOM_ISLAND_SHORE.ordinal()] = 16;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Biome.MUTATED_BIRCH_FOREST.ordinal()] = 51;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Biome.MUTATED_BIRCH_FOREST_HILLS.ordinal()] = 52;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Biome.MUTATED_DESERT.ordinal()] = 43;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Biome.MUTATED_EXTREME_HILLS.ordinal()] = 44;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Biome.MUTATED_EXTREME_HILLS_WITH_TREES.ordinal()] = 57;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Biome.MUTATED_FOREST.ordinal()] = 45;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Biome.MUTATED_ICE_FLATS.ordinal()] = 48;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Biome.MUTATED_JUNGLE.ordinal()] = 49;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Biome.MUTATED_JUNGLE_EDGE.ordinal()] = 50;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Biome.MUTATED_MESA.ordinal()] = 60;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Biome.MUTATED_MESA_CLEAR_ROCK.ordinal()] = 62;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Biome.MUTATED_MESA_ROCK.ordinal()] = 61;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Biome.MUTATED_PLAINS.ordinal()] = 42;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Biome.MUTATED_REDWOOD_TAIGA.ordinal()] = 55;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Biome.MUTATED_REDWOOD_TAIGA_HILLS.ordinal()] = 56;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Biome.MUTATED_ROOFED_FOREST.ordinal()] = 53;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Biome.MUTATED_SAVANNA.ordinal()] = 58;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Biome.MUTATED_SAVANNA_ROCK.ordinal()] = 59;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Biome.MUTATED_SWAMPLAND.ordinal()] = 47;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Biome.MUTATED_TAIGA.ordinal()] = 46;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Biome.MUTATED_TAIGA_COLD.ordinal()] = 54;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Biome.OCEAN.ordinal()] = 1;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Biome.PLAINS.ordinal()] = 2;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Biome.REDWOOD_TAIGA.ordinal()] = 33;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Biome.REDWOOD_TAIGA_HILLS.ordinal()] = 34;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Biome.RIVER.ordinal()] = 8;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Biome.ROOFED_FOREST.ordinal()] = 30;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Biome.SAVANNA.ordinal()] = 36;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Biome.SAVANNA_ROCK.ordinal()] = 37;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Biome.SKY.ordinal()] = 10;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Biome.SMALLER_EXTREME_HILLS.ordinal()] = 21;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Biome.STONE_BEACH.ordinal()] = 26;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Biome.SWAMPLAND.ordinal()] = 7;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Biome.TAIGA.ordinal()] = 6;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Biome.TAIGA_COLD.ordinal()] = 31;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Biome.TAIGA_COLD_HILLS.ordinal()] = 32;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Biome.TAIGA_HILLS.ordinal()] = 20;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Biome.VOID.ordinal()] = 41;
        }
        catch(NoSuchFieldError _ex) { }
        return $SWITCH_TABLE$org$bukkit$block$Biome = ai;
    }
}

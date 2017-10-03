// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   EnergyNet.java

package me.mrCookieSlime.Slimefun.api.energy;

import java.util.*;
import me.mrCookieSlime.CSCoreLibPlugin.general.Math.DoubleHandler;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.SlimefunStartup;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import me.mrCookieSlime.Slimefun.api.TickerTask;
import me.mrCookieSlime.Slimefun.holograms.EnergyHologram;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.scheduler.BukkitScheduler;

// Referenced classes of package me.mrCookieSlime.Slimefun.api.energy:
//            EnergyTicker, ChargableBlock

public class EnergyNet
{
    public static final class Axis extends Enum
    {

        public static final Axis X_POSITIVE;
        public static final Axis X_NEGATIVE;
        public static final Axis Y_POSITIVE;
        public static final Axis Y_NEGATIVE;
        public static final Axis Z_POSITIVE;
        public static final Axis Z_NEGATIVE;
        public static final Axis UNKNOWN;
        private static final Axis ENUM$VALUES[];

        public static Axis[] values()
        {
            Axis aaxis[];
            int i;
            Axis aaxis1[];
            System.arraycopy(aaxis = ENUM$VALUES, 0, aaxis1 = new Axis[i = aaxis.length], 0, i);
            return aaxis1;
        }

        public static Axis valueOf(String s)
        {
            return (Axis)Enum.valueOf(me/mrCookieSlime/Slimefun/api/energy/EnergyNet$Axis, s);
        }

        static 
        {
            X_POSITIVE = new Axis("X_POSITIVE", 0);
            X_NEGATIVE = new Axis("X_NEGATIVE", 1);
            Y_POSITIVE = new Axis("Y_POSITIVE", 2);
            Y_NEGATIVE = new Axis("Y_NEGATIVE", 3);
            Z_POSITIVE = new Axis("Z_POSITIVE", 4);
            Z_NEGATIVE = new Axis("Z_NEGATIVE", 5);
            UNKNOWN = new Axis("UNKNOWN", 6);
            ENUM$VALUES = (new Axis[] {
                X_POSITIVE, X_NEGATIVE, Y_POSITIVE, Y_NEGATIVE, Z_POSITIVE, Z_NEGATIVE, UNKNOWN
            });
        }

        private Axis(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class NetworkComponent extends Enum
    {

        public static final NetworkComponent SOURCE;
        public static final NetworkComponent DISTRIBUTOR;
        public static final NetworkComponent CONSUMER;
        public static final NetworkComponent NONE;
        private static final NetworkComponent ENUM$VALUES[];

        public static NetworkComponent[] values()
        {
            NetworkComponent anetworkcomponent[];
            int i;
            NetworkComponent anetworkcomponent1[];
            System.arraycopy(anetworkcomponent = ENUM$VALUES, 0, anetworkcomponent1 = new NetworkComponent[i = anetworkcomponent.length], 0, i);
            return anetworkcomponent1;
        }

        public static NetworkComponent valueOf(String s)
        {
            return (NetworkComponent)Enum.valueOf(me/mrCookieSlime/Slimefun/api/energy/EnergyNet$NetworkComponent, s);
        }

        static 
        {
            SOURCE = new NetworkComponent("SOURCE", 0);
            DISTRIBUTOR = new NetworkComponent("DISTRIBUTOR", 1);
            CONSUMER = new NetworkComponent("CONSUMER", 2);
            NONE = new NetworkComponent("NONE", 3);
            ENUM$VALUES = (new NetworkComponent[] {
                SOURCE, DISTRIBUTOR, CONSUMER, NONE
            });
        }

        private NetworkComponent(String s, int i)
        {
            super(s, i);
        }
    }


    private static final int RANGE = 6;
    public static Set machines_input = new HashSet();
    public static Set machines_storage = new HashSet();
    public static Set machines_output = new HashSet();
    public static Map listeners = new HashMap();
    private static int $SWITCH_TABLE$me$mrCookieSlime$Slimefun$api$energy$EnergyNet$NetworkComponent[];

    public EnergyNet()
    {
    }

    public static NetworkComponent getComponent(Block b)
    {
        return getComponent(b.getLocation());
    }

    public static NetworkComponent getComponent(String id)
    {
        if(machines_input.contains(id))
            return NetworkComponent.SOURCE;
        if(machines_storage.contains(id))
            return NetworkComponent.DISTRIBUTOR;
        if(machines_output.contains(id))
            return NetworkComponent.CONSUMER;
        else
            return NetworkComponent.NONE;
    }

    public static NetworkComponent getComponent(Location l)
    {
        if(!BlockStorage.hasBlockInfo(l))
            return NetworkComponent.NONE;
        String id = BlockStorage.checkID(l);
        if(machines_input.contains(id))
            return NetworkComponent.SOURCE;
        if(machines_storage.contains(id))
            return NetworkComponent.DISTRIBUTOR;
        if(machines_output.contains(id))
            return NetworkComponent.CONSUMER;
        else
            return NetworkComponent.NONE;
    }

    public static void registerComponent(String id, NetworkComponent component)
    {
        switch($SWITCH_TABLE$me$mrCookieSlime$Slimefun$api$energy$EnergyNet$NetworkComponent()[component.ordinal()])
        {
        case 3: // '\003'
            machines_output.add(id);
            break;

        case 2: // '\002'
            machines_storage.add(id);
            break;

        case 1: // '\001'
            machines_input.add(id);
            break;
        }
    }

    public static void tick(Block b)
    {
        Set input = new HashSet();
        Set storage = new HashSet();
        Set output = new HashSet();
        double supply = 0.0D;
        double demand = 0.0D;
        if(scan(b.getLocation(), Axis.UNKNOWN, new HashSet(), input, storage, output, supply, demand).isEmpty())
        {
            EnergyHologram.update(b, "&4\u627E\u4E0D\u5230\u80FD\u6E90\u7F51\u7EDC");
        } else
        {
            final Location source;
            long timestamp;
            for(Iterator iterator = input.iterator(); iterator.hasNext(); TickerTask.block_timings.put(source, Long.valueOf(System.currentTimeMillis() - timestamp)))
            {
                source = (Location)iterator.next();
                timestamp = System.currentTimeMillis();
                SlimefunItem item = BlockStorage.check(source);
                double energy = item.getEnergyTicker().generateEnergy(source, item, BlockStorage.getBlockInfo(source));
                if(item.getEnergyTicker().explode(source))
                {
                    BlockStorage.clearBlockInfo(source);
                    Bukkit.getScheduler().scheduleSyncDelayedTask(SlimefunStartup.instance, new Runnable() {

                        private final Location val$source;

                        public void run()
                        {
                            source.getBlock().setType(Material.LAVA);
                            source.getWorld().createExplosion(source, 0.0F, false);
                        }

            
            {
                source = location;
                super();
            }
                    }
);
                } else
                {
                    supply += energy;
                    if(ChargableBlock.isChargable(source))
                        supply = DoubleHandler.fixDouble(supply + (double)ChargableBlock.getCharge(source));
                }
            }

            for(Iterator iterator1 = storage.iterator(); iterator1.hasNext();)
            {
                Location battery = (Location)iterator1.next();
                supply += ChargableBlock.getCharge(battery);
            }

            int available = (int)DoubleHandler.fixDouble(supply);
            for(Iterator iterator2 = output.iterator(); iterator2.hasNext();)
            {
                Location destination = (Location)iterator2.next();
                int capacity = ChargableBlock.getMaxCharge(destination);
                int charge = ChargableBlock.getCharge(destination);
                if(charge < capacity)
                {
                    int rest = capacity - charge;
                    demand += rest;
                    if(available > 0)
                        if(available > rest)
                        {
                            ChargableBlock.setUnsafeCharge(destination, capacity, false);
                            available -= rest;
                        } else
                        {
                            ChargableBlock.setUnsafeCharge(destination, charge + available, false);
                            available = 0;
                        }
                }
            }

            for(Iterator iterator3 = storage.iterator(); iterator3.hasNext();)
            {
                Location battery = (Location)iterator3.next();
                if(available > 0)
                {
                    int capacity = ChargableBlock.getMaxCharge(battery);
                    if(available > capacity)
                    {
                        ChargableBlock.setUnsafeCharge(battery, capacity, true);
                        available -= capacity;
                    } else
                    {
                        ChargableBlock.setUnsafeCharge(battery, available, true);
                        available = 0;
                    }
                } else
                {
                    ChargableBlock.setUnsafeCharge(battery, 0, true);
                }
            }

            for(Iterator iterator4 = input.iterator(); iterator4.hasNext();)
            {
                Location source = (Location)iterator4.next();
                if(ChargableBlock.isChargable(source))
                    if(available > 0)
                    {
                        int capacity = ChargableBlock.getMaxCharge(source);
                        if(available > capacity)
                        {
                            ChargableBlock.setUnsafeCharge(source, capacity, false);
                            available -= capacity;
                        } else
                        {
                            ChargableBlock.setUnsafeCharge(source, available, false);
                            available = 0;
                        }
                    } else
                    {
                        ChargableBlock.setUnsafeCharge(source, 0, false);
                    }
            }

            EnergyHologram.update(b, supply, demand);
        }
    }

    public static Set scan(Location source, Axis exclude, Set sources, Set input, Set storage, Set output, double supply, 
            double demand)
    {
        sources.add(source);
        Set blocks = new HashSet();
        blocks.add(source);
        if(!exclude.equals(Axis.X_POSITIVE))
        {
            for(int i = 0; i <= 6; i++)
            {
                Location l = new Location(source.getWorld(), source.getX() + (double)i + 1.0D, source.getY(), source.getZ());
                if(!continueScan(l, Axis.X_NEGATIVE, blocks, sources, input, storage, output, supply, demand))
                    return new HashSet();
            }

        }
        if(!exclude.equals(Axis.X_NEGATIVE))
        {
            for(int i = 0; i <= 6; i++)
            {
                Location l = new Location(source.getWorld(), source.getX() - (double)i - 1.0D, source.getY(), source.getZ());
                if(!continueScan(l, Axis.X_POSITIVE, blocks, sources, input, storage, output, supply, demand))
                    return new HashSet();
            }

        }
        if(!exclude.equals(Axis.Y_POSITIVE))
        {
            for(int i = 0; i <= 6; i++)
            {
                Location l = new Location(source.getWorld(), source.getX(), source.getY() + (double)i + 1.0D, source.getZ());
                if(!continueScan(l, Axis.Y_NEGATIVE, blocks, sources, input, storage, output, supply, demand))
                    return new HashSet();
            }

        }
        if(!exclude.equals(Axis.Y_NEGATIVE))
        {
            for(int i = 0; i <= 6; i++)
            {
                Location l = new Location(source.getWorld(), source.getX(), source.getY() - (double)i - 1.0D, source.getZ());
                if(!continueScan(l, Axis.Y_POSITIVE, blocks, sources, input, storage, output, supply, demand))
                    return new HashSet();
            }

        }
        if(!exclude.equals(Axis.Z_POSITIVE))
        {
            for(int i = 0; i <= 6; i++)
            {
                Location l = new Location(source.getWorld(), source.getX(), source.getY(), source.getZ() + (double)i + 1.0D);
                if(!continueScan(l, Axis.Z_NEGATIVE, blocks, sources, input, storage, output, supply, demand))
                    return new HashSet();
            }

        }
        if(!exclude.equals(Axis.Z_NEGATIVE))
        {
            for(int i = 0; i <= 6; i++)
            {
                Location l = new Location(source.getWorld(), source.getX(), source.getY(), source.getZ() - (double)i - 1.0D);
                if(!continueScan(l, Axis.Z_POSITIVE, blocks, sources, input, storage, output, supply, demand))
                    return new HashSet();
            }

        }
        return blocks;
    }

    private static boolean continueScan(Location l, Axis axis, Set blocks, Set sources, Set input, Set storage, Set output, double supply, double demand)
    {
        if(!sources.contains(l))
        {
            if(BlockStorage.check(l, "ENERGY_REGULATOR"))
                return false;
            switch($SWITCH_TABLE$me$mrCookieSlime$Slimefun$api$energy$EnergyNet$NetworkComponent()[getComponent(l).ordinal()])
            {
            default:
                break;

            case 3: // '\003'
                blocks.add(l);
                output.add(l);
                break;

            case 2: // '\002'
                blocks.add(l);
                if(ChargableBlock.isCapacitor(l))
                    storage.add(l);
                Set nextBlocks = scan(l, axis, sources, input, storage, output, supply, demand);
                if(nextBlocks.isEmpty())
                    return false;
                Location sink;
                for(Iterator iterator = nextBlocks.iterator(); iterator.hasNext(); blocks.add(sink))
                    sink = (Location)iterator.next();

                break;

            case 1: // '\001'
                blocks.add(l);
                input.add(l);
                break;
            }
        }
        return true;
    }

    static int[] $SWITCH_TABLE$me$mrCookieSlime$Slimefun$api$energy$EnergyNet$NetworkComponent()
    {
        $SWITCH_TABLE$me$mrCookieSlime$Slimefun$api$energy$EnergyNet$NetworkComponent;
        if($SWITCH_TABLE$me$mrCookieSlime$Slimefun$api$energy$EnergyNet$NetworkComponent == null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        JVM INSTR pop ;
        int ai[] = new int[NetworkComponent.values().length];
        try
        {
            ai[NetworkComponent.CONSUMER.ordinal()] = 3;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[NetworkComponent.DISTRIBUTOR.ordinal()] = 2;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[NetworkComponent.NONE.ordinal()] = 4;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[NetworkComponent.SOURCE.ordinal()] = 1;
        }
        catch(NoSuchFieldError _ex) { }
        return $SWITCH_TABLE$me$mrCookieSlime$Slimefun$api$energy$EnergyNet$NetworkComponent = ai;
    }

}

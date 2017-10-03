// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   CargoNet.java

package me.mrCookieSlime.Slimefun.api.item_transport;

import java.util.*;
import me.mrCookieSlime.CSCoreLibPlugin.Configuration.Config;
import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu;
import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ClickAction;
import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.Item.CustomItem;
import me.mrCookieSlime.CSCoreLibPlugin.general.Math.DoubleHandler;
import me.mrCookieSlime.CSCoreLibPlugin.general.Particles.MC_1_8.ParticleEffect;
import me.mrCookieSlime.Slimefun.Setup.SlimefunManager;
import me.mrCookieSlime.Slimefun.SlimefunStartup;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import me.mrCookieSlime.Slimefun.api.inventory.*;
import me.mrCookieSlime.Slimefun.holograms.CargoHologram;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.material.MaterialData;
import org.bukkit.scheduler.BukkitScheduler;

// Referenced classes of package me.mrCookieSlime.Slimefun.api.item_transport:
//            ChestTerminalSorter, CargoManager, ItemSlot, ItemRequest, 
//            ItemTransportFlow, StoredItem

public class CargoNet
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
            return (Axis)Enum.valueOf(me/mrCookieSlime/Slimefun/api/item_transport/CargoNet$Axis, s);
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


    public static boolean EXTRA_CHANNELS = false;
    private static final int RANGE = 5;
    public static List faces;
    public static Map round_robin = new HashMap();
    public static Set requests = new HashSet();
    private static int slots[] = {
        19, 20, 21, 28, 29, 30, 37, 38, 39
    };
    private static final ChestTerminalSorter sorter = new ChestTerminalSorter();
    public static final int terminal_slots[] = {
        0, 1, 2, 3, 4, 5, 6, 9, 10, 11, 
        12, 13, 14, 15, 18, 19, 20, 21, 22, 23, 
        24, 27, 28, 29, 30, 31, 32, 33, 36, 37, 
        38, 39, 40, 41, 42
    };
    private static final ItemStack terminal_noitem_item;
    private static final me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuClickHandler terminal_noitem_handler = new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuClickHandler() {

        public boolean onClick(Player p, int slot, ItemStack stack, ClickAction clickaction)
        {
            return false;
        }

    }
;

    public CargoNet()
    {
    }

    public static void tick(final Block b)
    {
        final Map input = new HashMap();
        final Map output = new HashMap();
        final Set providers = new HashSet();
        final Set terminals = new HashSet();
        final Set imports = new HashSet();
        final Set exports = new HashSet();
        final Set destinations = new HashSet();
        Set blocks = new HashSet();
        blocks.add(b.getLocation());
        final List visualizer1 = new ArrayList();
        final List visualizer2 = new ArrayList();
        if(scan(b.getLocation(), blocks, visualizer1, visualizer2, Axis.UNKNOWN, input, output, terminals, providers, destinations, imports, exports).isEmpty())
        {
            CargoHologram.update(b, "&7\u72B6\u6001: &4&l\u79BB\u7EBF");
        } else
        {
            final BlockStorage storage = BlockStorage.getStorage(b.getWorld());
            SlimefunStartup.instance.getServer().getScheduler().scheduleSyncDelayedTask(SlimefunStartup.instance, new Runnable() {

                private final Block val$b;
                private final List val$visualizer1;
                private final List val$visualizer2;
                private final Set val$imports;
                private final BlockStorage val$storage;
                private final Set val$exports;
                private final Set val$terminals;
                private final Set val$destinations;
                private final Set val$providers;
                private static int $SWITCH_TABLE$me$mrCookieSlime$Slimefun$api$item_transport$ItemTransportFlow[];
                private final Map val$input;
                private final Map val$output;

                public void run()
                {
                    if(BlockStorage.getBlockInfo(b, "visualizer") == null)
                    {
                        for(int i = 0; i < visualizer1.size(); i++)
                        {
                            Location l1 = (Location)visualizer1.get(i);
                            Location l2 = (Location)visualizer2.get(i);
                            try
                            {
                                ParticleEffect.REDSTONE.drawLine(new Location(l1.getWorld(), (double)l1.getBlockX() + 0.5D, (double)l1.getBlockY() + 0.5D, (double)l1.getBlockZ() + 0.5D), new Location(l2.getWorld(), (double)l2.getBlockX() + 0.5D, (double)l2.getBlockY() + 0.5D, (double)l2.getBlockZ() + 0.5D));
                            }
                            catch(Exception e)
                            {
                                e.printStackTrace();
                            }
                        }

                    }
                    if(CargoNet.EXTRA_CHANNELS)
                    {
                        for(Iterator iterator1 = imports.iterator(); iterator1.hasNext();)
                        {
                            Location bus = (Location)iterator1.next();
                            BlockMenu menu = BlockStorage.getInventory(bus);
                            if(menu.getItemInSlot(17) == null)
                            {
                                Block target = CargoNet.getAttachedBlock(bus.getBlock());
                                ItemSlot stack = CargoManager.withdraw(bus.getBlock(), storage, target, -1);
                                if(stack != null)
                                    menu.replaceExistingItem(17, stack.getItem());
                            }
                            if(menu.getItemInSlot(17) != null)
                                CargoNet.requests.add(new ItemRequest(bus, 17, menu.getItemInSlot(17), ItemTransportFlow.INSERT));
                        }

                        for(Iterator iterator2 = exports.iterator(); iterator2.hasNext();)
                        {
                            Location bus = (Location)iterator2.next();
                            BlockMenu menu = BlockStorage.getInventory(bus);
                            if(menu.getItemInSlot(17) != null)
                            {
                                Block target = CargoNet.getAttachedBlock(bus.getBlock());
                                menu.replaceExistingItem(17, CargoManager.insert(bus.getBlock(), storage, target, menu.getItemInSlot(17), -1));
                            }
                            if(menu.getItemInSlot(17) == null)
                            {
                                List items = new ArrayList();
                                int ai[];
                                int k = (ai = CargoNet.slots).length;
                                for(int j = 0; j < k; j++)
                                {
                                    int slot = ai[j];
                                    ItemStack template = menu.getItemInSlot(slot);
                                    if(template != null)
                                        items.add(new CustomItem(template, 1));
                                }

                                if(!items.isEmpty())
                                {
                                    int index = Integer.parseInt(BlockStorage.getBlockInfo(bus, "index"));
                                    if(++index > items.size() - 1)
                                        index = 0;
                                    BlockStorage.addBlockInfo(bus, "index", String.valueOf(index));
                                    CargoNet.requests.add(new ItemRequest(bus, 17, (ItemStack)items.get(index), ItemTransportFlow.WITHDRAW));
                                }
                            }
                        }

                        for(Iterator iterator = CargoNet.requests.iterator(); iterator.hasNext();)
                        {
                            ItemRequest request = (ItemRequest)iterator.next();
                            if(terminals.contains(request.getTerminal()) || imports.contains(request.getTerminal()) || exports.contains(request.getTerminal()))
                            {
                                BlockMenu menu = BlockStorage.getInventory(request.getTerminal());
                                switch($SWITCH_TABLE$me$mrCookieSlime$Slimefun$api$item_transport$ItemTransportFlow()[request.getDirection().ordinal()])
                                {
                                default:
                                    break;

                                case 1: // '\001'
                                {
                                    ItemStack stack = request.getItem();
                                    for(Iterator iterator6 = destinations.iterator(); iterator6.hasNext();)
                                    {
                                        Location l = (Location)iterator6.next();
                                        Block target = CargoNet.getAttachedBlock(l.getBlock());
                                        stack = CargoManager.insert(l.getBlock(), storage, target, stack, -1);
                                        if(stack == null)
                                        {
                                            menu.replaceExistingItem(request.getSlot(), null);
                                            break;
                                        }
                                    }

                                    if(stack != null)
                                        menu.replaceExistingItem(request.getSlot(), stack);
                                    iterator.remove();
                                    break;
                                }

                                case 2: // '\002'
                                {
                                    int slot = request.getSlot();
                                    ItemStack prevStack = menu.getItemInSlot(slot);
                                    if(prevStack != null && (prevStack.getAmount() + request.getItem().getAmount() > prevStack.getMaxStackSize() || !SlimefunManager.isItemSimiliar(prevStack, new CustomItem(request.getItem(), 1), true, me.mrCookieSlime.Slimefun.Setup.SlimefunManager.DataType.ALWAYS)))
                                    {
                                        iterator.remove();
                                        break;
                                    }
                                    ItemStack stack = null;
                                    ItemStack requested = request.getItem();
                                    Iterator iterator7 = providers.iterator();
                                    while(iterator7.hasNext()) 
                                    {
                                        Location l = (Location)iterator7.next();
                                        Block target = CargoNet.getAttachedBlock(l.getBlock());
                                        ItemStack is = CargoManager.withdraw(l.getBlock(), storage, target, requested);
                                        if(is == null)
                                            continue;
                                        if(stack == null)
                                            stack = is;
                                        else
                                            stack = new CustomItem(stack, stack.getAmount() + is.getAmount());
                                        if(is.getAmount() == requested.getAmount())
                                            break;
                                        requested = new CustomItem(requested, requested.getAmount() - is.getAmount());
                                    }
                                    if(stack != null)
                                    {
                                        ItemStack prev = menu.getItemInSlot(slot);
                                        if(prev == null)
                                            menu.replaceExistingItem(slot, stack);
                                        else
                                            menu.replaceExistingItem(slot, new CustomItem(stack, stack.getAmount() + prev.getAmount()));
                                    }
                                    iterator.remove();
                                    break;
                                }
                                }
                            }
                        }

                    }
                    for(Iterator iterator3 = input.entrySet().iterator(); iterator3.hasNext();)
                    {
                        java.util.Map.Entry entry = (java.util.Map.Entry)iterator3.next();
                        Block inputTarget = CargoNet.getAttachedBlock(((Location)entry.getKey()).getBlock());
                        ItemStack stack = null;
                        int previousSlot = -1;
                        boolean roundrobin = BlockStorage.getBlockInfo((Location)entry.getKey(), "round-robin").equals("true");
                        if(inputTarget != null)
                        {
                            ItemSlot slot = CargoManager.withdraw(((Location)entry.getKey()).getBlock(), storage, inputTarget, Integer.parseInt(BlockStorage.getBlockInfo((Location)entry.getKey(), "index")));
                            if(slot != null)
                            {
                                stack = slot.getItem();
                                previousSlot = slot.getSlot();
                            }
                        }
                        if(stack != null && output.containsKey(entry.getValue()))
                        {
                            List outputlist = new ArrayList((Collection)output.get(entry.getValue()));
                            if(roundrobin)
                            {
                                if(!CargoNet.round_robin.containsKey(entry.getKey()))
                                    CargoNet.round_robin.put((Location)entry.getKey(), Integer.valueOf(0));
                                int c_index = ((Integer)CargoNet.round_robin.get(entry.getKey())).intValue();
                                if(c_index < outputlist.size())
                                {
                                    for(int i = 0; i < c_index; i++)
                                    {
                                        Location temp = (Location)outputlist.get(0);
                                        outputlist.remove(temp);
                                        outputlist.add(temp);
                                    }

                                    c_index++;
                                } else
                                {
                                    c_index = 1;
                                }
                                CargoNet.round_robin.put((Location)entry.getKey(), Integer.valueOf(c_index));
                            }
                            Iterator iterator8 = outputlist.iterator();
                            while(iterator8.hasNext()) 
                            {
                                Location out = (Location)iterator8.next();
                                Block target = CargoNet.getAttachedBlock(out.getBlock());
                                if(target == null)
                                    continue;
                                stack = CargoManager.insert(out.getBlock(), storage, target, stack, -1);
                                if(stack == null)
                                    break;
                            }
                        }
                        if(stack != null && previousSlot > -1)
                            if(storage.hasUniversalInventory(inputTarget))
                            {
                                UniversalBlockMenu menu = storage.getUniversalInventory(inputTarget);
                                menu.replaceExistingItem(previousSlot, stack);
                            } else
                            if(storage.hasInventory(inputTarget.getLocation()))
                            {
                                BlockMenu menu = BlockStorage.getInventory(inputTarget.getLocation());
                                menu.replaceExistingItem(previousSlot, stack);
                            } else
                            if(inputTarget.getState() instanceof InventoryHolder)
                            {
                                Inventory inv = ((InventoryHolder)inputTarget.getState()).getInventory();
                                inv.setItem(previousSlot, stack);
                            }
                    }

                    if(CargoNet.EXTRA_CHANNELS)
                    {
                        List items = new ArrayList();
                        for(Iterator iterator4 = providers.iterator(); iterator4.hasNext();)
                        {
                            Location l = (Location)iterator4.next();
                            Block target = CargoNet.getAttachedBlock(l.getBlock());
                            if(storage.hasUniversalInventory(target))
                            {
                                UniversalBlockMenu menu = storage.getUniversalInventory(target);
                                int ai1[];
                                int i2 = (ai1 = menu.getPreset().getSlotsAccessedByItemTransport(menu, ItemTransportFlow.WITHDRAW, null)).length;
                                for(int i1 = 0; i1 < i2; i1++)
                                {
                                    int slot = ai1[i1];
                                    ItemStack is = menu.getItemInSlot(slot);
                                    if(is != null && CargoManager.matchesFilter(l.getBlock(), is, -1))
                                    {
                                        boolean add = true;
                                        for(Iterator iterator10 = items.iterator(); iterator10.hasNext();)
                                        {
                                            StoredItem item = (StoredItem)iterator10.next();
                                            if(SlimefunManager.isItemSimiliar(is, item.getItem(), true, me.mrCookieSlime.Slimefun.Setup.SlimefunManager.DataType.ALWAYS))
                                            {
                                                add = false;
                                                item.add(is.getAmount());
                                            }
                                        }

                                        if(add)
                                            items.add(new StoredItem(new CustomItem(is, 1), is.getAmount()));
                                    }
                                }

                            } else
                            if(storage.hasInventory(target.getLocation()))
                            {
                                BlockMenu menu = BlockStorage.getInventory(target.getLocation());
                                if(BlockStorage.checkID(target.getLocation()).startsWith("BARREL_") && BlockStorage.getBlockInfo(target.getLocation(), "storedItems") != null)
                                {
                                    int stored = Integer.valueOf(BlockStorage.getBlockInfo(target.getLocation(), "storedItems")).intValue();
                                    int ai3[];
                                    int j3 = (ai3 = menu.getPreset().getSlotsAccessedByItemTransport(menu, ItemTransportFlow.WITHDRAW, null)).length;
                                    for(int j2 = 0; j2 < j3; j2++)
                                    {
                                        int slot = ai3[j2];
                                        ItemStack is = menu.getItemInSlot(slot);
                                        if(is != null && CargoManager.matchesFilter(l.getBlock(), is, -1))
                                        {
                                            boolean add = true;
                                            for(Iterator iterator13 = items.iterator(); iterator13.hasNext();)
                                            {
                                                StoredItem item = (StoredItem)iterator13.next();
                                                if(SlimefunManager.isItemSimiliar(is, item.getItem(), true, me.mrCookieSlime.Slimefun.Setup.SlimefunManager.DataType.ALWAYS))
                                                {
                                                    add = false;
                                                    item.add(is.getAmount() + stored);
                                                }
                                            }

                                            if(add)
                                                items.add(new StoredItem(new CustomItem(is, 1), is.getAmount() + stored));
                                        }
                                    }

                                } else
                                {
                                    int ai2[];
                                    int k2 = (ai2 = menu.getPreset().getSlotsAccessedByItemTransport(menu, ItemTransportFlow.WITHDRAW, null)).length;
                                    for(int j1 = 0; j1 < k2; j1++)
                                    {
                                        int slot = ai2[j1];
                                        ItemStack is = menu.getItemInSlot(slot);
                                        if(is != null && CargoManager.matchesFilter(l.getBlock(), is, -1))
                                        {
                                            boolean add = true;
                                            for(Iterator iterator11 = items.iterator(); iterator11.hasNext();)
                                            {
                                                StoredItem item = (StoredItem)iterator11.next();
                                                if(SlimefunManager.isItemSimiliar(is, item.getItem(), true, me.mrCookieSlime.Slimefun.Setup.SlimefunManager.DataType.ALWAYS))
                                                {
                                                    add = false;
                                                    item.add(is.getAmount());
                                                }
                                            }

                                            if(add)
                                                items.add(new StoredItem(new CustomItem(is, 1), is.getAmount()));
                                        }
                                    }

                                }
                            } else
                            if(target.getState() instanceof InventoryHolder)
                            {
                                Inventory inv = ((InventoryHolder)target.getState()).getInventory();
                                ItemStack aitemstack[];
                                int i3 = (aitemstack = inv.getContents()).length;
                                for(int k1 = 0; k1 < i3; k1++)
                                {
                                    ItemStack is = aitemstack[k1];
                                    if(is != null && CargoManager.matchesFilter(l.getBlock(), is, -1))
                                    {
                                        boolean add = true;
                                        for(Iterator iterator9 = items.iterator(); iterator9.hasNext();)
                                        {
                                            StoredItem item = (StoredItem)iterator9.next();
                                            if(SlimefunManager.isItemSimiliar(is, item.getItem(), true, me.mrCookieSlime.Slimefun.Setup.SlimefunManager.DataType.ALWAYS))
                                            {
                                                add = false;
                                                item.add(is.getAmount());
                                            }
                                        }

                                        if(add)
                                            items.add(new StoredItem(new CustomItem(is, 1), is.getAmount()));
                                    }
                                }

                            }
                        }

                        Collections.sort(items, CargoNet.sorter);
                        for(Iterator iterator5 = terminals.iterator(); iterator5.hasNext();)
                        {
                            final Location l = (Location)iterator5.next();
                            BlockMenu menu = BlockStorage.getInventory(l);
                            int page = Integer.parseInt(BlockStorage.getBlockInfo(l, "page"));
                            if(!items.isEmpty() && items.size() < (page - 1) * CargoNet.terminal_slots.length + 1)
                            {
                                page = 1;
                                BlockStorage.addBlockInfo(l, "page", String.valueOf(1));
                            }
                            for(int i = 0; i < CargoNet.terminal_slots.length; i++)
                            {
                                int slot = CargoNet.terminal_slots[i];
                                if(items.size() > i + CargoNet.terminal_slots.length * (page - 1))
                                {
                                    final StoredItem item = (StoredItem)items.get(i + CargoNet.terminal_slots.length * (page - 1));
                                    ItemStack stack = item.getItem().clone();
                                    ItemMeta im = stack.getItemMeta();
                                    List lore = new ArrayList();
                                    lore.add("");
                                    lore.add((new StringBuilder("&7Stored Items: &r")).append(DoubleHandler.getFancyDouble(item.getAmount())).toString());
                                    if(stack.getMaxStackSize() > 1)
                                        lore.add((new StringBuilder("&7<Left Click: Request 1 | Right Click: Request ")).append(item.getAmount() <= stack.getMaxStackSize() ? item.getAmount() : stack.getMaxStackSize()).append(">").toString());
                                    else
                                        lore.add("&7<Left Click: Request 1>");
                                    lore.add("");
                                    if(im.hasLore())
                                    {
                                        String line;
                                        for(Iterator iterator12 = im.getLore().iterator(); iterator12.hasNext(); lore.add(line))
                                            line = (String)iterator12.next();

                                    }
                                    im.setLore(lore);
                                    stack.setItemMeta(im);
                                    menu.replaceExistingItem(slot, stack);
                                    menu.addMenuClickHandler(slot, new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuClickHandler() {

                                        final _cls2 this$1;
                                        private final Location val$l;
                                        private final StoredItem val$item;

                                        public boolean onClick(Player p, int slot, ItemStack is, ClickAction action)
                                        {
                                            CargoNet.requests.add(new ItemRequest(l, 44, new CustomItem(item.getItem(), action.isRightClicked() ? item.getAmount() <= item.getItem().getMaxStackSize() ? item.getAmount() : item.getItem().getMaxStackSize() : 1), ItemTransportFlow.WITHDRAW));
                                            return false;
                                        }

                    
                    {
                        this$1 = _cls2.this;
                        l = location;
                        item = storeditem;
                        super();
                    }
                                    }
);
                                } else
                                {
                                    menu.replaceExistingItem(slot, CargoNet.terminal_noitem_item);
                                    menu.addMenuClickHandler(slot, CargoNet.terminal_noitem_handler);
                                }
                            }

                            ItemStack sent_item = menu.getItemInSlot(17);
                            if(sent_item != null)
                                CargoNet.requests.add(new ItemRequest(l, 17, sent_item, ItemTransportFlow.INSERT));
                        }

                    }
                    CargoHologram.update(b, "&7Status: &a&lONLINE");
                }

                static int[] $SWITCH_TABLE$me$mrCookieSlime$Slimefun$api$item_transport$ItemTransportFlow()
                {
                    $SWITCH_TABLE$me$mrCookieSlime$Slimefun$api$item_transport$ItemTransportFlow;
                    if($SWITCH_TABLE$me$mrCookieSlime$Slimefun$api$item_transport$ItemTransportFlow == null) goto _L2; else goto _L1
_L1:
                    return;
_L2:
                    JVM INSTR pop ;
                    int ai[] = new int[ItemTransportFlow.values().length];
                    try
                    {
                        ai[ItemTransportFlow.INSERT.ordinal()] = 1;
                    }
                    catch(NoSuchFieldError _ex) { }
                    try
                    {
                        ai[ItemTransportFlow.WITHDRAW.ordinal()] = 2;
                    }
                    catch(NoSuchFieldError _ex) { }
                    return $SWITCH_TABLE$me$mrCookieSlime$Slimefun$api$item_transport$ItemTransportFlow = ai;
                }

            
            {
                b = block;
                visualizer1 = list;
                visualizer2 = list1;
                imports = set;
                storage = blockstorage;
                exports = set1;
                terminals = set2;
                destinations = set3;
                providers = set4;
                input = map;
                output = map1;
                super();
            }
            }
);
        }
    }

    private static Block getAttachedBlock(Block block)
    {
        if(block.getData() == 2)
            return block.getRelative(BlockFace.SOUTH);
        if(block.getData() == 3)
            return block.getRelative(BlockFace.NORTH);
        if(block.getData() == 4)
            return block.getRelative(BlockFace.EAST);
        if(block.getData() == 5)
            return block.getRelative(BlockFace.WEST);
        else
            return null;
    }

    private static int getFrequency(Location l)
    {
        return BlockStorage.getBlockInfo(l).getInt("frequency");
    }

    public static Set scan(Location source, Set blocks, List l1, List l2, Axis exclude, Map input, Map output, Set terminals, 
            Set providers, Set destinations, Set imports, Set exports)
    {
        if(!exclude.equals(Axis.X_POSITIVE))
        {
            for(int i = 0; i <= 5; i++)
            {
                Location l = new Location(source.getWorld(), source.getX() + (double)i + 1.0D, source.getY(), source.getZ());
                if(!continueScan(source, l, l1, l2, Axis.X_NEGATIVE, blocks, input, output, terminals, providers, destinations, imports, exports))
                    return new HashSet();
            }

        }
        if(!exclude.equals(Axis.X_NEGATIVE))
        {
            for(int i = 0; i <= 5; i++)
            {
                Location l = new Location(source.getWorld(), source.getX() - (double)i - 1.0D, source.getY(), source.getZ());
                if(!continueScan(source, l, l1, l2, Axis.X_POSITIVE, blocks, input, output, terminals, providers, destinations, imports, exports))
                    return new HashSet();
            }

        }
        if(!exclude.equals(Axis.Y_POSITIVE))
        {
            for(int i = 0; i <= 5; i++)
            {
                Location l = new Location(source.getWorld(), source.getX(), source.getY() + (double)i + 1.0D, source.getZ());
                if(!continueScan(source, l, l1, l2, Axis.Y_NEGATIVE, blocks, input, output, terminals, providers, destinations, imports, exports))
                    return new HashSet();
            }

        }
        if(!exclude.equals(Axis.Y_NEGATIVE))
        {
            for(int i = 0; i <= 5; i++)
            {
                Location l = new Location(source.getWorld(), source.getX(), source.getY() - (double)i - 1.0D, source.getZ());
                if(!continueScan(source, l, l1, l2, Axis.Y_POSITIVE, blocks, input, output, terminals, providers, destinations, imports, exports))
                    return new HashSet();
            }

        }
        if(!exclude.equals(Axis.Z_POSITIVE))
        {
            for(int i = 0; i <= 5; i++)
            {
                Location l = new Location(source.getWorld(), source.getX(), source.getY(), source.getZ() + (double)i + 1.0D);
                if(!continueScan(source, l, l1, l2, Axis.Z_NEGATIVE, blocks, input, output, terminals, providers, destinations, imports, exports))
                    return new HashSet();
            }

        }
        if(!exclude.equals(Axis.Z_NEGATIVE))
        {
            for(int i = 0; i <= 5; i++)
            {
                Location l = new Location(source.getWorld(), source.getX(), source.getY(), source.getZ() - (double)i - 1.0D);
                if(!continueScan(source, l, l1, l2, Axis.Z_POSITIVE, blocks, input, output, terminals, providers, destinations, imports, exports))
                    return new HashSet();
            }

        }
        return blocks;
    }

    private static boolean continueScan(Location source, Location l, List l1, List l2, Axis axis, Set blocks, Map input, Map output, 
            Set terminals, Set providers, Set destinations, Set imports, Set exports)
    {
        if(!blocks.contains(l))
        {
            String id = BlockStorage.checkID(l);
            if(id == null)
                return true;
            if(id.equals("CARGO_MANAGER"))
                return false;
            if(id.equals("CARGO_NODE"))
            {
                blocks.add(l);
                l1.add(source);
                l2.add(l);
                scan(l, blocks, l1, l2, axis, input, output, terminals, providers, destinations, imports, exports);
                if(blocks.isEmpty())
                    return false;
            } else
            if(id.equals("CARGO_NODE_INPUT"))
            {
                blocks.add(l);
                l1.add(source);
                l2.add(l);
                int freq = getFrequency(l);
                if(freq == 16)
                    providers.add(l);
                else
                    input.put(l, Integer.valueOf(freq));
            } else
            if(id.equals("CHEST_TERMINAL"))
            {
                blocks.add(l);
                l1.add(source);
                l2.add(l);
                terminals.add(l);
            } else
            if(id.equals("CT_IMPORT_BUS"))
            {
                blocks.add(l);
                l1.add(source);
                l2.add(l);
                imports.add(l);
            } else
            if(id.equals("CT_EXPORT_BUS"))
            {
                blocks.add(l);
                l1.add(source);
                l2.add(l);
                exports.add(l);
            } else
            if(id.equals("CARGO_NODE_OUTPUT"))
            {
                blocks.add(l);
                l1.add(source);
                l2.add(l);
                int freq = getFrequency(l);
                if(freq == 16)
                {
                    destinations.add(l);
                } else
                {
                    List list = ((List) (output.containsKey(Integer.valueOf(freq)) ? (List)output.get(Integer.valueOf(freq)) : ((List) (new ArrayList()))));
                    list.add(l);
                    output.put(Integer.valueOf(freq), list);
                }
            } else
            if(id.equals("CARGO_NODE_OUTPUT_ADVANCED"))
            {
                blocks.add(l);
                l1.add(source);
                l2.add(l);
                int freq = getFrequency(l);
                if(freq == 16)
                {
                    destinations.add(l);
                } else
                {
                    List list = ((List) (output.containsKey(Integer.valueOf(freq)) ? (List)output.get(Integer.valueOf(freq)) : ((List) (new ArrayList()))));
                    list.add(l);
                    output.put(Integer.valueOf(freq), list);
                }
            }
        }
        return true;
    }

    public static boolean isConnected(Block b)
    {
        return passiveScan(b.getLocation(), Axis.UNKNOWN, new HashSet());
    }

    private static boolean passiveScan(Location source, Axis exclude, Set sources)
    {
        sources.add(source);
        Set blocks = new HashSet();
        blocks.add(source);
        if(!exclude.equals(Axis.X_POSITIVE))
        {
            for(int i = 0; i <= 5; i++)
            {
                Location l = new Location(source.getWorld(), source.getX() + (double)i + 1.0D, source.getY(), source.getZ());
                if(continuePassiveScan(l, Axis.X_NEGATIVE, sources))
                    return true;
            }

        }
        if(!exclude.equals(Axis.X_NEGATIVE))
        {
            for(int i = 0; i <= 5; i++)
            {
                Location l = new Location(source.getWorld(), source.getX() - (double)i - 1.0D, source.getY(), source.getZ());
                if(continuePassiveScan(l, Axis.X_POSITIVE, sources))
                    return true;
            }

        }
        if(!exclude.equals(Axis.Y_POSITIVE))
        {
            for(int i = 0; i <= 5; i++)
            {
                Location l = new Location(source.getWorld(), source.getX(), source.getY() + (double)i + 1.0D, source.getZ());
                if(continuePassiveScan(l, Axis.Y_NEGATIVE, sources))
                    return true;
            }

        }
        if(!exclude.equals(Axis.Y_NEGATIVE))
        {
            for(int i = 0; i <= 5; i++)
            {
                Location l = new Location(source.getWorld(), source.getX(), source.getY() - (double)i - 1.0D, source.getZ());
                if(continuePassiveScan(l, Axis.Y_POSITIVE, sources))
                    return true;
            }

        }
        if(!exclude.equals(Axis.Z_POSITIVE))
        {
            for(int i = 0; i <= 5; i++)
            {
                Location l = new Location(source.getWorld(), source.getX(), source.getY(), source.getZ() + (double)i + 1.0D);
                if(continuePassiveScan(l, Axis.Z_NEGATIVE, sources))
                    return true;
            }

        }
        if(!exclude.equals(Axis.Z_NEGATIVE))
        {
            for(int i = 0; i <= 5; i++)
            {
                Location l = new Location(source.getWorld(), source.getX(), source.getY(), source.getZ() - (double)i - 1.0D);
                if(continuePassiveScan(l, Axis.Z_POSITIVE, sources))
                    return true;
            }

        }
        return false;
    }

    private static boolean continuePassiveScan(Location l, Axis axis, Set sources)
    {
        if(!sources.contains(l))
        {
            String id = BlockStorage.checkID(l);
            if(id == null)
                return false;
            if(id.equals("CARGO_MANAGER"))
                return true;
            if(id.equals("CARGO_NODE"))
                return passiveScan(l, axis, sources);
        }
        return false;
    }

    static 
    {
        faces = Arrays.asList(new BlockFace[] {
            BlockFace.NORTH, BlockFace.EAST, BlockFace.SOUTH, BlockFace.WEST
        });
        terminal_noitem_item = new CustomItem(new MaterialData(Material.BARRIER), "&4\u65E0\u7269\u54C1\u7F13\u5B58", new String[0]);
    }





}

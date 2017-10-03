// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   AReactor.java

package me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems;

import java.util.*;
import me.mrCookieSlime.CSCoreLibPlugin.CSCoreLib;
import me.mrCookieSlime.CSCoreLibPlugin.Configuration.Config;
import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.*;
import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.Item.CustomItem;
import me.mrCookieSlime.CSCoreLibPlugin.general.World.CustomSkull;
import me.mrCookieSlime.CSCoreLibPlugin.protection.ProtectionManager;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Lists.SlimefunItems;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.Objects.SlimefunBlockHandler;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.UnregisterReason;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.handlers.ItemHandler;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.machines.ReactorAccessPort;
import me.mrCookieSlime.Slimefun.Setup.SlimefunManager;
import me.mrCookieSlime.Slimefun.SlimefunStartup;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import me.mrCookieSlime.Slimefun.api.energy.ChargableBlock;
import me.mrCookieSlime.Slimefun.api.energy.EnergyTicker;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenuPreset;
import me.mrCookieSlime.Slimefun.api.item_transport.ItemTransportFlow;
import me.mrCookieSlime.Slimefun.holograms.ReactorHologram;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.material.MaterialData;
import org.bukkit.scheduler.BukkitScheduler;

// Referenced classes of package me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems:
//            MachineFuel, MachineHelper

public abstract class AReactor extends SlimefunItem
{

    public static Map processing = new HashMap();
    public static Map progress = new HashMap();
    private static final BlockFace cooling[];
    private Set recipes;
    private static final int border[] = {
        0, 1, 2, 3, 5, 6, 7, 8, 12, 13, 
        14, 21, 23
    };
    private static final int border_1[] = {
        9, 10, 11, 18, 20, 27, 29, 36, 38, 45, 
        46, 47
    };
    private static final int border_2[] = {
        15, 16, 17, 24, 26, 33, 35, 42, 44, 51, 
        52, 53
    };
    private static final int border_3[] = {
        30, 31, 32, 39, 41, 48, 49, 50
    };
    private static final int border_4[] = {
        25, 34, 43
    };

    public AReactor(Category category, ItemStack item, String name, RecipeType recipeType, ItemStack recipe[])
    {
        super(category, item, name, recipeType, recipe);
        recipes = new HashSet();
        new BlockMenuPreset(name, getInventoryTitle()) {

            final AReactor this$0;

            public void init()
            {
                constructMenu(this);
            }

            public void newInstance(final BlockMenu menu, final Block b)
            {
                try
                {
                    if(BlockStorage.getBlockInfo(b, "reactor-mode") == null)
                        BlockStorage.addBlockInfo(b, "reactor-mode", "generator");
                    if(!BlockStorage.hasBlockInfo(b) || BlockStorage.getBlockInfo(b, "reactor-mode").equals("generator"))
                    {
                        menu.replaceExistingItem(4, new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOTM0M2NlNThkYTU0Yzc5OTI0YTJjOTMzMWNmYzQxN2ZlOGNjYmJlYTliZTQ1YTdhYzg1ODYwYTZjNzMwIn19fQ=="), "&7Focus: &eElectricity", new String[] {
                            "", "&6Your Reactor will focus on Power Generation", "&6If your Energy Network doesn't need Power", "&6it will not produce any either", "", "&7> Click to change the Focus to &eProduction"
                        }));
                        menu.addMenuClickHandler(4, new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuClickHandler() {

                            final _cls1 this$1;
                            private final Block val$b;
                            private final BlockMenu val$menu;

                            public boolean onClick(Player p, int arg1, ItemStack arg2, ClickAction arg3)
                            {
                                BlockStorage.addBlockInfo(b, "reactor-mode", "production");
                                newInstance(menu, b);
                                return false;
                            }

                    
                    {
                        this$1 = _cls1.this;
                        b = block;
                        menu = blockmenu;
                        super();
                    }
                        }
);
                    } else
                    {
                        menu.replaceExistingItem(4, new CustomItem(SlimefunItems.PLUTONIUM, "&7Focus: &eProduction", new String[] {
                            "", "&6Your Reactor will focus on producing goods", "&6If your Energy Network doesn't need Power", "&6it will continue to run and simply will", "&6not generate any Power in the mean time", "", "&7> Click to change the Focus to &ePower Generation"
                        }));
                        menu.addMenuClickHandler(4, new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuClickHandler() {

                            final _cls1 this$1;
                            private final Block val$b;
                            private final BlockMenu val$menu;

                            public boolean onClick(Player p, int arg1, ItemStack arg2, ClickAction arg3)
                            {
                                BlockStorage.addBlockInfo(b, "reactor-mode", "generator");
                                newInstance(menu, b);
                                return false;
                            }

                    
                    {
                        this$1 = _cls1.this;
                        b = block;
                        menu = blockmenu;
                        super();
                    }
                        }
);
                    }
                }
                catch(Exception exception) { }
            }

            public boolean canOpen(Block b, Player p)
            {
                return p.hasPermission("slimefun.inventory.bypass") || CSCoreLib.getLib().getProtectionManager().canAccessChest(p.getUniqueId(), b, true);
            }

            public int[] getSlotsAccessedByItemTransport(ItemTransportFlow flow)
            {
                return new int[0];
            }

            
            {
                this$0 = AReactor.this;
                super($anonymous0, $anonymous1);
            }
        }
;
        registerBlockHandler(name, new SlimefunBlockHandler() {

            final AReactor this$0;

            public void onPlace(Player player, Block block, SlimefunItem slimefunitem)
            {
            }

            public boolean onBreak(Player p, Block b, SlimefunItem item, UnregisterReason reason)
            {
                BlockMenu inv = BlockStorage.getInventory(b);
                if(inv != null)
                {
                    int ai[];
                    int l = (ai = getFuelSlots()).length;
                    for(int i = 0; i < l; i++)
                    {
                        int slot = ai[i];
                        if(inv.getItemInSlot(slot) != null)
                            b.getWorld().dropItemNaturally(b.getLocation(), inv.getItemInSlot(slot));
                    }

                    l = (ai = getCoolantSlots()).length;
                    for(int j = 0; j < l; j++)
                    {
                        int slot = ai[j];
                        if(inv.getItemInSlot(slot) != null)
                            b.getWorld().dropItemNaturally(b.getLocation(), inv.getItemInSlot(slot));
                    }

                    l = (ai = getOutputSlots()).length;
                    for(int k = 0; k < l; k++)
                    {
                        int slot = ai[k];
                        if(inv.getItemInSlot(slot) != null)
                            b.getWorld().dropItemNaturally(b.getLocation(), inv.getItemInSlot(slot));
                    }

                }
                AReactor.progress.remove(b.getLocation());
                AReactor.processing.remove(b.getLocation());
                ReactorHologram.remove(b.getLocation());
                return true;
            }

            
            {
                this$0 = AReactor.this;
                super();
            }
        }
);
        registerDefaultRecipes();
    }

    private void constructMenu(BlockMenuPreset preset)
    {
        int ai[];
        int k1 = (ai = border).length;
        for(int j = 0; j < k1; j++)
        {
            int i = ai[j];
            preset.addItem(i, new CustomItem(new MaterialData(Material.STAINED_GLASS_PANE, (byte)7), " ", new String[0]), new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuClickHandler() {

                final AReactor this$0;

                public boolean onClick(Player arg0, int arg1, ItemStack arg2, ClickAction clickaction)
                {
                    return false;
                }

            
            {
                this$0 = AReactor.this;
                super();
            }
            }
);
        }

        k1 = (ai = border_1).length;
        for(int k = 0; k < k1; k++)
        {
            int i = ai[k];
            preset.addItem(i, new CustomItem(new MaterialData(Material.STAINED_GLASS_PANE, (byte)5), " ", new String[0]), new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuClickHandler() {

                final AReactor this$0;

                public boolean onClick(Player arg0, int arg1, ItemStack arg2, ClickAction clickaction)
                {
                    return false;
                }

            
            {
                this$0 = AReactor.this;
                super();
            }
            }
);
        }

        k1 = (ai = border_3).length;
        for(int l = 0; l < k1; l++)
        {
            int i = ai[l];
            preset.addItem(i, new CustomItem(new MaterialData(Material.STAINED_GLASS_PANE, (byte)13), " ", new String[0]), new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuClickHandler() {

                final AReactor this$0;

                public boolean onClick(Player arg0, int arg1, ItemStack arg2, ClickAction clickaction)
                {
                    return false;
                }

            
            {
                this$0 = AReactor.this;
                super();
            }
            }
);
        }

        preset.addItem(22, new CustomItem(new MaterialData(Material.STAINED_GLASS_PANE, (byte)15), " ", new String[0]), new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuClickHandler() {

            final AReactor this$0;

            public boolean onClick(Player arg0, int arg1, ItemStack arg2, ClickAction clickaction)
            {
                return false;
            }

            
            {
                this$0 = AReactor.this;
                super();
            }
        }
);
        preset.addItem(1, new CustomItem(SlimefunItems.URANIUM, "&7Fuel Slot", new String[] {
            "", "&rThis Slot accepts radioactive Fuel such as:", "&2Uranium &ror &aNeptunium"
        }), new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuClickHandler() {

            final AReactor this$0;

            public boolean onClick(Player arg0, int arg1, ItemStack arg2, ClickAction clickaction)
            {
                return false;
            }

            
            {
                this$0 = AReactor.this;
                super();
            }
        }
);
        k1 = (ai = border_2).length;
        for(int i1 = 0; i1 < k1; i1++)
        {
            int i = ai[i1];
            preset.addItem(i, new CustomItem(new MaterialData(Material.STAINED_GLASS_PANE, (byte)9), " ", new String[0]), new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuClickHandler() {

                final AReactor this$0;

                public boolean onClick(Player arg0, int arg1, ItemStack arg2, ClickAction clickaction)
                {
                    return false;
                }

            
            {
                this$0 = AReactor.this;
                super();
            }
            }
);
        }

        if(needsCooling())
        {
            preset.addItem(7, new CustomItem(getCoolant(), "&bCoolant Slot", new String[] {
                "", "&rThis Slot accepts Coolant Cells", "&4Without any Coolant Cells, your Reactor", "&4will explode"
            }));
        } else
        {
            preset.addItem(7, new CustomItem(new MaterialData(Material.BARRIER), "&bCoolant Slot", new String[] {
                "", "&rThis Slot accepts Coolant Cells"
            }));
            int ai1[];
            int l1 = (ai1 = border_4).length;
            for(int j1 = 0; j1 < l1; j1++)
            {
                int i = ai1[j1];
                preset.addItem(i, new CustomItem(new ItemStack(Material.BARRIER), "&cNo Coolant Required"), new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuClickHandler() {

                    final AReactor this$0;

                    public boolean onClick(Player player, int i, ItemStack itemStack, ClickAction clickaction)
                    {
                        return false;
                    }

            
            {
                this$0 = AReactor.this;
                super();
            }
                }
);
            }

        }
    }

    public abstract String getInventoryTitle();

    public abstract void registerDefaultRecipes();

    public abstract int getEnergyProduction();

    public abstract void extraTick(Location location);

    public abstract ItemStack getCoolant();

    public boolean needsCooling()
    {
        return getCoolant() != null;
    }

    public int[] getInputSlots()
    {
        return (new int[] {
            19, 28, 37, 25, 34, 43
        });
    }

    public int[] getFuelSlots()
    {
        return (new int[] {
            19, 28, 37
        });
    }

    public int[] getCoolantSlots()
    {
        return needsCooling() ? (new int[] {
            25, 34, 43
        }) : new int[0];
    }

    public int[] getOutputSlots()
    {
        return (new int[] {
            40
        });
    }

    public MachineFuel getProcessing(Location l)
    {
        return (MachineFuel)processing.get(l);
    }

    public boolean isProcessing(Location l)
    {
        return progress.containsKey(l);
    }

    public void registerFuel(MachineFuel fuel)
    {
        recipes.add(fuel);
    }

    public void register(boolean slimefun)
    {
        addItemHandler(new ItemHandler[] {
            new EnergyTicker() {

                Set explode;
                final AReactor this$0;

                public double generateEnergy(final Location l, SlimefunItem sf, Config data)
                {
                    BlockMenu port = getAccessPort(l);
                    if(isProcessing(l))
                    {
                        extraTick(l);
                        int timeleft = ((Integer)AReactor.progress.get(l)).intValue();
                        if(timeleft > 0)
                        {
                            if(ChargableBlock.getMaxCharge(l) - ChargableBlock.getCharge(l) >= getEnergyProduction())
                                ChargableBlock.addCharge(l, getEnergyProduction());
                            if(ChargableBlock.getMaxCharge(l) - ChargableBlock.getCharge(l) >= getEnergyProduction() || !BlockStorage.getBlockInfo(l, "reactor-mode").equals("generator"))
                            {
                                AReactor.progress.put(l, Integer.valueOf(timeleft - 1));
                                Bukkit.getScheduler().scheduleSyncDelayedTask(SlimefunStartup.instance, new Runnable() {

                                    final _cls10 this$1;
                                    private final Location val$l;

                                    public void run()
                                    {
                                        if(!l.getBlock().getRelative(AReactor.cooling[CSCoreLib.randomizer().nextInt(AReactor.cooling.length)]).isLiquid())
                                            explode.add(l);
                                    }

                    
                    {
                        this$1 = _cls10.this;
                        l = location;
                        super();
                    }
                                }
);
                                ItemStack item = getProgressBar().clone();
                                ItemMeta im = item.getItemMeta();
                                im.setDisplayName(" ");
                                List lore = new ArrayList();
                                lore.add(MachineHelper.getProgress(timeleft, ((MachineFuel)AReactor.processing.get(l)).getTicks()));
                                lore.add(MachineHelper.getCoolant(timeleft, ((MachineFuel)AReactor.processing.get(l)).getTicks()));
                                lore.add("");
                                lore.add(MachineHelper.getTimeLeft(timeleft / 2));
                                im.setLore(lore);
                                item.setItemMeta(im);
                                BlockStorage.getInventory(l).replaceExistingItem(22, item);
                                if(needsCooling())
                                {
                                    boolean coolant = (((MachineFuel)AReactor.processing.get(l)).getTicks() - timeleft) % 25 == 0;
                                    if(coolant)
                                    {
                                        if(port != null)
                                        {
                                            int ai3[];
                                            int i2 = (ai3 = getCoolantSlots()).length;
                                            for(int k1 = 0; k1 < i2; k1++)
                                            {
                                                int slot = ai3[k1];
                                                if(SlimefunManager.isItemSimiliar(port.getItemInSlot(slot), getCoolant(), true))
                                                    port.replaceExistingItem(slot, pushItems(l, port.getItemInSlot(slot), getCoolantSlots()));
                                            }

                                        }
                                        boolean explosion = true;
                                        int ai4[];
                                        int k2 = (ai4 = getCoolantSlots()).length;
                                        for(int j2 = 0; j2 < k2; j2++)
                                        {
                                            int slot = ai4[j2];
                                            if(!SlimefunManager.isItemSimiliar(BlockStorage.getInventory(l).getItemInSlot(slot), getCoolant(), true))
                                                continue;
                                            BlockStorage.getInventory(l).replaceExistingItem(slot, InvUtils.decreaseItem(BlockStorage.getInventory(l).getItemInSlot(slot), 1));
                                            ReactorHologram.update(l, "&b\u2744 &7100%");
                                            explosion = false;
                                            break;
                                        }

                                        if(explosion)
                                        {
                                            explode.add(l);
                                            return 0.0D;
                                        }
                                    } else
                                    {
                                        ReactorHologram.update(l, (new StringBuilder("&b\u2744 &7")).append(MachineHelper.getPercentage(timeleft, ((MachineFuel)AReactor.processing.get(l)).getTicks())).append("%").toString());
                                    }
                                }
                                return (double)ChargableBlock.getCharge(l);
                            } else
                            {
                                return 0.0D;
                            }
                        }
                        BlockStorage.getInventory(l).replaceExistingItem(22, new CustomItem(new MaterialData(Material.STAINED_GLASS_PANE, (byte)15), " ", new String[0]));
                        if(((MachineFuel)AReactor.processing.get(l)).getOutput() != null)
                            pushItems(l, ((MachineFuel)AReactor.processing.get(l)).getOutput());
                        if(port != null)
                        {
                            int ai[];
                            int j = (ai = getOutputSlots()).length;
                            for(int i = 0; i < j; i++)
                            {
                                int slot = ai[i];
                                if(BlockStorage.getInventory(l).getItemInSlot(slot) != null)
                                    BlockStorage.getInventory(l).replaceExistingItem(slot, ReactorAccessPort.pushItems(port.getLocation(), BlockStorage.getInventory(l).getItemInSlot(slot)));
                            }

                        }
                        AReactor.progress.remove(l);
                        AReactor.processing.remove(l);
                        return 0.0D;
                    }
                    MachineFuel r = null;
                    Map found = new HashMap();
                    if(port != null)
                    {
                        int ai1[];
                        int i1 = (ai1 = getFuelSlots()).length;
label0:
                        for(int k = 0; k < i1; k++)
                        {
                            int slot = ai1[k];
                            for(Iterator iterator2 = recipes.iterator(); iterator2.hasNext();)
                            {
                                MachineFuel recipe = (MachineFuel)iterator2.next();
                                if(SlimefunManager.isItemSimiliar(port.getItemInSlot(slot), recipe.getInput(), true) && pushItems(l, new CustomItem(port.getItemInSlot(slot), 1), getFuelSlots()) == null)
                                {
                                    port.replaceExistingItem(slot, InvUtils.decreaseItem(port.getItemInSlot(slot), 1));
                                    break label0;
                                }
                            }

                        }

                    }
label1:
                    for(Iterator iterator = recipes.iterator(); iterator.hasNext();)
                    {
                        MachineFuel recipe = (MachineFuel)iterator.next();
                        int ai2[];
                        int l1 = (ai2 = getFuelSlots()).length;
                        for(int j1 = 0; j1 < l1; j1++)
                        {
                            int slot = ai2[j1];
                            if(!SlimefunManager.isItemSimiliar(BlockStorage.getInventory(l).getItemInSlot(slot), recipe.getInput(), true))
                                continue;
                            found.put(Integer.valueOf(slot), Integer.valueOf(recipe.getInput().getAmount()));
                            r = recipe;
                            break label1;
                        }

                    }

                    if(r != null)
                    {
                        java.util.Map.Entry entry;
                        for(Iterator iterator1 = found.entrySet().iterator(); iterator1.hasNext(); BlockStorage.getInventory(l).replaceExistingItem(((Integer)entry.getKey()).intValue(), InvUtils.decreaseItem(BlockStorage.getInventory(l).getItemInSlot(((Integer)entry.getKey()).intValue()), ((Integer)entry.getValue()).intValue())))
                            entry = (java.util.Map.Entry)iterator1.next();

                        AReactor.processing.put(l, r);
                        AReactor.progress.put(l, Integer.valueOf(r.getTicks()));
                    }
                    return 0.0D;
                }

                public boolean explode(final Location l)
                {
                    boolean explosion = explode.contains(l);
                    if(explosion)
                    {
                        BlockStorage.getInventory(l).close();
                        Bukkit.getScheduler().scheduleSyncDelayedTask(SlimefunStartup.instance, new Runnable() {

                            final _cls10 this$1;
                            private final Location val$l;

                            public void run()
                            {
                                ReactorHologram.remove(l);
                            }

                    
                    {
                        this$1 = _cls10.this;
                        l = location;
                        super();
                    }
                        }
, 0L);
                        explode.remove(l);
                        AReactor.processing.remove(l);
                        AReactor.progress.remove(l);
                    }
                    return explosion;
                }

            
            {
                this$0 = AReactor.this;
                super();
                explode = new HashSet();
            }
            }

        });
        super.register(slimefun);
    }

    private Inventory inject(Location l)
    {
        int size = BlockStorage.getInventory(l).toInventory().getSize();
        Inventory inv = Bukkit.createInventory(null, size);
        for(int i = 0; i < size; i++)
            inv.setItem(i, new CustomItem(Material.COMMAND, " &4ALL YOUR PLACEHOLDERS ARE BELONG TO US", 0));

        int ai[];
        int k = (ai = getOutputSlots()).length;
        for(int j = 0; j < k; j++)
        {
            int slot = ai[j];
            inv.setItem(slot, BlockStorage.getInventory(l).getItemInSlot(slot));
        }

        return inv;
    }

    private Inventory inject(Location l, int slots[])
    {
        int size = BlockStorage.getInventory(l).toInventory().getSize();
        Inventory inv = Bukkit.createInventory(null, size);
        for(int i = 0; i < size; i++)
            inv.setItem(i, new CustomItem(Material.COMMAND, " &4ALL YOUR PLACEHOLDERS ARE BELONG TO US", 0));

        int ai[];
        int k = (ai = slots).length;
        for(int j = 0; j < k; j++)
        {
            int slot = ai[j];
            inv.setItem(slot, BlockStorage.getInventory(l).getItemInSlot(slot));
        }

        return inv;
    }

    public void pushItems(Location l, ItemStack item)
    {
        Inventory inv = inject(l);
        inv.addItem(new ItemStack[] {
            item
        });
        int ai[];
        int j = (ai = getOutputSlots()).length;
        for(int i = 0; i < j; i++)
        {
            int slot = ai[i];
            BlockStorage.getInventory(l).replaceExistingItem(slot, inv.getItem(slot));
        }

    }

    public ItemStack pushItems(Location l, ItemStack item, int slots[])
    {
        Inventory inv = inject(l, slots);
        Map map = inv.addItem(new ItemStack[] {
            item
        });
        int ai[];
        int j = (ai = slots).length;
        for(int i = 0; i < j; i++)
        {
            int slot = ai[i];
            BlockStorage.getInventory(l).replaceExistingItem(slot, inv.getItem(slot));
        }

        Iterator iterator = map.entrySet().iterator();
        if(iterator.hasNext())
        {
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
            return (ItemStack)entry.getValue();
        } else
        {
            return null;
        }
    }

    public abstract ItemStack getProgressBar();

    public Set getFuelTypes()
    {
        return recipes;
    }

    public BlockMenu getAccessPort(Location l)
    {
        Location portL = new Location(l.getWorld(), l.getX(), l.getY() + 3D, l.getZ());
        if(BlockStorage.check(portL, "REACTOR_ACCESS_PORT"))
            return BlockStorage.getInventory(portL);
        else
            return null;
    }

    static 
    {
        cooling = (new BlockFace[] {
            BlockFace.NORTH, BlockFace.NORTH_EAST, BlockFace.EAST, BlockFace.SOUTH_EAST, BlockFace.SOUTH, BlockFace.SOUTH_WEST, BlockFace.WEST, BlockFace.NORTH_WEST
        });
    }



}

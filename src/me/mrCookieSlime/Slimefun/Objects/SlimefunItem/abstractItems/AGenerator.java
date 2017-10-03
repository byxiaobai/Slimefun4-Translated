// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   AGenerator.java

package me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems;

import java.util.*;
import me.mrCookieSlime.CSCoreLibPlugin.CSCoreLib;
import me.mrCookieSlime.CSCoreLibPlugin.Configuration.Config;
import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.*;
import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.Item.CustomItem;
import me.mrCookieSlime.CSCoreLibPlugin.protection.ProtectionManager;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Lists.SlimefunItems;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.Objects.SlimefunBlockHandler;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.UnregisterReason;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.handlers.ItemHandler;
import me.mrCookieSlime.Slimefun.Setup.SlimefunManager;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import me.mrCookieSlime.Slimefun.api.energy.ChargableBlock;
import me.mrCookieSlime.Slimefun.api.energy.EnergyTicker;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenuPreset;
import me.mrCookieSlime.Slimefun.api.item_transport.ItemTransportFlow;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.material.MaterialData;

// Referenced classes of package me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems:
//            MachineFuel, MachineHelper

public abstract class AGenerator extends SlimefunItem
{

    public static Map processing = new HashMap();
    public static Map progress = new HashMap();
    private Set recipes;
    private static final int border[] = {
        0, 1, 2, 3, 4, 5, 6, 7, 8, 13, 
        31, 36, 37, 38, 39, 40, 41, 42, 43, 44
    };
    private static final int border_in[] = {
        9, 10, 11, 12, 18, 21, 27, 28, 29, 30
    };
    private static final int border_out[] = {
        14, 15, 16, 17, 23, 26, 32, 33, 34, 35
    };

    public AGenerator(Category category, ItemStack item, String name, RecipeType recipeType, ItemStack recipe[])
    {
        super(category, item, name, recipeType, recipe);
        recipes = new HashSet();
        new BlockMenuPreset(name, getInventoryTitle()) {

            final AGenerator this$0;

            public void init()
            {
                constructMenu(this);
            }

            public void newInstance(BlockMenu blockmenu, Block block)
            {
            }

            public boolean canOpen(Block b, Player p)
            {
                return p.hasPermission("slimefun.inventory.bypass") || CSCoreLib.getLib().getProtectionManager().canAccessChest(p.getUniqueId(), b, true);
            }

            public int[] getSlotsAccessedByItemTransport(ItemTransportFlow flow)
            {
                if(flow.equals(ItemTransportFlow.INSERT))
                    return getInputSlots();
                else
                    return getOutputSlots();
            }

            
            {
                this$0 = AGenerator.this;
                super($anonymous0, $anonymous1);
            }
        }
;
        registerBlockHandler(name, new SlimefunBlockHandler() {

            final AGenerator this$0;

            public void onPlace(Player player, Block block, SlimefunItem slimefunitem)
            {
            }

            public boolean onBreak(Player p, Block b, SlimefunItem item, UnregisterReason reason)
            {
                BlockMenu inv = BlockStorage.getInventory(b);
                if(inv != null)
                {
                    int ai[];
                    int k = (ai = getInputSlots()).length;
                    for(int i = 0; i < k; i++)
                    {
                        int slot = ai[i];
                        if(inv.getItemInSlot(slot) != null)
                            b.getWorld().dropItemNaturally(b.getLocation(), inv.getItemInSlot(slot));
                    }

                    k = (ai = getOutputSlots()).length;
                    for(int j = 0; j < k; j++)
                    {
                        int slot = ai[j];
                        if(inv.getItemInSlot(slot) != null)
                            b.getWorld().dropItemNaturally(b.getLocation(), inv.getItemInSlot(slot));
                    }

                }
                AGenerator.progress.remove(b.getLocation());
                AGenerator.processing.remove(b.getLocation());
                return true;
            }

            
            {
                this$0 = AGenerator.this;
                super();
            }
        }
);
        registerDefaultRecipes();
    }

    public AGenerator(Category category, ItemStack item, String name, RecipeType recipeType, ItemStack recipe[], ItemStack recipeOutput)
    {
        super(category, item, name, recipeType, recipe, recipeOutput);
        recipes = new HashSet();
        new BlockMenuPreset(name, getInventoryTitle()) {

            final AGenerator this$0;

            public void init()
            {
                constructMenu(this);
            }

            public void newInstance(BlockMenu blockmenu, Block block)
            {
            }

            public boolean canOpen(Block b, Player p)
            {
                return p.hasPermission("slimefun.inventory.bypass") || CSCoreLib.getLib().getProtectionManager().canAccessChest(p.getUniqueId(), b, true);
            }

            public int[] getSlotsAccessedByItemTransport(ItemTransportFlow flow)
            {
                if(flow.equals(ItemTransportFlow.INSERT))
                    return getInputSlots();
                else
                    return getOutputSlots();
            }

            
            {
                this$0 = AGenerator.this;
                super($anonymous0, $anonymous1);
            }
        }
;
        registerBlockHandler(name, new SlimefunBlockHandler() {

            final AGenerator this$0;

            public void onPlace(Player player, Block block, SlimefunItem slimefunitem)
            {
            }

            public boolean onBreak(Player p, Block b, SlimefunItem item, UnregisterReason reason)
            {
                BlockMenu inv = BlockStorage.getInventory(b);
                if(inv != null)
                {
                    int ai[];
                    int k = (ai = getInputSlots()).length;
                    for(int i = 0; i < k; i++)
                    {
                        int slot = ai[i];
                        if(inv.getItemInSlot(slot) != null)
                            b.getWorld().dropItemNaturally(b.getLocation(), inv.getItemInSlot(slot));
                    }

                    k = (ai = getOutputSlots()).length;
                    for(int j = 0; j < k; j++)
                    {
                        int slot = ai[j];
                        if(inv.getItemInSlot(slot) != null)
                            b.getWorld().dropItemNaturally(b.getLocation(), inv.getItemInSlot(slot));
                    }

                }
                AGenerator.progress.remove(b.getLocation());
                AGenerator.processing.remove(b.getLocation());
                return true;
            }

            
            {
                this$0 = AGenerator.this;
                super();
            }
        }
);
        registerDefaultRecipes();
    }

    private void constructMenu(BlockMenuPreset preset)
    {
        int ai[];
        int j1 = (ai = border).length;
        for(int j = 0; j < j1; j++)
        {
            int i = ai[j];
            preset.addItem(i, new CustomItem(new MaterialData(Material.STAINED_GLASS_PANE, (byte)7), " ", new String[0]), new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuClickHandler() {

                final AGenerator this$0;

                public boolean onClick(Player arg0, int arg1, ItemStack arg2, ClickAction clickaction)
                {
                    return false;
                }

            
            {
                this$0 = AGenerator.this;
                super();
            }
            }
);
        }

        j1 = (ai = border_in).length;
        for(int k = 0; k < j1; k++)
        {
            int i = ai[k];
            preset.addItem(i, new CustomItem(new MaterialData(Material.STAINED_GLASS_PANE, (byte)9), " ", new String[0]), new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuClickHandler() {

                final AGenerator this$0;

                public boolean onClick(Player arg0, int arg1, ItemStack arg2, ClickAction clickaction)
                {
                    return false;
                }

            
            {
                this$0 = AGenerator.this;
                super();
            }
            }
);
        }

        j1 = (ai = border_out).length;
        for(int l = 0; l < j1; l++)
        {
            int i = ai[l];
            preset.addItem(i, new CustomItem(new MaterialData(Material.STAINED_GLASS_PANE, (byte)1), " ", new String[0]), new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuClickHandler() {

                final AGenerator this$0;

                public boolean onClick(Player arg0, int arg1, ItemStack arg2, ClickAction clickaction)
                {
                    return false;
                }

            
            {
                this$0 = AGenerator.this;
                super();
            }
            }
);
        }

        j1 = (ai = getOutputSlots()).length;
        for(int i1 = 0; i1 < j1; i1++)
        {
            int i = ai[i1];
            preset.addMenuClickHandler(i, new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.AdvancedMenuClickHandler() {

                final AGenerator this$0;

                public boolean onClick(Player p, int slot, ItemStack cursor, ClickAction clickaction)
                {
                    return false;
                }

                public boolean onClick(InventoryClickEvent e, Player p, int slot, ItemStack cursor, ClickAction action)
                {
                    return cursor == null || cursor.getType() == null || cursor.getType() == Material.AIR;
                }

            
            {
                this$0 = AGenerator.this;
                super();
            }
            }
);
        }

        preset.addItem(22, new CustomItem(new MaterialData(Material.STAINED_GLASS_PANE, (byte)15), " ", new String[0]), new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuClickHandler() {

            final AGenerator this$0;

            public boolean onClick(Player arg0, int arg1, ItemStack arg2, ClickAction clickaction)
            {
                return false;
            }

            
            {
                this$0 = AGenerator.this;
                super();
            }
        }
);
    }

    public abstract String getInventoryTitle();

    public abstract ItemStack getProgressBar();

    public abstract void registerDefaultRecipes();

    public abstract int getEnergyProduction();

    public int[] getInputSlots()
    {
        return (new int[] {
            19, 20
        });
    }

    public int[] getOutputSlots()
    {
        return (new int[] {
            24, 25
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

                final AGenerator this$0;

                public double generateEnergy(Location l, SlimefunItem sf, Config data)
                {
                    if(isProcessing(l))
                    {
                        int timeleft = ((Integer)AGenerator.progress.get(l)).intValue();
                        if(timeleft > 0)
                        {
                            ItemStack item = getProgressBar().clone();
                            item.setDurability(MachineHelper.getDurability(item, timeleft, ((MachineFuel)AGenerator.processing.get(l)).getTicks()));
                            ItemMeta im = item.getItemMeta();
                            im.setDisplayName(" ");
                            List lore = new ArrayList();
                            lore.add(MachineHelper.getProgress(timeleft, ((MachineFuel)AGenerator.processing.get(l)).getTicks()));
                            lore.add("");
                            lore.add(MachineHelper.getTimeLeft(timeleft / 2));
                            im.setLore(lore);
                            item.setItemMeta(im);
                            BlockStorage.getInventory(l).replaceExistingItem(22, item);
                            if(ChargableBlock.isChargable(l))
                            {
                                if(ChargableBlock.getMaxCharge(l) - ChargableBlock.getCharge(l) >= getEnergyProduction())
                                {
                                    ChargableBlock.addCharge(l, getEnergyProduction());
                                    AGenerator.progress.put(l, Integer.valueOf(timeleft - 1));
                                    return (double)ChargableBlock.getCharge(l);
                                } else
                                {
                                    return 0.0D;
                                }
                            } else
                            {
                                AGenerator.progress.put(l, Integer.valueOf(timeleft - 1));
                                return (double)getEnergyProduction();
                            }
                        }
                        ItemStack fuel = ((MachineFuel)AGenerator.processing.get(l)).getInput();
                        if(SlimefunManager.isItemSimiliar(fuel, new ItemStack(Material.LAVA_BUCKET), true))
                            pushItems(l, new ItemStack[] {
                                new ItemStack(Material.BUCKET)
                            });
                        else
                        if(SlimefunManager.isItemSimiliar(fuel, SlimefunItems.BUCKET_OF_FUEL, true))
                            pushItems(l, new ItemStack[] {
                                new ItemStack(Material.BUCKET)
                            });
                        else
                        if(SlimefunManager.isItemSimiliar(fuel, SlimefunItems.BUCKET_OF_OIL, true))
                            pushItems(l, new ItemStack[] {
                                new ItemStack(Material.BUCKET)
                            });
                        BlockStorage.getInventory(l).replaceExistingItem(22, new CustomItem(new MaterialData(Material.STAINED_GLASS_PANE, (byte)15), " ", new String[0]));
                        AGenerator.progress.remove(l);
                        AGenerator.processing.remove(l);
                        return 0.0D;
                    }
                    MachineFuel r = null;
                    Map found = new HashMap();
label0:
                    for(Iterator iterator = recipes.iterator(); iterator.hasNext();)
                    {
                        MachineFuel recipe = (MachineFuel)iterator.next();
                        int ai[];
                        int j = (ai = getInputSlots()).length;
                        for(int i = 0; i < j; i++)
                        {
                            int slot = ai[i];
                            if(!SlimefunManager.isItemSimiliar(BlockStorage.getInventory(l).getItemInSlot(slot), recipe.getInput(), true))
                                continue;
                            found.put(Integer.valueOf(slot), Integer.valueOf(recipe.getInput().getAmount()));
                            r = recipe;
                            break label0;
                        }

                    }

                    if(r != null)
                    {
                        java.util.Map.Entry entry;
                        for(Iterator iterator1 = found.entrySet().iterator(); iterator1.hasNext(); BlockStorage.getInventory(l).replaceExistingItem(((Integer)entry.getKey()).intValue(), InvUtils.decreaseItem(BlockStorage.getInventory(l).getItemInSlot(((Integer)entry.getKey()).intValue()), ((Integer)entry.getValue()).intValue())))
                            entry = (java.util.Map.Entry)iterator1.next();

                        AGenerator.processing.put(l, r);
                        AGenerator.progress.put(l, Integer.valueOf(r.getTicks()));
                    }
                    return 0.0D;
                }

                public boolean explode(Location l)
                {
                    return false;
                }

            
            {
                this$0 = AGenerator.this;
                super();
            }
            }

        });
        super.register(slimefun);
    }

    public Set getFuelTypes()
    {
        return recipes;
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

    protected void pushItems(Location l, ItemStack items[])
    {
        Inventory inv = inject(l);
        inv.addItem(items);
        int ai[];
        int j = (ai = getOutputSlots()).length;
        for(int i = 0; i < j; i++)
        {
            int slot = ai[i];
            BlockStorage.getInventory(l).replaceExistingItem(slot, inv.getItem(slot));
        }

    }



}

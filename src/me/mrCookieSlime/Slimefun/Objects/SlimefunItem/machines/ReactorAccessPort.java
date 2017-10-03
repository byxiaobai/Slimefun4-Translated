// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   ReactorAccessPort.java

package me.mrCookieSlime.Slimefun.Objects.SlimefunItem.machines;

import java.util.*;
import me.mrCookieSlime.CSCoreLibPlugin.CSCoreLib;
import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu;
import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ClickAction;
import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.Item.CustomItem;
import me.mrCookieSlime.CSCoreLibPlugin.protection.ProtectionManager;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Lists.SlimefunItems;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.Objects.SlimefunBlockHandler;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.UnregisterReason;
import me.mrCookieSlime.Slimefun.Setup.SlimefunManager;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenuPreset;
import me.mrCookieSlime.Slimefun.api.item_transport.ItemTransportFlow;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.MaterialData;

public class ReactorAccessPort extends SlimefunItem
{

    private static final int border[] = {
        0, 1, 2, 3, 4, 5, 6, 7, 8, 12, 
        13, 14, 21, 23
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

    public ReactorAccessPort(Category category, ItemStack item, String name, RecipeType recipeType, ItemStack recipe[])
    {
        super(category, item, name, recipeType, recipe);
        new BlockMenuPreset(name, getInventoryTitle()) {

            final ReactorAccessPort this$0;

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
                    return ReactorAccessPort.getOutputSlots();
            }

            public int[] getSlotsAccessedByItemTransport(BlockMenu menu, ItemTransportFlow flow, ItemStack item)
            {
                if(flow.equals(ItemTransportFlow.INSERT))
                {
                    if(SlimefunManager.isItemSimiliar(item, SlimefunItems.REACTOR_COOLANT_CELL, true))
                        return getCoolantSlots();
                    else
                        return getFuelSlots();
                } else
                {
                    return ReactorAccessPort.getOutputSlots();
                }
            }

            
            {
                this$0 = ReactorAccessPort.this;
                super($anonymous0, $anonymous1);
            }
        }
;
        registerBlockHandler(name, new SlimefunBlockHandler() {

            final ReactorAccessPort this$0;

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

                    l = (ai = ReactorAccessPort.getOutputSlots()).length;
                    for(int k = 0; k < l; k++)
                    {
                        int slot = ai[k];
                        if(inv.getItemInSlot(slot) != null)
                            b.getWorld().dropItemNaturally(b.getLocation(), inv.getItemInSlot(slot));
                    }

                }
                return true;
            }

            
            {
                this$0 = ReactorAccessPort.this;
                super();
            }
        }
);
    }

    private void constructMenu(BlockMenuPreset preset)
    {
        int ai[];
        int j1 = (ai = border).length;
        for(int j = 0; j < j1; j++)
        {
            int i = ai[j];
            preset.addItem(i, new CustomItem(new MaterialData(Material.STAINED_GLASS_PANE, (byte)7), " ", new String[0]), new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuClickHandler() {

                final ReactorAccessPort this$0;

                public boolean onClick(Player arg0, int arg1, ItemStack arg2, ClickAction clickaction)
                {
                    return false;
                }

            
            {
                this$0 = ReactorAccessPort.this;
                super();
            }
            }
);
        }

        j1 = (ai = border_1).length;
        for(int k = 0; k < j1; k++)
        {
            int i = ai[k];
            preset.addItem(i, new CustomItem(new MaterialData(Material.STAINED_GLASS_PANE, (byte)5), " ", new String[0]), new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuClickHandler() {

                final ReactorAccessPort this$0;

                public boolean onClick(Player arg0, int arg1, ItemStack arg2, ClickAction clickaction)
                {
                    return false;
                }

            
            {
                this$0 = ReactorAccessPort.this;
                super();
            }
            }
);
        }

        j1 = (ai = border_2).length;
        for(int l = 0; l < j1; l++)
        {
            int i = ai[l];
            preset.addItem(i, new CustomItem(new MaterialData(Material.STAINED_GLASS_PANE, (byte)9), " ", new String[0]), new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuClickHandler() {

                final ReactorAccessPort this$0;

                public boolean onClick(Player arg0, int arg1, ItemStack arg2, ClickAction clickaction)
                {
                    return false;
                }

            
            {
                this$0 = ReactorAccessPort.this;
                super();
            }
            }
);
        }

        j1 = (ai = border_3).length;
        for(int i1 = 0; i1 < j1; i1++)
        {
            int i = ai[i1];
            preset.addItem(i, new CustomItem(new MaterialData(Material.STAINED_GLASS_PANE, (byte)13), " ", new String[0]), new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuClickHandler() {

                final ReactorAccessPort this$0;

                public boolean onClick(Player arg0, int arg1, ItemStack arg2, ClickAction clickaction)
                {
                    return false;
                }

            
            {
                this$0 = ReactorAccessPort.this;
                super();
            }
            }
);
        }

        preset.addItem(1, new CustomItem(SlimefunItems.URANIUM, "&7Fuel Slot", new String[] {
            "", "&rThis Slot accepts radioactive Fuel such as:", "&2Uranium &ror &aNeptunium"
        }), new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuClickHandler() {

            final ReactorAccessPort this$0;

            public boolean onClick(Player arg0, int arg1, ItemStack arg2, ClickAction clickaction)
            {
                return false;
            }

            
            {
                this$0 = ReactorAccessPort.this;
                super();
            }
        }
);
        preset.addItem(22, new CustomItem(SlimefunItems.PLUTONIUM, "&7Byproduct Slot", new String[] {
            "", "&rThis Slot contains the Reactor's Byproduct", "&rsuch as &aNeptunium &ror &7Plutonium"
        }), new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuClickHandler() {

            final ReactorAccessPort this$0;

            public boolean onClick(Player arg0, int arg1, ItemStack arg2, ClickAction clickaction)
            {
                return false;
            }

            
            {
                this$0 = ReactorAccessPort.this;
                super();
            }
        }
);
        preset.addItem(7, new CustomItem(SlimefunItems.REACTOR_COOLANT_CELL, "&bCoolant Slot", new String[] {
            "", "&rThis Slot accepts Coolant Cells", "&4Without any Coolant Cells, your Reactor", "&4will explode"
        }), new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuClickHandler() {

            final ReactorAccessPort this$0;

            public boolean onClick(Player arg0, int arg1, ItemStack arg2, ClickAction clickaction)
            {
                return false;
            }

            
            {
                this$0 = ReactorAccessPort.this;
                super();
            }
        }
);
        preset.addItem(7, new CustomItem(SlimefunItems.REACTOR_COOLANT_CELL, "&bCoolant Slot", new String[] {
            "", "&rThis Slot accepts Coolant Cells", "&4Without any Coolant Cells, your Reactor", "&4will explode"
        }), new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuClickHandler() {

            final ReactorAccessPort this$0;

            public boolean onClick(Player arg0, int arg1, ItemStack arg2, ClickAction clickaction)
            {
                return false;
            }

            
            {
                this$0 = ReactorAccessPort.this;
                super();
            }
        }
);
    }

    public String getInventoryTitle()
    {
        return "&2Reactor Access Port";
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
        return (new int[] {
            25, 34, 43
        });
    }

    public static int[] getOutputSlots()
    {
        return (new int[] {
            40
        });
    }

    private static Inventory inject(Location l)
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

    public static ItemStack pushItems(Location l, ItemStack item)
    {
        Inventory inv = inject(l);
        Map map = inv.addItem(new ItemStack[] {
            item
        });
        int ai[];
        int j = (ai = getOutputSlots()).length;
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


}

// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   ElectricSmeltery.java

package me.mrCookieSlime.Slimefun.Objects.SlimefunItem.machines;

import java.util.*;
import me.mrCookieSlime.CSCoreLibPlugin.CSCoreLib;
import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu;
import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ClickAction;
import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.Item.CustomItem;
import me.mrCookieSlime.CSCoreLibPlugin.protection.ProtectionManager;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.Objects.SlimefunBlockHandler;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.UnregisterReason;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems.AContainer;
import me.mrCookieSlime.Slimefun.Setup.SlimefunManager;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenuPreset;
import me.mrCookieSlime.Slimefun.api.item_transport.ItemTransportFlow;
import me.mrCookieSlime.Slimefun.api.item_transport.RecipeSorter;
import org.apache.commons.lang.ArrayUtils;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.MaterialData;

public abstract class ElectricSmeltery extends AContainer
{

    public static Map processing = new HashMap();
    public static Map progress = new HashMap();
    protected List recipes;
    private static final int border[] = {
        4, 5, 6, 7, 8, 13, 31, 40, 41, 42, 
        43, 44
    };
    private static final int border_in[] = {
        0, 1, 2, 3, 9, 12, 18, 21, 27, 30, 
        36, 37, 38, 39
    };
    private static final int border_out[] = {
        14, 15, 16, 17, 23, 26, 32, 33, 34, 35
    };

    public ElectricSmeltery(Category category, ItemStack item, String name, RecipeType recipeType, ItemStack recipe[])
    {
        super(category, item, name, recipeType, recipe);
        recipes = new ArrayList();
        new BlockMenuPreset(name, getInventoryTitle()) {

            final ElectricSmeltery this$0;

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
                return new int[0];
            }

            public int[] getSlotsAccessedByItemTransport(BlockMenu menu, ItemTransportFlow flow, ItemStack item)
            {
                if(flow.equals(ItemTransportFlow.WITHDRAW))
                    return getOutputSlots();
                List slots = new ArrayList();
                int ai[];
                int j = (ai = getInputSlots()).length;
                for(int i = 0; i < j; i++)
                {
                    int slot = ai[i];
                    if(SlimefunManager.isItemSimiliar(menu.getItemInSlot(slot), item, true))
                        slots.add(Integer.valueOf(slot));
                }

                if(slots.isEmpty())
                {
                    return getInputSlots();
                } else
                {
                    Collections.sort(slots, new RecipeSorter(menu));
                    return ArrayUtils.toPrimitive((Integer[])slots.toArray(new Integer[slots.size()]));
                }
            }

            
            {
                this$0 = ElectricSmeltery.this;
                super($anonymous0, $anonymous1);
            }
        }
;
        registerBlockHandler(name, new SlimefunBlockHandler() {

            final ElectricSmeltery this$0;

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
                ElectricSmeltery.progress.remove(b.getLocation());
                ElectricSmeltery.processing.remove(b.getLocation());
                return true;
            }

            
            {
                this$0 = ElectricSmeltery.this;
                super();
            }
        }
);
        registerDefaultRecipes();
    }

    protected void constructMenu(BlockMenuPreset preset)
    {
        int ai[];
        int j1 = (ai = border).length;
        for(int j = 0; j < j1; j++)
        {
            int i = ai[j];
            preset.addItem(i, new CustomItem(new MaterialData(Material.STAINED_GLASS_PANE, (byte)7), " ", new String[0]), new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuClickHandler() {

                final ElectricSmeltery this$0;

                public boolean onClick(Player arg0, int arg1, ItemStack arg2, ClickAction clickaction)
                {
                    return false;
                }

            
            {
                this$0 = ElectricSmeltery.this;
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

                final ElectricSmeltery this$0;

                public boolean onClick(Player arg0, int arg1, ItemStack arg2, ClickAction clickaction)
                {
                    return false;
                }

            
            {
                this$0 = ElectricSmeltery.this;
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

                final ElectricSmeltery this$0;

                public boolean onClick(Player arg0, int arg1, ItemStack arg2, ClickAction clickaction)
                {
                    return false;
                }

            
            {
                this$0 = ElectricSmeltery.this;
                super();
            }
            }
);
        }

        preset.addItem(22, new CustomItem(new MaterialData(Material.STAINED_GLASS_PANE, (byte)15), " ", new String[0]), new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuClickHandler() {

            final ElectricSmeltery this$0;

            public boolean onClick(Player arg0, int arg1, ItemStack arg2, ClickAction clickaction)
            {
                return false;
            }

            
            {
                this$0 = ElectricSmeltery.this;
                super();
            }
        }
);
        j1 = (ai = getOutputSlots()).length;
        for(int i1 = 0; i1 < j1; i1++)
        {
            int i = ai[i1];
            preset.addMenuClickHandler(i, new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.AdvancedMenuClickHandler() {

                final ElectricSmeltery this$0;

                public boolean onClick(Player p, int slot, ItemStack cursor, ClickAction clickaction)
                {
                    return false;
                }

                public boolean onClick(InventoryClickEvent e, Player p, int slot, ItemStack cursor, ClickAction action)
                {
                    return cursor == null || cursor.getType() == null || cursor.getType() == Material.AIR;
                }

            
            {
                this$0 = ElectricSmeltery.this;
                super();
            }
            }
);
        }

    }

    public String getInventoryTitle()
    {
        return "&cElectric Smeltery";
    }

    public ItemStack getProgressBar()
    {
        return new ItemStack(Material.FLINT_AND_STEEL);
    }

    public int[] getInputSlots()
    {
        return (new int[] {
            10, 11, 19, 20, 28, 29
        });
    }

    public int[] getOutputSlots()
    {
        return (new int[] {
            24, 25
        });
    }

    public String getMachineIdentifier()
    {
        return "ELECTRIC_SMELTERY";
    }

}

// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   FluidPump.java

package me.mrCookieSlime.Slimefun.Objects.SlimefunItem.machines;

import java.util.*;
import me.mrCookieSlime.CSCoreLibPlugin.CSCoreLib;
import me.mrCookieSlime.CSCoreLibPlugin.Configuration.Config;
import me.mrCookieSlime.CSCoreLibPlugin.general.Block.Vein;
import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.*;
import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.Item.CustomItem;
import me.mrCookieSlime.CSCoreLibPlugin.protection.ProtectionManager;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.handlers.BlockTicker;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.handlers.ItemHandler;
import me.mrCookieSlime.Slimefun.Setup.SlimefunManager;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import me.mrCookieSlime.Slimefun.api.energy.ChargableBlock;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenuPreset;
import me.mrCookieSlime.Slimefun.api.item_transport.ItemTransportFlow;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.MaterialData;

public class FluidPump extends SlimefunItem
{

    public static Map processing = new HashMap();
    public static Map progress = new HashMap();
    private static final int border[] = {
        0, 1, 2, 3, 4, 5, 6, 7, 8, 13, 
        31, 36, 37, 38, 39, 40, 41, 42, 43, 44, 
        22
    };
    private static final int border_in[] = {
        9, 10, 11, 12, 18, 21, 27, 28, 29, 30
    };
    private static final int border_out[] = {
        14, 15, 16, 17, 23, 26, 32, 33, 34, 35
    };

    public FluidPump(Category category, ItemStack item, String name, RecipeType recipeType, ItemStack recipe[])
    {
        super(category, item, name, recipeType, recipe);
        new BlockMenuPreset(name, getInventoryTitle()) {

            final FluidPump this$0;

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
                this$0 = FluidPump.this;
                super($anonymous0, $anonymous1);
            }
        }
;
    }

    protected void constructMenu(BlockMenuPreset preset)
    {
        int ai[];
        int j1 = (ai = border).length;
        for(int j = 0; j < j1; j++)
        {
            int i = ai[j];
            preset.addItem(i, new CustomItem(new MaterialData(Material.STAINED_GLASS_PANE, (byte)7), " ", new String[0]), new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuClickHandler() {

                final FluidPump this$0;

                public boolean onClick(Player arg0, int arg1, ItemStack arg2, ClickAction clickaction)
                {
                    return false;
                }

            
            {
                this$0 = FluidPump.this;
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

                final FluidPump this$0;

                public boolean onClick(Player arg0, int arg1, ItemStack arg2, ClickAction clickaction)
                {
                    return false;
                }

            
            {
                this$0 = FluidPump.this;
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

                final FluidPump this$0;

                public boolean onClick(Player arg0, int arg1, ItemStack arg2, ClickAction clickaction)
                {
                    return false;
                }

            
            {
                this$0 = FluidPump.this;
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

                final FluidPump this$0;

                public boolean onClick(Player p, int slot, ItemStack cursor, ClickAction clickaction)
                {
                    return false;
                }

                public boolean onClick(InventoryClickEvent e, Player p, int slot, ItemStack cursor, ClickAction action)
                {
                    return cursor == null || cursor.getType() == null || cursor.getType() == Material.AIR;
                }

            
            {
                this$0 = FluidPump.this;
                super();
            }
            }
);
        }

    }

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

    public String getInventoryTitle()
    {
        return "&9Fluid Pump";
    }

    protected void tick(Block b)
    {
        Block fluid = b.getRelative(BlockFace.DOWN);
        if(fluid.getType().equals(Material.STATIONARY_LAVA))
        {
            int ai[];
            int k = (ai = getInputSlots()).length;
            for(int i = 0; i < k; i++)
            {
                int slot = ai[i];
                if(SlimefunManager.isItemSimiliar(BlockStorage.getInventory(b).getItemInSlot(slot), new ItemStack(Material.BUCKET), true))
                {
                    if(ChargableBlock.getCharge(b) < getEnergyConsumption())
                        return;
                    ItemStack output = new ItemStack(Material.LAVA_BUCKET);
                    if(!fits(b, new ItemStack[] {
    output
}))
                    {
                        return;
                    } else
                    {
                        ChargableBlock.addCharge(b, -getEnergyConsumption());
                        BlockStorage.getInventory(b).replaceExistingItem(slot, InvUtils.decreaseItem(BlockStorage.getInventory(b).getItemInSlot(slot), 1));
                        pushItems(b, new ItemStack[] {
                            output
                        });
                        List list = new ArrayList();
                        list.add(fluid.getLocation());
                        Vein.calculate(fluid.getLocation(), fluid.getLocation(), list, 64);
                        ((Location)list.get(list.size() - 1)).getBlock().setType(Material.AIR);
                        return;
                    }
                }
            }

        } else
        if(fluid.getType().equals(Material.STATIONARY_WATER))
        {
            int ai1[];
            int l = (ai1 = getInputSlots()).length;
            for(int j = 0; j < l; j++)
            {
                int slot = ai1[j];
                if(SlimefunManager.isItemSimiliar(BlockStorage.getInventory(b).getItemInSlot(slot), new ItemStack(Material.BUCKET), true))
                {
                    if(ChargableBlock.getCharge(b) < getEnergyConsumption())
                        return;
                    ItemStack output = new ItemStack(Material.WATER_BUCKET);
                    if(!fits(b, new ItemStack[] {
    output
}))
                    {
                        return;
                    } else
                    {
                        ChargableBlock.addCharge(b, -getEnergyConsumption());
                        BlockStorage.getInventory(b).replaceExistingItem(slot, InvUtils.decreaseItem(BlockStorage.getInventory(b).getItemInSlot(slot), 1));
                        pushItems(b, new ItemStack[] {
                            output
                        });
                        fluid.setType(Material.AIR);
                        return;
                    }
                }
            }

        }
    }

    private int getEnergyConsumption()
    {
        return 32;
    }

    public void register(boolean slimefun)
    {
        addItemHandler(new ItemHandler[] {
            new BlockTicker() {

                final FluidPump this$0;

                public void tick(Block b, SlimefunItem sf, Config data)
                {
                    FluidPump.this.tick(b);
                }

                public void uniqueTick()
                {
                }

                public boolean isSynchronized()
                {
                    return true;
                }

            
            {
                this$0 = FluidPump.this;
                super();
            }
            }

        });
        super.register(slimefun);
    }

    private Inventory inject(Block b)
    {
        int size = BlockStorage.getInventory(b).toInventory().getSize();
        Inventory inv = Bukkit.createInventory(null, size);
        for(int i = 0; i < size; i++)
            inv.setItem(i, new CustomItem(Material.COMMAND, " &4ALL YOUR PLACEHOLDERS ARE BELONG TO US", 0));

        int ai[];
        int k = (ai = getOutputSlots()).length;
        for(int j = 0; j < k; j++)
        {
            int slot = ai[j];
            inv.setItem(slot, BlockStorage.getInventory(b).getItemInSlot(slot));
        }

        return inv;
    }

    protected boolean fits(Block b, ItemStack items[])
    {
        return inject(b).addItem(items).isEmpty();
    }

    protected void pushItems(Block b, ItemStack items[])
    {
        Inventory inv = inject(b);
        inv.addItem(items);
        int ai[];
        int j = (ai = getOutputSlots()).length;
        for(int i = 0; i < j; i++)
        {
            int slot = ai[i];
            BlockStorage.getInventory(b).replaceExistingItem(slot, inv.getItem(slot));
        }

    }

}

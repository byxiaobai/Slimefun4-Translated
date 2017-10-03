// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   AFarm.java

package me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems;

import java.util.HashMap;
import me.mrCookieSlime.CSCoreLibPlugin.CSCoreLib;
import me.mrCookieSlime.CSCoreLibPlugin.Configuration.Config;
import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu;
import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ClickAction;
import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.Item.CustomItem;
import me.mrCookieSlime.CSCoreLibPlugin.protection.ProtectionManager;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.Objects.SlimefunBlockHandler;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.UnregisterReason;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.handlers.BlockTicker;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.handlers.ItemHandler;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import me.mrCookieSlime.Slimefun.api.energy.ChargableBlock;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenuPreset;
import me.mrCookieSlime.Slimefun.api.item_transport.ItemTransportFlow;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.MaterialData;

public abstract class AFarm extends SlimefunItem
{

    private static final int border[] = {
        0, 1, 2, 3, 4, 5, 6, 7, 8, 36, 
        37, 38, 39, 40, 41, 42, 43, 44
    };
    private static final int border_out[] = {
        9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 
        26, 27, 28, 29, 30, 31, 32, 33, 34, 35
    };

    public AFarm(Category category, ItemStack item, String name, RecipeType recipeType, ItemStack recipe[])
    {
        super(category, item, name, recipeType, recipe);
        new BlockMenuPreset(name, getInventoryTitle()) {

            final AFarm this$0;

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
                if(flow.equals(ItemTransportFlow.WITHDRAW))
                    return getOutputSlots();
                else
                    return new int[0];
            }

            
            {
                this$0 = AFarm.this;
                super($anonymous0, $anonymous1);
            }
        }
;
        registerBlockHandler(name, new SlimefunBlockHandler() {

            final AFarm this$0;

            public void onPlace(Player player, Block block, SlimefunItem slimefunitem)
            {
            }

            public boolean onBreak(Player p, Block b, SlimefunItem item, UnregisterReason reason)
            {
                int ai[];
                int j = (ai = getOutputSlots()).length;
                for(int i = 0; i < j; i++)
                {
                    int slot = ai[i];
                    if(BlockStorage.getInventory(b).getItemInSlot(slot) != null)
                        b.getWorld().dropItemNaturally(b.getLocation(), BlockStorage.getInventory(b).getItemInSlot(slot));
                }

                return true;
            }

            
            {
                this$0 = AFarm.this;
                super();
            }
        }
);
    }

    public AFarm(Category category, ItemStack item, String name, RecipeType recipeType, ItemStack recipe[], ItemStack recipeOutput)
    {
        super(category, item, name, recipeType, recipe, recipeOutput);
        new BlockMenuPreset(name, getInventoryTitle()) {

            final AFarm this$0;

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
                if(flow.equals(ItemTransportFlow.WITHDRAW))
                    return getOutputSlots();
                else
                    return new int[0];
            }

            
            {
                this$0 = AFarm.this;
                super($anonymous0, $anonymous1);
            }
        }
;
        registerBlockHandler(name, new SlimefunBlockHandler() {

            final AFarm this$0;

            public void onPlace(Player player, Block block, SlimefunItem slimefunitem)
            {
            }

            public boolean onBreak(Player p, Block b, SlimefunItem item, UnregisterReason reason)
            {
                int ai[];
                int j = (ai = getOutputSlots()).length;
                for(int i = 0; i < j; i++)
                {
                    int slot = ai[i];
                    if(BlockStorage.getInventory(b).getItemInSlot(slot) != null)
                        b.getWorld().dropItemNaturally(b.getLocation(), BlockStorage.getInventory(b).getItemInSlot(slot));
                }

                return true;
            }

            
            {
                this$0 = AFarm.this;
                super();
            }
        }
);
    }

    private void constructMenu(BlockMenuPreset preset)
    {
        int ai[];
        int i1 = (ai = border).length;
        for(int j = 0; j < i1; j++)
        {
            int i = ai[j];
            preset.addItem(i, new CustomItem(new MaterialData(Material.STAINED_GLASS_PANE, (byte)7), " ", new String[0]), new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuClickHandler() {

                final AFarm this$0;

                public boolean onClick(Player arg0, int arg1, ItemStack arg2, ClickAction clickaction)
                {
                    return false;
                }

            
            {
                this$0 = AFarm.this;
                super();
            }
            }
);
        }

        i1 = (ai = border_out).length;
        for(int k = 0; k < i1; k++)
        {
            int i = ai[k];
            preset.addItem(i, new CustomItem(new MaterialData(Material.STAINED_GLASS_PANE, (byte)1), " ", new String[0]), new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuClickHandler() {

                final AFarm this$0;

                public boolean onClick(Player arg0, int arg1, ItemStack arg2, ClickAction clickaction)
                {
                    return false;
                }

            
            {
                this$0 = AFarm.this;
                super();
            }
            }
);
        }

        preset.addItem(22, new CustomItem(new MaterialData(Material.STAINED_GLASS_PANE, (byte)15), " ", new String[0]), new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuClickHandler() {

            final AFarm this$0;

            public boolean onClick(Player arg0, int arg1, ItemStack arg2, ClickAction clickaction)
            {
                return false;
            }

            
            {
                this$0 = AFarm.this;
                super();
            }
        }
);
        i1 = (ai = getOutputSlots()).length;
        for(int l = 0; l < i1; l++)
        {
            int i = ai[l];
            preset.addMenuClickHandler(i, new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.AdvancedMenuClickHandler() {

                final AFarm this$0;

                public boolean onClick(Player p, int slot, ItemStack cursor, ClickAction clickaction)
                {
                    return false;
                }

                public boolean onClick(InventoryClickEvent e, Player p, int slot, ItemStack cursor, ClickAction action)
                {
                    return cursor == null || cursor.getType() == null || cursor.getType() == Material.AIR;
                }

            
            {
                this$0 = AFarm.this;
                super();
            }
            }
);
        }

    }

    public abstract String getInventoryTitle();

    public abstract int getEnergyConsumption();

    public abstract boolean canHarvest(Block block);

    public abstract ItemStack harvest(Block block);

    public abstract int getSize();

    public int[] getOutputSlots()
    {
        return (new int[] {
            19, 20, 21, 22, 23, 24, 25
        });
    }

    protected void tick(Block b)
    {
        if(ChargableBlock.isChargable(b))
        {
            if(ChargableBlock.getCharge(b) < getEnergyConsumption())
                return;
            int i = getSize() / 2;
label0:
            for(int x = -i; x <= i; x++)
            {
                for(int z = -i; z <= i; z++)
                {
                    Block block = (new Location(b.getWorld(), b.getX() + x, b.getY() + 2, b.getZ() + z)).getBlock();
                    if(!canHarvest(block))
                        continue;
                    ItemStack item = harvest(block);
                    if(fits(block, new ItemStack[] {
    item
}))
                    {
                        pushItems(b, new ItemStack[] {
                            item
                        });
                        ChargableBlock.addCharge(b, -getEnergyConsumption());
                    }
                    break label0;
                }

            }

        }
    }

    public void register(boolean slimefun)
    {
        addItemHandler(new ItemHandler[] {
            new BlockTicker() {

                final AFarm this$0;

                public void tick(Block b, SlimefunItem sf, Config data)
                {
                    AFarm.this.tick(b);
                }

                public void uniqueTick()
                {
                }

                public boolean isSynchronized()
                {
                    return true;
                }

            
            {
                this$0 = AFarm.this;
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

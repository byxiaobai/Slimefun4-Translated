// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   AutomatedCraftingChamber.java

package me.mrCookieSlime.Slimefun.Objects.SlimefunItem.machines;

import java.util.*;
import me.mrCookieSlime.CSCoreLibPlugin.CSCoreLib;
import me.mrCookieSlime.CSCoreLibPlugin.Configuration.Config;
import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.*;
import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.Item.CustomItem;
import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.Item.CustomItemSerializer;
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
import me.mrCookieSlime.Slimefun.api.item_transport.RecipeSorter;
import org.apache.commons.lang.ArrayUtils;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.MaterialData;

public abstract class AutomatedCraftingChamber extends SlimefunItem
{

    private static final int border[] = {
        0, 1, 3, 4, 5, 7, 8, 13, 14, 15, 
        16, 17, 50, 51, 52, 53
    };
    private static final int border_in[] = {
        9, 10, 11, 12, 13, 18, 22, 27, 31, 36, 
        40, 45, 46, 47, 48, 49
    };
    private static final int border_out[] = {
        23, 24, 25, 26, 32, 35, 41, 42, 43, 44
    };
    public static Map recipes = new HashMap();

    public AutomatedCraftingChamber(Category category, ItemStack item, String name, RecipeType recipeType, ItemStack recipe[])
    {
        super(category, item, name, recipeType, recipe);
        new BlockMenuPreset(name, "&6Automated Crafting Chamber") {

            final AutomatedCraftingChamber this$0;

            public void init()
            {
                constructMenu(this);
            }

            public void newInstance(final BlockMenu menu, final Block b)
            {
                if(!BlockStorage.hasBlockInfo(b) || BlockStorage.getBlockInfo(b, "enabled") == null || BlockStorage.getBlockInfo(b, "enabled").equals("false"))
                {
                    menu.replaceExistingItem(6, new CustomItem(new MaterialData(Material.SULPHUR), "&7Enabled: &4\u2718", new String[] {
                        "", "&e> Click to enable this Machine"
                    }));
                    menu.addMenuClickHandler(6, new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuClickHandler() {

                        final _cls1 this$1;
                        private final Block val$b;
                        private final BlockMenu val$menu;

                        public boolean onClick(Player p, int arg1, ItemStack arg2, ClickAction arg3)
                        {
                            BlockStorage.addBlockInfo(b, "enabled", "true");
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
                    menu.replaceExistingItem(6, new CustomItem(new MaterialData(Material.REDSTONE), "&7Enabled: &2\u2714", new String[] {
                        "", "&e> Click to disable this Machine"
                    }));
                    menu.addMenuClickHandler(6, new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuClickHandler() {

                        final _cls1 this$1;
                        private final Block val$b;
                        private final BlockMenu val$menu;

                        public boolean onClick(Player p, int arg1, ItemStack arg2, ClickAction arg3)
                        {
                            BlockStorage.addBlockInfo(b, "enabled", "false");
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
                    if(menu.getItemInSlot(slot) != null)
                        slots.add(Integer.valueOf(slot));
                }

                Collections.sort(slots, new RecipeSorter(menu));
                return ArrayUtils.toPrimitive((Integer[])slots.toArray(new Integer[slots.size()]));
            }

            
            {
                this$0 = AutomatedCraftingChamber.this;
                super($anonymous0, $anonymous1);
            }
        }
;
        registerBlockHandler(name, new SlimefunBlockHandler() {

            final AutomatedCraftingChamber this$0;

            public void onPlace(Player p, Block b, SlimefunItem item)
            {
                BlockStorage.addBlockInfo(b, "enabled", "false");
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
                return true;
            }

            
            {
                this$0 = AutomatedCraftingChamber.this;
                super();
            }
        }
);
    }

    protected void constructMenu(BlockMenuPreset preset)
    {
        int ai[];
        int j1 = (ai = border).length;
        for(int j = 0; j < j1; j++)
        {
            int i = ai[j];
            preset.addItem(i, new CustomItem(new MaterialData(Material.STAINED_GLASS_PANE, (byte)7), " ", new String[0]), new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuClickHandler() {

                final AutomatedCraftingChamber this$0;

                public boolean onClick(Player arg0, int arg1, ItemStack arg2, ClickAction clickaction)
                {
                    return false;
                }

            
            {
                this$0 = AutomatedCraftingChamber.this;
                super();
            }
            }
);
        }

        j1 = (ai = border_in).length;
        for(int k = 0; k < j1; k++)
        {
            int i = ai[k];
            preset.addItem(i, new CustomItem(new MaterialData(Material.STAINED_GLASS_PANE, (byte)11), " ", new String[0]), new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuClickHandler() {

                final AutomatedCraftingChamber this$0;

                public boolean onClick(Player arg0, int arg1, ItemStack arg2, ClickAction clickaction)
                {
                    return false;
                }

            
            {
                this$0 = AutomatedCraftingChamber.this;
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

                final AutomatedCraftingChamber this$0;

                public boolean onClick(Player arg0, int arg1, ItemStack arg2, ClickAction clickaction)
                {
                    return false;
                }

            
            {
                this$0 = AutomatedCraftingChamber.this;
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

                final AutomatedCraftingChamber this$0;

                public boolean onClick(Player p, int slot, ItemStack cursor, ClickAction clickaction)
                {
                    return false;
                }

                public boolean onClick(InventoryClickEvent e, Player p, int slot, ItemStack cursor, ClickAction action)
                {
                    return cursor == null || cursor.getType() == null || cursor.getType() == Material.AIR;
                }

            
            {
                this$0 = AutomatedCraftingChamber.this;
                super();
            }
            }
);
        }

        preset.addItem(2, new CustomItem(new MaterialData(Material.WORKBENCH), "&eRecipe", new String[] {
            "", "&bPut in the Recipe you want to craft", "&4Enhanced Crafting Table Recipes ONLY"
        }), new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuClickHandler() {

            final AutomatedCraftingChamber this$0;

            public boolean onClick(Player arg0, int arg1, ItemStack arg2, ClickAction clickaction)
            {
                return false;
            }

            
            {
                this$0 = AutomatedCraftingChamber.this;
                super();
            }
        }
);
    }

    public abstract int getEnergyConsumption();

    public int[] getInputSlots()
    {
        return (new int[] {
            19, 20, 21, 28, 29, 30, 37, 38, 39
        });
    }

    public int[] getOutputSlots()
    {
        return (new int[] {
            33, 34
        });
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

    public void register(boolean slimefun)
    {
        addItemHandler(new ItemHandler[] {
            new BlockTicker() {

                final AutomatedCraftingChamber this$0;

                public void tick(Block b, SlimefunItem sf, Config data)
                {
                    AutomatedCraftingChamber.this.tick(b);
                }

                public void uniqueTick()
                {
                }

                public boolean isSynchronized()
                {
                    return false;
                }

            
            {
                this$0 = AutomatedCraftingChamber.this;
                super();
            }
            }

        });
        super.register(slimefun);
    }

    protected void tick(Block b)
    {
        if(BlockStorage.getBlockInfo(b, "enabled").equals("false"))
            return;
        if(ChargableBlock.getCharge(b) < getEnergyConsumption())
            return;
        BlockMenu menu = BlockStorage.getInventory(b);
        StringBuilder builder = new StringBuilder();
        int i = 0;
        for(int j = 0; j < 9; j++)
        {
            if(i > 0)
                builder.append(" </slot> ");
            ItemStack item = menu.getItemInSlot(getInputSlots()[j]);
            if(item != null && item.getAmount() == 1)
                return;
            builder.append(CustomItemSerializer.serialize(item, new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.Item.CustomItemSerializer.ItemFlag[] {
                me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.Item.CustomItemSerializer.ItemFlag.DATA, me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.Item.CustomItemSerializer.ItemFlag.ITEMMETA_DISPLAY_NAME, me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.Item.CustomItemSerializer.ItemFlag.ITEMMETA_LORE, me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.Item.CustomItemSerializer.ItemFlag.MATERIAL
            }));
            i++;
        }

        String input = builder.toString();
        if(recipes.containsKey(input))
        {
            ItemStack output = (ItemStack)recipes.get(input);
            if(fits(b, new ItemStack[] {
    output
}))
            {
                pushItems(b, new ItemStack[] {
                    output
                });
                ChargableBlock.addCharge(b, -getEnergyConsumption());
                for(int j = 0; j < 9; j++)
                    if(menu.getItemInSlot(getInputSlots()[j]) != null)
                        menu.replaceExistingItem(getInputSlots()[j], InvUtils.decreaseItem(menu.getItemInSlot(getInputSlots()[j]), 1));

            }
        }
    }

}

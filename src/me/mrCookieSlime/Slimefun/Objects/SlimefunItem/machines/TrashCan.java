// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   TrashCan.java

package me.mrCookieSlime.Slimefun.Objects.SlimefunItem.machines;

import me.mrCookieSlime.CSCoreLibPlugin.Configuration.Config;
import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu;
import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ClickAction;
import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.Item.CustomItem;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.handlers.BlockTicker;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.handlers.ItemHandler;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenuPreset;
import me.mrCookieSlime.Slimefun.api.item_transport.ItemTransportFlow;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.MaterialData;

public class TrashCan extends SlimefunItem
{

    private static final int border[] = {
        0, 1, 2, 3, 5, 4, 6, 7, 8, 9, 
        17, 18, 19, 20, 21, 22, 23, 24, 25, 26
    };

    public TrashCan(Category category, ItemStack item, String name, RecipeType recipeType, ItemStack recipe[])
    {
        super(category, item, name, recipeType, recipe);
        new BlockMenuPreset(name, getInventoryTitle()) {

            final TrashCan this$0;

            public void init()
            {
                constructMenu(this);
            }

            public void newInstance(BlockMenu blockmenu, Block block)
            {
            }

            public boolean canOpen(Block b, Player p)
            {
                return true;
            }

            public int[] getSlotsAccessedByItemTransport(ItemTransportFlow flow)
            {
                if(flow.equals(ItemTransportFlow.INSERT))
                    return getInputSlots();
                else
                    return new int[0];
            }

            
            {
                this$0 = TrashCan.this;
                super($anonymous0, $anonymous1);
            }
        }
;
    }

    private void constructMenu(BlockMenuPreset preset)
    {
        int ai[];
        int k = (ai = border).length;
        for(int j = 0; j < k; j++)
        {
            int i = ai[j];
            preset.addItem(i, new CustomItem(new MaterialData(Material.STAINED_GLASS_PANE, (byte)14), " ", new String[0]), new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuClickHandler() {

                final TrashCan this$0;

                public boolean onClick(Player arg0, int arg1, ItemStack arg2, ClickAction clickaction)
                {
                    return false;
                }

            
            {
                this$0 = TrashCan.this;
                super();
            }
            }
);
        }

    }

    public String getInventoryTitle()
    {
        return "&4Trash Can";
    }

    public int[] getInputSlots()
    {
        return (new int[] {
            10, 11, 12, 13, 14, 15, 16
        });
    }

    public void register(boolean slimefun)
    {
        addItemHandler(new ItemHandler[] {
            new BlockTicker() {

                final TrashCan this$0;

                public void uniqueTick()
                {
                }

                public void tick(Block b, SlimefunItem item, Config data)
                {
                    BlockMenu menu = BlockStorage.getInventory(b);
                    int ai[];
                    int j = (ai = getInputSlots()).length;
                    for(int i = 0; i < j; i++)
                    {
                        int slot = ai[i];
                        menu.replaceExistingItem(slot, null);
                    }

                }

                public boolean isSynchronized()
                {
                    return false;
                }

            
            {
                this$0 = TrashCan.this;
                super();
            }
            }

        });
        super.register(slimefun);
    }


}

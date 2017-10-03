// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   CropGrowthAccelerator.java

package me.mrCookieSlime.Slimefun.Objects.SlimefunItem.machines;

import java.util.HashMap;
import java.util.Map;
import me.mrCookieSlime.CSCoreLibPlugin.CSCoreLib;
import me.mrCookieSlime.CSCoreLibPlugin.Configuration.Config;
import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.*;
import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.Item.CustomItem;
import me.mrCookieSlime.CSCoreLibPlugin.general.Particles.MC_1_8.ParticleEffect;
import me.mrCookieSlime.CSCoreLibPlugin.protection.ProtectionManager;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Lists.SlimefunItems;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.Objects.SlimefunBlockHandler;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.UnregisterReason;
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
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.MaterialData;

public abstract class CropGrowthAccelerator extends SlimefunItem
{

    private static final int border[] = {
        0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 
        17, 18, 19, 20, 21, 22, 23, 24, 25, 26
    };
    public static final Map crops;

    public CropGrowthAccelerator(Category category, ItemStack item, String name, RecipeType recipeType, ItemStack recipe[])
    {
        super(category, item, name, recipeType, recipe);
        new BlockMenuPreset(name, "&bGrowth Accelerator") {

            final CropGrowthAccelerator this$0;

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
                    return new int[0];
            }

            
            {
                this$0 = CropGrowthAccelerator.this;
                super($anonymous0, $anonymous1);
            }
        }
;
        registerBlockHandler(name, new SlimefunBlockHandler() {

            final CropGrowthAccelerator this$0;

            public void onPlace(Player player, Block block, SlimefunItem slimefunitem)
            {
            }

            public boolean onBreak(Player p, Block b, SlimefunItem item, UnregisterReason reason)
            {
                int ai[];
                int j = (ai = getInputSlots()).length;
                for(int i = 0; i < j; i++)
                {
                    int slot = ai[i];
                    if(BlockStorage.getInventory(b).getItemInSlot(slot) != null)
                        b.getWorld().dropItemNaturally(b.getLocation(), BlockStorage.getInventory(b).getItemInSlot(slot));
                }

                return true;
            }

            
            {
                this$0 = CropGrowthAccelerator.this;
                super();
            }
        }
);
    }

    protected void constructMenu(BlockMenuPreset preset)
    {
        int ai[];
        int k = (ai = border).length;
        for(int j = 0; j < k; j++)
        {
            int i = ai[j];
            preset.addItem(i, new CustomItem(new MaterialData(Material.STAINED_GLASS_PANE, (byte)9), " ", new String[0]), new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuClickHandler() {

                final CropGrowthAccelerator this$0;

                public boolean onClick(Player arg0, int arg1, ItemStack arg2, ClickAction clickaction)
                {
                    return false;
                }

            
            {
                this$0 = CropGrowthAccelerator.this;
                super();
            }
            }
);
        }

    }

    public abstract int getEnergyConsumption();

    public abstract int getRadius();

    public abstract int getSpeed();

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

                final CropGrowthAccelerator this$0;

                public void tick(Block b, SlimefunItem sf, Config data)
                {
                    try
                    {
                        CropGrowthAccelerator.this.tick(b);
                    }
                    catch(Exception e)
                    {
                        e.printStackTrace();
                    }
                }

                public void uniqueTick()
                {
                }

                public boolean isSynchronized()
                {
                    return true;
                }

            
            {
                this$0 = CropGrowthAccelerator.this;
                super();
            }
            }

        });
        super.register(slimefun);
    }

    protected void tick(Block b)
        throws Exception
    {
        int work = 0;
label0:
        for(int x = -getRadius(); x <= getRadius(); x++)
        {
            for(int z = -getRadius(); z <= getRadius(); z++)
            {
                Block block = b.getRelative(x, 0, z);
                if(!crops.containsKey(block.getType()) || block.getData() >= ((Integer)crops.get(block.getType())).intValue())
                    continue;
                int ai1[];
                int l = (ai1 = getInputSlots()).length;
                for(int k = 0; k < l; k++)
                {
                    int slot = ai1[k];
                    if(!SlimefunManager.isItemSimiliar(BlockStorage.getInventory(b).getItemInSlot(slot), SlimefunItems.FERTILIZER, false))
                        continue;
                    if(work <= getSpeed() - 1 && ChargableBlock.getCharge(b) >= getEnergyConsumption())
                    {
                        ChargableBlock.addCharge(b, -getEnergyConsumption());
                        if(block.getType().equals(Material.COCOA))
                            block.setData((byte)(block.getData() + 4));
                        else
                            block.setData((byte)(block.getData() + 1));
                        ParticleEffect.VILLAGER_HAPPY.display(block.getLocation().add(0.5D, 0.5D, 0.5D), 0.1F, 0.1F, 0.1F, 0.0F, 4);
                        work++;
                        break;
                    }
                    break label0;
                }

            }

        }

        if(work > 0)
        {
            int ai[];
            int j = (ai = getInputSlots()).length;
            for(int i = 0; i < j; i++)
            {
                int slot = ai[i];
                if(!SlimefunManager.isItemSimiliar(BlockStorage.getInventory(b).getItemInSlot(slot), SlimefunItems.FERTILIZER, false))
                    continue;
                BlockStorage.getInventory(b).replaceExistingItem(slot, InvUtils.decreaseItem(BlockStorage.getInventory(b).getItemInSlot(slot), 1));
                break;
            }

        }
    }

    static 
    {
        crops = new HashMap();
        crops.put(Material.CROPS, Integer.valueOf(7));
        crops.put(Material.POTATO, Integer.valueOf(7));
        crops.put(Material.CARROT, Integer.valueOf(7));
        crops.put(Material.NETHER_WARTS, Integer.valueOf(3));
        crops.put(Material.BEETROOT_BLOCK, Integer.valueOf(3));
        crops.put(Material.COCOA, Integer.valueOf(8));
    }
}

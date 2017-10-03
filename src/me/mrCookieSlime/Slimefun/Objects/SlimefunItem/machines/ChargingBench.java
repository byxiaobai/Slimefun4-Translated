// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   ChargingBench.java

package me.mrCookieSlime.Slimefun.Objects.SlimefunItem.machines;

import me.mrCookieSlime.CSCoreLibPlugin.CSCoreLib;
import me.mrCookieSlime.CSCoreLibPlugin.protection.ProtectionManager;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems.AContainer;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import me.mrCookieSlime.Slimefun.api.energy.ChargableBlock;
import me.mrCookieSlime.Slimefun.api.energy.ItemEnergy;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenuPreset;
import me.mrCookieSlime.Slimefun.api.item_transport.ItemTransportFlow;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class ChargingBench extends AContainer
{

    public ChargingBench(Category category, ItemStack item, String name, RecipeType recipeType, ItemStack recipe[])
    {
        super(category, item, name, recipeType, recipe);
        new BlockMenuPreset(name, getInventoryTitle()) {

            final ChargingBench this$0;

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
                this$0 = ChargingBench.this;
                super($anonymous0, $anonymous1);
            }
        }
;
    }

    public String getInventoryTitle()
    {
        return "&3Charging Bench";
    }

    public ItemStack getProgressBar()
    {
        return new ItemStack(Material.GOLD_PICKAXE);
    }

    public int getEnergyConsumption()
    {
        return 10;
    }

    public void registerDefaultRecipes()
    {
    }

    protected void tick(Block b)
    {
        if(ChargableBlock.getCharge(b) < getEnergyConsumption())
            return;
        int ai[];
        int j = (ai = getInputSlots()).length;
        for(int i = 0; i < j; i++)
        {
            int slot = ai[i];
            ItemStack stack = BlockStorage.getInventory(b).getItemInSlot(slot);
            if(ItemEnergy.getMaxEnergy(stack) > 0.0F)
            {
                if(ItemEnergy.getStoredEnergy(stack) < ItemEnergy.getMaxEnergy(stack))
                {
                    ChargableBlock.addCharge(b, -getEnergyConsumption());
                    float rest = ItemEnergy.addStoredEnergy(stack, getEnergyConsumption() / 2);
                    if(rest > 0.0F)
                    {
                        if(fits(b, new ItemStack[] {
    stack
}))
                        {
                            pushItems(b, new ItemStack[] {
                                stack
                            });
                            BlockStorage.getInventory(b).replaceExistingItem(slot, null);
                        } else
                        {
                            BlockStorage.getInventory(b).replaceExistingItem(slot, stack);
                        }
                    } else
                    {
                        BlockStorage.getInventory(b).replaceExistingItem(slot, stack);
                    }
                } else
                if(fits(b, new ItemStack[] {
    stack
}))
                {
                    pushItems(b, new ItemStack[] {
                        stack
                    });
                    BlockStorage.getInventory(b).replaceExistingItem(slot, null);
                } else
                {
                    BlockStorage.getInventory(b).replaceExistingItem(slot, stack);
                }
                return;
            }
        }

    }

    public int getSpeed()
    {
        return 1;
    }

    public String getMachineIdentifier()
    {
        return "CHARGING_BENCH";
    }

}

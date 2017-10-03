// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   AutoAnvil.java

package me.mrCookieSlime.Slimefun.Objects.SlimefunItem.machines;

import java.util.*;
import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.InvUtils;
import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.Item.CustomItem;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Lists.SlimefunItems;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems.*;
import me.mrCookieSlime.Slimefun.Setup.SlimefunManager;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import me.mrCookieSlime.Slimefun.api.energy.ChargableBlock;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.material.MaterialData;

public abstract class AutoAnvil extends AContainer
{

    public AutoAnvil(Category category, ItemStack item, String name, RecipeType recipeType, ItemStack recipe[])
    {
        super(category, item, name, recipeType, recipe);
    }

    public String getInventoryTitle()
    {
        return "Auto-Anvil";
    }

    public ItemStack getProgressBar()
    {
        return new ItemStack(Material.IRON_PICKAXE);
    }

    public void registerDefaultRecipes()
    {
    }

    public int getSpeed()
    {
        return 1;
    }

    public String getMachineIdentifier()
    {
        return "AUTO_ANVIL";
    }

    public abstract int getRepairFactor();

    protected void tick(Block b)
    {
        if(isProcessing(b))
        {
            int timeleft = ((Integer)progress.get(b)).intValue();
            if(timeleft > 0)
            {
                ItemStack item = getProgressBar().clone();
                item.setDurability(MachineHelper.getDurability(item, timeleft, ((MachineRecipe)processing.get(b)).getTicks()));
                ItemMeta im = item.getItemMeta();
                im.setDisplayName(" ");
                List lore = new ArrayList();
                lore.add(MachineHelper.getProgress(timeleft, ((MachineRecipe)processing.get(b)).getTicks()));
                lore.add("");
                lore.add(MachineHelper.getTimeLeft(timeleft / 2));
                im.setLore(lore);
                item.setItemMeta(im);
                BlockStorage.getInventory(b).replaceExistingItem(22, item);
                if(ChargableBlock.isChargable(b))
                {
                    if(ChargableBlock.getCharge(b) < getEnergyConsumption())
                        return;
                    ChargableBlock.addCharge(b, -getEnergyConsumption());
                    progress.put(b, Integer.valueOf(timeleft - 1));
                } else
                {
                    progress.put(b, Integer.valueOf(timeleft - 1));
                }
            } else
            {
                BlockStorage.getInventory(b).replaceExistingItem(22, new CustomItem(new MaterialData(Material.STAINED_GLASS_PANE, (byte)15), " ", new String[0]));
                pushItems(b, ((MachineRecipe)processing.get(b)).getOutput());
                progress.remove(b);
                processing.remove(b);
            }
        } else
        {
            MachineRecipe r = null;
            int ai[];
            int k = (ai = getInputSlots()).length;
            for(int i = 0; i < k; i++)
            {
                int slot = ai[i];
                ItemStack target = BlockStorage.getInventory(b).getItemInSlot(slot != getInputSlots()[0] ? getInputSlots()[0] : getInputSlots()[1]);
                ItemStack item = BlockStorage.getInventory(b).getItemInSlot(slot);
                if(item == null || item.getType().getMaxDurability() <= 0 || item.getDurability() <= 0)
                    continue;
                if(SlimefunManager.isItemSimiliar(target, SlimefunItems.DUCT_TAPE, true))
                {
                    ItemStack newItem = item.clone();
                    short durability = (short)(newItem.getDurability() - item.getType().getMaxDurability() / getRepairFactor());
                    if(durability < 0)
                        durability = 0;
                    newItem.setDurability(durability);
                    r = new MachineRecipe(30, new ItemStack[] {
                        target, item
                    }, new ItemStack[] {
                        newItem
                    });
                }
                break;
            }

            if(r != null)
            {
                if(!fits(b, r.getOutput()))
                    return;
                int ai1[];
                int l = (ai1 = getInputSlots()).length;
                for(int j = 0; j < l; j++)
                {
                    int slot = ai1[j];
                    BlockStorage.getInventory(b).replaceExistingItem(slot, InvUtils.decreaseItem(BlockStorage.getInventory(b).getItemInSlot(slot), 1));
                }

                processing.put(b, r);
                progress.put(b, Integer.valueOf(r.getTicks()));
            }
        }
    }
}

// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   ElectricGoldPan.java

package me.mrCookieSlime.Slimefun.Objects.SlimefunItem.machines;

import java.util.*;
import me.mrCookieSlime.CSCoreLibPlugin.CSCoreLib;
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

public abstract class ElectricGoldPan extends AContainer
{

    public ElectricGoldPan(Category category, ItemStack item, String name, RecipeType recipeType, ItemStack recipe[])
    {
        super(category, item, name, recipeType, recipe);
    }

    public String getInventoryTitle()
    {
        return "&6Electric Gold Pan";
    }

    public ItemStack getProgressBar()
    {
        return new ItemStack(Material.DIAMOND_SPADE);
    }

    public void registerDefaultRecipes()
    {
    }

    public abstract int getSpeed();

    protected void tick(Block b)
    {
        if(isProcessing(b))
        {
            int timeleft = ((Integer)progress.get(b)).intValue();
            if(timeleft > 0 && getSpeed() < 10)
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
            if(ChargableBlock.isChargable(b))
            {
                if(ChargableBlock.getCharge(b) < getEnergyConsumption())
                    return;
                ChargableBlock.addCharge(b, -getEnergyConsumption());
                BlockStorage.getInventory(b).replaceExistingItem(22, new CustomItem(new MaterialData(Material.STAINED_GLASS_PANE, (byte)15), " ", new String[0]));
                pushItems(b, ((MachineRecipe)processing.get(b)).getOutput());
                progress.remove(b);
                processing.remove(b);
            }
        } else
        {
            int ai[];
            int j = (ai = getInputSlots()).length;
            for(int i = 0; i < j; i++)
            {
                int slot = ai[i];
                if(!SlimefunManager.isItemSimiliar(BlockStorage.getInventory(b).getItemInSlot(slot), new ItemStack(Material.GRAVEL), true))
                    continue;
                ItemStack output = SlimefunItems.SIFTED_ORE;
                if(CSCoreLib.randomizer().nextInt(100) < 16)
                    output = new ItemStack(Material.FLINT);
                if(CSCoreLib.randomizer().nextInt(100) < 16)
                    output = new ItemStack(Material.CLAY_BALL);
                MachineRecipe r = new MachineRecipe(3 / getSpeed(), new ItemStack[0], new ItemStack[] {
                    output
                });
                if(!fits(b, r.getOutput()))
                    return;
                BlockStorage.getInventory(b).replaceExistingItem(slot, InvUtils.decreaseItem(BlockStorage.getInventory(b).getItemInSlot(slot), 1));
                processing.put(b, r);
                progress.put(b, Integer.valueOf(r.getTicks()));
                break;
            }

        }
    }

    public String getMachineIdentifier()
    {
        return "ELECTRIC_GOLD_PAN";
    }
}

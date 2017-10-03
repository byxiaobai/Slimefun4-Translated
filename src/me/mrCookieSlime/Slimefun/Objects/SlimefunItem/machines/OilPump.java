// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   OilPump.java

package me.mrCookieSlime.Slimefun.Objects.SlimefunItem.machines;

import java.util.*;
import me.mrCookieSlime.CSCoreLibPlugin.CSCoreLib;
import me.mrCookieSlime.CSCoreLibPlugin.Configuration.Localization;
import me.mrCookieSlime.CSCoreLibPlugin.Configuration.Variable;
import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.InvUtils;
import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.Item.CustomItem;
import me.mrCookieSlime.CSCoreLibPlugin.protection.ProtectionManager;
import me.mrCookieSlime.Slimefun.GEO.OreGenSystem;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Lists.SlimefunItems;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems.*;
import me.mrCookieSlime.Slimefun.Setup.Messages;
import me.mrCookieSlime.Slimefun.Setup.SlimefunManager;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import me.mrCookieSlime.Slimefun.api.energy.ChargableBlock;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenuPreset;
import me.mrCookieSlime.Slimefun.api.item_transport.ItemTransportFlow;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.material.MaterialData;

public abstract class OilPump extends AContainer
{

    public OilPump(Category category, ItemStack item, String name, RecipeType recipeType, ItemStack recipe[])
    {
        super(category, item, name, recipeType, recipe);
        new BlockMenuPreset(name, getInventoryTitle()) {

            final OilPump this$0;

            public void init()
            {
                constructMenu(this);
            }

            public void newInstance(BlockMenu blockmenu, Block block)
            {
            }

            public boolean canOpen(Block b, Player p)
            {
                if(!p.hasPermission("slimefun.inventory.bypass") && !CSCoreLib.getLib().getProtectionManager().canAccessChest(p.getUniqueId(), b, true))
                    return false;
                if(!OreGenSystem.wasResourceGenerated(OreGenSystem.getResource("Oil"), b.getChunk()))
                {
                    Messages.local.sendTranslation(p, "gps.geo.scan-required", true, new Variable[0]);
                    return false;
                } else
                {
                    return true;
                }
            }

            public int[] getSlotsAccessedByItemTransport(ItemTransportFlow flow)
            {
                if(flow.equals(ItemTransportFlow.INSERT))
                    return getInputSlots();
                else
                    return getOutputSlots();
            }

            
            {
                this$0 = OilPump.this;
                super($anonymous0, $anonymous1);
            }
        }
;
    }

    public String getMachineIdentifier()
    {
        return "OIL_PUMP";
    }

    public String getInventoryTitle()
    {
        return "&4Oil Pump";
    }

    public ItemStack getProgressBar()
    {
        return new ItemStack(Material.DIAMOND_SPADE);
    }

    public void registerDefaultRecipes()
    {
    }

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
                if(ChargableBlock.getCharge(b) < getEnergyConsumption())
                    return;
                ChargableBlock.addCharge(b, -getEnergyConsumption());
                progress.put(b, Integer.valueOf(timeleft - 1));
            } else
            {
                BlockStorage.getInventory(b).replaceExistingItem(22, new CustomItem(new MaterialData(Material.STAINED_GLASS_PANE, (byte)15), " ", new String[0]));
                pushItems(b, ((MachineRecipe)processing.get(b)).getOutput());
                progress.remove(b);
                processing.remove(b);
            }
        } else
        if(OreGenSystem.getSupplies(OreGenSystem.getResource("Oil"), b.getChunk(), false) > 0)
        {
            int ai[];
            int j = (ai = getInputSlots()).length;
            for(int i = 0; i < j; i++)
            {
                int slot = ai[i];
                if(!SlimefunManager.isItemSimiliar(BlockStorage.getInventory(b).getItemInSlot(slot), new ItemStack(Material.BUCKET), true))
                    continue;
                MachineRecipe r = new MachineRecipe(26, new ItemStack[0], new ItemStack[] {
                    SlimefunItems.BUCKET_OF_OIL
                });
                if(!fits(b, r.getOutput()))
                    return;
                BlockStorage.getInventory(b).replaceExistingItem(slot, InvUtils.decreaseItem(BlockStorage.getInventory(b).getItemInSlot(slot), 1));
                processing.put(b, r);
                progress.put(b, Integer.valueOf(r.getTicks()));
                OreGenSystem.setSupplies(OreGenSystem.getResource("Oil"), b.getChunk(), OreGenSystem.getSupplies(OreGenSystem.getResource("Oil"), b.getChunk(), false) - 1);
                break;
            }

        }
    }

}
